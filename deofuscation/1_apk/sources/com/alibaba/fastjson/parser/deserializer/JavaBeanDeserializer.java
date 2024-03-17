package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    public final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private Map<String, FieldDeserializer> fieldDeserializerMap;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    public final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    private Object createFactoryInstance(ParserConfig parserConfig, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return this.beanInfo.factoryMethod.invoke(null, obj);
    }

    public static JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public static boolean isSetFlag(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i2 = i / 32;
        int i3 = i % 32;
        if (i2 < iArr.length) {
            if (((1 << i3) & iArr[i2]) != 0) {
                return true;
            }
        }
        return false;
    }

    public static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            } else if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
            return;
        }
        jSONLexerBase.nextToken(16);
    }

    public void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        FieldInfo[] fieldInfoArr;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        Object obj = null;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        Method method = javaBeanInfo.factoryMethod;
        if (method == null || javaBeanInfo.defaultConstructorParameterSize <= 0) {
            try {
                if (javaBeanInfo.defaultConstructorParameterSize != 0) {
                    ParseContext context = defaultJSONParser.getContext();
                    if (context != null && context.object != null) {
                        if (type instanceof Class) {
                            String name = ((Class) type).getName();
                            String substring = name.substring(0, name.lastIndexOf(36));
                            Object obj2 = context.object;
                            String name2 = obj2.getClass().getName();
                            if (!name2.equals(substring)) {
                                ParseContext parseContext = context.parent;
                                if (parseContext == null || parseContext.object == null || !("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2))) {
                                    obj = obj2;
                                } else if (parseContext.object.getClass().getName().equals(substring)) {
                                    obj = parseContext.object;
                                }
                                obj2 = obj;
                            }
                            if (obj2 != null && (!(obj2 instanceof Collection) || !((Collection) obj2).isEmpty())) {
                                newInstance = constructor.newInstance(obj2);
                            } else {
                                throw new JSONException("can't create non-static inner class instance.");
                            }
                        } else {
                            throw new JSONException("can't create non-static inner class instance.");
                        }
                    } else {
                        throw new JSONException("can't create non-static inner class instance.");
                    }
                } else if (constructor != null) {
                    newInstance = constructor.newInstance(new Object[0]);
                } else {
                    newInstance = method.invoke(null, new Object[0]);
                }
                if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            try {
                                fieldInfo.set(newInstance, "");
                            } catch (Exception e) {
                                throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                            }
                        }
                    }
                }
                return newInstance;
            } catch (JSONException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
            }
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> scanEnum;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            String scanTypeName = jSONLexer.scanTypeName(defaultJSONParser.symbolTable);
            if (scanTypeName != null) {
                ObjectDeserializer seeAlso = getSeeAlso(defaultJSONParser.getConfig(), this.beanInfo, scanTypeName);
                if (seeAlso == null) {
                    seeAlso = defaultJSONParser.getConfig().getDeserializer(defaultJSONParser.getConfig().checkAutoType(scanTypeName, TypeUtils.getClass(type), jSONLexer.getFeatures()));
                }
                if (seeAlso instanceof JavaBeanDeserializer) {
                    return (T) ((JavaBeanDeserializer) seeAlso).deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                }
            }
            T t = (T) createInstance(defaultJSONParser, type);
            int i = 0;
            int length = this.sortedFieldDeserializers.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                char c = i == length + (-1) ? ']' : ',';
                FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
                Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c));
                } else if (cls == String.class) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c));
                } else if (cls == Long.TYPE) {
                    fieldDeserializer.setValue(t, jSONLexer.scanLong(c));
                } else if (cls.isEnum()) {
                    char current = jSONLexer.getCurrent();
                    if (current == '\"' || current == 'n') {
                        scanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                    } else if (current >= '0' && current <= '9') {
                        scanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                    } else {
                        scanEnum = scanEnum(jSONLexer, c);
                    }
                    fieldDeserializer.setValue(t, scanEnum);
                } else if (cls == Boolean.TYPE) {
                    fieldDeserializer.setValue(t, jSONLexer.scanBoolean(c));
                } else if (cls == Float.TYPE) {
                    fieldDeserializer.setValue(t, Float.valueOf(jSONLexer.scanFloat(c)));
                } else if (cls == Double.TYPE) {
                    fieldDeserializer.setValue(t, Double.valueOf(jSONLexer.scanDouble(c)));
                } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                    fieldDeserializer.setValue(t, new Date(jSONLexer.scanLong(c)));
                } else if (cls == BigDecimal.class) {
                    fieldDeserializer.setValue(t, jSONLexer.scanDecimal(c));
                } else {
                    jSONLexer.nextToken(14);
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldInfo.fieldType, fieldInfo.name));
                    if (jSONLexer.token() == 15) {
                        break;
                    }
                    check(jSONLexer, c == ']' ? 15 : 16);
                }
                i++;
            }
            jSONLexer.nextToken(16);
            return t;
        }
        throw new JSONException("error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    public Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        if (str == null) {
            return null;
        }
        Map<String, FieldDeserializer> map = this.fieldDeserializerMap;
        if (map == null || (fieldDeserializer = map.get(str)) == null) {
            int i = 0;
            int length = this.sortedFieldDeserializers.length - 1;
            while (i <= length) {
                int i2 = (i + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i = i2 + 1;
                } else if (compareTo <= 0) {
                    if (isSetFlag(i2, iArr)) {
                        return null;
                    }
                    return this.sortedFieldDeserializers[i2];
                } else {
                    length = i2 - 1;
                }
            }
            Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
            if (map2 != null) {
                return map2.get(str);
            }
            return null;
        }
        return fieldDeserializer;
    }

    /* JADX WARN: Removed duplicated region for block: B:198:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x01fc  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean parseField(com.alibaba.fastjson.parser.DefaultJSONParser r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map<java.lang.String, java.lang.Object> r26, int[] r27) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseField(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanEnumSymbol = jSONLexerBase.scanEnumSymbol(cArr);
        if (jSONLexerBase.matchStat > 0) {
            Enum enumByHashCode = enumDeserializer.getEnumByHashCode(scanEnumSymbol);
            if (enumByHashCode == null) {
                if (scanEnumSymbol == -3750763034362895579L) {
                    return null;
                }
                if (jSONLexerBase.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                    throw new JSONException("not match enum value, " + enumDeserializer.enumClass);
                }
            }
            return enumByHashCode;
        }
        return null;
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        boolean z;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            long fnv1a_64_lower = TypeUtils.fnv1a_64_lower(str);
            int i = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i2 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i2 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i2] = TypeUtils.fnv1a_64_lower(fieldDeserializerArr[i2].fieldInfo.name);
                    i2++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv1a_64_lower);
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s = this.smartMatchHashArrayMapping[binarySearch];
                if (s != -1 && !isSetFlag(s, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s];
                }
            }
            if (fieldDeserializer != null) {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class<?> cls = fieldInfo.fieldClass;
                if (z && cls != Boolean.TYPE && cls != Boolean.class) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:1077:0x0361, code lost:
        if (r5 == (-2)) goto L610;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1096:0x03c1, code lost:
        if (r13.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1163:0x04db, code lost:
        r12 = r29;
        r1 = getSeeAlso(r12, r34.beanInfo, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1164:0x04e3, code lost:
        if (r1 != null) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1165:0x04e5, code lost:
        r7 = r12.checkAutoType(r0, com.alibaba.fastjson.util.TypeUtils.getClass(r36), r13.getFeatures());
        r1 = r35.getConfig().getDeserializer(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1167:0x04fa, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1168:0x04fb, code lost:
        r2 = (T) r1.deserialze(r35, r7, r37);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1169:0x0501, code lost:
        if ((r1 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1170:0x0503, code lost:
        r1 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1171:0x0505, code lost:
        if (r3 == null) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1172:0x0507, code lost:
        r1.getFieldDeserializer(r3).setValue((java.lang.Object) r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1173:0x050e, code lost:
        if (r4 == null) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1174:0x0510, code lost:
        r4.object = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1175:0x0514, code lost:
        r35.setContext(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1176:0x0517, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1181:0x0527, code lost:
        r7 = r4;
        r32 = r6;
        r1 = r21;
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1248:0x064e, code lost:
        r13.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1262:0x0680, code lost:
        r13.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1263:0x0683, code lost:
        r1 = r19;
        r7 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1264:0x0687, code lost:
        if (r15 != null) goto L486;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1265:0x0689, code lost:
        if (r1 != null) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1266:0x068b, code lost:
        r1 = (T) createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r35, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1267:0x068f, code lost:
        if (r7 != null) goto L482;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1268:0x0691, code lost:
        r3 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1269:0x0693, code lost:
        r7 = r35.setContext(r3, r1, r37);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1271:0x0698, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1272:0x0699, code lost:
        r15 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1273:0x069c, code lost:
        r3 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1274:0x069e, code lost:
        if (r7 == null) goto L477;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1275:0x06a0, code lost:
        r7.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1276:0x06a2, code lost:
        r35.setContext(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1277:0x06a5, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1278:0x06a6, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1280:0x06a8, code lost:
        r3 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1281:0x06aa, code lost:
        r2 = r34.beanInfo;
        r4 = r2.creatorConstructorParameters;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1283:0x06b0, code lost:
        if (r4 == null) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1284:0x06b2, code lost:
        r2 = new java.lang.Object[r4.length];
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1286:0x06b7, code lost:
        if (r6 >= r4.length) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1287:0x06b9, code lost:
        r10 = r1.remove(r4[r6]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1288:0x06bf, code lost:
        if (r10 != null) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1289:0x06c1, code lost:
        r11 = r34.beanInfo;
        r12 = r11.creatorConstructorParameterTypes[r6];
        r11 = r11.fields[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:1290:0x06cd, code lost:
        if (r12 != java.lang.Byte.TYPE) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1291:0x06cf, code lost:
        r10 = (byte) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1292:0x06d4, code lost:
        r13 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1294:0x06db, code lost:
        if (r12 != java.lang.Short.TYPE) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1295:0x06dd, code lost:
        r10 = (short) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1297:0x06e4, code lost:
        if (r12 != java.lang.Integer.TYPE) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1298:0x06e6, code lost:
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1300:0x06ed, code lost:
        if (r12 != java.lang.Long.TYPE) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1301:0x06ef, code lost:
        r10 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1303:0x06f6, code lost:
        if (r12 != java.lang.Float.TYPE) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1304:0x06f8, code lost:
        r10 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1306:0x06ff, code lost:
        if (r12 != java.lang.Double.TYPE) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1307:0x0701, code lost:
        r10 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1309:0x0708, code lost:
        if (r12 != java.lang.Boolean.TYPE) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1310:0x070a, code lost:
        r10 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1311:0x070d, code lost:
        r13 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1312:0x070f, code lost:
        if (r12 != r13) goto L298;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1314:0x0718, code lost:
        if ((r11.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1315:0x071a, code lost:
        r10 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1316:0x071c, code lost:
        r13 = r31;
        r11 = r34.beanInfo.creatorConstructorParameterTypes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1317:0x0722, code lost:
        if (r11 == null) goto L321;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1319:0x0725, code lost:
        if (r6 >= r11.length) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1320:0x0727, code lost:
        r11 = r11[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:1321:0x072b, code lost:
        if ((r11 instanceof java.lang.Class) == false) goto L319;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1322:0x072d, code lost:
        r11 = (java.lang.Class) r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1323:0x0733, code lost:
        if (r11.isInstance(r10) != false) goto L318;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1325:0x0737, code lost:
        if ((r10 instanceof java.util.List) == false) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1326:0x0739, code lost:
        r12 = (java.util.List) r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1327:0x0740, code lost:
        if (r12.size() != r0) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1329:0x074b, code lost:
        if (r11.isInstance(r12.get(0)) == false) goto L315;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1330:0x074d, code lost:
        r10 = r12.get(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1331:0x0751, code lost:
        r2[r6] = r10;
        r6 = r6 + 1;
        r31 = r13;
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1332:0x075a, code lost:
        r13 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1333:0x075e, code lost:
        r13 = r31;
        r0 = r2.fields;
        r2 = r0.length;
        r6 = new java.lang.Object[r2];
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1334:0x0766, code lost:
        if (r10 >= r2) goto L466;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1335:0x0768, code lost:
        r11 = r0[r10];
        r12 = r1.get(r11.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1336:0x0770, code lost:
        if (r12 != null) goto L464;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1337:0x0772, code lost:
        r14 = r11.fieldType;
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1338:0x0778, code lost:
        if (r14 != java.lang.Byte.TYPE) goto L433;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1339:0x077a, code lost:
        r12 = (byte) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1341:0x0782, code lost:
        if (r14 != java.lang.Short.TYPE) goto L437;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1342:0x0784, code lost:
        r12 = (short) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1344:0x078c, code lost:
        if (r14 != java.lang.Integer.TYPE) goto L441;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1345:0x078e, code lost:
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1347:0x0796, code lost:
        if (r14 != java.lang.Long.TYPE) goto L445;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1348:0x0798, code lost:
        r12 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1350:0x079f, code lost:
        if (r14 != java.lang.Float.TYPE) goto L449;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1351:0x07a1, code lost:
        r12 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1353:0x07a8, code lost:
        if (r14 != java.lang.Double.TYPE) goto L453;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1354:0x07aa, code lost:
        r12 = java.lang.Double.valueOf(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1356:0x07b1, code lost:
        if (r14 != java.lang.Boolean.TYPE) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1357:0x07b3, code lost:
        r12 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1358:0x07b6, code lost:
        if (r14 != r13) goto L463;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1360:0x07bf, code lost:
        if ((r11.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L462;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1361:0x07c1, code lost:
        r12 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1362:0x07c3, code lost:
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1363:0x07c5, code lost:
        r6[r10] = r12;
        r10 = r10 + 1;
        r0 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1364:0x07cc, code lost:
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1365:0x07cd, code lost:
        r0 = r34.beanInfo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1366:0x07d1, code lost:
        if (r0.creatorConstructor == null) goto L413;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1368:0x07d5, code lost:
        if (r0.kotlin == false) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1369:0x07d7, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1371:0x07d9, code lost:
        if (r0 >= r2.length) goto L411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1373:0x07dd, code lost:
        if (r2[r0] != null) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1374:0x07df, code lost:
        r5 = r34.beanInfo.fields;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1375:0x07e3, code lost:
        if (r5 == null) goto L409;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1377:0x07e6, code lost:
        if (r0 >= r5.length) goto L407;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1379:0x07ec, code lost:
        if (r5[r0].fieldClass != r13) goto L412;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1380:0x07ee, code lost:
        r17 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1381:0x07f1, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1382:0x07f4, code lost:
        r17 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1383:0x07f6, code lost:
        if (r17 == false) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1384:0x07f8, code lost:
        r0 = r34.beanInfo.kotlinDefaultConstructor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1385:0x07fc, code lost:
        if (r0 == null) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1386:0x07fe, code lost:
        r5 = r0.newInstance(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1387:0x0805, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1389:0x0807, code lost:
        if (r0 >= r2.length) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1390:0x0809, code lost:
        r6 = r2[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:1391:0x080b, code lost:
        if (r6 == null) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1392:0x080d, code lost:
        r10 = r34.beanInfo.fields;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1393:0x0811, code lost:
        if (r10 == null) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1395:0x0814, code lost:
        if (r0 >= r10.length) goto L400;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1396:0x0816, code lost:
        r10[r0].set(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1397:0x081b, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1398:0x081e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1401:0x0829, code lost:
        r5 = r34.beanInfo.creatorConstructor.newInstance(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1402:0x082a, code lost:
        if (r4 == null) goto L359;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1403:0x082c, code lost:
        r0 = r1.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1405:0x0838, code lost:
        if (r0.hasNext() == false) goto L355;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1406:0x083a, code lost:
        r1 = r0.next();
        r2 = getFieldDeserializer(r1.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:1407:0x084a, code lost:
        if (r2 == null) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1408:0x084c, code lost:
        r2.setValue(r5, r1.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:1410:0x0854, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1411:0x0855, code lost:
        r15 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1412:0x0858, code lost:
        r15 = (T) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1413:0x085a, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1415:0x0881, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r4 + ", " + r34.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1416:0x0882, code lost:
        r0 = r0.factoryMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1417:0x0884, code lost:
        if (r0 == null) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1420:0x088b, code lost:
        r15 = (T) r0.invoke(null, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1421:0x088d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1424:0x08ad, code lost:
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r34.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1425:0x08ae, code lost:
        if (r7 == null) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1426:0x08b0, code lost:
        r7.object = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1427:0x08b3, code lost:
        r3 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1428:0x08b5, code lost:
        r0 = r34.beanInfo.buildMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1429:0x08b9, code lost:
        if (r0 != null) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1430:0x08bb, code lost:
        if (r7 == null) goto L366;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1431:0x08bd, code lost:
        r7.object = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1432:0x08bf, code lost:
        r35.setContext(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1433:0x08c2, code lost:
        return (T) r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1435:0x08c4, code lost:
        r0 = (T) r0.invoke(r15, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1436:0x08ca, code lost:
        if (r7 == null) goto L373;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1437:0x08cc, code lost:
        r7.object = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1438:0x08ce, code lost:
        r35.setContext(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1439:0x08d1, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1440:0x08d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1442:0x08da, code lost:
        throw new com.alibaba.fastjson.JSONException("build object error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1443:0x08db, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1452:0x092a, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r13.token()));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1076:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:1086:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:1189:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:1191:0x0574 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1210:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:1236:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:1259:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:1260:0x067a A[Catch: all -> 0x0938, TryCatch #17 {all -> 0x0938, blocks: (B:1257:0x066c, B:1260:0x067a, B:1262:0x0680, B:1244:0x0642, B:1255:0x0664), top: B:1500:0x066c }] */
    /* JADX WARN: Removed duplicated region for block: B:1467:0x094b  */
    /* JADX WARN: Removed duplicated region for block: B:824:0x0072 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #9 {all -> 0x004d, blocks: (B:802:0x003d, B:804:0x0042, B:814:0x0057, B:816:0x0062, B:818:0x0068, B:824:0x0072, B:830:0x0082, B:837:0x0098, B:863:0x00ea, B:865:0x00f0, B:869:0x00f7, B:873:0x0100, B:879:0x0118, B:883:0x0128, B:884:0x0131, B:885:0x0132, B:887:0x0154, B:888:0x015c, B:889:0x016f, B:894:0x0176), top: B:1488:0x003b, inners: #19 }] */
    /* JADX WARN: Type inference failed for: r0v114, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v43, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v46, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r35v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r35, java.lang.reflect.Type r36, java.lang.Object r37, java.lang.Object r38, int r39, int[] r40) {
        /*
            Method dump skipped, instructions count: 2390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        String[] strArr;
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            if (length > 128) {
                if (this.fieldDeserializerMap == null) {
                    this.fieldDeserializerMap = new HashMap();
                }
                this.fieldDeserializerMap.put(fieldInfo.name, createFieldDeserializer);
            }
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(long j) {
        int i = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = TypeUtils.fnv1a_64(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i;
                }
                i++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch];
        if (s != -1) {
            return this.sortedFieldDeserializers[s];
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:393:0x0217, code lost:
        if (r14[r13].fieldClass == java.lang.String.class) goto L200;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createInstance(java.util.Map<java.lang.String, java.lang.Object> r13, com.alibaba.fastjson.parser.ParserConfig r14) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 695
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.createInstance(java.util.Map, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }
}
