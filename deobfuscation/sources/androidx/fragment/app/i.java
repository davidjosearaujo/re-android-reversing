package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ l0 f1653f;

    /* renamed from: g */
    public final /* synthetic */ View f1654g;

    /* renamed from: h */
    public final /* synthetic */ Rect f1655h;

    public i(l0 l0Var, View view, Rect rect) {
        this.f1653f = l0Var;
        this.f1654g = view;
        this.f1655h = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l0 l0Var = this.f1653f;
        View view = this.f1654g;
        Rect rect = this.f1655h;
        l0Var.getClass();
        l0.g(view, rect);
    }
}
