package androidx.fragment.app;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.g;
import e2.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class n implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.n, androidx.lifecycle.f0, androidx.lifecycle.e, h2.c {
    public static final Object V = new Object();
    public int A;
    public int B;
    public String C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean H;
    public ViewGroup I;
    public View J;
    public boolean K;
    public b M;
    public boolean N;
    public boolean O;
    public androidx.lifecycle.o Q;
    public m0 R;
    public h2.b T;
    public final ArrayList<d> U;

    /* renamed from: g */
    public Bundle f1701g;

    /* renamed from: h */
    public SparseArray<Parcelable> f1702h;

    /* renamed from: i */
    public Bundle f1703i;

    /* renamed from: k */
    public Bundle f1705k;

    /* renamed from: l */
    public n f1706l;

    /* renamed from: n */
    public int f1707n;

    /* renamed from: p */
    public boolean f1709p;

    /* renamed from: q */
    public boolean f1710q;

    /* renamed from: r */
    public boolean f1711r;
    public boolean s;

    /* renamed from: t */
    public boolean f1712t;

    /* renamed from: u */
    public boolean f1713u;

    /* renamed from: v */
    public int f1714v;

    /* renamed from: w */
    public x f1715w;

    /* renamed from: x */
    public u<?> f1716x;

    /* renamed from: z */
    public n f1718z;

    /* renamed from: f */
    public int f1700f = -1;

    /* renamed from: j */
    public String f1704j = UUID.randomUUID().toString();
    public String m = null;

    /* renamed from: o */
    public Boolean f1708o = null;

    /* renamed from: y */
    public y f1717y = new y();
    public boolean G = true;
    public boolean L = true;
    public g.b P = g.b.RESUMED;
    public androidx.lifecycle.r<androidx.lifecycle.n> S = new androidx.lifecycle.r<>();

    /* loaded from: classes.dex */
    public class a extends androidx.activity.result.c {
        public a() {
            n.this = r1;
        }

        @Override // androidx.activity.result.c
        public final View g(int i7) {
            View view = n.this.J;
            if (view != null) {
                return view.findViewById(i7);
            }
            StringBuilder d7 = androidx.activity.h.d("Fragment ");
            d7.append(n.this);
            d7.append(" does not have a view");
            throw new IllegalStateException(d7.toString());
        }

        @Override // androidx.activity.result.c
        public final boolean n() {
            return n.this.J != null;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public boolean f1720a;

        /* renamed from: b */
        public int f1721b;

        /* renamed from: c */
        public int f1722c;

        /* renamed from: d */
        public int f1723d;
        public int e;

        /* renamed from: f */
        public int f1724f;

        /* renamed from: g */
        public ArrayList<String> f1725g;

        /* renamed from: h */
        public ArrayList<String> f1726h;

        /* renamed from: i */
        public Object f1727i;

        /* renamed from: j */
        public Object f1728j;

        /* renamed from: k */
        public Object f1729k;

        /* renamed from: l */
        public float f1730l;
        public View m;

        public b() {
            Object obj = n.V;
            this.f1727i = obj;
            this.f1728j = obj;
            this.f1729k = obj;
            this.f1730l = 1.0f;
            this.m = null;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RuntimeException {
        public c(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract void a();
    }

    public n() {
        new AtomicInteger();
        this.U = new ArrayList<>();
        this.Q = new androidx.lifecycle.o(this);
        this.T = new h2.b(this);
    }

    public void A(Bundle bundle) {
    }

    public void B() {
        this.H = true;
    }

    public void C() {
        this.H = true;
    }

    public void D(Bundle bundle) {
        this.H = true;
    }

    public void E(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1717y.P();
        this.f1713u = true;
        this.R = new m0(i());
        View u6 = u(layoutInflater, viewGroup, bundle);
        this.J = u6;
        if (u6 == null) {
            if (this.R.f1698g != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.R = null;
            return;
        }
        this.R.e();
        a0.b.B(this.J, this.R);
        View view = this.J;
        m0 m0Var = this.R;
        r5.h.f(view, "<this>");
        view.setTag(2131296918, m0Var);
        a0.b.C(this.J, this.R);
        this.S.h(this.R);
    }

    public final void F() {
        this.f1717y.u(1);
        if (this.J != null) {
            m0 m0Var = this.R;
            m0Var.e();
            if (m0Var.f1698g.f1876d.compareTo(g.b.CREATED) >= 0) {
                this.R.d(g.a.ON_DESTROY);
            }
        }
        this.f1700f = 1;
        this.H = false;
        w();
        if (!this.H) {
            throw new u0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        a.b bVar = (a.b) new androidx.lifecycle.d0(i(), a.b.f3760d).a(a.b.class);
        int i7 = bVar.f3761c.f5225h;
        for (int i8 = 0; i8 < i7; i8++) {
            ((a.C0049a) bVar.f3761c.f5224g[i8]).getClass();
        }
        this.f1713u = false;
    }

    public final void G() {
        onLowMemory();
        this.f1717y.n();
    }

    public final void H(boolean z6) {
        this.f1717y.o(z6);
    }

    public final void I(boolean z6) {
        this.f1717y.s(z6);
    }

    public final boolean J() {
        if (this.D) {
            return false;
        }
        return false | this.f1717y.t();
    }

    public final q K() {
        u<?> uVar = this.f1716x;
        q qVar = uVar == null ? null : (q) uVar.f1764f;
        if (qVar != null) {
            return qVar;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Context L() {
        Context j5 = j();
        if (j5 != null) {
            return j5;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final View M() {
        View view = this.J;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public final void N(int i7, int i8, int i9, int i10) {
        if (this.M == null && i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) {
            return;
        }
        g().f1721b = i7;
        g().f1722c = i8;
        g().f1723d = i9;
        g().e = i10;
    }

    public final void O(Bundle bundle) {
        x xVar = this.f1715w;
        if (xVar != null) {
            if (xVar.f1794y || xVar.f1795z) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.f1705k = bundle;
    }

    @Override // h2.c
    public final androidx.savedstate.a b() {
        return this.T.f4376b;
    }

    public androidx.activity.result.c d() {
        return new a();
    }

    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.A));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.B));
        printWriter.print(" mTag=");
        printWriter.println(this.C);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f1700f);
        printWriter.print(" mWho=");
        printWriter.print(this.f1704j);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f1714v);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f1709p);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f1710q);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f1711r);
        printWriter.print(" mInLayout=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.D);
        printWriter.print(" mDetached=");
        printWriter.print(this.E);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.G);
        printWriter.print(" mHasMenu=");
        printWriter.println(false);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.F);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.L);
        if (this.f1715w != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f1715w);
        }
        if (this.f1716x != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f1716x);
        }
        if (this.f1718z != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f1718z);
        }
        if (this.f1705k != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f1705k);
        }
        if (this.f1701g != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f1701g);
        }
        if (this.f1702h != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f1702h);
        }
        if (this.f1703i != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f1703i);
        }
        n nVar = this.f1706l;
        if (nVar == null) {
            x xVar = this.f1715w;
            nVar = (xVar == null || (str2 = this.m) == null) ? null : xVar.D(str2);
        }
        if (nVar != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(nVar);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f1707n);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        b bVar = this.M;
        printWriter.println(bVar == null ? false : bVar.f1720a);
        b bVar2 = this.M;
        if ((bVar2 == null ? 0 : bVar2.f1721b) != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            b bVar3 = this.M;
            printWriter.println(bVar3 == null ? 0 : bVar3.f1721b);
        }
        b bVar4 = this.M;
        if ((bVar4 == null ? 0 : bVar4.f1722c) != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            b bVar5 = this.M;
            printWriter.println(bVar5 == null ? 0 : bVar5.f1722c);
        }
        b bVar6 = this.M;
        if ((bVar6 == null ? 0 : bVar6.f1723d) != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            b bVar7 = this.M;
            printWriter.println(bVar7 == null ? 0 : bVar7.f1723d);
        }
        b bVar8 = this.M;
        if ((bVar8 == null ? 0 : bVar8.e) != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            b bVar9 = this.M;
            printWriter.println(bVar9 != null ? bVar9.e : 0);
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.I);
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.J);
        }
        b bVar10 = this.M;
        if (bVar10 != null) {
            bVar10.getClass();
        }
        if (j() != null) {
            new e2.a(this, i()).p(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f1717y + ":");
        this.f1717y.w(s0.h(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final b g() {
        if (this.M == null) {
            this.M = new b();
        }
        return this.M;
    }

    public final x h() {
        if (this.f1716x != null) {
            return this.f1717y;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.lifecycle.f0
    public final androidx.lifecycle.e0 i() {
        if (this.f1715w != null) {
            if (l() != 1) {
                a0 a0Var = this.f1715w.F;
                androidx.lifecycle.e0 e0Var = a0Var.e.get(this.f1704j);
                if (e0Var == null) {
                    androidx.lifecycle.e0 e0Var2 = new androidx.lifecycle.e0();
                    a0Var.e.put(this.f1704j, e0Var2);
                    return e0Var2;
                }
                return e0Var;
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final Context j() {
        u<?> uVar = this.f1716x;
        if (uVar == null) {
            return null;
        }
        return uVar.f1765g;
    }

    @Override // androidx.lifecycle.n
    public final androidx.lifecycle.o k() {
        return this.Q;
    }

    public final int l() {
        g.b bVar = this.P;
        return (bVar == g.b.INITIALIZED || this.f1718z == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.f1718z.l());
    }

    public final x m() {
        x xVar = this.f1715w;
        if (xVar != null) {
            return xVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final Object n() {
        Object obj;
        b bVar = this.M;
        if (bVar == null || (obj = bVar.f1728j) == V) {
            return null;
        }
        return obj;
    }

    public final Object o() {
        Object obj;
        b bVar = this.M;
        if (bVar == null || (obj = bVar.f1727i) == V) {
            return null;
        }
        return obj;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.H = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        K().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.H = true;
    }

    public final Object p() {
        Object obj;
        b bVar = this.M;
        if (bVar == null || (obj = bVar.f1729k) == V) {
            return null;
        }
        return obj;
    }

    public final String q(int i7) {
        return L().getResources().getString(i7);
    }

    @Deprecated
    public final void r(int i7, int i8, Intent intent) {
        if (x.K(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i7 + " resultCode: " + i8 + " data: " + intent);
        }
    }

    public void s(Context context) {
        this.H = true;
        u<?> uVar = this.f1716x;
        if ((uVar == null ? null : uVar.f1764f) != null) {
            this.H = true;
        }
    }

    public void t(Bundle bundle) {
        Parcelable parcelable;
        this.H = true;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.f1717y.U(parcelable);
            this.f1717y.k();
        }
        y yVar = this.f1717y;
        if (yVar.m >= 1) {
            return;
        }
        yVar.k();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f1704j);
        if (this.A != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.A));
        }
        if (this.C != null) {
            sb.append(" tag=");
            sb.append(this.C);
        }
        sb.append(")");
        return sb.toString();
    }

    public View u(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void v() {
        this.H = true;
    }

    public void w() {
        this.H = true;
    }

    public void x() {
        this.H = true;
    }

    public LayoutInflater y(Bundle bundle) {
        u<?> uVar = this.f1716x;
        if (uVar != null) {
            LayoutInflater q6 = uVar.q();
            q6.setFactory2(this.f1717y.f1777f);
            return q6;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void z(int i7, String[] strArr, int[] iArr) {
    }
}
