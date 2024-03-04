package n2;

import android.annotation.TargetApi;
import android.os.StrictMode;
import androidx.activity.h;
import androidx.fragment.app.s0;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import linc.com.amplituda.ErrorCode;

/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: f */
    public final File f5130f;

    /* renamed from: g */
    public final File f5131g;

    /* renamed from: h */
    public final File f5132h;

    /* renamed from: i */
    public final File f5133i;

    /* renamed from: k */
    public long f5135k;

    /* renamed from: n */
    public BufferedWriter f5137n;

    /* renamed from: p */
    public int f5139p;
    public long m = 0;

    /* renamed from: o */
    public final LinkedHashMap<String, d> f5138o = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: q */
    public long f5140q = 0;

    /* renamed from: r */
    public final ThreadPoolExecutor f5141r = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());
    public final CallableC0083a s = new CallableC0083a();

    /* renamed from: j */
    public final int f5134j = 1;

    /* renamed from: l */
    public final int f5136l = 1;

    /* renamed from: n2.a$a */
    /* loaded from: classes.dex */
    public class CallableC0083a implements Callable<Void> {
        public CallableC0083a() {
            a.this = r1;
        }

        @Override // java.util.concurrent.Callable
        public final Void call() {
            synchronized (a.this) {
                a aVar = a.this;
                if (aVar.f5137n != null) {
                    aVar.D();
                    if (a.this.m()) {
                        a.this.z();
                        a.this.f5139p = 0;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: a */
        public final d f5143a;

        /* renamed from: b */
        public final boolean[] f5144b;

        /* renamed from: c */
        public boolean f5145c;

        public c(d dVar) {
            a.this = r1;
            this.f5143a = dVar;
            this.f5144b = dVar.e ? null : new boolean[r1.f5136l];
        }

        public final void a() {
            a.b(a.this, this, false);
        }

        public final File b() {
            File file;
            synchronized (a.this) {
                d dVar = this.f5143a;
                if (dVar.f5151f != this) {
                    throw new IllegalStateException();
                }
                if (!dVar.e) {
                    this.f5144b[0] = true;
                }
                file = dVar.f5150d[0];
                a.this.f5130f.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: a */
        public final String f5147a;

        /* renamed from: b */
        public final long[] f5148b;

        /* renamed from: c */
        public File[] f5149c;

        /* renamed from: d */
        public File[] f5150d;
        public boolean e;

        /* renamed from: f */
        public c f5151f;

        public d(String str) {
            a.this = r7;
            this.f5147a = str;
            int i7 = r7.f5136l;
            this.f5148b = new long[i7];
            this.f5149c = new File[i7];
            this.f5150d = new File[i7];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i8 = 0; i8 < r7.f5136l; i8++) {
                sb.append(i8);
                this.f5149c[i8] = new File(r7.f5130f, sb.toString());
                sb.append(".tmp");
                this.f5150d[i8] = new File(r7.f5130f, sb.toString());
                sb.setLength(length);
            }
        }

        public final String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j5 : this.f5148b) {
                sb.append(' ');
                sb.append(j5);
            }
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public final class e {

        /* renamed from: a */
        public final File[] f5153a;

        public e(File[] fileArr) {
            this.f5153a = fileArr;
        }
    }

    public a(File file, long j5) {
        this.f5130f = file;
        this.f5131g = new File(file, "journal");
        this.f5132h = new File(file, "journal.tmp");
        this.f5133i = new File(file, "journal.bkp");
        this.f5135k = j5;
    }

    public static void C(File file, File file2, boolean z6) {
        if (z6) {
            e(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void b(a aVar, c cVar, boolean z6) {
        synchronized (aVar) {
            d dVar = cVar.f5143a;
            if (dVar.f5151f != cVar) {
                throw new IllegalStateException();
            }
            if (z6 && !dVar.e) {
                for (int i7 = 0; i7 < aVar.f5136l; i7++) {
                    if (!cVar.f5144b[i7]) {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i7);
                    } else if (!dVar.f5150d[i7].exists()) {
                        cVar.a();
                        break;
                    }
                }
            }
            for (int i8 = 0; i8 < aVar.f5136l; i8++) {
                File file = dVar.f5150d[i8];
                if (!z6) {
                    e(file);
                } else if (file.exists()) {
                    File file2 = dVar.f5149c[i8];
                    file.renameTo(file2);
                    long j5 = dVar.f5148b[i8];
                    long length = file2.length();
                    dVar.f5148b[i8] = length;
                    aVar.m = (aVar.m - j5) + length;
                }
            }
            aVar.f5139p++;
            dVar.f5151f = null;
            if (dVar.e || z6) {
                dVar.e = true;
                aVar.f5137n.append((CharSequence) "CLEAN");
                aVar.f5137n.append(' ');
                aVar.f5137n.append((CharSequence) dVar.f5147a);
                aVar.f5137n.append((CharSequence) dVar.a());
                aVar.f5137n.append('\n');
                if (z6) {
                    aVar.f5140q++;
                    dVar.getClass();
                }
            } else {
                aVar.f5138o.remove(dVar.f5147a);
                aVar.f5137n.append((CharSequence) "REMOVE");
                aVar.f5137n.append(' ');
                aVar.f5137n.append((CharSequence) dVar.f5147a);
                aVar.f5137n.append('\n');
            }
            i(aVar.f5137n);
            if (aVar.m > aVar.f5135k || aVar.m()) {
                aVar.f5141r.submit(aVar.s);
            }
        }
    }

    @TargetApi(ErrorCode.INVALID_AUDIO_INPUT_STREAM_IO_CODE)
    public static void d(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void e(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(ErrorCode.INVALID_AUDIO_INPUT_STREAM_IO_CODE)
    public static void i(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static a n(File file, long j5) {
        if (j5 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    C(file2, file3, false);
                }
            }
            a aVar = new a(file, j5);
            if (aVar.f5131g.exists()) {
                try {
                    aVar.q();
                    aVar.p();
                    return aVar;
                } catch (IOException e7) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e7.getMessage() + ", removing");
                    aVar.close();
                    n2.c.a(aVar.f5130f);
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, j5);
            aVar2.z();
            return aVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final void D() {
        while (this.m > this.f5135k) {
            String key = this.f5138o.entrySet().iterator().next().getKey();
            synchronized (this) {
                if (this.f5137n == null) {
                    throw new IllegalStateException("cache is closed");
                }
                d dVar = this.f5138o.get(key);
                if (dVar != null && dVar.f5151f == null) {
                    for (int i7 = 0; i7 < this.f5136l; i7++) {
                        File file = dVar.f5149c[i7];
                        if (file.exists() && !file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                        long j5 = this.m;
                        long[] jArr = dVar.f5148b;
                        this.m = j5 - jArr[i7];
                        jArr[i7] = 0;
                    }
                    this.f5139p++;
                    this.f5137n.append((CharSequence) "REMOVE");
                    this.f5137n.append(' ');
                    this.f5137n.append((CharSequence) key);
                    this.f5137n.append('\n');
                    this.f5138o.remove(key);
                    if (m()) {
                        this.f5141r.submit(this.s);
                    }
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f5137n == null) {
            return;
        }
        Iterator it = new ArrayList(this.f5138o.values()).iterator();
        while (it.hasNext()) {
            c cVar = ((d) it.next()).f5151f;
            if (cVar != null) {
                cVar.a();
            }
        }
        D();
        d(this.f5137n);
        this.f5137n = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x001d, code lost:
        if (r0.f5151f != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final n2.a.c f(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.io.BufferedWriter r0 = r3.f5137n     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L4b
            java.util.LinkedHashMap<java.lang.String, n2.a$d> r0 = r3.f5138o     // Catch: java.lang.Throwable -> L49
            java.lang.Object r0 = r0.get(r4)     // Catch: java.lang.Throwable -> L49
            n2.a$d r0 = (n2.a.d) r0     // Catch: java.lang.Throwable -> L49
            r1 = 0
            if (r0 != 0) goto L1b
            n2.a$d r0 = new n2.a$d     // Catch: java.lang.Throwable -> L49
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L49
            java.util.LinkedHashMap<java.lang.String, n2.a$d> r1 = r3.f5138o     // Catch: java.lang.Throwable -> L49
            r1.put(r4, r0)     // Catch: java.lang.Throwable -> L49
            goto L21
        L1b:
            n2.a$c r2 = r0.f5151f     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L21
        L1f:
            monitor-exit(r3)
            goto L48
        L21:
            n2.a$c r1 = new n2.a$c     // Catch: java.lang.Throwable -> L49
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L49
            r0.f5151f = r1     // Catch: java.lang.Throwable -> L49
            java.io.BufferedWriter r0 = r3.f5137n     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = "DIRTY"
            r0.append(r2)     // Catch: java.lang.Throwable -> L49
            java.io.BufferedWriter r0 = r3.f5137n     // Catch: java.lang.Throwable -> L49
            r2 = 32
            r0.append(r2)     // Catch: java.lang.Throwable -> L49
            java.io.BufferedWriter r0 = r3.f5137n     // Catch: java.lang.Throwable -> L49
            r0.append(r4)     // Catch: java.lang.Throwable -> L49
            java.io.BufferedWriter r4 = r3.f5137n     // Catch: java.lang.Throwable -> L49
            r0 = 10
            r4.append(r0)     // Catch: java.lang.Throwable -> L49
            java.io.BufferedWriter r4 = r3.f5137n     // Catch: java.lang.Throwable -> L49
            i(r4)     // Catch: java.lang.Throwable -> L49
            goto L1f
        L48:
            return r1
        L49:
            r4 = move-exception
            goto L53
        L4b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L49
            java.lang.String r0 = "cache is closed"
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L49
            throw r4     // Catch: java.lang.Throwable -> L49
        L53:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.a.f(java.lang.String):n2.a$c");
    }

    public final synchronized e k(String str) {
        if (this.f5137n != null) {
            d dVar = this.f5138o.get(str);
            if (dVar == null) {
                return null;
            }
            if (dVar.e) {
                for (File file : dVar.f5149c) {
                    if (!file.exists()) {
                        return null;
                    }
                }
                this.f5139p++;
                this.f5137n.append((CharSequence) "READ");
                this.f5137n.append(' ');
                this.f5137n.append((CharSequence) str);
                this.f5137n.append('\n');
                if (m()) {
                    this.f5141r.submit(this.s);
                }
                return new e(dVar.f5149c);
            }
            return null;
        }
        throw new IllegalStateException("cache is closed");
    }

    public final boolean m() {
        int i7 = this.f5139p;
        return i7 >= 2000 && i7 >= this.f5138o.size();
    }

    public final void p() {
        e(this.f5132h);
        Iterator<d> it = this.f5138o.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i7 = 0;
            if (next.f5151f == null) {
                while (i7 < this.f5136l) {
                    this.m += next.f5148b[i7];
                    i7++;
                }
            } else {
                next.f5151f = null;
                while (i7 < this.f5136l) {
                    e(next.f5149c[i7]);
                    e(next.f5150d[i7]);
                    i7++;
                }
                it.remove();
            }
        }
    }

    public final void q() {
        n2.b bVar = new n2.b(new FileInputStream(this.f5131g), n2.c.f5160a);
        try {
            String b2 = bVar.b();
            String b7 = bVar.b();
            String b8 = bVar.b();
            String b9 = bVar.b();
            String b10 = bVar.b();
            if (!"libcore.io.DiskLruCache".equals(b2) || !"1".equals(b7) || !Integer.toString(this.f5134j).equals(b8) || !Integer.toString(this.f5136l).equals(b9) || !"".equals(b10)) {
                throw new IOException("unexpected journal header: [" + b2 + ", " + b7 + ", " + b9 + ", " + b10 + "]");
            }
            int i7 = 0;
            while (true) {
                try {
                    s(bVar.b());
                    i7++;
                } catch (EOFException unused) {
                    this.f5139p = i7 - this.f5138o.size();
                    if (bVar.f5158j == -1) {
                        z();
                    } else {
                        this.f5137n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5131g, true), n2.c.f5160a));
                    }
                    try {
                        bVar.close();
                        return;
                    } catch (RuntimeException e7) {
                        throw e7;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                bVar.close();
            } catch (RuntimeException e8) {
                throw e8;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void s(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException(s0.h("unexpected journal line: ", str));
        }
        int i7 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i7);
        if (indexOf2 == -1) {
            substring = str.substring(i7);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.f5138o.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i7, indexOf2);
        }
        d dVar = this.f5138o.get(substring);
        if (dVar == null) {
            dVar = new d(substring);
            this.f5138o.put(substring, dVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f5151f = new c(dVar);
                return;
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException(s0.h("unexpected journal line: ", str));
            } else {
                return;
            }
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        dVar.e = true;
        dVar.f5151f = null;
        if (split.length != a.this.f5136l) {
            StringBuilder d7 = h.d("unexpected journal line: ");
            d7.append(Arrays.toString(split));
            throw new IOException(d7.toString());
        }
        for (int i8 = 0; i8 < split.length; i8++) {
            try {
                dVar.f5148b[i8] = Long.parseLong(split[i8]);
            } catch (NumberFormatException unused) {
                StringBuilder d8 = h.d("unexpected journal line: ");
                d8.append(Arrays.toString(split));
                throw new IOException(d8.toString());
            }
        }
    }

    public final synchronized void z() {
        StringBuilder sb;
        BufferedWriter bufferedWriter = this.f5137n;
        if (bufferedWriter != null) {
            d(bufferedWriter);
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5132h), n2.c.f5160a));
        bufferedWriter2.write("libcore.io.DiskLruCache");
        bufferedWriter2.write("\n");
        bufferedWriter2.write("1");
        bufferedWriter2.write("\n");
        bufferedWriter2.write(Integer.toString(this.f5134j));
        bufferedWriter2.write("\n");
        bufferedWriter2.write(Integer.toString(this.f5136l));
        bufferedWriter2.write("\n");
        bufferedWriter2.write("\n");
        for (d dVar : this.f5138o.values()) {
            if (dVar.f5151f != null) {
                sb = new StringBuilder();
                sb.append("DIRTY ");
                sb.append(dVar.f5147a);
                sb.append('\n');
            } else {
                sb = new StringBuilder();
                sb.append("CLEAN ");
                sb.append(dVar.f5147a);
                sb.append(dVar.a());
                sb.append('\n');
            }
            bufferedWriter2.write(sb.toString());
        }
        d(bufferedWriter2);
        if (this.f5131g.exists()) {
            C(this.f5131g, this.f5133i, true);
        }
        C(this.f5132h, this.f5131g, false);
        this.f5133i.delete();
        this.f5137n = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5131g, true), n2.c.f5160a));
    }
}
