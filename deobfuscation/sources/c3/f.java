package c3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.m;
import com.bumptech.glide.n;
import java.util.ArrayList;
import p2.l;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    public final o2.a f2538a;

    /* renamed from: b */
    public final Handler f2539b;

    /* renamed from: c */
    public final ArrayList f2540c;

    /* renamed from: d */
    public final n f2541d;
    public final s2.d e;

    /* renamed from: f */
    public boolean f2542f;

    /* renamed from: g */
    public boolean f2543g;

    /* renamed from: h */
    public m<Bitmap> f2544h;

    /* renamed from: i */
    public a f2545i;

    /* renamed from: j */
    public boolean f2546j;

    /* renamed from: k */
    public a f2547k;

    /* renamed from: l */
    public Bitmap f2548l;
    public l<Bitmap> m;

    /* renamed from: n */
    public a f2549n;

    /* renamed from: o */
    public int f2550o;

    /* renamed from: p */
    public int f2551p;

    /* renamed from: q */
    public int f2552q;

    /* loaded from: classes.dex */
    public static class a extends h3.c<Bitmap> {

        /* renamed from: i */
        public final Handler f2553i;

        /* renamed from: j */
        public final int f2554j;

        /* renamed from: k */
        public final long f2555k;

        /* renamed from: l */
        public Bitmap f2556l;

        public a(Handler handler, int i7, long j5) {
            this.f2553i = handler;
            this.f2554j = i7;
            this.f2555k = j5;
        }

        @Override // h3.g
        public final void i(Drawable drawable) {
            this.f2556l = null;
        }

        @Override // h3.g
        public final void j(Object obj) {
            this.f2556l = (Bitmap) obj;
            this.f2553i.sendMessageAtTime(this.f2553i.obtainMessage(1, this), this.f2555k);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes.dex */
    public class c implements Handler.Callback {
        public c() {
            f.this = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 1) {
                f.this.b((a) message.obj);
                return true;
            } else if (i7 == 2) {
                f.this.f2541d.l((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    public f(com.bumptech.glide.b bVar, o2.e eVar, int i7, int i8, x2.b bVar2, Bitmap bitmap) {
        s2.d dVar = bVar.f2623f;
        n d7 = com.bumptech.glide.b.d(bVar.f2625h.getBaseContext());
        n d8 = com.bumptech.glide.b.d(bVar.f2625h.getBaseContext());
        d8.getClass();
        m<Bitmap> r6 = new m(d8.f2738f, d8, Bitmap.class, d8.f2739g).r(n.f2737p).r(((g3.g) ((g3.g) new g3.g().d(r2.l.f5793a).p()).m()).h(i7, i8));
        this.f2540c = new ArrayList();
        this.f2541d = d7;
        Handler handler = new Handler(Looper.getMainLooper(), new c());
        this.e = dVar;
        this.f2539b = handler;
        this.f2544h = r6;
        this.f2538a = eVar;
        c(bVar2, bitmap);
    }

    public final void a() {
        if (!this.f2542f || this.f2543g) {
            return;
        }
        a aVar = this.f2549n;
        if (aVar != null) {
            this.f2549n = null;
            b(aVar);
            return;
        }
        this.f2543g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f2538a.e();
        this.f2538a.c();
        this.f2547k = new a(this.f2539b, this.f2538a.a(), uptimeMillis);
        m<Bitmap> w6 = this.f2544h.r(new g3.g().l(new j3.d(Double.valueOf(Math.random())))).w(this.f2538a);
        w6.v(this.f2547k, w6);
    }

    public final void b(a aVar) {
        this.f2543g = false;
        if (this.f2546j) {
            this.f2539b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f2542f) {
            this.f2549n = aVar;
        } else {
            if (aVar.f2556l != null) {
                Bitmap bitmap = this.f2548l;
                if (bitmap != null) {
                    this.e.e(bitmap);
                    this.f2548l = null;
                }
                a aVar2 = this.f2545i;
                this.f2545i = aVar;
                int size = this.f2540c.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    ((b) this.f2540c.get(size)).a();
                }
                if (aVar2 != null) {
                    this.f2539b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            a();
        }
    }

    public final void c(l<Bitmap> lVar, Bitmap bitmap) {
        q2.a.i(lVar);
        this.m = lVar;
        q2.a.i(bitmap);
        this.f2548l = bitmap;
        this.f2544h = this.f2544h.r(new g3.g().o(lVar, true));
        this.f2550o = k3.l.c(bitmap);
        this.f2551p = bitmap.getWidth();
        this.f2552q = bitmap.getHeight();
    }
}
