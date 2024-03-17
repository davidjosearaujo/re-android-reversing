package cn.jiguang.av;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    private LinkedHashSet<g> a = new LinkedHashSet<>();
    private LinkedHashSet<g> b = new LinkedHashSet<>();
    private List<Boolean> c = new ArrayList();

    private g a(boolean z, boolean z2) {
        LinkedHashSet<g> linkedHashSet = z ? this.b : this.a;
        LinkedHashSet<g> linkedHashSet2 = z2 ? null : z ? this.a : this.b;
        return (g) ((linkedHashSet2 == null || linkedHashSet2.isEmpty() || !(linkedHashSet == null || linkedHashSet.isEmpty() || a(z))) ? a(linkedHashSet) : a(linkedHashSet2));
    }

    private static <T> T a(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        Iterator<T> it = collection.iterator();
        if (it.hasNext()) {
            T next = it.next();
            collection.remove(next);
            return next;
        }
        return null;
    }

    private boolean a(boolean z) {
        if (this.c.size() < 2) {
            return false;
        }
        for (int size = this.c.size() - 1; size >= this.c.size() - 2; size--) {
            if (this.c.get(size).booleanValue() != z) {
                return false;
            }
        }
        return true;
    }

    public g a(int i) {
        List<Boolean> list;
        Boolean bool;
        cn.jiguang.ar.c.c("IpPool", "current ipv4List=" + this.a + " ipv6List=" + this.b);
        g a = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : a(true, false) : a(true, true) : a(false, true) : a(false, false);
        cn.jiguang.ar.c.c("IpPool", "get ipPort=" + a);
        if (a != null) {
            InetAddress inetAddress = a.c;
            if (inetAddress instanceof Inet4Address) {
                list = this.c;
                bool = Boolean.FALSE;
            } else if (inetAddress instanceof Inet6Address) {
                list = this.c;
                bool = Boolean.TRUE;
            }
            list.add(bool);
        }
        return a;
    }

    public void a() {
        try {
            this.a.clear();
            this.b.clear();
        } catch (Throwable unused) {
        }
    }

    public boolean a(g gVar) {
        LinkedHashSet<g> linkedHashSet;
        if (gVar == null || !gVar.a()) {
            return false;
        }
        InetAddress inetAddress = gVar.c;
        if (inetAddress instanceof Inet4Address) {
            linkedHashSet = this.a;
        } else if (!(inetAddress instanceof Inet6Address)) {
            return false;
        } else {
            linkedHashSet = this.b;
        }
        return linkedHashSet.add(gVar);
    }
}
