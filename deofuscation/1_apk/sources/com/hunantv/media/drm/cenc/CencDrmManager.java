package com.hunantv.media.drm.cenc;

import android.app.Application;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmSession;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CencDrmManager implements IDrmManager {
    public static final String VERSION = "CENC_1.0";
    private static IDrmManager sInstance;
    private volatile IDrmManager.OnInitListener mOnInitListener;
    private volatile int mStatus = 0;
    private volatile String mErrorCode = "0";

    private CencDrmManager() {
    }

    public static synchronized IDrmManager getInstance() {
        IDrmManager iDrmManager;
        synchronized (CencDrmManager.class) {
            if (sInstance == null) {
                sInstance = new CencDrmManager();
            }
            iDrmManager = sInstance;
        }
        return iDrmManager;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public IDrmSession genDrmSession(IDrmManager.SessionConfig sessionConfig) {
        return new CencDrmSession(sessionConfig);
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int getCurrentStatus() {
        return this.mStatus;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public String getErrorCode() {
        return this.mErrorCode;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public String getVersion() {
        return VERSION;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int init(Application application, IDrmManager.InitConfig initConfig) {
        if (!isInited() && !isIniting()) {
            this.mStatus = 2;
            if (this.mOnInitListener != null) {
                this.mOnInitListener.onInitSuccess();
            }
        }
        return 0;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public boolean isInited() {
        return this.mStatus == 2;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public boolean isIniting() {
        return this.mStatus == 1;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int release() {
        return 0;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public void setOnInitListener(IDrmManager.OnInitListener onInitListener) {
        this.mOnInitListener = onInitListener;
    }
}
