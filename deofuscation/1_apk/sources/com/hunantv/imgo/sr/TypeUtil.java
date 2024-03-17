package com.hunantv.imgo.sr;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import com.hunantv.imgo.entity.JumpAction;
import com.mgtv.json.JsonInterface;
import j.l.a.z.a;
import j.l.a.z.b;
import j.l.a.z.c;
import j.l.a.z.e;
import j.l.a.z.f;
import j.l.a.z.g;
import j.l.a.z.h;
import j.l.a.z.i;
import j.l.a.z.l;
import j.l.a.z.o;
import j.l.a.z.p;
import j.l.a.z.q;
import j.l.a.z.r;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class TypeUtil {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ContainerType {
        sparseBooleanArray(SparseBooleanArray.class, new q()),
        sparseIntArray(SparseIntArray.class, new r());
        
        public final Class cls;
        public final c impl;

        ContainerType(Class cls, c cVar) {
            this.cls = cls;
            this.impl = cVar;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ExtraType {
        fragment(Fragment.class, new f());
        
        public final Class cls;
        public final l impl;

        ExtraType(Class cls, l lVar) {
            this.cls = cls;
            this.impl = lVar;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum GenericContainerType {
        collection(Collection.class, new b()),
        map(Map.class, new i()),
        sparseArray(SparseArray.class, new p()),
        sparseArrayCompat(SparseArrayCompat.class, new o()),
        longSparseArray(LongSparseArray.class, new h());
        
        public final Class cls;
        public final c impl;

        GenericContainerType(Class cls, c cVar) {
            this.cls = cls;
            this.impl = cVar;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ListType {
        putStringArrayList(String.class),
        putIntegerArrayList(Integer.class, Integer.TYPE),
        putParcelableArrayList(Parcelable.class),
        putCharSequenceArrayList(CharSequence.class);
        
        public final Class<?>[] classes;
        public final String getMethod;
        public final String putMethod;

        ListType(Class... clsArr) {
            this.classes = clsArr;
            String name = name();
            this.putMethod = name;
            this.getMethod = name.replaceFirst("put", "get");
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum NormalType {
        putBundle(Bundle.class),
        putBoolean(Boolean.TYPE, Boolean.class),
        putBooleanArray(boolean[].class),
        putByte(Byte.TYPE, Byte.class),
        putByteArray(byte[].class),
        putChar(Character.TYPE, Character.class),
        putCharArray(char[].class),
        putCharSequence(CharSequence.class),
        putCharSequenceArray(CharSequence[].class),
        putDouble(Double.TYPE, Double.class),
        putDoubleArray(double[].class),
        putFloat(Float.TYPE, Float.class),
        putFloatArray(float[].class),
        putInt(Integer.TYPE, Integer.class),
        putIntArray(int[].class),
        putLong(Long.TYPE, Long.class),
        putLongArray(long[].class),
        putParcelable(Parcelable.class),
        putParcelableArray(Parcelable[].class),
        putShort(Short.TYPE, Short.class),
        putShortArray(short[].class),
        putString(String.class),
        putStringArray(String[].class),
        putSerializable(Serializable.class),
        putSparseParcelableArray(SparseArray.class);
        
        public final Class<?>[] classes;
        public final String getMethod;
        public final String putMethod;

        NormalType(Class... clsArr) {
            this.classes = clsArr;
            String name = name();
            this.putMethod = name;
            this.getMethod = name.replaceFirst("put", "get");
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum TranslateType {
        enum_(Enum.class, new e()),
        jsonInterface(JsonInterface.class, new g());
        
        public final Class cls;
        public final l impl;

        TranslateType(Class cls, l lVar) {
            this.cls = cls;
            this.impl = lVar;
        }
    }

    private TypeUtil() {
    }

    public static Class<?> a(Type type) {
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        return null;
    }

    public static String b(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getSimpleName();
        }
        int i = 0;
        if (type instanceof ParameterizedType) {
            StringBuilder sb = new StringBuilder();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            sb.append(((Class) parameterizedType.getRawType()).getSimpleName());
            sb.append("<");
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            boolean z = false;
            while (i < length) {
                Type type2 = actualTypeArguments[i];
                if (z) {
                    sb.append(", ");
                } else {
                    z = true;
                }
                sb.append(b(type2));
                i++;
            }
            sb.append(">");
            return sb.toString();
        } else if (type instanceof WildcardType) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(JumpAction.STR_ACTION_SPLIT);
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            if (lowerBounds.length > 0) {
                sb2.append(" super ");
                int length2 = lowerBounds.length;
                boolean z2 = false;
                while (i < length2) {
                    Type type3 = lowerBounds[i];
                    if (z2) {
                        sb2.append(" & ");
                    } else {
                        z2 = true;
                    }
                    sb2.append(b(type3));
                    i++;
                }
            } else {
                Type[] upperBounds = wildcardType.getUpperBounds();
                if (upperBounds.length > 0 && (upperBounds.length != 1 || upperBounds[0] != Object.class)) {
                    sb2.append(" extends ");
                    int length3 = upperBounds.length;
                    boolean z3 = false;
                    while (i < length3) {
                        Type type4 = upperBounds[i];
                        if (z3) {
                            sb2.append(" & ");
                        } else {
                            z3 = true;
                        }
                        sb2.append(b(type4));
                        i++;
                    }
                }
            }
            return sb2.toString();
        } else {
            return type.toString();
        }
    }

    public static ContainerType c(Class<?> cls) {
        ContainerType[] values;
        for (ContainerType containerType : ContainerType.values()) {
            if (containerType.cls.isAssignableFrom(cls)) {
                return containerType;
            }
        }
        return null;
    }

    public static ExtraType d(Class<?> cls) {
        ExtraType[] values;
        for (ExtraType extraType : ExtraType.values()) {
            if (extraType.cls.isAssignableFrom(cls)) {
                return extraType;
            }
        }
        return null;
    }

    public static GenericContainerType e(Class<?> cls) {
        GenericContainerType[] values;
        for (GenericContainerType genericContainerType : GenericContainerType.values()) {
            if (genericContainerType.cls.isAssignableFrom(cls)) {
                return genericContainerType;
            }
        }
        return null;
    }

    public static ListType f(Class<?> cls) {
        ListType[] values;
        Class<?>[] clsArr;
        boolean z;
        for (ListType listType : ListType.values()) {
            for (Class<?> cls2 : listType.classes) {
                if (cls2 == cls || cls2.isAssignableFrom(cls)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return listType;
            }
        }
        return null;
    }

    public static NormalType g(Class<?> cls) {
        NormalType[] values;
        Class<?>[] clsArr;
        boolean z;
        for (NormalType normalType : NormalType.values()) {
            for (Class<?> cls2 : normalType.classes) {
                if (cls2 == cls || cls2.isAssignableFrom(cls)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return normalType;
            }
        }
        return null;
    }

    public static TranslateType h(Class<?> cls) {
        TranslateType[] values;
        for (TranslateType translateType : TranslateType.values()) {
            if (translateType.cls.isAssignableFrom(cls)) {
                return translateType;
            }
        }
        return null;
    }

    public static boolean i(Type type) {
        if (type instanceof GenericArrayType) {
            return i(((GenericArrayType) type).getGenericComponentType());
        }
        if (type instanceof Class) {
            Class cls = (Class) type;
            return (g(cls) == null && h(cls) == null) ? false : true;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (e((Class) parameterizedType.getRawType()) == null) {
                return false;
            }
            for (Type type2 : parameterizedType.getActualTypeArguments()) {
                if (!i(type2)) {
                    return false;
                }
            }
            return true;
        } else if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 0) {
                return false;
            }
            return i(upperBounds[0]);
        } else {
            return false;
        }
    }

    @Nullable
    public static l j(Type type) {
        if (type instanceof GenericArrayType) {
            return a.a;
        }
        Class<?> a = a(type);
        if (a == null) {
            return null;
        }
        GenericContainerType e = e(a);
        if (e != null) {
            return e.impl;
        }
        ContainerType c = c(a);
        if (c != null) {
            return c.impl;
        }
        TranslateType h = h(a);
        if (h != null) {
            return h.impl;
        }
        ExtraType d = d(a);
        if (d != null) {
            return d.impl;
        }
        return null;
    }
}
