package com.hunantv.imgo.yaml.events;

import j.l.a.d0.i.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class Event {
    private final a a;
    private final a b;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ID {
        Alias,
        DocumentEnd,
        DocumentStart,
        MappingEnd,
        MappingStart,
        Scalar,
        SequenceEnd,
        SequenceStart,
        StreamEnd,
        StreamStart
    }

    public Event(a aVar, a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public String a() {
        return "";
    }

    public a b() {
        return this.b;
    }

    public a c() {
        return this.a;
    }

    public abstract boolean d(ID id);

    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return "<" + getClass().getName() + "(" + a() + ")>";
    }
}
