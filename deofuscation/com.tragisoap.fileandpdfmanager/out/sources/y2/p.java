package y2;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import p2.f;
import s2.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f6635b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(f.f5564a);

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f6635b);
    }

    @Override // y2.e
    public final Bitmap c(d dVar, Bitmap bitmap, int i7, int i8) {
        return v.b(dVar, bitmap, i7, i8);
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        return obj instanceof p;
    }

    @Override // p2.f
    public final int hashCode() {
        return 1572326941;
    }
}
