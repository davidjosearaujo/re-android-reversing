package o3;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.search.SearchBar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.e;
import p1.k0;
import p1.p0;
import p1.y;

/* loaded from: classes.dex */
public abstract class b extends c<View> {

    /* renamed from: h */
    public final Rect f5324h;

    /* renamed from: i */
    public final Rect f5325i;

    /* renamed from: j */
    public int f5326j;

    /* renamed from: k */
    public int f5327k;

    public b() {
        this.f5324h = new Rect();
        this.f5325i = new Rect();
        this.f5326j = 0;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5324h = new Rect();
        this.f5325i = new Rect();
        this.f5326j = 0;
    }

    public int A(View view) {
        return view.getMeasuredHeight();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9) {
        AppBarLayout y6;
        p0 lastWindowInsets;
        int i10 = view.getLayoutParams().height;
        if ((i10 == -1 || i10 == -2) && (y6 = y(coordinatorLayout.e(view))) != null) {
            int size = View.MeasureSpec.getSize(i9);
            if (size > 0) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (y.d.b(y6) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.b() + lastWindowInsets.e();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int A = A(y6) + size;
            int measuredHeight = y6.getMeasuredHeight();
            if (this instanceof SearchBar.ScrollingViewBehavior) {
                view.setTranslationY(-measuredHeight);
            } else {
                view.setTranslationY(0.0f);
                A -= measuredHeight;
            }
            coordinatorLayout.r(view, i7, i8, View.MeasureSpec.makeMeasureSpec(A, i10 == -1 ? 1073741824 : Integer.MIN_VALUE));
            return true;
        }
        return false;
    }

    @Override // o3.c
    public final void x(CoordinatorLayout coordinatorLayout, View view, int i7) {
        AppBarLayout y6 = y(coordinatorLayout.e(view));
        int i8 = 0;
        if (y6 != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f5324h;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, y6.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((y6.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            p0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (y.d.b(coordinatorLayout) && !y.d.b(view)) {
                    rect.left = lastWindowInsets.c() + rect.left;
                    rect.right -= lastWindowInsets.d();
                }
            }
            Rect rect2 = this.f5325i;
            int i9 = fVar.f1444c;
            if (i9 == 0) {
                i9 = 8388659;
            }
            e.b(i9, view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i7);
            if (this.f5327k != 0) {
                float z6 = z(y6);
                int i10 = this.f5327k;
                i8 = a0.e.k((int) (z6 * i10), 0, i10);
            }
            view.layout(rect2.left, rect2.top - i8, rect2.right, rect2.bottom - i8);
            i8 = rect2.top - y6.getBottom();
        } else {
            coordinatorLayout.q(view, i7);
        }
        this.f5326j = i8;
    }

    public abstract AppBarLayout y(ArrayList arrayList);

    public float z(View view) {
        return 1.0f;
    }
}
