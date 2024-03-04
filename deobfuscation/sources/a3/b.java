package a3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import g1.a;
import h1.f;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public static volatile boolean f124a = true;

    public static Drawable a(Context context, Context context2, int i7, Resources.Theme theme) {
        try {
            if (f124a) {
                return g.a.a(theme != null ? new i.c(context2, theme) : context2, i7);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            Object obj = g1.a.f4192a;
            return a.c.b(context2, i7);
        } catch (NoClassDefFoundError unused2) {
            f124a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Resources resources = context2.getResources();
        ThreadLocal<TypedValue> threadLocal = h1.f.f4353a;
        return f.a.a(resources, i7, theme);
    }
}
