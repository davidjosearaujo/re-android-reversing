package z0;

import androidx.fragment.app.s0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import y0.c;
import y0.d;
import y0.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o {

    /* renamed from: f  reason: collision with root package name */
    public static int f6889f;

    /* renamed from: b  reason: collision with root package name */
    public int f6891b;

    /* renamed from: c  reason: collision with root package name */
    public int f6892c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d> f6890a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f6893d = null;
    public int e = -1;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a {
        public a(d dVar, w0.d dVar2) {
            new WeakReference(dVar);
            c cVar = dVar.K;
            dVar2.getClass();
            w0.d.o(cVar);
            w0.d.o(dVar.L);
            w0.d.o(dVar.M);
            w0.d.o(dVar.N);
            w0.d.o(dVar.O);
        }
    }

    public o(int i7) {
        int i8 = f6889f;
        f6889f = i8 + 1;
        this.f6891b = i8;
        this.f6892c = i7;
    }

    public final boolean a(d dVar) {
        if (this.f6890a.contains(dVar)) {
            return false;
        }
        this.f6890a.add(dVar);
        return true;
    }

    public final void b(ArrayList<o> arrayList) {
        int size = this.f6890a.size();
        if (this.e != -1 && size > 0) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                o oVar = arrayList.get(i7);
                if (this.e == oVar.f6891b) {
                    d(this.f6892c, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int c(w0.d dVar, int i7) {
        c cVar;
        int i8;
        if (this.f6890a.size() == 0) {
            return 0;
        }
        ArrayList<d> arrayList = this.f6890a;
        e eVar = (e) arrayList.get(0).W;
        dVar.u();
        eVar.c(dVar, false);
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            arrayList.get(i9).c(dVar, false);
        }
        if (i7 == 0 && eVar.B0 > 0) {
            q2.a.d(eVar, dVar, arrayList, 0);
        }
        if (i7 == 1 && eVar.C0 > 0) {
            q2.a.d(eVar, dVar, arrayList, 1);
        }
        try {
            dVar.q();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f6893d = new ArrayList<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            this.f6893d.add(new a(arrayList.get(i10), dVar));
        }
        if (i7 == 0) {
            i8 = w0.d.o(eVar.K);
            cVar = eVar.M;
        } else {
            i8 = w0.d.o(eVar.L);
            cVar = eVar.N;
        }
        int o6 = w0.d.o(cVar);
        dVar.u();
        return o6 - i8;
    }

    public final void d(int i7, o oVar) {
        Iterator<d> it = this.f6890a.iterator();
        while (it.hasNext()) {
            d next = it.next();
            oVar.a(next);
            if (i7 == 0) {
                next.f6541q0 = oVar.f6891b;
            } else {
                next.f6543r0 = oVar.f6891b;
            }
        }
        this.e = oVar.f6891b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i7 = this.f6892c;
        sb.append(i7 == 0 ? "Horizontal" : i7 == 1 ? "Vertical" : i7 == 2 ? "Both" : "Unknown");
        sb.append(" [");
        sb.append(this.f6891b);
        sb.append("] <");
        String sb2 = sb.toString();
        Iterator<d> it = this.f6890a.iterator();
        while (it.hasNext()) {
            sb2 = sb2 + " " + it.next().f6530k0;
        }
        return s0.h(sb2, " >");
    }
}