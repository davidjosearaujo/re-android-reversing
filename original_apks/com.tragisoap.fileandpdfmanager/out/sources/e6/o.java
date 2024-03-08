package e6;

import androidx.activity.h;
import d6.d;
import f5.g;
import g5.j;
import g5.n;
import i5.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import k5.c;
import q5.p;
import q5.q;
import r5.i;
import y5.l;
import y5.m;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o<T> extends c implements d<T> {

    /* renamed from: i */
    public final d<T> f3907i;

    /* renamed from: j */
    public final f f3908j;

    /* renamed from: k */
    public final int f3909k;

    /* renamed from: l */
    public f f3910l;
    public i5.d<? super g> m;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements p<Integer, f.b, Integer> {

        /* renamed from: g */
        public static final a f3911g = new a();

        public a() {
            super(2);
        }

        @Override // q5.p
        public final Integer i(Integer num, f.b bVar) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(d<? super T> dVar, f fVar) {
        super(m.f3905f, i5.g.f4488f);
        this.f3907i = dVar;
        this.f3908j = fVar;
        this.f3909k = ((Number) fVar.q(0, a.f3911g)).intValue();
    }

    @Override // k5.c, i5.d
    public final f a() {
        f fVar = this.f3910l;
        return fVar == null ? i5.g.f4488f : fVar;
    }

    @Override // k5.a, k5.d
    public final k5.d g() {
        i5.d<? super g> dVar = this.m;
        if (dVar instanceof k5.d) {
            return (k5.d) dVar;
        }
        return null;
    }

    @Override // d6.d
    public final Object m(T t5, i5.d<? super g> dVar) {
        try {
            Object u6 = u(dVar, t5);
            return u6 == j5.a.f4591f ? u6 : g.f4141a;
        } catch (Throwable th) {
            this.f3910l = new k(dVar.a(), th);
            throw th;
        }
    }

    @Override // k5.a
    public final StackTraceElement q() {
        return null;
    }

    @Override // k5.a
    public final Object s(Object obj) {
        Throwable a7 = f5.d.a(obj);
        if (a7 != null) {
            this.f3910l = new k(a(), a7);
        }
        i5.d<? super g> dVar = this.m;
        if (dVar != null) {
            dVar.o(obj);
        }
        return j5.a.f4591f;
    }

    @Override // k5.c, k5.a
    public final void t() {
        super.t();
    }

    public final Object u(i5.d<? super g> dVar, T t5) {
        Comparable comparable;
        String str;
        f a7 = dVar.a();
        q2.a.r(a7);
        f fVar = this.f3910l;
        if (fVar != a7) {
            if (fVar instanceof k) {
                StringBuilder d7 = h.d("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
                d7.append(((k) fVar).f3903f);
                d7.append(", but then emission attempt of value '");
                d7.append(t5);
                d7.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
                String sb = d7.toString();
                r5.h.f(sb, "<this>");
                List asList = Arrays.asList("\r\n", "\n", "\r");
                r5.h.e(asList, "asList(...)");
                List O = l.O(new m(new z5.a(sb, 0, 0, new z5.g(asList, false)), new z5.h(sb)));
                ArrayList arrayList = new ArrayList();
                for (T t6 : O) {
                    if (true ^ z5.f.V((String) t6)) {
                        arrayList.add(t6);
                    }
                }
                ArrayList arrayList2 = new ArrayList(j.V(arrayList));
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
                if (!it2.hasNext()) {
                    comparable = null;
                } else {
                    comparable = (Comparable) it2.next();
                    while (it2.hasNext()) {
                        Comparable comparable2 = (Comparable) it2.next();
                        if (comparable.compareTo(comparable2) > 0) {
                            comparable = comparable2;
                        }
                    }
                }
                Integer num = (Integer) comparable;
                int intValue = num != null ? num.intValue() : 0;
                int size = (O.size() * 0) + sb.length();
                int x6 = q2.a.x(O);
                ArrayList arrayList3 = new ArrayList();
                int i8 = 0;
                for (T t7 : O) {
                    i8++;
                    if (i8 >= 0) {
                        String str3 = (String) t7;
                        if ((i8 == 0 || i8 == x6) && z5.f.V(str3)) {
                            str = null;
                        } else {
                            r5.h.f(str3, "<this>");
                            if (intValue >= 0) {
                                int length2 = str3.length();
                                if (intValue <= length2) {
                                    length2 = intValue;
                                }
                                str = str3.substring(length2);
                                r5.h.e(str, "substring(...)");
                            } else {
                                throw new IllegalArgumentException(("Requested character count " + intValue + " is less than zero.").toString());
                            }
                        }
                        if (str != null) {
                            arrayList3.add(str);
                        }
                    } else {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                }
                StringBuilder sb2 = new StringBuilder(size);
                n.Y(arrayList3, sb2, "\n", "", "", -1, "...", null);
                String sb3 = sb2.toString();
                r5.h.e(sb3, "toString(...)");
                throw new IllegalStateException(sb3.toString());
            } else if (((Number) a7.q(0, new q(this))).intValue() == this.f3909k) {
                this.f3910l = a7;
            } else {
                StringBuilder d8 = h.d("Flow invariant is violated:\n\t\tFlow was collected in ");
                d8.append(this.f3908j);
                d8.append(",\n\t\tbut emission happened in ");
                d8.append(a7);
                d8.append(".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead");
                throw new IllegalStateException(d8.toString().toString());
            }
        }
        this.m = dVar;
        q<d<Object>, Object, i5.d<? super g>, Object> qVar = p.f3912a;
        d<T> dVar2 = this.f3907i;
        r5.h.d(dVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object f7 = qVar.f(dVar2, t5, this);
        if (!r5.h.a(f7, j5.a.f4591f)) {
            this.m = null;
        }
        return f7;
    }
}
