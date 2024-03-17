package com.hunantv.media.drm.cenc;

import android.media.MediaCrypto;
import android.os.Build;
import c.a.a.a.f;
import c.a.a.b.b.b;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmProxy;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.drm.MgtvDrmSession;
import com.hunantv.media.drm.cenc.CencCoreDrmSession;
import com.hunantv.media.drm.utils.MgtvDrmUtils;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CencDrmSession extends MgtvDrmSession {
    public CencCoreDrmSession coreSession;
    private int lic = 0;
    private String dpt = "n";
    private int drmType = 2;

    public CencDrmSession(IDrmManager.SessionConfig sessionConfig) {
        this.mSessionConfig = sessionConfig;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public int close() {
        synchronized (this.mListenerLocker) {
            this.mRequestClose = true;
            this.mOnProvisionSuccessListenerSet.clear();
            this.mOnProvisionErrorListenerSet.clear();
            this.mOnInfoListenerSet.clear();
        }
        synchronized (this.mSessionLocker) {
            CencCoreDrmSession cencCoreDrmSession = this.coreSession;
            if (cencCoreDrmSession != null) {
                cencCoreDrmSession.close();
                this.coreSession = null;
            }
        }
        return 0;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public IDrmProxy createProxy() {
        return null;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public int getCurrentStatus() {
        return this.mStatus;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public int getDrmType() {
        return this.drmType;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public String getDrmdi() {
        b bVar = new b("__");
        bVar.a("lic", this.lic + "");
        bVar.a("sf", this.sf + "");
        bVar.a("ec", this.ec + "");
        bVar.a("dpt", this.dpt);
        bVar.a("msg", this.ec_msg);
        return bVar.toString();
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public String getDrmt() {
        return this.drmType + "";
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public String getErrorCode() {
        return this.ec + "";
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public boolean provision() {
        return true;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void provisionAsync() {
    }

    @Override // com.hunantv.media.drm.MgtvDrmSession
    public synchronized void publishProvisionError(int i) {
        CencDrmStrategy.notifyError();
        super.publishProvisionError(i);
    }

    @Override // com.hunantv.media.drm.MgtvDrmSession
    public synchronized void publishProvisionSuccess() {
        CencDrmStrategy.notifySuccess();
        super.publishProvisionSuccess();
    }

    public void realProvision(Map<UUID, MgtvDrmUtils.PSSH> map) {
        List<MgtvDrmParams.DrmInfo> list;
        synchronized (this.mSessionLocker) {
            this.sf = 1;
            final long currentTimeMillis = System.currentTimeMillis();
            IDrmManager.SessionConfig sessionConfig = this.mSessionConfig;
            if (sessionConfig == null || (list = sessionConfig.drmInfoList) == null || list.size() <= 0) {
                this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                publishProvisionError(100);
                sendDrmReport(String.valueOf(100), "error config null", "3");
            } else {
                CencCoreDrmSession cencCoreDrmSession = new CencCoreDrmSession(map, this.mSessionConfig.drmInfoList, new CencCoreDrmSession.OnDoLicenseListener() { // from class: com.hunantv.media.drm.cenc.CencDrmSession.1
                    @Override // com.hunantv.media.drm.cenc.CencCoreDrmSession.OnDoLicenseListener
                    public void onFailed(int i, String str) {
                        CencDrmSession.this.sf = 4;
                        CencDrmSession cencDrmSession = CencDrmSession.this;
                        cencDrmSession.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                        CencDrmSession.this.ec_msg = str;
                        CencDrmSession.this.publishProvisionError(i);
                        CencDrmSession.this.sendDrmReport(String.valueOf(i), "error request license", "3");
                    }

                    @Override // com.hunantv.media.drm.cenc.CencCoreDrmSession.OnDoLicenseListener
                    public void onSuccess() {
                        CencDrmSession.this.sf = 3;
                        CencDrmSession cencDrmSession = CencDrmSession.this;
                        cencDrmSession.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                        CencDrmSession.this.sendDrmReport("0", "", "1");
                        CencDrmSession.this.publishProvisionSuccess();
                    }
                });
                this.coreSession = cencCoreDrmSession;
                this.sf = 2;
                cencCoreDrmSession.doLicense();
            }
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void setDrmLicensePrepared() {
        synchronized (this.mSessionLocker) {
            if (this.coreSession != null) {
                try {
                    f fVar = this.mPlayer;
                    if (fVar != null && Build.VERSION.SDK_INT >= 16) {
                        fVar.F0(new MediaCrypto(this.coreSession.getSelectedUUID(), this.coreSession.getDrmSessionId()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
