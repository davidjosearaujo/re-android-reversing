package f;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.g0;
import f.a;
import f.h;
import i.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l0.z;
import p1.k0;
import p1.m0;
import p1.y;

/* loaded from: classes.dex */
public final class x extends f.a implements ActionBarOverlayLayout.d {

    /* renamed from: a */
    public Context f4044a;

    /* renamed from: b */
    public Context f4045b;

    /* renamed from: c */
    public ActionBarOverlayLayout f4046c;

    /* renamed from: d */
    public ActionBarContainer f4047d;
    public g0 e;

    /* renamed from: f */
    public ActionBarContextView f4048f;

    /* renamed from: g */
    public View f4049g;

    /* renamed from: h */
    public boolean f4050h;

    /* renamed from: i */
    public d f4051i;

    /* renamed from: j */
    public d f4052j;

    /* renamed from: k */
    public a.InterfaceC0067a f4053k;

    /* renamed from: l */
    public boolean f4054l;
    public ArrayList<a.b> m;

    /* renamed from: n */
    public boolean f4055n;

    /* renamed from: o */
    public int f4056o;

    /* renamed from: p */
    public boolean f4057p;

    /* renamed from: q */
    public boolean f4058q;

    /* renamed from: r */
    public boolean f4059r;
    public boolean s;

    /* renamed from: t */
    public i.g f4060t;

    /* renamed from: u */
    public boolean f4061u;

    /* renamed from: v */
    public boolean f4062v;

    /* renamed from: w */
    public final a f4063w;

    /* renamed from: x */
    public final b f4064x;

    /* renamed from: y */
    public final c f4065y;

    /* renamed from: z */
    public static final AccelerateInterpolator f4043z = new AccelerateInterpolator();
    public static final DecelerateInterpolator A = new DecelerateInterpolator();

    /* loaded from: classes.dex */
    public class a extends z {
        public a() {
            x.this = r1;
        }

        @Override // p1.l0
        public final void a() {
            View view;
            x xVar = x.this;
            if (xVar.f4057p && (view = xVar.f4049g) != null) {
                view.setTranslationY(0.0f);
                x.this.f4047d.setTranslationY(0.0f);
            }
            x.this.f4047d.setVisibility(8);
            x.this.f4047d.setTransitioning(false);
            x xVar2 = x.this;
            xVar2.f4060t = null;
            a.InterfaceC0067a interfaceC0067a = xVar2.f4053k;
            if (interfaceC0067a != null) {
                interfaceC0067a.c(xVar2.f4052j);
                xVar2.f4052j = null;
                xVar2.f4053k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = x.this.f4046c;
            if (actionBarOverlayLayout != null) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.h.c(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends z {
        public b() {
            x.this = r1;
        }

        @Override // p1.l0
        public final void a() {
            x xVar = x.this;
            xVar.f4060t = null;
            xVar.f4047d.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class c implements m0 {
        public c() {
            x.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public class d extends i.a implements f.a {

        /* renamed from: h */
        public final Context f4067h;

        /* renamed from: i */
        public final androidx.appcompat.view.menu.f f4068i;

        /* renamed from: j */
        public a.InterfaceC0067a f4069j;

        /* renamed from: k */
        public WeakReference<View> f4070k;

        public d(Context context, h.d dVar) {
            x.this = r1;
            this.f4067h = context;
            this.f4069j = dVar;
            androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(context);
            fVar.f589l = 1;
            this.f4068i = fVar;
            fVar.e = this;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
            a.InterfaceC0067a interfaceC0067a = this.f4069j;
            if (interfaceC0067a != null) {
                return interfaceC0067a.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(androidx.appcompat.view.menu.f fVar) {
            if (this.f4069j == null) {
                return;
            }
            i();
            androidx.appcompat.widget.c cVar = x.this.f4048f.f808i;
            if (cVar != null) {
                cVar.l();
            }
        }

        @Override // i.a
        public final void c() {
            x xVar = x.this;
            if (xVar.f4051i != this) {
                return;
            }
            if (!xVar.f4058q) {
                this.f4069j.c(this);
            } else {
                xVar.f4052j = this;
                xVar.f4053k = this.f4069j;
            }
            this.f4069j = null;
            x.this.s(false);
            ActionBarContextView actionBarContextView = x.this.f4048f;
            if (actionBarContextView.f671p == null) {
                actionBarContextView.h();
            }
            x xVar2 = x.this;
            xVar2.f4046c.setHideOnContentScrollEnabled(xVar2.f4062v);
            x.this.f4051i = null;
        }

        @Override // i.a
        public final View d() {
            WeakReference<View> weakReference = this.f4070k;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // i.a
        public final androidx.appcompat.view.menu.f e() {
            return this.f4068i;
        }

        @Override // i.a
        public final MenuInflater f() {
            return new i.f(this.f4067h);
        }

        @Override // i.a
        public final CharSequence g() {
            return x.this.f4048f.getSubtitle();
        }

        @Override // i.a
        public final CharSequence h() {
            return x.this.f4048f.getTitle();
        }

        @Override // i.a
        public final void i() {
            if (x.this.f4051i != this) {
                return;
            }
            this.f4068i.w();
            try {
                this.f4069j.d(this, this.f4068i);
            } finally {
                this.f4068i.v();
            }
        }

        @Override // i.a
        public final boolean j() {
            return x.this.f4048f.f678x;
        }

        @Override // i.a
        public final void k(View view) {
            x.this.f4048f.setCustomView(view);
            this.f4070k = new WeakReference<>(view);
        }

        @Override // i.a
        public final void l(int i7) {
            m(x.this.f4044a.getResources().getString(i7));
        }

        @Override // i.a
        public final void m(CharSequence charSequence) {
            x.this.f4048f.setSubtitle(charSequence);
        }

        @Override // i.a
        public final void n(int i7) {
            o(x.this.f4044a.getResources().getString(i7));
        }

        @Override // i.a
        public final void o(CharSequence charSequence) {
            x.this.f4048f.setTitle(charSequence);
        }

        @Override // i.a
        public final void p(boolean z6) {
            this.f4404g = z6;
            x.this.f4048f.setTitleOptional(z6);
        }
    }

    public x(Activity activity, boolean z6) {
        new ArrayList();
        this.m = new ArrayList<>();
        this.f4056o = 0;
        this.f4057p = true;
        this.s = true;
        this.f4063w = new a();
        this.f4064x = new b();
        this.f4065y = new c();
        View decorView = activity.getWindow().getDecorView();
        t(decorView);
        if (z6) {
            return;
        }
        this.f4049g = decorView.findViewById(16908290);
    }

    public x(Dialog dialog) {
        new ArrayList();
        this.m = new ArrayList<>();
        this.f4056o = 0;
        this.f4057p = true;
        this.s = true;
        this.f4063w = new a();
        this.f4064x = new b();
        this.f4065y = new c();
        t(dialog.getWindow().getDecorView());
    }

    @Override // f.a
    public final boolean b() {
        g0 g0Var = this.e;
        if (g0Var == null || !g0Var.l()) {
            return false;
        }
        this.e.collapseActionView();
        return true;
    }

    @Override // f.a
    public final void c(boolean z6) {
        if (z6 == this.f4054l) {
            return;
        }
        this.f4054l = z6;
        int size = this.m.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.m.get(i7).a();
        }
    }

    @Override // f.a
    public final int d() {
        return this.e.o();
    }

    @Override // f.a
    public final Context e() {
        if (this.f4045b == null) {
            TypedValue typedValue = new TypedValue();
            this.f4044a.getTheme().resolveAttribute(2130903052, typedValue, true);
            int i7 = typedValue.resourceId;
            if (i7 != 0) {
                this.f4045b = new ContextThemeWrapper(this.f4044a, i7);
            } else {
                this.f4045b = this.f4044a;
            }
        }
        return this.f4045b;
    }

    @Override // f.a
    public final void g() {
        v(this.f4044a.getResources().getBoolean(2130968576));
    }

    @Override // f.a
    public final boolean i(int i7, KeyEvent keyEvent) {
        androidx.appcompat.view.menu.f fVar;
        d dVar = this.f4051i;
        if (dVar == null || (fVar = dVar.f4068i) == null) {
            return false;
        }
        fVar.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return fVar.performShortcut(i7, keyEvent, 0);
    }

    @Override // f.a
    public final void l(boolean z6) {
        if (this.f4050h) {
            return;
        }
        m(z6);
    }

    @Override // f.a
    public final void m(boolean z6) {
        u(z6 ? 4 : 0, 4);
    }

    @Override // f.a
    public final void n() {
        u(2, 2);
    }

    @Override // f.a
    public final void o() {
        u(0, 8);
    }

    @Override // f.a
    public final void p(boolean z6) {
        i.g gVar;
        this.f4061u = z6;
        if (z6 || (gVar = this.f4060t) == null) {
            return;
        }
        gVar.a();
    }

    @Override // f.a
    public final void q(CharSequence charSequence) {
        this.e.setWindowTitle(charSequence);
    }

    @Override // f.a
    public final i.a r(h.d dVar) {
        d dVar2 = this.f4051i;
        if (dVar2 != null) {
            dVar2.c();
        }
        this.f4046c.setHideOnContentScrollEnabled(false);
        this.f4048f.h();
        d dVar3 = new d(this.f4048f.getContext(), dVar);
        dVar3.f4068i.w();
        try {
            if (dVar3.f4069j.b(dVar3, dVar3.f4068i)) {
                this.f4051i = dVar3;
                dVar3.i();
                this.f4048f.f(dVar3);
                s(true);
                return dVar3;
            }
            return null;
        } finally {
            dVar3.f4068i.v();
        }
    }

    public final void s(boolean z6) {
        k0 e;
        k0 k0Var;
        if (z6) {
            if (!this.f4059r) {
                this.f4059r = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4046c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                w(false);
            }
        } else if (this.f4059r) {
            this.f4059r = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4046c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            w(false);
        }
        ActionBarContainer actionBarContainer = this.f4047d;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (!y.g.c(actionBarContainer)) {
            if (z6) {
                this.e.j(4);
                this.f4048f.setVisibility(0);
                return;
            }
            this.e.j(0);
            this.f4048f.setVisibility(8);
            return;
        }
        if (z6) {
            e = this.e.r(4, 100L);
            k0Var = this.f4048f.e(0, 200L);
        } else {
            k0 r6 = this.e.r(0, 200L);
            e = this.f4048f.e(8, 100L);
            k0Var = r6;
        }
        i.g gVar = new i.g();
        gVar.f4452a.add(e);
        View view = e.f5495a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = k0Var.f5495a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        gVar.f4452a.add(k0Var);
        gVar.b();
    }

    public final void t(View view) {
        g0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(2131296421);
        this.f4046c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(2131296309);
        if (findViewById instanceof g0) {
            wrapper = (g0) findViewById;
        } else if (!(findViewById instanceof Toolbar)) {
            StringBuilder d7 = androidx.activity.h.d("Can't make a decor toolbar out of ");
            d7.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(d7.toString());
        } else {
            wrapper = ((Toolbar) findViewById).getWrapper();
        }
        this.e = wrapper;
        this.f4048f = (ActionBarContextView) view.findViewById(2131296317);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(2131296311);
        this.f4047d = actionBarContainer;
        g0 g0Var = this.e;
        if (g0Var == null || this.f4048f == null || actionBarContainer == null) {
            throw new IllegalStateException(x.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f4044a = g0Var.a();
        if ((this.e.o() & 4) != 0) {
            this.f4050h = true;
        }
        Context context = this.f4044a;
        int i7 = context.getApplicationInfo().targetSdkVersion;
        this.e.k();
        v(context.getResources().getBoolean(2130968576));
        TypedArray obtainStyledAttributes = this.f4044a.obtainStyledAttributes(null, a0.e.f56w, 2130903047, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4046c;
            if (!actionBarOverlayLayout2.m) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f4062v = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f4047d;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.i.s(actionBarContainer2, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void u(int i7, int i8) {
        int o6 = this.e.o();
        if ((i8 & 4) != 0) {
            this.f4050h = true;
        }
        this.e.m((i7 & i8) | ((~i8) & o6));
    }

    public final void v(boolean z6) {
        this.f4055n = z6;
        if (z6) {
            this.f4047d.setTabContainer(null);
            this.e.n();
        } else {
            this.e.n();
            this.f4047d.setTabContainer(null);
        }
        this.e.q();
        g0 g0Var = this.e;
        boolean z7 = this.f4055n;
        g0Var.u(false);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f4046c;
        boolean z8 = this.f4055n;
        actionBarOverlayLayout.setHasNonEmbeddedTabs(false);
    }

    public final void w(boolean z6) {
        View view;
        int[] iArr;
        View view2;
        View view3;
        int[] iArr2;
        if (!(this.f4059r || !this.f4058q)) {
            if (this.s) {
                this.s = false;
                i.g gVar = this.f4060t;
                if (gVar != null) {
                    gVar.a();
                }
                if (this.f4056o != 0 || (!this.f4061u && !z6)) {
                    this.f4063w.a();
                    return;
                }
                this.f4047d.setAlpha(1.0f);
                this.f4047d.setTransitioning(true);
                i.g gVar2 = new i.g();
                float f7 = -this.f4047d.getHeight();
                if (z6) {
                    this.f4047d.getLocationInWindow(new int[]{0, 0});
                    f7 -= iArr[1];
                }
                k0 a7 = y.a(this.f4047d);
                a7.e(f7);
                c cVar = this.f4065y;
                View view4 = a7.f5495a.get();
                if (view4 != null) {
                    k0.a.a(view4.animate(), cVar != null ? new ValueAnimator.AnimatorUpdateListener(cVar, view4) { // from class: p1.i0

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ m0 f5492a;

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) f.x.this.f4047d.getParent()).invalidate();
                        }
                    } : null);
                }
                if (!gVar2.e) {
                    gVar2.f4452a.add(a7);
                }
                if (this.f4057p && (view = this.f4049g) != null) {
                    k0 a8 = y.a(view);
                    a8.e(f7);
                    if (!gVar2.e) {
                        gVar2.f4452a.add(a8);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = f4043z;
                boolean z7 = gVar2.e;
                if (!z7) {
                    gVar2.f4454c = accelerateInterpolator;
                }
                if (!z7) {
                    gVar2.f4453b = 250L;
                }
                a aVar = this.f4063w;
                if (!z7) {
                    gVar2.f4455d = aVar;
                }
                this.f4060t = gVar2;
                gVar2.b();
            }
        } else if (this.s) {
        } else {
            this.s = true;
            i.g gVar3 = this.f4060t;
            if (gVar3 != null) {
                gVar3.a();
            }
            this.f4047d.setVisibility(0);
            if (this.f4056o == 0 && (this.f4061u || z6)) {
                this.f4047d.setTranslationY(0.0f);
                float f8 = -this.f4047d.getHeight();
                if (z6) {
                    this.f4047d.getLocationInWindow(new int[]{0, 0});
                    f8 -= iArr2[1];
                }
                this.f4047d.setTranslationY(f8);
                i.g gVar4 = new i.g();
                k0 a9 = y.a(this.f4047d);
                a9.e(0.0f);
                c cVar2 = this.f4065y;
                View view5 = a9.f5495a.get();
                if (view5 != null) {
                    k0.a.a(view5.animate(), cVar2 != null ? new ValueAnimator.AnimatorUpdateListener(cVar2, view5) { // from class: p1.i0

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ m0 f5492a;

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) f.x.this.f4047d.getParent()).invalidate();
                        }
                    } : null);
                }
                if (!gVar4.e) {
                    gVar4.f4452a.add(a9);
                }
                if (this.f4057p && (view3 = this.f4049g) != null) {
                    view3.setTranslationY(f8);
                    k0 a10 = y.a(this.f4049g);
                    a10.e(0.0f);
                    if (!gVar4.e) {
                        gVar4.f4452a.add(a10);
                    }
                }
                DecelerateInterpolator decelerateInterpolator = A;
                boolean z8 = gVar4.e;
                if (!z8) {
                    gVar4.f4454c = decelerateInterpolator;
                }
                if (!z8) {
                    gVar4.f4453b = 250L;
                }
                b bVar = this.f4064x;
                if (!z8) {
                    gVar4.f4455d = bVar;
                }
                this.f4060t = gVar4;
                gVar4.b();
            } else {
                this.f4047d.setAlpha(1.0f);
                this.f4047d.setTranslationY(0.0f);
                if (this.f4057p && (view2 = this.f4049g) != null) {
                    view2.setTranslationY(0.0f);
                }
                this.f4064x.a();
            }
            ActionBarOverlayLayout actionBarOverlayLayout = this.f4046c;
            if (actionBarOverlayLayout != null) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.h.c(actionBarOverlayLayout);
            }
        }
    }
}
