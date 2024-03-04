package l0;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a */
    public final o f4877a;

    /* renamed from: b */
    public final a f4878b;

    /* loaded from: classes.dex */
    public final class a extends j0.c implements l0.a {

        /* renamed from: h */
        public int f4879h = SubsamplingScaleImageView.TILE_SIZE_AUTO;

        /* renamed from: i */
        public int f4880i = 3;

        public a() {
            s.this = r3;
            long j5 = t0.f.f6007a;
            new q(this);
            new q.e(new a[16]);
        }

        @Override // j0.c
        public final int c() {
            return s.this.a().c();
        }

        public final void g() {
            s.this.getClass();
        }
    }

    public s(o oVar) {
        r5.h.f(oVar, "layoutNode");
        this.f4877a = oVar;
        this.f4878b = new a();
    }

    public final w a() {
        return this.f4877a.s.f4884b;
    }
}
