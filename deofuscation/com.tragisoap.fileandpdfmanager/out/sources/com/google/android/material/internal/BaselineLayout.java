package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class BaselineLayout extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    public int f3205f = -1;

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.f3205f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i9 - i7) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int baseline = (this.f3205f == -1 || childAt.getBaseline() == -1) ? paddingTop : (this.f3205f + paddingTop) - childAt.getBaseline();
                childAt.layout(i12, baseline, measuredWidth + i12, measuredHeight + baseline);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        int childCount = getChildCount();
        int i9 = -1;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i7, i8);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i9 = Math.max(i9, baseline);
                    i10 = Math.max(i10, childAt.getMeasuredHeight() - baseline);
                }
                i12 = Math.max(i12, childAt.getMeasuredWidth());
                i11 = Math.max(i11, childAt.getMeasuredHeight());
                i13 = View.combineMeasuredStates(i13, childAt.getMeasuredState());
            }
        }
        if (i9 != -1) {
            i11 = Math.max(i11, Math.max(i10, getPaddingBottom()) + i9);
            this.f3205f = i9;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i12, getSuggestedMinimumWidth()), i7, i13), View.resolveSizeAndState(Math.max(i11, getSuggestedMinimumHeight()), i8, i13 << 16));
    }
}
