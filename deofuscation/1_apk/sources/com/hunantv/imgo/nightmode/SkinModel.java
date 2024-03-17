package com.hunantv.imgo.nightmode;

import com.facebook.internal.ServerProtocol;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinModel implements Serializable {
    private static final long serialVersionUID = -5906189890276474957L;
    public boolean isDynamic;
    public String level;
    public String skinId;
    public String skinName;
    public String url;
    public String validTime;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class SKIN_DEFAULT extends SkinModel {
        private static final long serialVersionUID = 2652282407075541996L;

        public SKIN_DEFAULT() {
            super("1", "默认芒果橙", null, "0");
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class SKIN_DEFAULT_NIGHT extends SkinModel {
        private static final long serialVersionUID = -8424742758163805191L;

        public SKIN_DEFAULT_NIGHT() {
            super("2", "默认暗夜黑", null, "0");
        }
    }

    public SkinModel(String str, String str2, String str3, String str4) {
        this.skinId = str;
        this.skinName = str2;
        this.url = str3;
        this.level = str4;
    }

    public static SkinModel fromString(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        boolean z = false;
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                str2 = split[i];
            } else if (i == 1) {
                str3 = split[i];
            } else if (i == 2) {
                str4 = split[i].equals("null") ? null : split[i];
            } else if (i == 3) {
                str5 = split[i].equals("null") ? null : split[i];
            } else if (i == 4) {
                str6 = split[i].equals("null") ? null : split[i];
            } else if (i == 5) {
                z = split[i].equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
        }
        SkinModel skinModel = new SkinModel(str2, str3, str4, str5, str6);
        skinModel.isDynamic = z;
        return skinModel;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == null || !(obj instanceof SkinModel) || (str = ((SkinModel) obj).skinId) == null) {
            return false;
        }
        return str.equals(this.skinId);
    }

    public String getReportString(int i) {
        StringBuilder sb = new StringBuilder();
        if ("2".equals(this.level)) {
            sb.append("skinType=1");
        } else {
            sb.append("skinType=0");
        }
        sb.append("&skinid=");
        sb.append(this.skinId);
        if ("2".equals(this.skinId)) {
            sb.append("&darkType=");
            sb.append(i);
        }
        return sb.toString();
    }

    public int hashCode() {
        return this.skinId.hashCode();
    }

    public boolean isTimeValid() {
        if (!this.level.equals("3") || this.validTime == null) {
            return true;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(this.validTime).after(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
            return true;
        }
    }

    public String toString() {
        return this.skinId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.skinName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.url + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.level + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.validTime + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.isDynamic;
    }

    public SkinModel(String str, String str2, String str3, String str4, String str5) {
        this.skinId = str;
        this.skinName = str2;
        this.url = str3;
        this.level = str4;
        this.validTime = str5;
    }

    public String getReportString() {
        return getReportString(0);
    }

    public SkinModel(String str, String str2, String str3, String str4, boolean z) {
        this.skinId = str;
        this.skinName = str2;
        this.url = str3;
        this.level = str4;
        this.isDynamic = z;
    }
}
