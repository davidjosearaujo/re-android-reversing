package o0;

import f5.g;
import g5.n;
import g5.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import l0.i0;
import l0.o;
import l0.w;
import q.e;
import q5.l;
import r5.h;
import r5.i;
import x.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j {

    /* renamed from: a */
    public final a.b f5237a;

    /* renamed from: b */
    public final boolean f5238b;

    /* renamed from: c */
    public final o f5239c;

    /* renamed from: d */
    public final f f5240d;
    public boolean e;

    /* renamed from: f */
    public j f5241f;

    /* renamed from: g */
    public final int f5242g;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends a.b implements i0 {

        /* renamed from: d */
        public final /* synthetic */ l<r, g> f5243d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l<? super r, g> lVar) {
            this.f5243d = lVar;
        }

        @Override // l0.i0
        public final void b(f fVar) {
            h.f(fVar, "<this>");
            this.f5243d.k(fVar);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b extends i implements l<o, Boolean> {

        /* renamed from: g */
        public static final b f5244g = new b();

        public b() {
            super(1);
        }

        @Override // q5.l
        public final Boolean k(o oVar) {
            o oVar2 = oVar;
            h.f(oVar2, "it");
            f b2 = oVar2.b();
            boolean z6 = true;
            z6 = false;
            if (b2 == null || !b2.f5232g) {
            }
            return Boolean.valueOf(z6);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c extends i implements l<o, Boolean> {

        /* renamed from: g */
        public static final c f5245g = new c();

        public c() {
            super(1);
        }

        @Override // q5.l
        public final Boolean k(o oVar) {
            o oVar2 = oVar;
            h.f(oVar2, "it");
            return Boolean.valueOf(oVar2.s.a(8));
        }
    }

    public j(a.b bVar, boolean z6, o oVar, f fVar) {
        h.f(bVar, "outerSemanticsNode");
        h.f(oVar, "layoutNode");
        h.f(fVar, "unmergedConfig");
        this.f5237a = bVar;
        this.f5238b = z6;
        this.f5239c = oVar;
        this.f5240d = fVar;
        this.f5242g = oVar.f4861g;
    }

    public final j a(c cVar, l<? super r, g> lVar) {
        int i7;
        int i8;
        f fVar = new f();
        fVar.f5232g = false;
        fVar.f5233h = false;
        lVar.k(fVar);
        a aVar = new a(lVar);
        if (cVar != null) {
            i7 = this.f5242g;
            i8 = 1000000000;
        } else {
            i7 = this.f5242g;
            i8 = 2000000000;
        }
        j jVar = new j(aVar, false, new o(i7 + i8, true), fVar);
        jVar.e = true;
        jVar.f5241f = this;
        return jVar;
    }

    public final void b(o oVar, ArrayList arrayList) {
        e<o> e = oVar.e();
        int i7 = e.f5605h;
        if (i7 > 0) {
            int i8 = 0;
            o[] oVarArr = e.f5603f;
            do {
                o oVar2 = oVarArr[i8];
                if (oVar2.i()) {
                    if (oVar2.s.a(8)) {
                        arrayList.add(k.a(oVar2, this.f5238b));
                    } else {
                        b(oVar2, arrayList);
                    }
                }
                i8++;
            } while (i8 < i7);
        }
    }

    public final w c() {
        if (this.e) {
            j g2 = g();
            if (g2 != null) {
                return g2.c();
            }
            return null;
        }
        l0.b c7 = k.c(this.f5239c);
        if (c7 == null) {
            c7 = this.f5237a;
        }
        return l0.c.a(c7, 8);
    }

    public final void d(List list) {
        List<j> k6 = k(false);
        int size = k6.size();
        for (int i7 = 0; i7 < size; i7++) {
            j jVar = k6.get(i7);
            if (jVar.i()) {
                list.add(jVar);
            } else if (!jVar.f5240d.f5233h) {
                jVar.d(list);
            }
        }
    }

    public final List<j> e(boolean z6, boolean z7) {
        if (!z6 && this.f5240d.f5233h) {
            return p.f4284f;
        }
        if (!i()) {
            return k(z7);
        }
        ArrayList arrayList = new ArrayList();
        d(arrayList);
        return arrayList;
    }

    public final f f() {
        if (!i()) {
            return this.f5240d;
        }
        f fVar = this.f5240d;
        fVar.getClass();
        f fVar2 = new f();
        fVar2.f5232g = fVar.f5232g;
        fVar2.f5233h = fVar.f5233h;
        fVar2.f5231f.putAll(fVar.f5231f);
        j(fVar2);
        return fVar2;
    }

    public final j g() {
        j jVar = this.f5241f;
        if (jVar != null) {
            return jVar;
        }
        o b2 = this.f5238b ? k.b(this.f5239c, b.f5244g) : null;
        if (b2 == null) {
            b2 = k.b(this.f5239c, c.f5245g);
        }
        if (b2 == null) {
            return null;
        }
        return k.a(b2, this.f5238b);
    }

    public final List<j> h() {
        return e(false, true);
    }

    public final boolean i() {
        return this.f5238b && this.f5240d.f5232g;
    }

    public final void j(f fVar) {
        if (!this.f5240d.f5233h) {
            List<j> k6 = k(false);
            int size = k6.size();
            for (int i7 = 0; i7 < size; i7++) {
                j jVar = k6.get(i7);
                if (!jVar.i()) {
                    f fVar2 = jVar.f5240d;
                    h.f(fVar2, "child");
                    for (Map.Entry entry : fVar2.f5231f.entrySet()) {
                        q qVar = (q) entry.getKey();
                        Object value = entry.getValue();
                        Object obj = fVar.f5231f.get(qVar);
                        h.d(qVar, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
                        Object i8 = qVar.f5270b.i(obj, value);
                        if (i8 != null) {
                            fVar.f5231f.put(qVar, i8);
                        }
                    }
                    jVar.j(fVar);
                }
            }
        }
    }

    public final List<j> k(boolean z6) {
        if (this.e) {
            return p.f4284f;
        }
        ArrayList arrayList = new ArrayList();
        b(this.f5239c, arrayList);
        if (z6) {
            c cVar = (c) a0.e.r(this.f5240d, m.f5253i);
            if (cVar != null && this.f5240d.f5232g && (!arrayList.isEmpty())) {
                arrayList.add(a(cVar, new h(cVar)));
            }
            f fVar = this.f5240d;
            q<List<String>> qVar = m.f5246a;
            if (fVar.b(qVar) && (!arrayList.isEmpty())) {
                f fVar2 = this.f5240d;
                if (fVar2.f5232g) {
                    List list = (List) a0.e.r(fVar2, qVar);
                    String str = list != null ? (String) n.X(list) : null;
                    if (str != null) {
                        arrayList.add(0, a(null, new i(str)));
                    }
                }
            }
        }
        return arrayList;
    }
}
