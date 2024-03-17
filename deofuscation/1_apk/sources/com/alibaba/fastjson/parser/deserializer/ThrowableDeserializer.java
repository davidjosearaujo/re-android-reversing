package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?>[] constructors;
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ee, code lost:
        if (r14 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f0, code lost:
        r15 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00fc, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00fe, code lost:
        r15 = (T) createException(r5, r3, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0102, code lost:
        if (r15 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0104, code lost:
        r15 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0109, code lost:
        if (r6 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x010b, code lost:
        ((java.lang.Throwable) r15).setStackTrace(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x010e, code lost:
        if (r0 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0110, code lost:
        if (r14 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0114, code lost:
        if (r14 != r12.clazz) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0116, code lost:
        r2 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0118, code lost:
        r13 = r13.getConfig().getDeserializer(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0122, code lost:
        if ((r13 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0124, code lost:
        r2 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0127, code lost:
        if (r2 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0129, code lost:
        r13 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0135, code lost:
        if (r13.hasNext() == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0137, code lost:
        r14 = (java.util.Map.Entry) r13.next();
        r14 = r14.getValue();
        r0 = r2.getFieldDeserializer((java.lang.String) r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x014b, code lost:
        if (r0 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014d, code lost:
        r0.setValue(r15, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0151, code lost:
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0152, code lost:
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x015a, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0176, code lost:
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r14.getName());
     */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r13, java.lang.reflect.Type r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
