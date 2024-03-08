package h3;

import android.graphics.drawable.Drawable;
import g3.d;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class c<T> implements g<T> {

    /* renamed from: f  reason: collision with root package name */
    public final int f4380f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4381g;

    /* renamed from: h  reason: collision with root package name */
    public d f4382h;

    public c() {
        if (l.i(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            this.f4380f = Integer.MIN_VALUE;
            this.f4381g = Integer.MIN_VALUE;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
    }

    @Override // com.bumptech.glide.manager.g
    public final void a() {
    }

    @Override // h3.g
    public final void b(d dVar) {
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
    public final d h() {
        return this.f4382h;
    }

    @Override // com.bumptech.glide.manager.g
    public final void k() {
    }
}
