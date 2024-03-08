package y0;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import l0.z;
import q2.a;
import w0.d;
import z0.b;
import z0.c;
import z0.g;
import z0.p;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends k {
    public int A0;

    /* renamed from: v0 */
    public int f6553v0;

    /* renamed from: z0 */
    public int f6557z0;

    /* renamed from: t0 */
    public b f6551t0 = new b(this);

    /* renamed from: u0 */
    public z0.e f6552u0 = new z0.e(this);

    /* renamed from: w0 */
    public b.AbstractC0136b f6554w0 = null;

    /* renamed from: x0 */
    public boolean f6555x0 = false;

    /* renamed from: y0 */
    public d f6556y0 = new d();
    public int B0 = 0;
    public int C0 = 0;
    public b[] D0 = new b[4];
    public b[] E0 = new b[4];
    public int F0 = 257;
    public boolean G0 = false;
    public boolean H0 = false;
    public WeakReference<c> I0 = null;
    public WeakReference<c> J0 = null;
    public WeakReference<c> K0 = null;
    public WeakReference<c> L0 = null;
    public HashSet<d> M0 = new HashSet<>();
    public b.a N0 = new b.a();

    public static void V(d dVar, b.AbstractC0136b bVar, b.a aVar) {
        int i7;
        int i8;
        if (bVar != null) {
            if (dVar.f6528j0 == 8 || (dVar instanceof g) || (dVar instanceof a)) {
                aVar.e = 0;
                aVar.f6858f = 0;
                return;
            }
            int[] iArr = dVar.V;
            aVar.f6854a = iArr[0];
            boolean z6 = true;
            aVar.f6855b = iArr[1];
            aVar.f6856c = dVar.r();
            aVar.f6857d = dVar.l();
            aVar.f6861i = false;
            aVar.f6862j = 0;
            boolean z7 = aVar.f6854a == 3;
            boolean z8 = aVar.f6855b == 3;
            boolean z9 = z7 && dVar.Z > 0.0f;
            boolean z10 = z8 && dVar.Z > 0.0f;
            if (z7 && dVar.u(0) && dVar.s == 0 && !z9) {
                aVar.f6854a = 2;
                if (z8 && dVar.f6544t == 0) {
                    aVar.f6854a = 1;
                }
                z7 = false;
            }
            if (z8 && dVar.u(1) && dVar.f6544t == 0 && !z10) {
                aVar.f6855b = 2;
                if (z7 && dVar.s == 0) {
                    aVar.f6855b = 1;
                }
                z8 = false;
            }
            if (dVar.B()) {
                aVar.f6854a = 1;
                z7 = false;
            }
            if (dVar.C()) {
                aVar.f6855b = 1;
                z8 = false;
            }
            if (z9) {
                if (dVar.f6545u[0] == 4) {
                    aVar.f6854a = 1;
                } else if (!z8) {
                    if (aVar.f6855b == 1) {
                        i8 = aVar.f6857d;
                    } else {
                        aVar.f6854a = 2;
                        ((ConstraintLayout.b) bVar).b(dVar, aVar);
                        i8 = aVar.f6858f;
                    }
                    aVar.f6854a = 1;
                    aVar.f6856c = (int) (dVar.Z * ((float) i8));
                }
            }
            if (z10) {
                if (dVar.f6545u[1] == 4) {
                    aVar.f6855b = 1;
                } else if (!z7) {
                    if (aVar.f6854a == 1) {
                        i7 = aVar.f6856c;
                    } else {
                        aVar.f6855b = 2;
                        ((ConstraintLayout.b) bVar).b(dVar, aVar);
                        i7 = aVar.e;
                    }
                    aVar.f6855b = 1;
                    aVar.f6857d = dVar.f6511a0 == -1 ? (int) (((float) i7) / dVar.Z) : (int) (dVar.Z * ((float) i7));
                }
            }
            ((ConstraintLayout.b) bVar).b(dVar, aVar);
            dVar.O(aVar.e);
            dVar.L(aVar.f6858f);
            dVar.F = aVar.f6860h;
            int i9 = aVar.f6859g;
            dVar.f6517d0 = i9;
            if (i9 <= 0) {
                z6 = false;
            }
            dVar.F = z6;
            aVar.f6862j = 0;
        }
    }

    @Override // y0.k, y0.d
    public final void D() {
        this.f6556y0.u();
        this.f6557z0 = 0;
        this.A0 = 0;
        super.D();
    }

    @Override // y0.d
    public final void P(boolean z6, boolean z7) {
        super.P(z6, z7);
        int size = this.f6591s0.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f6591s0.get(i7).P(z6, z7);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:344:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x05e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x060d  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0623  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x065a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x067b  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x07da  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0807 A[LOOP:34: B:474:0x0805->B:475:0x0807, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:487:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x089b  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x08d9  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:617:0x08e1 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // y0.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R() {
        /*
            Method dump skipped, instructions count: 2300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.e.R():void");
    }

    public final void S(int i7, d dVar) {
        if (i7 == 0) {
            int i8 = this.B0 + 1;
            b[] bVarArr = this.E0;
            if (i8 >= bVarArr.length) {
                this.E0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.E0;
            int i9 = this.B0;
            bVarArr2[i9] = new b(dVar, 0, this.f6555x0);
            this.B0 = i9 + 1;
        } else if (i7 == 1) {
            int i10 = this.C0 + 1;
            b[] bVarArr3 = this.D0;
            if (i10 >= bVarArr3.length) {
                this.D0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.D0;
            int i11 = this.C0;
            bVarArr4[i11] = new b(dVar, 1, this.f6555x0);
            this.C0 = i11 + 1;
        }
    }

    public final void T(d dVar) {
        boolean z6;
        boolean W = W(64);
        c(dVar, W);
        int size = this.f6591s0.size();
        boolean z7 = false;
        for (int i7 = 0; i7 < size; i7++) {
            d dVar2 = this.f6591s0.get(i7);
            boolean[] zArr = dVar2.U;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar2 instanceof a) {
                z7 = true;
            }
        }
        if (z7) {
            for (int i8 = 0; i8 < size; i8++) {
                d dVar3 = this.f6591s0.get(i8);
                if (dVar3 instanceof a) {
                    a aVar = (a) dVar3;
                    for (int i9 = 0; i9 < aVar.f6584t0; i9++) {
                        d dVar4 = aVar.f6583s0[i9];
                        if (aVar.f6476v0 || dVar4.d()) {
                            int i10 = aVar.f6475u0;
                            if (i10 == 0 || i10 == 1) {
                                dVar4.U[0] = true;
                            } else if (i10 == 2 || i10 == 3) {
                                dVar4.U[1] = true;
                            }
                        }
                    }
                }
            }
        }
        this.M0.clear();
        for (int i11 = 0; i11 < size; i11++) {
            d dVar5 = this.f6591s0.get(i11);
            dVar5.getClass();
            if ((dVar5 instanceof j) || (dVar5 instanceof g)) {
                if (dVar5 instanceof j) {
                    this.M0.add(dVar5);
                } else {
                    dVar5.c(dVar, W);
                }
            }
        }
        while (this.M0.size() > 0) {
            int size2 = this.M0.size();
            Iterator<d> it = this.M0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j jVar = (j) it.next();
                HashSet<d> hashSet = this.M0;
                int i12 = 0;
                while (true) {
                    if (i12 >= jVar.f6584t0) {
                        z6 = false;
                        continue;
                        break;
                    } else if (hashSet.contains(jVar.f6583s0[i12])) {
                        z6 = true;
                        continue;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (z6) {
                    jVar.c(dVar, W);
                    this.M0.remove(jVar);
                    break;
                }
            }
            if (size2 == this.M0.size()) {
                Iterator<d> it2 = this.M0.iterator();
                while (it2.hasNext()) {
                    it2.next().c(dVar, W);
                }
                this.M0.clear();
            }
        }
        if (d.f6341p) {
            HashSet<d> hashSet2 = new HashSet<>();
            for (int i13 = 0; i13 < size; i13++) {
                d dVar6 = this.f6591s0.get(i13);
                dVar6.getClass();
                if (!((dVar6 instanceof j) || (dVar6 instanceof g))) {
                    hashSet2.add(dVar6);
                }
            }
            b(this, dVar, hashSet2, this.V[0] == 2 ? 0 : 1, false);
            Iterator<d> it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                d next = it3.next();
                z.m(this, dVar, next);
                next.c(dVar, W);
            }
        } else {
            for (int i14 = 0; i14 < size; i14++) {
                d dVar7 = this.f6591s0.get(i14);
                if (dVar7 instanceof e) {
                    int[] iArr = dVar7.V;
                    int i15 = iArr[0];
                    int i16 = iArr[1];
                    if (i15 == 2) {
                        dVar7.M(1);
                    }
                    if (i16 == 2) {
                        dVar7.N(1);
                    }
                    dVar7.c(dVar, W);
                    if (i15 == 2) {
                        dVar7.M(i15);
                    }
                    if (i16 == 2) {
                        dVar7.N(i16);
                    }
                } else {
                    z.m(this, dVar, dVar7);
                    if (!((dVar7 instanceof j) || (dVar7 instanceof g))) {
                        dVar7.c(dVar, W);
                    }
                }
            }
        }
        if (this.B0 > 0) {
            a.d(this, dVar, null, 0);
        }
        if (this.C0 > 0) {
            a.d(this, dVar, null, 1);
        }
    }

    public final boolean U(int i7, boolean z6) {
        boolean z7;
        int i8;
        g gVar;
        int i9;
        g gVar2;
        z0.e eVar = this.f6552u0;
        boolean z8 = true;
        boolean z9 = z6 & true;
        int k6 = eVar.f6865a.k(0);
        int k7 = eVar.f6865a.k(1);
        int s = eVar.f6865a.s();
        int t5 = eVar.f6865a.t();
        if (z9 && (k6 == 2 || k7 == 2)) {
            Iterator<p> it = eVar.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                if (next.f6898f == i7 && !next.k()) {
                    z9 = false;
                    break;
                }
            }
            if (i7 == 0) {
                if (z9 && k6 == 2) {
                    eVar.f6865a.M(1);
                    e eVar2 = eVar.f6865a;
                    eVar2.O(eVar.d(eVar2, 0));
                    e eVar3 = eVar.f6865a;
                    gVar2 = eVar3.f6516d.e;
                    i9 = eVar3.r();
                    gVar2.d(i9);
                }
            } else if (z9 && k7 == 2) {
                eVar.f6865a.N(1);
                e eVar4 = eVar.f6865a;
                eVar4.L(eVar.d(eVar4, 1));
                e eVar5 = eVar.f6865a;
                gVar2 = eVar5.e.e;
                i9 = eVar5.l();
                gVar2.d(i9);
            }
        }
        e eVar6 = eVar.f6865a;
        int[] iArr = eVar6.V;
        if (i7 == 0) {
            int i10 = iArr[0];
            if (i10 == 1 || i10 == 4) {
                int r6 = eVar6.r() + s;
                eVar.f6865a.f6516d.f6901i.d(r6);
                gVar = eVar.f6865a.f6516d.e;
                i8 = r6 - s;
                gVar.d(i8);
                z7 = true;
            }
            z7 = false;
        } else {
            int i11 = iArr[1];
            if (i11 == 1 || i11 == 4) {
                int l6 = eVar6.l() + t5;
                eVar.f6865a.e.f6901i.d(l6);
                gVar = eVar.f6865a.e.e;
                i8 = l6 - t5;
                gVar.d(i8);
                z7 = true;
            }
            z7 = false;
        }
        eVar.g();
        Iterator<p> it2 = eVar.e.iterator();
        while (it2.hasNext()) {
            p next2 = it2.next();
            if (next2.f6898f == i7 && (next2.f6895b != eVar.f6865a || next2.f6899g)) {
                next2.e();
            }
        }
        Iterator<p> it3 = eVar.e.iterator();
        while (it3.hasNext()) {
            p next3 = it3.next();
            if (next3.f6898f == i7 && (z7 || next3.f6895b != eVar.f6865a)) {
                if (!next3.f6900h.f6880j || !next3.f6901i.f6880j || (!(next3 instanceof c) && !next3.e.f6880j)) {
                    z8 = false;
                    break;
                }
            }
        }
        eVar.f6865a.M(k6);
        eVar.f6865a.N(k7);
        return z8;
    }

    public final boolean W(int i7) {
        return (this.F0 & i7) == i7;
    }

    @Override // y0.d
    public final void o(StringBuilder sb) {
        sb.append(this.f6529k + ":{\n");
        sb.append("  actualWidth:" + this.X);
        sb.append("\n");
        sb.append("  actualHeight:" + this.Y);
        sb.append("\n");
        Iterator<d> it = this.f6591s0.iterator();
        while (it.hasNext()) {
            it.next().o(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
