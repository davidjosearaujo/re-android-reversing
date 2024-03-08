package q2;

import a0.b;
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
import i5.d;
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
import k5.c;
import p1.g0;
import p1.k0;
import p1.y;
import r0.n;
import r0.r;
import r5.h;
import r5.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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

    public static final d A(d dVar) {
        h.f(dVar, "<this>");
        c cVar = dVar instanceof c ? (c) dVar : null;
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
        return obj == b.f25z;
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
            if (dArr.length == 3) {
                double d7 = ((double) red) / 255.0d;
                double pow = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
                double d8 = ((double) green) / 255.0d;
                double pow2 = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
                double d9 = ((double) blue) / 255.0d;
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
                throw new IllegalArgumentException("outXyz must have a length of 3.");
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
        return i1.a.b(i1.a.c(i8, Math.round(((float) Color.alpha(i8)) * f7)), i7);
    }

    public static final List G(Object obj) {
        List singletonList = Collections.singletonList(obj);
        h.e(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static final List H(Object... objArr) {
        if (objArr.length <= 0) {
            return p.f4284f;
        }
        List asList = Arrays.asList(objArr);
        h.e(asList, "asList(...)");
        return asList;
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
        long j7 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Animator animator = (Animator) arrayList.get(i7);
            j7 = Math.max(j7, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j7);
        arrayList.add(0, ofInt);
        animatorSet.playTogether(arrayList);
    }

    public static final int K(float f7) {
        if (!Float.isNaN(f7)) {
            return Math.round(f7);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
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
        Object obj;
        Object X;
        try {
            v.b(2, pVar);
            obj = pVar.i(rVar2, rVar);
        } catch (Throwable th) {
            obj = new o(th, false);
        }
        j5.a aVar = j5.a.f4591f;
        if (obj == aVar || (X = rVar.X(obj)) == a0.e.f41h) {
            return aVar;
        }
        if (!(X instanceof o)) {
            return a0.e.J(X);
        }
        throw ((o) X).f324a;
    }

    public static final d6.r P(s sVar, f6.c cVar, b0 b0Var, Float f7) {
        q.c cVar2;
        e6.f fVar;
        d6.c f8;
        c6.a aVar = c6.a.SUSPEND;
        c6.e.f2611b.getClass();
        int i7 = e.a.f2613b;
        int i8 = 1;
        if (1 >= i7) {
            i7 = 1;
        }
        int i9 = i7 - 1;
        if (!(sVar instanceof e6.f) || (f8 = (fVar = (e6.f) sVar).f()) == null) {
            cVar2 = new q.c(i9, g.f4488f, aVar, sVar);
        } else {
            int i10 = fVar.f3881g;
            i9 = 0;
            if (i10 != -3 && i10 != -2 && i10 != 0) {
                i9 = i10;
            } else if (fVar.f3882h != aVar || i10 == 0) {
            }
            cVar2 = new q.c(i9, fVar.f3880f, fVar.f3882h, f8);
        }
        d0 d0Var = new d0(f7 == null ? a0.e.Y : f7);
        i5.f fVar2 = (i5.f) cVar2.f5600c;
        d6.c cVar3 = (d6.c) cVar2.f5598a;
        if (!h.a(b0Var, y.a.f3756a)) {
            i8 = 4;
        }
        return new d6.r(d0Var, a0.e.t(cVar, fVar2, i8, new d6.o(b0Var, cVar3, d0Var, f7, null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long Q(java.lang.String r21, long r22, long r24, long r26) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
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
        return (int) Q(str, (long) i7, (long) i8, (long) i9);
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
                            if (i8 < 2147483645) {
                                i9 = 2147483645;
                            } else {
                                throw new OutOfMemoryError();
                            }
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
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
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
                            if (i8 < 2147483645) {
                                i9 = 2147483645;
                            } else {
                                throw new OutOfMemoryError();
                            }
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
            } else if (objArr.length <= 0) {
                return objArr;
            } else {
                objArr[0] = null;
                return objArr;
            }
        } else if (objArr.length <= 0) {
            return objArr;
        } else {
            objArr[0] = null;
            return objArr;
        }
    }

    public static String U(int i7) {
        boolean z6 = false;
        if (i7 == 0) {
            return "Normal";
        }
        if (i7 == 1) {
            z6 = true;
        }
        return z6 ? "Italic" : "Invalid";
    }

    public static final void c(Throwable th, Throwable th2) {
        h.f(th, "<this>");
        h.f(th2, "exception");
        if (th != th2) {
            m5.b.f5094a.a(th, th2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0185, code lost:
        if (r3 == r6) goto L_0x019d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x019b, code lost:
        if (r3 == r6) goto L_0x019d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x019d, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x019f, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x026e, code lost:
        if (r4.f6497d == r6) goto L_0x0272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f6, code lost:
        if (r5.f6497d == r6) goto L_0x00fa;
     */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x043c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0534 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0582 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x069c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x06d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06f8 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0576 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(y0.e r36, w0.d r37, java.util.ArrayList r38, int r39) {
        /*
            Method dump skipped, instructions count: 1798
            To view this dump add '--comments-level debug' option
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
            for (int x6 = x(bVar.f6182a); -1 < x6; x6--) {
                bVar.f6182a.get(x6).a();
            }
        }
    }

    public static final void g(q qVar, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = new CancellationException("Channel was consumed, consumer had failed");
                cancellationException.initCause(th);
            }
        }
        qVar.d(cancellationException);
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
        boolean z6 = true;
        if (i7 < 1) {
            z6 = false;
        }
        if (!z6) {
            throw new IllegalArgumentException(s0.g("Expected positive parallelism level, but got ", i7).toString());
        }
    }

    public static final void k() {
        if (!(10 <= new w5.c(2, 36).f6412g)) {
            throw new IllegalArgumentException("radix 10 was not in valid range " + new w5.c(2, 36));
        }
    }

    public static final void l(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
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
        String str2;
        Typeface typeface;
        boolean z6 = true;
        if ((i7 == 0) && h.a(nVar, n.f5701g)) {
            if (str == null || str.length() == 0) {
                typeface = Typeface.DEFAULT;
                str2 = "DEFAULT";
                h.e(typeface, str2);
                return typeface;
            }
        }
        Typeface create = str == null ? Typeface.DEFAULT : Typeface.create(str, 0);
        int i8 = nVar.f5702f;
        if (i7 != 1) {
            z6 = false;
        }
        typeface = Typeface.create(create, i8, z6);
        str2 = "create(\n            fami…ontStyle.Italic\n        )";
        h.e(typeface, str2);
        return typeface;
    }

    public static i o(int i7) {
        if (i7 != 0 && i7 == 1) {
            return new k4.d();
        }
        return new k4.h();
    }

    public static final d p(Object obj, d dVar, q5.p pVar) {
        h.f(pVar, "<this>");
        h.f(dVar, "completion");
        if (pVar instanceof k5.a) {
            return ((k5.a) pVar).p(obj, dVar);
        }
        i5.f a7 = dVar.a();
        return a7 == g.f4488f ? new j5.b(obj, dVar, pVar) : new j5.c(dVar, a7, pVar, obj);
    }

    public static final d6.c q(d6.c cVar) {
        if (cVar instanceof c0) {
            return cVar;
        }
        Object obj = d6.h.f3697g;
        d6.g gVar = d6.g.f3696g;
        if (cVar instanceof d6.b) {
            d6.b bVar = (d6.b) cVar;
            if (bVar.f3662g == obj && bVar.f3663h == gVar) {
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
        if (!z6) {
            return false;
        }
        char upperCase = Character.toUpperCase(c7);
        char upperCase2 = Character.toUpperCase(c8);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (r5.a(r2, r0) == r1) goto L_0x006a;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, q.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object t(d6.c0 r5, q5.p r6, i5.d r7) {
        /*
            boolean r0 = r7 instanceof d6.n
            if (r0 == 0) goto L_0x0013
            r0 = r7
            d6.n r0 = (d6.n) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.m = r1
            goto L_0x0018
        L_0x0013:
            d6.n r0 = new d6.n
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f3720l
            j5.a r1 = j5.a.f4591f
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            d6.m r5 = r0.f3719k
            r5.s r6 = r0.f3718j
            q5.p r0 = r0.f3717i
            f5.e.b(r7)     // Catch: a -> 0x002d
            goto L_0x0064
        L_0x002d:
            r7 = move-exception
            r4 = r7
            r7 = r6
            r6 = r0
            r0 = r4
            goto L_0x005e
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            f5.e.b(r7)
            r5.s r7 = new r5.s
            r7.<init>()
            q.d r2 = a0.e.Y
            r7.f5927f = r2
            d6.m r2 = new d6.m
            r2.<init>(r6, r7)
            r0.f3717i = r6     // Catch: a -> 0x005b
            r0.f3718j = r7     // Catch: a -> 0x005b
            r0.f3719k = r2     // Catch: a -> 0x005b
            r0.m = r3     // Catch: a -> 0x005b
            java.lang.Object r5 = r5.a(r2, r0)     // Catch: a -> 0x005b
            if (r5 != r1) goto L_0x0062
            goto L_0x006a
        L_0x005b:
            r5 = move-exception
            r0 = r5
            r5 = r2
        L_0x005e:
            d6.d<?> r1 = r0.f3869f
            if (r1 != r5) goto L_0x0082
        L_0x0062:
            r0 = r6
            r6 = r7
        L_0x0064:
            T r1 = r6.f5927f
            q.d r5 = a0.e.Y
            if (r1 == r5) goto L_0x006b
        L_0x006a:
            return r1
        L_0x006b:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Expected at least one element matching the predicate "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x0082:
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
        if (i8 == 0) {
            return c7.data;
        }
        Object obj = g1.a.f4192a;
        return a.d.a(context, i8);
    }

    public static final int w(long j7) {
        return (int) (j7 & 4294967295L);
    }

    public static final int x(List list) {
        h.f(list, "<this>");
        return list.size() - 1;
    }

    public static final f6.s y(Object obj) {
        if (obj != b.f25z) {
            return (f6.s) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final void z(i5.f fVar, Throwable th) {
        Throwable th2;
        for (a6.v vVar : f6.d.f4146a) {
            try {
                vVar.z(fVar, th);
            } catch (Throwable th3) {
                if (th == th3) {
                    th2 = th;
                } else {
                    th2 = new RuntimeException("Exception while trying to handle coroutine exception", th3);
                    c(th2, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
            }
        }
        try {
            c(th, new f6.e(fVar));
        } catch (Throwable unused) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    @Override // t2.a
    public File a(p2.f fVar) {
        return null;
    }

    @Override // t2.a
    public void b(p2.f fVar, r2.g gVar) {
    }
}
