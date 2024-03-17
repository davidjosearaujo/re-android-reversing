package cn.jiguang.aw;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class h implements Serializable {
    private List a;
    private short b;
    private short c;

    public h() {
        this.a = new ArrayList(1);
        this.b = (short) 0;
        this.c = (short) 0;
    }

    public h(i iVar) {
        this();
        b(iVar);
    }

    private String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            stringBuffer.append("[");
            stringBuffer.append(((i) it.next()).c());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private synchronized Iterator a(boolean z, boolean z2) {
        int i;
        List subList;
        int size = this.a.size();
        int i2 = z ? size - this.b : this.b;
        if (i2 == 0) {
            return Collections.EMPTY_LIST.iterator();
        }
        if (!z) {
            i = size - this.b;
        } else if (z2) {
            if (this.c >= i2) {
                this.c = (short) 0;
            }
            i = this.c;
            this.c = (short) (i + 1);
        } else {
            i = 0;
        }
        ArrayList arrayList = new ArrayList(i2);
        if (z) {
            arrayList.addAll(this.a.subList(i, i2));
            if (i != 0) {
                subList = this.a.subList(0, i);
            }
            return arrayList.iterator();
        }
        subList = this.a.subList(i, size);
        arrayList.addAll(subList);
        return arrayList.iterator();
    }

    private void b(i iVar) {
        if (this.b == 0) {
            this.a.add(iVar);
            return;
        }
        List list = this.a;
        list.add(list.size() - this.b, iVar);
    }

    public synchronized Iterator a() {
        return a(true, true);
    }

    public synchronized void a(i iVar) {
        if (this.a.size() == 0) {
            b(iVar);
            return;
        }
        i f = f();
        if (!iVar.a(f)) {
            throw new IllegalArgumentException("record does not match rrset");
        }
        if (iVar.h() != f.h()) {
            if (iVar.h() > f.h()) {
                iVar = iVar.i();
                iVar.a(f.h());
            } else {
                for (int i = 0; i < this.a.size(); i++) {
                    i i2 = ((i) this.a.get(i)).i();
                    i2.a(iVar.h());
                    this.a.set(i, i2);
                }
            }
        }
        if (!this.a.contains(iVar)) {
            b(iVar);
        }
    }

    public g b() {
        return f().d();
    }

    public int c() {
        return f().f();
    }

    public int d() {
        return f().g();
    }

    public synchronized long e() {
        return f().h();
    }

    public synchronized i f() {
        if (this.a.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (i) this.a.get(0);
    }

    public String toString() {
        if (this.a.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        stringBuffer.append(b() + " ");
        stringBuffer.append(e() + " ");
        stringBuffer.append(a(a(true, false)));
        if (this.b > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
