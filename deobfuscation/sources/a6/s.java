package a6;

import i5.f;

/* loaded from: classes.dex */
public final class s {

    /* loaded from: classes.dex */
    public static final class a extends r5.i implements q5.p<i5.f, f.b, i5.f> {

        /* renamed from: g */
        public static final a f331g = new a();

        public a() {
            super(2);
        }

        @Override // q5.p
        public final i5.f i(i5.f fVar, f.b bVar) {
            i5.f fVar2 = fVar;
            f.b bVar2 = bVar;
            return bVar2 instanceof r ? fVar2.s(((r) bVar2).p()) : fVar2.s(bVar2);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends r5.i implements q5.p<i5.f, f.b, i5.f> {

        /* renamed from: g */
        public final /* synthetic */ r5.s<i5.f> f332g;

        /* renamed from: h */
        public final /* synthetic */ boolean f333h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r5.s<i5.f> sVar, boolean z6) {
            super(2);
            this.f332g = sVar;
            this.f333h = z6;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [i5.f, T] */
        @Override // q5.p
        public final i5.f i(i5.f fVar, f.b bVar) {
            i5.f N;
            i5.f fVar2 = fVar;
            f.b bVar2 = bVar;
            if (bVar2 instanceof r) {
                if (this.f332g.f5927f.e(bVar2.getKey()) == null) {
                    N = this.f333h ? ((r) bVar2).p() : (r) bVar2;
                } else {
                    r5.s<i5.f> sVar = this.f332g;
                    sVar.f5927f = sVar.f5927f.k(bVar2.getKey());
                    N = ((r) bVar2).N();
                }
                return fVar2.s(N);
            }
            return fVar2.s(bVar2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final i5.f a(i5.f fVar, i5.f fVar2, boolean z6) {
        Boolean bool = Boolean.FALSE;
        t tVar = t.f336g;
        boolean booleanValue = ((Boolean) fVar.q(bool, tVar)).booleanValue();
        boolean booleanValue2 = ((Boolean) fVar2.q(bool, tVar)).booleanValue();
        if (booleanValue || booleanValue2) {
            r5.s sVar = new r5.s();
            sVar.f5927f = fVar2;
            i5.g gVar = i5.g.f4488f;
            i5.f fVar3 = (i5.f) fVar.q(gVar, new b(sVar, z6));
            if (booleanValue2) {
                sVar.f5927f = ((i5.f) sVar.f5927f).q(gVar, a.f331g);
            }
            return fVar3.s((i5.f) sVar.f5927f);
        }
        return fVar.s(fVar2);
    }

    public static final n1<?> b(i5.d<?> dVar, i5.f fVar, Object obj) {
        n1<?> n1Var = null;
        if (dVar instanceof k5.d) {
            if (fVar.e(o1.f325f) != null) {
                k5.d dVar2 = (k5.d) dVar;
                while (true) {
                    if (!(dVar2 instanceof f0) && (dVar2 = dVar2.g()) != null) {
                        if (dVar2 instanceof n1) {
                            n1Var = (n1) dVar2;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (n1Var != null) {
                    n1Var.n0(fVar, obj);
                }
                return n1Var;
            }
            return null;
        }
        return null;
    }
}
