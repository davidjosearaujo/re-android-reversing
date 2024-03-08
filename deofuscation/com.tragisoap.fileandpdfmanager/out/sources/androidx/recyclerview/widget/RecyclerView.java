package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.a0;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.v;
import androidx.recyclerview.widget.z;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class RecyclerView extends ViewGroup implements p1.k {
    public static boolean D0 = false;
    public static boolean E0 = false;
    public static final Class<?>[] J0;
    public int A;
    public int A0;
    public boolean B;
    public int B0;
    public boolean C;
    public final c C0;
    public boolean D;
    public int E;
    public final AccessibilityManager F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public h K;
    public EdgeEffect L;
    public EdgeEffect M;
    public EdgeEffect N;
    public EdgeEffect O;
    public i P;
    public int Q;
    public int R;
    public VelocityTracker S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a0 */
    public int f1958a0;

    /* renamed from: b0 */
    public n f1959b0;

    /* renamed from: c0 */
    public final int f1960c0;

    /* renamed from: d0 */
    public final int f1961d0;

    /* renamed from: e0 */
    public float f1962e0;

    /* renamed from: f */
    public final float f1963f;

    /* renamed from: f0 */
    public float f1964f0;

    /* renamed from: g */
    public final t f1965g;

    /* renamed from: g0 */
    public boolean f1966g0;

    /* renamed from: h */
    public final r f1967h;

    /* renamed from: h0 */
    public final z f1968h0;

    /* renamed from: i */
    public u f1969i;

    /* renamed from: i0 */
    public k f1970i0;

    /* renamed from: j */
    public a f1971j;

    /* renamed from: j0 */
    public k.b f1972j0;

    /* renamed from: k */
    public b f1973k;

    /* renamed from: k0 */
    public final w f1974k0;

    /* renamed from: l */
    public final a0 f1975l;

    /* renamed from: l0 */
    public p f1976l0;
    public boolean m;

    /* renamed from: m0 */
    public ArrayList f1977m0;

    /* renamed from: n */
    public final Rect f1978n;

    /* renamed from: n0 */
    public boolean f1979n0;

    /* renamed from: o */
    public final Rect f1980o;

    /* renamed from: o0 */
    public boolean f1981o0;

    /* renamed from: p */
    public final RectF f1982p;

    /* renamed from: p0 */
    public j f1983p0;

    /* renamed from: q */
    public d f1984q;

    /* renamed from: q0 */
    public boolean f1985q0;

    /* renamed from: r */
    public l f1986r;

    /* renamed from: r0 */
    public v f1987r0;
    public s s;

    /* renamed from: s0 */
    public final int[] f1988s0;

    /* renamed from: t */
    public final ArrayList f1989t;

    /* renamed from: t0 */
    public p1.l f1990t0;

    /* renamed from: u */
    public final ArrayList<k> f1991u;

    /* renamed from: u0 */
    public final int[] f1992u0;

    /* renamed from: v */
    public final ArrayList<o> f1993v;

    /* renamed from: v0 */
    public final int[] f1994v0;

    /* renamed from: w */
    public o f1995w;

    /* renamed from: w0 */
    public final int[] f1996w0;

    /* renamed from: x */
    public boolean f1997x;

    /* renamed from: x0 */
    public final ArrayList f1998x0;

    /* renamed from: y */
    public boolean f1999y;

    /* renamed from: y0 */
    public a f2000y0;

    /* renamed from: z */
    public boolean f2001z;

    /* renamed from: z0 */
    public boolean f2002z0;
    public static final int[] F0 = {16843830};
    public static final float G0 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean H0 = true;
    public static final boolean I0 = true;
    public static final b K0 = new b();
    public static final x L0 = new x();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {
        public a() {
            RecyclerView.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i iVar = RecyclerView.this.P;
            if (iVar != null) {
                iVar.l();
            }
            RecyclerView.this.f1985q0 = false;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class a0 {

        /* renamed from: t */
        public static final List<Object> f2004t = Collections.emptyList();

        /* renamed from: a */
        public final View f2005a;

        /* renamed from: b */
        public WeakReference<RecyclerView> f2006b;

        /* renamed from: j */
        public int f2013j;

        /* renamed from: r */
        public RecyclerView f2020r;
        public d<? extends a0> s;

        /* renamed from: c */
        public int f2007c = -1;

        /* renamed from: d */
        public int f2008d = -1;
        public long e = -1;

        /* renamed from: f */
        public int f2009f = -1;

        /* renamed from: g */
        public int f2010g = -1;

        /* renamed from: h */
        public a0 f2011h = null;

        /* renamed from: i */
        public a0 f2012i = null;

        /* renamed from: k */
        public ArrayList f2014k = null;

        /* renamed from: l */
        public List<Object> f2015l = null;
        public int m = 0;

        /* renamed from: n */
        public r f2016n = null;

        /* renamed from: o */
        public boolean f2017o = false;

        /* renamed from: p */
        public int f2018p = 0;

        /* renamed from: q */
        public int f2019q = -1;

        public a0(View view) {
            if (view != null) {
                this.f2005a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public final void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f2013j) == 0) {
                if (this.f2014k == null) {
                    ArrayList arrayList = new ArrayList();
                    this.f2014k = arrayList;
                    this.f2015l = Collections.unmodifiableList(arrayList);
                }
                this.f2014k.add(obj);
            }
        }

        public final void b(int i7) {
            this.f2013j = i7 | this.f2013j;
        }

        public final int c() {
            int i7 = this.f2010g;
            return i7 == -1 ? this.f2007c : i7;
        }

        public final List<Object> d() {
            if ((this.f2013j & 1024) != 0) {
                return f2004t;
            }
            ArrayList arrayList = this.f2014k;
            return (arrayList == null || arrayList.size() == 0) ? f2004t : this.f2015l;
        }

        public final boolean e() {
            return (this.f2005a.getParent() == null || this.f2005a.getParent() == this.f2020r) ? false : true;
        }

        public final boolean f() {
            return (this.f2013j & 1) != 0;
        }

        public final boolean g() {
            return (this.f2013j & 4) != 0;
        }

        public final boolean h() {
            if ((this.f2013j & 16) == 0) {
                View view = this.f2005a;
                WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
                if (!y.d.i(view)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean i() {
            return (this.f2013j & 8) != 0;
        }

        public final boolean j() {
            return this.f2016n != null;
        }

        public final boolean k() {
            return (this.f2013j & 256) != 0;
        }

        public final void l(int i7, boolean z6) {
            if (this.f2008d == -1) {
                this.f2008d = this.f2007c;
            }
            if (this.f2010g == -1) {
                this.f2010g = this.f2007c;
            }
            if (z6) {
                this.f2010g += i7;
            }
            this.f2007c += i7;
            if (this.f2005a.getLayoutParams() != null) {
                ((m) this.f2005a.getLayoutParams()).f2054c = true;
            }
        }

        public final void m() {
            if (!RecyclerView.D0 || !k()) {
                this.f2013j = 0;
                this.f2007c = -1;
                this.f2008d = -1;
                this.e = -1;
                this.f2010g = -1;
                this.m = 0;
                this.f2011h = null;
                this.f2012i = null;
                ArrayList arrayList = this.f2014k;
                if (arrayList != null) {
                    arrayList.clear();
                }
                this.f2013j &= -1025;
                this.f2018p = 0;
                this.f2019q = -1;
                RecyclerView.l(this);
                return;
            }
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        public final void n(boolean z6) {
            int i7;
            int i8 = this.m;
            int i9 = z6 ? i8 - 1 : i8 + 1;
            this.m = i9;
            if (i9 < 0) {
                this.m = 0;
                if (!RecyclerView.D0) {
                    Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                } else {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
            } else {
                if (!z6 && i9 == 1) {
                    i7 = this.f2013j | 16;
                } else if (z6 && i9 == 0) {
                    i7 = this.f2013j & -17;
                }
                this.f2013j = i7;
            }
            if (RecyclerView.E0) {
                Log.d("RecyclerView", "setIsRecyclable val:" + z6 + ":" + this);
            }
        }

        public final boolean o() {
            return (this.f2013j & 128) != 0;
        }

        public final boolean p() {
            return (this.f2013j & 32) != 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f2007c + " id=" + this.e + ", oldPos=" + this.f2008d + ", pLpos:" + this.f2010g);
            if (j()) {
                sb.append(" scrap ");
                sb.append(this.f2017o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (g()) {
                sb.append(" invalid");
            }
            if (!f()) {
                sb.append(" unbound");
            }
            boolean z6 = true;
            if ((this.f2013j & 2) != 0) {
                sb.append(" update");
            }
            if (i()) {
                sb.append(" removed");
            }
            if (o()) {
                sb.append(" ignored");
            }
            if (k()) {
                sb.append(" tmpDetached");
            }
            if (!h()) {
                StringBuilder d7 = androidx.activity.h.d(" not recyclable(");
                d7.append(this.m);
                d7.append(")");
                sb.append(d7.toString());
            }
            if ((this.f2013j & 512) == 0 && !g()) {
                z6 = false;
            }
            if (z6) {
                sb.append(" undefined adapter position");
            }
            if (this.f2005a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f7) {
            float f8 = f7 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c {
        public c() {
            RecyclerView.this = r1;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class d<VH extends a0> {

        /* renamed from: a */
        public final e f2022a = new e();

        /* renamed from: b */
        public boolean f2023b = false;

        /* renamed from: c */
        public int f2024c = 1;

        public abstract int a();

        public long b(int i7) {
            return -1;
        }

        public final void c() {
            this.f2022a.b();
        }

        public abstract void d(VH vh, int i7);

        public abstract a0 e(RecyclerView recyclerView);

        public void f(VH vh) {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e extends Observable<f> {
        public final boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public final void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((f) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class f {
        public void a() {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface g {
        int a();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class h {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class i {

        /* renamed from: a */
        public b f2025a = null;

        /* renamed from: b */
        public ArrayList<a> f2026b = new ArrayList<>();

        /* renamed from: c */
        public long f2027c = 120;

        /* renamed from: d */
        public long f2028d = 120;
        public long e = 250;

        /* renamed from: f */
        public long f2029f = 250;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public interface a {
            void a();
        }

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public interface b {
        }

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static class c {

            /* renamed from: a */
            public int f2030a;

            /* renamed from: b */
            public int f2031b;

            public final void a(a0 a0Var) {
                View view = a0Var.f2005a;
                this.f2030a = view.getLeft();
                this.f2031b = view.getTop();
                view.getRight();
                view.getBottom();
            }
        }

        public static void e(a0 a0Var) {
            RecyclerView recyclerView;
            int i7 = a0Var.f2013j & 14;
            if (!a0Var.g() && (i7 & 4) == 0 && (recyclerView = a0Var.f2020r) != null) {
                recyclerView.I(a0Var);
            }
        }

        public abstract boolean a(a0 a0Var, c cVar, c cVar2);

        public abstract boolean b(a0 a0Var, a0 a0Var2, c cVar, c cVar2);

        public abstract boolean c(a0 a0Var, c cVar, c cVar2);

        public abstract boolean d(a0 a0Var, c cVar, c cVar2);

        public abstract boolean f(a0 a0Var, List<Object> list);

        /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void g(androidx.recyclerview.widget.RecyclerView.a0 r8) {
            /*
                r7 = this;
                androidx.recyclerview.widget.RecyclerView$i$b r7 = r7.f2025a
                if (r7 == 0) goto L_0x00c3
                androidx.recyclerview.widget.RecyclerView$j r7 = (androidx.recyclerview.widget.RecyclerView.j) r7
                r0 = 1
                r8.n(r0)
                androidx.recyclerview.widget.RecyclerView$a0 r1 = r8.f2011h
                r2 = 0
                if (r1 == 0) goto L_0x0015
                androidx.recyclerview.widget.RecyclerView$a0 r1 = r8.f2012i
                if (r1 != 0) goto L_0x0015
                r8.f2011h = r2
            L_0x0015:
                r8.f2012i = r2
                int r1 = r8.f2013j
                r1 = r1 & 16
                r2 = 0
                if (r1 == 0) goto L_0x0020
                r1 = r0
                goto L_0x0021
            L_0x0020:
                r1 = r2
            L_0x0021:
                if (r1 != 0) goto L_0x00c3
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r3 = r8.f2005a
                r1.j0()
                androidx.recyclerview.widget.b r4 = r1.f1973k
                int r5 = r4.f2158d
                if (r5 != r0) goto L_0x003d
                android.view.View r0 = r4.e
                if (r0 != r3) goto L_0x0035
                goto L_0x006f
            L_0x0035:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "Cannot call removeViewIfHidden within removeView(At) for a different view"
                r7.<init>(r8)
                throw r7
            L_0x003d:
                r6 = 2
                if (r5 == r6) goto L_0x00bb
                r4.f2158d = r6     // Catch: all -> 0x00b7
                androidx.recyclerview.widget.b$b r5 = r4.f2155a     // Catch: all -> 0x00b7
                androidx.recyclerview.widget.t r5 = (androidx.recyclerview.widget.t) r5     // Catch: all -> 0x00b7
                androidx.recyclerview.widget.RecyclerView r5 = r5.f2275a     // Catch: all -> 0x00b7
                int r5 = r5.indexOfChild(r3)     // Catch: all -> 0x00b7
                r6 = -1
                if (r5 != r6) goto L_0x0053
                r4.l(r3)     // Catch: all -> 0x00b7
                goto L_0x006a
            L_0x0053:
                androidx.recyclerview.widget.b$a r6 = r4.f2156b     // Catch: all -> 0x00b7
                boolean r6 = r6.d(r5)     // Catch: all -> 0x00b7
                if (r6 == 0) goto L_0x006d
                androidx.recyclerview.widget.b$a r6 = r4.f2156b     // Catch: all -> 0x00b7
                r6.f(r5)     // Catch: all -> 0x00b7
                r4.l(r3)     // Catch: all -> 0x00b7
                androidx.recyclerview.widget.b$b r6 = r4.f2155a     // Catch: all -> 0x00b7
                androidx.recyclerview.widget.t r6 = (androidx.recyclerview.widget.t) r6     // Catch: all -> 0x00b7
                r6.b(r5)     // Catch: all -> 0x00b7
            L_0x006a:
                r4.f2158d = r2
                goto L_0x0070
            L_0x006d:
                r4.f2158d = r2
            L_0x006f:
                r0 = r2
            L_0x0070:
                if (r0 == 0) goto L_0x00a2
                androidx.recyclerview.widget.RecyclerView$a0 r4 = androidx.recyclerview.widget.RecyclerView.L(r3)
                androidx.recyclerview.widget.RecyclerView$r r5 = r1.f1967h
                r5.m(r4)
                androidx.recyclerview.widget.RecyclerView$r r5 = r1.f1967h
                r5.j(r4)
                boolean r4 = androidx.recyclerview.widget.RecyclerView.E0
                if (r4 == 0) goto L_0x00a2
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "after removing animated view: "
                r4.append(r5)
                r4.append(r3)
                java.lang.String r3 = ", "
                r4.append(r3)
                r4.append(r1)
                java.lang.String r3 = r4.toString()
                java.lang.String r4 = "RecyclerView"
                android.util.Log.d(r4, r3)
            L_0x00a2:
                r3 = r0 ^ 1
                r1.k0(r3)
                if (r0 != 0) goto L_0x00c3
                boolean r0 = r8.k()
                if (r0 == 0) goto L_0x00c3
                androidx.recyclerview.widget.RecyclerView r7 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r8 = r8.f2005a
                r7.removeDetachedView(r8, r2)
                goto L_0x00c3
            L_0x00b7:
                r7 = move-exception
                r4.f2158d = r2
                throw r7
            L_0x00bb:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "Cannot call removeViewIfHidden within removeViewIfHidden"
                r7.<init>(r8)
                throw r7
            L_0x00c3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i.g(androidx.recyclerview.widget.RecyclerView$a0):void");
        }

        public final void h() {
            int size = this.f2026b.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f2026b.get(i7).a();
            }
            this.f2026b.clear();
        }

        public abstract void i(a0 a0Var);

        public abstract void j();

        public abstract boolean k();

        public abstract void l();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class j implements i.b {
        public j() {
            RecyclerView.this = r1;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class k {
        public void d(Rect rect, View view) {
            ((m) view.getLayoutParams()).a();
            rect.set(0, 0, 0, 0);
        }

        public void e(Canvas canvas, RecyclerView recyclerView) {
        }

        public void f(Canvas canvas, RecyclerView recyclerView) {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class l {

        /* renamed from: a */
        public b f2033a;

        /* renamed from: b */
        public RecyclerView f2034b;

        /* renamed from: c */
        public z f2035c;

        /* renamed from: d */
        public z f2036d;
        public v e;

        /* renamed from: f */
        public boolean f2037f = false;

        /* renamed from: g */
        public boolean f2038g = false;

        /* renamed from: h */
        public boolean f2039h = true;

        /* renamed from: i */
        public boolean f2040i = true;

        /* renamed from: j */
        public int f2041j;

        /* renamed from: k */
        public boolean f2042k;

        /* renamed from: l */
        public int f2043l;
        public int m;

        /* renamed from: n */
        public int f2044n;

        /* renamed from: o */
        public int f2045o;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements z.b {
            public a() {
                l.this = r1;
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int a() {
                l lVar = l.this;
                return lVar.f2044n - lVar.E();
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int b(View view) {
                l.this.getClass();
                return (view.getLeft() - ((m) view.getLayoutParams()).f2053b.left) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.z.b
            public final View c(int i7) {
                return l.this.v(i7);
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int d() {
                return l.this.D();
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int e(View view) {
                l.this.getClass();
                return view.getRight() + ((m) view.getLayoutParams()).f2053b.right + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).rightMargin;
            }
        }

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class b implements z.b {
            public b() {
                l.this = r1;
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int a() {
                l lVar = l.this;
                return lVar.f2045o - lVar.C();
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int b(View view) {
                l.this.getClass();
                return (view.getTop() - ((m) view.getLayoutParams()).f2053b.top) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.z.b
            public final View c(int i7) {
                return l.this.v(i7);
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int d() {
                return l.this.F();
            }

            @Override // androidx.recyclerview.widget.z.b
            public final int e(View view) {
                l.this.getClass();
                return view.getBottom() + ((m) view.getLayoutParams()).f2053b.bottom + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).bottomMargin;
            }
        }

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public interface c {
        }

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static class d {

            /* renamed from: a */
            public int f2048a;

            /* renamed from: b */
            public int f2049b;

            /* renamed from: c */
            public boolean f2050c;

            /* renamed from: d */
            public boolean f2051d;
        }

        public l() {
            a aVar = new a();
            b bVar = new b();
            this.f2035c = new z(aVar);
            this.f2036d = new z(bVar);
        }

        public static int G(View view) {
            return ((m) view.getLayoutParams()).a();
        }

        public static d H(Context context, AttributeSet attributeSet, int i7, int i8) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.e.f34c0, i7, i8);
            dVar.f2048a = obtainStyledAttributes.getInt(0, 1);
            dVar.f2049b = obtainStyledAttributes.getInt(10, 1);
            dVar.f2050c = obtainStyledAttributes.getBoolean(9, false);
            dVar.f2051d = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static boolean L(int i7, int i8, int i9) {
            int mode = View.MeasureSpec.getMode(i8);
            int size = View.MeasureSpec.getSize(i8);
            if (i9 > 0 && i7 != i9) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i7;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i7;
            }
            return true;
        }

        public static void M(View view, int i7, int i8, int i9, int i10) {
            m mVar = (m) view.getLayoutParams();
            Rect rect = mVar.f2053b;
            view.layout(i7 + rect.left + ((ViewGroup.MarginLayoutParams) mVar).leftMargin, i8 + rect.top + ((ViewGroup.MarginLayoutParams) mVar).topMargin, (i9 - rect.right) - ((ViewGroup.MarginLayoutParams) mVar).rightMargin, (i10 - rect.bottom) - ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        }

        public static int h(int i7, int i8, int i9) {
            int mode = View.MeasureSpec.getMode(i7);
            int size = View.MeasureSpec.getSize(i7);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i8, i9) : size : Math.min(size, Math.max(i8, i9));
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0020;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int x(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0020
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0020
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001e
            L_0x001c:
                r5 = r3
                goto L_0x0031
            L_0x001e:
                if (r7 != r1) goto L_0x0022
            L_0x0020:
                r7 = r4
                goto L_0x0031
            L_0x0022:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x0029
                goto L_0x002c
            L_0x0029:
                r7 = r4
                r5 = r6
                goto L_0x0031
            L_0x002c:
                r7 = r4
                r5 = r2
                goto L_0x0031
            L_0x002f:
                r5 = r6
                r7 = r5
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.l.x(int, int, int, int, boolean):int");
        }

        public final int A() {
            RecyclerView recyclerView = this.f2034b;
            d adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.a();
            }
            return 0;
        }

        public boolean A0() {
            return false;
        }

        public final int B() {
            RecyclerView recyclerView = this.f2034b;
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            return y.e.d(recyclerView);
        }

        public final int C() {
            RecyclerView recyclerView = this.f2034b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public final int D() {
            RecyclerView recyclerView = this.f2034b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public final int E() {
            RecyclerView recyclerView = this.f2034b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public final int F() {
            RecyclerView recyclerView = this.f2034b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int I(r rVar, w wVar) {
            return -1;
        }

        public final void J(View view, Rect rect) {
            Matrix matrix;
            Rect rect2 = ((m) view.getLayoutParams()).f2053b;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            if (!(this.f2034b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f2034b.f1982p;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean K() {
            return false;
        }

        public void N(int i7) {
            RecyclerView recyclerView = this.f2034b;
            if (recyclerView != null) {
                int e = recyclerView.f1973k.e();
                for (int i8 = 0; i8 < e; i8++) {
                    recyclerView.f1973k.d(i8).offsetLeftAndRight(i7);
                }
            }
        }

        public void O(int i7) {
            RecyclerView recyclerView = this.f2034b;
            if (recyclerView != null) {
                int e = recyclerView.f1973k.e();
                for (int i8 = 0; i8 < e; i8++) {
                    recyclerView.f1973k.d(i8).offsetTopAndBottom(i7);
                }
            }
        }

        public void P() {
        }

        public void Q(RecyclerView recyclerView) {
        }

        @SuppressLint({"UnknownNullness"})
        public void R(RecyclerView recyclerView) {
        }

        public View S(View view, int i7, r rVar, w wVar) {
            return null;
        }

        public void T(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2034b;
            r rVar = recyclerView.f1967h;
            w wVar = recyclerView.f1974k0;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z6 = true;
                if (!recyclerView.canScrollVertically(1) && !this.f2034b.canScrollVertically(-1) && !this.f2034b.canScrollHorizontally(-1) && !this.f2034b.canScrollHorizontally(1)) {
                    z6 = false;
                }
                accessibilityEvent.setScrollable(z6);
                d dVar = this.f2034b.f1984q;
                if (dVar != null) {
                    accessibilityEvent.setItemCount(dVar.a());
                }
            }
        }

        public void U(r rVar, w wVar, q1.f fVar) {
            if (this.f2034b.canScrollVertically(-1) || this.f2034b.canScrollHorizontally(-1)) {
                fVar.a(8192);
                fVar.f5624a.setScrollable(true);
            }
            if (this.f2034b.canScrollVertically(1) || this.f2034b.canScrollHorizontally(1)) {
                fVar.a(4096);
                fVar.f5624a.setScrollable(true);
            }
            fVar.f5624a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(I(rVar, wVar), y(rVar, wVar), false, 0));
        }

        public final void V(View view, q1.f fVar) {
            a0 L = RecyclerView.L(view);
            if (L != null && !L.i() && !this.f2033a.k(L.f2005a)) {
                RecyclerView recyclerView = this.f2034b;
                W(recyclerView.f1967h, recyclerView.f1974k0, view, fVar);
            }
        }

        public void W(r rVar, w wVar, View view, q1.f fVar) {
        }

        public void X(int i7, int i8) {
        }

        public void Y() {
        }

        public void Z(int i7, int i8) {
        }

        public void a0(int i7, int i8) {
        }

        public final void b(View view, int i7, boolean z6) {
            a0 L = RecyclerView.L(view);
            if (z6 || L.i()) {
                a0 a0Var = this.f2034b.f1975l;
                a0.a orDefault = a0Var.f2149a.getOrDefault(L, null);
                if (orDefault == null) {
                    orDefault = a0.a.a();
                    a0Var.f2149a.put(L, orDefault);
                }
                orDefault.f2152a |= 1;
            } else {
                this.f2034b.f1975l.d(L);
            }
            m mVar = (m) view.getLayoutParams();
            if (L.p() || L.j()) {
                if (L.j()) {
                    L.f2016n.m(L);
                } else {
                    L.f2013j &= -33;
                }
                this.f2033a.b(view, i7, view.getLayoutParams(), false);
            } else {
                int i8 = -1;
                if (view.getParent() == this.f2034b) {
                    int j7 = this.f2033a.j(view);
                    if (i7 == -1) {
                        i7 = this.f2033a.e();
                    }
                    if (j7 == -1) {
                        StringBuilder d7 = androidx.activity.h.d("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        d7.append(this.f2034b.indexOfChild(view));
                        throw new IllegalStateException(androidx.activity.h.b(this.f2034b, d7));
                    } else if (j7 != i7) {
                        l lVar = this.f2034b.f1986r;
                        View v6 = lVar.v(j7);
                        if (v6 != null) {
                            lVar.v(j7);
                            lVar.f2033a.c(j7);
                            m mVar2 = (m) v6.getLayoutParams();
                            a0 L2 = RecyclerView.L(v6);
                            if (L2.i()) {
                                a0 a0Var2 = lVar.f2034b.f1975l;
                                a0.a orDefault2 = a0Var2.f2149a.getOrDefault(L2, null);
                                if (orDefault2 == null) {
                                    orDefault2 = a0.a.a();
                                    a0Var2.f2149a.put(L2, orDefault2);
                                }
                                orDefault2.f2152a = 1 | orDefault2.f2152a;
                            } else {
                                lVar.f2034b.f1975l.d(L2);
                            }
                            lVar.f2033a.b(v6, i7, mVar2, L2.i());
                        } else {
                            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j7 + lVar.f2034b.toString());
                        }
                    }
                } else {
                    this.f2033a.a(view, i7, false);
                    mVar.f2054c = true;
                    v vVar = this.e;
                    if (vVar != null && vVar.e) {
                        vVar.f2073b.getClass();
                        a0 L3 = RecyclerView.L(view);
                        if (L3 != null) {
                            i8 = L3.c();
                        }
                        if (i8 == vVar.f2072a) {
                            vVar.f2076f = view;
                            if (RecyclerView.E0) {
                                Log.d("RecyclerView", "smooth scroll target view has been attached");
                            }
                        }
                    }
                }
            }
            if (mVar.f2055d) {
                if (RecyclerView.E0) {
                    StringBuilder d8 = androidx.activity.h.d("consuming pending invalidate on child ");
                    d8.append(mVar.f2052a);
                    Log.d("RecyclerView", d8.toString());
                }
                L.f2005a.invalidate();
                mVar.f2055d = false;
            }
        }

        public void b0(int i7, int i8) {
        }

        @SuppressLint({"UnknownNullness"})
        public void c(String str) {
            RecyclerView recyclerView = this.f2034b;
            if (recyclerView != null) {
                recyclerView.k(str);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void c0(r rVar, w wVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public final void d(View view, Rect rect) {
            RecyclerView recyclerView = this.f2034b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.N(view));
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void d0(w wVar) {
        }

        public boolean e() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void e0(Parcelable parcelable) {
        }

        public boolean f() {
            return false;
        }

        public Parcelable f0() {
            return null;
        }

        public boolean g(m mVar) {
            return mVar != null;
        }

        public void g0(int i7) {
        }

        public final void h0(r rVar) {
            int w6 = w();
            while (true) {
                w6--;
                if (w6 < 0) {
                    return;
                }
                if (!RecyclerView.L(v(w6)).o()) {
                    View v6 = v(w6);
                    k0(w6);
                    rVar.i(v6);
                }
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void i(int i7, int i8, w wVar, c cVar) {
        }

        public final void i0(r rVar) {
            int size = rVar.f2063a.size();
            for (int i7 = size - 1; i7 >= 0; i7--) {
                View view = rVar.f2063a.get(i7).f2005a;
                a0 L = RecyclerView.L(view);
                if (!L.o()) {
                    L.n(false);
                    if (L.k()) {
                        this.f2034b.removeDetachedView(view, false);
                    }
                    i iVar = this.f2034b.P;
                    if (iVar != null) {
                        iVar.i(L);
                    }
                    L.n(true);
                    a0 L2 = RecyclerView.L(view);
                    L2.f2016n = null;
                    L2.f2017o = false;
                    L2.f2013j &= -33;
                    rVar.j(L2);
                }
            }
            rVar.f2063a.clear();
            ArrayList<a0> arrayList = rVar.f2064b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.f2034b.invalidate();
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void j(int i7, c cVar) {
        }

        /* JADX WARN: Finally extract failed */
        public final void j0(View view, r rVar) {
            b bVar = this.f2033a;
            int i7 = bVar.f2158d;
            if (i7 == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            } else if (i7 != 2) {
                try {
                    bVar.f2158d = 1;
                    bVar.e = view;
                    int indexOfChild = ((t) bVar.f2155a).f2275a.indexOfChild(view);
                    if (indexOfChild >= 0) {
                        if (bVar.f2156b.f(indexOfChild)) {
                            bVar.l(view);
                        }
                        ((t) bVar.f2155a).b(indexOfChild);
                    }
                    bVar.f2158d = 0;
                    bVar.e = null;
                    rVar.i(view);
                } catch (Throwable th) {
                    bVar.f2158d = 0;
                    bVar.e = null;
                    throw th;
                }
            } else {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
        }

        public int k(w wVar) {
            return 0;
        }

        public final void k0(int i7) {
            if (v(i7) != null) {
                b bVar = this.f2033a;
                int i8 = bVar.f2158d;
                if (i8 == 1) {
                    throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
                } else if (i8 != 2) {
                    try {
                        int f7 = bVar.f(i7);
                        View childAt = ((t) bVar.f2155a).f2275a.getChildAt(f7);
                        if (childAt != null) {
                            bVar.f2158d = 1;
                            bVar.e = childAt;
                            if (bVar.f2156b.f(f7)) {
                                bVar.l(childAt);
                            }
                            ((t) bVar.f2155a).b(f7);
                        }
                    } finally {
                        bVar.f2158d = 0;
                        bVar.e = null;
                    }
                } else {
                    throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
                }
            }
        }

        public int l(w wVar) {
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00a9, code lost:
            if (r8 == false) goto L_0x00b0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean l0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
            /*
                r8 = this;
                int r0 = r8.D()
                int r1 = r8.F()
                int r2 = r8.f2044n
                int r3 = r8.E()
                int r2 = r2 - r3
                int r3 = r8.f2045o
                int r4 = r8.C()
                int r3 = r3 - r4
                int r4 = r10.getLeft()
                int r5 = r11.left
                int r4 = r4 + r5
                int r5 = r10.getScrollX()
                int r4 = r4 - r5
                int r5 = r10.getTop()
                int r6 = r11.top
                int r5 = r5 + r6
                int r10 = r10.getScrollY()
                int r5 = r5 - r10
                int r10 = r11.width()
                int r10 = r10 + r4
                int r11 = r11.height()
                int r11 = r11 + r5
                int r4 = r4 - r0
                r0 = 0
                int r6 = java.lang.Math.min(r0, r4)
                int r5 = r5 - r1
                int r1 = java.lang.Math.min(r0, r5)
                int r10 = r10 - r2
                int r2 = java.lang.Math.max(r0, r10)
                int r11 = r11 - r3
                int r11 = java.lang.Math.max(r0, r11)
                int r3 = r8.B()
                r7 = 1
                if (r3 != r7) goto L_0x005c
                if (r2 == 0) goto L_0x0057
                goto L_0x0064
            L_0x0057:
                int r2 = java.lang.Math.max(r6, r10)
                goto L_0x0064
            L_0x005c:
                if (r6 == 0) goto L_0x005f
                goto L_0x0063
            L_0x005f:
                int r6 = java.lang.Math.min(r4, r2)
            L_0x0063:
                r2 = r6
            L_0x0064:
                if (r1 == 0) goto L_0x0067
                goto L_0x006b
            L_0x0067:
                int r1 = java.lang.Math.min(r5, r11)
            L_0x006b:
                if (r13 == 0) goto L_0x00ab
                android.view.View r10 = r9.getFocusedChild()
                if (r10 != 0) goto L_0x0074
                goto L_0x00a8
            L_0x0074:
                int r11 = r8.D()
                int r13 = r8.F()
                int r3 = r8.f2044n
                int r4 = r8.E()
                int r3 = r3 - r4
                int r4 = r8.f2045o
                int r5 = r8.C()
                int r4 = r4 - r5
                androidx.recyclerview.widget.RecyclerView r5 = r8.f2034b
                android.graphics.Rect r5 = r5.f1978n
                r8.z(r10, r5)
                int r8 = r5.left
                int r8 = r8 - r2
                if (r8 >= r3) goto L_0x00a8
                int r8 = r5.right
                int r8 = r8 - r2
                if (r8 <= r11) goto L_0x00a8
                int r8 = r5.top
                int r8 = r8 - r1
                if (r8 >= r4) goto L_0x00a8
                int r8 = r5.bottom
                int r8 = r8 - r1
                if (r8 > r13) goto L_0x00a6
                goto L_0x00a8
            L_0x00a6:
                r8 = r7
                goto L_0x00a9
            L_0x00a8:
                r8 = r0
            L_0x00a9:
                if (r8 == 0) goto L_0x00b0
            L_0x00ab:
                if (r2 != 0) goto L_0x00b1
                if (r1 == 0) goto L_0x00b0
                goto L_0x00b1
            L_0x00b0:
                return r0
            L_0x00b1:
                if (r12 == 0) goto L_0x00b7
                r9.scrollBy(r2, r1)
                goto L_0x00ba
            L_0x00b7:
                r9.i0(r2, r1, r0)
            L_0x00ba:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.l.l0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public int m(w wVar) {
            return 0;
        }

        public final void m0() {
            RecyclerView recyclerView = this.f2034b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int n(w wVar) {
            return 0;
        }

        @SuppressLint({"UnknownNullness"})
        public int n0(int i7, r rVar, w wVar) {
            return 0;
        }

        public int o(w wVar) {
            return 0;
        }

        public void o0(int i7) {
            if (RecyclerView.E0) {
                Log.e("RecyclerView", "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        public int p(w wVar) {
            return 0;
        }

        @SuppressLint({"UnknownNullness"})
        public int p0(int i7, r rVar, w wVar) {
            return 0;
        }

        public final void q(r rVar) {
            int w6 = w();
            while (true) {
                w6--;
                if (w6 >= 0) {
                    View v6 = v(w6);
                    a0 L = RecyclerView.L(v6);
                    if (L.o()) {
                        if (RecyclerView.E0) {
                            Log.d("RecyclerView", "ignoring view " + L);
                        }
                    } else if (!L.g() || L.i() || this.f2034b.f1984q.f2023b) {
                        v(w6);
                        this.f2033a.c(w6);
                        rVar.k(v6);
                        this.f2034b.f1975l.d(L);
                    } else {
                        k0(w6);
                        rVar.j(L);
                    }
                } else {
                    return;
                }
            }
        }

        public final void q0(RecyclerView recyclerView) {
            r0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public View r(int i7) {
            int w6 = w();
            for (int i8 = 0; i8 < w6; i8++) {
                View v6 = v(i8);
                a0 L = RecyclerView.L(v6);
                if (L != null && L.c() == i7 && !L.o() && (this.f2034b.f1974k0.f2090g || !L.i())) {
                    return v6;
                }
            }
            return null;
        }

        public final void r0(int i7, int i8) {
            this.f2044n = View.MeasureSpec.getSize(i7);
            int mode = View.MeasureSpec.getMode(i7);
            this.f2043l = mode;
            if (mode == 0 && !RecyclerView.H0) {
                this.f2044n = 0;
            }
            this.f2045o = View.MeasureSpec.getSize(i8);
            int mode2 = View.MeasureSpec.getMode(i8);
            this.m = mode2;
            if (mode2 == 0 && !RecyclerView.H0) {
                this.f2045o = 0;
            }
        }

        @SuppressLint({"UnknownNullness"})
        public abstract m s();

        public void s0(Rect rect, int i7, int i8) {
            int E = E() + D() + rect.width();
            int C = C() + F() + rect.height();
            RecyclerView recyclerView = this.f2034b;
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            this.f2034b.setMeasuredDimension(h(i7, E, y.d.e(recyclerView)), h(i8, C, y.d.d(this.f2034b)));
        }

        @SuppressLint({"UnknownNullness"})
        public m t(Context context, AttributeSet attributeSet) {
            return new m(context, attributeSet);
        }

        public final void t0(int i7, int i8) {
            int w6 = w();
            if (w6 == 0) {
                this.f2034b.q(i7, i8);
                return;
            }
            int i9 = Integer.MIN_VALUE;
            int i10 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            int i11 = Integer.MAX_VALUE;
            int i12 = Integer.MIN_VALUE;
            for (int i13 = 0; i13 < w6; i13++) {
                View v6 = v(i13);
                Rect rect = this.f2034b.f1978n;
                z(v6, rect);
                int i14 = rect.left;
                if (i14 < i10) {
                    i10 = i14;
                }
                int i15 = rect.right;
                if (i15 > i9) {
                    i9 = i15;
                }
                int i16 = rect.top;
                if (i16 < i11) {
                    i11 = i16;
                }
                int i17 = rect.bottom;
                if (i17 > i12) {
                    i12 = i17;
                }
            }
            this.f2034b.f1978n.set(i10, i11, i9, i12);
            s0(this.f2034b.f1978n, i7, i8);
        }

        @SuppressLint({"UnknownNullness"})
        public m u(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof m ? new m((m) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new m((ViewGroup.MarginLayoutParams) layoutParams) : new m(layoutParams);
        }

        public final void u0(RecyclerView recyclerView) {
            int i7;
            if (recyclerView == null) {
                this.f2034b = null;
                this.f2033a = null;
                i7 = 0;
                this.f2044n = 0;
            } else {
                this.f2034b = recyclerView;
                this.f2033a = recyclerView.f1973k;
                this.f2044n = recyclerView.getWidth();
                i7 = recyclerView.getHeight();
            }
            this.f2045o = i7;
            this.f2043l = 1073741824;
            this.m = 1073741824;
        }

        public final View v(int i7) {
            b bVar = this.f2033a;
            if (bVar != null) {
                return bVar.d(i7);
            }
            return null;
        }

        public final boolean v0(View view, int i7, int i8, m mVar) {
            return view.isLayoutRequested() || !this.f2039h || !L(view.getWidth(), i7, ((ViewGroup.MarginLayoutParams) mVar).width) || !L(view.getHeight(), i8, ((ViewGroup.MarginLayoutParams) mVar).height);
        }

        public final int w() {
            b bVar = this.f2033a;
            if (bVar != null) {
                return bVar.e();
            }
            return 0;
        }

        public boolean w0() {
            return false;
        }

        public final boolean x0(View view, int i7, int i8, m mVar) {
            return !this.f2039h || !L(view.getMeasuredWidth(), i7, ((ViewGroup.MarginLayoutParams) mVar).width) || !L(view.getMeasuredHeight(), i8, ((ViewGroup.MarginLayoutParams) mVar).height);
        }

        public int y(r rVar, w wVar) {
            return -1;
        }

        @SuppressLint({"UnknownNullness"})
        public void y0(RecyclerView recyclerView, int i7) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void z(View view, Rect rect) {
            RecyclerView.M(view, rect);
        }

        @SuppressLint({"UnknownNullness"})
        public final void z0(m mVar) {
            v vVar = this.e;
            if (!(vVar == null || mVar == vVar || !vVar.e)) {
                vVar.d();
            }
            this.e = mVar;
            RecyclerView recyclerView = this.f2034b;
            z zVar = recyclerView.f1968h0;
            RecyclerView.this.removeCallbacks(zVar);
            zVar.f2099h.abortAnimation();
            if (mVar.f2078h) {
                StringBuilder d7 = androidx.activity.h.d("An instance of ");
                d7.append(mVar.getClass().getSimpleName());
                d7.append(" was started more than once. Each instance of");
                d7.append(mVar.getClass().getSimpleName());
                d7.append(" is intended to only be used once. You should create a new instance for each use.");
                Log.w("RecyclerView", d7.toString());
            }
            mVar.f2073b = recyclerView;
            mVar.f2074c = this;
            int i7 = mVar.f2072a;
            if (i7 != -1) {
                recyclerView.f1974k0.f2085a = i7;
                mVar.e = true;
                mVar.f2075d = true;
                mVar.f2076f = recyclerView.f1986r.r(i7);
                mVar.f2073b.f1968h0.b();
                mVar.f2078h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class m extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public a0 f2052a;

        /* renamed from: b */
        public final Rect f2053b = new Rect();

        /* renamed from: c */
        public boolean f2054c = true;

        /* renamed from: d */
        public boolean f2055d = false;

        public m(int i7, int i8) {
            super(i7, i8);
        }

        public m(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public m(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public m(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public m(m mVar) {
            super((ViewGroup.LayoutParams) mVar);
        }

        public final int a() {
            return this.f2052a.c();
        }

        public final boolean b() {
            return (this.f2052a.f2013j & 2) != 0;
        }

        public final boolean c() {
            return this.f2052a.i();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class n {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface o {
        void a(MotionEvent motionEvent);

        boolean b(MotionEvent motionEvent);

        void c();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class p {
        public void a(RecyclerView recyclerView, int i7) {
        }

        public void b(RecyclerView recyclerView, int i7, int i8) {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class q {

        /* renamed from: a */
        public SparseArray<a> f2056a = new SparseArray<>();

        /* renamed from: b */
        public int f2057b = 0;

        /* renamed from: c */
        public Set<d<?>> f2058c = Collections.newSetFromMap(new IdentityHashMap());

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static class a {

            /* renamed from: a */
            public final ArrayList<a0> f2059a = new ArrayList<>();

            /* renamed from: b */
            public int f2060b = 5;

            /* renamed from: c */
            public long f2061c = 0;

            /* renamed from: d */
            public long f2062d = 0;
        }

        public final a a(int i7) {
            a aVar = this.f2056a.get(i7);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f2056a.put(i7, aVar2);
            return aVar2;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class r {

        /* renamed from: a */
        public final ArrayList<a0> f2063a;

        /* renamed from: d */
        public final List<a0> f2066d;

        /* renamed from: g */
        public q f2068g;

        /* renamed from: b */
        public ArrayList<a0> f2064b = null;

        /* renamed from: c */
        public final ArrayList<a0> f2065c = new ArrayList<>();
        public int e = 2;

        /* renamed from: f */
        public int f2067f = 2;

        public r() {
            RecyclerView.this = r2;
            ArrayList<a0> arrayList = new ArrayList<>();
            this.f2063a = arrayList;
            this.f2066d = Collections.unmodifiableList(arrayList);
        }

        public final void a(a0 a0Var, boolean z6) {
            RecyclerView.l(a0Var);
            View view = a0Var.f2005a;
            v vVar = RecyclerView.this.f1987r0;
            if (vVar != null) {
                v.a aVar = vVar.e;
                p1.y.i(view, aVar instanceof v.a ? (p1.a) aVar.e.remove(view) : null);
            }
            if (z6) {
                s sVar = RecyclerView.this.s;
                if (sVar != null) {
                    sVar.a();
                }
                int size = RecyclerView.this.f1989t.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ((s) RecyclerView.this.f1989t.get(i7)).a();
                }
                d dVar = RecyclerView.this.f1984q;
                if (dVar != null) {
                    dVar.f(a0Var);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f1974k0 != null) {
                    recyclerView.f1975l.e(a0Var);
                }
                if (RecyclerView.E0) {
                    Log.d("RecyclerView", "dispatchViewRecycled: " + a0Var);
                }
            }
            a0Var.s = null;
            a0Var.f2020r = null;
            q c7 = c();
            c7.getClass();
            int i8 = a0Var.f2009f;
            ArrayList<a0> arrayList = c7.a(i8).f2059a;
            if (c7.f2056a.get(i8).f2060b <= arrayList.size()) {
                q2.a.f(a0Var.f2005a);
            } else if (!RecyclerView.D0 || !arrayList.contains(a0Var)) {
                a0Var.m();
                arrayList.add(a0Var);
            } else {
                throw new IllegalArgumentException("this scrap item already exists");
            }
        }

        public final int b(int i7) {
            if (i7 < 0 || i7 >= RecyclerView.this.f1974k0.b()) {
                StringBuilder sb = new StringBuilder();
                sb.append("invalid position ");
                sb.append(i7);
                sb.append(". State item count is ");
                sb.append(RecyclerView.this.f1974k0.b());
                throw new IndexOutOfBoundsException(androidx.activity.h.b(RecyclerView.this, sb));
            }
            RecyclerView recyclerView = RecyclerView.this;
            return !recyclerView.f1974k0.f2090g ? i7 : recyclerView.f1971j.f(i7, 0);
        }

        public final q c() {
            if (this.f2068g == null) {
                this.f2068g = new q();
                e();
            }
            return this.f2068g;
        }

        public final View d(int i7) {
            return l(i7, Long.MAX_VALUE).f2005a;
        }

        public final void e() {
            if (this.f2068g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f1984q != null && recyclerView.isAttachedToWindow()) {
                    q qVar = this.f2068g;
                    qVar.f2058c.add(RecyclerView.this.f1984q);
                }
            }
        }

        public final void f(d<?> dVar, boolean z6) {
            q qVar = this.f2068g;
            if (qVar != null) {
                qVar.f2058c.remove(dVar);
                if (qVar.f2058c.size() == 0 && !z6) {
                    for (int i7 = 0; i7 < qVar.f2056a.size(); i7++) {
                        SparseArray<q.a> sparseArray = qVar.f2056a;
                        ArrayList<a0> arrayList = sparseArray.get(sparseArray.keyAt(i7)).f2059a;
                        for (int i8 = 0; i8 < arrayList.size(); i8++) {
                            q2.a.f(arrayList.get(i8).f2005a);
                        }
                    }
                }
            }
        }

        public final void g() {
            for (int size = this.f2065c.size() - 1; size >= 0; size--) {
                h(size);
            }
            this.f2065c.clear();
            if (RecyclerView.I0) {
                k.b bVar = RecyclerView.this.f1972j0;
                int[] iArr = bVar.f2247c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.f2248d = 0;
            }
        }

        public final void h(int i7) {
            if (RecyclerView.E0) {
                Log.d("RecyclerView", "Recycling cached view at index " + i7);
            }
            a0 a0Var = this.f2065c.get(i7);
            if (RecyclerView.E0) {
                Log.d("RecyclerView", "CachedViewHolder to be recycled: " + a0Var);
            }
            a(a0Var, true);
            this.f2065c.remove(i7);
        }

        public final void i(View view) {
            a0 L = RecyclerView.L(view);
            if (L.k()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (L.j()) {
                L.f2016n.m(L);
            } else if (L.p()) {
                L.f2013j &= -33;
            }
            j(L);
            if (RecyclerView.this.P != null && !L.h()) {
                RecyclerView.this.P.i(L);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00e3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void j(androidx.recyclerview.widget.RecyclerView.a0 r10) {
            /*
                Method dump skipped, instructions count: 366
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r.j(androidx.recyclerview.widget.RecyclerView$a0):void");
        }

        public final void k(View view) {
            ArrayList<a0> arrayList;
            a0 L = RecyclerView.L(view);
            int i7 = L.f2013j;
            if (!((i7 & 12) != 0)) {
                if ((i7 & 2) != 0) {
                    i iVar = RecyclerView.this.P;
                    if (!(iVar == null || iVar.f(L, L.d()))) {
                        if (this.f2064b == null) {
                            this.f2064b = new ArrayList<>();
                        }
                        L.f2016n = this;
                        L.f2017o = true;
                        arrayList = this.f2064b;
                        arrayList.add(L);
                        return;
                    }
                }
            }
            if (!L.g() || L.i() || RecyclerView.this.f1984q.f2023b) {
                L.f2016n = this;
                L.f2017o = false;
                arrayList = this.f2063a;
                arrayList.add(L);
                return;
            }
            throw new IllegalArgumentException(androidx.activity.h.b(RecyclerView.this, androidx.activity.h.d("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }

        /* JADX WARN: Code restructure failed: missing block: B:110:0x0223, code lost:
            if (r7.f2009f != 0) goto L_0x023b;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x0338, code lost:
            r7 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:241:0x04bf, code lost:
            if (r7.g() == false) goto L_0x051b;
         */
        /* JADX WARN: Code restructure failed: missing block: B:256:0x0519, code lost:
            if ((r11 == 0 || r11 + r9 < r21) == false) goto L_0x051b;
         */
        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0285  */
        /* JADX WARN: Removed duplicated region for block: B:218:0x0462  */
        /* JADX WARN: Removed duplicated region for block: B:235:0x04b0  */
        /* JADX WARN: Removed duplicated region for block: B:250:0x0502  */
        /* JADX WARN: Removed duplicated region for block: B:260:0x0525  */
        /* JADX WARN: Removed duplicated region for block: B:261:0x0538  */
        /* JADX WARN: Removed duplicated region for block: B:264:0x0544  */
        /* JADX WARN: Removed duplicated region for block: B:265:0x0546  */
        /* JADX WARN: Removed duplicated region for block: B:267:0x0549  */
        /* JADX WARN: Removed duplicated region for block: B:273:0x0568  */
        /* JADX WARN: Removed duplicated region for block: B:287:0x05de  */
        /* JADX WARN: Removed duplicated region for block: B:295:0x05ff  */
        /* JADX WARN: Removed duplicated region for block: B:298:0x061e  */
        /* JADX WARN: Removed duplicated region for block: B:306:0x0639  */
        /* JADX WARN: Removed duplicated region for block: B:324:0x067a  */
        /* JADX WARN: Removed duplicated region for block: B:327:0x0683  */
        /* JADX WARN: Removed duplicated region for block: B:331:0x068e  */
        /* JADX WARN: Removed duplicated region for block: B:332:0x0695  */
        /* JADX WARN: Removed duplicated region for block: B:339:0x06b2 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.recyclerview.widget.RecyclerView.a0 l(int r20, long r21) {
            /*
                Method dump skipped, instructions count: 1769
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r.l(int, long):androidx.recyclerview.widget.RecyclerView$a0");
        }

        public final void m(a0 a0Var) {
            (a0Var.f2017o ? this.f2064b : this.f2063a).remove(a0Var);
            a0Var.f2016n = null;
            a0Var.f2017o = false;
            a0Var.f2013j &= -33;
        }

        public final void n() {
            l lVar = RecyclerView.this.f1986r;
            this.f2067f = this.e + (lVar != null ? lVar.f2041j : 0);
            for (int size = this.f2065c.size() - 1; size >= 0 && this.f2065c.size() > this.f2067f; size--) {
                h(size);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface s {
        void a();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class t extends f {
        public t() {
            RecyclerView.this = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f
        public final void a() {
            RecyclerView.this.k(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f1974k0.f2089f = true;
            recyclerView.X(true);
            if (!RecyclerView.this.f1971j.g()) {
                RecyclerView.this.requestLayout();
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class u extends w1.a {
        public static final Parcelable.Creator<u> CREATOR = new a();

        /* renamed from: h */
        public Parcelable f2071h;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<u> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new u(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i7) {
                return new u[i7];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final u createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new u(parcel, classLoader);
            }
        }

        public u(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2071h = parcel.readParcelable(classLoader == null ? l.class.getClassLoader() : classLoader);
        }

        public u(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // w1.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeParcelable(this.f2071h, 0);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class v {

        /* renamed from: b */
        public RecyclerView f2073b;

        /* renamed from: c */
        public l f2074c;

        /* renamed from: d */
        public boolean f2075d;
        public boolean e;

        /* renamed from: f */
        public View f2076f;

        /* renamed from: h */
        public boolean f2078h;

        /* renamed from: a */
        public int f2072a = -1;

        /* renamed from: g */
        public final a f2077g = new a();

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static class a {

            /* renamed from: d */
            public int f2082d = -1;

            /* renamed from: f */
            public boolean f2083f = false;

            /* renamed from: g */
            public int f2084g = 0;

            /* renamed from: a */
            public int f2079a = 0;

            /* renamed from: b */
            public int f2080b = 0;

            /* renamed from: c */
            public int f2081c = Integer.MIN_VALUE;
            public Interpolator e = null;

            public final void a(RecyclerView recyclerView) {
                int i7 = this.f2082d;
                if (i7 >= 0) {
                    this.f2082d = -1;
                    recyclerView.P(i7);
                    this.f2083f = false;
                } else if (this.f2083f) {
                    Interpolator interpolator = this.e;
                    if (interpolator == null || this.f2081c >= 1) {
                        int i8 = this.f2081c;
                        if (i8 >= 1) {
                            recyclerView.f1968h0.c(this.f2079a, this.f2080b, i8, interpolator);
                            int i9 = this.f2084g + 1;
                            this.f2084g = i9;
                            if (i9 > 10) {
                                Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                            }
                            this.f2083f = false;
                            return;
                        }
                        throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else {
                    this.f2084g = 0;
                }
            }
        }

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public interface b {
            PointF a(int i7);
        }

        public PointF a(int i7) {
            l lVar = this.f2074c;
            if (lVar instanceof b) {
                return ((b) lVar).a(i7);
            }
            StringBuilder d7 = androidx.activity.h.d("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            d7.append(b.class.getCanonicalName());
            Log.w("RecyclerView", d7.toString());
            return null;
        }

        public final void b(int i7, int i8) {
            PointF a7;
            RecyclerView recyclerView = this.f2073b;
            int i9 = -1;
            if (this.f2072a == -1 || recyclerView == null) {
                d();
            }
            if (this.f2075d && this.f2076f == null && this.f2074c != null && (a7 = a(this.f2072a)) != null) {
                float f7 = a7.x;
                if (!(f7 == 0.0f && a7.y == 0.0f)) {
                    recyclerView.f0((int) Math.signum(f7), (int) Math.signum(a7.y), null);
                }
            }
            boolean z6 = false;
            this.f2075d = false;
            View view = this.f2076f;
            if (view != null) {
                this.f2073b.getClass();
                a0 L = RecyclerView.L(view);
                if (L != null) {
                    i9 = L.c();
                }
                if (i9 == this.f2072a) {
                    View view2 = this.f2076f;
                    w wVar = recyclerView.f1974k0;
                    c(view2, this.f2077g);
                    this.f2077g.a(recyclerView);
                    d();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f2076f = null;
                }
            }
            if (this.e) {
                w wVar2 = recyclerView.f1974k0;
                a aVar = this.f2077g;
                m mVar = (m) this;
                if (mVar.f2073b.f1986r.w() == 0) {
                    mVar.d();
                } else {
                    int i10 = mVar.f2266o;
                    int i11 = i10 - i7;
                    if (i10 * i11 <= 0) {
                        i11 = 0;
                    }
                    mVar.f2266o = i11;
                    int i12 = mVar.f2267p;
                    int i13 = i12 - i8;
                    if (i12 * i13 <= 0) {
                        i13 = 0;
                    }
                    mVar.f2267p = i13;
                    if (i11 == 0 && i13 == 0) {
                        PointF a8 = mVar.a(mVar.f2072a);
                        if (a8 != null) {
                            float f8 = a8.x;
                            if (!(f8 == 0.0f && a8.y == 0.0f)) {
                                float f9 = a8.y;
                                float sqrt = (float) Math.sqrt((double) ((f9 * f9) + (f8 * f8)));
                                float f10 = a8.x / sqrt;
                                a8.x = f10;
                                float f11 = a8.y / sqrt;
                                a8.y = f11;
                                mVar.f2263k = a8;
                                mVar.f2266o = (int) (f10 * 10000.0f);
                                mVar.f2267p = (int) (f11 * 10000.0f);
                                int i14 = mVar.i(10000);
                                LinearInterpolator linearInterpolator = mVar.f2261i;
                                aVar.f2079a = (int) (((float) mVar.f2266o) * 1.2f);
                                aVar.f2080b = (int) (((float) mVar.f2267p) * 1.2f);
                                aVar.f2081c = (int) (((float) i14) * 1.2f);
                                aVar.e = linearInterpolator;
                                aVar.f2083f = true;
                            }
                        }
                        aVar.f2082d = mVar.f2072a;
                        mVar.d();
                    }
                }
                a aVar2 = this.f2077g;
                if (aVar2.f2082d >= 0) {
                    z6 = true;
                }
                aVar2.a(recyclerView);
                if (z6 && this.e) {
                    this.f2075d = true;
                    recyclerView.f1968h0.b();
                }
            }
        }

        public abstract void c(View view, a aVar);

        public final void d() {
            if (this.e) {
                this.e = false;
                m mVar = (m) this;
                mVar.f2267p = 0;
                mVar.f2266o = 0;
                mVar.f2263k = null;
                this.f2073b.f1974k0.f2085a = -1;
                this.f2076f = null;
                this.f2072a = -1;
                this.f2075d = false;
                l lVar = this.f2074c;
                if (lVar.e == this) {
                    lVar.e = null;
                }
                this.f2074c = null;
                this.f2073b = null;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class w {

        /* renamed from: a */
        public int f2085a = -1;

        /* renamed from: b */
        public int f2086b = 0;

        /* renamed from: c */
        public int f2087c = 0;

        /* renamed from: d */
        public int f2088d = 1;
        public int e = 0;

        /* renamed from: f */
        public boolean f2089f = false;

        /* renamed from: g */
        public boolean f2090g = false;

        /* renamed from: h */
        public boolean f2091h = false;

        /* renamed from: i */
        public boolean f2092i = false;

        /* renamed from: j */
        public boolean f2093j = false;

        /* renamed from: k */
        public boolean f2094k = false;

        /* renamed from: l */
        public int f2095l;
        public long m;

        /* renamed from: n */
        public int f2096n;

        public final void a(int i7) {
            if ((this.f2088d & i7) == 0) {
                StringBuilder d7 = androidx.activity.h.d("Layout state should be one of ");
                d7.append(Integer.toBinaryString(i7));
                d7.append(" but it is ");
                d7.append(Integer.toBinaryString(this.f2088d));
                throw new IllegalStateException(d7.toString());
            }
        }

        public final int b() {
            return this.f2090g ? this.f2086b - this.f2087c : this.e;
        }

        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("State{mTargetPosition=");
            d7.append(this.f2085a);
            d7.append(", mData=");
            d7.append((Object) null);
            d7.append(", mItemCount=");
            d7.append(this.e);
            d7.append(", mIsMeasuring=");
            d7.append(this.f2092i);
            d7.append(", mPreviousLayoutItemCount=");
            d7.append(this.f2086b);
            d7.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            d7.append(this.f2087c);
            d7.append(", mStructureChanged=");
            d7.append(this.f2089f);
            d7.append(", mInPreLayout=");
            d7.append(this.f2090g);
            d7.append(", mRunSimpleAnimations=");
            d7.append(this.f2093j);
            d7.append(", mRunPredictiveAnimations=");
            d7.append(this.f2094k);
            d7.append('}');
            return d7.toString();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class x extends h {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class y {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class z implements Runnable {

        /* renamed from: f */
        public int f2097f;

        /* renamed from: g */
        public int f2098g;

        /* renamed from: h */
        public OverScroller f2099h;

        /* renamed from: i */
        public Interpolator f2100i;

        /* renamed from: j */
        public boolean f2101j = false;

        /* renamed from: k */
        public boolean f2102k = false;

        public z() {
            RecyclerView.this = r3;
            b bVar = RecyclerView.K0;
            this.f2100i = bVar;
            this.f2099h = new OverScroller(r3.getContext(), bVar);
        }

        public final void a(int i7, int i8) {
            RecyclerView.this.setScrollState(2);
            this.f2098g = 0;
            this.f2097f = 0;
            Interpolator interpolator = this.f2100i;
            b bVar = RecyclerView.K0;
            if (interpolator != bVar) {
                this.f2100i = bVar;
                this.f2099h = new OverScroller(RecyclerView.this.getContext(), bVar);
            }
            this.f2099h.fling(0, 0, i7, i8, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
            b();
        }

        public final void b() {
            if (this.f2101j) {
                this.f2102k = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            RecyclerView recyclerView = RecyclerView.this;
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            y.d.m(recyclerView, this);
        }

        public final void c(int i7, int i8, int i9, Interpolator interpolator) {
            if (i9 == Integer.MIN_VALUE) {
                int abs = Math.abs(i7);
                int abs2 = Math.abs(i8);
                boolean z6 = abs > abs2;
                RecyclerView recyclerView = RecyclerView.this;
                int width = z6 ? recyclerView.getWidth() : recyclerView.getHeight();
                if (!z6) {
                    abs = abs2;
                }
                i9 = Math.min((int) (((((float) abs) / ((float) width)) + 1.0f) * 300.0f), 2000);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.K0;
            }
            if (this.f2100i != interpolator) {
                this.f2100i = interpolator;
                this.f2099h = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f2098g = 0;
            this.f2097f = 0;
            RecyclerView.this.setScrollState(2);
            this.f2099h.startScroll(0, 0, i7, i8, i9);
            b();
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i7;
            int i8;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f1986r == null) {
                recyclerView.removeCallbacks(this);
                this.f2099h.abortAnimation();
                return;
            }
            this.f2102k = false;
            this.f2101j = true;
            recyclerView.p();
            OverScroller overScroller = this.f2099h;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i9 = currX - this.f2097f;
                int i10 = currY - this.f2098g;
                this.f2097f = currX;
                this.f2098g = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int o6 = RecyclerView.o(i9, recyclerView2.L, recyclerView2.N, recyclerView2.getWidth());
                RecyclerView recyclerView3 = RecyclerView.this;
                int o7 = RecyclerView.o(i10, recyclerView3.M, recyclerView3.O, recyclerView3.getHeight());
                RecyclerView recyclerView4 = RecyclerView.this;
                int[] iArr = recyclerView4.f1996w0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView4.u(o6, o7, 1, iArr, null)) {
                    int[] iArr2 = RecyclerView.this.f1996w0;
                    o6 -= iArr2[0];
                    o7 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.n(o6, o7);
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                if (recyclerView5.f1984q != null) {
                    int[] iArr3 = recyclerView5.f1996w0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView5.f0(o6, o7, iArr3);
                    RecyclerView recyclerView6 = RecyclerView.this;
                    int[] iArr4 = recyclerView6.f1996w0;
                    i7 = iArr4[0];
                    i8 = iArr4[1];
                    o6 -= i7;
                    o7 -= i8;
                    v vVar = recyclerView6.f1986r.e;
                    if (vVar != null && !vVar.f2075d && vVar.e) {
                        int b2 = recyclerView6.f1974k0.b();
                        if (b2 == 0) {
                            vVar.d();
                        } else {
                            if (vVar.f2072a >= b2) {
                                vVar.f2072a = b2 - 1;
                            }
                            vVar.b(i7, i8);
                        }
                    }
                } else {
                    i8 = 0;
                    i7 = 0;
                }
                if (!RecyclerView.this.f1991u.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView7 = RecyclerView.this;
                int[] iArr5 = recyclerView7.f1996w0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView7.v(i7, i8, o6, o7, null, 1, iArr5);
                RecyclerView recyclerView8 = RecyclerView.this;
                int[] iArr6 = recyclerView8.f1996w0;
                int i11 = o6 - iArr6[0];
                int i12 = o7 - iArr6[1];
                if (!(i7 == 0 && i8 == 0)) {
                    recyclerView8.w(i7, i8);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z6 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i11 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i12 != 0));
                RecyclerView recyclerView9 = RecyclerView.this;
                v vVar2 = recyclerView9.f1986r.e;
                if ((vVar2 != null && vVar2.f2075d) || !z6) {
                    b();
                    RecyclerView recyclerView10 = RecyclerView.this;
                    k kVar = recyclerView10.f1970i0;
                    if (kVar != null) {
                        kVar.a(recyclerView10, i7, i8);
                    }
                } else {
                    if (recyclerView9.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i13 = i11 < 0 ? -currVelocity : i11 > 0 ? currVelocity : 0;
                        if (i12 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i12 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView recyclerView11 = RecyclerView.this;
                        if (i13 < 0) {
                            recyclerView11.y();
                            if (recyclerView11.L.isFinished()) {
                                recyclerView11.L.onAbsorb(-i13);
                            }
                        } else if (i13 > 0) {
                            recyclerView11.z();
                            if (recyclerView11.N.isFinished()) {
                                recyclerView11.N.onAbsorb(i13);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView11.A();
                            if (recyclerView11.M.isFinished()) {
                                recyclerView11.M.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView11.x();
                            if (recyclerView11.O.isFinished()) {
                                recyclerView11.O.onAbsorb(currVelocity);
                            }
                        } else {
                            recyclerView11.getClass();
                        }
                        if (!(i13 == 0 && currVelocity == 0)) {
                            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
                            y.d.k(recyclerView11);
                        }
                    }
                    if (RecyclerView.I0) {
                        k.b bVar = RecyclerView.this.f1972j0;
                        int[] iArr7 = bVar.f2247c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        bVar.f2248d = 0;
                    }
                }
            }
            v vVar3 = RecyclerView.this.f1986r.e;
            if (vVar3 != null && vVar3.f2075d) {
                vVar3.b(0, 0);
            }
            this.f2101j = false;
            if (this.f2102k) {
                RecyclerView.this.removeCallbacks(this);
                RecyclerView recyclerView12 = RecyclerView.this;
                WeakHashMap<View, k0> weakHashMap2 = p1.y.f5540a;
                y.d.m(recyclerView12, this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.l0(1);
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        J0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130904013);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(1:35)(11:36|(1:39)|38|77|41|(1:43)(1:44)|45|75|46|47|52)|77|41|(0)(0)|45|75|46|47|52) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0270, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0273, code lost:
        r0 = r4.getConstructor(new java.lang.Class[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0279, code lost:
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0288, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0289, code lost:
        r0.initCause(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x02a9, code lost:
        throw new java.lang.IllegalStateException(r20.getPositionDescription() + ": Error creating LayoutManager " + r0, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x023c A[Catch: ClassNotFoundException -> 0x0322, InvocationTargetException -> 0x0305, InstantiationException -> 0x02e8, IllegalAccessException -> 0x02c9, ClassCastException -> 0x02aa, TryCatch #4 {ClassCastException -> 0x02aa, ClassNotFoundException -> 0x0322, IllegalAccessException -> 0x02c9, InstantiationException -> 0x02e8, InvocationTargetException -> 0x0305, blocks: (B:41:0x0236, B:43:0x023c, B:44:0x0245, B:45:0x0249, B:46:0x0254, B:50:0x0273, B:52:0x027a, B:54:0x0289, B:55:0x02a9), top: B:77:0x0236 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0245 A[Catch: ClassNotFoundException -> 0x0322, InvocationTargetException -> 0x0305, InstantiationException -> 0x02e8, IllegalAccessException -> 0x02c9, ClassCastException -> 0x02aa, TryCatch #4 {ClassCastException -> 0x02aa, ClassNotFoundException -> 0x0322, IllegalAccessException -> 0x02c9, InstantiationException -> 0x02e8, InvocationTargetException -> 0x0305, blocks: (B:41:0x0236, B:43:0x023c, B:44:0x0245, B:45:0x0249, B:46:0x0254, B:50:0x0273, B:52:0x027a, B:54:0x0289, B:55:0x02a9), top: B:77:0x0236 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public RecyclerView(android.content.Context r19, android.util.AttributeSet r20, int r21) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public static RecyclerView G(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            RecyclerView G = G(viewGroup.getChildAt(i7));
            if (G != null) {
                return G;
            }
        }
        return null;
    }

    public static a0 L(View view) {
        if (view == null) {
            return null;
        }
        return ((m) view.getLayoutParams()).f2052a;
    }

    public static void M(View view, Rect rect) {
        m mVar = (m) view.getLayoutParams();
        Rect rect2 = mVar.f2053b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
    }

    private int a0(float f7, int i7) {
        EdgeEffect edgeEffect;
        float width = f7 / ((float) getWidth());
        float height = ((float) i7) / ((float) getHeight());
        EdgeEffect edgeEffect2 = this.M;
        float f8 = 0.0f;
        if (edgeEffect2 == null || t1.d.a(edgeEffect2) == 0.0f) {
            EdgeEffect edgeEffect3 = this.O;
            if (!(edgeEffect3 == null || t1.d.a(edgeEffect3) == 0.0f)) {
                if (canScrollVertically(1)) {
                    edgeEffect = this.O;
                    edgeEffect.onRelease();
                } else {
                    f8 = t1.d.b(this.O, height, 1.0f - width);
                    if (t1.d.a(this.O) == 0.0f) {
                        this.O.onRelease();
                    }
                }
            }
            return Math.round(f8 * ((float) getHeight()));
        } else if (canScrollVertically(-1)) {
            edgeEffect = this.M;
            edgeEffect.onRelease();
        } else {
            f8 = -t1.d.b(this.M, -height, width);
            if (t1.d.a(this.M) == 0.0f) {
                this.M.onRelease();
            }
        }
        invalidate();
        return Math.round(f8 * ((float) getHeight()));
    }

    private p1.l getScrollingChildHelper() {
        if (this.f1990t0 == null) {
            this.f1990t0 = new p1.l(this);
        }
        return this.f1990t0;
    }

    public static void l(a0 a0Var) {
        WeakReference<RecyclerView> weakReference = a0Var.f2006b;
        if (weakReference != null) {
            ViewParent viewParent = weakReference.get();
            while (true) {
                for (View view = (View) viewParent; view != null; view = null) {
                    if (view != a0Var.f2005a) {
                        viewParent = view.getParent();
                        if (viewParent instanceof View) {
                            break;
                        }
                    } else {
                        return;
                    }
                }
                a0Var.f2006b = null;
                return;
            }
        }
    }

    public static int o(int i7, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i8) {
        if (i7 > 0 && edgeEffect != null && t1.d.a(edgeEffect) != 0.0f) {
            int round = Math.round(t1.d.b(edgeEffect, (((float) (-i7)) * 4.0f) / ((float) i8), 0.5f) * (((float) (-i8)) / 4.0f));
            if (round != i7) {
                edgeEffect.finish();
            }
            return i7 - round;
        } else if (i7 >= 0 || edgeEffect2 == null || t1.d.a(edgeEffect2) == 0.0f) {
            return i7;
        } else {
            float f7 = (float) i8;
            int round2 = Math.round(t1.d.b(edgeEffect2, (((float) i7) * 4.0f) / f7, 0.5f) * (f7 / 4.0f));
            if (round2 != i7) {
                edgeEffect2.finish();
            }
            return i7 - round2;
        }
    }

    public static void setDebugAssertionsEnabled(boolean z6) {
        D0 = z6;
    }

    public static void setVerboseLoggingEnabled(boolean z6) {
        E0 = z6;
    }

    public final void A() {
        if (this.M == null) {
            ((x) this.K).getClass();
            EdgeEffect edgeEffect = new EdgeEffect(getContext());
            this.M = edgeEffect;
            if (this.m) {
                edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public final String B() {
        StringBuilder d7 = androidx.activity.h.d(" ");
        d7.append(super.toString());
        d7.append(", adapter:");
        d7.append(this.f1984q);
        d7.append(", layout:");
        d7.append(this.f1986r);
        d7.append(", context:");
        d7.append(getContext());
        return d7.toString();
    }

    public final void C(w wVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f1968h0.f2099h;
            overScroller.getFinalX();
            overScroller.getCurrX();
            wVar.getClass();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        wVar.getClass();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View D(android.view.View r3) {
        /*
            r2 = this;
        L_0x0000:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L_0x0010
            if (r0 == r2) goto L_0x0010
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x0010
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L_0x0000
        L_0x0010:
            if (r0 != r2) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.D(android.view.View):android.view.View");
    }

    public final boolean E(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f1993v.size();
        for (int i7 = 0; i7 < size; i7++) {
            o oVar = this.f1993v.get(i7);
            if (oVar.b(motionEvent) && action != 3) {
                this.f1995w = oVar;
                return true;
            }
        }
        return false;
    }

    public final void F(int[] iArr) {
        int e7 = this.f1973k.e();
        if (e7 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i7 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int i8 = Integer.MIN_VALUE;
        for (int i9 = 0; i9 < e7; i9++) {
            a0 L = L(this.f1973k.d(i9));
            if (!L.o()) {
                int c7 = L.c();
                if (c7 < i7) {
                    i7 = c7;
                }
                if (c7 > i8) {
                    i8 = c7;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
    }

    public final a0 H(int i7) {
        a0 a0Var = null;
        if (this.G) {
            return null;
        }
        int h7 = this.f1973k.h();
        for (int i8 = 0; i8 < h7; i8++) {
            a0 L = L(this.f1973k.g(i8));
            if (L != null && !L.i() && I(L) == i7) {
                if (!this.f1973k.k(L.f2005a)) {
                    return L;
                }
                a0Var = L;
            }
        }
        return a0Var;
    }

    public final int I(a0 a0Var) {
        if (!((a0Var.f2013j & 524) != 0) && a0Var.f()) {
            a aVar = this.f1971j;
            int i7 = a0Var.f2007c;
            int size = aVar.f2142b.size();
            for (int i8 = 0; i8 < size; i8++) {
                a.b bVar = aVar.f2142b.get(i8);
                int i9 = bVar.f2145a;
                if (i9 != 1) {
                    if (i9 == 2) {
                        int i10 = bVar.f2146b;
                        if (i10 <= i7) {
                            int i11 = bVar.f2148d;
                            if (i10 + i11 <= i7) {
                                i7 -= i11;
                            }
                        } else {
                            continue;
                        }
                    } else if (i9 == 8) {
                        int i12 = bVar.f2146b;
                        if (i12 == i7) {
                            i7 = bVar.f2148d;
                        } else {
                            if (i12 < i7) {
                                i7--;
                            }
                            if (bVar.f2148d <= i7) {
                                i7++;
                            }
                        }
                    }
                } else if (bVar.f2146b <= i7) {
                    i7 += bVar.f2148d;
                }
            }
            return i7;
        }
        return -1;
    }

    public final long J(a0 a0Var) {
        return this.f1984q.f2023b ? a0Var.e : (long) a0Var.f2007c;
    }

    public final a0 K(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return L(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect N(View view) {
        m mVar = (m) view.getLayoutParams();
        if (!mVar.f2054c) {
            return mVar.f2053b;
        }
        if (this.f1974k0.f2090g && (mVar.b() || mVar.f2052a.g())) {
            return mVar.f2053b;
        }
        Rect rect = mVar.f2053b;
        rect.set(0, 0, 0, 0);
        int size = this.f1991u.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f1978n.set(0, 0, 0, 0);
            this.f1991u.get(i7).d(this.f1978n, view);
            int i8 = rect.left;
            Rect rect2 = this.f1978n;
            rect.left = i8 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        mVar.f2054c = false;
        return rect;
    }

    public final boolean O() {
        return this.I > 0;
    }

    public final void P(int i7) {
        if (this.f1986r != null) {
            setScrollState(2);
            this.f1986r.o0(i7);
            awakenScrollBars();
        }
    }

    public final void Q() {
        int h7 = this.f1973k.h();
        for (int i7 = 0; i7 < h7; i7++) {
            ((m) this.f1973k.g(i7).getLayoutParams()).f2054c = true;
        }
        r rVar = this.f1967h;
        int size = rVar.f2065c.size();
        for (int i8 = 0; i8 < size; i8++) {
            m mVar = (m) rVar.f2065c.get(i8).f2005a.getLayoutParams();
            if (mVar != null) {
                mVar.f2054c = true;
            }
        }
    }

    public final void R(int i7, int i8, boolean z6) {
        int i9 = i7 + i8;
        int h7 = this.f1973k.h();
        for (int i10 = 0; i10 < h7; i10++) {
            a0 L = L(this.f1973k.g(i10));
            if (L != null && !L.o()) {
                int i11 = L.f2007c;
                if (i11 >= i9) {
                    if (E0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i10 + " holder " + L + " now at position " + (L.f2007c - i8));
                    }
                    L.l(-i8, z6);
                } else if (i11 >= i7) {
                    if (E0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i10 + " holder " + L + " now REMOVED");
                    }
                    L.b(8);
                    L.l(-i8, z6);
                    L.f2007c = i7 - 1;
                }
                this.f1974k0.f2089f = true;
            }
        }
        r rVar = this.f1967h;
        int size = rVar.f2065c.size();
        while (true) {
            size--;
            if (size >= 0) {
                a0 a0Var = rVar.f2065c.get(size);
                if (a0Var != null) {
                    int i12 = a0Var.f2007c;
                    if (i12 >= i9) {
                        if (E0) {
                            Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + a0Var + " now at position " + (a0Var.f2007c - i8));
                        }
                        a0Var.l(-i8, z6);
                    } else if (i12 >= i7) {
                        a0Var.b(8);
                        rVar.h(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    public final void S() {
        this.I++;
    }

    public final void T(boolean z6) {
        int i7;
        boolean z7 = true;
        int i8 = this.I - 1;
        this.I = i8;
        if (i8 >= 1) {
            return;
        }
        if (!D0 || i8 >= 0) {
            this.I = 0;
            if (z6) {
                int i9 = this.E;
                this.E = 0;
                if (i9 != 0) {
                    AccessibilityManager accessibilityManager = this.F;
                    if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                        z7 = false;
                    }
                    if (z7) {
                        AccessibilityEvent obtain = AccessibilityEvent.obtain();
                        obtain.setEventType(2048);
                        q1.b.b(obtain, i9);
                        sendAccessibilityEventUnchecked(obtain);
                    }
                }
                for (int size = this.f1998x0.size() - 1; size >= 0; size--) {
                    a0 a0Var = (a0) this.f1998x0.get(size);
                    if (a0Var.f2005a.getParent() == this && !a0Var.o() && (i7 = a0Var.f2019q) != -1) {
                        View view = a0Var.f2005a;
                        WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
                        y.d.s(view, i7);
                        a0Var.f2019q = -1;
                    }
                }
                this.f1998x0.clear();
                return;
            }
            return;
        }
        throw new IllegalStateException(androidx.activity.h.b(this, androidx.activity.h.d("layout or scroll counter cannot go below zero.Some calls are not matching")));
    }

    public final void U(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.R) {
            int i7 = actionIndex == 0 ? 1 : 0;
            this.R = motionEvent.getPointerId(i7);
            int x6 = (int) (motionEvent.getX(i7) + 0.5f);
            this.V = x6;
            this.T = x6;
            int y6 = (int) (motionEvent.getY(i7) + 0.5f);
            this.W = y6;
            this.U = y6;
        }
    }

    public final void V() {
        if (!this.f1985q0 && this.f1997x) {
            a aVar = this.f2000y0;
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            y.d.m(this, aVar);
            this.f1985q0 = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x007d, code lost:
        if ((r6.P != null && r6.f1986r.A0()) != false) goto L_0x0081;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W() {
        /*
            r6 = this;
            boolean r0 = r6.G
            if (r0 == 0) goto L_0x0019
            androidx.recyclerview.widget.a r0 = r6.f1971j
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r1 = r0.f2142b
            r0.l(r1)
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r1 = r0.f2143c
            r0.l(r1)
            boolean r0 = r6.H
            if (r0 == 0) goto L_0x0019
            androidx.recyclerview.widget.RecyclerView$l r0 = r6.f1986r
            r0.Y()
        L_0x0019:
            androidx.recyclerview.widget.RecyclerView$i r0 = r6.P
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0029
            androidx.recyclerview.widget.RecyclerView$l r0 = r6.f1986r
            boolean r0 = r0.A0()
            if (r0 == 0) goto L_0x0029
            r0 = r1
            goto L_0x002a
        L_0x0029:
            r0 = r2
        L_0x002a:
            if (r0 == 0) goto L_0x0032
            androidx.recyclerview.widget.a r0 = r6.f1971j
            r0.j()
            goto L_0x0037
        L_0x0032:
            androidx.recyclerview.widget.a r0 = r6.f1971j
            r0.c()
        L_0x0037:
            boolean r0 = r6.f1979n0
            if (r0 != 0) goto L_0x0042
            boolean r0 = r6.f1981o0
            if (r0 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r0 = r2
            goto L_0x0043
        L_0x0042:
            r0 = r1
        L_0x0043:
            androidx.recyclerview.widget.RecyclerView$w r3 = r6.f1974k0
            boolean r4 = r6.f2001z
            if (r4 == 0) goto L_0x0063
            androidx.recyclerview.widget.RecyclerView$i r4 = r6.P
            if (r4 == 0) goto L_0x0063
            boolean r4 = r6.G
            if (r4 != 0) goto L_0x0059
            if (r0 != 0) goto L_0x0059
            androidx.recyclerview.widget.RecyclerView$l r5 = r6.f1986r
            boolean r5 = r5.f2037f
            if (r5 == 0) goto L_0x0063
        L_0x0059:
            if (r4 == 0) goto L_0x0061
            androidx.recyclerview.widget.RecyclerView$d r4 = r6.f1984q
            boolean r4 = r4.f2023b
            if (r4 == 0) goto L_0x0063
        L_0x0061:
            r4 = r1
            goto L_0x0064
        L_0x0063:
            r4 = r2
        L_0x0064:
            r3.f2093j = r4
            if (r4 == 0) goto L_0x0080
            if (r0 == 0) goto L_0x0080
            boolean r0 = r6.G
            if (r0 != 0) goto L_0x0080
            androidx.recyclerview.widget.RecyclerView$i r0 = r6.P
            if (r0 == 0) goto L_0x007c
            androidx.recyclerview.widget.RecyclerView$l r6 = r6.f1986r
            boolean r6 = r6.A0()
            if (r6 == 0) goto L_0x007c
            r6 = r1
            goto L_0x007d
        L_0x007c:
            r6 = r2
        L_0x007d:
            if (r6 == 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r1 = r2
        L_0x0081:
            r3.f2094k = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.W():void");
    }

    public final void X(boolean z6) {
        this.H = z6 | this.H;
        this.G = true;
        int h7 = this.f1973k.h();
        for (int i7 = 0; i7 < h7; i7++) {
            a0 L = L(this.f1973k.g(i7));
            if (L != null && !L.o()) {
                L.b(6);
            }
        }
        Q();
        r rVar = this.f1967h;
        int size = rVar.f2065c.size();
        for (int i8 = 0; i8 < size; i8++) {
            a0 a0Var = rVar.f2065c.get(i8);
            if (a0Var != null) {
                a0Var.b(6);
                a0Var.a(null);
            }
        }
        d dVar = RecyclerView.this.f1984q;
        if (dVar == null || !dVar.f2023b) {
            rVar.g();
        }
    }

    public final void Y(a0 a0Var, i.c cVar) {
        boolean z6 = false;
        int i7 = (a0Var.f2013j & -8193) | 0;
        a0Var.f2013j = i7;
        if (this.f1974k0.f2091h) {
            if ((i7 & 2) != 0) {
                z6 = true;
            }
            if (z6 && !a0Var.i() && !a0Var.o()) {
                this.f1975l.f2150b.e(a0Var, J(a0Var));
            }
        }
        this.f1975l.b(a0Var, cVar);
    }

    public final int Z(float f7, int i7) {
        EdgeEffect edgeEffect;
        float height = f7 / ((float) getHeight());
        float width = ((float) i7) / ((float) getWidth());
        EdgeEffect edgeEffect2 = this.L;
        float f8 = 0.0f;
        if (edgeEffect2 == null || t1.d.a(edgeEffect2) == 0.0f) {
            EdgeEffect edgeEffect3 = this.N;
            if (!(edgeEffect3 == null || t1.d.a(edgeEffect3) == 0.0f)) {
                if (canScrollHorizontally(1)) {
                    edgeEffect = this.N;
                    edgeEffect.onRelease();
                } else {
                    f8 = t1.d.b(this.N, width, height);
                    if (t1.d.a(this.N) == 0.0f) {
                        this.N.onRelease();
                    }
                }
            }
            return Math.round(f8 * ((float) getWidth()));
        } else if (canScrollHorizontally(-1)) {
            edgeEffect = this.L;
            edgeEffect.onRelease();
        } else {
            f8 = -t1.d.b(this.L, -width, 1.0f - height);
            if (t1.d.a(this.L) == 0.0f) {
                this.L.onRelease();
            }
        }
        invalidate();
        return Math.round(f8 * ((float) getWidth()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i7, int i8) {
        l lVar = this.f1986r;
        if (lVar != null) {
            lVar.getClass();
        }
        super.addFocusables(arrayList, i7, i8);
    }

    public final void b0() {
        i iVar = this.P;
        if (iVar != null) {
            iVar.j();
        }
        l lVar = this.f1986r;
        if (lVar != null) {
            lVar.h0(this.f1967h);
            this.f1986r.i0(this.f1967h);
        }
        r rVar = this.f1967h;
        rVar.f2063a.clear();
        rVar.g();
    }

    public final void c0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f1978n.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof m) {
            m mVar = (m) layoutParams;
            if (!mVar.f2054c) {
                Rect rect = mVar.f2053b;
                Rect rect2 = this.f1978n;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f1978n);
            offsetRectIntoDescendantCoords(view, this.f1978n);
        }
        l lVar = this.f1986r;
        Rect rect3 = this.f1978n;
        boolean z6 = true;
        boolean z7 = !this.f2001z;
        if (view2 != null) {
            z6 = false;
        }
        lVar.l0(this, view, rect3, z7, z6);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof m) && this.f1986r.g((m) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        l lVar = this.f1986r;
        if (lVar != null && lVar.e()) {
            return this.f1986r.k(this.f1974k0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        l lVar = this.f1986r;
        if (lVar != null && lVar.e()) {
            return this.f1986r.l(this.f1974k0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        l lVar = this.f1986r;
        if (lVar != null && lVar.e()) {
            return this.f1986r.m(this.f1974k0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        l lVar = this.f1986r;
        if (lVar != null && lVar.f()) {
            return this.f1986r.n(this.f1974k0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        l lVar = this.f1986r;
        if (lVar != null && lVar.f()) {
            return this.f1986r.o(this.f1974k0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        l lVar = this.f1986r;
        if (lVar != null && lVar.f()) {
            return this.f1986r.p(this.f1974k0);
        }
        return 0;
    }

    public final void d0() {
        VelocityTracker velocityTracker = this.S;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z6 = false;
        l0(0);
        EdgeEffect edgeEffect = this.L;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z6 = this.L.isFinished();
        }
        EdgeEffect edgeEffect2 = this.M;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z6 |= this.M.isFinished();
        }
        EdgeEffect edgeEffect3 = this.N;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z6 |= this.N.isFinished();
        }
        EdgeEffect edgeEffect4 = this.O;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z6 |= this.O.isFinished();
        }
        if (z6) {
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            y.d.k(this);
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f7, float f8, boolean z6) {
        return getScrollingChildHelper().a(f7, f8, z6);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f7, float f8) {
        return getScrollingChildHelper().b(f7, f8);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i7, int i8, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i7, i8, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i7, int i8, int i9, int i10, int[] iArr) {
        return getScrollingChildHelper().e(i7, i8, i9, i10, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z6;
        float f7;
        float f8;
        super.draw(canvas);
        int size = this.f1991u.size();
        boolean z7 = false;
        for (int i7 = 0; i7 < size; i7++) {
            this.f1991u.get(i7).f(canvas, this);
        }
        EdgeEffect edgeEffect = this.L;
        boolean z8 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z6 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.m ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.L;
            z6 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.M;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.m) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.M;
            z6 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.N;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.m ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) paddingTop, (float) (-width));
            EdgeEffect edgeEffect6 = this.N;
            z6 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.O;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.m) {
                f8 = (float) (getPaddingRight() + (-getWidth()));
                f7 = (float) (getPaddingBottom() + (-getHeight()));
            } else {
                f8 = (float) (-getWidth());
                f7 = (float) (-getHeight());
            }
            canvas.translate(f8, f7);
            EdgeEffect edgeEffect8 = this.O;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z7 = true;
            }
            z6 |= z7;
            canvas.restoreToCount(save4);
        }
        if (z6 || this.P == null || this.f1991u.size() <= 0 || !this.P.k()) {
            z8 = z6;
        }
        if (z8) {
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            y.d.k(this);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j7) {
        return super.drawChild(canvas, view, j7);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e0(int r18, int r19, android.view.MotionEvent r20, int r21) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.e0(int, int, android.view.MotionEvent, int):boolean");
    }

    public final void f0(int i7, int i8, int[] iArr) {
        a0 a0Var;
        j0();
        S();
        l1.h.a("RV Scroll");
        C(this.f1974k0);
        int n02 = i7 != 0 ? this.f1986r.n0(i7, this.f1967h, this.f1974k0) : 0;
        int p02 = i8 != 0 ? this.f1986r.p0(i8, this.f1967h, this.f1974k0) : 0;
        l1.h.b();
        int e7 = this.f1973k.e();
        for (int i9 = 0; i9 < e7; i9++) {
            View d7 = this.f1973k.d(i9);
            a0 K = K(d7);
            if (!(K == null || (a0Var = K.f2012i) == null)) {
                View view = a0Var.f2005a;
                int left = d7.getLeft();
                int top = d7.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        T(true);
        k0(false);
        if (iArr != null) {
            iArr[0] = n02;
            iArr[1] = p02;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0166, code lost:
        if (r3 > 0) goto L_0x019a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0180, code lost:
        if (r6 > 0) goto L_0x019a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0183, code lost:
        if (r3 < 0) goto L_0x019a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0186, code lost:
        if (r6 < 0) goto L_0x019a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x018e, code lost:
        if ((r6 * r2) <= 0) goto L_0x0199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0196, code lost:
        if ((r6 * r2) >= 0) goto L_0x0199;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006f  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r14, int r15) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g0(int i7) {
        v vVar;
        if (!this.C) {
            setScrollState(0);
            z zVar = this.f1968h0;
            RecyclerView.this.removeCallbacks(zVar);
            zVar.f2099h.abortAnimation();
            l lVar = this.f1986r;
            if (!(lVar == null || (vVar = lVar.e) == null)) {
                vVar.d();
            }
            l lVar2 = this.f1986r;
            if (lVar2 == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            lVar2.o0(i7);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        l lVar = this.f1986r;
        if (lVar != null) {
            return lVar.s();
        }
        throw new IllegalStateException(androidx.activity.h.b(this, androidx.activity.h.d("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        l lVar = this.f1986r;
        if (lVar != null) {
            return lVar.t(getContext(), attributeSet);
        }
        throw new IllegalStateException(androidx.activity.h.b(this, androidx.activity.h.d("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public d getAdapter() {
        return this.f1984q;
    }

    @Override // android.view.View
    public int getBaseline() {
        l lVar = this.f1986r;
        if (lVar == null) {
            return super.getBaseline();
        }
        lVar.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i7, int i8) {
        return super.getChildDrawingOrder(i7, i8);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.m;
    }

    public v getCompatAccessibilityDelegate() {
        return this.f1987r0;
    }

    public h getEdgeEffectFactory() {
        return this.K;
    }

    public i getItemAnimator() {
        return this.P;
    }

    public int getItemDecorationCount() {
        return this.f1991u.size();
    }

    public l getLayoutManager() {
        return this.f1986r;
    }

    public int getMaxFlingVelocity() {
        return this.f1961d0;
    }

    public int getMinFlingVelocity() {
        return this.f1960c0;
    }

    public long getNanoTime() {
        if (I0) {
            return System.nanoTime();
        }
        return 0;
    }

    public n getOnFlingListener() {
        return this.f1959b0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1966g0;
    }

    public q getRecycledViewPool() {
        return this.f1967h.c();
    }

    public int getScrollState() {
        return this.Q;
    }

    public final void h(a0 a0Var) {
        View view = a0Var.f2005a;
        boolean z6 = view.getParent() == this;
        this.f1967h.m(K(view));
        boolean k6 = a0Var.k();
        b bVar = this.f1973k;
        if (k6) {
            bVar.b(view, -1, view.getLayoutParams(), true);
        } else if (!z6) {
            bVar.a(view, -1, true);
        } else {
            int indexOfChild = ((t) bVar.f2155a).f2275a.indexOfChild(view);
            if (indexOfChild >= 0) {
                bVar.f2156b.h(indexOfChild);
                bVar.i(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final boolean h0(EdgeEffect edgeEffect, int i7, int i8) {
        if (i7 > 0) {
            return true;
        }
        float a7 = t1.d.a(edgeEffect) * ((float) i8);
        double log = Math.log((double) ((((float) Math.abs(-i7)) * 0.35f) / (this.f1963f * 0.015f)));
        double d7 = (double) G0;
        return ((float) (Math.exp((d7 / (d7 - 1.0d)) * log) * ((double) (this.f1963f * 0.015f)))) < a7;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0) != null;
    }

    public final void i(k kVar) {
        l lVar = this.f1986r;
        if (lVar != null) {
            lVar.c("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f1991u.isEmpty()) {
            setWillNotDraw(false);
        }
        this.f1991u.add(kVar);
        Q();
        requestLayout();
    }

    public final void i0(int i7, int i8, boolean z6) {
        l lVar = this.f1986r;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.C) {
            int i9 = 0;
            if (!lVar.e()) {
                i7 = 0;
            }
            if (!this.f1986r.f()) {
                i8 = 0;
            }
            if (i7 != 0 || i8 != 0) {
                if (z6) {
                    if (i7 != 0) {
                        i9 = 1;
                    }
                    if (i8 != 0) {
                        i9 |= 2;
                    }
                    getScrollingChildHelper().g(i9, 1);
                }
                this.f1968h0.c(i7, i8, Integer.MIN_VALUE, null);
            }
        }
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f1997x;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.C;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f5499d;
    }

    public final void j(p pVar) {
        if (this.f1977m0 == null) {
            this.f1977m0 = new ArrayList();
        }
        this.f1977m0.add(pVar);
    }

    public final void j0() {
        int i7 = this.A + 1;
        this.A = i7;
        if (i7 == 1 && !this.C) {
            this.B = false;
        }
    }

    public final void k(String str) {
        if (O()) {
            if (str == null) {
                throw new IllegalStateException(androidx.activity.h.b(this, androidx.activity.h.d("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.J > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(androidx.activity.h.b(this, androidx.activity.h.d(""))));
        }
    }

    public final void k0(boolean z6) {
        if (this.A < 1) {
            if (!D0) {
                this.A = 1;
            } else {
                throw new IllegalStateException(androidx.activity.h.b(this, androidx.activity.h.d("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
        }
        if (!z6 && !this.C) {
            this.B = false;
        }
        if (this.A == 1) {
            if (z6 && this.B && !this.C && this.f1986r != null && this.f1984q != null) {
                r();
            }
            if (!this.C) {
                this.B = false;
            }
        }
        this.A--;
    }

    public final void l0(int i7) {
        getScrollingChildHelper().h(i7);
    }

    public final void m() {
        int h7 = this.f1973k.h();
        for (int i7 = 0; i7 < h7; i7++) {
            a0 L = L(this.f1973k.g(i7));
            if (!L.o()) {
                L.f2008d = -1;
                L.f2010g = -1;
            }
        }
        r rVar = this.f1967h;
        int size = rVar.f2065c.size();
        for (int i8 = 0; i8 < size; i8++) {
            a0 a0Var = rVar.f2065c.get(i8);
            a0Var.f2008d = -1;
            a0Var.f2010g = -1;
        }
        int size2 = rVar.f2063a.size();
        for (int i9 = 0; i9 < size2; i9++) {
            a0 a0Var2 = rVar.f2063a.get(i9);
            a0Var2.f2008d = -1;
            a0Var2.f2010g = -1;
        }
        ArrayList<a0> arrayList = rVar.f2064b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i10 = 0; i10 < size3; i10++) {
                a0 a0Var3 = rVar.f2064b.get(i10);
                a0Var3.f2008d = -1;
                a0Var3.f2010g = -1;
            }
        }
    }

    public final void n(int i7, int i8) {
        boolean z6;
        EdgeEffect edgeEffect = this.L;
        if (edgeEffect == null || edgeEffect.isFinished() || i7 <= 0) {
            z6 = false;
        } else {
            this.L.onRelease();
            z6 = this.L.isFinished();
        }
        EdgeEffect edgeEffect2 = this.N;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i7 < 0) {
            this.N.onRelease();
            z6 |= this.N.isFinished();
        }
        EdgeEffect edgeEffect3 = this.M;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i8 > 0) {
            this.M.onRelease();
            z6 |= this.M.isFinished();
        }
        EdgeEffect edgeEffect4 = this.O;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i8 < 0) {
            this.O.onRelease();
            z6 |= this.O.isFinished();
        }
        if (z6) {
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            y.d.k(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = 0;
        this.f1997x = true;
        this.f2001z = this.f2001z && !isLayoutRequested();
        this.f1967h.e();
        l lVar = this.f1986r;
        if (lVar != null) {
            lVar.f2038g = true;
            lVar.Q(this);
        }
        this.f1985q0 = false;
        if (I0) {
            ThreadLocal<k> threadLocal = k.f2239j;
            k kVar = threadLocal.get();
            this.f1970i0 = kVar;
            if (kVar == null) {
                this.f1970i0 = new k();
                WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
                Display b2 = y.e.b(this);
                float f7 = 60.0f;
                if (!isInEditMode() && b2 != null) {
                    float refreshRate = b2.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f7 = refreshRate;
                    }
                }
                k kVar2 = this.f1970i0;
                kVar2.f2243h = (long) (1.0E9f / f7);
                threadLocal.set(kVar2);
            }
            k kVar3 = this.f1970i0;
            kVar3.getClass();
            if (!D0 || !kVar3.f2241f.contains(this)) {
                kVar3.f2241f.add(this);
                return;
            }
            throw new IllegalStateException("RecyclerView already present in worker list!");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        k kVar;
        v vVar;
        super.onDetachedFromWindow();
        i iVar = this.P;
        if (iVar != null) {
            iVar.j();
        }
        setScrollState(0);
        z zVar = this.f1968h0;
        RecyclerView.this.removeCallbacks(zVar);
        zVar.f2099h.abortAnimation();
        l lVar = this.f1986r;
        if (!(lVar == null || (vVar = lVar.e) == null)) {
            vVar.d();
        }
        this.f1997x = false;
        l lVar2 = this.f1986r;
        if (lVar2 != null) {
            lVar2.f2038g = false;
            lVar2.R(this);
        }
        this.f1998x0.clear();
        removeCallbacks(this.f2000y0);
        this.f1975l.getClass();
        do {
        } while (a0.a.f2151d.b() != null);
        r rVar = this.f1967h;
        for (int i7 = 0; i7 < rVar.f2065c.size(); i7++) {
            q2.a.f(rVar.f2065c.get(i7).f2005a);
        }
        rVar.f(RecyclerView.this.f1984q, false);
        int i8 = 0;
        while (true) {
            if (i8 < getChildCount()) {
                i8++;
                View childAt = getChildAt(i8);
                if (childAt != null) {
                    v1.b bVar = (v1.b) childAt.getTag(2131296722);
                    if (bVar == null) {
                        bVar = new v1.b();
                        childAt.setTag(2131296722, bVar);
                    }
                    for (int x6 = q2.a.x(bVar.f6182a); -1 < x6; x6--) {
                        bVar.f6182a.get(x6).a();
                    }
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } else if (I0 && (kVar = this.f1970i0) != null) {
                boolean remove = kVar.f2241f.remove(this);
                if (!D0 || remove) {
                    this.f1970i0 = null;
                    return;
                }
                throw new IllegalStateException("RecyclerView removal failed!");
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f1991u.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f1991u.get(i7).e(canvas, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z6;
        boolean z7;
        if (this.C) {
            return false;
        }
        this.f1995w = null;
        if (E(motionEvent)) {
            d0();
            setScrollState(0);
            return true;
        }
        l lVar = this.f1986r;
        if (lVar == null) {
            return false;
        }
        boolean e7 = lVar.e();
        boolean f7 = this.f1986r.f();
        if (this.S == null) {
            this.S = VelocityTracker.obtain();
        }
        this.S.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.D) {
                this.D = false;
            }
            this.R = motionEvent.getPointerId(0);
            int x6 = (int) (motionEvent.getX() + 0.5f);
            this.V = x6;
            this.T = x6;
            int y6 = (int) (motionEvent.getY() + 0.5f);
            this.W = y6;
            this.U = y6;
            EdgeEffect edgeEffect = this.L;
            if (edgeEffect == null || t1.d.a(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                z6 = false;
            } else {
                t1.d.b(this.L, 0.0f, 1.0f - (motionEvent.getY() / ((float) getHeight())));
                z6 = true;
            }
            EdgeEffect edgeEffect2 = this.N;
            boolean z8 = z6;
            if (edgeEffect2 != null) {
                z8 = z6;
                if (t1.d.a(edgeEffect2) != 0.0f) {
                    z8 = z6;
                    if (!canScrollHorizontally(1)) {
                        t1.d.b(this.N, 0.0f, motionEvent.getY() / ((float) getHeight()));
                        z8 = true;
                    }
                }
            }
            EdgeEffect edgeEffect3 = this.M;
            boolean z9 = z8;
            if (edgeEffect3 != null) {
                z9 = z8;
                if (t1.d.a(edgeEffect3) != 0.0f) {
                    z9 = z8;
                    if (!canScrollVertically(-1)) {
                        t1.d.b(this.M, 0.0f, motionEvent.getX() / ((float) getWidth()));
                        z9 = true;
                    }
                }
            }
            EdgeEffect edgeEffect4 = this.O;
            boolean z10 = z9;
            if (edgeEffect4 != null) {
                z10 = z9;
                if (t1.d.a(edgeEffect4) != 0.0f) {
                    z10 = z9;
                    if (!canScrollVertically(1)) {
                        t1.d.b(this.O, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
                        z10 = true;
                    }
                }
            }
            if (z10 || this.Q == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                l0(1);
            }
            int[] iArr = this.f1994v0;
            iArr[1] = 0;
            iArr[0] = 0;
            if (f7) {
                boolean z11 = e7 ? 1 : 0;
                boolean z12 = e7 ? 1 : 0;
                e7 = z11 | true;
            }
            p1.l scrollingChildHelper = getScrollingChildHelper();
            int i7 = e7 ? 1 : 0;
            int i8 = e7 ? 1 : 0;
            int i9 = e7 ? 1 : 0;
            scrollingChildHelper.g(i7, 0);
        } else if (actionMasked == 1) {
            this.S.clear();
            l0(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.R);
            if (findPointerIndex < 0) {
                StringBuilder d7 = androidx.activity.h.d("Error processing scroll; pointer index for id ");
                d7.append(this.R);
                d7.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", d7.toString());
                return false;
            }
            int x7 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y7 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.Q != 1) {
                int i10 = x7 - this.T;
                int i11 = y7 - this.U;
                if (!e7 || Math.abs(i10) <= this.f1958a0) {
                    z7 = false;
                } else {
                    this.V = x7;
                    z7 = true;
                }
                if (f7 && Math.abs(i11) > this.f1958a0) {
                    this.W = y7;
                    z7 = true;
                }
                if (z7) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            d0();
            setScrollState(0);
        } else if (actionMasked == 5) {
            this.R = motionEvent.getPointerId(actionIndex);
            int x8 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.V = x8;
            this.T = x8;
            int y8 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.W = y8;
            this.U = y8;
        } else if (actionMasked == 6) {
            U(motionEvent);
        }
        return this.Q == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        l1.h.a("RV OnLayout");
        r();
        l1.h.b();
        this.f2001z = true;
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        l lVar = this.f1986r;
        if (lVar == null) {
            q(i7, i8);
            return;
        }
        boolean z6 = false;
        if (lVar.K()) {
            int mode = View.MeasureSpec.getMode(i7);
            int mode2 = View.MeasureSpec.getMode(i8);
            this.f1986r.f2034b.q(i7, i8);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z6 = true;
            }
            this.f2002z0 = z6;
            if (!z6 && this.f1984q != null) {
                if (this.f1974k0.f2088d == 1) {
                    s();
                }
                this.f1986r.r0(i7, i8);
                this.f1974k0.f2092i = true;
                t();
                this.f1986r.t0(i7, i8);
                if (this.f1986r.w0()) {
                    this.f1986r.r0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f1974k0.f2092i = true;
                    t();
                    this.f1986r.t0(i7, i8);
                }
                this.A0 = getMeasuredWidth();
                this.B0 = getMeasuredHeight();
            }
        } else if (this.f1999y) {
            this.f1986r.f2034b.q(i7, i8);
        } else {
            w wVar = this.f1974k0;
            if (wVar.f2094k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            d dVar = this.f1984q;
            if (dVar != null) {
                wVar.e = dVar.a();
            } else {
                wVar.e = 0;
            }
            j0();
            this.f1986r.f2034b.q(i7, i8);
            k0(false);
            this.f1974k0.f2090g = false;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i7, Rect rect) {
        if (O()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i7, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof u)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        u uVar = (u) parcelable;
        this.f1969i = uVar;
        super.onRestoreInstanceState(uVar.f6374f);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        u uVar = new u(super.onSaveInstanceState());
        u uVar2 = this.f1969i;
        if (uVar2 != null) {
            uVar.f2071h = uVar2.f2071h;
        } else {
            l lVar = this.f1986r;
            uVar.f2071h = lVar != null ? lVar.f0() : null;
        }
        return uVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        if (i7 != i9 || i8 != i10) {
            this.O = null;
            this.M = null;
            this.N = null;
            this.L = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:244:0x03cf, code lost:
        if (r3 < r8) goto L_0x03d2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x03e2, code lost:
        if (r8 != 0) goto L_0x0410;
     */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0299 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0112  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r20) {
        /*
            Method dump skipped, instructions count: 1115
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (!this.f2001z || this.G) {
            l1.h.a("RV FullInvalidate");
            r();
            l1.h.b();
        } else if (this.f1971j.g()) {
            this.f1971j.getClass();
            if (this.f1971j.g()) {
                l1.h.a("RV FullInvalidate");
                r();
                l1.h.b();
            }
        }
    }

    public final void q(int i7, int i8) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
        setMeasuredDimension(l.h(i7, paddingRight, y.d.e(this)), l.h(i8, getPaddingBottom() + getPaddingTop(), y.d.d(this)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0328, code lost:
        if (r15.f1973k.k(getFocusedChild()) == false) goto L_0x03ec;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            Method dump skipped, instructions count: 1013
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r():void");
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z6) {
        a0 L = L(view);
        if (L != null) {
            if (L.k()) {
                L.f2013j &= -257;
            } else if (!L.o()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(L);
                throw new IllegalArgumentException(androidx.activity.h.b(this, sb));
            }
        } else if (D0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(androidx.activity.h.b(this, sb2));
        }
        view.clearAnimation();
        L(view);
        super.removeDetachedView(view, z6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        v vVar = this.f1986r.e;
        boolean z6 = true;
        if (!(vVar != null && vVar.e) && !O()) {
            z6 = false;
        }
        if (!z6 && view2 != null) {
            c0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z6) {
        return this.f1986r.l0(this, view, rect, z6, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z6) {
        int size = this.f1993v.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f1993v.get(i7).c();
        }
        super.requestDisallowInterceptTouchEvent(z6);
    }

    @Override // android.view.ViewParent, android.view.View
    public final void requestLayout() {
        if (this.A != 0 || this.C) {
            this.B = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s() {
        int i7;
        View view;
        int id;
        View D;
        this.f1974k0.a(1);
        C(this.f1974k0);
        this.f1974k0.f2092i = false;
        j0();
        a0 a0Var = this.f1975l;
        a0Var.f2149a.clear();
        a0Var.f2150b.a();
        S();
        W();
        View focusedChild = (!this.f1966g0 || !hasFocus() || this.f1984q == null) ? null : getFocusedChild();
        a0 K = (focusedChild == null || (D = D(focusedChild)) == null) ? null : K(D);
        long j7 = -1;
        if (K == null) {
            w wVar = this.f1974k0;
            wVar.m = -1;
            wVar.f2095l = -1;
            wVar.f2096n = -1;
        } else {
            w wVar2 = this.f1974k0;
            if (this.f1984q.f2023b) {
                j7 = K.e;
            }
            wVar2.m = j7;
            if (!this.G) {
                if (K.i()) {
                    i7 = K.f2008d;
                } else {
                    RecyclerView recyclerView = K.f2020r;
                    if (recyclerView != null) {
                        i7 = recyclerView.I(K);
                    }
                }
                wVar2.f2095l = i7;
                w wVar3 = this.f1974k0;
                view = K.f2005a;
                loop0: while (true) {
                    id = view.getId();
                    while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                        view = ((ViewGroup) view).getFocusedChild();
                        if (view.getId() != -1) {
                            break;
                        }
                    }
                }
                wVar3.f2096n = id;
            }
            i7 = -1;
            wVar2.f2095l = i7;
            w wVar32 = this.f1974k0;
            view = K.f2005a;
            loop0: while (true) {
                id = view.getId();
                while (!view.isFocused()) {
                    view = ((ViewGroup) view).getFocusedChild();
                    if (view.getId() != -1) {
                        break;
                    }
                }
            }
            wVar32.f2096n = id;
        }
        w wVar4 = this.f1974k0;
        wVar4.f2091h = wVar4.f2093j && this.f1981o0;
        this.f1981o0 = false;
        this.f1979n0 = false;
        wVar4.f2090g = wVar4.f2094k;
        wVar4.e = this.f1984q.a();
        F(this.f1988s0);
        if (this.f1974k0.f2093j) {
            int e7 = this.f1973k.e();
            for (int i8 = 0; i8 < e7; i8++) {
                a0 L = L(this.f1973k.d(i8));
                if (!L.o() && (!L.g() || this.f1984q.f2023b)) {
                    i iVar = this.P;
                    i.e(L);
                    L.d();
                    iVar.getClass();
                    i.c cVar = new i.c();
                    cVar.a(L);
                    this.f1975l.b(L, cVar);
                    if (this.f1974k0.f2091h) {
                        if (((L.f2013j & 2) != 0) && !L.i() && !L.o() && !L.g()) {
                            this.f1975l.f2150b.e(L, J(L));
                        }
                    }
                }
            }
        }
        if (this.f1974k0.f2094k) {
            int h7 = this.f1973k.h();
            for (int i9 = 0; i9 < h7; i9++) {
                a0 L2 = L(this.f1973k.g(i9));
                if (!D0 || L2.f2007c != -1 || L2.i()) {
                    if (!L2.o() && L2.f2008d == -1) {
                        L2.f2008d = L2.f2007c;
                    }
                } else {
                    throw new IllegalStateException(androidx.activity.h.b(this, androidx.activity.h.d("view holder cannot have position -1 unless it is removed")));
                }
            }
            w wVar5 = this.f1974k0;
            boolean z6 = wVar5.f2089f;
            wVar5.f2089f = false;
            this.f1986r.c0(this.f1967h, wVar5);
            this.f1974k0.f2089f = z6;
            for (int i10 = 0; i10 < this.f1973k.e(); i10++) {
                a0 L3 = L(this.f1973k.d(i10));
                if (!L3.o()) {
                    a0.a orDefault = this.f1975l.f2149a.getOrDefault(L3, null);
                    if (!((orDefault == null || (orDefault.f2152a & 4) == 0) ? false : true)) {
                        i.e(L3);
                        boolean z7 = (L3.f2013j & 8192) != 0;
                        i iVar2 = this.P;
                        L3.d();
                        iVar2.getClass();
                        i.c cVar2 = new i.c();
                        cVar2.a(L3);
                        if (z7) {
                            Y(L3, cVar2);
                        } else {
                            a0 a0Var2 = this.f1975l;
                            a0.a orDefault2 = a0Var2.f2149a.getOrDefault(L3, null);
                            if (orDefault2 == null) {
                                orDefault2 = a0.a.a();
                                a0Var2.f2149a.put(L3, orDefault2);
                            }
                            orDefault2.f2152a |= 2;
                            orDefault2.f2153b = cVar2;
                        }
                    }
                }
            }
        }
        m();
        T(true);
        k0(false);
        this.f1974k0.f2088d = 2;
    }

    @Override // android.view.View
    public final void scrollBy(int i7, int i8) {
        l lVar = this.f1986r;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.C) {
            boolean e7 = lVar.e();
            boolean f7 = this.f1986r.f();
            if (e7 || f7) {
                if (!e7) {
                    i7 = 0;
                }
                if (!f7) {
                    i8 = 0;
                }
                e0(i7, i8, null, 0);
            }
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i7, int i8) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i7 = 0;
        if (O()) {
            int a7 = accessibilityEvent != null ? q1.b.a(accessibilityEvent) : 0;
            if (a7 != 0) {
                i7 = a7;
            }
            this.E |= i7;
            i7 = 1;
        }
        if (i7 == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(v vVar) {
        this.f1987r0 = vVar;
        p1.y.i(this, vVar);
    }

    public void setAdapter(d dVar) {
        setLayoutFrozen(false);
        d dVar2 = this.f1984q;
        if (dVar2 != null) {
            dVar2.f2022a.unregisterObserver(this.f1965g);
            this.f1984q.getClass();
        }
        b0();
        a aVar = this.f1971j;
        aVar.l(aVar.f2142b);
        aVar.l(aVar.f2143c);
        d<?> dVar3 = this.f1984q;
        this.f1984q = dVar;
        if (dVar != null) {
            dVar.f2022a.registerObserver(this.f1965g);
        }
        l lVar = this.f1986r;
        if (lVar != null) {
            lVar.P();
        }
        r rVar = this.f1967h;
        d dVar4 = this.f1984q;
        rVar.f2063a.clear();
        rVar.g();
        rVar.f(dVar3, true);
        q c7 = rVar.c();
        if (dVar3 != null) {
            c7.f2057b--;
        }
        if (c7.f2057b == 0) {
            for (int i7 = 0; i7 < c7.f2056a.size(); i7++) {
                q.a valueAt = c7.f2056a.valueAt(i7);
                Iterator<a0> it = valueAt.f2059a.iterator();
                while (it.hasNext()) {
                    q2.a.f(it.next().f2005a);
                }
                valueAt.f2059a.clear();
            }
        }
        if (dVar4 != null) {
            c7.f2057b++;
        }
        rVar.e();
        this.f1974k0.f2089f = true;
        X(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(g gVar) {
        if (gVar != null) {
            setChildrenDrawingOrderEnabled(gVar != null);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z6) {
        if (z6 != this.m) {
            this.O = null;
            this.M = null;
            this.N = null;
            this.L = null;
        }
        this.m = z6;
        super.setClipToPadding(z6);
        if (this.f2001z) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(h hVar) {
        hVar.getClass();
        this.K = hVar;
        this.O = null;
        this.M = null;
        this.N = null;
        this.L = null;
    }

    public void setHasFixedSize(boolean z6) {
        this.f1999y = z6;
    }

    public void setItemAnimator(i iVar) {
        i iVar2 = this.P;
        if (iVar2 != null) {
            iVar2.j();
            this.P.f2025a = null;
        }
        this.P = iVar;
        if (iVar != null) {
            iVar.f2025a = this.f1983p0;
        }
    }

    public void setItemViewCacheSize(int i7) {
        r rVar = this.f1967h;
        rVar.e = i7;
        rVar.n();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z6) {
        suppressLayout(z6);
    }

    public void setLayoutManager(l lVar) {
        v vVar;
        if (lVar != this.f1986r) {
            setScrollState(0);
            z zVar = this.f1968h0;
            RecyclerView.this.removeCallbacks(zVar);
            zVar.f2099h.abortAnimation();
            l lVar2 = this.f1986r;
            if (!(lVar2 == null || (vVar = lVar2.e) == null)) {
                vVar.d();
            }
            if (this.f1986r != null) {
                i iVar = this.P;
                if (iVar != null) {
                    iVar.j();
                }
                this.f1986r.h0(this.f1967h);
                this.f1986r.i0(this.f1967h);
                r rVar = this.f1967h;
                rVar.f2063a.clear();
                rVar.g();
                if (this.f1997x) {
                    l lVar3 = this.f1986r;
                    lVar3.f2038g = false;
                    lVar3.R(this);
                }
                this.f1986r.u0(null);
                this.f1986r = null;
            } else {
                r rVar2 = this.f1967h;
                rVar2.f2063a.clear();
                rVar2.g();
            }
            b bVar = this.f1973k;
            bVar.f2156b.g();
            int size = bVar.f2157c.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                t tVar = (t) bVar.f2155a;
                tVar.getClass();
                a0 L = L((View) bVar.f2157c.get(size));
                if (L != null) {
                    RecyclerView recyclerView = tVar.f2275a;
                    int i7 = L.f2018p;
                    if (recyclerView.O()) {
                        L.f2019q = i7;
                        recyclerView.f1998x0.add(L);
                    } else {
                        View view = L.f2005a;
                        WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
                        y.d.s(view, i7);
                    }
                    L.f2018p = 0;
                }
                bVar.f2157c.remove(size);
            }
            t tVar2 = (t) bVar.f2155a;
            int a7 = tVar2.a();
            for (int i8 = 0; i8 < a7; i8++) {
                View childAt = tVar2.f2275a.getChildAt(i8);
                RecyclerView recyclerView2 = tVar2.f2275a;
                recyclerView2.getClass();
                L(childAt);
                d dVar = recyclerView2.f1984q;
                childAt.clearAnimation();
            }
            tVar2.f2275a.removeAllViews();
            this.f1986r = lVar;
            if (lVar != null) {
                if (lVar.f2034b == null) {
                    lVar.u0(this);
                    if (this.f1997x) {
                        l lVar4 = this.f1986r;
                        lVar4.f2038g = true;
                        lVar4.Q(this);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LayoutManager ");
                    sb.append(lVar);
                    sb.append(" is already attached to a RecyclerView:");
                    throw new IllegalArgumentException(androidx.activity.h.b(lVar.f2034b, sb));
                }
            }
            this.f1967h.n();
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z6) {
        p1.l scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f5499d) {
            View view = scrollingChildHelper.f5498c;
            WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
            y.i.z(view);
        }
        scrollingChildHelper.f5499d = z6;
    }

    public void setOnFlingListener(n nVar) {
        this.f1959b0 = nVar;
    }

    @Deprecated
    public void setOnScrollListener(p pVar) {
        this.f1976l0 = pVar;
    }

    public void setPreserveFocusAfterLayout(boolean z6) {
        this.f1966g0 = z6;
    }

    public void setRecycledViewPool(q qVar) {
        r rVar = this.f1967h;
        rVar.f(RecyclerView.this.f1984q, false);
        q qVar2 = rVar.f2068g;
        if (qVar2 != null) {
            qVar2.f2057b--;
        }
        rVar.f2068g = qVar;
        if (!(qVar == null || RecyclerView.this.getAdapter() == null)) {
            rVar.f2068g.f2057b++;
        }
        rVar.e();
    }

    @Deprecated
    public void setRecyclerListener(s sVar) {
        this.s = sVar;
    }

    public void setScrollState(int i7) {
        v vVar;
        if (i7 != this.Q) {
            if (E0) {
                Log.d("RecyclerView", "setting scroll state to " + i7 + " from " + this.Q, new Exception());
            }
            this.Q = i7;
            if (i7 != 2) {
                z zVar = this.f1968h0;
                RecyclerView.this.removeCallbacks(zVar);
                zVar.f2099h.abortAnimation();
                l lVar = this.f1986r;
                if (!(lVar == null || (vVar = lVar.e) == null)) {
                    vVar.d();
                }
            }
            l lVar2 = this.f1986r;
            if (lVar2 != null) {
                lVar2.g0(i7);
            }
            p pVar = this.f1976l0;
            if (pVar != null) {
                pVar.a(this, i7);
            }
            ArrayList arrayList = this.f1977m0;
            if (arrayList != null) {
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        ((p) this.f1977m0.get(size)).a(this, i7);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setScrollingTouchSlop(int i7) {
        int i8;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i7 != 0) {
            if (i7 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i7 + "; using default value");
            } else {
                i8 = viewConfiguration.getScaledPagingTouchSlop();
                this.f1958a0 = i8;
            }
        }
        i8 = viewConfiguration.getScaledTouchSlop();
        this.f1958a0 = i8;
    }

    public void setViewCacheExtension(y yVar) {
        this.f1967h.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i7) {
        return getScrollingChildHelper().g(i7, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z6) {
        v vVar;
        if (z6 != this.C) {
            k("Do not suppressLayout in layout or scroll");
            if (!z6) {
                this.C = false;
                if (!(!this.B || this.f1986r == null || this.f1984q == null)) {
                    requestLayout();
                }
                this.B = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.C = true;
            this.D = true;
            setScrollState(0);
            z zVar = this.f1968h0;
            RecyclerView.this.removeCallbacks(zVar);
            zVar.f2099h.abortAnimation();
            l lVar = this.f1986r;
            if (lVar != null && (vVar = lVar.e) != null) {
                vVar.d();
            }
        }
    }

    public final void t() {
        j0();
        S();
        this.f1974k0.a(6);
        this.f1971j.c();
        this.f1974k0.e = this.f1984q.a();
        this.f1974k0.f2087c = 0;
        if (this.f1969i != null) {
            d dVar = this.f1984q;
            int a7 = p.p.a(dVar.f2024c);
            if (a7 == 1 ? dVar.a() > 0 : a7 != 2) {
                Parcelable parcelable = this.f1969i.f2071h;
                if (parcelable != null) {
                    this.f1986r.e0(parcelable);
                }
                this.f1969i = null;
            }
        }
        w wVar = this.f1974k0;
        wVar.f2090g = false;
        this.f1986r.c0(this.f1967h, wVar);
        w wVar2 = this.f1974k0;
        wVar2.f2089f = false;
        wVar2.f2093j = wVar2.f2093j && this.P != null;
        wVar2.f2088d = 4;
        T(true);
        k0(false);
    }

    public final boolean u(int i7, int i8, int i9, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i7, i8, i9, iArr, iArr2);
    }

    public final void v(int i7, int i8, int i9, int i10, int[] iArr, int i11, int[] iArr2) {
        getScrollingChildHelper().e(i7, i8, i9, i10, iArr, i11, iArr2);
    }

    public final void w(int i7, int i8) {
        this.J++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i7, scrollY - i8);
        p pVar = this.f1976l0;
        if (pVar != null) {
            pVar.b(this, i7, i8);
        }
        ArrayList arrayList = this.f1977m0;
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                ((p) this.f1977m0.get(size)).b(this, i7, i8);
            }
        }
        this.J--;
    }

    public final void x() {
        if (this.O == null) {
            ((x) this.K).getClass();
            EdgeEffect edgeEffect = new EdgeEffect(getContext());
            this.O = edgeEffect;
            if (this.m) {
                edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public final void y() {
        if (this.L == null) {
            ((x) this.K).getClass();
            EdgeEffect edgeEffect = new EdgeEffect(getContext());
            this.L = edgeEffect;
            if (this.m) {
                edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public final void z() {
        if (this.N == null) {
            ((x) this.K).getClass();
            EdgeEffect edgeEffect = new EdgeEffect(getContext());
            this.N = edgeEffect;
            if (this.m) {
                edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        l lVar = this.f1986r;
        if (lVar != null) {
            return lVar.u(layoutParams);
        }
        throw new IllegalStateException(androidx.activity.h.b(this, androidx.activity.h.d("RecyclerView has no LayoutManager")));
    }
}
