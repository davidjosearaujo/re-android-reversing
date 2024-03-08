package y0;

import androidx.activity.h;
import com.davemorrissey.labs.subscaleview.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import l0.z;
import y0.c;
import z0.c;
import z0.f;
import z0.l;
import z0.n;
import z0.p;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class d {
    public boolean G;
    public c K;
    public c L;
    public c M;
    public c N;
    public c O;
    public c R;
    public c[] S;
    public ArrayList<c> T;

    /* renamed from: b */
    public c f6512b;

    /* renamed from: c */
    public c f6514c;

    /* renamed from: e0 */
    public int f6518e0;

    /* renamed from: f0 */
    public int f6520f0;

    /* renamed from: i0 */
    public Object f6526i0;

    /* renamed from: k */
    public String f6529k;

    /* renamed from: a */
    public boolean f6510a = false;

    /* renamed from: d */
    public l f6516d = null;
    public n e = null;

    /* renamed from: f */
    public boolean[] f6519f = {true, true};

    /* renamed from: g */
    public boolean f6521g = true;

    /* renamed from: h */
    public boolean f6523h = true;

    /* renamed from: i */
    public int f6525i = -1;

    /* renamed from: j */
    public int f6527j = -1;

    /* renamed from: l */
    public boolean f6531l = false;
    public boolean m = false;

    /* renamed from: n */
    public boolean f6534n = false;

    /* renamed from: o */
    public boolean f6536o = false;

    /* renamed from: p */
    public int f6538p = -1;

    /* renamed from: q */
    public int f6540q = -1;

    /* renamed from: r */
    public int f6542r = 0;
    public int s = 0;

    /* renamed from: t */
    public int f6544t = 0;

    /* renamed from: u */
    public int[] f6545u = new int[2];

    /* renamed from: v */
    public int f6546v = 0;

    /* renamed from: w */
    public int f6547w = 0;

    /* renamed from: x */
    public float f6548x = 1.0f;

    /* renamed from: y */
    public int f6549y = 0;

    /* renamed from: z */
    public int f6550z = 0;
    public float A = 1.0f;
    public int B = -1;
    public float C = 1.0f;
    public int[] D = {SubsamplingScaleImageView.TILE_SIZE_AUTO, SubsamplingScaleImageView.TILE_SIZE_AUTO};
    public float E = 0.0f;
    public boolean F = false;
    public boolean H = false;
    public int I = 0;
    public int J = 0;
    public c P = new c(this, c.a.CENTER_X);
    public c Q = new c(this, c.a.CENTER_Y);
    public boolean[] U = new boolean[2];
    public int[] V = {1, 1};
    public d W = null;
    public int X = 0;
    public int Y = 0;
    public float Z = 0.0f;

    /* renamed from: a0 */
    public int f6511a0 = -1;

    /* renamed from: b0 */
    public int f6513b0 = 0;

    /* renamed from: c0 */
    public int f6515c0 = 0;

    /* renamed from: d0 */
    public int f6517d0 = 0;

    /* renamed from: g0 */
    public float f6522g0 = 0.5f;

    /* renamed from: h0 */
    public float f6524h0 = 0.5f;

    /* renamed from: j0 */
    public int f6528j0 = 0;

    /* renamed from: k0 */
    public String f6530k0 = null;

    /* renamed from: l0 */
    public int f6532l0 = 0;

    /* renamed from: m0 */
    public int f6533m0 = 0;

    /* renamed from: n0 */
    public float[] f6535n0 = {-1.0f, -1.0f};

    /* renamed from: o0 */
    public d[] f6537o0 = {null, null};

    /* renamed from: p0 */
    public d[] f6539p0 = {null, null};

    /* renamed from: q0 */
    public int f6541q0 = -1;

    /* renamed from: r0 */
    public int f6543r0 = -1;

    public d() {
        new HashMap();
        c cVar = new c(this, c.a.LEFT);
        this.K = cVar;
        c cVar2 = new c(this, c.a.TOP);
        this.L = cVar2;
        c cVar3 = new c(this, c.a.RIGHT);
        this.M = cVar3;
        c cVar4 = new c(this, c.a.BOTTOM);
        this.N = cVar4;
        c cVar5 = new c(this, c.a.BASELINE);
        this.O = cVar5;
        c cVar6 = new c(this, c.a.CENTER);
        this.R = cVar6;
        this.S = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar6};
        ArrayList<c> arrayList = new ArrayList<>();
        this.T = arrayList;
        arrayList.add(this.K);
        this.T.add(this.L);
        this.T.add(this.M);
        this.T.add(this.N);
        this.T.add(this.P);
        this.T.add(this.Q);
        this.T.add(this.R);
        this.T.add(this.O);
    }

    public static void H(int i7, int i8, String str, StringBuilder sb) {
        if (i7 != i8) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(i7);
            sb.append(",\n");
        }
    }

    public static void I(StringBuilder sb, String str, float f7, float f8) {
        if (f7 != f8) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(f7);
            sb.append(",\n");
        }
    }

    public static void p(StringBuilder sb, String str, int i7, int i8, int i9, int i10, int i11, float f7) {
        sb.append(str);
        sb.append(" :  {\n");
        H(i7, 0, "      size", sb);
        H(i8, 0, "      min", sb);
        H(i9, SubsamplingScaleImageView.TILE_SIZE_AUTO, "      max", sb);
        H(i10, 0, "      matchMin", sb);
        H(i11, 0, "      matchDef", sb);
        I(sb, "      matchPercent", f7, 1.0f);
        sb.append("    },\n");
    }

    public static void q(StringBuilder sb, String str, c cVar) {
        if (cVar.f6498f != null) {
            sb.append("    ");
            sb.append(str);
            sb.append(" : [ '");
            sb.append(cVar.f6498f);
            sb.append("'");
            if (!(cVar.f6500h == Integer.MIN_VALUE && cVar.f6499g == 0)) {
                sb.append(",");
                sb.append(cVar.f6499g);
                if (cVar.f6500h != Integer.MIN_VALUE) {
                    sb.append(",");
                    sb.append(cVar.f6500h);
                    sb.append(",");
                }
            }
            sb.append(" ] ,\n");
        }
    }

    public final boolean A() {
        return this.f6521g && this.f6528j0 != 8;
    }

    public boolean B() {
        return this.f6531l || (this.K.f6496c && this.M.f6496c);
    }

    public boolean C() {
        return this.m || (this.L.f6496c && this.N.f6496c);
    }

    public void D() {
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.R.j();
        this.W = null;
        this.E = 0.0f;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.0f;
        this.f6511a0 = -1;
        this.f6513b0 = 0;
        this.f6515c0 = 0;
        this.f6517d0 = 0;
        this.f6518e0 = 0;
        this.f6520f0 = 0;
        this.f6522g0 = 0.5f;
        this.f6524h0 = 0.5f;
        int[] iArr = this.V;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f6526i0 = null;
        this.f6528j0 = 0;
        this.f6532l0 = 0;
        this.f6533m0 = 0;
        float[] fArr = this.f6535n0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f6538p = -1;
        this.f6540q = -1;
        int[] iArr2 = this.D;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.s = 0;
        this.f6544t = 0;
        this.f6548x = 1.0f;
        this.A = 1.0f;
        this.f6547w = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f6550z = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f6546v = 0;
        this.f6549y = 0;
        this.B = -1;
        this.C = 1.0f;
        boolean[] zArr = this.f6519f;
        zArr[0] = true;
        zArr[1] = true;
        this.H = false;
        boolean[] zArr2 = this.U;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f6521g = true;
        int[] iArr3 = this.f6545u;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.f6525i = -1;
        this.f6527j = -1;
    }

    public final void E() {
        d dVar = this.W;
        if (dVar != null && (dVar instanceof e)) {
            ((e) dVar).getClass();
        }
        int size = this.T.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.T.get(i7).j();
        }
    }

    public final void F() {
        this.f6531l = false;
        this.m = false;
        this.f6534n = false;
        this.f6536o = false;
        int size = this.T.size();
        for (int i7 = 0; i7 < size; i7++) {
            c cVar = this.T.get(i7);
            cVar.f6496c = false;
            cVar.f6495b = 0;
        }
    }

    public void G(w0.c cVar) {
        this.K.k();
        this.L.k();
        this.M.k();
        this.N.k();
        this.O.k();
        this.R.k();
        this.P.k();
        this.Q.k();
    }

    public final void J(int i7, int i8) {
        if (!this.f6531l) {
            this.K.l(i7);
            this.M.l(i8);
            this.f6513b0 = i7;
            this.X = i8 - i7;
            this.f6531l = true;
        }
    }

    public final void K(int i7, int i8) {
        if (!this.m) {
            this.L.l(i7);
            this.N.l(i8);
            this.f6515c0 = i7;
            this.Y = i8 - i7;
            if (this.F) {
                this.O.l(i7 + this.f6517d0);
            }
            this.m = true;
        }
    }

    public final void L(int i7) {
        this.Y = i7;
        int i8 = this.f6520f0;
        if (i7 < i8) {
            this.Y = i8;
        }
    }

    public final void M(int i7) {
        this.V[0] = i7;
    }

    public final void N(int i7) {
        this.V[1] = i7;
    }

    public final void O(int i7) {
        this.X = i7;
        int i8 = this.f6518e0;
        if (i7 < i8) {
            this.X = i8;
        }
    }

    public void P(boolean z6, boolean z7) {
        int i7;
        int i8;
        l lVar = this.f6516d;
        boolean z8 = z6 & lVar.f6899g;
        n nVar = this.e;
        boolean z9 = z7 & nVar.f6899g;
        int i9 = lVar.f6900h.f6877g;
        int i10 = nVar.f6900h.f6877g;
        int i11 = lVar.f6901i.f6877g;
        int i12 = nVar.f6901i.f6877g;
        int i13 = i12 - i10;
        if (i11 - i9 < 0 || i13 < 0 || i9 == Integer.MIN_VALUE || i9 == Integer.MAX_VALUE || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE) {
            i11 = 0;
            i12 = 0;
            i9 = 0;
            i10 = 0;
        }
        int i14 = i11 - i9;
        int i15 = i12 - i10;
        if (z8) {
            this.f6513b0 = i9;
        }
        if (z9) {
            this.f6515c0 = i10;
        }
        if (this.f6528j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        if (z8) {
            if (this.V[0] == 1 && i14 < (i8 = this.X)) {
                i14 = i8;
            }
            this.X = i14;
            int i16 = this.f6518e0;
            if (i14 < i16) {
                this.X = i16;
            }
        }
        if (z9) {
            if (this.V[1] == 1 && i15 < (i7 = this.Y)) {
                i15 = i7;
            }
            this.Y = i15;
            int i17 = this.f6520f0;
            if (i15 < i17) {
                this.Y = i17;
            }
        }
    }

    public void Q(w0.d dVar, boolean z6) {
        int i7;
        int i8;
        n nVar;
        l lVar;
        c cVar = this.K;
        dVar.getClass();
        int o6 = w0.d.o(cVar);
        int o7 = w0.d.o(this.L);
        int o8 = w0.d.o(this.M);
        int o9 = w0.d.o(this.N);
        if (z6 && (lVar = this.f6516d) != null) {
            f fVar = lVar.f6900h;
            if (fVar.f6880j) {
                f fVar2 = lVar.f6901i;
                if (fVar2.f6880j) {
                    o6 = fVar.f6877g;
                    o8 = fVar2.f6877g;
                }
            }
        }
        if (z6 && (nVar = this.e) != null) {
            f fVar3 = nVar.f6900h;
            if (fVar3.f6880j) {
                f fVar4 = nVar.f6901i;
                if (fVar4.f6880j) {
                    o7 = fVar3.f6877g;
                    o9 = fVar4.f6877g;
                }
            }
        }
        int i9 = o9 - o7;
        if (o8 - o6 < 0 || i9 < 0 || o6 == Integer.MIN_VALUE || o6 == Integer.MAX_VALUE || o7 == Integer.MIN_VALUE || o7 == Integer.MAX_VALUE || o8 == Integer.MIN_VALUE || o8 == Integer.MAX_VALUE || o9 == Integer.MIN_VALUE || o9 == Integer.MAX_VALUE) {
            o6 = 0;
            o7 = 0;
            o8 = 0;
            o9 = 0;
        }
        int i10 = o8 - o6;
        int i11 = o9 - o7;
        this.f6513b0 = o6;
        this.f6515c0 = o7;
        if (this.f6528j0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        int[] iArr = this.V;
        int i12 = iArr[0];
        if (i12 == 1 && i10 < (i8 = this.X)) {
            i10 = i8;
        }
        if (iArr[1] == 1 && i11 < (i7 = this.Y)) {
            i11 = i7;
        }
        this.X = i10;
        this.Y = i11;
        int i13 = this.f6520f0;
        if (i11 < i13) {
            this.Y = i13;
        }
        int i14 = this.f6518e0;
        if (i10 < i14) {
            this.X = i14;
        }
        int i15 = this.f6547w;
        if (i15 > 0 && i12 == 3) {
            this.X = Math.min(this.X, i15);
        }
        int i16 = this.f6550z;
        if (i16 > 0 && this.V[1] == 3) {
            this.Y = Math.min(this.Y, i16);
        }
        int i17 = this.X;
        if (i10 != i17) {
            this.f6525i = i17;
        }
        int i18 = this.Y;
        if (i11 != i18) {
            this.f6527j = i18;
        }
    }

    public final void b(e eVar, w0.d dVar, HashSet<d> hashSet, int i7, boolean z6) {
        if (z6) {
            if (hashSet.contains(this)) {
                z.m(eVar, dVar, this);
                hashSet.remove(this);
                c(dVar, eVar.W(64));
            } else {
                return;
            }
        }
        if (i7 == 0) {
            HashSet<c> hashSet2 = this.K.f6494a;
            if (hashSet2 != null) {
                Iterator<c> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().f6497d.b(eVar, dVar, hashSet, i7, true);
                }
            }
            HashSet<c> hashSet3 = this.M.f6494a;
            if (hashSet3 != null) {
                Iterator<c> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().f6497d.b(eVar, dVar, hashSet, i7, true);
                }
                return;
            }
            return;
        }
        HashSet<c> hashSet4 = this.L.f6494a;
        if (hashSet4 != null) {
            Iterator<c> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().f6497d.b(eVar, dVar, hashSet, i7, true);
            }
        }
        HashSet<c> hashSet5 = this.N.f6494a;
        if (hashSet5 != null) {
            Iterator<c> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().f6497d.b(eVar, dVar, hashSet, i7, true);
            }
        }
        HashSet<c> hashSet6 = this.O.f6494a;
        if (hashSet6 != null) {
            Iterator<c> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().f6497d.b(eVar, dVar, hashSet, i7, true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x06a3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(w0.d r50, boolean r51) {
        /*
            Method dump skipped, instructions count: 1889
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.d.c(w0.d, boolean):void");
    }

    public boolean d() {
        return this.f6528j0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x036e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0416 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0491 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04bb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:354:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(w0.d r32, boolean r33, boolean r34, boolean r35, boolean r36, w0.f r37, w0.f r38, int r39, boolean r40, y0.c r41, y0.c r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            Method dump skipped, instructions count: 1311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.d.e(w0.d, boolean, boolean, boolean, boolean, w0.f, w0.f, int, boolean, y0.c, y0.c, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x013a, code lost:
        if (r10 != null) goto L_0x018d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0161, code lost:
        if (r10.h() != false) goto L_0x018a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0188, code lost:
        if (r10.h() != false) goto L_0x018a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x018a, code lost:
        r11.j();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(y0.c.a r11, y0.d r12, y0.c.a r13, int r14) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.d.f(y0.c$a, y0.d, y0.c$a, int):void");
    }

    public final void g(c cVar, c cVar2, int i7) {
        if (cVar.f6497d == this) {
            f(cVar.e, cVar2.f6497d, cVar2.e, i7);
        }
    }

    public final void h(w0.d dVar) {
        dVar.l(this.K);
        dVar.l(this.L);
        dVar.l(this.M);
        dVar.l(this.N);
        if (this.f6517d0 > 0) {
            dVar.l(this.O);
        }
    }

    public final void i() {
        if (this.f6516d == null) {
            this.f6516d = new l(this);
        }
        if (this.e == null) {
            this.e = new n(this);
        }
    }

    public c j(c.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.K;
            case 2:
                return this.L;
            case 3:
                return this.M;
            case 4:
                return this.N;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                return this.O;
            case 6:
                return this.R;
            case 7:
                return this.P;
            case 8:
                return this.Q;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public final int k(int i7) {
        if (i7 == 0) {
            return this.V[0];
        }
        if (i7 == 1) {
            return this.V[1];
        }
        return 0;
    }

    public final int l() {
        if (this.f6528j0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public final d m(int i7) {
        c cVar;
        c cVar2;
        if (i7 == 0) {
            c cVar3 = this.M;
            c cVar4 = cVar3.f6498f;
            if (cVar4 == null || cVar4.f6498f != cVar3) {
                return null;
            }
            return cVar4.f6497d;
        } else if (i7 == 1 && (cVar2 = (cVar = this.N).f6498f) != null && cVar2.f6498f == cVar) {
            return cVar2.f6497d;
        } else {
            return null;
        }
    }

    public final p n(int i7) {
        if (i7 == 0) {
            return this.f6516d;
        }
        if (i7 == 1) {
            return this.e;
        }
        return null;
    }

    public void o(StringBuilder sb) {
        StringBuilder d7 = h.d("  ");
        d7.append(this.f6529k);
        d7.append(":{\n");
        sb.append(d7.toString());
        sb.append("    actualWidth:" + this.X);
        sb.append("\n");
        sb.append("    actualHeight:" + this.Y);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f6513b0);
        sb.append("\n");
        sb.append("    actualTop:" + this.f6515c0);
        sb.append("\n");
        q(sb, "left", this.K);
        q(sb, "top", this.L);
        q(sb, "right", this.M);
        q(sb, "bottom", this.N);
        q(sb, "baseline", this.O);
        q(sb, "centerX", this.P);
        q(sb, "centerY", this.Q);
        int i7 = this.X;
        int i8 = this.f6518e0;
        int i9 = this.D[0];
        int i10 = this.f6546v;
        int i11 = this.s;
        float f7 = this.f6548x;
        float f8 = this.f6535n0[0];
        p(sb, "    width", i7, i8, i9, i10, i11, f7);
        int i12 = this.Y;
        int i13 = this.f6520f0;
        int i14 = this.D[1];
        int i15 = this.f6549y;
        int i16 = this.f6544t;
        float f9 = this.A;
        float f10 = this.f6535n0[1];
        p(sb, "    height", i12, i13, i14, i15, i16, f9);
        float f11 = this.Z;
        int i17 = this.f6511a0;
        if (f11 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f11);
            sb.append(",");
            sb.append(i17);
            sb.append("");
            sb.append("],\n");
        }
        I(sb, "    horizontalBias", this.f6522g0, 0.5f);
        I(sb, "    verticalBias", this.f6524h0, 0.5f);
        H(this.f6532l0, 0, "    horizontalChainStyle", sb);
        H(this.f6533m0, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int r() {
        if (this.f6528j0 == 8) {
            return 0;
        }
        return this.X;
    }

    public final int s() {
        d dVar = this.W;
        return (dVar == null || !(dVar instanceof e)) ? this.f6513b0 : ((e) dVar).f6557z0 + this.f6513b0;
    }

    public final int t() {
        d dVar = this.W;
        return (dVar == null || !(dVar instanceof e)) ? this.f6515c0 : ((e) dVar).A0 + this.f6515c0;
    }

    public String toString() {
        String str = "";
        StringBuilder d7 = h.d(str);
        if (this.f6530k0 != null) {
            str = h.c(h.d("id: "), this.f6530k0, " ");
        }
        d7.append(str);
        d7.append("(");
        d7.append(this.f6513b0);
        d7.append(", ");
        d7.append(this.f6515c0);
        d7.append(") - (");
        d7.append(this.X);
        d7.append(" x ");
        d7.append(this.Y);
        d7.append(")");
        return d7.toString();
    }

    public final boolean u(int i7) {
        if (i7 == 0) {
            return (this.K.f6498f != null ? 1 : 0) + (this.M.f6498f != null ? 1 : 0) < 2;
        }
        return ((this.L.f6498f != null ? 1 : 0) + (this.N.f6498f != null ? 1 : 0)) + (this.O.f6498f != null ? 1 : 0) < 2;
    }

    public final boolean v(int i7, int i8) {
        c cVar;
        c cVar2;
        if (i7 == 0) {
            c cVar3 = this.K.f6498f;
            if (cVar3 != null && cVar3.f6496c && (cVar2 = this.M.f6498f) != null && cVar2.f6496c) {
                return (cVar2.d() - this.M.e()) - (this.K.e() + this.K.f6498f.d()) >= i8;
            }
        } else {
            c cVar4 = this.L.f6498f;
            if (cVar4 != null && cVar4.f6496c && (cVar = this.N.f6498f) != null && cVar.f6496c) {
                return (cVar.d() - this.N.e()) - (this.L.e() + this.L.f6498f.d()) >= i8;
            }
        }
        return false;
    }

    public final void w(c.a aVar, d dVar, c.a aVar2, int i7, int i8) {
        j(aVar).b(dVar.j(aVar2), i7, i8, true);
    }

    public final boolean x(int i7) {
        c cVar;
        c cVar2;
        int i8 = i7 * 2;
        c[] cVarArr = this.S;
        c cVar3 = cVarArr[i8];
        c cVar4 = cVar3.f6498f;
        return (cVar4 == null || cVar4.f6498f == cVar3 || (cVar2 = (cVar = cVarArr[i8 + 1]).f6498f) == null || cVar2.f6498f != cVar) ? false : true;
    }

    public final boolean y() {
        c cVar = this.K;
        c cVar2 = cVar.f6498f;
        if (cVar2 != null && cVar2.f6498f == cVar) {
            return true;
        }
        c cVar3 = this.M;
        c cVar4 = cVar3.f6498f;
        return cVar4 != null && cVar4.f6498f == cVar3;
    }

    public final boolean z() {
        c cVar = this.L;
        c cVar2 = cVar.f6498f;
        if (cVar2 != null && cVar2.f6498f == cVar) {
            return true;
        }
        c cVar3 = this.N;
        c cVar4 = cVar3.f6498f;
        return cVar4 != null && cVar4.f6498f == cVar3;
    }
}
