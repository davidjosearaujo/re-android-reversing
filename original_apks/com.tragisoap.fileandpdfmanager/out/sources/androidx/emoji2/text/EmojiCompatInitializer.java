package androidx.emoji2.text;

import android.content.Context;
import android.os.Looper;
import androidx.emoji2.text.f;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l1.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class EmojiCompatInitializer implements i2.b<Boolean> {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends f.c {
        public a(Context context) {
            super(new b(context));
            this.f1521b = 1;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b implements f.g {

        /* renamed from: a */
        public final Context f1503a;

        public b(Context context) {
            this.f1503a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.f.g
        public final void a(f.h hVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("EmojiCompatInitializer"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(new g(this, hVar, threadPoolExecutor));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                h.a("EmojiCompat.EmojiCompatInitializer.run");
                if (f.f1509j != null) {
                    f.a().c();
                }
            } finally {
                h.b();
            }
        }
    }

    @Override // i2.b
    public final List<Class<? extends i2.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

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
        final o k6 = ((n) obj).k();
        k6.a(new androidx.lifecycle.b() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.b
            public final void b(n nVar) {
                EmojiCompatInitializer.this.getClass();
                b.a(Looper.getMainLooper()).postDelayed(new c(), 500);
                k6.c(this);
            }
        });
        return Boolean.TRUE;
    }
}
