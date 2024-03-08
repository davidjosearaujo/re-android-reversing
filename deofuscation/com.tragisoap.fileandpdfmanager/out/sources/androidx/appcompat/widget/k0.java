package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import j.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class k0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: f  reason: collision with root package name */
    public final float f953f;

    /* renamed from: g  reason: collision with root package name */
    public final int f954g;

    /* renamed from: h  reason: collision with root package name */
    public final int f955h;

    /* renamed from: i  reason: collision with root package name */
    public final View f956i;

    /* renamed from: j  reason: collision with root package name */
    public a f957j;

    /* renamed from: k  reason: collision with root package name */
    public b f958k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f959l;
    public int m;

    /* renamed from: n  reason: collision with root package name */
    public final int[] f960n = new int[2];

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewParent parent = k0.this.f956i.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k0 k0Var = k0.this;
            k0Var.a();
            View view = k0Var.f956i;
            if (view.isEnabled() && !view.isLongClickable() && k0Var.c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                k0Var.f959l = true;
            }
        }
    }

    public k0(View view) {
        this.f956i = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f953f = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f954g = tapTimeout;
        this.f955h = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        b bVar = this.f958k;
        if (bVar != null) {
            this.f956i.removeCallbacks(bVar);
        }
        a aVar = this.f957j;
        if (aVar != null) {
            this.f956i.removeCallbacks(aVar);
        }
    }

    public abstract f b();

    public abstract boolean c();

    public boolean d() {
        f b2 = b();
        if (b2 == null || !b2.b()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 3) goto L_0x0102;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0110  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f959l = false;
        this.m = -1;
        a aVar = this.f957j;
        if (aVar != null) {
            this.f956i.removeCallbacks(aVar);
        }
    }
}
