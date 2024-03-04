package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.n;
import androidx.fragment.app.x;

/* loaded from: classes.dex */
public class m extends n implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler W;

    /* renamed from: f0 */
    public boolean f1684f0;

    /* renamed from: h0 */
    public Dialog f1686h0;

    /* renamed from: i0 */
    public boolean f1687i0;

    /* renamed from: j0 */
    public boolean f1688j0;

    /* renamed from: k0 */
    public boolean f1689k0;
    public a X = new a();
    public b Y = new b();
    public c Z = new c();

    /* renamed from: a0 */
    public int f1679a0 = 0;

    /* renamed from: b0 */
    public int f1680b0 = 0;

    /* renamed from: c0 */
    public boolean f1681c0 = true;

    /* renamed from: d0 */
    public boolean f1682d0 = true;

    /* renamed from: e0 */
    public int f1683e0 = -1;

    /* renamed from: g0 */
    public d f1685g0 = new d();

    /* renamed from: l0 */
    public boolean f1690l0 = false;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            m.this = r1;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public final void run() {
            m mVar = m.this;
            mVar.Z.onDismiss(mVar.f1686h0);
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
            m.this = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public final void onCancel(DialogInterface dialogInterface) {
            m mVar = m.this;
            Dialog dialog = mVar.f1686h0;
            if (dialog != null) {
                mVar.onCancel(dialog);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
            m.this = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public final void onDismiss(DialogInterface dialogInterface) {
            m mVar = m.this;
            Dialog dialog = mVar.f1686h0;
            if (dialog != null) {
                mVar.onDismiss(dialog);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements androidx.lifecycle.s<androidx.lifecycle.n> {
        public d() {
            m.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public class e extends androidx.activity.result.c {

        /* renamed from: f */
        public final /* synthetic */ androidx.activity.result.c f1695f;

        public e(n.a aVar) {
            m.this = r1;
            this.f1695f = aVar;
        }

        @Override // androidx.activity.result.c
        public final View g(int i7) {
            if (this.f1695f.n()) {
                return this.f1695f.g(i7);
            }
            Dialog dialog = m.this.f1686h0;
            if (dialog != null) {
                return dialog.findViewById(i7);
            }
            return null;
        }

        @Override // androidx.activity.result.c
        public final boolean n() {
            return this.f1695f.n() || m.this.f1690l0;
        }
    }

    @Override // androidx.fragment.app.n
    public void A(Bundle bundle) {
        Dialog dialog = this.f1686h0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i7 = this.f1679a0;
        if (i7 != 0) {
            bundle.putInt("android:style", i7);
        }
        int i8 = this.f1680b0;
        if (i8 != 0) {
            bundle.putInt("android:theme", i8);
        }
        boolean z6 = this.f1681c0;
        if (!z6) {
            bundle.putBoolean("android:cancelable", z6);
        }
        boolean z7 = this.f1682d0;
        if (!z7) {
            bundle.putBoolean("android:showsDialog", z7);
        }
        int i9 = this.f1683e0;
        if (i9 != -1) {
            bundle.putInt("android:backStackId", i9);
        }
    }

    @Override // androidx.fragment.app.n
    public void B() {
        this.H = true;
        Dialog dialog = this.f1686h0;
        if (dialog != null) {
            this.f1687i0 = false;
            dialog.show();
            View decorView = this.f1686h0.getWindow().getDecorView();
            a0.b.B(decorView, this);
            decorView.setTag(2131296918, this);
            a0.b.C(decorView, this);
        }
    }

    @Override // androidx.fragment.app.n
    public void C() {
        this.H = true;
        Dialog dialog = this.f1686h0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.n
    public final void D(Bundle bundle) {
        Bundle bundle2;
        this.H = true;
        if (this.f1686h0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f1686h0.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.n
    public final void E(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.E(layoutInflater, viewGroup, bundle);
        if (this.J != null || this.f1686h0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f1686h0.onRestoreInstanceState(bundle2);
    }

    public final void P(boolean z6, boolean z7) {
        if (this.f1688j0) {
            return;
        }
        this.f1688j0 = true;
        this.f1689k0 = false;
        Dialog dialog = this.f1686h0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f1686h0.dismiss();
            if (!z7) {
                if (Looper.myLooper() == this.W.getLooper()) {
                    onDismiss(this.f1686h0);
                } else {
                    this.W.post(this.X);
                }
            }
        }
        this.f1687i0 = true;
        if (this.f1683e0 >= 0) {
            x m = m();
            int i7 = this.f1683e0;
            if (i7 < 0) {
                throw new IllegalArgumentException(s0.g("Bad id: ", i7));
            }
            m.x(new x.m(i7), false);
            this.f1683e0 = -1;
            return;
        }
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(m());
        aVar.i(this);
        if (z6) {
            aVar.d(true);
        } else {
            aVar.d(false);
        }
    }

    public Dialog Q() {
        if (x.K(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(L(), this.f1680b0);
    }

    public final Dialog R() {
        Dialog dialog = this.f1686h0;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void S(Dialog dialog, int i7) {
        if (i7 != 1 && i7 != 2) {
            if (i7 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public final void T(y yVar) {
        this.f1688j0 = false;
        this.f1689k0 = true;
        yVar.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(yVar);
        aVar.e(0, this, "ContentValues", 1);
        aVar.d(false);
    }

    @Override // androidx.fragment.app.n
    public final androidx.activity.result.c d() {
        return new e(new n.a());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f1687i0) {
            return;
        }
        if (x.K(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        P(true, true);
    }

    @Override // androidx.fragment.app.n
    public final void s(Context context) {
        super.s(context);
        this.S.d(this.f1685g0);
        if (this.f1689k0) {
            return;
        }
        this.f1688j0 = false;
    }

    @Override // androidx.fragment.app.n
    public void t(Bundle bundle) {
        super.t(bundle);
        this.W = new Handler();
        this.f1682d0 = this.B == 0;
        if (bundle != null) {
            this.f1679a0 = bundle.getInt("android:style", 0);
            this.f1680b0 = bundle.getInt("android:theme", 0);
            this.f1681c0 = bundle.getBoolean("android:cancelable", true);
            this.f1682d0 = bundle.getBoolean("android:showsDialog", this.f1682d0);
            this.f1683e0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.n
    public final void w() {
        this.H = true;
        Dialog dialog = this.f1686h0;
        if (dialog != null) {
            this.f1687i0 = true;
            dialog.setOnDismissListener(null);
            this.f1686h0.dismiss();
            if (!this.f1688j0) {
                onDismiss(this.f1686h0);
            }
            this.f1686h0 = null;
            this.f1690l0 = false;
        }
    }

    @Override // androidx.fragment.app.n
    public final void x() {
        this.H = true;
        if (!this.f1689k0 && !this.f1688j0) {
            this.f1688j0 = true;
        }
        this.S.g(this.f1685g0);
    }

    @Override // androidx.fragment.app.n
    public final LayoutInflater y(Bundle bundle) {
        StringBuilder sb;
        String str;
        LayoutInflater y6 = super.y(bundle);
        boolean z6 = this.f1682d0;
        if (!z6 || this.f1684f0) {
            if (x.K(2)) {
                String str2 = "getting layout inflater for DialogFragment " + this;
                if (this.f1682d0) {
                    sb = new StringBuilder();
                    str = "mCreatingDialog = true: ";
                } else {
                    sb = new StringBuilder();
                    str = "mShowsDialog = false: ";
                }
                sb.append(str);
                sb.append(str2);
                Log.d("FragmentManager", sb.toString());
            }
            return y6;
        }
        if (z6 && !this.f1690l0) {
            try {
                this.f1684f0 = true;
                Dialog Q = Q();
                this.f1686h0 = Q;
                if (this.f1682d0) {
                    S(Q, this.f1679a0);
                    Context j5 = j();
                    if (j5 instanceof Activity) {
                        this.f1686h0.setOwnerActivity((Activity) j5);
                    }
                    this.f1686h0.setCancelable(this.f1681c0);
                    this.f1686h0.setOnCancelListener(this.Y);
                    this.f1686h0.setOnDismissListener(this.Z);
                    this.f1690l0 = true;
                } else {
                    this.f1686h0 = null;
                }
            } finally {
                this.f1684f0 = false;
            }
        }
        if (x.K(2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.f1686h0;
        return dialog != null ? y6.cloneInContext(dialog.getContext()) : y6;
    }
}
