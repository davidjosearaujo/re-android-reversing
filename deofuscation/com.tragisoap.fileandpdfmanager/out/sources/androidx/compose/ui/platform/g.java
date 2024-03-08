package androidx.compose.ui.platform;

import java.util.ArrayList;
import o0.a;
import o0.e;
import o0.f;
import o0.j;
import o0.m;
import o0.q;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g {
    public static final boolean a(j jVar) {
        return jVar.f().b(m.f5258o);
    }

    public static final y b(int i7, ArrayList arrayList) {
        h.f(arrayList, "<this>");
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (((y) arrayList.get(i8)).f1242f == i7) {
                return (y) arrayList.get(i8);
            }
        }
        return null;
    }

    public static final boolean c(j jVar) {
        f fVar = jVar.f5240d;
        q<a<l<p0.a, Boolean>>> qVar = e.f5229a;
        return fVar.b(e.f5229a);
    }
}
