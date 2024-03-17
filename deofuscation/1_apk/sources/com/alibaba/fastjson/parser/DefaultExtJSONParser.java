package com.alibaba.fastjson.parser;

@Deprecated
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DefaultExtJSONParser extends DefaultJSONParser {
    public DefaultExtJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance());
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig) {
        super(str, parserConfig);
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig, int i) {
        super(str, parserConfig, i);
    }

    public DefaultExtJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        super(cArr, i, parserConfig, i2);
    }
}
