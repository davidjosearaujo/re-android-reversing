package com.hunantv.imgo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import com.mgtv.json.JsonInterface;
import com.mgtv.task.http.HttpCallBack;
import com.mgtv.task.http.HttpParams;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.v.r.r;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class NetworkStateManager {
    private static NetworkStateManager d = new NetworkStateManager();
    private String a = "http://ip.taobao.com/service/getIpInfo.php?ip=myip";
    private NetWorkLocationInfo b;
    private String c;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class NetWorkLocationInfo implements JsonInterface {
        private static final long serialVersionUID = -5429269194674395975L;
        public int code;
        public DataBean data;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class DataBean implements JsonInterface {
            private static final long serialVersionUID = -8776148255602340672L;
            public String area;
            public String area_id;
            public String city;
            public String city_id;
            public String country;
            public String country_id;
            public String county;
            public String county_id;
            public String ip;
            public String isp;
            public String isp_id;
            public String region;
            public String region_id;
        }

        public HashMap<String, String> getWorkFlowContentMap() {
            HashMap<String, String> hashMap = new HashMap<>();
            DataBean dataBean = this.data;
            if (dataBean != null) {
                hashMap.put("ip", dataBean.ip);
                hashMap.put("operater", this.data.isp);
                hashMap.put("location", this.data.city);
            }
            return hashMap;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends HttpCallBack<NetWorkLocationInfo> {
        public final /* synthetic */ b d;

        public a(b bVar) {
            this.d = bVar;
        }

        /* renamed from: u */
        public void failed(@Nullable NetWorkLocationInfo netWorkLocationInfo, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(netWorkLocationInfo, i, i2, str, th);
            NetworkStateManager.this.b = null;
        }

        /* renamed from: v */
        public void previewCache(NetWorkLocationInfo netWorkLocationInfo) {
        }

        /* renamed from: w */
        public void success(NetWorkLocationInfo netWorkLocationInfo) {
            if (netWorkLocationInfo == null || netWorkLocationInfo.code != 0) {
                NetworkStateManager.this.b = null;
                return;
            }
            NetworkStateManager.this.b = netWorkLocationInfo;
            b bVar = this.d;
            if (bVar != null) {
                bVar.a(netWorkLocationInfo);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface b {
        void a(NetWorkLocationInfo netWorkLocationInfo);
    }

    private NetworkStateManager() {
    }

    private void b() {
        ConnectivityManager connectivityManager;
        Network[] allNetworks;
        if (Build.VERSION.SDK_INT < 21 || (connectivityManager = (ConnectivityManager) j.l.a.a.a().getSystemService("connectivity")) == null) {
            return;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        StringBuilder sb = new StringBuilder();
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (networkInfo != null && activeNetworkInfo != null && networkInfo.getType() == activeNetworkInfo.getType()) {
                LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
                if (linkProperties == null || linkProperties.getDnsServers() == null || linkProperties.getDnsServers().size() <= 0) {
                    return;
                }
                for (InetAddress inetAddress : linkProperties.getDnsServers()) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(inetAddress.getHostAddress());
                }
            }
        }
        this.c = sb.toString();
    }

    public static NetworkStateManager e() {
        return d;
    }

    public String c() {
        return this.c;
    }

    public NetWorkLocationInfo d() {
        return this.b;
    }

    public void f(b bVar) {
        if (b0.f()) {
            HttpParams httpParams = new HttpParams();
            HashMap hashMap = new HashMap();
            String uuid = e.W0() ? UUID.randomUUID().toString() : "";
            hashMap.put("User-Agent", uuid + new Random(1000L).nextInt(10000));
            httpParams.putParams(hashMap, HttpParams.Type.HEADER);
            new r((Context) null).n(true).u(this.a, httpParams, new a(bVar));
            b();
        }
    }
}
