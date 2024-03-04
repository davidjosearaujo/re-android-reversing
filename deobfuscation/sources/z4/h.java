package z4;

import i6.q;
import i6.v;
import i6.w;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import y4.m;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a */
    public static final byte[] f6955a = new byte[0];

    /* renamed from: b */
    public static final String[] f6956b = new String[0];

    /* renamed from: c */
    public static final Charset f6957c = Charset.forName("UTF-8");

    public static void a(i6.e eVar, q qVar) {
        try {
            eVar.close();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            qVar.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th == null) {
            return;
        }
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new AssertionError(th);
        }
        throw th;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!h(e)) {
                    throw e;
                }
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static String e(m mVar) {
        if (mVar.e != m.d(mVar.f6747a)) {
            return mVar.f6750d + ":" + mVar.e;
        }
        return mVar.f6750d;
    }

    public static <T> List<T> f(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static Object[] g(Object[] objArr, Object[] objArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            int length = objArr2.length;
            int i7 = 0;
            while (true) {
                if (i7 < length) {
                    Object obj2 = objArr2[i7];
                    if (obj.equals(obj2)) {
                        arrayList.add(obj2);
                        break;
                    }
                    i7++;
                }
            }
        }
        return arrayList.toArray((Object[]) Array.newInstance(String.class, arrayList.size()));
    }

    public static boolean h(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean i(v vVar, int i7, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long c7 = vVar.c().e() ? vVar.c().c() - nanoTime : Long.MAX_VALUE;
        vVar.c().d(Math.min(c7, timeUnit.toNanos(i7)) + nanoTime);
        try {
            i6.d dVar = new i6.d();
            while (vVar.B(dVar, 2048L) != -1) {
                try {
                    dVar.skip(dVar.f4498g);
                } catch (EOFException e) {
                    throw new AssertionError(e);
                }
            }
            int i8 = (c7 > Long.MAX_VALUE ? 1 : (c7 == Long.MAX_VALUE ? 0 : -1));
            w c8 = vVar.c();
            if (i8 == 0) {
                c8.a();
            } else {
                c8.d(nanoTime + c7);
            }
            return true;
        } catch (InterruptedIOException unused) {
            int i9 = (c7 > Long.MAX_VALUE ? 1 : (c7 == Long.MAX_VALUE ? 0 : -1));
            w c9 = vVar.c();
            if (i9 == 0) {
                c9.a();
            } else {
                c9.d(nanoTime + c7);
            }
            return false;
        } catch (Throwable th) {
            int i10 = (c7 > Long.MAX_VALUE ? 1 : (c7 == Long.MAX_VALUE ? 0 : -1));
            w c10 = vVar.c();
            if (i10 == 0) {
                c10.a();
            } else {
                c10.d(nanoTime + c7);
            }
            throw th;
        }
    }
}
