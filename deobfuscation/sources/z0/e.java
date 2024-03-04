package z0;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import z0.b;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public y0.e f6865a;

    /* renamed from: d */
    public y0.e f6868d;

    /* renamed from: f */
    public b.InterfaceC0136b f6869f;

    /* renamed from: g */
    public b.a f6870g;

    /* renamed from: h */
    public ArrayList<m> f6871h;

    /* renamed from: b */
    public boolean f6866b = true;

    /* renamed from: c */
    public boolean f6867c = true;
    public ArrayList<p> e = new ArrayList<>();

    public e(y0.e eVar) {
        new ArrayList();
        this.f6869f = null;
        this.f6870g = new b.a();
        this.f6871h = new ArrayList<>();
        this.f6865a = eVar;
        this.f6868d = eVar;
    }

    public final void a(f fVar, int i7, int i8, ArrayList arrayList, m mVar) {
        p pVar = fVar.f6875d;
        if (pVar.f6896c == null) {
            y0.e eVar = this.f6865a;
            if (pVar == eVar.f6516d || pVar == eVar.e) {
                return;
            }
            if (mVar == null) {
                mVar = new m(pVar);
                arrayList.add(mVar);
            }
            pVar.f6896c = mVar;
            mVar.f6886b.add(pVar);
            Iterator it = pVar.f6900h.f6881k.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar instanceof f) {
                    a((f) dVar, i7, 0, arrayList, mVar);
                }
            }
            Iterator it2 = pVar.f6901i.f6881k.iterator();
            while (it2.hasNext()) {
                d dVar2 = (d) it2.next();
                if (dVar2 instanceof f) {
                    a((f) dVar2, i7, 1, arrayList, mVar);
                }
            }
            if (i7 == 1 && (pVar instanceof n)) {
                Iterator it3 = ((n) pVar).f6887k.f6881k.iterator();
                while (it3.hasNext()) {
                    d dVar3 = (d) it3.next();
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i7, 2, arrayList, mVar);
                    }
                }
            }
            Iterator it4 = pVar.f6900h.f6882l.iterator();
            while (it4.hasNext()) {
                a((f) it4.next(), i7, 0, arrayList, mVar);
            }
            Iterator it5 = pVar.f6901i.f6882l.iterator();
            while (it5.hasNext()) {
                a((f) it5.next(), i7, 1, arrayList, mVar);
            }
            if (i7 == 1 && (pVar instanceof n)) {
                Iterator it6 = ((n) pVar).f6887k.f6882l.iterator();
                while (it6.hasNext()) {
                    a((f) it6.next(), i7, 2, arrayList, mVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:530:0x005f, code lost:
        if (r2.f6544t == 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(y0.e r18) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.e.b(y0.e):void");
    }

    public final void c() {
        p jVar;
        ArrayList<p> arrayList = this.e;
        arrayList.clear();
        this.f6868d.f6516d.f();
        this.f6868d.e.f();
        arrayList.add(this.f6868d.f6516d);
        arrayList.add(this.f6868d.e);
        Iterator<y0.d> it = this.f6868d.f6591s0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            y0.d next = it.next();
            if (next instanceof y0.g) {
                jVar = new j(next);
            } else {
                if (next.y()) {
                    if (next.f6512b == null) {
                        next.f6512b = new c(0, next);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f6512b);
                } else {
                    arrayList.add(next.f6516d);
                }
                if (next.z()) {
                    if (next.f6514c == null) {
                        next.f6514c = new c(1, next);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f6514c);
                } else {
                    arrayList.add(next.e);
                }
                if (next instanceof y0.i) {
                    jVar = new k(next);
                }
            }
            arrayList.add(jVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<p> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<p> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p next2 = it3.next();
            if (next2.f6895b != this.f6868d) {
                next2.d();
            }
        }
        this.f6871h.clear();
        e(this.f6865a.f6516d, 0, this.f6871h);
        e(this.f6865a.e, 1, this.f6871h);
        this.f6866b = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0064 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int d(y0.e r17, int r18) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.e.d(y0.e, int):int");
    }

    public final void e(p pVar, int i7, ArrayList<m> arrayList) {
        Iterator it = pVar.f6900h.f6881k.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar instanceof f) {
                a((f) dVar, i7, 0, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f6900h, i7, 0, arrayList, null);
            }
        }
        Iterator it2 = pVar.f6901i.f6881k.iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2 instanceof f) {
                a((f) dVar2, i7, 1, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f6901i, i7, 1, arrayList, null);
            }
        }
        if (i7 == 1) {
            Iterator it3 = ((n) pVar).f6887k.f6881k.iterator();
            while (it3.hasNext()) {
                d dVar3 = (d) it3.next();
                if (dVar3 instanceof f) {
                    a((f) dVar3, i7, 2, arrayList, null);
                }
            }
        }
    }

    public final void f(y0.d dVar, int i7, int i8, int i9, int i10) {
        b.a aVar = this.f6870g;
        aVar.f6854a = i7;
        aVar.f6855b = i9;
        aVar.f6856c = i8;
        aVar.f6857d = i10;
        ((ConstraintLayout.b) this.f6869f).b(dVar, aVar);
        dVar.O(this.f6870g.e);
        dVar.L(this.f6870g.f6858f);
        b.a aVar2 = this.f6870g;
        dVar.F = aVar2.f6860h;
        int i11 = aVar2.f6859g;
        dVar.f6517d0 = i11;
        dVar.F = i11 > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:176:0x006b, code lost:
        if (r10 == 3) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0085, code lost:
        if (r8 == 3) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0087, code lost:
        r2.m = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x008a, code lost:
        r2.d(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            r12 = this;
            y0.e r0 = r12.f6865a
            java.util.ArrayList<y0.d> r0 = r0.f6591s0
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto La0
            java.lang.Object r1 = r0.next()
            y0.d r1 = (y0.d) r1
            boolean r2 = r1.f6510a
            if (r2 == 0) goto L19
            goto L8
        L19:
            int[] r2 = r1.V
            r3 = 0
            r8 = r2[r3]
            r9 = 1
            r10 = r2[r9]
            int r2 = r1.s
            int r4 = r1.f6544t
            r5 = 2
            r11 = 3
            if (r8 == r5) goto L30
            if (r8 != r11) goto L2e
            if (r2 != r9) goto L2e
            goto L30
        L2e:
            r2 = r3
            goto L31
        L30:
            r2 = r9
        L31:
            if (r10 == r5) goto L37
            if (r10 != r11) goto L38
            if (r4 != r9) goto L38
        L37:
            r3 = r9
        L38:
            z0.l r4 = r1.f6516d
            z0.g r4 = r4.e
            boolean r5 = r4.f6880j
            z0.n r6 = r1.e
            z0.g r6 = r6.e
            boolean r7 = r6.f6880j
            if (r5 == 0) goto L54
            if (r7 == 0) goto L54
            int r5 = r4.f6877g
            int r7 = r6.f6877g
            r6 = 1
            r2 = r12
            r3 = r1
            r4 = r6
            r2.f(r3, r4, r5, r6, r7)
            goto L8d
        L54:
            if (r5 == 0) goto L6e
            if (r3 == 0) goto L6e
            int r5 = r4.f6877g
            int r7 = r6.f6877g
            r4 = 1
            r6 = 2
            r2 = r12
            r3 = r1
            r2.f(r3, r4, r5, r6, r7)
            z0.n r2 = r1.e
            z0.g r2 = r2.e
            int r3 = r1.l()
            if (r10 != r11) goto L8a
            goto L87
        L6e:
            if (r7 == 0) goto L8f
            if (r2 == 0) goto L8f
            int r5 = r4.f6877g
            int r7 = r6.f6877g
            r4 = 2
            r6 = 1
            r2 = r12
            r3 = r1
            r2.f(r3, r4, r5, r6, r7)
            z0.l r2 = r1.f6516d
            z0.g r2 = r2.e
            int r3 = r1.r()
            if (r8 != r11) goto L8a
        L87:
            r2.m = r3
            goto L8f
        L8a:
            r2.d(r3)
        L8d:
            r1.f6510a = r9
        L8f:
            boolean r2 = r1.f6510a
            if (r2 == 0) goto L8
            z0.n r2 = r1.e
            z0.a r2 = r2.f6888l
            if (r2 == 0) goto L8
            int r1 = r1.f6517d0
            r2.d(r1)
            goto L8
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.e.g():void");
    }
}
