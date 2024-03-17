package cn.jpush.android.f;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class a {
    private static Map<b, cn.jpush.android.e.a> a = new ConcurrentHashMap();

    public static cn.jpush.android.e.a a(b bVar) {
        return a.get(bVar);
    }

    public static void a(b bVar, cn.jpush.android.e.a aVar) {
        if (aVar != null) {
            a.put(bVar, aVar);
        }
    }

    public static void b(b bVar) {
        a.remove(bVar);
    }
}
