package f;

import a0.e;
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
import f.x;
import i.a;
import i.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l0.z;
import p1.i0;
import p1.k0;
import p1.m0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class x extends a implements ActionBarOverlayLayout.d {

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
    public a.AbstractC0067a f4053k;

    /* renamed from: l */
    public boolean f4054l;

    /* renamed from: n */
    public boolean f4055n;

    /* renamed from: q */
    public boolean f4058q;

    /* renamed from: r */
    public boolean f4059r;

    /* renamed from: t */
    public g f4060t;

    /* renamed from: u */
    public boolean f4061u;

    /* renamed from: v */
    public boolean f4062v;

    /* renamed from: z */
    public static final AccelerateInterpolator f4043z = new AccelerateInterpolator();
    public static final DecelerateInterpolator A = new DecelerateInterpolator();
    public ArrayList<a.b> m = new ArrayList<>();

    /* renamed from: o */
    public int f4056o = 0;

    /* renamed from: p */
    public boolean f4057p = true;
    public boolean s = true;

    /* renamed from: w */
    public final a f4063w = new a();

    /* renamed from: x */
    public final b f4064x = new b();

    /* renamed from: y */
    public final c f4065y = new c();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
            a.AbstractC0067a aVar = xVar2.f4053k;
            if (aVar != null) {
                aVar.c(xVar2.f4052j);
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

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c implements m0 {
        public c() {
            x.this = r1;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d extends i.a implements f.a {

        /* renamed from: h */
        public final Context f4067h;

        /* renamed from: i */
        public final f f4068i;

        /* renamed from: j */
        public a.AbstractC0067a f4069j;

        /* renamed from: k */
        public WeakReference<View> f4070k;

        public d(Context context, h.d dVar) {
            x.this = r1;
            this.f4067h = context;
            this.f4069j = dVar;
            f fVar = new f(context);
            fVar.f589l = 1;
            this.f4068i = fVar;
            fVar.e = this;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final boolean a(f fVar, MenuItem menuItem) {
            a.AbstractC0067a aVar = this.f4069j;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.f.a
        public final void b(f fVar) {
            if (this.f4069j != null) {
                i();
                androidx.appcompat.widget.c cVar = x.this.f4048f.f808i;
                if (cVar != null) {
                    cVar.l();
                }
            }
        }

        @Override // i.a
        public final void c() {
            x xVar = x.this;
            if (xVar.f4051i == this) {
                if (!(!xVar.f4058q)) {
                    xVar.f4052j = this;
                    xVar.f4053k = this.f4069j;
                } else {
                    this.f4069j.c(this);
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
        public final f e() {
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
            if (x.this.f4051i == this) {
                this.f4068i.w();
                try {
                    this.f4069j.d(this, this.f4068i);
                } finally {
                    this.f4068i.v();
                }
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
        View decorView = activity.getWindow().getDecorView();
        t(decorView);
        if (!z6) {
            this.f4049g = decorView.findViewById(16908290);
        }
    }

    public x(Dialog dialog) {
        new ArrayList();
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
        if (z6 != this.f4054l) {
            this.f4054l = z6;
            int size = this.m.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.m.get(i7).a();
            }
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
        f fVar;
        d dVar = this.f4051i;
        if (dVar == null || (fVar = dVar.f4068i) == null) {
            return false;
        }
        boolean z6 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z6 = false;
        }
        fVar.setQwertyMode(z6);
        return fVar.performShortcut(i7, keyEvent, 0);
    }

    @Override // f.a
    public final void l(boolean z6) {
        if (!this.f4050h) {
            m(z6);
        }
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
        g gVar;
        this.f4061u = z6;
        if (!z6 && (gVar = this.f4060t) != null) {
            gVar.a();
        }
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
            if (!dVar3.f4069j.b(dVar3, dVar3.f4068i)) {
                return null;
            }
            this.f4051i = dVar3;
            dVar3.i();
            this.f4048f.f(dVar3);
            s(true);
            return dVar3;
        } finally {
            dVar3.f4068i.v();
        }
    }

    public final void s(boolean z6) {
        k0 k0Var;
        k0 k0Var2;
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
        if (y.g.c(actionBarContainer)) {
            if (z6) {
                k0Var = this.e.r(4, 100);
                k0Var2 = this.f4048f.e(0, 200);
            } else {
                k0Var2 = this.e.r(0, 200);
                k0Var = this.f4048f.e(8, 100);
            }
            g gVar = new g();
            gVar.f4452a.add(k0Var);
            View view = k0Var.f5495a.get();
            long duration = view != null ? view.animate().getDuration() : 0;
            View view2 = k0Var2.f5495a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(duration);
            }
            gVar.f4452a.add(k0Var2);
            gVar.b();
        } else if (z6) {
            this.e.j(4);
            this.f4048f.setVisibility(0);
        } else {
            this.e.j(0);
            this.f4048f.setVisibility(8);
        }
    }

    public final void t(View view) {
        g0 g0Var;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(2131296421);
        this.f4046c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(2131296309);
        if (findViewById instanceof g0) {
            g0Var = (g0) findViewById;
        } else if (findViewById instanceof Toolbar) {
            g0Var = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder d7 = androidx.activity.h.d("Can't make a decor toolbar out of ");
            d7.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(d7.toString());
        }
        this.e = g0Var;
        this.f4048f = (ActionBarContextView) view.findViewById(2131296317);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(2131296311);
        this.f4047d = actionBarContainer;
        g0 g0Var2 = this.e;
        if (g0Var2 == null || this.f4048f == null || actionBarContainer == null) {
            throw new IllegalStateException(x.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f4044a = g0Var2.a();
        if ((this.e.o() & 4) != 0) {
            this.f4050h = true;
        }
        Context context = this.f4044a;
        int i7 = context.getApplicationInfo().targetSdkVersion;
        this.e.k();
        v(context.getResources().getBoolean(2130968576));
        TypedArray obtainStyledAttributes = this.f4044a.obtainStyledAttributes(null, e.f56w, 2130903047, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4046c;
            if (actionBarOverlayLayout2.m) {
                this.f4062v = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f4047d;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.i.s(actionBarContainer2, (float) dimensionPixelSize);
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
        if (!z6) {
            this.e.n();
            this.f4047d.setTabContainer(null);
        } else {
            this.f4047d.setTabContainer(null);
            this.e.n();
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
        View view2;
        View view3;
        i0 i0Var = null;
        if (this.f4059r || !this.f4058q) {
            if (!this.s) {
                this.s = true;
                g gVar = this.f4060t;
                if (gVar != null) {
                    gVar.a();
                }
                this.f4047d.setVisibility(0);
                if (this.f4056o != 0 || (!this.f4061u && !z6)) {
                    this.f4047d.setAlpha(1.0f);
                    this.f4047d.setTranslationY(0.0f);
                    if (this.f4057p && (view2 = this.f4049g) != null) {
                        view2.setTranslationY(0.0f);
                    }
                    this.f4064x.a();
                } else {
                    this.f4047d.setTranslationY(0.0f);
                    float f7 = (float) (-this.f4047d.getHeight());
                    if (z6) {
                        int[] iArr = {0, 0};
                        this.f4047d.getLocationInWindow(iArr);
                        f7 -= (float) iArr[1];
                    }
                    this.f4047d.setTranslationY(f7);
                    g gVar2 = new g();
                    k0 a7 = y.a(this.f4047d);
                    a7.e(0.0f);
                    c cVar = this.f4065y;
                    View view4 = a7.f5495a.get();
                    if (view4 != null) {
                        if (cVar != null) {
                            i0Var = new ValueAnimator.AnimatorUpdateListener(cVar, view4) { // from class: p1.i0

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ m0 f5492a;

                                {
                                    this.f5492a = r1;
                                }

                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    ((View) x.this.f4047d.getParent()).invalidate();
                                }
                            };
                        }
                        k0.a.a(view4.animate(), i0Var);
                    }
                    if (!gVar2.e) {
                        gVar2.f4452a.add(a7);
                    }
                    if (this.f4057p && (view3 = this.f4049g) != null) {
                        view3.setTranslationY(f7);
                        k0 a8 = y.a(this.f4049g);
                        a8.e(0.0f);
                        if (!gVar2.e) {
                            gVar2.f4452a.add(a8);
                        }
                    }
                    DecelerateInterpolator decelerateInterpolator = A;
                    boolean z7 = gVar2.e;
                    if (!z7) {
                        gVar2.f4454c = decelerateInterpolator;
                    }
                    if (!z7) {
                        gVar2.f4453b = 250;
                    }
                    b bVar = this.f4064x;
                    if (!z7) {
                        gVar2.f4455d = bVar;
                    }
                    this.f4060t = gVar2;
                    gVar2.b();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4046c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    y.h.c(actionBarOverlayLayout);
                }
            }
        } else if (this.s) {
            this.s = false;
            g gVar3 = this.f4060t;
            if (gVar3 != null) {
                gVar3.a();
            }
            if (this.f4056o != 0 || (!this.f4061u && !z6)) {
                this.f4063w.a();
                return;
            }
            this.f4047d.setAlpha(1.0f);
            this.f4047d.setTransitioning(true);
            g gVar4 = new g();
            float f8 = (float) (-this.f4047d.getHeight());
            if (z6) {
                int[] iArr2 = {0, 0};
                this.f4047d.getLocationInWindow(iArr2);
                f8 -= (float) iArr2[1];
            }
            k0 a9 = y.a(this.f4047d);
            a9.e(f8);
            c cVar2 = this.f4065y;
            View view5 = a9.f5495a.get();
            if (view5 != null) {
                if (cVar2 != null) {
                    i0Var = new ValueAnimator.AnimatorUpdateListener(cVar2, view5) { // from class: p1.i0

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ m0 f5492a;

                        {
                            this.f5492a = r1;
                        }

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            ((View) x.this.f4047d.getParent()).invalidate();
                        }
                    };
                }
                k0.a.a(view5.animate(), i0Var);
            }
            if (!gVar4.e) {
                gVar4.f4452a.add(a9);
            }
            if (this.f4057p && (view = this.f4049g) != null) {
                k0 a10 = y.a(view);
                a10.e(f8);
                if (!gVar4.e) {
                    gVar4.f4452a.add(a10);
                }
            }
            AccelerateInterpolator accelerateInterpolator = f4043z;
            boolean z8 = gVar4.e;
            if (!z8) {
                gVar4.f4454c = accelerateInterpolator;
            }
            if (!z8) {
                gVar4.f4453b = 250;
            }
            a aVar = this.f4063w;
            if (!z8) {
                gVar4.f4455d = aVar;
            }
            this.f4060t = gVar4;
            gVar4.b();
        }
    }
}
