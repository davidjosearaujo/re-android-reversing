package o;

import java.util.Map;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends g<Object, Object> {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ d f5181d;

    public c(d dVar) {
        this.f5181d = dVar;
    }

    @Override // o.g
    public final void a() {
        this.f5181d.clear();
    }

    @Override // o.g
    public final Object b(int i7, int i8) {
        return this.f5181d.f5188g[i7];
    }

    @Override // o.g
    public final Map<Object, Object> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // o.g
    public final int d() {
        return this.f5181d.f5189h;
    }

    @Override // o.g
    public final int e(Object obj) {
        return this.f5181d.indexOf(obj);
    }

    @Override // o.g
    public final int f(Object obj) {
        return this.f5181d.indexOf(obj);
    }

    @Override // o.g
    public final void g(Object obj, Object obj2) {
        this.f5181d.add(obj);
    }

    @Override // o.g
    public final void h(int i7) {
        this.f5181d.e(i7);
    }

    @Override // o.g
    public final Object i(int i7, Object obj) {
        throw new UnsupportedOperationException("not a map");
    }
}
