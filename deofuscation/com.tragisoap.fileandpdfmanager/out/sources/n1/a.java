package n1;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import n1.e;
import n1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f5108d = Character.toString(8206);
    public static final String e = Character.toString(8207);

    /* renamed from: f  reason: collision with root package name */
    public static final a f5109f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f5110g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5111a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5112b;

    /* renamed from: c  reason: collision with root package name */
    public final d f5113c;

    /* renamed from: n1.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0082a {
        public static final byte[] e = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f5114a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5115b;

        /* renamed from: c  reason: collision with root package name */
        public int f5116c;

        /* renamed from: d  reason: collision with root package name */
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
        f5109f = new a(false, 2, dVar);
        f5110g = new a(true, 2, dVar);
    }

    public a(boolean z6, int i7, e.d dVar) {
        this.f5111a = z6;
        this.f5112b = i7;
        this.f5113c = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
        if (r3 != 0) goto L_0x0073;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r4 == 0) goto L_0x0077;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (r0.f5116c <= 0) goto L_0x0091;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
        switch(r0.a()) {
            case 14: goto L_0x008a;
            case 15: goto L_0x008a;
            case 16: goto L_0x0086;
            case 17: goto L_0x0086;
            case 18: goto L_0x0083;
            default: goto L_0x0082;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        if (r3 != r5) goto L_0x008e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
        if (r3 != r5) goto L_0x008e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008e, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
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
        L_0x000d:
            int r6 = r0.f5116c
            int r7 = r0.f5115b
            if (r6 >= r7) goto L_0x0070
            if (r3 != 0) goto L_0x0070
            java.lang.CharSequence r7 = r0.f5114a
            char r6 = r7.charAt(r6)
            r0.f5117d = r6
            boolean r6 = java.lang.Character.isHighSurrogate(r6)
            if (r6 == 0) goto L_0x0039
            java.lang.CharSequence r6 = r0.f5114a
            int r7 = r0.f5116c
            int r6 = java.lang.Character.codePointAt(r6, r7)
            int r7 = r0.f5116c
            int r8 = java.lang.Character.charCount(r6)
            int r8 = r8 + r7
            r0.f5116c = r8
            byte r6 = java.lang.Character.getDirectionality(r6)
            goto L_0x004d
        L_0x0039:
            int r6 = r0.f5116c
            int r6 = r6 + r2
            r0.f5116c = r6
            char r6 = r0.f5117d
            r7 = 1792(0x700, float:2.511E-42)
            if (r6 >= r7) goto L_0x0049
            byte[] r7 = n1.a.C0082a.e
            byte r6 = r7[r6]
            goto L_0x004d
        L_0x0049:
            byte r6 = java.lang.Character.getDirectionality(r6)
        L_0x004d:
            if (r6 == 0) goto L_0x006b
            if (r6 == r2) goto L_0x0068
            r7 = 2
            if (r6 == r7) goto L_0x0068
            r7 = 9
            if (r6 == r7) goto L_0x000d
            switch(r6) {
                case 14: goto L_0x0064;
                case 15: goto L_0x0064;
                case 16: goto L_0x0060;
                case 17: goto L_0x0060;
                case 18: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x006e
        L_0x005c:
            int r5 = r5 + -1
            r4 = r9
            goto L_0x000d
        L_0x0060:
            int r5 = r5 + 1
            r4 = r2
            goto L_0x000d
        L_0x0064:
            int r5 = r5 + 1
            r4 = r1
            goto L_0x000d
        L_0x0068:
            if (r5 != 0) goto L_0x006e
            goto L_0x0088
        L_0x006b:
            if (r5 != 0) goto L_0x006e
            goto L_0x008c
        L_0x006e:
            r3 = r5
            goto L_0x000d
        L_0x0070:
            if (r3 != 0) goto L_0x0073
            goto L_0x0091
        L_0x0073:
            if (r4 == 0) goto L_0x0077
            r9 = r4
            goto L_0x0091
        L_0x0077:
            int r4 = r0.f5116c
            if (r4 <= 0) goto L_0x0091
            byte r4 = r0.a()
            switch(r4) {
                case 14: goto L_0x008a;
                case 15: goto L_0x008a;
                case 16: goto L_0x0086;
                case 17: goto L_0x0086;
                case 18: goto L_0x0083;
                default: goto L_0x0082;
            }
        L_0x0082:
            goto L_0x0077
        L_0x0083:
            int r5 = r5 + 1
            goto L_0x0077
        L_0x0086:
            if (r3 != r5) goto L_0x008e
        L_0x0088:
            r9 = r2
            goto L_0x0091
        L_0x008a:
            if (r3 != r5) goto L_0x008e
        L_0x008c:
            r9 = r1
            goto L_0x0091
        L_0x008e:
            int r5 = r5 + -1
            goto L_0x0077
        L_0x0091:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.a.a(java.lang.CharSequence):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(java.lang.CharSequence r6) {
        /*
            n1.a$a r0 = new n1.a$a
            r0.<init>(r6)
            int r6 = r0.f5115b
            r0.f5116c = r6
            r6 = 0
            r1 = r6
        L_0x000b:
            r2 = r1
        L_0x000c:
            int r3 = r0.f5116c
            r4 = 1
            if (r3 <= 0) goto L_0x0041
            byte r3 = r0.a()
            if (r3 == 0) goto L_0x0039
            if (r3 == r4) goto L_0x0032
            r5 = 2
            if (r3 == r5) goto L_0x0032
            r5 = 9
            if (r3 == r5) goto L_0x000c
            switch(r3) {
                case 14: goto L_0x002c;
                case 15: goto L_0x002c;
                case 16: goto L_0x0029;
                case 17: goto L_0x0029;
                case 18: goto L_0x0026;
                default: goto L_0x0023;
            }
        L_0x0023:
            if (r1 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0026:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0029:
            if (r1 != r2) goto L_0x002f
            goto L_0x0034
        L_0x002c:
            if (r1 != r2) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            int r2 = r2 + -1
            goto L_0x000c
        L_0x0032:
            if (r2 != 0) goto L_0x0036
        L_0x0034:
            r6 = r4
            goto L_0x0041
        L_0x0036:
            if (r1 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0039:
            if (r2 != 0) goto L_0x003d
        L_0x003b:
            r6 = -1
            goto L_0x0041
        L_0x003d:
            if (r1 != 0) goto L_0x000c
        L_0x003f:
            r1 = r2
            goto L_0x000b
        L_0x0041:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.a.b(java.lang.CharSequence):int");
    }

    public static a c() {
        Locale locale = Locale.getDefault();
        int i7 = f.f5129a;
        boolean z6 = true;
        if (f.a.a(locale) != 1) {
            z6 = false;
        }
        return z6 ? f5110g : f5109f;
    }

    public final SpannableStringBuilder d(CharSequence charSequence, d dVar) {
        if (charSequence == null) {
            return null;
        }
        boolean z6 = false;
        boolean b2 = ((e.c) dVar).b(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if ((this.f5112b & 2) != 0) {
            z6 = true;
        }
        String str = "";
        if (z6) {
            boolean b7 = (b2 ? e.f5123b : e.f5122a).b(charSequence, charSequence.length());
            spannableStringBuilder.append((CharSequence) ((this.f5111a || (!b7 && a(charSequence) != 1)) ? (!this.f5111a || (b7 && a(charSequence) != -1)) ? str : e : f5108d));
        }
        if (b2 != this.f5111a) {
            spannableStringBuilder.append(b2 ? (char) 8235 : 8234);
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
