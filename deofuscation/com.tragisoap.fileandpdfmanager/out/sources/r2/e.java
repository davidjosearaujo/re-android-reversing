package r2;

import com.bumptech.glide.load.data.d;
import java.io.File;
import java.util.List;
import p2.a;
import p2.f;
import r2.h;
import v2.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e implements h, d.a<Object> {

    /* renamed from: f  reason: collision with root package name */
    public final List<f> f5733f;

    /* renamed from: g  reason: collision with root package name */
    public final i<?> f5734g;

    /* renamed from: h  reason: collision with root package name */
    public final h.a f5735h;

    /* renamed from: i  reason: collision with root package name */
    public int f5736i = -1;

    /* renamed from: j  reason: collision with root package name */
    public f f5737j;

    /* renamed from: k  reason: collision with root package name */
    public List<n<File, ?>> f5738k;

    /* renamed from: l  reason: collision with root package name */
    public int f5739l;
    public volatile n.a<?> m;

    /* renamed from: n  reason: collision with root package name */
    public File f5740n;

    public e(List<f> list, i<?> iVar, h.a aVar) {
        this.f5733f = list;
        this.f5734g = iVar;
        this.f5735h = aVar;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public final void c(Exception exc) {
        this.f5735h.b(this.f5737j, exc, this.m.f6225c, a.DATA_DISK_CACHE);
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
        this.f5735h.c(this.f5737j, obj, this.m.f6225c, a.DATA_DISK_CACHE, this.f5737j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
        r8.m = null;
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0 != false) goto L_0x006d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
        if (r8.f5739l >= r8.f5738k.size()) goto L_0x0026;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
        if (r3 == false) goto L_0x006d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
        r3 = r8.f5738k;
        r4 = r8.f5739l;
        r8.f5739l = r4 + 1;
        r4 = r8.f5740n;
        r5 = r8.f5734g;
        r8.m = r3.get(r4).a(r4, r5.e, r5.f5750f, r5.f5753i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r8.m == null) goto L_0x0018;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (r8.f5734g.c(r8.m.f6225c.a()) == null) goto L_0x005d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (r3 == false) goto L_0x0018;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        r8.m.f6225c.f(r8.f5734g.f5758o, r8);
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
        return r0;
     */
    @Override // r2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e() {
        /*
            r8 = this;
        L_0x0000:
            java.util.List<v2.n<java.io.File, ?>> r0 = r8.f5738k     // Catch: all -> 0x00b3
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x006e
            int r3 = r8.f5739l     // Catch: all -> 0x00b3
            int r0 = r0.size()     // Catch: all -> 0x00b3
            if (r3 >= r0) goto L_0x0010
            r0 = r2
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 != 0) goto L_0x0014
            goto L_0x006e
        L_0x0014:
            r0 = 0
            r8.m = r0     // Catch: all -> 0x00b3
            r0 = r1
        L_0x0018:
            if (r0 != 0) goto L_0x006d
            int r3 = r8.f5739l     // Catch: all -> 0x00b3
            java.util.List<v2.n<java.io.File, ?>> r4 = r8.f5738k     // Catch: all -> 0x00b3
            int r4 = r4.size()     // Catch: all -> 0x00b3
            if (r3 >= r4) goto L_0x0026
            r3 = r2
            goto L_0x0027
        L_0x0026:
            r3 = r1
        L_0x0027:
            if (r3 == 0) goto L_0x006d
            java.util.List<v2.n<java.io.File, ?>> r3 = r8.f5738k     // Catch: all -> 0x00b3
            int r4 = r8.f5739l     // Catch: all -> 0x00b3
            int r5 = r4 + 1
            r8.f5739l = r5     // Catch: all -> 0x00b3
            java.lang.Object r3 = r3.get(r4)     // Catch: all -> 0x00b3
            v2.n r3 = (v2.n) r3     // Catch: all -> 0x00b3
            java.io.File r4 = r8.f5740n     // Catch: all -> 0x00b3
            r2.i<?> r5 = r8.f5734g     // Catch: all -> 0x00b3
            int r6 = r5.e     // Catch: all -> 0x00b3
            int r7 = r5.f5750f     // Catch: all -> 0x00b3
            p2.h r5 = r5.f5753i     // Catch: all -> 0x00b3
            v2.n$a r3 = r3.a(r4, r6, r7, r5)     // Catch: all -> 0x00b3
            r8.m = r3     // Catch: all -> 0x00b3
            v2.n$a<?> r3 = r8.m     // Catch: all -> 0x00b3
            if (r3 == 0) goto L_0x0018
            r2.i<?> r3 = r8.f5734g     // Catch: all -> 0x00b3
            v2.n$a<?> r4 = r8.m     // Catch: all -> 0x00b3
            com.bumptech.glide.load.data.d<Data> r4 = r4.f6225c     // Catch: all -> 0x00b3
            java.lang.Class r4 = r4.a()     // Catch: all -> 0x00b3
            r2.t r3 = r3.c(r4)     // Catch: all -> 0x00b3
            if (r3 == 0) goto L_0x005d
            r3 = r2
            goto L_0x005e
        L_0x005d:
            r3 = r1
        L_0x005e:
            if (r3 == 0) goto L_0x0018
            v2.n$a<?> r0 = r8.m     // Catch: all -> 0x00b3
            com.bumptech.glide.load.data.d<Data> r0 = r0.f6225c     // Catch: all -> 0x00b3
            r2.i<?> r3 = r8.f5734g     // Catch: all -> 0x00b3
            com.bumptech.glide.i r3 = r3.f5758o     // Catch: all -> 0x00b3
            r0.f(r3, r8)     // Catch: all -> 0x00b3
            r0 = r2
            goto L_0x0018
        L_0x006d:
            return r0
        L_0x006e:
            int r0 = r8.f5736i     // Catch: all -> 0x00b3
            int r0 = r0 + r2
            r8.f5736i = r0     // Catch: all -> 0x00b3
            java.util.List<p2.f> r2 = r8.f5733f     // Catch: all -> 0x00b3
            int r2 = r2.size()     // Catch: all -> 0x00b3
            if (r0 < r2) goto L_0x007c
            return r1
        L_0x007c:
            java.util.List<p2.f> r0 = r8.f5733f     // Catch: all -> 0x00b3
            int r2 = r8.f5736i     // Catch: all -> 0x00b3
            java.lang.Object r0 = r0.get(r2)     // Catch: all -> 0x00b3
            p2.f r0 = (p2.f) r0     // Catch: all -> 0x00b3
            r2.f r2 = new r2.f     // Catch: all -> 0x00b3
            r2.i<?> r3 = r8.f5734g     // Catch: all -> 0x00b3
            p2.f r4 = r3.f5757n     // Catch: all -> 0x00b3
            r2.<init>(r0, r4)     // Catch: all -> 0x00b3
            r2.j$d r3 = r3.f5752h     // Catch: all -> 0x00b3
            r2.m$c r3 = (r2.m.c) r3     // Catch: all -> 0x00b3
            t2.a r3 = r3.a()     // Catch: all -> 0x00b3
            java.io.File r2 = r3.a(r2)     // Catch: all -> 0x00b3
            r8.f5740n = r2     // Catch: all -> 0x00b3
            if (r2 == 0) goto L_0x0000
            r8.f5737j = r0     // Catch: all -> 0x00b3
            r2.i<?> r0 = r8.f5734g     // Catch: all -> 0x00b3
            com.bumptech.glide.g r0 = r0.f5748c     // Catch: all -> 0x00b3
            com.bumptech.glide.j r0 = r0.a()     // Catch: all -> 0x00b3
            java.util.List r0 = r0.e(r2)     // Catch: all -> 0x00b3
            r8.f5738k = r0     // Catch: all -> 0x00b3
            r8.f5739l = r1     // Catch: all -> 0x00b3
            goto L_0x0000
        L_0x00b3:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.e.e():boolean");
    }
}