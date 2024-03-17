package com.hunantv.media.drm.strategy;

import android.app.Application;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.drm.cbcs.CbcsDrmManager;
import com.hunantv.media.drm.cbcs.CbcsDrmStrategy;
import com.hunantv.media.drm.cenc.CencDrmManager;
import com.hunantv.media.drm.cenc.CencDrmStrategy;
import com.hunantv.media.drm.wasabi.WasabiDrmManager;
import com.hunantv.media.player.pragma.DebugLog;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class StrategyDrmManager implements IDrmManager {
    private static final String TAG = "StrategyDrmManager";
    private static IDrmManager sInstance;
    private Application application;
    private IDrmManager cbcsDrmManager;
    private IDrmManager currentDrmManager;
    private IDrmManager.InitConfig initConfig;
    private volatile IDrmManager.OnInitListener mOnInitListener;
    private IDrmManager cencDrmManager = CencDrmManager.getInstance();
    private IDrmManager wasabiDrmManager = WasabiDrmManager.getInstance();

    private StrategyDrmManager() {
        IDrmManager cbcsDrmManager = CbcsDrmManager.getInstance();
        this.cbcsDrmManager = cbcsDrmManager;
        if (cbcsDrmManager instanceof CbcsDrmManager) {
            ((CbcsDrmManager) cbcsDrmManager).bindWasabiDrmManager(this.wasabiDrmManager);
        }
        this.currentDrmManager = this.wasabiDrmManager;
    }

    public static synchronized IDrmManager getInstance() {
        IDrmManager iDrmManager;
        synchronized (StrategyDrmManager.class) {
            if (sInstance == null) {
                sInstance = new StrategyDrmManager();
            }
            iDrmManager = sInstance;
        }
        return iDrmManager;
    }

    private void setCurrentInitListener() {
        IDrmManager iDrmManager = this.currentDrmManager;
        if (iDrmManager != null) {
            iDrmManager.setOnInitListener(new IDrmManager.OnInitListener() { // from class: com.hunantv.media.drm.strategy.StrategyDrmManager.1
                @Override // com.hunantv.media.drm.IDrmManager.OnInitListener
                public void onInitError(String str, String str2) {
                    if (StrategyDrmManager.this.mOnInitListener != null) {
                        StrategyDrmManager.this.mOnInitListener.onInitError(str, str2);
                    }
                }

                @Override // com.hunantv.media.drm.IDrmManager.OnInitListener
                public void onInitSuccess() {
                    if (StrategyDrmManager.this.mOnInitListener != null) {
                        StrategyDrmManager.this.mOnInitListener.onInitSuccess();
                    }
                }
            });
        }
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public IDrmSession genDrmSession(IDrmManager.SessionConfig sessionConfig) {
        List<MgtvDrmParams.DrmInfo> list;
        List<MgtvDrmParams.DrmInfo> list2;
        this.currentDrmManager = (sessionConfig == null || !"6".equals(sessionConfig.drmType) || (list2 = sessionConfig.drmInfoList) == null || list2.size() <= 0) ? (sessionConfig == null || !("4".equals(sessionConfig.drmType) || "5".equals(sessionConfig.drmType)) || (list = sessionConfig.drmInfoList) == null || list.size() <= 0) ? this.wasabiDrmManager : this.cencDrmManager : this.cbcsDrmManager;
        DebugLog.i(TAG, "genDrmSession " + sessionConfig);
        if (this.currentDrmManager != null) {
            DebugLog.i(TAG, "genDrmSession currentDrmManager " + this.currentDrmManager.getClass().getSimpleName());
        }
        setCurrentInitListener();
        return this.currentDrmManager.genDrmSession(sessionConfig);
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int getCurrentStatus() {
        return this.currentDrmManager.getCurrentStatus();
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public String getErrorCode() {
        return this.currentDrmManager.getErrorCode();
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public String getVersion() {
        return this.currentDrmManager.getVersion();
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int init(Application application, IDrmManager.InitConfig initConfig) {
        this.application = application;
        this.initConfig = initConfig;
        this.currentDrmManager = (NetPlayConfig.getPreferDrmType() == 6 && CbcsDrmStrategy.isCbcsSupported()) ? this.cbcsDrmManager : (CencDrmStrategy.isCencSupported() && (NetPlayConfig.getPreferDrmType() == 4 || NetPlayConfig.getPreferDrmType() == 5)) ? this.cencDrmManager : this.wasabiDrmManager;
        if (this.currentDrmManager != null) {
            DebugLog.i(TAG, "init currentDrmManager " + this.currentDrmManager.getClass().getSimpleName());
        }
        setCurrentInitListener();
        this.cencDrmManager.init(application, initConfig);
        this.cbcsDrmManager.init(application, initConfig);
        this.wasabiDrmManager.init(application, initConfig);
        return 0;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public boolean isInited() {
        IDrmManager iDrmManager = this.currentDrmManager;
        if (iDrmManager != null) {
            return iDrmManager.isInited();
        }
        return false;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public boolean isIniting() {
        return this.currentDrmManager.isIniting();
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public int release() {
        this.cbcsDrmManager.release();
        this.cencDrmManager.release();
        this.wasabiDrmManager.release();
        return 0;
    }

    @Override // com.hunantv.media.drm.IDrmManager
    public void setOnInitListener(IDrmManager.OnInitListener onInitListener) {
        this.mOnInitListener = onInitListener;
    }
}
