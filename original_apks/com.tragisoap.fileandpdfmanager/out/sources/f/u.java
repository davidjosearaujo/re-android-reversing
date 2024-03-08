package f;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.c1;
import f.a;
import f.h;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u extends a {

    /* renamed from: a  reason: collision with root package name */
    public final c1 f4020a;

    /* renamed from: b  reason: collision with root package name */
    public final Window.Callback f4021b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4023d;
    public boolean e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4024f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<a.b> f4025g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public final a f4026h = new a();

    /* renamed from: c  reason: collision with root package name */
    public final e f4022c = new e();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            u uVar = u.this;
            Menu s = uVar.s();
            f fVar = s instanceof f ? (f) s : null;
            if (fVar != null) {
                fVar.w();
            }
            try {
                s.clear();
                if (!uVar.f4021b.onCreatePanelMenu(0, s) || !uVar.f4021b.onPreparePanel(0, null, s)) {
                    s.clear();
                }
            } finally {
                if (fVar != null) {
                    fVar.v();
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Toolbar.h {
        public b() {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class c implements j.a {

        /* renamed from: f  reason: collision with root package name */
        public boolean f4029f;

        public c() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(f fVar, boolean z6) {
            if (!this.f4029f) {
                this.f4029f = true;
                u.this.f4020a.i();
                u.this.f4021b.onPanelClosed(108, fVar);
                this.f4029f = false;
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(f fVar) {
            u.this.f4021b.onMenuOpened(108, fVar);
            return true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class d implements f.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(f fVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(f fVar) {
            if (u.this.f4020a.b()) {
                u.this.f4021b.onPanelClosed(108, fVar);
            } else if (u.this.f4021b.onPreparePanel(0, null, fVar)) {
                u.this.f4021b.onMenuOpened(108, fVar);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e implements h.b {
        public e() {
        }
    }

    public u(Toolbar toolbar, CharSequence charSequence, h.g gVar) {
        b bVar = new b();
        toolbar.getClass();
        c1 c1Var = new c1(toolbar, false);
        this.f4020a = c1Var;
        gVar.getClass();
        this.f4021b = gVar;
        c1Var.f875l = gVar;
        toolbar.setOnMenuItemClickListener(bVar);
        c1Var.setWindowTitle(charSequence);
    }

    @Override // f.a
    public final boolean a() {
        return this.f4020a.e();
    }

    @Override // f.a
    public final boolean b() {
        if (!this.f4020a.l()) {
            return false;
        }
        this.f4020a.collapseActionView();
        return true;
    }

    @Override // f.a
    public final void c(boolean z6) {
        if (z6 != this.f4024f) {
            this.f4024f = z6;
            int size = this.f4025g.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f4025g.get(i7).a();
            }
        }
    }

    @Override // f.a
    public final int d() {
        return this.f4020a.f866b;
    }

    @Override // f.a
    public final Context e() {
        return this.f4020a.a();
    }

    @Override // f.a
    public final boolean f() {
        this.f4020a.f865a.removeCallbacks(this.f4026h);
        Toolbar toolbar = this.f4020a.f865a;
        a aVar = this.f4026h;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.m(toolbar, aVar);
        return true;
    }

    @Override // f.a
    public final void g() {
    }

    @Override // f.a
    public final void h() {
        this.f4020a.f865a.removeCallbacks(this.f4026h);
    }

    @Override // f.a
    public final boolean i(int i7, KeyEvent keyEvent) {
        Menu s = s();
        if (s == null) {
            return false;
        }
        boolean z6 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z6 = false;
        }
        s.setQwertyMode(z6);
        return s.performShortcut(i7, keyEvent, 0);
    }

    @Override // f.a
    public final boolean j(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    @Override // f.a
    public final boolean k() {
        return this.f4020a.g();
    }

    @Override // f.a
    public final void l(boolean z6) {
    }

    @Override // f.a
    public final void m(boolean z6) {
        t(4, 4);
    }

    @Override // f.a
    public final void n() {
        t(2, 2);
    }

    @Override // f.a
    public final void o() {
        t(0, 8);
    }

    @Override // f.a
    public final void p(boolean z6) {
    }

    @Override // f.a
    public final void q(CharSequence charSequence) {
        this.f4020a.setWindowTitle(charSequence);
    }

    public final Menu s() {
        if (!this.e) {
            c1 c1Var = this.f4020a;
            c cVar = new c();
            d dVar = new d();
            Toolbar toolbar = c1Var.f865a;
            toolbar.S = cVar;
            toolbar.T = dVar;
            ActionMenuView actionMenuView = toolbar.f772f;
            if (actionMenuView != null) {
                actionMenuView.f708z = cVar;
                actionMenuView.A = dVar;
            }
            this.e = true;
        }
        return this.f4020a.f865a.getMenu();
    }

    public final void t(int i7, int i8) {
        c1 c1Var = this.f4020a;
        c1Var.m((i7 & i8) | ((~i8) & c1Var.f866b));
    }
}
