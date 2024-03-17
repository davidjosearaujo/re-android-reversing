package com.hunantv.oversea.channel.dynamic.data;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.c.o1.t;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class KeyValue {
    private static final /* synthetic */ c.b e = null;
    private String a;
    private String b = "";
    private String c;
    private JsonObject d;

    static {
        b();
    }

    public KeyValue(String str, JsonElement jsonElement) {
        this.a = str;
        parse(str, jsonElement);
    }

    private static /* synthetic */ void b() {
        e eVar = new e("KeyValue.java", KeyValue.class);
        e = eVar.H("method-execution", eVar.E("2", "parse", "com.hunantv.oversea.channel.dynamic.data.KeyValue", "java.lang.String:com.google.gson.JsonElement", "key:json", "", "void"), 32);
    }

    public static final /* synthetic */ void f(KeyValue keyValue, String str, JsonElement jsonElement, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith(ParamParser.m)) {
            keyValue.b = str;
        } else if (jsonElement == null || !jsonElement.isJsonObject()) {
        } else {
            keyValue.d = jsonElement.getAsJsonObject();
            if (str.startsWith(ParamParser.m) && str.length() > 1) {
                str = str.substring(1);
            }
            keyValue.c = str;
            if (str.contains(Consts.DOT)) {
                String[] split = str.split("\\.");
                if (split.length > 1) {
                    keyValue.c = split[1];
                    JsonElement jsonElement2 = keyValue.d.get(split[0]);
                    if (jsonElement2 == null || !jsonElement2.isJsonObject()) {
                        return;
                    }
                    JsonObject asJsonObject = jsonElement2.getAsJsonObject();
                    keyValue.d = asJsonObject;
                    JsonElement jsonElement3 = asJsonObject.get(split[1]);
                    if (jsonElement3 == null || !jsonElement3.isJsonPrimitive()) {
                        return;
                    }
                    keyValue.b = jsonElement3.getAsString();
                    return;
                }
                return;
            }
            JsonElement jsonElement4 = keyValue.d.get(str);
            if (jsonElement4 == null || !jsonElement4.isJsonPrimitive()) {
                return;
            }
            keyValue.b = jsonElement4.getAsString();
        }
    }

    @WithTryCatchRuntime
    private void parse(String str, JsonElement jsonElement) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new t(new Object[]{this, str, jsonElement, e.x(e, this, this, str, jsonElement)}).e(69648));
    }

    public void a(String str) {
        if (this.d == null || TextUtils.isEmpty(this.c) || !this.d.has(this.c)) {
            return;
        }
        this.d.addProperty(this.c, str);
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return TextUtils.isEmpty(this.a);
    }
}
