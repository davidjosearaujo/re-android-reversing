package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.timepicker.ClockHandView;
import g1.a;
import g4.c;
import java.util.Arrays;
import l0.z;
import p1.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ClockFaceView extends d implements ClockHandView.a {
    public final SparseArray<TextView> C;
    public final b D;
    public final int[] E;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public String[] K;
    public float L;
    public final ColorStateList M;

    /* renamed from: y */
    public final ClockHandView f3350y;

    /* renamed from: z */
    public final Rect f3351z = new Rect();
    public final RectF A = new RectF();
    public final Rect B = new Rect();
    public final float[] F = {0.0f, 0.9f, 1.0f};

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130903818);
        SparseArray<TextView> sparseArray = new SparseArray<>();
        this.C = sparseArray;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.e, 2130903818, 2131887192);
        Resources resources = getResources();
        ColorStateList a7 = c.a(context, obtainStyledAttributes, 1);
        this.M = a7;
        LayoutInflater.from(context).inflate(2131492934, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(2131296601);
        this.f3350y = clockHandView;
        this.G = resources.getDimensionPixelSize(2131100196);
        int colorForState = a7.getColorForState(new int[]{16842913}, a7.getDefaultColor());
        this.E = new int[]{colorForState, colorForState, a7.getDefaultColor()};
        clockHandView.f3354h.add(this);
        int defaultColor = a.c(context, 2131034828).getDefaultColor();
        ColorStateList a8 = c.a(context, obtainStyledAttributes, 0);
        setBackgroundColor(a8 != null ? a8.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.D = new b(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.K = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z6 = false;
        for (int i7 = 0; i7 < Math.max(this.K.length, size); i7++) {
            TextView textView = this.C.get(i7);
            if (i7 >= this.K.length) {
                removeView(textView);
                this.C.remove(i7);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(2131492933, (ViewGroup) this, false);
                    this.C.put(i7, textView);
                    addView(textView);
                }
                textView.setText(this.K[i7]);
                textView.setTag(2131296617, Integer.valueOf(i7));
                int i8 = (i7 / 12) + 1;
                textView.setTag(2131296602, Integer.valueOf(i8));
                z6 = i8 > 1 ? true : z6;
                y.i(textView, this.D);
                textView.setTextColor(this.M);
            }
        }
        ClockHandView clockHandView2 = this.f3350y;
        if (clockHandView2.f3353g && !z6) {
            clockHandView2.f3363r = 1;
        }
        clockHandView2.f3353g = z6;
        clockHandView2.invalidate();
        this.H = resources.getDimensionPixelSize(2131100224);
        this.I = resources.getDimensionPixelSize(2131100225);
        this.J = resources.getDimensionPixelSize(2131100203);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.a
    public final void b(float f7) {
        if (Math.abs(this.L - f7) > 0.001f) {
            this.L = f7;
            l();
        }
    }

    @Override // com.google.android.material.timepicker.d
    public final void k() {
        super.k();
        for (int i7 = 0; i7 < this.C.size(); i7++) {
            this.C.get(i7).setVisibility(0);
        }
    }

    public final void l() {
        RectF rectF = this.f3350y.f3358l;
        float f7 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i7 = 0; i7 < this.C.size(); i7++) {
            TextView textView2 = this.C.get(i7);
            if (textView2 != null) {
                textView2.getHitRect(this.f3351z);
                this.A.set(this.f3351z);
                this.A.union(rectF);
                float height = this.A.height() * this.A.width();
                if (height < f7) {
                    textView = textView2;
                    f7 = height;
                }
            }
        }
        for (int i8 = 0; i8 < this.C.size(); i8++) {
            TextView textView3 = this.C.get(i8);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(this.f3351z);
                this.A.set(this.f3351z);
                textView3.getLineBounds(0, this.B);
                RectF rectF2 = this.A;
                Rect rect = this.B;
                rectF2.inset((float) rect.left, (float) rect.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF, this.A) ? null : new RadialGradient(rectF.centerX() - this.A.left, rectF.centerY() - this.A.top, 0.5f * rectF.width(), this.E, this.F, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.K.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        super.onLayout(z6, i7, i8, i9, i10);
        l();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i7, int i8) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (((float) this.J) / Math.max(Math.max(((float) this.H) / ((float) displayMetrics.heightPixels), ((float) this.I) / ((float) displayMetrics.widthPixels)), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
