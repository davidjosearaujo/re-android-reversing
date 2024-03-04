package a5;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: d */
    public static final i6.g f214d = i6.g.b(":status");
    public static final i6.g e = i6.g.b(":method");

    /* renamed from: f */
    public static final i6.g f215f = i6.g.b(":path");

    /* renamed from: g */
    public static final i6.g f216g = i6.g.b(":scheme");

    /* renamed from: h */
    public static final i6.g f217h = i6.g.b(":authority");

    /* renamed from: i */
    public static final i6.g f218i = i6.g.b(":host");

    /* renamed from: j */
    public static final i6.g f219j = i6.g.b(":version");

    /* renamed from: a */
    public final i6.g f220a;

    /* renamed from: b */
    public final i6.g f221b;

    /* renamed from: c */
    public final int f222c;

    public m(i6.g gVar, i6.g gVar2) {
        this.f220a = gVar;
        this.f221b = gVar2;
        this.f222c = gVar.f4501f.length + 32 + gVar2.f4501f.length;
    }

    public m(i6.g gVar, String str) {
        this(gVar, i6.g.b(str));
    }

    public m(String str, String str2) {
        this(i6.g.b(str), i6.g.b(str2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            return this.f220a.equals(mVar.f220a) && this.f221b.equals(mVar.f221b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f221b.hashCode() + ((this.f220a.hashCode() + 527) * 31);
    }

    public final String toString() {
        return String.format("%s: %s", this.f220a.f(), this.f221b.f());
    }
}
