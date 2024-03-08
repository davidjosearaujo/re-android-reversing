package c3;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import c3.c;
import com.bumptech.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import k3.l;
import o2.c;
import o2.e;
import p2.h;
import p2.j;
import r2.v;
import s2.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements j<ByteBuffer, c> {

    /* renamed from: f */
    public static final C0029a f2518f = new C0029a();

    /* renamed from: g */
    public static final b f2519g = new b();

    /* renamed from: a */
    public final Context f2520a;

    /* renamed from: b */
    public final List<ImageHeaderParser> f2521b;

    /* renamed from: c */
    public final b f2522c;

    /* renamed from: d */
    public final C0029a f2523d;
    public final b e;

    /* renamed from: c3.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0029a {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {

        /* renamed from: a */
        public final ArrayDeque f2524a = new ArrayDeque(0);

        public b() {
            char[] cArr = l.f4712a;
        }
    }

    public a(Context context, List<ImageHeaderParser> list, d dVar, s2.b bVar) {
        b bVar2 = f2519g;
        C0029a aVar = f2518f;
        this.f2520a = context.getApplicationContext();
        this.f2521b = list;
        this.f2523d = aVar;
        this.e = new b(dVar, bVar);
        this.f2522c = bVar2;
    }

    public static int d(c cVar, int i7, int i8) {
        int min = Math.min(cVar.f5289g / i8, cVar.f5288f / i7);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i7 + "x" + i8 + "], actual dimens: [" + cVar.f5288f + "x" + cVar.f5289g + "]");
        }
        return max;
    }

    @Override // p2.j
    public final boolean a(ByteBuffer byteBuffer, h hVar) {
        return !((Boolean) hVar.c(h.f2560b)).booleanValue() && com.bumptech.glide.load.a.b(this.f2521b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // p2.j
    public final v<c> b(ByteBuffer byteBuffer, int i7, int i8, h hVar) {
        o2.d dVar;
        ByteBuffer byteBuffer2 = byteBuffer;
        b bVar = this.f2522c;
        synchronized (bVar) {
            try {
                dVar = (o2.d) bVar.f2524a.poll();
                if (dVar == null) {
                    dVar = new o2.d();
                }
                dVar.f5295b = null;
                Arrays.fill(dVar.f5294a, (byte) 0);
                dVar.f5296c = new c();
                dVar.f5297d = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer2.asReadOnlyBuffer();
                dVar.f5295b = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                dVar.f5295b.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            d c7 = c(byteBuffer2, i7, i8, dVar, hVar);
            b bVar2 = this.f2522c;
            synchronized (bVar2) {
                try {
                    dVar.f5295b = null;
                    dVar.f5296c = null;
                    bVar2.f2524a.offer(dVar);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return c7;
        } catch (Throwable th3) {
            b bVar3 = this.f2522c;
            synchronized (bVar3) {
                try {
                    dVar.f5295b = null;
                    dVar.f5296c = null;
                    bVar3.f2524a.offer(dVar);
                    throw th3;
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }
    }

    public final d c(ByteBuffer byteBuffer, int i7, int i8, o2.d dVar, h hVar) {
        int i9 = k3.h.f4702b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            c b2 = dVar.b();
            if (b2.f5286c > 0 && b2.f5285b == 0) {
                Bitmap.Config config = hVar.c(h.f2559a) == p2.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int d7 = d(b2, i7, i8);
                C0029a aVar = this.f2523d;
                b bVar = this.e;
                aVar.getClass();
                e eVar = new e(bVar, b2, byteBuffer, d7);
                eVar.i(config);
                eVar.c();
                Bitmap b7 = eVar.b();
                if (b7 == null) {
                    return null;
                }
                d dVar2 = new d(new c(new c.a(new f(com.bumptech.glide.b.b(this.f2520a), eVar, i7, i8, x2.b.f6468b, b7))));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    StringBuilder d8 = androidx.activity.h.d("Decoded GIF from stream in ");
                    d8.append(k3.h.a(elapsedRealtimeNanos));
                    Log.v("BufferGifDecoder", d8.toString());
                }
                return dVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                StringBuilder d9 = androidx.activity.h.d("Decoded GIF from stream in ");
                d9.append(k3.h.a(elapsedRealtimeNanos));
                Log.v("BufferGifDecoder", d9.toString());
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                StringBuilder d10 = androidx.activity.h.d("Decoded GIF from stream in ");
                d10.append(k3.h.a(elapsedRealtimeNanos));
                Log.v("BufferGifDecoder", d10.toString());
            }
        }
    }
}
