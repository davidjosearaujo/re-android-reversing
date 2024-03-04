package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a */
    public static final i0 f1647a = new i0();

    /* renamed from: b */
    public static final l0 f1648b;

    static {
        l0 l0Var;
        try {
            l0Var = (l0) k2.f.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            l0Var = null;
        }
        f1648b = l0Var;
    }

    public static void a(n nVar, n nVar2, boolean z6) {
        if (z6) {
            nVar2.getClass();
        } else {
            nVar.getClass();
        }
    }

    public static void b(ArrayList<View> arrayList, int i7) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i7);
        }
    }
}
