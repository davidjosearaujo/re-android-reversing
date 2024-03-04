package androidx.emoji2.text;

import android.content.Context;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.f;
import androidx.emoji2.text.l;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements i2.b<Boolean> {

    /* loaded from: classes.dex */
    public static class a extends f.c {
        public a(Context context) {
            super(new b(context));
            this.f1521b = 1;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements f.g {

        /* renamed from: a */
        public final Context f1503a;

        public b(Context context) {
            this.f1503a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.f.g
        public final void a(final f.h hVar) {
            final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("EmojiCompatInitializer"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(new Runnable() { // from class: androidx.emoji2.text.g
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.b bVar = EmojiCompatInitializer.b.this;
                    f.h hVar2 = hVar;
                    ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                    bVar.getClass();
                    try {
                        l a7 = c.a(bVar.f1503a);
                        if (a7 == null) {
                            throw new RuntimeException("EmojiCompat font provider not available on this device.");
                        }
                        l.b bVar2 = (l.b) a7.f1520a;
                        synchronized (bVar2.f1549d) {
                            bVar2.f1550f = threadPoolExecutor2;
                        }
                        a7.f1520a.a(new h(hVar2, threadPoolExecutor2));
                    } catch (Throwable th) {
                        hVar2.a(th);
                        threadPoolExecutor2.shutdown();
                    }
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                l1.h.a("EmojiCompat.EmojiCompatInitializer.run");
                if (f.f1509j != null) {
                    f.a().c();
                }
            } finally {
                l1.h.b();
            }
        }
    }

    @Override // i2.b
    public final List<Class<? extends i2.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // i2.b
    /* renamed from: c */
    public final Boolean b(Context context) {
        Object obj;
        a aVar = new a(context);
        if (f.f1509j == null) {
            synchronized (f.f1508i) {
                if (f.f1509j == null) {
                    f.f1509j = new f(aVar);
                }
            }
        }
        i2.a c7 = i2.a.c(context);
        c7.getClass();
        synchronized (i2.a.e) {
            try {
                obj = c7.f4473a.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = c7.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        final androidx.lifecycle.o k6 = ((androidx.lifecycle.n) obj).k();
        k6.a(new androidx.lifecycle.b() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.b
            public final void b(androidx.lifecycle.n nVar) {
                EmojiCompatInitializer.this.getClass();
                androidx.emoji2.text.b.a(Looper.getMainLooper()).postDelayed(new c(), 500L);
                k6.c(this);
            }
        });
        return Boolean.TRUE;
    }
}
