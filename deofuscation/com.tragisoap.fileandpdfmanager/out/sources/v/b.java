package v;

import f5.g;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class b extends c {

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f6122h = new int[0];

    /* renamed from: d  reason: collision with root package name */
    public final l<Object, g> f6123d;
    public final l<Object, g> e;

    /* renamed from: f  reason: collision with root package name */
    public int f6124f;

    /* renamed from: g  reason: collision with root package name */
    public q.b<k> f6125g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i7, e eVar, l<Object, g> lVar, l<Object, g> lVar2) {
        super(i7, eVar);
        h.f(eVar, "invalid");
        this.f6123d = lVar;
        this.e = lVar2;
    }

    @Override // v.c
    public final l<Object, g> d() {
        return this.f6123d;
    }

    @Override // v.c
    public boolean e() {
        return false;
    }

    @Override // v.c
    public int f() {
        return this.f6124f;
    }

    @Override // v.c
    public final l<Object, g> g() {
        return this.e;
    }

    @Override // v.c
    public void h(k kVar) {
        h.f(kVar, "state");
        q.b<k> j7 = j();
        if (j7 == null) {
            j7 = new q.b<>();
            k(j7);
        }
        j7.add(kVar);
    }

    @Override // v.c
    public void i(int i7) {
        this.f6124f = i7;
    }

    public q.b<k> j() {
        return this.f6125g;
    }

    public void k(q.b<k> bVar) {
        this.f6125g = bVar;
    }
}
