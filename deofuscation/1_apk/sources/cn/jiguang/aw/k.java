package cn.jiguang.aw;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class k {
    private static k d;
    private String[] a = null;
    private g[] b = null;
    private int c = -1;

    static {
        c();
    }

    public k() {
        if (d() || e()) {
            return;
        }
        if (this.a == null || this.b == null) {
            if (System.getProperty("java.vendor").indexOf("Android") != -1) {
                g();
            } else {
                f();
            }
        }
    }

    private int a(String str) {
        try {
            int parseInt = Integer.parseInt(str.substring(6));
            if (parseInt >= 0) {
                return parseInt;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private void a(int i) {
        if (this.c >= 0 || i <= 0) {
            return;
        }
        this.c = i;
    }

    private void a(String str, List list) {
        if (list.contains(str)) {
            return;
        }
        list.add(str);
    }

    private void a(List list, List list2) {
        if (this.a == null && list.size() > 0) {
            this.a = (String[]) list.toArray(new String[0]);
        }
        if (this.b != null || list2.size() <= 0) {
            return;
        }
        this.b = (g[]) list2.toArray(new g[0]);
    }

    public static synchronized k b() {
        k kVar;
        synchronized (k.class) {
            kVar = d;
        }
        return kVar;
    }

    private void b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            ArrayList arrayList = new ArrayList(0);
            ArrayList arrayList2 = new ArrayList(0);
            int i = -1;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.startsWith("nameserver")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                        stringTokenizer.nextToken();
                        a(stringTokenizer.nextToken(), arrayList);
                    } else if (readLine.startsWith("domain")) {
                        StringTokenizer stringTokenizer2 = new StringTokenizer(readLine);
                        stringTokenizer2.nextToken();
                        if (stringTokenizer2.hasMoreTokens() && arrayList2.isEmpty()) {
                            b(stringTokenizer2.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("search")) {
                        if (!arrayList2.isEmpty()) {
                            arrayList2.clear();
                        }
                        StringTokenizer stringTokenizer3 = new StringTokenizer(readLine);
                        stringTokenizer3.nextToken();
                        while (stringTokenizer3.hasMoreTokens()) {
                            b(stringTokenizer3.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)) {
                        StringTokenizer stringTokenizer4 = new StringTokenizer(readLine);
                        stringTokenizer4.nextToken();
                        while (stringTokenizer4.hasMoreTokens()) {
                            String nextToken = stringTokenizer4.nextToken();
                            if (nextToken.startsWith("ndots:")) {
                                i = a(nextToken);
                            }
                        }
                    }
                } catch (IOException unused) {
                }
            }
            bufferedReader.close();
            a(arrayList, arrayList2);
            a(i);
        } catch (FileNotFoundException unused2) {
        }
    }

    private void b(String str, List list) {
        try {
            g a = g.a(str, g.a);
            if (list.contains(a)) {
                return;
            }
            list.add(a);
        } catch (Exception unused) {
        }
    }

    public static void c() {
        k kVar = new k();
        synchronized (k.class) {
            d = kVar;
        }
    }

    private boolean d() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, ",");
            while (stringTokenizer2.hasMoreTokens()) {
                b(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        a(arrayList, arrayList2);
        return (this.a == null || this.b == null) ? false : true;
    }

    private boolean e() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            Class<?>[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object invoke = cls.getDeclaredMethod("open", clsArr).invoke(null, objArr);
            List<String> list = (List) cls.getMethod("nameservers", clsArr).invoke(invoke, objArr);
            List<String> list2 = (List) cls.getMethod("searchlist", clsArr).invoke(invoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                for (String str : list) {
                    a(str, arrayList);
                }
            }
            if (list2.size() > 0) {
                for (String str2 : list2) {
                    b(str2, arrayList2);
                }
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void f() {
        b("/etc/resolv.conf");
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, strArr[i]);
                if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
        } catch (Exception unused) {
        }
        a(arrayList, arrayList2);
    }

    public String[] a() {
        return this.a;
    }
}
