package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public final InterfaceC0022b f2155a;
    public View e;

    /* renamed from: d */
    public int f2158d = 0;

    /* renamed from: b */
    public final a f2156b = new a();

    /* renamed from: c */
    public final ArrayList f2157c = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public long f2159a = 0;

        /* renamed from: b */
        public a f2160b;

        public final void a(int i7) {
            if (i7 < 64) {
                this.f2159a &= ~(1 << i7);
                return;
            }
            a aVar = this.f2160b;
            if (aVar != null) {
                aVar.a(i7 - 64);
            }
        }

        public final int b(int i7) {
            a aVar = this.f2160b;
            if (aVar == null) {
                if (i7 >= 64) {
                    return Long.bitCount(this.f2159a);
                }
                return Long.bitCount(((1 << i7) - 1) & this.f2159a);
            } else if (i7 < 64) {
                return Long.bitCount(((1 << i7) - 1) & this.f2159a);
            } else {
                return Long.bitCount(this.f2159a) + aVar.b(i7 - 64);
            }
        }

        public final void c() {
            if (this.f2160b == null) {
                this.f2160b = new a();
            }
        }

        public final boolean d(int i7) {
            if (i7 < 64) {
                return ((1 << i7) & this.f2159a) != 0;
            }
            c();
            return this.f2160b.d(i7 - 64);
        }

        public final void e(int i7, boolean z6) {
            if (i7 >= 64) {
                c();
                this.f2160b.e(i7 - 64, z6);
                return;
            }
            long j5 = this.f2159a;
            boolean z7 = (Long.MIN_VALUE & j5) != 0;
            long j7 = (1 << i7) - 1;
            this.f2159a = ((j5 & (~j7)) << 1) | (j5 & j7);
            if (z6) {
                h(i7);
            } else {
                a(i7);
            }
            if (z7 || this.f2160b != null) {
                c();
                this.f2160b.e(0, z7);
            }
        }

        public final boolean f(int i7) {
            if (i7 >= 64) {
                c();
                return this.f2160b.f(i7 - 64);
            }
            long j5 = 1 << i7;
            long j7 = this.f2159a;
            boolean z6 = (j7 & j5) != 0;
            long j8 = j7 & (~j5);
            this.f2159a = j8;
            long j9 = j5 - 1;
            this.f2159a = (j8 & j9) | Long.rotateRight((~j9) & j8, 1);
            a aVar = this.f2160b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f2160b.f(0);
            }
            return z6;
        }

        public final void g() {
            this.f2159a = 0L;
            a aVar = this.f2160b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public final void h(int i7) {
            if (i7 < 64) {
                this.f2159a |= 1 << i7;
                return;
            }
            c();
            this.f2160b.h(i7 - 64);
        }

        public final String toString() {
            if (this.f2160b == null) {
                return Long.toBinaryString(this.f2159a);
            }
            return this.f2160b.toString() + "xx" + Long.toBinaryString(this.f2159a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0022b {
    }

    public b(t tVar) {
        this.f2155a = tVar;
    }

    public final void a(View view, int i7, boolean z6) {
        int a7 = i7 < 0 ? ((t) this.f2155a).a() : f(i7);
        this.f2156b.e(a7, z6);
        if (z6) {
            i(view);
        }
        t tVar = (t) this.f2155a;
        tVar.f2275a.addView(view, a7);
        tVar.f2275a.getClass();
        RecyclerView.L(view);
    }

    public final void b(View view, int i7, ViewGroup.LayoutParams layoutParams, boolean z6) {
        int a7 = i7 < 0 ? ((t) this.f2155a).a() : f(i7);
        this.f2156b.e(a7, z6);
        if (z6) {
            i(view);
        }
        t tVar = (t) this.f2155a;
        tVar.getClass();
        RecyclerView.a0 L = RecyclerView.L(view);
        if (L != null) {
            if (!L.k() && !L.o()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(L);
                throw new IllegalArgumentException(androidx.activity.h.b(tVar.f2275a, sb));
            }
            if (RecyclerView.E0) {
                Log.d("RecyclerView", "reAttach " + L);
            }
            L.f2013j &= -257;
        } else if (RecyclerView.D0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(a7);
            throw new IllegalArgumentException(androidx.activity.h.b(tVar.f2275a, sb2));
        }
        tVar.f2275a.attachViewToParent(view, a7, layoutParams);
    }

    public final void c(int i7) {
        int f7 = f(i7);
        this.f2156b.f(f7);
        t tVar = (t) this.f2155a;
        View childAt = tVar.f2275a.getChildAt(f7);
        if (childAt != null) {
            RecyclerView.a0 L = RecyclerView.L(childAt);
            if (L != null) {
                if (L.k() && !L.o()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("called detach on an already detached child ");
                    sb.append(L);
                    throw new IllegalArgumentException(androidx.activity.h.b(tVar.f2275a, sb));
                }
                if (RecyclerView.E0) {
                    Log.d("RecyclerView", "tmpDetach " + L);
                }
                L.b(256);
            }
        } else if (RecyclerView.D0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No view at offset ");
            sb2.append(f7);
            throw new IllegalArgumentException(androidx.activity.h.b(tVar.f2275a, sb2));
        }
        tVar.f2275a.detachViewFromParent(f7);
    }

    public final View d(int i7) {
        return ((t) this.f2155a).f2275a.getChildAt(f(i7));
    }

    public final int e() {
        return ((t) this.f2155a).a() - this.f2157c.size();
    }

    public final int f(int i7) {
        if (i7 < 0) {
            return -1;
        }
        int a7 = ((t) this.f2155a).a();
        int i8 = i7;
        while (i8 < a7) {
            int b2 = i7 - (i8 - this.f2156b.b(i8));
            if (b2 == 0) {
                while (this.f2156b.d(i8)) {
                    i8++;
                }
                return i8;
            }
            i8 += b2;
        }
        return -1;
    }

    public final View g(int i7) {
        return ((t) this.f2155a).f2275a.getChildAt(i7);
    }

    public final int h() {
        return ((t) this.f2155a).a();
    }

    public final void i(View view) {
        this.f2157c.add(view);
        t tVar = (t) this.f2155a;
        tVar.getClass();
        RecyclerView.a0 L = RecyclerView.L(view);
        if (L != null) {
            RecyclerView recyclerView = tVar.f2275a;
            int i7 = L.f2019q;
            if (i7 == -1) {
                View view2 = L.f2005a;
                WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
                i7 = y.d.c(view2);
            }
            L.f2018p = i7;
            if (recyclerView.O()) {
                L.f2019q = 4;
                recyclerView.f1998x0.add(L);
                return;
            }
            View view3 = L.f2005a;
            WeakHashMap<View, k0> weakHashMap2 = p1.y.f5540a;
            y.d.s(view3, 4);
        }
    }

    public final int j(View view) {
        int indexOfChild = ((t) this.f2155a).f2275a.indexOfChild(view);
        if (indexOfChild == -1 || this.f2156b.d(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.f2156b.b(indexOfChild);
    }

    public final boolean k(View view) {
        return this.f2157c.contains(view);
    }

    public final void l(View view) {
        if (this.f2157c.remove(view)) {
            t tVar = (t) this.f2155a;
            tVar.getClass();
            RecyclerView.a0 L = RecyclerView.L(view);
            if (L != null) {
                RecyclerView recyclerView = tVar.f2275a;
                int i7 = L.f2018p;
                if (recyclerView.O()) {
                    L.f2019q = i7;
                    recyclerView.f1998x0.add(L);
                } else {
                    View view2 = L.f2005a;
                    WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
                    y.d.s(view2, i7);
                }
                L.f2018p = 0;
            }
        }
    }

    public final String toString() {
        return this.f2156b.toString() + ", hidden list:" + this.f2157c.size();
    }
}
