package y4;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: i */
    public static final char[] f6746i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public final String f6747a;

    /* renamed from: b */
    public final String f6748b;

    /* renamed from: c */
    public final String f6749c;

    /* renamed from: d */
    public final String f6750d;
    public final int e;

    /* renamed from: f */
    public final List<String> f6751f;

    /* renamed from: g */
    public final String f6752g;

    /* renamed from: h */
    public final String f6753h;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public String f6754a;

        /* renamed from: d */
        public String f6757d;

        /* renamed from: f */
        public final ArrayList f6758f;

        /* renamed from: g */
        public ArrayList f6759g;

        /* renamed from: h */
        public String f6760h;

        /* renamed from: b */
        public String f6755b = "";

        /* renamed from: c */
        public String f6756c = "";
        public int e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f6758f = arrayList;
            arrayList.add("");
        }

        /* JADX WARN: Code restructure failed: missing block: B:580:0x0078, code lost:
            r4 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:621:0x00f5, code lost:
            if (r9 == r0) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:622:0x00f7, code lost:
            if (r10 != (-1)) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:624:0x00fc, code lost:
            r1 = r9 - r10;
            java.lang.System.arraycopy(r7, r10, r7, 16 - r1, r1);
            r0 = 0;
            java.util.Arrays.fill(r7, r10, (16 - r9) + r10, (byte) 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:625:0x010b, code lost:
            r0 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:626:0x010c, code lost:
            r1 = java.net.InetAddress.getByAddress(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:663:0x0180, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Removed duplicated region for block: B:611:0x00c7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String b(int r16, int r17, java.lang.String r18) {
            /*
                Method dump skipped, instructions count: 443
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: y4.m.a.b(int, int, java.lang.String):java.lang.String");
        }

        public final m a() {
            if (this.f6754a != null) {
                if (this.f6757d != null) {
                    return new m(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        /* JADX WARN: Code restructure failed: missing block: B:828:0x008b, code lost:
            if (r7 == ':') goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:909:0x021b, code lost:
            if (r1 <= 65535) goto L197;
         */
        /* JADX WARN: Removed duplicated region for block: B:934:0x027e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:932:0x0278 -> B:933:0x027c). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int c(y4.m r21, java.lang.String r22) {
            /*
                Method dump skipped, instructions count: 897
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: y4.m.a.c(y4.m, java.lang.String):int");
        }

        public final void d() {
            int size = this.f6758f.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f6758f.set(i7, m.b((String) this.f6758f.get(i7), "[]", false, true));
            }
            ArrayList arrayList = this.f6759g;
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    String str = (String) this.f6759g.get(i8);
                    if (str != null) {
                        this.f6759g.set(i8, m.b(str, "\\^`{|}", true, true));
                    }
                }
            }
            String str2 = this.f6760h;
            if (str2 != null) {
                this.f6760h = m.b(str2, " \"#<>\\^`{|}", false, false);
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6754a);
            sb.append("://");
            if (!this.f6755b.isEmpty() || !this.f6756c.isEmpty()) {
                sb.append(this.f6755b);
                if (!this.f6756c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f6756c);
                }
                sb.append('@');
            }
            if (this.f6757d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f6757d);
                sb.append(']');
            } else {
                sb.append(this.f6757d);
            }
            int i7 = this.e;
            if (i7 == -1) {
                i7 = m.d(this.f6754a);
            }
            if (i7 != m.d(this.f6754a)) {
                sb.append(':');
                sb.append(i7);
            }
            ArrayList arrayList = this.f6758f;
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                sb.append('/');
                sb.append((String) arrayList.get(i8));
            }
            if (this.f6759g != null) {
                sb.append('?');
                m.j(sb, this.f6759g);
            }
            if (this.f6760h != null) {
                sb.append('#');
                sb.append(this.f6760h);
            }
            return sb.toString();
        }
    }

    public m(a aVar) {
        this.f6747a = aVar.f6754a;
        String str = aVar.f6755b;
        this.f6748b = l(str, 0, str.length(), false);
        String str2 = aVar.f6756c;
        this.f6749c = l(str2, 0, str2.length(), false);
        this.f6750d = aVar.f6757d;
        int i7 = aVar.e;
        this.e = i7 == -1 ? d(aVar.f6754a) : i7;
        m(aVar.f6758f, false);
        ArrayList arrayList = aVar.f6759g;
        this.f6751f = arrayList != null ? m(arrayList, true) : null;
        String str3 = aVar.f6760h;
        this.f6752g = str3 != null ? l(str3, 0, str3.length(), false) : null;
        this.f6753h = aVar.toString();
    }

    public static String a(String str, int i7, int i8, String str2, boolean z6, boolean z7, boolean z8) {
        int i9 = i7;
        while (i9 < i8) {
            int codePointAt = str.codePointAt(i9);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z8) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && !z6) || (codePointAt == 43 && z7)))) {
                i6.d dVar = new i6.d();
                dVar.G(i7, i9, str);
                i6.d dVar2 = null;
                while (i9 < i8) {
                    int codePointAt2 = str.codePointAt(i9);
                    if (!z6 || (codePointAt2 != 9 && codePointAt2 != 10 && codePointAt2 != 12 && codePointAt2 != 13)) {
                        if (codePointAt2 == 43 && z7) {
                            String str3 = z6 ? "+" : "%2B";
                            dVar.G(0, str3.length(), str3);
                        } else if (codePointAt2 < 32 || codePointAt2 == 127 || ((codePointAt2 >= 128 && z8) || str2.indexOf(codePointAt2) != -1 || (codePointAt2 == 37 && !z6))) {
                            if (dVar2 == null) {
                                dVar2 = new i6.d();
                            }
                            dVar2.J(codePointAt2);
                            while (!dVar2.x()) {
                                int readByte = dVar2.readByte() & 255;
                                dVar.z(37);
                                char[] cArr = f6746i;
                                dVar.z(cArr[(readByte >> 4) & 15]);
                                dVar.z(cArr[readByte & 15]);
                            }
                        } else {
                            dVar.J(codePointAt2);
                        }
                    }
                    i9 += Character.charCount(codePointAt2);
                }
                return dVar.m();
            }
            i9 += Character.charCount(codePointAt);
        }
        return str.substring(i7, i8);
    }

    public static String b(String str, String str2, boolean z6, boolean z7) {
        return a(str, 0, str.length(), str2, true, z6, z7);
    }

    public static int c(char c7) {
        if (c7 < '0' || c7 > '9') {
            char c8 = 'a';
            if (c7 < 'a' || c7 > 'f') {
                c8 = 'A';
                if (c7 < 'A' || c7 > 'F') {
                    return -1;
                }
            }
            return (c7 - c8) + 10;
        }
        return c7 - '0';
    }

    public static int d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static int e(String str, int i7, int i8, String str2) {
        while (i7 < i8) {
            if (str2.indexOf(str.charAt(i7)) != -1) {
                return i7;
            }
            i7++;
        }
        return i8;
    }

    public static void j(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7 += 2) {
            String str = list.get(i7);
            String str2 = list.get(i7 + 1);
            if (i7 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static String l(String str, int i7, int i8, boolean z6) {
        int i9;
        int i10 = i7;
        while (i10 < i8) {
            char charAt = str.charAt(i10);
            if (charAt == '%' || (charAt == '+' && z6)) {
                i6.d dVar = new i6.d();
                dVar.G(i7, i10, str);
                while (i10 < i8) {
                    int codePointAt = str.codePointAt(i10);
                    if (codePointAt != 37 || (i9 = i10 + 2) >= i8) {
                        if (codePointAt == 43 && z6) {
                            dVar.z(32);
                        }
                        dVar.J(codePointAt);
                    } else {
                        int c7 = c(str.charAt(i10 + 1));
                        int c8 = c(str.charAt(i9));
                        if (c7 != -1 && c8 != -1) {
                            dVar.z((c7 << 4) + c8);
                            i10 = i9;
                        }
                        dVar.J(codePointAt);
                    }
                    i10 += Character.charCount(codePointAt);
                }
                return dVar.m();
            }
            i10++;
        }
        return str.substring(i7, i8);
    }

    public static List m(List list, boolean z6) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            arrayList.add(str != null ? l(str, 0, str.length(), z6) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static ArrayList n(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 <= str.length()) {
            int indexOf = str.indexOf(38, i7);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i7);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i7, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i7, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i7 = indexOf + 1;
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m) && ((m) obj).f6753h.equals(this.f6753h);
    }

    public final String f() {
        if (this.f6749c.isEmpty()) {
            return "";
        }
        int indexOf = this.f6753h.indexOf(64);
        return this.f6753h.substring(this.f6753h.indexOf(58, this.f6747a.length() + 3) + 1, indexOf);
    }

    public final ArrayList g() {
        int indexOf = this.f6753h.indexOf(47, this.f6747a.length() + 3);
        String str = this.f6753h;
        int e = e(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < e) {
            int i7 = indexOf + 1;
            int e7 = e(this.f6753h, i7, e, "/");
            arrayList.add(this.f6753h.substring(i7, e7));
            indexOf = e7;
        }
        return arrayList;
    }

    public final String h() {
        if (this.f6751f == null) {
            return null;
        }
        int indexOf = this.f6753h.indexOf(63) + 1;
        String str = this.f6753h;
        return this.f6753h.substring(indexOf, e(str, indexOf + 1, str.length(), "#"));
    }

    public final int hashCode() {
        return this.f6753h.hashCode();
    }

    public final String i() {
        if (this.f6748b.isEmpty()) {
            return "";
        }
        int length = this.f6747a.length() + 3;
        String str = this.f6753h;
        return this.f6753h.substring(length, e(str, length, str.length(), ":@"));
    }

    public final a k() {
        a aVar = new a();
        aVar.f6754a = this.f6747a;
        aVar.f6755b = i();
        aVar.f6756c = f();
        aVar.f6757d = this.f6750d;
        aVar.e = this.e != d(this.f6747a) ? this.e : -1;
        aVar.f6758f.clear();
        aVar.f6758f.addAll(g());
        String h7 = h();
        aVar.f6759g = h7 != null ? n(b(h7, " \"'<>#", true, true)) : null;
        aVar.f6760h = this.f6752g != null ? this.f6753h.substring(this.f6753h.indexOf(35) + 1) : null;
        return aVar;
    }

    public final URI o() {
        try {
            a k6 = k();
            k6.d();
            return new URI(k6.toString());
        } catch (URISyntaxException unused) {
            StringBuilder d7 = androidx.activity.h.d("not valid as a java.net.URI: ");
            d7.append(this.f6753h);
            throw new IllegalStateException(d7.toString());
        }
    }

    public final String toString() {
        return this.f6753h;
    }
}
