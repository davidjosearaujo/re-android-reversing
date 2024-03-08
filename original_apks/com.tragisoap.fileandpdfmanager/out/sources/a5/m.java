package a5;

import i6.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m {

    /* renamed from: d  reason: collision with root package name */
    public static final g f214d = g.b(":status");
    public static final g e = g.b(":method");

    /* renamed from: f  reason: collision with root package name */
    public static final g f215f = g.b(":path");

    /* renamed from: g  reason: collision with root package name */
    public static final g f216g = g.b(":scheme");

    /* renamed from: h  reason: collision with root package name */
    public static final g f217h = g.b(":authority");

    /* renamed from: i  reason: collision with root package name */
    public static final g f218i = g.b(":host");

    /* renamed from: j  reason: collision with root package name */
    public static final g f219j = g.b(":version");

    /* renamed from: a  reason: collision with root package name */
    public final g f220a;

    /* renamed from: b  reason: collision with root package name */
    public final g f221b;

    /* renamed from: c  reason: collision with root package name */
    public final int f222c;

    public m(g gVar, g gVar2) {
        this.f220a = gVar;
        this.f221b = gVar2;
        this.f222c = gVar.f4501f.length + 32 + gVar2.f4501f.length;
    }

    public m(g gVar, String str) {
        this(gVar, g.b(str));
    }

    public m(String str, String str2) {
        this(g.b(str), g.b(str2));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f220a.equals(mVar.f220a) && this.f221b.equals(mVar.f221b);
    }

    public final int hashCode() {
        return this.f221b.hashCode() + ((this.f220a.hashCode() + 527) * 31);
    }

    public final String toString() {
        return String.format("%s: %s", this.f220a.f(), this.f221b.f());
    }
}
