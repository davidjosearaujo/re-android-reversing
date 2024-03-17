package com.alibaba.fastjson.parser;

import com.alibaba.android.arouter.utils.Consts;
import com.hunantv.oversea.channel.dynamic.data.ParamParser;
import java.lang.reflect.Type;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ParseContext {
    public final Object fieldName;
    public final int level;
    public Object object;
    public final ParseContext parent;
    private transient String path;
    public Type type;

    public ParseContext(ParseContext parseContext, Object obj, Object obj2) {
        this.parent = parseContext;
        this.object = obj;
        this.fieldName = obj2;
        this.level = parseContext == null ? 0 : parseContext.level + 1;
    }

    public String toString() {
        if (this.path == null) {
            if (this.parent == null) {
                this.path = ParamParser.m;
            } else if (this.fieldName instanceof Integer) {
                this.path = this.parent.toString() + "[" + this.fieldName + "]";
            } else {
                this.path = this.parent.toString() + Consts.DOT + this.fieldName;
            }
        }
        return this.path;
    }
}
