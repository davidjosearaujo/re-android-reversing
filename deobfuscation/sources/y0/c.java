package y0;

import com.davemorrissey.labs.subscaleview.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import z0.o;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b */
    public int f6495b;

    /* renamed from: c */
    public boolean f6496c;

    /* renamed from: d */
    public final d f6497d;
    public final a e;

    /* renamed from: f */
    public c f6498f;

    /* renamed from: i */
    public w0.f f6501i;

    /* renamed from: a */
    public HashSet<c> f6494a = null;

    /* renamed from: g */
    public int f6499g = 0;

    /* renamed from: h */
    public int f6500h = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public enum a {
        /* JADX INFO: Fake field, exist only in values array */
        f30EF0,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public c(d dVar, a aVar) {
        this.f6497d = dVar;
        this.e = aVar;
    }

    public final void a(c cVar, int i7) {
        b(cVar, i7, Integer.MIN_VALUE, false);
    }

    public final boolean b(c cVar, int i7, int i8, boolean z6) {
        if (cVar == null) {
            j();
            return true;
        } else if (z6 || i(cVar)) {
            this.f6498f = cVar;
            if (cVar.f6494a == null) {
                cVar.f6494a = new HashSet<>();
            }
            HashSet<c> hashSet = this.f6498f.f6494a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.f6499g = i7;
            this.f6500h = i8;
            return true;
        } else {
            return false;
        }
    }

    public final void c(int i7, o oVar, ArrayList arrayList) {
        HashSet<c> hashSet = this.f6494a;
        if (hashSet != null) {
            Iterator<c> it = hashSet.iterator();
            while (it.hasNext()) {
                z0.i.a(it.next().f6497d, i7, arrayList, oVar);
            }
        }
    }

    public final int d() {
        if (this.f6496c) {
            return this.f6495b;
        }
        return 0;
    }

    public final int e() {
        c cVar;
        if (this.f6497d.f6528j0 == 8) {
            return 0;
        }
        int i7 = this.f6500h;
        return (i7 == Integer.MIN_VALUE || (cVar = this.f6498f) == null || cVar.f6497d.f6528j0 != 8) ? this.f6499g : i7;
    }

    public final c f() {
        switch (this.e.ordinal()) {
            case 0:
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return this.f6497d.M;
            case 2:
                return this.f6497d.N;
            case 3:
                return this.f6497d.K;
            case 4:
                return this.f6497d.L;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    public final boolean g() {
        HashSet<c> hashSet = this.f6494a;
        if (hashSet == null) {
            return false;
        }
        Iterator<c> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f6498f != null;
    }

    public final boolean i(c cVar) {
        a aVar = a.CENTER_Y;
        a aVar2 = a.RIGHT;
        a aVar3 = a.CENTER_X;
        a aVar4 = a.LEFT;
        a aVar5 = a.BASELINE;
        boolean z6 = false;
        if (cVar == null) {
            return false;
        }
        a aVar6 = cVar.e;
        a aVar7 = this.e;
        if (aVar6 == aVar7) {
            return aVar7 != aVar5 || (cVar.f6497d.F && this.f6497d.F);
        }
        switch (aVar7.ordinal()) {
            case 0:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z7 = aVar6 == aVar4 || aVar6 == aVar2;
                if (cVar.f6497d instanceof g) {
                    if (z7 || aVar6 == aVar3) {
                        z6 = true;
                    }
                    return z6;
                }
                return z7;
            case 2:
            case 4:
                boolean z8 = aVar6 == a.TOP || aVar6 == a.BOTTOM;
                if (cVar.f6497d instanceof g) {
                    if (z8 || aVar6 == aVar) {
                        z6 = true;
                    }
                    return z6;
                }
                return z8;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                return (aVar6 == aVar4 || aVar6 == aVar2) ? false : true;
            case 6:
                return (aVar6 == aVar5 || aVar6 == aVar3 || aVar6 == aVar) ? false : true;
            default:
                throw new AssertionError(this.e.name());
        }
    }

    public final void j() {
        HashSet<c> hashSet;
        c cVar = this.f6498f;
        if (cVar != null && (hashSet = cVar.f6494a) != null) {
            hashSet.remove(this);
            if (this.f6498f.f6494a.size() == 0) {
                this.f6498f.f6494a = null;
            }
        }
        this.f6494a = null;
        this.f6498f = null;
        this.f6499g = 0;
        this.f6500h = Integer.MIN_VALUE;
        this.f6496c = false;
        this.f6495b = 0;
    }

    public final void k() {
        w0.f fVar = this.f6501i;
        if (fVar == null) {
            this.f6501i = new w0.f(1);
        } else {
            fVar.c();
        }
    }

    public final void l(int i7) {
        this.f6495b = i7;
        this.f6496c = true;
    }

    public final String toString() {
        return this.f6497d.f6530k0 + ":" + this.e.toString();
    }
}
