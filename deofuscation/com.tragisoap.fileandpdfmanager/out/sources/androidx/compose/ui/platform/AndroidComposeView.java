package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.lifecycle.n;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import f5.g;
import h0.f;
import h2.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import l0.b0;
import l0.c0;
import l0.e0;
import l0.h0;
import l0.o;
import l0.r;
import l0.z;
import q.e;
import q5.l;
import r0.f;
import r0.g;
import r0.j;
import r5.h;
import t0.d;
@SuppressLint({"ViewConstructor", "VisibleForTests"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class AndroidComposeView extends ViewGroup implements c0, h0, f, androidx.lifecycle.b {

    /* renamed from: x  reason: collision with root package name */
    public static Class<?> f1105x;

    /* renamed from: y  reason: collision with root package name */
    public static Method f1106y;

    /* renamed from: f  reason: collision with root package name */
    public long f1107f;

    /* renamed from: g  reason: collision with root package name */
    public d f1108g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f1109h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1110i;

    /* renamed from: j  reason: collision with root package name */
    public l<? super Configuration, g> f1111j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1112k;

    /* renamed from: l  reason: collision with root package name */
    public l f1113l;
    public t0.a m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1114n;

    /* renamed from: o  reason: collision with root package name */
    public long f1115o;

    /* renamed from: p  reason: collision with root package name */
    public long f1116p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f1117q;

    /* renamed from: r  reason: collision with root package name */
    public long f1118r;
    public l<? super b, g> s;

    /* renamed from: t  reason: collision with root package name */
    public int f1119t;

    /* renamed from: u  reason: collision with root package name */
    public MotionEvent f1120u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1121v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f1122w;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {
        public static final boolean a() {
            Class<?> cls = AndroidComposeView.f1105x;
            try {
                if (AndroidComposeView.f1105x == null) {
                    Class<?> cls2 = Class.forName("android.os.SystemProperties");
                    AndroidComposeView.f1105x = cls2;
                    AndroidComposeView.f1106y = cls2.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
                }
                Method method = AndroidComposeView.f1106y;
                Boolean bool = null;
                Object invoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
                if (invoke instanceof Boolean) {
                    bool = (Boolean) invoke;
                }
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final n f1123a;

        /* renamed from: b  reason: collision with root package name */
        public final c f1124b;

        public b(n nVar, c cVar) {
            this.f1123a = nVar;
            this.f1124b = cVar;
        }
    }

    static {
        new a();
    }

    public static long e(int i7) {
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                size = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            } else if (mode == 1073741824) {
                return o(size, size);
            } else {
                throw new IllegalStateException();
            }
        }
        return o(0, size);
    }

    public static void g(o oVar) {
        oVar.h();
        e<o> f7 = oVar.f();
        int i7 = f7.f5605h;
        if (i7 > 0) {
            int i8 = 0;
            o[] oVarArr = f7.f5603f;
            do {
                g(oVarArr[i8]);
                i8++;
            } while (i8 < i7);
        }
    }

    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    private final b get_viewTreeOwners() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009c A[LOOP:0: B:34:0x0061->B:54:0x009c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f A[EDGE_INSN: B:57:0x009f->B:55:0x009f ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i(android.view.MotionEvent r6) {
        /*
            float r0 = r6.getX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0014
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r3
        L_0x0015:
            if (r0 == 0) goto L_0x0059
            float r0 = r6.getY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0029
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0029
            r0 = r2
            goto L_0x002a
        L_0x0029:
            r0 = r3
        L_0x002a:
            if (r0 == 0) goto L_0x0059
            float r0 = r6.getRawX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x003e
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x003e
            r0 = r2
            goto L_0x003f
        L_0x003e:
            r0 = r3
        L_0x003f:
            if (r0 == 0) goto L_0x0059
            float r0 = r6.getRawY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0053
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0053
            r0 = r2
            goto L_0x0054
        L_0x0053:
            r0 = r3
        L_0x0054:
            if (r0 != 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r0 = r3
            goto L_0x005a
        L_0x0059:
            r0 = r2
        L_0x005a:
            if (r0 != 0) goto L_0x009f
            int r1 = r6.getPointerCount()
            r4 = r2
        L_0x0061:
            if (r4 >= r1) goto L_0x009f
            float r0 = r6.getX(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L_0x0075
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0075
            r0 = r2
            goto L_0x0076
        L_0x0075:
            r0 = r3
        L_0x0076:
            if (r0 == 0) goto L_0x0099
            float r0 = r6.getY(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L_0x008a
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x008a
            r0 = r2
            goto L_0x008b
        L_0x008a:
            r0 = r3
        L_0x008b:
            if (r0 == 0) goto L_0x0099
            androidx.compose.ui.platform.w r0 = androidx.compose.ui.platform.w.f1241a
            boolean r0 = r0.a(r6, r4)
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r0 = r3
            goto L_0x009a
        L_0x0099:
            r0 = r2
        L_0x009a:
            if (r0 != 0) goto L_0x009f
            int r4 = r4 + 1
            goto L_0x0061
        L_0x009f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.i(android.view.MotionEvent):boolean");
    }

    public static long o(int i7, int i8) {
        return ((long) i8) | (((long) i7) << 32);
    }

    private void setFontFamilyResolver(g.a aVar) {
        throw null;
    }

    private void setLayoutDirection(t0.g gVar) {
        throw null;
    }

    private final void set_viewTreeOwners(b bVar) {
        throw null;
    }

    @Override // l0.c0
    public final void a(o oVar, boolean z6, boolean z7, boolean z8) {
        h.f(oVar, "layoutNode");
        if (z6) {
            throw null;
        }
        throw null;
    }

    @Override // android.view.View
    public final void autofill(SparseArray<AutofillValue> sparseArray) {
        h.f(sparseArray, "values");
    }

    @Override // androidx.lifecycle.b
    public final void b(n nVar) {
        setShowLayoutBounds(a.a());
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i7) {
        throw null;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i7) {
        throw null;
    }

    @Override // l0.c0
    public final void d(o oVar, boolean z6, boolean z7) {
        h.f(oVar, "layoutNode");
        if (z6) {
            throw null;
        }
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        h.f(canvas, "canvas");
        if (!isAttachedToWindow()) {
            g(getRoot());
        }
        m(true);
        this.f1110i = true;
        throw null;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        h.f(motionEvent, "event");
        if (motionEvent.getActionMasked() == 8) {
            if (motionEvent.isFromSource(4194304)) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                float f7 = -motionEvent.getAxisValue(26);
                getContext();
                getContext();
                return getFocusOwner().f(new i0.b(p1.c0.b(viewConfiguration) * f7, p1.c0.a(viewConfiguration) * f7, motionEvent.getEventTime()));
            } else if (!i(motionEvent) && isAttachedToWindow()) {
                return (f(motionEvent) & 1) != 0;
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        h.f(motionEvent, "event");
        if (this.f1121v) {
            removeCallbacks(null);
            throw null;
        } else if (i(motionEvent) || !isAttachedToWindow()) {
            return false;
        } else {
            throw null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        h.f(keyEvent, "event");
        if (!isFocused()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        keyEvent.getMetaState();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        h.f(keyEvent, "event");
        return (isFocused() && getFocusOwner().c(keyEvent)) || super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        h.f(motionEvent, "motionEvent");
        if (this.f1121v) {
            removeCallbacks(null);
            MotionEvent motionEvent2 = this.f1120u;
            h.c(motionEvent2);
            if (motionEvent.getActionMasked() == 0) {
                if (!((motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) ? false : true)) {
                    this.f1121v = false;
                }
            }
            throw null;
        }
        if (i(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !k(motionEvent)) {
            return false;
        }
        int f7 = f(motionEvent);
        if ((f7 & 2) != 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return (f7 & 1) != 0;
    }

    public final int f(MotionEvent motionEvent) {
        removeCallbacks(null);
        try {
            this.f1116p = AnimationUtils.currentAnimationTimeMillis();
            throw null;
        } catch (Throwable th) {
            this.f1117q = false;
            throw th;
        }
    }

    public final View findViewByAccessibilityIdTraversal(int i7) {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(this, Integer.valueOf(i7));
            if (invoke instanceof View) {
                return (View) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // l0.c0
    public b getAccessibilityManager() {
        return null;
    }

    public final l getAndroidViewsHandler$ui_release() {
        if (this.f1113l == null) {
            Context context = getContext();
            h.e(context, "context");
            l lVar = new l(context);
            this.f1113l = lVar;
            addView(lVar);
        }
        l lVar2 = this.f1113l;
        h.c(lVar2);
        return lVar2;
    }

    @Override // l0.c0
    public y.b getAutofill() {
        return null;
    }

    @Override // l0.c0
    public y.g getAutofillTree() {
        return null;
    }

    @Override // l0.c0
    public c getClipboardManager() {
        return null;
    }

    public final l<Configuration, f5.g> getConfigurationChangeObserver() {
        return this.f1111j;
    }

    public i5.f getCoroutineContext() {
        return null;
    }

    @Override // l0.c0
    public t0.c getDensity() {
        return this.f1108g;
    }

    @Override // l0.c0
    public z.b getFocusOwner() {
        return null;
    }

    @Override // android.view.View
    public final void getFocusedRect(Rect rect) {
        f5.g gVar;
        h.f(rect, "rect");
        a0.c a7 = getFocusOwner().a();
        if (a7 != null) {
            rect.left = q2.a.K(a7.f26a);
            rect.top = q2.a.K(a7.f27b);
            rect.right = q2.a.K(a7.f28c);
            rect.bottom = q2.a.K(a7.f29d);
            gVar = f5.g.f4141a;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // l0.c0
    public g.a getFontFamilyResolver() {
        throw null;
    }

    @Override // l0.c0
    public f.a getFontLoader() {
        return null;
    }

    @Override // l0.c0
    public e0.a getHapticFeedBack() {
        return null;
    }

    public boolean getHasPendingMeasureOrLayout() {
        throw null;
    }

    @Override // l0.c0
    public f0.b getInputModeManager() {
        return null;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.f1116p;
    }

    @Override // android.view.ViewParent, android.view.View, l0.c0
    public t0.g getLayoutDirection() {
        throw null;
    }

    public long getMeasureIteration() {
        throw null;
    }

    public k0.a getModifierLocalManager() {
        return null;
    }

    @Override // l0.c0
    public s0.c getPlatformTextInputPluginRegistry() {
        return null;
    }

    @Override // l0.c0
    public h0.b getPointerIconService() {
        return null;
    }

    public o getRoot() {
        return null;
    }

    public h0 getRootForTest() {
        return null;
    }

    public o0.l getSemanticsOwner() {
        return null;
    }

    @Override // l0.c0
    public r getSharedDrawScope() {
        return null;
    }

    @Override // l0.c0
    public boolean getShowLayoutBounds() {
        return this.f1112k;
    }

    @Override // l0.c0
    public e0 getSnapshotObserver() {
        return null;
    }

    @Override // l0.c0
    public s0.e getTextInputService() {
        return null;
    }

    @Override // l0.c0
    public a0 getTextToolbar() {
        return null;
    }

    public View getView() {
        return this;
    }

    @Override // l0.c0
    public c0 getViewConfiguration() {
        return null;
    }

    public final b getViewTreeOwners() {
        throw null;
    }

    @Override // l0.c0
    public e0 getWindowInfo() {
        return null;
    }

    public final void h(o oVar) {
        throw null;
    }

    public final boolean j(MotionEvent motionEvent) {
        float x6 = motionEvent.getX();
        float y6 = motionEvent.getY();
        if (0.0f <= x6 && x6 <= ((float) getWidth())) {
            if (0.0f <= y6 && y6 <= ((float) getHeight())) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        if (motionEvent.getPointerCount() != 1 || (motionEvent2 = this.f1120u) == null || motionEvent2.getPointerCount() != motionEvent.getPointerCount()) {
            return true;
        }
        if (!(motionEvent.getRawX() == motionEvent2.getRawX())) {
            return true;
        }
        return !((motionEvent.getRawY() > motionEvent2.getRawY() ? 1 : (motionEvent.getRawY() == motionEvent2.getRawY() ? 0 : -1)) == 0);
    }

    public final long l(long j7) {
        p();
        long p6 = a0.b.p(null, j7);
        return a0.b.a(a0.a.b(this.f1118r) + a0.a.b(p6), a0.a.c(this.f1118r) + a0.a.c(p6));
    }

    public final void m(boolean z6) {
        throw null;
    }

    public final void n(b0 b0Var, boolean z6) {
        h.f(b0Var, "layer");
        if (!z6) {
            if (!this.f1110i) {
                throw null;
            }
        } else if (this.f1110i) {
            ArrayList arrayList = this.f1109h;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f1109h = arrayList;
            }
            arrayList.add(b0Var);
        } else {
            throw null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h(getRoot());
        g(getRoot());
        getSnapshotObserver().getClass();
        throw null;
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        getPlatformTextInputPluginRegistry().getClass();
        throw null;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        h.f(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Context context = getContext();
        h.e(context, "context");
        this.f1108g = z.d(context);
        int i7 = Build.VERSION.SDK_INT;
        int i8 = 0;
        if ((i7 >= 31 ? configuration.fontWeightAdjustment : 0) != this.f1119t) {
            if (i7 >= 31) {
                i8 = configuration.fontWeightAdjustment;
            }
            this.f1119t = i8;
            Context context2 = getContext();
            h.e(context2, "context");
            setFontFamilyResolver(new j(new q2.a(context2), r0.b.a(context2)));
        }
        this.f1111j.k(configuration);
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        h.f(editorInfo, "outAttrs");
        getPlatformTextInputPluginRegistry().getClass();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().getClass();
        throw null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        h.f(canvas, "canvas");
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z6, int i7, Rect rect) {
        super.onFocusChanged(z6, i7, rect);
        Log.d("Compose Focus", "Owner FocusChanged(" + z6 + ')');
        z.b focusOwner = getFocusOwner();
        if (z6) {
            focusOwner.b();
        } else {
            focusOwner.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        throw null;
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                h(getRoot());
            }
            long e = e(i7);
            long e7 = e(i8);
            long a7 = t0.b.a((int) (e >>> 32), (int) (e & 4294967295L), (int) (e7 >>> 32), (int) (4294967295L & e7));
            t0.a aVar = this.m;
            boolean z6 = false;
            if (aVar != null) {
                if (aVar.f6001a == a7) {
                    z6 = true;
                }
                if (!z6) {
                    this.f1114n = true;
                }
            } else {
                this.m = new t0.a(a7);
                this.f1114n = false;
            }
            throw null;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i7) {
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i7) {
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z6) {
        throw null;
    }

    public final void p() {
        if (!this.f1117q) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis != this.f1116p) {
                this.f1116p = currentAnimationTimeMillis;
                throw null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(l0.o r7) {
        /*
            r6 = this;
            boolean r0 = r6.isLayoutRequested()
            if (r0 != 0) goto L_0x0079
            boolean r0 = r6.isAttachedToWindow()
            if (r0 == 0) goto L_0x0079
            if (r7 == 0) goto L_0x0065
        L_0x000e:
            if (r7 == 0) goto L_0x005b
            l0.s r0 = r7.f4872t
            l0.s$a r0 = r0.f4878b
            int r0 = r0.f4880i
            r1 = 1
            if (r0 != r1) goto L_0x005b
            boolean r0 = r6.f1114n
            r2 = 0
            if (r0 != 0) goto L_0x0054
            l0.o r0 = r7.c()
            if (r0 == 0) goto L_0x004f
            l0.v r0 = r0.s
            l0.h r0 = r0.f4883a
            long r3 = r0.f4571g
            int r0 = t0.a.b(r3)
            int r5 = t0.a.d(r3)
            if (r0 != r5) goto L_0x0036
            r0 = r1
            goto L_0x0037
        L_0x0036:
            r0 = r2
        L_0x0037:
            if (r0 == 0) goto L_0x004a
            int r0 = t0.a.a(r3)
            int r3 = t0.a.c(r3)
            if (r0 != r3) goto L_0x0045
            r0 = r1
            goto L_0x0046
        L_0x0045:
            r0 = r2
        L_0x0046:
            if (r0 == 0) goto L_0x004a
            r0 = r1
            goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            if (r0 != 0) goto L_0x004f
            r0 = r1
            goto L_0x0050
        L_0x004f:
            r0 = r2
        L_0x0050:
            if (r0 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r1 = r2
        L_0x0054:
            if (r1 == 0) goto L_0x005b
            l0.o r7 = r7.c()
            goto L_0x000e
        L_0x005b:
            l0.o r0 = r6.getRoot()
            if (r7 != r0) goto L_0x0065
            r6.requestLayout()
            return
        L_0x0065:
            int r7 = r6.getWidth()
            if (r7 == 0) goto L_0x0076
            int r7 = r6.getHeight()
            if (r7 != 0) goto L_0x0072
            goto L_0x0076
        L_0x0072:
            r6.invalidate()
            goto L_0x0079
        L_0x0076:
            r6.requestLayout()
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.q(l0.o):void");
    }

    public final int r(MotionEvent motionEvent) {
        if (this.f1122w) {
            this.f1122w = false;
            motionEvent.getMetaState();
            throw null;
        }
        throw null;
    }

    public final void s(MotionEvent motionEvent, int i7, long j7, boolean z6) {
        int i8;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i8 = motionEvent.getActionIndex();
            }
            i8 = -1;
        } else {
            if (!(i7 == 9 || i7 == 10)) {
                i8 = 0;
            }
            i8 = -1;
        }
        int pointerCount = motionEvent.getPointerCount() - (i8 >= 0 ? 1 : 0);
        if (pointerCount != 0) {
            MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
            for (int i9 = 0; i9 < pointerCount; i9++) {
                pointerPropertiesArr[i9] = new MotionEvent.PointerProperties();
            }
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
            for (int i10 = 0; i10 < pointerCount; i10++) {
                pointerCoordsArr[i10] = new MotionEvent.PointerCoords();
            }
            int i11 = 0;
            while (i11 < pointerCount) {
                int i12 = ((i8 < 0 || i11 < i8) ? 0 : 1) + i11;
                motionEvent.getPointerProperties(i12, pointerPropertiesArr[i11]);
                MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i11];
                motionEvent.getPointerCoords(i12, pointerCoords);
                long l6 = l(a0.b.a(pointerCoords.x, pointerCoords.y));
                pointerCoords.x = a0.a.b(l6);
                pointerCoords.y = a0.a.c(l6);
                i11++;
            }
            h.e(MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j7 : motionEvent.getDownTime(), j7, i7, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z6 ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()), "event");
            throw null;
        }
    }

    public final void setConfigurationChangeObserver(l<? super Configuration, f5.g> lVar) {
        h.f(lVar, "<set-?>");
        this.f1111j = lVar;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j7) {
        this.f1116p = j7;
    }

    public final void setOnViewTreeOwnersAvailable(l<? super b, f5.g> lVar) {
        h.f(lVar, "callback");
        b viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            lVar.k(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.s = lVar;
        }
    }

    public void setShowLayoutBounds(boolean z6) {
        this.f1112k = z6;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t() {
        getLocationOnScreen(null);
        t0.f.a(this.f1115o);
        throw null;
    }
}
