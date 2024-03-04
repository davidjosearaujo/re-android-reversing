package t2;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import n2.a;
import t2.b;

/* loaded from: classes.dex */
public final class d implements a {

    /* renamed from: b */
    public final File f6045b;

    /* renamed from: c */
    public final long f6046c;
    public n2.a e;

    /* renamed from: d */
    public final b f6047d = new b();

    /* renamed from: a */
    public final j f6044a = new j();

    @Deprecated
    public d(File file, long j5) {
        this.f6045b = file;
        this.f6046c = j5;
    }

    @Override // t2.a
    public final File a(p2.f fVar) {
        n2.a aVar;
        String a7 = this.f6044a.a(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + a7 + " for for Key: " + fVar);
        }
        File file = null;
        try {
            synchronized (this) {
                if (this.e == null) {
                    this.e = n2.a.n(this.f6045b, this.f6046c);
                }
                aVar = this.e;
            }
            a.e k6 = aVar.k(a7);
            if (k6 != null) {
                file = k6.f5153a[0];
                return file;
            }
            return null;
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
                return file;
            }
            return file;
        }
    }

    @Override // t2.a
    public final void b(p2.f fVar, r2.g gVar) {
        b.a aVar;
        n2.a aVar2;
        boolean z6;
        String a7 = this.f6044a.a(fVar);
        b bVar = this.f6047d;
        synchronized (bVar) {
            aVar = (b.a) bVar.f6037a.get(a7);
            if (aVar == null) {
                b.C0107b c0107b = bVar.f6038b;
                synchronized (c0107b.f6041a) {
                    aVar = (b.a) c0107b.f6041a.poll();
                }
                if (aVar == null) {
                    aVar = new b.a();
                }
                bVar.f6037a.put(a7, aVar);
            }
            aVar.f6040b++;
        }
        aVar.f6039a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + a7 + " for for Key: " + fVar);
            }
            try {
                synchronized (this) {
                    if (this.e == null) {
                        this.e = n2.a.n(this.f6045b, this.f6046c);
                    }
                    aVar2 = this.e;
                }
                if (aVar2.k(a7) == null) {
                    a.c f7 = aVar2.f(a7);
                    if (f7 == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + a7);
                    }
                    try {
                        if (gVar.f5743a.c(gVar.f5744b, f7.b(), gVar.f5745c)) {
                            n2.a.b(n2.a.this, f7, true);
                            f7.f5145c = true;
                        }
                        if (!z6) {
                            try {
                                f7.a();
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                        if (!f7.f5145c) {
                            try {
                                f7.a();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
        } finally {
            this.f6047d.a(a7);
        }
    }
}
