package com.hunantv.media.drm.cbcs;

import android.app.Application;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;
import com.mgtv.drm.LightPlayDrmManager;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CbcsDrmManager implements IDrmManager {
    public static final String VERSION = "CBCS_1.0";
    private static IDrmManager sInstance;
    private volatile IDrmManager.OnInitListener mOnInitListener;
    private IDrmManager wasabiDrmManager;
    private volatile int mStatus = 0;
    private volatile String mErrorCode = "0";

    private CbcsDrmManager() {
    }

    public static synchronized IDrmManager getInstance() {
        IDrmManager iDrmManager;
        synchronized (CbcsDrmManager.class) {
            if (sInstance == null) {
                sInstance = new CbcsDrmManager();
            }
            iDrmManager = sInstance;
        }
        return iDrmManager;
    }

    public void bindWasabiDrmManager(IDrmManager iDrmManager) {
        this.wasabiDrmManager = iDrmManager;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public IDrmSession genDrmSession(IDrmManager.SessionConfig sessionConfig) {
        CbcsDrmSession cbcsDrmSession = new CbcsDrmSession(sessionConfig);
        cbcsDrmSession.bindWasabiDrmManager(this.wasabiDrmManager);
        return cbcsDrmSession;
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
        String str;
        if (!isInited() && !isIniting()) {
            if (ImgoLibLoader.getInstance().syncTryLoadMgtvDRMLib(application)) {
                str = "LightPlayDrmManager init suc=" + LightPlayDrmManager.getInstance().init();
            } else {
                str = "syncTryLoadMgtvDRMLib failed";
            }
            DebugLog.i("CbcsDrmManager", str);
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
        LightPlayDrmManager.getInstance().release();
        return 0;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public void setOnInitListener(IDrmManager.OnInitListener onInitListener) {
        this.mOnInitListener = onInitListener;
    }
}
