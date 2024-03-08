package z5;

import r5.h;
import w5.a;
import w5.b;
import w5.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class i extends f {
    public static final int X(CharSequence charSequence) {
        h.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int Y(CharSequence charSequence, String str, int i7, boolean z6) {
        h.f(charSequence, "<this>");
        h.f(str, "string");
        return (z6 || !(charSequence instanceof String)) ? Z(charSequence, str, i7, charSequence.length(), z6, false) : ((String) charSequence).indexOf(str, i7);
    }

    public static final int Z(CharSequence charSequence, CharSequence charSequence2, int i7, int i8, boolean z6, boolean z7) {
        a aVar;
        if (!z7) {
            if (i7 < 0) {
                i7 = 0;
            }
            int length = charSequence.length();
            if (i8 > length) {
                i8 = length;
            }
            aVar = new c(i7, i8);
        } else {
            int X = X(charSequence);
            if (i7 > X) {
                i7 = X;
            }
            if (i8 < 0) {
                i8 = 0;
            }
            aVar = new a(i7, i8, -1);
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int i9 = aVar.f6411f;
            int i10 = aVar.f6412g;
            int i11 = aVar.f6413h;
            if ((i11 > 0 && i9 <= i10) || (i11 < 0 && i10 <= i9)) {
                while (!c0(charSequence2, charSequence, i9, charSequence2.length(), z6)) {
                    if (i9 != i10) {
                        i9 += i11;
                    }
                }
                return i9;
            }
        } else {
            int i12 = aVar.f6411f;
            int i13 = aVar.f6412g;
            int i14 = aVar.f6413h;
            if ((i14 > 0 && i12 <= i13) || (i14 < 0 && i13 <= i12)) {
                while (!f.W(0, i12, charSequence2.length(), (String) charSequence2, (String) charSequence, z6)) {
                    if (i12 != i13) {
                        i12 += i14;
                    }
                }
                return i12;
            }
        }
        return -1;
    }

    public static /* synthetic */ int a0(CharSequence charSequence, String str, int i7, boolean z6, int i8) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z6 = false;
        }
        return Y(charSequence, str, i7, z6);
    }

    public static int b0(String str, char c7, boolean z6, int i7) {
        boolean z7;
        if ((i7 & 4) != 0) {
            z6 = false;
        }
        if (!z6) {
            return str.indexOf(c7, 0);
        }
        char[] cArr = {c7};
        if (!z6) {
            return str.indexOf(c7, 0);
        }
        c cVar = new c(0, X(str));
        b bVar = new b(0, cVar.f6412g, cVar.f6413h);
        while (bVar.f6416h) {
            int nextInt = bVar.nextInt();
            char charAt = str.charAt(nextInt);
            int i8 = 0;
            while (true) {
                if (i8 >= 1) {
                    z7 = false;
                    continue;
                    break;
                } else if (q2.a.s(cArr[i8], charAt, z6)) {
                    z7 = true;
                    continue;
                    break;
                } else {
                    i8++;
                }
            }
            if (z7) {
                return nextInt;
            }
        }
        return -1;
    }

    public static final boolean c0(CharSequence charSequence, CharSequence charSequence2, int i7, int i8, boolean z6) {
        h.f(charSequence, "<this>");
        h.f(charSequence2, "other");
        if (i7 < 0 || charSequence.length() - i8 < 0 || i7 > charSequence2.length() - i8) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (!q2.a.s(charSequence.charAt(0 + i9), charSequence2.charAt(i7 + i9), z6)) {
                return false;
            }
        }
        return true;
    }

    public static String d0(String str, String str2) {
        h.f(str2, "delimiter");
        int a02 = a0(str, str2, 0, false, 6);
        if (a02 == -1) {
            return str;
        }
        String substring = str.substring(str2.length() + a02, str.length());
        h.e(substring, "substring(...)");
        return substring;
    }

    public static String e0(String str) {
        h.f(str, "<this>");
        h.f(str, "missingDelimiterValue");
        int lastIndexOf = str.lastIndexOf(46, X(str));
        if (lastIndexOf == -1) {
            return str;
        }
        String substring = str.substring(lastIndexOf + 1, str.length());
        h.e(substring, "substring(...)");
        return substring;
    }
}
