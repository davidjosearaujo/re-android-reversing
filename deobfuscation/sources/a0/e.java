package a0;

import a6.a1;
import a6.b1;
import a6.f0;
import a6.h0;
import a6.h1;
import a6.i1;
import a6.k0;
import a6.n1;
import a6.q0;
import a6.r0;
import a6.s;
import a6.x;
import android.app.AppOpsManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.cardview.widget.CardView;
import androidx.compose.ui.platform.p;
import androidx.fragment.app.s0;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.i;
import androidx.lifecycle.n;
import c0.f;
import c0.g;
import c0.h;
import c0.r;
import c0.t;
import f6.m;
import f6.v;
import i5.e;
import i5.f;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import l0.c0;
import l0.o;
import o0.q;
import r5.h;

/* loaded from: classes.dex */
public class e implements d3.b {

    /* renamed from: f */
    public static final q.d f37f = new q.d(4, "RESUME_TOKEN");

    /* renamed from: g */
    public static final q.d f39g = new q.d(4, "COMPLETING_ALREADY");

    /* renamed from: h */
    public static final q.d f41h = new q.d(4, "COMPLETING_WAITING_CHILDREN");

    /* renamed from: i */
    public static final q.d f43i = new q.d(4, "COMPLETING_RETRY");

    /* renamed from: j */
    public static final q.d f45j = new q.d(4, "TOO_LATE_TO_CANCEL");

    /* renamed from: k */
    public static final q.d f46k = new q.d(4, "SEALED");

    /* renamed from: l */
    public static final k0 f47l = new k0(false);
    public static final k0 m = new k0(true);

    /* renamed from: n */
    public static final e f48n = new e();

    /* renamed from: o */
    public static final int[] f49o = {16842755, 16842960, 16842961};

    /* renamed from: p */
    public static final int[] f50p = {16842755, 16842961};

    /* renamed from: q */
    public static final t f51q = new t(0.31006f, 0.31616f);

    /* renamed from: r */
    public static final t f52r = new t(0.34567f, 0.3585f);
    public static final t s = new t(0.32168f, 0.33767f);

    /* renamed from: t */
    public static final t f53t = new t(0.31271f, 0.32902f);

    /* renamed from: u */
    public static final float[] f54u = {0.964212f, 1.0f, 0.825188f};

    /* renamed from: v */
    public static final e f55v = new e();

    /* renamed from: w */
    public static final int[] f56w = {2130903112, 2130903119, 2130903120, 2130903356, 2130903357, 2130903358, 2130903359, 2130903360, 2130903361, 2130903418, 2130903437, 2130903438, 2130903470, 2130903593, 2130903601, 2130903607, 2130903608, 2130903612, 2130903629, 2130903651, 2130903776, 2130903912, 2130903988, 2130903995, 2130903996, 2130904116, 2130904120, 2130904254, 2130904268};

    /* renamed from: x */
    public static final int[] f57x = {16842931};

    /* renamed from: y */
    public static final int[] f58y = {16843071};

    /* renamed from: z */
    public static final int[] f59z = {2130903112, 2130903119, 2130903272, 2130903593, 2130904120, 2130904268};
    public static final int[] A = {16842994, 2130903187, 2130903190, 2130903765, 2130903766, 2130903908, 2130904059, 2130904067};
    public static final int[] B = {16843033, 2130904086, 2130904251, 2130904252};
    public static final int[] C = {16843074, 2130904244, 2130904245, 2130904246};
    public static final int[] D = {16842804, 16843117, 16843118, 16843119, 16843120, 16843666, 16843667};
    public static final int[] E = {16842804, 2130903105, 2130903106, 2130903107, 2130903108, 2130903109, 2130903450, 2130903451, 2130903452, 2130903453, 2130903455, 2130903456, 2130903457, 2130903458, 2130903474, 2130903535, 2130903571, 2130903580, 2130903679, 2130903758, 2130904162, 2130904217};
    public static final int[] F = {16842839, 16842926, 2130903042, 2130903043, 2130903044, 2130903045, 2130903046, 2130903047, 2130903048, 2130903049, 2130903050, 2130903051, 2130903052, 2130903053, 2130903054, 2130903056, 2130903057, 2130903058, 2130903059, 2130903060, 2130903061, 2130903062, 2130903063, 2130903064, 2130903065, 2130903066, 2130903067, 2130903068, 2130903069, 2130903070, 2130903071, 2130903072, 2130903073, 2130903074, 2130903079, 2130903081, 2130903082, 2130903083, 2130903084, 2130903103, 2130903160, 2130903179, 2130903180, 2130903181, 2130903182, 2130903183, 2130903191, 2130903192, 2130903219, 2130903230, 2130903285, 2130903286, 2130903287, 2130903289, 2130903290, 2130903291, 2130903292, 2130903317, 2130903319, 2130903340, 2130903371, 2130903434, 2130903435, 2130903436, 2130903440, 2130903445, 2130903463, 2130903464, 2130903467, 2130903468, 2130903469, 2130903607, 2130903623, 2130903761, 2130903762, 2130903763, 2130903764, 2130903767, 2130903768, 2130903769, 2130903770, 2130903771, 2130903772, 2130903773, 2130903774, 2130903775, 2130903940, 2130903941, 2130903942, 2130903987, 2130903989, 2130904004, 2130904006, 2130904007, 2130904008, 2130904032, 2130904033, 2130904034, 2130904035, 2130904077, 2130904078, 2130904127, 2130904185, 2130904187, 2130904188, 2130904189, 2130904191, 2130904192, 2130904193, 2130904194, 2130904205, 2130904206, 2130904271, 2130904272, 2130904274, 2130904275, 2130904311, 2130904339, 2130904340, 2130904341, 2130904342, 2130904343, 2130904344, 2130904345, 2130904346, 2130904347, 2130904348};
    public static final int[] G = {2130903085};
    public static final int[] H = {16843016, 2130903216, 2130903217, 2130903218};
    public static final int[] I = {16843015, 2130903184, 2130903193, 2130903194};
    public static final int[] J = {16842927, 16842948, 16843046, 16843047, 16843048, 2130903438, 2130903443, 2130903846, 2130904055};
    public static final int[] K = {16843436, 16843437};
    public static final int[] L = {16842766, 16842960, 16843156, 16843230, 16843231, 16843232};
    public static final int[] M = {16842754, 16842766, 16842960, 16843014, 16843156, 16843230, 16843231, 16843233, 16843234, 16843235, 16843236, 16843237, 16843375, 2130903055, 2130903075, 2130903077, 2130903087, 2130903355, 2130903618, 2130903619, 2130903919, 2130904053, 2130904277};
    public static final int[] N = {16842926, 16843052, 16843053, 16843054, 16843055, 16843056, 16843057, 2130903993, 2130904110};
    public static final int[] O = {16843126, 16843465, 2130903928};
    public static final int[] P = {2130903930, 2130903937};
    public static final int[] Q = {16842804, 16842970, 16843039, 16843087, 16843088, 16843296, 16843364, 2130903090, 2130903091, 2130903104, 2130903111, 2130903121, 2130903265, 2130903345, 2130903428, 2130903588, 2130903592, 2130903600, 2130903620, 2130903681, 2130904000, 2130904001, 2130904029, 2130904030, 2130904031, 2130904115, 2130904124, 2130904306, 2130904317};
    public static final int[] R = {16842930, 16843126, 16843131, 16843362, 2130903988};
    public static final int[] S = {16842901, 16842902, 16842903, 16842904, 16842906, 16842907, 16843105, 16843106, 16843107, 16843108, 16843692, 16844165, 2130903571, 2130903580, 2130904162, 2130904217};
    public static final int[] T = {16842927, 16843072, 2130903185, 2130903273, 2130903274, 2130903356, 2130903357, 2130903358, 2130903359, 2130903360, 2130903361, 2130903776, 2130903778, 2130903838, 2130903847, 2130903909, 2130903910, 2130903988, 2130904116, 2130904118, 2130904119, 2130904254, 2130904258, 2130904259, 2130904260, 2130904261, 2130904262, 2130904263, 2130904265, 2130904266};
    public static final int[] U = {16842752, 16842970, 2130903932, 2130903935, 2130904227};
    public static final int[] V = {16842964, 2130903121, 2130903122};
    public static final int[] W = {16842960, 16842994, 16842995};
    public static final i5.d[] X = new i5.d[0];
    public static final q.d Y = new q.d(4, "NULL");
    public static final e Z = new e();

    /* renamed from: a0 */
    public static final q.d f32a0 = new q.d(4, "NO_DECISION");

    /* renamed from: b0 */
    public static final q.d f33b0 = new q.d(4, "CONDITION_FALSE");

    /* renamed from: c0 */
    public static final int[] f34c0 = {16842948, 16842987, 16842993, 2130903527, 2130903528, 2130903529, 2130903530, 2130903531, 2130903684, 2130904019, 2130904075, 2130904087};

    /* renamed from: d0 */
    public static final q.d f35d0 = new q.d(4, "STATE_REG");

    /* renamed from: e0 */
    public static final q.d f36e0 = new q.d(4, "STATE_COMPLETED");

    /* renamed from: f0 */
    public static final q.d f38f0 = new q.d(4, "STATE_CANCELLED");

    /* renamed from: g0 */
    public static final byte[] f40g0 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: h0 */
    public static final t0.d f42h0 = new t0.d(1.0f, 1.0f);

    /* renamed from: i0 */
    public static final int[] f44i0 = {16843071, 16843072, 2130903195, 2130903196, 2130903197, 2130903199, 2130903200, 2130903201, 2130903362, 2130903363, 2130903365, 2130903366, 2130903368};

    public /* synthetic */ e() {
    }

    public /* synthetic */ e(int i7) {
    }

    public /* synthetic */ e(p pVar) {
    }

    public static int A(InputStream inputStream) {
        return (int) z(inputStream, 2);
    }

    public static final c0 B(o oVar) {
        h.f(oVar, "<this>");
        oVar.getClass();
        throw new IllegalStateException("LayoutNode should be attached to an owner".toString());
    }

    public static boolean C(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r6.e(r1) == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        r6 = r6.s(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
        if (r6.e(r1) == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object D(a6.b1 r6, q5.p r7) {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            i5.e$a r1 = i5.e.a.f4486f
            i5.f$b r2 = r6.e(r1)
            i5.e r2 = (i5.e) r2
            r3 = 1
            if (r2 != 0) goto L28
            a6.l0 r2 = a6.k1.a()
            i5.f r6 = i5.f.a.a(r6, r2)
            i5.g r4 = i5.g.f4488f
            i5.f r6 = a6.s.a(r4, r6, r3)
            g6.c r4 = a6.h0.f297a
            if (r6 == r4) goto L4a
            i5.f$b r1 = r6.e(r1)
            if (r1 != 0) goto L4a
            goto L46
        L28:
            boolean r4 = r2 instanceof a6.l0
            if (r4 == 0) goto L2e
            a6.l0 r2 = (a6.l0) r2
        L2e:
            java.lang.ThreadLocal<a6.l0> r2 = a6.k1.f304a
            java.lang.Object r2 = r2.get()
            a6.l0 r2 = (a6.l0) r2
            i5.g r4 = i5.g.f4488f
            i5.f r6 = a6.s.a(r4, r6, r3)
            g6.c r4 = a6.h0.f297a
            if (r6 == r4) goto L4a
            i5.f$b r1 = r6.e(r1)
            if (r1 != 0) goto L4a
        L46:
            i5.f r6 = r6.s(r4)
        L4a:
            a6.c r1 = new a6.c
            r1.<init>(r6, r0, r2)
            r1.l0(r3, r1, r7)
            a6.l0 r6 = r1.f286j     // Catch: java.lang.Throwable -> Lb2
            r7 = 0
            if (r6 == 0) goto L5c
            int r0 = a6.l0.f306k     // Catch: java.lang.Throwable -> Lb2
            r6.Y(r7)     // Catch: java.lang.Throwable -> Lb2
        L5c:
            boolean r6 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L9d
            if (r6 != 0) goto L9f
            a6.l0 r6 = r1.f286j     // Catch: java.lang.Throwable -> L9d
            if (r6 == 0) goto L6b
            long r4 = r6.a0()     // Catch: java.lang.Throwable -> L9d
            goto L70
        L6b:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L70:
            java.lang.Object r6 = r1.Q()     // Catch: java.lang.Throwable -> L9d
            boolean r6 = r6 instanceof a6.q0     // Catch: java.lang.Throwable -> L9d
            r6 = r6 ^ r3
            if (r6 != 0) goto L7d
            java.util.concurrent.locks.LockSupport.parkNanos(r1, r4)     // Catch: java.lang.Throwable -> L9d
            goto L5c
        L7d:
            a6.l0 r6 = r1.f286j     // Catch: java.lang.Throwable -> Lb2
            if (r6 == 0) goto L86
            int r0 = a6.l0.f306k     // Catch: java.lang.Throwable -> Lb2
            r6.W(r7)     // Catch: java.lang.Throwable -> Lb2
        L86:
            java.lang.Object r6 = r1.Q()
            java.lang.Object r6 = J(r6)
            boolean r7 = r6 instanceof a6.o
            if (r7 == 0) goto L96
            r7 = r6
            a6.o r7 = (a6.o) r7
            goto L97
        L96:
            r7 = 0
        L97:
            if (r7 != 0) goto L9a
            return r6
        L9a:
            java.lang.Throwable r6 = r7.f324a
            throw r6
        L9d:
            r6 = move-exception
            goto La8
        L9f:
            java.lang.InterruptedException r6 = new java.lang.InterruptedException     // Catch: java.lang.Throwable -> L9d
            r6.<init>()     // Catch: java.lang.Throwable -> L9d
            r1.x(r6)     // Catch: java.lang.Throwable -> L9d
            throw r6     // Catch: java.lang.Throwable -> L9d
        La8:
            a6.l0 r0 = r1.f286j     // Catch: java.lang.Throwable -> Lb2
            if (r0 == 0) goto Lb1
            int r1 = a6.l0.f306k     // Catch: java.lang.Throwable -> Lb2
            r0.W(r7)     // Catch: java.lang.Throwable -> Lb2
        Lb1:
            throw r6     // Catch: java.lang.Throwable -> Lb2
        Lb2:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.e.D(a6.b1, q5.p):java.lang.Object");
    }

    public static final int F(long j5) {
        c0.h bVar;
        r rVar = f.f2472c;
        int i7 = Graphics_1.f.f2343d;
        h.f(rVar, "colorSpace");
        c0.c cVar = f.f2474f[(int) (63 & j5)];
        if (!h.a(rVar, cVar)) {
            h.f(cVar, "$this$connect");
            if (cVar == rVar) {
                bVar = c0.h.e;
            } else if (cVar == f.e) {
                bVar = c0.h.f2475f;
            } else if (cVar == rVar) {
                g gVar = c0.h.e;
                bVar = new g(cVar);
            } else {
                long j7 = cVar.f2467b;
                long j8 = c0.b.f2462a;
                bVar = (c0.b.a(j7, j8) && c0.b.a(rVar.f2467b, j8)) ? new h.b((r) cVar, rVar, 0) : new c0.h(cVar, rVar, 0);
            }
            j5 = bVar.a(Graphics_1.f.d(j5), Graphics_1.f.c(j5), Graphics_1.f.b(j5), Graphics_1.f.a(j5));
        }
        return (int) (j5 >>> 32);
    }

    public static String G(long j5) {
        return "PointerId(value=" + j5 + ')';
    }

    public static final String H(float f7) {
        int max = Math.max(1, 0);
        float pow = (float) Math.pow(10.0f, max);
        float f8 = f7 * pow;
        int i7 = (int) f8;
        if (f8 - i7 >= 0.5f) {
            i7++;
        }
        float f9 = i7 / pow;
        return max > 0 ? String.valueOf(f9) : String.valueOf((int) f9);
    }

    public static final double I(long j5) {
        return ((j5 >>> 11) * 2048) + (j5 & 2047);
    }

    public static final Object J(Object obj) {
        q0 q0Var;
        r0 r0Var = obj instanceof r0 ? (r0) obj : null;
        return (r0Var == null || (q0Var = r0Var.f330a) == null) ? obj : q0Var;
    }

    public static final int K(int i7) {
        int i8 = 306783378 & i7;
        int i9 = 613566756 & i7;
        return (i7 & (-920350135)) | (i9 >> 1) | i8 | ((i8 << 1) & i9);
    }

    public static final Object L(f.b bVar, q5.p pVar, i5.d dVar) {
        Object J2;
        i5.f a7 = dVar.a();
        boolean z6 = false;
        i5.f s6 = !((Boolean) bVar.q(Boolean.FALSE, a6.t.f336g)).booleanValue() ? a7.s(bVar) : s.a(a7, bVar, false);
        q2.a.r(s6);
        if (s6 == a7) {
            f6.r rVar = new f6.r(dVar, s6);
            J2 = q2.a.O(rVar, rVar, pVar);
        } else {
            e.a aVar = e.a.f4486f;
            if (r5.h.a(s6.e(aVar), a7.e(aVar))) {
                n1 n1Var = new n1(dVar, s6);
                i5.f fVar = n1Var.f280h;
                Object c7 = v.c(fVar, null);
                try {
                    Object O2 = q2.a.O(n1Var, n1Var, pVar);
                    v.a(fVar, c7);
                    J2 = O2;
                } catch (Throwable th) {
                    v.a(fVar, c7);
                    throw th;
                }
            } else {
                f0 f0Var = new f0(dVar, s6);
                try {
                    b.A(q2.a.A(q2.a.p(f0Var, f0Var, pVar)), f5.g.f4141a, null);
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f0.f290j;
                    while (true) {
                        int i7 = atomicIntegerFieldUpdater.get(f0Var);
                        if (i7 == 0) {
                            if (f0.f290j.compareAndSet(f0Var, 0, 1)) {
                                z6 = true;
                                break;
                            }
                        } else if (i7 != 2) {
                            throw new IllegalStateException("Already suspended".toString());
                        }
                    }
                    if (z6) {
                        J2 = Kotlin_1.a.f4591f;
                    } else {
                        J2 = J(f0Var.Q());
                        if (J2 instanceof a6.o) {
                            throw ((a6.o) J2).f324a;
                        }
                    }
                } catch (Throwable th2) {
                    f0Var.o(f5.e.a(th2));
                    throw th2;
                }
            }
        }
        Kotlin_1.a aVar2 = Kotlin_1.a.f4591f;
        return J2;
    }

    public static void M(ByteArrayOutputStream byteArrayOutputStream, long j5, int i7) {
        byte[] bArr = new byte[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            bArr[i8] = (byte) ((j5 >> (i8 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void N(ByteArrayOutputStream byteArrayOutputStream, int i7) {
        M(byteArrayOutputStream, i7, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long a(float r10, float r11, float r12, float r13, c0.c r14) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.e.a(float, float, float, float, c0.c):long");
    }

    public static final long c(long j5) {
        long j7 = (j5 & 4294967295L) << 32;
        int i7 = Graphics_1.f.f2343d;
        return j7;
    }

    public static final long d(float f7, float f8) {
        long floatToIntBits = (Float.floatToIntBits(f8) & 4294967295L) | (Float.floatToIntBits(f7) << 32);
        int i7 = d.f31b;
        return floatToIntBits;
    }

    public static String e(String str, String str2) {
        try {
            String a7 = i6.g.d((str + ":" + str2).getBytes("ISO-8859-1")).a();
            return "Basic " + a7;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    public static final int f(int[] iArr, int i7) {
        int length = iArr.length - 1;
        int i8 = 0;
        while (i8 <= length) {
            int i9 = (i8 + length) >>> 1;
            int i10 = iArr[i9];
            if (i7 > i10) {
                i8 = i9 + 1;
            } else if (i7 >= i10) {
                return i9;
            } else {
                length = i9 - 1;
            }
        }
        return -(i8 + 1);
    }

    public static void g(String str, boolean z6) {
        if (!z6) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void h(int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int j(Context context, String str) {
        int c7;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String d7 = f1.c.d(str);
        if (d7 != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            if (Process.myUid() == myUid && o1.b.a(context.getPackageName(), packageName)) {
                AppOpsManager c8 = f1.d.c(context);
                c7 = f1.d.a(c8, d7, Binder.getCallingUid(), packageName);
                if (c7 == 0) {
                    c7 = f1.d.a(c8, d7, myUid, f1.d.b(context));
                }
            } else {
                c7 = f1.c.c((AppOpsManager) f1.c.a(context, AppOpsManager.class), d7, packageName);
            }
            if (c7 != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static int k(int i7, int i8, int i9) {
        return i7 < i8 ? i8 : i7 > i9 ? i9 : i7;
    }

    public static byte[] l(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static String m(List list, String str) {
        CharSequence valueOf;
        r5.h.f(list, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int size = list.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = list.get(i8);
            i7++;
            if (i7 > 1) {
                sb.append((CharSequence) str);
            }
            if (obj != null ? obj instanceof CharSequence : true) {
                valueOf = (CharSequence) obj;
            } else if (obj instanceof Character) {
                sb.append(((Character) obj).charValue());
            } else {
                valueOf = String.valueOf(obj);
            }
            sb.append(valueOf);
        }
        sb.append((CharSequence) "");
        String sb2 = sb.toString();
        r5.h.e(sb2, "fastJoinTo(StringBuilder…form)\n        .toString()");
        return sb2;
    }

    public static View n(View view, int i7) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View findViewById = viewGroup.getChildAt(i8).findViewById(i7);
                if (findViewById != null) {
                    return findViewById;
                }
            }
            return null;
        }
        return null;
    }

    public static final Class o(x5.b bVar) {
        r5.h.f(bVar, "<this>");
        Class<?> a7 = ((r5.c) bVar).a();
        if (a7.isPrimitive()) {
            String name = a7.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    return !name.equals("double") ? a7 : Double.class;
                case 104431:
                    return !name.equals("int") ? a7 : Integer.class;
                case 3039496:
                    return !name.equals("byte") ? a7 : Byte.class;
                case 3052374:
                    return !name.equals("char") ? a7 : Character.class;
                case 3327612:
                    return !name.equals("long") ? a7 : Long.class;
                case 3625364:
                    return !name.equals("void") ? a7 : Void.class;
                case 64711720:
                    return !name.equals("boolean") ? a7 : Boolean.class;
                case 97526364:
                    return !name.equals("float") ? a7 : Float.class;
                case 109413500:
                    return !name.equals("short") ? a7 : Short.class;
                default:
                    return a7;
            }
        }
        return a7;
    }

    public static final LifecycleCoroutineScopeImpl p(n nVar) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        r5.h.f(nVar, "<this>");
        androidx.lifecycle.o k6 = nVar.k();
        r5.h.f(k6, "<this>");
        while (true) {
            lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) k6.f1860a.get();
            if (lifecycleCoroutineScopeImpl == null) {
                boolean z6 = true;
                i1 i1Var = new i1(null);
                g6.c cVar = h0.f297a;
                lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(k6, i1Var.s(m.f4172a.W()));
                AtomicReference<Object> atomicReference = k6.f1860a;
                while (true) {
                    if (!atomicReference.compareAndSet(null, lifecycleCoroutineScopeImpl)) {
                        if (atomicReference.get() != null) {
                            z6 = false;
                            continue;
                            break;
                        }
                    }
                }
                if (z6) {
                    g6.c cVar2 = h0.f297a;
                    u(lifecycleCoroutineScopeImpl, m.f4172a.W(), 0, new i(lifecycleCoroutineScopeImpl, null), 2);
                    break;
                }
            } else {
                break;
            }
        }
        return lifecycleCoroutineScopeImpl;
    }

    public static final a6.h q(i5.d dVar) {
        a6.h hVar;
        boolean z6;
        boolean z7 = true;
        if (dVar instanceof f6.f) {
            f6.f fVar = (f6.f) dVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6.f.m;
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                if (obj == null) {
                    f6.f.m.set(fVar, b.B);
                    hVar = null;
                    break;
                } else if (obj instanceof a6.h) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6.f.m;
                    q.d dVar2 = b.B;
                    while (true) {
                        if (!atomicReferenceFieldUpdater2.compareAndSet(fVar, obj, dVar2)) {
                            if (atomicReferenceFieldUpdater2.get(fVar) != obj) {
                                z6 = false;
                                break;
                            }
                        } else {
                            z6 = true;
                            break;
                        }
                    }
                    if (z6) {
                        hVar = (a6.h) obj;
                        break;
                    }
                } else if (obj != b.B && !(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                }
            }
            if (hVar != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = a6.h.f294l;
                Object obj2 = atomicReferenceFieldUpdater3.get(hVar);
                if (!(obj2 instanceof a6.n) || ((a6.n) obj2).f321d == null) {
                    a6.h.f293k.set(hVar, 536870911);
                    atomicReferenceFieldUpdater3.set(hVar, a6.b.f282f);
                } else {
                    hVar.q();
                    z7 = false;
                }
                a6.h hVar2 = z7 ? hVar : null;
                if (hVar2 != null) {
                    return hVar2;
                }
            }
            return new a6.h(2, dVar);
        }
        return new a6.h(1, dVar);
    }

    public static final Object r(o0.f fVar, q qVar) {
        r5.h.f(fVar, "<this>");
        r5.h.f(qVar, "key");
        Object obj = fVar.f5231f.get(qVar);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public static final boolean s(float[] fArr, float[] fArr2) {
        r5.h.f(fArr, "$this$invertTo");
        r5.h.f(fArr2, "other");
        float f7 = fArr[0];
        float f8 = fArr[1];
        float f9 = fArr[2];
        float f10 = fArr[3];
        float f11 = fArr[4];
        float f12 = fArr[5];
        float f13 = fArr[6];
        float f14 = fArr[7];
        float f15 = fArr[8];
        float f16 = fArr[9];
        float f17 = fArr[10];
        float f18 = fArr[11];
        float f19 = fArr[12];
        float f20 = fArr[13];
        float f21 = fArr[14];
        float f22 = fArr[15];
        float f23 = (f7 * f12) - (f8 * f11);
        float f24 = (f7 * f13) - (f9 * f11);
        float f25 = (f7 * f14) - (f10 * f11);
        float f26 = (f8 * f13) - (f9 * f12);
        float f27 = (f8 * f14) - (f10 * f12);
        float f28 = (f9 * f14) - (f10 * f13);
        float f29 = (f15 * f20) - (f16 * f19);
        float f30 = (f15 * f21) - (f17 * f19);
        float f31 = (f15 * f22) - (f18 * f19);
        float f32 = (f16 * f21) - (f17 * f20);
        float f33 = (f16 * f22) - (f18 * f20);
        float f34 = (f17 * f22) - (f18 * f21);
        float f35 = (f28 * f29) + (((f26 * f31) + ((f25 * f32) + ((f23 * f34) - (f24 * f33)))) - (f27 * f30));
        if (f35 == 0.0f) {
            return false;
        }
        float f36 = 1.0f / f35;
        fArr2[0] = ((f14 * f32) + ((f12 * f34) - (f13 * f33))) * f36;
        fArr2[1] = (((f9 * f33) + ((-f8) * f34)) - (f10 * f32)) * f36;
        fArr2[2] = ((f22 * f26) + ((f20 * f28) - (f21 * f27))) * f36;
        fArr2[3] = (((f17 * f27) + ((-f16) * f28)) - (f18 * f26)) * f36;
        float f37 = -f11;
        fArr2[4] = (((f13 * f31) + (f37 * f34)) - (f14 * f30)) * f36;
        fArr2[5] = ((f10 * f30) + ((f34 * f7) - (f9 * f31))) * f36;
        float f38 = -f19;
        fArr2[6] = (((f21 * f25) + (f38 * f28)) - (f22 * f24)) * f36;
        fArr2[7] = ((f18 * f24) + ((f28 * f15) - (f17 * f25))) * f36;
        fArr2[8] = ((f14 * f29) + ((f11 * f33) - (f12 * f31))) * f36;
        fArr2[9] = (((f31 * f8) + ((-f7) * f33)) - (f10 * f29)) * f36;
        fArr2[10] = ((f22 * f23) + ((f19 * f27) - (f20 * f25))) * f36;
        fArr2[11] = (((f25 * f16) + ((-f15) * f27)) - (f18 * f23)) * f36;
        fArr2[12] = (((f12 * f30) + (f37 * f32)) - (f13 * f29)) * f36;
        fArr2[13] = ((f9 * f29) + ((f7 * f32) - (f8 * f30))) * f36;
        fArr2[14] = (((f20 * f24) + (f38 * f26)) - (f21 * f23)) * f36;
        fArr2[15] = ((f17 * f23) + ((f15 * f26) - (f16 * f24))) * f36;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [a6.h1, a6.a] */
    public static final h1 t(x xVar, i5.f fVar, int i7, q5.p pVar) {
        i5.f a7 = s.a(xVar.l(), fVar, true);
        g6.c cVar = h0.f297a;
        if (a7 != cVar && a7.e(e.a.f4486f) == null) {
            a7 = a7.s(cVar);
        }
        if (i7 != 0) {
            a1 a1Var = i7 == 2 ? new a1(a7, pVar) : new h1(a7, true);
            a1Var.l0(i7, a1Var, pVar);
            return a1Var;
        }
        throw null;
    }

    public static /* synthetic */ h1 u(x xVar, b1 b1Var, int i7, q5.p pVar, int i8) {
        i5.f fVar = b1Var;
        if ((i8 & 1) != 0) {
            fVar = i5.g.f4488f;
        }
        if ((i8 & 2) != 0) {
            i7 = 1;
        }
        return t(xVar, fVar, i7, pVar);
    }

    public static void v(View view, EditorInfo editorInfo, InputConnection inputConnection) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof androidx.appcompat.widget.h1) {
                editorInfo.hintText = ((androidx.appcompat.widget.h1) parent).a();
                return;
            }
        }
    }

    public static boolean w(String str) {
        return C(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static byte[] x(InputStream inputStream, int i7) {
        byte[] bArr = new byte[i7];
        int i8 = 0;
        while (i8 < i7) {
            int read = inputStream.read(bArr, i8, i7 - i8);
            if (read < 0) {
                throw new IllegalStateException(s0.g("Not enough bytes to read: ", i7));
            }
            i8 += read;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r0.finished() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        throw new java.lang.IllegalStateException("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] y(java.io.FileInputStream r8, int r9, int r10) {
        /*
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            byte[] r1 = new byte[r10]     // Catch: java.lang.Throwable -> L88
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L88
            r3 = 0
            r4 = r3
            r5 = r4
        Le:
            boolean r6 = r0.finished()     // Catch: java.lang.Throwable -> L88
            if (r6 != 0) goto L55
            boolean r6 = r0.needsDictionary()     // Catch: java.lang.Throwable -> L88
            if (r6 != 0) goto L55
            if (r4 >= r9) goto L55
            int r6 = r8.read(r2)     // Catch: java.lang.Throwable -> L88
            if (r6 < 0) goto L39
            r0.setInput(r2, r3, r6)     // Catch: java.lang.Throwable -> L88
            int r7 = r10 - r5
            int r7 = r0.inflate(r1, r5, r7)     // Catch: java.util.zip.DataFormatException -> L2e java.lang.Throwable -> L88
            int r5 = r5 + r7
            int r4 = r4 + r6
            goto Le
        L2e:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L88
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L39:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r8.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r10 = "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "
            r8.append(r10)     // Catch: java.lang.Throwable -> L88
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            java.lang.String r9 = " bytes"
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L88
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L55:
            if (r4 != r9) goto L69
            boolean r8 = r0.finished()     // Catch: java.lang.Throwable -> L88
            if (r8 == 0) goto L61
            r0.end()
            return r1
        L61:
            java.lang.String r8 = "Inflater did not finish"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L69:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r8.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r10 = "Didn't read enough bytes during decompression. expected="
            r8.append(r10)     // Catch: java.lang.Throwable -> L88
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            java.lang.String r9 = " actual="
            r8.append(r9)     // Catch: java.lang.Throwable -> L88
            r8.append(r4)     // Catch: java.lang.Throwable -> L88
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L88
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L88
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L88
            throw r9     // Catch: java.lang.Throwable -> L88
        L88:
            r8 = move-exception
            r0.end()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.e.y(java.io.FileInputStream, int, int):byte[]");
    }

    public static long z(InputStream inputStream, int i7) {
        byte[] x6 = x(inputStream, i7);
        long j5 = 0;
        for (int i8 = 0; i8 < i7; i8++) {
            j5 += (x6[i8] & 255) << (i8 * 8);
        }
        return j5;
    }

    public void E(n.a aVar, float f7) {
        float f8;
        CardView.a aVar2 = (CardView.a) aVar;
        n.b bVar = (n.b) aVar2.f1103a;
        boolean useCompatPadding = CardView.this.getUseCompatPadding();
        boolean preventCornerOverlap = CardView.this.getPreventCornerOverlap();
        if (f7 != bVar.e || bVar.f5099f != useCompatPadding || bVar.f5100g != preventCornerOverlap) {
            bVar.e = f7;
            bVar.f5099f = useCompatPadding;
            bVar.f5100g = preventCornerOverlap;
            bVar.c(null);
            bVar.invalidateSelf();
        }
        if (!CardView.this.getUseCompatPadding()) {
            aVar2.a(0, 0, 0, 0);
            return;
        }
        Drawable drawable = aVar2.f1103a;
        float f9 = ((n.b) drawable).e;
        float f10 = ((n.b) drawable).f5095a;
        if (CardView.this.getPreventCornerOverlap()) {
            f8 = (float) (((1.0d - n.c.f5105a) * f10) + f9);
        } else {
            int i7 = n.c.f5106b;
            f8 = f9;
        }
        int ceil = (int) Math.ceil(f8);
        float f11 = f9 * 1.5f;
        if (CardView.this.getPreventCornerOverlap()) {
            f11 = (float) (((1.0d - n.c.f5105a) * f10) + f11);
        }
        int ceil2 = (int) Math.ceil(f11);
        aVar2.a(ceil, ceil2, ceil, ceil2);
    }

    @Override // d3.b
    public r2.v b(r2.v vVar, p2.h hVar) {
        return vVar;
    }
}
