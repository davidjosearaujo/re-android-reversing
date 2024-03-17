package com.hunantv.media.drm;

import c.a.a.a.f;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.player.MgtvMediaPlayer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class MgtvDrmSession implements IDrmSession {
    public IDrmSession.OnReportListener mOnReportListener;
    public f mPlayer;
    public IDrmManager.SessionConfig mSessionConfig;
    public volatile boolean isProvisionDone = false;
    public volatile int mStatus = 0;
    public Set<IDrmSession.OnProvisionSuccessListener> mOnProvisionSuccessListenerSet = Collections.synchronizedSet(new HashSet());
    public Set<IDrmSession.OnProvisionErrorListener> mOnProvisionErrorListenerSet = Collections.synchronizedSet(new HashSet());
    public Set<IDrmSession.OnInfoListener> mOnInfoListenerSet = Collections.synchronizedSet(new HashSet());
    public Object mListenerLocker = new Object();
    public Object mSessionLocker = new Object();
    public volatile boolean mRequestClose = false;
    public int ec = 0;
    public int sf = 0;
    public String ec_msg = "";
    public int error_what = MgtvMediaPlayer.MGTVMEDIA_ERROR_400802;
    public boolean isInnerSession = false;

    @Override // com.hunantv.media.drm.IDrmSession
    public void addOnInfoListener(IDrmSession.OnInfoListener onInfoListener) {
        synchronized (this.mListenerLocker) {
            if (this.mRequestClose) {
                return;
            }
            this.mOnInfoListenerSet.add(onInfoListener);
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void addOnProvisionErrorListener(IDrmSession.OnProvisionErrorListener onProvisionErrorListener) {
        synchronized (this.mListenerLocker) {
            if (this.mRequestClose) {
                return;
            }
            this.mOnProvisionErrorListenerSet.add(onProvisionErrorListener);
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void addOnProvisionSuccessListener(IDrmSession.OnProvisionSuccessListener onProvisionSuccessListener) {
        synchronized (this.mListenerLocker) {
            if (this.mRequestClose) {
                return;
            }
            this.mOnProvisionSuccessListenerSet.add(onProvisionSuccessListener);
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void bind(f fVar) {
        this.mPlayer = fVar;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public int getErrorWhat() {
        return this.error_what;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public IDrmManager.SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public boolean isInnerSession() {
        return this.isInnerSession;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public boolean isProvisionDone() {
        return this.isProvisionDone;
    }

    public synchronized void publishProvisionError(int i) {
        publishProvisionError(i, "");
    }

    public synchronized void publishProvisionError(int i, String str) {
        synchronized (this.mListenerLocker) {
            this.mStatus = 3;
            this.ec = i;
            this.ec_msg = str;
            for (IDrmSession.OnProvisionErrorListener onProvisionErrorListener : this.mOnProvisionErrorListenerSet) {
                if (onProvisionErrorListener != null) {
                    onProvisionErrorListener.onError(this, i, str);
                }
            }
        }
    }

    public synchronized void publishProvisionSuccess() {
        this.sf = 4;
        synchronized (this.mListenerLocker) {
            this.mStatus = 2;
            for (IDrmSession.OnProvisionSuccessListener onProvisionSuccessListener : this.mOnProvisionSuccessListenerSet) {
                if (onProvisionSuccessListener != null) {
                    onProvisionSuccessListener.onSuccess(this);
                }
            }
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void removeOnInfoListener(IDrmSession.OnInfoListener onInfoListener) {
        synchronized (this.mListenerLocker) {
            this.mOnInfoListenerSet.remove(onInfoListener);
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void removeOnProvisionErrorListener(IDrmSession.OnProvisionErrorListener onProvisionErrorListener) {
        synchronized (this.mListenerLocker) {
            this.mOnProvisionErrorListenerSet.remove(onProvisionErrorListener);
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void removeOnProvisionSuccessListener(IDrmSession.OnProvisionSuccessListener onProvisionSuccessListener) {
        synchronized (this.mListenerLocker) {
            this.mOnProvisionSuccessListenerSet.remove(onProvisionSuccessListener);
        }
    }

    public synchronized void sendDrmExReport(String str, String str2, String str3, int i) {
        IDrmSession.OnReportListener onReportListener = this.mOnReportListener;
        if (onReportListener != null) {
            onReportListener.onExReport(str, str2, str3, i);
        }
    }

    public synchronized void sendDrmReport(String str, String str2, String str3) {
        IDrmSession.OnReportListener onReportListener = this.mOnReportListener;
        if (onReportListener != null) {
            onReportListener.onReport(str, str2, str3);
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void setIsInnerSession(boolean z) {
        this.isInnerSession = z;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void setOnReportListener(IDrmSession.OnReportListener onReportListener) {
        this.mOnReportListener = onReportListener;
    }
}
