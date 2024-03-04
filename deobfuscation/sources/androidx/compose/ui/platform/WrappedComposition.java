package androidx.compose.ui.platform;

import androidx.compose.ui.platform.AndroidComposeView;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
public final class WrappedComposition implements p.e, androidx.lifecycle.l {

    /* renamed from: f */
    public boolean f1135f;

    /* renamed from: g */
    public androidx.lifecycle.g f1136g;

    /* renamed from: h */
    public q5.p<? super p.b, ? super Integer, f5.g> f1137h;

    /* loaded from: classes.dex */
    public static final class a extends r5.i implements q5.l<AndroidComposeView.b, f5.g> {

        /* renamed from: h */
        public final /* synthetic */ q5.p<p.b, Integer, f5.g> f1139h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(q5.p<? super p.b, ? super Integer, f5.g> pVar) {
            super(1);
            WrappedComposition.this = r1;
            this.f1139h = pVar;
        }

        @Override // q5.l
        public final f5.g k(AndroidComposeView.b bVar) {
            AndroidComposeView.b bVar2 = bVar;
            r5.h.f(bVar2, "it");
            if (!WrappedComposition.this.f1135f) {
                androidx.lifecycle.o k6 = bVar2.f1123a.k();
                WrappedComposition wrappedComposition = WrappedComposition.this;
                wrappedComposition.f1137h = this.f1139h;
                if (wrappedComposition.f1136g == null) {
                    wrappedComposition.f1136g = k6;
                    k6.a(wrappedComposition);
                } else {
                    if (k6.f1876d.compareTo(g.b.CREATED) >= 0) {
                        WrappedComposition wrappedComposition2 = WrappedComposition.this;
                        wrappedComposition2.getClass();
                        t.b.c(-2000640158, true, new l0(wrappedComposition2, this.f1139h));
                        throw null;
                    }
                }
            }
            return f5.g.f4141a;
        }
    }

    @Override // p.e
    public final void a() {
        if (this.f1135f) {
            throw null;
        }
        this.f1135f = true;
        throw null;
    }

    @Override // androidx.lifecycle.l
    public final void c(androidx.lifecycle.n nVar, g.a aVar) {
        if (aVar == g.a.ON_DESTROY) {
            a();
        } else if (aVar != g.a.ON_CREATE || this.f1135f) {
        } else {
            d(this.f1137h);
        }
    }

    @Override // p.e
    public final void d(q5.p<? super p.b, ? super Integer, f5.g> pVar) {
        r5.h.f(pVar, "content");
        new a(pVar);
        throw null;
    }
}
