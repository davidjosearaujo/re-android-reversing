package com.hunantv.media.drm;

import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.drm.cbcs.CbcsDrmStrategy;
import com.hunantv.media.drm.cenc.CencDrmStrategy;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvDrmParams {
    private static int drmType;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DrmInfo {
        public String drmCid;
        public String drmFirm;
        public String drmSolution;
        public String drmToken;
        public String drmType;
        public String licenseUrl;

        public DrmInfo() {
        }

        public DrmInfo(String str, String str2, String str3) {
            this.drmFirm = str;
            this.drmSolution = str2;
            this.licenseUrl = str3;
        }

        public DrmInfo(String str, String str2, String str3, String str4) {
            this.drmFirm = str;
            this.drmSolution = str2;
            this.licenseUrl = str3;
            this.drmType = str4;
        }

        public DrmInfo(String str, String str2, String str3, String str4, String str5) {
            this.drmFirm = str;
            this.drmSolution = str2;
            this.licenseUrl = str3;
            this.drmCid = str4;
            this.drmToken = str5;
        }

        public DrmInfo setDrmType(String str) {
            this.drmType = str;
            return this;
        }

        public String toString() {
            return "DrmInfo{drmFirm='" + this.drmFirm + "', drmSolution='" + this.drmSolution + "', licenseUrl='" + this.licenseUrl + "', drmCid='" + this.drmCid + "', drmToken='" + this.drmToken + "', drmType='" + this.drmType + "'}";
        }
    }

    public static String getDrmType() {
        drmType = ((CbcsDrmStrategy.isCbcsSupported() && NetPlayConfig.getPreferDrmType() == 6) || (CencDrmStrategy.isCencSupported() && !NetPlayConfig.isDrmProxyEnable() && (NetPlayConfig.getPreferDrmType() == 4 || NetPlayConfig.getPreferDrmType() == 5))) ? NetPlayConfig.getPreferDrmType() : 0;
        return drmType + "";
    }
}
