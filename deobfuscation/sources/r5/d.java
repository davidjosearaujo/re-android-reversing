package r5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import q5.w;

/* loaded from: classes.dex */
public final class d implements x5.b<Object>, c {

    /* renamed from: b */
    public static final Map<Class<? extends f5.a<?>>, Integer> f5917b;

    /* renamed from: c */
    public static final LinkedHashMap f5918c;

    /* renamed from: a */
    public final Class<?> f5919a;

    static {
        int i7 = 0;
        List H = q2.a.H(q5.a.class, q5.l.class, q5.p.class, q5.q.class, q5.r.class, q5.s.class, q5.t.class, q5.u.class, q5.v.class, w.class, q5.b.class, q5.c.class, q5.d.class, q5.e.class, q5.f.class, q5.g.class, q5.h.class, q5.i.class, q5.j.class, q5.k.class, q5.m.class, q5.n.class, q5.o.class);
        ArrayList arrayList = new ArrayList(g5.j.V(H));
        for (Object obj : H) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new f5.c((Class) obj, Integer.valueOf(i7)));
            i7 = i8;
        }
        f5917b = g5.u.X(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        h.e(values, "<get-values>(...)");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            h.c(str);
            sb.append(z5.i.e0(str));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            hashMap3.put(sb2, str + ".Companion");
        }
        for (Map.Entry<Class<? extends f5.a<?>>, Integer> entry : f5917b.entrySet()) {
            int intValue = entry.getValue().intValue();
            String name = entry.getKey().getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(g5.t.V(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), z5.i.e0((String) entry2.getValue()));
        }
        f5918c = linkedHashMap;
    }

    public d(Class<?> cls) {
        h.f(cls, "jClass");
        this.f5919a = cls;
    }

    @Override // r5.c
    public final Class<?> a() {
        return this.f5919a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d) && h.a(a0.e.o(this), a0.e.o((x5.b) obj));
    }

    public final int hashCode() {
        return a0.e.o(this).hashCode();
    }

    public final String toString() {
        return this.f5919a.toString() + " (Kotlin reflection is not available)";
    }
}
