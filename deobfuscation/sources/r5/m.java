package r5;

/* loaded from: classes.dex */
public final class m implements c {

    /* renamed from: a */
    public final Class<?> f5922a;

    public m(Class cls) {
        h.f(cls, "jClass");
        this.f5922a = cls;
    }

    @Override // r5.c
    public final Class<?> a() {
        return this.f5922a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m) && h.a(this.f5922a, ((m) obj).f5922a);
    }

    public final int hashCode() {
        return this.f5922a.hashCode();
    }

    public final String toString() {
        return this.f5922a.toString() + " (Kotlin reflection is not available)";
    }
}
