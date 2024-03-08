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
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i extends RecyclerView.k {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f2207d = {16843284};

    /* renamed from: a  reason: collision with root package name */
    public Drawable f2208a;

    /* renamed from: b  reason: collision with root package name */
    public int f2209b;

    /* renamed from: c  reason: collision with root package name */
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
        int i7;
        int i8;
        int i9;
        int i10;
        if (recyclerView.getLayoutManager() != null && this.f2208a != null) {
            int i11 = 0;
            if (this.f2209b == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i10 = recyclerView.getPaddingLeft();
                    i9 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i10, recyclerView.getPaddingTop(), i9, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    i9 = recyclerView.getWidth();
                    i10 = 0;
                }
                int childCount = recyclerView.getChildCount();
                while (i11 < childCount) {
                    View childAt = recyclerView.getChildAt(i11);
                    RecyclerView.M(childAt, this.f2210c);
                    int round = Math.round(childAt.getTranslationY()) + this.f2210c.bottom;
                    this.f2208a.setBounds(i10, round - this.f2208a.getIntrinsicHeight(), i9, round);
                    this.f2208a.draw(canvas);
                    i11++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i8 = recyclerView.getPaddingTop();
                i7 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), i8, recyclerView.getWidth() - recyclerView.getPaddingRight(), i7);
            } else {
                i7 = recyclerView.getHeight();
                i8 = 0;
            }
            int childCount2 = recyclerView.getChildCount();
            while (i11 < childCount2) {
                View childAt2 = recyclerView.getChildAt(i11);
                recyclerView.getLayoutManager().z(childAt2, this.f2210c);
                int round2 = Math.round(childAt2.getTranslationX()) + this.f2210c.right;
                this.f2208a.setBounds(round2 - this.f2208a.getIntrinsicWidth(), i8, round2, i7);
                this.f2208a.draw(canvas);
                i11++;
            }
            canvas.restore();
        }
    }
}
