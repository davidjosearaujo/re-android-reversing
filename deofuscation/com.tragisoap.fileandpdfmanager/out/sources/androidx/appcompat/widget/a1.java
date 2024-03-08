package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.a0;
import g1.a;
import h1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a1 {

    /* renamed from: a */
    public final Context f830a;

    /* renamed from: b */
    public final TypedArray f831b;

    /* renamed from: c */
    public TypedValue f832c;

    public a1(Context context, TypedArray typedArray) {
        this.f830a = context;
        this.f831b = typedArray;
    }

    public static a1 m(Context context, AttributeSet attributeSet, int[] iArr, int i7) {
        return new a1(context, context.obtainStyledAttributes(attributeSet, iArr, i7, 0));
    }

    public final boolean a(int i7, boolean z6) {
        return this.f831b.getBoolean(i7, z6);
    }

    public final ColorStateList b(int i7) {
        int resourceId;
        ColorStateList c7;
        return (!this.f831b.hasValue(i7) || (resourceId = this.f831b.getResourceId(i7, 0)) == 0 || (c7 = a.c(this.f830a, resourceId)) == null) ? this.f831b.getColorStateList(i7) : c7;
    }

    public final int c(int i7, int i8) {
        return this.f831b.getDimensionPixelOffset(i7, i8);
    }

    public final int d(int i7, int i8) {
        return this.f831b.getDimensionPixelSize(i7, i8);
    }

    public final Drawable e(int i7) {
        int resourceId;
        return (!this.f831b.hasValue(i7) || (resourceId = this.f831b.getResourceId(i7, 0)) == 0) ? this.f831b.getDrawable(i7) : g.a.a(this.f830a, resourceId);
    }

    public final Drawable f(int i7) {
        int resourceId;
        Drawable f7;
        if (!this.f831b.hasValue(i7) || (resourceId = this.f831b.getResourceId(i7, 0)) == 0) {
            return null;
        }
        j a7 = j.a();
        Context context = this.f830a;
        synchronized (a7) {
            f7 = a7.f941a.f(context, resourceId, true);
        }
        return f7;
    }

    public final Typeface g(int i7, int i8, a0.a aVar) {
        int resourceId = this.f831b.getResourceId(i7, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f832c == null) {
            this.f832c = new TypedValue();
        }
        Context context = this.f830a;
        TypedValue typedValue = this.f832c;
        ThreadLocal<TypedValue> threadLocal = f.f4353a;
        if (context.isRestricted()) {
            return null;
        }
        return f.a(context, resourceId, typedValue, i8, aVar, true, false);
    }

    public final int h(int i7, int i8) {
        return this.f831b.getInt(i7, i8);
    }

    public final int i(int i7, int i8) {
        return this.f831b.getResourceId(i7, i8);
    }

    public final String j(int i7) {
        return this.f831b.getString(i7);
    }

    public final CharSequence k(int i7) {
        return this.f831b.getText(i7);
    }

    public final boolean l(int i7) {
        return this.f831b.hasValue(i7);
    }

    public final void n() {
        this.f831b.recycle();
    }
}
