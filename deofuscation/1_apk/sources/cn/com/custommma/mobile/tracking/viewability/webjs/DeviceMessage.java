package cn.com.custommma.mobile.tracking.viewability.webjs;

import android.content.Context;
import cn.com.custommma.mobile.tracking.api.Constant;
import cn.com.custommma.mobile.tracking.util.CommonUtil;
import cn.com.custommma.mobile.tracking.util.DeviceInfoUtil;
import com.facebook.internal.security.CertificateUtil;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DeviceMessage {
    private static final String JSON_AKEY = "akey";
    private static final String JSON_ANAME = "aname";
    private static final String JSON_ANDROIDID = "androidid";
    private static final String JSON_IMEI = "imei";
    private static final String JSON_MAC = "mac";
    private static final String JSON_OS = "os";
    private static final String JSON_OSVS = "osvs";
    private static final String JSON_SCWH = "scwh";
    private static final String JSON_SDKV = "sdkv";
    private static final String JSON_TERM = "term";
    public static final String JSON_TS = "ts";
    private static final String JSON_WIFI = "wifi";
    private static final String JSON_WIFIBSSID = "wifibssid";
    private static final String JSON_WIFISSID = "wifissid";
    private static JSONObject deviceMessage;

    public static JSONObject getDeviceMessage(Context context) {
        if (deviceMessage == null) {
            JSONObject jSONObject = new JSONObject();
            deviceMessage = jSONObject;
            try {
                jSONObject.put(JSON_OS, "0");
                deviceMessage.put(JSON_MAC, CommonUtil.md5(DeviceInfoUtil.getMacAddress(context).replaceAll(CertificateUtil.DELIMITER, "").toUpperCase()));
                deviceMessage.put(JSON_IMEI, CommonUtil.md5(DeviceInfoUtil.getImei(context)));
                deviceMessage.put(JSON_ANDROIDID, CommonUtil.md5(DeviceInfoUtil.getAndroidId(context)));
                deviceMessage.put(JSON_AKEY, DeviceInfoUtil.getPackageName(context));
                deviceMessage.put(JSON_ANAME, DeviceInfoUtil.getAppName(context));
                deviceMessage.put(JSON_SCWH, DeviceInfoUtil.getResolution(context));
                deviceMessage.put(JSON_TERM, DeviceInfoUtil.getDevice());
                deviceMessage.put(JSON_OSVS, DeviceInfoUtil.getOSVersion());
                deviceMessage.put(JSON_SDKV, Constant.TRACKING_SDKVS_VALUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                deviceMessage.put(JSON_WIFI, DeviceInfoUtil.isWifi(context));
                deviceMessage.put(JSON_WIFISSID, DeviceInfoUtil.getWifiSSID(context));
                deviceMessage.put(JSON_WIFIBSSID, DeviceInfoUtil.getWiFiBSSID(context).replace(CertificateUtil.DELIMITER, "").toUpperCase());
            } catch (Exception unused) {
            }
        }
        return deviceMessage;
    }
}
