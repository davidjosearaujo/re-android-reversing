package com.hunantv.media.source;

import android.content.Context;
import androidx.annotation.NonNull;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.player.utils.ThreadUtil;
import com.hunantv.media.source.CacheTask;
import com.hunantv.media.source.IImgoCache;
import com.hunantv.media.source.jni.ImgoSourceNative;
import com.hunantv.media.utils.FileUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoQueueCache implements IImgoQueueCache {
    private static final int CONNECT_TIMEOUT_MS = 3000;
    private static final int MAX_RUNNING_SIZE = 1;
    private static final int NULL = 0;
    private static final int REQUEST_TIMEOUT_MS = 5000;
    public static final String TAG = "ImgoQueueCache";
    private static final String USER_AGENT = "ImgoDataSource";
    private String mCachePath;
    private ImgoSourceNative.Callback mCallback;
    private ImgoSourceNative.InitParams mInitParams;
    public long mManagerAddress;
    private Queue<CacheTask> mPrepareTasks;
    private List<CacheTask> mRunningTasks;
    private Object mSyncLock;
    private IImgoCache.TaskCallback mTaskCallback;

    public ImgoQueueCache(Context context, String str) {
        this(context, str, null);
    }

    public ImgoQueueCache(Context context, String str, ImgoSourceNative.InitParams initParams) {
        this.mPrepareTasks = new LinkedList();
        this.mRunningTasks = new LinkedList();
        this.mSyncLock = new Object();
        this.mCallback = new ImgoSourceNative.Callback() { // from class: com.hunantv.media.source.ImgoQueueCache.1
            /* JADX INFO: Access modifiers changed from: private */
            public CacheTask findTask(List<CacheTask> list, String str2) {
                if (list != null && str2 != null) {
                    for (CacheTask cacheTask : list) {
                        if (cacheTask != null && str2.equals(cacheTask.getTaskID())) {
                            return cacheTask;
                        }
                    }
                }
                return null;
            }

            @Override // com.hunantv.media.source.jni.ImgoSourceNative.Callback
            public void onError(ImgoSourceNative.CbErrorParams cbErrorParams) {
            }

            @Override // com.hunantv.media.source.jni.ImgoSourceNative.Callback
            public void onResult(final int i, final ImgoSourceNative.CbResultParams cbResultParams) {
                ImgoCacheLogger.d(ImgoQueueCache.this.TAG(), "onResult IN");
                if (cbResultParams != null) {
                    ImgoCacheLogger.i(ImgoQueueCache.this.TAG(), "native_resultcallback result:" + i + ",taskid:" + cbResultParams.taskid + ",fullpath:" + cbResultParams.fullpath + ",type" + cbResultParams.type);
                    String[] strArr = cbResultParams.ts_names;
                    if (strArr != null && strArr.length > 0) {
                        for (String str2 : strArr) {
                            ImgoCacheLogger.i(ImgoQueueCache.this.TAG(), "native_callback ts_name:" + str2);
                        }
                    }
                }
                ThreadUtil.runOnUiThread(new Runnable() { // from class: com.hunantv.media.source.ImgoQueueCache.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CacheTask cacheTask;
                        ImgoCacheLogger.d(ImgoQueueCache.this.TAG(), "onResult attach to UI thread");
                        if (cbResultParams != null) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            cacheTask = anonymousClass1.findTask(ImgoQueueCache.this.mRunningTasks, cbResultParams.taskid);
                            ImgoQueueCache.this.onTaskResult(cacheTask, i, cbResultParams);
                        } else {
                            cacheTask = null;
                        }
                        if (cacheTask == null || !cacheTask.isSuccess()) {
                            return;
                        }
                        ImgoQueueCache imgoQueueCache = ImgoQueueCache.this;
                        imgoQueueCache.cache((CacheTask) imgoQueueCache.mPrepareTasks.poll(), true);
                    }
                });
                ImgoCacheLogger.d(ImgoQueueCache.this.TAG(), "onResult OUT");
            }
        };
        if (!ImgoCacheLibLoader.loadLibs(context) || StringUtil.isEmpty(str)) {
            return;
        }
        this.mCachePath = str;
        FileUtil.mkdirs(str);
        if (initParams != null) {
            this.mInitParams = initParams;
        } else {
            ImgoSourceNative.InitParams initParams2 = new ImgoSourceNative.InitParams();
            this.mInitParams = initParams2;
            initParams2.useragent = USER_AGENT;
            initParams2.connect_timeout_ms = CONNECT_TIMEOUT_MS;
            initParams2.request_timeout_ms = 5000;
        }
        create();
    }

    private void cancelImpl(CacheTask cacheTask) {
        if (this.mManagerAddress == 0 || cacheTask == null) {
            return;
        }
        String TAG2 = TAG();
        ImgoCacheLogger.i(TAG2, "cancel in vid:" + cacheTask.getVid() + ",streamid:" + cacheTask.getStreamId());
        cacheTask.setCurrentStatus(CacheTask.Status.NONE);
        cacheTask.setTempPath(null);
        if (this.mRunningTasks.contains(cacheTask)) {
            ImgoCacheLogger.i(TAG(), "cancel from mRunningTasks");
            this.mRunningTasks.remove(cacheTask);
        }
        if (this.mPrepareTasks.contains(cacheTask)) {
            ImgoCacheLogger.i(TAG(), "cancel from mPrepareTasks");
            this.mPrepareTasks.remove(cacheTask);
        }
        ImgoSourceNative.cancelCache(this.mManagerAddress, cacheTask.getTaskID());
        ImgoCacheLogger.i(TAG(), "cancel out");
    }

    private void moveToRunningTasks(CacheTask cacheTask) {
        if (cacheTask == null || this.mRunningTasks.contains(cacheTask)) {
            return;
        }
        if (this.mPrepareTasks.contains(cacheTask)) {
            this.mPrepareTasks.remove(cacheTask);
        }
        String TAG2 = TAG();
        ImgoCacheLogger.i(TAG2, "moveToRunningTasks vid:" + cacheTask.getVid() + ",StreamId" + cacheTask.getStreamId());
        startCache(cacheTask);
        this.mRunningTasks.add(cacheTask);
        callOnStart(cacheTask);
    }

    public String TAG() {
        return "ImgoQueueCache[" + hashCode() + "]";
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void cache(CacheTask cacheTask) {
        cache(cacheTask, false);
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void cache(CacheTask cacheTask, boolean z) {
        synchronized (this.mSyncLock) {
            if (this.mManagerAddress != 0 && cacheTask != null && cacheTask.getVid() != null && cacheTask.getUrl() != null) {
                String TAG2 = TAG();
                ImgoCacheLogger.i(TAG2, "cache in vid:" + cacheTask.getVid() + ",streamid:" + cacheTask.getStreamId());
                if (z) {
                    if (this.mRunningTasks.size() > 0) {
                        String TAG3 = TAG();
                        ImgoCacheLogger.i(TAG3, "force cache vid:" + cacheTask.getVid() + ",StreamId" + cacheTask.getStreamId());
                        CacheTask cacheTask2 = this.mRunningTasks.get(0);
                        if (cacheTask2 != cacheTask) {
                            cancelImpl(cacheTask2);
                            if (!this.mPrepareTasks.contains(cacheTask2)) {
                                String TAG4 = TAG();
                                ImgoCacheLogger.i(TAG4, "add RunningTask to mPrepareTasks vid:" + cacheTask2.getVid());
                                this.mPrepareTasks.add(cacheTask2);
                            }
                        }
                    }
                } else if (this.mRunningTasks.size() >= 1) {
                    String TAG5 = TAG();
                    ImgoCacheLogger.i(TAG5, "add to mPrepareTasks vid:" + cacheTask.getVid());
                    if (!this.mPrepareTasks.contains(cacheTask)) {
                        this.mPrepareTasks.add(cacheTask);
                    }
                    String TAG6 = TAG();
                    ImgoCacheLogger.i(TAG6, "cache out force:" + z);
                }
                moveToRunningTasks(cacheTask);
                String TAG62 = TAG();
                ImgoCacheLogger.i(TAG62, "cache out force:" + z);
            }
        }
    }

    public void callOnFailed(CacheTask cacheTask) {
        IImgoCache.TaskCallback taskCallback = this.mTaskCallback;
        if (taskCallback != null) {
            taskCallback.onFailed(cacheTask);
        }
    }

    public void callOnStart(CacheTask cacheTask) {
        IImgoCache.TaskCallback taskCallback = this.mTaskCallback;
        if (taskCallback != null) {
            taskCallback.onStart(cacheTask);
        }
    }

    public void callOnSuccess(CacheTask cacheTask) {
        IImgoCache.TaskCallback taskCallback = this.mTaskCallback;
        if (taskCallback != null) {
            taskCallback.onSuccess(cacheTask);
        }
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void cancel(CacheTask cacheTask) {
        synchronized (this.mSyncLock) {
            cancelImpl(cacheTask);
        }
    }

    public void create() {
        release();
        synchronized (this.mSyncLock) {
            ImgoCacheLogger.i(TAG(), "create in");
            long newCacheManager = ImgoSourceNative.newCacheManager(this.mCachePath, this.mInitParams);
            this.mManagerAddress = newCacheManager;
            ImgoSourceNative.setMaxTask(newCacheManager, 1);
            ImgoSourceNative.subscribeCallback(this.mCallback);
            ImgoCacheLogger.i(TAG(), "create out");
        }
    }

    @Override // com.hunantv.media.source.IImgoCache
    public IImgoCache.ExtraInfo getExtraInfo() {
        return new IImgoCache.ExtraInfo(this.mManagerAddress);
    }

    @Override // com.hunantv.media.source.IImgoQueueCache
    public Queue<CacheTask> getPrepareQueue() {
        return this.mPrepareTasks;
    }

    @Override // com.hunantv.media.source.IImgoQueueCache
    public List<CacheTask> getRunningList() {
        return this.mRunningTasks;
    }

    public void onTaskResult(CacheTask cacheTask, int i, ImgoSourceNative.CbResultParams cbResultParams) {
        String TAG2;
        String str;
        String TAG3 = TAG();
        ImgoCacheLogger.i(TAG3, "onResult findTask " + cacheTask);
        if (cacheTask != null) {
            this.mRunningTasks.remove(cacheTask);
            if (cbResultParams != null) {
                updateParamsOnResult(cacheTask, cbResultParams);
            }
            if (i == 0) {
                ImgoCacheLogger.i(TAG(), "onResult OK IN");
                cacheTask.setCurrentStatus(CacheTask.Status.SUCCESS);
                callOnSuccess(cacheTask);
                TAG2 = TAG();
                str = "onResult OK OUT";
            } else {
                ImgoCacheLogger.i(TAG(), "onResult FAILED IN");
                cacheTask.setTempPath(null);
                cacheTask.setCurrentStatus(CacheTask.Status.FAILED);
                callOnFailed(cacheTask);
                TAG2 = TAG();
                str = "onResult FAILED OUT";
            }
            ImgoCacheLogger.i(TAG2, str);
        }
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void release() {
        synchronized (this.mSyncLock) {
            if (this.mManagerAddress == 0) {
                return;
            }
            ImgoCacheLogger.i(TAG(), "release in");
            ImgoSourceNative.removeCallback(this.mCallback);
            ImgoSourceNative.freeCacheManager(this.mManagerAddress);
            this.mManagerAddress = 0L;
            Queue<CacheTask> queue = this.mPrepareTasks;
            if (queue != null) {
                queue.clear();
            }
            List<CacheTask> list = this.mRunningTasks;
            if (list != null) {
                list.clear();
            }
            ImgoCacheLogger.i(TAG(), "release out");
        }
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void setTaskCallback(IImgoCache.TaskCallback taskCallback) {
        this.mTaskCallback = taskCallback;
    }

    public void startCache(CacheTask cacheTask) {
        String TAG2 = TAG();
        ImgoCacheLogger.i(TAG2, "startCache vid:" + cacheTask.getVid() + ",StreamId" + cacheTask.getStreamId());
        ImgoSourceNative.CbStartParams startCache = ImgoSourceNative.startCache(this.mManagerAddress, cacheTask.getUrl(), cacheTask.getVid(), cacheTask.getStreamId(), 0, 0, cacheTask.getWriteM3u8());
        if (startCache != null) {
            updateParamsOnStart(cacheTask, startCache);
        }
        ImgoCacheLogger.i(TAG(), "startCache end");
    }

    public void updateParamsOnResult(@NonNull CacheTask cacheTask, @NonNull ImgoSourceNative.CbResultParams cbResultParams) {
        cacheTask.setFullPath(cbResultParams.fullpath);
        cacheTask.setFileName(cbResultParams.file_name);
        cacheTask.setType(cbResultParams.type);
        cacheTask.setTsNames(cbResultParams.ts_names);
    }

    public void updateParamsOnStart(@NonNull CacheTask cacheTask, @NonNull ImgoSourceNative.CbStartParams cbStartParams) {
        cacheTask.setTempPath(cbStartParams.filepath);
        cacheTask.setCurrentStatus(CacheTask.Status.START);
        cacheTask.setTaskID(cbStartParams.taskid);
    }
}
