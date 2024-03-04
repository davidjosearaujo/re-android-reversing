package f6;

import a6.j1;
import i5.f;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a */
    public static final q.d f4182a = new q.d(4, "NO_THREAD_ELEMENTS");

    /* loaded from: classes.dex */
    public static final class a extends r5.i implements q5.p<Object, f.b, Object> {

        /* renamed from: g */
        public static final a f4183g = new a();

        public a() {
            super(2);
        }

        @Override // q5.p
        public final Object i(Object obj, f.b bVar) {
            f.b bVar2 = bVar;
            if (bVar2 instanceof j1) {
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int intValue = num != null ? num.intValue() : 1;
                return intValue == 0 ? bVar2 : Integer.valueOf(intValue + 1);
            }
            return obj;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends r5.i implements q5.p<j1<?>, f.b, j1<?>> {

        /* renamed from: g */
        public static final b f4184g = new b();

        public b() {
            super(2);
        }

        @Override // q5.p
        public final j1<?> i(j1<?> j1Var, f.b bVar) {
            j1<?> j1Var2 = j1Var;
            f.b bVar2 = bVar;
            if (j1Var2 != null) {
                return j1Var2;
            }
            if (bVar2 instanceof j1) {
                return (j1) bVar2;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends r5.i implements q5.p<y, f.b, y> {

        /* renamed from: g */
        public static final c f4185g = new c();

        public c() {
            super(2);
        }

        @Override // q5.p
        public final y i(y yVar, f.b bVar) {
            y yVar2 = yVar;
            f.b bVar2 = bVar;
            if (bVar2 instanceof j1) {
                j1<Object> j1Var = (j1) bVar2;
                String m = j1Var.m(yVar2.f4188a);
                Object[] objArr = yVar2.f4189b;
                int i7 = yVar2.f4191d;
                objArr[i7] = m;
                j1<Object>[] j1VarArr = yVar2.f4190c;
                yVar2.f4191d = i7 + 1;
                j1VarArr[i7] = j1Var;
            }
            return yVar2;
        }
    }

    public static final void a(i5.f fVar, Object obj) {
        if (obj == f4182a) {
            return;
        }
        if (!(obj instanceof y)) {
            Object q6 = fVar.q(null, b.f4184g);
            r5.h.d(q6, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((j1) q6).C(obj);
            return;
        }
        y yVar = (y) obj;
        int length = yVar.f4190c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i7 = length - 1;
            j1<Object> j1Var = yVar.f4190c[length];
            r5.h.c(j1Var);
            j1Var.C(yVar.f4189b[length]);
            if (i7 < 0) {
                return;
            }
            length = i7;
        }
    }

    public static final Object b(i5.f fVar) {
        Object q6 = fVar.q(0, a.f4183g);
        r5.h.c(q6);
        return q6;
    }

    public static final Object c(i5.f fVar, Object obj) {
        if (obj == null) {
            obj = b(fVar);
        }
        return obj == 0 ? f4182a : obj instanceof Integer ? fVar.q(new y(fVar, ((Number) obj).intValue()), c.f4185g) : ((j1) obj).m(fVar);
    }
}
