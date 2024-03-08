package h1;

import android.content.res.ColorStateList;
import android.graphics.Shader;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: a */
    public final Shader f4339a;

    /* renamed from: b */
    public final ColorStateList f4340b;

    /* renamed from: c */
    public int f4341c;

    public c(Shader shader, ColorStateList colorStateList, int i7) {
        this.f4339a = shader;
        this.f4340b = colorStateList;
        this.f4341c = i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x017e, code lost:
        if (r8.size() <= 0) goto L_0x0186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0180, code lost:
        r0 = new h1.e((java.util.ArrayList) r8, (java.util.ArrayList) r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0186, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0187, code lost:
        if (r0 == null) goto L_0x018a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x018c, code lost:
        if (r19 == false) goto L_0x0192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x018e, code lost:
        r0 = new h1.e(r5, r6, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0192, code lost:
        r0 = new h1.e(r5, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0196, code lost:
        if (r11 == 1) goto L_0x01cc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0199, code lost:
        if (r11 == 2) goto L_0x01be;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x019b, code lost:
        r4 = r0.f4351a;
        r0 = r0.f4352b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01a1, code lost:
        if (r7 == 1) goto L_0x01ab;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01a3, code lost:
        if (r7 == 2) goto L_0x01a8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a5, code lost:
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01a8, code lost:
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ab, code lost:
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01ad, code lost:
        r3 = new android.graphics.LinearGradient(r12, r26, (float) r14, (float) r15, r4, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01be, code lost:
        r3 = new android.graphics.SweepGradient((float) r7, (float) r9, r0.f4351a, r0.f4352b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01d3, code lost:
        if (r8 <= 0.0f) goto L_0x0202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01d5, code lost:
        r1 = r0.f4351a;
        r0 = r0.f4352b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01dc, code lost:
        if (r7 == 1) goto L_0x01e7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01df, code lost:
        if (r7 == 2) goto L_0x01e4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01e1, code lost:
        r5 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01e4, code lost:
        r5 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e7, code lost:
        r5 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e9, code lost:
        r3 = new android.graphics.RadialGradient((float) r7, (float) r9, (float) r8, r1, r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0201, code lost:
        return new h1.c(r3, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0209, code lost:
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.util.ArrayList, float] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.ArrayList, float] */
    /* JADX WARN: Unknown variable types count: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static h1.c a(android.content.res.Resources r29, int r30, android.content.res.Resources.Theme r31) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.c.a(android.content.res.Resources, int, android.content.res.Resources$Theme):h1.c");
    }

    public final boolean b() {
        ColorStateList colorStateList;
        return this.f4339a == null && (colorStateList = this.f4340b) != null && colorStateList.isStateful();
    }
}
