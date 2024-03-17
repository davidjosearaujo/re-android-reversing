package com.hunantv.imgo.guide.core;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.hunantv.imgo.guide.model.HighLight;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GuideLayout extends SkinnableFrameLayout {
    public static final int h = -1728053248;
    private j.l.a.l.b.b a;
    private Paint b;
    public j.l.a.l.e.a c;
    private f d;
    private float e;
    private float f;
    private int g;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GuideLayout.this.c.C()) {
                GuideLayout.this.remove();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuideLayout.this.remove();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c extends j.l.a.l.d.a {
        public c() {
        }

        public void onAnimationEnd(Animation animation) {
            GuideLayout.this.d0();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GuideLayout.this.getParent() != null) {
                ((ViewGroup) GuideLayout.this.getParent()).removeView(GuideLayout.this);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[HighLight.Shape.values().length];
            a = iArr;
            try {
                iArr[HighLight.Shape.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HighLight.Shape.OVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[HighLight.Shape.ROUND_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[HighLight.Shape.RECTANGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface f {
        void a(GuideLayout guideLayout);
    }

    public GuideLayout(Context context, j.l.a.l.e.a aVar, j.l.a.l.b.b bVar) {
        super(context);
        init();
        setGuidePage(aVar);
        this.a = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c0(j.l.a.l.e.a aVar) {
        removeAllViews();
        int y = aVar.y();
        if (y != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(y, (ViewGroup) this, false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            int[] u = aVar.u();
            if (u != null && u.length > 0) {
                for (int i : u) {
                    View findViewById = inflate.findViewById(i);
                    if (findViewById != null) {
                        findViewById.setOnClickListener(new b());
                    } else {
                        Log.w("MGUserGuide", "can't find the view by id : " + i + " which used to remove guide page");
                    }
                }
            }
            j.l.a.l.d.d z = aVar.z();
            if (z != null) {
                z.a(inflate, this.a);
            }
            addView(inflate, layoutParams);
        }
        List<j.l.a.l.e.e> A = aVar.A();
        if (A.size() > 0) {
            for (j.l.a.l.e.e eVar : A) {
                addView(eVar.a((ViewGroup) getParent()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void d0() {
        if (getParent() != null) {
            post(new d());
            f fVar = this.d;
            if (fVar != null) {
                fVar.a(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e0(Canvas canvas) {
        List<HighLight> x = this.c.x();
        if (x != null) {
            for (HighLight highLight : x) {
                RectF a2 = highLight.a((ViewGroup) getParent());
                int i = e.a[highLight.d().ordinal()];
                if (i == 1) {
                    canvas.drawCircle(a2.centerX(), a2.centerY(), highLight.getRadius(), this.b);
                } else if (i == 2) {
                    canvas.drawOval(a2, this.b);
                } else if (i != 3) {
                    canvas.drawRect(a2, this.b);
                } else {
                    canvas.drawRoundRect(a2, highLight.c(), highLight.c(), this.b);
                }
                g0(canvas, highLight, a2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f0(HighLight highLight) {
        View.OnClickListener onClickListener;
        j.l.a.l.e.b b2 = highLight.b();
        if (b2 == null || (onClickListener = b2.a) == null) {
            return;
        }
        onClickListener.onClick(this);
    }

    private void g0(Canvas canvas, HighLight highLight, RectF rectF) {
        j.l.a.l.d.c cVar;
        j.l.a.l.e.b b2 = highLight.b();
        if (b2 == null || (cVar = b2.c) == null) {
            return;
        }
        cVar.a(canvas, rectF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.b.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.INNER));
        setLayerType(1, null);
        setWillNotDraw(false);
        this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void setGuidePage(j.l.a.l.e.a aVar) {
        this.c = aVar;
        setOnClickListener(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        c0(this.c);
        Animation v = this.c.v();
        if (v != null) {
            startAnimation(v);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        super/*android.widget.FrameLayout*/.onDraw(canvas);
        int t = this.c.t();
        if (t == 0) {
            t = h;
        }
        canvas.drawColor(t);
        e0(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = motionEvent.getX();
            this.f = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (Math.abs(x - this.e) < this.g && Math.abs(y - this.f) < this.g) {
                for (HighLight highLight : this.c.x()) {
                    if (highLight.a((ViewGroup) getParent()).contains(x, y)) {
                        f0(highLight);
                        return true;
                    }
                }
                performClick();
            }
        }
        return super/*android.widget.FrameLayout*/.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean performClick() {
        return super/*android.widget.FrameLayout*/.performClick();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void remove() {
        Animation w = this.c.w();
        if (w != null) {
            w.setAnimationListener(new c());
            startAnimation(w);
            return;
        }
        d0();
    }

    public void setOnGuideLayoutDismissListener(f fVar) {
        this.d = fVar;
    }

    private GuideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private GuideLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
