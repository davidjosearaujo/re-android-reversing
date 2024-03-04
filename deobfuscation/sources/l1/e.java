package l1;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b */
    public static final e f4943b = new e(new g(b.a(new Locale[0])));

    /* renamed from: a */
    public final f f4944a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public static final Locale[] f4945a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale, Locale locale2) {
            boolean z6;
            boolean z7;
            if (locale.equals(locale2)) {
                return true;
            }
            if (locale.getLanguage().equals(locale2.getLanguage())) {
                Locale[] localeArr = f4945a;
                int length = localeArr.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        z6 = false;
                        break;
                    } else if (localeArr[i7].equals(locale)) {
                        z6 = true;
                        break;
                    } else {
                        i7++;
                    }
                }
                if (!z6) {
                    Locale[] localeArr2 = f4945a;
                    int length2 = localeArr2.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            z7 = false;
                            break;
                        } else if (localeArr2[i8].equals(locale2)) {
                            z7 = true;
                            break;
                        } else {
                            i8++;
                        }
                    }
                    if (!z7) {
                        String c7 = n1.b.c(n1.b.a(n1.b.b(locale)));
                        if (c7.isEmpty()) {
                            String country = locale.getCountry();
                            return country.isEmpty() || country.equals(locale2.getCountry());
                        }
                        return c7.equals(n1.b.c(n1.b.a(n1.b.b(locale2))));
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    public e(g gVar) {
        this.f4944a = gVar;
    }

    public static e a(String str) {
        if (str == null || str.isEmpty()) {
            return f4943b;
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i7 = 0; i7 < length; i7++) {
            localeArr[i7] = a.a(split[i7]);
        }
        return new e(new g(b.a(localeArr)));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && this.f4944a.equals(((e) obj).f4944a);
    }

    public final int hashCode() {
        return this.f4944a.hashCode();
    }

    public final String toString() {
        return this.f4944a.toString();
    }
}
