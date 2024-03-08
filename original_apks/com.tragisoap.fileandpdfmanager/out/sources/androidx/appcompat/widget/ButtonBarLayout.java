package androidx.appcompat.widget;

import a0.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    public boolean f719f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f720g;

    /* renamed from: h  reason: collision with root package name */
    public int f721h = -1;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr = e.G;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.m.d(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f719f = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f719f);
        }
    }

    private void setStacked(boolean z6) {
        if (this.f720g == z6) {
            return;
        }
        if (!z6 || this.f719f) {
            this.f720g = z6;
            setOrientation(z6 ? 1 : 0);
            setGravity(z6 ? 8388613 : 80);
            View findViewById = findViewById(2131296797);
            if (findViewById != null) {
                findViewById.setVisibility(z6 ? 8 : 4);
            }
            for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                bringChildToFront(getChildAt(childCount));
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i7, int i8) {
        boolean z6;
        int i9;
        int i10;
        int i11;
        int size = View.MeasureSpec.getSize(i7);
        int i12 = 0;
        if (this.f719f) {
            if (size > this.f721h && this.f720g) {
                setStacked(false);
            }
            this.f721h = size;
        }
        if (this.f720g || View.MeasureSpec.getMode(i7) != 1073741824) {
            i9 = i7;
            z6 = false;
        } else {
            i9 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z6 = true;
        }
        super.onMeasure(i9, i8);
        if (this.f719f && !this.f720g) {
            if ((getMeasuredWidthAndState() & -16777216) == 16777216) {
                setStacked(true);
                z6 = true;
            }
        }
        if (z6) {
            super.onMeasure(i7, i8);
        }
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            i10 = -1;
            if (i13 >= childCount) {
                i13 = -1;
                break;
            } else if (getChildAt(i13).getVisibility() == 0) {
                break;
            } else {
                i13++;
            }
        }
        if (i13 >= 0) {
            View childAt = getChildAt(i13);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            i12 = 0 + childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f720g) {
                int i14 = i13 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i14 >= childCount2) {
                        break;
                    } else if (getChildAt(i14).getVisibility() == 0) {
                        i10 = i14;
                        break;
                    } else {
                        i14++;
                    }
                }
                if (i10 >= 0) {
                    i11 = getChildAt(i10).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
            } else {
                i11 = getPaddingBottom();
            }
            i12 += i11;
        }
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.d.d(this) != i12) {
            setMinimumHeight(i12);
            if (i8 == 0) {
                super.onMeasure(i7, i8);
            }
        }
    }

    public void setAllowStacking(boolean z6) {
        if (this.f719f != z6) {
            this.f719f = z6;
            if (!z6 && this.f720g) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
