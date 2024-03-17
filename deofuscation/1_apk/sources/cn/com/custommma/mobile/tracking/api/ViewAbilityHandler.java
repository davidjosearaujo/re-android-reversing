package cn.com.custommma.mobile.tracking.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import cn.com.custommma.mobile.tracking.bean.Argument;
import cn.com.custommma.mobile.tracking.bean.Company;
import cn.com.custommma.mobile.tracking.bean.SDK;
import cn.com.custommma.mobile.tracking.bean.ViewAbility;
import cn.com.custommma.mobile.tracking.util.CommonUtil;
import cn.com.custommma.mobile.tracking.util.DeviceInfoUtil;
import cn.com.custommma.mobile.tracking.util.Logger;
import cn.com.custommma.mobile.tracking.util.SdkConfigUpdateUtil;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityEventListener;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityService;
import cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats;
import cn.com.custommma.mobile.tracking.viewability.origin.sniffer.ViewAbilityConfig;
import cn.com.custommma.mobile.tracking.viewability.webjs.ViewAbilityJsService;
import java.util.HashMap;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbilityHandler {
    private ViewAbilityConfig abilityConfig = initViewAbilityGlobalConfig();
    private Context context;
    private HashMap<String, String> impressions;
    private ViewAbilityEventListener mmaSdkCallback;
    private SDK sdkConfig;
    private ViewAbilityJsService viewAbilityJsService;
    private ViewAbilityService viewAbilityService;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum MonitorType {
        CLICK,
        EXPOSE,
        EXPOSEWITHABILITY,
        VIDEOEXPOSEWITHABILITY
    }

    public ViewAbilityHandler(Context context, ViewAbilityEventListener viewAbilityEventListener, SDK sdk) {
        this.impressions = null;
        this.context = context;
        this.mmaSdkCallback = viewAbilityEventListener;
        this.impressions = new HashMap<>();
        this.sdkConfig = sdk;
        this.viewAbilityService = new ViewAbilityService(context, viewAbilityEventListener, this.abilityConfig);
        this.viewAbilityJsService = new ViewAbilityJsService(context);
    }

    private boolean checkViewAbilityEnabled(ViewAbilityStats viewAbilityStats, String str) throws Exception {
        String[] split = str.split(viewAbilityStats.getSeparator());
        String str2 = viewAbilityStats.get(ViewAbilityStats.ADVIEWABILITY_ENABLE);
        if (!TextUtils.isEmpty(str2)) {
            String str3 = str2 + viewAbilityStats.getEqualizer();
            for (String str4 : split) {
                if (str4.startsWith(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0018 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String filterIdentifiers(cn.com.custommma.mobile.tracking.bean.Company r12, cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.api.ViewAbilityHandler.filterIdentifiers(cn.com.custommma.mobile.tracking.bean.Company, cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats, java.lang.String):java.lang.String");
    }

    private static String generateImpressionID(Context context, String str) {
        try {
            String macAddress = DeviceInfoUtil.getMacAddress(context);
            String imei = DeviceInfoUtil.getImei(context);
            String androidId = DeviceInfoUtil.getAndroidId(context);
            String valueOf = String.valueOf(System.currentTimeMillis());
            return CommonUtil.md5(imei + androidId + macAddress + str + valueOf);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getAdAreaID(Company company, String str) throws Exception {
        String[] split;
        String adAreaIdentifier = getAdAreaIdentifier(company);
        for (String str2 : str.split(company.separator)) {
            if (str2.startsWith(adAreaIdentifier)) {
                return str2.replaceFirst(adAreaIdentifier + company.equalizer, "");
            }
        }
        return "";
    }

    private String getAdAreaIdentifier(Company company) throws Exception {
        Argument argument;
        HashMap<String, Argument> hashMap = company.config.adplacements;
        return (hashMap == null || (argument = hashMap.get(ViewAbilityStats.ADPLACEMENT)) == null) ? "" : argument.value;
    }

    private Company getCompany(String str) {
        SDK sdk = this.sdkConfig;
        if (sdk != null && sdk.companies != null) {
            String hostURL = CommonUtil.getHostURL(str);
            for (Company company : this.sdkConfig.companies) {
                if (hostURL.endsWith(company.domain.url)) {
                    return company;
                }
            }
            return null;
        }
        this.sdkConfig = SdkConfigUpdateUtil.getSDKConfig(this.context);
        return null;
    }

    private String getImpressionID(Company company, MonitorType monitorType, String str) throws Exception {
        String str2 = company.domain.url + str;
        if (monitorType == MonitorType.CLICK) {
            for (String str3 : this.impressions.keySet()) {
                if (str2.equals(str3)) {
                    return this.impressions.get(str3);
                }
            }
            return "";
        }
        String generateImpressionID = generateImpressionID(this.context, str);
        this.impressions.put(str2, generateImpressionID);
        return generateImpressionID;
    }

    private String getRedirectIdentifier(Company company) {
        List<Argument> list = company.config.arguments;
        if (list != null) {
            for (Argument argument : list) {
                if (argument != null && !TextUtils.isEmpty(argument.key) && argument.key.equals(Constant.REDIRECTURL)) {
                    return argument.value;
                }
            }
        }
        return "u";
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x01ec, code lost:
        r14.setViewabilityTrackPolicy(r5.sswitch.viewabilityTrackPolicy);
        r14.setURLExposeDuration(r0);
        r14.setURLShowCoverRate(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01fb, code lost:
        if (r22 != cn.com.custommma.mobile.tracking.api.ViewAbilityHandler.MonitorType.VIDEOEXPOSEWITHABILITY) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01fd, code lost:
        r14.setVideoExpose(true);
        r14.setVideoPlayType(r24);
        r14.setURLVideoDuration(r0);
        r14.setURLVideoProgressTracks(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x020c, code lost:
        r13.append(filterIdentifiers(r5, r14, r0));
        r13.append(r2);
        r2 = new java.lang.StringBuffer();
        r2.append(r13);
        r4 = r14.get(cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats.ADVIEWABILITY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0228, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x022a, code lost:
        r13.append(r5.separator + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x023e, code lost:
        r4 = r14.get(cn.com.custommma.mobile.tracking.viewability.origin.ViewAbilityStats.ADVIEWABILITY_RESULT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0248, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x024a, code lost:
        if (r23 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x024c, code lost:
        r13.append(r5.separator + r4 + r5.equalizer + "0");
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0268, code lost:
        if (r23 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x026c, code lost:
        if ((r23 instanceof android.view.View) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x026e, code lost:
        r4 = r5.separator + r7 + r5.equalizer + "1";
        r13.append(r4);
        r2.append(r4);
        r8 = r5.domain.url + r15;
        r4 = r20.viewAbilityService;
        r5 = r2.toString();
        r2 = r19;
        r4.addViewAbilityMonitor(r5, r23, r19, r8, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02b1, code lost:
        r2 = r19;
        cn.com.custommma.mobile.tracking.util.Logger.w("监测链接传入的AdView为空,以正常曝光方式监测.");
     */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e4 A[Catch: Exception -> 0x03b5, TRY_LEAVE, TryCatch #1 {Exception -> 0x03b5, blocks: (B:103:0x00aa, B:105:0x00d0, B:107:0x00f0, B:110:0x0104, B:113:0x010a, B:115:0x0124, B:118:0x012a, B:125:0x01ab, B:127:0x01b1, B:148:0x02dd, B:150:0x02e4, B:128:0x01e1, B:119:0x0153, B:122:0x017f, B:124:0x0183, B:131:0x01ec, B:133:0x01fd, B:134:0x020c, B:136:0x022a, B:137:0x023e, B:140:0x024c, B:142:0x026a, B:144:0x026e, B:145:0x02b1, B:146:0x02ba), top: B:158:0x00aa }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handlerOriginURL(java.lang.String r21, cn.com.custommma.mobile.tracking.api.ViewAbilityHandler.MonitorType r22, android.view.View r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 963
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.api.ViewAbilityHandler.handlerOriginURL(java.lang.String, cn.com.custommma.mobile.tracking.api.ViewAbilityHandler$MonitorType, android.view.View, int, int):void");
    }

    private ViewAbilityConfig initViewAbilityGlobalConfig() {
        ViewAbility viewAbility;
        ViewAbilityConfig viewAbilityConfig = new ViewAbilityConfig();
        try {
            SDK sdk = this.sdkConfig;
            if (sdk != null && (viewAbility = sdk.viewAbility) != null) {
                viewAbilityConfig.setInspectInterval(viewAbility.intervalTime);
                viewAbilityConfig.setExposeValidDuration(this.sdkConfig.viewAbility.viewabilityTime);
                viewAbilityConfig.setCoverRateScale(1.0f - (this.sdkConfig.viewAbility.viewabilityFrame / 100.0f));
                viewAbilityConfig.setMaxDuration(this.sdkConfig.viewAbility.maxExpirationSecs);
                viewAbilityConfig.setMaxUploadAmount(this.sdkConfig.viewAbility.maxAmount);
                viewAbilityConfig.setVideoExposeValidDuration(this.sdkConfig.viewAbility.viewabilityVideoTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return viewAbilityConfig;
    }

    public void onClick(String str) {
        handlerOriginURL(str, MonitorType.CLICK, null, 0, 0);
    }

    public void onExpose(String str, View view, int i) {
        handlerOriginURL(str, MonitorType.EXPOSE, view, 0, i);
    }

    public void onJSExpose(String str, View view, boolean z) {
        Company company = getCompany(str);
        if (company != null && !TextUtils.isEmpty(company.name)) {
            this.viewAbilityJsService.addTrack(str, view, company, z);
            return;
        }
        Logger.w("监测链接:" + str + " 没有对应的配置项,请检查sdkconfig.xml是否存在链接域名对应的Company配置!");
    }

    public void onVideoExpose(String str, View view, int i) {
        handlerOriginURL(str, MonitorType.VIDEOEXPOSEWITHABILITY, view, i, 0);
    }

    public void stop(String str) {
        Company company = getCompany(str);
        if (company == null) {
            Logger.w("监测链接:" + str + " 没有对应的配置项,请检查sdkconfig.xml是否存在链接域名对应的Company配置!");
            return;
        }
        String str2 = null;
        try {
            str2 = getAdAreaID(company, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.viewAbilityService.stopViewAbilityMonitor(company.domain.url + str2);
    }

    public void onExpose(String str, View view) {
        handlerOriginURL(str, MonitorType.EXPOSEWITHABILITY, view, 0, 0);
    }
}
