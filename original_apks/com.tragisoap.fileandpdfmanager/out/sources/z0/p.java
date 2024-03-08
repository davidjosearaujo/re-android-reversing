package z0;

import y0.c;
import y0.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class p implements d {

    /* renamed from: a */
    public int f6894a;

    /* renamed from: b */
    public d f6895b;

    /* renamed from: c */
    public m f6896c;

    /* renamed from: d */
    public int f6897d;
    public g e = new g(this);

    /* renamed from: f */
    public int f6898f = 0;

    /* renamed from: g */
    public boolean f6899g = false;

    /* renamed from: h */
    public f f6900h = new f(this);

    /* renamed from: i */
    public f f6901i = new f(this);

    /* renamed from: j */
    public int f6902j = 1;

    public p(d dVar) {
        this.f6895b = dVar;
    }

    public static void b(f fVar, f fVar2, int i7) {
        fVar.f6882l.add(fVar2);
        fVar.f6876f = i7;
        fVar2.f6881k.add(fVar);
    }

    public static f h(c cVar) {
        p pVar;
        p pVar2;
        c cVar2 = cVar.f6498f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f6497d;
        int ordinal = cVar2.e.ordinal();
        if (ordinal == 1) {
            pVar = dVar.f6516d;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                pVar2 = dVar.f6516d;
            } else if (ordinal == 4) {
                pVar2 = dVar.e;
            } else if (ordinal != 5) {
                return null;
            } else {
                return dVar.e.f6887k;
            }
            return pVar2.f6901i;
        } else {
            pVar = dVar.e;
        }
        return pVar.f6900h;
    }

    public static f i(c cVar, int i7) {
        c cVar2 = cVar.f6498f;
        if (cVar2 == null) {
            return null;
        }
        d dVar = cVar2.f6497d;
        p pVar = i7 == 0 ? dVar.f6516d : dVar.e;
        int ordinal = cVar2.e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return pVar.f6900h;
        }
        if (ordinal == 3 || ordinal == 4) {
            return pVar.f6901i;
        }
        return null;
    }

    @Override // z0.d
    public void a(d dVar) {
    }

    public final void c(f fVar, f fVar2, int i7, g gVar) {
        fVar.f6882l.add(fVar2);
        fVar.f6882l.add(this.e);
        fVar.f6878h = i7;
        fVar.f6879i = gVar;
        fVar2.f6881k.add(fVar);
        gVar.f6881k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i7, int i8) {
        int i9;
        d dVar = this.f6895b;
        if (i8 == 0) {
            int i10 = dVar.f6547w;
            i9 = Math.max(dVar.f6546v, i7);
            if (i10 > 0) {
                i9 = Math.min(i10, i7);
            }
            if (i9 == i7) {
                return i7;
            }
        } else {
            int i11 = dVar.f6550z;
            i9 = Math.max(dVar.f6549y, i7);
            if (i11 > 0) {
                i9 = Math.min(i11, i7);
            }
            if (i9 == i7) {
                return i7;
            }
        }
        return i9;
    }

    public long j() {
        g gVar = this.e;
        if (gVar.f6880j) {
            return (long) gVar.f6877g;
        }
        return 0;
    }

    public abstract boolean k();

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r9.f6894a == 3) goto L_0x00a9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(y0.c r13, y0.c r14, int r15) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.p.l(y0.c, y0.c, int):void");
    }
}
