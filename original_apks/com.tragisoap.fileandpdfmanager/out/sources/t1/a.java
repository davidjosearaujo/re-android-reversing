package t1;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: v */
    public static final int f6012v = ViewConfiguration.getTapTimeout();

    /* renamed from: f */
    public final C0105a f6013f;

    /* renamed from: h */
    public final View f6015h;

    /* renamed from: i */
    public b f6016i;

    /* renamed from: q */
    public boolean f6023q;

    /* renamed from: r */
    public boolean f6024r;
    public boolean s;

    /* renamed from: t */
    public boolean f6025t;

    /* renamed from: u */
    public boolean f6026u;

    /* renamed from: g */
    public final AccelerateInterpolator f6014g = new AccelerateInterpolator();

    /* renamed from: j */
    public float[] f6017j = {0.0f, 0.0f};

    /* renamed from: k */
    public float[] f6018k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: n */
    public float[] f6020n = {0.0f, 0.0f};

    /* renamed from: o */
    public float[] f6021o = {0.0f, 0.0f};

    /* renamed from: p */
    public float[] f6022p = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: l */
    public int f6019l = 1;
    public int m = f6012v;

    /* renamed from: t1.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0105a {

        /* renamed from: a */
        public int f6027a;

        /* renamed from: b */
        public int f6028b;

        /* renamed from: c */
        public float f6029c;

        /* renamed from: d */
        public float f6030d;

        /* renamed from: h */
        public float f6033h;

        /* renamed from: i */
        public int f6034i;
        public long e = Long.MIN_VALUE;

        /* renamed from: g */
        public long f6032g = -1;

        /* renamed from: f */
        public long f6031f = 0;

        public final float a(long j7) {
            long j8 = this.e;
            if (j7 < j8) {
                return 0.0f;
            }
            long j9 = this.f6032g;
            if (j9 < 0 || j7 < j9) {
                return a.b(((float) (j7 - j8)) / ((float) this.f6027a), 0.0f, 1.0f) * 0.5f;
            }
            float f7 = this.f6033h;
            return (a.b(((float) (j7 - j9)) / ((float) this.f6034i), 0.0f, 1.0f) * f7) + (1.0f - f7);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Runnable {
        public b() {
            a.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            if (aVar.f6025t) {
                if (aVar.f6024r) {
                    aVar.f6024r = false;
                    C0105a aVar2 = aVar.f6013f;
                    aVar2.getClass();
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    aVar2.e = currentAnimationTimeMillis;
                    aVar2.f6032g = -1;
                    aVar2.f6031f = currentAnimationTimeMillis;
                    aVar2.f6033h = 0.5f;
                }
                C0105a aVar3 = a.this.f6013f;
                if ((aVar3.f6032g > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar3.f6032g + ((long) aVar3.f6034i)) || !a.this.e()) {
                    a.this.f6025t = false;
                    return;
                }
                a aVar4 = a.this;
                if (aVar4.s) {
                    aVar4.s = false;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar4.f6015h.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar3.f6031f != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a7 = aVar3.a(currentAnimationTimeMillis2);
                    aVar3.f6031f = currentAnimationTimeMillis2;
                    g.b(((f) a.this).f6036w, (int) (((float) (currentAnimationTimeMillis2 - aVar3.f6031f)) * ((a7 * 4.0f) + (-4.0f * a7 * a7)) * aVar3.f6030d));
                    View view = a.this.f6015h;
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    y.d.m(view, this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public a(View view) {
        C0105a aVar = new C0105a();
        this.f6013f = aVar;
        this.f6015h = view;
        float f7 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.f6022p;
        float f8 = ((float) ((int) ((1575.0f * f7) + 0.5f))) / 1000.0f;
        fArr[0] = f8;
        fArr[1] = f8;
        float[] fArr2 = this.f6021o;
        float f9 = ((float) ((int) ((f7 * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f9;
        fArr2[1] = f9;
        float[] fArr3 = this.f6018k;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f6017j;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.f6020n;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        aVar.f6027a = 500;
        aVar.f6028b = 500;
    }

    public static float b(float f7, float f8, float f9) {
        return f7 > f9 ? f9 : f7 < f8 ? f8 : f7;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f6017j
            r0 = r0[r7]
            float[] r1 = r3.f6018k
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x0025
            android.view.animation.AccelerateInterpolator r5 = r3.f6014g
            float r4 = -r4
            float r4 = r5.getInterpolation(r4)
            float r4 = -r4
            goto L_0x002f
        L_0x0025:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0038
            android.view.animation.AccelerateInterpolator r5 = r3.f6014g
            float r4 = r5.getInterpolation(r4)
        L_0x002f:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L_0x0039
        L_0x0038:
            r4 = r2
        L_0x0039:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x003e
            return r2
        L_0x003e:
            float[] r0 = r3.f6020n
            r0 = r0[r7]
            float[] r1 = r3.f6021o
            r1 = r1[r7]
            float[] r3 = r3.f6022p
            r3 = r3[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L_0x0053
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            return r3
        L_0x0053:
            float r4 = -r4
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            float r3 = -r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.a.a(float, float, float, int):float");
    }

    public final float c(float f7, float f8) {
        if (f8 == 0.0f) {
            return 0.0f;
        }
        int i7 = this.f6019l;
        if (i7 == 0 || i7 == 1) {
            if (f7 < f8) {
                if (f7 >= 0.0f) {
                    return 1.0f - (f7 / f8);
                }
                if (this.f6025t && i7 == 1) {
                    return 1.0f;
                }
            }
        } else if (i7 == 2 && f7 < 0.0f) {
            return f7 / (-f8);
        }
        return 0.0f;
    }

    public final void d() {
        int i7 = 0;
        if (this.f6024r) {
            this.f6025t = false;
            return;
        }
        C0105a aVar = this.f6013f;
        aVar.getClass();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i8 = (int) (currentAnimationTimeMillis - aVar.e);
        int i9 = aVar.f6028b;
        if (i8 > i9) {
            i7 = i9;
        } else if (i8 >= 0) {
            i7 = i8;
        }
        aVar.f6034i = i7;
        aVar.f6033h = aVar.a(currentAnimationTimeMillis);
        aVar.f6032g = currentAnimationTimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e() {
        /*
            r8 = this;
            t1.a$a r0 = r8.f6013f
            float r1 = r0.f6030d
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.f6029c
            float r2 = java.lang.Math.abs(r0)
            float r0 = r0 / r2
            int r0 = (int) r0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0052
            t1.f r8 = (t1.f) r8
            android.widget.ListView r8 = r8.f6036w
            int r4 = r8.getCount()
            if (r4 != 0) goto L_0x0022
        L_0x0020:
            r8 = r3
            goto L_0x0050
        L_0x0022:
            int r5 = r8.getChildCount()
            int r6 = r8.getFirstVisiblePosition()
            int r7 = r6 + r5
            if (r1 <= 0) goto L_0x0040
            if (r7 < r4) goto L_0x004f
            int r5 = r5 - r2
            android.view.View r1 = r8.getChildAt(r5)
            int r1 = r1.getBottom()
            int r8 = r8.getHeight()
            if (r1 > r8) goto L_0x004f
            goto L_0x0020
        L_0x0040:
            if (r1 >= 0) goto L_0x0020
            if (r6 > 0) goto L_0x004f
            android.view.View r8 = r8.getChildAt(r3)
            int r8 = r8.getTop()
            if (r8 < 0) goto L_0x004f
            goto L_0x0020
        L_0x004f:
            r8 = r2
        L_0x0050:
            if (r8 != 0) goto L_0x0053
        L_0x0052:
            r2 = r3
        L_0x0053:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.a.e():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L_0x007f;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f6026u
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x007f
        L_0x0016:
            r5.d()
            goto L_0x007f
        L_0x001a:
            r5.s = r2
            r5.f6023q = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f6015h
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r0, r3, r4, r1)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f6015h
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r7, r6, r3, r2)
            t1.a$a r7 = r5.f6013f
            r7.f6029c = r0
            r7.f6030d = r6
            boolean r6 = r5.f6025t
            if (r6 != 0) goto L_0x007f
            boolean r6 = r5.e()
            if (r6 == 0) goto L_0x007f
            t1.a$b r6 = r5.f6016i
            if (r6 != 0) goto L_0x0061
            t1.a$b r6 = new t1.a$b
            r6.<init>()
            r5.f6016i = r6
        L_0x0061:
            r5.f6025t = r2
            r5.f6024r = r2
            boolean r6 = r5.f6023q
            if (r6 != 0) goto L_0x0078
            int r6 = r5.m
            if (r6 <= 0) goto L_0x0078
            android.view.View r7 = r5.f6015h
            t1.a$b r0 = r5.f6016i
            long r3 = (long) r6
            java.util.WeakHashMap<android.view.View, p1.k0> r6 = p1.y.f5540a
            p1.y.d.n(r7, r0, r3)
            goto L_0x007d
        L_0x0078:
            t1.a$b r6 = r5.f6016i
            r6.run()
        L_0x007d:
            r5.f6023q = r2
        L_0x007f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
