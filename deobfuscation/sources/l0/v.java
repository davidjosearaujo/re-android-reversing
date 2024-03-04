package l0;

import x.a;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a */
    public final h f4883a;

    /* renamed from: b */
    public w f4884b;

    /* renamed from: c */
    public final j0 f4885c;

    /* renamed from: d */
    public a.b f4886d;

    public v(o oVar) {
        r5.h.f(oVar, "layoutNode");
        h hVar = new h(oVar);
        this.f4883a = hVar;
        this.f4884b = hVar;
        j0 j0Var = hVar.f4855n;
        this.f4885c = j0Var;
        this.f4886d = j0Var;
    }

    public final boolean a(int i7) {
        return (this.f4886d.f6421b & i7) != 0;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("[");
        a.b bVar = this.f4886d;
        if (bVar != this.f4885c) {
            while (bVar != null && bVar != this.f4885c) {
                d7.append(String.valueOf(bVar));
                bVar.getClass();
                if (this.f4885c != null) {
                    d7.append(",");
                    bVar.getClass();
                    bVar = null;
                }
            }
            String sb = d7.toString();
            r5.h.e(sb, "StringBuilder().apply(builderAction).toString()");
            return sb;
        }
        d7.append("]");
        String sb2 = d7.toString();
        r5.h.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
