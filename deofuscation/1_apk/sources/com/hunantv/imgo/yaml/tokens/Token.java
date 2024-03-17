package com.hunantv.imgo.yaml.tokens;

import com.hunantv.imgo.yaml.error.YAMLException;
import j.l.a.d0.i.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class Token {
    private final a a;
    private final a b;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ID {
        Alias,
        Anchor,
        BlockEnd,
        BlockEntry,
        BlockMappingStart,
        BlockSequenceStart,
        Directive,
        DocumentEnd,
        DocumentStart,
        FlowEntry,
        FlowMappingEnd,
        FlowMappingStart,
        FlowSequenceEnd,
        FlowSequenceStart,
        Key,
        Scalar,
        StreamEnd,
        StreamStart,
        Tag,
        Value,
        Whitespace,
        Comment,
        Error
    }

    public Token(a aVar, a aVar2) {
        if (aVar != null && aVar2 != null) {
            this.a = aVar;
            this.b = aVar2;
            return;
        }
        throw new YAMLException("Token requires marks.");
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

    public abstract ID d();

    public boolean equals(Object obj) {
        if (obj instanceof Token) {
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
