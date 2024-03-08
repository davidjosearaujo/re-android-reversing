package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class q {

    /* renamed from: a */
    public final RecyclerView.l f2269a;

    /* renamed from: b */
    public int f2270b = Integer.MIN_VALUE;

    /* renamed from: c */
    public final Rect f2271c = new Rect();

    public q(RecyclerView.l lVar) {
        this.f2269a = lVar;
    }

    public static q a(RecyclerView.l lVar, int i7) {
        if (i7 == 0) {
            return new o(lVar);
        }
        if (i7 == 1) {
            return new p(lVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public final int m() {
        if (Integer.MIN_VALUE == this.f2270b) {
            return 0;
        }
        return l() - this.f2270b;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i7);
}
