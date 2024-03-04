package r2;

import android.util.Log;
import com.bumptech.glide.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import l3.a;
import r2.j;
import v2.n;

/* loaded from: classes.dex */
public final class k<DataType, ResourceType, Transcode> {

    /* renamed from: a */
    public final Class<DataType> f5789a;

    /* renamed from: b */
    public final List<? extends p2.j<DataType, ResourceType>> f5790b;

    /* renamed from: c */
    public final d3.b<ResourceType, Transcode> f5791c;

    /* renamed from: d */
    public final o1.d<List<Throwable>> f5792d;
    public final String e;

    public k(Class cls, Class cls2, Class cls3, List list, d3.b bVar, a.c cVar) {
        this.f5789a = cls;
        this.f5790b = list;
        this.f5791c = bVar;
        this.f5792d = cVar;
        StringBuilder d7 = androidx.activity.h.d("Failed DecodePath{");
        d7.append(cls.getSimpleName());
        d7.append("->");
        d7.append(cls2.getSimpleName());
        d7.append("->");
        d7.append(cls3.getSimpleName());
        d7.append("}");
        this.e = d7.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final v a(int i7, int i8, p2.h hVar, com.bumptech.glide.load.data.e eVar, j.b bVar) {
        v vVar;
        p2.l lVar;
        p2.c cVar;
        boolean z6;
        p2.f fVar;
        List<Throwable> b2 = this.f5792d.b();
        q2.a.i(b2);
        List<Throwable> list = b2;
        try {
            v<ResourceType> b7 = b(eVar, i7, i8, hVar, list);
            this.f5792d.a(list);
            j jVar = j.this;
            p2.a aVar = bVar.f5781a;
            jVar.getClass();
            Class<?> cls = b7.get().getClass();
            p2.k kVar = null;
            if (aVar != p2.a.RESOURCE_DISK_CACHE) {
                p2.l f7 = jVar.f5762f.f(cls);
                vVar = f7.b(jVar.m, b7, jVar.f5772q, jVar.f5773r);
                lVar = f7;
            } else {
                vVar = b7;
                lVar = null;
            }
            if (!b7.equals(vVar)) {
                b7.recycle();
            }
            if (jVar.f5762f.f5748c.a().f2650d.a(vVar.c()) != null) {
                p2.k a7 = jVar.f5762f.f5748c.a().f2650d.a(vVar.c());
                if (a7 == null) {
                    throw new j.d(vVar.c());
                }
                cVar = a7.d(jVar.f5774t);
                kVar = a7;
            } else {
                cVar = p2.c.NONE;
            }
            i<R> iVar = jVar.f5762f;
            p2.f fVar2 = jVar.C;
            ArrayList b8 = iVar.b();
            int size = b8.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    z6 = false;
                    break;
                } else if (((n.a) b8.get(i9)).f6223a.equals(fVar2)) {
                    z6 = true;
                    break;
                } else {
                    i9++;
                }
            }
            if (jVar.s.d(!z6, aVar, cVar)) {
                if (kVar == null) {
                    throw new j.d(vVar.get().getClass());
                }
                int ordinal = cVar.ordinal();
                if (ordinal == 0) {
                    fVar = new f(jVar.C, jVar.f5769n);
                } else if (ordinal != 1) {
                    throw new IllegalArgumentException("Unknown strategy: " + cVar);
                } else {
                    fVar = new x(jVar.f5762f.f5748c.f2631a, jVar.C, jVar.f5769n, jVar.f5772q, jVar.f5773r, lVar, cls, jVar.f5774t);
                }
                u<Z> uVar = (u) u.f5871j.b();
                q2.a.i(uVar);
                uVar.f5875i = false;
                uVar.f5874h = true;
                uVar.f5873g = vVar;
                j.c<?> cVar2 = jVar.f5767k;
                cVar2.f5783a = fVar;
                cVar2.f5784b = kVar;
                cVar2.f5785c = uVar;
                vVar = uVar;
            }
            return this.f5791c.b(vVar, hVar);
        } catch (Throwable th) {
            this.f5792d.a(list);
            throw th;
        }
    }

    public final v<ResourceType> b(com.bumptech.glide.load.data.e<DataType> eVar, int i7, int i8, p2.h hVar, List<Throwable> list) {
        int size = this.f5790b.size();
        v<ResourceType> vVar = null;
        for (int i9 = 0; i9 < size; i9++) {
            p2.j<DataType, ResourceType> jVar = this.f5790b.get(i9);
            try {
                if (jVar.a(eVar.a(), hVar)) {
                    vVar = jVar.b(eVar.a(), i7, i8, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e);
                }
                list.add(e);
            }
            if (vVar != null) {
                break;
            }
        }
        if (vVar != null) {
            return vVar;
        }
        throw new r(this.e, new ArrayList(list));
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("DecodePath{ dataClass=");
        d7.append(this.f5789a);
        d7.append(", decoders=");
        d7.append(this.f5790b);
        d7.append(", transcoder=");
        d7.append(this.f5791c);
        d7.append('}');
        return d7.toString();
    }
}
