package androidx.lifecycle;

import d2.a;
import java.util.ArrayList;
import java.util.Arrays;
import q5.l;
import r5.h;
import r5.i;
import r5.t;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class z {

    /* renamed from: a */
    public static final b f1901a = new b();

    /* renamed from: b */
    public static final c f1902b = new c();

    /* renamed from: c */
    public static final a f1903c = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class d extends i implements l<d2.a, b0> {

        /* renamed from: g */
        public static final d f1904g = new d();

        public d() {
            super(1);
        }

        @Override // q5.l
        public final b0 k(d2.a aVar) {
            h.f(aVar, "$this$initializer");
            return new b0();
        }
    }

    public static final b0 a(f0 f0Var) {
        h.f(f0Var, "<this>");
        ArrayList arrayList = new ArrayList();
        Class<?> a7 = t.a(b0.class).a();
        h.d(a7, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        arrayList.add(new d2.d(a7));
        d2.d[] dVarArr = (d2.d[]) arrayList.toArray(new d2.d[0]);
        return (b0) new d0(f0Var.i(), new d2.b((d2.d[]) Arrays.copyOf(dVarArr, dVarArr.length)), f0Var instanceof e ? ((e) f0Var).f() : a.C0044a.f3556b).b(b0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
