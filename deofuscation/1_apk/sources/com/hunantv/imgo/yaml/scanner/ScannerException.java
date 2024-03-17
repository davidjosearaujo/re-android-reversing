package com.hunantv.imgo.yaml.scanner;

import com.hunantv.imgo.yaml.error.MarkedYAMLException;
import j.l.a.d0.i.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ScannerException extends MarkedYAMLException {
    private static final long serialVersionUID = 4782293188600445954L;

    public ScannerException(String str, a aVar, String str2, a aVar2, String str3) {
        super(str, aVar, str2, aVar2, str3);
    }

    public ScannerException(String str, a aVar, String str2, a aVar2) {
        this(str, aVar, str2, aVar2, null);
    }
}
