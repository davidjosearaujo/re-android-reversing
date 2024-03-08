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
import androidx.activity.h;
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
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.l implements RecyclerView.v.b {
    public boolean D;
    public boolean E;
    public e F;
    public int[] J;

    /* renamed from: p  reason: collision with root package name */
    public int f2104p;

    /* renamed from: q  reason: collision with root package name */
    public f[] f2105q;

    /* renamed from: r  reason: collision with root package name */
    public q f2106r;
    public q s;

    /* renamed from: t  reason: collision with root package name */
    public int f2107t;

    /* renamed from: u  reason: collision with root package name */
    public int f2108u;

    /* renamed from: v  reason: collision with root package name */
    public final l f2109v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f2110w;

    /* renamed from: y  reason: collision with root package name */
    public BitSet f2112y;

    /* renamed from: x  reason: collision with root package name */
    public boolean f2111x = false;

    /* renamed from: z  reason: collision with root package name */
    public int f2113z = -1;
    public int A = Integer.MIN_VALUE;
    public d B = new d();
    public int C = 2;
    public final Rect G = new Rect();
    public final b H = new b();
    public boolean I = true;
    public final a K = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            StaggeredGridLayoutManager.this.C0();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2115a;

        /* renamed from: b  reason: collision with root package name */
        public int f2116b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2117c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2118d;
        public boolean e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f2119f;

        public b() {
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

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int[] f2121a;

        /* renamed from: b  reason: collision with root package name */
        public List<a> f2122b;

        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0020a();

            /* renamed from: f  reason: collision with root package name */
            public int f2123f;

            /* renamed from: g  reason: collision with root package name */
            public int f2124g;

            /* renamed from: h  reason: collision with root package name */
            public int[] f2125h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f2126i;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
                this.f2126i = parcel.readInt() != 1 ? false : true;
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

            @Override // java.lang.Object
            public final String toString() {
                StringBuilder d7 = h.d("FullSpanItem{mPosition=");
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

        /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int c(int r6) {
            /*
                r5 = this;
                int[] r0 = r5.f2121a
                r1 = -1
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                int r0 = r0.length
                if (r6 < r0) goto L_0x000a
                return r1
            L_0x000a:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r5.f2122b
                if (r0 != 0) goto L_0x000f
                goto L_0x005e
            L_0x000f:
                r2 = 0
                if (r0 != 0) goto L_0x0013
                goto L_0x002b
            L_0x0013:
                int r0 = r0.size()
                int r0 = r0 + r1
            L_0x0018:
                if (r0 < 0) goto L_0x002b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r5.f2122b
                java.lang.Object r3 = r3.get(r0)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r3
                int r4 = r3.f2123f
                if (r4 != r6) goto L_0x0028
                r2 = r3
                goto L_0x002b
            L_0x0028:
                int r0 = r0 + -1
                goto L_0x0018
            L_0x002b:
                if (r2 == 0) goto L_0x0032
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r5.f2122b
                r0.remove(r2)
            L_0x0032:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r5.f2122b
                int r0 = r0.size()
                r2 = 0
            L_0x0039:
                if (r2 >= r0) goto L_0x004b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r5.f2122b
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r3
                int r3 = r3.f2123f
                if (r3 < r6) goto L_0x0048
                goto L_0x004c
            L_0x0048:
                int r2 = r2 + 1
                goto L_0x0039
            L_0x004b:
                r2 = r1
            L_0x004c:
                if (r2 == r1) goto L_0x005e
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r0 = r5.f2122b
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a> r3 = r5.f2122b
                r3.remove(r2)
                int r0 = r0.f2123f
                goto L_0x005f
            L_0x005e:
                r0 = r1
            L_0x005f:
                if (r0 != r1) goto L_0x006b
                int[] r0 = r5.f2121a
                int r2 = r0.length
                java.util.Arrays.fill(r0, r6, r2, r1)
                int[] r5 = r5.f2121a
                int r5 = r5.length
                return r5
            L_0x006b:
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
            if (iArr != null && i7 < iArr.length) {
                int i9 = i7 + i8;
                b(i9);
                int[] iArr2 = this.f2121a;
                System.arraycopy(iArr2, i7, iArr2, i9, (iArr2.length - i7) - i8);
                Arrays.fill(this.f2121a, i7, i9, -1);
                List<a> list = this.f2122b;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        a aVar = this.f2122b.get(size);
                        int i10 = aVar.f2123f;
                        if (i10 >= i7) {
                            aVar.f2123f = i10 + i8;
                        }
                    }
                }
            }
        }

        public final void e(int i7, int i8) {
            int[] iArr = this.f2121a;
            if (iArr != null && i7 < iArr.length) {
                int i9 = i7 + i8;
                b(i9);
                int[] iArr2 = this.f2121a;
                System.arraycopy(iArr2, i9, iArr2, i7, (iArr2.length - i7) - i8);
                int[] iArr3 = this.f2121a;
                Arrays.fill(iArr3, iArr3.length - i8, iArr3.length, -1);
                List<a> list = this.f2122b;
                if (list != null) {
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
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: f  reason: collision with root package name */
        public int f2127f;

        /* renamed from: g  reason: collision with root package name */
        public int f2128g;

        /* renamed from: h  reason: collision with root package name */
        public int f2129h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f2130i;

        /* renamed from: j  reason: collision with root package name */
        public int f2131j;

        /* renamed from: k  reason: collision with root package name */
        public int[] f2132k;

        /* renamed from: l  reason: collision with root package name */
        public List<d.a> f2133l;
        public boolean m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f2134n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f2135o;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
            boolean z6 = false;
            this.m = parcel.readInt() == 1;
            this.f2134n = parcel.readInt() == 1;
            this.f2135o = parcel.readInt() == 1 ? true : z6;
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

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<View> f2136a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public int f2137b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        public int f2138c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        public int f2139d = 0;
        public final int e;

        public f(int i7) {
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
            int i8;
            if (StaggeredGridLayoutManager.this.f2110w) {
                i8 = this.f2136a.size() - 1;
                i7 = -1;
            } else {
                i8 = 0;
                i7 = this.f2136a.size();
            }
            return e(i8, i7);
        }

        public final int d() {
            int i7;
            int i8;
            if (StaggeredGridLayoutManager.this.f2110w) {
                i8 = 0;
                i7 = this.f2136a.size();
            } else {
                i8 = this.f2136a.size() - 1;
                i7 = -1;
            }
            return e(i8, i7);
        }

        public final int e(int i7, int i8) {
            int k6 = StaggeredGridLayoutManager.this.f2106r.k();
            int g2 = StaggeredGridLayoutManager.this.f2106r.g();
            int i9 = i8 > i7 ? 1 : -1;
            while (i7 != i8) {
                View view = this.f2136a.get(i7);
                int e = StaggeredGridLayoutManager.this.f2106r.e(view);
                int b2 = StaggeredGridLayoutManager.this.f2106r.b(view);
                boolean z6 = false;
                boolean z7 = e <= g2;
                if (b2 >= k6) {
                    z6 = true;
                }
                if (!z7 || !z6 || (e >= k6 && b2 <= g2)) {
                    i7 += i9;
                } else {
                    StaggeredGridLayoutManager.this.getClass();
                    return RecyclerView.l.G(view);
                }
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
        if (i9 == 0 || i9 == 1) {
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
            if (!(eVar == null || eVar.m == z6)) {
                eVar.m = z6;
            }
            this.f2110w = z6;
            m0();
            this.f2109v = new l();
            this.f2106r = q.a(this, this.f2107t);
            this.s = q.a(this, 1 - this.f2107t);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
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
        int i7;
        if (!(w() == 0 || this.C == 0 || !this.f2038g)) {
            if (this.f2111x) {
                i7 = M0();
                L0();
            } else {
                i7 = L0();
                M0();
            }
            if (i7 == 0 && Q0() != null) {
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

    public final int G0(RecyclerView.r rVar, l lVar, RecyclerView.w wVar) {
        f fVar;
        boolean z6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = 0;
        this.f2112y.set(0, this.f2104p, true);
        int i17 = this.f2109v.f2260i ? lVar.e == 1 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : Integer.MIN_VALUE : lVar.e == 1 ? lVar.f2258g + lVar.f2254b : lVar.f2257f - lVar.f2254b;
        int i18 = lVar.e;
        for (int i19 = 0; i19 < this.f2104p; i19++) {
            if (!this.f2105q[i19].f2136a.isEmpty()) {
                c1(this.f2105q[i19], i18, i17);
            }
        }
        int g2 = this.f2111x ? this.f2106r.g() : this.f2106r.k();
        Object[] objArr = null;
        while (true) {
            int i20 = lVar.f2255c;
            if (((i20 < 0 || i20 >= wVar.b()) ? i16 : 1) == 0 || (!this.f2109v.f2260i && this.f2112y.isEmpty())) {
                break;
            }
            View d7 = rVar.d(lVar.f2255c);
            lVar.f2255c += lVar.f2256d;
            c cVar = (c) d7.getLayoutParams();
            int a7 = cVar.a();
            int[] iArr = this.B.f2121a;
            int i21 = (iArr == null || a7 >= iArr.length) ? -1 : iArr[a7];
            if ((i21 == -1 ? 1 : i16) != 0) {
                if (T0(lVar.e)) {
                    i14 = this.f2104p - 1;
                    i13 = -1;
                    i15 = -1;
                } else {
                    i15 = this.f2104p;
                    i14 = i16;
                    i13 = 1;
                }
                fVar = null;
                if (lVar.e == 1) {
                    int k6 = this.f2106r.k();
                    int i22 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                    while (i14 != i15) {
                        f fVar2 = this.f2105q[i14];
                        int f7 = fVar2.f(k6);
                        if (f7 < i22) {
                            fVar = fVar2;
                            i22 = f7;
                        }
                        i14 += i13;
                    }
                } else {
                    int g7 = this.f2106r.g();
                    int i23 = Integer.MIN_VALUE;
                    while (i14 != i15) {
                        f fVar3 = this.f2105q[i14];
                        int i24 = fVar3.i(g7);
                        if (i24 > i23) {
                            fVar = fVar3;
                            i23 = i24;
                        }
                        i14 += i13;
                    }
                }
                d dVar = this.B;
                dVar.b(a7);
                dVar.f2121a[a7] = fVar.e;
            } else {
                fVar = this.f2105q[i21];
            }
            cVar.e = fVar;
            if (lVar.e == 1) {
                z6 = false;
                b(d7, -1, false);
            } else {
                z6 = false;
                b(d7, 0, false);
            }
            if (this.f2107t == 1) {
                int i25 = this.f2108u;
                int i26 = this.f2043l;
                int i27 = ((ViewGroup.MarginLayoutParams) cVar).width;
                int i28 = z6 ? 1 : 0;
                int i29 = z6 ? 1 : 0;
                int i30 = z6 ? 1 : 0;
                i8 = RecyclerView.l.x(i25, i26, i28, i27, z6);
                i7 = RecyclerView.l.x(this.f2045o, this.m, C() + F(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
            } else {
                i8 = RecyclerView.l.x(this.f2044n, this.f2043l, E() + D(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
                i7 = RecyclerView.l.x(this.f2108u, this.m, 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
            }
            d(d7, this.G);
            c cVar2 = (c) d7.getLayoutParams();
            int i31 = ((ViewGroup.MarginLayoutParams) cVar2).leftMargin;
            Rect rect = this.G;
            int d12 = d1(i8, i31 + rect.left, ((ViewGroup.MarginLayoutParams) cVar2).rightMargin + rect.right);
            int i32 = ((ViewGroup.MarginLayoutParams) cVar2).topMargin;
            Rect rect2 = this.G;
            int d13 = d1(i7, i32 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar2).bottomMargin + rect2.bottom);
            if (v0(d7, d12, d13, cVar2)) {
                d7.measure(d12, d13);
            }
            if (lVar.e == 1) {
                i10 = fVar.f(g2);
                i9 = this.f2106r.c(d7) + i10;
            } else {
                i9 = fVar.i(g2);
                i10 = i9 - this.f2106r.c(d7);
            }
            int i33 = lVar.e;
            f fVar4 = cVar.e;
            fVar4.getClass();
            if (i33 == 1) {
                c cVar3 = (c) d7.getLayoutParams();
                cVar3.e = fVar4;
                fVar4.f2136a.add(d7);
                fVar4.f2138c = Integer.MIN_VALUE;
                if (fVar4.f2136a.size() == 1) {
                    fVar4.f2137b = Integer.MIN_VALUE;
                }
                if (cVar3.c() || cVar3.b()) {
                    fVar4.f2139d = StaggeredGridLayoutManager.this.f2106r.c(d7) + fVar4.f2139d;
                }
            } else {
                c cVar4 = (c) d7.getLayoutParams();
                cVar4.e = fVar4;
                fVar4.f2136a.add(0, d7);
                fVar4.f2137b = Integer.MIN_VALUE;
                if (fVar4.f2136a.size() == 1) {
                    fVar4.f2138c = Integer.MIN_VALUE;
                }
                if (cVar4.c() || cVar4.b()) {
                    fVar4.f2139d = StaggeredGridLayoutManager.this.f2106r.c(d7) + fVar4.f2139d;
                }
            }
            if (!R0() || this.f2107t != 1) {
                i11 = this.s.k() + (fVar.e * this.f2108u);
                i12 = this.s.c(d7) + i11;
            } else {
                i12 = this.s.g() - (((this.f2104p - 1) - fVar.e) * this.f2108u);
                i11 = i12 - this.s.c(d7);
            }
            if (this.f2107t == 1) {
                i11 = i10;
                i10 = i11;
                i12 = i9;
                i9 = i12;
            }
            RecyclerView.l.M(d7, i10, i11, i9, i12);
            c1(fVar, this.f2109v.e, i17);
            V0(rVar, this.f2109v);
            if (!this.f2109v.f2259h || !d7.hasFocusable()) {
                i16 = 0;
            } else {
                i16 = 0;
                this.f2112y.set(fVar.e, false);
            }
            objArr = 1;
        }
        if (objArr == null) {
            V0(rVar, this.f2109v);
        }
        int k7 = this.f2109v.e == -1 ? this.f2106r.k() - O0(this.f2106r.k()) : N0(this.f2106r.g()) - this.f2106r.g();
        return k7 > 0 ? Math.min(lVar.f2254b, k7) : i16;
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
            if (z6 && i7 > 0) {
                this.f2106r.p(i7);
            }
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
            if (z6 && Z0 > 0) {
                this.f2106r.p(-Z0);
            }
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P0(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f2111x
            if (r0 == 0) goto L_0x0009
            int r0 = r6.M0()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.L0()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.B
            r4.c(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.e(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.B
            r7.d(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.e(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.d(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.f2111x
            if (r7 == 0) goto L_0x004d
            int r7 = r6.L0()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.M0()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.m0()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.P0(int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cb, code lost:
        if (r10 == r11) goto L_0x00df;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00dd, code lost:
        if (r10 == r11) goto L_0x00df;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00df, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e1, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View Q0() {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
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

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
        if (r8.f2107t == 1) goto L_0x006d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
        if (r8.f2107t == 0) goto L_0x006d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
        if (R0() == false) goto L_0x006b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0069, code lost:
        if (R0() == false) goto L_0x006d;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View S(android.view.View r9, int r10, androidx.recyclerview.widget.RecyclerView.r r11, androidx.recyclerview.widget.RecyclerView.w r12) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.S(android.view.View, int, androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:240:0x03fe, code lost:
        if (C0() != false) goto L_0x0402;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S0(androidx.recyclerview.widget.RecyclerView.r r12, androidx.recyclerview.widget.RecyclerView.w r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.S0(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void T(AccessibilityEvent accessibilityEvent) {
        super.T(accessibilityEvent);
        if (w() > 0) {
            View I0 = I0(false);
            View H0 = H0(false);
            if (I0 != null && H0 != null) {
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
    }

    public final boolean T0(int i7) {
        if (this.f2107t == 0) {
            return (i7 == -1) != this.f2111x;
        }
        return ((i7 == -1) == this.f2111x) == R0();
    }

    public final void U0(int i7, RecyclerView.w wVar) {
        int i8;
        int i9;
        if (i7 > 0) {
            i9 = M0();
            i8 = 1;
        } else {
            i8 = -1;
            i9 = L0();
        }
        this.f2109v.f2253a = true;
        b1(i9, wVar);
        a1(i8);
        l lVar = this.f2109v;
        lVar.f2255c = i9 + lVar.f2256d;
        lVar.f2254b = Math.abs(i7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
        if (r6.e == -1) goto L_0x0013;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V0(androidx.recyclerview.widget.RecyclerView.r r5, androidx.recyclerview.widget.l r6) {
        /*
            r4 = this;
            boolean r0 = r6.f2253a
            if (r0 == 0) goto L_0x007c
            boolean r0 = r6.f2260i
            if (r0 == 0) goto L_0x000a
            goto L_0x007c
        L_0x000a:
            int r0 = r6.f2254b
            r1 = -1
            if (r0 != 0) goto L_0x001f
            int r0 = r6.e
            if (r0 != r1) goto L_0x0019
        L_0x0013:
            int r6 = r6.f2258g
        L_0x0015:
            r4.W0(r6, r5)
            goto L_0x007c
        L_0x0019:
            int r6 = r6.f2257f
        L_0x001b:
            r4.X0(r6, r5)
            goto L_0x007c
        L_0x001f:
            int r0 = r6.e
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x0050
            int r0 = r6.f2257f
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r1 = r4.f2105q
            r1 = r1[r2]
            int r1 = r1.i(r0)
        L_0x002f:
            int r2 = r4.f2104p
            if (r3 >= r2) goto L_0x0041
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r2 = r4.f2105q
            r2 = r2[r3]
            int r2 = r2.i(r0)
            if (r2 <= r1) goto L_0x003e
            r1 = r2
        L_0x003e:
            int r3 = r3 + 1
            goto L_0x002f
        L_0x0041:
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x0045
            goto L_0x0013
        L_0x0045:
            int r1 = r6.f2258g
            int r6 = r6.f2254b
            int r6 = java.lang.Math.min(r0, r6)
            int r6 = r1 - r6
            goto L_0x0015
        L_0x0050:
            int r0 = r6.f2258g
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r1 = r4.f2105q
            r1 = r1[r2]
            int r1 = r1.f(r0)
        L_0x005a:
            int r2 = r4.f2104p
            if (r3 >= r2) goto L_0x006c
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f[] r2 = r4.f2105q
            r2 = r2[r3]
            int r2 = r2.f(r0)
            if (r2 >= r1) goto L_0x0069
            r1 = r2
        L_0x0069:
            int r3 = r3 + 1
            goto L_0x005a
        L_0x006c:
            int r0 = r6.f2258g
            int r1 = r1 - r0
            if (r1 >= 0) goto L_0x0072
            goto L_0x0019
        L_0x0072:
            int r0 = r6.f2257f
            int r6 = r6.f2254b
            int r6 = java.lang.Math.min(r1, r6)
            int r6 = r6 + r0
            goto L_0x001b
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.V0(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.l):void");
    }

    public final void W0(int i7, RecyclerView.r rVar) {
        for (int w6 = w() - 1; w6 >= 0; w6--) {
            View v6 = v(w6);
            if (this.f2106r.e(v6) >= i7 && this.f2106r.o(v6) >= i7) {
                c cVar = (c) v6.getLayoutParams();
                cVar.getClass();
                if (cVar.e.f2136a.size() != 1) {
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
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void X(int i7, int i8) {
        P0(i7, i8, 1);
    }

    public final void X0(int i7, RecyclerView.r rVar) {
        while (w() > 0) {
            View v6 = v(0);
            if (this.f2106r.b(v6) <= i7 && this.f2106r.n(v6) <= i7) {
                c cVar = (c) v6.getLayoutParams();
                cVar.getClass();
                if (cVar.e.f2136a.size() != 1) {
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
                } else {
                    return;
                }
            } else {
                return;
            }
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
            pointF.x = (float) B0;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) B0;
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
        int i8 = 1;
        if (this.f2111x != (i7 == -1)) {
            i8 = -1;
        }
        lVar.f2256d = i8;
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
            i9 = 0;
            i8 = 0;
        } else {
            if (this.f2111x == (i10 < i7)) {
                i9 = this.f2106r.l();
                i8 = 0;
            } else {
                i8 = this.f2106r.l();
                i9 = 0;
            }
        }
        RecyclerView recyclerView = this.f2034b;
        if (recyclerView != null && recyclerView.m) {
            this.f2109v.f2257f = this.f2106r.k() - i8;
            this.f2109v.f2258g = this.f2106r.g() + i9;
        } else {
            this.f2109v.f2258g = this.f2106r.f() + i9;
            this.f2109v.f2257f = -i8;
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
        int i8;
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
        int i9 = -1;
        if (w() > 0) {
            eVar2.f2127f = this.D ? M0() : L0();
            View H0 = this.f2111x ? H0(true) : I0(true);
            if (H0 != null) {
                i9 = RecyclerView.l.G(H0);
            }
            eVar2.f2128g = i9;
            int i10 = this.f2104p;
            eVar2.f2129h = i10;
            eVar2.f2130i = new int[i10];
            for (int i11 = 0; i11 < this.f2104p; i11++) {
                if (this.D) {
                    i7 = this.f2105q[i11].f(Integer.MIN_VALUE);
                    if (i7 != Integer.MIN_VALUE) {
                        i8 = this.f2106r.g();
                        i7 -= i8;
                        eVar2.f2130i[i11] = i7;
                    } else {
                        eVar2.f2130i[i11] = i7;
                    }
                } else {
                    i7 = this.f2105q[i11].i(Integer.MIN_VALUE);
                    if (i7 != Integer.MIN_VALUE) {
                        i8 = this.f2106r.k();
                        i7 -= i8;
                        eVar2.f2130i[i11] = i7;
                    } else {
                        eVar2.f2130i[i11] = i7;
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
        int i9;
        int i10;
        if (this.f2107t != 0) {
            i7 = i8;
        }
        if (!(w() == 0 || i7 == 0)) {
            U0(i7, wVar);
            int[] iArr = this.J;
            if (iArr == null || iArr.length < this.f2104p) {
                this.J = new int[this.f2104p];
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.f2104p; i12++) {
                l lVar = this.f2109v;
                if (lVar.f2256d == -1) {
                    i10 = lVar.f2257f;
                    i9 = this.f2105q[i12].i(i10);
                } else {
                    i10 = this.f2105q[i12].f(lVar.f2258g);
                    i9 = this.f2109v.f2258g;
                }
                int i13 = i10 - i9;
                if (i13 >= 0) {
                    this.J[i11] = i13;
                    i11++;
                }
            }
            Arrays.sort(this.J, 0, i11);
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = this.f2109v.f2255c;
                if (i15 >= 0 && i15 < wVar.b()) {
                    ((k.b) cVar).a(this.f2109v.f2255c, this.J[i14]);
                    l lVar2 = this.f2109v;
                    lVar2.f2255c += lVar2.f2256d;
                } else {
                    return;
                }
            }
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
        if (!(eVar == null || eVar.f2127f == i7)) {
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
        int i9;
        int i10;
        int E = E() + D();
        int C = C() + F();
        if (this.f2107t == 1) {
            int height = rect.height() + C;
            RecyclerView recyclerView = this.f2034b;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            i10 = RecyclerView.l.h(i8, height, y.d.d(recyclerView));
            i9 = RecyclerView.l.h(i7, (this.f2108u * this.f2104p) + E, y.d.e(this.f2034b));
        } else {
            int width = rect.width() + E;
            RecyclerView recyclerView2 = this.f2034b;
            WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
            i9 = RecyclerView.l.h(i7, width, y.d.e(recyclerView2));
            i10 = RecyclerView.l.h(i8, (this.f2108u * this.f2104p) + C, y.d.d(this.f2034b));
        }
        this.f2034b.setMeasuredDimension(i9, i10);
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
