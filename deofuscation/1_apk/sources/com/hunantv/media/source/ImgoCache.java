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

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoCache implements IImgoSingleCache {
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
    private CacheTask mRunningCacheTask;
    private IImgoCache.TaskCallback mTaskCallback;

    public ImgoCache(Context context, String str) {
        this(context, str, null);
    }

    public ImgoCache(Context context, String str, ImgoSourceNative.InitParams initParams) {
        this.mLock = new Object();
        this.mCallback = new ImgoSourceNative.Callback() { // from class: com.hunantv.media.source.ImgoCache.1
            @Override // com.hunantv.media.source.jni.ImgoSourceNative.Callback
            public void onError(final ImgoSourceNative.CbErrorParams cbErrorParams) {
                if (cbErrorParams == null) {
                    ImgoCacheLogger.e(ImgoCache.this.TAG(), "onError params null");
                    return;
                }
                String TAG2 = ImgoCache.this.TAG();
                ImgoCacheLogger.e(TAG2, "onError taskid:" + cbErrorParams.taskid + ",error_code:" + cbErrorParams.error_code + ",detail_code:" + cbErrorParams.detail_code);
                if (ImgoCache.this.mMyLooper != null) {
                    ThreadUtil.runOnTargetLooper(ImgoCache.this.mMyLooper, new Runnable() { // from class: com.hunantv.media.source.ImgoCache.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ImgoCache.this.notifyTaskError(cbErrorParams);
                        }
                    });
                } else {
                    ThreadUtil.runOnUiThread(new Runnable() { // from class: com.hunantv.media.source.ImgoCache.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ImgoCache.this.notifyTaskError(cbErrorParams);
                        }
                    });
                }
            }

            @Override // com.hunantv.media.source.jni.ImgoSourceNative.Callback
            public void onResult(final int i, final ImgoSourceNative.CbResultParams cbResultParams) {
                if (cbResultParams != null) {
                    ImgoCacheLogger.d(ImgoCache.this.TAG(), "native_resultcallback result:" + i + ",taskid:" + cbResultParams.taskid + ",fullpath:" + cbResultParams.fullpath + ",type" + cbResultParams.type);
                    String[] strArr = cbResultParams.ts_names;
                    if (strArr != null && strArr.length > 0) {
                        for (String str2 : strArr) {
                            ImgoCacheLogger.i(ImgoCache.this.TAG(), "native_callback ts_name:" + str2);
                        }
                    }
                }
                if (i == 0) {
                    if (ImgoCache.this.mMyLooper != null) {
                        ThreadUtil.runOnTargetLooper(ImgoCache.this.mMyLooper, new Runnable() { // from class: com.hunantv.media.source.ImgoCache.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ImgoCache.this.notifyTaskResult(i, cbResultParams);
                            }
                        });
                    } else {
                        ThreadUtil.runOnUiThread(new Runnable() { // from class: com.hunantv.media.source.ImgoCache.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ImgoCache.this.notifyTaskResult(i, cbResultParams);
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

    private boolean isRunningTask(CacheTask cacheTask) {
        if (this.mRunningCacheTask == null || cacheTask == null) {
            return false;
        }
        return isRunningTask(cacheTask.getTaskID());
    }

    private boolean isRunningTask(String str) {
        return (this.mRunningCacheTask == null || StringUtil.isEmpty(str) || !str.equals(this.mRunningCacheTask.getTaskID())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyTaskError(ImgoSourceNative.CbErrorParams cbErrorParams) {
        ImgoCacheLogger.d(TAG(), "notifyTaskError");
        synchronized (this.mLock) {
            ImgoCacheLogger.d(TAG(), "notifyTaskError in");
            if (cbErrorParams != null && isRunningTask(cbErrorParams.taskid)) {
                CacheTask cacheTask = this.mRunningCacheTask;
                String TAG2 = TAG();
                ImgoCacheLogger.i(TAG2, "notifyTaskError findTask " + cacheTask);
                if (cacheTask != null) {
                    this.mRunningCacheTask = null;
                    cacheTask.setErrorCode(cbErrorParams.error_code);
                    cacheTask.setDetailCode(cbErrorParams.detail_code);
                    ImgoCacheLogger.i(TAG(), "notifyTaskError FAILED IN");
                    cacheTask.setTempPath(null);
                    cacheTask.setCurrentStatus(CacheTask.Status.FAILED);
                    callOnFailed(cacheTask);
                    ImgoCacheLogger.i(TAG(), "notifyTaskError FAILED OUT");
                    ImgoCacheLogger.i(TAG(), "notifyTaskError FINISH IN");
                    callOnFinish(cacheTask);
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
            if (cbResultParams != null && isRunningTask(cbResultParams.taskid)) {
                onTaskResult(this.mRunningCacheTask, i, cbResultParams);
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
            if (this.mManagerAddress != 0 && cacheTask != null && cacheTask.getVid() != null && cacheTask.getUrl() != null && !isRunningTask(cacheTask)) {
                CacheTask cacheTask2 = this.mRunningCacheTask;
                if (cacheTask2 == null || z) {
                    if (z && cacheTask2 != null) {
                        cancel();
                    }
                    String TAG2 = TAG();
                    ImgoCacheLogger.i(TAG2, "cache in vid:" + cacheTask.getVid() + ",streamid:" + cacheTask.getStreamId() + ",getWriteM3u8:" + cacheTask.getWriteM3u8());
                    startCache(cacheTask);
                    this.mRunningCacheTask = cacheTask;
                    callOnStart(cacheTask);
                    String TAG3 = TAG();
                    ImgoCacheLogger.i(TAG3, "cache out force:" + z);
                }
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

    @Override // com.hunantv.media.source.IImgoSingleCache
    public void cancel() {
        cancel(this.mRunningCacheTask);
    }

    @Override // com.hunantv.media.source.IImgoCache
    public void cancel(CacheTask cacheTask) {
        synchronized (this.mLock) {
            if (this.mManagerAddress != 0 && cacheTask != null) {
                String TAG2 = TAG();
                ImgoCacheLogger.i(TAG2, "cancel in vid:" + cacheTask.getVid() + ",streamid:" + cacheTask.getStreamId());
                cacheTask.setCurrentStatus(CacheTask.Status.NONE);
                cacheTask.setTempPath(null);
                ImgoSourceNative.cancelCache(this.mManagerAddress, cacheTask.getTaskID());
                if (isRunningTask(cacheTask)) {
                    this.mRunningCacheTask = null;
                }
                ImgoCacheLogger.i(TAG(), "cancel out");
            }
        }
    }

    public void create() {
        release();
        ImgoCacheLogger.i(TAG(), "create in");
        long newCacheManager = ImgoSourceNative.newCacheManager(this.mCachePath, this.mInitParams);
        this.mManagerAddress = newCacheManager;
        ImgoSourceNative.setMaxTask(newCacheManager, 1);
        ImgoSourceNative.subscribeCallback(this.mCallback);
        ImgoCacheLogger.i(TAG(), "create out");
    }

    @Override // com.hunantv.media.source.IImgoCache
    public IImgoCache.ExtraInfo getExtraInfo() {
        return new IImgoCache.ExtraInfo(this.mManagerAddress);
    }

    @Override // com.hunantv.media.source.IImgoSingleCache
    public CacheTask getRunningTask() {
        return this.mRunningCacheTask;
    }

    public void onTaskResult(CacheTask cacheTask, int i, ImgoSourceNative.CbResultParams cbResultParams) {
        String TAG2;
        String str;
        String TAG3 = TAG();
        ImgoCacheLogger.i(TAG3, "onResult findTask " + cacheTask);
        if (cacheTask != null) {
            this.mRunningCacheTask = null;
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
