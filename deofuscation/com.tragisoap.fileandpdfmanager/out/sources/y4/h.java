package y4;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import q.d;
import z4.b;
import z4.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h {

    /* renamed from: g  reason: collision with root package name */
    public static final h f6723g;

    /* renamed from: a  reason: collision with root package name */
    public final ThreadPoolExecutor f6724a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6725b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6726c;

    /* renamed from: d  reason: collision with root package name */
    public a f6727d = new a();
    public final ArrayDeque e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public final d f6728f = new d(3, 0);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long j7;
            while (true) {
                h hVar = h.this;
                long nanoTime = System.nanoTime();
                synchronized (hVar) {
                    Iterator it = hVar.e.iterator();
                    int i7 = 0;
                    c5.a aVar = null;
                    long j8 = Long.MIN_VALUE;
                    int i8 = 0;
                    while (it.hasNext()) {
                        c5.a aVar2 = (c5.a) it.next();
                        if (hVar.a(aVar2, nanoTime) > 0) {
                            i8++;
                        } else {
                            i7++;
                            long j9 = nanoTime - aVar2.f2576l;
                            if (j9 > j8) {
                                aVar = aVar2;
                                j8 = j9;
                            }
                        }
                    }
                    j7 = hVar.f6726c;
                    if (j8 < j7 && i7 <= hVar.f6725b) {
                        if (i7 > 0) {
                            j7 -= j8;
                        } else if (i8 <= 0) {
                            j7 = -1;
                        }
                    }
                    hVar.e.remove(aVar);
                    z4.h.c(aVar.f2568c);
                    j7 = 0;
                }
                if (j7 != -1) {
                    if (j7 > 0) {
                        long j10 = j7 / 1000000;
                        long j11 = j7 - (1000000 * j10);
                        synchronized (h.this) {
                            try {
                                h.this.wait(j10, (int) j11);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000;
        f6723g = (property == null || Boolean.parseBoolean(property)) ? property3 != null ? new h(Integer.parseInt(property3), parseLong) : new h(5, parseLong) : new h(0, parseLong);
    }

    public h(int i7, long j7) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        byte[] bArr = z4.h.f6955a;
        this.f6724a = new ThreadPoolExecutor(0, 1, 60, timeUnit2, linkedBlockingQueue, new g("OkHttp ConnectionPool"));
        this.f6725b = i7;
        this.f6726c = timeUnit.toNanos(j7);
        if (j7 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j7);
        }
    }

    public final int a(c5.a aVar, long j7) {
        ArrayList arrayList = aVar.f2574j;
        int i7 = 0;
        while (i7 < arrayList.size()) {
            if (((Reference) arrayList.get(i7)).get() != null) {
                i7++;
            } else {
                Logger logger = b.f6934a;
                StringBuilder d7 = androidx.activity.h.d("A connection to ");
                d7.append(aVar.f2566a.f6818a.f6677a);
                d7.append(" was leaked. Did you forget to close a response body?");
                logger.warning(d7.toString());
                arrayList.remove(i7);
                aVar.f2575k = true;
                if (arrayList.isEmpty()) {
                    aVar.f2576l = j7 - this.f6726c;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
