package v;

/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: h */
    public static final int[] f6122h = new int[0];

    /* renamed from: d */
    public final q5.l<Object, f5.g> f6123d;
    public final q5.l<Object, f5.g> e;

    /* renamed from: f */
    public int f6124f;

    /* renamed from: g */
    public q.b<k> f6125g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i7, e eVar, q5.l<Object, f5.g> lVar, q5.l<Object, f5.g> lVar2) {
        super(i7, eVar);
        r5.h.f(eVar, "invalid");
        this.f6123d = lVar;
        this.e = lVar2;
    }

    @Override // v.c
    public final q5.l<Object, f5.g> d() {
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
    public final q5.l<Object, f5.g> g() {
        return this.e;
    }

    @Override // v.c
    public void h(k kVar) {
        r5.h.f(kVar, "state");
        q.b<k> j5 = j();
        if (j5 == null) {
            j5 = new q.b<>();
            k(j5);
        }
        j5.add(kVar);
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
