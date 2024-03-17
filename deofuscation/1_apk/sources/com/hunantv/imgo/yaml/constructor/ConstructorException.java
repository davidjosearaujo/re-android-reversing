package com.hunantv.imgo.yaml.constructor;

import com.hunantv.imgo.yaml.error.MarkedYAMLException;
import j.l.a.d0.i.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ConstructorException extends MarkedYAMLException {
    private static final long serialVersionUID = -8816339931365239910L;

    public ConstructorException(String str, a aVar, String str2, a aVar2, Throwable th) {
        super(str, aVar, str2, aVar2, th);
    }

    public ConstructorException(String str, a aVar, String str2, a aVar2) {
        this(str, aVar, str2, aVar2, null);
    }
}
