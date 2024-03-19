package com.hunantv.media.drm2.mask;

import android.app.Application;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;
import com.mgtv.drm.LightPlayDrmManager;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MaskDrmManager implements IDrmManager {
    public static final String VERSION = "MASK_1.0";
    private static IDrmManager sInstance;
    private volatile IDrmManager.OnInitListener mOnInitListener;
    private volatile int mStatus = 0;
    private volatile String mErrorCode = "0";
    private Object mSyncLocker = new Object();

    private MaskDrmManager() {
    }

    public static synchronized IDrmManager getInstance() {
        IDrmManager iDrmManager;
        synchronized (MaskDrmManager.class) {
            if (sInstance == null) {
                sInstance = new MaskDrmManager();
            }
            iDrmManager = sInstance;
        }
        return iDrmManager;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public IDrmSession genDrmSession(IDrmManager.SessionConfig sessionConfig) {
        MaskDrmSession maskDrmSession;
        synchronized (this.mSyncLocker) {
            maskDrmSession = new MaskDrmSession(sessionConfig);
        }
        return maskDrmSession;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int getCurrentStatus() {
        int i;
        synchronized (this.mSyncLocker) {
            i = this.mStatus;
        }
        return i;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public String getErrorCode() {
        String str;
        synchronized (this.mSyncLocker) {
            str = this.mErrorCode;
        }
        return str;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public String getVersion() {
        return VERSION;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int init(Application application, IDrmManager.InitConfig initConfig) {
        String str;
        String str2;
        synchronized (this.mSyncLocker) {
            if (!isInited() && !isIniting()) {
                boolean syncTryLoadMgtvDRMLib = ImgoLibLoader.getInstance().syncTryLoadMgtvDRMLib(application);
                if (syncTryLoadMgtvDRMLib) {
                    syncTryLoadMgtvDRMLib = LightPlayDrmManager.getInstance().initBuilder();
                    str = "MaskDrmManager";
                    str2 = "LightPlayDrmManager init suc=" + syncTryLoadMgtvDRMLib;
                } else {
                    str = "MaskDrmManager";
                    str2 = "syncTryLoadMgtvDRMLib failed";
                }
                DebugLog.i(str, str2);
                if (syncTryLoadMgtvDRMLib) {
                    this.mStatus = 2;
                    if (this.mOnInitListener != null) {
                        this.mOnInitListener.onInitSuccess();
                    }
                    return 0;
                }
                DebugLog.i("MaskDrmManager", "MaskDrmManager init failed");
                if (this.mOnInitListener != null) {
                    this.mOnInitListener.onInitError("400275", "");
                }
                return -1;
            }
            return 0;
        }
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public boolean isInited() {
        boolean z;
        synchronized (this.mSyncLocker) {
            z = this.mStatus == 2;
        }
        return z;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public boolean isIniting() {
        boolean z;
        synchronized (this.mSyncLocker) {
            z = true;
            if (this.mStatus != 1) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int release() {
        synchronized (this.mSyncLocker) {
            LightPlayDrmManager.getInstance().release();
        }
        return 0;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public void setOnInitListener(IDrmManager.OnInitListener onInitListener) {
        synchronized (this.mSyncLocker) {
            this.mOnInitListener = onInitListener;
        }
    }
}
