package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j extends RecyclerView.k implements RecyclerView.o {
    public static final int[] C = {16842919};
    public static final int[] D = new int[0];
    public final a B;

    /* renamed from: a  reason: collision with root package name */
    public final int f2211a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2212b;

    /* renamed from: c  reason: collision with root package name */
    public final StateListDrawable f2213c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f2214d;
    public final int e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2215f;

    /* renamed from: g  reason: collision with root package name */
    public final StateListDrawable f2216g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f2217h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2218i;

    /* renamed from: j  reason: collision with root package name */
    public final int f2219j;

    /* renamed from: k  reason: collision with root package name */
    public int f2220k;

    /* renamed from: l  reason: collision with root package name */
    public int f2221l;
    public float m;

    /* renamed from: n  reason: collision with root package name */
    public int f2222n;

    /* renamed from: o  reason: collision with root package name */
    public int f2223o;

    /* renamed from: p  reason: collision with root package name */
    public float f2224p;
    public RecyclerView s;

    /* renamed from: z  reason: collision with root package name */
    public final ValueAnimator f2233z;

    /* renamed from: q  reason: collision with root package name */
    public int f2225q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f2226r = 0;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2227t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2228u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f2229v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f2230w = 0;

    /* renamed from: x  reason: collision with root package name */
    public final int[] f2231x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    public final int[] f2232y = new int[2];
    public int A = 0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            j jVar = j.this;
            int i7 = jVar.A;
            if (i7 == 1) {
                jVar.f2233z.cancel();
            } else if (i7 != 2) {
                return;
            }
            jVar.A = 3;
            ValueAnimator valueAnimator = jVar.f2233z;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            jVar.f2233z.setDuration((long) 500);
            jVar.f2233z.start();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends RecyclerView.p {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public final void b(RecyclerView recyclerView, int i7, int i8) {
            j jVar = j.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = jVar.s.computeVerticalScrollRange();
            int i9 = jVar.f2226r;
            jVar.f2227t = computeVerticalScrollRange - i9 > 0 && i9 >= jVar.f2211a;
            int computeHorizontalScrollRange = jVar.s.computeHorizontalScrollRange();
            int i10 = jVar.f2225q;
            boolean z6 = computeHorizontalScrollRange - i10 > 0 && i10 >= jVar.f2211a;
            jVar.f2228u = z6;
            boolean z7 = jVar.f2227t;
            if (z7 || z6) {
                if (z7) {
                    float f7 = (float) i9;
                    jVar.f2221l = (int) ((((f7 / 2.0f) + ((float) computeVerticalScrollOffset)) * f7) / ((float) computeVerticalScrollRange));
                    jVar.f2220k = Math.min(i9, (i9 * i9) / computeVerticalScrollRange);
                }
                if (jVar.f2228u) {
                    float f8 = (float) computeHorizontalScrollOffset;
                    float f9 = (float) i10;
                    jVar.f2223o = (int) ((((f9 / 2.0f) + f8) * f9) / ((float) computeHorizontalScrollRange));
                    jVar.f2222n = Math.min(i10, (i10 * i10) / computeHorizontalScrollRange);
                }
                int i11 = jVar.f2229v;
                if (i11 == 0 || i11 == 1) {
                    jVar.j(1);
                }
            } else if (jVar.f2229v != 0) {
                jVar.j(0);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2236a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f2236a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.f2236a) {
                this.f2236a = false;
                return;
            }
            int i7 = (((Float) j.this.f2233z.getAnimatedValue()).floatValue() > 0.0f ? 1 : (((Float) j.this.f2233z.getAnimatedValue()).floatValue() == 0.0f ? 0 : -1));
            j jVar = j.this;
            if (i7 == 0) {
                jVar.A = 0;
                jVar.j(0);
                return;
            }
            jVar.A = 2;
            jVar.s.invalidate();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            j.this.f2213c.setAlpha(floatValue);
            j.this.f2214d.setAlpha(floatValue);
            j.this.s.invalidate();
        }
    }

    public j(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i7, int i8, int i9) {
        boolean z6 = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2233z = ofFloat;
        a aVar = new a();
        this.B = aVar;
        b bVar = new b();
        this.f2213c = stateListDrawable;
        this.f2214d = drawable;
        this.f2216g = stateListDrawable2;
        this.f2217h = drawable2;
        this.e = Math.max(i7, stateListDrawable.getIntrinsicWidth());
        this.f2215f = Math.max(i7, drawable.getIntrinsicWidth());
        this.f2218i = Math.max(i7, stateListDrawable2.getIntrinsicWidth());
        this.f2219j = Math.max(i7, drawable2.getIntrinsicWidth());
        this.f2211a = i8;
        this.f2212b = i9;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                RecyclerView.l lVar = recyclerView2.f1986r;
                if (lVar != null) {
                    lVar.c("Cannot remove item decoration during a scroll  or layout");
                }
                recyclerView2.f1991u.remove(this);
                if (recyclerView2.f1991u.isEmpty()) {
                    recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2 ? true : z6);
                }
                recyclerView2.Q();
                recyclerView2.requestLayout();
                RecyclerView recyclerView3 = this.s;
                recyclerView3.f1993v.remove(this);
                if (recyclerView3.f1995w == this) {
                    recyclerView3.f1995w = null;
                }
                ArrayList arrayList = this.s.f1977m0;
                if (arrayList != null) {
                    arrayList.remove(bVar);
                }
                this.s.removeCallbacks(aVar);
            }
            this.s = recyclerView;
            if (recyclerView != null) {
                recyclerView.i(this);
                this.s.f1993v.add(this);
                this.s.j(bVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
        if (r8 >= 0) goto L_0x00bd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0114, code lost:
        if (r5 >= 0) goto L_0x0116;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.j.a(android.view.MotionEvent):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean b(MotionEvent motionEvent) {
        int i7 = this.f2229v;
        if (i7 == 1) {
            boolean h7 = h(motionEvent.getX(), motionEvent.getY());
            boolean g2 = g(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (h7 || g2)) {
                if (g2) {
                    this.f2230w = 1;
                    this.f2224p = (float) ((int) motionEvent.getX());
                } else if (h7) {
                    this.f2230w = 2;
                    this.m = (float) ((int) motionEvent.getY());
                }
                j(2);
                return true;
            }
        } else if (i7 == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void c() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public final void f(Canvas canvas, RecyclerView recyclerView) {
        if (this.f2225q != this.s.getWidth() || this.f2226r != this.s.getHeight()) {
            this.f2225q = this.s.getWidth();
            this.f2226r = this.s.getHeight();
            j(0);
        } else if (this.A != 0) {
            if (this.f2227t) {
                int i7 = this.f2225q;
                int i8 = this.e;
                int i9 = i7 - i8;
                int i10 = this.f2221l;
                int i11 = this.f2220k;
                int i12 = i10 - (i11 / 2);
                this.f2213c.setBounds(0, 0, i8, i11);
                this.f2214d.setBounds(0, 0, this.f2215f, this.f2226r);
                RecyclerView recyclerView2 = this.s;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                boolean z6 = true;
                if (y.e.d(recyclerView2) != 1) {
                    z6 = false;
                }
                if (z6) {
                    this.f2214d.draw(canvas);
                    canvas.translate((float) this.e, (float) i12);
                    canvas.scale(-1.0f, 1.0f);
                    this.f2213c.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    i9 = this.e;
                } else {
                    canvas.translate((float) i9, 0.0f);
                    this.f2214d.draw(canvas);
                    canvas.translate(0.0f, (float) i12);
                    this.f2213c.draw(canvas);
                }
                canvas.translate((float) (-i9), (float) (-i12));
            }
            if (this.f2228u) {
                int i13 = this.f2226r;
                int i14 = this.f2218i;
                int i15 = i13 - i14;
                int i16 = this.f2223o;
                int i17 = this.f2222n;
                int i18 = i16 - (i17 / 2);
                this.f2216g.setBounds(0, 0, i17, i14);
                this.f2217h.setBounds(0, 0, this.f2225q, this.f2219j);
                canvas.translate(0.0f, (float) i15);
                this.f2217h.draw(canvas);
                canvas.translate((float) i18, 0.0f);
                this.f2216g.draw(canvas);
                canvas.translate((float) (-i18), (float) (-i15));
            }
        }
    }

    public final boolean g(float f7, float f8) {
        if (f8 >= ((float) (this.f2226r - this.f2218i))) {
            int i7 = this.f2223o;
            int i8 = this.f2222n;
            if (f7 >= ((float) (i7 - (i8 / 2))) && f7 <= ((float) ((i8 / 2) + i7))) {
                return true;
            }
        }
        return false;
    }

    public final boolean h(float f7, float f8) {
        RecyclerView recyclerView = this.s;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.e.d(recyclerView) == 1) {
            if (f7 > ((float) this.e)) {
                return false;
            }
        } else if (f7 < ((float) (this.f2225q - this.e))) {
            return false;
        }
        int i7 = this.f2221l;
        int i8 = this.f2220k / 2;
        return f8 >= ((float) (i7 - i8)) && f8 <= ((float) (i8 + i7));
    }

    public final void i(int i7) {
        this.s.removeCallbacks(this.B);
        this.s.postDelayed(this.B, (long) i7);
    }

    public final void j(int i7) {
        int i8;
        if (i7 == 2 && this.f2229v != 2) {
            this.f2213c.setState(C);
            this.s.removeCallbacks(this.B);
        }
        if (i7 == 0) {
            this.s.invalidate();
        } else {
            k();
        }
        if (this.f2229v != 2 || i7 == 2) {
            if (i7 == 1) {
                i8 = 1500;
            }
            this.f2229v = i7;
        }
        this.f2213c.setState(D);
        i8 = 1200;
        i(i8);
        this.f2229v = i7;
    }

    public final void k() {
        int i7 = this.A;
        if (i7 != 0) {
            if (i7 == 3) {
                this.f2233z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f2233z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f2233z.setDuration(500L);
        this.f2233z.setStartDelay(0);
        this.f2233z.start();
    }
}
