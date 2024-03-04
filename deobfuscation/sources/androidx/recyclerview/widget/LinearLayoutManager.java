package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.s0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.l implements RecyclerView.v.b {
    public final a A;
    public final b B;
    public int C;
    public int[] D;

    /* renamed from: p */
    public int f1926p;

    /* renamed from: q */
    public c f1927q;

    /* renamed from: r */
    public q f1928r;
    public boolean s;

    /* renamed from: t */
    public boolean f1929t;

    /* renamed from: u */
    public boolean f1930u;

    /* renamed from: v */
    public boolean f1931v;

    /* renamed from: w */
    public boolean f1932w;

    /* renamed from: x */
    public int f1933x;

    /* renamed from: y */
    public int f1934y;

    /* renamed from: z */
    public d f1935z;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public q f1936a;

        /* renamed from: b */
        public int f1937b;

        /* renamed from: c */
        public int f1938c;

        /* renamed from: d */
        public boolean f1939d;
        public boolean e;

        public a() {
            c();
        }

        public final void a(View view, int i7) {
            if (this.f1939d) {
                this.f1938c = this.f1936a.m() + this.f1936a.b(view);
            } else {
                this.f1938c = this.f1936a.e(view);
            }
            this.f1937b = i7;
        }

        public final void b(View view, int i7) {
            int min;
            int m = this.f1936a.m();
            if (m >= 0) {
                a(view, i7);
                return;
            }
            this.f1937b = i7;
            if (this.f1939d) {
                int g2 = (this.f1936a.g() - m) - this.f1936a.b(view);
                this.f1938c = this.f1936a.g() - g2;
                if (g2 <= 0) {
                    return;
                }
                int c7 = this.f1938c - this.f1936a.c(view);
                int k6 = this.f1936a.k();
                int min2 = c7 - (Math.min(this.f1936a.e(view) - k6, 0) + k6);
                if (min2 >= 0) {
                    return;
                }
                min = Math.min(g2, -min2) + this.f1938c;
            } else {
                int e = this.f1936a.e(view);
                int k7 = e - this.f1936a.k();
                this.f1938c = e;
                if (k7 <= 0) {
                    return;
                }
                int g7 = (this.f1936a.g() - Math.min(0, (this.f1936a.g() - m) - this.f1936a.b(view))) - (this.f1936a.c(view) + e);
                if (g7 >= 0) {
                    return;
                }
                min = this.f1938c - Math.min(k7, -g7);
            }
            this.f1938c = min;
        }

        public final void c() {
            this.f1937b = -1;
            this.f1938c = Integer.MIN_VALUE;
            this.f1939d = false;
            this.e = false;
        }

        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("AnchorInfo{mPosition=");
            d7.append(this.f1937b);
            d7.append(", mCoordinate=");
            d7.append(this.f1938c);
            d7.append(", mLayoutFromEnd=");
            d7.append(this.f1939d);
            d7.append(", mValid=");
            d7.append(this.e);
            d7.append('}');
            return d7.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public int f1940a;

        /* renamed from: b */
        public boolean f1941b;

        /* renamed from: c */
        public boolean f1942c;

        /* renamed from: d */
        public boolean f1943d;
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b */
        public int f1945b;

        /* renamed from: c */
        public int f1946c;

        /* renamed from: d */
        public int f1947d;
        public int e;

        /* renamed from: f */
        public int f1948f;

        /* renamed from: g */
        public int f1949g;

        /* renamed from: j */
        public int f1952j;

        /* renamed from: l */
        public boolean f1954l;

        /* renamed from: a */
        public boolean f1944a = true;

        /* renamed from: h */
        public int f1950h = 0;

        /* renamed from: i */
        public int f1951i = 0;

        /* renamed from: k */
        public List<RecyclerView.a0> f1953k = null;

        public final void a(View view) {
            int a7;
            int size = this.f1953k.size();
            View view2 = null;
            int i7 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            for (int i8 = 0; i8 < size; i8++) {
                View view3 = this.f1953k.get(i8).f2005a;
                RecyclerView.m mVar = (RecyclerView.m) view3.getLayoutParams();
                if (view3 != view && !mVar.c() && (a7 = (mVar.a() - this.f1947d) * this.e) >= 0 && a7 < i7) {
                    view2 = view3;
                    if (a7 == 0) {
                        break;
                    }
                    i7 = a7;
                }
            }
            this.f1947d = view2 == null ? -1 : ((RecyclerView.m) view2.getLayoutParams()).a();
        }

        public final View b(RecyclerView.r rVar) {
            List<RecyclerView.a0> list = this.f1953k;
            if (list == null) {
                View d7 = rVar.d(this.f1947d);
                this.f1947d += this.e;
                return d7;
            }
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = this.f1953k.get(i7).f2005a;
                RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
                if (!mVar.c() && this.f1947d == mVar.a()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: f */
        public int f1955f;

        /* renamed from: g */
        public int f1956g;

        /* renamed from: h */
        public boolean f1957h;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            public final d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final d[] newArray(int i7) {
                return new d[i7];
            }
        }

        public d() {
        }

        public d(Parcel parcel) {
            this.f1955f = parcel.readInt();
            this.f1956g = parcel.readInt();
            this.f1957h = parcel.readInt() == 1;
        }

        @SuppressLint({"UnknownNullness"})
        public d(d dVar) {
            this.f1955f = dVar.f1955f;
            this.f1956g = dVar.f1956g;
            this.f1957h = dVar.f1957h;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeInt(this.f1955f);
            parcel.writeInt(this.f1956g);
            parcel.writeInt(this.f1957h ? 1 : 0);
        }
    }

    public LinearLayoutManager() {
        this(1);
    }

    public LinearLayoutManager(int i7) {
        this.f1926p = 1;
        this.f1929t = false;
        this.f1930u = false;
        this.f1931v = false;
        this.f1932w = true;
        this.f1933x = -1;
        this.f1934y = Integer.MIN_VALUE;
        this.f1935z = null;
        this.A = new a();
        this.B = new b();
        this.C = 2;
        this.D = new int[2];
        b1(i7);
        c(null);
        if (this.f1929t) {
            this.f1929t = false;
            m0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean A0() {
        return this.f1935z == null && this.s == this.f1931v;
    }

    public void B0(RecyclerView.w wVar, int[] iArr) {
        int i7;
        int l6 = wVar.f2085a != -1 ? this.f1928r.l() : 0;
        if (this.f1927q.f1948f == -1) {
            i7 = 0;
        } else {
            i7 = l6;
            l6 = 0;
        }
        iArr[0] = l6;
        iArr[1] = i7;
    }

    public void C0(RecyclerView.w wVar, c cVar, RecyclerView.l.c cVar2) {
        int i7 = cVar.f1947d;
        if (i7 < 0 || i7 >= wVar.b()) {
            return;
        }
        ((k.b) cVar2).a(i7, Math.max(0, cVar.f1949g));
    }

    public final int D0(RecyclerView.w wVar) {
        if (w() == 0) {
            return 0;
        }
        H0();
        return w.a(wVar, this.f1928r, K0(!this.f1932w), J0(!this.f1932w), this, this.f1932w);
    }

    public final int E0(RecyclerView.w wVar) {
        if (w() == 0) {
            return 0;
        }
        H0();
        return w.b(wVar, this.f1928r, K0(!this.f1932w), J0(!this.f1932w), this, this.f1932w, this.f1930u);
    }

    public final int F0(RecyclerView.w wVar) {
        if (w() == 0) {
            return 0;
        }
        H0();
        return w.c(wVar, this.f1928r, K0(!this.f1932w), J0(!this.f1932w), this, this.f1932w);
    }

    public final int G0(int i7) {
        return i7 != 1 ? i7 != 2 ? i7 != 17 ? i7 != 33 ? i7 != 66 ? (i7 == 130 && this.f1926p == 1) ? 1 : Integer.MIN_VALUE : this.f1926p == 0 ? 1 : Integer.MIN_VALUE : this.f1926p == 1 ? -1 : Integer.MIN_VALUE : this.f1926p == 0 ? -1 : Integer.MIN_VALUE : (this.f1926p != 1 && U0()) ? -1 : 1 : (this.f1926p != 1 && U0()) ? 1 : -1;
    }

    public final void H0() {
        if (this.f1927q == null) {
            this.f1927q = new c();
        }
    }

    public final int I0(RecyclerView.r rVar, c cVar, RecyclerView.w wVar, boolean z6) {
        int i7 = cVar.f1946c;
        int i8 = cVar.f1949g;
        if (i8 != Integer.MIN_VALUE) {
            if (i7 < 0) {
                cVar.f1949g = i8 + i7;
            }
            X0(rVar, cVar);
        }
        int i9 = cVar.f1946c + cVar.f1950h;
        b bVar = this.B;
        while (true) {
            if (!cVar.f1954l && i9 <= 0) {
                break;
            }
            int i10 = cVar.f1947d;
            if (!(i10 >= 0 && i10 < wVar.b())) {
                break;
            }
            bVar.f1940a = 0;
            bVar.f1941b = false;
            bVar.f1942c = false;
            bVar.f1943d = false;
            V0(rVar, wVar, cVar, bVar);
            if (!bVar.f1941b) {
                int i11 = cVar.f1945b;
                int i12 = bVar.f1940a;
                cVar.f1945b = (cVar.f1948f * i12) + i11;
                if (!bVar.f1942c || cVar.f1953k != null || !wVar.f2090g) {
                    cVar.f1946c -= i12;
                    i9 -= i12;
                }
                int i13 = cVar.f1949g;
                if (i13 != Integer.MIN_VALUE) {
                    int i14 = i13 + i12;
                    cVar.f1949g = i14;
                    int i15 = cVar.f1946c;
                    if (i15 < 0) {
                        cVar.f1949g = i14 + i15;
                    }
                    X0(rVar, cVar);
                }
                if (z6 && bVar.f1943d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i7 - cVar.f1946c;
    }

    public final View J0(boolean z6) {
        int w6;
        int i7 = -1;
        if (this.f1930u) {
            w6 = 0;
            i7 = w();
        } else {
            w6 = w() - 1;
        }
        return O0(w6, i7, z6, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean K() {
        return true;
    }

    public final View K0(boolean z6) {
        int i7;
        int i8 = -1;
        if (this.f1930u) {
            i7 = w() - 1;
        } else {
            i7 = 0;
            i8 = w();
        }
        return O0(i7, i8, z6, true);
    }

    public final int L0() {
        View O0 = O0(0, w(), false, true);
        if (O0 == null) {
            return -1;
        }
        return RecyclerView.l.G(O0);
    }

    public final int M0() {
        View O0 = O0(w() - 1, -1, false, true);
        if (O0 == null) {
            return -1;
        }
        return RecyclerView.l.G(O0);
    }

    public final View N0(int i7, int i8) {
        int i9;
        int i10;
        H0();
        if ((i8 > i7 ? (char) 1 : i8 < i7 ? (char) 65535 : (char) 0) == 0) {
            return v(i7);
        }
        if (this.f1928r.e(v(i7)) < this.f1928r.k()) {
            i9 = 16644;
            i10 = 16388;
        } else {
            i9 = 4161;
            i10 = 4097;
        }
        return (this.f1926p == 0 ? this.f2035c : this.f2036d).a(i7, i8, i9, i10);
    }

    public final View O0(int i7, int i8, boolean z6, boolean z7) {
        H0();
        return (this.f1926p == 0 ? this.f2035c : this.f2036d).a(i7, i8, z6 ? 24579 : 320, z7 ? 320 : 0);
    }

    public View P0(RecyclerView.r rVar, RecyclerView.w wVar, boolean z6, boolean z7) {
        int i7;
        int i8;
        H0();
        int w6 = w();
        int i9 = -1;
        if (z7) {
            i7 = w() - 1;
            i8 = -1;
        } else {
            i9 = w6;
            i7 = 0;
            i8 = 1;
        }
        int b2 = wVar.b();
        int k6 = this.f1928r.k();
        int g2 = this.f1928r.g();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i7 != i9) {
            View v6 = v(i7);
            int G = RecyclerView.l.G(v6);
            int e = this.f1928r.e(v6);
            int b7 = this.f1928r.b(v6);
            if (G >= 0 && G < b2) {
                if (!((RecyclerView.m) v6.getLayoutParams()).c()) {
                    boolean z8 = b7 <= k6 && e < k6;
                    boolean z9 = e >= g2 && b7 > g2;
                    if (!z8 && !z9) {
                        return v6;
                    }
                    if (z6) {
                        if (!z9) {
                            if (view != null) {
                            }
                            view = v6;
                        }
                        view2 = v6;
                    } else {
                        if (!z8) {
                            if (view != null) {
                            }
                            view = v6;
                        }
                        view2 = v6;
                    }
                } else if (view3 == null) {
                    view3 = v6;
                }
            }
            i7 += i8;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    public final int Q0(int i7, RecyclerView.r rVar, RecyclerView.w wVar, boolean z6) {
        int g2;
        int g7 = this.f1928r.g() - i7;
        if (g7 > 0) {
            int i8 = -a1(-g7, rVar, wVar);
            int i9 = i7 + i8;
            if (!z6 || (g2 = this.f1928r.g() - i9) <= 0) {
                return i8;
            }
            this.f1928r.p(g2);
            return g2 + i8;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public final void R(RecyclerView recyclerView) {
    }

    public final int R0(int i7, RecyclerView.r rVar, RecyclerView.w wVar, boolean z6) {
        int k6;
        int k7 = i7 - this.f1928r.k();
        if (k7 > 0) {
            int i8 = -a1(k7, rVar, wVar);
            int i9 = i7 + i8;
            if (!z6 || (k6 = i9 - this.f1928r.k()) <= 0) {
                return i8;
            }
            this.f1928r.p(-k6);
            return i8 - k6;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public View S(View view, int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        int G0;
        Z0();
        if (w() == 0 || (G0 = G0(i7)) == Integer.MIN_VALUE) {
            return null;
        }
        H0();
        d1(G0, (int) (this.f1928r.l() * 0.33333334f), false, wVar);
        c cVar = this.f1927q;
        cVar.f1949g = Integer.MIN_VALUE;
        cVar.f1944a = false;
        I0(rVar, cVar, wVar, true);
        View N0 = G0 == -1 ? this.f1930u ? N0(w() - 1, -1) : N0(0, w()) : this.f1930u ? N0(0, w()) : N0(w() - 1, -1);
        View T0 = G0 == -1 ? T0() : S0();
        if (T0.hasFocusable()) {
            if (N0 == null) {
                return null;
            }
            return T0;
        }
        return N0;
    }

    public final View S0() {
        return v(this.f1930u ? 0 : w() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public final void T(AccessibilityEvent accessibilityEvent) {
        super.T(accessibilityEvent);
        if (w() > 0) {
            accessibilityEvent.setFromIndex(L0());
            accessibilityEvent.setToIndex(M0());
        }
    }

    public final View T0() {
        return v(this.f1930u ? w() - 1 : 0);
    }

    public final boolean U0() {
        return B() == 1;
    }

    public void V0(RecyclerView.r rVar, RecyclerView.w wVar, c cVar, b bVar) {
        int i7;
        int i8;
        int i9;
        int i10;
        View b2 = cVar.b(rVar);
        if (b2 == null) {
            bVar.f1941b = true;
            return;
        }
        RecyclerView.m mVar = (RecyclerView.m) b2.getLayoutParams();
        if (cVar.f1953k == null) {
            if (this.f1930u == (cVar.f1948f == -1)) {
                b(b2, -1, false);
            } else {
                b(b2, 0, false);
            }
        } else {
            if (this.f1930u == (cVar.f1948f == -1)) {
                b(b2, -1, true);
            } else {
                b(b2, 0, true);
            }
        }
        RecyclerView.m mVar2 = (RecyclerView.m) b2.getLayoutParams();
        Rect N = this.f2034b.N(b2);
        int x3 = RecyclerView.l.x(this.f2044n, this.f2043l, E() + D() + ((ViewGroup.MarginLayoutParams) mVar2).leftMargin + ((ViewGroup.MarginLayoutParams) mVar2).rightMargin + N.left + N.right + 0, ((ViewGroup.MarginLayoutParams) mVar2).width, e());
        int x6 = RecyclerView.l.x(this.f2045o, this.m, C() + F() + ((ViewGroup.MarginLayoutParams) mVar2).topMargin + ((ViewGroup.MarginLayoutParams) mVar2).bottomMargin + N.top + N.bottom + 0, ((ViewGroup.MarginLayoutParams) mVar2).height, f());
        if (v0(b2, x3, x6, mVar2)) {
            b2.measure(x3, x6);
        }
        bVar.f1940a = this.f1928r.c(b2);
        if (this.f1926p == 1) {
            if (U0()) {
                i10 = this.f2044n - E();
                i8 = i10 - this.f1928r.d(b2);
            } else {
                int D = D();
                i10 = this.f1928r.d(b2) + D;
                i8 = D;
            }
            int i11 = cVar.f1948f;
            i9 = cVar.f1945b;
            if (i11 == -1) {
                i7 = i9;
                i9 -= bVar.f1940a;
            } else {
                i7 = bVar.f1940a + i9;
            }
        } else {
            int F = F();
            int d7 = this.f1928r.d(b2) + F;
            int i12 = cVar.f1948f;
            int i13 = cVar.f1945b;
            if (i12 == -1) {
                i7 = d7;
                i8 = i13 - bVar.f1940a;
                i10 = i13;
                i9 = F;
            } else {
                int i14 = bVar.f1940a + i13;
                i7 = d7;
                i8 = i13;
                i9 = F;
                i10 = i14;
            }
        }
        RecyclerView.l.M(b2, i8, i9, i10, i7);
        if (mVar.c() || mVar.b()) {
            bVar.f1942c = true;
        }
        bVar.f1943d = b2.hasFocusable();
    }

    public void W0(RecyclerView.r rVar, RecyclerView.w wVar, a aVar, int i7) {
    }

    public final void X0(RecyclerView.r rVar, c cVar) {
        if (!cVar.f1944a || cVar.f1954l) {
            return;
        }
        int i7 = cVar.f1949g;
        int i8 = cVar.f1951i;
        if (cVar.f1948f == -1) {
            int w6 = w();
            if (i7 < 0) {
                return;
            }
            int f7 = (this.f1928r.f() - i7) + i8;
            if (this.f1930u) {
                for (int i9 = 0; i9 < w6; i9++) {
                    View v6 = v(i9);
                    if (this.f1928r.e(v6) < f7 || this.f1928r.o(v6) < f7) {
                        Y0(rVar, 0, i9);
                        return;
                    }
                }
                return;
            }
            int i10 = w6 - 1;
            for (int i11 = i10; i11 >= 0; i11--) {
                View v7 = v(i11);
                if (this.f1928r.e(v7) < f7 || this.f1928r.o(v7) < f7) {
                    Y0(rVar, i10, i11);
                    return;
                }
            }
        } else if (i7 >= 0) {
            int i12 = i7 - i8;
            int w7 = w();
            if (!this.f1930u) {
                for (int i13 = 0; i13 < w7; i13++) {
                    View v8 = v(i13);
                    if (this.f1928r.b(v8) > i12 || this.f1928r.n(v8) > i12) {
                        Y0(rVar, 0, i13);
                        return;
                    }
                }
                return;
            }
            int i14 = w7 - 1;
            for (int i15 = i14; i15 >= 0; i15--) {
                View v9 = v(i15);
                if (this.f1928r.b(v9) > i12 || this.f1928r.n(v9) > i12) {
                    Y0(rVar, i14, i15);
                    return;
                }
            }
        }
    }

    public final void Y0(RecyclerView.r rVar, int i7, int i8) {
        if (i7 == i8) {
            return;
        }
        if (i8 <= i7) {
            while (i7 > i8) {
                View v6 = v(i7);
                k0(i7);
                rVar.i(v6);
                i7--;
            }
            return;
        }
        while (true) {
            i8--;
            if (i8 < i7) {
                return;
            }
            View v7 = v(i8);
            k0(i8);
            rVar.i(v7);
        }
    }

    public final void Z0() {
        this.f1930u = (this.f1926p == 1 || !U0()) ? this.f1929t : !this.f1929t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v.b
    @SuppressLint({"UnknownNullness"})
    public final PointF a(int i7) {
        if (w() == 0) {
            return null;
        }
        int i8 = (i7 < RecyclerView.l.G(v(0))) != this.f1930u ? -1 : 1;
        return this.f1926p == 0 ? new PointF(i8, 0.0f) : new PointF(0.0f, i8);
    }

    public final int a1(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (w() == 0 || i7 == 0) {
            return 0;
        }
        H0();
        this.f1927q.f1944a = true;
        int i8 = i7 > 0 ? 1 : -1;
        int abs = Math.abs(i7);
        d1(i8, abs, true, wVar);
        c cVar = this.f1927q;
        int I0 = I0(rVar, cVar, wVar, false) + cVar.f1949g;
        if (I0 < 0) {
            return 0;
        }
        if (abs > I0) {
            i7 = i8 * I0;
        }
        this.f1928r.p(-i7);
        this.f1927q.f1952j = i7;
        return i7;
    }

    public final void b1(int i7) {
        if (i7 != 0 && i7 != 1) {
            throw new IllegalArgumentException(s0.g("invalid orientation:", i7));
        }
        c(null);
        if (i7 != this.f1926p || this.f1928r == null) {
            q a7 = q.a(this, i7);
            this.f1928r = a7;
            this.A.f1936a = a7;
            this.f1926p = i7;
            m0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public final void c(String str) {
        if (this.f1935z == null) {
            super.c(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:900:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:950:0x0234  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    @android.annotation.SuppressLint({"UnknownNullness"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c0(androidx.recyclerview.widget.RecyclerView.r r18, androidx.recyclerview.widget.RecyclerView.w r19) {
        /*
            Method dump skipped, instructions count: 1124
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.c0(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):void");
    }

    public void c1(boolean z6) {
        c(null);
        if (this.f1931v == z6) {
            return;
        }
        this.f1931v = z6;
        m0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public void d0(RecyclerView.w wVar) {
        this.f1935z = null;
        this.f1933x = -1;
        this.f1934y = Integer.MIN_VALUE;
        this.A.c();
    }

    public final void d1(int i7, int i8, boolean z6, RecyclerView.w wVar) {
        int k6;
        this.f1927q.f1954l = this.f1928r.i() == 0 && this.f1928r.f() == 0;
        this.f1927q.f1948f = i7;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        B0(wVar, iArr);
        int max = Math.max(0, this.D[0]);
        int max2 = Math.max(0, this.D[1]);
        boolean z7 = i7 == 1;
        c cVar = this.f1927q;
        int i9 = z7 ? max2 : max;
        cVar.f1950h = i9;
        if (!z7) {
            max = max2;
        }
        cVar.f1951i = max;
        if (z7) {
            cVar.f1950h = this.f1928r.h() + i9;
            View S0 = S0();
            c cVar2 = this.f1927q;
            cVar2.e = this.f1930u ? -1 : 1;
            int G = RecyclerView.l.G(S0);
            c cVar3 = this.f1927q;
            cVar2.f1947d = G + cVar3.e;
            cVar3.f1945b = this.f1928r.b(S0);
            k6 = this.f1928r.b(S0) - this.f1928r.g();
        } else {
            View T0 = T0();
            c cVar4 = this.f1927q;
            cVar4.f1950h = this.f1928r.k() + cVar4.f1950h;
            c cVar5 = this.f1927q;
            cVar5.e = this.f1930u ? 1 : -1;
            int G2 = RecyclerView.l.G(T0);
            c cVar6 = this.f1927q;
            cVar5.f1947d = G2 + cVar6.e;
            cVar6.f1945b = this.f1928r.e(T0);
            k6 = (-this.f1928r.e(T0)) + this.f1928r.k();
        }
        c cVar7 = this.f1927q;
        cVar7.f1946c = i8;
        if (z6) {
            cVar7.f1946c = i8 - k6;
        }
        cVar7.f1949g = k6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean e() {
        return this.f1926p == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public final void e0(Parcelable parcelable) {
        if (parcelable instanceof d) {
            d dVar = (d) parcelable;
            this.f1935z = dVar;
            if (this.f1933x != -1) {
                dVar.f1955f = -1;
            }
            m0();
        }
    }

    public final void e1(int i7, int i8) {
        this.f1927q.f1946c = this.f1928r.g() - i8;
        c cVar = this.f1927q;
        cVar.e = this.f1930u ? -1 : 1;
        cVar.f1947d = i7;
        cVar.f1948f = 1;
        cVar.f1945b = i8;
        cVar.f1949g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean f() {
        return this.f1926p == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public final Parcelable f0() {
        d dVar = this.f1935z;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (w() > 0) {
            H0();
            boolean z6 = this.s ^ this.f1930u;
            dVar2.f1957h = z6;
            if (z6) {
                View S0 = S0();
                dVar2.f1956g = this.f1928r.g() - this.f1928r.b(S0);
                dVar2.f1955f = RecyclerView.l.G(S0);
            } else {
                View T0 = T0();
                dVar2.f1955f = RecyclerView.l.G(T0);
                dVar2.f1956g = this.f1928r.e(T0) - this.f1928r.k();
            }
        } else {
            dVar2.f1955f = -1;
        }
        return dVar2;
    }

    public final void f1(int i7, int i8) {
        this.f1927q.f1946c = i8 - this.f1928r.k();
        c cVar = this.f1927q;
        cVar.f1947d = i7;
        cVar.e = this.f1930u ? 1 : -1;
        cVar.f1948f = -1;
        cVar.f1945b = i8;
        cVar.f1949g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public final void i(int i7, int i8, RecyclerView.w wVar, RecyclerView.l.c cVar) {
        if (this.f1926p != 0) {
            i7 = i8;
        }
        if (w() == 0 || i7 == 0) {
            return;
        }
        H0();
        d1(i7 > 0 ? 1 : -1, Math.abs(i7), true, wVar);
        C0(wVar, this.f1927q, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0025  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    @android.annotation.SuppressLint({"UnknownNullness"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(int r7, androidx.recyclerview.widget.RecyclerView.l.c r8) {
        /*
            r6 = this;
            androidx.recyclerview.widget.LinearLayoutManager$d r0 = r6.f1935z
            r1 = 0
            r2 = -1
            r3 = 1
            if (r0 == 0) goto L13
            int r4 = r0.f1955f
            if (r4 < 0) goto Ld
            r5 = r3
            goto Le
        Ld:
            r5 = r1
        Le:
            if (r5 == 0) goto L13
            boolean r0 = r0.f1957h
            goto L22
        L13:
            r6.Z0()
            boolean r0 = r6.f1930u
            int r4 = r6.f1933x
            if (r4 != r2) goto L22
            if (r0 == 0) goto L21
            int r4 = r7 + (-1)
            goto L22
        L21:
            r4 = r1
        L22:
            if (r0 == 0) goto L25
            goto L26
        L25:
            r2 = r3
        L26:
            r0 = r1
        L27:
            int r3 = r6.C
            if (r0 >= r3) goto L39
            if (r4 < 0) goto L39
            if (r4 >= r7) goto L39
            r3 = r8
            androidx.recyclerview.widget.k$b r3 = (androidx.recyclerview.widget.k.b) r3
            r3.a(r4, r1)
            int r4 = r4 + r2
            int r0 = r0 + 1
            goto L27
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.j(int, androidx.recyclerview.widget.RecyclerView$l$c):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public final int k(RecyclerView.w wVar) {
        return D0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public int l(RecyclerView.w wVar) {
        return E0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public int m(RecyclerView.w wVar) {
        return F0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public final int n(RecyclerView.w wVar) {
        return D0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public int n0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.f1926p == 1) {
            return 0;
        }
        return a1(i7, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public int o(RecyclerView.w wVar) {
        return E0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void o0(int i7) {
        this.f1933x = i7;
        this.f1934y = Integer.MIN_VALUE;
        d dVar = this.f1935z;
        if (dVar != null) {
            dVar.f1955f = -1;
        }
        m0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public int p(RecyclerView.w wVar) {
        return F0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public int p0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.f1926p == 0) {
            return 0;
        }
        return a1(i7, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public final View r(int i7) {
        int w6 = w();
        if (w6 == 0) {
            return null;
        }
        int G = i7 - RecyclerView.l.G(v(0));
        if (G >= 0 && G < w6) {
            View v6 = v(G);
            if (RecyclerView.l.G(v6) == i7) {
                return v6;
            }
        }
        return super.r(i7);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public RecyclerView.m s() {
        return new RecyclerView.m(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean w0() {
        boolean z6;
        if (this.m != 1073741824 && this.f2043l != 1073741824) {
            int w6 = w();
            int i7 = 0;
            while (true) {
                if (i7 >= w6) {
                    z6 = false;
                    break;
                }
                ViewGroup.LayoutParams layoutParams = v(i7).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z6 = true;
                    break;
                }
                i7++;
            }
            if (z6) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    @SuppressLint({"UnknownNullness"})
    public void y0(RecyclerView recyclerView, int i7) {
        m mVar = new m(recyclerView.getContext());
        mVar.f2072a = i7;
        z0(mVar);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f1926p = 1;
        this.f1929t = false;
        this.f1930u = false;
        this.f1931v = false;
        this.f1932w = true;
        this.f1933x = -1;
        this.f1934y = Integer.MIN_VALUE;
        this.f1935z = null;
        this.A = new a();
        this.B = new b();
        this.C = 2;
        this.D = new int[2];
        RecyclerView.l.d H = RecyclerView.l.H(context, attributeSet, i7, i8);
        b1(H.f2048a);
        boolean z6 = H.f2050c;
        c(null);
        if (z6 != this.f1929t) {
            this.f1929t = z6;
            m0();
        }
        c1(H.f2051d);
    }
}
