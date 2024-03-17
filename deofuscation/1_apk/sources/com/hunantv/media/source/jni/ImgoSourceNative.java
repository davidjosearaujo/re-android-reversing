package com.hunantv.media.source.jni;

import com.hunantv.media.source.ImgoCacheLogger;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoSourceNative {
    public static final int ERROR = -1;
    public static final int OK = 0;
    public static final String TAG = "ImgoSourceNative";
    private static List<WeakReference<Callback>> sCallbacks = new LinkedList();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Callback {
        void onError(CbErrorParams cbErrorParams);

        void onResult(int i, CbResultParams cbResultParams);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class CbErrorParams {
        public int detail_code;
        public int error_code;
        public String taskid;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class CbResultParams {
        public static final int FT_FLV = 2;
        public static final int FT_M3U8 = 0;
        public static final int FT_MP4 = 1;
        public static final int FT_UNKNOW = -1;
        public String file_name;
        public String fullpath;
        public String taskid;
        public String[] ts_names;
        public int type;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class CbStartParams {
        public String filepath;
        public String taskid;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class InitParams {
        public int connect_timeout_ms;
        public int max_task_num = 5;
        public int request_timeout_ms;
        public String useragent;
    }

    public static native void cancelCache(long j, String str);

    public static native void freeCacheManager(long j);

    public static native long getDynamicIntervalBytes(long j);

    private static void native_errorcallback(CbErrorParams cbErrorParams) {
        for (WeakReference<Callback> weakReference : sCallbacks) {
            Callback callback = weakReference.get();
            if (callback != null) {
                callback.onError(cbErrorParams);
            }
        }
    }

    private static void native_logger(int i, String str, String str2) {
        ImgoCacheLogger.cbLog(i, str, str2);
    }

    private static void native_resultcallback(int i, CbResultParams cbResultParams) {
        for (WeakReference<Callback> weakReference : sCallbacks) {
            Callback callback = weakReference.get();
            if (callback != null) {
                callback.onResult(i, cbResultParams);
            }
        }
    }

    public static native long newCacheManager(String str, InitParams initParams);

    public static native void pauseCache(long j, String str);

    public static void removeCallback(Callback callback) {
        for (WeakReference<Callback> weakReference : sCallbacks) {
            Callback callback2 = weakReference.get();
            if (callback2 != null && callback2.equals(callback)) {
                sCallbacks.remove(weakReference);
                return;
            }
        }
    }

    public static native void resumeCache(long j, String str);

    public static native void setMaxTask(long j, int i);

    public static native CbStartParams startCache(long j, String str, String str2, int i, int i2, int i3, int i4);

    public static void subscribeCallback(Callback callback) {
        sCallbacks.add(new WeakReference<>(callback));
    }

    public static native String testJNI();
}
