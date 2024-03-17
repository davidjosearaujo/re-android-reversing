package com.alibaba.android.arouter.base;

import java.util.TreeMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class UniqueKeyTreeMap<K, V> extends TreeMap<K, V> {
    private String tipText;

    public UniqueKeyTreeMap(String str) {
        this.tipText = str;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (!containsKey(k)) {
            return (V) super.put(k, v);
        }
        throw new RuntimeException(String.format(this.tipText, k));
    }
}
