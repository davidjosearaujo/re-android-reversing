package cn.jiguang.av;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g implements Serializable {
    public String a;
    public int b;
    public transient InetAddress c;

    public g(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public g(InetAddress inetAddress, int i) {
        this.a = inetAddress.getHostAddress();
        this.b = i;
        this.c = inetAddress;
    }

    public static g a(String str) {
        int lastIndexOf;
        String substring;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(CertificateUtil.DELIMITER)) >= 0) {
            try {
                int intValue = Integer.decode(str.substring(lastIndexOf + 1)).intValue();
                if (lastIndexOf == 0) {
                    substring = "";
                } else {
                    int i = str.startsWith("[") ? 1 : 0;
                    if (str.charAt(lastIndexOf - 1) == ']') {
                        lastIndexOf--;
                    }
                    substring = str.substring(i, lastIndexOf);
                }
                return new g(substring, intValue);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String a(LinkedHashSet<g> linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<g> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static LinkedHashSet<g> a(LinkedHashMap<String, Integer> linkedHashMap) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            g gVar = new g(entry.getKey(), entry.getValue().intValue());
            if (gVar.a()) {
                linkedHashSet.add(gVar);
            }
        }
        return linkedHashSet;
    }

    public static boolean a(String str, int i) {
        return !TextUtils.isEmpty(str) && i > 0 && i <= 65535;
    }

    public static LinkedHashSet<g> b(String str) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                g a = a(str2);
                if (a != null && a.a()) {
                    linkedHashSet.add(a);
                }
            }
        }
        return linkedHashSet;
    }

    public boolean a() {
        int i;
        return !TextUtils.isEmpty(this.a) && (i = this.b) > 0 && i <= 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.b == gVar.b) {
            String str = this.a;
            String str2 = gVar.a;
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.b;
    }

    public String toString() {
        StringBuilder sb;
        String str = this.a;
        String str2 = CertificateUtil.DELIMITER;
        if (str.contains(CertificateUtil.DELIMITER)) {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.a);
            str2 = "]:";
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
        }
        sb.append(str2);
        sb.append(this.b);
        return sb.toString();
    }
}
