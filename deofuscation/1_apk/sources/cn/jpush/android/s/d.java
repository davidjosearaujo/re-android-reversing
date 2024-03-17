package cn.jpush.android.s;

import cn.jpush.android.r.l;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    public static c a(l lVar, cn.jpush.android.u.e eVar) {
        if (eVar != null) {
            int o = eVar.o();
            if (o == 1) {
                return ((cn.jpush.android.u.b) eVar).a() ? new b(lVar, eVar) : new a(lVar, eVar);
            } else if (o != 2) {
                if (o != 3) {
                    return null;
                }
                return new e(lVar, eVar);
            } else {
                return new f(lVar, eVar);
            }
        }
        return null;
    }
}
