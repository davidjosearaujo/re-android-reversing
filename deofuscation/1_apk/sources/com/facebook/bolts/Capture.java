package com.facebook.bolts;

@Deprecated
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class Capture<T> {
    private T value;

    public Capture() {
    }

    public T get() {
        return this.value;
    }

    public void set(T t) {
        this.value = t;
    }

    public Capture(T t) {
        this.value = t;
    }
}
