package x1;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.activity.h;
import java.util.Arrays;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: v */
    public static final a f6442v = new a();

    /* renamed from: a */
    public int f6443a;

    /* renamed from: b */
    public int f6444b;

    /* renamed from: d */
    public float[] f6446d;
    public float[] e;

    /* renamed from: f */
    public float[] f6447f;

    /* renamed from: g */
    public float[] f6448g;

    /* renamed from: h */
    public int[] f6449h;

    /* renamed from: i */
    public int[] f6450i;

    /* renamed from: j */
    public int[] f6451j;

    /* renamed from: k */
    public int f6452k;

    /* renamed from: l */
    public VelocityTracker f6453l;
    public float m;

    /* renamed from: n */
    public float f6454n;

    /* renamed from: o */
    public int f6455o;

    /* renamed from: p */
    public OverScroller f6456p;

    /* renamed from: q */
    public final AbstractC0134c f6457q;

    /* renamed from: r */
    public View f6458r;
    public boolean s;

    /* renamed from: t */
    public final ViewGroup f6459t;

    /* renamed from: c */
    public int f6445c = -1;

    /* renamed from: u */
    public final b f6460u = new b();

    /* loaded from: classes.dex */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f7) {
            float f8 = f7 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
            c.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.p(0);
        }
    }

    /* renamed from: x1.c$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0134c {
        public abstract int a(View view, int i7);

        public abstract int b(View view, int i7);

        public int c(View view) {
            return 0;
        }

        public int d() {
            return 0;
        }

        public void e(View view, int i7) {
        }

        public abstract void f(int i7);

        public abstract void g(View view, int i7, int i8);

        public abstract void h(View view, float f7, float f8);

        public abstract boolean i(View view, int i7);
    }

    public c(Context context, ViewGroup viewGroup, AbstractC0134c abstractC0134c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0134c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f6459t = viewGroup;
        this.f6457q = abstractC0134c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6455o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f6444b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f6454n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6456p = new OverScroller(context, f6442v);
    }

    public final void a() {
        this.f6445c = -1;
        float[] fArr = this.f6446d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f6447f, 0.0f);
            Arrays.fill(this.f6448g, 0.0f);
            Arrays.fill(this.f6449h, 0);
            Arrays.fill(this.f6450i, 0);
            Arrays.fill(this.f6451j, 0);
            this.f6452k = 0;
        }
        VelocityTracker velocityTracker = this.f6453l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6453l = null;
        }
    }

    public final void b(View view, int i7) {
        if (view.getParent() != this.f6459t) {
            StringBuilder d7 = h.d("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
            d7.append(this.f6459t);
            d7.append(")");
            throw new IllegalArgumentException(d7.toString());
        }
        this.f6458r = view;
        this.f6445c = i7;
        this.f6457q.e(view, i7);
        p(1);
    }

    public final boolean c(float f7, float f8, int i7, int i8) {
        float abs = Math.abs(f7);
        float abs2 = Math.abs(f8);
        if ((this.f6449h[i7] & i8) != i8 || (0 & i8) == 0 || (this.f6451j[i7] & i8) == i8 || (this.f6450i[i7] & i8) == i8) {
            return false;
        }
        int i9 = this.f6444b;
        if (abs > i9 || abs2 > i9) {
            if (abs < abs2 * 0.5f) {
                this.f6457q.getClass();
            }
            return (this.f6450i[i7] & i8) == 0 && abs > ((float) this.f6444b);
        }
        return false;
    }

    public final boolean d(View view, float f7, float f8) {
        if (view == null) {
            return false;
        }
        boolean z6 = this.f6457q.c(view) > 0;
        boolean z7 = this.f6457q.d() > 0;
        if (!z6 || !z7) {
            return z6 ? Math.abs(f7) > ((float) this.f6444b) : z7 && Math.abs(f8) > ((float) this.f6444b);
        }
        float f9 = f8 * f8;
        int i7 = this.f6444b;
        return f9 + (f7 * f7) > ((float) (i7 * i7));
    }

    public final void e(int i7) {
        float[] fArr = this.f6446d;
        if (fArr != null) {
            int i8 = this.f6452k;
            int i9 = 1 << i7;
            if ((i8 & i9) != 0) {
                fArr[i7] = 0.0f;
                this.e[i7] = 0.0f;
                this.f6447f[i7] = 0.0f;
                this.f6448g[i7] = 0.0f;
                this.f6449h[i7] = 0;
                this.f6450i[i7] = 0;
                this.f6451j[i7] = 0;
                this.f6452k = (~i9) & i8;
            }
        }
    }

    public final int f(int i7, int i8, int i9) {
        int width;
        if (i7 == 0) {
            return 0;
        }
        float width2 = this.f6459t.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i7) / width) - 0.5f) * 0.47123894f)) * width2) + width2;
        int abs = Math.abs(i8);
        return Math.min(abs > 0 ? Math.round(Math.abs(sin / abs) * 1000.0f) * 4 : (int) (((Math.abs(i7) / i9) + 1.0f) * 256.0f), 600);
    }

    public final boolean g() {
        if (this.f6443a == 2) {
            boolean computeScrollOffset = this.f6456p.computeScrollOffset();
            int currX = this.f6456p.getCurrX();
            int currY = this.f6456p.getCurrY();
            int left = currX - this.f6458r.getLeft();
            int top = currY - this.f6458r.getTop();
            if (left != 0) {
                View view = this.f6458r;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f6458r;
                WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f6457q.g(this.f6458r, currX, currY);
            }
            if (computeScrollOffset && currX == this.f6456p.getFinalX() && currY == this.f6456p.getFinalY()) {
                this.f6456p.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f6459t.post(this.f6460u);
            }
        }
        return this.f6443a == 2;
    }

    public final View h(int i7, int i8) {
        for (int childCount = this.f6459t.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.f6459t;
            this.f6457q.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && i8 >= childAt.getTop() && i8 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            android.view.View r0 = r9.f6458r
            int r2 = r0.getLeft()
            android.view.View r0 = r9.f6458r
            int r3 = r0.getTop()
            int r4 = r10 - r2
            int r5 = r11 - r3
            r10 = 0
            if (r4 != 0) goto L1e
            if (r5 != 0) goto L1e
            android.widget.OverScroller r11 = r9.f6456p
            r11.abortAnimation()
            r9.p(r10)
            return r10
        L1e:
            android.view.View r11 = r9.f6458r
            float r0 = r9.f6454n
            int r0 = (int) r0
            float r1 = r9.m
            int r1 = (int) r1
            int r6 = java.lang.Math.abs(r12)
            if (r6 >= r0) goto L2e
            r12 = r10
            goto L35
        L2e:
            if (r6 <= r1) goto L35
            if (r12 <= 0) goto L34
            r12 = r1
            goto L35
        L34:
            int r12 = -r1
        L35:
            float r0 = r9.f6454n
            int r0 = (int) r0
            float r1 = r9.m
            int r1 = (int) r1
            int r6 = java.lang.Math.abs(r13)
            if (r6 >= r0) goto L42
            goto L49
        L42:
            if (r6 <= r1) goto L4a
            if (r13 <= 0) goto L48
            r13 = r1
            goto L4a
        L48:
            int r10 = -r1
        L49:
            r13 = r10
        L4a:
            int r10 = java.lang.Math.abs(r4)
            int r0 = java.lang.Math.abs(r5)
            int r1 = java.lang.Math.abs(r12)
            int r6 = java.lang.Math.abs(r13)
            int r7 = r1 + r6
            int r8 = r10 + r0
            if (r12 == 0) goto L63
            float r10 = (float) r1
            float r1 = (float) r7
            goto L65
        L63:
            float r10 = (float) r10
            float r1 = (float) r8
        L65:
            float r10 = r10 / r1
            if (r13 == 0) goto L6b
            float r0 = (float) r6
            float r1 = (float) r7
            goto L6d
        L6b:
            float r0 = (float) r0
            float r1 = (float) r8
        L6d:
            float r0 = r0 / r1
            x1.c$c r1 = r9.f6457q
            int r11 = r1.c(r11)
            int r11 = r9.f(r4, r12, r11)
            x1.c$c r12 = r9.f6457q
            int r12 = r12.d()
            int r12 = r9.f(r5, r13, r12)
            float r11 = (float) r11
            float r11 = r11 * r10
            float r10 = (float) r12
            float r10 = r10 * r0
            float r10 = r10 + r11
            int r6 = (int) r10
            android.widget.OverScroller r1 = r9.f6456p
            r1.startScroll(r2, r3, r4, r5, r6)
            r10 = 2
            r9.p(r10)
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.c.i(int, int, int, int):boolean");
    }

    public final boolean j(int i7) {
        if ((this.f6452k & (1 << i7)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i7 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void k(MotionEvent motionEvent) {
        int i7;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f6453l == null) {
            this.f6453l = VelocityTracker.obtain();
        }
        this.f6453l.addMovement(motionEvent);
        int i8 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f6443a != 1) {
                        int pointerCount = motionEvent.getPointerCount();
                        while (i8 < pointerCount) {
                            int pointerId = motionEvent.getPointerId(i8);
                            if (j(pointerId)) {
                                float x6 = motionEvent.getX(i8);
                                float y6 = motionEvent.getY(i8);
                                float f7 = x6 - this.f6446d[pointerId];
                                float f8 = y6 - this.e[pointerId];
                                m(f7, f8, pointerId);
                                if (this.f6443a != 1) {
                                    View h7 = h((int) x6, (int) y6);
                                    if (d(h7, f7, f8) && s(h7, pointerId)) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            i8++;
                        }
                    } else if (!j(this.f6445c)) {
                        return;
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f6445c);
                        float x7 = motionEvent.getX(findPointerIndex);
                        float y7 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f6447f;
                        int i9 = this.f6445c;
                        int i10 = (int) (x7 - fArr[i9]);
                        int i11 = (int) (y7 - this.f6448g[i9]);
                        int left = this.f6458r.getLeft() + i10;
                        int top = this.f6458r.getTop() + i11;
                        int left2 = this.f6458r.getLeft();
                        int top2 = this.f6458r.getTop();
                        if (i10 != 0) {
                            left = this.f6457q.a(this.f6458r, left);
                            WeakHashMap<View, k0> weakHashMap = y.f5540a;
                            this.f6458r.offsetLeftAndRight(left - left2);
                        }
                        if (i11 != 0) {
                            top = this.f6457q.b(this.f6458r, top);
                            WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                            this.f6458r.offsetTopAndBottom(top - top2);
                        }
                        if (i10 != 0 || i11 != 0) {
                            this.f6457q.g(this.f6458r, left, top);
                        }
                    }
                    o(motionEvent);
                    return;
                } else if (actionMasked != 3) {
                    if (actionMasked != 5) {
                        if (actionMasked != 6) {
                            return;
                        }
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        if (this.f6443a == 1 && pointerId2 == this.f6445c) {
                            int pointerCount2 = motionEvent.getPointerCount();
                            while (true) {
                                if (i8 >= pointerCount2) {
                                    i7 = -1;
                                    break;
                                }
                                int pointerId3 = motionEvent.getPointerId(i8);
                                if (pointerId3 != this.f6445c) {
                                    View h8 = h((int) motionEvent.getX(i8), (int) motionEvent.getY(i8));
                                    View view = this.f6458r;
                                    if (h8 == view && s(view, pointerId3)) {
                                        i7 = this.f6445c;
                                        break;
                                    }
                                }
                                i8++;
                            }
                            if (i7 == -1) {
                                l();
                            }
                        }
                        e(pointerId2);
                        return;
                    }
                    int pointerId4 = motionEvent.getPointerId(actionIndex);
                    float x8 = motionEvent.getX(actionIndex);
                    float y8 = motionEvent.getY(actionIndex);
                    n(x8, y8, pointerId4);
                    if (this.f6443a != 0) {
                        int i12 = (int) x8;
                        int i13 = (int) y8;
                        View view2 = this.f6458r;
                        if (view2 != null && i12 >= view2.getLeft() && i12 < view2.getRight() && i13 >= view2.getTop() && i13 < view2.getBottom()) {
                            i8 = 1;
                        }
                        if (i8 != 0) {
                            s(this.f6458r, pointerId4);
                            return;
                        }
                        return;
                    }
                    s(h((int) x8, (int) y8), pointerId4);
                    if ((this.f6449h[pointerId4] & 0) == 0) {
                        return;
                    }
                } else if (this.f6443a == 1) {
                    this.s = true;
                    this.f6457q.h(this.f6458r, 0.0f, 0.0f);
                    this.s = false;
                    if (this.f6443a == 1) {
                        p(0);
                    }
                }
            } else if (this.f6443a == 1) {
                l();
            }
            a();
            return;
        }
        float x9 = motionEvent.getX();
        float y9 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View h9 = h((int) x9, (int) y9);
        n(x9, y9, pointerId5);
        s(h9, pointerId5);
        if ((this.f6449h[pointerId5] & 0) == 0) {
            return;
        }
        this.f6457q.getClass();
    }

    public final void l() {
        this.f6453l.computeCurrentVelocity(1000, this.m);
        float xVelocity = this.f6453l.getXVelocity(this.f6445c);
        float f7 = this.f6454n;
        float f8 = this.m;
        float abs = Math.abs(xVelocity);
        float f9 = 0.0f;
        if (abs < f7) {
            xVelocity = 0.0f;
        } else if (abs > f8) {
            xVelocity = xVelocity > 0.0f ? f8 : -f8;
        }
        float yVelocity = this.f6453l.getYVelocity(this.f6445c);
        float f10 = this.f6454n;
        float f11 = this.m;
        float abs2 = Math.abs(yVelocity);
        if (abs2 >= f10) {
            if (abs2 > f11) {
                if (yVelocity > 0.0f) {
                    f9 = f11;
                } else {
                    yVelocity = -f11;
                }
            }
            f9 = yVelocity;
        }
        this.s = true;
        this.f6457q.h(this.f6458r, xVelocity, f9);
        this.s = false;
        if (this.f6443a == 1) {
            p(0);
        }
    }

    public final void m(float f7, float f8, int i7) {
        boolean c7 = c(f7, f8, i7, 1);
        if (c(f8, f7, i7, 4)) {
            c7 |= true;
        }
        if (c(f7, f8, i7, 2)) {
            c7 |= true;
        }
        if (c(f8, f7, i7, 8)) {
            c7 |= true;
        }
        if (c7) {
            int[] iArr = this.f6450i;
            iArr[i7] = iArr[i7] | c7;
            this.f6457q.getClass();
        }
    }

    public final void n(float f7, float f8, int i7) {
        float[] fArr = this.f6446d;
        if (fArr == null || fArr.length <= i7) {
            int i8 = i7 + 1;
            float[] fArr2 = new float[i8];
            float[] fArr3 = new float[i8];
            float[] fArr4 = new float[i8];
            float[] fArr5 = new float[i8];
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            int[] iArr3 = new int[i8];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f6447f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f6448g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f6449h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f6450i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f6451j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f6446d = fArr2;
            this.e = fArr3;
            this.f6447f = fArr4;
            this.f6448g = fArr5;
            this.f6449h = iArr;
            this.f6450i = iArr2;
            this.f6451j = iArr3;
        }
        float[] fArr9 = this.f6446d;
        this.f6447f[i7] = f7;
        fArr9[i7] = f7;
        float[] fArr10 = this.e;
        this.f6448g[i7] = f8;
        fArr10[i7] = f8;
        int[] iArr7 = this.f6449h;
        int i9 = (int) f7;
        int i10 = (int) f8;
        int i11 = i9 < this.f6459t.getLeft() + this.f6455o ? 1 : 0;
        if (i10 < this.f6459t.getTop() + this.f6455o) {
            i11 |= 4;
        }
        if (i9 > this.f6459t.getRight() - this.f6455o) {
            i11 |= 2;
        }
        if (i10 > this.f6459t.getBottom() - this.f6455o) {
            i11 |= 8;
        }
        iArr7[i7] = i11;
        this.f6452k |= 1 << i7;
    }

    public final void o(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i7 = 0; i7 < pointerCount; i7++) {
            int pointerId = motionEvent.getPointerId(i7);
            if (j(pointerId)) {
                float x6 = motionEvent.getX(i7);
                float y6 = motionEvent.getY(i7);
                this.f6447f[pointerId] = x6;
                this.f6448g[pointerId] = y6;
            }
        }
    }

    public final void p(int i7) {
        this.f6459t.removeCallbacks(this.f6460u);
        if (this.f6443a != i7) {
            this.f6443a = i7;
            this.f6457q.f(i7);
            if (this.f6443a == 0) {
                this.f6458r = null;
            }
        }
    }

    public final boolean q(int i7, int i8) {
        if (this.s) {
            return i(i7, i8, (int) this.f6453l.getXVelocity(this.f6445c), (int) this.f6453l.getYVelocity(this.f6445c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:223:0x00db, code lost:
        if (r12 != r11) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean r(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.c.r(android.view.MotionEvent):boolean");
    }

    public final boolean s(View view, int i7) {
        if (view == this.f6458r && this.f6445c == i7) {
            return true;
        }
        if (view == null || !this.f6457q.i(view, i7)) {
            return false;
        }
        this.f6445c = i7;
        b(view, i7);
        return true;
    }
}
