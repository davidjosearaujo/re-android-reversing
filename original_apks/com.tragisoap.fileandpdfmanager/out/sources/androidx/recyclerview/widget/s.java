package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s extends y {

    /* renamed from: c */
    public p f2273c;

    /* renamed from: d */
    public o f2274d;

    public static int c(View view, q qVar) {
        return ((qVar.c(view) / 2) + qVar.e(view)) - ((qVar.l() / 2) + qVar.k());
    }

    @Override // androidx.recyclerview.widget.y
    public final int[] a(RecyclerView.l lVar, View view) {
        int[] iArr = new int[2];
        if (lVar.e()) {
            iArr[0] = c(view, d(lVar));
        } else {
            iArr[0] = 0;
        }
        if (lVar.f()) {
            iArr[1] = c(view, e(lVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final q d(RecyclerView.l lVar) {
        o oVar = this.f2274d;
        if (oVar == null || oVar.f2269a != lVar) {
            this.f2274d = new o(lVar);
        }
        return this.f2274d;
    }

    public final q e(RecyclerView.l lVar) {
        p pVar = this.f2273c;
        if (pVar == null || pVar.f2269a != lVar) {
            this.f2273c = new p(lVar);
        }
        return this.f2273c;
    }
}
