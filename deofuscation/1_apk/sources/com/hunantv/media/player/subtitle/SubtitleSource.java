package com.hunantv.media.player.subtitle;

import android.os.Handler;
import android.os.HandlerThread;
import c.a.a.a.p.c;
import c.a.a.a.p.d;
import c.a.a.b.d.e;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hunantv.media.player.utils.ThreadUtil;
import com.hunantv.media.utils.ByteUtil;
import com.hunantv.media.utils.StreamUtil;
import com.hunantv.media.utils.StringUtil;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SubtitleSource {
    private SubtitleSourceCallback mCallback;
    private String mCharset;
    private byte[] mContent;
    private ErrorResult mErrorResult;
    private MediaFormat mFormat;
    private volatile SubtitleSourceHolder mHolder;
    private InputStream mInputStream;
    private String mPath;
    private volatile boolean mReaded;
    private volatile boolean mReading;
    private volatile boolean mReleased;
    private Object sync;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ErrorResult {
        public static final int ERROR_DEFAULT = -1;
        public static final int ERROR_NOT_ENABLE_MODULE = -2;
        public int code = 0;

        public ErrorResult setCode(int i) {
            this.code = i;
            return this;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface SubtitleSourceCallback {
        void onFailed(int i);

        void onSuccess(d dVar, SubtitleSource subtitleSource);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface SubtitleSourceHolder {
    }

    public SubtitleSource(InputStream inputStream, MediaFormat mediaFormat) {
        this.mCharset = "UTF-8";
        this.sync = new Object();
        this.mErrorResult = new ErrorResult();
        this.mInputStream = inputStream;
        this.mFormat = mediaFormat;
    }

    public SubtitleSource(String str, MediaFormat mediaFormat) {
        this.mCharset = "UTF-8";
        this.sync = new Object();
        this.mErrorResult = new ErrorResult();
        this.mPath = str;
        this.mFormat = mediaFormat;
        this.mInputStream = StreamUtil.createFileInputStream(str);
    }

    public SubtitleSource(byte[] bArr, MediaFormat mediaFormat) {
        this.mCharset = "UTF-8";
        this.sync = new Object();
        this.mErrorResult = new ErrorResult();
        this.mContent = bArr;
        this.mFormat = mediaFormat;
        this.mReaded = true;
    }

    private void asyncReadSource(final d dVar, final SubtitleSource subtitleSource) {
        if (this.mReading) {
            return;
        }
        final HandlerThread handlerThread = new HandlerThread("SubtitleReadThread", 9);
        handlerThread.start();
        this.mReading = true;
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.hunantv.media.player.subtitle.SubtitleSource.1
            private void addTrack() {
                c.c(MessengerShareContentUtility.SUBTITLE, "addTrack in");
                if (subtitleSource == null || dVar == null) {
                    if (SubtitleSource.this.mCallback != null) {
                        SubtitleSource.this.mCallback.onFailed(0);
                        return;
                    }
                    return;
                }
                c.c(MessengerShareContentUtility.SUBTITLE, "before new Scanner");
                if (ByteUtil.isEmpty(subtitleSource.readContentBytes())) {
                    if (SubtitleSource.this.mCallback != null) {
                        SubtitleSource.this.mCallback.onFailed(1);
                    }
                } else if (SubtitleSource.this.mCallback != null) {
                    SubtitleSource.this.mCallback.onSuccess(dVar, subtitleSource);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                addTrack();
                SubtitleSource.this.mReading = false;
                if (SubtitleSource.this.mReleased) {
                    SubtitleSource.this.mCallback = null;
                }
                ThreadUtil.quit(handlerThread.getLooper());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] readContentBytes() {
        if (isValid()) {
            byte[] bArr = this.mContent;
            if (bArr != null) {
                return bArr;
            }
            String readContentStrImpl = readContentStrImpl();
            if (!StringUtil.isSpace(readContentStrImpl)) {
                try {
                    this.mContent = readContentStrImpl.getBytes(getCharset());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (this.mReleased) {
                e.a(this.mInputStream);
            }
            return this.mContent;
        }
        return null;
    }

    private String readContentStrImpl() {
        String next = new Scanner(getInputStream(), getCharset()).useDelimiter("\\A").next();
        this.mReaded = true;
        return next;
    }

    public void bindHolder(SubtitleSourceHolder subtitleSourceHolder) {
        synchronized (this.sync) {
            this.mHolder = subtitleSourceHolder;
        }
    }

    public String getCharset() {
        return this.mCharset;
    }

    public byte[] getContent() {
        return this.mContent;
    }

    public ErrorResult getErrorResult() {
        return this.mErrorResult;
    }

    public MediaFormat getFormat() {
        return this.mFormat;
    }

    public InputStream getInputStream() {
        return this.mInputStream;
    }

    public String getPath() {
        return this.mPath;
    }

    public boolean isBinded() {
        boolean z;
        synchronized (this.sync) {
            z = this.mHolder != null;
        }
        return z;
    }

    public boolean isReading() {
        return this.mReading;
    }

    public boolean isReleased() {
        return this.mReleased;
    }

    public boolean isValid() {
        return (isReleased() || (getInputStream() == null && ByteUtil.isEmpty(this.mContent)) || getFormat() == null) ? false : true;
    }

    public void readSource(d dVar, SubtitleSource subtitleSource) {
        synchronized (this.sync) {
            if (ByteUtil.isEmpty(this.mContent)) {
                asyncReadSource(dVar, subtitleSource);
            } else {
                SubtitleSourceCallback subtitleSourceCallback = this.mCallback;
                if (subtitleSourceCallback != null) {
                    subtitleSourceCallback.onSuccess(dVar, subtitleSource);
                }
            }
        }
    }

    public void release() {
        synchronized (this.sync) {
            this.mReleased = true;
            if (!this.mReading) {
                e.a(this.mInputStream);
                this.mCallback = null;
            }
            this.mInputStream = null;
            this.mReaded = false;
        }
    }

    public void setCallback(SubtitleSourceCallback subtitleSourceCallback) {
        this.mCallback = subtitleSourceCallback;
    }

    public void setCharset(String str) {
        this.mCharset = str;
    }

    public void unBindHolder() {
        synchronized (this.sync) {
            this.mHolder = null;
        }
    }
}
