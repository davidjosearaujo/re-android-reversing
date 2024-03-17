package com.hunantv.oversea.channel.dynamic.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.JsonElement;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.hunantv.mpdt.data.EventClickData;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.v;
import j.l.c.c.c.o1.a0;
import j.l.c.c.c.o1.b0;
import j.l.c.c.c.o1.c0;
import j.l.c.c.c.o1.d0;
import j.l.c.c.c.o1.z;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ParamParser {
    private static final String g = "ParamParser";
    private static final String h = ";";
    private static final String i = "&";
    private static final String j = "=";
    private static final String k = ",";
    private static final String l = "-";
    public static final String m = "$";
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private static final /* synthetic */ c.b p = null;
    private static final /* synthetic */ c.b q = null;
    private static final /* synthetic */ c.b r = null;
    private String a;
    private String b;
    private JsonElement c;
    private HashMap<String, String> d = new HashMap<>();
    private HashMap<String, String> e = new HashMap<>();
    private HashMap<String, KeyValue> f = new HashMap<>();

    static {
        b();
    }

    public ParamParser(String str, JsonElement jsonElement) {
        this.b = str;
        this.a = str;
        this.c = jsonElement;
        parse();
    }

    private static /* synthetic */ void b() {
        e eVar = new e("ParamParser.java", ParamParser.class);
        n = eVar.H("method-execution", eVar.E("2", "parse", "com.hunantv.oversea.channel.dynamic.data.ParamParser", "", "", "", "void"), 60);
        o = eVar.H("method-execution", eVar.E("2", "parseParam", "com.hunantv.oversea.channel.dynamic.data.ParamParser", "java.lang.String", RemoteMessageConst.MessageBody.PARAM, "", "void"), 116);
        p = eVar.H("method-execution", eVar.E("2", "parsePath", "com.hunantv.oversea.channel.dynamic.data.ParamParser", "java.lang.String", "path", "", "void"), (int) EventClickData.u.L0);
        q = eVar.H("method-execution", eVar.E("2", "parseKeyValue", "com.hunantv.oversea.channel.dynamic.data.ParamParser", "java.lang.String", SDKConstants.PARAM_KEY, "", "void"), (int) EventClickData.u.C1);
        r = eVar.H("method-execution", eVar.E("2", "parseResultMap", "com.hunantv.oversea.channel.dynamic.data.ParamParser", "java.lang.String", RemoteMessageConst.MessageBody.PARAM, "", "void"), (int) Opcodes.GOTO);
    }

    public static final /* synthetic */ void h(ParamParser paramParser, String str, c cVar) {
        if (TextUtils.isEmpty(str) || !str.startsWith(m) || paramParser.f.containsKey(str)) {
            return;
        }
        paramParser.f.put(str, new KeyValue(str, paramParser.c));
    }

    public static final /* synthetic */ void i(ParamParser paramParser, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.contains("=")) {
            String[] split = str.split("=");
            if (split.length > 1) {
                str = split[1];
                paramParser.d.put(split[0], split[1]);
            }
        }
        if (str.contains(k)) {
            for (String str2 : str.split(k)) {
                paramParser.parsePath(str2);
            }
            return;
        }
        paramParser.parsePath(str);
    }

    public static final /* synthetic */ void j(ParamParser paramParser, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.contains(l)) {
            for (String str2 : str.split(l)) {
                paramParser.parseKeyValue(str2);
            }
            return;
        }
        paramParser.parseKeyValue(str);
    }

    public static final /* synthetic */ void k(ParamParser paramParser, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.contains("=")) {
            String[] split = str.split("=");
            if (split.length > 1) {
                paramParser.e.put(split[0], split[1]);
                return;
            } else {
                paramParser.e.put(split[0], "");
                return;
            }
        }
        paramParser.e.put(str, "");
    }

    public static final /* synthetic */ void l(ParamParser paramParser, c cVar) {
        String str;
        if (TextUtils.isEmpty(paramParser.a)) {
            return;
        }
        int i2 = 0;
        if (paramParser.a.contains(";")) {
            for (String str2 : paramParser.a.split(";")) {
                paramParser.parseParam(str2);
            }
        } else if (paramParser.a.contains("&")) {
            for (String str3 : paramParser.a.split("&")) {
                paramParser.parseParam(str3);
            }
        } else {
            paramParser.parseParam(paramParser.a);
        }
        HashMap<String, KeyValue> hashMap = paramParser.f;
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, KeyValue> entry : paramParser.f.entrySet()) {
                if (entry != null) {
                    KeyValue value = entry.getValue();
                    if (!value.e() && !TextUtils.isEmpty(paramParser.b)) {
                        try {
                            str = URLEncoder.encode(value.d(), "UTF-8");
                        } catch (Exception e) {
                            e.printStackTrace();
                            str = "";
                        }
                        paramParser.b = paramParser.b.replace(value.c(), str);
                    }
                }
            }
        }
        String trim = paramParser.b.trim();
        paramParser.b = trim;
        if (trim.contains(";")) {
            String[] split = paramParser.b.split(";");
            while (i2 < split.length) {
                paramParser.parseResultMap(split[i2]);
                i2++;
            }
        } else if (paramParser.b.contains("&")) {
            String[] split2 = paramParser.b.split("&");
            while (i2 < split2.length) {
                paramParser.parseResultMap(split2[i2]);
                i2++;
            }
        } else {
            paramParser.parseResultMap(paramParser.b);
        }
        v.g(g, "origin: " + paramParser.a);
        v.g(g, "result: " + paramParser.b);
    }

    @WithTryCatchRuntime
    private void parse() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new z(new Object[]{this, e.v(n, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    private void parseKeyValue(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new c0(new Object[]{this, str, e.w(q, this, this, str)}).e(69648));
    }

    @WithTryCatchRuntime
    private void parseParam(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a0(new Object[]{this, str, e.w(o, this, this, str)}).e(69648));
    }

    @WithTryCatchRuntime
    private void parsePath(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b0(new Object[]{this, str, e.w(p, this, this, str)}).e(69648));
    }

    @WithTryCatchRuntime
    private void parseResultMap(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d0(new Object[]{this, str, e.w(r, this, this, str)}).e(69648));
    }

    public void a(String str, String str2) {
        KeyValue keyValue;
        if (TextUtils.isEmpty(str) || (keyValue = this.f.get(str)) == null) {
            return;
        }
        keyValue.a(str2);
    }

    public JsonElement c() {
        return this.c;
    }

    public String d() {
        String str = this.a;
        return str == null ? "" : str;
    }

    @NonNull
    public Map<String, String> e() {
        return this.d;
    }

    public String f() {
        String str = this.b;
        return str == null ? "" : str;
    }

    @NonNull
    public Map<String, String> g() {
        return this.e;
    }

    @NonNull
    public String toString() {
        String str = this.b;
        return str == null ? "" : str;
    }
}
