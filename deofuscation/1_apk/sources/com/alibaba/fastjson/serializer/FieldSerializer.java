package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FieldSerializer implements Comparable<FieldSerializer> {
    public boolean browserCompatible;
    public boolean disableCircularReferenceDetect;
    private final String double_quoted_fieldPrefix;
    public int features;
    public BeanContext fieldContext;
    public final FieldInfo fieldInfo;
    private String format;
    public boolean persistenceXToMany;
    private RuntimeSerializerInfo runtimeInfo;
    public boolean serializeUsing = false;
    private String single_quoted_fieldPrefix;
    private String un_quoted_fieldPrefix;
    public boolean writeEnumUsingName;
    public boolean writeEnumUsingToString;
    public final boolean writeNull;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class RuntimeSerializerInfo {
        public final ObjectSerializer fieldSerializer;
        public final Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }

    public FieldSerializer(Class<?> cls, FieldInfo fieldInfo) {
        boolean z;
        SerializerFeature[] serialzeFeatures;
        JSONType jSONType;
        SerializerFeature[] serialzeFeatures2;
        boolean z2 = false;
        this.writeEnumUsingToString = false;
        this.writeEnumUsingName = false;
        this.disableCircularReferenceDetect = false;
        this.persistenceXToMany = false;
        this.fieldInfo = fieldInfo;
        this.fieldContext = new BeanContext(cls, fieldInfo);
        if (cls != null && (jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class)) != null) {
            for (SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                } else if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
                    this.disableCircularReferenceDetect = true;
                } else {
                    SerializerFeature serializerFeature2 = SerializerFeature.BrowserCompatible;
                    if (serializerFeature == serializerFeature2) {
                        this.features |= serializerFeature2.mask;
                        this.browserCompatible = true;
                    } else {
                        SerializerFeature serializerFeature3 = SerializerFeature.WriteMapNullValue;
                        if (serializerFeature == serializerFeature3) {
                            this.features |= serializerFeature3.mask;
                        }
                    }
                }
            }
        }
        fieldInfo.setAccessible();
        this.double_quoted_fieldPrefix = '\"' + fieldInfo.name + "\":";
        JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            SerializerFeature[] serialzeFeatures3 = annotation.serialzeFeatures();
            int length = serialzeFeatures3.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if ((serialzeFeatures3[i].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            String format = annotation.format();
            this.format = format;
            if (format.trim().length() == 0) {
                this.format = null;
            }
            for (SerializerFeature serializerFeature4 : annotation.serialzeFeatures()) {
                if (serializerFeature4 == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature4 == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                } else if (serializerFeature4 == SerializerFeature.DisableCircularReferenceDetect) {
                    this.disableCircularReferenceDetect = true;
                } else if (serializerFeature4 == SerializerFeature.BrowserCompatible) {
                    this.browserCompatible = true;
                }
            }
            this.features = SerializerFeature.of(annotation.serialzeFeatures()) | this.features;
        } else {
            z = false;
        }
        this.writeNull = z;
        this.persistenceXToMany = (TypeUtils.isAnnotationPresentOneToMany(fieldInfo.method) || TypeUtils.isAnnotationPresentManyToMany(fieldInfo.method)) ? true : true;
    }

    public Object getPropertyValue(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object obj2 = this.fieldInfo.get(obj);
        if (this.format == null || obj2 == null) {
            return obj2;
        }
        Class<?> cls = this.fieldInfo.fieldClass;
        if (cls == Date.class || cls == java.sql.Date.class) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.format, JSON.defaultLocale);
            simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
            return simpleDateFormat.format(obj2);
        }
        return obj2;
    }

    public Object getPropertyValueDirect(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object obj2 = this.fieldInfo.get(obj);
        if (!this.persistenceXToMany || TypeUtils.isHibernateInitialized(obj2)) {
            return obj2;
        }
        return null;
    }

    public void writePrefix(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (serializeWriter.quoteFieldNames) {
            if (SerializerFeature.isEnabled(serializeWriter.features, this.fieldInfo.serialzeFeatures, SerializerFeature.UseSingleQuotes)) {
                if (this.single_quoted_fieldPrefix == null) {
                    this.single_quoted_fieldPrefix = '\'' + this.fieldInfo.name + "':";
                }
                serializeWriter.write(this.single_quoted_fieldPrefix);
                return;
            }
            serializeWriter.write(this.double_quoted_fieldPrefix);
            return;
        }
        if (this.un_quoted_fieldPrefix == null) {
            this.un_quoted_fieldPrefix = this.fieldInfo.name + CertificateUtil.DELIMITER;
        }
        serializeWriter.write(this.un_quoted_fieldPrefix);
    }

    public void writeValue(JSONSerializer jSONSerializer, Object obj) throws Exception {
        ObjectSerializer objectSerializer;
        Class<?> cls;
        Class<?> cls2;
        ObjectSerializer objectWriter;
        if (this.runtimeInfo == null) {
            if (obj == null) {
                cls2 = this.fieldInfo.fieldClass;
                if (cls2 == Byte.TYPE) {
                    cls2 = Byte.class;
                } else if (cls2 == Short.TYPE) {
                    cls2 = Short.class;
                } else if (cls2 == Integer.TYPE) {
                    cls2 = Integer.class;
                } else if (cls2 == Long.TYPE) {
                    cls2 = Long.class;
                } else if (cls2 == Float.TYPE) {
                    cls2 = Float.class;
                } else if (cls2 == Double.TYPE) {
                    cls2 = Double.class;
                } else if (cls2 == Boolean.TYPE) {
                    cls2 = Boolean.class;
                }
            } else {
                cls2 = obj.getClass();
            }
            ObjectSerializer objectSerializer2 = null;
            JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation != null && annotation.serializeUsing() != Void.class) {
                objectWriter = (ObjectSerializer) annotation.serializeUsing().newInstance();
                this.serializeUsing = true;
            } else {
                if (this.format != null) {
                    if (cls2 != Double.TYPE && cls2 != Double.class) {
                        if (cls2 == Float.TYPE || cls2 == Float.class) {
                            objectSerializer2 = new FloatCodec(this.format);
                        }
                    } else {
                        objectSerializer2 = new DoubleSerializer(this.format);
                    }
                }
                objectWriter = objectSerializer2 == null ? jSONSerializer.getObjectWriter(cls2) : objectSerializer2;
            }
            this.runtimeInfo = new RuntimeSerializerInfo(objectWriter, cls2);
        }
        RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        int i = (this.disableCircularReferenceDetect ? this.fieldInfo.serialzeFeatures | SerializerFeature.DisableCircularReferenceDetect.mask : this.fieldInfo.serialzeFeatures) | this.features;
        if (obj == null) {
            SerializeWriter serializeWriter = jSONSerializer.out;
            if (this.fieldInfo.fieldClass == Object.class && serializeWriter.isEnabled(SerializerFeature.WRITE_MAP_NULL_FEATURES)) {
                serializeWriter.writeNull();
                return;
            }
            Class<?> cls3 = runtimeSerializerInfo.runtimeFieldClass;
            if (Number.class.isAssignableFrom(cls3)) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullNumberAsZero.mask);
                return;
            } else if (String.class == cls3) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullStringAsEmpty.mask);
                return;
            } else if (Boolean.class == cls3) {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullBooleanAsFalse.mask);
                return;
            } else if (!Collection.class.isAssignableFrom(cls3) && !cls3.isArray()) {
                ObjectSerializer objectSerializer3 = runtimeSerializerInfo.fieldSerializer;
                if (serializeWriter.isEnabled(SerializerFeature.WRITE_MAP_NULL_FEATURES) && (objectSerializer3 instanceof JavaBeanSerializer)) {
                    serializeWriter.writeNull();
                    return;
                }
                FieldInfo fieldInfo = this.fieldInfo;
                objectSerializer3.write(jSONSerializer, null, fieldInfo.name, fieldInfo.fieldType, i);
                return;
            } else {
                serializeWriter.writeNull(this.features, SerializerFeature.WriteNullListAsEmpty.mask);
                return;
            }
        }
        if (this.fieldInfo.isEnum) {
            if (this.writeEnumUsingName) {
                jSONSerializer.out.writeString(((Enum) obj).name());
                return;
            } else if (this.writeEnumUsingToString) {
                jSONSerializer.out.writeString(((Enum) obj).toString());
                return;
            }
        }
        Class<?> cls4 = obj.getClass();
        if (cls4 != runtimeSerializerInfo.runtimeFieldClass && !this.serializeUsing) {
            objectSerializer = jSONSerializer.getObjectWriter(cls4);
        } else {
            objectSerializer = runtimeSerializerInfo.fieldSerializer;
        }
        ObjectSerializer objectSerializer4 = objectSerializer;
        String str = this.format;
        if (str != null && !(objectSerializer4 instanceof DoubleSerializer) && !(objectSerializer4 instanceof FloatCodec)) {
            if (objectSerializer4 instanceof ContextObjectSerializer) {
                ((ContextObjectSerializer) objectSerializer4).write(jSONSerializer, obj, this.fieldContext);
                return;
            } else {
                jSONSerializer.writeWithFormat(obj, str);
                return;
            }
        }
        FieldInfo fieldInfo2 = this.fieldInfo;
        if (fieldInfo2.unwrapped) {
            if (objectSerializer4 instanceof JavaBeanSerializer) {
                ((JavaBeanSerializer) objectSerializer4).write(jSONSerializer, obj, fieldInfo2.name, fieldInfo2.fieldType, i, true);
                return;
            } else if (objectSerializer4 instanceof MapSerializer) {
                ((MapSerializer) objectSerializer4).write(jSONSerializer, obj, fieldInfo2.name, fieldInfo2.fieldType, i, true);
                return;
            }
        }
        if ((this.features & SerializerFeature.WriteClassName.mask) != 0 && cls4 != fieldInfo2.fieldClass && (objectSerializer4 instanceof JavaBeanSerializer)) {
            ((JavaBeanSerializer) objectSerializer4).write(jSONSerializer, obj, fieldInfo2.name, fieldInfo2.fieldType, i, false);
            return;
        }
        if (this.browserCompatible && ((cls = fieldInfo2.fieldClass) == Long.TYPE || cls == Long.class)) {
            long longValue = ((Long) obj).longValue();
            if (longValue > 9007199254740991L || longValue < -9007199254740991L) {
                jSONSerializer.getWriter().writeString(Long.toString(longValue));
                return;
            }
        }
        FieldInfo fieldInfo3 = this.fieldInfo;
        objectSerializer4.write(jSONSerializer, obj, fieldInfo3.name, fieldInfo3.fieldType, i);
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }
}
