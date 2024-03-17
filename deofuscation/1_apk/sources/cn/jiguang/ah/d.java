package cn.jiguang.ah;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.f.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private Context a;

    public d(Context context) {
        this.a = context;
    }

    private String a(Context context) {
        String str;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
        } catch (Throwable unused) {
            str = "";
        }
        if (Build.VERSION.SDK_INT < 29 || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        str = connectionInfo.getSupplicantState() == SupplicantState.COMPLETED ? connectionInfo.getSSID() : "";
        try {
            int networkId = connectionInfo.getNetworkId();
            for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
                if (wifiConfiguration.networkId == networkId) {
                    str = wifiConfiguration.SSID;
                }
            }
        } catch (Throwable unused2) {
        }
        cn.jiguang.ak.a.a("JLocationWifi", "ssid is " + str);
        return str.replace("\"", "");
    }

    public List<cn.jiguang.ai.c> a(int i) {
        String str;
        if (cn.jiguang.n.d.m(this.a)) {
            WifiManager wifiManager = (WifiManager) this.a.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                cn.jiguang.ak.a.d("JLocationWifi", "get wifiManager failed");
                return null;
            } else if (wifiManager.isWifiEnabled()) {
                ArrayList arrayList = new ArrayList();
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                cn.jiguang.ai.c cVar = new cn.jiguang.ai.c();
                cVar.a = cn.jiguang.n.d.h(this.a);
                cVar.b = g.b((TextUtils.isEmpty(connectionInfo.getSSID()) || "<unknown ssid>".equals(connectionInfo.getSSID())) ? a(this.a) : connectionInfo.getSSID());
                cVar.c = "connect";
                cVar.d = connectionInfo.getRssi();
                cVar.e = connectionInfo.getBSSID();
                cn.jiguang.ak.a.a("JLocationWifi", "connectingWifi:" + cVar.toString());
                arrayList.add(cVar);
                if (Build.VERSION.SDK_INT < 23 || cn.jiguang.n.d.a(this.a, "android.permission.ACCESS_COARSE_LOCATION") || cn.jiguang.n.d.a(this.a, "android.permission.ACCESS_FINE_LOCATION")) {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() != 0) {
                        cn.jiguang.ak.a.a("JLocationWifi", "scan wifi list success:" + scanResults);
                        ArrayList<ScanResult> arrayList2 = new ArrayList(scanResults);
                        for (ScanResult scanResult : arrayList2) {
                            if (!(cVar.b.equals(cn.jiguang.n.d.d(scanResult.SSID)) && cVar.e.equals(scanResult.BSSID)) && scanResult.level >= -200) {
                                for (ScanResult scanResult2 : arrayList2) {
                                    if (scanResult2 != scanResult && scanResult.SSID.equals(scanResult2.SSID) && scanResult.BSSID.equals(scanResult2.BSSID)) {
                                        scanResults.remove(scanResult);
                                    }
                                }
                            } else {
                                scanResults.remove(scanResult);
                            }
                        }
                        arrayList2.clear();
                        Collections.sort(scanResults, new Comparator<ScanResult>() { // from class: cn.jiguang.ah.d.1
                            {
                                d.this = this;
                            }

                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(ScanResult scanResult3, ScanResult scanResult4) {
                                return scanResult4.level - scanResult3.level;
                            }
                        });
                        for (int i2 = 0; i2 < scanResults.size() && i2 != i - 1; i2++) {
                            ScanResult scanResult3 = scanResults.get(i2);
                            String d = cn.jiguang.n.d.d(scanResult3.SSID);
                            cn.jiguang.ai.c cVar2 = new cn.jiguang.ai.c();
                            cVar2.a = cn.jiguang.n.d.h(this.a);
                            cVar2.b = d;
                            cVar2.c = null;
                            if (i2 == 0) {
                                cVar2.c = "strongest";
                            }
                            cVar2.d = scanResult3.level;
                            cVar2.e = scanResult3.BSSID;
                            arrayList.add(cVar2);
                        }
                        return arrayList;
                    }
                    str = "scan wifi list failed";
                } else {
                    str = "scan wifi list failed because has no Manifest.permission.LOCATION";
                }
                cn.jiguang.ak.a.d("JLocationWifi", str);
                return arrayList;
            } else {
                return null;
            }
        }
        return null;
    }
}
