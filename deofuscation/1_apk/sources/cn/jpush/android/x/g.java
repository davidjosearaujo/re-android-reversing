package cn.jpush.android.x;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g {
    private static Queue<Integer> a = new ConcurrentLinkedQueue();

    public static int a() {
        if (a.size() > 0) {
            return a.poll().intValue();
        }
        return 0;
    }

    public static boolean a(int i) {
        return a.offer(Integer.valueOf(i));
    }

    public static int b() {
        return a.size();
    }

    public static boolean b(int i) {
        return a.contains(Integer.valueOf(i));
    }
}
