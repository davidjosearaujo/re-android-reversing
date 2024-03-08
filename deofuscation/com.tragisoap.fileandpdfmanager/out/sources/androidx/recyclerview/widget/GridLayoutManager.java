package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.s0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import java.util.Arrays;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
import q1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public int[] G;
    public View[] H;
    public boolean E = false;
    public int F = -1;
    public final SparseIntArray I = new SparseIntArray();
    public final SparseIntArray J = new SparseIntArray();
    public a K = new a();
    public final Rect L = new Rect();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends c {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends RecyclerView.m {
        public int e = -1;

        /* renamed from: f */
        public int f1923f = 0;

        public b(int i7, int i8) {
            super(i7, i8);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class c {

        /* renamed from: a */
        public final SparseIntArray f1924a = new SparseIntArray();

        /* renamed from: b */
        public final SparseIntArray f1925b = new SparseIntArray();

        public static int a(int i7, int i8) {
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                i9++;
                if (i9 == i8) {
                    i10++;
                    i9 = 0;
                } else if (i9 > i8) {
                    i10++;
                    i9 = 1;
                }
            }
            return i9 + 1 > i8 ? i10 + 1 : i10;
        }

        public final void b() {
            this.f1924a.clear();
        }
    }

    public GridLayoutManager(int i7) {
        super(1);
        m1(i7);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        m1(RecyclerView.l.H(context, attributeSet, i7, i8).f2049b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final boolean A0() {
        return this.f1935z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void C0(RecyclerView.w wVar, LinearLayoutManager.c cVar, RecyclerView.l.c cVar2) {
        int i7 = this.F;
        for (int i8 = 0; i8 < this.F; i8++) {
            int i9 = cVar.f1947d;
            if ((i9 >= 0 && i9 < wVar.b()) && i7 > 0) {
                ((k.b) cVar2).a(cVar.f1947d, Math.max(0, cVar.f1949g));
                this.K.getClass();
                i7--;
                cVar.f1947d += cVar.e;
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int I(RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.f1926p == 0) {
            return this.F;
        }
        if (wVar.b() < 1) {
            return 0;
        }
        return i1(wVar.b() - 1, rVar, wVar) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View P0(RecyclerView.r rVar, RecyclerView.w wVar, boolean z6, boolean z7) {
        int i7;
        int w6 = w();
        int i8 = -1;
        if (z7) {
            i7 = w() - 1;
            w6 = -1;
        } else {
            i7 = 0;
            i8 = 1;
        }
        int b2 = wVar.b();
        H0();
        int k6 = this.f1928r.k();
        int g2 = this.f1928r.g();
        View view = null;
        View view2 = null;
        while (i7 != w6) {
            View v6 = v(i7);
            int G = RecyclerView.l.G(v6);
            if (G >= 0 && G < b2 && j1(G, rVar, wVar) == 0) {
                if (((RecyclerView.m) v6.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = v6;
                    }
                } else if (this.f1928r.e(v6) < g2 && this.f1928r.b(v6) >= k6) {
                    return v6;
                } else {
                    if (view == null) {
                        view = v6;
                    }
                }
            }
            i7 += i8;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00df, code lost:
        if (r13 == (r2 > r15)) goto L_0x00e1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x010f, code lost:
        if (r13 == (r2 > r9)) goto L_0x0111;
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View S(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.r r25, androidx.recyclerview.widget.RecyclerView.w r26) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.S(android.view.View, int, androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void U(RecyclerView.r rVar, RecyclerView.w wVar, f fVar) {
        super.U(rVar, wVar, fVar);
        fVar.h(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void V0(RecyclerView.r rVar, RecyclerView.w wVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z6;
        View b2;
        int j7 = this.f1928r.j();
        boolean z7 = j7 != 1073741824;
        int i16 = w() > 0 ? this.G[this.F] : 0;
        if (z7) {
            n1();
        }
        boolean z8 = cVar.e == 1;
        int i17 = this.F;
        if (!z8) {
            i17 = j1(cVar.f1947d, rVar, wVar) + k1(cVar.f1947d, rVar, wVar);
        }
        int i18 = 0;
        while (i18 < this.F) {
            int i19 = cVar.f1947d;
            if (!(i19 >= 0 && i19 < wVar.b()) || i17 <= 0) {
                break;
            }
            int i20 = cVar.f1947d;
            int k12 = k1(i20, rVar, wVar);
            if (k12 <= this.F) {
                i17 -= k12;
                if (i17 < 0 || (b2 = cVar.b(rVar)) == null) {
                    break;
                }
                this.H[i18] = b2;
                i18++;
            } else {
                throw new IllegalArgumentException("Item at position " + i20 + " requires " + k12 + " spans but GridLayoutManager has only " + this.F + " spans.");
            }
        }
        if (i18 == 0) {
            bVar.f1941b = true;
            return;
        }
        if (z8) {
            i7 = 1;
            i8 = i18;
            i9 = 0;
        } else {
            i9 = i18 - 1;
            i8 = -1;
            i7 = -1;
        }
        int i21 = 0;
        while (i9 != i8) {
            View view = this.H[i9];
            b bVar2 = (b) view.getLayoutParams();
            int k13 = k1(RecyclerView.l.G(view), rVar, wVar);
            bVar2.f1923f = k13;
            bVar2.e = i21;
            i21 += k13;
            i9 += i7;
        }
        float f7 = 0.0f;
        int i22 = 0;
        for (int i23 = 0; i23 < i18; i23++) {
            View view2 = this.H[i23];
            if (cVar.f1953k != null) {
                z6 = false;
                if (z8) {
                    b(view2, -1, true);
                } else {
                    b(view2, 0, true);
                }
            } else if (z8) {
                z6 = false;
                b(view2, -1, false);
            } else {
                z6 = false;
                b(view2, 0, false);
            }
            d(view2, this.L);
            l1(view2, j7, z6);
            int c7 = this.f1928r.c(view2);
            if (c7 > i22) {
                i22 = c7;
            }
            float d7 = (((float) this.f1928r.d(view2)) * 1.0f) / ((float) ((b) view2.getLayoutParams()).f1923f);
            if (d7 > f7) {
                f7 = d7;
            }
        }
        if (z7) {
            g1(Math.max(Math.round(f7 * ((float) this.F)), i16));
            i22 = 0;
            for (int i24 = 0; i24 < i18; i24++) {
                View view3 = this.H[i24];
                l1(view3, 1073741824, true);
                int c8 = this.f1928r.c(view3);
                if (c8 > i22) {
                    i22 = c8;
                }
            }
        }
        for (int i25 = 0; i25 < i18; i25++) {
            View view4 = this.H[i25];
            if (this.f1928r.c(view4) != i22) {
                b bVar3 = (b) view4.getLayoutParams();
                Rect rect = bVar3.f2053b;
                int i26 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar3).topMargin + ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin;
                int i27 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar3).leftMargin + ((ViewGroup.MarginLayoutParams) bVar3).rightMargin;
                int h12 = h1(bVar3.e, bVar3.f1923f);
                if (this.f1926p == 1) {
                    i15 = RecyclerView.l.x(h12, 1073741824, i27, ((ViewGroup.MarginLayoutParams) bVar3).width, false);
                    i14 = View.MeasureSpec.makeMeasureSpec(i22 - i26, 1073741824);
                } else {
                    i15 = View.MeasureSpec.makeMeasureSpec(i22 - i27, 1073741824);
                    i14 = RecyclerView.l.x(h12, 1073741824, i26, ((ViewGroup.MarginLayoutParams) bVar3).height, false);
                }
                if (x0(view4, i15, i14, (RecyclerView.m) view4.getLayoutParams())) {
                    view4.measure(i15, i14);
                }
            }
        }
        bVar.f1940a = i22;
        if (this.f1926p == 1) {
            if (cVar.f1948f == -1) {
                int i28 = cVar.f1945b;
                i11 = i28 - i22;
                i10 = i28;
            } else {
                i11 = cVar.f1945b;
                i10 = i22 + i11;
            }
            i13 = 0;
            i12 = 0;
        } else {
            int i29 = cVar.f1948f;
            int i30 = cVar.f1945b;
            if (i29 == -1) {
                i12 = i30 - i22;
                i11 = 0;
                i13 = i30;
            } else {
                i13 = i22 + i30;
                i11 = 0;
                i12 = i30;
            }
            i10 = i11;
        }
        for (int i31 = 0; i31 < i18; i31++) {
            View view5 = this.H[i31];
            b bVar4 = (b) view5.getLayoutParams();
            if (this.f1926p != 1) {
                i11 = F() + this.G[bVar4.e];
                i10 = this.f1928r.d(view5) + i11;
            } else if (U0()) {
                i13 = D() + this.G[this.F - bVar4.e];
                i12 = i13 - this.f1928r.d(view5);
            } else {
                i12 = this.G[bVar4.e] + D();
                i13 = this.f1928r.d(view5) + i12;
            }
            RecyclerView.l.M(view5, i12, i11, i13, i10);
            if (bVar4.c() || bVar4.b()) {
                bVar.f1942c = true;
            }
            bVar.f1943d = view5.hasFocusable() | bVar.f1943d;
        }
        Arrays.fill(this.H, (Object) null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void W(RecyclerView.r rVar, RecyclerView.w wVar, View view, f fVar) {
        int i7;
        int i8;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            V(view, fVar);
            return;
        }
        b bVar = (b) layoutParams;
        int i12 = i1(bVar.a(), rVar, wVar);
        int i9 = 1;
        if (this.f1926p == 0) {
            i12 = bVar.e;
            i9 = bVar.f1923f;
            i8 = i12;
            i7 = 1;
        } else {
            i8 = bVar.e;
            i7 = bVar.f1923f;
        }
        fVar.j(f.g.a(i12, i9, i8, i7, false));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void W0(RecyclerView.r rVar, RecyclerView.w wVar, LinearLayoutManager.a aVar, int i7) {
        n1();
        if (wVar.b() > 0 && !wVar.f2090g) {
            boolean z6 = i7 == 1;
            int j12 = j1(aVar.f1937b, rVar, wVar);
            if (z6) {
                while (j12 > 0) {
                    int i8 = aVar.f1937b;
                    if (i8 <= 0) {
                        break;
                    }
                    int i9 = i8 - 1;
                    aVar.f1937b = i9;
                    j12 = j1(i9, rVar, wVar);
                }
            } else {
                int b2 = wVar.b() - 1;
                int i10 = aVar.f1937b;
                while (i10 < b2) {
                    int i11 = i10 + 1;
                    int j13 = j1(i11, rVar, wVar);
                    if (j13 <= j12) {
                        break;
                    }
                    i10 = i11;
                    j12 = j13;
                }
                aVar.f1937b = i10;
            }
        }
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void X(int i7, int i8) {
        this.K.b();
        this.K.f1925b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void Y() {
        this.K.b();
        this.K.f1925b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void Z(int i7, int i8) {
        this.K.b();
        this.K.f1925b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void a0(int i7, int i8) {
        this.K.b();
        this.K.f1925b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void b0(int i7, int i8) {
        this.K.b();
        this.K.f1925b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final void c0(RecyclerView.r rVar, RecyclerView.w wVar) {
        if (wVar.f2090g) {
            int w6 = w();
            for (int i7 = 0; i7 < w6; i7++) {
                b bVar = (b) v(i7).getLayoutParams();
                int a7 = bVar.a();
                this.I.put(a7, bVar.f1923f);
                this.J.put(a7, bVar.e);
            }
        }
        super.c0(rVar, wVar);
        this.I.clear();
        this.J.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void c1(boolean z6) {
        if (!z6) {
            super.c1(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final void d0(RecyclerView.w wVar) {
        super.d0(wVar);
        this.E = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean g(RecyclerView.m mVar) {
        return mVar instanceof b;
    }

    public final void g1(int i7) {
        int i8;
        int[] iArr = this.G;
        int i9 = this.F;
        if (!(iArr != null && iArr.length == i9 + 1 && iArr[iArr.length - 1] == i7)) {
            iArr = new int[i9 + 1];
        }
        int i10 = 0;
        iArr[0] = 0;
        int i11 = i7 / i9;
        int i12 = i7 % i9;
        int i13 = 0;
        for (int i14 = 1; i14 <= i9; i14++) {
            i10 += i12;
            if (i10 <= 0 || i9 - i10 >= i12) {
                i8 = i11;
            } else {
                i8 = i11 + 1;
                i10 -= i9;
            }
            i13 += i8;
            iArr[i14] = i13;
        }
        this.G = iArr;
    }

    public final int h1(int i7, int i8) {
        if (this.f1926p != 1 || !U0()) {
            int[] iArr = this.G;
            return iArr[i8 + i7] - iArr[i7];
        }
        int[] iArr2 = this.G;
        int i9 = this.F;
        return iArr2[i9 - i7] - iArr2[(i9 - i7) - i8];
    }

    public final int i1(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (!wVar.f2090g) {
            a aVar = this.K;
            int i8 = this.F;
            aVar.getClass();
            return c.a(i7, i8);
        }
        int b2 = rVar.b(i7);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i7);
            return 0;
        }
        a aVar2 = this.K;
        int i9 = this.F;
        aVar2.getClass();
        return c.a(b2, i9);
    }

    public final int j1(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (!wVar.f2090g) {
            a aVar = this.K;
            int i8 = this.F;
            aVar.getClass();
            return i7 % i8;
        }
        int i9 = this.J.get(i7, -1);
        if (i9 != -1) {
            return i9;
        }
        int b2 = rVar.b(i7);
        if (b2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i7);
            return 0;
        }
        a aVar2 = this.K;
        int i10 = this.F;
        aVar2.getClass();
        return b2 % i10;
    }

    public final int k1(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (!wVar.f2090g) {
            this.K.getClass();
            return 1;
        }
        int i8 = this.I.get(i7, -1);
        if (i8 != -1) {
            return i8;
        }
        if (rVar.b(i7) == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i7);
            return 1;
        }
        this.K.getClass();
        return 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final int l(RecyclerView.w wVar) {
        return E0(wVar);
    }

    public final void l1(View view, int i7, boolean z6) {
        int i8;
        int i9;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f2053b;
        int i10 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i11 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int h12 = h1(bVar.e, bVar.f1923f);
        if (this.f1926p == 1) {
            i8 = RecyclerView.l.x(h12, i7, i11, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i9 = RecyclerView.l.x(this.f1928r.l(), this.m, i10, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            i9 = RecyclerView.l.x(h12, i7, i10, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            i8 = RecyclerView.l.x(this.f1928r.l(), this.f2043l, i11, ((ViewGroup.MarginLayoutParams) bVar).width, true);
        }
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        if (z6 ? x0(view, i8, i9, mVar) : v0(view, i8, i9, mVar)) {
            view.measure(i8, i9);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final int m(RecyclerView.w wVar) {
        return F0(wVar);
    }

    public final void m1(int i7) {
        if (i7 != this.F) {
            this.E = true;
            if (i7 >= 1) {
                this.F = i7;
                this.K.b();
                m0();
                return;
            }
            throw new IllegalArgumentException(s0.g("Span count should be at least 1. Provided ", i7));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final int n0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        n1();
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
        return super.n0(i7, rVar, wVar);
    }

    public final void n1() {
        int i7;
        int i8;
        if (this.f1926p == 1) {
            i8 = this.f2044n - E();
            i7 = D();
        } else {
            i8 = this.f2045o - C();
            i7 = F();
        }
        g1(i8 - i7);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final int o(RecyclerView.w wVar) {
        return E0(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final int p(RecyclerView.w wVar) {
        return F0(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final int p0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        n1();
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
        return super.p0(i7, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m s() {
        return this.f1926p == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void s0(Rect rect, int i7, int i8) {
        int i9;
        int i10;
        if (this.G == null) {
            super.s0(rect, i7, i8);
        }
        int E = E() + D();
        int C = C() + F();
        if (this.f1926p == 1) {
            int height = rect.height() + C;
            RecyclerView recyclerView = this.f2034b;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            i10 = RecyclerView.l.h(i8, height, y.d.d(recyclerView));
            int[] iArr = this.G;
            i9 = RecyclerView.l.h(i7, iArr[iArr.length - 1] + E, y.d.e(this.f2034b));
        } else {
            int width = rect.width() + E;
            RecyclerView recyclerView2 = this.f2034b;
            WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
            i9 = RecyclerView.l.h(i7, width, y.d.e(recyclerView2));
            int[] iArr2 = this.G;
            i10 = RecyclerView.l.h(i8, iArr2[iArr2.length - 1] + C, y.d.d(this.f2034b));
        }
        this.f2034b.setMeasuredDimension(i9, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m t(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m u(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int y(RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.f1926p == 1) {
            return this.F;
        }
        if (wVar.b() < 1) {
            return 0;
        }
        return i1(wVar.b() - 1, rVar, wVar) + 1;
    }
}
