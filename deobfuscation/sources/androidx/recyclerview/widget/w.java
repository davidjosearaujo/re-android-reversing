package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class w {
    public static int a(RecyclerView.w wVar, q qVar, View view, View view2, RecyclerView.l lVar, boolean z6) {
        if (lVar.w() == 0 || wVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (z6) {
            return Math.min(qVar.l(), qVar.b(view2) - qVar.e(view));
        }
        return Math.abs(RecyclerView.l.G(view) - RecyclerView.l.G(view2)) + 1;
    }

    public static int b(RecyclerView.w wVar, q qVar, View view, View view2, RecyclerView.l lVar, boolean z6, boolean z7) {
        if (lVar.w() == 0 || wVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z7 ? Math.max(0, (wVar.b() - Math.max(RecyclerView.l.G(view), RecyclerView.l.G(view2))) - 1) : Math.max(0, Math.min(RecyclerView.l.G(view), RecyclerView.l.G(view2)));
        if (z6) {
            return Math.round((max * (Math.abs(qVar.b(view2) - qVar.e(view)) / (Math.abs(RecyclerView.l.G(view) - RecyclerView.l.G(view2)) + 1))) + (qVar.k() - qVar.e(view)));
        }
        return max;
    }

    public static int c(RecyclerView.w wVar, q qVar, View view, View view2, RecyclerView.l lVar, boolean z6) {
        if (lVar.w() == 0 || wVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (z6) {
            return (int) (((qVar.b(view2) - qVar.e(view)) / (Math.abs(RecyclerView.l.G(view) - RecyclerView.l.G(view2)) + 1)) * wVar.b());
        }
        return wVar.b();
    }
}
