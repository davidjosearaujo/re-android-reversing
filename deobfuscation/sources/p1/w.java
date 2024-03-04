package p1;

import android.text.TextUtils;
import android.view.View;
import p1.y;

/* loaded from: classes.dex */
public final class w extends y.b<CharSequence> {
    public w(Class cls) {
        super(2131296824, cls, 8, 28);
    }

    @Override // p1.y.b
    public final CharSequence b(View view) {
        return y.l.b(view);
    }

    @Override // p1.y.b
    public final void c(View view, CharSequence charSequence) {
        y.l.h(view, charSequence);
    }

    @Override // p1.y.b
    public final boolean f(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
