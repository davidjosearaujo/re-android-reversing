package androidx.compose.ui.platform;

import java.util.ArrayList;
import java.util.List;
import l0.d0;
import o0.d;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class y implements d0 {

    /* renamed from: f  reason: collision with root package name */
    public final int f1242f;

    /* renamed from: g  reason: collision with root package name */
    public final List<y> f1243g;

    /* renamed from: h  reason: collision with root package name */
    public Float f1244h = null;

    /* renamed from: i  reason: collision with root package name */
    public Float f1245i = null;

    /* renamed from: j  reason: collision with root package name */
    public d f1246j = null;

    /* renamed from: k  reason: collision with root package name */
    public d f1247k = null;

    public y(int i7, ArrayList arrayList) {
        h.f(arrayList, "allScopes");
        this.f1242f = i7;
        this.f1243g = arrayList;
    }

    public final boolean a() {
        return this.f1243g.contains(this);
    }
}
