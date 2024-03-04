package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a */
    public final o.h<RecyclerView.a0, a> f2149a = new o.h<>();

    /* renamed from: b */
    public final o.e<RecyclerView.a0> f2150b = new o.e<>();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d */
        public static o1.e f2151d = new o1.e(20);

        /* renamed from: a */
        public int f2152a;

        /* renamed from: b */
        public RecyclerView.i.c f2153b;

        /* renamed from: c */
        public RecyclerView.i.c f2154c;

        public static a a() {
            a aVar = (a) f2151d.b();
            return aVar == null ? new a() : aVar;
        }
    }

    public final void a(RecyclerView.a0 a0Var, RecyclerView.i.c cVar) {
        a orDefault = this.f2149a.getOrDefault(a0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f2149a.put(a0Var, orDefault);
        }
        orDefault.f2154c = cVar;
        orDefault.f2152a |= 8;
    }

    public final void b(RecyclerView.a0 a0Var, RecyclerView.i.c cVar) {
        a orDefault = this.f2149a.getOrDefault(a0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.f2149a.put(a0Var, orDefault);
        }
        orDefault.f2153b = cVar;
        orDefault.f2152a |= 4;
    }

    public final RecyclerView.i.c c(RecyclerView.a0 a0Var, int i7) {
        a l6;
        RecyclerView.i.c cVar;
        int e = this.f2149a.e(a0Var);
        if (e >= 0 && (l6 = this.f2149a.l(e)) != null) {
            int i8 = l6.f2152a;
            if ((i8 & i7) != 0) {
                int i9 = i8 & (~i7);
                l6.f2152a = i9;
                if (i7 == 4) {
                    cVar = l6.f2153b;
                } else if (i7 != 8) {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                } else {
                    cVar = l6.f2154c;
                }
                if ((i9 & 12) == 0) {
                    this.f2149a.j(e);
                    l6.f2152a = 0;
                    l6.f2153b = null;
                    l6.f2154c = null;
                    a.f2151d.a(l6);
                }
                return cVar;
            }
        }
        return null;
    }

    public final void d(RecyclerView.a0 a0Var) {
        a orDefault = this.f2149a.getOrDefault(a0Var, null);
        if (orDefault == null) {
            return;
        }
        orDefault.f2152a &= -2;
    }

    public final void e(RecyclerView.a0 a0Var) {
        o.e<RecyclerView.a0> eVar = this.f2150b;
        if (eVar.f5192f) {
            eVar.c();
        }
        int i7 = eVar.f5195i - 1;
        while (true) {
            if (i7 < 0) {
                break;
            } else if (a0Var == this.f2150b.f(i7)) {
                o.e<RecyclerView.a0> eVar2 = this.f2150b;
                Object[] objArr = eVar2.f5194h;
                Object obj = objArr[i7];
                Object obj2 = o.e.f5191j;
                if (obj != obj2) {
                    objArr[i7] = obj2;
                    eVar2.f5192f = true;
                }
            } else {
                i7--;
            }
        }
        a remove = this.f2149a.remove(a0Var);
        if (remove != null) {
            remove.f2152a = 0;
            remove.f2153b = null;
            remove.f2154c = null;
            a.f2151d.a(remove);
        }
    }
}
