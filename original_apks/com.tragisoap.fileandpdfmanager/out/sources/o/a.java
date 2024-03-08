package o;

import java.util.Map;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends g<Object, Object> {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f5180d;

    public a(b bVar) {
        this.f5180d = bVar;
    }

    @Override // o.g
    public final void a() {
        this.f5180d.clear();
    }

    @Override // o.g
    public final Object b(int i7, int i8) {
        return this.f5180d.f5220g[(i7 << 1) + i8];
    }

    @Override // o.g
    public final Map<Object, Object> c() {
        return this.f5180d;
    }

    @Override // o.g
    public final int d() {
        return this.f5180d.f5221h;
    }

    @Override // o.g
    public final int e(Object obj) {
        return this.f5180d.e(obj);
    }

    @Override // o.g
    public final int f(Object obj) {
        return this.f5180d.g(obj);
    }

    @Override // o.g
    public final void g(Object obj, Object obj2) {
        this.f5180d.put(obj, obj2);
    }

    @Override // o.g
    public final void h(int i7) {
        this.f5180d.j(i7);
    }

    @Override // o.g
    public final Object i(int i7, Object obj) {
        return this.f5180d.k(i7, obj);
    }
}
