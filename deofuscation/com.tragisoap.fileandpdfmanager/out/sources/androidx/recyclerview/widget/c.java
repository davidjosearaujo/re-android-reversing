package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.activity.h;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends x {
    public static TimeInterpolator s;

    /* renamed from: h */
    public ArrayList<RecyclerView.a0> f2161h = new ArrayList<>();

    /* renamed from: i */
    public ArrayList<RecyclerView.a0> f2162i = new ArrayList<>();

    /* renamed from: j */
    public ArrayList<e> f2163j = new ArrayList<>();

    /* renamed from: k */
    public ArrayList<d> f2164k = new ArrayList<>();

    /* renamed from: l */
    public ArrayList<ArrayList<RecyclerView.a0>> f2165l = new ArrayList<>();
    public ArrayList<ArrayList<e>> m = new ArrayList<>();

    /* renamed from: n */
    public ArrayList<ArrayList<d>> f2166n = new ArrayList<>();

    /* renamed from: o */
    public ArrayList<RecyclerView.a0> f2167o = new ArrayList<>();

    /* renamed from: p */
    public ArrayList<RecyclerView.a0> f2168p = new ArrayList<>();

    /* renamed from: q */
    public ArrayList<RecyclerView.a0> f2169q = new ArrayList<>();

    /* renamed from: r */
    public ArrayList<RecyclerView.a0> f2170r = new ArrayList<>();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ ArrayList f2171f;

        public a(ArrayList arrayList) {
            c.this = r1;
            this.f2171f = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = this.f2171f.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                c cVar = c.this;
                RecyclerView.a0 a0Var = eVar.f2182a;
                int i7 = eVar.f2183b;
                int i8 = eVar.f2184c;
                int i9 = eVar.f2185d;
                int i10 = eVar.e;
                cVar.getClass();
                View view = a0Var.f2005a;
                int i11 = i9 - i7;
                int i12 = i10 - i8;
                if (i11 != 0) {
                    view.animate().translationX(0.0f);
                }
                if (i12 != 0) {
                    view.animate().translationY(0.0f);
                }
                ViewPropertyAnimator animate = view.animate();
                cVar.f2168p.add(a0Var);
                animate.setDuration(cVar.e).setListener(new f(cVar, a0Var, i11, view, i12, animate)).start();
            }
            this.f2171f.clear();
            c.this.m.remove(this.f2171f);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ ArrayList f2173f;

        public b(ArrayList arrayList) {
            c.this = r1;
            this.f2173f = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = this.f2173f.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                c cVar = c.this;
                cVar.getClass();
                RecyclerView.a0 a0Var = dVar.f2177a;
                View view = null;
                View view2 = a0Var == null ? null : a0Var.f2005a;
                RecyclerView.a0 a0Var2 = dVar.f2178b;
                if (a0Var2 != null) {
                    view = a0Var2.f2005a;
                }
                if (view2 != null) {
                    ViewPropertyAnimator duration = view2.animate().setDuration(cVar.f2029f);
                    cVar.f2170r.add(dVar.f2177a);
                    duration.translationX((float) (dVar.e - dVar.f2179c));
                    duration.translationY((float) (dVar.f2181f - dVar.f2180d));
                    duration.alpha(0.0f).setListener(new g(cVar, dVar, duration, view2)).start();
                }
                if (view != null) {
                    ViewPropertyAnimator animate = view.animate();
                    cVar.f2170r.add(dVar.f2178b);
                    animate.translationX(0.0f).translationY(0.0f).setDuration(cVar.f2029f).alpha(1.0f).setListener(new h(cVar, dVar, animate, view)).start();
                }
            }
            this.f2173f.clear();
            c.this.f2166n.remove(this.f2173f);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class RunnableC0023c implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ ArrayList f2175f;

        public RunnableC0023c(ArrayList arrayList) {
            c.this = r1;
            this.f2175f = arrayList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = this.f2175f.iterator();
            while (it.hasNext()) {
                RecyclerView.a0 a0Var = (RecyclerView.a0) it.next();
                c cVar = c.this;
                cVar.getClass();
                View view = a0Var.f2005a;
                ViewPropertyAnimator animate = view.animate();
                cVar.f2167o.add(a0Var);
                animate.alpha(1.0f).setDuration(cVar.f2027c).setListener(new e(view, animate, cVar, a0Var)).start();
            }
            this.f2175f.clear();
            c.this.f2165l.remove(this.f2175f);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d {

        /* renamed from: a */
        public RecyclerView.a0 f2177a;

        /* renamed from: b */
        public RecyclerView.a0 f2178b;

        /* renamed from: c */
        public int f2179c;

        /* renamed from: d */
        public int f2180d;
        public int e;

        /* renamed from: f */
        public int f2181f;

        public d(RecyclerView.a0 a0Var, RecyclerView.a0 a0Var2, int i7, int i8, int i9, int i10) {
            this.f2177a = a0Var;
            this.f2178b = a0Var2;
            this.f2179c = i7;
            this.f2180d = i8;
            this.e = i9;
            this.f2181f = i10;
        }

        @SuppressLint({"UnknownNullness"})
        public final String toString() {
            StringBuilder d7 = h.d("ChangeInfo{oldHolder=");
            d7.append(this.f2177a);
            d7.append(", newHolder=");
            d7.append(this.f2178b);
            d7.append(", fromX=");
            d7.append(this.f2179c);
            d7.append(", fromY=");
            d7.append(this.f2180d);
            d7.append(", toX=");
            d7.append(this.e);
            d7.append(", toY=");
            d7.append(this.f2181f);
            d7.append('}');
            return d7.toString();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e {

        /* renamed from: a */
        public RecyclerView.a0 f2182a;

        /* renamed from: b */
        public int f2183b;

        /* renamed from: c */
        public int f2184c;

        /* renamed from: d */
        public int f2185d;
        public int e;

        public e(RecyclerView.a0 a0Var, int i7, int i8, int i9, int i10) {
            this.f2182a = a0Var;
            this.f2183b = i7;
            this.f2184c = i8;
            this.f2185d = i9;
            this.e = i10;
        }
    }

    public static void o(ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                ((RecyclerView.a0) arrayList.get(size)).f2005a.animate().cancel();
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean f(RecyclerView.a0 a0Var, List<Object> list) {
        return !list.isEmpty() || n(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    @SuppressLint({"UnknownNullness"})
    public final void i(RecyclerView.a0 a0Var) {
        View view = a0Var.f2005a;
        view.animate().cancel();
        int size = this.f2163j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f2163j.get(size).f2182a == a0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                g(a0Var);
                this.f2163j.remove(size);
            }
        }
        q(a0Var, this.f2164k);
        if (this.f2161h.remove(a0Var)) {
            view.setAlpha(1.0f);
            g(a0Var);
        }
        if (this.f2162i.remove(a0Var)) {
            view.setAlpha(1.0f);
            g(a0Var);
        }
        int size2 = this.f2166n.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList<d> arrayList = this.f2166n.get(size2);
            q(a0Var, arrayList);
            if (arrayList.isEmpty()) {
                this.f2166n.remove(size2);
            }
        }
        int size3 = this.m.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList<e> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f2182a == a0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    g(a0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                }
            }
        }
        int size5 = this.f2165l.size();
        while (true) {
            size5--;
            if (size5 >= 0) {
                ArrayList<RecyclerView.a0> arrayList3 = this.f2165l.get(size5);
                if (arrayList3.remove(a0Var)) {
                    view.setAlpha(1.0f);
                    g(a0Var);
                    if (arrayList3.isEmpty()) {
                        this.f2165l.remove(size5);
                    }
                }
            } else {
                this.f2169q.remove(a0Var);
                this.f2167o.remove(a0Var);
                this.f2170r.remove(a0Var);
                this.f2168p.remove(a0Var);
                p();
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final void j() {
        int size = this.f2163j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            e eVar = this.f2163j.get(size);
            View view = eVar.f2182a.f2005a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            g(eVar.f2182a);
            this.f2163j.remove(size);
        }
        int size2 = this.f2161h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            g(this.f2161h.get(size2));
            this.f2161h.remove(size2);
        }
        int size3 = this.f2162i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.a0 a0Var = this.f2162i.get(size3);
            a0Var.f2005a.setAlpha(1.0f);
            g(a0Var);
            this.f2162i.remove(size3);
        }
        int size4 = this.f2164k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            d dVar = this.f2164k.get(size4);
            RecyclerView.a0 a0Var2 = dVar.f2177a;
            if (a0Var2 != null) {
                r(dVar, a0Var2);
            }
            RecyclerView.a0 a0Var3 = dVar.f2178b;
            if (a0Var3 != null) {
                r(dVar, a0Var3);
            }
        }
        this.f2164k.clear();
        if (k()) {
            int size5 = this.m.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList<e> arrayList = this.m.get(size5);
                int size6 = arrayList.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        e eVar2 = arrayList.get(size6);
                        View view2 = eVar2.f2182a.f2005a;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        g(eVar2.f2182a);
                        arrayList.remove(size6);
                        if (arrayList.isEmpty()) {
                            this.m.remove(arrayList);
                        }
                    }
                }
            }
            int size7 = this.f2165l.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList<RecyclerView.a0> arrayList2 = this.f2165l.get(size7);
                int size8 = arrayList2.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        RecyclerView.a0 a0Var4 = arrayList2.get(size8);
                        a0Var4.f2005a.setAlpha(1.0f);
                        g(a0Var4);
                        arrayList2.remove(size8);
                        if (arrayList2.isEmpty()) {
                            this.f2165l.remove(arrayList2);
                        }
                    }
                }
            }
            int size9 = this.f2166n.size();
            while (true) {
                size9--;
                if (size9 >= 0) {
                    ArrayList<d> arrayList3 = this.f2166n.get(size9);
                    int size10 = arrayList3.size();
                    while (true) {
                        size10--;
                        if (size10 >= 0) {
                            d dVar2 = arrayList3.get(size10);
                            RecyclerView.a0 a0Var5 = dVar2.f2177a;
                            if (a0Var5 != null) {
                                r(dVar2, a0Var5);
                            }
                            RecyclerView.a0 a0Var6 = dVar2.f2178b;
                            if (a0Var6 != null) {
                                r(dVar2, a0Var6);
                            }
                            if (arrayList3.isEmpty()) {
                                this.f2166n.remove(arrayList3);
                            }
                        }
                    }
                } else {
                    o(this.f2169q);
                    o(this.f2168p);
                    o(this.f2167o);
                    o(this.f2170r);
                    h();
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final boolean k() {
        return !this.f2162i.isEmpty() || !this.f2164k.isEmpty() || !this.f2163j.isEmpty() || !this.f2161h.isEmpty() || !this.f2168p.isEmpty() || !this.f2169q.isEmpty() || !this.f2167o.isEmpty() || !this.f2170r.isEmpty() || !this.m.isEmpty() || !this.f2165l.isEmpty() || !this.f2166n.isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public final void l() {
        boolean z6 = !this.f2161h.isEmpty();
        boolean z7 = !this.f2163j.isEmpty();
        boolean z8 = !this.f2164k.isEmpty();
        boolean z9 = !this.f2162i.isEmpty();
        if (z6 || z7 || z9 || z8) {
            Iterator<RecyclerView.a0> it = this.f2161h.iterator();
            while (it.hasNext()) {
                RecyclerView.a0 next = it.next();
                View view = next.f2005a;
                ViewPropertyAnimator animate = view.animate();
                this.f2169q.add(next);
                animate.setDuration(this.f2028d).alpha(0.0f).setListener(new d(view, animate, this, next)).start();
            }
            this.f2161h.clear();
            if (z7) {
                ArrayList<e> arrayList = new ArrayList<>();
                arrayList.addAll(this.f2163j);
                this.m.add(arrayList);
                this.f2163j.clear();
                a aVar = new a(arrayList);
                if (z6) {
                    View view2 = arrayList.get(0).f2182a.f2005a;
                    long j7 = this.f2028d;
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    y.d.n(view2, aVar, j7);
                } else {
                    aVar.run();
                }
            }
            if (z8) {
                ArrayList<d> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f2164k);
                this.f2166n.add(arrayList2);
                this.f2164k.clear();
                b bVar = new b(arrayList2);
                if (z6) {
                    View view3 = arrayList2.get(0).f2177a.f2005a;
                    long j8 = this.f2028d;
                    WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                    y.d.n(view3, bVar, j8);
                } else {
                    bVar.run();
                }
            }
            if (z9) {
                ArrayList<RecyclerView.a0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f2162i);
                this.f2165l.add(arrayList3);
                this.f2162i.clear();
                RunnableC0023c cVar = new RunnableC0023c(arrayList3);
                if (z6 || z7 || z8) {
                    long j9 = 0;
                    long j10 = z6 ? this.f2028d : 0;
                    long j11 = z7 ? this.e : 0;
                    if (z8) {
                        j9 = this.f2029f;
                    }
                    View view4 = arrayList3.get(0).f2005a;
                    WeakHashMap<View, k0> weakHashMap3 = y.f5540a;
                    y.d.n(view4, cVar, Math.max(j11, j9) + j10);
                    return;
                }
                cVar.run();
            }
        }
    }

    @Override // androidx.recyclerview.widget.x
    @SuppressLint({"UnknownNullness"})
    public final boolean m(RecyclerView.a0 a0Var, int i7, int i8, int i9, int i10) {
        View view = a0Var.f2005a;
        int translationX = i7 + ((int) view.getTranslationX());
        int translationY = i8 + ((int) a0Var.f2005a.getTranslationY());
        s(a0Var);
        int i11 = i9 - translationX;
        int i12 = i10 - translationY;
        if (i11 == 0 && i12 == 0) {
            g(a0Var);
            return false;
        }
        if (i11 != 0) {
            view.setTranslationX((float) (-i11));
        }
        if (i12 != 0) {
            view.setTranslationY((float) (-i12));
        }
        this.f2163j.add(new e(a0Var, translationX, translationY, i9, i10));
        return true;
    }

    public final void p() {
        if (!k()) {
            h();
        }
    }

    public final void q(RecyclerView.a0 a0Var, ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                d dVar = (d) arrayList.get(size);
                if (r(dVar, a0Var) && dVar.f2177a == null && dVar.f2178b == null) {
                    arrayList.remove(dVar);
                }
            } else {
                return;
            }
        }
    }

    public final boolean r(d dVar, RecyclerView.a0 a0Var) {
        if (dVar.f2178b == a0Var) {
            dVar.f2178b = null;
        } else if (dVar.f2177a != a0Var) {
            return false;
        } else {
            dVar.f2177a = null;
        }
        a0Var.f2005a.setAlpha(1.0f);
        a0Var.f2005a.setTranslationX(0.0f);
        a0Var.f2005a.setTranslationY(0.0f);
        g(a0Var);
        return true;
    }

    public final void s(RecyclerView.a0 a0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        a0Var.f2005a.animate().setInterpolator(s);
        i(a0Var);
    }
}
