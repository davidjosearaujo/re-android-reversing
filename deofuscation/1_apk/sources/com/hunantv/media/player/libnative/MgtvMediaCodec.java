package com.hunantv.media.player.libnative;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.hunantv.media.player.helper.MediaCodecHelp;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.StringUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

@TargetApi(16)
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvMediaCodec {
    private static final int MAX_WAITING_TIME_MS = 1000;
    private static final String OPPO_OSIE_ENABLE_KEY = "vendor.oplus-osie-enable.value";
    private static final String OPPO_SR_ENABLE_KEY = "vendor.oplus-sr-enable.value";
    private static final int STATUS_OK = 0;
    private static final int STATUS_TIMEOUT = 1;
    private static final String TAG = "MgtvMediaCodec";
    private String mCodecName;
    private volatile int mFlushStatus = 0;
    private MediaCodec mMediaCodec;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class CreateCodecRunnable implements Runnable {
        private volatile MediaCodec mMediaCodec;
        private String mName;
        private boolean mReleased;

        public CreateCodecRunnable(String str) {
            this.mName = str;
        }

        public MediaCodec getMediaCodec() {
            return this.mMediaCodec;
        }

        public void release() {
            this.mReleased = true;
            if (StringUtil.isEmpty(this.mName)) {
                return;
            }
            DebugLog.i(MgtvMediaCodec.TAG, "createByCodecName:" + this.mName + " put into blacklist");
            MediaCodecHelp.sCreateCodecBlackList.add(this.mName);
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb;
            try {
                try {
                    DebugLog.i(MgtvMediaCodec.TAG, "createByCodecName:" + this.mName + " IN");
                    this.mMediaCodec = MediaCodec.createByCodecName(this.mName);
                    DebugLog.i(MgtvMediaCodec.TAG, "createByCodecName:" + this.mName + " OUT");
                    if (this.mReleased) {
                        DebugLog.i(MgtvMediaCodec.TAG, "createByCodecName:" + this.mName + " already in released status.release in");
                        this.mMediaCodec.release();
                        DebugLog.i(MgtvMediaCodec.TAG, "createByCodecName:" + this.mName + " already in released status.release out");
                        this.mMediaCodec = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (StringUtil.isEmpty(this.mName) || !MediaCodecHelp.sCreateCodecBlackList.remove(this.mName)) {
                        return;
                    }
                    sb = new StringBuilder();
                }
                if (StringUtil.isEmpty(this.mName) || !MediaCodecHelp.sCreateCodecBlackList.remove(this.mName)) {
                    return;
                }
                sb = new StringBuilder();
                sb.append("createByCodecName:");
                sb.append(this.mName);
                sb.append(" remove from blacklist");
                DebugLog.i(MgtvMediaCodec.TAG, sb.toString());
            } catch (Throwable th) {
                if (!StringUtil.isEmpty(this.mName) && MediaCodecHelp.sCreateCodecBlackList.remove(this.mName)) {
                    DebugLog.i(MgtvMediaCodec.TAG, "createByCodecName:" + this.mName + " remove from blacklist");
                }
                throw th;
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class FlushRunnable implements Runnable {
        private volatile boolean isFlushing = true;
        private MediaCodec mMediaCodec;

        public FlushRunnable(MediaCodec mediaCodec) {
            this.mMediaCodec = mediaCodec;
        }

        public boolean isFlushing() {
            return this.isFlushing;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mMediaCodec.flush();
            } catch (Exception unused) {
            }
            this.isFlushing = false;
        }
    }

    private MgtvMediaCodec(MediaCodec mediaCodec, String str) throws NullPointerException {
        Objects.requireNonNull(mediaCodec, "MediaCodec is NULL");
        this.mMediaCodec = mediaCodec;
        this.mCodecName = str;
    }

    public static MgtvMediaCodec createByCodecName(String str) throws IOException, NullPointerException {
        MediaCodec mediaCodec;
        if (StringUtil.isEmpty(str) || !MediaCodecHelp.sCreateCodecBlackList.contains(str)) {
            DebugLog.d(TAG, "createByCodecName:" + str + " not in blacklist.try create");
            CreateCodecRunnable createCodecRunnable = new CreateCodecRunnable(str);
            Thread thread = new Thread(createCodecRunnable);
            thread.setName("mgtvmp_jMCCre");
            thread.start();
            try {
                thread.join(1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            MediaCodec mediaCodec2 = createCodecRunnable.getMediaCodec();
            if (mediaCodec2 == null) {
                createCodecRunnable.release();
            }
            mediaCodec = mediaCodec2;
        } else {
            DebugLog.e(TAG, "createByCodecName:" + str + " already in blacklist");
            mediaCodec = null;
        }
        return new MgtvMediaCodec(mediaCodec, str);
    }

    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.mMediaCodec.configure(mediaFormat, surface, mediaCrypto, i);
    }

    public final int dequeueInputBuffer(long j) {
        return this.mMediaCodec.dequeueInputBuffer(j);
    }

    public final int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j) {
        return this.mMediaCodec.dequeueOutputBuffer(bufferInfo, j);
    }

    public final synchronized void flush() {
        if (this.mFlushStatus != 0 || MediaCodecHelp.sFlushCodecBlackList.contains(this.mCodecName)) {
            throw new IllegalStateException("flush timeout");
        }
        FlushRunnable flushRunnable = new FlushRunnable(this.mMediaCodec);
        Thread thread = new Thread(flushRunnable);
        thread.setName("mgtvmp_jMCFlush");
        thread.start();
        try {
            thread.join(1000L);
        } catch (Exception unused) {
        }
        if (flushRunnable.isFlushing) {
            this.mFlushStatus = 1;
            if (!StringUtil.isEmpty(this.mCodecName)) {
                MediaCodecHelp.sFlushCodecBlackList.add(this.mCodecName);
            }
            DebugLog.i(TAG, "flush add into blacklist");
            throw new IllegalStateException("flush timeout");
        }
    }

    public int getFlushStatus() {
        return this.mFlushStatus;
    }

    @TargetApi(21)
    public ByteBuffer getInputBuffer(int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return this.mMediaCodec.getInputBuffer(i);
    }

    public ByteBuffer[] getInputBuffers() {
        return this.mMediaCodec.getInputBuffers();
    }

    @TargetApi(21)
    public ByteBuffer getOutputBuffer(int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return this.mMediaCodec.getOutputBuffer(i);
    }

    public ByteBuffer[] getOutputBuffers() {
        return this.mMediaCodec.getOutputBuffers();
    }

    public final MediaFormat getOutputFormat() {
        return this.mMediaCodec.getOutputFormat();
    }

    @TargetApi(21)
    public Image getOutputImage(int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return this.mMediaCodec.getOutputImage(i);
    }

    public final void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.mMediaCodec.queueInputBuffer(i, i2, i3, j, i4);
    }

    public final void queueSecureInputBuffer(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        this.mMediaCodec.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
    }

    public final void release() {
        DebugLog.i(TAG, "release in");
        this.mMediaCodec.release();
        DebugLog.i(TAG, "release out");
    }

    public final void releaseOutputBuffer(int i, boolean z) {
        this.mMediaCodec.releaseOutputBuffer(i, z);
    }

    @TargetApi(19)
    public void setParameters(Bundle bundle) {
        DebugLog.i(TAG, "setParameters oppo_sr:" + bundle.getInt(OPPO_SR_ENABLE_KEY, -1));
        DebugLog.i(TAG, "setParameters oppo_osie:" + bundle.getInt(OPPO_OSIE_ENABLE_KEY, -1));
        this.mMediaCodec.setParameters(bundle);
    }

    public final void start() {
        this.mMediaCodec.start();
    }

    public final void stop() {
        this.mMediaCodec.stop();
    }
}
