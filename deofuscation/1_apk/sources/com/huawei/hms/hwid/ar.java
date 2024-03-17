package com.huawei.hms.hwid;

import java.util.HashSet;
import java.util.Set;

/* compiled from: HiAnalyticsUtil.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ar {
    private static final Set<Integer> a;

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        hashSet.add(0);
    }

    public static int a(int i) {
        return a.contains(Integer.valueOf(i)) ? 0 : 1;
    }
}
