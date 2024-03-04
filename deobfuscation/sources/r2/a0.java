package r2;

import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import r2.h;
import r2.m;
import v2.n;

/* loaded from: classes.dex */
public final class a0 implements h, h.a {

    /* renamed from: f */
    public final i<?> f5718f;

    /* renamed from: g */
    public final h.a f5719g;

    /* renamed from: h */
    public volatile int f5720h;

    /* renamed from: i */
    public volatile e f5721i;

    /* renamed from: j */
    public volatile Object f5722j;

    /* renamed from: k */
    public volatile n.a<?> f5723k;

    /* renamed from: l */
    public volatile f f5724l;

    public a0(i<?> iVar, h.a aVar) {
        this.f5718f = iVar;
        this.f5719g = aVar;
    }

    @Override // r2.h.a
    public final void a() {
        throw new UnsupportedOperationException();
    }

    @Override // r2.h.a
    public final void b(p2.f fVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, p2.a aVar) {
        this.f5719g.b(fVar, exc, dVar, this.f5723k.f6225c.e());
    }

    @Override // r2.h.a
    public final void c(p2.f fVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, p2.a aVar, p2.f fVar2) {
        this.f5719g.c(fVar, obj, dVar, this.f5723k.f6225c.e(), fVar);
    }

    @Override // r2.h
    public final void cancel() {
        n.a<?> aVar = this.f5723k;
        if (aVar != null) {
            aVar.f6225c.cancel();
        }
    }

    public final boolean d(Object obj) {
        int i7 = k3.h.f4702b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        boolean z6 = true;
        try {
            com.bumptech.glide.load.data.e f7 = this.f5718f.f5748c.a().f(obj);
            Object a7 = f7.a();
            p2.d<X> e = this.f5718f.e(a7);
            g gVar = new g(e, a7, this.f5718f.f5753i);
            p2.f fVar = this.f5723k.f6223a;
            i<?> iVar = this.f5718f;
            f fVar2 = new f(fVar, iVar.f5757n);
            t2.a a8 = ((m.c) iVar.f5752h).a();
            a8.b(fVar2, gVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + fVar2 + ", data: " + obj + ", encoder: " + e + ", duration: " + k3.h.a(elapsedRealtimeNanos));
            }
            if (a8.a(fVar2) != null) {
                this.f5724l = fVar2;
                this.f5721i = new e(Collections.singletonList(this.f5723k.f6223a), this.f5718f, this);
                this.f5723k.f6225c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f5724l + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f5719g.c(this.f5723k.f6223a, f7.a(), this.f5723k.f6225c, this.f5723k.f6225c.e(), this.f5723k.f6223a);
                return false;
            } catch (Throwable th) {
                th = th;
                if (!z6) {
                    this.f5723k.f6225c.b();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z6 = false;
        }
    }

    @Override // r2.h
    public final boolean e() {
        if (this.f5722j != null) {
            Object obj = this.f5722j;
            this.f5722j = null;
            try {
                if (!d(obj)) {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.f5721i == null || !this.f5721i.e()) {
            this.f5721i = null;
            this.f5723k = null;
            boolean z6 = false;
            while (!z6) {
                if (!(this.f5720h < this.f5718f.b().size())) {
                    break;
                }
                ArrayList b2 = this.f5718f.b();
                int i7 = this.f5720h;
                this.f5720h = i7 + 1;
                this.f5723k = (n.a) b2.get(i7);
                if (this.f5723k != null) {
                    if (!this.f5718f.f5759p.c(this.f5723k.f6225c.e())) {
                        if (this.f5718f.c(this.f5723k.f6225c.a()) != null) {
                        }
                    }
                    this.f5723k.f6225c.f(this.f5718f.f5758o, new z(this, this.f5723k));
                    z6 = true;
                }
            }
            return z6;
        }
        return true;
    }
}
