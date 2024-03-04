package e6;

import i5.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class o<T> extends k5.c implements d6.d {

    /* renamed from: i */
    public final d6.d f3907i;

    /* renamed from: j */
    public final i5.f f3908j;

    /* renamed from: k */
    public final int f3909k;

    /* renamed from: l */
    public i5.f f3910l;
    public i5.d m;

    /* loaded from: classes.dex */
    public static final class a extends r5.i implements q5.p {

        /* renamed from: g */
        public static final a f3911g = new a();

        public a() {
            super(2);
        }

        public final Object i(Object obj, Object obj2) {
            f.b bVar = (f.b) obj2;
            return Integer.valueOf(((Number) obj).intValue() + 1);
        }
    }

    public o(d6.d dVar, i5.f fVar) {
        super(m.f3905f, i5.g.f4488f);
        this.f3907i = dVar;
        this.f3908j = fVar;
        this.f3909k = ((Number) fVar.q(0, a.f3911g)).intValue();
    }

    public final i5.f a() {
        i5.f fVar = this.f3910l;
        return fVar == null ? i5.g.f4488f : fVar;
    }

    public final k5.d g() {
        i5.d dVar = this.m;
        if (dVar instanceof k5.d) {
            return (k5.d) dVar;
        }
        return null;
    }

    public final Object m(Object obj, i5.d dVar) {
        try {
            Object u6 = u(dVar, obj);
            return u6 == Kotlin_1.a.f4591f ? u6 : f5.g.f4141a;
        } catch (Throwable th) {
            this.f3910l = new k(dVar.a(), th);
            throw th;
        }
    }

    public final StackTraceElement q() {
        return null;
    }

    public final Object s(Object obj) {
        Throwable a7 = f5.d.a(obj);
        if (a7 != null) {
            this.f3910l = new k(a(), a7);
        }
        i5.d dVar = this.m;
        if (dVar != null) {
            dVar.o(obj);
        }
        return Kotlin_1.a.f4591f;
    }

    public final void t() {
        super.t();
    }

    public final Object u(i5.d dVar, Object obj) {
        Comparable comparable;
        String str;
        i5.f a7 = dVar.a();
        q2.a.r(a7);
        i5.f fVar = this.f3910l;
        if (fVar != a7) {
            if (fVar instanceof k) {
                StringBuilder d7 = androidx.activity.h.d("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
                d7.append(((k) fVar).f3903f);
                d7.append(", but then emission attempt of value '");
                d7.append(obj);
                d7.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
                String sb = d7.toString();
                r5.h.f(sb, "<this>");
                List asList = Arrays.asList("\r\n", "\n", "\r");
                r5.h.e(asList, "asList(...)");
                List O = y5.l.O(new y5.m(new z5.a(sb, 0, 0, new z5.g(asList, false)), new z5.h(sb)));
                ArrayList arrayList = new ArrayList();
                for (T t5 : O) {
                    if (true ^ z5.f.V((String) t5)) {
                        arrayList.add(t5);
                    }
                }
                ArrayList arrayList2 = new ArrayList(g5.j.V(arrayList));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    int length = str2.length();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length) {
                            i7 = -1;
                            break;
                        } else if (!q2.a.E(str2.charAt(i7))) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                    if (i7 == -1) {
                        i7 = str2.length();
                    }
                    arrayList2.add(Integer.valueOf(i7));
                }
                Iterator it2 = arrayList2.iterator();
                if (it2.hasNext()) {
                    comparable = (Comparable) it2.next();
                    while (it2.hasNext()) {
                        Comparable comparable2 = (Comparable) it2.next();
                        if (comparable.compareTo(comparable2) > 0) {
                            comparable = comparable2;
                        }
                    }
                } else {
                    comparable = null;
                }
                Integer num = (Integer) comparable;
                int intValue = num != null ? num.intValue() : 0;
                int size = (O.size() * 0) + sb.length();
                int x3 = q2.a.x(O);
                ArrayList arrayList3 = new ArrayList();
                int i8 = 0;
                for (T t6 : O) {
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                    String str3 = (String) t6;
                    if ((i8 == 0 || i8 == x3) && z5.f.V(str3)) {
                        str = null;
                    } else {
                        r5.h.f(str3, "<this>");
                        if (!(intValue >= 0)) {
                            throw new IllegalArgumentException(("Requested character count " + intValue + " is less than zero.").toString());
                        }
                        int length2 = str3.length();
                        if (intValue <= length2) {
                            length2 = intValue;
                        }
                        str = str3.substring(length2);
                        r5.h.e(str, "substring(...)");
                    }
                    if (str != null) {
                        arrayList3.add(str);
                    }
                    i8 = i9;
                }
                StringBuilder sb2 = new StringBuilder(size);
                g5.n.Y(arrayList3, sb2, "\n", "", "", -1, "...", null);
                String sb3 = sb2.toString();
                r5.h.e(sb3, "toString(...)");
                throw new IllegalStateException(sb3.toString());
            } else if (((Number) a7.q(0, new q(this))).intValue() != this.f3909k) {
                StringBuilder d8 = androidx.activity.h.d("Flow invariant is violated:\n\t\tFlow was collected in ");
                d8.append(this.f3908j);
                d8.append(",\n\t\tbut emission happened in ");
                d8.append(a7);
                d8.append(".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead");
                throw new IllegalStateException(d8.toString().toString());
            } else {
                this.f3910l = a7;
            }
        }
        this.m = dVar;
        q5.q<d6.d<Object>, Object, i5.d<? super f5.g>, Object> qVar = p.f3912a;
        d6.d<Object> dVar2 = this.f3907i;
        r5.h.d(dVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object f7 = qVar.f(dVar2, obj, this);
        if (!r5.h.a(f7, Kotlin_1.a.f4591f)) {
            this.m = null;
        }
        return f7;
    }
}
