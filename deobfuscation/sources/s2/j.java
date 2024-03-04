package s2;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class j implements d {

    /* renamed from: j */
    public static final Bitmap.Config f5948j = Bitmap.Config.ARGB_8888;

    /* renamed from: a */
    public final k f5949a;

    /* renamed from: b */
    public final Set<Bitmap.Config> f5950b;

    /* renamed from: c */
    public final a f5951c;

    /* renamed from: d */
    public long f5952d;
    public long e;

    /* renamed from: f */
    public int f5953f;

    /* renamed from: g */
    public int f5954g;

    /* renamed from: h */
    public int f5955h;

    /* renamed from: i */
    public int f5956i;

    /* loaded from: classes.dex */
    public static final class a {
    }

    public j(long j5) {
        m mVar = new m();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        Set<Bitmap.Config> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f5952d = j5;
        this.f5949a = mVar;
        this.f5950b = unmodifiableSet;
        this.f5951c = new a();
    }

    @Override // s2.d
    @SuppressLint({"InlinedApi"})
    public final void a(int i7) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i7);
        }
        if (i7 >= 40 || i7 >= 20) {
            b();
        } else if (i7 >= 20 || i7 == 15) {
            h(this.f5952d / 2);
        }
    }

    @Override // s2.d
    public final void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        h(0L);
    }

    @Override // s2.d
    public final Bitmap c(int i7, int i8, Bitmap.Config config) {
        Bitmap g2 = g(i7, i8, config);
        if (g2 == null) {
            if (config == null) {
                config = f5948j;
            }
            return Bitmap.createBitmap(i7, i8, config);
        }
        return g2;
    }

    @Override // s2.d
    public final Bitmap d(int i7, int i8, Bitmap.Config config) {
        Bitmap g2 = g(i7, i8, config);
        if (g2 != null) {
            g2.eraseColor(0);
            return g2;
        }
        if (config == null) {
            config = f5948j;
        }
        return Bitmap.createBitmap(i7, i8, config);
    }

    @Override // s2.d
    public final synchronized void e(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                ((m) this.f5949a).getClass();
                if (k3.l.c(bitmap) <= this.f5952d && this.f5950b.contains(bitmap.getConfig())) {
                    ((m) this.f5949a).getClass();
                    int c7 = k3.l.c(bitmap);
                    ((m) this.f5949a).f(bitmap);
                    this.f5951c.getClass();
                    this.f5955h++;
                    this.e += c7;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Put bitmap in pool=" + ((m) this.f5949a).e(bitmap));
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        f();
                    }
                    h(this.f5952d);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + ((m) this.f5949a).e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f5950b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void f() {
        StringBuilder d7 = androidx.activity.h.d("Hits=");
        d7.append(this.f5953f);
        d7.append(", misses=");
        d7.append(this.f5954g);
        d7.append(", puts=");
        d7.append(this.f5955h);
        d7.append(", evictions=");
        d7.append(this.f5956i);
        d7.append(", currentSize=");
        d7.append(this.e);
        d7.append(", maxSize=");
        d7.append(this.f5952d);
        d7.append("\nStrategy=");
        d7.append(this.f5949a);
        Log.v("LruBitmapPool", d7.toString());
    }

    public final synchronized Bitmap g(int i7, int i8, Bitmap.Config config) {
        Bitmap b2;
        try {
            if (config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
            b2 = ((m) this.f5949a).b(i7, i8, config != null ? config : f5948j);
            if (b2 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Missing bitmap=");
                    ((m) this.f5949a).getClass();
                    sb.append(m.c(k3.l.d(config) * i7 * i8, config));
                    Log.d("LruBitmapPool", sb.toString());
                }
                this.f5954g++;
            } else {
                this.f5953f++;
                long j5 = this.e;
                ((m) this.f5949a).getClass();
                this.e = j5 - k3.l.c(b2);
                this.f5951c.getClass();
                b2.setHasAlpha(true);
                b2.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Get bitmap=");
                ((m) this.f5949a).getClass();
                sb2.append(m.c(k3.l.d(config) * i7 * i8, config));
                Log.v("LruBitmapPool", sb2.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b2;
    }

    public final synchronized void h(long j5) {
        while (this.e > j5) {
            m mVar = (m) this.f5949a;
            Bitmap c7 = mVar.f5962b.c();
            if (c7 != null) {
                mVar.a(Integer.valueOf(k3.l.c(c7)), c7);
            }
            if (c7 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    f();
                }
                this.e = 0L;
                return;
            }
            this.f5951c.getClass();
            long j7 = this.e;
            ((m) this.f5949a).getClass();
            this.e = j7 - k3.l.c(c7);
            this.f5956i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + ((m) this.f5949a).e(c7));
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                f();
            }
            c7.recycle();
        }
    }
}
