package g4;

import android.content.Context;
import android.util.TypedValue;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {
    public static TypedValue a(Context context, int i7) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i7, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i7, boolean z6) {
        TypedValue a7 = a(context, i7);
        return (a7 == null || a7.type != 18) ? z6 : a7.data != 0;
    }

    public static TypedValue c(int i7, Context context, String str) {
        TypedValue a7 = a(context, i7);
        if (a7 != null) {
            return a7;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i7)));
    }
}
