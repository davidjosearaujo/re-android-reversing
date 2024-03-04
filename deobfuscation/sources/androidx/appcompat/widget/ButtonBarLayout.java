package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.WeakHashMap;
import p1.y;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: f */
    public boolean f719f;

    /* renamed from: g */
    public boolean f720g;

    /* renamed from: h */
    public int f721h;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f721h = -1;
        int[] iArr = a0.e.G;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        y.m.d(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f719f = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f719f);
        }
    }

    private void setStacked(boolean z6) {
        if (this.f720g != z6) {
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
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i7, int i8) {
        int i9;
        boolean z6;
        int i10;
        int paddingBottom;
        int size = View.MeasureSpec.getSize(i7);
        int i11 = 0;
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
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z6 = true;
            }
        }
        if (z6) {
            super.onMeasure(i7, i8);
        }
        int childCount = getChildCount();
        int i12 = 0;
        while (true) {
            i10 = -1;
            if (i12 >= childCount) {
                i12 = -1;
                break;
            } else if (getChildAt(i12).getVisibility() == 0) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 >= 0) {
            View childAt = getChildAt(i12);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            i11 = 0 + childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f720g) {
                int i13 = i12 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i13 >= childCount2) {
                        break;
                    } else if (getChildAt(i13).getVisibility() == 0) {
                        i10 = i13;
                        break;
                    } else {
                        i13++;
                    }
                }
                if (i10 >= 0) {
                    paddingBottom = getChildAt(i10).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
            } else {
                paddingBottom = getPaddingBottom();
            }
            i11 += paddingBottom;
        }
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        if (y.d.d(this) != i11) {
            setMinimumHeight(i11);
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
