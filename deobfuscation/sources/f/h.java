package f;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.g1;
import androidx.appcompat.widget.q0;
import f.u;
import i.a;
import i.e;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.WeakHashMap;
import l0.z;
import l1.e;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class h extends f.g implements f.a, LayoutInflater.Factory2 {

    /* renamed from: n0 */
    public static final o.h<String, Integer> f3937n0 = new o.h<>();

    /* renamed from: o0 */
    public static final int[] f3938o0 = {16842836};

    /* renamed from: p0 */
    public static final boolean f3939p0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: q0 */
    public static final boolean f3940q0 = true;
    public ActionBarContextView A;
    public PopupWindow B;
    public f.k C;
    public boolean F;
    public ViewGroup G;
    public TextView H;
    public View I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public l[] R;
    public l S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public Configuration X;
    public int Y;
    public int Z;

    /* renamed from: a0 */
    public int f3941a0;

    /* renamed from: b0 */
    public boolean f3942b0;

    /* renamed from: c0 */
    public j f3943c0;

    /* renamed from: d0 */
    public C0054h f3944d0;

    /* renamed from: e0 */
    public boolean f3945e0;

    /* renamed from: f0 */
    public int f3946f0;

    /* renamed from: h0 */
    public boolean f3948h0;

    /* renamed from: i0 */
    public Rect f3949i0;

    /* renamed from: j0 */
    public Rect f3950j0;

    /* renamed from: k0 */
    public p f3951k0;

    /* renamed from: l0 */
    public OnBackInvokedDispatcher f3952l0;

    /* renamed from: m0 */
    public OnBackInvokedCallback f3953m0;

    /* renamed from: o */
    public final Object f3954o;

    /* renamed from: p */
    public final Context f3955p;

    /* renamed from: q */
    public Window f3956q;

    /* renamed from: r */
    public g f3957r;
    public final f.e s;

    /* renamed from: t */
    public f.a f3958t;

    /* renamed from: u */
    public i.f f3959u;

    /* renamed from: v */
    public CharSequence f3960v;

    /* renamed from: w */
    public f0 f3961w;

    /* renamed from: x */
    public c f3962x;

    /* renamed from: y */
    public m f3963y;

    /* renamed from: z */
    public i.a f3964z;
    public k0 D = null;
    public boolean E = true;

    /* renamed from: g0 */
    public final a f3947g0 = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            h.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h hVar = h.this;
            if ((hVar.f3946f0 & 1) != 0) {
                hVar.I(0);
            }
            h hVar2 = h.this;
            if ((hVar2.f3946f0 & 4096) != 0) {
                hVar2.I(108);
            }
            h hVar3 = h.this;
            hVar3.f3945e0 = false;
            hVar3.f3946f0 = 0;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public final class c implements j.a {
        public c() {
            h.this = r1;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z6) {
            h.this.E(fVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            Window.Callback N = h.this.N();
            if (N != null) {
                N.onMenuOpened(108, fVar);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.InterfaceC0067a {

        /* renamed from: a */
        public a.InterfaceC0067a f3967a;

        /* loaded from: classes.dex */
        public class a extends z {
            public a() {
                d.this = r1;
            }

            @Override // p1.l0
            public final void a() {
                h.this.A.setVisibility(8);
                h hVar = h.this;
                PopupWindow popupWindow = hVar.B;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (hVar.A.getParent() instanceof View) {
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    y.h.c((View) h.this.A.getParent());
                }
                h.this.A.h();
                h.this.D.d(null);
                h hVar2 = h.this;
                hVar2.D = null;
                ViewGroup viewGroup = hVar2.G;
                WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                y.h.c(viewGroup);
            }
        }

        public d(e.a aVar) {
            h.this = r1;
            this.f3967a = aVar;
        }

        @Override // i.a.InterfaceC0067a
        public final boolean a(i.a aVar, MenuItem menuItem) {
            return this.f3967a.a(aVar, menuItem);
        }

        @Override // i.a.InterfaceC0067a
        public final boolean b(i.a aVar, androidx.appcompat.view.menu.f fVar) {
            return this.f3967a.b(aVar, fVar);
        }

        @Override // i.a.InterfaceC0067a
        public final void c(i.a aVar) {
            this.f3967a.c(aVar);
            h hVar = h.this;
            if (hVar.B != null) {
                hVar.f3956q.getDecorView().removeCallbacks(h.this.C);
            }
            h hVar2 = h.this;
            if (hVar2.A != null) {
                k0 k0Var = hVar2.D;
                if (k0Var != null) {
                    k0Var.b();
                }
                h hVar3 = h.this;
                k0 a7 = y.a(hVar3.A);
                a7.a(0.0f);
                hVar3.D = a7;
                h.this.D.d(new a());
            }
            f.e eVar = h.this.s;
            if (eVar != null) {
                eVar.d();
            }
            h hVar4 = h.this;
            hVar4.f3964z = null;
            ViewGroup viewGroup = hVar4.G;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.h.c(viewGroup);
            h.this.V();
        }

        @Override // i.a.InterfaceC0067a
        public final boolean d(i.a aVar, androidx.appcompat.view.menu.f fVar) {
            ViewGroup viewGroup = h.this.G;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.h.c(viewGroup);
            return this.f3967a.d(aVar, fVar);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        public static l1.e b(Configuration configuration) {
            return l1.e.a(configuration.getLocales().toLanguageTags());
        }

        public static void c(l1.e eVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(eVar.f4944a.a()));
        }

        public static void d(Configuration configuration, l1.e eVar) {
            configuration.setLocales(LocaleList.forLanguageTags(eVar.f4944a.a()));
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object obj, h hVar) {
            Objects.requireNonNull(hVar);
            androidx.activity.t tVar = new androidx.activity.t(1, hVar);
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, tVar);
            return tVar;
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* loaded from: classes.dex */
    public class g extends i.h {

        /* renamed from: g */
        public b f3969g;

        /* renamed from: h */
        public boolean f3970h;

        /* renamed from: i */
        public boolean f3971i;

        /* renamed from: j */
        public boolean f3972j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Window.Callback callback) {
            super(callback);
            h.this = r1;
        }

        public final void a(Window.Callback callback) {
            try {
                this.f3970h = true;
                callback.onContentChanged();
            } finally {
                this.f3970h = false;
            }
        }

        @Override // i.h, android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f3971i ? this.f4457f.dispatchKeyEvent(keyEvent) : h.this.H(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARN: Code restructure failed: missing block: B:97:0x0046, code lost:
            if (r4 != false) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
        @Override // i.h, android.view.Window.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r5) {
            /*
                r4 = this;
                boolean r0 = super.dispatchKeyShortcutEvent(r5)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L4d
                f.h r4 = f.h.this
                int r0 = r5.getKeyCode()
                r4.O()
                f.a r3 = r4.f3958t
                if (r3 == 0) goto L1c
                boolean r0 = r3.i(r0, r5)
                if (r0 == 0) goto L1c
                goto L48
            L1c:
                f.h$l r0 = r4.S
                if (r0 == 0) goto L31
                int r3 = r5.getKeyCode()
                boolean r0 = r4.S(r0, r3, r5)
                if (r0 == 0) goto L31
                f.h$l r4 = r4.S
                if (r4 == 0) goto L48
                r4.f3992l = r2
                goto L48
            L31:
                f.h$l r0 = r4.S
                if (r0 != 0) goto L4a
                f.h$l r0 = r4.M(r1)
                r4.T(r0, r5)
                int r3 = r5.getKeyCode()
                boolean r4 = r4.S(r0, r3, r5)
                r0.f3991k = r1
                if (r4 == 0) goto L4a
            L48:
                r4 = r2
                goto L4b
            L4a:
                r4 = r1
            L4b:
                if (r4 == 0) goto L4e
            L4d:
                r1 = r2
            L4e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: f.h.g.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            if (this.f3970h) {
                this.f4457f.onContentChanged();
            }
        }

        @Override // i.h, android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i7, Menu menu) {
            if (i7 != 0 || (menu instanceof androidx.appcompat.view.menu.f)) {
                return super.onCreatePanelMenu(i7, menu);
            }
            return false;
        }

        @Override // i.h, android.view.Window.Callback
        public final View onCreatePanelView(int i7) {
            b bVar = this.f3969g;
            if (bVar != null) {
                View view = i7 == 0 ? new View(u.this.f4020a.a()) : null;
                if (view != null) {
                    return view;
                }
            }
            return super.onCreatePanelView(i7);
        }

        @Override // i.h, android.view.Window.Callback
        public final boolean onMenuOpened(int i7, Menu menu) {
            super.onMenuOpened(i7, menu);
            h hVar = h.this;
            if (i7 == 108) {
                hVar.O();
                f.a aVar = hVar.f3958t;
                if (aVar != null) {
                    aVar.c(true);
                }
            } else {
                hVar.getClass();
            }
            return true;
        }

        @Override // i.h, android.view.Window.Callback
        public final void onPanelClosed(int i7, Menu menu) {
            if (this.f3972j) {
                this.f4457f.onPanelClosed(i7, menu);
                return;
            }
            super.onPanelClosed(i7, menu);
            h hVar = h.this;
            if (i7 == 108) {
                hVar.O();
                f.a aVar = hVar.f3958t;
                if (aVar != null) {
                    aVar.c(false);
                }
            } else if (i7 != 0) {
                hVar.getClass();
            } else {
                l M = hVar.M(i7);
                if (M.m) {
                    hVar.F(M, false);
                }
            }
        }

        @Override // i.h, android.view.Window.Callback
        public final boolean onPreparePanel(int i7, View view, Menu menu) {
            androidx.appcompat.view.menu.f fVar = menu instanceof androidx.appcompat.view.menu.f ? (androidx.appcompat.view.menu.f) menu : null;
            if (i7 == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.f599x = true;
            }
            b bVar = this.f3969g;
            if (bVar != null) {
                u.e eVar = (u.e) bVar;
                if (i7 == 0) {
                    u uVar = u.this;
                    if (!uVar.f4023d) {
                        uVar.f4020a.m = true;
                        uVar.f4023d = true;
                    }
                }
            }
            boolean onPreparePanel = super.onPreparePanel(i7, view, menu);
            if (fVar != null) {
                fVar.f599x = false;
            }
            return onPreparePanel;
        }

        @Override // i.h, android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i7) {
            androidx.appcompat.view.menu.f fVar = h.this.M(0).f3988h;
            if (fVar != null) {
                super.onProvideKeyboardShortcuts(list, fVar, i7);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i7);
            }
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:323:0x014c, code lost:
            if (p1.y.g.c(r8) != false) goto L61;
         */
        @Override // i.h, android.view.Window.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r8, int r9) {
            /*
                Method dump skipped, instructions count: 450
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: f.h.g.onWindowStartingActionMode(android.view.ActionMode$Callback, int):android.view.ActionMode");
        }
    }

    /* renamed from: f.h$h */
    /* loaded from: classes.dex */
    public class C0054h extends i {

        /* renamed from: c */
        public final PowerManager f3974c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0054h(Context context) {
            super();
            h.this = r1;
            this.f3974c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // f.h.i
        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // f.h.i
        public final int c() {
            return this.f3974c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // f.h.i
        public final void d() {
            h.this.A(true, true);
        }
    }

    /* loaded from: classes.dex */
    public abstract class i {

        /* renamed from: a */
        public a f3976a;

        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            public a() {
                i.this = r1;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                i.this.d();
            }
        }

        public i() {
            h.this = r1;
        }

        public final void a() {
            a aVar = this.f3976a;
            if (aVar != null) {
                try {
                    h.this.f3955p.unregisterReceiver(aVar);
                } catch (IllegalArgumentException unused) {
                }
                this.f3976a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public final void e() {
            a();
            IntentFilter b2 = b();
            if (b2 == null || b2.countActions() == 0) {
                return;
            }
            if (this.f3976a == null) {
                this.f3976a = new a();
            }
            h.this.f3955p.registerReceiver(this.f3976a, b2);
        }
    }

    /* loaded from: classes.dex */
    public class j extends i {

        /* renamed from: c */
        public final w f3979c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(w wVar) {
            super();
            h.this = r1;
            this.f3979c = wVar;
        }

        @Override // f.h.i
        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX WARN: Removed duplicated region for block: B:285:0x010d A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:291:? A[RETURN, SYNTHETIC] */
        @Override // f.h.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int c() {
            /*
                Method dump skipped, instructions count: 271
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: f.h.j.c():int");
        }

        @Override // f.h.i
        public final void d() {
            h.this.A(true, true);
        }
    }

    /* loaded from: classes.dex */
    public class k extends ContentFrameLayout {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(i.c cVar) {
            super(cVar, null);
            h.this = r1;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return h.this.H(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x3 = (int) motionEvent.getX();
                int y6 = (int) motionEvent.getY();
                if (x3 < -5 || y6 < -5 || x3 > getWidth() + 5 || y6 > getHeight() + 5) {
                    h hVar = h.this;
                    hVar.F(hVar.M(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i7) {
            setBackgroundDrawable(g.a.a(getContext(), i7));
        }
    }

    /* loaded from: classes.dex */
    public static final class l {

        /* renamed from: a */
        public int f3982a;

        /* renamed from: b */
        public int f3983b;

        /* renamed from: c */
        public int f3984c;

        /* renamed from: d */
        public int f3985d;
        public k e;

        /* renamed from: f */
        public View f3986f;

        /* renamed from: g */
        public View f3987g;

        /* renamed from: h */
        public androidx.appcompat.view.menu.f f3988h;

        /* renamed from: i */
        public androidx.appcompat.view.menu.d f3989i;

        /* renamed from: j */
        public i.c f3990j;

        /* renamed from: k */
        public boolean f3991k;

        /* renamed from: l */
        public boolean f3992l;
        public boolean m;

        /* renamed from: n */
        public boolean f3993n = false;

        /* renamed from: o */
        public boolean f3994o;

        /* renamed from: p */
        public Bundle f3995p;

        public l(int i7) {
            this.f3982a = i7;
        }
    }

    /* loaded from: classes.dex */
    public final class m implements j.a {
        public m() {
            h.this = r1;
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z6) {
            l lVar;
            androidx.appcompat.view.menu.f k6 = fVar.k();
            int i7 = 0;
            boolean z7 = k6 != fVar;
            h hVar = h.this;
            if (z7) {
                fVar = k6;
            }
            l[] lVarArr = hVar.R;
            int length = lVarArr != null ? lVarArr.length : 0;
            while (true) {
                if (i7 < length) {
                    lVar = lVarArr[i7];
                    if (lVar != null && lVar.f3988h == fVar) {
                        break;
                    }
                    i7++;
                } else {
                    lVar = null;
                    break;
                }
            }
            if (lVar != null) {
                if (!z7) {
                    h.this.F(lVar, z6);
                    return;
                }
                h.this.D(lVar.f3982a, lVar, k6);
                h.this.F(lVar, true);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            Window.Callback N;
            if (fVar == fVar.k()) {
                h hVar = h.this;
                if (!hVar.L || (N = hVar.N()) == null || h.this.W) {
                    return true;
                }
                N.onMenuOpened(108, fVar);
                return true;
            }
            return true;
        }
    }

    public h(Context context, Window window, f.e eVar, Object obj) {
        o.h<String, Integer> hVar;
        Integer orDefault;
        f.d dVar;
        this.Y = -100;
        this.f3955p = context;
        this.s = eVar;
        this.f3954o = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof f.d)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    dVar = (f.d) context;
                    break;
                }
            }
            dVar = null;
            if (dVar != null) {
                this.Y = dVar.s().g();
            }
        }
        if (this.Y == -100 && (orDefault = (hVar = f3937n0).getOrDefault(this.f3954o.getClass().getName(), null)) != null) {
            this.Y = orDefault.intValue();
            hVar.remove(this.f3954o.getClass().getName());
        }
        if (window != null) {
            B(window);
        }
        androidx.appcompat.widget.j.d();
    }

    public static l1.e C(Context context) {
        l1.e eVar;
        l1.e eVar2;
        if (Build.VERSION.SDK_INT < 33 && (eVar = f.g.f3931h) != null) {
            l1.e b2 = e.b(context.getApplicationContext().getResources().getConfiguration());
            if (eVar.f4944a.isEmpty()) {
                eVar2 = l1.e.f4943b;
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                int i7 = 0;
                while (i7 < b2.f4944a.size() + eVar.f4944a.size()) {
                    Locale locale = i7 < eVar.f4944a.size() ? eVar.f4944a.get(i7) : b2.f4944a.get(i7 - eVar.f4944a.size());
                    if (locale != null) {
                        linkedHashSet.add(locale);
                    }
                    i7++;
                }
                eVar2 = new l1.e(new l1.g(e.b.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
            }
            return eVar2.f4944a.isEmpty() ? b2 : eVar2;
        }
        return null;
    }

    public static Configuration G(Context context, int i7, l1.e eVar, Configuration configuration, boolean z6) {
        int i8 = i7 != 1 ? i7 != 2 ? z6 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i8 | (configuration2.uiMode & (-49));
        if (eVar != null) {
            e.d(configuration2, eVar);
        }
        return configuration2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:431:0x0138, code lost:
        if ((((androidx.lifecycle.n) r11).k().f1876d.compareTo(androidx.lifecycle.g.b.CREATED) >= 0) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x0141, code lost:
        if (r10.W == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x0143, code lost:
        r11.onConfigurationChanged(r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:384:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0166 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A(boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f.h.A(boolean, boolean):boolean");
    }

    public final void B(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.f3956q != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof g) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        g gVar = new g(callback);
        this.f3957r = gVar;
        window.setCallback(gVar);
        Context context = this.f3955p;
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f3938o0);
        if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawable = null;
        } else {
            androidx.appcompat.widget.j a7 = androidx.appcompat.widget.j.a();
            synchronized (a7) {
                drawable = a7.f941a.f(context, resourceId, true);
            }
        }
        if (drawable != null) {
            window.setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        this.f3956q = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.f3952l0) != null) {
            return;
        }
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f3953m0) != null) {
            f.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f3953m0 = null;
        }
        Object obj = this.f3954o;
        if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
            onBackInvokedDispatcher2 = f.a((Activity) this.f3954o);
        }
        this.f3952l0 = onBackInvokedDispatcher2;
        V();
    }

    public final void D(int i7, l lVar, androidx.appcompat.view.menu.f fVar) {
        if (fVar == null) {
            if (lVar == null && i7 >= 0) {
                l[] lVarArr = this.R;
                if (i7 < lVarArr.length) {
                    lVar = lVarArr[i7];
                }
            }
            if (lVar != null) {
                fVar = lVar.f3988h;
            }
        }
        if ((lVar == null || lVar.m) && !this.W) {
            g gVar = this.f3957r;
            Window.Callback callback = this.f3956q.getCallback();
            gVar.getClass();
            try {
                gVar.f3972j = true;
                callback.onPanelClosed(i7, fVar);
            } finally {
                gVar.f3972j = false;
            }
        }
    }

    public final void E(androidx.appcompat.view.menu.f fVar) {
        if (this.Q) {
            return;
        }
        this.Q = true;
        this.f3961w.l();
        Window.Callback N = N();
        if (N != null && !this.W) {
            N.onPanelClosed(108, fVar);
        }
        this.Q = false;
    }

    public final void F(l lVar, boolean z6) {
        k kVar;
        f0 f0Var;
        if (z6 && lVar.f3982a == 0 && (f0Var = this.f3961w) != null && f0Var.b()) {
            E(lVar.f3988h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f3955p.getSystemService("window");
        if (windowManager != null && lVar.m && (kVar = lVar.e) != null) {
            windowManager.removeView(kVar);
            if (z6) {
                D(lVar.f3982a, lVar, null);
            }
        }
        lVar.f3991k = false;
        lVar.f3992l = false;
        lVar.m = false;
        lVar.f3986f = null;
        lVar.f3993n = true;
        if (this.S == lVar) {
            this.S = null;
        }
        if (lVar.f3982a == 0) {
            V();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:338:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean H(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f.h.H(android.view.KeyEvent):boolean");
    }

    public final void I(int i7) {
        l M = M(i7);
        if (M.f3988h != null) {
            Bundle bundle = new Bundle();
            M.f3988h.t(bundle);
            if (bundle.size() > 0) {
                M.f3995p = bundle;
            }
            M.f3988h.w();
            M.f3988h.clear();
        }
        M.f3994o = true;
        M.f3993n = true;
        if ((i7 == 108 || i7 == 0) && this.f3961w != null) {
            l M2 = M(0);
            M2.f3991k = false;
            T(M2, null);
        }
    }

    public final void J() {
        ViewGroup viewGroup;
        if (this.F) {
            return;
        }
        TypedArray obtainStyledAttributes = this.f3955p.obtainStyledAttributes(a0.e.F);
        if (!obtainStyledAttributes.hasValue(117)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(126, false)) {
            t(1);
        } else if (obtainStyledAttributes.getBoolean(117, false)) {
            t(108);
        }
        if (obtainStyledAttributes.getBoolean(118, false)) {
            t(109);
        }
        if (obtainStyledAttributes.getBoolean(119, false)) {
            t(10);
        }
        this.O = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        K();
        this.f3956q.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f3955p);
        if (this.P) {
            viewGroup = (ViewGroup) from.inflate(this.N ? 2131492886 : 2131492885, (ViewGroup) null);
        } else if (this.O) {
            viewGroup = (ViewGroup) from.inflate(2131492876, (ViewGroup) null);
            this.M = false;
            this.L = false;
        } else if (this.L) {
            TypedValue typedValue = new TypedValue();
            this.f3955p.getTheme().resolveAttribute(2130903051, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new i.c(this.f3955p, typedValue.resourceId) : this.f3955p).inflate(2131492887, (ViewGroup) null);
            f0 f0Var = (f0) viewGroup.findViewById(2131296421);
            this.f3961w = f0Var;
            f0Var.setWindowCallback(N());
            if (this.M) {
                this.f3961w.k(109);
            }
            if (this.J) {
                this.f3961w.k(2);
            }
            if (this.K) {
                this.f3961w.k(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            StringBuilder d7 = androidx.activity.h.d("AppCompat does not support the current theme features: { windowActionBar: ");
            d7.append(this.L);
            d7.append(", windowActionBarOverlay: ");
            d7.append(this.M);
            d7.append(", android:windowIsFloating: ");
            d7.append(this.O);
            d7.append(", windowActionModeOverlay: ");
            d7.append(this.N);
            d7.append(", windowNoTitle: ");
            d7.append(this.P);
            d7.append(" }");
            throw new IllegalArgumentException(d7.toString());
        }
        f.i iVar = new f.i(this);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.i.u(viewGroup, iVar);
        if (this.f3961w == null) {
            this.H = (TextView) viewGroup.findViewById(2131296873);
        }
        Method method = g1.f908a;
        try {
            Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method2.isAccessible()) {
                method2.setAccessible(true);
            }
            method2.invoke(viewGroup, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e7) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e7);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(2131296310);
        ViewGroup viewGroup2 = (ViewGroup) this.f3956q.findViewById(16908290);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f3956q.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new f.j(this));
        this.G = viewGroup;
        Object obj = this.f3954o;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f3960v;
        if (!TextUtils.isEmpty(title)) {
            f0 f0Var2 = this.f3961w;
            if (f0Var2 != null) {
                f0Var2.setWindowTitle(title);
            } else {
                f.a aVar = this.f3958t;
                if (aVar != null) {
                    aVar.q(title);
                } else {
                    TextView textView = this.H;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.G.findViewById(16908290);
        View decorView = this.f3956q.getDecorView();
        contentFrameLayout2.f728l.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
        if (y.g.c(contentFrameLayout2)) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray obtainStyledAttributes2 = this.f3955p.obtainStyledAttributes(a0.e.F);
        obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (obtainStyledAttributes2.hasValue(122)) {
            obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (obtainStyledAttributes2.hasValue(123)) {
            obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (obtainStyledAttributes2.hasValue(120)) {
            obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (obtainStyledAttributes2.hasValue(121)) {
            obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        obtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.F = true;
        l M = M(0);
        if (this.W || M.f3988h != null) {
            return;
        }
        this.f3946f0 |= 4096;
        if (this.f3945e0) {
            return;
        }
        y.d.m(this.f3956q.getDecorView(), this.f3947g0);
        this.f3945e0 = true;
    }

    public final void K() {
        if (this.f3956q == null) {
            Object obj = this.f3954o;
            if (obj instanceof Activity) {
                B(((Activity) obj).getWindow());
            }
        }
        if (this.f3956q == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final i L(Context context) {
        if (this.f3943c0 == null) {
            if (w.f4037d == null) {
                Context applicationContext = context.getApplicationContext();
                w.f4037d = new w(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f3943c0 = new j(w.f4037d);
        }
        return this.f3943c0;
    }

    public final l M(int i7) {
        l[] lVarArr = this.R;
        if (lVarArr == null || lVarArr.length <= i7) {
            l[] lVarArr2 = new l[i7 + 1];
            if (lVarArr != null) {
                System.arraycopy(lVarArr, 0, lVarArr2, 0, lVarArr.length);
            }
            this.R = lVarArr2;
            lVarArr = lVarArr2;
        }
        l lVar = lVarArr[i7];
        if (lVar == null) {
            l lVar2 = new l(i7);
            lVarArr[i7] = lVar2;
            return lVar2;
        }
        return lVar;
    }

    public final Window.Callback N() {
        return this.f3956q.getCallback();
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void O() {
        /*
            r3 = this;
            r3.J()
            boolean r0 = r3.L
            if (r0 == 0) goto L37
            f.a r0 = r3.f3958t
            if (r0 == 0) goto Lc
            goto L37
        Lc:
            java.lang.Object r0 = r3.f3954o
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L20
            f.x r0 = new f.x
            java.lang.Object r1 = r3.f3954o
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.M
            r0.<init>(r1, r2)
        L1d:
            r3.f3958t = r0
            goto L2e
        L20:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L2e
            f.x r0 = new f.x
            java.lang.Object r1 = r3.f3954o
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L1d
        L2e:
            f.a r0 = r3.f3958t
            if (r0 == 0) goto L37
            boolean r3 = r3.f3948h0
            r0.l(r3)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.h.O():void");
    }

    public final int P(Context context, int i7) {
        i L;
        if (i7 != -100) {
            if (i7 != -1) {
                if (i7 != 0) {
                    if (i7 != 1 && i7 != 2) {
                        if (i7 != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.f3944d0 == null) {
                            this.f3944d0 = new C0054h(context);
                        }
                        L = this.f3944d0;
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                } else {
                    L = L(context);
                }
                return L.c();
            }
            return i7;
        }
        return -1;
    }

    public final boolean Q() {
        boolean z6 = this.T;
        this.T = false;
        l M = M(0);
        if (M.m) {
            if (!z6) {
                F(M, true);
            }
            return true;
        }
        i.a aVar = this.f3964z;
        if (aVar != null) {
            aVar.c();
            return true;
        }
        O();
        f.a aVar2 = this.f3958t;
        return aVar2 != null && aVar2.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:426:0x0151, code lost:
        if (r15 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x0175, code lost:
        if (r15.f569k.getCount() > 0) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:461:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void R(f.h.l r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f.h.R(f.h$l, android.view.KeyEvent):void");
    }

    public final boolean S(l lVar, int i7, KeyEvent keyEvent) {
        androidx.appcompat.view.menu.f fVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((lVar.f3991k || T(lVar, keyEvent)) && (fVar = lVar.f3988h) != null) {
            return fVar.performShortcut(i7, keyEvent, 1);
        }
        return false;
    }

    public final boolean T(l lVar, KeyEvent keyEvent) {
        f0 f0Var;
        f0 f0Var2;
        Resources.Theme theme;
        f0 f0Var3;
        f0 f0Var4;
        if (this.W) {
            return false;
        }
        if (lVar.f3991k) {
            return true;
        }
        l lVar2 = this.S;
        if (lVar2 != null && lVar2 != lVar) {
            F(lVar2, false);
        }
        Window.Callback N = N();
        if (N != null) {
            lVar.f3987g = N.onCreatePanelView(lVar.f3982a);
        }
        int i7 = lVar.f3982a;
        boolean z6 = i7 == 0 || i7 == 108;
        if (z6 && (f0Var4 = this.f3961w) != null) {
            f0Var4.c();
        }
        if (lVar.f3987g == null && (!z6 || !(this.f3958t instanceof u))) {
            androidx.appcompat.view.menu.f fVar = lVar.f3988h;
            if (fVar == null || lVar.f3994o) {
                if (fVar == null) {
                    Context context = this.f3955p;
                    int i8 = lVar.f3982a;
                    if ((i8 == 0 || i8 == 108) && this.f3961w != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(2130903051, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(2130903052, typedValue, true);
                        } else {
                            theme2.resolveAttribute(2130903052, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            i.c cVar = new i.c(context, 0);
                            cVar.getTheme().setTo(theme);
                            context = cVar;
                        }
                    }
                    androidx.appcompat.view.menu.f fVar2 = new androidx.appcompat.view.menu.f(context);
                    fVar2.e = this;
                    androidx.appcompat.view.menu.f fVar3 = lVar.f3988h;
                    if (fVar2 != fVar3) {
                        if (fVar3 != null) {
                            fVar3.r(lVar.f3989i);
                        }
                        lVar.f3988h = fVar2;
                        androidx.appcompat.view.menu.d dVar = lVar.f3989i;
                        if (dVar != null) {
                            fVar2.b(dVar, fVar2.f579a);
                        }
                    }
                    if (lVar.f3988h == null) {
                        return false;
                    }
                }
                if (z6 && (f0Var2 = this.f3961w) != null) {
                    if (this.f3962x == null) {
                        this.f3962x = new c();
                    }
                    f0Var2.f(lVar.f3988h, this.f3962x);
                }
                lVar.f3988h.w();
                if (!N.onCreatePanelMenu(lVar.f3982a, lVar.f3988h)) {
                    androidx.appcompat.view.menu.f fVar4 = lVar.f3988h;
                    if (fVar4 != null) {
                        if (fVar4 != null) {
                            fVar4.r(lVar.f3989i);
                        }
                        lVar.f3988h = null;
                    }
                    if (z6 && (f0Var = this.f3961w) != null) {
                        f0Var.f(null, this.f3962x);
                    }
                    return false;
                }
                lVar.f3994o = false;
            }
            lVar.f3988h.w();
            Bundle bundle = lVar.f3995p;
            if (bundle != null) {
                lVar.f3988h.s(bundle);
                lVar.f3995p = null;
            }
            if (!N.onPreparePanel(0, lVar.f3987g, lVar.f3988h)) {
                if (z6 && (f0Var3 = this.f3961w) != null) {
                    f0Var3.f(null, this.f3962x);
                }
                lVar.f3988h.v();
                return false;
            }
            lVar.f3988h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            lVar.f3988h.v();
        }
        lVar.f3991k = true;
        lVar.f3992l = false;
        this.S = lVar;
        return true;
    }

    public final void U() {
        if (this.F) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void V() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z6 = false;
            if (this.f3952l0 != null && (M(0).m || this.f3964z != null)) {
                z6 = true;
            }
            if (z6 && this.f3953m0 == null) {
                this.f3953m0 = f.b(this.f3952l0, this);
            } else if (z6 || (onBackInvokedCallback = this.f3953m0) == null) {
            } else {
                f.c(this.f3952l0, onBackInvokedCallback);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        int i7;
        int i8;
        l lVar;
        Window.Callback N = N();
        if (N != null && !this.W) {
            androidx.appcompat.view.menu.f k6 = fVar.k();
            l[] lVarArr = this.R;
            if (lVarArr != null) {
                i7 = lVarArr.length;
                i8 = 0;
            } else {
                i7 = 0;
                i8 = 0;
            }
            while (true) {
                if (i8 < i7) {
                    lVar = lVarArr[i8];
                    if (lVar != null && lVar.f3988h == k6) {
                        break;
                    }
                    i8++;
                } else {
                    lVar = null;
                    break;
                }
            }
            if (lVar != null) {
                return N.onMenuItemSelected(lVar.f3982a, menuItem);
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final void b(androidx.appcompat.view.menu.f fVar) {
        f0 f0Var = this.f3961w;
        if (f0Var == null || !f0Var.h() || (ViewConfiguration.get(this.f3955p).hasPermanentMenuKey() && !this.f3961w.d())) {
            l M = M(0);
            M.f3993n = true;
            F(M, false);
            R(M, null);
            return;
        }
        Window.Callback N = N();
        if (this.f3961w.b()) {
            this.f3961w.e();
            if (this.W) {
                return;
            }
            N.onPanelClosed(108, M(0).f3988h);
        } else if (N == null || this.W) {
        } else {
            if (this.f3945e0 && (1 & this.f3946f0) != 0) {
                this.f3956q.getDecorView().removeCallbacks(this.f3947g0);
                this.f3947g0.run();
            }
            l M2 = M(0);
            androidx.appcompat.view.menu.f fVar2 = M2.f3988h;
            if (fVar2 == null || M2.f3994o || !N.onPreparePanel(0, M2.f3987g, fVar2)) {
                return;
            }
            N.onMenuOpened(108, M2.f3988h);
            this.f3961w.g();
        }
    }

    @Override // f.g
    public final void c(View view, ViewGroup.LayoutParams layoutParams) {
        J();
        ((ViewGroup) this.G.findViewById(16908290)).addView(view, layoutParams);
        this.f3957r.a(this.f3956q.getCallback());
    }

    @Override // f.g
    public final Context d(Context context) {
        this.U = true;
        int i7 = this.Y;
        if (i7 == -100) {
            i7 = f.g.f3930g;
        }
        int P = P(context, i7);
        boolean z6 = false;
        if (f.g.l(context) && f.g.l(context)) {
            if (!l1.a.a()) {
                synchronized (f.g.f3936n) {
                    l1.e eVar = f.g.f3931h;
                    if (eVar == null) {
                        if (f.g.f3932i == null) {
                            f.g.f3932i = l1.e.a(s.b(context));
                        }
                        if (!f.g.f3932i.f4944a.isEmpty()) {
                            f.g.f3931h = f.g.f3932i;
                        }
                    } else if (!eVar.equals(f.g.f3932i)) {
                        l1.e eVar2 = f.g.f3931h;
                        f.g.f3932i = eVar2;
                        s.a(context, eVar2.f4944a.a());
                    }
                }
            } else if (!f.g.f3934k) {
                f.g.f3929f.execute(new f.f(context, 0));
            }
        }
        l1.e C = C(context);
        Configuration configuration = null;
        if (f3940q0 && (context instanceof ContextThemeWrapper)) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(G(context, P, C, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof i.c) {
            try {
                ((i.c) context).a(G(context, P, C, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (f3939p0) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f7 = configuration3.fontScale;
                    float f8 = configuration4.fontScale;
                    if (f7 != f8) {
                        configuration.fontScale = f8;
                    }
                    int i8 = configuration3.mcc;
                    int i9 = configuration4.mcc;
                    if (i8 != i9) {
                        configuration.mcc = i9;
                    }
                    int i10 = configuration3.mnc;
                    int i11 = configuration4.mnc;
                    if (i10 != i11) {
                        configuration.mnc = i11;
                    }
                    e.a(configuration3, configuration4, configuration);
                    int i12 = configuration3.touchscreen;
                    int i13 = configuration4.touchscreen;
                    if (i12 != i13) {
                        configuration.touchscreen = i13;
                    }
                    int i14 = configuration3.keyboard;
                    int i15 = configuration4.keyboard;
                    if (i14 != i15) {
                        configuration.keyboard = i15;
                    }
                    int i16 = configuration3.keyboardHidden;
                    int i17 = configuration4.keyboardHidden;
                    if (i16 != i17) {
                        configuration.keyboardHidden = i17;
                    }
                    int i18 = configuration3.navigation;
                    int i19 = configuration4.navigation;
                    if (i18 != i19) {
                        configuration.navigation = i19;
                    }
                    int i20 = configuration3.navigationHidden;
                    int i21 = configuration4.navigationHidden;
                    if (i20 != i21) {
                        configuration.navigationHidden = i21;
                    }
                    int i22 = configuration3.orientation;
                    int i23 = configuration4.orientation;
                    if (i22 != i23) {
                        configuration.orientation = i23;
                    }
                    int i24 = configuration3.screenLayout & 15;
                    int i25 = configuration4.screenLayout & 15;
                    if (i24 != i25) {
                        configuration.screenLayout |= i25;
                    }
                    int i26 = configuration3.screenLayout & 192;
                    int i27 = configuration4.screenLayout & 192;
                    if (i26 != i27) {
                        configuration.screenLayout |= i27;
                    }
                    int i28 = configuration3.screenLayout & 48;
                    int i29 = configuration4.screenLayout & 48;
                    if (i28 != i29) {
                        configuration.screenLayout |= i29;
                    }
                    int i30 = configuration3.screenLayout & 768;
                    int i31 = configuration4.screenLayout & 768;
                    if (i30 != i31) {
                        configuration.screenLayout |= i31;
                    }
                    int i32 = configuration3.colorMode & 3;
                    int i33 = configuration4.colorMode & 3;
                    if (i32 != i33) {
                        configuration.colorMode |= i33;
                    }
                    int i34 = configuration3.colorMode & 12;
                    int i35 = configuration4.colorMode & 12;
                    if (i34 != i35) {
                        configuration.colorMode |= i35;
                    }
                    int i36 = configuration3.uiMode & 15;
                    int i37 = configuration4.uiMode & 15;
                    if (i36 != i37) {
                        configuration.uiMode |= i37;
                    }
                    int i38 = configuration3.uiMode & 48;
                    int i39 = configuration4.uiMode & 48;
                    if (i38 != i39) {
                        configuration.uiMode |= i39;
                    }
                    int i40 = configuration3.screenWidthDp;
                    int i41 = configuration4.screenWidthDp;
                    if (i40 != i41) {
                        configuration.screenWidthDp = i41;
                    }
                    int i42 = configuration3.screenHeightDp;
                    int i43 = configuration4.screenHeightDp;
                    if (i42 != i43) {
                        configuration.screenHeightDp = i43;
                    }
                    int i44 = configuration3.smallestScreenWidthDp;
                    int i45 = configuration4.smallestScreenWidthDp;
                    if (i44 != i45) {
                        configuration.smallestScreenWidthDp = i45;
                    }
                    int i46 = configuration3.densityDpi;
                    int i47 = configuration4.densityDpi;
                    if (i46 != i47) {
                        configuration.densityDpi = i47;
                    }
                }
            }
            Configuration G = G(context, P, C, configuration, true);
            i.c cVar = new i.c(context, 2131886622);
            cVar.a(G);
            try {
                z6 = context.getTheme() != null;
            } catch (NullPointerException unused3) {
            }
            if (z6) {
                h1.h.a(cVar.getTheme());
            }
            return cVar;
        }
        return context;
    }

    @Override // f.g
    public final <T extends View> T e(int i7) {
        J();
        return (T) this.f3956q.findViewById(i7);
    }

    @Override // f.g
    public final Context f() {
        return this.f3955p;
    }

    @Override // f.g
    public final int g() {
        return this.Y;
    }

    @Override // f.g
    public final MenuInflater h() {
        if (this.f3959u == null) {
            O();
            f.a aVar = this.f3958t;
            this.f3959u = new i.f(aVar != null ? aVar.e() : this.f3955p);
        }
        return this.f3959u;
    }

    @Override // f.g
    public final f.a i() {
        O();
        return this.f3958t;
    }

    @Override // f.g
    public final void j() {
        LayoutInflater from = LayoutInflater.from(this.f3955p);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (from.getFactory2() instanceof h) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // f.g
    public final void k() {
        if (this.f3958t != null) {
            O();
            if (this.f3958t.f()) {
                return;
            }
            this.f3946f0 |= 1;
            if (this.f3945e0) {
                return;
            }
            View decorView = this.f3956q.getDecorView();
            a aVar = this.f3947g0;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.m(decorView, aVar);
            this.f3945e0 = true;
        }
    }

    @Override // f.g
    public final void m(Configuration configuration) {
        if (this.L && this.F) {
            O();
            f.a aVar = this.f3958t;
            if (aVar != null) {
                aVar.g();
            }
        }
        androidx.appcompat.widget.j a7 = androidx.appcompat.widget.j.a();
        Context context = this.f3955p;
        synchronized (a7) {
            q0 q0Var = a7.f941a;
            synchronized (q0Var) {
                o.e<WeakReference<Drawable.ConstantState>> eVar = q0Var.f1025b.get(context);
                if (eVar != null) {
                    eVar.a();
                }
            }
        }
        this.X = new Configuration(this.f3955p.getResources().getConfiguration());
        A(false, false);
    }

    @Override // f.g
    public final void n() {
        this.U = true;
        A(false, true);
        K();
        Object obj = this.f3954o;
        if (obj instanceof Activity) {
            String str = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    str = f1.g.b(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e7) {
                    throw new IllegalArgumentException(e7);
                }
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                f.a aVar = this.f3958t;
                if (aVar == null) {
                    this.f3948h0 = true;
                } else {
                    aVar.l(true);
                }
            }
            synchronized (f.g.m) {
                f.g.s(this);
                f.g.f3935l.add(new WeakReference<>(this));
            }
        }
        this.X = new Configuration(this.f3955p.getResources().getConfiguration());
        this.V = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    @Override // f.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f3954o
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = f.g.m
            monitor-enter(r0)
            f.g.s(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r3
        L11:
            boolean r0 = r3.f3945e0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f3956q
            android.view.View r0 = r0.getDecorView()
            f.h$a r1 = r3.f3947g0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.W = r0
            int r0 = r3.Y
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f3954o
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            o.h<java.lang.String, java.lang.Integer> r0 = f.h.f3937n0
            java.lang.Object r1 = r3.f3954o
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.Y
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            o.h<java.lang.String, java.lang.Integer> r0 = f.h.f3937n0
            java.lang.Object r1 = r3.f3954o
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            f.a r0 = r3.f3958t
            if (r0 == 0) goto L63
            r0.h()
        L63:
            f.h$j r0 = r3.f3943c0
            if (r0 == 0) goto L6a
            r0.a()
        L6a:
            f.h$h r3 = r3.f3944d0
            if (r3 == 0) goto L71
            r3.a()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.h.o():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x0115, code lost:
        if (r9.equals("ImageButton") == false) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:521:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x01c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:530:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:533:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0206 A[Catch: all -> 0x0212, Exception -> 0x021a, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x021a, all -> 0x0212, blocks: (B:531:0x01d9, B:534:0x01e8, B:536:0x01ec, B:541:0x0206), top: B:561:0x01d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:549:0x0223  */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View onCreateView(android.view.View r8, java.lang.String r9, android.content.Context r10, android.util.AttributeSet r11) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f.h.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // f.g
    public final void p() {
        O();
        f.a aVar = this.f3958t;
        if (aVar != null) {
            aVar.p(true);
        }
    }

    @Override // f.g
    public final void q() {
        A(true, false);
    }

    @Override // f.g
    public final void r() {
        O();
        f.a aVar = this.f3958t;
        if (aVar != null) {
            aVar.p(false);
        }
    }

    @Override // f.g
    public final boolean t(int i7) {
        if (i7 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i7 = 108;
        } else if (i7 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i7 = 109;
        }
        if (this.P && i7 == 108) {
            return false;
        }
        if (this.L && i7 == 1) {
            this.L = false;
        }
        if (i7 == 1) {
            U();
            this.P = true;
            return true;
        } else if (i7 == 2) {
            U();
            this.J = true;
            return true;
        } else if (i7 == 5) {
            U();
            this.K = true;
            return true;
        } else if (i7 == 10) {
            U();
            this.N = true;
            return true;
        } else if (i7 == 108) {
            U();
            this.L = true;
            return true;
        } else if (i7 != 109) {
            return this.f3956q.requestFeature(i7);
        } else {
            U();
            this.M = true;
            return true;
        }
    }

    @Override // f.g
    public final void u(int i7) {
        J();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f3955p).inflate(i7, viewGroup);
        this.f3957r.a(this.f3956q.getCallback());
    }

    @Override // f.g
    public final void v(View view) {
        J();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f3957r.a(this.f3956q.getCallback());
    }

    @Override // f.g
    public final void w(View view, ViewGroup.LayoutParams layoutParams) {
        J();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f3957r.a(this.f3956q.getCallback());
    }

    @Override // f.g
    public final void x(Toolbar toolbar) {
        if (this.f3954o instanceof Activity) {
            O();
            f.a aVar = this.f3958t;
            if (aVar instanceof x) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f3959u = null;
            if (aVar != null) {
                aVar.h();
            }
            this.f3958t = null;
            if (toolbar != null) {
                Object obj = this.f3954o;
                u uVar = new u(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : this.f3960v, this.f3957r);
                this.f3958t = uVar;
                this.f3957r.f3969g = uVar.f4022c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f3957r.f3969g = null;
            }
            k();
        }
    }

    @Override // f.g
    public final void y(int i7) {
        this.Z = i7;
    }

    @Override // f.g
    public final void z(CharSequence charSequence) {
        this.f3960v = charSequence;
        f0 f0Var = this.f3961w;
        if (f0Var != null) {
            f0Var.setWindowTitle(charSequence);
            return;
        }
        f.a aVar = this.f3958t;
        if (aVar != null) {
            aVar.q(charSequence);
            return;
        }
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
