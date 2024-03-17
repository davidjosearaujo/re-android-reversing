package com.hunantv.media.source;

import android.content.Context;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.player.utils.ThreadUtil;
import com.hunantv.media.player.utils.UrlUtil;
import com.hunantv.media.source.M3u8CacheTask;
import com.hunantv.media.source.jni.ImgoSourceNative;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Deprecated
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoM3u8Cache {
    private static final int CONNECT_TIMEOUT = 10;
    private static final int MAX_RUNNING_SIZE = 1;
    private static final int NULL = 0;
    private static final int REQUEST_TIMEOUT = 30;
    private static final String TAG = "ImgoM3u8Cache";
    private static final String USER_AGENT = "ImgoDataSource";
    private String mCachePath;
    private ImgoSourceNative.Callback mCallback;
    private ImgoSourceNative.InitParams mInitParams;
    private long mManagerAddress;
    private Queue<M3u8CacheTask> mPrepareTasks;
    private List<M3u8CacheTask> mRunningTasks;
    private TaskCallback mTaskCallback;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface TaskCallback {
        void onFailed(M3u8CacheTask m3u8CacheTask);

        void onStart(M3u8CacheTask m3u8CacheTask);

        void onSuccess(M3u8CacheTask m3u8CacheTask);
    }

    public ImgoM3u8Cache(Context context, String str) {
        this(context, str, null);
    }

    public ImgoM3u8Cache(Context context, String str, ImgoSourceNative.InitParams initParams) {
        this.mPrepareTasks = new LinkedList();
        this.mRunningTasks = new LinkedList();
        this.mCallback = new ImgoSourceNative.Callback() { // from class: com.hunantv.media.source.ImgoM3u8Cache.1
            /* JADX INFO: Access modifiers changed from: private */
            public M3u8CacheTask findTask(List<M3u8CacheTask> list, String str2) {
                if (list != null && !StringUtil.isEmpty(str2)) {
                    for (M3u8CacheTask m3u8CacheTask : list) {
                        if (m3u8CacheTask != null && str2.equals(m3u8CacheTask.mTaskID)) {
                            return m3u8CacheTask;
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
                if (cbResultParams != null) {
                    ImgoCacheLogger.i(ImgoM3u8Cache.TAG, "native_callback result:" + i + ",taskid:" + cbResultParams.taskid + ",fullpath:" + cbResultParams.fullpath);
                    String[] strArr = cbResultParams.ts_names;
                    if (strArr != null && strArr.length > 0) {
                        for (String str2 : strArr) {
                            ImgoCacheLogger.i(ImgoM3u8Cache.TAG, "native_callback ts_name:" + str2);
                        }
                    }
                }
                ThreadUtil.runOnUiThread(new Runnable() { // from class: com.hunantv.media.source.ImgoM3u8Cache.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cbResultParams != null) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            M3u8CacheTask findTask = anonymousClass1.findTask(ImgoM3u8Cache.this.mRunningTasks, cbResultParams.taskid);
                            ImgoCacheLogger.i(ImgoM3u8Cache.TAG, "onResult findTask " + findTask);
                            if (findTask != null) {
                                ImgoM3u8Cache.this.mRunningTasks.remove(findTask);
                                findTask.setFullPath(cbResultParams.fullpath);
                                findTask.setTsNames(cbResultParams.ts_names);
                                if (i == 0) {
                                    ImgoCacheLogger.i(ImgoM3u8Cache.TAG, "onResult OK");
                                    findTask.setCurrentStatus(M3u8CacheTask.Status.SUCCESS);
                                    if (ImgoM3u8Cache.this.mTaskCallback != null) {
                                        ImgoM3u8Cache.this.mTaskCallback.onSuccess(findTask);
                                    }
                                } else {
                                    ImgoCacheLogger.i(ImgoM3u8Cache.TAG, "onResult FAILED");
                                    findTask.setCurrentStatus(M3u8CacheTask.Status.FAILED);
                                    if (ImgoM3u8Cache.this.mTaskCallback != null) {
                                        ImgoM3u8Cache.this.mTaskCallback.onFailed(findTask);
                                    }
                                }
                            }
                        }
                        ImgoM3u8Cache imgoM3u8Cache = ImgoM3u8Cache.this;
                        imgoM3u8Cache.moveToRunningTasks((M3u8CacheTask) imgoM3u8Cache.mPrepareTasks.poll());
                    }
                });
            }
        };
        if (!loadLibs(context) || StringUtil.isEmpty(str)) {
            return;
        }
        this.mCachePath = str;
        if (initParams != null) {
            this.mInitParams = initParams;
        } else {
            ImgoSourceNative.InitParams initParams2 = new ImgoSourceNative.InitParams();
            this.mInitParams = initParams2;
            initParams2.useragent = USER_AGENT;
            initParams2.connect_timeout_ms = 10;
            initParams2.request_timeout_ms = 30;
        }
        create();
    }

    private void create() {
        release();
        ImgoCacheLogger.i(TAG, "create in");
        this.mManagerAddress = ImgoSourceNative.newCacheManager(this.mCachePath, this.mInitParams);
        ImgoSourceNative.subscribeCallback(this.mCallback);
        ImgoCacheLogger.i(TAG, "create out");
    }

    private boolean loadLibs(Context context) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToRunningTasks(M3u8CacheTask m3u8CacheTask) {
        if (m3u8CacheTask == null) {
            return;
        }
        ImgoCacheLogger.i(TAG, "moveToRunningTasks vid:" + m3u8CacheTask.getVid() + ",StreamId" + m3u8CacheTask.getStreamId());
        ImgoSourceNative.startCache(this.mManagerAddress, m3u8CacheTask.getUrl(), m3u8CacheTask.getVid(), m3u8CacheTask.getStreamId(), 0, m3u8CacheTask.getTsNum(), m3u8CacheTask.isWriteM3u8() ? 1 : 0);
        this.mRunningTasks.add(m3u8CacheTask);
        TaskCallback taskCallback = this.mTaskCallback;
        if (taskCallback != null) {
            taskCallback.onStart(m3u8CacheTask);
        }
    }

    public void cache(M3u8CacheTask m3u8CacheTask) {
        String str;
        ImgoCacheLogger.d(TAG, "cache in");
        if (this.mManagerAddress == 0 || m3u8CacheTask == null || m3u8CacheTask.getVid() == null || m3u8CacheTask.getUrl() == null) {
            str = "cache FAILED invalid task";
        } else if (!UrlUtil.isM3u8(m3u8CacheTask.getUrl())) {
            ImgoCacheLogger.i(TAG, "cache FAILED cause by not m3u8 ");
            m3u8CacheTask.setCurrentStatus(M3u8CacheTask.Status.FAILED);
            TaskCallback taskCallback = this.mTaskCallback;
            if (taskCallback != null) {
                taskCallback.onFailed(m3u8CacheTask);
                return;
            }
            return;
        } else {
            ImgoCacheLogger.i(TAG, "cache in vid:" + m3u8CacheTask.getVid() + ",streamid:" + m3u8CacheTask.getStreamId());
            if (this.mRunningTasks.size() < 1) {
                moveToRunningTasks(m3u8CacheTask);
            } else {
                ImgoCacheLogger.i(TAG, "add to mPrepareTasks");
                this.mPrepareTasks.add(m3u8CacheTask);
            }
            str = "cache out";
        }
        ImgoCacheLogger.i(TAG, str);
    }

    public void cancel(M3u8CacheTask m3u8CacheTask) {
        if (this.mManagerAddress == 0 || m3u8CacheTask == null) {
            return;
        }
        ImgoCacheLogger.i(TAG, "cancel in vid:" + m3u8CacheTask.getVid() + ",streamid:" + m3u8CacheTask.getStreamId());
        if (this.mRunningTasks.contains(m3u8CacheTask)) {
            ImgoCacheLogger.i(TAG, "cancel from mRunningTasks");
            this.mRunningTasks.remove(m3u8CacheTask);
        }
        if (this.mPrepareTasks.contains(m3u8CacheTask)) {
            ImgoCacheLogger.i(TAG, "cancel from mPrepareTasks");
            this.mPrepareTasks.remove(m3u8CacheTask);
        }
        ImgoSourceNative.cancelCache(this.mManagerAddress, null);
        ImgoCacheLogger.i(TAG, "cancel out");
    }

    public boolean isLibsLoaded() {
        return ImgoLibLoader.getInstance().isDsLibLoaded() && ImgoLibLoader.getInstance().isCacheLibLoaded();
    }

    public void release() {
        if (this.mManagerAddress == 0) {
            return;
        }
        ImgoCacheLogger.i(TAG, "release in");
        ImgoSourceNative.removeCallback(this.mCallback);
        ImgoSourceNative.freeCacheManager(this.mManagerAddress);
        this.mManagerAddress = 0L;
        Queue<M3u8CacheTask> queue = this.mPrepareTasks;
        if (queue != null) {
            queue.clear();
        }
        List<M3u8CacheTask> list = this.mRunningTasks;
        if (list != null) {
            list.clear();
        }
        ImgoCacheLogger.i(TAG, "release out");
    }

    public void setTaskCallback(TaskCallback taskCallback) {
        this.mTaskCallback = taskCallback;
    }
}
