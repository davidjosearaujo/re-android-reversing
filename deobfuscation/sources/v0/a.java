package v0;

import androidx.fragment.app.s0;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
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
    /* loaded from: classes.dex */
    public static abstract class AbstractC0115a {
        public abstract boolean a(a aVar, d dVar);

        public abstract boolean b(a<?> aVar, Object obj, Object obj2);

        public abstract boolean c(a<?> aVar, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a */
        public final Throwable f6170a;

        /* renamed from: v0.a$c$a */
        /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static final class f<V> implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends AbstractC0115a {
        @Override // v0.a.AbstractC0115a
        public final boolean a(a aVar, d dVar) {
            d dVar2 = d.f6171d;
            synchronized (aVar) {
                if (aVar.f6165g == dVar) {
                    aVar.f6165g = dVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // v0.a.AbstractC0115a
        public final boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f6164f == obj) {
                    aVar.f6164f = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // v0.a.AbstractC0115a
        public final boolean c(a<?> aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                if (aVar.f6166h == hVar) {
                    aVar.f6166h = hVar2;
                    return true;
                }
                return false;
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

    /* loaded from: classes.dex */
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
        AbstractC0115a gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "h"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "g"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "f"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f6162k = gVar;
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
            d dVar3 = dVar.f6174c;
            dVar.f6174c = dVar2;
            dVar2 = dVar;
            dVar = dVar3;
        }
        while (dVar2 != null) {
            d dVar4 = dVar2.f6174c;
            Runnable runnable = dVar2.f6172a;
            if (runnable instanceof f) {
                ((f) runnable).getClass();
                throw null;
            }
            Executor executor = dVar2.f6173b;
            try {
                executor.execute(runnable);
            } catch (RuntimeException e7) {
                f6161j.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e7);
            }
            dVar2 = dVar4;
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
        } else {
            if (obj == f6163l) {
                return null;
            }
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
                } catch (CancellationException unused) {
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
            } catch (InterruptedException unused2) {
                z6 = true;
            } catch (Throwable th) {
                if (z6) {
                    Thread.currentThread().interrupt();
                }
                throw th;
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
        if (obj instanceof f) {
            ((f) obj).getClass();
            throw null;
        }
        return true;
    }

    public final String d() {
        Object obj = this.f6164f;
        if (obj instanceof f) {
            StringBuilder d7 = androidx.activity.h.d("setFuture=[");
            ((f) obj).getClass();
            d7.append("null");
            d7.append("]");
            return d7.toString();
        } else if (this instanceof ScheduledFuture) {
            StringBuilder d8 = androidx.activity.h.d("remaining delay=[");
            d8.append(((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS));
            d8.append(" ms]");
            return d8.toString();
        } else {
            return null;
        }
    }

    public final void e(h hVar) {
        hVar.f6180a = null;
        while (true) {
            h hVar2 = this.f6166h;
            if (hVar2 == h.f6179c) {
                return;
            }
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
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f6164f;
        if ((obj2 != null) && (!(obj2 instanceof f))) {
            return (V) c(obj2);
        }
        h hVar = this.f6166h;
        if (hVar != h.f6179c) {
            h hVar2 = new h();
            do {
                AbstractC0115a abstractC0115a = f6162k;
                abstractC0115a.d(hVar2, hVar);
                if (abstractC0115a.c(this, hVar, hVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            e(hVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f6164f;
                    } while (!((obj != null) & (!(obj instanceof f))));
                    return (V) c(obj);
                }
                hVar = this.f6166h;
            } while (hVar != h.f6179c);
            return (V) c(this.f6164f);
        }
        return (V) c(this.f6164f);
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

    public final String toString() {
        String sb;
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (!(this.f6164f instanceof b)) {
            if (!isDone()) {
                try {
                    sb = d();
                } catch (RuntimeException e7) {
                    StringBuilder d7 = androidx.activity.h.d("Exception thrown from implementation: ");
                    d7.append(e7.getClass());
                    sb = d7.toString();
                }
                if (sb != null && !sb.isEmpty()) {
                    sb2.append("PENDING, info=[");
                    sb2.append(sb);
                    sb2.append("]");
                    sb2.append("]");
                    return sb2.toString();
                }
                str = isDone() ? "PENDING" : "PENDING";
            }
            a(sb2);
            sb2.append("]");
            return sb2.toString();
        }
        str = "CANCELLED";
        sb2.append(str);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j5, TimeUnit timeUnit) {
        Locale locale;
        long nanos = timeUnit.toNanos(j5);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f6164f;
        boolean z6 = true;
        if ((obj != null) && (!(obj instanceof f))) {
            return (V) c(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f6166h;
            if (hVar != h.f6179c) {
                h hVar2 = new h();
                do {
                    AbstractC0115a abstractC0115a = f6162k;
                    abstractC0115a.d(hVar2, hVar);
                    if (abstractC0115a.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                e(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f6164f;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return (V) c(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        e(hVar2);
                    } else {
                        hVar = this.f6166h;
                    }
                } while (hVar != h.f6179c);
                return (V) c(this.f6164f);
            }
            return (V) c(this.f6164f);
        }
        while (nanos > 0) {
            Object obj3 = this.f6164f;
            if ((obj3 != null) && (!(obj3 instanceof f))) {
                return (V) c(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String str = "Waited " + j5 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String h7 = s0.h(str, " (plus ");
            long j7 = -nanos;
            long convert = timeUnit.convert(j7, TimeUnit.NANOSECONDS);
            long nanos2 = j7 - timeUnit.toNanos(convert);
            int i7 = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
            if (i7 != 0 && nanos2 <= 1000) {
                z6 = false;
            }
            if (i7 > 0) {
                String str2 = h7 + convert + " " + lowerCase;
                if (z6) {
                    str2 = s0.h(str2, ",");
                }
                h7 = s0.h(str2, " ");
            }
            if (z6) {
                h7 = h7 + nanos2 + " nanoseconds ";
            }
            str = s0.h(h7, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(s0.h(str, " but future completed as timeout expired"));
        }
        throw new TimeoutException(str + " for " + aVar);
    }
}
