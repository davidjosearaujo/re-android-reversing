package k2;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import androidx.fragment.app.s0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import k2.o;
import l0.z;
import o.e;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class h implements Cloneable {

    /* renamed from: p */
    public ArrayList<n> f4641p;

    /* renamed from: q */
    public ArrayList<n> f4642q;

    /* renamed from: x */
    public c f4648x;

    /* renamed from: z */
    public static final int[] f4631z = {2, 1, 3, 4};
    public static final a A = new a();
    public static ThreadLocal<o.b<Animator, b>> B = new ThreadLocal<>();

    /* renamed from: f */
    public String f4632f = getClass().getName();

    /* renamed from: g */
    public long f4633g = -1;

    /* renamed from: h */
    public long f4634h = -1;

    /* renamed from: i */
    public TimeInterpolator f4635i = null;

    /* renamed from: j */
    public ArrayList<Integer> f4636j = new ArrayList<>();

    /* renamed from: k */
    public ArrayList<View> f4637k = new ArrayList<>();

    /* renamed from: l */
    public w0.c f4638l = new w0.c(2);
    public w0.c m = new w0.c(2);

    /* renamed from: n */
    public m f4639n = null;

    /* renamed from: o */
    public int[] f4640o = f4631z;

    /* renamed from: r */
    public ArrayList<Animator> f4643r = new ArrayList<>();
    public int s = 0;

    /* renamed from: t */
    public boolean f4644t = false;

    /* renamed from: u */
    public boolean f4645u = false;

    /* renamed from: v */
    public ArrayList<d> f4646v = null;

    /* renamed from: w */
    public ArrayList<Animator> f4647w = new ArrayList<>();

    /* renamed from: y */
    public androidx.activity.result.c f4649y = A;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends androidx.activity.result.c {
        @Override // androidx.activity.result.c
        public final Path f(float f7, float f8, float f9, float f10) {
            Path path = new Path();
            path.moveTo(f7, f8);
            path.lineTo(f9, f10);
            return path;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {

        /* renamed from: a */
        public View f4650a;

        /* renamed from: b */
        public String f4651b;

        /* renamed from: c */
        public n f4652c;

        /* renamed from: d */
        public x f4653d;
        public h e;

        public b(View view, String str, h hVar, w wVar, n nVar) {
            this.f4650a = view;
            this.f4651b = str;
            this.f4652c = nVar;
            this.f4653d = wVar;
            this.e = hVar;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class c {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface d {
        void a();

        void b();

        void c(h hVar);

        void d();

        void e();
    }

    public static void c(w0.c cVar, View view, n nVar) {
        ((o.b) cVar.f6337a).put(view, nVar);
        int id = view.getId();
        if (id >= 0) {
            if (((SparseArray) cVar.f6338b).indexOfKey(id) >= 0) {
                ((SparseArray) cVar.f6338b).put(id, null);
            } else {
                ((SparseArray) cVar.f6338b).put(id, view);
            }
        }
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        String k6 = y.i.k(view);
        if (k6 != null) {
            if (((o.b) cVar.f6340d).containsKey(k6)) {
                ((o.b) cVar.f6340d).put(k6, null);
            } else {
                ((o.b) cVar.f6340d).put(k6, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                e eVar = (e) cVar.f6339c;
                if (eVar.f5192f) {
                    eVar.c();
                }
                if (z.j(eVar.f5193g, eVar.f5195i, itemIdAtPosition) >= 0) {
                    View view2 = (View) ((e) cVar.f6339c).d(null, itemIdAtPosition);
                    if (view2 != null) {
                        y.d.r(view2, false);
                        ((e) cVar.f6339c).e(null, itemIdAtPosition);
                        return;
                    }
                    return;
                }
                y.d.r(view, true);
                ((e) cVar.f6339c).e(view, itemIdAtPosition);
            }
        }
    }

    public static o.b<Animator, b> o() {
        o.b<Animator, b> bVar = B.get();
        if (bVar != null) {
            return bVar;
        }
        o.b<Animator, b> bVar2 = new o.b<>();
        B.set(bVar2);
        return bVar2;
    }

    public static boolean t(n nVar, n nVar2, String str) {
        Object obj = nVar.f4666a.get(str);
        Object obj2 = nVar2.f4666a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public void A(c cVar) {
        this.f4648x = cVar;
    }

    public void B(TimeInterpolator timeInterpolator) {
        this.f4635i = timeInterpolator;
    }

    public void C(androidx.activity.result.c cVar) {
        if (cVar == null) {
            cVar = A;
        }
        this.f4649y = cVar;
    }

    public void D() {
    }

    public void E(long j7) {
        this.f4633g = j7;
    }

    public final void F() {
        if (this.s == 0) {
            ArrayList<d> arrayList = this.f4646v;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f4646v.clone();
                int size = arrayList2.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ((d) arrayList2.get(i7)).a();
                }
            }
            this.f4645u = false;
        }
        this.s++;
    }

    public String G(String str) {
        StringBuilder d7 = androidx.activity.h.d(str);
        d7.append(getClass().getSimpleName());
        d7.append("@");
        d7.append(Integer.toHexString(hashCode()));
        d7.append(": ");
        String sb = d7.toString();
        if (this.f4634h != -1) {
            sb = sb + "dur(" + this.f4634h + ") ";
        }
        if (this.f4633g != -1) {
            sb = sb + "dly(" + this.f4633g + ") ";
        }
        if (this.f4635i != null) {
            sb = sb + "interp(" + this.f4635i + ") ";
        }
        if (this.f4636j.size() <= 0 && this.f4637k.size() <= 0) {
            return sb;
        }
        String h7 = s0.h(sb, "tgts(");
        if (this.f4636j.size() > 0) {
            for (int i7 = 0; i7 < this.f4636j.size(); i7++) {
                if (i7 > 0) {
                    h7 = s0.h(h7, ", ");
                }
                StringBuilder d8 = androidx.activity.h.d(h7);
                d8.append(this.f4636j.get(i7));
                h7 = d8.toString();
            }
        }
        if (this.f4637k.size() > 0) {
            for (int i8 = 0; i8 < this.f4637k.size(); i8++) {
                if (i8 > 0) {
                    h7 = s0.h(h7, ", ");
                }
                StringBuilder d9 = androidx.activity.h.d(h7);
                d9.append(this.f4637k.get(i8));
                h7 = d9.toString();
            }
        }
        return s0.h(h7, ")");
    }

    public void a(d dVar) {
        if (this.f4646v == null) {
            this.f4646v = new ArrayList<>();
        }
        this.f4646v.add(dVar);
    }

    public void b(View view) {
        this.f4637k.add(view);
    }

    public abstract void d(n nVar);

    public final void e(View view, boolean z6) {
        if (view != null) {
            view.getId();
            if (view.getParent() instanceof ViewGroup) {
                n nVar = new n(view);
                if (z6) {
                    g(nVar);
                } else {
                    d(nVar);
                }
                nVar.f4668c.add(this);
                f(nVar);
                c(z6 ? this.f4638l : this.m, view, nVar);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
                    e(viewGroup.getChildAt(i7), z6);
                }
            }
        }
    }

    public void f(n nVar) {
    }

    public abstract void g(n nVar);

    public final void h(ViewGroup viewGroup, boolean z6) {
        i(z6);
        if (this.f4636j.size() > 0 || this.f4637k.size() > 0) {
            for (int i7 = 0; i7 < this.f4636j.size(); i7++) {
                View findViewById = viewGroup.findViewById(this.f4636j.get(i7).intValue());
                if (findViewById != null) {
                    n nVar = new n(findViewById);
                    if (z6) {
                        g(nVar);
                    } else {
                        d(nVar);
                    }
                    nVar.f4668c.add(this);
                    f(nVar);
                    c(z6 ? this.f4638l : this.m, findViewById, nVar);
                }
            }
            for (int i8 = 0; i8 < this.f4637k.size(); i8++) {
                View view = this.f4637k.get(i8);
                n nVar2 = new n(view);
                if (z6) {
                    g(nVar2);
                } else {
                    d(nVar2);
                }
                nVar2.f4668c.add(this);
                f(nVar2);
                c(z6 ? this.f4638l : this.m, view, nVar2);
            }
            return;
        }
        e(viewGroup, z6);
    }

    public final void i(boolean z6) {
        w0.c cVar;
        if (z6) {
            ((o.b) this.f4638l.f6337a).clear();
            ((SparseArray) this.f4638l.f6338b).clear();
            cVar = this.f4638l;
        } else {
            ((o.b) this.m.f6337a).clear();
            ((SparseArray) this.m.f6338b).clear();
            cVar = this.m;
        }
        ((e) cVar.f6339c).a();
    }

    /* renamed from: j */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.f4647w = new ArrayList<>();
            hVar.f4638l = new w0.c(2);
            hVar.m = new w0.c(2);
            hVar.f4641p = null;
            hVar.f4642q = null;
            return hVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator k(ViewGroup viewGroup, n nVar, n nVar2) {
        return null;
    }

    public void l(ViewGroup viewGroup, w0.c cVar, w0.c cVar2, ArrayList<n> arrayList, ArrayList<n> arrayList2) {
        Animator k6;
        n nVar;
        View view;
        ViewGroup viewGroup2 = viewGroup;
        o.b<Animator, b> o6 = o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            n nVar2 = arrayList.get(i7);
            n nVar3 = arrayList2.get(i7);
            if (nVar2 != null && !nVar2.f4668c.contains(this)) {
                nVar2 = null;
            }
            if (nVar3 != null && !nVar3.f4668c.contains(this)) {
                nVar3 = null;
            }
            if (!(nVar2 == null && nVar3 == null)) {
                if ((nVar2 == null || nVar3 == null || r(nVar2, nVar3)) && (k6 = k(viewGroup2, nVar2, nVar3)) != null) {
                    if (nVar3 != null) {
                        View view2 = nVar3.f4667b;
                        String[] p6 = p();
                        if (p6 != null && p6.length > 0) {
                            nVar = new n(view2);
                            n nVar4 = (n) ((o.b) cVar2.f6337a).getOrDefault(view2, null);
                            if (nVar4 != null) {
                                int i8 = 0;
                                while (i8 < p6.length) {
                                    HashMap hashMap = nVar.f4666a;
                                    String str = p6[i8];
                                    hashMap.put(str, nVar4.f4666a.get(str));
                                    i8++;
                                    k6 = k6;
                                    p6 = p6;
                                }
                            }
                            int i9 = o6.f5221h;
                            int i10 = 0;
                            while (true) {
                                if (i10 >= i9) {
                                    break;
                                }
                                b orDefault = o6.getOrDefault(o6.h(i10), null);
                                if (orDefault.f4652c != null && orDefault.f4650a == view2 && orDefault.f4651b.equals(this.f4632f) && orDefault.f4652c.equals(nVar)) {
                                    k6 = null;
                                    break;
                                }
                                i10++;
                            }
                        } else {
                            k6 = k6;
                            nVar = null;
                        }
                        view = view2;
                    } else {
                        view = nVar2.f4667b;
                        k6 = k6;
                        nVar = null;
                    }
                    if (k6 != null) {
                        String str2 = this.f4632f;
                        o.a aVar = o.f4669a;
                        o6.put(k6, new b(view, str2, this, new w(viewGroup2), nVar));
                        this.f4647w.add(k6);
                    }
                    i7++;
                    viewGroup2 = viewGroup;
                }
            }
            i7++;
            viewGroup2 = viewGroup;
        }
        if (sparseIntArray.size() != 0) {
            for (int i11 = 0; i11 < sparseIntArray.size(); i11++) {
                Animator animator = this.f4647w.get(sparseIntArray.keyAt(i11));
                animator.setStartDelay(animator.getStartDelay() + (((long) sparseIntArray.valueAt(i11)) - Long.MAX_VALUE));
            }
        }
    }

    public final void m() {
        int i7 = this.s - 1;
        this.s = i7;
        if (i7 == 0) {
            ArrayList<d> arrayList = this.f4646v;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f4646v.clone();
                int size = arrayList2.size();
                for (int i8 = 0; i8 < size; i8++) {
                    ((d) arrayList2.get(i8)).c(this);
                }
            }
            int i9 = 0;
            while (true) {
                e eVar = (e) this.f4638l.f6339c;
                if (eVar.f5192f) {
                    eVar.c();
                }
                if (i9 >= eVar.f5195i) {
                    break;
                }
                View view = (View) ((e) this.f4638l.f6339c).f(i9);
                if (view != null) {
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    y.d.r(view, false);
                }
                i9++;
            }
            int i10 = 0;
            while (true) {
                e eVar2 = (e) this.m.f6339c;
                if (eVar2.f5192f) {
                    eVar2.c();
                }
                if (i10 < eVar2.f5195i) {
                    View view2 = (View) ((e) this.m.f6339c).f(i10);
                    if (view2 != null) {
                        WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                        y.d.r(view2, false);
                    }
                    i10++;
                } else {
                    this.f4645u = true;
                    return;
                }
            }
        }
    }

    public final n n(View view, boolean z6) {
        m mVar = this.f4639n;
        if (mVar != null) {
            return mVar.n(view, z6);
        }
        ArrayList<n> arrayList = z6 ? this.f4641p : this.f4642q;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i7 = -1;
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                break;
            }
            n nVar = arrayList.get(i8);
            if (nVar == null) {
                return null;
            }
            if (nVar.f4667b == view) {
                i7 = i8;
                break;
            }
            i8++;
        }
        if (i7 < 0) {
            return null;
        }
        return (z6 ? this.f4642q : this.f4641p).get(i7);
    }

    public String[] p() {
        return null;
    }

    public final n q(View view, boolean z6) {
        m mVar = this.f4639n;
        if (mVar != null) {
            return mVar.q(view, z6);
        }
        return (n) ((o.b) (z6 ? this.f4638l : this.m).f6337a).getOrDefault(view, null);
    }

    public boolean r(n nVar, n nVar2) {
        if (nVar == null || nVar2 == null) {
            return false;
        }
        String[] p6 = p();
        if (p6 != null) {
            for (String str : p6) {
                if (!t(nVar, nVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : nVar.f4666a.keySet()) {
            if (t(nVar, nVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    public final boolean s(View view) {
        return (this.f4636j.size() == 0 && this.f4637k.size() == 0) || this.f4636j.contains(Integer.valueOf(view.getId())) || this.f4637k.contains(view);
    }

    @Override // java.lang.Object
    public final String toString() {
        return G("");
    }

    public void u(View view) {
        int i7;
        if (!this.f4645u) {
            o.b<Animator, b> o6 = o();
            int i8 = o6.f5221h;
            o.a aVar = o.f4669a;
            WindowId windowId = view.getWindowId();
            int i9 = i8 - 1;
            while (true) {
                i7 = 0;
                if (i9 < 0) {
                    break;
                }
                b l6 = o6.l(i9);
                if (l6.f4650a != null) {
                    x xVar = l6.f4653d;
                    if ((xVar instanceof w) && ((w) xVar).f4684a.equals(windowId)) {
                        i7 = 1;
                    }
                    if (i7 != 0) {
                        o6.h(i9).pause();
                    }
                }
                i9--;
            }
            ArrayList<d> arrayList = this.f4646v;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f4646v.clone();
                int size = arrayList2.size();
                while (i7 < size) {
                    ((d) arrayList2.get(i7)).b();
                    i7++;
                }
            }
            this.f4644t = true;
        }
    }

    public void v(d dVar) {
        ArrayList<d> arrayList = this.f4646v;
        if (arrayList != null) {
            arrayList.remove(dVar);
            if (this.f4646v.size() == 0) {
                this.f4646v = null;
            }
        }
    }

    public void w(View view) {
        this.f4637k.remove(view);
    }

    public void x(ViewGroup viewGroup) {
        if (this.f4644t) {
            if (!this.f4645u) {
                o.b<Animator, b> o6 = o();
                int i7 = o6.f5221h;
                o.a aVar = o.f4669a;
                WindowId windowId = viewGroup.getWindowId();
                for (int i8 = i7 - 1; i8 >= 0; i8--) {
                    b l6 = o6.l(i8);
                    if (l6.f4650a != null) {
                        x xVar = l6.f4653d;
                        if ((xVar instanceof w) && ((w) xVar).f4684a.equals(windowId)) {
                            o6.h(i8).resume();
                        }
                    }
                }
                ArrayList<d> arrayList = this.f4646v;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f4646v.clone();
                    int size = arrayList2.size();
                    for (int i9 = 0; i9 < size; i9++) {
                        ((d) arrayList2.get(i9)).d();
                    }
                }
            }
            this.f4644t = false;
        }
    }

    public void y() {
        F();
        o.b<Animator, b> o6 = o();
        Iterator<Animator> it = this.f4647w.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (o6.containsKey(next)) {
                F();
                if (next != null) {
                    next.addListener(new i(this, o6));
                    long j7 = this.f4634h;
                    if (j7 >= 0) {
                        next.setDuration(j7);
                    }
                    long j8 = this.f4633g;
                    if (j8 >= 0) {
                        next.setStartDelay(next.getStartDelay() + j8);
                    }
                    TimeInterpolator timeInterpolator = this.f4635i;
                    if (timeInterpolator != null) {
                        next.setInterpolator(timeInterpolator);
                    }
                    next.addListener(new j(this));
                    next.start();
                }
            }
        }
        this.f4647w.clear();
        m();
    }

    public void z(long j7) {
        this.f4634h = j7;
    }
}
