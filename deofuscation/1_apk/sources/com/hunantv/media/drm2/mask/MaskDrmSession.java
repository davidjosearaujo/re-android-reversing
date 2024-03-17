package com.hunantv.media.drm2.mask;

import c.a.a.b.b.b;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmProxy;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.drm.MgtvDrmSession;
import com.hunantv.media.drm2.mask.MaskCoreDrmSession;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.utils.NumericUtil;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MaskDrmSession extends MgtvDrmSession {
    public static final int MAX_ERROR_MSG_SIZE = 100;
    public MaskCoreDrmSession coreSession;
    private int lic = 0;
    private String dpt = "n";
    private int drmType = 10;

    public MaskDrmSession(IDrmManager.SessionConfig sessionConfig) {
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
            MaskCoreDrmSession maskCoreDrmSession = this.coreSession;
            if (maskCoreDrmSession != null) {
                maskCoreDrmSession.close();
                this.coreSession = null;
            }
        }
        return 0;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public IDrmProxy createProxy() {
        return null;
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
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

    public int getFirm() {
        MaskCoreDrmSession maskCoreDrmSession = this.coreSession;
        if (maskCoreDrmSession == null || maskCoreDrmSession.getSelectedDrmInfo() == null) {
            return 0;
        }
        return NumericUtil.parseInt(this.coreSession.getSelectedDrmInfo().drmFirm);
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
        super.publishProvisionError(i);
    }

    @Override // com.hunantv.media.drm.MgtvDrmSession
    public synchronized void publishProvisionSuccess() {
        super.publishProvisionSuccess();
    }

    public void realProvision(byte[] bArr) {
        List<MgtvDrmParams.DrmInfo> list;
        synchronized (this.mSessionLocker) {
            this.sf = 1;
            final long currentTimeMillis = System.currentTimeMillis();
            IDrmManager.SessionConfig sessionConfig = this.mSessionConfig;
            if (sessionConfig == null || (list = sessionConfig.drmInfoList) == null || list.size() <= 0) {
                this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                publishProvisionError(100);
                sendDrmExReport(String.valueOf(100), "error config null", "3", getFirm());
            } else {
                MaskCoreDrmSession maskCoreDrmSession = new MaskCoreDrmSession(bArr, this.mSessionConfig.drmInfoList, new MaskCoreDrmSession.OnDoLicenseListener() { // from class: com.hunantv.media.drm2.mask.MaskDrmSession.1
                    @Override // com.hunantv.media.drm2.mask.MaskCoreDrmSession.OnDoLicenseListener
                    public void onFailed(int i, int i2, String str) {
                        if (str != null && str.length() > 100) {
                            str = str.substring(0, 100);
                        }
                        MaskDrmSession.this.sf = 4;
                        MaskDrmSession maskDrmSession = MaskDrmSession.this;
                        maskDrmSession.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                        MaskDrmSession.this.ec_msg = str;
                        MaskDrmSession.this.error_what = i;
                        DebugLog.e("MaskDrmSession", "realProvision onFailed error=" + i2 + ",msg=" + str);
                        MaskDrmSession.this.publishProvisionError(i2, str);
                        MaskDrmSession.this.sendDrmExReport(String.valueOf(i2), "error request license", "3", MaskDrmSession.this.getFirm());
                    }

                    @Override // com.hunantv.media.drm2.mask.MaskCoreDrmSession.OnDoLicenseListener
                    public void onSuccess(int i) {
                        MaskDrmSession.this.sf = 3;
                        MaskDrmSession.this.lic = i;
                        MaskDrmSession maskDrmSession = MaskDrmSession.this;
                        maskDrmSession.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                        MaskDrmSession maskDrmSession2 = MaskDrmSession.this;
                        maskDrmSession2.sendDrmExReport("0", "", i + "", MaskDrmSession.this.getFirm());
                        MaskDrmSession.this.publishProvisionSuccess();
                    }
                });
                this.coreSession = maskCoreDrmSession;
                this.sf = 2;
                maskCoreDrmSession.bindMediaPlayer(this.mPlayer);
                this.coreSession.autoSelectDrmSolution();
                this.coreSession.doLicense();
            }
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void setDrmLicensePrepared() {
        synchronized (this.mSessionLocker) {
            this.mPlayer.f();
        }
    }
}
