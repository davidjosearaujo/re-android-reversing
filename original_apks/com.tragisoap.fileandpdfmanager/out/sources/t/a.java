package t;

import java.util.ArrayList;
import p.d0;
import p.e0;
import q5.b;
import q5.c;
import q5.e;
import q5.f;
import q5.g;
import q5.h;
import q5.i;
import q5.j;
import q5.k;
import q5.m;
import q5.n;
import q5.p;
import q5.q;
import q5.r;
import q5.s;
import q5.t;
import q5.u;
import q5.v;
import q5.w;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements p, q, r, s, t, u, v, w, b, c, e, f, g, h, i, j, k, m, n {

    /* renamed from: f */
    public final int f5985f;

    /* renamed from: g */
    public final boolean f5986g;

    /* renamed from: h */
    public Object f5987h;

    /* renamed from: i */
    public d0 f5988i;

    /* renamed from: j */
    public ArrayList f5989j;

    /* renamed from: t.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0103a extends r5.i implements p<p.b, Integer, f5.g> {

        /* renamed from: h */
        public final /* synthetic */ Object f5991h;

        /* renamed from: i */
        public final /* synthetic */ int f5992i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0103a(Object obj, int i7) {
            super(2);
            a.this = r1;
            this.f5991h = obj;
            this.f5992i = i7;
        }

        @Override // q5.p
        public final f5.g i(p.b bVar, Integer num) {
            p.b bVar2 = bVar;
            num.intValue();
            r5.h.f(bVar2, "nc");
            a.this.a(this.f5991h, bVar2, a0.e.K(this.f5992i) | 1);
            return f5.g.f4141a;
        }
    }

    public a(int i7, boolean z6) {
        this.f5985f = i7;
        this.f5986g = z6;
    }

    public final Object a(Object obj, p.b bVar, int i7) {
        r5.h.f(bVar, "c");
        p.c i8 = bVar.i(this.f5985f);
        b(i8);
        int a7 = i8.m(this) ? b.a(2, 1) : b.a(1, 1);
        Object obj2 = this.f5987h;
        r5.h.d(obj2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        r5.v.b(3, obj2);
        Object f7 = ((q) obj2).f(obj, i8, Integer.valueOf(a7 | i7));
        e0 q6 = i8.q();
        if (q6 != null) {
            q6.f5426a = new C0103a(obj, i7);
        }
        return f7;
    }

    public final void b(p.b bVar) {
        e0 b2;
        if (this.f5986g && (b2 = bVar.b()) != null) {
            bVar.e(b2);
            if (b.d(this.f5988i, b2)) {
                this.f5988i = b2;
                return;
            }
            ArrayList arrayList = this.f5989j;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f5989j = arrayList;
            } else {
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (b.d((d0) arrayList.get(i7), b2)) {
                        arrayList.set(i7, b2);
                        return;
                    }
                }
            }
            arrayList.add(b2);
        }
    }

    public final void c(r5.i iVar) {
        if (!r5.h.a(this.f5987h, iVar)) {
            boolean z6 = this.f5987h == null;
            this.f5987h = iVar;
            if (!z6 && this.f5986g) {
                d0 d0Var = this.f5988i;
                if (d0Var != null) {
                    d0Var.invalidate();
                    this.f5988i = null;
                }
                ArrayList arrayList = this.f5989j;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        ((d0) arrayList.get(i7)).invalidate();
                    }
                    arrayList.clear();
                }
            }
        }
    }

    @Override // q5.q
    public final /* bridge */ /* synthetic */ Object f(Object obj, Object obj2, Object obj3) {
        return a(obj, (p.b) obj2, ((Number) obj3).intValue());
    }

    @Override // q5.p
    public final Object i(Object obj, Object obj2) {
        p.b bVar = (p.b) obj;
        int intValue = ((Number) obj2).intValue();
        r5.h.f(bVar, "c");
        p.c i7 = bVar.i(this.f5985f);
        b(i7);
        int a7 = intValue | (i7.m(this) ? b.a(2, 0) : b.a(1, 0));
        Object obj3 = this.f5987h;
        r5.h.d(obj3, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        r5.v.b(2, obj3);
        Object i8 = ((p) obj3).i(i7, Integer.valueOf(a7));
        e0 q6 = i7.q();
        if (q6 != null) {
            r5.v.b(2, this);
            q6.f5426a = this;
        }
        return i8;
    }
}
