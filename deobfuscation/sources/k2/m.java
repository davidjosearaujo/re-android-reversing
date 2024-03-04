package k2;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import k2.h;

/* loaded from: classes.dex */
public class m extends h {
    public int E;
    public ArrayList<h> C = new ArrayList<>();
    public boolean D = true;
    public boolean F = false;
    public int G = 0;

    /* loaded from: classes.dex */
    public class a extends k {

        /* renamed from: a */
        public final /* synthetic */ h f4664a;

        public a(h hVar) {
            this.f4664a = hVar;
        }

        @Override // k2.h.d
        public final void c(h hVar) {
            this.f4664a.y();
            hVar.v(this);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends k {

        /* renamed from: a */
        public m f4665a;

        public b(m mVar) {
            this.f4665a = mVar;
        }

        @Override // k2.k, k2.h.d
        public final void a() {
            m mVar = this.f4665a;
            if (mVar.F) {
                return;
            }
            mVar.F();
            this.f4665a.F = true;
        }

        @Override // k2.h.d
        public final void c(h hVar) {
            m mVar = this.f4665a;
            int i7 = mVar.E - 1;
            mVar.E = i7;
            if (i7 == 0) {
                mVar.F = false;
                mVar.m();
            }
            hVar.v(this);
        }
    }

    @Override // k2.h
    public final void A(h.c cVar) {
        this.f4648x = cVar;
        this.G |= 8;
        int size = this.C.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.C.get(i7).A(cVar);
        }
    }

    @Override // k2.h
    public final void B(TimeInterpolator timeInterpolator) {
        this.G |= 1;
        ArrayList<h> arrayList = this.C;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.C.get(i7).B(timeInterpolator);
            }
        }
        this.f4635i = timeInterpolator;
    }

    @Override // k2.h
    public final void C(androidx.activity.result.c cVar) {
        super.C(cVar);
        this.G |= 4;
        if (this.C != null) {
            for (int i7 = 0; i7 < this.C.size(); i7++) {
                this.C.get(i7).C(cVar);
            }
        }
    }

    @Override // k2.h
    public final void D() {
        this.G |= 2;
        int size = this.C.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.C.get(i7).D();
        }
    }

    @Override // k2.h
    public final void E(long j5) {
        this.f4633g = j5;
    }

    @Override // k2.h
    public final String G(String str) {
        String G = super.G(str);
        for (int i7 = 0; i7 < this.C.size(); i7++) {
            StringBuilder sb = new StringBuilder();
            sb.append(G);
            sb.append("\n");
            sb.append(this.C.get(i7).G(str + "  "));
            G = sb.toString();
        }
        return G;
    }

    public final void H(h hVar) {
        this.C.add(hVar);
        hVar.f4639n = this;
        long j5 = this.f4634h;
        if (j5 >= 0) {
            hVar.z(j5);
        }
        if ((this.G & 1) != 0) {
            hVar.B(this.f4635i);
        }
        if ((this.G & 2) != 0) {
            hVar.D();
        }
        if ((this.G & 4) != 0) {
            hVar.C(this.f4649y);
        }
        if ((this.G & 8) != 0) {
            hVar.A(this.f4648x);
        }
    }

    @Override // k2.h
    public final void a(h.d dVar) {
        super.a(dVar);
    }

    @Override // k2.h
    public final void b(View view) {
        for (int i7 = 0; i7 < this.C.size(); i7++) {
            this.C.get(i7).b(view);
        }
        this.f4637k.add(view);
    }

    @Override // k2.h
    public final void d(n nVar) {
        if (s(nVar.f4667b)) {
            Iterator<h> it = this.C.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next.s(nVar.f4667b)) {
                    next.d(nVar);
                    nVar.f4668c.add(next);
                }
            }
        }
    }

    @Override // k2.h
    public final void f(n nVar) {
        int size = this.C.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.C.get(i7).f(nVar);
        }
    }

    @Override // k2.h
    public final void g(n nVar) {
        if (s(nVar.f4667b)) {
            Iterator<h> it = this.C.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next.s(nVar.f4667b)) {
                    next.g(nVar);
                    nVar.f4668c.add(next);
                }
            }
        }
    }

    @Override // k2.h
    /* renamed from: j */
    public final h clone() {
        m mVar = (m) super.clone();
        mVar.C = new ArrayList<>();
        int size = this.C.size();
        for (int i7 = 0; i7 < size; i7++) {
            h clone = this.C.get(i7).clone();
            mVar.C.add(clone);
            clone.f4639n = mVar;
        }
        return mVar;
    }

    @Override // k2.h
    public final void l(ViewGroup viewGroup, w0.c cVar, w0.c cVar2, ArrayList<n> arrayList, ArrayList<n> arrayList2) {
        long j5 = this.f4633g;
        int size = this.C.size();
        for (int i7 = 0; i7 < size; i7++) {
            h hVar = this.C.get(i7);
            if (j5 > 0 && (this.D || i7 == 0)) {
                long j7 = hVar.f4633g;
                if (j7 > 0) {
                    hVar.E(j7 + j5);
                } else {
                    hVar.E(j5);
                }
            }
            hVar.l(viewGroup, cVar, cVar2, arrayList, arrayList2);
        }
    }

    @Override // k2.h
    public final void u(View view) {
        super.u(view);
        int size = this.C.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.C.get(i7).u(view);
        }
    }

    @Override // k2.h
    public final void v(h.d dVar) {
        super.v(dVar);
    }

    @Override // k2.h
    public final void w(View view) {
        for (int i7 = 0; i7 < this.C.size(); i7++) {
            this.C.get(i7).w(view);
        }
        this.f4637k.remove(view);
    }

    @Override // k2.h
    public final void x(ViewGroup viewGroup) {
        super.x(viewGroup);
        int size = this.C.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.C.get(i7).x(viewGroup);
        }
    }

    @Override // k2.h
    public final void y() {
        if (this.C.isEmpty()) {
            F();
            m();
            return;
        }
        b bVar = new b(this);
        Iterator<h> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.E = this.C.size();
        if (this.D) {
            Iterator<h> it2 = this.C.iterator();
            while (it2.hasNext()) {
                it2.next().y();
            }
            return;
        }
        for (int i7 = 1; i7 < this.C.size(); i7++) {
            this.C.get(i7 - 1).a(new a(this.C.get(i7)));
        }
        h hVar = this.C.get(0);
        if (hVar != null) {
            hVar.y();
        }
    }

    @Override // k2.h
    public final void z(long j5) {
        ArrayList<h> arrayList;
        this.f4634h = j5;
        if (j5 < 0 || (arrayList = this.C) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.C.get(i7).z(j5);
        }
    }
}
