package l0;

import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c {
    public static final w a(b bVar, int i7) {
        h.f(bVar, "$this$requireCoordinator");
        w wVar = bVar.a().f6422c;
        h.c(wVar);
        if (wVar.q() != bVar || !a0.b(i7)) {
            return wVar;
        }
        wVar.getClass();
        h.c(null);
        return null;
    }

    public static final o b(b bVar) {
        h.f(bVar, "<this>");
        w wVar = bVar.a().f6422c;
        if (wVar != null) {
            return wVar.f4888h;
        }
        throw new IllegalStateException("Cannot obtain node coordinator. Is the Modifier.Node attached?".toString());
    }
}
