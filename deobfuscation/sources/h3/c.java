package h3;

import android.graphics.drawable.Drawable;
import k3.l;

/* loaded from: classes.dex */
public abstract class c<T> implements g<T> {

    /* renamed from: f */
    public final int f4380f;

    /* renamed from: g */
    public final int f4381g;

    /* renamed from: h */
    public g3.d f4382h;

    public c() {
        if (!l.i(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f4380f = Integer.MIN_VALUE;
        this.f4381g = Integer.MIN_VALUE;
    }

    @Override // com.bumptech.glide.manager.g
    public final void a() {
    }

    @Override // h3.g
    public final void b(g3.d dVar) {
        this.f4382h = dVar;
    }

    @Override // h3.g
    public final void c(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.g
    public final void d() {
    }

    @Override // h3.g
    public final void e(f fVar) {
    }

    @Override // h3.g
    public final void f(f fVar) {
        fVar.b(this.f4380f, this.f4381g);
    }

    @Override // h3.g
    public final void g(Drawable drawable) {
    }

    @Override // h3.g
    public final g3.d h() {
        return this.f4382h;
    }

    @Override // com.bumptech.glide.manager.g
    public final void k() {
    }
}
