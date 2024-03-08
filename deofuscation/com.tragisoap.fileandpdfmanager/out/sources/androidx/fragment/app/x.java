package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.n;
import androidx.fragment.app.f0;
import androidx.fragment.app.n;
import androidx.lifecycle.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import linc.com.amplituda.ErrorCode;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class x {
    public boolean A;
    public boolean B;
    public ArrayList<a> C;
    public ArrayList<Boolean> D;
    public ArrayList<n> E;
    public a0 F;

    /* renamed from: b */
    public boolean f1774b;

    /* renamed from: d */
    public ArrayList<a> f1776d;
    public ArrayList<n> e;

    /* renamed from: g */
    public OnBackPressedDispatcher f1778g;

    /* renamed from: n */
    public u<?> f1784n;

    /* renamed from: o */
    public androidx.activity.result.c f1785o;

    /* renamed from: p */
    public n f1786p;

    /* renamed from: q */
    public n f1787q;

    /* renamed from: t */
    public androidx.activity.result.e f1789t;

    /* renamed from: u */
    public androidx.activity.result.e f1790u;

    /* renamed from: v */
    public androidx.activity.result.e f1791v;

    /* renamed from: x */
    public boolean f1793x;

    /* renamed from: y */
    public boolean f1794y;

    /* renamed from: z */
    public boolean f1795z;

    /* renamed from: a */
    public final ArrayList<l> f1773a = new ArrayList<>();

    /* renamed from: c */
    public final e0 f1775c = new e0();

    /* renamed from: f */
    public final v f1777f = new v(this);

    /* renamed from: h */
    public final c f1779h = new c();

    /* renamed from: i */
    public final AtomicInteger f1780i = new AtomicInteger();

    /* renamed from: j */
    public final Map<String, Bundle> f1781j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k */
    public final w f1782k = new w(this);

    /* renamed from: l */
    public final CopyOnWriteArrayList<b0> f1783l = new CopyOnWriteArrayList<>();
    public int m = -1;

    /* renamed from: r */
    public e f1788r = new e();
    public f s = new f();

    /* renamed from: w */
    public ArrayDeque<k> f1792w = new ArrayDeque<>();
    public g G = new g();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements androidx.activity.result.b<androidx.activity.result.a> {
        public a() {
            x.this = r1;
        }

        @Override // androidx.activity.result.b
        public final void a(androidx.activity.result.a aVar) {
            String str;
            androidx.activity.result.a aVar2 = aVar;
            k pollFirst = x.this.f1792w.pollFirst();
            if (pollFirst == null) {
                str = "No IntentSenders were started for " + this;
            } else {
                String str2 = pollFirst.f1803f;
                int i7 = pollFirst.f1804g;
                n e = x.this.f1775c.e(str2);
                if (e == null) {
                    str = s0.h("Intent Sender result delivered for unknown Fragment ", str2);
                } else {
                    e.r(i7, aVar2.f439f, aVar2.f440g);
                    return;
                }
            }
            Log.w("FragmentManager", str);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements androidx.activity.result.b<Map<String, Boolean>> {
        public b() {
            x.this = r1;
        }

        @Override // androidx.activity.result.b
        @SuppressLint({"SyntheticAccessor"})
        public final void a(Map<String, Boolean> map) {
            String str;
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                iArr[i7] = ((Boolean) arrayList.get(i7)).booleanValue() ? 0 : -1;
            }
            k pollFirst = x.this.f1792w.pollFirst();
            if (pollFirst == null) {
                str = "No permissions were requested for " + this;
            } else {
                String str2 = pollFirst.f1803f;
                int i8 = pollFirst.f1804g;
                n e = x.this.f1775c.e(str2);
                if (e == null) {
                    str = s0.h("Permission request result delivered for unknown Fragment ", str2);
                } else {
                    e.z(i8, strArr, iArr);
                    return;
                }
            }
            Log.w("FragmentManager", str);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c extends n {
        public c() {
            x.this = r1;
        }

        @Override // androidx.activity.n
        public final void a() {
            x xVar = x.this;
            xVar.z(true);
            if (xVar.f1779h.f428a) {
                xVar.Q();
            } else {
                xVar.f1778g.b();
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d {
        public d(x xVar) {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e extends t {
        public e() {
            x.this = r1;
        }

        @Override // androidx.fragment.app.t
        public final n a(String str) {
            Context context = x.this.f1784n.f1765g;
            Object obj = n.V;
            try {
                return (n) t.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throw new n.c("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
            } catch (InstantiationException e7) {
                throw new n.c("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e7);
            } catch (NoSuchMethodException e8) {
                throw new n.c("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e8);
            } catch (InvocationTargetException e9) {
                throw new n.c("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e9);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class f implements t0 {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class g implements Runnable {
        public g() {
            x.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            x.this.z(true);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class h implements b0 {

        /* renamed from: f */
        public final /* synthetic */ n f1801f;

        public h(n nVar) {
            this.f1801f = nVar;
        }

        @Override // androidx.fragment.app.b0
        public final void d() {
            this.f1801f.getClass();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class i implements androidx.activity.result.b<androidx.activity.result.a> {
        public i() {
            x.this = r1;
        }

        @Override // androidx.activity.result.b
        public final void a(androidx.activity.result.a aVar) {
            String str;
            androidx.activity.result.a aVar2 = aVar;
            k pollFirst = x.this.f1792w.pollFirst();
            if (pollFirst == null) {
                str = "No Activities were started for result for " + this;
            } else {
                String str2 = pollFirst.f1803f;
                int i7 = pollFirst.f1804g;
                n e = x.this.f1775c.e(str2);
                if (e == null) {
                    str = s0.h("Activity result delivered for unknown Fragment ", str2);
                } else {
                    e.r(i7, aVar2.f439f, aVar2.f440g);
                    return;
                }
            }
            Log.w("FragmentManager", str);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class j extends d.a<androidx.activity.result.h, androidx.activity.result.a> {
        @Override // d.a
        public final Intent a(ComponentActivity componentActivity, Object obj) {
            Bundle bundleExtra;
            androidx.activity.result.h hVar = (androidx.activity.result.h) obj;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = hVar.f457g;
            if (!(intent2 == null || (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    IntentSender intentSender = hVar.f456f;
                    r5.h.f(intentSender, "intentSender");
                    hVar = new androidx.activity.result.h(intentSender, null, hVar.f458h, hVar.f459i);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", hVar);
            if (x.K(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // d.a
        public final Object c(Intent intent, int i7) {
            return new androidx.activity.result.a(intent, i7);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: f */
        public String f1803f;

        /* renamed from: g */
        public int f1804g;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Parcelable.Creator<k> {
            @Override // android.os.Parcelable.Creator
            public final k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final k[] newArray(int i7) {
                return new k[i7];
            }
        }

        public k() {
            throw null;
        }

        public k(Parcel parcel) {
            this.f1803f = parcel.readString();
            this.f1804g = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeString(this.f1803f);
            parcel.writeInt(this.f1804g);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface l {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class m implements l {

        /* renamed from: a */
        public final int f1805a;

        /* renamed from: b */
        public final int f1806b = 1;

        public m(int i7) {
            x.this = r1;
            this.f1805a = i7;
        }

        @Override // androidx.fragment.app.x.l
        public final boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            n nVar = x.this.f1787q;
            if (nVar == null || this.f1805a >= 0 || !nVar.h().Q()) {
                return x.this.R(arrayList, arrayList2, this.f1805a, this.f1806b);
            }
            return false;
        }
    }

    public x() {
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        new d(this);
    }

    public static boolean K(int i7) {
        return Log.isLoggable("FragmentManager", i7);
    }

    public static boolean L(n nVar) {
        nVar.getClass();
        Iterator it = nVar.f1717y.f1775c.g().iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            n nVar2 = (n) it.next();
            if (nVar2 != null) {
                z6 = L(nVar2);
                continue;
            }
            if (z6) {
                return true;
            }
        }
        return false;
    }

    public static boolean M(n nVar) {
        if (nVar == null) {
            return true;
        }
        return nVar.G && (nVar.f1715w == null || M(nVar.f1718z));
    }

    public static boolean N(n nVar) {
        if (nVar == null) {
            return true;
        }
        x xVar = nVar.f1715w;
        return nVar.equals(xVar.f1787q) && N(xVar.f1786p);
    }

    public static void b0(n nVar) {
        if (K(2)) {
            Log.v("FragmentManager", "show: " + nVar);
        }
        if (nVar.D) {
            nVar.D = false;
            nVar.N = !nVar.N;
        }
    }

    public final void A(l lVar, boolean z6) {
        if (!z6 || (this.f1784n != null && !this.A)) {
            y(z6);
            if (lVar.a(this.C, this.D)) {
                this.f1774b = true;
                try {
                    T(this.C, this.D);
                } finally {
                    e();
                }
            }
            d0();
            v();
            this.f1775c.c();
        }
    }

    public final void B(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i7, int i8) {
        ViewGroup viewGroup;
        int i9;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z6 = arrayList.get(i7).f1636o;
        ArrayList<n> arrayList4 = this.E;
        if (arrayList4 == null) {
            this.E = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.E.addAll(this.f1775c.h());
        n nVar = this.f1787q;
        int i10 = i7;
        boolean z7 = false;
        while (true) {
            int i11 = 1;
            if (i10 < i8) {
                a aVar = arrayList.get(i10);
                int i12 = 3;
                if (!arrayList3.get(i10).booleanValue()) {
                    ArrayList<n> arrayList5 = this.E;
                    int i13 = 0;
                    while (i13 < aVar.f1624a.size()) {
                        f0.a aVar2 = aVar.f1624a.get(i13);
                        int i14 = aVar2.f1637a;
                        if (i14 == i11) {
                            i9 = i11;
                        } else if (i14 != 2) {
                            if (i14 == i12 || i14 == 6) {
                                arrayList5.remove(aVar2.f1638b);
                                n nVar2 = aVar2.f1638b;
                                if (nVar2 == nVar) {
                                    aVar.f1624a.add(i13, new f0.a(9, nVar2));
                                    i13++;
                                    i9 = 1;
                                    nVar = null;
                                    i13 += i9;
                                    i11 = i9;
                                    i12 = 3;
                                }
                            } else if (i14 == 7) {
                                i9 = 1;
                            } else if (i14 == 8) {
                                aVar.f1624a.add(i13, new f0.a(9, nVar));
                                i13++;
                                nVar = aVar2.f1638b;
                            }
                            i9 = 1;
                            i13 += i9;
                            i11 = i9;
                            i12 = 3;
                        } else {
                            n nVar3 = aVar2.f1638b;
                            int i15 = nVar3.B;
                            boolean z8 = false;
                            for (int size = arrayList5.size() - 1; size >= 0; size--) {
                                n nVar4 = arrayList5.get(size);
                                if (nVar4.B != i15) {
                                    i15 = i15;
                                } else if (nVar4 == nVar3) {
                                    i15 = i15;
                                    z8 = true;
                                } else {
                                    if (nVar4 == nVar) {
                                        i15 = i15;
                                        aVar.f1624a.add(i13, new f0.a(9, nVar4));
                                        i13++;
                                        nVar = null;
                                    } else {
                                        i15 = i15;
                                    }
                                    f0.a aVar3 = new f0.a(3, nVar4);
                                    aVar3.f1639c = aVar2.f1639c;
                                    aVar3.e = aVar2.e;
                                    aVar3.f1640d = aVar2.f1640d;
                                    aVar3.f1641f = aVar2.f1641f;
                                    aVar.f1624a.add(i13, aVar3);
                                    arrayList5.remove(nVar4);
                                    i13++;
                                }
                            }
                            if (z8) {
                                aVar.f1624a.remove(i13);
                                i13--;
                                i9 = 1;
                                i13 += i9;
                                i11 = i9;
                                i12 = 3;
                            } else {
                                i9 = 1;
                                aVar2.f1637a = 1;
                                arrayList5.add(nVar3);
                                i13 += i9;
                                i11 = i9;
                                i12 = 3;
                            }
                        }
                        arrayList5.add(aVar2.f1638b);
                        i13 += i9;
                        i11 = i9;
                        i12 = 3;
                    }
                } else {
                    int i16 = 1;
                    ArrayList<n> arrayList6 = this.E;
                    int size2 = aVar.f1624a.size() - 1;
                    while (size2 >= 0) {
                        f0.a aVar4 = aVar.f1624a.get(size2);
                        int i17 = aVar4.f1637a;
                        if (i17 != i16) {
                            if (i17 != 3) {
                                switch (i17) {
                                    case 8:
                                        nVar = null;
                                        break;
                                    case 9:
                                        nVar = aVar4.f1638b;
                                        break;
                                    case ErrorCode.FRAME_ALLOC_CODE /* 10 */:
                                        aVar4.f1643h = aVar4.f1642g;
                                        break;
                                }
                                size2--;
                                i16 = 1;
                            }
                            arrayList6.add(aVar4.f1638b);
                            size2--;
                            i16 = 1;
                        }
                        arrayList6.remove(aVar4.f1638b);
                        size2--;
                        i16 = 1;
                    }
                }
                z7 = z7 || aVar.f1629g;
                i10++;
                arrayList3 = arrayList2;
            } else {
                this.E.clear();
                if (!z6 && this.m >= 1) {
                    for (int i18 = i7; i18 < i8; i18++) {
                        Iterator<f0.a> it = arrayList.get(i18).f1624a.iterator();
                        while (it.hasNext()) {
                            n nVar5 = it.next().f1638b;
                            if (!(nVar5 == null || nVar5.f1715w == null)) {
                                this.f1775c.i(g(nVar5));
                            }
                        }
                    }
                }
                for (int i19 = i7; i19 < i8; i19++) {
                    a aVar5 = arrayList.get(i19);
                    if (arrayList2.get(i19).booleanValue()) {
                        aVar5.c(-1);
                        aVar5.h();
                    } else {
                        aVar5.c(1);
                        aVar5.g();
                    }
                }
                boolean booleanValue = arrayList2.get(i8 - 1).booleanValue();
                for (int i20 = i7; i20 < i8; i20++) {
                    a aVar6 = arrayList.get(i20);
                    if (booleanValue) {
                        for (int size3 = aVar6.f1624a.size() - 1; size3 >= 0; size3--) {
                            n nVar6 = aVar6.f1624a.get(size3).f1638b;
                            if (nVar6 != null) {
                                g(nVar6).k();
                            }
                        }
                    } else {
                        Iterator<f0.a> it2 = aVar6.f1624a.iterator();
                        while (it2.hasNext()) {
                            n nVar7 = it2.next().f1638b;
                            if (nVar7 != null) {
                                g(nVar7).k();
                            }
                        }
                    }
                }
                O(this.m, true);
                HashSet hashSet = new HashSet();
                for (int i21 = i7; i21 < i8; i21++) {
                    Iterator<f0.a> it3 = arrayList.get(i21).f1624a.iterator();
                    while (it3.hasNext()) {
                        n nVar8 = it3.next().f1638b;
                        if (!(nVar8 == null || (viewGroup = nVar8.I) == null)) {
                            hashSet.add(q0.f(viewGroup, I()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    q0 q0Var = (q0) it4.next();
                    q0Var.f1746d = booleanValue;
                    q0Var.g();
                    q0Var.c();
                }
                for (int i22 = i7; i22 < i8; i22++) {
                    a aVar7 = arrayList.get(i22);
                    if (arrayList2.get(i22).booleanValue() && aVar7.f1573r >= 0) {
                        aVar7.f1573r = -1;
                    }
                    aVar7.getClass();
                }
                return;
            }
        }
    }

    public final void C(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
    }

    public final n D(String str) {
        return this.f1775c.d(str);
    }

    public final n E(int i7) {
        e0 e0Var = this.f1775c;
        int size = ((ArrayList) e0Var.f1617f).size();
        while (true) {
            size--;
            if (size >= 0) {
                n nVar = (n) ((ArrayList) e0Var.f1617f).get(size);
                if (nVar != null && nVar.A == i7) {
                    return nVar;
                }
            } else {
                for (d0 d0Var : ((HashMap) e0Var.f1618g).values()) {
                    if (d0Var != null) {
                        n nVar2 = d0Var.f1613c;
                        if (nVar2.A == i7) {
                            return nVar2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public final n F(String str) {
        e0 e0Var = this.f1775c;
        int size = ((ArrayList) e0Var.f1617f).size();
        while (true) {
            size--;
            if (size >= 0) {
                n nVar = (n) ((ArrayList) e0Var.f1617f).get(size);
                if (nVar != null && str.equals(nVar.C)) {
                    return nVar;
                }
            } else {
                for (d0 d0Var : ((HashMap) e0Var.f1618g).values()) {
                    if (d0Var != null) {
                        n nVar2 = d0Var.f1613c;
                        if (str.equals(nVar2.C)) {
                            return nVar2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public final ViewGroup G(n nVar) {
        ViewGroup viewGroup = nVar.I;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (nVar.B > 0 && this.f1785o.n()) {
            View g2 = this.f1785o.g(nVar.B);
            if (g2 instanceof ViewGroup) {
                return (ViewGroup) g2;
            }
        }
        return null;
    }

    public final t H() {
        n nVar = this.f1786p;
        return nVar != null ? nVar.f1715w.H() : this.f1788r;
    }

    public final t0 I() {
        n nVar = this.f1786p;
        return nVar != null ? nVar.f1715w.I() : this.s;
    }

    public final void J(n nVar) {
        if (K(2)) {
            Log.v("FragmentManager", "hide: " + nVar);
        }
        if (!nVar.D) {
            nVar.D = true;
            nVar.N = true ^ nVar.N;
            a0(nVar);
        }
    }

    public final void O(int i7, boolean z6) {
        u<?> uVar;
        if (this.f1784n == null && i7 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z6 || i7 != this.m) {
            this.m = i7;
            e0 e0Var = this.f1775c;
            Iterator it = ((ArrayList) e0Var.f1617f).iterator();
            while (it.hasNext()) {
                d0 d0Var = (d0) ((HashMap) e0Var.f1618g).get(((n) it.next()).f1704j);
                if (d0Var != null) {
                    d0Var.k();
                }
            }
            Iterator it2 = ((HashMap) e0Var.f1618g).values().iterator();
            while (true) {
                boolean z7 = false;
                if (!it2.hasNext()) {
                    break;
                }
                d0 d0Var2 = (d0) it2.next();
                if (d0Var2 != null) {
                    d0Var2.k();
                    n nVar = d0Var2.f1613c;
                    if (nVar.f1710q) {
                        if (!(nVar.f1714v > 0)) {
                            z7 = true;
                        }
                    }
                    if (z7) {
                        e0Var.j(d0Var2);
                    }
                }
            }
            c0();
            if (this.f1793x && (uVar = this.f1784n) != null && this.m == 7) {
                uVar.r();
                this.f1793x = false;
            }
        }
    }

    public final void P() {
        if (this.f1784n != null) {
            this.f1794y = false;
            this.f1795z = false;
            this.F.f1579h = false;
            for (n nVar : this.f1775c.h()) {
                if (nVar != null) {
                    nVar.f1717y.P();
                }
            }
        }
    }

    public final boolean Q() {
        z(false);
        y(true);
        n nVar = this.f1787q;
        if (nVar != null && nVar.h().Q()) {
            return true;
        }
        boolean R = R(this.C, this.D, -1, 0);
        if (R) {
            this.f1774b = true;
            try {
                T(this.C, this.D);
            } finally {
                e();
            }
        }
        d0();
        v();
        this.f1775c.c();
        return R;
    }

    public final boolean R(ArrayList arrayList, ArrayList arrayList2, int i7, int i8) {
        a aVar;
        ArrayList<a> arrayList3 = this.f1776d;
        if (arrayList3 == null) {
            return false;
        }
        if (i7 >= 0 || (i8 & 1) != 0) {
            int i9 = -1;
            if (i7 >= 0) {
                i9 = arrayList3.size() - 1;
                while (i9 >= 0) {
                    a aVar2 = this.f1776d.get(i9);
                    if (i7 >= 0 && i7 == aVar2.f1573r) {
                        break;
                    }
                    i9--;
                }
                if (i9 < 0) {
                    return false;
                }
                if ((i8 & 1) != 0) {
                    do {
                        i9--;
                        if (i9 < 0) {
                            break;
                        }
                        aVar = this.f1776d.get(i9);
                        if (i7 < 0) {
                            break;
                        }
                    } while (i7 == aVar.f1573r);
                }
            }
            if (i9 == this.f1776d.size() - 1) {
                return false;
            }
            for (int size = this.f1776d.size() - 1; size > i9; size--) {
                arrayList.add(this.f1776d.remove(size));
                arrayList2.add(Boolean.TRUE);
            }
        } else {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.f1776d.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void S(n nVar) {
        if (K(2)) {
            Log.v("FragmentManager", "remove: " + nVar + " nesting=" + nVar.f1714v);
        }
        boolean z6 = !(nVar.f1714v > 0);
        if (!nVar.E || z6) {
            e0 e0Var = this.f1775c;
            synchronized (((ArrayList) e0Var.f1617f)) {
                ((ArrayList) e0Var.f1617f).remove(nVar);
            }
            nVar.f1709p = false;
            if (L(nVar)) {
                this.f1793x = true;
            }
            nVar.f1710q = true;
            a0(nVar);
        }
    }

    public final void T(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                C(arrayList, arrayList2);
                int size = arrayList.size();
                int i7 = 0;
                int i8 = 0;
                while (i7 < size) {
                    if (!arrayList.get(i7).f1636o) {
                        if (i8 != i7) {
                            B(arrayList, arrayList2, i8, i7);
                        }
                        i8 = i7 + 1;
                        if (arrayList2.get(i7).booleanValue()) {
                            while (i8 < size && arrayList2.get(i8).booleanValue() && !arrayList.get(i8).f1636o) {
                                i8++;
                            }
                        }
                        B(arrayList, arrayList2, i7, i8);
                        i7 = i8 - 1;
                    }
                    i7++;
                }
                if (i8 != size) {
                    B(arrayList, arrayList2, i8, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public final void U(Parcelable parcelable) {
        int i7;
        d0 d0Var;
        if (parcelable != null) {
            z zVar = (z) parcelable;
            if (zVar.f1808f != null) {
                ((HashMap) this.f1775c.f1618g).clear();
                Iterator<c0> it = zVar.f1808f.iterator();
                while (it.hasNext()) {
                    c0 next = it.next();
                    if (next != null) {
                        n nVar = this.F.f1575c.get(next.f1596g);
                        if (nVar != null) {
                            if (K(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + nVar);
                            }
                            d0Var = new d0(this.f1782k, this.f1775c, nVar, next);
                        } else {
                            d0Var = new d0(this.f1782k, this.f1775c, this.f1784n.f1765g.getClassLoader(), H(), next);
                        }
                        n nVar2 = d0Var.f1613c;
                        nVar2.f1715w = this;
                        if (K(2)) {
                            StringBuilder d7 = androidx.activity.h.d("restoreSaveState: active (");
                            d7.append(nVar2.f1704j);
                            d7.append("): ");
                            d7.append(nVar2);
                            Log.v("FragmentManager", d7.toString());
                        }
                        d0Var.m(this.f1784n.f1765g.getClassLoader());
                        this.f1775c.i(d0Var);
                        d0Var.e = this.m;
                    }
                }
                a0 a0Var = this.F;
                a0Var.getClass();
                Iterator it2 = new ArrayList(a0Var.f1575c.values()).iterator();
                while (true) {
                    i7 = 0;
                    if (!it2.hasNext()) {
                        break;
                    }
                    n nVar3 = (n) it2.next();
                    if (((HashMap) this.f1775c.f1618g).get(nVar3.f1704j) != null) {
                        i7 = 1;
                    }
                    if (i7 == 0) {
                        if (K(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + nVar3 + " that was not found in the set of active Fragments " + zVar.f1808f);
                        }
                        this.F.c(nVar3);
                        nVar3.f1715w = this;
                        d0 d0Var2 = new d0(this.f1782k, this.f1775c, nVar3);
                        d0Var2.e = 1;
                        d0Var2.k();
                        nVar3.f1710q = true;
                        d0Var2.k();
                    }
                }
                e0 e0Var = this.f1775c;
                ArrayList<String> arrayList = zVar.f1809g;
                ((ArrayList) e0Var.f1617f).clear();
                if (arrayList != null) {
                    for (String str : arrayList) {
                        n d8 = e0Var.d(str);
                        if (d8 != null) {
                            if (K(2)) {
                                Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + d8);
                            }
                            e0Var.a(d8);
                        } else {
                            throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                        }
                    }
                }
                if (zVar.f1810h != null) {
                    this.f1776d = new ArrayList<>(zVar.f1810h.length);
                    int i8 = 0;
                    while (true) {
                        b[] bVarArr = zVar.f1810h;
                        if (i8 >= bVarArr.length) {
                            break;
                        }
                        b bVar = bVarArr[i8];
                        bVar.getClass();
                        a aVar = new a(this);
                        int i9 = 0;
                        int i10 = 0;
                        while (i9 < bVar.f1580f.length) {
                            f0.a aVar2 = new f0.a();
                            int i11 = i9 + 1;
                            aVar2.f1637a = bVar.f1580f[i9];
                            if (K(2)) {
                                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i10 + " base fragment #" + bVar.f1580f[i11]);
                            }
                            String str2 = bVar.f1581g.get(i10);
                            aVar2.f1638b = str2 != null ? D(str2) : null;
                            aVar2.f1642g = g.b.values()[bVar.f1582h[i10]];
                            aVar2.f1643h = g.b.values()[bVar.f1583i[i10]];
                            int[] iArr = bVar.f1580f;
                            int i12 = i11 + 1;
                            int i13 = iArr[i11];
                            aVar2.f1639c = i13;
                            int i14 = i12 + 1;
                            int i15 = iArr[i12];
                            aVar2.f1640d = i15;
                            int i16 = i14 + 1;
                            int i17 = iArr[i14];
                            aVar2.e = i17;
                            i9 = i16 + 1;
                            int i18 = iArr[i16];
                            aVar2.f1641f = i18;
                            aVar.f1625b = i13;
                            aVar.f1626c = i15;
                            aVar.f1627d = i17;
                            aVar.e = i18;
                            aVar.b(aVar2);
                            i10++;
                        }
                        aVar.f1628f = bVar.f1584j;
                        aVar.f1630h = bVar.f1585k;
                        aVar.f1573r = bVar.f1586l;
                        aVar.f1629g = true;
                        aVar.f1631i = bVar.m;
                        aVar.f1632j = bVar.f1587n;
                        aVar.f1633k = bVar.f1588o;
                        aVar.f1634l = bVar.f1589p;
                        aVar.m = bVar.f1590q;
                        aVar.f1635n = bVar.f1591r;
                        aVar.f1636o = bVar.s;
                        aVar.c(1);
                        if (K(2)) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i8 + " (index " + aVar.f1573r + "): " + aVar);
                            PrintWriter printWriter = new PrintWriter(new n0());
                            aVar.f("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f1776d.add(aVar);
                        i8++;
                    }
                } else {
                    this.f1776d = null;
                }
                this.f1780i.set(zVar.f1811i);
                String str3 = zVar.f1812j;
                if (str3 != null) {
                    n D = D(str3);
                    this.f1787q = D;
                    r(D);
                }
                ArrayList<String> arrayList2 = zVar.f1813k;
                if (arrayList2 != null) {
                    while (i7 < arrayList2.size()) {
                        Bundle bundle = zVar.f1814l.get(i7);
                        bundle.setClassLoader(this.f1784n.f1765g.getClassLoader());
                        this.f1781j.put(arrayList2.get(i7), bundle);
                        i7++;
                    }
                }
                this.f1792w = new ArrayDeque<>(zVar.m);
            }
        }
    }

    public final z V() {
        int i7;
        b[] bVarArr;
        ArrayList<String> arrayList;
        int size;
        Iterator it = f().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            q0 q0Var = (q0) it.next();
            if (q0Var.e) {
                q0Var.e = false;
                q0Var.c();
            }
        }
        Iterator it2 = f().iterator();
        while (it2.hasNext()) {
            ((q0) it2.next()).e();
        }
        z(true);
        this.f1794y = true;
        this.F.f1579h = true;
        e0 e0Var = this.f1775c;
        e0Var.getClass();
        ArrayList<c0> arrayList2 = new ArrayList<>(((HashMap) e0Var.f1618g).size());
        Iterator it3 = ((HashMap) e0Var.f1618g).values().iterator();
        while (true) {
            bVarArr = null;
            Bundle bundle = null;
            bVarArr = null;
            if (!it3.hasNext()) {
                break;
            }
            d0 d0Var = (d0) it3.next();
            if (d0Var != null) {
                n nVar = d0Var.f1613c;
                c0 c0Var = new c0(nVar);
                n nVar2 = d0Var.f1613c;
                if (nVar2.f1700f <= -1 || c0Var.f1606r != null) {
                    c0Var.f1606r = nVar2.f1701g;
                } else {
                    Bundle bundle2 = new Bundle();
                    n nVar3 = d0Var.f1613c;
                    nVar3.A(bundle2);
                    nVar3.T.c(bundle2);
                    z V = nVar3.f1717y.V();
                    if (V != null) {
                        bundle2.putParcelable("android:support:fragments", V);
                    }
                    d0Var.f1611a.j(false);
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                    if (d0Var.f1613c.J != null) {
                        d0Var.o();
                    }
                    if (d0Var.f1613c.f1702h != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", d0Var.f1613c.f1702h);
                    }
                    if (d0Var.f1613c.f1703i != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBundle("android:view_registry_state", d0Var.f1613c.f1703i);
                    }
                    if (!d0Var.f1613c.L) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", d0Var.f1613c.L);
                    }
                    c0Var.f1606r = bundle;
                    if (d0Var.f1613c.m != null) {
                        if (bundle == null) {
                            c0Var.f1606r = new Bundle();
                        }
                        c0Var.f1606r.putString("android:target_state", d0Var.f1613c.m);
                        int i8 = d0Var.f1613c.f1707n;
                        if (i8 != 0) {
                            c0Var.f1606r.putInt("android:target_req_state", i8);
                        }
                    }
                }
                arrayList2.add(c0Var);
                if (K(2)) {
                    Log.v("FragmentManager", "Saved state of " + nVar + ": " + c0Var.f1606r);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (K(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        e0 e0Var2 = this.f1775c;
        synchronized (((ArrayList) e0Var2.f1617f)) {
            if (((ArrayList) e0Var2.f1617f).isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(((ArrayList) e0Var2.f1617f).size());
                Iterator it4 = ((ArrayList) e0Var2.f1617f).iterator();
                while (it4.hasNext()) {
                    n nVar4 = (n) it4.next();
                    arrayList.add(nVar4.f1704j);
                    if (K(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + nVar4.f1704j + "): " + nVar4);
                    }
                }
            }
        }
        ArrayList<a> arrayList3 = this.f1776d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new b[size];
            for (i7 = 0; i7 < size; i7++) {
                bVarArr[i7] = new b(this.f1776d.get(i7));
                if (K(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i7 + ": " + this.f1776d.get(i7));
                }
            }
        }
        z zVar = new z();
        zVar.f1808f = arrayList2;
        zVar.f1809g = arrayList;
        zVar.f1810h = bVarArr;
        zVar.f1811i = this.f1780i.get();
        n nVar5 = this.f1787q;
        if (nVar5 != null) {
            zVar.f1812j = nVar5.f1704j;
        }
        zVar.f1813k.addAll(this.f1781j.keySet());
        zVar.f1814l.addAll(this.f1781j.values());
        zVar.m = new ArrayList<>(this.f1792w);
        return zVar;
    }

    public final void W() {
        synchronized (this.f1773a) {
            boolean z6 = false;
            if (this.f1773a.size() == 1) {
                z6 = true;
            }
            if (z6) {
                this.f1784n.f1766h.removeCallbacks(this.G);
                this.f1784n.f1766h.post(this.G);
                d0();
            }
        }
    }

    public final void X(n nVar, boolean z6) {
        ViewGroup G = G(nVar);
        if (G != null && (G instanceof FragmentContainerView)) {
            ((FragmentContainerView) G).setDrawDisappearingViewsLast(!z6);
        }
    }

    public final void Y(n nVar, g.b bVar) {
        if (!nVar.equals(D(nVar.f1704j)) || !(nVar.f1716x == null || nVar.f1715w == this)) {
            throw new IllegalArgumentException("Fragment " + nVar + " is not an active fragment of FragmentManager " + this);
        }
        nVar.P = bVar;
    }

    public final void Z(n nVar) {
        if (nVar == null || (nVar.equals(D(nVar.f1704j)) && (nVar.f1716x == null || nVar.f1715w == this))) {
            n nVar2 = this.f1787q;
            this.f1787q = nVar;
            r(nVar2);
            r(this.f1787q);
            return;
        }
        throw new IllegalArgumentException("Fragment " + nVar + " is not an active fragment of FragmentManager " + this);
    }

    public final d0 a(n nVar) {
        if (K(2)) {
            Log.v("FragmentManager", "add: " + nVar);
        }
        d0 g2 = g(nVar);
        nVar.f1715w = this;
        this.f1775c.i(g2);
        if (!nVar.E) {
            this.f1775c.a(nVar);
            nVar.f1710q = false;
            if (nVar.J == null) {
                nVar.N = false;
            }
            if (L(nVar)) {
                this.f1793x = true;
            }
        }
        return g2;
    }

    public final void a0(n nVar) {
        ViewGroup G = G(nVar);
        if (G != null) {
            n.b bVar = nVar.M;
            boolean z6 = false;
            if ((bVar == null ? 0 : bVar.e) + (bVar == null ? 0 : bVar.f1723d) + (bVar == null ? 0 : bVar.f1722c) + (bVar == null ? 0 : bVar.f1721b) > 0) {
                if (G.getTag(2131296920) == null) {
                    G.setTag(2131296920, nVar);
                }
                n nVar2 = (n) G.getTag(2131296920);
                n.b bVar2 = nVar.M;
                if (bVar2 != null) {
                    z6 = bVar2.f1720a;
                }
                if (nVar2.M != null) {
                    nVar2.g().f1720a = z6;
                }
            }
        }
    }

    public final void b(b0 b0Var) {
        this.f1783l.add(b0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(androidx.fragment.app.u<?> r3, androidx.activity.result.c r4, androidx.fragment.app.n r5) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.x.c(androidx.fragment.app.u, androidx.activity.result.c, androidx.fragment.app.n):void");
    }

    public final void c0() {
        Iterator it = this.f1775c.f().iterator();
        while (it.hasNext()) {
            d0 d0Var = (d0) it.next();
            n nVar = d0Var.f1613c;
            if (nVar.K) {
                if (this.f1774b) {
                    this.B = true;
                } else {
                    nVar.K = false;
                    d0Var.k();
                }
            }
        }
    }

    public final void d(n nVar) {
        if (K(2)) {
            Log.v("FragmentManager", "attach: " + nVar);
        }
        if (nVar.E) {
            nVar.E = false;
            if (!nVar.f1709p) {
                this.f1775c.a(nVar);
                if (K(2)) {
                    Log.v("FragmentManager", "add from attach: " + nVar);
                }
                if (L(nVar)) {
                    this.f1793x = true;
                }
            }
        }
    }

    public final void d0() {
        synchronized (this.f1773a) {
            try {
                boolean z6 = true;
                if (!this.f1773a.isEmpty()) {
                    c cVar = this.f1779h;
                    cVar.f428a = true;
                    q5.a<f5.g> aVar = cVar.f430c;
                    if (aVar != null) {
                        aVar.d();
                    }
                    return;
                }
                c cVar2 = this.f1779h;
                ArrayList<a> arrayList = this.f1776d;
                if ((arrayList != null ? arrayList.size() : 0) <= 0 || !N(this.f1786p)) {
                    z6 = false;
                }
                cVar2.f428a = z6;
                q5.a<f5.g> aVar2 = cVar2.f430c;
                if (aVar2 != null) {
                    aVar2.d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        this.f1774b = false;
        this.D.clear();
        this.C.clear();
    }

    public final HashSet f() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f1775c.f().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((d0) it.next()).f1613c.I;
            if (viewGroup != null) {
                hashSet.add(q0.f(viewGroup, I()));
            }
        }
        return hashSet;
    }

    public final d0 g(n nVar) {
        e0 e0Var = this.f1775c;
        d0 d0Var = (d0) ((HashMap) e0Var.f1618g).get(nVar.f1704j);
        if (d0Var != null) {
            return d0Var;
        }
        d0 d0Var2 = new d0(this.f1782k, this.f1775c, nVar);
        d0Var2.m(this.f1784n.f1765g.getClassLoader());
        d0Var2.e = this.m;
        return d0Var2;
    }

    public final void h(n nVar) {
        if (K(2)) {
            Log.v("FragmentManager", "detach: " + nVar);
        }
        if (!nVar.E) {
            nVar.E = true;
            if (nVar.f1709p) {
                if (K(2)) {
                    Log.v("FragmentManager", "remove from detach: " + nVar);
                }
                e0 e0Var = this.f1775c;
                synchronized (((ArrayList) e0Var.f1617f)) {
                    ((ArrayList) e0Var.f1617f).remove(nVar);
                }
                nVar.f1709p = false;
                if (L(nVar)) {
                    this.f1793x = true;
                }
                a0(nVar);
            }
        }
    }

    public final void i(Configuration configuration) {
        for (n nVar : this.f1775c.h()) {
            if (nVar != null) {
                nVar.onConfigurationChanged(configuration);
                nVar.f1717y.i(configuration);
            }
        }
    }

    public final boolean j() {
        if (this.m < 1) {
            return false;
        }
        for (n nVar : this.f1775c.h()) {
            if (nVar != null) {
                if (!nVar.D ? nVar.f1717y.j() : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void k() {
        this.f1794y = false;
        this.f1795z = false;
        this.F.f1579h = false;
        u(1);
    }

    public final boolean l() {
        if (this.m < 1) {
            return false;
        }
        ArrayList<n> arrayList = null;
        boolean z6 = false;
        for (n nVar : this.f1775c.h()) {
            if (nVar != null && M(nVar)) {
                if (!nVar.D ? nVar.f1717y.l() | false : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(nVar);
                    z6 = true;
                }
            }
        }
        if (this.e != null) {
            for (int i7 = 0; i7 < this.e.size(); i7++) {
                n nVar2 = this.e.get(i7);
                if (arrayList == null || !arrayList.contains(nVar2)) {
                    nVar2.getClass();
                }
            }
        }
        this.e = arrayList;
        return z6;
    }

    public final void m() {
        this.A = true;
        z(true);
        Iterator it = f().iterator();
        while (it.hasNext()) {
            ((q0) it.next()).e();
        }
        u(-1);
        this.f1784n = null;
        this.f1785o = null;
        this.f1786p = null;
        if (this.f1778g != null) {
            Iterator<androidx.activity.c> it2 = this.f1779h.f429b.iterator();
            while (it2.hasNext()) {
                it2.next().cancel();
            }
            this.f1778g = null;
        }
        androidx.activity.result.e eVar = this.f1789t;
        if (eVar != null) {
            eVar.f445g.f(eVar.f444f);
            androidx.activity.result.e eVar2 = this.f1790u;
            eVar2.f445g.f(eVar2.f444f);
            androidx.activity.result.e eVar3 = this.f1791v;
            eVar3.f445g.f(eVar3.f444f);
        }
    }

    public final void n() {
        for (n nVar : this.f1775c.h()) {
            if (nVar != null) {
                nVar.G();
            }
        }
    }

    public final void o(boolean z6) {
        for (n nVar : this.f1775c.h()) {
            if (nVar != null) {
                nVar.H(z6);
            }
        }
    }

    public final boolean p() {
        if (this.m < 1) {
            return false;
        }
        for (n nVar : this.f1775c.h()) {
            if (nVar != null) {
                if (!nVar.D ? nVar.f1717y.p() : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void q() {
        if (this.m >= 1) {
            for (n nVar : this.f1775c.h()) {
                if (nVar != null && !nVar.D) {
                    nVar.f1717y.q();
                }
            }
        }
    }

    public final void r(n nVar) {
        if (nVar != null && nVar.equals(D(nVar.f1704j))) {
            nVar.f1715w.getClass();
            boolean N = N(nVar);
            Boolean bool = nVar.f1708o;
            if (bool == null || bool.booleanValue() != N) {
                nVar.f1708o = Boolean.valueOf(N);
                y yVar = nVar.f1717y;
                yVar.d0();
                yVar.r(yVar.f1787q);
            }
        }
    }

    public final void s(boolean z6) {
        for (n nVar : this.f1775c.h()) {
            if (nVar != null) {
                nVar.I(z6);
            }
        }
    }

    public final boolean t() {
        boolean z6 = false;
        if (this.m < 1) {
            return false;
        }
        for (n nVar : this.f1775c.h()) {
            if (nVar != null && M(nVar) && nVar.J()) {
                z6 = true;
            }
        }
        return z6;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        n nVar = this.f1786p;
        if (nVar != null) {
            sb.append(nVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.f1786p;
        } else {
            u<?> uVar = this.f1784n;
            if (uVar != null) {
                sb.append(uVar.getClass().getSimpleName());
                sb.append("{");
                obj = this.f1784n;
            } else {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    /* JADX WARN: Finally extract failed */
    public final void u(int i7) {
        try {
            this.f1774b = true;
            for (d0 d0Var : ((HashMap) this.f1775c.f1618g).values()) {
                if (d0Var != null) {
                    d0Var.e = i7;
                }
            }
            O(i7, false);
            Iterator it = f().iterator();
            while (it.hasNext()) {
                ((q0) it.next()).e();
            }
            this.f1774b = false;
            z(true);
        } catch (Throwable th) {
            this.f1774b = false;
            throw th;
        }
    }

    public final void v() {
        if (this.B) {
            this.B = false;
            c0();
        }
    }

    public final void w(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String h7 = s0.h(str, "    ");
        e0 e0Var = this.f1775c;
        e0Var.getClass();
        String str2 = str + "    ";
        if (!((HashMap) e0Var.f1618g).isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (d0 d0Var : ((HashMap) e0Var.f1618g).values()) {
                printWriter.print(str);
                if (d0Var != null) {
                    n nVar = d0Var.f1613c;
                    printWriter.println(nVar);
                    nVar.e(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = ((ArrayList) e0Var.f1617f).size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i7 = 0; i7 < size3; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(((n) ((ArrayList) e0Var.f1617f).get(i7)).toString());
            }
        }
        ArrayList<n> arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i8 = 0; i8 < size2; i8++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i8);
                printWriter.print(": ");
                printWriter.println(this.e.get(i8).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f1776d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i9 = 0; i9 < size; i9++) {
                a aVar = this.f1776d.get(i9);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i9);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.f(h7, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f1780i.get());
        synchronized (this.f1773a) {
            int size4 = this.f1773a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i10 = 0; i10 < size4; i10++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i10);
                    printWriter.print(": ");
                    printWriter.println((l) this.f1773a.get(i10));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1784n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1785o);
        if (this.f1786p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1786p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1794y);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1795z);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.A);
        if (this.f1793x) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1793x);
        }
    }

    public final void x(l lVar, boolean z6) {
        if (!z6) {
            if (this.f1784n != null) {
                if (this.f1794y || this.f1795z) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
            } else if (this.A) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f1773a) {
            if (this.f1784n != null) {
                this.f1773a.add(lVar);
                W();
            } else if (!z6) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void y(boolean z6) {
        if (this.f1774b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f1784n == null) {
            if (this.A) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f1784n.f1766h.getLooper()) {
            if (!z6) {
                if (this.f1794y || this.f1795z) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
            }
            if (this.C == null) {
                this.C = new ArrayList<>();
                this.D = new ArrayList<>();
            }
            this.f1774b = false;
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* JADX WARN: Finally extract failed */
    public final boolean z(boolean z6) {
        boolean z7;
        y(z6);
        boolean z8 = false;
        while (true) {
            ArrayList<a> arrayList = this.C;
            ArrayList<Boolean> arrayList2 = this.D;
            synchronized (this.f1773a) {
                if (this.f1773a.isEmpty()) {
                    z7 = false;
                } else {
                    int size = this.f1773a.size();
                    z7 = false;
                    for (int i7 = 0; i7 < size; i7++) {
                        z7 |= this.f1773a.get(i7).a(arrayList, arrayList2);
                    }
                    this.f1773a.clear();
                    this.f1784n.f1766h.removeCallbacks(this.G);
                }
            }
            if (z7) {
                this.f1774b = true;
                try {
                    T(this.C, this.D);
                    e();
                    z8 = true;
                } catch (Throwable th) {
                    e();
                    throw th;
                }
            } else {
                d0();
                v();
                this.f1775c.c();
                return z8;
            }
        }
    }
}
