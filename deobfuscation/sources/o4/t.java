package o4;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class t extends m {
    public int e;

    /* renamed from: f */
    public EditText f5407f;

    /* renamed from: g */
    public final com.google.android.material.datepicker.q f5408g;

    public t(com.google.android.material.textfield.a aVar, int i7) {
        super(aVar);
        this.e = 2131165331;
        this.f5408g = new com.google.android.material.datepicker.q(1, this);
        if (i7 != 0) {
            this.e = i7;
        }
    }

    @Override // o4.m
    public final void b() {
        q();
    }

    @Override // o4.m
    public final int c() {
        return 2131820719;
    }

    @Override // o4.m
    public final int d() {
        return this.e;
    }

    @Override // o4.m
    public final View.OnClickListener f() {
        return this.f5408g;
    }

    @Override // o4.m
    public final boolean k() {
        return true;
    }

    @Override // o4.m
    public final boolean l() {
        EditText editText = this.f5407f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // o4.m
    public final void m(EditText editText) {
        this.f5407f = editText;
        q();
    }

    @Override // o4.m
    public final void r() {
        EditText editText = this.f5407f;
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            this.f5407f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // o4.m
    public final void s() {
        EditText editText = this.f5407f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
