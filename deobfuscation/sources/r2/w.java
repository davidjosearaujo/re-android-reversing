package r2;

import com.bumptech.glide.load.data.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import r2.h;
import r2.m;
import v2.n;

/* loaded from: classes.dex */
public final class w implements h, d.a<Object> {

    /* renamed from: f */
    public final h.a f5876f;

    /* renamed from: g */
    public final i<?> f5877g;

    /* renamed from: h */
    public int f5878h;

    /* renamed from: i */
    public int f5879i = -1;

    /* renamed from: j */
    public p2.f f5880j;

    /* renamed from: k */
    public List<v2.n<File, ?>> f5881k;

    /* renamed from: l */
    public int f5882l;
    public volatile n.a<?> m;

    /* renamed from: n */
    public File f5883n;

    /* renamed from: o */
    public x f5884o;

    public w(i<?> iVar, h.a aVar) {
        this.f5877g = iVar;
        this.f5876f = aVar;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public final void c(Exception exc) {
        this.f5876f.b(this.f5884o, exc, this.m.f6225c, p2.a.RESOURCE_DISK_CACHE);
    }

    @Override // r2.h
    public final void cancel() {
        n.a<?> aVar = this.m;
        if (aVar != null) {
            aVar.f6225c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public final void d(Object obj) {
        this.f5876f.c(this.f5880j, obj, this.m.f6225c, p2.a.RESOURCE_DISK_CACHE, this.f5884o);
    }

    @Override // r2.h
    public final boolean e() {
        ArrayList a7 = this.f5877g.a();
        if (a7.isEmpty()) {
            return false;
        }
        List<Class<?>> d7 = this.f5877g.d();
        if (d7.isEmpty()) {
            if (File.class.equals(this.f5877g.f5755k)) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f5877g.f5749d.getClass() + " to " + this.f5877g.f5755k);
        }
        while (true) {
            List<v2.n<File, ?>> list = this.f5881k;
            if (list != null) {
                if (this.f5882l < list.size()) {
                    this.m = null;
                    boolean z6 = false;
                    while (!z6) {
                        if (!(this.f5882l < this.f5881k.size())) {
                            break;
                        }
                        List<v2.n<File, ?>> list2 = this.f5881k;
                        int i7 = this.f5882l;
                        this.f5882l = i7 + 1;
                        File file = this.f5883n;
                        i<?> iVar = this.f5877g;
                        this.m = list2.get(i7).a(file, iVar.e, iVar.f5750f, iVar.f5753i);
                        if (this.m != null) {
                            if (this.f5877g.c(this.m.f6225c.a()) != null) {
                                this.m.f6225c.f(this.f5877g.f5758o, this);
                                z6 = true;
                            }
                        }
                    }
                    return z6;
                }
            }
            int i8 = this.f5879i + 1;
            this.f5879i = i8;
            if (i8 >= d7.size()) {
                int i9 = this.f5878h + 1;
                this.f5878h = i9;
                if (i9 >= a7.size()) {
                    return false;
                }
                this.f5879i = 0;
            }
            p2.f fVar = (p2.f) a7.get(this.f5878h);
            Class<?> cls = d7.get(this.f5879i);
            p2.l<Z> f7 = this.f5877g.f(cls);
            i<?> iVar2 = this.f5877g;
            this.f5884o = new x(iVar2.f5748c.f2631a, fVar, iVar2.f5757n, iVar2.e, iVar2.f5750f, f7, cls, iVar2.f5753i);
            File a8 = ((m.c) iVar2.f5752h).a().a(this.f5884o);
            this.f5883n = a8;
            if (a8 != null) {
                this.f5880j = fVar;
                this.f5881k = this.f5877g.f5748c.a().e(a8);
                this.f5882l = 0;
            }
        }
    }
}
