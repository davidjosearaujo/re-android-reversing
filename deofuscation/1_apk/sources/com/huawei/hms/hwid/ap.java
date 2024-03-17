package com.huawei.hms.hwid;

import java.util.Collection;

/* compiled from: CollectionUtil.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ap {
    public static Boolean a(Collection collection) {
        if (collection != null && collection.size() != 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean b(Collection collection) {
        return Boolean.valueOf(!a(collection).booleanValue());
    }
}
