package androidx.appcompat.widget;

import a0.e;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import z1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m {

    /* renamed from: a */
    public final TextView f978a;

    /* renamed from: b */
    public final f f979b;

    public m(TextView textView) {
        this.f978a = textView;
        this.f979b = new f(textView);
    }

    /* JADX WARN: Finally extract failed */
    public final void a(AttributeSet attributeSet, int i7) {
        TypedArray obtainStyledAttributes = this.f978a.getContext().obtainStyledAttributes(attributeSet, e.E, i7, 0);
        try {
            boolean z6 = true;
            if (obtainStyledAttributes.hasValue(14)) {
                z6 = obtainStyledAttributes.getBoolean(14, true);
            }
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
