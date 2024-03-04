package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class m extends RecyclerView.v {
    @SuppressLint({"UnknownNullness"})

    /* renamed from: k */
    public PointF f2263k;

    /* renamed from: l */
    public final DisplayMetrics f2264l;

    /* renamed from: n */
    public float f2265n;

    /* renamed from: i */
    public final LinearInterpolator f2261i = new LinearInterpolator();

    /* renamed from: j */
    public final DecelerateInterpolator f2262j = new DecelerateInterpolator();
    public boolean m = false;

    /* renamed from: o */
    public int f2266o = 0;

    /* renamed from: p */
    public int f2267p = 0;

    @SuppressLint({"UnknownNullness"})
    public m(Context context) {
        this.f2264l = context.getResources().getDisplayMetrics();
    }

    public static int e(int i7, int i8, int i9, int i10, int i11) {
        if (i11 != -1) {
            if (i11 != 0) {
                if (i11 == 1) {
                    return i10 - i8;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i12 = i9 - i7;
            if (i12 > 0) {
                return i12;
            }
            int i13 = i10 - i8;
            if (i13 < 0) {
                return i13;
            }
            return 0;
        }
        return i9 - i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    @SuppressLint({"UnknownNullness"})
    public void c(View view, RecyclerView.v.a aVar) {
        int i7;
        int i8;
        PointF pointF = this.f2263k;
        int i9 = -1;
        int f7 = f(view, (pointF == null || pointF.x == 0.0f) ? 0 : i8 > 0 ? 1 : -1);
        PointF pointF2 = this.f2263k;
        if (pointF2 == null || pointF2.y == 0.0f) {
            i9 = 0;
        } else if (i7 > 0) {
            i9 = 1;
        }
        int g2 = g(view, i9);
        int ceil = (int) Math.ceil(i((int) Math.sqrt((g2 * g2) + (f7 * f7))) / 0.3356d);
        if (ceil > 0) {
            DecelerateInterpolator decelerateInterpolator = this.f2262j;
            aVar.f2079a = -f7;
            aVar.f2080b = -g2;
            aVar.f2081c = ceil;
            aVar.e = decelerateInterpolator;
            aVar.f2083f = true;
        }
    }

    @SuppressLint({"UnknownNullness"})
    public int f(View view, int i7) {
        RecyclerView.l lVar = this.f2074c;
        if (lVar == null || !lVar.e()) {
            return 0;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return e((view.getLeft() - ((RecyclerView.m) view.getLayoutParams()).f2053b.left) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, view.getRight() + ((RecyclerView.m) view.getLayoutParams()).f2053b.right + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, lVar.D(), lVar.f2044n - lVar.E(), i7);
    }

    @SuppressLint({"UnknownNullness"})
    public int g(View view, int i7) {
        RecyclerView.l lVar = this.f2074c;
        if (lVar == null || !lVar.f()) {
            return 0;
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return e((view.getTop() - ((RecyclerView.m) view.getLayoutParams()).f2053b.top) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, view.getBottom() + ((RecyclerView.m) view.getLayoutParams()).f2053b.bottom + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin, lVar.F(), lVar.f2045o - lVar.C(), i7);
    }

    @SuppressLint({"UnknownNullness"})
    public float h(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int i(int i7) {
        float abs = Math.abs(i7);
        if (!this.m) {
            this.f2265n = h(this.f2264l);
            this.m = true;
        }
        return (int) Math.ceil(abs * this.f2265n);
    }
}
