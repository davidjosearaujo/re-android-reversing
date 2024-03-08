package p1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContentInfo;
import android.view.Display;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p1.a;
import p1.c;
import p1.p0;
import q1.f;
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class y {

    /* renamed from: a */
    public static WeakHashMap<View, k0> f5540a = null;

    /* renamed from: b */
    public static final int[] f5541b = {2131296274, 2131296275, 2131296286, 2131296297, 2131296300, 2131296301, 2131296302, 2131296303, 2131296304, 2131296305, 2131296276, 2131296277, 2131296278, 2131296279, 2131296280, 2131296281, 2131296282, 2131296283, 2131296284, 2131296285, 2131296287, 2131296288, 2131296289, 2131296290, 2131296291, 2131296292, 2131296293, 2131296294, 2131296295, 2131296296, 2131296298, 2131296299};

    /* renamed from: c */
    public static final v f5542c = new v();

    /* renamed from: d */
    public static final a f5543d = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: f */
        public final WeakHashMap<View, Boolean> f5544f = new WeakHashMap<>();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class b<T> {

        /* renamed from: a */
        public final int f5545a;

        /* renamed from: b */
        public final Class<T> f5546b;

        /* renamed from: c */
        public final int f5547c;

        /* renamed from: d */
        public final int f5548d;

        public b(int i7, Class<T> cls, int i8, int i9) {
            this.f5545a = i7;
            this.f5546b = cls;
            this.f5548d = i8;
            this.f5547c = i9;
        }

        public static boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public abstract T b(View view);

        public abstract void c(View view, T t5);

        public final T d(View view) {
            if (Build.VERSION.SDK_INT >= this.f5547c) {
                return b(view);
            }
            T t5 = (T) view.getTag(this.f5545a);
            if (this.f5546b.isInstance(t5)) {
                return t5;
            }
            return null;
        }

        public final void e(View view, T t5) {
            if (Build.VERSION.SDK_INT >= this.f5547c) {
                c(view, t5);
            } else if (f(d(view), t5)) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                View.AccessibilityDelegate a7 = m.a(view);
                a aVar = a7 == null ? null : a7 instanceof a.C0092a ? ((a.C0092a) a7).f5468a : new a(a7);
                if (aVar == null) {
                    aVar = new a();
                }
                y.i(view, aVar);
                view.setTag(this.f5545a, t5);
                y.e(view, this.f5548d);
            }
        }

        public abstract boolean f(T t5, T t6);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {
        public static boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d {
        public static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        public static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        public static int c(View view) {
            return view.getImportantForAccessibility();
        }

        public static int d(View view) {
            return view.getMinimumHeight();
        }

        public static int e(View view) {
            return view.getMinimumWidth();
        }

        public static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        public static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        public static boolean i(View view) {
            return view.hasTransientState();
        }

        public static boolean j(View view, int i7, Bundle bundle) {
            return view.performAccessibilityAction(i7, bundle);
        }

        public static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        public static void l(View view, int i7, int i8, int i9, int i10) {
            view.postInvalidateOnAnimation(i7, i8, i9, i10);
        }

        public static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static void n(View view, Runnable runnable, long j7) {
            view.postOnAnimationDelayed(runnable, j7);
        }

        public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public static void p(View view) {
            view.requestFitSystemWindows();
        }

        public static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public static void r(View view, boolean z6) {
            view.setHasTransientState(z6);
        }

        public static void s(View view, int i7) {
            view.setImportantForAccessibility(i7);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e {
        public static int a() {
            return View.generateViewId();
        }

        public static Display b(View view) {
            return view.getDisplay();
        }

        public static int c(View view) {
            return view.getLabelFor();
        }

        public static int d(View view) {
            return view.getLayoutDirection();
        }

        public static int e(View view) {
            return view.getPaddingEnd();
        }

        public static int f(View view) {
            return view.getPaddingStart();
        }

        public static boolean g(View view) {
            return view.isPaddingRelative();
        }

        public static void h(View view, int i7) {
            view.setLabelFor(i7);
        }

        public static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public static void j(View view, int i7) {
            view.setLayoutDirection(i7);
        }

        public static void k(View view, int i7, int i8, int i9, int i10) {
            view.setPaddingRelative(i7, i8, i9, i10);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class f {
        public static Rect a(View view) {
            return view.getClipBounds();
        }

        public static boolean b(View view) {
            return view.isInLayout();
        }

        public static void c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class g {
        public static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        public static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        public static boolean c(View view) {
            return view.isLaidOut();
        }

        public static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        public static void e(ViewParent viewParent, View view, View view2, int i7) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i7);
        }

        public static void f(View view, int i7) {
            view.setAccessibilityLiveRegion(i7);
        }

        public static void g(AccessibilityEvent accessibilityEvent, int i7) {
            accessibilityEvent.setContentChangeTypes(i7);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class h {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class i {

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a */
            public final /* synthetic */ p f5549a;

            public a(View view, p pVar) {
                this.f5549a = pVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return this.f5549a.a(view, p0.h(view, windowInsets)).g();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(2131296833);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static p0 b(View view, p0 p0Var, Rect rect) {
            WindowInsets g2 = p0Var.g();
            if (g2 != null) {
                return p0.h(view, view.computeSystemWindowInsets(g2, rect));
            }
            rect.setEmpty();
            return p0Var;
        }

        public static boolean c(View view, float f7, float f8, boolean z6) {
            return view.dispatchNestedFling(f7, f8, z6);
        }

        public static boolean d(View view, float f7, float f8) {
            return view.dispatchNestedPreFling(f7, f8);
        }

        public static boolean e(View view, int i7, int i8, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i7, i8, iArr, iArr2);
        }

        public static boolean f(View view, int i7, int i8, int i9, int i10, int[] iArr) {
            return view.dispatchNestedScroll(i7, i8, i9, i10, iArr);
        }

        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        public static float i(View view) {
            return view.getElevation();
        }

        public static p0 j(View view) {
            if (p0.a.f5514d && view.isAttachedToWindow()) {
                try {
                    Object obj = p0.a.f5511a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) p0.a.f5512b.get(obj);
                        Rect rect2 = (Rect) p0.a.f5513c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            p0.c cVar = new p0.c();
                            cVar.d(i1.b.b(rect.left, rect.top, rect.right, rect.bottom));
                            cVar.f(i1.b.b(rect2.left, rect2.top, rect2.right, rect2.bottom));
                            p0 b2 = cVar.b();
                            b2.f5510a.p(b2);
                            b2.f5510a.d(view.getRootView());
                            return b2;
                        }
                    }
                } catch (IllegalAccessException e) {
                    StringBuilder d7 = androidx.activity.h.d("Failed to get insets from AttachInfo. ");
                    d7.append(e.getMessage());
                    Log.w("WindowInsetsCompat", d7.toString(), e);
                }
            }
            return null;
        }

        public static String k(View view) {
            return view.getTransitionName();
        }

        public static float l(View view) {
            return view.getTranslationZ();
        }

        public static float m(View view) {
            return view.getZ();
        }

        public static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void s(View view, float f7) {
            view.setElevation(f7);
        }

        public static void t(View view, boolean z6) {
            view.setNestedScrollingEnabled(z6);
        }

        public static void u(View view, p pVar) {
            if (pVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(2131296833));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, pVar));
            }
        }

        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void w(View view, float f7) {
            view.setTranslationZ(f7);
        }

        public static void x(View view, float f7) {
            view.setZ(f7);
        }

        public static boolean y(View view, int i7) {
            return view.startNestedScroll(i7);
        }

        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class j {
        public static p0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            p0 h7 = p0.h(null, rootWindowInsets);
            h7.f5510a.p(h7);
            h7.f5510a.d(view.getRootView());
            return h7;
        }

        public static int b(View view) {
            return view.getScrollIndicators();
        }

        public static void c(View view, int i7) {
            view.setScrollIndicators(i7);
        }

        public static void d(View view, int i7, int i8) {
            view.setScrollIndicators(i7, i8);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class k {
        public static void a(View view, Collection<View> collection, int i7) {
            view.addKeyboardNavigationClusters(collection, i7);
        }

        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        public static int c(View view) {
            return view.getImportantForAutofill();
        }

        public static int d(View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean e(View view) {
            return view.hasExplicitFocusable();
        }

        public static boolean f(View view) {
            return view.isFocusedByDefault();
        }

        public static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        public static boolean h(View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static View i(View view, View view2, int i7) {
            return view.keyboardNavigationClusterSearch(view2, i7);
        }

        public static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        public static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void l(View view, boolean z6) {
            view.setFocusedByDefault(z6);
        }

        public static void m(View view, int i7) {
            view.setImportantForAutofill(i7);
        }

        public static void n(View view, boolean z6) {
            view.setKeyboardNavigationCluster(z6);
        }

        public static void o(View view, int i7) {
            view.setNextClusterForwardId(i7);
        }

        public static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class l {
        public static void a(View view, q qVar) {
            o.h hVar = (o.h) view.getTag(2131296832);
            if (hVar == null) {
                hVar = new o.h();
                view.setTag(2131296832, hVar);
            }
            Objects.requireNonNull(qVar);
            z zVar = new z(qVar);
            hVar.put(qVar, zVar);
            view.addOnUnhandledKeyEventListener(zVar);
        }

        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void e(View view, q qVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            o.h hVar = (o.h) view.getTag(2131296832);
            if (hVar != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) hVar.getOrDefault(qVar, null)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        public static <T> T f(View view, int i7) {
            return (T) view.requireViewById(i7);
        }

        public static void g(View view, boolean z6) {
            view.setAccessibilityHeading(z6);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, AutofillId autofillId) {
            view.setAutofillId(autofillId);
        }

        public static void j(View view, boolean z6) {
            view.setScreenReaderFocusable(z6);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class m {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        public static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i7, int i8) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i7, i8);
        }

        public static void e(View view, ContentCaptureSession contentCaptureSession) {
            view.setContentCaptureSession(contentCaptureSession);
        }

        public static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class n {
        public static int a(View view) {
            return view.getImportantForContentCapture();
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static q0 c(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return new q0(windowInsetsController);
            }
            return null;
        }

        public static boolean d(View view) {
            return view.isImportantForContentCapture();
        }

        public static void e(View view, int i7) {
            view.setImportantForContentCapture(i7);
        }

        public static void f(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class o {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static c b(View view, c cVar) {
            ContentInfo c7 = cVar.f5470a.c();
            Objects.requireNonNull(c7);
            ContentInfo contentInfo = view.performReceiveContent(c7);
            if (contentInfo == null) {
                return null;
            }
            return contentInfo == c7 ? cVar : new c(new c.d(contentInfo));
        }

        public static void c(View view, String[] strArr, q qVar) {
            if (qVar == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new p(qVar));
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class p implements OnReceiveContentListener {

        /* renamed from: a */
        public final q f5550a;

        public p(q qVar) {
            this.f5550a = qVar;
        }

        public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            c cVar = new c(new c.d(contentInfo));
            c a7 = this.f5550a.a(view, cVar);
            if (a7 == null) {
                return null;
            }
            if (a7 == cVar) {
                return contentInfo;
            }
            ContentInfo c7 = a7.f5470a.c();
            Objects.requireNonNull(c7);
            return c7;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface q {
        boolean a();
    }

    static {
        new AtomicInteger(1);
    }

    public static k0 a(View view) {
        if (f5540a == null) {
            f5540a = new WeakHashMap<>();
        }
        k0 k0Var = f5540a.get(view);
        if (k0Var != null) {
            return k0Var;
        }
        k0 k0Var2 = new k0(view);
        f5540a.put(view, k0Var2);
        return k0Var2;
    }

    public static CharSequence b(View view) {
        return l.b(view);
    }

    public static ArrayList c(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(2131296821);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(2131296821, arrayList2);
        return arrayList2;
    }

    public static String[] d(View view) {
        return Build.VERSION.SDK_INT >= 31 ? o.a(view) : (String[]) view.getTag(2131296827);
    }

    public static void e(View view, int i7) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z6 = b(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            int i8 = 32;
            if (g.a(view) != 0 || z6) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z6) {
                    i8 = 2048;
                }
                obtain.setEventType(i8);
                g.g(obtain, i7);
                if (z6) {
                    obtain.getText().add(b(view));
                    if (d.c(view) == 0) {
                        d.s(view, 1);
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i7 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                g.g(obtain2, i7);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(b(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    g.e(view.getParent(), view, view, i7);
                } catch (AbstractMethodError e7) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e7);
                }
            }
        }
    }

    public static c f(View view, c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return o.b(view, cVar);
        }
        q qVar = (q) view.getTag(2131296826);
        if (qVar != null) {
            c a7 = qVar.a(view, cVar);
            if (a7 == null) {
                return null;
            }
            return (view instanceof r ? (r) view : f5542c).a(a7);
        }
        return (view instanceof r ? (r) view : f5542c).a(cVar);
    }

    public static void g(View view, int i7) {
        ArrayList c7 = c(view);
        for (int i8 = 0; i8 < c7.size(); i8++) {
            if (((f.a) c7.get(i8)).a() == i7) {
                c7.remove(i8);
                return;
            }
        }
    }

    public static void h(View view, f.a aVar, q1.j jVar) {
        f.a aVar2 = new f.a(null, aVar.f5635b, null, jVar, aVar.f5636c);
        View.AccessibilityDelegate a7 = m.a(view);
        a aVar3 = a7 == null ? null : a7 instanceof a.C0092a ? ((a.C0092a) a7).f5468a : new a(a7);
        if (aVar3 == null) {
            aVar3 = new a();
        }
        i(view, aVar3);
        g(view, aVar2.a());
        c(view).add(aVar2);
        e(view, 0);
    }

    public static void i(View view, a aVar) {
        if (aVar == null && (m.a(view) instanceof a.C0092a)) {
            aVar = new a();
        }
        if (d.c(view) == 0) {
            d.s(view, 1);
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.f5467b);
    }

    public static void j(View view, CharSequence charSequence) {
        new w(CharSequence.class).e(view, charSequence);
        if (charSequence != null) {
            a aVar = f5543d;
            aVar.f5544f.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(aVar);
            if (g.b(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
                return;
            }
            return;
        }
        a aVar2 = f5543d;
        aVar2.f5544f.remove(view);
        view.removeOnAttachStateChangeListener(aVar2);
        d.o(view.getViewTreeObserver(), aVar2);
    }
}
