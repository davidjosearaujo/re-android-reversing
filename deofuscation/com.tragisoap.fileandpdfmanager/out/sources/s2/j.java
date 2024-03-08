package s2;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.activity.h;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import k3.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j implements d {

    /* renamed from: j  reason: collision with root package name */
    public static final Bitmap.Config f5948j = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    public final k f5949a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<Bitmap.Config> f5950b;

    /* renamed from: c  reason: collision with root package name */
    public final a f5951c = new a();

    /* renamed from: d  reason: collision with root package name */
    public long f5952d;
    public long e;

    /* renamed from: f  reason: collision with root package name */
    public int f5953f;

    /* renamed from: g  reason: collision with root package name */
    public int f5954g;

    /* renamed from: h  reason: collision with root package name */
    public int f5955h;

    /* renamed from: i  reason: collision with root package name */
    public int f5956i;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {
    }

    public j(long j7) {
        m mVar = new m();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        Set<Bitmap.Config> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f5952d = j7;
        this.f5949a = mVar;
        this.f5950b = unmodifiableSet;
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
        h(0);
    }

    @Override // s2.d
    public final Bitmap c(int i7, int i8, Bitmap.Config config) {
        Bitmap g2 = g(i7, i8, config);
        if (g2 != null) {
            return g2;
        }
        if (config == null) {
            config = f5948j;
        }
        return Bitmap.createBitmap(i7, i8, config);
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
            } else if (!bitmap.isRecycled()) {
                if (bitmap.isMutable()) {
                    ((m) this.f5949a).getClass();
                    if (((long) l.c(bitmap)) <= this.f5952d && this.f5950b.contains(bitmap.getConfig())) {
                        ((m) this.f5949a).getClass();
                        int c7 = l.c(bitmap);
                        ((m) this.f5949a).f(bitmap);
                        this.f5951c.getClass();
                        this.f5955h++;
                        this.e += (long) c7;
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
            } else {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void f() {
        StringBuilder d7 = h.d("Hits=");
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
            if (config != Bitmap.Config.HARDWARE) {
                b2 = ((m) this.f5949a).b(i7, i8, config != null ? config : f5948j);
                if (b2 == null) {
                    if (Log.isLoggable("LruBitmapPool", 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Missing bitmap=");
                        ((m) this.f5949a).getClass();
                        sb.append(m.c(l.d(config) * i7 * i8, config));
                        Log.d("LruBitmapPool", sb.toString());
                    }
                    this.f5954g++;
                } else {
                    this.f5953f++;
                    long j7 = this.e;
                    ((m) this.f5949a).getClass();
                    this.e = j7 - ((long) l.c(b2));
                    this.f5951c.getClass();
                    b2.setHasAlpha(true);
                    b2.setPremultiplied(true);
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Get bitmap=");
                    ((m) this.f5949a).getClass();
                    sb2.append(m.c(l.d(config) * i7 * i8, config));
                    Log.v("LruBitmapPool", sb2.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    f();
                }
            } else {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
        } catch (Throwable th) {
            throw th;
        }
        return b2;
    }

    public final synchronized void h(long j7) {
        while (this.e > j7) {
            m mVar = (m) this.f5949a;
            Bitmap c7 = mVar.f5962b.c();
            if (c7 != null) {
                mVar.a(Integer.valueOf(l.c(c7)), c7);
            }
            if (c7 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    f();
                }
                this.e = 0;
                return;
            }
            this.f5951c.getClass();
            long j8 = this.e;
            ((m) this.f5949a).getClass();
            this.e = j8 - ((long) l.c(c7));
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
