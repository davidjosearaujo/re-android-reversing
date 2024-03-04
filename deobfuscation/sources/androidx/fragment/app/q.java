package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.g;
import f1.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class q extends ComponentActivity implements a.c {
    public boolean A;

    /* renamed from: z */
    public boolean f1741z;

    /* renamed from: x */
    public final s f1739x = new s(new a());

    /* renamed from: y */
    public final androidx.lifecycle.o f1740y = new androidx.lifecycle.o(this);
    public boolean B = true;

    /* loaded from: classes.dex */
    public class a extends u<q> implements androidx.lifecycle.f0, androidx.activity.w, androidx.activity.result.g, b0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(r1);
            q.this = r1;
        }

        @Override // androidx.activity.w
        public final OnBackPressedDispatcher a() {
            return q.this.a();
        }

        @Override // androidx.fragment.app.b0
        public final void d() {
            q.this.getClass();
        }

        @Override // androidx.activity.result.c
        public final View g(int i7) {
            return q.this.findViewById(i7);
        }

        @Override // androidx.activity.result.g
        public final androidx.activity.result.f h() {
            return q.this.f364p;
        }

        @Override // androidx.lifecycle.f0
        public final androidx.lifecycle.e0 i() {
            return q.this.i();
        }

        @Override // androidx.lifecycle.n
        public final androidx.lifecycle.o k() {
            return q.this.f1740y;
        }

        @Override // androidx.activity.result.c
        public final boolean n() {
            Window window = q.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.fragment.app.u
        public final q p() {
            return q.this;
        }

        @Override // androidx.fragment.app.u
        public final LayoutInflater q() {
            return q.this.getLayoutInflater().cloneInContext(q.this);
        }

        @Override // androidx.fragment.app.u
        public final void r() {
            q.this.r();
        }
    }

    public q() {
        this.f359j.f4376b.c("android:support:fragments", new o(this));
        n(new p(this));
    }

    public static boolean q(x xVar) {
        g.b bVar = g.b.STARTED;
        boolean z6 = false;
        for (n nVar : xVar.f1775c.h()) {
            if (nVar != null) {
                u<?> uVar = nVar.f1716x;
                if ((uVar == null ? null : uVar.p()) != null) {
                    z6 |= q(nVar.h());
                }
                m0 m0Var = nVar.R;
                if (m0Var != null) {
                    m0Var.e();
                    if (m0Var.f1698g.f1876d.compareTo(bVar) >= 0) {
                        nVar.R.f1698g.h();
                        z6 = true;
                    }
                }
                if (nVar.Q.f1876d.compareTo(bVar) >= 0) {
                    nVar.Q.h();
                    z6 = true;
                }
            }
        }
        return z6;
    }

    @Override // android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1741z);
        printWriter.print(" mResumed=");
        printWriter.print(this.A);
        printWriter.print(" mStopped=");
        printWriter.print(this.B);
        if (getApplication() != null) {
            new e2.a(this, i()).p(str2, printWriter);
        }
        this.f1739x.f1762a.f1767i.w(str, fileDescriptor, printWriter, strArr);
    }

    @Override // f1.a.c
    @Deprecated
    public final void e() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i7, int i8, Intent intent) {
        this.f1739x.a();
        super.onActivityResult(i7, i8, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f1739x.a();
        super.onConfigurationChanged(configuration);
        this.f1739x.f1762a.f1767i.i(configuration);
    }

    @Override // androidx.activity.ComponentActivity, f1.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1740y.f(g.a.ON_CREATE);
        this.f1739x.f1762a.f1767i.k();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i7, Menu menu) {
        super.onCreatePanelMenu(i7, menu);
        if (i7 == 0) {
            s sVar = this.f1739x;
            getMenuInflater();
            return sVar.f1762a.f1767i.l() | true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1739x.f1762a.f1767i.f1777f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1739x.f1762a.f1767i.m();
        this.f1740y.f(g.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        this.f1739x.f1762a.f1767i.n();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i7, MenuItem menuItem) {
        if (super.onMenuItemSelected(i7, menuItem)) {
            return true;
        }
        if (i7 != 0) {
            if (i7 != 6) {
                return false;
            }
            return this.f1739x.f1762a.f1767i.j();
        }
        return this.f1739x.f1762a.f1767i.p();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onMultiWindowModeChanged(boolean z6) {
        this.f1739x.f1762a.f1767i.o(z6);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.f1739x.a();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i7, Menu menu) {
        if (i7 == 0) {
            this.f1739x.f1762a.f1767i.q();
        }
        super.onPanelClosed(i7, menu);
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        this.A = false;
        this.f1739x.f1762a.f1767i.u(5);
        this.f1740y.f(g.a.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z6) {
        this.f1739x.f1762a.f1767i.s(z6);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f1740y.f(g.a.ON_RESUME);
        y yVar = this.f1739x.f1762a.f1767i;
        yVar.f1794y = false;
        yVar.f1795z = false;
        yVar.F.f1579h = false;
        yVar.u(7);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i7, View view, Menu menu) {
        if (i7 == 0) {
            super.onPreparePanel(0, view, menu);
            return this.f1739x.f1762a.f1767i.t() | true;
        }
        super.onPreparePanel(i7, view, menu);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        this.f1739x.a();
        super.onRequestPermissionsResult(i7, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f1739x.a();
        super.onResume();
        this.A = true;
        this.f1739x.f1762a.f1767i.z(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.f1739x.a();
        super.onStart();
        this.B = false;
        if (!this.f1741z) {
            this.f1741z = true;
            y yVar = this.f1739x.f1762a.f1767i;
            yVar.f1794y = false;
            yVar.f1795z = false;
            yVar.F.f1579h = false;
            yVar.u(4);
        }
        this.f1739x.f1762a.f1767i.z(true);
        this.f1740y.f(g.a.ON_START);
        y yVar2 = this.f1739x.f1762a.f1767i;
        yVar2.f1794y = false;
        yVar2.f1795z = false;
        yVar2.F.f1579h = false;
        yVar2.u(5);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.f1739x.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.B = true;
        do {
        } while (q(this.f1739x.f1762a.f1767i));
        y yVar = this.f1739x.f1762a.f1767i;
        yVar.f1795z = true;
        yVar.F.f1579h = true;
        yVar.u(4);
        this.f1740y.f(g.a.ON_STOP);
    }

    @Deprecated
    public void r() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1739x.f1762a.f1767i.f1777f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }
}
