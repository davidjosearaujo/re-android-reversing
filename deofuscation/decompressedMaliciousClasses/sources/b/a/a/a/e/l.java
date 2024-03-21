package b.a.a.a.e;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.e0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class l<R extends j> extends f<R> {
    private static short[] $ = {9457, 9414, 9424, 9430, 9423, 9431, 9347, 9419, 9410, 9424, 9347, 9410, 9423, 9425, 9414, 9410, 9415, 9434, 9347, 9409, 9414, 9414, 9421, 9347, 9408, 9420, 9421, 9424, 9430, 9422, 9414, 9415, 9357, 1405, 1354, 1372, 1370, 1347, 1371, 1295, 1350, 1372, 1295, 1345, 1344, 1371, 1295, 1373, 1354, 1358, 1355, 1366, 1281, 561, 522, 517, 518, 520, 513, 580, 528, 523, 580, 534, 513, 520, 513, 517, 535, 513, 580, 2392, 2427, 2409, 2431, 2378, 2431, 2420, 2430, 2419, 2420, 2429, 2376, 2431, 2409, 2415, 2422, 2414, 2190, 2200, 2190, 2182, 2203, 2255, 2178, 2202, 2204, 2203, 2255, 2177, 2176, 2203, 2255, 2189, 2186, 2255, 2188, 2190, 2179, 2179, 2186, 2187, 2255, 2176, 2177, 2255, 2203, 2183, 2186, 2255, 2234, 2214, 2255, 2203, 2183, 2205, 2186, 2190, 2187, 2255, 2200, 2183, 2186, 2177, 2255, 2203, 2182, 2178, 2186, 2255, 2182, 2204, 2255, 2184, 2205, 2186, 2190, 2203, 2186, 2205, 2255, 2203, 2183, 2190, 2177, 2255, 2197, 2186, 2205, 2176, 2241, 2992, 2951, 2961, 2967, 2958, 2966, 3010, 2954, 2947, 2961, 3010, 2947, 2958, 2960, 2951, 2947, 2950, 2971, 3010, 2944, 2951, 2951, 2956, 3010, 2945, 2957, 2956, 2961, 2967, 2959, 2951, 2950, 3020, 698, 664, 663, 663, 662, 653, 729, 664, 654, 664, 656, 653, 729, 656, 671, 729, 653, 657, 668, 663, 721, 720, 729, 657, 664, 650, 729, 667, 668, 668, 663, 729, 666, 664, 661, 661, 668, 669, 727, 598, 609, 631, 625, 616, 624, 548, 621, 631, 548, 618, 619, 624, 548, 630, 609, 613, 608, 637, 554, 4265, 4235, 4230, 4230, 4232, 4235, 4233, 4225, 4298, 4233, 4235, 4228, 4228, 4229, 4254, 4298, 4232, 4239, 4298, 4228, 4255, 4230, 4230, 4292, 8010, 8061, 8043, 8045, 8052, 8044, 8043, 7992, 8048, 8057, 8046, 8061, 7992, 8057, 8052, 8042, 8061, 8057, 8060, 8033, 7992, 8058, 8061, 8061, 8054, 7992, 8043, 8061, 8044, 9902, 9881, 9871, 9865, 9872, 9864, 9948, 9876, 9885, 9871, 9948, 9885, 9872, 9870, 9881, 9885, 9880, 9861, 9948, 9886, 9881, 9881, 9874, 9948, 9887, 9875, 9874, 9871, 9865, 9873, 9881, 9880};
    static final ThreadLocal<Boolean> o = new m();

    /* renamed from: a */
    private final Object f164a;

    /* renamed from: b */
    private n<R> f165b;
    private final CountDownLatch c;
    private final ArrayList<f.a> d;
    private k<? super R> e;
    private final AtomicReference<m0> f;
    private R g;
    private Status h;
    private o i;
    private volatile boolean j;
    private boolean k;
    private boolean l;
    private volatile k0<R> m;
    private boolean n;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Deprecated
    l() {
        this.f164a = new Object();
        this.c = new CountDownLatch(1);
        this.d = new ArrayList<>();
        this.f = new AtomicReference<>();
        this.n = false;
        this.f165b = new n<>(Looper.getMainLooper());
        new WeakReference(null);
    }

    public l(e eVar) {
        this.f164a = new Object();
        this.c = new CountDownLatch(1);
        this.d = new ArrayList<>();
        this.f = new AtomicReference<>();
        this.n = false;
        this.f165b = new n<>(eVar != null ? eVar.a() : Looper.getMainLooper());
        new WeakReference(eVar);
    }

    private final R c() {
        R r;
        synchronized (this.f164a) {
            e0.b(!this.j, $(0, 33, 9379));
            e0.b(d(), $(33, 53, 1327));
            r = this.g;
            this.g = null;
            this.e = null;
            this.j = true;
        }
        m0 andSet = this.f.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    private final void h(R r) {
        this.g = r;
        this.c.countDown();
        this.h = this.g.b();
        if (this.k) {
            this.e = null;
        } else if (this.e != null) {
            this.f165b.removeMessages(2);
            this.f165b.a(this.e, c());
        } else if (this.g instanceof g) {
            this.i = new o(this, null);
        }
        ArrayList<f.a> arrayList = this.d;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            f.a aVar = arrayList.get(i);
            i++;
            aVar.a(this.h);
        }
        this.d.clear();
    }

    public static void i(j jVar) {
        if (jVar instanceof g) {
            try {
                ((g) jVar).a();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(jVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append($(53, 71, 612));
                sb.append(valueOf);
                Log.w($(71, 88, 2330), sb.toString(), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.f
    public final R a(long j, TimeUnit timeUnit) {
        boolean z = false;
        e0.b(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), $(88, 161, 2287));
        e0.b(!this.j, $(161, 194, 3042));
        if (this.m == null) {
            z = true;
        }
        e0.b(z, $(194, 233, 761));
        try {
            if (!this.c.await(j, timeUnit)) {
                k(Status.h);
            }
        } catch (InterruptedException unused) {
            k(Status.f);
        }
        e0.b(d(), $(233, 253, 516));
        return c();
    }

    @Override // com.google.android.gms.common.api.f
    public final void b(f.a aVar) {
        e0.f(aVar != null, $(253, 277, 4330));
        synchronized (this.f164a) {
            if (d()) {
                aVar.a(this.h);
            } else {
                this.d.add(aVar);
            }
        }
    }

    public final boolean d() {
        return this.c.getCount() == 0;
    }

    public final void e(R r) {
        synchronized (this.f164a) {
            if (this.l || this.k) {
                i(r);
                return;
            }
            d();
            boolean z = true;
            e0.b(!d(), $(277, 306, 7960));
            if (this.j) {
                z = false;
            }
            e0.b(z, $(306, 338, 9980));
            h(r);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract R g(Status status);

    public final void j() {
        this.n = this.n || o.get().booleanValue();
    }

    public final void k(Status status) {
        synchronized (this.f164a) {
            if (!d()) {
                e(g(status));
                this.l = true;
            }
        }
    }
}
