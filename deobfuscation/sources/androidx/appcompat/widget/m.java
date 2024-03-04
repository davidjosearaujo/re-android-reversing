package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a */
    public final TextView f978a;

    /* renamed from: b */
    public final z1.f f979b;

    public m(TextView textView) {
        this.f978a = textView;
        this.f979b = new z1.f(textView);
    }

    public final void a(AttributeSet attributeSet, int i7) {
        TypedArray obtainStyledAttributes = this.f978a.getContext().obtainStyledAttributes(attributeSet, a0.e.E, i7, 0);
        try {
            boolean z6 = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
            obtainStyledAttributes.recycle();
            c(z6);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b(boolean z6) {
        this.f979b.f6917a.b(z6);
    }

    public final void c(boolean z6) {
        this.f979b.f6917a.c(z6);
    }
}
