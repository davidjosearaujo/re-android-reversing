package cn.jiguang.aw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e implements Cloneable {
    private static i[] d = new i[0];
    private static h[] e = new h[0];
    private d a;
    private List[] b;
    private int c;

    public e() {
        this(new d());
    }

    public e(b bVar) {
        this(new d(bVar));
        for (int i = 0; i < 4; i++) {
            try {
                int c = this.a.c(i);
                if (c > 0) {
                    this.b[i] = new ArrayList(c);
                }
                for (int i2 = 0; i2 < c; i2++) {
                    this.b[i].add(i.a(bVar, i));
                }
            } catch (IOException e2) {
                throw e2;
            }
        }
        this.c = bVar.a();
    }

    private e(d dVar) {
        this.b = new List[4];
        this.a = dVar;
    }

    public e(byte[] bArr) {
        this(new b(bArr));
    }

    private int a(c cVar, int i, a aVar, int i2) {
        int size = this.b[i].size();
        int a = cVar.a();
        i iVar = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i iVar2 = (i) this.b[i].get(i5);
            if (i == 3) {
                i3++;
            } else {
                if (iVar != null && !a(iVar2, iVar)) {
                    a = cVar.a();
                    i4 = i5;
                }
                iVar2.a(cVar, i, aVar);
                if (cVar.a() > i2) {
                    cVar.a(a);
                    return (size - i4) + i3;
                }
                iVar = iVar2;
            }
        }
        return i3;
    }

    public static e a(i iVar) {
        e eVar = new e();
        eVar.a(iVar, 0);
        return eVar;
    }

    private boolean a(c cVar, int i) {
        if (i < 12) {
            return false;
        }
        cVar.a();
        this.a.a(cVar);
        a aVar = new a();
        this.a.c();
        for (int i2 = 0; i2 < 4; i2++) {
            if (this.b[i2] != null) {
                a(cVar, i2, aVar, i);
            }
        }
        return true;
    }

    private static boolean a(i iVar, i iVar2) {
        return iVar.f() == iVar2.f() && iVar.g() == iVar2.g() && iVar.d().equals(iVar2.d());
    }

    public i a() {
        List list = this.b[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (i) list.get(0);
    }

    public void a(i iVar, int i) {
        List[] listArr = this.b;
        if (listArr[i] == null) {
            listArr[i] = new LinkedList();
        }
        this.a.b(i);
        this.b[i].add(iVar);
    }

    public i[] a(int i) {
        List[] listArr = this.b;
        if (listArr[i] == null) {
            return d;
        }
        List list = listArr[i];
        return (i[]) list.toArray(new i[list.size()]);
    }

    public h[] b(int i) {
        if (this.b[i] == null) {
            return e;
        }
        LinkedList linkedList = new LinkedList();
        i[] a = a(i);
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < a.length; i2++) {
            g d2 = a[i2].d();
            boolean z = true;
            if (hashSet.contains(d2)) {
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    h hVar = (h) linkedList.get(size);
                    if (hVar.c() == a[i2].f() && hVar.d() == a[i2].g() && hVar.b().equals(d2)) {
                        hVar.a(a[i2]);
                        z = false;
                        break;
                    }
                    size--;
                }
            }
            if (z) {
                linkedList.add(new h(a[i2]));
                hashSet.add(d2);
            }
        }
        return (h[]) linkedList.toArray(new h[linkedList.size()]);
    }

    public byte[] c(int i) {
        c cVar = new c();
        a(cVar, i);
        this.c = cVar.a();
        return cVar.b();
    }

    public Object clone() {
        e eVar = new e();
        int i = 0;
        while (true) {
            List[] listArr = this.b;
            if (i >= listArr.length) {
                eVar.a = (d) this.a.clone();
                eVar.c = this.c;
                return eVar;
            }
            if (listArr[i] != null) {
                eVar.b[i] = new LinkedList(this.b[i]);
            }
            i++;
        }
    }
}
