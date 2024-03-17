package cn.com.custommma.mobile.tracking.viewability.webjs;

import android.view.View;
import cn.com.custommma.mobile.tracking.util.CommonUtil;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbilityJsBean {
    private static final String JSON_ADURL = "adurl";
    private static final String JSON_ADVIEWABILITYID = "AdviewabilityID";
    private static final String JSON_DEVICEMESSAGE = "deviceMessage";
    private static final String JSON_VIEWABILITYMESSAGE = "viewabilityMessage";
    private String adURL;
    private View adView;
    private String adviewabilityId;
    private long timestamp = System.currentTimeMillis();
    private boolean isVideo = false;
    private boolean isCompleted = false;

    public ViewAbilityJsBean(String str, View view) {
        this.adURL = str;
        this.adView = view;
        this.adviewabilityId = CommonUtil.md5(str + this.timestamp);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject generateUploadEvents(android.content.Context r4, boolean r5) {
        /*
            r3 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "adurl"
            java.lang.String r2 = r3.adURL     // Catch: java.lang.Exception -> L4d
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L4d
            java.lang.String r1 = "AdviewabilityID"
            java.lang.String r2 = r3.adviewabilityId     // Catch: java.lang.Exception -> L4d
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L4d
            if (r5 != 0) goto L1f
            android.view.View r5 = r3.adView     // Catch: java.lang.Exception -> L4d
            if (r5 != 0) goto L1a
            goto L1f
        L1a:
            org.json.JSONObject r5 = cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityMessage.getViewAbilityEvents(r4, r5)     // Catch: java.lang.Exception -> L4d
            goto L23
        L1f:
            org.json.JSONObject r5 = cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityMessage.getEmptyViewAbilityEvents(r4)     // Catch: java.lang.Exception -> L4d
        L23:
            java.lang.String r1 = "AdviewabilityType"
            boolean r2 = r3.isVideo     // Catch: java.lang.Exception -> L4d
            if (r2 == 0) goto L2c
            java.lang.String r2 = "1"
            goto L2e
        L2c:
            java.lang.String r2 = "0"
        L2e:
            r5.put(r1, r2)     // Catch: java.lang.Exception -> L4d
            java.lang.String r1 = "viewabilityMessage"
            r0.put(r1, r5)     // Catch: java.lang.Exception -> L4d
            org.json.JSONObject r4 = cn.com.custommma.mobile.tracking.viewability.webjs.DeviceMessage.getDeviceMessage(r4)     // Catch: java.lang.Exception -> L4d
            java.lang.String r5 = "ts"
            long r1 = r3.timestamp     // Catch: java.lang.Exception -> L4d
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L4d
            r4.put(r5, r1)     // Catch: java.lang.Exception -> L4d
            java.lang.String r5 = "deviceMessage"
            r0.put(r5, r4)     // Catch: java.lang.Exception -> L4d
            goto L51
        L4d:
            r4 = move-exception
            r4.printStackTrace()
        L51:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityJsBean.generateUploadEvents(android.content.Context, boolean):org.json.JSONObject");
    }

    public View getAdView() {
        return this.adView;
    }

    public String getAdviewabilityId() {
        return this.adviewabilityId;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void setCompleted(boolean z) {
        this.isCompleted = z;
    }

    public void setVideo(boolean z) {
        this.isVideo = z;
    }

    public String toString() {
        return "[" + this.adviewabilityId + ",URL: " + this.adURL + " ,isVideo:" + this.isVideo + ",isCompleted:" + this.isCompleted + "]";
    }
}
