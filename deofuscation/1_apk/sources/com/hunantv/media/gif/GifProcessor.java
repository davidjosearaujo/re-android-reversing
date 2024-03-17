package com.hunantv.media.gif;

import a.a.a.b.a;
import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.libnative.FFmpegApi;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.FileUtil;
import com.hunantv.media.player.utils.StringUtil;
import com.hunantv.media.report.ReportParams;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GifProcessor {
    public static final int ERROR_GIF = 7001999;
    private static String TAG = "GifProcessor";
    private static Application sApplication;
    private static GifProcessor sInstance;
    private GifProcessHandler mGifProcessHandler;
    private HandlerThread mGifProcessThread;
    private a mReporter;
    private Object mSafeLocker = new Object();
    private WeakReference<Callback> mWeakCallback;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Callback {
        void onFailure(int i, Task task);

        void onSuccess(String str, Task task);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class GifProcessHandler extends Handler {
        public static final int MSG_GIF_PROCESS = 100;
        private WeakReference<GifProcessor> mWeakProcessor;

        public GifProcessHandler(GifProcessor gifProcessor, Looper looper) {
            super(looper);
            this.mWeakProcessor = new WeakReference<>(gifProcessor);
        }

        private void callbackFail(int i, Task task) {
            reportErr(7001999, i);
            GifProcessor gifProcessor = this.mWeakProcessor.get();
            if (gifProcessor != null) {
                gifProcessor.callbackFailure(i, task);
            }
        }

        private void callbackSuc(Task task) {
            reportVV();
            GifProcessor gifProcessor = this.mWeakProcessor.get();
            if (gifProcessor != null) {
                gifProcessor.callbackSuccess(task.targetFile, task);
            }
        }

        private void processGif(Message message) {
            int i;
            reportPV();
            if (message == null) {
                i = -200;
            } else {
                Task task = (Task) message.obj;
                DebugLog.i(GifProcessor.TAG, "processGif in. " + task);
                if (task != null) {
                    task.targetFile = task.targetDir + "/" + ("gif_" + System.currentTimeMillis() + ".gif");
                    int a = c.a.a.a.q.a.a(GifProcessor.sApplication, task.url, task.startS, task.durationS, task.w, task.h, task.fps, task.targetFile);
                    DebugLog.i(GifProcessor.TAG, "processGif out. ret=" + a);
                    if (a == 0) {
                        callbackSuc(task);
                        return;
                    } else {
                        callbackFail(a, task);
                        return;
                    }
                }
                i = -201;
            }
            callbackFail(i, null);
        }

        private void reportErr(int i, int i2) {
            GifProcessor gifProcessor = this.mWeakProcessor.get();
            if (gifProcessor == null || gifProcessor.mReporter == null) {
                return;
            }
            gifProcessor.mReporter.l(i, i2, "");
        }

        private void reportPV() {
            GifProcessor gifProcessor = this.mWeakProcessor.get();
            if (gifProcessor == null || gifProcessor.mReporter == null) {
                return;
            }
            gifProcessor.mReporter.H();
        }

        private void reportVV() {
            GifProcessor gifProcessor = this.mWeakProcessor.get();
            if (gifProcessor == null || gifProcessor.mReporter == null) {
                return;
            }
            gifProcessor.mReporter.N();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 100) {
                return;
            }
            processGif(message);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Task {
        public int durationS;
        public int fps;
        public int h;
        public int startS;
        public String targetDir;
        private String targetFile;
        public String url;
        public int w;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class Size {
            public int height;
            public int width;

            public Size(int i, int i2) {
                this.width = i;
                this.height = i2;
            }

            public String toString() {
                return "Size{width=" + this.width + ", height=" + this.height + '}';
            }
        }

        public Task(String str, int i, int i2, int i3, int i4, int i5, String str2) {
            this.fps = 10;
            this.url = str;
            this.startS = i;
            this.durationS = i2;
            this.w = i3;
            this.h = i4;
            this.fps = i5;
            this.targetDir = str2;
        }

        public static Size getAutoSize(int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                return new Size(0, 0);
            }
            String str = GifProcessor.TAG;
            DebugLog.i(str, "getAutoSize in." + i + "-" + i2);
            if (i < i2) {
                if (i2 >= 480) {
                    i = (i * 480) / i2;
                    i2 = 480;
                }
            } else if (i >= 480) {
                i2 = (i2 * 480) / i;
                i = 480;
            }
            String str2 = GifProcessor.TAG;
            DebugLog.i(str2, "getAutoSize out." + i + "-" + i2);
            return new Size(i, i2);
        }

        public void autoSize(int i, int i2) {
            Size autoSize = getAutoSize(i, i2);
            if (autoSize != null) {
                this.w = autoSize.width;
                this.h = autoSize.height;
            }
        }

        public String getTargetFile() {
            return this.targetFile;
        }

        public String toString() {
            return "Task{url='" + this.url + "', startS=" + this.startS + ", durationS=" + this.durationS + ", w=" + this.w + ", h=" + this.h + ", fps=" + this.fps + ", targetDir='" + this.targetDir + "', targetFile='" + this.targetFile + "'}";
        }
    }

    private GifProcessor() {
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void callbackFailure(int i, Task task) {
        String str = TAG;
        DebugLog.i(str, "callbackFailure ret:" + i + ", " + task);
        if (task != null && !StringUtil.isEmpty(task.targetFile)) {
            try {
                FileUtil.deleteFile(new File(task.targetFile));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Callback callback = this.mWeakCallback.get();
        if (callback != null) {
            callback.onFailure(i, task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackSuccess(String str, Task task) {
        String str2 = TAG;
        DebugLog.i(str2, "callbackSuccess targetFile=" + str + ", " + task);
        Callback callback = this.mWeakCallback.get();
        if (callback != null) {
            callback.onSuccess(str, task);
        }
    }

    public static synchronized GifProcessor getInstance() {
        GifProcessor gifProcessor;
        synchronized (GifProcessor.class) {
            if (sInstance == null) {
                sInstance = new GifProcessor();
            }
            gifProcessor = sInstance;
        }
        return gifProcessor;
    }

    private void init() {
        if (this.mGifProcessThread == null) {
            HandlerThread handlerThread = new HandlerThread("MgtvGifProcessThread");
            this.mGifProcessThread = handlerThread;
            handlerThread.start();
        }
        if (this.mGifProcessHandler == null) {
            this.mGifProcessHandler = new GifProcessHandler(this, this.mGifProcessThread.getLooper());
        }
    }

    private boolean validTask(Task task) {
        return task != null && !StringUtil.isEmpty(task.url) && task.startS >= 0 && task.durationS > 0 && task.fps > 0;
    }

    public void bindApplication(Application application) {
        sApplication = application;
        a aVar = new a(sApplication, (MgtvMediaPlayer) null);
        this.mReporter = aVar;
        aVar.n(new ReportParams().setVideoType(ReportParams.VideoType.GIF_CREATOR));
    }

    public void cancel() {
        synchronized (this.mSafeLocker) {
            DebugLog.i(TAG, "cancel in");
            try {
                FFmpegApi.fftool_process_interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DebugLog.i(TAG, "cancel out");
        }
    }

    public boolean isSupported() {
        return c.a.a.a.q.a.e();
    }

    public void processAsync(Task task) {
        cancel();
        synchronized (this.mSafeLocker) {
            String str = TAG;
            DebugLog.i(str, "processAsync in. " + task);
            if (this.mGifProcessHandler != null && this.mGifProcessThread != null) {
                if (!validTask(task)) {
                    callbackFailure(-101, task);
                    return;
                }
                this.mGifProcessHandler.removeMessages(100);
                Message message = new Message();
                message.what = 100;
                message.obj = task;
                this.mGifProcessHandler.sendMessage(message);
                DebugLog.i(TAG, "processAsync out.");
                return;
            }
            callbackFailure(-100, task);
        }
    }

    public void release() {
        synchronized (this.mSafeLocker) {
            DebugLog.i(TAG, "release in");
            try {
                FFmpegApi.fftool_process_interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            GifProcessHandler gifProcessHandler = this.mGifProcessHandler;
            if (gifProcessHandler != null) {
                gifProcessHandler.removeMessages(100);
                this.mGifProcessHandler = null;
            }
            HandlerThread handlerThread = this.mGifProcessThread;
            if (handlerThread != null) {
                handlerThread.quit();
                this.mGifProcessThread = null;
            }
            DebugLog.i(TAG, "release out");
        }
    }

    public void setWeakCallback(Callback callback) {
        this.mWeakCallback = new WeakReference<>(callback);
    }
}
