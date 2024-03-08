package r3;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import n3.a;
import p1.o0;
import p1.p0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g extends o0.a {

    /* renamed from: b  reason: collision with root package name */
    public final View f5904b;

    /* renamed from: c  reason: collision with root package name */
    public int f5905c;

    /* renamed from: d  reason: collision with root package name */
    public int f5906d;
    public final int[] e = new int[2];

    public g(View view) {
        this.f5904b = view;
    }

    @Override // p1.o0.a
    public final p0 a(p0 p0Var, List<o0> list) {
        Iterator<o0> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            o0 next = it.next();
            if ((next.f5502a.b() & 8) != 0) {
                this.f5904b.setTranslationY((float) a.b(this.f5906d, 0, next.f5502a.a()));
                break;
            }
        }
        return p0Var;
    }
}
