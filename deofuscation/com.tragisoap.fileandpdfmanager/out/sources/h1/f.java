package h1;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import f.r;
import java.util.WeakHashMap;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f {

    /* renamed from: a */
    public static final ThreadLocal<TypedValue> f4353a = new ThreadLocal<>();

    /* renamed from: b */
    public static final WeakHashMap<d, SparseArray<c>> f4354b = new WeakHashMap<>(0);

    /* renamed from: c */
    public static final Object f4355c = new Object();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        public static Drawable a(Resources resources, int i7, Resources.Theme theme) {
            return resources.getDrawable(i7, theme);
        }

        public static Drawable b(Resources resources, int i7, int i8, Resources.Theme theme) {
            return resources.getDrawableForDensity(i7, i8, theme);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public static int a(Resources resources, int i7, Resources.Theme theme) {
            return resources.getColor(i7, theme);
        }

        public static ColorStateList b(Resources resources, int i7, Resources.Theme theme) {
            return resources.getColorStateList(i7, theme);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {

        /* renamed from: a */
        public final ColorStateList f4356a;

        /* renamed from: b */
        public final Configuration f4357b;

        /* renamed from: c */
        public final int f4358c;

        public c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f4356a = colorStateList;
            this.f4357b = configuration;
            this.f4358c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class d {

        /* renamed from: a */
        public final Resources f4359a;

        /* renamed from: b */
        public final Resources.Theme f4360b;

        public d(Resources resources, Resources.Theme theme) {
            this.f4359a = resources;
            this.f4360b = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f4359a.equals(dVar.f4359a) && o1.b.a(this.f4360b, dVar.f4360b);
        }

        public final int hashCode() {
            return o1.b.b(this.f4359a, this.f4360b);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class e {
        public final void a(int i7) {
            new Handler(Looper.getMainLooper()).post(new g(i7, 0, this));
        }

        public final void b(Typeface typeface) {
            new Handler(Looper.getMainLooper()).post(new r(this, 1, typeface));
        }

        public abstract void c(int i7);

        public abstract void d(Typeface typeface);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
        if (r20 != null) goto L_0x00aa;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
        r20.a(-3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
        if (r20 != null) goto L_0x00aa;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r16, int r17, android.util.TypedValue r18, int r19, h1.f.e r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.f.a(android.content.Context, int, android.util.TypedValue, int, h1.f$e, boolean, boolean):android.graphics.Typeface");
    }
}
