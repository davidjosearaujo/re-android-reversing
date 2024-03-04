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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.l implements RecyclerView.v.b {
    public boolean D;
    public boolean E;
    public e F;
    public int[] J;

    /* renamed from: p */
    public int f2104p;

    /* renamed from: q */
    public f[] f2105q;

    /* renamed from: r */
    public q f2106r;
    public q s;

    /* renamed from: t */
    public int f2107t;

    /* renamed from: u */
    public int f2108u;

    /* renamed from: v */
    public final l f2109v;

    /* renamed from: w */
    public boolean f2110w;

    /* renamed from: y */
    public BitSet f2112y;

    /* renamed from: x */
    public boolean f2111x = false;

    /* renamed from: z */
    public int f2113z = -1;
    public int A = Integer.MIN_VALUE;
    public d B = new d();
    public int C = 2;
    public final Rect G = new Rect();
    public final b H = new b();
    public boolean I = true;
    public final a K = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            StaggeredGridLayoutManager.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StaggeredGridLayoutManager.this.C0();
        }
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a */
        public int f2115a;

        /* renamed from: b */
        public int f2116b;

        /* renamed from: c */
        public boolean f2117c;

        /* renamed from: d */
        public boolean f2118d;
        public boolean e;

        /* renamed from: f */
        public int[] f2119f;

        public b() {
            StaggeredGridLayoutManager.this = r1;
            a();
        }

        public final void a() {
            this.f2115a = -1;
            this.f2116b = Integer.MIN_VALUE;
            this.f2117c = false;
            this.f2118d = false;
            this.e = false;
            int[] iArr = this.f2119f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.m {
        public f e;

        public c(int i7, int i8) {
            super(i7, i8);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a */
        public int[] f2121a;

        /* renamed from: b */
        public List<a> f2122b;

        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0020a();

            /* renamed from: f */
            public int f2123f;

            /* renamed from: g */
            public int f2124g;

            /* renamed from: h */
            public int[] f2125h;

            /* renamed from: i */
            public boolean f2126i;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a */
            /* loaded from: classes.dex */
            public class C0020a implements Parcelable.Creator<a> {
                @Override // android.os.Parcelable.Creator
                public final a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public final a[] newArray(int i7) {
                    return new a[i7];
                }
            }

            public a() {
            }

            public a(Parcel parcel) {
                this.f2123f = parcel.readInt();
                this.f2124g = parcel.readInt();
                this.f2126i = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f2125h = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public final String toString() {
                StringBuilder d7 = androidx.activity.h.d("FullSpanItem{mPosition=");
                d7.append(this.f2123f);
                d7.append(", mGapDir=");
                d7.append(this.f2124g);
                d7.append(", mHasUnwantedGapAfter=");
                d7.append(this.f2126i);
                d7.append(", mGapPerSpan=");
                d7.append(Arrays.toString(this.f2125h));
                d7.append('}');
                return d7.toString();
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i7) {
                parcel.writeInt(this.f2123f);
                parcel.writeInt(this.f2124g);
                parcel.writeInt(this.f2126i ? 1 : 0);
                int[] iArr = this.f2125h;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f2125h);
            }
        }

        public final void a() {
            int[] iArr = this.f2121a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2122b = null;
        }

        public final void b(int i7) {
            int[] iArr = this.f2121a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i7, 10) + 1];
                this.f2121a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i7 >= iArr.length) {
                int length = iArr.length;
                while (length <= i7) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.f2121a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f2121a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:156:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int c(int r6) {
            /*
                r5 = this;
                int[] r0 = r5.f2121a
                r1 = -1
                if (r0 != 0) goto L6
                return r1
            L6:
                int r0 = r0.length
                if (r6 < r0) goto La
                return r1
            La:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r5.f2122b
                if (r0 != 0) goto Lf
                goto L5e
            Lf:
                r2 = 0
                if (r0 != 0) goto L13
                goto L2b
            L13:
                int r0 = r0.size()
                int r0 = r0 + r1
            L18:
                if (r0 < 0) goto L2b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r5.f2122b
                java.lang.Object r3 = r3.get(r0)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r3
                int r4 = r3.f2123f
                if (r4 != r6) goto L28
                r2 = r3
                goto L2b
            L28:
                int r0 = r0 + (-1)
                goto L18
            L2b:
                if (r2 == 0) goto L32
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r5.f2122b
                r0.remove(r2)
            L32:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r5.f2122b
                int r0 = r0.size()
                r2 = 0
            L39:
                if (r2 >= r0) goto L4b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r5.f2122b
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r3
                int r3 = r3.f2123f
                if (r3 < r6) goto L48
                goto L4c
            L48:
                int r2 = r2 + 1
                goto L39
            L4b:
                r2 = r1
            L4c:
                if (r2 == r1) goto L5e
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r5.f2122b
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r5.f2122b
                r3.remove(r2)
                int r0 = r0.f2123f
                goto L5f
            L5e:
                r0 = r1
            L5f:
                if (r0 != r1) goto L6b
                int[] r0 = r5.f2121a
                int r2 = r0.length
                java.util.Arrays.fill(r0, r6, r2, r1)
                int[] r5 = r5.f2121a
                int r5 = r5.length
                return r5
            L6b:
                int r0 = r0 + 1
                int[] r2 = r5.f2121a
                int r2 = r2.length
                int r0 = java.lang.Math.min(r0, r2)
                int[] r5 = r5.f2121a
                java.util.Arrays.fill(r5, r6, r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.d.c(int):int");
        }

        public final void d(int i7, int i8) {
            int[] iArr = this.f2121a;
            if (iArr == null || i7 >= iArr.length) {
                return;
            }
            int i9 = i7 + i8;
            b(i9);
            int[] iArr2 = this.f2121a;
            System.arraycopy(iArr2, i7, iArr2, i9, (iArr2.length - i7) - i8);
            Arrays.fill(this.f2121a, i7, i9, -1);
            List<a> list = this.f2122b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2122b.get(size);
                int i10 = aVar.f2123f;
                if (i10 >= i7) {
                    aVar.f2123f = i10 + i8;
                }
            }
        }

        public final void e(int i7, int i8) {
            int[] iArr = this.f2121a;
            if (iArr == null || i7 >= iArr.length) {
                return;
            }
            int i9 = i7 + i8;
            b(i9);
            int[] iArr2 = this.f2121a;
            System.arraycopy(iArr2, i9, iArr2, i7, (iArr2.length - i7) - i8);
            int[] iArr3 = this.f2121a;
            Arrays.fill(iArr3, iArr3.length - i8, iArr3.length, -1);
            List<a> list = this.f2122b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f2122b.get(size);
                int i10 = aVar.f2123f;
                if (i10 >= i7) {
                    if (i10 < i9) {
                        this.f2122b.remove(size);
                    } else {
                        aVar.f2123f = i10 - i8;
                    }
                }
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: f */
        public int f2127f;

        /* renamed from: g */
        public int f2128g;

        /* renamed from: h */
        public int f2129h;

        /* renamed from: i */
        public int[] f2130i;

        /* renamed from: j */
        public int f2131j;

        /* renamed from: k */
        public int[] f2132k;

        /* renamed from: l */
        public List<d.a> f2133l;
        public boolean m;

        /* renamed from: n */
        public boolean f2134n;

        /* renamed from: o */
        public boolean f2135o;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<e> {
            @Override // android.os.Parcelable.Creator
            public final e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final e[] newArray(int i7) {
                return new e[i7];
            }
        }

        public e() {
        }

        public e(Parcel parcel) {
            this.f2127f = parcel.readInt();
            this.f2128g = parcel.readInt();
            int readInt = parcel.readInt();
            this.f2129h = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f2130i = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f2131j = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f2132k = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.m = parcel.readInt() == 1;
            this.f2134n = parcel.readInt() == 1;
            this.f2135o = parcel.readInt() == 1;
            this.f2133l = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f2129h = eVar.f2129h;
            this.f2127f = eVar.f2127f;
            this.f2128g = eVar.f2128g;
            this.f2130i = eVar.f2130i;
            this.f2131j = eVar.f2131j;
            this.f2132k = eVar.f2132k;
            this.m = eVar.m;
            this.f2134n = eVar.f2134n;
            this.f2135o = eVar.f2135o;
            this.f2133l = eVar.f2133l;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeInt(this.f2127f);
            parcel.writeInt(this.f2128g);
            parcel.writeInt(this.f2129h);
            if (this.f2129h > 0) {
                parcel.writeIntArray(this.f2130i);
            }
            parcel.writeInt(this.f2131j);
            if (this.f2131j > 0) {
                parcel.writeIntArray(this.f2132k);
            }
            parcel.writeInt(this.m ? 1 : 0);
            parcel.writeInt(this.f2134n ? 1 : 0);
            parcel.writeInt(this.f2135o ? 1 : 0);
            parcel.writeList(this.f2133l);
        }
    }

    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a */
        public ArrayList<View> f2136a = new ArrayList<>();

        /* renamed from: b */
        public int f2137b = Integer.MIN_VALUE;

        /* renamed from: c */
        public int f2138c = Integer.MIN_VALUE;

        /* renamed from: d */
        public int f2139d = 0;
        public final int e;

        public f(int i7) {
            StaggeredGridLayoutManager.this = r1;
            this.e = i7;
        }

        public static c h(View view) {
            return (c) view.getLayoutParams();
        }

        public final void a() {
            ArrayList<View> arrayList = this.f2136a;
            View view = arrayList.get(arrayList.size() - 1);
            c h7 = h(view);
            this.f2138c = StaggeredGridLayoutManager.this.f2106r.b(view);
            h7.getClass();
        }

        public final void b() {
            this.f2136a.clear();
            this.f2137b = Integer.MIN_VALUE;
            this.f2138c = Integer.MIN_VALUE;
            this.f2139d = 0;
        }

        public final int c() {
            int i7;
            int size;
            if (StaggeredGridLayoutManager.this.f2110w) {
                i7 = this.f2136a.size() - 1;
                size = -1;
            } else {
                i7 = 0;
                size = this.f2136a.size();
            }
            return e(i7, size);
        }

        public final int d() {
            int size;
            int i7;
            if (StaggeredGridLayoutManager.this.f2110w) {
                size = 0;
                i7 = this.f2136a.size();
            } else {
                size = this.f2136a.size() - 1;
                i7 = -1;
            }
            return e(size, i7);
        }

        public final int e(int i7, int i8) {
            int k6 = StaggeredGridLayoutManager.this.f2106r.k();
            int g2 = StaggeredGridLayoutManager.this.f2106r.g();
            int i9 = i8 > i7 ? 1 : -1;
            while (i7 != i8) {
                View view = this.f2136a.get(i7);
                int e = StaggeredGridLayoutManager.this.f2106r.e(view);
                int b2 = StaggeredGridLayoutManager.this.f2106r.b(view);
                boolean z6 = e <= g2;
                boolean z7 = b2 >= k6;
                if (z6 && z7 && (e < k6 || b2 > g2)) {
                    StaggeredGridLayoutManager.this.getClass();
                    return RecyclerView.l.G(view);
                }
                i7 += i9;
            }
            return -1;
        }

        public final int f(int i7) {
            int i8 = this.f2138c;
            if (i8 != Integer.MIN_VALUE) {
                return i8;
            }
            if (this.f2136a.size() == 0) {
                return i7;
            }
            a();
            return this.f2138c;
        }

        public final View g(int i7, int i8) {
            View view = null;
            if (i8 != -1) {
                int size = this.f2136a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f2136a.get(size);
                    if ((StaggeredGridLayoutManager.this.f2110w && RecyclerView.l.G(view2) >= i7) || ((!StaggeredGridLayoutManager.this.f2110w && RecyclerView.l.G(view2) <= i7) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f2136a.size();
                int i9 = 0;
                while (i9 < size2) {
                    View view3 = this.f2136a.get(i9);
                    if ((StaggeredGridLayoutManager.this.f2110w && RecyclerView.l.G(view3) <= i7) || ((!StaggeredGridLayoutManager.this.f2110w && RecyclerView.l.G(view3) >= i7) || !view3.hasFocusable())) {
                        break;
                    }
                    i9++;
                    view = view3;
                }
            }
            return view;
        }

        public final int i(int i7) {
            int i8 = this.f2137b;
            if (i8 != Integer.MIN_VALUE) {
                return i8;
            }
            if (this.f2136a.size() == 0) {
                return i7;
            }
            View view = this.f2136a.get(0);
            c h7 = h(view);
            this.f2137b = StaggeredGridLayoutManager.this.f2106r.e(view);
            h7.getClass();
            return this.f2137b;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f2104p = -1;
        this.f2110w = false;
        RecyclerView.l.d H = RecyclerView.l.H(context, attributeSet, i7, i8);
        int i9 = H.f2048a;
        if (i9 != 0 && i9 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i9 != this.f2107t) {
            this.f2107t = i9;
            q qVar = this.f2106r;
            this.f2106r = this.s;
            this.s = qVar;
            m0();
        }
        int i10 = H.f2049b;
        c(null);
        if (i10 != this.f2104p) {
            this.B.a();
            m0();
            this.f2104p = i10;
            this.f2112y = new BitSet(this.f2104p);
            this.f2105q = new f[this.f2104p];
            for (int i11 = 0; i11 < this.f2104p; i11++) {
                this.f2105q[i11] = new f(i11);
            }
            m0();
        }
        boolean z6 = H.f2050c;
        c(null);
        e eVar = this.F;
        if (eVar != null && eVar.m != z6) {
            eVar.m = z6;
        }
        this.f2110w = z6;
        m0();
        this.f2109v = new l();
        this.f2106r = q.a(this, this.f2107t);
        this.s = q.a(this, 1 - this.f2107t);
    }

    public static int d1(int i7, int i8, int i9) {
        if (i8 == 0 && i9 == 0) {
            return i7;
        }
        int mode = View.MeasureSpec.getMode(i7);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i7) - i8) - i9), mode) : i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean A0() {
        return this.F == null;
    }

    public final int B0(int i7) {
        if (w() == 0) {
            return this.f2111x ? 1 : -1;
        }
        return (i7 < L0()) != this.f2111x ? -1 : 1;
    }

    public final boolean C0() {
        int L0;
        if (w() != 0 && this.C != 0 && this.f2038g) {
            if (this.f2111x) {
                L0 = M0();
                L0();
            } else {
                L0 = L0();
                M0();
            }
            if (L0 == 0 && Q0() != null) {
                this.B.a();
                this.f2037f = true;
                m0();
                return true;
            }
        }
        return false;
    }

    public final int D0(RecyclerView.w wVar) {
        if (w() == 0) {
            return 0;
        }
        return w.a(wVar, this.f2106r, I0(!this.I), H0(!this.I), this, this.I);
    }

    public final int E0(RecyclerView.w wVar) {
        if (w() == 0) {
            return 0;
        }
        return w.b(wVar, this.f2106r, I0(!this.I), H0(!this.I), this, this.I, this.f2111x);
    }

    public final int F0(RecyclerView.w wVar) {
        if (w() == 0) {
            return 0;
        }
        return w.c(wVar, this.f2106r, I0(!this.I), H0(!this.I), this, this.I);
    }

    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v20 */
    public final int G0(RecyclerView.r rVar, l lVar, RecyclerView.w wVar) {
        f fVar;
        ?? r7;
        int x3;
        int x6;
        int i7;
        int c7;
        int k6;
        int c8;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 0;
        this.f2112y.set(0, this.f2104p, true);
        int i13 = this.f2109v.f2260i ? lVar.e == 1 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : Integer.MIN_VALUE : lVar.e == 1 ? lVar.f2258g + lVar.f2254b : lVar.f2257f - lVar.f2254b;
        int i14 = lVar.e;
        for (int i15 = 0; i15 < this.f2104p; i15++) {
            if (!this.f2105q[i15].f2136a.isEmpty()) {
                c1(this.f2105q[i15], i14, i13);
            }
        }
        int g2 = this.f2111x ? this.f2106r.g() : this.f2106r.k();
        boolean z6 = false;
        while (true) {
            int i16 = lVar.f2255c;
            if (((i16 < 0 || i16 >= wVar.b()) ? i12 : 1) == 0 || (!this.f2109v.f2260i && this.f2112y.isEmpty())) {
                break;
            }
            View d7 = rVar.d(lVar.f2255c);
            lVar.f2255c += lVar.f2256d;
            c cVar = (c) d7.getLayoutParams();
            int a7 = cVar.a();
            int[] iArr = this.B.f2121a;
            int i17 = (iArr == null || a7 >= iArr.length) ? -1 : iArr[a7];
            if ((i17 == -1 ? 1 : i12) != 0) {
                if (T0(lVar.e)) {
                    i11 = -1;
                    i10 = this.f2104p - 1;
                    i9 = -1;
                } else {
                    i9 = this.f2104p;
                    i10 = i12;
                    i11 = 1;
                }
                f fVar2 = null;
                if (lVar.e == 1) {
                    int k7 = this.f2106r.k();
                    int i18 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                    while (i10 != i9) {
                        f fVar3 = this.f2105q[i10];
                        int f7 = fVar3.f(k7);
                        if (f7 < i18) {
                            fVar2 = fVar3;
                            i18 = f7;
                        }
                        i10 += i11;
                    }
                } else {
                    int g7 = this.f2106r.g();
                    int i19 = Integer.MIN_VALUE;
                    while (i10 != i9) {
                        f fVar4 = this.f2105q[i10];
                        int i20 = fVar4.i(g7);
                        if (i20 > i19) {
                            fVar2 = fVar4;
                            i19 = i20;
                        }
                        i10 += i11;
                    }
                }
                fVar = fVar2;
                d dVar = this.B;
                dVar.b(a7);
                dVar.f2121a[a7] = fVar.e;
            } else {
                fVar = this.f2105q[i17];
            }
            cVar.e = fVar;
            if (lVar.e == 1) {
                r7 = 0;
                b(d7, -1, false);
            } else {
                r7 = 0;
                b(d7, 0, false);
            }
            if (this.f2107t == 1) {
                x3 = RecyclerView.l.x(this.f2108u, this.f2043l, r7, ((ViewGroup.MarginLayoutParams) cVar).width, r7);
                x6 = RecyclerView.l.x(this.f2045o, this.m, C() + F(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
            } else {
                x3 = RecyclerView.l.x(this.f2044n, this.f2043l, E() + D(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
                x6 = RecyclerView.l.x(this.f2108u, this.m, 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
            }
            d(d7, this.G);
            c cVar2 = (c) d7.getLayoutParams();
            int i21 = ((ViewGroup.MarginLayoutParams) cVar2).leftMargin;
            Rect rect = this.G;
            int d12 = d1(x3, i21 + rect.left, ((ViewGroup.MarginLayoutParams) cVar2).rightMargin + rect.right);
            int i22 = ((ViewGroup.MarginLayoutParams) cVar2).topMargin;
            Rect rect2 = this.G;
            int d13 = d1(x6, i22 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar2).bottomMargin + rect2.bottom);
            if (v0(d7, d12, d13, cVar2)) {
                d7.measure(d12, d13);
            }
            if (lVar.e == 1) {
                c7 = fVar.f(g2);
                i7 = this.f2106r.c(d7) + c7;
            } else {
                i7 = fVar.i(g2);
                c7 = i7 - this.f2106r.c(d7);
            }
            int i23 = lVar.e;
            f fVar5 = cVar.e;
            fVar5.getClass();
            if (i23 == 1) {
                c cVar3 = (c) d7.getLayoutParams();
                cVar3.e = fVar5;
                fVar5.f2136a.add(d7);
                fVar5.f2138c = Integer.MIN_VALUE;
                if (fVar5.f2136a.size() == 1) {
                    fVar5.f2137b = Integer.MIN_VALUE;
                }
                if (cVar3.c() || cVar3.b()) {
                    fVar5.f2139d = StaggeredGridLayoutManager.this.f2106r.c(d7) + fVar5.f2139d;
                }
            } else {
                c cVar4 = (c) d7.getLayoutParams();
                cVar4.e = fVar5;
                fVar5.f2136a.add(0, d7);
                fVar5.f2137b = Integer.MIN_VALUE;
                if (fVar5.f2136a.size() == 1) {
                    fVar5.f2138c = Integer.MIN_VALUE;
                }
                if (cVar4.c() || cVar4.b()) {
                    fVar5.f2139d = StaggeredGridLayoutManager.this.f2106r.c(d7) + fVar5.f2139d;
                }
            }
            if (R0() && this.f2107t == 1) {
                c8 = this.s.g() - (((this.f2104p - 1) - fVar.e) * this.f2108u);
                k6 = c8 - this.s.c(d7);
            } else {
                k6 = this.s.k() + (fVar.e * this.f2108u);
                c8 = this.s.c(d7) + k6;
            }
            if (this.f2107t == 1) {
                int i24 = k6;
                k6 = c7;
                c7 = i24;
                int i25 = c8;
                c8 = i7;
                i7 = i25;
            }
            RecyclerView.l.M(d7, c7, k6, i7, c8);
            c1(fVar, this.f2109v.e, i13);
            V0(rVar, this.f2109v);
            if (this.f2109v.f2259h && d7.hasFocusable()) {
                i8 = 0;
                this.f2112y.set(fVar.e, false);
            } else {
                i8 = 0;
            }
            z6 = true;
            i12 = i8;
        }
        int i26 = i12;
        if (!z6) {
            V0(rVar, this.f2109v);
        }
        int k8 = this.f2109v.e == -1 ? this.f2106r.k() - O0(this.f2106r.k()) : N0(this.f2106r.g()) - this.f2106r.g();
        return k8 > 0 ? Math.min(lVar.f2254b, k8) : i26;
    }

    public final View H0(boolean z6) {
        int k6 = this.f2106r.k();
        int g2 = this.f2106r.g();
        View view = null;
        for (int w6 = w() - 1; w6 >= 0; w6--) {
            View v6 = v(w6);
            int e7 = this.f2106r.e(v6);
            int b2 = this.f2106r.b(v6);
            if (b2 > k6 && e7 < g2) {
                if (b2 <= g2 || !z6) {
                    return v6;
                }
                if (view == null) {
                    view = v6;
                }
            }
        }
        return view;
    }

    public final View I0(boolean z6) {
        int k6 = this.f2106r.k();
        int g2 = this.f2106r.g();
        int w6 = w();
        View view = null;
        for (int i7 = 0; i7 < w6; i7++) {
            View v6 = v(i7);
            int e7 = this.f2106r.e(v6);
            if (this.f2106r.b(v6) > k6 && e7 < g2) {
                if (e7 >= k6 || !z6) {
                    return v6;
                }
                if (view == null) {
                    view = v6;
                }
            }
        }
        return view;
    }

    public final void J0(RecyclerView.r rVar, RecyclerView.w wVar, boolean z6) {
        int g2;
        int N0 = N0(Integer.MIN_VALUE);
        if (N0 != Integer.MIN_VALUE && (g2 = this.f2106r.g() - N0) > 0) {
            int i7 = g2 - (-Z0(-g2, rVar, wVar));
            if (!z6 || i7 <= 0) {
                return;
            }
            this.f2106r.p(i7);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean K() {
        return this.C != 0;
    }

    public final void K0(RecyclerView.r rVar, RecyclerView.w wVar, boolean z6) {
        int k6;
        int O0 = O0(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        if (O0 != Integer.MAX_VALUE && (k6 = O0 - this.f2106r.k()) > 0) {
            int Z0 = k6 - Z0(k6, rVar, wVar);
            if (!z6 || Z0 <= 0) {
                return;
            }
            this.f2106r.p(-Z0);
        }
    }

    public final int L0() {
        if (w() == 0) {
            return 0;
        }
        return RecyclerView.l.G(v(0));
    }

    public final int M0() {
        int w6 = w();
        if (w6 == 0) {
            return 0;
        }
        return RecyclerView.l.G(v(w6 - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void N(int i7) {
        super.N(i7);
        for (int i8 = 0; i8 < this.f2104p; i8++) {
            f fVar = this.f2105q[i8];
            int i9 = fVar.f2137b;
            if (i9 != Integer.MIN_VALUE) {
                fVar.f2137b = i9 + i7;
            }
            int i10 = fVar.f2138c;
            if (i10 != Integer.MIN_VALUE) {
                fVar.f2138c = i10 + i7;
            }
        }
    }

    public final int N0(int i7) {
        int f7 = this.f2105q[0].f(i7);
        for (int i8 = 1; i8 < this.f2104p; i8++) {
            int f8 = this.f2105q[i8].f(i7);
            if (f8 > f7) {
                f7 = f8;
            }
        }
        return f7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void O(int i7) {
        super.O(i7);
        for (int i8 = 0; i8 < this.f2104p; i8++) {
            f fVar = this.f2105q[i8];
            int i9 = fVar.f2137b;
            if (i9 != Integer.MIN_VALUE) {
                fVar.f2137b = i9 + i7;
            }
            int i10 = fVar.f2138c;
            if (i10 != Integer.MIN_VALUE) {
                fVar.f2138c = i10 + i7;
            }
        }
    }

    public final int O0(int i7) {
        int i8 = this.f2105q[0].i(i7);
        for (int i9 = 1; i9 < this.f2104p; i9++) {
            int i10 = this.f2105q[i9].i(i7);
            if (i10 < i8) {
                i8 = i10;
            }
        }
        return i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void P() {
        this.B.a();
        for (int i7 = 0; i7 < this.f2104p; i7++) {
            this.f2105q[i7].b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void P0(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f2111x
            if (r0 == 0) goto L9
            int r0 = r6.M0()
            goto Ld
        L9:
            int r0 = r6.L0()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.B
            r4.c(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.e(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.B
            r7.d(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.e(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.d(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.f2111x
            if (r7 == 0) goto L4d
            int r7 = r6.L0()
            goto L51
        L4d:
            int r7 = r6.M0()
        L51:
            if (r3 > r7) goto L56
            r6.m0()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.P0(int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:276:0x00cb, code lost:
        if (r10 == r11) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x00dd, code lost:
        if (r10 == r11) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x00df, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x00e1, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View Q0() {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Q0():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void R(RecyclerView recyclerView) {
        a aVar = this.K;
        RecyclerView recyclerView2 = this.f2034b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(aVar);
        }
        for (int i7 = 0; i7 < this.f2104p; i7++) {
            this.f2105q[i7].b();
        }
        recyclerView.requestLayout();
    }

    public final boolean R0() {
        return B() == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:459:0x004a, code lost:
        if (r8.f2107t == 1) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x004f, code lost:
        if (r8.f2107t == 0) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x005d, code lost:
        if (R0() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x0069, code lost:
        if (R0() == false) goto L115;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View S(android.view.View r9, int r10, androidx.recyclerview.widget.RecyclerView.r r11, androidx.recyclerview.widget.RecyclerView.w r12) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.S(android.view.View, int, androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:1131:0x03fe, code lost:
        if (C0() != false) goto L263;
     */
    /* JADX WARN: Removed duplicated region for block: B:997:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void S0(androidx.recyclerview.widget.RecyclerView.r r12, androidx.recyclerview.widget.RecyclerView.w r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.S0(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void T(AccessibilityEvent accessibilityEvent) {
        super.T(accessibilityEvent);
        if (w() > 0) {
            View I0 = I0(false);
            View H0 = H0(false);
            if (I0 == null || H0 == null) {
                return;
            }
            int G = RecyclerView.l.G(I0);
            int G2 = RecyclerView.l.G(H0);
            if (G < G2) {
                accessibilityEvent.setFromIndex(G);
                accessibilityEvent.setToIndex(G2);
                return;
            }
            accessibilityEvent.setFromIndex(G2);
            accessibilityEvent.setToIndex(G);
        }
    }

    public final boolean T0(int i7) {
        if (this.f2107t == 0) {
            return (i7 == -1) != this.f2111x;
        }
        return ((i7 == -1) == this.f2111x) == R0();
    }

    public final void U0(int i7, RecyclerView.w wVar) {
        int i8;
        int L0;
        if (i7 > 0) {
            L0 = M0();
            i8 = 1;
        } else {
            i8 = -1;
            L0 = L0();
        }
        this.f2109v.f2253a = true;
        b1(L0, wVar);
        a1(i8);
        l lVar = this.f2109v;
        lVar.f2255c = L0 + lVar.f2256d;
        lVar.f2254b = Math.abs(i7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x0011, code lost:
        if (r6.e == (-1)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void V0(androidx.recyclerview.widget.RecyclerView.r r5, androidx.recyclerview.widget.l r6) {
        /*
            r4 = this;
            boolean r0 = r6.f2253a
            if (r0 == 0) goto L7c
            boolean r0 = r6.f2260i
            if (r0 == 0) goto La
            goto L7c
        La:
            int r0 = r6.f2254b
            r1 = -1
            if (r0 != 0) goto L1f
            int r0 = r6.e
            if (r0 != r1) goto L19
        L13:
            int r6 = r6.f2258g
        L15:
            r4.W0(r6, r5)
            goto L7c
        L19:
            int r6 = r6.f2257f
        L1b:
            r4.X0(r6, r5)
            goto L7c
        L1f:
            int r0 = r6.e
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L50
            int r0 = r6.f2257f
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r1 = r4.f2105q
            r1 = r1[r2]
            int r1 = r1.i(r0)
        L2f:
            int r2 = r4.f2104p
            if (r3 >= r2) goto L41
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r2 = r4.f2105q
            r2 = r2[r3]
            int r2 = r2.i(r0)
            if (r2 <= r1) goto L3e
            r1 = r2
        L3e:
            int r3 = r3 + 1
            goto L2f
        L41:
            int r0 = r0 - r1
            if (r0 >= 0) goto L45
            goto L13
        L45:
            int r1 = r6.f2258g
            int r6 = r6.f2254b
            int r6 = java.lang.Math.min(r0, r6)
            int r6 = r1 - r6
            goto L15
        L50:
            int r0 = r6.f2258g
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r1 = r4.f2105q
            r1 = r1[r2]
            int r1 = r1.f(r0)
        L5a:
            int r2 = r4.f2104p
            if (r3 >= r2) goto L6c
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r2 = r4.f2105q
            r2 = r2[r3]
            int r2 = r2.f(r0)
            if (r2 >= r1) goto L69
            r1 = r2
        L69:
            int r3 = r3 + 1
            goto L5a
        L6c:
            int r0 = r6.f2258g
            int r1 = r1 - r0
            if (r1 >= 0) goto L72
            goto L19
        L72:
            int r0 = r6.f2257f
            int r6 = r6.f2254b
            int r6 = java.lang.Math.min(r1, r6)
            int r6 = r6 + r0
            goto L1b
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.V0(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.l):void");
    }

    public final void W0(int i7, RecyclerView.r rVar) {
        for (int w6 = w() - 1; w6 >= 0; w6--) {
            View v6 = v(w6);
            if (this.f2106r.e(v6) < i7 || this.f2106r.o(v6) < i7) {
                return;
            }
            c cVar = (c) v6.getLayoutParams();
            cVar.getClass();
            if (cVar.e.f2136a.size() == 1) {
                return;
            }
            f fVar = cVar.e;
            int size = fVar.f2136a.size();
            View remove = fVar.f2136a.remove(size - 1);
            c h7 = f.h(remove);
            h7.e = null;
            if (h7.c() || h7.b()) {
                fVar.f2139d -= StaggeredGridLayoutManager.this.f2106r.c(remove);
            }
            if (size == 1) {
                fVar.f2137b = Integer.MIN_VALUE;
            }
            fVar.f2138c = Integer.MIN_VALUE;
            j0(v6, rVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void X(int i7, int i8) {
        P0(i7, i8, 1);
    }

    public final void X0(int i7, RecyclerView.r rVar) {
        while (w() > 0) {
            View v6 = v(0);
            if (this.f2106r.b(v6) > i7 || this.f2106r.n(v6) > i7) {
                return;
            }
            c cVar = (c) v6.getLayoutParams();
            cVar.getClass();
            if (cVar.e.f2136a.size() == 1) {
                return;
            }
            f fVar = cVar.e;
            View remove = fVar.f2136a.remove(0);
            c h7 = f.h(remove);
            h7.e = null;
            if (fVar.f2136a.size() == 0) {
                fVar.f2138c = Integer.MIN_VALUE;
            }
            if (h7.c() || h7.b()) {
                fVar.f2139d -= StaggeredGridLayoutManager.this.f2106r.c(remove);
            }
            fVar.f2137b = Integer.MIN_VALUE;
            j0(v6, rVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void Y() {
        this.B.a();
        m0();
    }

    public final void Y0() {
        this.f2111x = (this.f2107t == 1 || !R0()) ? this.f2110w : !this.f2110w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void Z(int i7, int i8) {
        P0(i7, i8, 8);
    }

    public final int Z0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (w() == 0 || i7 == 0) {
            return 0;
        }
        U0(i7, wVar);
        int G0 = G0(rVar, this.f2109v, wVar);
        if (this.f2109v.f2254b >= G0) {
            i7 = i7 < 0 ? -G0 : G0;
        }
        this.f2106r.p(-i7);
        this.D = this.f2111x;
        l lVar = this.f2109v;
        lVar.f2254b = 0;
        V0(rVar, lVar);
        return i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v.b
    public final PointF a(int i7) {
        int B0 = B0(i7);
        PointF pointF = new PointF();
        if (B0 == 0) {
            return null;
        }
        if (this.f2107t == 0) {
            pointF.x = B0;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = B0;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void a0(int i7, int i8) {
        P0(i7, i8, 2);
    }

    public final void a1(int i7) {
        l lVar = this.f2109v;
        lVar.e = i7;
        lVar.f2256d = this.f2111x != (i7 == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void b0(int i7, int i8) {
        P0(i7, i8, 4);
    }

    public final void b1(int i7, RecyclerView.w wVar) {
        int i8;
        int i9;
        int i10;
        l lVar = this.f2109v;
        boolean z6 = false;
        lVar.f2254b = 0;
        lVar.f2255c = i7;
        RecyclerView.v vVar = this.e;
        if (!(vVar != null && vVar.e) || (i10 = wVar.f2085a) == -1) {
            i8 = 0;
            i9 = 0;
        } else {
            if (this.f2111x == (i10 < i7)) {
                i8 = this.f2106r.l();
                i9 = 0;
            } else {
                i9 = this.f2106r.l();
                i8 = 0;
            }
        }
        RecyclerView recyclerView = this.f2034b;
        if (recyclerView != null && recyclerView.m) {
            this.f2109v.f2257f = this.f2106r.k() - i9;
            this.f2109v.f2258g = this.f2106r.g() + i8;
        } else {
            this.f2109v.f2258g = this.f2106r.f() + i8;
            this.f2109v.f2257f = -i9;
        }
        l lVar2 = this.f2109v;
        lVar2.f2259h = false;
        lVar2.f2253a = true;
        if (this.f2106r.i() == 0 && this.f2106r.f() == 0) {
            z6 = true;
        }
        lVar2.f2260i = z6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void c0(RecyclerView.r rVar, RecyclerView.w wVar) {
        S0(rVar, wVar, true);
    }

    public final void c1(f fVar, int i7, int i8) {
        int i9 = fVar.f2139d;
        if (i7 == -1) {
            int i10 = fVar.f2137b;
            if (i10 == Integer.MIN_VALUE) {
                View view = fVar.f2136a.get(0);
                c h7 = f.h(view);
                fVar.f2137b = StaggeredGridLayoutManager.this.f2106r.e(view);
                h7.getClass();
                i10 = fVar.f2137b;
            }
            if (i10 + i9 > i8) {
                return;
            }
        } else {
            int i11 = fVar.f2138c;
            if (i11 == Integer.MIN_VALUE) {
                fVar.a();
                i11 = fVar.f2138c;
            }
            if (i11 - i9 < i8) {
                return;
            }
        }
        this.f2112y.set(fVar.e, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void d0(RecyclerView.w wVar) {
        this.f2113z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean e() {
        return this.f2107t == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void e0(Parcelable parcelable) {
        if (parcelable instanceof e) {
            e eVar = (e) parcelable;
            this.F = eVar;
            if (this.f2113z != -1) {
                eVar.f2130i = null;
                eVar.f2129h = 0;
                eVar.f2127f = -1;
                eVar.f2128g = -1;
                eVar.f2130i = null;
                eVar.f2129h = 0;
                eVar.f2131j = 0;
                eVar.f2132k = null;
                eVar.f2133l = null;
            }
            m0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean f() {
        return this.f2107t == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final Parcelable f0() {
        int i7;
        int k6;
        int[] iArr;
        e eVar = this.F;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.m = this.f2110w;
        eVar2.f2134n = this.D;
        eVar2.f2135o = this.E;
        d dVar = this.B;
        if (dVar == null || (iArr = dVar.f2121a) == null) {
            eVar2.f2131j = 0;
        } else {
            eVar2.f2132k = iArr;
            eVar2.f2131j = iArr.length;
            eVar2.f2133l = dVar.f2122b;
        }
        if (w() > 0) {
            eVar2.f2127f = this.D ? M0() : L0();
            View H0 = this.f2111x ? H0(true) : I0(true);
            eVar2.f2128g = H0 != null ? RecyclerView.l.G(H0) : -1;
            int i8 = this.f2104p;
            eVar2.f2129h = i8;
            eVar2.f2130i = new int[i8];
            for (int i9 = 0; i9 < this.f2104p; i9++) {
                if (this.D) {
                    i7 = this.f2105q[i9].f(Integer.MIN_VALUE);
                    if (i7 != Integer.MIN_VALUE) {
                        k6 = this.f2106r.g();
                        i7 -= k6;
                        eVar2.f2130i[i9] = i7;
                    } else {
                        eVar2.f2130i[i9] = i7;
                    }
                } else {
                    i7 = this.f2105q[i9].i(Integer.MIN_VALUE);
                    if (i7 != Integer.MIN_VALUE) {
                        k6 = this.f2106r.k();
                        i7 -= k6;
                        eVar2.f2130i[i9] = i7;
                    } else {
                        eVar2.f2130i[i9] = i7;
                    }
                }
            }
        } else {
            eVar2.f2127f = -1;
            eVar2.f2128g = -1;
            eVar2.f2129h = 0;
        }
        return eVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean g(RecyclerView.m mVar) {
        return mVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void g0(int i7) {
        if (i7 == 0) {
            C0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void i(int i7, int i8, RecyclerView.w wVar, RecyclerView.l.c cVar) {
        int f7;
        int i9;
        if (this.f2107t != 0) {
            i7 = i8;
        }
        if (w() == 0 || i7 == 0) {
            return;
        }
        U0(i7, wVar);
        int[] iArr = this.J;
        if (iArr == null || iArr.length < this.f2104p) {
            this.J = new int[this.f2104p];
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f2104p; i11++) {
            l lVar = this.f2109v;
            if (lVar.f2256d == -1) {
                f7 = lVar.f2257f;
                i9 = this.f2105q[i11].i(f7);
            } else {
                f7 = this.f2105q[i11].f(lVar.f2258g);
                i9 = this.f2109v.f2258g;
            }
            int i12 = f7 - i9;
            if (i12 >= 0) {
                this.J[i10] = i12;
                i10++;
            }
        }
        Arrays.sort(this.J, 0, i10);
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = this.f2109v.f2255c;
            if (!(i14 >= 0 && i14 < wVar.b())) {
                return;
            }
            ((k.b) cVar).a(this.f2109v.f2255c, this.J[i13]);
            l lVar2 = this.f2109v;
            lVar2.f2255c += lVar2.f2256d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int k(RecyclerView.w wVar) {
        return D0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int l(RecyclerView.w wVar) {
        return E0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int m(RecyclerView.w wVar) {
        return F0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int n(RecyclerView.w wVar) {
        return D0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int n0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        return Z0(i7, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int o(RecyclerView.w wVar) {
        return E0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void o0(int i7) {
        e eVar = this.F;
        if (eVar != null && eVar.f2127f != i7) {
            eVar.f2130i = null;
            eVar.f2129h = 0;
            eVar.f2127f = -1;
            eVar.f2128g = -1;
        }
        this.f2113z = i7;
        this.A = Integer.MIN_VALUE;
        m0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int p(RecyclerView.w wVar) {
        return F0(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final int p0(int i7, RecyclerView.r rVar, RecyclerView.w wVar) {
        return Z0(i7, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m s() {
        return this.f2107t == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void s0(Rect rect, int i7, int i8) {
        int h7;
        int h8;
        int E = E() + D();
        int C = C() + F();
        if (this.f2107t == 1) {
            int height = rect.height() + C;
            RecyclerView recyclerView = this.f2034b;
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            h8 = RecyclerView.l.h(i8, height, y.d.d(recyclerView));
            h7 = RecyclerView.l.h(i7, (this.f2108u * this.f2104p) + E, y.d.e(this.f2034b));
        } else {
            int width = rect.width() + E;
            RecyclerView recyclerView2 = this.f2034b;
            WeakHashMap<View, k0> weakHashMap2 = p1.y.f5540a;
            h7 = RecyclerView.l.h(i7, width, y.d.e(recyclerView2));
            h8 = RecyclerView.l.h(i8, (this.f2108u * this.f2104p) + C, y.d.d(this.f2034b));
        }
        RecyclerView.g(this.f2034b, h7, h8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m t(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final RecyclerView.m u(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void y0(RecyclerView recyclerView, int i7) {
        m mVar = new m(recyclerView.getContext());
        mVar.f2072a = i7;
        z0(mVar);
    }
}
