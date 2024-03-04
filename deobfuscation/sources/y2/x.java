package y2;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p2.g;

/* loaded from: classes.dex */
public final class x<T> implements p2.j<T, Bitmap> {

    /* renamed from: d */
    public static final p2.g<Long> f6665d = new p2.g<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final p2.g<Integer> e = new p2.g<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f */
    public static final e f6666f = new e();

    /* renamed from: g */
    public static final List<String> f6667g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    /* renamed from: a */
    public final f<T> f6668a;

    /* renamed from: b */
    public final s2.d f6669b;

    /* renamed from: c */
    public final e f6670c;

    /* loaded from: classes.dex */
    public class a implements g.b<Long> {

        /* renamed from: a */
        public final ByteBuffer f6671a = ByteBuffer.allocate(8);

        @Override // p2.g.b
        public final void a(byte[] bArr, Long l6, MessageDigest messageDigest) {
            Long l7 = l6;
            messageDigest.update(bArr);
            synchronized (this.f6671a) {
                this.f6671a.position(0);
                messageDigest.update(this.f6671a.putLong(l7.longValue()).array());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements g.b<Integer> {

        /* renamed from: a */
        public final ByteBuffer f6672a = ByteBuffer.allocate(4);

        @Override // p2.g.b
        public final void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            Integer num2 = num;
            if (num2 == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f6672a) {
                this.f6672a.position(0);
                messageDigest.update(this.f6672a.putInt(num2.intValue()).array());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements f<AssetFileDescriptor> {
        @Override // y2.x.f
        public final void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements f<ByteBuffer> {
        @Override // y2.x.f
        public final void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new y(byteBuffer));
        }
    }

    /* loaded from: classes.dex */
    public static class e {
    }

    /* loaded from: classes.dex */
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t5);
    }

    /* loaded from: classes.dex */
    public static final class g implements f<ParcelFileDescriptor> {
        @Override // y2.x.f
        public final void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends RuntimeException {
        public h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public x(s2.d dVar, f<T> fVar) {
        e eVar = f6666f;
        this.f6669b = dVar;
        this.f6668a = fVar;
        this.f6670c = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:234:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0099 A[EDGE_INSN: B:247:0x0099->B:249:0x009c ?: BREAK  ] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0121 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap c(android.media.MediaMetadataRetriever r12, long r13, int r15, int r16, int r17, y2.k r18) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.x.c(android.media.MediaMetadataRetriever, long, int, int, int, y2.k):android.graphics.Bitmap");
    }

    @Override // p2.j
    public final boolean a(T t5, p2.h hVar) {
        return true;
    }

    @Override // p2.j
    public final r2.v<Bitmap> b(T t5, int i7, int i8, p2.h hVar) {
        long longValue = ((Long) hVar.c(f6665d)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) hVar.c(e);
        if (num == null) {
            num = 2;
        }
        k kVar = (k) hVar.c(k.f6620f);
        if (kVar == null) {
            kVar = k.e;
        }
        k kVar2 = kVar;
        this.f6670c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.f6668a.a(mediaMetadataRetriever, t5);
            Bitmap c7 = c(mediaMetadataRetriever, longValue, num.intValue(), i7, i8, kVar2);
            mediaMetadataRetriever.close();
            return y2.d.d(c7, this.f6669b);
        } catch (Throwable th) {
            mediaMetadataRetriever.close();
            throw th;
        }
    }
}
