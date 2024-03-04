package n1;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import n1.e;
import n1.f;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d */
    public static final String f5108d;
    public static final String e;

    /* renamed from: f */
    public static final a f5109f;

    /* renamed from: g */
    public static final a f5110g;

    /* renamed from: a */
    public final boolean f5111a;

    /* renamed from: b */
    public final int f5112b;

    /* renamed from: c */
    public final d f5113c;

    /* renamed from: n1.a$a */
    /* loaded from: classes.dex */
    public static class C0082a {
        public static final byte[] e = new byte[1792];

        /* renamed from: a */
        public final CharSequence f5114a;

        /* renamed from: b */
        public final int f5115b;

        /* renamed from: c */
        public int f5116c;

        /* renamed from: d */
        public char f5117d;

        static {
            for (int i7 = 0; i7 < 1792; i7++) {
                e[i7] = Character.getDirectionality(i7);
            }
        }

        public C0082a(CharSequence charSequence) {
            this.f5114a = charSequence;
            this.f5115b = charSequence.length();
        }

        public final byte a() {
            char charAt = this.f5114a.charAt(this.f5116c - 1);
            this.f5117d = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f5114a, this.f5116c);
                this.f5116c -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f5116c--;
            char c7 = this.f5117d;
            return c7 < 1792 ? e[c7] : Character.getDirectionality(c7);
        }
    }

    static {
        e.d dVar = e.f5124c;
        f5108d = Character.toString((char) 8206);
        e = Character.toString((char) 8207);
        f5109f = new a(false, 2, dVar);
        f5110g = new a(true, 2, dVar);
    }

    public a(boolean z6, int i7, e.d dVar) {
        this.f5111a = z6;
        this.f5112b = i7;
        this.f5113c = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:260:0x0070, code lost:
        if (r3 != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0073, code lost:
        if (r4 == 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0079, code lost:
        if (r0.f5116c <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x007f, code lost:
        switch(r0.a()) {
            case 14: goto L64;
            case 15: goto L64;
            case 16: goto L59;
            case 17: goto L59;
            case 18: goto L55;
            default: goto L67;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0083, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0086, code lost:
        if (r3 != r5) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x008a, code lost:
        if (r3 != r5) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x008e, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0091, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:?, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:?, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:?, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.CharSequence r9) {
        /*
            n1.a$a r0 = new n1.a$a
            r0.<init>(r9)
            r9 = 0
            r0.f5116c = r9
            r1 = -1
            r2 = 1
            r3 = r9
            r4 = r3
            r5 = r4
        Ld:
            int r6 = r0.f5116c
            int r7 = r0.f5115b
            if (r6 >= r7) goto L70
            if (r3 != 0) goto L70
            java.lang.CharSequence r7 = r0.f5114a
            char r6 = r7.charAt(r6)
            r0.f5117d = r6
            boolean r6 = java.lang.Character.isHighSurrogate(r6)
            if (r6 == 0) goto L39
            java.lang.CharSequence r6 = r0.f5114a
            int r7 = r0.f5116c
            int r6 = java.lang.Character.codePointAt(r6, r7)
            int r7 = r0.f5116c
            int r8 = java.lang.Character.charCount(r6)
            int r8 = r8 + r7
            r0.f5116c = r8
            byte r6 = java.lang.Character.getDirectionality(r6)
            goto L4d
        L39:
            int r6 = r0.f5116c
            int r6 = r6 + r2
            r0.f5116c = r6
            char r6 = r0.f5117d
            r7 = 1792(0x700, float:2.511E-42)
            if (r6 >= r7) goto L49
            byte[] r7 = n1.a.C0082a.e
            r6 = r7[r6]
            goto L4d
        L49:
            byte r6 = java.lang.Character.getDirectionality(r6)
        L4d:
            if (r6 == 0) goto L6b
            if (r6 == r2) goto L68
            r7 = 2
            if (r6 == r7) goto L68
            r7 = 9
            if (r6 == r7) goto Ld
            switch(r6) {
                case 14: goto L64;
                case 15: goto L64;
                case 16: goto L60;
                case 17: goto L60;
                case 18: goto L5c;
                default: goto L5b;
            }
        L5b:
            goto L6e
        L5c:
            int r5 = r5 + (-1)
            r4 = r9
            goto Ld
        L60:
            int r5 = r5 + 1
            r4 = r2
            goto Ld
        L64:
            int r5 = r5 + 1
            r4 = r1
            goto Ld
        L68:
            if (r5 != 0) goto L6e
            goto L88
        L6b:
            if (r5 != 0) goto L6e
            goto L8c
        L6e:
            r3 = r5
            goto Ld
        L70:
            if (r3 != 0) goto L73
            goto L91
        L73:
            if (r4 == 0) goto L77
            r9 = r4
            goto L91
        L77:
            int r4 = r0.f5116c
            if (r4 <= 0) goto L91
            byte r4 = r0.a()
            switch(r4) {
                case 14: goto L8a;
                case 15: goto L8a;
                case 16: goto L86;
                case 17: goto L86;
                case 18: goto L83;
                default: goto L82;
            }
        L82:
            goto L77
        L83:
            int r5 = r5 + 1
            goto L77
        L86:
            if (r3 != r5) goto L8e
        L88:
            r9 = r2
            goto L91
        L8a:
            if (r3 != r5) goto L8e
        L8c:
            r9 = r1
            goto L91
        L8e:
            int r5 = r5 + (-1)
            goto L77
        L91:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.a.a(java.lang.CharSequence):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:204:0x0041, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(java.lang.CharSequence r6) {
        /*
            n1.a$a r0 = new n1.a$a
            r0.<init>(r6)
            int r6 = r0.f5115b
            r0.f5116c = r6
            r6 = 0
            r1 = r6
        Lb:
            r2 = r1
        Lc:
            int r3 = r0.f5116c
            r4 = 1
            if (r3 <= 0) goto L41
            byte r3 = r0.a()
            if (r3 == 0) goto L39
            if (r3 == r4) goto L32
            r5 = 2
            if (r3 == r5) goto L32
            r5 = 9
            if (r3 == r5) goto Lc
            switch(r3) {
                case 14: goto L2c;
                case 15: goto L2c;
                case 16: goto L29;
                case 17: goto L29;
                case 18: goto L26;
                default: goto L23;
            }
        L23:
            if (r1 != 0) goto Lc
            goto L3f
        L26:
            int r2 = r2 + 1
            goto Lc
        L29:
            if (r1 != r2) goto L2f
            goto L34
        L2c:
            if (r1 != r2) goto L2f
            goto L3b
        L2f:
            int r2 = r2 + (-1)
            goto Lc
        L32:
            if (r2 != 0) goto L36
        L34:
            r6 = r4
            goto L41
        L36:
            if (r1 != 0) goto Lc
            goto L3f
        L39:
            if (r2 != 0) goto L3d
        L3b:
            r6 = -1
            goto L41
        L3d:
            if (r1 != 0) goto Lc
        L3f:
            r1 = r2
            goto Lb
        L41:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.a.b(java.lang.CharSequence):int");
    }

    public static a c() {
        Locale locale = Locale.getDefault();
        int i7 = f.f5129a;
        return f.a.a(locale) == 1 ? f5110g : f5109f;
    }

    public final SpannableStringBuilder d(CharSequence charSequence, d dVar) {
        if (charSequence == null) {
            return null;
        }
        boolean b2 = ((e.c) dVar).b(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str = "";
        if ((this.f5112b & 2) != 0) {
            boolean b7 = (b2 ? e.f5123b : e.f5122a).b(charSequence, charSequence.length());
            spannableStringBuilder.append((CharSequence) ((this.f5111a || !(b7 || a(charSequence) == 1)) ? (!this.f5111a || (b7 && a(charSequence) != -1)) ? "" : e : f5108d));
        }
        if (b2 != this.f5111a) {
            spannableStringBuilder.append(b2 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        boolean b8 = (b2 ? e.f5123b : e.f5122a).b(charSequence, charSequence.length());
        if (!this.f5111a && (b8 || b(charSequence) == 1)) {
            str = f5108d;
        } else if (this.f5111a && (!b8 || b(charSequence) == -1)) {
            str = e;
        }
        spannableStringBuilder.append((CharSequence) str);
        return spannableStringBuilder;
    }
}
