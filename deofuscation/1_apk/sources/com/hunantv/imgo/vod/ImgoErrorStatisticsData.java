package com.hunantv.imgo.vod;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import j.l.a.b0.l;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;

@Deprecated
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoErrorStatisticsData extends ImgoBaseStatisticsData {
    public static final String AD_RES_PIC = "pic";
    public static final String AD_RES_VIDEO = "video";
    public static final String A_JSON = "01.100001";
    public static final String A_NULL = "01.100002";
    public static final String C_AD = "08.";
    public static final String C_AD_RESOURCE = "09.";
    public static final String C_API = "01.";
    public static final String C_CATCH_EXCEPTION = "03";
    public static final String C_CORE_PLAYER_MGTV = "21.";
    public static final String C_CORE_PLAYER_MGTV_WARN = "22.";
    public static final String C_CRASH = "33";
    public static final String C_DOWNLOAD = "05.";
    public static final String C_LIVE_PLAYER = "06.";
    public static final String C_LOCAL_PLAYER = "07.";
    public static final String C_MID_AD = "15.";
    public static final String C_P2P = "12.";
    public static final String C_PAY = "13.";
    public static final String C_PIC_DOWNLOAD = "10.";
    public static final String C_PRE_AD = "14.";
    public static final String C_PUSH = "04.";
    public static final String C_SO_UPDATE = "11.";
    public static final String C_VOD_PLAYER = "02.";
    public static final String D200002 = "200002";
    public static final String D200003 = "200003";
    public static final String D200004 = "200004";
    public static final String D200005 = "200005";
    public static final String D_PIC = "10.300001";
    public static final String D_VIDEO = "05.100001";
    public static final String D_VIDEOID_NULL = "05.000001";
    public static final String L_200002 = "06.200002";
    public static final String L_200003 = "06.200003";
    public static final String L_200004 = "06.200004";
    public static final String L_200005 = "06.200005";
    public static final String L_300001 = "06.300001";
    public static final String PAY_ERR_4000 = "104000";
    public static final String PAY_ERR_6001 = "106001";
    public static final String PAY_ERR_6002 = "106002";
    public static final String PAY_ERR_8000 = "108000";
    public static final String PAY_ERR_9000 = "109000";
    public static final String P_200001 = "02.200001";
    public static final String P_200002 = "02.200002";
    public static final String P_200003 = "02.200003";
    public static final String P_200004 = "02.200004";
    public static final String P_200005 = "02.200005";
    public static final String P_300001 = "02.300001";
    public static final String STRING_LIVE = "live";
    public static final String STRING_LOCAL = "local";
    public static final String STRING_MID_AD = "midad";
    public static final String STRING_PRE_AD = "pread";
    public static final String STRING_VOD = "vod";
    private static final long serialVersionUID = 8284926213566294904L;
    public String error_code;
    public String error_detail;
    public String error_time = l.n(System.currentTimeMillis());

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        private String a;
        private StringBuilder b = new StringBuilder();
        private boolean c = true;

        public a c(String str) {
            this.a = str;
            return this;
        }

        public a d(String str) {
            return i("errorDesc", str);
        }

        public a e(String str, char c) {
            return i(str, String.valueOf(c));
        }

        public a f(String str, double d) {
            return i(str, String.valueOf(d));
        }

        public a g(String str, int i) {
            return i(str, String.valueOf(i));
        }

        public a h(String str, Object obj) {
            if (obj == null) {
                obj = "null";
            }
            return i(str, String.valueOf(obj));
        }

        public a i(String str, String str2) {
            if (str2 == null) {
                str2 = "null";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "empty";
            }
            if (str2.length() > 10240) {
                str2 = "value is too long";
            }
            try {
                if (this.c) {
                    StringBuilder sb = this.b;
                    sb.append(str + CertificateUtil.DELIMITER + str2);
                    this.c = false;
                } else {
                    StringBuilder sb2 = this.b;
                    sb2.append("____" + str + CertificateUtil.DELIMITER + str2);
                }
            } catch (OutOfMemoryError e) {
                System.gc();
                e.printStackTrace();
            }
            return this;
        }

        public a j(Throwable th) {
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                return i("errorMessage", stringWriter.toString());
            }
            return this;
        }

        public ImgoErrorStatisticsData k() {
            return new ImgoErrorStatisticsData(this);
        }
    }

    public ImgoErrorStatisticsData() {
        setData_type("error");
    }

    public ImgoErrorStatisticsData(String str, int i, String str2, int i2, int i3, String str3) {
        this.error_code = str;
        setData_type("error");
        this.error_detail = "httpCode:" + i + "@response:" + str2 + "@curPosition:" + i2 + "@videoId:" + i3 + "@videoInfo:" + str3;
    }

    public ImgoErrorStatisticsData(String str, String str2, String str3, String str4) {
        this.error_code = str;
        setData_type("error");
        this.error_detail = "url:" + str2 + "@response:" + str3 + "@errorMessage:" + str4;
    }

    public ImgoErrorStatisticsData(String str, String str2, int i, String str3) {
        this.error_code = str;
        setData_type("error");
        this.error_detail = "url:" + str2 + "@videoId:" + i + "@errorMessage:" + str3;
    }

    public ImgoErrorStatisticsData(a aVar) {
        this.error_code = aVar.a;
        this.error_detail = URLEncoder.encode(aVar.b.toString());
        setData_type("error");
    }
}
