package androidx.compose.ui.platform;

import Graphics_1.CanvasOperations;
import Graphics_1.NotImplemented;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class d0 extends View implements l0.b0 {

    /* renamed from: h */
    public static Method f1140h;

    /* renamed from: i */
    public static Field f1141i;

    /* renamed from: j */
    public static boolean f1142j;

    /* renamed from: k */
    public static boolean f1143k;

    /* renamed from: f */
    public boolean f1144f;

    /* renamed from: g */
    public boolean f1145g;

    /* loaded from: classes.dex */
    public static final class a extends ViewOutlineProvider {
        public final void getOutline(View view, Outline outline) {
            r5.h.f(view, "view");
            r5.h.f(outline, "outline");
            ((d0) view).getClass();
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        @SuppressLint({"BanUncheckedReflection"})
        public static void a(View view) {
            r5.h.f(view, "view");
            try {
                if (!d0.f1142j) {
                    d0.f1142j = true;
                    d0.f1140h = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                    d0.f1141i = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    Method method = d0.f1140h;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = d0.f1141i;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = d0.f1141i;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = d0.f1140h;
                if (method2 != null) {
                    method2.invoke(view, new Object[0]);
                }
            } catch (Throwable unused) {
                d0.f1143k = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static final long a(View view) {
            r5.h.f(view, "view");
            return view.getUniqueDrawingId();
        }
    }

    static {
        new a();
    }

    private final NotImplemented getManualClipPath() {
        if (getClipToOutline()) {
            throw null;
        }
        return null;
    }

    private final void setInvalidated(boolean z6) {
        if (z6 == this.f1144f) {
            return;
        }
        this.f1144f = z6;
        throw null;
    }

    public final long a(long j5, boolean z6) {
        if (z6) {
            throw null;
        }
        throw null;
    }

    public final void b(CanvasOperations canvasOperations) {
        r5.h.f(canvasOperations, "canvas");
        boolean z6 = getElevation() > 0.0f;
        this.f1145g = z6;
        if (z6) {
            canvasOperations.g();
        }
        getDrawingTime();
        throw null;
    }

    public final void c() {
        if (!this.f1144f || f1143k) {
            return;
        }
        setInvalidated(false);
        b.a(this);
    }

    public final boolean d(long j5) {
        a0.a.b(j5);
        a0.a.c(j5);
        if (getClipToOutline()) {
            throw null;
        }
        return true;
    }

    public final void dispatchDraw(Canvas canvas) {
        r5.h.f(canvas, "canvas");
        setInvalidated(false);
        throw null;
    }

    public final void forceLayout() {
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    public final u getContainer() {
        return null;
    }

    public long getLayerId() {
        return 0L;
    }

    public final AndroidComposeView getOwnerView() {
        return null;
    }

    public long getOwnerViewId() {
        return c.a(null);
    }

    public final boolean hasOverlappingRendering() {
        return false;
    }

    public final void invalidate() {
        if (this.f1144f) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        throw null;
    }

    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
    }

    public final void setCameraDistancePx(float f7) {
        setCameraDistance(f7 * getResources().getDisplayMetrics().densityDpi);
    }
}
