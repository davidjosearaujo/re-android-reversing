package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.f0;
import androidx.fragment.app.n;
import androidx.fragment.app.x;
import com.davemorrissey.labs.subscaleview.R;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import linc.com.amplituda.ErrorCode;

/* loaded from: classes.dex */
public final class a extends f0 implements x.l {

    /* renamed from: p */
    public final x f1571p;

    /* renamed from: q */
    public boolean f1572q;

    /* renamed from: r */
    public int f1573r;

    public a(x xVar) {
        xVar.H();
        u<?> uVar = xVar.f1784n;
        if (uVar != null) {
            uVar.f1765g.getClassLoader();
        }
        this.f1573r = -1;
        this.f1571p = xVar;
    }

    @Override // androidx.fragment.app.x.l
    public final boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (x.K(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f1629g) {
            x xVar = this.f1571p;
            if (xVar.f1776d == null) {
                xVar.f1776d = new ArrayList<>();
            }
            xVar.f1776d.add(this);
            return true;
        }
        return true;
    }

    public final void c(int i7) {
        if (this.f1629g) {
            if (x.K(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i7);
            }
            int size = this.f1624a.size();
            for (int i8 = 0; i8 < size; i8++) {
                f0.a aVar = this.f1624a.get(i8);
                n nVar = aVar.f1638b;
                if (nVar != null) {
                    nVar.f1714v += i7;
                    if (x.K(2)) {
                        StringBuilder d7 = androidx.activity.h.d("Bump nesting of ");
                        d7.append(aVar.f1638b);
                        d7.append(" to ");
                        d7.append(aVar.f1638b.f1714v);
                        Log.v("FragmentManager", d7.toString());
                    }
                }
            }
        }
    }

    public final int d(boolean z6) {
        if (this.f1572q) {
            throw new IllegalStateException("commit already called");
        }
        if (x.K(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new n0());
            f("  ", printWriter, true);
            printWriter.close();
        }
        this.f1572q = true;
        this.f1573r = this.f1629g ? this.f1571p.f1780i.getAndIncrement() : -1;
        this.f1571p.x(this, z6);
        return this.f1573r;
    }

    public final void e(int i7, n nVar, String str, int i8) {
        Class<?> cls = nVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder d7 = androidx.activity.h.d("Fragment ");
            d7.append(cls.getCanonicalName());
            d7.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(d7.toString());
        }
        if (str != null) {
            String str2 = nVar.C;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + nVar + ": was " + nVar.C + " now " + str);
            }
            nVar.C = str;
        }
        if (i7 != 0) {
            if (i7 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + nVar + " with tag " + str + " to container view with no id");
            }
            int i9 = nVar.A;
            if (i9 != 0 && i9 != i7) {
                throw new IllegalStateException("Can't change container ID of fragment " + nVar + ": was " + nVar.A + " now " + i7);
            }
            nVar.A = i7;
            nVar.B = i7;
        }
        b(new f0.a(i8, nVar));
        nVar.f1715w = this.f1571p;
    }

    public final void f(String str, PrintWriter printWriter, boolean z6) {
        String str2;
        if (z6) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1630h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1573r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1572q);
            if (this.f1628f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1628f));
            }
            if (this.f1625b != 0 || this.f1626c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1625b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1626c));
            }
            if (this.f1627d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1627d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f1631i != 0 || this.f1632j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1631i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1632j);
            }
            if (this.f1633k != 0 || this.f1634l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1633k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1634l);
            }
        }
        if (this.f1624a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1624a.size();
        for (int i7 = 0; i7 < size; i7++) {
            f0.a aVar = this.f1624a.get(i7);
            switch (aVar.f1637a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    StringBuilder d7 = androidx.activity.h.d("cmd=");
                    d7.append(aVar.f1637a);
                    str2 = d7.toString();
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i7);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f1638b);
            if (z6) {
                if (aVar.f1639c != 0 || aVar.f1640d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1639c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1640d));
                }
                if (aVar.e != 0 || aVar.f1641f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1641f));
                }
            }
        }
    }

    public final void g() {
        x xVar;
        int size = this.f1624a.size();
        for (int i7 = 0; i7 < size; i7++) {
            f0.a aVar = this.f1624a.get(i7);
            n nVar = aVar.f1638b;
            if (nVar != null) {
                if (nVar.M != null) {
                    nVar.g().f1720a = false;
                }
                int i8 = this.f1628f;
                if (nVar.M != null || i8 != 0) {
                    nVar.g();
                    nVar.M.f1724f = i8;
                }
                ArrayList<String> arrayList = this.m;
                ArrayList<String> arrayList2 = this.f1635n;
                nVar.g();
                n.b bVar = nVar.M;
                bVar.f1725g = arrayList;
                bVar.f1726h = arrayList2;
            }
            switch (aVar.f1637a) {
                case 1:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.X(nVar, false);
                    this.f1571p.a(nVar);
                    continue;
                case 2:
                default:
                    StringBuilder d7 = androidx.activity.h.d("Unknown cmd: ");
                    d7.append(aVar.f1637a);
                    throw new IllegalArgumentException(d7.toString());
                case 3:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.S(nVar);
                    continue;
                case 4:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.J(nVar);
                    continue;
                case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.X(nVar, false);
                    this.f1571p.getClass();
                    x.b0(nVar);
                    continue;
                case 6:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.h(nVar);
                    continue;
                case 7:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.X(nVar, false);
                    this.f1571p.d(nVar);
                    continue;
                case 8:
                    xVar = this.f1571p;
                    break;
                case 9:
                    xVar = this.f1571p;
                    nVar = null;
                    break;
                case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                    this.f1571p.Y(nVar, aVar.f1643h);
                    continue;
            }
            xVar.Z(nVar);
        }
    }

    public final void h() {
        x xVar;
        for (int size = this.f1624a.size() - 1; size >= 0; size--) {
            f0.a aVar = this.f1624a.get(size);
            n nVar = aVar.f1638b;
            if (nVar != null) {
                if (nVar.M != null) {
                    nVar.g().f1720a = true;
                }
                int i7 = this.f1628f;
                int i8 = i7 != 4097 ? i7 != 4099 ? i7 != 8194 ? 0 : 4097 : 4099 : 8194;
                if (nVar.M != null || i8 != 0) {
                    nVar.g();
                    nVar.M.f1724f = i8;
                }
                ArrayList<String> arrayList = this.f1635n;
                ArrayList<String> arrayList2 = this.m;
                nVar.g();
                n.b bVar = nVar.M;
                bVar.f1725g = arrayList;
                bVar.f1726h = arrayList2;
            }
            switch (aVar.f1637a) {
                case 1:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.X(nVar, true);
                    this.f1571p.S(nVar);
                    continue;
                case 2:
                default:
                    StringBuilder d7 = androidx.activity.h.d("Unknown cmd: ");
                    d7.append(aVar.f1637a);
                    throw new IllegalArgumentException(d7.toString());
                case 3:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.a(nVar);
                    continue;
                case 4:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.getClass();
                    x.b0(nVar);
                    continue;
                case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.X(nVar, true);
                    this.f1571p.J(nVar);
                    continue;
                case 6:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.d(nVar);
                    continue;
                case 7:
                    nVar.N(aVar.f1639c, aVar.f1640d, aVar.e, aVar.f1641f);
                    this.f1571p.X(nVar, true);
                    this.f1571p.h(nVar);
                    continue;
                case 8:
                    xVar = this.f1571p;
                    nVar = null;
                    break;
                case 9:
                    xVar = this.f1571p;
                    break;
                case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                    this.f1571p.Y(nVar, aVar.f1642g);
                    continue;
            }
            xVar.Z(nVar);
        }
    }

    public final a i(n nVar) {
        x xVar = nVar.f1715w;
        if (xVar == null || xVar == this.f1571p) {
            b(new f0.a(3, nVar));
            return this;
        }
        StringBuilder d7 = androidx.activity.h.d("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        d7.append(nVar.toString());
        d7.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(d7.toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1573r >= 0) {
            sb.append(" #");
            sb.append(this.f1573r);
        }
        if (this.f1630h != null) {
            sb.append(" ");
            sb.append(this.f1630h);
        }
        sb.append("}");
        return sb.toString();
    }
}
