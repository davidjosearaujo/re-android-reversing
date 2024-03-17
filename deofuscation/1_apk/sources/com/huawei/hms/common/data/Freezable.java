package com.huawei.hms.common.data;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface Freezable<T> {
    T freeze();

    boolean isDataValid();
}
