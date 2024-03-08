package c0;

import androidx.activity.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final double f2505a;

    /* renamed from: b  reason: collision with root package name */
    public final double f2506b;

    /* renamed from: c  reason: collision with root package name */
    public final double f2507c;

    /* renamed from: d  reason: collision with root package name */
    public final double f2508d;
    public final double e;

    /* renamed from: f  reason: collision with root package name */
    public final double f2509f = 0.0d;

    /* renamed from: g  reason: collision with root package name */
    public final double f2510g = 0.0d;

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
        if ((r5 == 0.0d) == false) goto L_0x006d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
        if ((r5 == 0.0d) != false) goto L_0x0095;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s(double r5, double r7, double r9, double r11, double r13) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.s.<init>(double, double, double, double, double):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return Double.compare(this.f2505a, sVar.f2505a) == 0 && Double.compare(this.f2506b, sVar.f2506b) == 0 && Double.compare(this.f2507c, sVar.f2507c) == 0 && Double.compare(this.f2508d, sVar.f2508d) == 0 && Double.compare(this.e, sVar.e) == 0 && Double.compare(this.f2509f, sVar.f2509f) == 0 && Double.compare(this.f2510g, sVar.f2510g) == 0;
    }

    public final int hashCode() {
        int hashCode = Double.hashCode(this.f2506b);
        int hashCode2 = Double.hashCode(this.f2507c);
        int hashCode3 = Double.hashCode(this.f2508d);
        int hashCode4 = Double.hashCode(this.e);
        int hashCode5 = Double.hashCode(this.f2509f);
        return Double.hashCode(this.f2510g) + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (Double.hashCode(this.f2505a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder d7 = h.d("TransferParameters(gamma=");
        d7.append(this.f2505a);
        d7.append(", a=");
        d7.append(this.f2506b);
        d7.append(", b=");
        d7.append(this.f2507c);
        d7.append(", c=");
        d7.append(this.f2508d);
        d7.append(", d=");
        d7.append(this.e);
        d7.append(", e=");
        d7.append(this.f2509f);
        d7.append(", f=");
        d7.append(this.f2510g);
        d7.append(')');
        return d7.toString();
    }
}
