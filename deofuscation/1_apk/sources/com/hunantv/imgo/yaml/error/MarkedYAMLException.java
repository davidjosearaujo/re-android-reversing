package com.hunantv.imgo.yaml.error;

import j.l.a.d0.i.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MarkedYAMLException extends YAMLException {
    private static final long serialVersionUID = -9119388488683035101L;
    private String context;
    private a contextMark;
    private String note;
    private String problem;
    private a problemMark;

    public MarkedYAMLException(String str, a aVar, String str2, a aVar2, String str3) {
        this(str, aVar, str2, aVar2, str3, null);
    }

    public String getContext() {
        return this.context;
    }

    public a getContextMark() {
        return this.contextMark;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return toString();
    }

    public String getProblem() {
        return this.problem;
    }

    public a getProblemMark() {
        return this.problemMark;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.context;
        if (str != null) {
            sb.append(str);
            sb.append("\n");
        }
        a aVar = this.contextMark;
        if (aVar != null && (this.problem == null || this.problemMark == null || aVar.d().equals(this.problemMark.d()) || this.contextMark.c() != this.problemMark.c() || this.contextMark.a() != this.problemMark.a())) {
            sb.append(this.contextMark.toString());
            sb.append("\n");
        }
        String str2 = this.problem;
        if (str2 != null) {
            sb.append(str2);
            sb.append("\n");
        }
        a aVar2 = this.problemMark;
        if (aVar2 != null) {
            sb.append(aVar2.toString());
            sb.append("\n");
        }
        String str3 = this.note;
        if (str3 != null) {
            sb.append(str3);
            sb.append("\n");
        }
        return sb.toString();
    }

    public MarkedYAMLException(String str, a aVar, String str2, a aVar2, String str3, Throwable th) {
        super(str + "; " + str2 + "; " + aVar2, th);
        this.context = str;
        this.contextMark = aVar;
        this.problem = str2;
        this.problemMark = aVar2;
        this.note = str3;
    }

    public MarkedYAMLException(String str, a aVar, String str2, a aVar2) {
        this(str, aVar, str2, aVar2, null, null);
    }

    public MarkedYAMLException(String str, a aVar, String str2, a aVar2, Throwable th) {
        this(str, aVar, str2, aVar2, null, th);
    }
}
