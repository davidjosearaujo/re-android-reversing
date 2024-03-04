package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.emoji2.text.f;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class l extends f.c {

    /* renamed from: d */
    public static final a f1545d = new a();

    /* loaded from: classes.dex */
    public static class a {
    }

    /* loaded from: classes.dex */
    public static class b implements f.g {

        /* renamed from: a */
        public final Context f1546a;

        /* renamed from: b */
        public final m1.f f1547b;

        /* renamed from: c */
        public final a f1548c;

        /* renamed from: d */
        public final Object f1549d;
        public Handler e;

        /* renamed from: f */
        public Executor f1550f;

        /* renamed from: g */
        public ThreadPoolExecutor f1551g;

        /* renamed from: h */
        public f.h f1552h;

        public b(Context context, m1.f fVar) {
            a aVar = l.f1545d;
            this.f1549d = new Object();
            if (context == null) {
                throw new NullPointerException("Context cannot be null");
            }
            this.f1546a = context.getApplicationContext();
            this.f1547b = fVar;
            this.f1548c = aVar;
        }

        @Override // androidx.emoji2.text.f.g
        public final void a(f.h hVar) {
            synchronized (this.f1549d) {
                this.f1552h = hVar;
            }
            c();
        }

        public final void b() {
            synchronized (this.f1549d) {
                this.f1552h = null;
                Handler handler = this.e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f1551g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f1550f = null;
                this.f1551g = null;
            }
        }

        public final void c() {
            synchronized (this.f1549d) {
                if (this.f1552h == null) {
                    return;
                }
                if (this.f1550f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new androidx.emoji2.text.a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f1551g = threadPoolExecutor;
                    this.f1550f = threadPoolExecutor;
                }
                this.f1550f.execute(new androidx.activity.d(7, this));
            }
        }

        public final m1.m d() {
            try {
                a aVar = this.f1548c;
                Context context = this.f1546a;
                m1.f fVar = this.f1547b;
                aVar.getClass();
                m1.l a7 = m1.e.a(context, fVar);
                if (a7.f5066a != 0) {
                    StringBuilder d7 = androidx.activity.h.d("fetchFonts failed (");
                    d7.append(a7.f5066a);
                    d7.append(")");
                    throw new RuntimeException(d7.toString());
                }
                m1.m[] mVarArr = a7.f5067b;
                if (mVarArr == null || mVarArr.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return mVarArr[0];
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }
    }

    public l(Context context, m1.f fVar) {
        super(new b(context, fVar));
    }
}
