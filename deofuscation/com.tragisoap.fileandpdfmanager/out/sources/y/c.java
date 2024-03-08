package y;

import android.view.ViewStructure;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f6472a = new c();

    public final int a(ViewStructure viewStructure, int i7) {
        h.f(viewStructure, "structure");
        return viewStructure.addChildCount(i7);
    }

    public final ViewStructure b(ViewStructure viewStructure, int i7) {
        h.f(viewStructure, "structure");
        return viewStructure.newChild(i7);
    }

    public final void c(ViewStructure viewStructure, int i7, int i8, int i9, int i10, int i11, int i12) {
        h.f(viewStructure, "structure");
        viewStructure.setDimens(i7, i8, i9, i10, i11, i12);
    }

    public final void d(ViewStructure viewStructure, int i7, String str, String str2, String str3) {
        h.f(viewStructure, "structure");
        viewStructure.setId(i7, str, str2, str3);
    }
}
