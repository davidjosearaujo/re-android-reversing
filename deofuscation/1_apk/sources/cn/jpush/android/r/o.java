package cn.jpush.android.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import cn.jpush.android.helper.Logger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class o implements View.OnTouchListener {
    private int a;
    private int b;
    private int c;
    private long d;
    private View e;
    private a f;
    private int g = 1;
    private int h = 1;
    private float i;
    private float j;
    private boolean k;
    private int l;
    private Object m;
    private VelocityTracker n;
    private float o;
    private float p;
    private boolean q;
    private boolean r;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void a(View view, Object obj);

        boolean a(Object obj);
    }

    public o(cn.jpush.android.s.c cVar, Object obj, a aVar) {
        this.q = false;
        this.r = true;
        View d = cVar.d();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(d.getContext());
        this.a = viewConfiguration.getScaledTouchSlop();
        this.b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.d = 1000L;
        this.e = d;
        this.m = obj;
        this.f = aVar;
        this.q = false;
        this.r = cVar.f().c() == 80;
        StringBuilder sb = new StringBuilder();
        sb.append("[InAppSwipeDismissTouchListener] in-app show at top: ");
        sb.append(!this.r);
        sb.append(", dismiss top_bottom: ");
        sb.append(!this.q);
        Logger.d("InAppSwipeDismissTouchListener", sb.toString());
    }

    private void a(float f, float f2, AnimatorListenerAdapter animatorListenerAdapter) {
        try {
            final float a2 = this.q ? a() : b();
            final float f3 = f - a2;
            final float alpha = this.e.getAlpha();
            final float f4 = f2 - alpha;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            if (ofFloat != null) {
                ofFloat.setDuration(this.d);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.r.o.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = a2 + (valueAnimator.getAnimatedFraction() * f3);
                        float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f4);
                        if (o.this.q) {
                            o.this.a(animatedFraction);
                        } else {
                            o.this.b(animatedFraction);
                        }
                        o.this.c(animatedFraction2);
                    }
                });
                if (animatorListenerAdapter != null) {
                    ofFloat.addListener(animatorListenerAdapter);
                }
                ofFloat.start();
            }
        } catch (Throwable th) {
            Logger.w("InAppSwipeDismissTouchListener", "[animateTo] failed" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            View view = this.e;
            if (view != null) {
                final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                final int height = this.e.getHeight();
                final int width = this.e.getWidth();
                int[] iArr = new int[2];
                iArr[0] = this.q ? height : width;
                iArr[1] = 1;
                ValueAnimator duration = ValueAnimator.ofInt(iArr).setDuration(this.d);
                duration.addListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.o.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Logger.d("InAppSwipeDismissTouchListener", "[onAnimationEnd] ...");
                        if (o.this.f != null) {
                            o.this.f.a(o.this.e, o.this.m);
                        }
                        o.this.e.setAlpha(1.0f);
                        if (o.this.q) {
                            o.this.e.setTranslationX(0.0f);
                            layoutParams.height = height;
                        } else {
                            o.this.e.setTranslationY(0.0f);
                            layoutParams.width = width;
                        }
                        o.this.e.setLayoutParams(layoutParams);
                    }
                });
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.r.o.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (o.this.q) {
                            layoutParams.height = intValue;
                        } else {
                            layoutParams.width = intValue;
                        }
                        o.this.e.setLayoutParams(layoutParams);
                    }
                });
                duration.start();
            }
        } catch (Throwable th) {
            Logger.w("InAppSwipeDismissTouchListener", "[performDismiss] failed." + th.getMessage());
        }
    }

    public float a() {
        return this.e.getTranslationX();
    }

    public void a(float f) {
        this.e.setTranslationX(f);
    }

    public void a(boolean z) {
        int i = this.h;
        if (z) {
            i = -i;
        }
        Logger.d("InAppSwipeDismissTouchListener", "[startDismissAnimationY] dismissTop: " + z);
        a((float) i, 0.0f, new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.o.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                o.this.d();
            }
        });
    }

    public float b() {
        return this.e.getTranslationY();
    }

    public void b(float f) {
        this.e.setTranslationY(f);
    }

    public void b(boolean z) {
        a(z ? this.g : -this.g, 0.0f, new AnimatorListenerAdapter() { // from class: cn.jpush.android.r.o.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                o.this.d();
            }
        });
    }

    public void c() {
        a(0.0f, 1.0f, null);
    }

    public void c(float f) {
        this.e.setAlpha(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011c A[Catch: all -> 0x0391, TryCatch #0 {all -> 0x0391, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0016, B:11:0x0030, B:20:0x0043, B:23:0x0049, B:24:0x0056, B:25:0x005a, B:28:0x0060, B:30:0x0077, B:32:0x0082, B:34:0x008f, B:36:0x0095, B:38:0x009b, B:39:0x00b9, B:37:0x0098, B:59:0x0118, B:61:0x011c, B:63:0x0122, B:64:0x0140, B:65:0x0144, B:40:0x00bd, B:42:0x00c8, B:46:0x00d7, B:49:0x00dd, B:51:0x00e1, B:54:0x00ed, B:56:0x00f3, B:58:0x00f9, B:57:0x00f6, B:67:0x0164, B:70:0x016a, B:73:0x01f8, B:75:0x0203, B:106:0x024a, B:131:0x031e, B:133:0x0322, B:138:0x0331, B:140:0x0335, B:141:0x0338, B:134:0x0326, B:135:0x032a, B:137:0x032e, B:82:0x0211, B:84:0x0218, B:88:0x0223, B:101:0x023a, B:107:0x0296, B:109:0x02a1, B:129:0x02d3, B:116:0x02af, B:118:0x02b6, B:122:0x02c1, B:124:0x02c5, B:142:0x0346, B:144:0x037e, B:146:0x0386, B:8:0x001f, B:10:0x0028), top: B:153:0x0007 }] */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r17, android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 940
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.o.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
