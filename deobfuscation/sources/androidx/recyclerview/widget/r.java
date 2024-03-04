package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class r extends m {

    /* renamed from: q */
    public final /* synthetic */ s f2272q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, Context context) {
        super(context);
        this.f2272q = sVar;
    }

    @Override // androidx.recyclerview.widget.m, androidx.recyclerview.widget.RecyclerView.v
    public final void c(View view, RecyclerView.v.a aVar) {
        s sVar = this.f2272q;
        int[] a7 = sVar.a(sVar.f2280a.getLayoutManager(), view);
        int i7 = a7[0];
        int i8 = a7[1];
        int ceil = (int) Math.ceil(i(Math.max(Math.abs(i7), Math.abs(i8))) / 0.3356d);
        if (ceil > 0) {
            DecelerateInterpolator decelerateInterpolator = this.f2262j;
            aVar.f2079a = i7;
            aVar.f2080b = i8;
            aVar.f2081c = ceil;
            aVar.e = decelerateInterpolator;
            aVar.f2083f = true;
        }
    }

    @Override // androidx.recyclerview.widget.m
    public final float h(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.m
    public final int i(int i7) {
        return Math.min(100, super.i(i7));
    }
}
