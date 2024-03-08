package k3;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b<K, V> extends o.b<K, V> {

    /* renamed from: n */
    public int f4691n;

    @Override // o.h, java.util.Map
    public final void clear() {
        this.f4691n = 0;
        super.clear();
    }

    @Override // o.h, java.util.Map, java.lang.Object
    public final int hashCode() {
        if (this.f4691n == 0) {
            this.f4691n = super.hashCode();
        }
        return this.f4691n;
    }

    @Override // o.h
    public final void i(o.b bVar) {
        this.f4691n = 0;
        super.i(bVar);
    }

    @Override // o.h
    public final V j(int i7) {
        this.f4691n = 0;
        return (V) super.j(i7);
    }

    @Override // o.h
    public final V k(int i7, V v6) {
        this.f4691n = 0;
        return (V) super.k(i7, v6);
    }

    @Override // o.h, java.util.Map
    public final V put(K k6, V v6) {
        this.f4691n = 0;
        return (V) super.put(k6, v6);
    }
}
