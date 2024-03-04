package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class i extends RecyclerView.k {

    /* renamed from: d */
    public static final int[] f2207d = {16843284};

    /* renamed from: a */
    public Drawable f2208a;

    /* renamed from: b */
    public int f2209b;

    /* renamed from: c */
    public final Rect f2210c = new Rect();

    @SuppressLint({"UnknownNullness"})
    public i(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f2207d);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f2208a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        this.f2209b = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    @SuppressLint({"UnknownNullness"})
    public final void d(Rect rect, View view) {
        Drawable drawable = this.f2208a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f2209b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    @SuppressLint({"UnknownNullness"})
    public final void e(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int i7;
        int width;
        int i8;
        if (recyclerView.getLayoutManager() == null || this.f2208a == null) {
            return;
        }
        int i9 = 0;
        if (this.f2209b == 1) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i8 = recyclerView.getPaddingLeft();
                width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(i8, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                width = recyclerView.getWidth();
                i8 = 0;
            }
            int childCount = recyclerView.getChildCount();
            while (i9 < childCount) {
                View childAt = recyclerView.getChildAt(i9);
                RecyclerView.M(childAt, this.f2210c);
                int round = Math.round(childAt.getTranslationY()) + this.f2210c.bottom;
                this.f2208a.setBounds(i8, round - this.f2208a.getIntrinsicHeight(), width, round);
                this.f2208a.draw(canvas);
                i9++;
            }
            canvas.restore();
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i7 = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i7, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            i7 = 0;
        }
        int childCount2 = recyclerView.getChildCount();
        while (i9 < childCount2) {
            View childAt2 = recyclerView.getChildAt(i9);
            recyclerView.getLayoutManager().z(childAt2, this.f2210c);
            int round2 = Math.round(childAt2.getTranslationX()) + this.f2210c.right;
            this.f2208a.setBounds(round2 - this.f2208a.getIntrinsicWidth(), i7, round2, height);
            this.f2208a.draw(canvas);
            i9++;
        }
        canvas.restore();
    }
}
