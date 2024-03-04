package z0;

import java.util.HashSet;
import java.util.Iterator;
import y0.c;
import z0.b;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a */
    public static b.a f6883a = new b.a();

    public static boolean a(y0.d dVar) {
        int[] iArr = dVar.V;
        int i7 = iArr[0];
        int i8 = iArr[1];
        y0.d dVar2 = dVar.W;
        y0.e eVar = dVar2 != null ? (y0.e) dVar2 : null;
        if (eVar != null) {
            int i9 = eVar.V[0];
        }
        if (eVar != null) {
            int i10 = eVar.V[1];
        }
        boolean z6 = i7 == 1 || dVar.B() || i7 == 2 || (i7 == 3 && dVar.s == 0 && dVar.Z == 0.0f && dVar.u(0)) || (i7 == 3 && dVar.s == 1 && dVar.v(0, dVar.r()));
        boolean z7 = i8 == 1 || dVar.C() || i8 == 2 || (i8 == 3 && dVar.f6544t == 0 && dVar.Z == 0.0f && dVar.u(1)) || (i8 == 3 && dVar.f6544t == 1 && dVar.v(1, dVar.l()));
        if (dVar.Z <= 0.0f || !(z6 || z7)) {
            return z6 && z7;
        }
        return true;
    }

    public static void b(int i7, y0.d dVar, b.InterfaceC0136b interfaceC0136b, boolean z6) {
        y0.c cVar;
        y0.c cVar2;
        y0.c cVar3;
        y0.c cVar4;
        if (dVar.f6534n) {
            return;
        }
        if (!(dVar instanceof y0.e) && dVar.A() && a(dVar)) {
            y0.e.V(dVar, interfaceC0136b, new b.a());
        }
        y0.c j5 = dVar.j(c.a.LEFT);
        y0.c j7 = dVar.j(c.a.RIGHT);
        int d7 = j5.d();
        int d8 = j7.d();
        HashSet<y0.c> hashSet = j5.f6494a;
        if (hashSet != null && j5.f6496c) {
            Iterator<y0.c> it = hashSet.iterator();
            while (it.hasNext()) {
                y0.c next = it.next();
                y0.d dVar2 = next.f6497d;
                int i8 = i7 + 1;
                boolean a7 = a(dVar2);
                if (dVar2.A() && a7) {
                    y0.e.V(dVar2, interfaceC0136b, new b.a());
                }
                y0.c cVar5 = dVar2.K;
                boolean z7 = (next == cVar5 && (cVar4 = dVar2.M.f6498f) != null && cVar4.f6496c) || (next == dVar2.M && (cVar3 = cVar5.f6498f) != null && cVar3.f6496c);
                int i9 = dVar2.V[0];
                if (i9 != 3 || a7) {
                    if (!dVar2.A()) {
                        y0.c cVar6 = dVar2.K;
                        if (next == cVar6 && dVar2.M.f6498f == null) {
                            int e = cVar6.e() + d7;
                            dVar2.J(e, dVar2.r() + e);
                        } else {
                            y0.c cVar7 = dVar2.M;
                            if (next == cVar7 && cVar6.f6498f == null) {
                                int e7 = d7 - cVar7.e();
                                dVar2.J(e7 - dVar2.r(), e7);
                            } else if (z7 && !dVar2.y()) {
                                c(i8, dVar2, interfaceC0136b, z6);
                            }
                        }
                        b(i8, dVar2, interfaceC0136b, z6);
                    }
                } else if (i9 == 3 && dVar2.f6547w >= 0 && dVar2.f6546v >= 0 && (dVar2.f6528j0 == 8 || (dVar2.s == 0 && dVar2.Z == 0.0f))) {
                    if (!dVar2.y() && !dVar2.H && z7 && !dVar2.y()) {
                        d(i8, dVar, interfaceC0136b, dVar2, z6);
                    }
                }
            }
        }
        if (dVar instanceof y0.g) {
            return;
        }
        HashSet<y0.c> hashSet2 = j7.f6494a;
        if (hashSet2 != null && j7.f6496c) {
            Iterator<y0.c> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                y0.c next2 = it2.next();
                y0.d dVar3 = next2.f6497d;
                int i10 = i7 + 1;
                boolean a8 = a(dVar3);
                if (dVar3.A() && a8) {
                    y0.e.V(dVar3, interfaceC0136b, new b.a());
                }
                y0.c cVar8 = dVar3.K;
                boolean z8 = (next2 == cVar8 && (cVar2 = dVar3.M.f6498f) != null && cVar2.f6496c) || (next2 == dVar3.M && (cVar = cVar8.f6498f) != null && cVar.f6496c);
                int i11 = dVar3.V[0];
                if (i11 != 3 || a8) {
                    if (!dVar3.A()) {
                        y0.c cVar9 = dVar3.K;
                        if (next2 == cVar9 && dVar3.M.f6498f == null) {
                            int e8 = cVar9.e() + d8;
                            dVar3.J(e8, dVar3.r() + e8);
                        } else {
                            y0.c cVar10 = dVar3.M;
                            if (next2 == cVar10 && cVar9.f6498f == null) {
                                int e9 = d8 - cVar10.e();
                                dVar3.J(e9 - dVar3.r(), e9);
                            } else if (z8 && !dVar3.y()) {
                                c(i10, dVar3, interfaceC0136b, z6);
                            }
                        }
                        b(i10, dVar3, interfaceC0136b, z6);
                    }
                } else if (i11 == 3 && dVar3.f6547w >= 0 && dVar3.f6546v >= 0) {
                    if (dVar3.f6528j0 != 8) {
                        if (dVar3.s == 0) {
                            if (dVar3.Z == 0.0f) {
                            }
                        }
                    }
                    if (!dVar3.y() && !dVar3.H && z8 && !dVar3.y()) {
                        d(i10, dVar, interfaceC0136b, dVar3, z6);
                    }
                }
            }
        }
        dVar.f6534n = true;
    }

    public static void c(int i7, y0.d dVar, b.InterfaceC0136b interfaceC0136b, boolean z6) {
        float f7 = dVar.f6522g0;
        int d7 = dVar.K.f6498f.d();
        int d8 = dVar.M.f6498f.d();
        int e = dVar.K.e() + d7;
        int e7 = d8 - dVar.M.e();
        if (d7 == d8) {
            f7 = 0.5f;
        } else {
            d7 = e;
            d8 = e7;
        }
        int r6 = dVar.r();
        int i8 = (d8 - d7) - r6;
        if (d7 > d8) {
            i8 = (d7 - d8) - r6;
        }
        int i9 = ((int) (i8 > 0 ? (f7 * i8) + 0.5f : f7 * i8)) + d7;
        int i10 = i9 + r6;
        if (d7 > d8) {
            i10 = i9 - r6;
        }
        dVar.J(i9, i10);
        b(i7 + 1, dVar, interfaceC0136b, z6);
    }

    public static void d(int i7, y0.d dVar, b.InterfaceC0136b interfaceC0136b, y0.d dVar2, boolean z6) {
        float f7 = dVar2.f6522g0;
        int e = dVar2.K.e() + dVar2.K.f6498f.d();
        int d7 = dVar2.M.f6498f.d() - dVar2.M.e();
        if (d7 >= e) {
            int r6 = dVar2.r();
            if (dVar2.f6528j0 != 8) {
                int i8 = dVar2.s;
                if (i8 == 2) {
                    if (!(dVar instanceof y0.e)) {
                        dVar = dVar.W;
                    }
                    r6 = (int) (dVar2.f6522g0 * 0.5f * dVar.r());
                } else if (i8 == 0) {
                    r6 = d7 - e;
                }
                r6 = Math.max(dVar2.f6546v, r6);
                int i9 = dVar2.f6547w;
                if (i9 > 0) {
                    r6 = Math.min(i9, r6);
                }
            }
            int i10 = e + ((int) ((f7 * ((d7 - e) - r6)) + 0.5f));
            dVar2.J(i10, r6 + i10);
            b(i7 + 1, dVar2, interfaceC0136b, z6);
        }
    }

    public static void e(int i7, y0.d dVar, b.InterfaceC0136b interfaceC0136b) {
        float f7 = dVar.f6524h0;
        int d7 = dVar.L.f6498f.d();
        int d8 = dVar.N.f6498f.d();
        int e = dVar.L.e() + d7;
        int e7 = d8 - dVar.N.e();
        if (d7 == d8) {
            f7 = 0.5f;
        } else {
            d7 = e;
            d8 = e7;
        }
        int l6 = dVar.l();
        int i8 = (d8 - d7) - l6;
        if (d7 > d8) {
            i8 = (d7 - d8) - l6;
        }
        int i9 = (int) (i8 > 0 ? (f7 * i8) + 0.5f : f7 * i8);
        int i10 = d7 + i9;
        int i11 = i10 + l6;
        if (d7 > d8) {
            i10 = d7 - i9;
            i11 = i10 - l6;
        }
        dVar.K(i10, i11);
        g(i7 + 1, dVar, interfaceC0136b);
    }

    public static void f(int i7, y0.d dVar, b.InterfaceC0136b interfaceC0136b, y0.d dVar2) {
        float f7 = dVar2.f6524h0;
        int e = dVar2.L.e() + dVar2.L.f6498f.d();
        int d7 = dVar2.N.f6498f.d() - dVar2.N.e();
        if (d7 >= e) {
            int l6 = dVar2.l();
            if (dVar2.f6528j0 != 8) {
                int i8 = dVar2.f6544t;
                if (i8 == 2) {
                    if (!(dVar instanceof y0.e)) {
                        dVar = dVar.W;
                    }
                    l6 = (int) (f7 * 0.5f * dVar.l());
                } else if (i8 == 0) {
                    l6 = d7 - e;
                }
                l6 = Math.max(dVar2.f6549y, l6);
                int i9 = dVar2.f6550z;
                if (i9 > 0) {
                    l6 = Math.min(i9, l6);
                }
            }
            int i10 = e + ((int) ((f7 * ((d7 - e) - l6)) + 0.5f));
            dVar2.K(i10, l6 + i10);
            g(i7 + 1, dVar2, interfaceC0136b);
        }
    }

    public static void g(int i7, y0.d dVar, b.InterfaceC0136b interfaceC0136b) {
        y0.c cVar;
        y0.c cVar2;
        y0.c cVar3;
        y0.c cVar4;
        if (dVar.f6536o) {
            return;
        }
        if (!(dVar instanceof y0.e) && dVar.A() && a(dVar)) {
            y0.e.V(dVar, interfaceC0136b, new b.a());
        }
        y0.c j5 = dVar.j(c.a.TOP);
        y0.c j7 = dVar.j(c.a.BOTTOM);
        int d7 = j5.d();
        int d8 = j7.d();
        HashSet<y0.c> hashSet = j5.f6494a;
        if (hashSet != null && j5.f6496c) {
            Iterator<y0.c> it = hashSet.iterator();
            while (it.hasNext()) {
                y0.c next = it.next();
                y0.d dVar2 = next.f6497d;
                int i8 = i7 + 1;
                boolean a7 = a(dVar2);
                if (dVar2.A() && a7) {
                    y0.e.V(dVar2, interfaceC0136b, new b.a());
                }
                y0.c cVar5 = dVar2.L;
                boolean z6 = (next == cVar5 && (cVar4 = dVar2.N.f6498f) != null && cVar4.f6496c) || (next == dVar2.N && (cVar3 = cVar5.f6498f) != null && cVar3.f6496c);
                int i9 = dVar2.V[1];
                if (i9 != 3 || a7) {
                    if (!dVar2.A()) {
                        y0.c cVar6 = dVar2.L;
                        if (next == cVar6 && dVar2.N.f6498f == null) {
                            int e = cVar6.e() + d7;
                            dVar2.K(e, dVar2.l() + e);
                        } else {
                            y0.c cVar7 = dVar2.N;
                            if (next == cVar7 && cVar6.f6498f == null) {
                                int e7 = d7 - cVar7.e();
                                dVar2.K(e7 - dVar2.l(), e7);
                            } else if (z6 && !dVar2.z()) {
                                e(i8, dVar2, interfaceC0136b);
                            }
                        }
                        g(i8, dVar2, interfaceC0136b);
                    }
                } else if (i9 == 3 && dVar2.f6550z >= 0 && dVar2.f6549y >= 0 && (dVar2.f6528j0 == 8 || (dVar2.f6544t == 0 && dVar2.Z == 0.0f))) {
                    if (!dVar2.z() && !dVar2.H && z6 && !dVar2.z()) {
                        f(i8, dVar, interfaceC0136b, dVar2);
                    }
                }
            }
        }
        if (dVar instanceof y0.g) {
            return;
        }
        HashSet<y0.c> hashSet2 = j7.f6494a;
        if (hashSet2 != null && j7.f6496c) {
            Iterator<y0.c> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                y0.c next2 = it2.next();
                y0.d dVar3 = next2.f6497d;
                int i10 = i7 + 1;
                boolean a8 = a(dVar3);
                if (dVar3.A() && a8) {
                    y0.e.V(dVar3, interfaceC0136b, new b.a());
                }
                y0.c cVar8 = dVar3.L;
                boolean z7 = (next2 == cVar8 && (cVar2 = dVar3.N.f6498f) != null && cVar2.f6496c) || (next2 == dVar3.N && (cVar = cVar8.f6498f) != null && cVar.f6496c);
                int i11 = dVar3.V[1];
                if (i11 != 3 || a8) {
                    if (!dVar3.A()) {
                        y0.c cVar9 = dVar3.L;
                        if (next2 == cVar9 && dVar3.N.f6498f == null) {
                            int e8 = cVar9.e() + d8;
                            dVar3.K(e8, dVar3.l() + e8);
                        } else {
                            y0.c cVar10 = dVar3.N;
                            if (next2 == cVar10 && cVar9.f6498f == null) {
                                int e9 = d8 - cVar10.e();
                                dVar3.K(e9 - dVar3.l(), e9);
                            } else if (z7 && !dVar3.z()) {
                                e(i10, dVar3, interfaceC0136b);
                            }
                        }
                        g(i10, dVar3, interfaceC0136b);
                    }
                } else if (i11 == 3 && dVar3.f6550z >= 0 && dVar3.f6549y >= 0 && (dVar3.f6528j0 == 8 || (dVar3.f6544t == 0 && dVar3.Z == 0.0f))) {
                    if (!dVar3.z() && !dVar3.H && z7 && !dVar3.z()) {
                        f(i10, dVar, interfaceC0136b, dVar3);
                    }
                }
            }
        }
        y0.c j8 = dVar.j(c.a.BASELINE);
        if (j8.f6494a != null && j8.f6496c) {
            int d9 = j8.d();
            Iterator<y0.c> it3 = j8.f6494a.iterator();
            while (it3.hasNext()) {
                y0.c next3 = it3.next();
                y0.d dVar4 = next3.f6497d;
                int i12 = i7 + 1;
                boolean a9 = a(dVar4);
                if (dVar4.A() && a9) {
                    y0.e.V(dVar4, interfaceC0136b, new b.a());
                }
                if (dVar4.V[1] != 3 || a9) {
                    if (!dVar4.A() && next3 == dVar4.O) {
                        int e10 = next3.e() + d9;
                        if (dVar4.F) {
                            int i13 = e10 - dVar4.f6517d0;
                            int i14 = dVar4.Y + i13;
                            dVar4.f6515c0 = i13;
                            dVar4.L.l(i13);
                            dVar4.N.l(i14);
                            dVar4.O.l(e10);
                            dVar4.m = true;
                        }
                        g(i12, dVar4, interfaceC0136b);
                    }
                }
            }
        }
        dVar.f6536o = true;
    }
}
