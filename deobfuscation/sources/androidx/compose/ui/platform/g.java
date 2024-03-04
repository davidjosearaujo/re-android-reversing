package androidx.compose.ui.platform;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g {
    public static final boolean a(o0.j jVar) {
        return jVar.f().b(o0.m.f5258o);
    }

    public static final y b(int i7, ArrayList arrayList) {
        r5.h.f(arrayList, "<this>");
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (((y) arrayList.get(i8)).f1242f == i7) {
                return (y) arrayList.get(i8);
            }
        }
        return null;
    }

    public static final boolean c(o0.j jVar) {
        o0.f fVar = jVar.f5240d;
        o0.q<o0.a<q5.l<p0.a, Boolean>>> qVar = o0.e.f5229a;
        return fVar.b(o0.e.f5229a);
    }
}
