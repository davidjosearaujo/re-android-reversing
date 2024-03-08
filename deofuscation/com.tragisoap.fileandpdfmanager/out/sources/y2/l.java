package y2;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.activity.h;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.locks.Lock;
import p2.g;
import p2.i;
import s2.d;
import y2.k;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l {

    /* renamed from: h */
    public static final g<Boolean> f6624h;

    /* renamed from: i */
    public static final g<Boolean> f6625i;

    /* renamed from: a */
    public final d f6628a;

    /* renamed from: b */
    public final DisplayMetrics f6629b;

    /* renamed from: c */
    public final s2.b f6630c;

    /* renamed from: d */
    public final List<ImageHeaderParser> f6631d;
    public final q e;

    /* renamed from: f */
    public static final g<p2.b> f6622f = g.a(p2.b.PREFER_ARGB_8888, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");

    /* renamed from: g */
    public static final g<i> f6623g = new g<>("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, g.e);

    /* renamed from: j */
    public static final a f6626j = new a();

    /* renamed from: k */
    public static final ArrayDeque f6627k = new ArrayDeque(0);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements b {
        @Override // y2.l.b
        public final void a(Bitmap bitmap, d dVar) {
        }

        @Override // y2.l.b
        public final void b() {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        void a(Bitmap bitmap, d dVar);

        void b();
    }

    static {
        k.e eVar = k.f6616a;
        Boolean bool = Boolean.FALSE;
        f6624h = g.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        f6625i = g.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        char[] cArr = k3.l.f4712a;
    }

    public l(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, d dVar, s2.b bVar) {
        if (q.f6636f == null) {
            synchronized (q.class) {
                if (q.f6636f == null) {
                    q.f6636f = new q();
                }
            }
        }
        this.e = q.f6636f;
        this.f6631d = list;
        q2.a.i(displayMetrics);
        this.f6629b = displayMetrics;
        q2.a.i(dVar);
        this.f6628a = dVar;
        q2.a.i(bVar);
        this.f6630c = bVar;
    }

    public static Bitmap c(r rVar, BitmapFactory.Options options, b bVar, d dVar) {
        if (!options.inJustDecodeBounds) {
            bVar.b();
            rVar.b();
        }
        int i7 = options.outWidth;
        int i8 = options.outHeight;
        String str = options.outMimeType;
        Lock lock = v.f6663b;
        lock.lock();
        try {
            try {
                Bitmap a7 = rVar.a(options);
                lock.unlock();
                return a7;
            } catch (IllegalArgumentException e) {
                IOException e7 = e(e, i7, i8, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", e7);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        dVar.e(bitmap);
                        options.inBitmap = null;
                        Bitmap c7 = c(rVar, options, bVar, dVar);
                        v.f6663b.unlock();
                        return c7;
                    } catch (IOException unused) {
                        throw e7;
                    }
                } else {
                    throw e7;
                }
            }
        } catch (Throwable th) {
            v.f6663b.unlock();
            throw th;
        }
    }

    @TargetApi(19)
    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder d7 = h.d(" (");
        d7.append(bitmap.getAllocationByteCount());
        d7.append(")");
        String sb = d7.toString();
        StringBuilder d8 = h.d("[");
        d8.append(bitmap.getWidth());
        d8.append("x");
        d8.append(bitmap.getHeight());
        d8.append("] ");
        d8.append(bitmap.getConfig());
        d8.append(sb);
        return d8.toString();
    }

    public static IOException e(IllegalArgumentException illegalArgumentException, int i7, int i8, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i7 + ", outHeight: " + i8 + ", outMimeType: " + str + ", inBitmap: " + d(options.inBitmap), illegalArgumentException);
    }

    public static void f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final d a(r rVar, int i7, int i8, p2.h hVar, b bVar) {
        ArrayDeque arrayDeque;
        BitmapFactory.Options options;
        byte[] bArr = (byte[]) this.f6630c.c(65536, byte[].class);
        synchronized (l.class) {
            try {
                arrayDeque = f6627k;
                synchronized (arrayDeque) {
                    options = (BitmapFactory.Options) arrayDeque.poll();
                }
                if (options == null) {
                    options = new BitmapFactory.Options();
                    f(options);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        options.inTempStorage = bArr;
        p2.b bVar2 = (p2.b) hVar.c(f6622f);
        i iVar = (i) hVar.c(f6623g);
        k kVar = (k) hVar.c(k.f6620f);
        boolean booleanValue = ((Boolean) hVar.c(f6624h)).booleanValue();
        g<Boolean> gVar = f6625i;
        try {
            d d7 = d.d(b(rVar, options, kVar, bVar2, iVar, hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue(), i7, i8, booleanValue, bVar), this.f6628a);
            f(options);
            synchronized (arrayDeque) {
                try {
                    arrayDeque.offer(options);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f6630c.put(bArr);
            return d7;
        } catch (Throwable th3) {
            f(options);
            ArrayDeque arrayDeque2 = f6627k;
            synchronized (arrayDeque2) {
                try {
                    arrayDeque2.offer(options);
                    this.f6630c.put(bArr);
                    throw th3;
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x033a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0497  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(y2.r r34, android.graphics.BitmapFactory.Options r35, y2.k r36, p2.b r37, p2.i r38, boolean r39, int r40, int r41, boolean r42, y2.l.b r43) {
        /*
            Method dump skipped, instructions count: 1400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.l.b(y2.r, android.graphics.BitmapFactory$Options, y2.k, p2.b, p2.i, boolean, int, int, boolean, y2.l$b):android.graphics.Bitmap");
    }
}