package f;

import a0.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import f.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a {

    /* renamed from: f.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0053a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f3924a;

        public C0053a() {
            super(-2, -2);
            this.f3924a = 8388627;
        }

        public C0053a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3924a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f57x);
            this.f3924a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public C0053a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3924a = 0;
        }

        public C0053a(C0053a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f3924a = 0;
            this.f3924a = aVar.f3924a;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        void a();
    }

    public boolean a() {
        return false;
    }

    public abstract boolean b();

    public abstract void c(boolean z6);

    public abstract int d();

    public abstract Context e();

    public boolean f() {
        return false;
    }

    public abstract void g();

    public void h() {
    }

    public abstract boolean i(int i7, KeyEvent keyEvent);

    public boolean j(KeyEvent keyEvent) {
        return false;
    }

    public boolean k() {
        return false;
    }

    public abstract void l(boolean z6);

    public abstract void m(boolean z6);

    public abstract void n();

    public abstract void o();

    public abstract void p(boolean z6);

    public abstract void q(CharSequence charSequence);

    public i.a r(h.d dVar) {
        return null;
    }
}
