package com.hunantv.media.drm.cbcs;

import android.media.MediaCrypto;
import android.os.Build;
import c.a.a.b.b.b;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmProxy;
import com.hunantv.media.drm.MgtvDrmConstans;
import com.hunantv.media.drm.MgtvDrmParams;
import com.hunantv.media.drm.MgtvDrmSession;
import com.hunantv.media.drm.cbcs.CbcsCoreDrmSession;
import com.hunantv.media.drm.utils.MgtvDrmUtils;
import com.hunantv.media.utils.NumericUtil;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CbcsDrmSession extends MgtvDrmSession {
    public CbcsCoreDrmSession coreSession;
    private IDrmManager wasabiDrmManager;
    private int lic = 0;
    private String dpt = "n";
    private int drmType = 3;

    public CbcsDrmSession(IDrmManager.SessionConfig sessionConfig) {
        this.mSessionConfig = sessionConfig;
    }

    public void bindWasabiDrmManager(IDrmManager iDrmManager) {
        this.wasabiDrmManager = iDrmManager;
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
            CbcsCoreDrmSession cbcsCoreDrmSession = this.coreSession;
            if (cbcsCoreDrmSession != null) {
                cbcsCoreDrmSession.close();
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        if (r0.equals("0") == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0087, code lost:
        if (com.hunantv.media.drm.MgtvDrmConstans.CHINADRM_UUID.equals(r0) != false) goto L13;
     */
    @Override // com.hunantv.media.drm.IDrmSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getDrmt() {
        /*
            r8 = this;
            com.hunantv.media.drm.cbcs.CbcsCoreDrmSession r0 = r8.coreSession
            r1 = 4
            r2 = 3
            r3 = 0
            if (r0 == 0) goto L60
            com.hunantv.media.drm.MgtvDrmParams$DrmInfo r0 = r0.getSelectedDrmInfo()
            if (r0 == 0) goto L8d
            java.lang.String r0 = r0.drmSolution
            r0.hashCode()
            r0.hashCode()
            r4 = -1
            int r5 = r0.hashCode()
            r6 = 2
            r7 = 1
            switch(r5) {
                case 48: goto L4d;
                case 49: goto L1f;
                case 50: goto L42;
                case 51: goto L1f;
                case 52: goto L37;
                case 53: goto L2c;
                case 54: goto L21;
                default: goto L1f;
            }
        L1f:
            r3 = -1
            goto L56
        L21:
            java.lang.String r3 = "6"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L2a
            goto L1f
        L2a:
            r3 = 4
            goto L56
        L2c:
            java.lang.String r3 = "5"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L35
            goto L1f
        L35:
            r3 = 3
            goto L56
        L37:
            java.lang.String r3 = "4"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L40
            goto L1f
        L40:
            r3 = 2
            goto L56
        L42:
            java.lang.String r3 = "2"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L4b
            goto L1f
        L4b:
            r3 = 1
            goto L56
        L4d:
            java.lang.String r5 = "0"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L56
            goto L1f
        L56:
            switch(r3) {
                case 0: goto L5d;
                case 1: goto L73;
                case 2: goto L5a;
                case 3: goto L7e;
                case 4: goto L89;
                default: goto L59;
            }
        L59:
            goto L8d
        L5a:
            r8.drmType = r6
            goto L8d
        L5d:
            r8.drmType = r7
            goto L8d
        L60:
            java.util.UUID[] r0 = com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.getMultiDrmOrder()
            if (r0 == 0) goto L8d
            int r4 = r0.length
            if (r4 <= 0) goto L8d
            r0 = r0[r3]
            java.util.UUID r3 = com.hunantv.media.drm.MgtvDrmConstans.WIDEVINE_UUID
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L76
        L73:
            r8.drmType = r1
            goto L8d
        L76:
            java.util.UUID r1 = com.hunantv.media.drm.MgtvDrmConstans.MARLIN_UUID
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L81
        L7e:
            r8.drmType = r2
            goto L8d
        L81:
            java.util.UUID r1 = com.hunantv.media.drm.MgtvDrmConstans.CHINADRM_UUID
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L8d
        L89:
            r0 = 10
            r8.drmType = r0
        L8d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r8.drmType
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.drm.cbcs.CbcsDrmSession.getDrmt():java.lang.String");
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public String getErrorCode() {
        return this.ec + "";
    }

    public int getFirm() {
        CbcsCoreDrmSession cbcsCoreDrmSession = this.coreSession;
        if (cbcsCoreDrmSession == null || cbcsCoreDrmSession.getSelectedDrmInfo() == null) {
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
        CbcsDrmStrategy.notifyError();
        super.publishProvisionError(i);
    }

    @Override // com.hunantv.media.drm.MgtvDrmSession
    public synchronized void publishProvisionSuccess() {
        CbcsDrmStrategy.notifySuccess();
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
                sendDrmExReport(String.valueOf(100), "error config null", "3", getFirm());
            } else {
                CbcsCoreDrmSession cbcsCoreDrmSession = new CbcsCoreDrmSession(map, this.mSessionConfig.drmInfoList, new CbcsCoreDrmSession.OnDoLicenseListener() { // from class: com.hunantv.media.drm.cbcs.CbcsDrmSession.1
                    @Override // com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.OnDoLicenseListener
                    public void onFailed(int i, String str) {
                        CbcsDrmSession.this.sf = 4;
                        CbcsDrmSession cbcsDrmSession = CbcsDrmSession.this;
                        cbcsDrmSession.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                        CbcsDrmSession.this.ec_msg = str;
                        CbcsDrmSession.this.publishProvisionError(i);
                        CbcsDrmSession.this.sendDrmExReport(String.valueOf(i), "error request license", "3", CbcsDrmSession.this.getFirm());
                    }

                    @Override // com.hunantv.media.drm.cbcs.CbcsCoreDrmSession.OnDoLicenseListener
                    public void onSuccess(int i) {
                        CbcsDrmSession.this.sf = 3;
                        CbcsDrmSession.this.lic = i;
                        CbcsDrmSession cbcsDrmSession = CbcsDrmSession.this;
                        cbcsDrmSession.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                        CbcsDrmSession cbcsDrmSession2 = CbcsDrmSession.this;
                        cbcsDrmSession2.sendDrmExReport("0", "", i + "", CbcsDrmSession.this.getFirm());
                        CbcsDrmSession.this.publishProvisionSuccess();
                    }
                });
                this.coreSession = cbcsCoreDrmSession;
                this.sf = 2;
                cbcsCoreDrmSession.bindMediaPlayer(this.mPlayer);
                this.coreSession.bindWasabiDrmManager(this.wasabiDrmManager);
                this.coreSession.autoSelectDrmSolution();
                this.coreSession.doLicense();
            }
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void setDrmLicensePrepared() {
        synchronized (this.mSessionLocker) {
            CbcsCoreDrmSession cbcsCoreDrmSession = this.coreSession;
            if (cbcsCoreDrmSession != null) {
                try {
                    if (this.mPlayer != null && Build.VERSION.SDK_INT >= 16) {
                        if (MgtvDrmConstans.MARLIN_UUID.equals(cbcsCoreDrmSession.getSelectedUUID())) {
                            this.mPlayer.G2(2);
                        } else if (this.coreSession.getSelectedDrmInfo() == null || !"6".equals(this.coreSession.getSelectedDrmInfo().drmSolution)) {
                            this.mPlayer.F0(new MediaCrypto(this.coreSession.getSelectedUUID(), this.coreSession.getDrmSessionId()));
                        } else {
                            this.mPlayer.G2(3);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
