package k2;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import k2.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u extends k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f4670a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f4671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f4672c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ v f4673d;

    public u(v vVar, ViewGroup viewGroup, View view, View view2) {
        this.f4673d = vVar;
        this.f4670a = viewGroup;
        this.f4671b = view;
        this.f4672c = view2;
    }

    @Override // k2.k, k2.h.d
    public final void b() {
        this.f4670a.getOverlay().remove(this.f4671b);
    }

    @Override // k2.h.d
    public final void c(h hVar) {
        this.f4672c.setTag(2131296757, null);
        this.f4670a.getOverlay().remove(this.f4671b);
        hVar.v(this);
    }

    @Override // k2.k, k2.h.d
    public final void d() {
        if (this.f4671b.getParent() == null) {
            this.f4670a.getOverlay().add(this.f4671b);
            return;
        }
        v vVar = this.f4673d;
        int size = vVar.f4643r.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            vVar.f4643r.get(size).cancel();
        }
        ArrayList<h.d> arrayList = vVar.f4646v;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) vVar.f4646v.clone();
            int size2 = arrayList2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                ((h.d) arrayList2.get(i7)).e();
            }
        }
    }
}
