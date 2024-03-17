package com.hunantv.imgo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hunantv.imgo.guide.core.GuideLayout;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import j.l.a.a0.b;
import j.l.a.b0.j0;
import j.l.a.t.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgCardView extends SkinnableFrameLayout {
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 4;
    private Context a;
    private Paint b;
    private RectF c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MgCardView.this.getWidth(), MgCardView.this.getHeight(), MgCardView.this.g);
        }
    }

    public MgCardView(@NonNull Context context) {
        super(context);
        this.f = 0;
        this.g = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.a = context;
        initView();
    }

    private void d0(Canvas canvas, int i, int i2) {
        this.b.setShadowLayer(this.h, 0.0f, 0.0f, this.e);
        RectF rectF = this.c;
        int i3 = this.i;
        rectF.left = i3;
        rectF.top = i3;
        rectF.right = i - i3;
        rectF.bottom = i2 - i3;
        int i4 = this.g;
        canvas.drawRoundRect(rectF, i4, i4, this.b);
    }

    private void e0(Canvas canvas, int i, int i2) {
        Path path = new Path();
        path.moveTo(this.i, this.h / 2);
        int i3 = this.i;
        int i4 = this.g;
        path.arcTo(new RectF(i3, (i2 - (i4 * 2)) - i3, (i4 * 2) + i3, i2 - i3), -180.0f, -90.0f, false);
        int i5 = this.i;
        int i6 = this.g;
        path.arcTo(new RectF((i - i5) - (i6 * 2), (i2 - i5) - (i6 * 2), i - i5, i2 - i5), 90.0f, -90.0f, false);
        path.lineTo(i - this.i, this.h / 2);
        canvas.drawPath(path, this.b);
    }

    private void f0(Canvas canvas, int i, int i2) {
        Path path = new Path();
        float f = i2;
        path.moveTo(this.i, f);
        int i3 = this.i;
        int i4 = this.g;
        path.arcTo(new RectF(i3, i3, (i4 * 2) + i3, i3 + (i4 * 2)), -180.0f, 90.0f, false);
        int i5 = this.i;
        int i6 = this.g;
        path.arcTo(new RectF((i - i5) - (i6 * 2), i5, i - i5, i5 + (i6 * 2)), -90.0f, 90.0f, false);
        path.lineTo(i - this.i, f);
        canvas.drawPath(path, this.b);
    }

    private void g0(Canvas canvas, int i, int i2) {
        int i3 = this.i;
        float f = i2;
        canvas.drawLine(i3, this.h / 2, i3, f, this.b);
        int i4 = this.i;
        canvas.drawLine(i - i4, this.h / 2, i - i4, f, this.b);
    }

    private int getShadowColor() {
        if (this.j) {
            return this.l ? this.n : GuideLayout.h;
        } else if (this.l) {
            return this.m;
        } else {
            return -3355444;
        }
    }

    private void initView() {
        this.d = j.l.a.a.a().getResources().getColor(b.e.color_v60_bg_primary);
        this.g = j0.b(this.a, 3.0f);
        this.j = e.m().t();
        int i = Build.VERSION.SDK_INT;
        if (i > 27 || i < 21) {
            this.k = true;
            this.i = j0.b(this.a, 1.0f);
            this.h = j0.b(this.a, 3.0f);
            this.e = getShadowColor();
            Paint paint = new Paint();
            this.b = paint;
            paint.setColor(this.e);
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setStrokeWidth(this.i);
            this.b.setShadowLayer(this.h, 0.0f, 0.0f, this.e);
            this.c = new RectF();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c0() {
        setClipChildren(false);
        this.f = 0;
        this.j = e.m().t();
        this.d = j.l.a.a.a().getResources().getColor(b.e.color_v60_bg_primary);
        this.e = this.j ? GuideLayout.h : -3355444;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int i = b.i.tag_mg_card_view;
        if (getTag(i) != null) {
            marginLayoutParams.leftMargin = 0;
            marginLayoutParams.rightMargin = 0;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
            setTag(i, null);
            setBackgroundColor(0);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                getChildAt(0).setClipToOutline(false);
            }
            setLayoutParams(marginLayoutParams);
            if (this.k) {
                invalidate();
            } else if (i2 >= 21) {
                setElevation(0.0f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        if (this.k && this.f != 0) {
            int height = getHeight();
            int width = getWidth();
            this.b.setColor(this.e);
            this.b.setShadowLayer(this.h, 0.0f, 0.0f, this.e);
            int i = this.f;
            if (i == 1) {
                f0(canvas, width, height);
            } else if (i == 2) {
                g0(canvas, width, height);
            } else if (i == 3) {
                e0(canvas, width, height);
            } else if (i == 4) {
                d0(canvas, width, height);
            }
        }
        super/*android.widget.FrameLayout*/.draw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h0(int i) {
        boolean z;
        GradientDrawable gradientDrawable;
        View childAt;
        View childAt2;
        setClipChildren(true);
        boolean t = e.m().t();
        if (this.j != t) {
            this.j = t;
            this.d = j.l.a.a.a().getResources().getColor(b.e.color_v60_bg_primary);
            this.e = getShadowColor();
            z = true;
        } else {
            z = false;
        }
        this.f = i;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int i2 = b.i.tag_mg_card_view;
        Object tag = getTag(i2);
        if ((tag instanceof Integer) && ((Integer) tag).intValue() != i) {
            tag = null;
        }
        if (tag == null || z) {
            Drawable background = getBackground();
            if (background instanceof GradientDrawable) {
                gradientDrawable = (GradientDrawable) background;
                if (z) {
                    gradientDrawable.setColor(this.d);
                }
            } else {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(this.d);
            }
            setTag(i2, Integer.valueOf(i));
            if (tag == null) {
                marginLayoutParams.leftMargin = j0.b(this.a, 10.0f);
                marginLayoutParams.rightMargin = j0.b(this.a, 10.0f);
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.bottomMargin = 0;
                if (i == 1) {
                    marginLayoutParams.topMargin = j0.b(this.a, 6.0f);
                    int i3 = this.g;
                    gradientDrawable.setCornerRadii(new float[]{i3, i3, i3, i3, 0.0f, 0.0f, 0.0f, 0.0f});
                } else if (i == 2) {
                    gradientDrawable.setCornerRadius(0.0f);
                } else if (i == 3) {
                    marginLayoutParams.bottomMargin = j0.b(this.a, 6.0f);
                    int i4 = this.g;
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, i4, i4, i4, i4});
                } else if (i == 4) {
                    marginLayoutParams.topMargin = j0.b(this.a, 6.0f);
                    marginLayoutParams.bottomMargin = j0.b(this.a, 6.0f);
                    gradientDrawable.setCornerRadius(this.g);
                }
                setLayoutParams(marginLayoutParams);
            }
            setBackground(gradientDrawable);
            if (i == 4) {
                if (Build.VERSION.SDK_INT >= 21 && (childAt2 = getChildAt(0)) != null) {
                    childAt2.setOutlineProvider(new a());
                    childAt2.setClipToOutline(true);
                }
            } else if (Build.VERSION.SDK_INT >= 21 && (childAt = getChildAt(0)) != null) {
                childAt.setClipToOutline(false);
            }
            if (!this.k) {
                if (Build.VERSION.SDK_INT >= 21) {
                    setElevation(j0.b(getContext(), 1.0f));
                    return;
                }
                return;
            }
            invalidate();
        }
    }

    public void i0(int i, int i2) {
        this.l = true;
        this.m = i;
        this.n = i2;
        this.e = getShadowColor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int i, int i2) {
        super/*android.widget.FrameLayout*/.onMeasure(i, i2);
    }

    public void setCustomShadowWidth(int i) {
        this.h = j0.b(this.a, i);
    }

    public MgCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        this.g = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.a = context;
        initView();
    }

    public MgCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        this.g = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.a = context;
        initView();
    }
}
