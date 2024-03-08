package a6;

import i5.d;
import i5.f;
import i5.g;
import q5.p;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements p<f, f.b, f> {

        /* renamed from: g  reason: collision with root package name */
        public static final a f331g = new a();

        public a() {
            super(2);
        }

        @Override // q5.p
        public final f i(f fVar, f.b bVar) {
            f fVar2 = fVar;
            f.b bVar2 = bVar;
            return bVar2 instanceof r ? fVar2.s(((r) bVar2).p()) : fVar2.s(bVar2);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b extends i implements p<f, f.b, f> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ r5.s<f> f332g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f333h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r5.s<f> sVar, boolean z6) {
            super(2);
            this.f332g = sVar;
            this.f333h = z6;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [i5.f, T] */
        @Override // q5.p
        public final f i(f fVar, f.b bVar) {
            f fVar2;
            f fVar3 = fVar;
            f.b bVar2 = bVar;
            if (!(bVar2 instanceof r)) {
                return fVar3.s(bVar2);
            }
            if (this.f332g.f5927f.e(bVar2.getKey()) == null) {
                fVar2 = this.f333h ? ((r) bVar2).p() : (r) bVar2;
            } else {
                r5.s<f> sVar = this.f332g;
                sVar.f5927f = sVar.f5927f.k(bVar2.getKey());
                fVar2 = ((r) bVar2).N();
            }
            return fVar3.s(fVar2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final f a(f fVar, f fVar2, boolean z6) {
        Boolean bool = Boolean.FALSE;
        t tVar = t.f336g;
        boolean booleanValue = ((Boolean) fVar.q(bool, tVar)).booleanValue();
        boolean booleanValue2 = ((Boolean) fVar2.q(bool, tVar)).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return fVar.s(fVar2);
        }
        r5.s sVar = new r5.s();
        sVar.f5927f = fVar2;
        g gVar = g.f4488f;
        f fVar3 = (f) fVar.q(gVar, new b(sVar, z6));
        if (booleanValue2) {
            sVar.f5927f = ((f) sVar.f5927f).q(gVar, a.f331g);
        }
        return fVar3.s((f) sVar.f5927f);
    }

    public static final n1<?> b(d<?> dVar, f fVar, Object obj) {
        n1<?> n1Var = null;
        if (!(dVar instanceof k5.d)) {
            return null;
        }
        if (!(fVar.e(o1.f325f) != null)) {
            return null;
        }
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
}
