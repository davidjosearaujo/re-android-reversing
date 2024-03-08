package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k0 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f1668f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1669g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1670h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1671i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1672j;

    public k0(int i7, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f1668f = i7;
        this.f1669g = arrayList;
        this.f1670h = arrayList2;
        this.f1671i = arrayList3;
        this.f1672j = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i7 = 0; i7 < this.f1668f; i7++) {
            WeakHashMap<View, p1.k0> weakHashMap = y.f5540a;
            y.i.v((View) this.f1669g.get(i7), (String) this.f1670h.get(i7));
            y.i.v((View) this.f1671i.get(i7), (String) this.f1672j.get(i7));
        }
    }
}
