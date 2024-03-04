package androidx.compose.ui.platform;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class y implements l0.d0 {

    /* renamed from: f */
    public final int f1242f;

    /* renamed from: g */
    public final List<y> f1243g;

    /* renamed from: h */
    public Float f1244h;

    /* renamed from: i */
    public Float f1245i;

    /* renamed from: j */
    public o0.d f1246j;

    /* renamed from: k */
    public o0.d f1247k;

    public y(int i7, ArrayList arrayList) {
        r5.h.f(arrayList, "allScopes");
        this.f1242f = i7;
        this.f1243g = arrayList;
        this.f1244h = null;
        this.f1245i = null;
        this.f1246j = null;
        this.f1247k = null;
    }

    public final boolean a() {
        return this.f1243g.contains(this);
    }
}
