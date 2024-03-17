package com.hunantv.oversea.me.ui.scan.parser;

import android.content.Context;
import androidx.annotation.NonNull;
import com.hunantv.oversea.me.ui.scan.bean.ParseInfo;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.k.l.f.b.a;
import j.l.c.k.l.f.b.d;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class CaptureParser {
    private static final /* synthetic */ c.b c = null;
    private CaptureParser a;
    public Context b;

    static {
        a();
    }

    public CaptureParser(@NonNull Context context) {
        this.b = context;
        this.a = b(context);
    }

    private static /* synthetic */ void a() {
        e eVar = new e("CaptureParser.java", CaptureParser.class);
        c = eVar.H("method-execution", eVar.E("1", "parse", "com.hunantv.oversea.me.ui.scan.parser.CaptureParser", "com.hunantv.oversea.me.ui.scan.bean.ParseInfo:com.hunantv.oversea.me.ui.scan.parser.ParseListener", "parseInfo:parseListener", "", "boolean"), 37);
    }

    public static final /* synthetic */ boolean c(CaptureParser captureParser, ParseInfo parseInfo, d dVar, c cVar) {
        CaptureParser captureParser2 = captureParser.a;
        if (captureParser2 != null ? captureParser2.parse(parseInfo, dVar) : false) {
            return true;
        }
        return captureParser.parseInside(parseInfo, dVar);
    }

    public abstract CaptureParser b(Context context);

    @WithTryCatchRuntime
    public boolean parse(ParseInfo parseInfo, d dVar) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a(new Object[]{this, parseInfo, dVar, e.x(c, this, this, parseInfo, dVar)}).e(69648)));
    }

    @WithTryCatchRuntime
    public abstract boolean parseInside(ParseInfo parseInfo, d dVar);
}
