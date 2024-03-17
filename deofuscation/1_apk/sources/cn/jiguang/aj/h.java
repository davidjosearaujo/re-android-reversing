package cn.jiguang.aj;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class h {
    private static String b = "WifiHelper";
    public int a;
    private f c;
    private Comparator<ScanResult> d;
    private Comparator<Long> e;
    private g<Long> f;
    private List<ScanResult> g;
    private WifiManager h;
    private Context i;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements Comparator<Long> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Long l, Long l2) {
            if (l.longValue() == l2.longValue()) {
                return 0;
            }
            return l.longValue() > l2.longValue() ? 1 : -1;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements Comparator<ScanResult> {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    public h(Context context) {
        this.i = context;
        b();
    }

    private void b() {
        this.g = new ArrayList();
        this.d = new b();
        a aVar = new a();
        this.e = aVar;
        this.f = new g<>(aVar);
        this.a = 101;
        this.h = (WifiManager) this.i.getSystemService("wifi");
        ArrayList<Long> arrayList = c.o;
        if (arrayList == null) {
            c.o = new ArrayList<>();
        } else if (arrayList.isEmpty()) {
        } else {
            Collections.sort(c.o, this.e);
        }
    }

    private void b(List<ScanResult> list) {
        List<Long> a2;
        try {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                Collections.sort(list, this.d);
                int i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    ScanResult scanResult = list.get(i2);
                    if (scanResult != null) {
                        long parseLong = Long.parseLong(scanResult.BSSID.replaceAll(CertificateUtil.DELIMITER, ""), 16);
                        if (parseLong != 0 && scanResult.level > c.h && !arrayList.contains(Long.valueOf(parseLong))) {
                            if (i >= c.g) {
                                break;
                            }
                            arrayList.add(Long.valueOf(parseLong));
                            this.g.add(scanResult);
                            i++;
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    Collections.sort(arrayList, this.e);
                    if (!c.o.isEmpty() && (a2 = this.f.a(arrayList, c.o)) != null && !a2.isEmpty()) {
                        double size = arrayList.size() - a2.size();
                        double size2 = arrayList.size();
                        Double.isNaN(size);
                        Double.isNaN(size2);
                        if (((int) ((size / size2) * 100.0d)) < c.i) {
                            c();
                            return;
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                a(arrayList);
            }
            this.c.a(this.g);
        } catch (Throwable th) {
            cn.jiguang.ak.a.a(b, "" + th);
        }
        this.a = 101;
    }

    private void c() {
        try {
            this.g.clear();
            cn.jiguang.ak.a.a(b, "clearWifiData ");
        } catch (Throwable th) {
            String str = b;
            cn.jiguang.ak.a.a(str, "" + th);
        }
    }

    public void a() {
        try {
            if (c.a && this.a == 101) {
                boolean b2 = d.a().b();
                Context context = this.i;
                boolean a2 = context != null ? cn.jiguang.n.d.a(context, "android.permission.ACCESS_WIFI_STATE") : false;
                String str = b;
                cn.jiguang.ak.a.a(str, "doSample checkSafeStatus = " + b2 + "  , wifi permission:" + a2);
                if (!b2 || !a2) {
                    this.a = 101;
                    return;
                }
                this.g.clear();
                this.a = 100;
                b(this.h.getScanResults());
            }
        } catch (Throwable th) {
            String str2 = b;
            cn.jiguang.ak.a.d(str2, "[WifiHelper] startScan error:" + th);
        }
    }

    public void a(f fVar) {
        this.c = fVar;
    }

    public void a(List<Long> list) {
        if (list != null) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                c.o.clear();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    long longValue = list.get(i).longValue();
                    c.o.add(Long.valueOf(longValue));
                    sb.append(longValue);
                    if (i < list.size() - 1) {
                        sb.append(",");
                    }
                }
            } catch (Throwable th) {
                String str = b;
                cn.jiguang.ak.a.a(str, "" + th);
            }
        }
    }
}
