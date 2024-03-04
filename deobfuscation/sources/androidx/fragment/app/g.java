package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.l;
import l1.d;

/* loaded from: classes.dex */
public final class g implements d.a {

    /* renamed from: a */
    public final /* synthetic */ View f1644a;

    /* renamed from: b */
    public final /* synthetic */ ViewGroup f1645b;

    /* renamed from: c */
    public final /* synthetic */ l.a f1646c;

    public g(View view, ViewGroup viewGroup, l.a aVar) {
        this.f1644a = view;
        this.f1645b = viewGroup;
        this.f1646c = aVar;
    }

    @Override // l1.d.a
    public final void onCancel() {
        this.f1644a.clearAnimation();
        this.f1645b.endViewTransition(this.f1644a);
        this.f1646c.a();
    }
}
