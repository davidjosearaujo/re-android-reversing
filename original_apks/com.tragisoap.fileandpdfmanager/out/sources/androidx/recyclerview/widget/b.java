package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.h;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {

    /* renamed from: a */
    public final AbstractC0022b f2155a;
    public View e;

    /* renamed from: d */
    public int f2158d = 0;

    /* renamed from: b */
    public final a f2156b = new a();

    /* renamed from: c */
    public final ArrayList f2157c = new ArrayList();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a */
        public long f2159a = 0;

        /* renamed from: b */
        public a f2160b;

        public final void a(int i7) {
            if (i7 >= 64) {
                a aVar = this.f2160b;
                if (aVar != null) {
                    aVar.a(i7 - 64);
                    return;
                }
                return;
            }
            this.f2159a &= ~(1 << i7);
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
            if (i7 >= 64) {
                c();
                return this.f2160b.d(i7 - 64);
            }
            return ((1 << i7) & this.f2159a) != 0;
        }

        public final void e(int i7, boolean z6) {
            if (i7 >= 64) {
                c();
                this.f2160b.e(i7 - 64, z6);
                return;
            }
            long j7 = this.f2159a;
            boolean z7 = (Long.MIN_VALUE & j7) != 0;
            long j8 = (1 << i7) - 1;
            this.f2159a = ((j7 & (~j8)) << 1) | (j7 & j8);
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
            long j7 = 1 << i7;
            long j8 = this.f2159a;
            boolean z6 = (j8 & j7) != 0;
            long j9 = j8 & (~j7);
            this.f2159a = j9;
            long j10 = j7 - 1;
            this.f2159a = (j9 & j10) | Long.rotateRight((~j10) & j9, 1);
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
            this.f2159a = 0;
            a aVar = this.f2160b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public final void h(int i7) {
            if (i7 >= 64) {
                c();
                this.f2160b.h(i7 - 64);
                return;
            }
            this.f2159a |= 1 << i7;
        }

        public final String toString() {
            if (this.f2160b == null) {
                return Long.toBinaryString(this.f2159a);
            }
            return this.f2160b.toString() + "xx" + Long.toBinaryString(this.f2159a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface AbstractC0022b {
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
            if (L.k() || L.o()) {
                if (RecyclerView.E0) {
                    Log.d("RecyclerView", "reAttach " + L);
                }
                L.f2013j &= -257;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(L);
                throw new IllegalArgumentException(h.b(tVar.f2275a, sb));
            }
        } else if (RecyclerView.D0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(a7);
            throw new IllegalArgumentException(h.b(tVar.f2275a, sb2));
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
                if (!L.k() || L.o()) {
                    if (RecyclerView.E0) {
                        Log.d("RecyclerView", "tmpDetach " + L);
                    }
                    L.b(256);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("called detach on an already detached child ");
                    sb.append(L);
                    throw new IllegalArgumentException(h.b(tVar.f2275a, sb));
                }
            }
        } else if (RecyclerView.D0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No view at offset ");
            sb2.append(f7);
            throw new IllegalArgumentException(h.b(tVar.f2275a, sb2));
        }
        tVar.f2275a.detachViewFromParent(f7);
    }

    public final View d(int i7) {
        return ((t) this.f2155a).f2275a.getChildAt(f(i7));
    }

    public final int e() {
        return ((t) this.f2155a).a() - this.f2157c.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r4.f2156b.d(r2) == false) goto L_0x0026;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(int r5) {
        /*
            r4 = this;
            r0 = -1
            if (r5 >= 0) goto L_0x0004
            return r0
        L_0x0004:
            androidx.recyclerview.widget.b$b r1 = r4.f2155a
            androidx.recyclerview.widget.t r1 = (androidx.recyclerview.widget.t) r1
            int r1 = r1.a()
            r2 = r5
        L_0x000d:
            if (r2 >= r1) goto L_0x0029
            androidx.recyclerview.widget.b$a r3 = r4.f2156b
            int r3 = r3.b(r2)
            int r3 = r2 - r3
            int r3 = r5 - r3
            if (r3 != 0) goto L_0x0027
        L_0x001b:
            androidx.recyclerview.widget.b$a r5 = r4.f2156b
            boolean r5 = r5.d(r2)
            if (r5 == 0) goto L_0x0026
            int r2 = r2 + 1
            goto L_0x001b
        L_0x0026:
            return r2
        L_0x0027:
            int r2 = r2 + r3
            goto L_0x000d
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.b.f(int):int");
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
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                i7 = y.d.c(view2);
            }
            L.f2018p = i7;
            if (recyclerView.O()) {
                L.f2019q = 4;
                recyclerView.f1998x0.add(L);
                return;
            }
            View view3 = L.f2005a;
            WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
            y.d.s(view3, 4);
        }
    }

    public final int j(View view) {
        int indexOfChild = ((t) this.f2155a).f2275a.indexOfChild(view);
        if (indexOfChild != -1 && !this.f2156b.d(indexOfChild)) {
            return indexOfChild - this.f2156b.b(indexOfChild);
        }
        return -1;
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
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
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
