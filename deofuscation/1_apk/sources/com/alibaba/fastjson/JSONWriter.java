package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JSONWriter implements Closeable, Flushable {
    private JSONStreamContext context;
    private JSONSerializer serializer;
    private SerializeWriter writer;

    public JSONWriter(Writer writer) {
        SerializeWriter serializeWriter = new SerializeWriter(writer);
        this.writer = serializeWriter;
        this.serializer = new JSONSerializer(serializeWriter);
    }

    private void afterWriter() {
        int i;
        JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext == null) {
            return;
        }
        switch (jSONStreamContext.state) {
            case 1001:
            case JSONStreamContext.PropertyValue /* 1003 */:
                i = 1002;
                break;
            case 1002:
                i = JSONStreamContext.PropertyValue;
                break;
            case JSONStreamContext.StartArray /* 1004 */:
                i = JSONStreamContext.ArrayValue;
                break;
            default:
                i = -1;
                break;
        }
        if (i != -1) {
            jSONStreamContext.state = i;
        }
    }

    private void beforeWrite() {
        JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext == null) {
            return;
        }
        int i = jSONStreamContext.state;
        if (i == 1002) {
            this.writer.write(58);
        } else if (i == 1003) {
            this.writer.write(44);
        } else if (i != 1005) {
        } else {
            this.writer.write(44);
        }
    }

    private void beginStructure() {
        int i = this.context.state;
        switch (i) {
            case 1001:
            case JSONStreamContext.StartArray /* 1004 */:
                return;
            case 1002:
                this.writer.write(58);
                return;
            case JSONStreamContext.PropertyValue /* 1003 */:
            default:
                throw new JSONException("illegal state : " + i);
            case JSONStreamContext.ArrayValue /* 1005 */:
                this.writer.write(44);
                return;
        }
    }

    private void endStructure() {
        JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext == null) {
            return;
        }
        int i = jSONStreamContext.state;
        int i2 = i != 1001 ? i != 1002 ? i != 1004 ? -1 : JSONStreamContext.ArrayValue : JSONStreamContext.PropertyValue : 1002;
        if (i2 != -1) {
            jSONStreamContext.state = i2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.writer.close();
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        this.writer.config(serializerFeature, z);
    }

    public void endArray() {
        this.writer.write(93);
        endStructure();
    }

    public void endObject() {
        this.writer.write(125);
        endStructure();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.writer.flush();
    }

    public void startArray() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new JSONStreamContext(this.context, JSONStreamContext.StartArray);
        this.writer.write(91);
    }

    public void startObject() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new JSONStreamContext(this.context, 1001);
        this.writer.write(123);
    }

    @Deprecated
    public void writeEndArray() {
        endArray();
    }

    @Deprecated
    public void writeEndObject() {
        endObject();
    }

    public void writeKey(String str) {
        writeObject(str);
    }

    public void writeObject(String str) {
        beforeWrite();
        this.serializer.write(str);
        afterWriter();
    }

    @Deprecated
    public void writeStartArray() {
        startArray();
    }

    @Deprecated
    public void writeStartObject() {
        startObject();
    }

    public void writeValue(Object obj) {
        writeObject(obj);
    }

    public void writeObject(Object obj) {
        beforeWrite();
        this.serializer.write(obj);
        afterWriter();
    }
}
