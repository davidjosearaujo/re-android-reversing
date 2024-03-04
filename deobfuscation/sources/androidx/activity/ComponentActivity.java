package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.a0;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.g;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.savedstate.a;
import d.a;
import f1.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ComponentActivity extends f1.e implements f0, androidx.lifecycle.e, h2.c, w, androidx.activity.result.g {

    /* renamed from: g */
    public final c.a f356g = new c.a();

    /* renamed from: h */
    public final p1.h f357h = new p1.h();

    /* renamed from: i */
    public final androidx.lifecycle.o f358i;

    /* renamed from: j */
    public final h2.b f359j;

    /* renamed from: k */
    public e0 f360k;

    /* renamed from: l */
    public OnBackPressedDispatcher f361l;
    public final e m;

    /* renamed from: n */
    public final m f362n;

    /* renamed from: o */
    public final AtomicInteger f363o;

    /* renamed from: p */
    public final a f364p;

    /* renamed from: q */
    public final CopyOnWriteArrayList<o1.a<Configuration>> f365q;

    /* renamed from: r */
    public final CopyOnWriteArrayList<o1.a<Integer>> f366r;
    public final CopyOnWriteArrayList<o1.a<Intent>> s;

    /* renamed from: t */
    public final CopyOnWriteArrayList<o1.a<a0.e>> f367t;

    /* renamed from: u */
    public final CopyOnWriteArrayList<o1.a<a0.b>> f368u;

    /* renamed from: v */
    public boolean f369v;

    /* renamed from: w */
    public boolean f370w;

    /* loaded from: classes.dex */
    public class a extends androidx.activity.result.f {
        public a() {
            ComponentActivity.this = r1;
        }

        @Override // androidx.activity.result.f
        public final void b(int i7, d.a aVar, Object obj) {
            ComponentActivity componentActivity = ComponentActivity.this;
            a.C0043a b2 = aVar.b(componentActivity, obj);
            if (b2 != null) {
                new Handler(Looper.getMainLooper()).post(new i(this, i7, b2));
                return;
            }
            Intent a7 = aVar.a(componentActivity, obj);
            Bundle bundle = null;
            if (a7.getExtras() != null && a7.getExtras().getClassLoader() == null) {
                a7.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a7.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a7.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a7.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            }
            Bundle bundle2 = bundle;
            if (!"androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a7.getAction())) {
                if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a7.getAction())) {
                    int i8 = f1.a.f4073b;
                    a.C0055a.b(componentActivity, a7, i7, bundle2);
                    return;
                }
                androidx.activity.result.h hVar = (androidx.activity.result.h) a7.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    IntentSender intentSender = hVar.f456f;
                    Intent intent = hVar.f457g;
                    int i9 = hVar.f458h;
                    int i10 = hVar.f459i;
                    int i11 = f1.a.f4073b;
                    a.C0055a.c(componentActivity, intentSender, i7, intent, i9, i10, 0, bundle2);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    new Handler(Looper.getMainLooper()).post(new j(this, i7, e));
                    return;
                }
            }
            String[] stringArrayExtra = a7.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            int i12 = f1.a.f4073b;
            HashSet hashSet = new HashSet();
            for (int i13 = 0; i13 < stringArrayExtra.length; i13++) {
                if (TextUtils.isEmpty(stringArrayExtra[i13])) {
                    throw new IllegalArgumentException(h.c(h.d("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[i13], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i13));
                }
            }
            int size = hashSet.size();
            String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
            if (size > 0) {
                if (size == stringArrayExtra.length) {
                    return;
                }
                int i14 = 0;
                for (int i15 = 0; i15 < stringArrayExtra.length; i15++) {
                    if (!hashSet.contains(Integer.valueOf(i15))) {
                        strArr[i14] = stringArrayExtra[i15];
                        i14++;
                    }
                }
            }
            if (componentActivity instanceof a.c) {
                ((a.c) componentActivity).e();
            }
            a.b.b(componentActivity, stringArrayExtra, i7);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
            ComponentActivity.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            } catch (NullPointerException e7) {
                if (!TextUtils.equals(e7.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e7;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a */
        public e0 f377a;
    }

    /* loaded from: classes.dex */
    public class e implements Executor, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: g */
        public Runnable f379g;

        /* renamed from: f */
        public final long f378f = SystemClock.uptimeMillis() + 10000;

        /* renamed from: h */
        public boolean f380h = false;

        public e() {
            ComponentActivity.this = r5;
        }

        public final void a(View view) {
            if (this.f380h) {
                return;
            }
            this.f380h = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f379g = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f380h) {
                decorView.postOnAnimation(new androidx.activity.d(1, this));
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            boolean z6;
            Runnable runnable = this.f379g;
            if (runnable != null) {
                runnable.run();
                this.f379g = null;
                m mVar = ComponentActivity.this.f362n;
                synchronized (mVar.f425b) {
                    z6 = mVar.f426c;
                }
                if (!z6) {
                    return;
                }
            } else if (SystemClock.uptimeMillis() <= this.f378f) {
                return;
            }
            this.f380h = false;
            ComponentActivity.this.getWindow().getDecorView().post(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.activity.e] */
    public ComponentActivity() {
        androidx.lifecycle.o oVar = new androidx.lifecycle.o(this);
        this.f358i = oVar;
        h2.b bVar = new h2.b(this);
        this.f359j = bVar;
        this.f361l = null;
        e eVar = new e();
        this.m = eVar;
        this.f362n = new m(eVar, new q5.a() { // from class: androidx.activity.e
            @Override // q5.a
            public final Object d() {
                ComponentActivity.this.reportFullyDrawn();
                return null;
            }
        });
        this.f363o = new AtomicInteger();
        this.f364p = new a();
        this.f365q = new CopyOnWriteArrayList<>();
        this.f366r = new CopyOnWriteArrayList<>();
        this.s = new CopyOnWriteArrayList<>();
        this.f367t = new CopyOnWriteArrayList<>();
        this.f368u = new CopyOnWriteArrayList<>();
        this.f369v = false;
        this.f370w = false;
        oVar.a(new androidx.lifecycle.l() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.l
            public final void c(androidx.lifecycle.n nVar, g.a aVar) {
                if (aVar == g.a.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        oVar.a(new androidx.lifecycle.l() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.l
            public final void c(androidx.lifecycle.n nVar, g.a aVar) {
                if (aVar == g.a.ON_DESTROY) {
                    ComponentActivity.this.f356g.f2459b = null;
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.i().a();
                    }
                    e eVar2 = ComponentActivity.this.m;
                    ComponentActivity.this.getWindow().getDecorView().removeCallbacks(eVar2);
                    ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(eVar2);
                }
            }
        });
        oVar.a(new androidx.lifecycle.l() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.l
            public final void c(androidx.lifecycle.n nVar, g.a aVar) {
                ComponentActivity componentActivity = ComponentActivity.this;
                if (componentActivity.f360k == null) {
                    d dVar = (d) componentActivity.getLastNonConfigurationInstance();
                    if (dVar != null) {
                        componentActivity.f360k = dVar.f377a;
                    }
                    if (componentActivity.f360k == null) {
                        componentActivity.f360k = new e0();
                    }
                }
                ComponentActivity.this.f358i.c(this);
            }
        });
        bVar.a();
        g.b bVar2 = oVar.f1876d;
        if (!(bVar2 == g.b.INITIALIZED || bVar2 == g.b.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (bVar.f4376b.b() == null) {
            a0 a0Var = new a0(bVar.f4376b, this);
            bVar.f4376b.c("androidx.lifecycle.internal.SavedStateHandlesProvider", a0Var);
            oVar.a(new SavedStateHandleAttacher(a0Var));
        }
        bVar.f4376b.c("android:support:activity-result", new a.b() { // from class: androidx.activity.f
            @Override // androidx.savedstate.a.b
            public final Bundle a() {
                switch (r1) {
                    case 0:
                        ComponentActivity componentActivity = (ComponentActivity) this;
                        componentActivity.getClass();
                        Bundle bundle = new Bundle();
                        ComponentActivity.a aVar = componentActivity.f364p;
                        aVar.getClass();
                        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(aVar.f447b.values()));
                        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(aVar.f447b.keySet()));
                        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(aVar.f449d));
                        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) aVar.f451g.clone());
                        return bundle;
                    default:
                        return y.a((y) this);
                }
            }
        });
        n(new c.b() { // from class: androidx.activity.g
            @Override // c.b
            public final void a() {
                ComponentActivity componentActivity = ComponentActivity.this;
                Bundle a7 = componentActivity.f359j.f4376b.a("android:support:activity-result");
                if (a7 != null) {
                    ComponentActivity.a aVar = componentActivity.f364p;
                    aVar.getClass();
                    ArrayList<Integer> integerArrayList = a7.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = a7.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    aVar.f449d = a7.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    aVar.f451g.putAll(a7.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                    for (int i7 = 0; i7 < stringArrayList.size(); i7++) {
                        String str = stringArrayList.get(i7);
                        if (aVar.f447b.containsKey(str)) {
                            Integer num = (Integer) aVar.f447b.remove(str);
                            if (!aVar.f451g.containsKey(str)) {
                                aVar.f446a.remove(num);
                            }
                        }
                        int intValue = integerArrayList.get(i7).intValue();
                        String str2 = stringArrayList.get(i7);
                        aVar.f446a.put(Integer.valueOf(intValue), str2);
                        aVar.f447b.put(str2, Integer.valueOf(intValue));
                    }
                }
            }
        });
    }

    @Override // androidx.activity.w
    public final OnBackPressedDispatcher a() {
        if (this.f361l == null) {
            this.f361l = new OnBackPressedDispatcher(new b());
            this.f358i.a(new androidx.lifecycle.l() { // from class: androidx.activity.ComponentActivity.6
                @Override // androidx.lifecycle.l
                public final void c(androidx.lifecycle.n nVar, g.a aVar) {
                    if (aVar != g.a.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    OnBackPressedDispatcher onBackPressedDispatcher = ComponentActivity.this.f361l;
                    OnBackInvokedDispatcher a7 = c.a((ComponentActivity) nVar);
                    onBackPressedDispatcher.getClass();
                    r5.h.f(a7, "invoker");
                    onBackPressedDispatcher.f387f = a7;
                    onBackPressedDispatcher.c(onBackPressedDispatcher.f389h);
                }
            });
        }
        return this.f361l;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        o();
        this.m.a(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // h2.c
    public final androidx.savedstate.a b() {
        return this.f359j.f4376b;
    }

    @Override // androidx.lifecycle.e
    public final d2.a f() {
        d2.c cVar = new d2.c();
        if (getApplication() != null) {
            cVar.f3555a.put(a0.b.f5c, getApplication());
        }
        cVar.f3555a.put(z.f1901a, this);
        cVar.f3555a.put(z.f1902b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            cVar.f3555a.put(z.f1903c, getIntent().getExtras());
        }
        return cVar;
    }

    @Override // androidx.activity.result.g
    public final androidx.activity.result.f h() {
        return this.f364p;
    }

    @Override // androidx.lifecycle.f0
    public final e0 i() {
        if (getApplication() != null) {
            if (this.f360k == null) {
                d dVar = (d) getLastNonConfigurationInstance();
                if (dVar != null) {
                    this.f360k = dVar.f377a;
                }
                if (this.f360k == null) {
                    this.f360k = new e0();
                }
            }
            return this.f360k;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // f1.e, androidx.lifecycle.n
    public final androidx.lifecycle.o k() {
        return this.f358i;
    }

    public final void n(c.b bVar) {
        c.a aVar = this.f356g;
        aVar.getClass();
        if (aVar.f2459b != null) {
            bVar.a();
        }
        aVar.f2458a.add(bVar);
    }

    public final void o() {
        a0.b.B(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        r5.h.f(decorView, "<this>");
        decorView.setTag(2131296918, this);
        a0.b.C(getWindow().getDecorView(), this);
        View decorView2 = getWindow().getDecorView();
        r5.h.f(decorView2, "<this>");
        decorView2.setTag(2131296916, this);
        View decorView3 = getWindow().getDecorView();
        r5.h.f(decorView3, "<this>");
        decorView3.setTag(2131296746, this);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i7, int i8, Intent intent) {
        if (this.f364p.a(i7, i8, intent)) {
            return;
        }
        super.onActivityResult(i7, i8, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public final void onBackPressed() {
        a().b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<o1.a<Configuration>> it = this.f365q.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // f1.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f359j.b(bundle);
        c.a aVar = this.f356g;
        aVar.getClass();
        aVar.f2459b = this;
        Iterator it = aVar.f2458a.iterator();
        while (it.hasNext()) {
            ((c.b) it.next()).a();
        }
        super.onCreate(bundle);
        int i7 = androidx.lifecycle.w.f1893g;
        w.b.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i7, Menu menu) {
        if (i7 == 0) {
            super.onCreatePanelMenu(i7, menu);
            p1.h hVar = this.f357h;
            getMenuInflater();
            Iterator<p1.j> it = hVar.f5491a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i7, MenuItem menuItem) {
        if (super.onMenuItemSelected(i7, menuItem)) {
            return true;
        }
        if (i7 == 0) {
            Iterator<p1.j> it = this.f357h.f5491a.iterator();
            while (it.hasNext()) {
                if (it.next().b()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z6) {
        if (this.f369v) {
            return;
        }
        Iterator<o1.a<a0.e>> it = this.f367t.iterator();
        while (it.hasNext()) {
            it.next().accept(new a0.e());
        }
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z6, Configuration configuration) {
        this.f369v = true;
        try {
            super.onMultiWindowModeChanged(z6, configuration);
            this.f369v = false;
            Iterator<o1.a<a0.e>> it = this.f367t.iterator();
            while (it.hasNext()) {
                it.next().accept(new a0.e(0));
            }
        } catch (Throwable th) {
            this.f369v = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<o1.a<Intent>> it = this.s.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i7, Menu menu) {
        Iterator<p1.j> it = this.f357h.f5491a.iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
        super.onPanelClosed(i7, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z6) {
        if (this.f370w) {
            return;
        }
        Iterator<o1.a<a0.b>> it = this.f368u.iterator();
        while (it.hasNext()) {
            it.next().accept(new a0.b());
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z6, Configuration configuration) {
        this.f370w = true;
        try {
            super.onPictureInPictureModeChanged(z6, configuration);
            this.f370w = false;
            Iterator<o1.a<a0.b>> it = this.f368u.iterator();
            while (it.hasNext()) {
                it.next().accept(new a0.b(0));
            }
        } catch (Throwable th) {
            this.f370w = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i7, View view, Menu menu) {
        if (i7 == 0) {
            super.onPreparePanel(i7, view, menu);
            Iterator<p1.j> it = this.f357h.f5491a.iterator();
            while (it.hasNext()) {
                it.next().getClass();
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        if (this.f364p.a(i7, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i7, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        d dVar;
        e0 e0Var = this.f360k;
        if (e0Var == null && (dVar = (d) getLastNonConfigurationInstance()) != null) {
            e0Var = dVar.f377a;
        }
        if (e0Var == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.f377a = e0Var;
        return dVar2;
    }

    @Override // f1.e, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.o oVar = this.f358i;
        if (oVar instanceof androidx.lifecycle.o) {
            oVar.h();
        }
        super.onSaveInstanceState(bundle);
        this.f359j.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i7) {
        super.onTrimMemory(i7);
        Iterator<o1.a<Integer>> it = this.f366r.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i7));
        }
    }

    public final androidx.activity.result.d p(androidx.activity.result.b bVar, d.a aVar) {
        a aVar2 = this.f364p;
        StringBuilder d7 = h.d("activity_rq#");
        d7.append(this.f363o.getAndIncrement());
        return aVar2.c(d7.toString(), this, aVar, bVar);
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (j2.a.a()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            m mVar = this.f362n;
            synchronized (mVar.f425b) {
                mVar.f426c = true;
                Iterator it = mVar.f427d.iterator();
                while (it.hasNext()) {
                    ((q5.a) it.next()).d();
                }
                mVar.f427d.clear();
                f5.g gVar = f5.g.f4141a;
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i7) {
        o();
        this.m.a(getWindow().getDecorView());
        super.setContentView(i7);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        o();
        this.m.a(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        o();
        this.m.a(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    @Deprecated
    public final void startActivityForResult(Intent intent, int i7) {
        super.startActivityForResult(intent, i7);
    }

    @Override // android.app.Activity
    @Deprecated
    public final void startActivityForResult(Intent intent, int i7, Bundle bundle) {
        super.startActivityForResult(intent, i7, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public final void startIntentSenderForResult(IntentSender intentSender, int i7, Intent intent, int i8, int i9, int i10) {
        super.startIntentSenderForResult(intentSender, i7, intent, i8, i9, i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public final void startIntentSenderForResult(IntentSender intentSender, int i7, Intent intent, int i8, int i9, int i10, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i7, intent, i8, i9, i10, bundle);
    }
}
