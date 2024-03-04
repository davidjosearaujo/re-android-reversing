package h1;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* loaded from: classes.dex */
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

    /* JADX WARN: Code restructure failed: missing block: B:359:0x017e, code lost:
        if (r8.size() <= 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0180, code lost:
        r0 = new h1.e((java.util.ArrayList) r8, (java.util.ArrayList) r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0186, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0187, code lost:
        if (r0 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x018c, code lost:
        if (r19 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x018e, code lost:
        r0 = new h1.e(r5, r6, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0192, code lost:
        r0 = new h1.e(r5, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0196, code lost:
        if (r11 == 1) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0199, code lost:
        if (r11 == 2) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x019b, code lost:
        r4 = r0.f4351a;
        r0 = r0.f4352b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x01a1, code lost:
        if (r7 == 1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x01a3, code lost:
        if (r7 == 2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x01a5, code lost:
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x01a8, code lost:
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x01ab, code lost:
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x01ad, code lost:
        r3 = new android.graphics.LinearGradient(r12, r26, r25, (float) r15, r4, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x01be, code lost:
        r3 = new android.graphics.SweepGradient((float) r7, (float) r9, r0.f4351a, r0.f4352b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x01d3, code lost:
        if (r8 <= 0.0f) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x01d5, code lost:
        r1 = r0.f4351a;
        r0 = r0.f4352b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x01dc, code lost:
        if (r7 == 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x01df, code lost:
        if (r7 == 2) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x01e1, code lost:
        r5 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x01e4, code lost:
        r5 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x01e7, code lost:
        r5 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x01e9, code lost:
        r3 = new android.graphics.RadialGradient((float) r7, (float) r9, (float) r8, r1, r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0201, code lost:
        return new h1.c(r3, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0209, code lost:
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Type inference failed for: r15v2, types: [float, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v9, types: [float, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static h1.c a(android.content.res.Resources r29, int r30, android.content.res.Resources.Theme r31) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.c.a(android.content.res.Resources, int, android.content.res.Resources$Theme):h1.c");
    }

    public final boolean b() {
        ColorStateList colorStateList;
        return this.f4339a == null && (colorStateList = this.f4340b) != null && colorStateList.isStateful();
    }
}
