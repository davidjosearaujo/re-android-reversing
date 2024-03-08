package v0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a<V> implements Future {

    /* renamed from: i */
    public static final boolean f6160i = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: j */
    public static final Logger f6161j = Logger.getLogger(a.class.getName());

    /* renamed from: k */
    public static final AbstractC0115a f6162k;

    /* renamed from: l */
    public static final Object f6163l;

    /* renamed from: f */
    public volatile Object f6164f;

    /* renamed from: g */
    public volatile d f6165g;

    /* renamed from: h */
    public volatile h f6166h;

    /* renamed from: v0.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class AbstractC0115a {
        public abstract boolean a(a aVar, d dVar);

        public abstract boolean b(a<?> aVar, Object obj, Object obj2);

        public abstract boolean c(a<?> aVar, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: b */
        public static final b f6167b;

        /* renamed from: c */
        public static final b f6168c;

        /* renamed from: a */
        public final Throwable f6169a;

        static {
            if (a.f6160i) {
                f6168c = null;
                f6167b = null;
                return;
            }
            f6168c = new b(null, false);
            f6167b = new b(null, true);
        }

        public b(Throwable th, boolean z6) {
            this.f6169a = th;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c {

        /* renamed from: a */
        public final Throwable f6170a;

        /* renamed from: v0.a$c$a */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class C0116a extends Throwable {
            public C0116a() {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            new c(new C0116a());
        }

        public c(Throwable th) {
            boolean z6 = a.f6160i;
            th.getClass();
            this.f6170a = th;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class d {

        /* renamed from: d */
        public static final d f6171d = new d();

        /* renamed from: a */
        public final Runnable f6172a = null;

        /* renamed from: b */
        public final Executor f6173b = null;

        /* renamed from: c */
        public d f6174c;
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class e extends AbstractC0115a {

        /* renamed from: a */
        public final AtomicReferenceFieldUpdater<h, Thread> f6175a;

        /* renamed from: b */
        public final AtomicReferenceFieldUpdater<h, h> f6176b;

        /* renamed from: c */
        public final AtomicReferenceFieldUpdater<a, h> f6177c;

        /* renamed from: d */
        public final AtomicReferenceFieldUpdater<a, d> f6178d;
        public final AtomicReferenceFieldUpdater<a, Object> e;

        public e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            this.f6175a = atomicReferenceFieldUpdater;
            this.f6176b = atomicReferenceFieldUpdater2;
            this.f6177c = atomicReferenceFieldUpdater3;
            this.f6178d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // v0.a.AbstractC0115a
        public final boolean a(a aVar, d dVar) {
            d dVar2 = d.f6171d;
            AtomicReferenceFieldUpdater<a, d> atomicReferenceFieldUpdater = this.f6178d;
            while (!atomicReferenceFieldUpdater.compareAndSet(aVar, dVar, dVar2)) {
                if (atomicReferenceFieldUpdater.get(aVar) != dVar) {
                    return false;
                }
            }
            return true;
        }

        @Override // v0.a.AbstractC0115a
        public final boolean b(a<?> aVar, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater = this.e;
            while (!atomicReferenceFieldUpdater.compareAndSet(aVar, obj, obj2)) {
                if (atomicReferenceFieldUpdater.get(aVar) != obj) {
                    return false;
                }
            }
            return true;
        }

        @Override // v0.a.AbstractC0115a
        public final boolean c(a<?> aVar, h hVar, h hVar2) {
            AtomicReferenceFieldUpdater<a, h> atomicReferenceFieldUpdater = this.f6177c;
            while (!atomicReferenceFieldUpdater.compareAndSet(aVar, hVar, hVar2)) {
                if (atomicReferenceFieldUpdater.get(aVar) != hVar) {
                    return false;
                }
            }
            return true;
        }

        @Override // v0.a.AbstractC0115a
        public final void d(h hVar, h hVar2) {
            this.f6176b.lazySet(hVar, hVar2);
        }

        @Override // v0.a.AbstractC0115a
        public final void e(h hVar, Thread thread) {
            this.f6175a.lazySet(hVar, thread);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class f<V> implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class g extends AbstractC0115a {
        @Override // v0.a.AbstractC0115a
        public final boolean a(a aVar, d dVar) {
            d dVar2 = d.f6171d;
            synchronized (aVar) {
                if (aVar.f6165g != dVar) {
                    return false;
                }
                aVar.f6165g = dVar2;
                return true;
            }
        }

        @Override // v0.a.AbstractC0115a
        public final boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f6164f != obj) {
                    return false;
                }
                aVar.f6164f = obj2;
                return true;
            }
        }

        @Override // v0.a.AbstractC0115a
        public final boolean c(a<?> aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                if (aVar.f6166h != hVar) {
                    return false;
                }
                aVar.f6166h = hVar2;
                return true;
            }
        }

        @Override // v0.a.AbstractC0115a
        public final void d(h hVar, h hVar2) {
            hVar.f6181b = hVar2;
        }

        @Override // v0.a.AbstractC0115a
        public final void e(h hVar, Thread thread) {
            hVar.f6180a = thread;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class h {

        /* renamed from: c */
        public static final h f6179c = new h(0);

        /* renamed from: a */
        public volatile Thread f6180a;

        /* renamed from: b */
        public volatile h f6181b;

        public h() {
            a.f6162k.e(this, Thread.currentThread());
        }

        public h(int i7) {
        }
    }

    static {
        AbstractC0115a aVar;
        Throwable th;
        try {
            aVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "h"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "g"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "f"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            aVar = new g();
        }
        f6162k = aVar;
        if (th != null) {
            f6161j.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f6163l = new Object();
    }

    public static void b(a<?> aVar) {
        h hVar;
        d dVar;
        do {
            hVar = aVar.f6166h;
        } while (!f6162k.c(aVar, hVar, h.f6179c));
        while (hVar != null) {
            Thread thread = hVar.f6180a;
            if (thread != null) {
                hVar.f6180a = null;
                LockSupport.unpark(thread);
            }
            hVar = hVar.f6181b;
        }
        do {
            dVar = aVar.f6165g;
        } while (!f6162k.a(aVar, dVar));
        d dVar2 = null;
        while (dVar != null) {
            dVar = dVar.f6174c;
            dVar.f6174c = dVar2;
            dVar2 = dVar;
        }
        while (dVar2 != null) {
            dVar2 = dVar2.f6174c;
            Runnable runnable = dVar2.f6172a;
            if (!(runnable instanceof f)) {
                Executor executor = dVar2.f6173b;
                try {
                    executor.execute(runnable);
                } catch (RuntimeException e7) {
                    f6161j.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e7);
                }
            } else {
                ((f) runnable).getClass();
                throw null;
            }
        }
    }

    public static Object c(Object obj) {
        if (obj instanceof b) {
            Throwable th = ((b) obj).f6169a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f6170a);
        } else if (obj == f6163l) {
            return null;
        } else {
            return obj;
        }
    }

    public final void a(StringBuilder sb) {
        String str;
        V v6;
        boolean z6 = false;
        while (true) {
            try {
                try {
                    v6 = get();
                    break;
                } catch (InterruptedException unused) {
                    z6 = true;
                } catch (Throwable th) {
                    if (z6) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                str = "CANCELLED";
                sb.append(str);
                return;
            } catch (RuntimeException e7) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e7.getClass());
                str = " thrown from get()]";
                sb.append(str);
                return;
            } catch (ExecutionException e8) {
                sb.append("FAILURE, cause=[");
                sb.append(e8.getCause());
                sb.append("]");
                return;
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(v6 == this ? "this future" : String.valueOf(v6));
        sb.append("]");
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        Object obj = this.f6164f;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        b bVar = f6160i ? new b(new CancellationException("Future.cancel() was called."), z6) : z6 ? b.f6167b : b.f6168c;
        while (!f6162k.b(this, obj, bVar)) {
            obj = this.f6164f;
            if (!(obj instanceof f)) {
                return false;
            }
        }
        b(this);
        if (!(obj instanceof f)) {
            return true;
        }
        ((f) obj).getClass();
        throw null;
    }

    public final String d() {
        Object obj = this.f6164f;
        if (obj instanceof f) {
            StringBuilder d7 = androidx.activity.h.d("setFuture=[");
            ((f) obj).getClass();
            d7.append("null");
            d7.append("]");
            return d7.toString();
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            StringBuilder d8 = androidx.activity.h.d("remaining delay=[");
            d8.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            d8.append(" ms]");
            return d8.toString();
        }
    }

    public final void e(h hVar) {
        hVar.f6180a = null;
        while (true) {
            h hVar2 = this.f6166h;
            if (hVar2 != h.f6179c) {
                h hVar3 = null;
                while (hVar2 != null) {
                    h hVar4 = hVar2.f6181b;
                    if (hVar2.f6180a != null) {
                        hVar3 = hVar2;
                    } else if (hVar3 != null) {
                        hVar3.f6181b = hVar4;
                        if (hVar3.f6180a == null) {
                            break;
                        }
                    } else if (!f6162k.c(this, hVar2, hVar4)) {
                        break;
                    }
                    hVar2 = hVar4;
                }
                return;
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
        java.util.concurrent.locks.LockSupport.park(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (java.lang.Thread.interrupted() != false) goto L_0x004b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        r0 = r6.f6164f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r0 == null) goto L_0x003f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        if ((r4 & (!(r0 instanceof v0.a.f))) == false) goto L_0x0030;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        return (V) c(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
        e(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V get() {
        /*
            r6 = this;
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L_0x0061
            java.lang.Object r0 = r6.f6164f
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000e
            r3 = r2
            goto L_0x000f
        L_0x000e:
            r3 = r1
        L_0x000f:
            boolean r4 = r0 instanceof v0.a.f
            r4 = r4 ^ r2
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001a
            java.lang.Object r6 = c(r0)
            return r6
        L_0x001a:
            v0.a$h r0 = r6.f6166h
            v0.a$h r3 = v0.a.h.f6179c
            if (r0 == r3) goto L_0x005a
            v0.a$h r3 = new v0.a$h
            r3.<init>()
        L_0x0025:
            v0.a$a r4 = v0.a.f6162k
            r4.d(r3, r0)
            boolean r0 = r4.c(r6, r0, r3)
            if (r0 == 0) goto L_0x0054
        L_0x0030:
            java.util.concurrent.locks.LockSupport.park(r6)
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L_0x004b
            java.lang.Object r0 = r6.f6164f
            if (r0 == 0) goto L_0x003f
            r4 = r2
            goto L_0x0040
        L_0x003f:
            r4 = r1
        L_0x0040:
            boolean r5 = r0 instanceof v0.a.f
            r5 = r5 ^ r2
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0030
            java.lang.Object r6 = c(r0)
            return r6
        L_0x004b:
            r6.e(r3)
            java.lang.InterruptedException r6 = new java.lang.InterruptedException
            r6.<init>()
            throw r6
        L_0x0054:
            v0.a$h r0 = r6.f6166h
            v0.a$h r4 = v0.a.h.f6179c
            if (r0 != r4) goto L_0x0025
        L_0x005a:
            java.lang.Object r6 = r6.f6164f
            java.lang.Object r6 = c(r6)
            return r6
        L_0x0061:
            java.lang.InterruptedException r6 = new java.lang.InterruptedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.a.get():java.lang.Object");
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f6164f instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f6164f;
        return (!(obj instanceof f)) & (obj != null);
    }

    @Override // java.lang.Object
    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f6164f instanceof b) {
            str = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    str2 = d();
                } catch (RuntimeException e7) {
                    StringBuilder d7 = androidx.activity.h.d("Exception thrown from implementation: ");
                    d7.append(e7.getClass());
                    str2 = d7.toString();
                }
                if (str2 != null && !str2.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str2);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                } else if (!isDone()) {
                    str = "PENDING";
                }
            }
            a(sb);
            sb.append("]");
            return sb.toString();
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        java.util.concurrent.locks.LockSupport.parkNanos(r18, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (java.lang.Thread.interrupted() != false) goto L_0x0075;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        r4 = r18.f6164f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
        if (r4 == null) goto L_0x005b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        if ((r5 & (!(r4 instanceof v0.a.f))) == false) goto L_0x0067;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
        return (V) c(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        r4 = r10 - java.lang.System.nanoTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
        if (r4 >= 1000) goto L_0x004c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
        e(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
        e(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V get(long r19, java.util.concurrent.TimeUnit r21) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.a.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }
}
