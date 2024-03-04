package d4;

import android.view.View;
import android.view.ViewGroup;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public class f extends ViewGroup {

    /* renamed from: f */
    public int f3599f;

    /* renamed from: g */
    public int f3600g;

    /* renamed from: h */
    public boolean f3601h;

    /* renamed from: i */
    public int f3602i;

    public boolean a() {
        return this.f3601h;
    }

    public int getItemSpacing() {
        return this.f3600g;
    }

    public int getLineSpacing() {
        return this.f3599f;
    }

    public int getRowCount() {
        return this.f3602i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        if (getChildCount() == 0) {
            this.f3602i = 0;
            return;
        }
        this.f3602i = 1;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        boolean z7 = y.e.d(this) == 1;
        int paddingRight = z7 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z7 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i13 = (i9 - i7) - paddingLeft;
        int i14 = paddingRight;
        int i15 = paddingTop;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(2131296754, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i12 = p1.g.c(marginLayoutParams);
                    i11 = p1.g.b(marginLayoutParams);
                } else {
                    i11 = 0;
                    i12 = 0;
                }
                int measuredWidth = childAt.getMeasuredWidth() + i14 + i12;
                if (!this.f3601h && measuredWidth > i13) {
                    i15 = this.f3599f + paddingTop;
                    this.f3602i++;
                    i14 = paddingRight;
                }
                childAt.setTag(2131296754, Integer.valueOf(this.f3602i - 1));
                int i17 = i14 + i12;
                int measuredWidth2 = childAt.getMeasuredWidth() + i17;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (z7) {
                    i17 = i13 - measuredWidth2;
                    measuredWidth2 = (i13 - i14) - i12;
                }
                childAt.layout(i17, i15, measuredWidth2, measuredHeight);
                i14 += childAt.getMeasuredWidth() + i12 + i11 + this.f3600g;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        int i9;
        int i10;
        int size = View.MeasureSpec.getSize(i7);
        int mode = View.MeasureSpec.getMode(i7);
        int size2 = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i8);
        int i11 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i11 - getPaddingRight();
        int i12 = paddingTop;
        int i13 = 0;
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i7, i8);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i10 = marginLayoutParams.leftMargin + 0;
                    i9 = marginLayoutParams.rightMargin + 0;
                } else {
                    i9 = 0;
                    i10 = 0;
                }
                if (childAt.getMeasuredWidth() + paddingLeft + i10 > paddingRight && !a()) {
                    paddingLeft = getPaddingLeft();
                    i12 = this.f3599f + paddingTop;
                }
                int measuredWidth = childAt.getMeasuredWidth() + paddingLeft + i10;
                int measuredHeight = childAt.getMeasuredHeight() + i12;
                if (measuredWidth > i13) {
                    i13 = measuredWidth;
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + i10 + i9 + this.f3600g + paddingLeft;
                if (i14 == getChildCount() - 1) {
                    i13 += i9;
                }
                paddingLeft = measuredWidth2;
                paddingTop = measuredHeight;
            }
        }
        int paddingRight2 = getPaddingRight() + i13;
        int paddingBottom = getPaddingBottom() + paddingTop;
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(paddingRight2, size);
        } else if (mode != 1073741824) {
            size = paddingRight2;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(paddingBottom, size2);
        } else if (mode2 != 1073741824) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    public void setItemSpacing(int i7) {
        this.f3600g = i7;
    }

    public void setLineSpacing(int i7) {
        this.f3599f = i7;
    }

    public void setSingleLine(boolean z6) {
        this.f3601h = z6;
    }
}
