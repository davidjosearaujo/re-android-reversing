package com.hunantv.media.drm.wasabi;

import android.text.TextUtils;
import c.a.a.a.f;
import c.a.a.b.b.b;
import com.hunantv.media.drm.IDrmManager;
import com.hunantv.media.drm.IDrmProxy;
import com.hunantv.media.drm.MgtvDrmErrorCodeException;
import com.hunantv.media.drm.MgtvDrmSession;
import com.hunantv.media.player.pragma.DebugLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class WasabiDrmSession extends MgtvDrmSession {
    private static final int mRightCode = 777;
    private int lic = 0;
    private String dpt = "n";
    private String t2 = "n";
    private String t3 = "n";
    private String t4 = "n";
    private int drmType = 1;

    public WasabiDrmSession(IDrmManager.SessionConfig sessionConfig) {
        this.mSessionConfig = sessionConfig;
    }

    private synchronized int checkLicense(String str, String str2) {
        DebugLog.i(getTag(), "checkLicense in");
        this.sf = 3;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            WasabiDrmRuntime.checkLicense(str);
            this.t3 = ((System.currentTimeMillis() - currentTimeMillis) / 1000) + "";
            this.lic = 0;
            sendDrmReport("0", "", this.lic + "");
            String tag = getTag();
            DebugLog.i(tag, "checkLicense out. res=" + mRightCode);
        } catch (MgtvDrmErrorCodeException unused) {
            int doProcessToken = doProcessToken(str2);
            String tag2 = getTag();
            DebugLog.i(tag2, "checkLicense out. res=" + doProcessToken);
            return doProcessToken;
        }
        return mRightCode;
    }

    private synchronized String decodeToken(String str) {
        String decode;
        try {
            decode = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decode;
    }

    private synchronized int doPersonalize() {
        DebugLog.i(getTag(), "doPersonalize in");
        this.sf = 1;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!WasabiDrmRuntime.isPersonalized()) {
                WasabiDrmRuntime.personalize();
            }
            this.t2 = ((System.currentTimeMillis() - currentTimeMillis) / 1000) + "";
            String tag = getTag();
            DebugLog.i(tag, "doPersonalize out: res=" + mRightCode);
        } catch (MgtvDrmErrorCodeException e) {
            e.printStackTrace();
            int errorCode = e.getErrorCode();
            String tag2 = getTag();
            DebugLog.i(tag2, "doPersonalize out: res=" + errorCode);
            return errorCode;
        }
        return mRightCode;
    }

    private synchronized int doProcessToken(String str) {
        DebugLog.i(getTag(), "doProcessToken in");
        this.sf = 2;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            WasabiDrmRuntime.processServiceToken(str);
            this.t4 = ((System.currentTimeMillis() - currentTimeMillis) / 1000) + "";
            this.lic = 1;
            sendDrmReport("0", "", this.lic + "");
            String tag = getTag();
            DebugLog.i(tag, "doProcessToken out. res=" + mRightCode);
        } catch (MgtvDrmErrorCodeException e) {
            e.printStackTrace();
            int errorCode = e.getErrorCode();
            String tag2 = getTag();
            DebugLog.i(tag2, "doProcessToken out. res=" + errorCode);
            return errorCode;
        }
        return mRightCode;
    }

    private String getTag() {
        return "[WasabiDrmSession-" + hashCode() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean provisionImpl() {
        String tag;
        StringBuilder sb;
        String tag2;
        StringBuilder sb2;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                String tag3 = getTag();
                DebugLog.i(tag3, "provisionImpl in. info:-" + WasabiDrmManager.getInstance().getCurrentStatus() + "-" + WasabiDrmManager.getInstance().getErrorCode());
                this.isProvisionDone = false;
            } catch (Exception unused) {
                publishProvisionError(102);
                sendDrmReport(String.valueOf(102), "", "3");
                this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                tag = getTag();
                sb = new StringBuilder();
            }
            if (this.mSessionConfig == null) {
                publishProvisionError(100);
                sendDrmReport(String.valueOf(100), "config null", "3");
                this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                tag2 = getTag();
                sb2 = new StringBuilder();
            } else if (WasabiDrmManager.getInstance().syncInitRuntime() != 0) {
                publishProvisionError(103);
                sendDrmReport(String.valueOf(103), "drm manager not inited", "3");
                this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                tag2 = getTag();
                sb2 = new StringBuilder();
            } else if (this.mRequestClose) {
                DebugLog.i(getTag(), "drm session close return");
                this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                tag2 = getTag();
                sb2 = new StringBuilder();
            } else {
                DebugLog.i(getTag(), "drm session check init ok");
                IDrmManager.SessionConfig sessionConfig = this.mSessionConfig;
                String str = sessionConfig.drmToken;
                String str2 = sessionConfig.drmCid;
                if (sessionConfig.tokenNeedDecode) {
                    str = decodeToken(str);
                }
                if (!TextUtils.isEmpty(str)) {
                    int doPersonalize = doPersonalize();
                    if (doPersonalize == -55201 || doPersonalize == -55202) {
                        int doPersonalize2 = doPersonalize();
                        if (doPersonalize2 != mRightCode) {
                            publishProvisionError(doPersonalize2);
                            sendDrmReport(String.valueOf(doPersonalize2), "personalize error", "3");
                            this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                            tag = getTag();
                            sb = new StringBuilder();
                            sb.append("provisionImpl out. ");
                            sb.append(this.mStatus);
                            sb.append("-");
                            sb.append(this.ec);
                            sb.append(",dpt:");
                            sb.append(this.dpt);
                            DebugLog.i(tag, sb.toString());
                            this.isProvisionDone = true;
                            return false;
                        }
                    } else if (doPersonalize != mRightCode) {
                        publishProvisionError(doPersonalize);
                        sendDrmReport(String.valueOf(doPersonalize), "personalize error", "3");
                        this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                        tag = getTag();
                        sb = new StringBuilder();
                        sb.append("provisionImpl out. ");
                        sb.append(this.mStatus);
                        sb.append("-");
                        sb.append(this.ec);
                        sb.append(",dpt:");
                        sb.append(this.dpt);
                        DebugLog.i(tag, sb.toString());
                        this.isProvisionDone = true;
                        return false;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        int doProcessToken = doProcessToken(str);
                        if (doProcessToken == -55201 || doProcessToken == -55202) {
                            int doProcessToken2 = doProcessToken(str);
                            if (doProcessToken2 != mRightCode) {
                                publishProvisionError(doProcessToken2);
                                sendDrmReport(String.valueOf(doProcessToken2), "processToken error", "3");
                                this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                                tag = getTag();
                                sb = new StringBuilder();
                                sb.append("provisionImpl out. ");
                                sb.append(this.mStatus);
                                sb.append("-");
                                sb.append(this.ec);
                                sb.append(",dpt:");
                                sb.append(this.dpt);
                                DebugLog.i(tag, sb.toString());
                                this.isProvisionDone = true;
                                return false;
                            }
                        } else if (doProcessToken != mRightCode) {
                            publishProvisionError(doProcessToken);
                            sendDrmReport(String.valueOf(doProcessToken), "processToken error", "3");
                            this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                            tag = getTag();
                            sb = new StringBuilder();
                            sb.append("provisionImpl out. ");
                            sb.append(this.mStatus);
                            sb.append("-");
                            sb.append(this.ec);
                            sb.append(",dpt:");
                            sb.append(this.dpt);
                            DebugLog.i(tag, sb.toString());
                            this.isProvisionDone = true;
                            return false;
                        }
                    } else {
                        int checkLicense = checkLicense(str2, str);
                        if (checkLicense != mRightCode) {
                            publishProvisionError(checkLicense);
                            sendDrmReport(String.valueOf(checkLicense), "", "0");
                            this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                            tag = getTag();
                            sb = new StringBuilder();
                            sb.append("provisionImpl out. ");
                            sb.append(this.mStatus);
                            sb.append("-");
                            sb.append(this.ec);
                            sb.append(",dpt:");
                            sb.append(this.dpt);
                            DebugLog.i(tag, sb.toString());
                            this.isProvisionDone = true;
                            return false;
                        }
                    }
                    publishProvisionSuccess();
                    return true;
                }
                publishProvisionError(101);
                sendDrmReport(String.valueOf(101), "token null", "3");
                this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
                tag2 = getTag();
                sb2 = new StringBuilder();
            }
            sb2.append("provisionImpl out. ");
            sb2.append(this.mStatus);
            sb2.append("-");
            sb2.append(this.ec);
            sb2.append(",dpt:");
            sb2.append(this.dpt);
            DebugLog.i(tag2, sb2.toString());
            this.isProvisionDone = true;
            return false;
        } finally {
            this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
            String tag4 = getTag();
            DebugLog.i(tag4, "provisionImpl out. " + this.mStatus + "-" + this.ec + ",dpt:" + this.dpt);
            this.isProvisionDone = true;
        }
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public synchronized int close() {
        DebugLog.i(getTag(), "close in");
        synchronized (this.mListenerLocker) {
            this.mRequestClose = true;
            this.mOnProvisionSuccessListenerSet.clear();
            this.mOnProvisionErrorListenerSet.clear();
            this.mOnInfoListenerSet.clear();
        }
        DebugLog.i(getTag(), "close out");
        return 0;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public IDrmProxy createProxy() {
        return new WasabiDrmProxy();
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
        bVar.a("ec", this.ec + "_" + WasabiDrmManager.getInstance().getErrorCode());
        bVar.a("dpt", this.dpt);
        bVar.a("t1", WasabiDrmManager.getInstance().getT1());
        bVar.a("t2", this.t2);
        bVar.a("t3", this.t3);
        bVar.a("t4", this.t4);
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

    public int getLic() {
        return this.lic;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public synchronized boolean provision() {
        long currentTimeMillis = System.currentTimeMillis();
        DebugLog.i(getTag(), "provision in");
        if (this.mStatus != 0) {
            DebugLog.i(getTag(), "provision out status not right. return");
            return false;
        }
        this.mStatus = 1;
        boolean provisionImpl = provisionImpl();
        this.dpt = (System.currentTimeMillis() - currentTimeMillis) + "";
        String tag = getTag();
        DebugLog.i(tag, "provision out dpt:" + this.dpt);
        return provisionImpl;
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void provisionAsync() {
        String tag;
        String str;
        DebugLog.i(getTag(), "provisionAsync in");
        if (this.mStatus != 0) {
            tag = getTag();
            str = "provisionAsync status not right. return";
        } else {
            this.mStatus = 1;
            Thread thread = new Thread(new Runnable() { // from class: com.hunantv.media.drm.wasabi.WasabiDrmSession.1
                @Override // java.lang.Runnable
                public void run() {
                    WasabiDrmSession.this.provisionImpl();
                }
            });
            thread.setName("mgtvmp_jDrmPrvs");
            thread.start();
            tag = getTag();
            str = "provisionAsync out";
        }
        DebugLog.i(tag, str);
    }

    @Override // com.hunantv.media.drm.IDrmSession
    public void setDrmLicensePrepared() {
        f fVar = this.mPlayer;
        if (fVar != null) {
            fVar.f();
        }
    }
}
