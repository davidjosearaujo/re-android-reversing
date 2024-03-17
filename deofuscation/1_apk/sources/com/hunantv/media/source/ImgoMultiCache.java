package com.hunantv.media.source;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.player.utils.ThreadUtil;
import com.hunantv.media.source.CacheTask;
import com.hunantv.media.source.IImgoCache;
import com.hunantv.media.source.jni.ImgoSourceNative;
import com.hunantv.media.utils.FileUtil;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoMultiCache implements IImgoMultiCache {
    private static final int CONNECT_TIMEOUT_MS = 3000;
    public static final int NULL = 0;
    private static final int REQUEST_TIMEOUT_MS = 5000;
    public static final String TAG = "ImgoCache";
    private static final String USER_AGENT = "ImgoDataSource";
    private String mCachePath;
    private ImgoSourceNative.Callback mCallback;
    private ImgoSourceNative.InitParams mInitParams;
    private Object mLock;
    public long mManagerAddress;
    private Looper mMyLooper;
    private List<CacheTask> mStartTasks;
    private IImgoCache.TaskCallback mTaskCallback;

    public ImgoMultiCache(Context context, String str) {
        this(context, str, null);
    }

    public ImgoMultiCache(Context context, String str, ImgoSourceNative.InitParams initParams) {
        this.mLock = new Object();
        this.mStartTasks = Collections.synchronizedList(new LinkedList());
        this.mCallback = new ImgoSourceNative.Callback() { // from class: com.hunantv.media.source.ImgoMultiCache.1
            @Override // com.hunantv.media.source.jni.ImgoSourceNative.Callback
            public void onError(final ImgoSourceNative.CbErrorParams cbErrorParams) {
                if (cbErrorParams == null) {
                    ImgoCacheLogger.e(ImgoMultiCache.this.TAG(), "onError params null");
                    return;
                }
                String TAG2 = ImgoMultiCache.this.TAG();
                ImgoCacheLogger.e(TAG2, "onError taskid:" + cbErrorParams.taskid + ",error_code:" + cbErrorParams.error_code + ",detail_code:" + cbErrorParams.detail_code);
                if (ImgoMultiCache.this.mMyLooper != null) {
                    ThreadUtil.runOnTargetLooper(ImgoMultiCache.this.mMyLooper, new Runnable() { // from class: com.hunantv.media.source.ImgoMultiCache.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ImgoMultiCache.this.notifyTaskError(cbErrorParams);
                        }
                    });
                } else {
                    ThreadUtil.runOnUiThread(new Runnable() { // from class: com.hunantv.media.source.ImgoMultiCache.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ImgoMultiCache.this.notifyTaskError(cbErrorParams);
                        }
                    });
                }
            }

            @Override // com.hunantv.media.source.jni.ImgoSourceNative.Callback
            public void onResult(final int i, final ImgoSourceNative.CbResultParams cbResultParams) {
                if (cbResultParams != null) {
                    ImgoCacheLogger.d(ImgoMultiCache.this.TAG(), "native_resultcallback result:" + i + ",taskid:" + cbResultParams.taskid + ",fullpath:" + cbResultParams.fullpath + ",type" + cbResultParams.type);
                    String[] strArr = cbResultParams.ts_names;
                    if (strArr != null && strArr.length > 0) {
                        for (String str2 : strArr) {
                            ImgoCacheLogger.i(ImgoMultiCache.this.TAG(), "native_callback ts_name:" + str2);
                        }
                    }
                }
                if (i == 0) {
                    if (ImgoMultiCache.this.mMyLooper != null) {
                        ThreadUtil.runOnTargetLooper(ImgoMultiCache.this.mMyLooper, new Runnable() { // from class: com.hunantv.media.source.ImgoMultiCache.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ImgoMultiCache.this.notifyTaskResult(i, cbResultParams);
                            }
                        });
                    } else {
                        ThreadUtil.runOnUiThread(new Runnable() { // from class: com.hunantv.media.source.ImgoMultiCache.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ImgoMultiCache.this.notifyTaskResult(i, cbResultParams);
                            }
                        });
                    }
                }
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
        this.mMyLooper = Looper.myLooper();
        create();
    }

    private CacheTask findTask(String str) {
        for (CacheTask cacheTask : this.mStartTasks) {
            if (str.equals(cacheTask.getTaskID())) {
                return cacheTask;
            }
        }
        return null;
    }

    private boolean isStartTaskEmpty() {
        List<CacheTask> list = this.mStartTasks;
        return list == null || list.isEmpty();
    }

    private boolean isStartingTask(CacheTask cacheTask) {
        if (cacheTask == null || isStartTaskEmpty()) {
            return false;
        }
        return isStartingTask(cacheTask.getTaskID());
    }

    private boolean isStartingTask(String str) {
        return (isStartTaskEmpty() || StringUtil.isEmpty(str) || findTask(str) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyTaskError(ImgoSourceNative.CbErrorParams cbErrorParams) {
        ImgoCacheLogger.d(TAG(), "notifyTaskError");
        synchronized (this.mLock) {
            ImgoCacheLogger.d(TAG(), "notifyTaskError in");
            if (cbErrorParams != null && isStartingTask(cbErrorParams.taskid)) {
                CacheTask findTask = findTask(cbErrorParams.taskid);
                String TAG2 = TAG();
                ImgoCacheLogger.i(TAG2, "notifyTaskError findTask " + findTask);
                if (findTask != null) {
                    this.mStartTasks.remove(findTask);
                    findTask.setErrorCode(cbErrorParams.error_code);
                    findTask.setDetailCode(cbErrorParams.detail_code);
                    ImgoCacheLogger.i(TAG(), "notifyTaskError FAILED IN");
                    findTask.setTempPath(null);
                    findTask.setCurrentStatus(CacheTask.Status.FAILED);
                    callOnFailed(findTask);
                    ImgoCacheLogger.i(TAG(), "notifyTaskError FAILED OUT");
                    ImgoCacheLogger.i(TAG(), "notifyTaskError FINISH IN");
                    callOnFinish(findTask);
                    ImgoCacheLogger.i(TAG(), "notifyTaskError FINISH OUT");
                }
            }
            ImgoCacheLogger.d(TAG(), "notifyTaskError out");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyTaskResult(int i, ImgoSourceNative.CbResultParams cbResultParams) {
        ImgoCacheLogger.d(TAG(), "notifyTaskResult");
        synchronized (this.mLock) {
            ImgoCacheLogger.d(TAG(), "notifyTaskResult in");
            if (cbResultParams != null && isStartingTask(cbResultParams.taskid)) {
                onTaskResult(findTask(cbResultParams.taskid), i, cbResultParams);
            }
            ImgoCacheLogger.d(TAG(), "notifyTaskResult out");
        }
    }

    public String TAG() {
        return "ImgoCache[" + hashCode() + "]";
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void cache(CacheTask cacheTask) {
        cache(cacheTask, false);
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void cache(CacheTask cacheTask, boolean z) {
        synchronized (this.mLock) {
            if (this.mManagerAddress != 0 && cacheTask != null && cacheTask.getVid() != null && cacheTask.getUrl() != null && !isStartingTask(cacheTask)) {
                if (cacheTask.isStart()) {
                    String TAG2 = TAG();
                    ImgoCacheLogger.i(TAG2, "cache in started cache taskid:" + cacheTask.getTaskID());
                    return;
                }
                String TAG3 = TAG();
                ImgoCacheLogger.i(TAG3, "cache in vid:" + cacheTask.getVid() + ",streamid:" + cacheTask.getStreamId());
                startCache(cacheTask);
                this.mStartTasks.add(cacheTask);
                callOnStart(cacheTask);
                String TAG4 = TAG();
                ImgoCacheLogger.i(TAG4, "cache out force:" + z);
            }
        }
    }

    public void callOnFailed(CacheTask cacheTask) {
        IImgoCache.TaskCallback taskCallback = this.mTaskCallback;
        if (taskCallback != null) {
            taskCallback.onFailed(cacheTask);
        }
    }

    public void callOnFinish(CacheTask cacheTask) {
        IImgoCache.TaskCallback taskCallback = this.mTaskCallback;
        if (taskCallback != null) {
            taskCallback.onFinish(cacheTask);
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
        synchronized (this.mLock) {
            if (this.mManagerAddress != 0 && cacheTask != null) {
                String TAG2 = TAG();
                ImgoCacheLogger.i(TAG2, "cancel in taskid:" + cacheTask.getTaskID() + " vid:" + cacheTask.getVid() + ",streamid:" + cacheTask.getStreamId());
                cacheTask.setCurrentStatus(CacheTask.Status.NONE);
                cacheTask.setTempPath(null);
                ImgoSourceNative.cancelCache(this.mManagerAddress, cacheTask.getTaskID());
                this.mStartTasks.remove(cacheTask);
                ImgoCacheLogger.i(TAG(), "cancel out");
            }
        }
    }

    public void create() {
        release();
        ImgoCacheLogger.i(TAG(), "create in");
        long newCacheManager = ImgoSourceNative.newCacheManager(this.mCachePath, this.mInitParams);
        this.mManagerAddress = newCacheManager;
        ImgoSourceNative.setMaxTask(newCacheManager, this.mInitParams.max_task_num);
        ImgoSourceNative.subscribeCallback(this.mCallback);
        ImgoCacheLogger.i(TAG(), "create out");
    }

    @Override // com.hunantv.media.source.IImgoCache
    public IImgoCache.ExtraInfo getExtraInfo() {
        return new IImgoCache.ExtraInfo(this.mManagerAddress);
    }

    public void onTaskResult(CacheTask cacheTask, int i, ImgoSourceNative.CbResultParams cbResultParams) {
        String TAG2;
        String str;
        String TAG3 = TAG();
        ImgoCacheLogger.i(TAG3, "onResult findTask " + cacheTask);
        if (cacheTask != null) {
            this.mStartTasks.remove(cacheTask);
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
            ImgoCacheLogger.i(TAG(), "onResult FINISH IN");
            callOnFinish(cacheTask);
            ImgoCacheLogger.i(TAG(), "onResult FINISH OUT");
        }
    }

    @Override // com.hunantv.media.source.IImgoMultiCache
    public void pause(CacheTask cacheTask) {
        synchronized (this.mLock) {
            if (this.mManagerAddress != 0 && cacheTask != null && !StringUtil.isEmpty(cacheTask.getTaskID())) {
                String TAG2 = TAG();
                ImgoCacheLogger.i(TAG2, "pause in taskid:" + cacheTask.getTaskID() + " vid:" + cacheTask.getVid() + ",streamid:" + cacheTask.getStreamId());
                cacheTask.setCurrentStatus(CacheTask.Status.PAUSE);
                ImgoSourceNative.pauseCache(this.mManagerAddress, cacheTask.getTaskID());
                ImgoCacheLogger.i(TAG(), "pause out");
            }
        }
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void release() {
        if (this.mManagerAddress == 0) {
            return;
        }
        ImgoCacheLogger.i(TAG(), "release in");
        ImgoSourceNative.removeCallback(this.mCallback);
        ImgoSourceNative.freeCacheManager(this.mManagerAddress);
        this.mManagerAddress = 0L;
        ImgoCacheLogger.i(TAG(), "release out");
    }

    @Override // com.hunantv.media.source.IImgoMultiCache
    public void resume(CacheTask cacheTask) {
        synchronized (this.mLock) {
            if (this.mManagerAddress != 0 && cacheTask != null && !StringUtil.isEmpty(cacheTask.getTaskID())) {
                String TAG2 = TAG();
                ImgoCacheLogger.i(TAG2, "resume in taskid:" + cacheTask.getTaskID() + " vid:" + cacheTask.getVid() + ",streamid:" + cacheTask.getStreamId());
                cacheTask.setCurrentStatus(CacheTask.Status.START);
                ImgoSourceNative.resumeCache(this.mManagerAddress, cacheTask.getTaskID());
                ImgoCacheLogger.i(TAG(), "resume out");
            }
        }
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void setTaskCallback(IImgoCache.TaskCallback taskCallback) {
        this.mTaskCallback = taskCallback;
    }

    public void startCache(CacheTask cacheTask) {
        String TAG2 = TAG();
        ImgoCacheLogger.i(TAG2, "startCache vid:" + cacheTask.getVid() + ",StreamId" + cacheTask.getStreamId());
        ImgoSourceNative.CbStartParams startCache = ImgoSourceNative.startCache(this.mManagerAddress, cacheTask.getUrl(), cacheTask.getVid(), cacheTask.getStreamId(), cacheTask.getStartTimeMs(), cacheTask.getTsNum(), cacheTask.getWriteM3u8());
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
