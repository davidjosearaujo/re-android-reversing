package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import j1.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final CheckedTextView f909a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f910b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f911c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f912d = false;
    public boolean e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f913f;

    public h(CheckedTextView checkedTextView) {
        this.f909a = checkedTextView;
    }

    public final void a() {
        Drawable checkMarkDrawable = this.f909a.getCheckMarkDrawable();
        if (checkMarkDrawable == null) {
            return;
        }
        if (this.f912d || this.e) {
            Drawable mutate = checkMarkDrawable.mutate();
            if (this.f912d) {
                a.b.h(mutate, this.f910b);
            }
            if (this.e) {
                a.b.i(mutate, this.f911c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f909a.getDrawableState());
            }
            this.f909a.setCheckMarkDrawable(mutate);
        }
    }
}
