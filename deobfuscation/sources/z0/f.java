package z0;

import androidx.fragment.app.s0;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d */
    public p f6875d;

    /* renamed from: f */
    public int f6876f;

    /* renamed from: g */
    public int f6877g;

    /* renamed from: a */
    public p f6872a = null;

    /* renamed from: b */
    public boolean f6873b = false;

    /* renamed from: c */
    public boolean f6874c = false;
    public int e = 1;

    /* renamed from: h */
    public int f6878h = 1;

    /* renamed from: i */
    public g f6879i = null;

    /* renamed from: j */
    public boolean f6880j = false;

    /* renamed from: k */
    public ArrayList f6881k = new ArrayList();

    /* renamed from: l */
    public ArrayList f6882l = new ArrayList();

    public f(p pVar) {
        this.f6875d = pVar;
    }

    @Override // z0.d
    public final void a(d dVar) {
        Iterator it = this.f6882l.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f6880j) {
                return;
            }
        }
        this.f6874c = true;
        p pVar = this.f6872a;
        if (pVar != null) {
            pVar.a(this);
        }
        if (this.f6873b) {
            this.f6875d.a(this);
            return;
        }
        f fVar = null;
        int i7 = 0;
        Iterator it2 = this.f6882l.iterator();
        while (it2.hasNext()) {
            f fVar2 = (f) it2.next();
            if (!(fVar2 instanceof g)) {
                i7++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i7 == 1 && fVar.f6880j) {
            g gVar = this.f6879i;
            if (gVar != null) {
                if (!gVar.f6880j) {
                    return;
                }
                this.f6876f = this.f6878h * gVar.f6877g;
            }
            d(fVar.f6877g + this.f6876f);
        }
        p pVar2 = this.f6872a;
        if (pVar2 != null) {
            pVar2.a(this);
        }
    }

    public final void b(d dVar) {
        this.f6881k.add(dVar);
        if (this.f6880j) {
            dVar.a(dVar);
        }
    }

    public final void c() {
        this.f6882l.clear();
        this.f6881k.clear();
        this.f6880j = false;
        this.f6877g = 0;
        this.f6874c = false;
        this.f6873b = false;
    }

    public void d(int i7) {
        if (this.f6880j) {
            return;
        }
        this.f6880j = true;
        this.f6877g = i7;
        Iterator it = this.f6881k.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            dVar.a(dVar);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6875d.f6895b.f6530k0);
        sb.append(":");
        sb.append(s0.n(this.e));
        sb.append("(");
        sb.append(this.f6880j ? Integer.valueOf(this.f6877g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f6882l.size());
        sb.append(":d=");
        sb.append(this.f6881k.size());
        sb.append(">");
        return sb.toString();
    }
}
