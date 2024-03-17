package com.hunantv.media.gif;

import a.a.a.b.a;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.report.ReportParams;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GifFramesProducer {
    public static final int ERROR_GIF_PREVIEW_IMAGE = 7001998;
    private Callback mCallback;
    private Config mConfig;
    private Context mContext;
    private Uri mCurrentUri;
    private MgtvMediaPlayer mMediaPlayer;
    private a mReporter;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Callback {
        void onError(int i, int i2);

        void onImage(int i, String str);

        void onStart();

        void onSuccess();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Config {
        public int endMs;
        public float fileStartTimeFloatS;
        public String imageDir;
        public int imgH;
        public int imgW;
        public int num;
        public int startMs;
        public String url;

        public Config(String str, int i, int i2, int i3, int i4, int i5, String str2) {
            this.imgW = -1;
            this.imgH = -1;
            this.fileStartTimeFloatS = -1.0f;
            this.url = str;
            this.startMs = i;
            this.endMs = i2;
            this.num = i3;
            this.imgW = i4;
            this.imgH = i5;
            this.imageDir = str2;
        }

        public Config(String str, int i, int i2, int i3, String str2) {
            this.imgW = -1;
            this.imgH = -1;
            this.fileStartTimeFloatS = -1.0f;
            this.url = str;
            this.startMs = i;
            this.endMs = i2;
            this.num = i3;
            this.imageDir = str2;
        }

        public float getFileStartTimeFloatS() {
            return this.fileStartTimeFloatS;
        }

        public Config setFileStartTimeFloatS(float f) {
            this.fileStartTimeFloatS = f;
            return this;
        }

        public String toString() {
            return "Config{url='" + this.url + "', startMs=" + this.startMs + ", endMs=" + this.endMs + ", num=" + this.num + ", imgW=" + this.imgW + ", imgH=" + this.imgH + ", imageDir='" + this.imageDir + "'}";
        }
    }

    public GifFramesProducer(Context context, Config config) {
        this.mContext = context;
        this.mConfig = config;
        a aVar = new a(context, (MgtvMediaPlayer) null);
        this.mReporter = aVar;
        aVar.n(new ReportParams().setVideoType(ReportParams.VideoType.GIF_PREVIEW_IMAGE));
        String logTagKey = getLogTagKey();
        DebugLog.i(logTagKey, "VideoFrameCapture " + config);
    }

    private void initListener() {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer == null) {
            return;
        }
        mgtvMediaPlayer.setPrepared4StartMode(MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_AUTOPLAY);
        this.mMediaPlayer.setOnPreparedListener(new MgtvPlayerListener.OnPreparedListener() { // from class: com.hunantv.media.gif.GifFramesProducer.1
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnPreparedListener
            public void onPrepared() {
                DebugLog.i(GifFramesProducer.this.getLogTagKey(), "onPrepared in");
                if (GifFramesProducer.this.mCallback != null) {
                    GifFramesProducer.this.mCallback.onStart();
                }
                if (GifFramesProducer.this.mMediaPlayer.getPrepared4StartMode() != MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_AUTOPLAY) {
                    GifFramesProducer.this.mMediaPlayer.start();
                }
                DebugLog.i(GifFramesProducer.this.getLogTagKey(), "onPrepared out");
            }
        });
        this.mMediaPlayer.setOnGetFrameImageListener(new MgtvPlayerListener.OnGetFrameImageListener() { // from class: com.hunantv.media.gif.GifFramesProducer.2
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnGetFrameImageListener
            public void onGetFrameImageInfo(int i, int i2, String str) {
                String logTagKey = GifFramesProducer.this.getLogTagKey();
                DebugLog.i(logTagKey, "onGetFrameImageInfo result_code:" + i + ", timestamp:" + i2 + ", file_name:" + str);
                if (GifFramesProducer.this.mCallback != null) {
                    GifFramesProducer.this.mCallback.onImage(i2, str);
                }
            }

            @Override // com.hunantv.media.player.MgtvPlayerListener.OnGetFrameImageListener
            public void onGetFrameImageStatus(int i, int i2) {
                String logTagKey = GifFramesProducer.this.getLogTagKey();
                DebugLog.i(logTagKey, "onGetFrameImageStatus what:" + i + ", extra:" + i2);
                if (i != 1) {
                    if ((i == 2 || i == 3) && GifFramesProducer.this.mCallback != null) {
                        GifFramesProducer.this.preOnError(7001998, i2);
                        GifFramesProducer.this.mCallback.onError(7001998, i2);
                        return;
                    }
                    return;
                }
                if (GifFramesProducer.this.mReporter != null) {
                    GifFramesProducer.this.mReporter.N();
                }
                if (GifFramesProducer.this.mMediaPlayer != null) {
                    GifFramesProducer.this.mMediaPlayer.stop();
                }
                if (GifFramesProducer.this.mCallback != null) {
                    GifFramesProducer.this.mCallback.onSuccess();
                }
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MgtvPlayerListener.OnErrorListener() { // from class: com.hunantv.media.gif.GifFramesProducer.3
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnErrorListener
            public boolean onError(int i, int i2) {
                if (GifFramesProducer.this.mCallback != null) {
                    GifFramesProducer.this.preOnError(i, i2);
                    GifFramesProducer.this.mCallback.onError(i, i2);
                    return false;
                }
                return false;
            }
        });
        this.mMediaPlayer.setOnCompletionListener(new MgtvPlayerListener.OnCompletionListener() { // from class: com.hunantv.media.gif.GifFramesProducer.4
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnCompletionListener
            public void onCompletion(int i, int i2) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preOnError(int i, int i2) {
        a aVar = this.mReporter;
        if (aVar != null) {
            aVar.l(i, i2, "");
        }
    }

    public void cancel() {
        a aVar = this.mReporter;
        if (aVar != null) {
            aVar.M();
        }
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.stop();
        }
    }

    public void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public String getLogTagKey() {
        return getClass().getSimpleName() + "-" + hashCode();
    }

    public long getPropertyLong(int i, long j) {
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        return mgtvMediaPlayer != null ? mgtvMediaPlayer.getPropertyLong(i, j) : j;
    }

    public void process() {
        if (this.mConfig == null) {
            return;
        }
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.reset();
        }
        try {
            if (this.mMediaPlayer == null) {
                Bundle bundle = new Bundle();
                bundle.putString(MgtvMediaPlayer.BUNDLE_KEY_LOG_TAG_KEY, getLogTagKey());
                bundle.putBoolean(MgtvMediaPlayer.BUNDLE_KEY_BOOLEAN_ENABLE_REPORT, false);
                MgtvMediaPlayer mgtvMediaPlayer2 = new MgtvMediaPlayer(1, this.mContext, bundle);
                this.mMediaPlayer = mgtvMediaPlayer2;
                mgtvMediaPlayer2.setConfig(2020021001, 1);
                initListener();
            }
            Config config = this.mConfig;
            if (config != null) {
                float f = config.fileStartTimeFloatS;
                if (f >= 0.0f) {
                    this.mMediaPlayer.setPlayerFileStartTimeFloatS(f);
                }
            }
            this.mMediaPlayer.setReportParams(new ReportParams().setVideoType(ReportParams.VideoType.GIF_PREVIEW_IMAGE));
            this.mMediaPlayer.setPlayerSeekAtStartPosMs(this.mConfig.startMs);
            MgtvMediaPlayer mgtvMediaPlayer3 = this.mMediaPlayer;
            Config config2 = this.mConfig;
            mgtvMediaPlayer3.setFrameImageAtTime(config2.imageDir, config2.startMs, config2.endMs, config2.num, config2.imgW, config2.imgH);
            Uri parse = Uri.parse(this.mConfig.url.trim());
            this.mCurrentUri = parse;
            this.mMediaPlayer.setDataSource(parse.toString());
            this.mMediaPlayer.prepareAsync();
            a aVar = this.mReporter;
            if (aVar != null) {
                aVar.H();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        a aVar = this.mReporter;
        if (aVar != null) {
            aVar.M();
        }
        MgtvMediaPlayer mgtvMediaPlayer = this.mMediaPlayer;
        if (mgtvMediaPlayer != null) {
            mgtvMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }
}
