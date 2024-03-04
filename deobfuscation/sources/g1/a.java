package g1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import f1.h;
import h1.f;
import java.io.File;
import java.util.WeakHashMap;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static final Object f4192a = new Object();

    /* renamed from: g1.a$a */
    /* loaded from: classes.dex */
    public static class C0058a {
        public static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        public static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        public static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        public static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }

        public static Drawable b(Context context, int i7) {
            return context.getDrawable(i7);
        }

        public static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static int a(Context context, int i7) {
            return context.getColor(i7);
        }

        public static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        public static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : h.a.a(new h(context).f4090a) ? 0 : -1;
        }
        throw new NullPointerException("permission must be non-null");
    }

    public static int b(Context context) {
        return d.a(context, 17170443);
    }

    public static ColorStateList c(Context context, int i7) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        f.c cVar;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        f.d dVar = new f.d(resources, theme);
        synchronized (f.f4355c) {
            SparseArray<f.c> sparseArray = f.f4354b.get(dVar);
            colorStateList = null;
            if (sparseArray != null && sparseArray.size() > 0 && (cVar = sparseArray.get(i7)) != null) {
                if (!cVar.f4357b.equals(resources.getConfiguration()) || (!(theme == null && cVar.f4358c == 0) && (theme == null || cVar.f4358c != theme.hashCode()))) {
                    sparseArray.remove(i7);
                } else {
                    colorStateList2 = cVar.f4356a;
                }
            }
            colorStateList2 = null;
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        ThreadLocal<TypedValue> threadLocal = f.f4353a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        boolean z6 = true;
        resources.getValue(i7, typedValue, true);
        int i8 = typedValue.type;
        if (!((i8 < 28 || i8 > 31) ? false : false)) {
            try {
                colorStateList = h1.b.a(resources, resources.getXml(i7), theme);
            } catch (Exception e) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        if (colorStateList != null) {
            synchronized (f.f4355c) {
                WeakHashMap<f.d, SparseArray<f.c>> weakHashMap = f.f4354b;
                SparseArray<f.c> sparseArray2 = weakHashMap.get(dVar);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray<>();
                    weakHashMap.put(dVar, sparseArray2);
                }
                sparseArray2.append(i7, new f.c(colorStateList, dVar.f4359a.getConfiguration(), theme));
            }
            return colorStateList;
        }
        return f.b.b(resources, i7, theme);
    }

    public static Drawable d(Context context, int i7) {
        return c.b(context, i7);
    }
}
