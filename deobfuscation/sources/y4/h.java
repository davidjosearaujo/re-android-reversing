package y4;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: g */
    public static final h f6723g;

    /* renamed from: a */
    public final ThreadPoolExecutor f6724a;

    /* renamed from: b */
    public final int f6725b;

    /* renamed from: c */
    public final long f6726c;

    /* renamed from: d */
    public a f6727d;
    public final ArrayDeque e;

    /* renamed from: f */
    public final q.d f6728f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            h.this = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long j5;
            while (true) {
                h hVar = h.this;
                long nanoTime = System.nanoTime();
                synchronized (hVar) {
                    Iterator it = hVar.e.iterator();
                    int i7 = 0;
                    long j7 = Long.MIN_VALUE;
                    c5.a aVar = null;
                    int i8 = 0;
                    while (it.hasNext()) {
                        c5.a aVar2 = (c5.a) it.next();
                        if (hVar.a(aVar2, nanoTime) > 0) {
                            i8++;
                        } else {
                            i7++;
                            long j8 = nanoTime - aVar2.f2576l;
                            if (j8 > j7) {
                                aVar = aVar2;
                                j7 = j8;
                            }
                        }
                    }
                    j5 = hVar.f6726c;
                    if (j7 < j5 && i7 <= hVar.f6725b) {
                        if (i7 > 0) {
                            j5 -= j7;
                        } else if (i8 <= 0) {
                            j5 = -1;
                        }
                    }
                    hVar.e.remove(aVar);
                    z4.h.c(aVar.f2568c);
                    j5 = 0;
                }
                if (j5 == -1) {
                    return;
                }
                if (j5 > 0) {
                    long j9 = j5 / 1000000;
                    long j10 = j5 - (1000000 * j9);
                    synchronized (h.this) {
                        try {
                            h.this.wait(j9, (int) j10);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000L;
        f6723g = (property == null || Boolean.parseBoolean(property)) ? property3 != null ? new h(Integer.parseInt(property3), parseLong) : new h(5, parseLong) : new h(0, parseLong);
    }

    public h(int i7, long j5) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        byte[] bArr = z4.h.f6955a;
        this.f6724a = new ThreadPoolExecutor(0, 1, 60L, timeUnit2, linkedBlockingQueue, new z4.g("OkHttp ConnectionPool"));
        this.f6727d = new a();
        this.e = new ArrayDeque();
        this.f6728f = new q.d(3, 0);
        this.f6725b = i7;
        this.f6726c = timeUnit.toNanos(j5);
        if (j5 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j5);
    }

    public final int a(c5.a aVar, long j5) {
        ArrayList arrayList = aVar.f2574j;
        int i7 = 0;
        while (i7 < arrayList.size()) {
            if (((Reference) arrayList.get(i7)).get() != null) {
                i7++;
            } else {
                Logger logger = z4.b.f6934a;
                StringBuilder d7 = androidx.activity.h.d("A connection to ");
                d7.append(aVar.f2566a.f6818a.f6677a);
                d7.append(" was leaked. Did you forget to close a response body?");
                logger.warning(d7.toString());
                arrayList.remove(i7);
                aVar.f2575k = true;
                if (arrayList.isEmpty()) {
                    aVar.f2576l = j5 - this.f6726c;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
