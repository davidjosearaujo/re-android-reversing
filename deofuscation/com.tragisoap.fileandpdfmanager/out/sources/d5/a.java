package d5;

import androidx.activity.h;
import javax.security.auth.x500.X500Principal;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f3641a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3642b;

    /* renamed from: c  reason: collision with root package name */
    public int f3643c;

    /* renamed from: d  reason: collision with root package name */
    public int f3644d;
    public int e;

    /* renamed from: f  reason: collision with root package name */
    public int f3645f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f3646g;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f3641a = name;
        this.f3642b = name.length();
    }

    public final int a(int i7) {
        int i8;
        int i9;
        int i10 = i7 + 1;
        if (i10 < this.f3642b) {
            char[] cArr = this.f3646g;
            char c7 = cArr[i7];
            if (c7 >= '0' && c7 <= '9') {
                i8 = c7 - '0';
            } else if (c7 >= 'a' && c7 <= 'f') {
                i8 = c7 - 'W';
            } else if (c7 < 'A' || c7 > 'F') {
                StringBuilder d7 = h.d("Malformed DN: ");
                d7.append(this.f3641a);
                throw new IllegalStateException(d7.toString());
            } else {
                i8 = c7 - '7';
            }
            char c8 = cArr[i10];
            if (c8 >= '0' && c8 <= '9') {
                i9 = c8 - '0';
            } else if (c8 >= 'a' && c8 <= 'f') {
                i9 = c8 - 'W';
            } else if (c8 < 'A' || c8 > 'F') {
                StringBuilder d8 = h.d("Malformed DN: ");
                d8.append(this.f3641a);
                throw new IllegalStateException(d8.toString());
            } else {
                i9 = c8 - '7';
            }
            return (i8 << 4) + i9;
        }
        StringBuilder d9 = h.d("Malformed DN: ");
        d9.append(this.f3641a);
        throw new IllegalStateException(d9.toString());
    }

    public final char b() {
        int i7;
        int i8 = this.f3643c + 1;
        this.f3643c = i8;
        if (i8 != this.f3642b) {
            char c7 = this.f3646g[i8];
            if (!(c7 == ' ' || c7 == '%' || c7 == '\\' || c7 == '_' || c7 == '\"' || c7 == '#')) {
                switch (c7) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c7) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                int a7 = a(i8);
                                this.f3643c++;
                                if (a7 >= 128) {
                                    if (a7 < 192 || a7 > 247) {
                                        return '?';
                                    }
                                    if (a7 <= 223) {
                                        a7 &= 31;
                                        i7 = 1;
                                    } else if (a7 <= 239) {
                                        i7 = 2;
                                        a7 &= 15;
                                    } else {
                                        i7 = 3;
                                        a7 &= 7;
                                    }
                                    for (int i9 = 0; i9 < i7; i9++) {
                                        int i10 = this.f3643c + 1;
                                        this.f3643c = i10;
                                        if (i10 == this.f3642b || this.f3646g[i10] != '\\') {
                                            return '?';
                                        }
                                        int i11 = i10 + 1;
                                        this.f3643c = i11;
                                        int a8 = a(i11);
                                        this.f3643c++;
                                        if ((a8 & 192) != 128) {
                                            return '?';
                                        }
                                        a7 = (a7 << 6) + (a8 & 63);
                                    }
                                }
                                return (char) a7;
                        }
                }
            }
            return c7;
        }
        StringBuilder d7 = h.d("Unexpected end of DN: ");
        d7.append(this.f3641a);
        throw new IllegalStateException(d7.toString());
    }

    public final String c() {
        int i7;
        int i8;
        int i9;
        char c7;
        int i10;
        int i11;
        char c8;
        char c9;
        while (true) {
            i7 = this.f3643c;
            i8 = this.f3642b;
            if (i7 >= i8 || this.f3646g[i7] != ' ') {
                break;
            }
            this.f3643c = i7 + 1;
        }
        if (i7 == i8) {
            return null;
        }
        this.f3644d = i7;
        do {
            this.f3643c = i7 + 1;
            i7 = this.f3643c;
            i9 = this.f3642b;
            if (i7 >= i9 || (c9 = this.f3646g[i7]) == '=') {
                break;
            }
        } while (c9 != ' ');
        if (i7 < i9) {
            this.e = i7;
            if (this.f3646g[i7] == ' ') {
                while (true) {
                    i10 = this.f3643c;
                    i11 = this.f3642b;
                    if (i10 >= i11 || (c8 = this.f3646g[i10]) == '=' || c8 != ' ') {
                        break;
                    }
                    this.f3643c = i10 + 1;
                }
                if (this.f3646g[i10] != '=' || i10 == i11) {
                    StringBuilder d7 = h.d("Unexpected end of DN: ");
                    d7.append(this.f3641a);
                    throw new IllegalStateException(d7.toString());
                }
            }
            int i12 = this.f3643c;
            do {
                this.f3643c = i12 + 1;
                i12 = this.f3643c;
                if (i12 >= this.f3642b) {
                    break;
                }
            } while (this.f3646g[i12] == ' ');
            int i13 = this.e;
            int i14 = this.f3644d;
            if (i13 - i14 > 4) {
                char[] cArr = this.f3646g;
                if (cArr[i14 + 3] == '.' && (((c7 = cArr[i14]) == 'O' || c7 == 'o') && ((cArr[i14 + 1] == 'I' || cArr[i14 + 1] == 'i') && (cArr[i14 + 2] == 'D' || cArr[i14 + 2] == 'd')))) {
                    this.f3644d = i14 + 4;
                }
            }
            char[] cArr2 = this.f3646g;
            int i15 = this.f3644d;
            return new String(cArr2, i15, i13 - i15);
        }
        StringBuilder d8 = h.d("Unexpected end of DN: ");
        d8.append(this.f3641a);
        throw new IllegalStateException(d8.toString());
    }
}
