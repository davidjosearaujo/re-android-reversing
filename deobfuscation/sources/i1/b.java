package i1;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class b {
    public static final b e = new b(0, 0, 0, 0);

    /* renamed from: a */
    public final int f4462a;

    /* renamed from: b */
    public final int f4463b;

    /* renamed from: c */
    public final int f4464c;

    /* renamed from: d */
    public final int f4465d;

    /* loaded from: classes.dex */
    public static class a {
        public static Insets a(int i7, int i8, int i9, int i10) {
            return Insets.of(i7, i8, i9, i10);
        }
    }

    public b(int i7, int i8, int i9, int i10) {
        this.f4462a = i7;
        this.f4463b = i8;
        this.f4464c = i9;
        this.f4465d = i10;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f4462a, bVar2.f4462a), Math.max(bVar.f4463b, bVar2.f4463b), Math.max(bVar.f4464c, bVar2.f4464c), Math.max(bVar.f4465d, bVar2.f4465d));
    }

    public static b b(int i7, int i8, int i9, int i10) {
        return (i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) ? e : new b(i7, i8, i9, i10);
    }

    public static b c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return a.a(this.f4462a, this.f4463b, this.f4464c, this.f4465d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4465d == bVar.f4465d && this.f4462a == bVar.f4462a && this.f4464c == bVar.f4464c && this.f4463b == bVar.f4463b;
    }

    public final int hashCode() {
        return (((((this.f4462a * 31) + this.f4463b) * 31) + this.f4464c) * 31) + this.f4465d;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("Insets{left=");
        d7.append(this.f4462a);
        d7.append(", top=");
        d7.append(this.f4463b);
        d7.append(", right=");
        d7.append(this.f4464c);
        d7.append(", bottom=");
        d7.append(this.f4465d);
        d7.append('}');
        return d7.toString();
    }
}
