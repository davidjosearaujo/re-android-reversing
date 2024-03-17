package cn.jiguang.common.app.helper;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static volatile a a;
    private List<String> b;
    private AtomicLong c = new AtomicLong(0);
    private AtomicLong d = new AtomicLong(0);
    private HashMap<String, Object> e = null;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private boolean b() {
        return System.currentTimeMillis() - this.c.get() >= 108000000;
    }

    private void c() {
        this.c.set(System.currentTimeMillis());
    }

    public synchronized List<String> a(Context context) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        if (this.b.size() > 0 && !b()) {
            return this.b;
        }
        ArrayList arrayList = new ArrayList();
        if (b.a(context, false, arrayList) instanceof List) {
            c();
            this.b.clear();
            this.b.addAll(arrayList);
        }
        return this.b;
    }
}
