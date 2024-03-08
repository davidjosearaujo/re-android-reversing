package y4;

import java.util.ArrayList;
import java.util.Collections;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f6744a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList f6745a = new ArrayList(20);

        public static void c(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i7 = 0; i7 < length; i7++) {
                    char charAt = str.charAt(i7);
                    if (charAt <= 31 || charAt >= 127) {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i7), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    for (int i8 = 0; i8 < length2; i8++) {
                        char charAt2 = str2.charAt(i8);
                        if (charAt2 <= 31 || charAt2 >= 127) {
                            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", Integer.valueOf(charAt2), Integer.valueOf(i8), str2));
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("value == null");
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        public final void a(String str, String str2) {
            c(str, str2);
            b(str, str2);
        }

        public final void b(String str, String str2) {
            this.f6745a.add(str);
            this.f6745a.add(str2.trim());
        }

        public final void d(String str) {
            int i7 = 0;
            while (i7 < this.f6745a.size()) {
                if (str.equalsIgnoreCase((String) this.f6745a.get(i7))) {
                    this.f6745a.remove(i7);
                    this.f6745a.remove(i7);
                    i7 -= 2;
                }
                i7 += 2;
            }
        }

        public final void e(String str, String str2) {
            c(str, str2);
            d(str);
            b(str, str2);
        }
    }

    public l(a aVar) {
        ArrayList arrayList = aVar.f6745a;
        this.f6744a = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final String a(String str) {
        String[] strArr = this.f6744a;
        int length = strArr.length;
        do {
            length -= 2;
            if (length < 0) {
                return null;
            }
        } while (!str.equalsIgnoreCase(strArr[length]));
        return strArr[length + 1];
    }

    public final String b(int i7) {
        int i8 = i7 * 2;
        if (i8 < 0) {
            return null;
        }
        String[] strArr = this.f6744a;
        if (i8 >= strArr.length) {
            return null;
        }
        return strArr[i8];
    }

    public final a c() {
        a aVar = new a();
        Collections.addAll(aVar.f6745a, this.f6744a);
        return aVar;
    }

    public final String d(int i7) {
        int i8 = (i7 * 2) + 1;
        if (i8 < 0) {
            return null;
        }
        String[] strArr = this.f6744a;
        if (i8 >= strArr.length) {
            return null;
        }
        return strArr[i8];
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int length = this.f6744a.length / 2;
        for (int i7 = 0; i7 < length; i7++) {
            sb.append(b(i7));
            sb.append(": ");
            sb.append(d(i7));
            sb.append("\n");
        }
        return sb.toString();
    }
}
