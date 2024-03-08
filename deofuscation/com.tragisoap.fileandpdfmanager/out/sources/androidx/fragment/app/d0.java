package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.h;
import androidx.fragment.app.n;
import androidx.fragment.app.q0;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.o;
import com.davemorrissey.labs.subscaleview.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d0 {

    /* renamed from: a */
    public final w f1611a;

    /* renamed from: b */
    public final e0 f1612b;

    /* renamed from: c */
    public final n f1613c;

    /* renamed from: d */
    public boolean f1614d = false;
    public int e = -1;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: f */
        public final /* synthetic */ View f1615f;

        public a(View view) {
            this.f1615f = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            this.f1615f.removeOnAttachStateChangeListener(this);
            View view2 = this.f1615f;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.h.c(view2);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    public d0(w wVar, e0 e0Var, n nVar) {
        this.f1611a = wVar;
        this.f1612b = e0Var;
        this.f1613c = nVar;
    }

    public d0(w wVar, e0 e0Var, n nVar, c0 c0Var) {
        this.f1611a = wVar;
        this.f1612b = e0Var;
        this.f1613c = nVar;
        nVar.f1702h = null;
        nVar.f1703i = null;
        nVar.f1714v = 0;
        nVar.s = false;
        nVar.f1709p = false;
        n nVar2 = nVar.f1706l;
        nVar.m = nVar2 != null ? nVar2.f1704j : null;
        nVar.f1706l = null;
        Bundle bundle = c0Var.f1606r;
        nVar.f1701g = bundle == null ? new Bundle() : bundle;
    }

    public d0(w wVar, e0 e0Var, ClassLoader classLoader, t tVar, c0 c0Var) {
        this.f1611a = wVar;
        this.f1612b = e0Var;
        n a7 = tVar.a(c0Var.f1595f);
        this.f1613c = a7;
        Bundle bundle = c0Var.f1603o;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a7.O(c0Var.f1603o);
        a7.f1704j = c0Var.f1596g;
        a7.f1711r = c0Var.f1597h;
        a7.f1712t = true;
        a7.A = c0Var.f1598i;
        a7.B = c0Var.f1599j;
        a7.C = c0Var.f1600k;
        a7.F = c0Var.f1601l;
        a7.f1710q = c0Var.m;
        a7.E = c0Var.f1602n;
        a7.D = c0Var.f1604p;
        a7.P = g.b.values()[c0Var.f1605q];
        Bundle bundle2 = c0Var.f1606r;
        a7.f1701g = bundle2 == null ? new Bundle() : bundle2;
        if (x.K(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a7);
        }
    }

    public final void a() {
        if (x.K(3)) {
            StringBuilder d7 = h.d("moveto ACTIVITY_CREATED: ");
            d7.append(this.f1613c);
            Log.d("FragmentManager", d7.toString());
        }
        n nVar = this.f1613c;
        Bundle bundle = nVar.f1701g;
        nVar.f1717y.P();
        nVar.f1700f = 3;
        nVar.H = true;
        if (x.K(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + nVar);
        }
        View view = nVar.J;
        if (view != null) {
            Bundle bundle2 = nVar.f1701g;
            SparseArray<Parcelable> sparseArray = nVar.f1702h;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                nVar.f1702h = null;
            }
            if (nVar.J != null) {
                m0 m0Var = nVar.R;
                m0Var.f1699h.b(nVar.f1703i);
                nVar.f1703i = null;
            }
            nVar.H = false;
            nVar.D(bundle2);
            if (!nVar.H) {
                throw new u0("Fragment " + nVar + " did not call through to super.onViewStateRestored()");
            } else if (nVar.J != null) {
                nVar.R.d(g.a.ON_CREATE);
            }
        }
        nVar.f1701g = null;
        y yVar = nVar.f1717y;
        yVar.f1794y = false;
        yVar.f1795z = false;
        yVar.F.f1579h = false;
        yVar.u(4);
        w wVar = this.f1611a;
        Bundle bundle3 = this.f1613c.f1701g;
        wVar.a(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (r1 >= ((java.util.ArrayList) r0.f1617f).size()) goto L_0x0057;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        r4 = (androidx.fragment.app.n) ((java.util.ArrayList) r0.f1617f).get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r4.I != r2) goto L_0x0035;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        r4 = r4.J;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
        if (r4 == null) goto L_0x0035;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        r3 = r2.indexOfChild(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r7 = this;
            androidx.fragment.app.e0 r0 = r7.f1612b
            androidx.fragment.app.n r1 = r7.f1613c
            r0.getClass()
            android.view.ViewGroup r2 = r1.I
            r3 = -1
            if (r2 != 0) goto L_0x000d
            goto L_0x0057
        L_0x000d:
            java.lang.Object r4 = r0.f1617f
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            int r1 = r4.indexOf(r1)
            int r4 = r1 + -1
        L_0x0017:
            if (r4 < 0) goto L_0x0035
            java.lang.Object r5 = r0.f1617f
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.n r5 = (androidx.fragment.app.n) r5
            android.view.ViewGroup r6 = r5.I
            if (r6 != r2) goto L_0x0032
            android.view.View r5 = r5.J
            if (r5 == 0) goto L_0x0032
            int r0 = r2.indexOfChild(r5)
            int r3 = r0 + 1
            goto L_0x0057
        L_0x0032:
            int r4 = r4 + -1
            goto L_0x0017
        L_0x0035:
            int r1 = r1 + 1
            java.lang.Object r4 = r0.f1617f
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            int r4 = r4.size()
            if (r1 >= r4) goto L_0x0057
            java.lang.Object r4 = r0.f1617f
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.lang.Object r4 = r4.get(r1)
            androidx.fragment.app.n r4 = (androidx.fragment.app.n) r4
            android.view.ViewGroup r5 = r4.I
            if (r5 != r2) goto L_0x0035
            android.view.View r4 = r4.J
            if (r4 == 0) goto L_0x0035
            int r3 = r2.indexOfChild(r4)
        L_0x0057:
            androidx.fragment.app.n r7 = r7.f1613c
            android.view.ViewGroup r0 = r7.I
            android.view.View r7 = r7.J
            r0.addView(r7, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d0.b():void");
    }

    public final void c() {
        if (x.K(3)) {
            StringBuilder d7 = h.d("moveto ATTACHED: ");
            d7.append(this.f1613c);
            Log.d("FragmentManager", d7.toString());
        }
        n nVar = this.f1613c;
        n nVar2 = nVar.f1706l;
        d0 d0Var = null;
        if (nVar2 != null) {
            d0 d0Var2 = (d0) ((HashMap) this.f1612b.f1618g).get(nVar2.f1704j);
            if (d0Var2 != null) {
                n nVar3 = this.f1613c;
                nVar3.m = nVar3.f1706l.f1704j;
                nVar3.f1706l = null;
                d0Var = d0Var2;
            } else {
                StringBuilder d8 = h.d("Fragment ");
                d8.append(this.f1613c);
                d8.append(" declared target fragment ");
                d8.append(this.f1613c.f1706l);
                d8.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(d8.toString());
            }
        } else {
            String str = nVar.m;
            if (str != null && (d0Var = (d0) ((HashMap) this.f1612b.f1618g).get(str)) == null) {
                StringBuilder d9 = h.d("Fragment ");
                d9.append(this.f1613c);
                d9.append(" declared target fragment ");
                throw new IllegalStateException(h.c(d9, this.f1613c.m, " that does not belong to this FragmentManager!"));
            }
        }
        if (d0Var != null) {
            d0Var.k();
        }
        n nVar4 = this.f1613c;
        x xVar = nVar4.f1715w;
        nVar4.f1716x = xVar.f1784n;
        nVar4.f1718z = xVar.f1786p;
        this.f1611a.g(false);
        n nVar5 = this.f1613c;
        Iterator<n.d> it = nVar5.U.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        nVar5.U.clear();
        nVar5.f1717y.c(nVar5.f1716x, nVar5.d(), nVar5);
        nVar5.f1700f = 0;
        nVar5.H = false;
        nVar5.s(nVar5.f1716x.f1765g);
        if (nVar5.H) {
            Iterator<b0> it2 = nVar5.f1715w.f1783l.iterator();
            while (it2.hasNext()) {
                it2.next().d();
            }
            y yVar = nVar5.f1717y;
            yVar.f1794y = false;
            yVar.f1795z = false;
            yVar.F.f1579h = false;
            yVar.u(0);
            this.f1611a.b(false);
            return;
        }
        throw new u0("Fragment " + nVar5 + " did not call through to super.onAttach()");
    }

    public final int d() {
        int i7;
        n nVar = this.f1613c;
        if (nVar.f1715w == null) {
            return nVar.f1700f;
        }
        int i8 = this.e;
        int ordinal = nVar.P.ordinal();
        boolean z6 = false;
        if (ordinal == 1) {
            i8 = Math.min(i8, 0);
        } else if (ordinal == 2) {
            i8 = Math.min(i8, 1);
        } else if (ordinal == 3) {
            i8 = Math.min(i8, 5);
        } else if (ordinal != 4) {
            i8 = Math.min(i8, -1);
        }
        n nVar2 = this.f1613c;
        if (nVar2.f1711r) {
            if (nVar2.s) {
                i8 = Math.max(this.e, 2);
                View view = this.f1613c.J;
                if (view != null && view.getParent() == null) {
                    i8 = Math.min(i8, 2);
                }
            } else {
                i8 = this.e < 4 ? Math.min(i8, nVar2.f1700f) : Math.min(i8, 1);
            }
        }
        if (!this.f1613c.f1709p) {
            i8 = Math.min(i8, 1);
        }
        n nVar3 = this.f1613c;
        ViewGroup viewGroup = nVar3.I;
        q0.b bVar = null;
        if (viewGroup != null) {
            q0 f7 = q0.f(viewGroup, nVar3.m().I());
            f7.getClass();
            q0.b d7 = f7.d(this.f1613c);
            i7 = d7 != null ? d7.f1749b : 0;
            n nVar4 = this.f1613c;
            Iterator<q0.b> it = f7.f1745c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q0.b next = it.next();
                if (next.f1750c.equals(nVar4) && !next.f1752f) {
                    bVar = next;
                    break;
                }
            }
            if (bVar != null && (i7 == 0 || i7 == 1)) {
                i7 = bVar.f1749b;
            }
        } else {
            i7 = 0;
        }
        if (i7 == 2) {
            i8 = Math.min(i8, 6);
        } else if (i7 == 3) {
            i8 = Math.max(i8, 3);
        } else {
            n nVar5 = this.f1613c;
            if (nVar5.f1710q) {
                if (nVar5.f1714v > 0) {
                    z6 = true;
                }
                i8 = z6 ? Math.min(i8, 1) : Math.min(i8, -1);
            }
        }
        n nVar6 = this.f1613c;
        if (nVar6.K && nVar6.f1700f < 5) {
            i8 = Math.min(i8, 4);
        }
        if (x.K(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i8 + " for " + this.f1613c);
        }
        return i8;
    }

    public final void e() {
        Parcelable parcelable;
        if (x.K(3)) {
            StringBuilder d7 = h.d("moveto CREATED: ");
            d7.append(this.f1613c);
            Log.d("FragmentManager", d7.toString());
        }
        n nVar = this.f1613c;
        if (!nVar.O) {
            this.f1611a.h(false);
            n nVar2 = this.f1613c;
            Bundle bundle = nVar2.f1701g;
            nVar2.f1717y.P();
            nVar2.f1700f = 1;
            nVar2.H = false;
            nVar2.Q.a(new l() { // from class: androidx.fragment.app.Fragment$5
                @Override // androidx.lifecycle.l
                public final void c(androidx.lifecycle.n nVar3, g.a aVar) {
                    View view;
                    if (aVar == g.a.ON_STOP && (view = n.this.J) != null) {
                        view.cancelPendingInputEvents();
                    }
                }
            });
            nVar2.T.b(bundle);
            nVar2.t(bundle);
            nVar2.O = true;
            if (nVar2.H) {
                nVar2.Q.f(g.a.ON_CREATE);
                w wVar = this.f1611a;
                Bundle bundle2 = this.f1613c.f1701g;
                wVar.c(false);
                return;
            }
            throw new u0("Fragment " + nVar2 + " did not call through to super.onCreate()");
        }
        Bundle bundle3 = nVar.f1701g;
        if (!(bundle3 == null || (parcelable = bundle3.getParcelable("android:support:fragments")) == null)) {
            nVar.f1717y.U(parcelable);
            nVar.f1717y.k();
        }
        this.f1613c.f1700f = 1;
    }

    public final void f() {
        String str;
        if (!this.f1613c.f1711r) {
            if (x.K(3)) {
                StringBuilder d7 = h.d("moveto CREATE_VIEW: ");
                d7.append(this.f1613c);
                Log.d("FragmentManager", d7.toString());
            }
            n nVar = this.f1613c;
            LayoutInflater y6 = nVar.y(nVar.f1701g);
            ViewGroup viewGroup = null;
            n nVar2 = this.f1613c;
            ViewGroup viewGroup2 = nVar2.I;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i7 = nVar2.B;
                if (i7 != 0) {
                    if (i7 != -1) {
                        viewGroup = (ViewGroup) nVar2.f1715w.f1785o.g(i7);
                        if (viewGroup == null) {
                            n nVar3 = this.f1613c;
                            if (!nVar3.f1712t) {
                                try {
                                    str = nVar3.L().getResources().getResourceName(this.f1613c.B);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                StringBuilder d8 = h.d("No view found for id 0x");
                                d8.append(Integer.toHexString(this.f1613c.B));
                                d8.append(" (");
                                d8.append(str);
                                d8.append(") for fragment ");
                                d8.append(this.f1613c);
                                throw new IllegalArgumentException(d8.toString());
                            }
                        }
                    } else {
                        StringBuilder d9 = h.d("Cannot create fragment ");
                        d9.append(this.f1613c);
                        d9.append(" for a container view with no id");
                        throw new IllegalArgumentException(d9.toString());
                    }
                }
            }
            n nVar4 = this.f1613c;
            nVar4.I = viewGroup;
            nVar4.E(y6, viewGroup, nVar4.f1701g);
            View view = this.f1613c.J;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                n nVar5 = this.f1613c;
                nVar5.J.setTag(2131296489, nVar5);
                if (viewGroup != null) {
                    b();
                }
                n nVar6 = this.f1613c;
                if (nVar6.D) {
                    nVar6.J.setVisibility(8);
                }
                View view2 = this.f1613c.J;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (y.g.b(view2)) {
                    y.h.c(this.f1613c.J);
                } else {
                    View view3 = this.f1613c.J;
                    view3.addOnAttachStateChangeListener(new a(view3));
                }
                this.f1613c.f1717y.u(2);
                w wVar = this.f1611a;
                View view4 = this.f1613c.J;
                wVar.m(false);
                int visibility = this.f1613c.J.getVisibility();
                this.f1613c.g().f1730l = this.f1613c.J.getAlpha();
                n nVar7 = this.f1613c;
                if (nVar7.I != null && visibility == 0) {
                    View findFocus = nVar7.J.findFocus();
                    if (findFocus != null) {
                        this.f1613c.g().m = findFocus;
                        if (x.K(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f1613c);
                        }
                    }
                    this.f1613c.J.setAlpha(0.0f);
                }
            }
            this.f1613c.f1700f = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d0.g():void");
    }

    public final void h() {
        View view;
        if (x.K(3)) {
            StringBuilder d7 = h.d("movefrom CREATE_VIEW: ");
            d7.append(this.f1613c);
            Log.d("FragmentManager", d7.toString());
        }
        n nVar = this.f1613c;
        ViewGroup viewGroup = nVar.I;
        if (!(viewGroup == null || (view = nVar.J) == null)) {
            viewGroup.removeView(view);
        }
        this.f1613c.F();
        this.f1611a.n(false);
        n nVar2 = this.f1613c;
        nVar2.I = null;
        nVar2.J = null;
        nVar2.R = null;
        nVar2.S.h(null);
        this.f1613c.s = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d0.i():void");
    }

    public final void j() {
        n nVar = this.f1613c;
        if (nVar.f1711r && nVar.s && !nVar.f1713u) {
            if (x.K(3)) {
                StringBuilder d7 = h.d("moveto CREATE_VIEW: ");
                d7.append(this.f1613c);
                Log.d("FragmentManager", d7.toString());
            }
            n nVar2 = this.f1613c;
            nVar2.E(nVar2.y(nVar2.f1701g), null, this.f1613c.f1701g);
            View view = this.f1613c.J;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                n nVar3 = this.f1613c;
                nVar3.J.setTag(2131296489, nVar3);
                n nVar4 = this.f1613c;
                if (nVar4.D) {
                    nVar4.J.setVisibility(8);
                }
                this.f1613c.f1717y.u(2);
                w wVar = this.f1611a;
                View view2 = this.f1613c.J;
                wVar.m(false);
                this.f1613c.f1700f = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f1614d) {
            try {
                this.f1614d = true;
                while (true) {
                    int d7 = d();
                    n nVar = this.f1613c;
                    int i7 = nVar.f1700f;
                    if (d7 == i7) {
                        if (nVar.N) {
                            if (!(nVar.J == null || (viewGroup = nVar.I) == null)) {
                                q0 f7 = q0.f(viewGroup, nVar.m().I());
                                if (this.f1613c.D) {
                                    f7.getClass();
                                    if (x.K(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + this.f1613c);
                                    }
                                    f7.a(3, 1, this);
                                } else {
                                    f7.getClass();
                                    if (x.K(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + this.f1613c);
                                    }
                                    f7.a(2, 1, this);
                                }
                            }
                            n nVar2 = this.f1613c;
                            x xVar = nVar2.f1715w;
                            if (xVar != null && nVar2.f1709p && x.L(nVar2)) {
                                xVar.f1793x = true;
                            }
                            this.f1613c.N = false;
                        }
                        return;
                    } else if (d7 > i7) {
                        switch (i7 + 1) {
                            case 0:
                                c();
                                continue;
                            case 1:
                                e();
                                continue;
                            case 2:
                                j();
                                f();
                                continue;
                            case 3:
                                a();
                                continue;
                            case 4:
                                if (!(nVar.J == null || (viewGroup2 = nVar.I) == null)) {
                                    q0 f8 = q0.f(viewGroup2, nVar.m().I());
                                    int c7 = s0.c(this.f1613c.J.getVisibility());
                                    f8.getClass();
                                    if (x.K(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + this.f1613c);
                                    }
                                    f8.a(c7, 2, this);
                                }
                                this.f1613c.f1700f = 4;
                                continue;
                            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                                p();
                                continue;
                            case 6:
                                nVar.f1700f = 6;
                                continue;
                            case 7:
                                n();
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        switch (i7 - 1) {
                            case SubsamplingScaleImageView.ORIENTATION_USE_EXIF /* -1 */:
                                i();
                                continue;
                            case 0:
                                g();
                                continue;
                            case 1:
                                h();
                                this.f1613c.f1700f = 1;
                                continue;
                            case 2:
                                nVar.s = false;
                                nVar.f1700f = 2;
                                continue;
                            case 3:
                                if (x.K(3)) {
                                    Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f1613c);
                                }
                                n nVar3 = this.f1613c;
                                if (nVar3.J != null && nVar3.f1702h == null) {
                                    o();
                                }
                                n nVar4 = this.f1613c;
                                if (!(nVar4.J == null || (viewGroup3 = nVar4.I) == null)) {
                                    q0 f9 = q0.f(viewGroup3, nVar4.m().I());
                                    f9.getClass();
                                    if (x.K(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + this.f1613c);
                                    }
                                    f9.a(1, 3, this);
                                }
                                this.f1613c.f1700f = 3;
                                continue;
                            case 4:
                                q();
                                continue;
                            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                                nVar.f1700f = 5;
                                continue;
                            case 6:
                                l();
                                continue;
                            default:
                                continue;
                        }
                    }
                }
            } finally {
                this.f1614d = false;
            }
        } else if (x.K(2)) {
            StringBuilder d8 = h.d("Ignoring re-entrant call to moveToExpectedState() for ");
            d8.append(this.f1613c);
            Log.v("FragmentManager", d8.toString());
        }
    }

    public final void l() {
        if (x.K(3)) {
            StringBuilder d7 = h.d("movefrom RESUMED: ");
            d7.append(this.f1613c);
            Log.d("FragmentManager", d7.toString());
        }
        n nVar = this.f1613c;
        nVar.f1717y.u(5);
        if (nVar.J != null) {
            nVar.R.d(g.a.ON_PAUSE);
        }
        nVar.Q.f(g.a.ON_PAUSE);
        nVar.f1700f = 6;
        nVar.H = true;
        this.f1611a.f(false);
    }

    public final void m(ClassLoader classLoader) {
        Bundle bundle = this.f1613c.f1701g;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            n nVar = this.f1613c;
            nVar.f1702h = nVar.f1701g.getSparseParcelableArray("android:view_state");
            n nVar2 = this.f1613c;
            nVar2.f1703i = nVar2.f1701g.getBundle("android:view_registry_state");
            n nVar3 = this.f1613c;
            nVar3.m = nVar3.f1701g.getString("android:target_state");
            n nVar4 = this.f1613c;
            if (nVar4.m != null) {
                nVar4.f1707n = nVar4.f1701g.getInt("android:target_req_state", 0);
            }
            n nVar5 = this.f1613c;
            nVar5.getClass();
            nVar5.L = nVar5.f1701g.getBoolean("android:user_visible_hint", true);
            n nVar6 = this.f1613c;
            if (!nVar6.L) {
                nVar6.K = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            r8 = this;
            r0 = 3
            boolean r0 = androidx.fragment.app.x.K(r0)
            java.lang.String r1 = "FragmentManager"
            if (r0 == 0) goto L_0x001b
            java.lang.String r0 = "moveto RESUMED: "
            java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
            androidx.fragment.app.n r2 = r8.f1613c
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L_0x001b:
            androidx.fragment.app.n r0 = r8.f1613c
            androidx.fragment.app.n$b r2 = r0.M
            r3 = 0
            if (r2 != 0) goto L_0x0024
            r2 = r3
            goto L_0x0026
        L_0x0024:
            android.view.View r2 = r2.m
        L_0x0026:
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x008d
            android.view.View r0 = r0.J
            if (r2 != r0) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            android.view.ViewParent r0 = r2.getParent()
        L_0x0033:
            if (r0 == 0) goto L_0x0042
            androidx.fragment.app.n r6 = r8.f1613c
            android.view.View r6 = r6.J
            if (r0 != r6) goto L_0x003d
        L_0x003b:
            r0 = r4
            goto L_0x0043
        L_0x003d:
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0033
        L_0x0042:
            r0 = r5
        L_0x0043:
            if (r0 == 0) goto L_0x008d
            boolean r0 = r2.requestFocus()
            r6 = 2
            boolean r6 = androidx.fragment.app.x.K(r6)
            if (r6 == 0) goto L_0x008d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "requestFocus: Restoring focused view "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = " "
            r6.append(r2)
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = "succeeded"
            goto L_0x0069
        L_0x0067:
            java.lang.String r0 = "failed"
        L_0x0069:
            r6.append(r0)
            java.lang.String r0 = " on Fragment "
            r6.append(r0)
            androidx.fragment.app.n r0 = r8.f1613c
            r6.append(r0)
            java.lang.String r0 = " resulting in focused view "
            r6.append(r0)
            androidx.fragment.app.n r0 = r8.f1613c
            android.view.View r0 = r0.J
            android.view.View r0 = r0.findFocus()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            android.util.Log.v(r1, r0)
        L_0x008d:
            androidx.fragment.app.n r0 = r8.f1613c
            androidx.fragment.app.n$b r0 = r0.g()
            r0.m = r3
            androidx.fragment.app.n r0 = r8.f1613c
            androidx.fragment.app.y r1 = r0.f1717y
            r1.P()
            androidx.fragment.app.y r1 = r0.f1717y
            r1.z(r4)
            r1 = 7
            r0.f1700f = r1
            r0.H = r4
            androidx.lifecycle.o r2 = r0.Q
            androidx.lifecycle.g$a r4 = androidx.lifecycle.g.a.ON_RESUME
            r2.f(r4)
            android.view.View r2 = r0.J
            if (r2 == 0) goto L_0x00b8
            androidx.fragment.app.m0 r2 = r0.R
            androidx.lifecycle.o r2 = r2.f1698g
            r2.f(r4)
        L_0x00b8:
            androidx.fragment.app.y r0 = r0.f1717y
            r0.f1794y = r5
            r0.f1795z = r5
            androidx.fragment.app.a0 r2 = r0.F
            r2.f1579h = r5
            r0.u(r1)
            androidx.fragment.app.w r0 = r8.f1611a
            r0.i(r5)
            androidx.fragment.app.n r8 = r8.f1613c
            r8.f1701g = r3
            r8.f1702h = r3
            r8.f1703i = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d0.n():void");
    }

    public final void o() {
        if (this.f1613c.J != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f1613c.J.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f1613c.f1702h = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f1613c.R.f1699h.c(bundle);
            if (!bundle.isEmpty()) {
                this.f1613c.f1703i = bundle;
            }
        }
    }

    public final void p() {
        if (x.K(3)) {
            StringBuilder d7 = h.d("moveto STARTED: ");
            d7.append(this.f1613c);
            Log.d("FragmentManager", d7.toString());
        }
        n nVar = this.f1613c;
        nVar.f1717y.P();
        nVar.f1717y.z(true);
        nVar.f1700f = 5;
        nVar.H = false;
        nVar.B();
        if (nVar.H) {
            o oVar = nVar.Q;
            g.a aVar = g.a.ON_START;
            oVar.f(aVar);
            if (nVar.J != null) {
                nVar.R.f1698g.f(aVar);
            }
            y yVar = nVar.f1717y;
            yVar.f1794y = false;
            yVar.f1795z = false;
            yVar.F.f1579h = false;
            yVar.u(5);
            this.f1611a.k(false);
            return;
        }
        throw new u0("Fragment " + nVar + " did not call through to super.onStart()");
    }

    public final void q() {
        if (x.K(3)) {
            StringBuilder d7 = h.d("movefrom STARTED: ");
            d7.append(this.f1613c);
            Log.d("FragmentManager", d7.toString());
        }
        n nVar = this.f1613c;
        y yVar = nVar.f1717y;
        yVar.f1795z = true;
        yVar.F.f1579h = true;
        yVar.u(4);
        if (nVar.J != null) {
            nVar.R.d(g.a.ON_STOP);
        }
        nVar.Q.f(g.a.ON_STOP);
        nVar.f1700f = 4;
        nVar.H = false;
        nVar.C();
        if (nVar.H) {
            this.f1611a.l(false);
            return;
        }
        throw new u0("Fragment " + nVar + " did not call through to super.onStop()");
    }
}
