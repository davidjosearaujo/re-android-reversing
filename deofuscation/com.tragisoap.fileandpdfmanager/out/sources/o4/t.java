package o4;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.datepicker.q;
import com.google.android.material.textfield.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class t extends m {
    public int e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f5407f;

    /* renamed from: g  reason: collision with root package name */
    public final q f5408g = new q(1, this);

    public t(a aVar, int i7) {
        super(aVar);
        this.e = 2131165331;
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
