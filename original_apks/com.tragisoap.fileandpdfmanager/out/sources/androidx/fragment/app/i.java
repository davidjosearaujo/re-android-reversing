package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ l0 f1653f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f1654g;

    /* renamed from: h  reason: collision with root package name */
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
