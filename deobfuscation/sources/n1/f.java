package n1;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    public static final /* synthetic */ int f5129a = 0;

    /* loaded from: classes.dex */
    public static class a {
        public static int a(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    static {
        new Locale("", "");
    }
}
