package p;

import a0.e;
import java.util.Arrays;
import q5.p;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements p<b, Integer, f5.g> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c0<?>[] f5427g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ p<b, Integer, f5.g> f5428h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f5429i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(c0<?>[] c0VarArr, p<? super b, ? super Integer, f5.g> pVar, int i7) {
            super(2);
            this.f5427g = c0VarArr;
            this.f5428h = pVar;
            this.f5429i = i7;
        }

        @Override // q5.p
        public final f5.g i(b bVar, Integer num) {
            num.intValue();
            c0<?>[] c0VarArr = this.f5427g;
            g.a((c0[]) Arrays.copyOf(c0VarArr, c0VarArr.length), this.f5428h, bVar, e.K(this.f5429i | 1));
            return f5.g.f4141a;
        }
    }

    public static final void a(c0<?>[] c0VarArr, p<? super b, ? super Integer, f5.g> pVar, b bVar, int i7) {
        h.f(c0VarArr, "values");
        h.f(pVar, "content");
        c i8 = bVar.i(-1390796515);
        i8.t(c0VarArr);
        pVar.i(i8, Integer.valueOf((i7 >> 3) & 14));
        i8.p();
        e0 q6 = i8.q();
        if (q6 != null) {
            q6.f5426a = new a(c0VarArr, pVar, i7);
        }
    }
}
