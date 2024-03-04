package q2;

import a6.o;
import a6.u0;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.s0;
import c6.e;
import c6.q;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import d6.b0;
import d6.c0;
import d6.d0;
import d6.s;
import d6.y;
import g1.a;
import g5.p;
import g6.i;
import i5.e;
import i5.g;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import k4.f;
import p1.g0;
import p1.k0;
import p1.y;
import r0.n;
import r0.r;
import r5.h;
import r5.v;

/* loaded from: classes.dex */
public class a implements r, t2.a {

    /* renamed from: a */
    public static final Object[] f5641a = new Object[0];

    /* renamed from: b */
    public static final int[] f5642b = {2130903784, 2130903785, 2130903786, 2130903787, 2130903788, 2130904325, 2130904326, 2130904327, 2130904328, 2130904329, 2130904330, 2130904331, 2130904332, 2130904333, 2130904334, 2130904335, 2130904336, 2130904337, 2130904338};

    /* renamed from: c */
    public static final int[] f5643c = {2130903391, 2130903392, 2130903393, 2130903394, 2130903395, 2130903396, 2130903397, 2130903398, 2130903399, 2130903400, 2130903401, 2130903402, 2130903403, 2130903404, 2130903405, 2130903406};

    /* renamed from: d */
    public static a f5644d;

    public /* synthetic */ a() {
    }

    public /* synthetic */ a(Context context) {
        context.getApplicationContext();
    }

    public static final i5.d A(i5.d dVar) {
        h.f(dVar, "<this>");
        k5.c cVar = dVar instanceof k5.c ? (k5.c) dVar : null;
        if (cVar != null && (dVar = cVar.f4820h) == null) {
            e eVar = (e) cVar.a().e(e.a.f4486f);
            if (eVar == null || (dVar = eVar.K(cVar)) == null) {
                dVar = cVar;
            }
            cVar.f4820h = dVar;
        }
        return dVar;
    }

    public static final boolean B(Object obj) {
        return obj == a0.b.f25z;
    }

    public static boolean C(int i7) {
        boolean z6;
        if (i7 != 0) {
            ThreadLocal<double[]> threadLocal = i1.a.f4461a;
            double[] dArr = threadLocal.get();
            if (dArr == null) {
                dArr = new double[3];
                threadLocal.set(dArr);
            }
            int red = Color.red(i7);
            int green = Color.green(i7);
            int blue = Color.blue(i7);
            if (dArr.length != 3) {
                throw new IllegalArgumentException("outXyz must have a length of 3.");
            }
            double d7 = red / 255.0d;
            double pow = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            double d8 = green / 255.0d;
            double pow2 = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
            double d9 = blue / 255.0d;
            double pow3 = d9 < 0.04045d ? d9 / 12.92d : Math.pow((d9 + 0.055d) / 1.055d, 2.4d);
            z6 = false;
            dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * 100.0d;
            double d10 = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * 100.0d;
            dArr[1] = d10;
            dArr[2] = ((pow3 * 0.9505d) + (pow2 * 0.1192d) + (pow * 0.0193d)) * 100.0d;
            if (d10 / 100.0d > 0.5d) {
                return true;
            }
        } else {
            z6 = false;
        }
        return z6;
    }

    public static boolean D(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static final boolean E(char c7) {
        return Character.isWhitespace(c7) || Character.isSpaceChar(c7);
    }

    public static int F(int i7, int i8, float f7) {
        return i1.a.b(i1.a.c(i8, Math.round(Color.alpha(i8) * f7)), i7);
    }

    public static final List G(Object obj) {
        List singletonList = Collections.singletonList(obj);
        h.e(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static final List H(Object... objArr) {
        if (objArr.length > 0) {
            List asList = Arrays.asList(objArr);
            h.e(asList, "asList(...)");
            return asList;
        }
        return p.f4284f;
    }

    public static int I(int i7, String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return SubsamplingScaleImageView.TILE_SIZE_AUTO;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i7;
        }
    }

    public static void J(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long j5 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Animator animator = (Animator) arrayList.get(i7);
            j5 = Math.max(j5, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j5);
        arrayList.add(0, ofInt);
        animatorSet.playTogether(arrayList);
    }

    public static final int K(float f7) {
        if (Float.isNaN(f7)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f7);
    }

    public static void L(View view, f fVar) {
        a4.a aVar = fVar.f4720f.f4741b;
        if (aVar != null && aVar.f129a) {
            float f7 = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                f7 += y.i.i((View) parent);
            }
            f.b bVar = fVar.f4720f;
            if (bVar.m != f7) {
                bVar.m = f7;
                fVar.n();
            }
        }
    }

    public static int M(int i7, String str, String str2) {
        while (i7 < str.length() && str2.indexOf(str.charAt(i7)) == -1) {
            i7++;
        }
        return i7;
    }

    public static int N(int i7, String str) {
        char charAt;
        while (i7 < str.length() && ((charAt = str.charAt(i7)) == ' ' || charAt == '\t')) {
            i7++;
        }
        return i7;
    }

    public static final Object O(f6.r rVar, f6.r rVar2, q5.p pVar) {
        Object oVar;
        Object X;
        try {
            v.b(2, pVar);
            oVar = pVar.i(rVar2, rVar);
        } catch (Throwable th) {
            oVar = new o(th, false);
        }
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        if (oVar == aVar || (X = rVar.X(oVar)) == a0.e.f41h) {
            return aVar;
        }
        if (X instanceof o) {
            throw ((o) X).f324a;
        }
        return a0.e.J(X);
    }

    public static final d6.r P(s sVar, f6.c cVar, b0 b0Var, Float f7) {
        q.c cVar2;
        e6.f fVar;
        d6.c f8;
        c6.a aVar = c6.a.SUSPEND;
        c6.e.f2611b.getClass();
        int i7 = e.a.f2613b;
        if (1 >= i7) {
            i7 = 1;
        }
        int i8 = i7 - 1;
        if (!(sVar instanceof e6.f) || (f8 = (fVar = (e6.f) sVar).f()) == null) {
            cVar2 = new q.c(i8, g.f4488f, aVar, sVar);
        } else {
            int i9 = fVar.f3881g;
            if (i9 != -3 && i9 != -2 && i9 != 0) {
                i8 = i9;
            } else if (fVar.f3882h != aVar || i9 == 0) {
                i8 = 0;
            }
            cVar2 = new q.c(i8, fVar.f3880f, fVar.f3882h, f8);
        }
        d0 d0Var = new d0(f7 == null ? a0.e.Y : f7);
        return new d6.r(d0Var, a0.e.t(cVar, (i5.f) cVar2.f5600c, h.a(b0Var, y.a.f3756a) ? 1 : 4, new d6.o(b0Var, (d6.c) cVar2.f5598a, d0Var, f7, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long Q(java.lang.String r21, long r22, long r24, long r26) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.a.Q(java.lang.String, long, long, long):long");
    }

    public static int R(String str, int i7, int i8, int i9, int i10) {
        if ((i10 & 4) != 0) {
            i8 = 1;
        }
        if ((i10 & 8) != 0) {
            i9 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        return (int) Q(str, i7, i8, i9);
    }

    public static final Object[] S(Collection collection) {
        h.f(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    objArr[i7] = it.next();
                    if (i8 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i9 = ((i8 * 3) + 1) >>> 1;
                        if (i9 <= i8) {
                            if (i8 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                            i9 = 2147483645;
                        }
                        objArr = Arrays.copyOf(objArr, i9);
                        h.e(objArr, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i8);
                        h.e(copyOf, "copyOf(...)");
                        return copyOf;
                    }
                    i7 = i8;
                }
            }
        }
        return f5641a;
    }

    public static final Object[] T(Collection collection, Object[] objArr) {
        Object[] objArr2;
        h.f(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i7 = 0;
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            h.d(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i8 = i7 + 1;
            objArr2[i7] = it.next();
            if (i8 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i9 = ((i8 * 3) + 1) >>> 1;
                if (i9 <= i8) {
                    if (i8 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i9 = 2147483645;
                }
                objArr2 = Arrays.copyOf(objArr2, i9);
                h.e(objArr2, "copyOf(...)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i8] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i8);
                h.e(copyOf, "copyOf(...)");
                return copyOf;
            }
            i7 = i8;
        }
    }

    public static String U(int i7) {
        if (i7 == 0) {
            return "Normal";
        }
        return i7 == 1 ? "Italic" : "Invalid";
    }

    public static final void c(Throwable th, Throwable th2) {
        h.f(th, "<this>");
        h.f(th2, "exception");
        if (th != th2) {
            m5.b.f5094a.a(th, th2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:502:0x00f6, code lost:
        if (r5.f6497d == r6) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0185, code lost:
        if (r3 == r6) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x019b, code lost:
        if (r3 == r6) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:557:0x019d, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:558:0x019f, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x026e, code lost:
        if (r4.f6497d == r6) goto L147;
     */
    /* JADX WARN: Removed duplicated region for block: B:639:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:642:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:686:0x043c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:709:0x04a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:741:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:742:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:748:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:751:0x0534 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:755:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:757:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:758:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:760:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:761:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:765:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:769:0x0582 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:778:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:802:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:803:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:806:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:807:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:822:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:827:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:832:0x069c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:837:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:838:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:841:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:842:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:845:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:846:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:848:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:853:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:855:0x06d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:865:0x06f8 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:878:0x0576 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(y0.e r36, w0.d r37, java.util.ArrayList r38, int r39) {
        /*
            Method dump skipped, instructions count: 1798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.a.d(y0.e, w0.d, java.util.ArrayList, int):void");
    }

    public static final ArrayList e(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new g5.g(objArr, true));
    }

    public static final void f(View view) {
        h.f(view, "<this>");
        g0 g0Var = new g0(view, null);
        y5.e eVar = new y5.e();
        eVar.f6843i = p(eVar, eVar, g0Var);
        while (eVar.hasNext()) {
            View view2 = (View) eVar.next();
            v1.b bVar = (v1.b) view2.getTag(2131296722);
            if (bVar == null) {
                bVar = new v1.b();
                view2.setTag(2131296722, bVar);
            }
            for (int x3 = x(bVar.f6182a); -1 < x3; x3--) {
                bVar.f6182a.get(x3).a();
            }
        }
    }

    public static final void g(q qVar, Throwable th) {
        if (th != null) {
            r0 = th instanceof CancellationException ? (CancellationException) th : null;
            if (r0 == null) {
                r0 = new CancellationException("Channel was consumed, consumer had failed");
                r0.initCause(th);
            }
        }
        qVar.d(r0);
    }

    public static void h(String str, boolean z6) {
        if (!z6) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void i(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Argument must not be null");
        }
    }

    public static final void j(int i7) {
        if (!(i7 >= 1)) {
            throw new IllegalArgumentException(s0.g("Expected positive parallelism level, but got ", i7).toString());
        }
    }

    public static final void k() {
        if (10 <= new w5.c(2, 36).f6412g) {
            return;
        }
        throw new IllegalArgumentException("radix 10 was not in valid range " + new w5.c(2, 36));
    }

    public static final void l(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                c(th, th2);
            }
        }
    }

    public static final int m(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static Typeface n(String str, n nVar, int i7) {
        Typeface create;
        String str2;
        if ((i7 == 0) && h.a(nVar, n.f5701g)) {
            if (str == null || str.length() == 0) {
                create = Typeface.DEFAULT;
                str2 = "DEFAULT";
                h.e(create, str2);
                return create;
            }
        }
        create = Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), nVar.f5702f, i7 == 1);
        str2 = "create(\n            fami…ontStyle.Italic\n        )";
        h.e(create, str2);
        return create;
    }

    public static i o(int i7) {
        if (i7 != 0 && i7 == 1) {
            return new k4.d();
        }
        return new k4.h();
    }

    public static final i5.d p(Object obj, i5.d dVar, q5.p pVar) {
        h.f(pVar, "<this>");
        h.f(dVar, "completion");
        if (pVar instanceof k5.a) {
            return ((k5.a) pVar).p(obj, dVar);
        }
        i5.f a7 = dVar.a();
        return a7 == g.f4488f ? new Kotlin_1.b(obj, dVar, pVar) : new Kotlin_1.c(dVar, a7, pVar, obj);
    }

    public static final d6.c q(d6.c cVar) {
        if (cVar instanceof c0) {
            return cVar;
        }
        d6.h hVar = d6.h.f3697g;
        d6.g gVar = d6.g.f3696g;
        if (cVar instanceof d6.b) {
            d6.b bVar = (d6.b) cVar;
            if (bVar.f3662g == hVar && bVar.f3663h == gVar) {
                return cVar;
            }
        }
        return new d6.b(cVar);
    }

    public static final void r(i5.f fVar) {
        u0 u0Var = (u0) fVar.e(u0.b.f341f);
        if (u0Var != null && !u0Var.b()) {
            throw u0Var.G();
        }
    }

    public static final boolean s(char c7, char c8, boolean z6) {
        if (c7 == c8) {
            return true;
        }
        if (z6) {
            char upperCase = Character.toUpperCase(c7);
            char upperCase2 = Character.toUpperCase(c8);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0058, code lost:
        if (r5.a(r2, r0) == r1) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0082  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, q.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object t(d6.c0 r5, q5.p r6, i5.d r7) {
        /*
            boolean r0 = r7 instanceof d6.n
            if (r0 == 0) goto L13
            r0 = r7
            d6.n r0 = (d6.n) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            d6.n r0 = new d6.n
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f3720l
            j5.a r1 = Kotlin_1.a.f4591f
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            d6.m r5 = r0.f3719k
            r5.s r6 = r0.f3718j
            q5.p r0 = r0.f3717i
            f5.e.b(r7)     // Catch: e6.a -> L2d
            goto L64
        L2d:
            r7 = move-exception
            r4 = r7
            r7 = r6
            r6 = r0
            r0 = r4
            goto L5e
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            f5.e.b(r7)
            r5.s r7 = new r5.s
            r7.<init>()
            q.d r2 = a0.e.Y
            r7.f5927f = r2
            d6.m r2 = new d6.m
            r2.<init>(r6, r7)
            r0.f3717i = r6     // Catch: e6.a -> L5b
            r0.f3718j = r7     // Catch: e6.a -> L5b
            r0.f3719k = r2     // Catch: e6.a -> L5b
            r0.m = r3     // Catch: e6.a -> L5b
            java.lang.Object r5 = r5.a(r2, r0)     // Catch: e6.a -> L5b
            if (r5 != r1) goto L62
            goto L6a
        L5b:
            r5 = move-exception
            r0 = r5
            r5 = r2
        L5e:
            d6.d<?> r1 = r0.f3869f
            if (r1 != r5) goto L82
        L62:
            r0 = r6
            r6 = r7
        L64:
            T r1 = r6.f5927f
            q.d r5 = a0.e.Y
            if (r1 == r5) goto L6b
        L6a:
            return r1
        L6b:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Expected at least one element matching the predicate "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L82:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.a.t(d6.c0, q5.p, i5.d):java.lang.Object");
    }

    public static int u(Context context, int i7, int i8) {
        Integer num;
        int i9;
        TypedValue a7 = g4.b.a(context, i7);
        if (a7 != null) {
            int i10 = a7.resourceId;
            if (i10 != 0) {
                Object obj = g1.a.f4192a;
                i9 = a.d.a(context, i10);
            } else {
                i9 = a7.data;
            }
            num = Integer.valueOf(i9);
        } else {
            num = null;
        }
        return num != null ? num.intValue() : i8;
    }

    public static int v(View view, int i7) {
        Context context = view.getContext();
        TypedValue c7 = g4.b.c(i7, view.getContext(), view.getClass().getCanonicalName());
        int i8 = c7.resourceId;
        if (i8 != 0) {
            Object obj = g1.a.f4192a;
            return a.d.a(context, i8);
        }
        return c7.data;
    }

    public static final int w(long j5) {
        return (int) (j5 & 4294967295L);
    }

    public static final int x(List list) {
        h.f(list, "<this>");
        return list.size() - 1;
    }

    public static final f6.s y(Object obj) {
        if (obj != a0.b.f25z) {
            return (f6.s) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final void z(i5.f fVar, Throwable th) {
        Throwable runtimeException;
        for (a6.v vVar : f6.d.f4146a) {
            try {
                vVar.z(fVar, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    c(runtimeException, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, runtimeException);
            }
        }
        try {
            c(th, new f6.e(fVar));
        } catch (Throwable unused) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public File a(p2.f fVar) {
        return null;
    }

    public void b(p2.f fVar, r2.g gVar) {
    }
}
