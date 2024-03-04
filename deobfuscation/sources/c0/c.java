package c0;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a */
    public final String f2466a;

    /* renamed from: b */
    public final long f2467b;

    /* renamed from: c */
    public final int f2468c;

    public c(String str, long j5, int i7) {
        r5.h.f(str, "name");
        this.f2466a = str;
        this.f2467b = j5;
        this.f2468c = i7;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i7 < -1 || i7 > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    public abstract float[] a(float[] fArr);

    public abstract float b(int i7);

    public abstract float c(int i7);

    public boolean d() {
        return false;
    }

    public long e(float f7, float f8, float f9) {
        float[] f10 = f(new float[]{f7, f8, f9});
        return (Float.floatToIntBits(f10[0]) << 32) | (4294967295L & Float.floatToIntBits(f10[1]));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f2468c == cVar.f2468c && r5.h.a(this.f2466a, cVar.f2466a)) {
            return b.a(this.f2467b, cVar.f2467b);
        }
        return false;
    }

    public abstract float[] f(float[] fArr);

    public float g(float f7, float f8, float f9) {
        return f(new float[]{f7, f8, f9})[2];
    }

    public long h(float f7, float f8, float f9, float f10, c cVar) {
        r5.h.f(cVar, "colorSpace");
        long j5 = this.f2467b;
        int i7 = b.e;
        float[] fArr = new float[(int) (j5 >> 32)];
        fArr[0] = f7;
        fArr[1] = f8;
        fArr[2] = f9;
        float[] a7 = a(fArr);
        return a0.e.a(a7[0], a7[1], a7[2], f10, cVar);
    }

    public int hashCode() {
        long j5 = this.f2467b;
        int i7 = b.e;
        return ((Long.hashCode(j5) + (this.f2466a.hashCode() * 31)) * 31) + this.f2468c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2466a);
        sb.append(" (id=");
        sb.append(this.f2468c);
        sb.append(", model=");
        long j5 = this.f2467b;
        sb.append((Object) (b.a(j5, b.f2462a) ? "Rgb" : b.a(j5, b.f2463b) ? "Xyz" : b.a(j5, b.f2464c) ? "Lab" : b.a(j5, b.f2465d) ? "Cmyk" : "Unknown"));
        sb.append(')');
        return sb.toString();
    }
}
