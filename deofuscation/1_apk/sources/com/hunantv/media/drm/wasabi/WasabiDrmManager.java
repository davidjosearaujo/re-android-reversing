package com.hunantv.media.drm.wasabi;

import android.app.Application;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmErrorCodeException;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.player.utils.FileUtil;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class WasabiDrmManager implements IDrmManager {
    private static final int OK = 0;
    private static final String TAG = "WasabiDrmManager";
    public static Object mInitLocker = new Object();
    private static WasabiDrmManager sInstance;
    private static String sVersion;
    private Application mApplication;
    private IDrmManager.InitConfig mInitConfig;
    private volatile IDrmManager.OnInitListener mOnInitListener;
    private volatile int mStatus = 0;
    private volatile String mErrorCode = "0";
    private int mRetryIndex = 0;
    private String t1 = "n";
    private boolean isRuntimeInited = false;

    private WasabiDrmManager() {
    }

    public static synchronized WasabiDrmManager getInstance() {
        WasabiDrmManager wasabiDrmManager;
        synchronized (WasabiDrmManager.class) {
            if (sInstance == null) {
                sInstance = new WasabiDrmManager();
            }
            wasabiDrmManager = sInstance;
        }
        return wasabiDrmManager;
    }

    private void gotoError() {
        gotoError("-1");
    }

    private void gotoError(String str) {
        DebugLog.i(TAG, "initRuntime gotoError. ec=" + str);
        this.mStatus = 3;
        this.mErrorCode = str;
        if (this.mOnInitListener != null) {
            this.mOnInitListener.onInitError(str, "");
        }
    }

    private void gotoSuccess() {
        DebugLog.i(TAG, "initRuntime gotoSuccess.");
        this.mStatus = 2;
        if (this.mOnInitListener != null) {
            this.mOnInitListener.onInitSuccess();
        }
    }

    private int initRuntime() {
        Boolean bool;
        if (this.mInitConfig == null) {
            return -10;
        }
        try {
            if (NetPlayConfig.getConfigDRMRootOK() != 1) {
                if (NetPlayConfig.getConfigDRMRootOK() != 2) {
                    if (this.mInitConfig.enableRoot) {
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    WasabiDrmRuntime.initialize(this.mInitConfig.initDirPath);
                    this.t1 = ((System.currentTimeMillis() - currentTimeMillis) / 1000) + "";
                    DebugLog.i(TAG, "initRuntime complete. " + WasabiDrmSdkInfo.getVersionMsg() + "/" + WasabiDrmRuntime.getKeySpace());
                    this.isRuntimeInited = true;
                    return 0;
                }
                bool = Boolean.FALSE;
                WasabiDrmRuntime.setProperty(5, bool);
                long currentTimeMillis2 = System.currentTimeMillis();
                WasabiDrmRuntime.initialize(this.mInitConfig.initDirPath);
                this.t1 = ((System.currentTimeMillis() - currentTimeMillis2) / 1000) + "";
                DebugLog.i(TAG, "initRuntime complete. " + WasabiDrmSdkInfo.getVersionMsg() + "/" + WasabiDrmRuntime.getKeySpace());
                this.isRuntimeInited = true;
                return 0;
            }
            bool = Boolean.TRUE;
            WasabiDrmRuntime.setProperty(5, bool);
            long currentTimeMillis22 = System.currentTimeMillis();
            WasabiDrmRuntime.initialize(this.mInitConfig.initDirPath);
            this.t1 = ((System.currentTimeMillis() - currentTimeMillis22) / 1000) + "";
            DebugLog.i(TAG, "initRuntime complete. " + WasabiDrmSdkInfo.getVersionMsg() + "/" + WasabiDrmRuntime.getKeySpace());
            this.isRuntimeInited = true;
            return 0;
        } catch (MgtvDrmErrorCodeException e) {
            DebugLog.i(TAG, "initRuntime MgtvDrmErrorCodeException : " + (e.getErrorCode() + e.getMessage()));
            e.printStackTrace();
            int errorCode = e.getErrorCode();
            int i = this.mRetryIndex;
            if (i == 0 && (errorCode == -55003 || errorCode == -55004 || errorCode == -55005 || errorCode == -55007)) {
                this.mRetryIndex = i + 1;
                try {
                    DebugLog.i(TAG, "initRuntime errorCode : " + errorCode + " goto retry");
                    WasabiDrmRuntime.shutdown();
                    FileUtil.deleteDir(this.mInitConfig.initDirPath);
                    initRuntime();
                    return -1;
                } catch (MgtvDrmErrorCodeException e2) {
                    e2.printStackTrace();
                    return e2.getErrorCode();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return -1;
                }
            }
            return errorCode;
        } catch (Error e4) {
            e4.printStackTrace();
            return -1;
        } catch (NullPointerException e5) {
            DebugLog.i(TAG, "initRuntime NullPointerException");
            e5.printStackTrace();
            return -11;
        }
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public IDrmSession genDrmSession(IDrmManager.SessionConfig sessionConfig) {
        return new WasabiDrmSession(sessionConfig);
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int getCurrentStatus() {
        return this.mStatus;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public String getErrorCode() {
        return this.mErrorCode;
    }

    public String getT1() {
        return this.t1;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public String getVersion() {
        if (this.isRuntimeInited) {
            try {
                if (sVersion == null) {
                    sVersion = WasabiDrmSdkInfo.getVersion() + "";
                }
                return sVersion;
            } catch (Exception e) {
                e.printStackTrace();
                return "-1";
            } catch (Throwable th) {
                th.printStackTrace();
                return "-2";
            }
        }
        return "0";
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public synchronized int init(Application application, IDrmManager.InitConfig initConfig) {
        int i;
        if (isInited() || isIniting()) {
            DebugLog.d(TAG, "invalid init. inited=" + isInited() + ",initing=" + isIniting());
            i = -2;
        } else if (application == null) {
            i = -3;
        } else {
            this.mApplication = application;
            this.mStatus = 1;
            this.mInitConfig = initConfig;
            if (ImgoLibLoader.getInstance().syncTryLoadDrmLib(this.mApplication)) {
                gotoSuccess();
            } else {
                gotoError();
            }
            i = 0;
        }
        return i;
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
    public synchronized void setOnInitListener(IDrmManager.OnInitListener onInitListener) {
        this.mOnInitListener = onInitListener;
    }

    public int syncInitRuntime() {
        synchronized (mInitLocker) {
            if (this.isRuntimeInited) {
                return 0;
            }
            DebugLog.i(TAG, "initRuntime in");
            int initRuntime = initRuntime();
            DebugLog.i(TAG, "initRuntime out ret=" + initRuntime);
            return initRuntime;
        }
    }
}
