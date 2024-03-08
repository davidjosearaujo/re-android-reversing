package a0;

import a6.g0;
import a6.k1;
import a6.l0;
import a6.n1;
import a6.o;
import a6.p;
import a6.s;
import a6.u0;
import a6.w;
import android.content.Context;
import android.view.View;
import androidx.compose.ui.platform.j;
import androidx.lifecycle.n;
import f5.e;
import f5.g;
import f6.f;
import f6.v;
import h2.c;
import j5.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import l0.u;
import p.p0;
import p.z;
import q.d;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class b {

    /* renamed from: a */
    public static final d f3a = new d(4, "REMOVED_TASK");

    /* renamed from: b */
    public static final d f4b = new d(4, "CLOSED_EMPTY");

    /* renamed from: c */
    public static final b f5c = new b();

    /* renamed from: d */
    public static final int[] f6d = {16842948, 16842960, 16842972, 16842996, 16842997, 16842999, 16843000, 16843001, 16843002, 16843039, 16843040, 16843071, 16843072, 16843551, 16843552, 16843553, 16843554, 16843555, 16843556, 16843557, 16843558, 16843559, 16843560, 16843701, 16843702, 16843770, 16843840, 2130903089, 2130903092, 2130903141, 2130903142, 2130903143, 2130903215, 2130903351, 2130903352, 2130903449, 2130903551, 2130903552, 2130903553, 2130903554, 2130903555, 2130903556, 2130903557, 2130903558, 2130903559, 2130903560, 2130903561, 2130903562, 2130903563, 2130903565, 2130903566, 2130903567, 2130903568, 2130903569, 2130903589, 2130903690, 2130903691, 2130903692, 2130903693, 2130903694, 2130903695, 2130903696, 2130903697, 2130903698, 2130903699, 2130903700, 2130903701, 2130903702, 2130903703, 2130903704, 2130903705, 2130903706, 2130903707, 2130903708, 2130903709, 2130903710, 2130903711, 2130903712, 2130903713, 2130903714, 2130903715, 2130903716, 2130903717, 2130903718, 2130903719, 2130903720, 2130903721, 2130903722, 2130903723, 2130903724, 2130903725, 2130903726, 2130903727, 2130903728, 2130903729, 2130903730, 2130903731, 2130903732, 2130903733, 2130903734, 2130903735, 2130903737, 2130903738, 2130903739, 2130903740, 2130903741, 2130903742, 2130903743, 2130903744, 2130903745, 2130903748, 2130903753, 2130903902, 2130903903, 2130903948, 2130903980, 2130903985, 2130903997, 2130903998, 2130903999, 2130904294, 2130904296, 2130904298, 2130904316};
    public static final int[] e = {16842948, 16842965, 16842966, 16842967, 16842968, 16842969, 16842972, 16842996, 16842997, 16842998, 16842999, 16843000, 16843001, 16843002, 16843039, 16843040, 16843071, 16843072, 16843699, 16843700, 16843701, 16843702, 16843840, 16844091, 16844092, 2130903141, 2130903142, 2130903143, 2130903215, 2130903254, 2130903255, 2130903256, 2130903257, 2130903258, 2130903348, 2130903351, 2130903352, 2130903551, 2130903552, 2130903553, 2130903554, 2130903555, 2130903556, 2130903557, 2130903558, 2130903559, 2130903560, 2130903561, 2130903562, 2130903563, 2130903565, 2130903566, 2130903567, 2130903568, 2130903569, 2130903589, 2130903682, 2130903690, 2130903691, 2130903692, 2130903693, 2130903694, 2130903695, 2130903696, 2130903697, 2130903698, 2130903699, 2130903700, 2130903701, 2130903702, 2130903703, 2130903704, 2130903705, 2130903706, 2130903707, 2130903708, 2130903709, 2130903710, 2130903711, 2130903712, 2130903713, 2130903714, 2130903715, 2130903716, 2130903717, 2130903718, 2130903719, 2130903720, 2130903721, 2130903722, 2130903723, 2130903724, 2130903725, 2130903726, 2130903727, 2130903728, 2130903729, 2130903730, 2130903731, 2130903732, 2130903733, 2130903734, 2130903735, 2130903737, 2130903738, 2130903739, 2130903740, 2130903741, 2130903742, 2130903743, 2130903744, 2130903745, 2130903748, 2130903749, 2130903753};

    /* renamed from: f */
    public static final int[] f7f = {16842948, 16842960, 16842972, 16842996, 16842997, 16842999, 16843000, 16843001, 16843002, 16843039, 16843040, 16843071, 16843072, 16843551, 16843552, 16843553, 16843554, 16843555, 16843556, 16843557, 16843558, 16843559, 16843560, 16843701, 16843702, 16843770, 16843840, 2130903089, 2130903092, 2130903141, 2130903142, 2130903143, 2130903215, 2130903351, 2130903449, 2130903551, 2130903552, 2130903553, 2130903554, 2130903555, 2130903556, 2130903557, 2130903558, 2130903559, 2130903560, 2130903561, 2130903562, 2130903563, 2130903565, 2130903566, 2130903567, 2130903568, 2130903569, 2130903589, 2130903690, 2130903691, 2130903692, 2130903696, 2130903700, 2130903701, 2130903702, 2130903705, 2130903706, 2130903707, 2130903708, 2130903709, 2130903710, 2130903711, 2130903712, 2130903713, 2130903714, 2130903715, 2130903716, 2130903719, 2130903724, 2130903725, 2130903728, 2130903729, 2130903730, 2130903731, 2130903732, 2130903733, 2130903734, 2130903735, 2130903737, 2130903738, 2130903739, 2130903740, 2130903741, 2130903742, 2130903743, 2130903744, 2130903745, 2130903748, 2130903753, 2130903902, 2130903903, 2130903904, 2130903948, 2130903980, 2130903985, 2130903997, 2130903998, 2130903999, 2130904294, 2130904296, 2130904298, 2130904316};

    /* renamed from: g */
    public static final int[] f8g = {16842948, 16842960, 16842972, 16842996, 16842997, 16842999, 16843000, 16843001, 16843002, 16843039, 16843040, 16843071, 16843072, 16843189, 16843190, 16843551, 16843552, 16843553, 16843554, 16843555, 16843556, 16843557, 16843558, 16843559, 16843560, 16843701, 16843702, 16843770, 16843840, 2130903089, 2130903092, 2130903141, 2130903142, 2130903143, 2130903215, 2130903347, 2130903351, 2130903352, 2130903433, 2130903449, 2130903551, 2130903552, 2130903553, 2130903554, 2130903555, 2130903556, 2130903557, 2130903558, 2130903559, 2130903560, 2130903561, 2130903562, 2130903563, 2130903565, 2130903566, 2130903567, 2130903568, 2130903569, 2130903589, 2130903690, 2130903691, 2130903692, 2130903693, 2130903694, 2130903695, 2130903696, 2130903697, 2130903698, 2130903699, 2130903700, 2130903701, 2130903702, 2130903703, 2130903704, 2130903705, 2130903706, 2130903707, 2130903709, 2130903710, 2130903711, 2130903712, 2130903713, 2130903714, 2130903715, 2130903716, 2130903717, 2130903718, 2130903719, 2130903720, 2130903721, 2130903722, 2130903723, 2130903724, 2130903725, 2130903726, 2130903727, 2130903728, 2130903729, 2130903730, 2130903732, 2130903733, 2130903734, 2130903735, 2130903737, 2130903738, 2130903739, 2130903740, 2130903741, 2130903742, 2130903743, 2130903744, 2130903745, 2130903748, 2130903753, 2130903902, 2130903903, 2130903948, 2130903980, 2130903985, 2130903999, 2130904296, 2130904298};

    /* renamed from: h */
    public static final int[] f9h = {2130903100, 2130903412, 2130903413, 2130903414, 2130903415, 2130903416, 2130903417, 2130903419, 2130903420, 2130903421, 2130903850};

    /* renamed from: i */
    public static final int[] f10i = {16842948, 16842996, 16842997, 16842999, 16843000, 16843001, 16843002, 16843701, 16843702, 2130903141, 2130903142, 2130903143, 2130903215, 2130903351, 2130903352, 2130903589, 2130903690, 2130903691, 2130903692, 2130903693, 2130903694, 2130903695, 2130903696, 2130903697, 2130903698, 2130903699, 2130903700, 2130903701, 2130903702, 2130903703, 2130903704, 2130903705, 2130903706, 2130903707, 2130903708, 2130903709, 2130903710, 2130903711, 2130903712, 2130903713, 2130903714, 2130903715, 2130903716, 2130903717, 2130903718, 2130903719, 2130903720, 2130903721, 2130903722, 2130903723, 2130903725, 2130903726, 2130903727, 2130903728, 2130903729, 2130903730, 2130903731, 2130903732, 2130903733, 2130903734, 2130903735, 2130903737, 2130903738, 2130903739, 2130903740, 2130903741, 2130903742, 2130903743, 2130903744, 2130903745, 2130903748, 2130903753, 2130903840, 2130903845, 2130903851, 2130903855};

    /* renamed from: j */
    public static final int[] f11j = {2130903089, 2130903092, 2130903449, 2130903901, 2130903903, 2130903948, 2130903997, 2130903998, 2130903999, 2130904296};

    /* renamed from: k */
    public static final int[] f12k = {2130903922, 2130903925};

    /* renamed from: l */
    public static final int[] f13l = {16842972, 16843551, 2130903724, 2130903902, 2130904316};
    public static final int[] m = {16842960, 2130903353};

    /* renamed from: n */
    public static final int[] f14n = {16843552, 16843553, 16843554, 16843555, 16843556, 16843557, 16843558, 16843559, 16843560, 16843770, 16843840, 2130904294};

    /* renamed from: o */
    public static final int[] f15o = {2130903353, 2130904014, 2130904015, 2130904016, 2130904017};

    /* renamed from: p */
    public static final int[] f16p = {2130903673, 2130904105};

    /* renamed from: q */
    public static final int[] f17q = {16842931, 2130903685, 2130903686, 2130903687, 2130903736, 2130903746, 2130903747};

    /* renamed from: r */
    public static final d f18r = new d(4, "NO_VALUE");
    public static final d s = new d(4, "NONE");

    /* renamed from: t */
    public static final d f19t = new d(4, "PENDING");

    /* renamed from: u */
    public static final int[] f20u = {16843173, 16843551, 16844359, 2130903086, 2130903674};

    /* renamed from: v */
    public static final int[] f21v = {2130903572, 2130903573, 2130903574, 2130903575, 2130903576, 2130903577, 2130903578};

    /* renamed from: w */
    public static final int[] f22w = {16844082, 16844083, 16844095, 16844143, 16844144, 2130903570, 2130903579, 2130903580, 2130903581, 2130904303};

    /* renamed from: x */
    public static final int[] f23x = {16843165, 16843166, 16843169, 16843170, 16843171, 16843172, 16843265, 16843275, 16844048, 16844049, 16844050, 16844051};

    /* renamed from: y */
    public static final int[] f24y = {16843173, 16844052};

    /* renamed from: z */
    public static final d f25z = new d(4, "CLOSED");
    public static final d A = new d(4, "UNDEFINED");
    public static final d B = new d(4, "REUSABLE_CLAIMED");
    public static final float[][] C = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    public static final float[][] D = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    public static final float[] E = {95.047f, 100.0f, 108.883f};
    public static final float[][] F = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    public static final int[] G = {2130903251};

    public /* synthetic */ b() {
    }

    public /* synthetic */ b(int i7) {
    }

    public /* synthetic */ b(Context context, j jVar) {
    }

    public /* synthetic */ b(u uVar) {
        h.f(uVar, "lookaheadDelegate");
    }

    public static final void A(i5.d dVar, Object obj, l lVar) {
        if (dVar instanceof f) {
            f fVar = (f) dVar;
            Throwable a7 = f5.d.a(obj);
            boolean z6 = false;
            Object pVar = a7 == null ? lVar != null ? new p(obj, lVar) : obj : new o(a7, false);
            a6.u uVar = fVar.f4148i;
            fVar.a();
            if (uVar.V()) {
                fVar.f4150k = pVar;
                fVar.f291h = 1;
                fVar.f4148i.U(fVar.a(), fVar);
                return;
            }
            l0 a8 = k1.a();
            if (a8.Z()) {
                fVar.f4150k = pVar;
                fVar.f291h = 1;
                a8.X(fVar);
                return;
            }
            a8.Y(true);
            try {
                u0 u0Var = (u0) fVar.a().e(u0.b.f341f);
                if (u0Var != null && !u0Var.b()) {
                    CancellationException G2 = u0Var.G();
                    fVar.d(pVar, G2);
                    fVar.o(e.a(G2));
                    z6 = true;
                }
                if (!z6) {
                    i5.d<T> dVar2 = fVar.f4149j;
                    Object obj2 = fVar.f4151l;
                    i5.f a9 = dVar2.a();
                    Object c7 = v.c(a9, obj2);
                    n1<?> b2 = c7 != v.f4182a ? s.b(dVar2, a9, c7) : null;
                    fVar.f4149j.o(obj);
                    g gVar = g.f4141a;
                    if (b2 == null || b2.m0()) {
                        v.a(a9, c7);
                    }
                }
                do {
                } while (a8.b0());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        dVar.o(obj);
    }

    public static final void B(View view, n nVar) {
        h.f(view, "<this>");
        view.setTag(2131296915, nVar);
    }

    public static final void C(View view, c cVar) {
        h.f(view, "<this>");
        view.setTag(2131296917, cVar);
    }

    /* JADX WARN: Finally extract failed */
    public static final Object E(i5.f fVar, Object obj, Object obj2, q5.p pVar, i5.d dVar) {
        Object c7 = v.c(fVar, obj2);
        try {
            e6.s sVar = new e6.s(dVar, fVar);
            r5.v.b(2, pVar);
            Object i7 = pVar.i(obj, sVar);
            v.a(fVar, c7);
            if (i7 == a.f4591f) {
                h.f(dVar, "frame");
            }
            return i7;
        } catch (Throwable th) {
            v.a(fVar, c7);
            throw th;
        }
    }

    public static float F() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public static final long a(float f7, float f8) {
        long floatToIntBits = (long) Float.floatToIntBits(f7);
        long floatToIntBits2 = (((long) Float.floatToIntBits(f8)) & 4294967295L) | (floatToIntBits << 32);
        int i7 = a.f2c;
        return floatToIntBits2;
    }

    public static final long b(float f7, boolean z6) {
        return ((z6 ? 1 : 0) & 4294967295L) | (((long) Float.floatToIntBits(f7)) << 32);
    }

    public static final void c(int i7, List list) {
        int size = list.size();
        if (i7 < 0 || i7 >= size) {
            throw new IndexOutOfBoundsException("Index " + i7 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    public static final void d(int i7, int i8, List list) {
        int size = list.size();
        if (i7 > i8) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i7 + ") is greater than toIndex (" + i8 + ").");
        } else if (i7 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i7 + ") is less than 0.");
        } else if (i8 > size) {
            throw new IndexOutOfBoundsException("toIndex (" + i8 + ") is more than than the list size (" + size + ')');
        }
    }

    public static final void g(l lVar, Object obj, i5.f fVar) {
        f5.b h7 = h(lVar, obj, null);
        if (h7 != null) {
            w.a(fVar, h7);
        }
    }

    public static final f5.b h(l lVar, Object obj, f5.b bVar) {
        try {
            lVar.k(obj);
        } catch (Throwable th) {
            if (bVar == null || bVar.getCause() == th) {
                return new f5.b("Exception in undelivered element handler for " + obj, th);
            }
            q2.a.c(bVar, th);
        }
        return bVar;
    }

    public static final int i(long j7, long j8) {
        boolean n6 = n(j7);
        return n6 != n(j8) ? n6 ? -1 : 1 : (int) Math.signum(Float.intBitsToFloat((int) (j7 >> 32)) - Float.intBitsToFloat((int) (j8 >> 32)));
    }

    public static float[] j() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[Catch: all -> 0x0086, TRY_LEAVE, TryCatch #1 {all -> 0x0086, blocks: (B:13:0x002f, B:18:0x0045, B:21:0x0050, B:22:0x0054, B:26:0x0069, B:28:0x0071), top: B:45:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Type inference failed for: r8v5, types: [c6.q] */
    /* JADX WARN: Type inference failed for: r8v7, types: [c6.q] */
    /* JADX WARN: Unknown variable types count: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(d6.d r7, c6.n r8, boolean r9, i5.d r10) {
        /*
            boolean r0 = r10 instanceof d6.f
            if (r0 == 0) goto L_0x0013
            r0 = r10
            d6.f r0 = (d6.f) r0
            int r1 = r0.f3691n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f3691n = r1
            goto L_0x0018
        L_0x0013:
            d6.f r0 = new d6.f
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.m
            j5.a r1 = j5.a.f4591f
            int r2 = r0.f3691n
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 == r3) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            boolean r9 = r0.f3690l
            c6.g r7 = r0.f3689k
            c6.q r8 = r0.f3688j
            d6.d r2 = r0.f3687i
            f5.e.b(r10)     // Catch: all -> 0x0086
        L_0x0032:
            r10 = r7
            r7 = r2
            goto L_0x0054
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003d:
            boolean r9 = r0.f3690l
            c6.g r7 = r0.f3689k
            c6.q r8 = r0.f3688j
            d6.d r2 = r0.f3687i
            f5.e.b(r10)     // Catch: all -> 0x0086
            goto L_0x0069
        L_0x0049:
            f5.e.b(r10)
            boolean r10 = r7 instanceof d6.h0
            if (r10 != 0) goto L_0x0098
            c6.g r10 = r8.iterator()     // Catch: all -> 0x0086
        L_0x0054:
            r0.f3687i = r7     // Catch: all -> 0x0086
            r0.f3688j = r8     // Catch: all -> 0x0086
            r0.f3689k = r10     // Catch: all -> 0x0086
            r0.f3690l = r9     // Catch: all -> 0x0086
            r0.f3691n = r3     // Catch: all -> 0x0086
            java.lang.Object r2 = r10.a(r0)     // Catch: all -> 0x0086
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L_0x0069:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: all -> 0x0086
            boolean r10 = r10.booleanValue()     // Catch: all -> 0x0086
            if (r10 == 0) goto L_0x0088
            java.lang.Object r10 = r7.next()     // Catch: all -> 0x0086
            r0.f3687i = r2     // Catch: all -> 0x0086
            r0.f3688j = r8     // Catch: all -> 0x0086
            r0.f3689k = r7     // Catch: all -> 0x0086
            r0.f3690l = r9     // Catch: all -> 0x0086
            r0.f3691n = r4     // Catch: all -> 0x0086
            java.lang.Object r10 = r2.m(r10, r0)     // Catch: all -> 0x0086
            if (r10 != r1) goto L_0x0032
            return r1
        L_0x0086:
            r7 = move-exception
            goto L_0x0090
        L_0x0088:
            if (r9 == 0) goto L_0x008d
            q2.a.g(r8, r5)
        L_0x008d:
            f5.g r7 = f5.g.f4141a
            return r7
        L_0x0090:
            throw r7     // Catch: all -> 0x0091
        L_0x0091:
            r10 = move-exception
            if (r9 == 0) goto L_0x0097
            q2.a.g(r8, r7)
        L_0x0097:
            throw r10
        L_0x0098:
            d6.h0 r7 = (d6.h0) r7
            r7.getClass()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.b.l(d6.d, c6.n, boolean, i5.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object m(f6.s sVar, long j7) {
        boolean z6;
        c6.c cVar = c6.c.f2594n;
        while (true) {
            if (sVar.f4179h >= j7 && !sVar.c()) {
                return sVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6.b.f4143f;
            Object obj = atomicReferenceFieldUpdater.get(sVar);
            d dVar = f25z;
            if (obj == dVar) {
                return dVar;
            }
            sVar = (f6.s) ((f6.b) obj);
            if (sVar == null) {
                sVar = cVar.i(Long.valueOf(sVar.f4179h + 1), sVar);
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(sVar, null, sVar)) {
                        if (atomicReferenceFieldUpdater.get(sVar) != null) {
                            z6 = false;
                            break;
                        }
                    } else {
                        z6 = true;
                        break;
                    }
                }
                if (z6) {
                    if (sVar.c()) {
                        sVar.d();
                    }
                }
            }
        }
    }

    public static final boolean n(long j7) {
        return ((int) (j7 & 4294967295L)) != 0;
    }

    public static float o(int i7) {
        float f7 = ((float) i7) / 255.0f;
        return (f7 <= 0.04045f ? f7 / 12.92f : (float) Math.pow((double) ((f7 + 0.055f) / 1.055f), 2.4000000953674316d)) * 100.0f;
    }

    public static final long p(float[] fArr, long j7) {
        float b2 = a.b(j7);
        float c7 = a.c(j7);
        float f7 = ((float) 1) / (((fArr[7] * c7) + (fArr[3] * b2)) + fArr[15]);
        if (!(!Float.isInfinite(f7) && !Float.isNaN(f7))) {
            f7 = 0.0f;
        }
        return a(((fArr[4] * c7) + (fArr[0] * b2) + fArr[12]) * f7, ((fArr[5] * c7) + (fArr[1] * b2) + fArr[13]) * f7);
    }

    public static z s(Object obj) {
        p0 p0Var = p0.f5447a;
        int i7 = p.a.f5420a;
        return new z(obj, p0Var);
    }

    public static final Object t(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final Object u(Object obj) {
        return obj instanceof o ? e.a(((o) obj).f324a) : obj;
    }

    public static final void z(g0 g0Var, i5.d dVar, boolean z6) {
        Object k6 = g0Var.k();
        Throwable f7 = g0Var.f(k6);
        Object a7 = f7 != null ? e.a(f7) : g0Var.i(k6);
        if (z6) {
            h.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            f fVar = (f) dVar;
            i5.d<T> dVar2 = fVar.f4149j;
            Object obj = fVar.f4151l;
            i5.f a8 = dVar2.a();
            Object c7 = v.c(a8, obj);
            n1<?> b2 = c7 != v.f4182a ? s.b(dVar2, a8, c7) : null;
            try {
                fVar.f4149j.o(a7);
                g gVar = g.f4141a;
            } finally {
                if (b2 == null || b2.m0()) {
                    v.a(a8, c7);
                }
            }
        } else {
            dVar.o(a7);
        }
    }

    public void D(long j7) {
        throw null;
    }

    public float[] e(Object obj) {
        throw null;
    }

    public float[] f(Object obj) {
        throw null;
    }

    public void k(boolean z6) {
        throw null;
    }

    public boolean q(androidx.compose.ui.platform.d dVar) {
        throw null;
    }

    public void r() {
        throw null;
    }

    public boolean v(l0.o oVar, boolean z6) {
        throw null;
    }

    public boolean w(l0.o oVar, boolean z6) {
        throw null;
    }

    public boolean x(l0.o oVar, boolean z6) {
        throw null;
    }

    public boolean y(l0.o oVar, boolean z6) {
        throw null;
    }
}
