package cn.jiguang.aj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    private static f a;
    private Context b;
    private a c;
    private h d;

    private f(Context context) {
        try {
            this.b = context;
            d.a().a(context);
            a aVar = new a(context);
            this.c = aVar;
            aVar.a(this);
            h hVar = new h(context);
            this.d = hVar;
            hVar.a(this);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("LBSManager", "LBSManageer init error:" + th);
            th.printStackTrace();
        }
    }

    public static f a(Context context) {
        if (a == null) {
            a = new f(JCoreManager.getAppContext(context));
        }
        return a;
    }

    private String a(ScanResult scanResult, WifiInfo wifiInfo) {
        String str;
        long currentTimeMillis = Build.VERSION.SDK_INT >= 17 ? System.currentTimeMillis() - (((SystemClock.elapsedRealtimeNanos() / 1000) / 1000) - (scanResult.timestamp / 1000)) : 0L;
        String str2 = "";
        if (scanResult == null) {
            if (wifiInfo != null) {
                String replace = wifiInfo.getSSID().replace(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "").replace("#", "").replace(",", "");
                return replace + "#" + wifiInfo.getBSSID() + "#" + wifiInfo.getRssi() + "##" + currentTimeMillis + "#connect";
            }
            return "";
        }
        String replace2 = scanResult.SSID.replace(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "").replace("#", "").replace(",", "");
        if (wifiInfo != null && (str = scanResult.BSSID) != null && str.equals(wifiInfo.getBSSID())) {
            str2 = "connect";
        }
        return replace2 + "#" + scanResult.BSSID + "#" + scanResult.level + "#" + scanResult.capabilities + "#" + currentTimeMillis + "#" + str2;
    }

    private String b(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append("g|");
        sb.append(System.currentTimeMillis());
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        if (location == null) {
            sb.append(IntegrityManager.INTEGRITY_TYPE_NONE);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("0");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("0");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("0");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("0");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("0");
        } else {
            sb.append(location.getProvider());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(location.getLongitude());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(location.getLatitude());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(location.getAltitude());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(location.getBearing());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(location.getAccuracy());
        }
        return sb.toString();
    }

    private String b(b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("c|");
        sb.append(System.currentTimeMillis());
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        if (bVar == null) {
            sb.append(0);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(0);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(0);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(0);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append("");
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        } else {
            sb.append(bVar.a());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(bVar.b());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(bVar.c());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(bVar.d());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(bVar.h());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(bVar.f());
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(bVar.g().replace(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, " "));
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            List<NeighboringCellInfo> e = bVar.e();
            if (e != null) {
                cn.jiguang.ak.a.a("LBSManager", "neighborCells size:" + e.size());
                for (int i = 0; i < e.size(); i++) {
                    sb.append(e.get(i).getCid());
                    if (i < e.size() - 1) {
                        sb.append(",");
                    }
                }
            } else {
                cn.jiguang.ak.a.a("LBSManager", "neighborCells is null");
            }
        }
        return sb.toString();
    }

    private String b(List<ScanResult> list) {
        WifiInfo wifiInfo;
        StringBuilder sb = new StringBuilder();
        WifiManager wifiManager = (WifiManager) this.b.getSystemService("wifi");
        if (wifiManager != null) {
            wifiInfo = wifiManager.getConnectionInfo();
            cn.jiguang.ak.a.a("LBSManager", "connectingWifi:" + wifiInfo.toString());
        } else {
            wifiInfo = null;
        }
        if (list != null) {
            if (list.size() > 0) {
                sb.append("w|");
                for (int i = 0; i < list.size(); i++) {
                    String a2 = a(list.get(i), wifiInfo);
                    if (!TextUtils.isEmpty(a2)) {
                        sb.append(a2);
                        if (i < list.size() - 1) {
                            sb.append(",");
                        }
                    }
                }
            } else if (wifiInfo != null) {
                sb.append("w|");
                sb.append(a(null, wifiInfo));
            }
        }
        return sb.toString();
    }

    public void a() {
        if (this.d != null) {
            cn.jiguang.ak.a.a("LBSManager", "start scan wifi");
            this.d.a();
        }
    }

    @SuppressLint({"MissingPermission"})
    public void a(Location location) {
        String b = b(location);
        cn.jiguang.ak.a.a("LBSManager", "location data:" + b);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        a(b);
    }

    public void a(b bVar) {
        String b = b(bVar);
        cn.jiguang.ak.a.a("LBSManager", "cell data：" + b);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        a(b);
    }

    public void a(String str) {
        synchronized (this) {
            Context context = this.b;
            boolean b = cn.jiguang.r.c.b(context, "rl2.catch", str + "\n");
            cn.jiguang.ak.a.a("LBSManager", "save lbs data success:" + b);
        }
    }

    public void a(List<ScanResult> list) {
        cn.jiguang.ak.a.a("LBSManager", "wifi data. size:" + list.size());
        String b = b(list);
        cn.jiguang.ak.a.a("LBSManager", "info:" + b);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        a(b);
    }

    public void b() {
        if (this.c != null) {
            cn.jiguang.ak.a.a("LBSManager", "start scanGps");
            this.c.a();
        }
    }

    public void c() {
        boolean b = d.a().b();
        a aVar = this.c;
        if (aVar == null || !b) {
            return;
        }
        Location a2 = aVar.a(false);
        cn.jiguang.ak.a.a("LBSManager", "get gps");
        if (a2 != null) {
            a(a2);
        }
    }

    public void d() {
        if (this.c != null) {
            cn.jiguang.ak.a.a("LBSManager", "start scan cell");
            this.c.b();
        }
    }

    public JSONObject e() {
        String[] split;
        synchronized (this) {
            String c = cn.jiguang.r.c.c(this.b, "rl2.catch");
            if (TextUtils.isEmpty(c)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (String str : c.split("\n")) {
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("g|")) {
                        jSONArray2.put(str.replaceFirst("g\\|", ""));
                    } else if (str.startsWith("w|")) {
                        jSONArray.put(str.replaceFirst("w\\|", ""));
                    } else if (str.startsWith("c|")) {
                        jSONArray3.put(str.replaceFirst("c\\|", ""));
                    }
                }
            }
            if (cn.jiguang.i.a.a().d(1502)) {
                jSONObject.put("g", jSONArray2);
            }
            if (cn.jiguang.i.a.a().d(1505)) {
                jSONObject.put("w", jSONArray);
            }
            if (cn.jiguang.i.a.a().d(1501)) {
                jSONObject.put(com.huawei.hms.opendevice.c.a, jSONArray3);
            }
            if (cn.jiguang.i.a.a().d(1503)) {
                jSONObject.put("local_dns", cn.jiguang.n.d.f());
            }
            if (cn.jiguang.i.a.a().d(1504)) {
                jSONObject.put("network_type", cn.jiguang.n.d.k(this.b));
            }
            return jSONObject;
        }
    }

    public void f() {
        synchronized (this) {
            cn.jiguang.r.c.d(this.b, "rl2.catch");
        }
    }
}
