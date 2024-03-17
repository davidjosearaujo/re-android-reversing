package com.hunantv.media.recoder;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.ExTicker;
import com.hunantv.media.utils.BitmapUtil;
import com.hunantv.media.utils.FileUtil;
import java.lang.ref.WeakReference;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GifRecorder {
    private static final int DEFAULT_HEIGHT = -1;
    private static final int DEFAULT_WIDTH = -1;
    public static final int ERR_REASON_ILLEGAL_ARGUMENT = 105;
    public static final int ERR_REASON_ILLEGAL_FRAMES_DIR = 109;
    public static final int ERR_REASON_ILLEGAL_STATUS = 103;
    public static final int ERR_REASON_NOT_SUPPORTED = 101;
    public static final int ERR_REASON_RECORD_FRAMES_ERROR = 201;
    public static final int ERR_RESON_BASE = 100;
    public static final int ERR_RESON_MAKE_GIF_BASE = 300;
    public static final int ERR_RESON_MAKE_GIF_ERROR = 302;
    public static final int ERR_RESON_NO_FRAMES_MAKE_GIF = 301;
    public static final int ERR_RESON_RECORD_BASE = 200;
    private static final String FRAMES_SUFFIX = ".jpeg";
    private static final int INTERRUPT_INNER_REASON = 100;
    public static final int INTERRUPT_REASON_COMPLETE = 102;
    public static final int INTERRUPT_REASON_ERROR = 101;
    public static final int INTERRUPT_REASON_RECORD_FRAMES_TOO_MUCH = 105;
    public static final int INTERRUPT_REASON_RESET = 103;
    public static final int MAX_FRAME_WIDTH = 848;
    private static final int MAX_SNAPSHOT_ERROR = 10;
    private static final String TAG = "[GifRecorder]";
    private WeakHandler mAsyncHandler;
    private Callback mCallback;
    private Configuration mConfiguration;
    private boolean mIsMakingGif;
    private MgtvMediaPlayer mPlayer;
    private HandlerThread mProcessThread;
    private ExTicker mTicker;
    private int mIndex = 0;
    private int mFramesErrorCounter = 0;
    private int mMaxFramesError = 10;
    private volatile Status mStatus = Status.IDLE;
    private String mTempFrameDir = null;
    private ExTicker.onTickListener mOnTickListener = new ExTicker.onTickListener() { // from class: com.hunantv.media.recoder.GifRecorder.1
        @Override // com.hunantv.media.player.utils.ExTicker.onTickListener
        public void onTick(int i) {
            if (GifRecorder.this.mStatus != Status.START) {
                return;
            }
            int i2 = GifRecorder.this.mConfiguration.maxDuration * GifRecorder.this.mConfiguration.fps;
            if (GifRecorder.this.mIndex > i2) {
                GifRecorder.this.interrupt(105, 0, "interrupt beyond maxFrames:" + i2);
                return;
            }
            String str = GifRecorder.this.mTempFrameDir + GifRecorder.this.mIndex + GifRecorder.FRAMES_SUFFIX;
            Bitmap snapshot = GifRecorder.this.mPlayer.getSnapshot(GifRecorder.this.mConfiguration.framesWidth, GifRecorder.this.mConfiguration.framesHeight);
            if (BitmapUtil.saveJpeg(snapshot, str)) {
                GifRecorder.access$208(GifRecorder.this);
                GifRecorder.this.mFramesErrorCounter = 0;
            } else {
                GifRecorder.access$508(GifRecorder.this);
            }
            if (snapshot != null && !snapshot.isRecycled()) {
                snapshot.recycle();
            }
            if (GifRecorder.this.mFramesErrorCounter >= GifRecorder.this.mMaxFramesError) {
                GifRecorder.this.callbackError(201, 0, "framesErrorCounter:" + GifRecorder.this.mFramesErrorCounter);
            }
        }
    };

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Callback {
        void onEndRecord();

        void onError(int i, int i2, String str);

        void onInterrupted(int i, int i2, String str);

        void onMakingGif();

        void onPause();

        void onResultGif(String str);

        void onResume();

        void onStart();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Configuration {
        public boolean autoResult;
        public int maxFramesError;
        public String saveDir;
        public String saveFramsDir;
        public int width = -1;
        public int height = -1;
        public int framesWidth = -1;
        public int framesHeight = -1;
        public int fps = 3;
        public int loopCount = 0;
        public int maxDuration = 60;

        public Configuration setAutoResult(boolean z) {
            this.autoResult = z;
            return this;
        }

        public Configuration setFps(int i) {
            this.fps = i;
            return this;
        }

        public Configuration setHeight(int i) {
            this.height = i;
            return this;
        }

        public Configuration setLoopCount(int i) {
            this.loopCount = i;
            return this;
        }

        public Configuration setMaxDuration(int i) {
            this.maxDuration = i;
            return this;
        }

        public Configuration setMaxFramesError(int i) {
            this.maxFramesError = i;
            return this;
        }

        public Configuration setSaveDir(String str) {
            this.saveDir = str;
            return this;
        }

        public Configuration setWidth(int i) {
            this.width = i;
            return this;
        }

        public String toString() {
            return "[width-" + this.width + ",height-" + this.height + ",fps-" + this.fps + ",autoResult-" + this.autoResult + ",saveDir-" + this.saveDir + ",maxFramesError-" + this.maxFramesError + ",maxDuration-" + this.maxDuration + "]";
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum Status {
        IDLE,
        START,
        PAUSE,
        STOP,
        INTERRUPT,
        ERROR
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class WeakHandler extends Handler {
        public static final int MSG_ASYNC_RESULT_GIF = 256;
        private WeakReference<GifRecorder> mWeakGifRecorder;

        public WeakHandler(Looper looper, GifRecorder gifRecorder) {
            super(looper);
            this.mWeakGifRecorder = new WeakReference<>(gifRecorder);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            GifRecorder gifRecorder = this.mWeakGifRecorder.get();
            if (gifRecorder != null && message.what == 256) {
                gifRecorder.makeGif();
            }
        }
    }

    public static /* synthetic */ int access$208(GifRecorder gifRecorder) {
        int i = gifRecorder.mIndex;
        gifRecorder.mIndex = i + 1;
        return i;
    }

    public static /* synthetic */ int access$508(GifRecorder gifRecorder) {
        int i = gifRecorder.mFramesErrorCounter;
        gifRecorder.mFramesErrorCounter = i + 1;
        return i;
    }

    private void callbackError(int i) {
        callbackError(i, 0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackError(int i, int i2, String str) {
        String str2 = str + ",status:" + getStatus().name();
        DebugLog.e(TAG, "callbackError reason:" + i + ",extra:" + i2 + ",msg:" + str2);
        stopRecorder();
        this.mStatus = Status.ERROR;
        reset();
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onError(i, i2, str2);
        }
    }

    private void stopRecorder() {
        if (this.mTicker != null) {
            DebugLog.i(TAG, "stop record.frame_num:" + this.mIndex);
            this.mTicker.stop();
            this.mTicker = null;
        }
    }

    public void bindMediaPlayer(MgtvMediaPlayer mgtvMediaPlayer) {
        this.mPlayer = mgtvMediaPlayer;
    }

    public void end() {
        if (this.mStatus == Status.IDLE) {
            return;
        }
        stopRecorder();
        this.mStatus = Status.STOP;
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onEndRecord();
        }
        Configuration configuration = this.mConfiguration;
        if (configuration == null || !configuration.autoResult) {
            return;
        }
        makeGifAsync();
    }

    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public void interrupt(int i) {
        interrupt(i, 0, null);
    }

    public void interrupt(int i, int i2, String str) {
        if (this.mStatus == Status.IDLE || this.mStatus == Status.STOP || this.mStatus == Status.ERROR) {
            return;
        }
        Status status = this.mStatus;
        Status status2 = Status.INTERRUPT;
        if (status == status2) {
            return;
        }
        DebugLog.i(TAG, "interrupt by reason:" + i);
        stopRecorder();
        this.mStatus = status2;
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onInterrupted(i, i2, str);
        }
    }

    public boolean isPaused() {
        return this.mStatus == Status.PAUSE;
    }

    public boolean isRecording() {
        return this.mStatus == Status.START || this.mStatus == Status.PAUSE;
    }

    public boolean isSupported() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mPlayer;
        if (mgtvMediaPlayer != null) {
            if (!mgtvMediaPlayer.isHardware() || Build.VERSION.SDK_INT > 22) {
                return this.mPlayer.isSupportedSnapshot();
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2 A[Catch: Exception -> 0x00d2, TryCatch #0 {Exception -> 0x00d2, blocks: (B:10:0x0017, B:12:0x002c, B:14:0x0034, B:16:0x006f, B:17:0x0072, B:19:0x0078, B:22:0x007d, B:24:0x00a2, B:26:0x00c2, B:28:0x00c6, B:30:0x00ca, B:23:0x009e), top: B:35:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ca A[Catch: Exception -> 0x00d2, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d2, blocks: (B:10:0x0017, B:12:0x002c, B:14:0x0034, B:16:0x006f, B:17:0x0072, B:19:0x0078, B:22:0x007d, B:24:0x00a2, B:26:0x00c2, B:28:0x00c6, B:30:0x00ca, B:23:0x009e), top: B:35:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String makeGif() {
        /*
            r8 = this;
            java.lang.String r0 = ".jpeg"
            java.lang.String r1 = "[GifRecorder]"
            com.hunantv.media.recoder.GifRecorder$Status r2 = r8.mStatus
            com.hunantv.media.recoder.GifRecorder$Status r3 = com.hunantv.media.recoder.GifRecorder.Status.STOP
            r4 = 0
            if (r2 == r3) goto L11
            com.hunantv.media.recoder.GifRecorder$Status r2 = r8.mStatus
            com.hunantv.media.recoder.GifRecorder$Status r3 = com.hunantv.media.recoder.GifRecorder.Status.INTERRUPT
            if (r2 != r3) goto L15
        L11:
            boolean r2 = r8.mIsMakingGif
            if (r2 == 0) goto L16
        L15:
            return r4
        L16:
            r2 = 0
            java.lang.String r3 = "start makeGif"
            com.hunantv.media.player.pragma.DebugLog.i(r1, r3)     // Catch: java.lang.Exception -> Ld2
            r3 = 1
            r8.mIsMakingGif = r3     // Catch: java.lang.Exception -> Ld2
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> Ld2
            java.lang.String r5 = r8.mTempFrameDir     // Catch: java.lang.Exception -> Ld2
            r3.<init>(r5)     // Catch: java.lang.Exception -> Ld2
            int r3 = com.hunantv.media.utils.FileUtil.listCount(r3, r0)     // Catch: java.lang.Exception -> Ld2
            if (r3 > 0) goto L34
            r0 = 301(0x12d, float:4.22E-43)
            java.lang.String r1 = "no frames to make gif"
            r8.callbackError(r0, r2, r1)     // Catch: java.lang.Exception -> Ld2
            return r4
        L34:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld2
            r3.<init>()     // Catch: java.lang.Exception -> Ld2
            java.lang.String r5 = r8.mTempFrameDir     // Catch: java.lang.Exception -> Ld2
            r3.append(r5)     // Catch: java.lang.Exception -> Ld2
            java.lang.String r5 = "#d"
            r3.append(r5)     // Catch: java.lang.Exception -> Ld2
            r3.append(r0)     // Catch: java.lang.Exception -> Ld2
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> Ld2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld2
            r3.<init>()     // Catch: java.lang.Exception -> Ld2
            com.hunantv.media.recoder.GifRecorder$Configuration r5 = r8.mConfiguration     // Catch: java.lang.Exception -> Ld2
            java.lang.String r5 = r5.saveDir     // Catch: java.lang.Exception -> Ld2
            r3.append(r5)     // Catch: java.lang.Exception -> Ld2
            java.lang.String r5 = "/test.gif"
            r3.append(r5)     // Catch: java.lang.Exception -> Ld2
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Ld2
            java.io.File r5 = new java.io.File     // Catch: java.lang.Exception -> Ld2
            r5.<init>(r3)     // Catch: java.lang.Exception -> Ld2
            com.hunantv.media.utils.FileUtil.deleteFile(r5)     // Catch: java.lang.Exception -> Ld2
            com.hunantv.media.recoder.GifRecorder$Configuration r5 = r8.mConfiguration     // Catch: java.lang.Exception -> Ld2
            int r5 = r5.fps     // Catch: java.lang.Exception -> Ld2
            com.hunantv.media.recoder.GifRecorder$Callback r6 = r8.mCallback     // Catch: java.lang.Exception -> Ld2
            if (r6 == 0) goto L72
            r6.onMakingGif()     // Catch: java.lang.Exception -> Ld2
        L72:
            com.hunantv.media.recoder.GifRecorder$Configuration r6 = r8.mConfiguration     // Catch: java.lang.Exception -> Ld2
            int r7 = r6.width     // Catch: java.lang.Exception -> Ld2
            if (r7 <= 0) goto L9e
            int r6 = r6.height     // Catch: java.lang.Exception -> Ld2
            if (r6 > 0) goto L7d
            goto L9e
        L7d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld2
            r6.<init>()     // Catch: java.lang.Exception -> Ld2
            com.hunantv.media.recoder.GifRecorder$Configuration r7 = r8.mConfiguration     // Catch: java.lang.Exception -> Ld2
            int r7 = r7.width     // Catch: java.lang.Exception -> Ld2
            r6.append(r7)     // Catch: java.lang.Exception -> Ld2
            java.lang.String r7 = "x"
            r6.append(r7)     // Catch: java.lang.Exception -> Ld2
            com.hunantv.media.recoder.GifRecorder$Configuration r7 = r8.mConfiguration     // Catch: java.lang.Exception -> Ld2
            int r7 = r7.height     // Catch: java.lang.Exception -> Ld2
            r6.append(r7)     // Catch: java.lang.Exception -> Ld2
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> Ld2
            int r0 = c.a.a.a.q.a.c(r0, r3, r6, r5)     // Catch: java.lang.Exception -> Ld2
            goto La2
        L9e:
            int r0 = c.a.a.a.q.a.b(r0, r3, r5)     // Catch: java.lang.Exception -> Ld2
        La2:
            r8.mIsMakingGif = r2     // Catch: java.lang.Exception -> Ld2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld2
            r5.<init>()     // Catch: java.lang.Exception -> Ld2
            java.lang.String r6 = "makeGif result:"
            r5.append(r6)     // Catch: java.lang.Exception -> Ld2
            r5.append(r0)     // Catch: java.lang.Exception -> Ld2
            java.lang.String r6 = ",gifPath:"
            r5.append(r6)     // Catch: java.lang.Exception -> Ld2
            r5.append(r3)     // Catch: java.lang.Exception -> Ld2
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> Ld2
            com.hunantv.media.player.pragma.DebugLog.i(r1, r5)     // Catch: java.lang.Exception -> Ld2
            if (r0 != 0) goto Lca
            com.hunantv.media.recoder.GifRecorder$Callback r0 = r8.mCallback     // Catch: java.lang.Exception -> Ld2
            if (r0 == 0) goto Lc9
            r0.onResultGif(r3)     // Catch: java.lang.Exception -> Ld2
        Lc9:
            return r3
        Lca:
            r1 = 302(0x12e, float:4.23E-43)
            java.lang.String r3 = "make gif failed"
            r8.callbackError(r1, r0, r3)     // Catch: java.lang.Exception -> Ld2
            return r4
        Ld2:
            r0 = move-exception
            r1 = 300(0x12c, float:4.2E-43)
            java.lang.String r0 = r0.getMessage()
            r8.callbackError(r1, r2, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.recoder.GifRecorder.makeGif():java.lang.String");
    }

    public void makeGifAsync() {
        WeakHandler weakHandler;
        if ((this.mStatus != Status.STOP && this.mStatus != Status.INTERRUPT) || this.mIsMakingGif || (weakHandler = this.mAsyncHandler) == null) {
            return;
        }
        weakHandler.sendEmptyMessage(256);
    }

    public void pause() {
        if (this.mStatus != Status.START) {
            return;
        }
        DebugLog.i(TAG, "pause record");
        ExTicker exTicker = this.mTicker;
        if (exTicker != null) {
            exTicker.pause();
        }
        this.mStatus = Status.PAUSE;
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onPause();
        }
    }

    public void release() {
    }

    public void reset() {
        Status status = this.mStatus;
        Status status2 = Status.IDLE;
        if (status == status2) {
            return;
        }
        interrupt(103);
        FileUtil.deleteDir(this.mTempFrameDir);
        WeakHandler weakHandler = this.mAsyncHandler;
        if (weakHandler != null) {
            weakHandler.removeMessages(256);
            this.mAsyncHandler = null;
        }
        HandlerThread handlerThread = this.mProcessThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mProcessThread = null;
        }
        this.mTempFrameDir = null;
        this.mIndex = 0;
        this.mFramesErrorCounter = 0;
        this.mStatus = status2;
    }

    public void resume() {
        if (this.mStatus != Status.PAUSE) {
            return;
        }
        DebugLog.i(TAG, "resume record");
        ExTicker exTicker = this.mTicker;
        if (exTicker != null) {
            exTicker.resume();
        }
        this.mStatus = Status.START;
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onResume();
        }
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public boolean start(Configuration configuration) {
        String str;
        String str2;
        DebugLog.i(TAG, "try start snapshot");
        if (!isSupported()) {
            callbackError(101);
            return false;
        }
        reset();
        if (this.mStatus != Status.IDLE) {
            callbackError(103);
            return false;
        } else if (configuration == null || (str2 = configuration.saveDir) == null || "".equals(str2.trim())) {
            if (configuration == null) {
                str = "config == null";
            } else {
                str = "config.saveDir:" + configuration.saveDir;
            }
            callbackError(105, 0, str);
            return false;
        } else {
            try {
                stopRecorder();
                if (!this.mPlayer.isPlaying()) {
                    callbackError(100, 1, "");
                    stopRecorder();
                    return false;
                }
                this.mConfiguration = configuration;
                if (configuration.framesWidth == -1) {
                    configuration.framesWidth = this.mPlayer.getVideoWidth();
                }
                Configuration configuration2 = this.mConfiguration;
                if (configuration2.framesHeight == -1) {
                    configuration2.framesHeight = this.mPlayer.getVideoHeight();
                }
                Configuration configuration3 = this.mConfiguration;
                int i = configuration3.framesWidth;
                if (i > 848) {
                    configuration3.framesHeight = (configuration3.framesHeight * MAX_FRAME_WIDTH) / i;
                    configuration3.framesWidth = MAX_FRAME_WIDTH;
                }
                DebugLog.i(TAG, "start record. framesWidth:" + this.mConfiguration.framesWidth + ", framesHeight:" + this.mConfiguration.framesHeight);
                Configuration configuration4 = this.mConfiguration;
                int i2 = configuration4.maxFramesError;
                if (i2 > 0) {
                    this.mMaxFramesError = i2;
                }
                String str3 = configuration4.saveFramsDir;
                if (str3 != null) {
                    this.mTempFrameDir = str3;
                } else {
                    String str4 = this.mConfiguration.saveDir + "/temp_frame/";
                    this.mTempFrameDir = str4;
                    this.mConfiguration.saveFramsDir = str4;
                }
                if (!FileUtil.remkdirs(this.mTempFrameDir)) {
                    callbackError(109, 0, this.mTempFrameDir + " can't remkdirs");
                    return false;
                }
                this.mIndex = 0;
                if (this.mProcessThread == null) {
                    HandlerThread handlerThread = new HandlerThread("mgtvmp_jGif1Pro");
                    this.mProcessThread = handlerThread;
                    handlerThread.start();
                }
                if (this.mAsyncHandler == null) {
                    this.mAsyncHandler = new WeakHandler(this.mProcessThread.getLooper(), this);
                }
                DebugLog.i(TAG, "start record. Configuration:" + this.mConfiguration);
                ExTicker exTicker = new ExTicker(this.mProcessThread.getLooper(), 1000 / this.mConfiguration.fps);
                this.mTicker = exTicker;
                exTicker.setCallback(this.mOnTickListener);
                this.mTicker.start();
                this.mStatus = Status.START;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onStart();
                }
                return true;
            } catch (Exception e) {
                callbackError(100, 0, e.getMessage());
                return false;
            }
        }
    }
}
