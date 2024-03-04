package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.appcompat.view.menu.j;

/* loaded from: classes.dex */
public abstract class a implements j {

    /* renamed from: f */
    public Context f529f;

    /* renamed from: g */
    public Context f530g;

    /* renamed from: h */
    public f f531h;

    /* renamed from: i */
    public LayoutInflater f532i;

    /* renamed from: j */
    public j.a f533j;

    /* renamed from: k */
    public int f534k = 2131492867;

    /* renamed from: l */
    public int f535l = 2131492866;
    public k m;

    public a(Context context) {
        this.f529f = context;
        this.f532i = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void j(j.a aVar) {
        this.f533j = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean k(h hVar) {
        return false;
    }
}
