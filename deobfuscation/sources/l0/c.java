package l0;

/* loaded from: classes.dex */
public final class c {
    public static final w a(b bVar, int i7) {
        r5.h.f(bVar, "$this$requireCoordinator");
        w wVar = bVar.a().f6422c;
        r5.h.c(wVar);
        if (wVar.q() == bVar && a0.b(i7)) {
            wVar.getClass();
            r5.h.c(null);
            return null;
        }
        return wVar;
    }

    public static final o b(b bVar) {
        r5.h.f(bVar, "<this>");
        w wVar = bVar.a().f6422c;
        if (wVar != null) {
            return wVar.f4888h;
        }
        throw new IllegalStateException("Cannot obtain node coordinator. Is the Modifier.Node attached?".toString());
    }
}
