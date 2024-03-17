package cn.jiguang.i;

import android.annotation.TargetApi;
import android.util.ArrayMap;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@TargetApi(19)
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static Map<String, Integer> a;
    private static Map<Integer, Boolean> d;
    private static ArrayList<Integer> e;
    private static Map<Integer, Integer[]> f;
    private static a g;
    public ArrayList<String[]> b;
    private Map<Integer, cn.jiguang.o.a> c;

    static {
        ArrayMap arrayMap = new ArrayMap();
        a = arrayMap;
        arrayMap.put("JDevice", 1000);
        a.put("JAppAll", 1100);
        a.put("JAppMovement", 1101);
        a.put("JAppPermission", 1300);
        a.put("JAppSdk", 1103);
        a.put("JAppRunning", 1102);
        a.put("JDeviceBattery", 1200);
        a.put("JLocation", 1500);
        a.put("JLocationv2", 1500);
        a.put("JArp", 1600);
        a.put("JDeviceIds", 1900);
        a.put("CopyManager", 1400);
        a.put("JBt", 1450);
        a.put("JDeviceCA", 1700);
        a.put("JDevicePhoneNumber", 1700);
        a.put(CommonConstant.KEY_UID, 2300);
        a.put("JAppActive", 1104);
        d = new ArrayMap();
        ArrayList<Integer> arrayList = new ArrayList<>();
        e = arrayList;
        arrayList.add(1800);
        ArrayMap arrayMap2 = new ArrayMap();
        f = arrayMap2;
        arrayMap2.put(1022, new Integer[]{1023, 1024, 1025});
        g = null;
    }

    private a() {
    }

    private long a(Date date) {
        if (date == null) {
            return 0L;
        }
        Date date2 = new Date();
        date2.setHours(date.getHours());
        date2.setMinutes(date.getMinutes());
        date2.setSeconds(date.getSeconds());
        return (date2.getTime() / 1000) * 1000;
    }

    public static a a() {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a();
                }
                g.b = new ArrayList<>();
                g.c = new ArrayMap();
            }
        }
        return g;
    }

    public void a(cn.jiguang.o.a aVar) {
        int a2;
        try {
            if (this.c == null) {
                this.c = new ArrayMap();
            }
            if (aVar != null && !this.c.containsKey(Integer.valueOf(aVar.a()))) {
                this.c.put(Integer.valueOf(aVar.a()), aVar);
            }
            if (aVar == null || aVar.a() >= 2000 || (a2 = (aVar.a() / 100) * 100) == 1100 || a2 == 1450 || this.c.containsKey(Integer.valueOf(a2))) {
                return;
            }
            cn.jiguang.o.a aVar2 = new cn.jiguang.o.a();
            aVar2.a(a2);
            aVar2.a(true);
            aVar2.b(aVar.c());
            aVar2.d(aVar.e());
            aVar2.c(aVar.d());
            aVar2.e(aVar.f());
            aVar2.f(aVar.g());
            aVar2.g(aVar.h());
            this.c.put(Integer.valueOf(a2), aVar2);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JDataConfigManager", "addConfig failed :" + th);
        }
    }

    public synchronized void a(String str) {
        try {
            Map<String, Integer> map = a;
            if (map != null) {
                Integer num = map.get(str);
                Map<Integer, Boolean> map2 = d;
                if (map2 != null && num != null && !map2.containsKey(num)) {
                    cn.jiguang.ak.a.a("JDataConfigManager", "mark first collect delay :" + str + CertificateUtil.DELIMITER + num);
                    d.put(num, Boolean.TRUE);
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r14) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.i.a.a(int):boolean");
    }

    public synchronized int b(int i) {
        Map<Integer, Boolean> map;
        cn.jiguang.o.a aVar;
        try {
            map = d;
        } finally {
            return 0;
        }
        if (map == null || !map.containsKey(Integer.valueOf(i))) {
            Map<Integer, cn.jiguang.o.a> map2 = this.c;
            if (map2 != null && map2.containsKey(Integer.valueOf(i)) && (aVar = this.c.get(Integer.valueOf(i))) != null) {
                return aVar.c() * 1000;
            }
            return 0;
        }
        return 0;
    }

    public long b(String str) {
        cn.jiguang.o.a aVar;
        try {
            Map<String, Integer> map = a;
            if (map != null) {
                Integer num = map.get(str);
                Map<Integer, cn.jiguang.o.a> map2 = this.c;
                if (map2 == null || num == null || !map2.containsKey(num) || (aVar = this.c.get(num)) == null) {
                    return 86400000L;
                }
                return aVar.e() * 60 * 1000;
            }
            return 86400000L;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JDataConfigManager", "get clt interval  failed :" + th);
            return 86400000L;
        }
    }

    public void b() {
        this.b = new ArrayList<>();
        this.c = new ArrayMap();
    }

    public int c(int i) {
        cn.jiguang.o.a aVar;
        try {
            Map<Integer, cn.jiguang.o.a> map = this.c;
            if (map == null || !map.containsKey(Integer.valueOf(i)) || (aVar = this.c.get(Integer.valueOf(i))) == null) {
                return -1;
            }
            return aVar.g();
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JDataConfigManager", "get bg interval  failed :" + th);
            return -1;
        }
    }

    public long c(String str) {
        cn.jiguang.o.a aVar;
        try {
            Map<String, Integer> map = a;
            if (map != null) {
                Integer num = map.get(str);
                Map<Integer, cn.jiguang.o.a> map2 = this.c;
                if (map2 == null || num == null || !map2.containsKey(num) || (aVar = this.c.get(num)) == null) {
                    return 86400000L;
                }
                return aVar.f() * 60 * 1000;
            }
            return 86400000L;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JDataConfigManager", "get rpt interval  failed :" + th);
            return 86400000L;
        }
    }

    public boolean d(int i) {
        boolean z = a().a(i) && !cn.jiguang.n.b.a(i);
        cn.jiguang.ak.a.a("JDataConfigManager", "configId is " + i + ", isCanCollect is " + z);
        return z;
    }

    public boolean e(int i) {
        boolean z = !a().a(i) || cn.jiguang.n.b.a(i);
        cn.jiguang.ak.a.a("JDataConfigManager", "configId is " + i + ", isNotCollect is " + z);
        return z;
    }
}
