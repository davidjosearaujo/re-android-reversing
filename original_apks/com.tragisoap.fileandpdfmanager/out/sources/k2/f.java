package k2;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.l0;
import java.util.ArrayList;
import k2.h;
@SuppressLint({"RestrictedApi"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class f extends l0 {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements h.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f4623a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f4624b;

        public a(View view, ArrayList arrayList) {
            this.f4623a = view;
            this.f4624b = arrayList;
        }

        @Override // k2.h.d
        public final void a() {
        }

        @Override // k2.h.d
        public final void b() {
        }

        @Override // k2.h.d
        public final void c(h hVar) {
            hVar.v(this);
            this.f4623a.setVisibility(8);
            int size = this.f4624b.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((View) this.f4624b.get(i7)).setVisibility(0);
            }
        }

        @Override // k2.h.d
        public final void d() {
        }

        @Override // k2.h.d
        public final void e() {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f4625a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f4626b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f4627c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f4628d;
        public final /* synthetic */ Object e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f4629f;

        public b(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f4625a = obj;
            this.f4626b = arrayList;
            this.f4627c = obj2;
            this.f4628d = arrayList2;
            this.e = obj3;
            this.f4629f = arrayList3;
        }

        @Override // k2.k, k2.h.d
        public final void a() {
            Object obj = this.f4625a;
            if (obj != null) {
                f.this.u(obj, this.f4626b, null);
            }
            Object obj2 = this.f4627c;
            if (obj2 != null) {
                f.this.u(obj2, this.f4628d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                f.this.u(obj3, this.f4629f, null);
            }
        }

        @Override // k2.h.d
        public final void c(h hVar) {
            hVar.v(this);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c extends h.c {
    }

    @Override // androidx.fragment.app.l0
    public final void a(View view, Object obj) {
        if (obj != null) {
            ((h) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.l0
    public final void b(Object obj, ArrayList<View> arrayList) {
        h hVar = (h) obj;
        if (hVar != null) {
            int i7 = 0;
            if (hVar instanceof m) {
                m mVar = (m) hVar;
                int size = mVar.C.size();
                while (i7 < size) {
                    b((i7 < 0 || i7 >= mVar.C.size()) ? null : mVar.C.get(i7), arrayList);
                    i7++;
                }
                return;
            }
            if (!(!l0.h(hVar.f4636j) || !l0.h(null) || !l0.h(null)) && l0.h(hVar.f4637k)) {
                int size2 = arrayList.size();
                while (i7 < size2) {
                    hVar.b(arrayList.get(i7));
                    i7++;
                }
            }
        }
    }

    @Override // androidx.fragment.app.l0
    public final void c(ViewGroup viewGroup, Object obj) {
        l.a(viewGroup, (h) obj);
    }

    @Override // androidx.fragment.app.l0
    public final boolean e(Object obj) {
        return obj instanceof h;
    }

    @Override // androidx.fragment.app.l0
    public final Object f(Object obj) {
        if (obj != null) {
            return ((h) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.l0
    public final Object i(Object obj, Object obj2, Object obj3) {
        h hVar = (h) obj;
        h hVar2 = (h) obj2;
        h hVar3 = (h) obj3;
        if (hVar != null && hVar2 != null) {
            m mVar = new m();
            mVar.H(hVar);
            mVar.H(hVar2);
            mVar.D = false;
            hVar = mVar;
        } else if (hVar == null) {
            hVar = hVar2 != null ? hVar2 : null;
        }
        if (hVar3 == null) {
            return hVar;
        }
        m mVar2 = new m();
        if (hVar != null) {
            mVar2.H(hVar);
        }
        mVar2.H(hVar3);
        return mVar2;
    }

    @Override // androidx.fragment.app.l0
    public final Object j(Object obj, Object obj2, Object obj3) {
        m mVar = new m();
        if (obj != null) {
            mVar.H((h) obj);
        }
        if (obj2 != null) {
            mVar.H((h) obj2);
        }
        if (obj3 != null) {
            mVar.H((h) obj3);
        }
        return mVar;
    }

    @Override // androidx.fragment.app.l0
    public final void l(Object obj, View view, ArrayList<View> arrayList) {
        ((h) obj).a(new a(view, arrayList));
    }

    @Override // androidx.fragment.app.l0
    public final void m(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((h) obj).a(new b(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.l0
    public final void n(View view, Object obj) {
        if (view != null) {
            l0.g(view, new Rect());
            ((h) obj).A(new e());
        }
    }

    @Override // androidx.fragment.app.l0
    public final void o(Object obj, Rect rect) {
        if (obj != null) {
            ((h) obj).A(new c());
        }
    }

    @Override // androidx.fragment.app.l0
    public final void r(Object obj, View view, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        ArrayList<View> arrayList2 = mVar.f4637k;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            l0.d(arrayList.get(i7), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(mVar, arrayList);
    }

    @Override // androidx.fragment.app.l0
    public final void s(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        if (mVar != null) {
            mVar.f4637k.clear();
            mVar.f4637k.addAll(arrayList2);
            u(mVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.l0
    public final Object t(Object obj) {
        if (obj == null) {
            return null;
        }
        m mVar = new m();
        mVar.H((h) obj);
        return mVar;
    }

    public final void u(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        h hVar = (h) obj;
        int i7 = 0;
        if (hVar instanceof m) {
            m mVar = (m) hVar;
            int size = mVar.C.size();
            while (i7 < size) {
                u((i7 < 0 || i7 >= mVar.C.size()) ? null : mVar.C.get(i7), arrayList, arrayList2);
                i7++;
            }
            return;
        }
        if (!(!l0.h(hVar.f4636j) || !l0.h(null) || !l0.h(null))) {
            ArrayList<View> arrayList3 = hVar.f4637k;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i7 < size2) {
                    hVar.b(arrayList2.get(i7));
                    i7++;
                }
                int size3 = arrayList.size();
                while (true) {
                    size3--;
                    if (size3 >= 0) {
                        hVar.w(arrayList.get(size3));
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
