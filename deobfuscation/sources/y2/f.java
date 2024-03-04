package y2;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;
import java.util.List;
import y2.r;

/* loaded from: classes.dex */
public final class f implements p2.j {

    /* renamed from: a */
    public final /* synthetic */ int f6606a;

    /* renamed from: b */
    public final l f6607b;

    public /* synthetic */ f(l lVar, int i7) {
        this.f6606a = i7;
        this.f6607b = lVar;
    }

    @Override // p2.j
    public final boolean a(Object obj, p2.h hVar) {
        switch (this.f6606a) {
            case 0:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                this.f6607b.getClass();
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                if (!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) {
                    this.f6607b.getClass();
                    if (!"robolectric".equals(Build.FINGERPRINT)) {
                        return true;
                    }
                }
                return false;
        }
    }

    @Override // p2.j
    public final r2.v b(Object obj, int i7, int i8, p2.h hVar) {
        switch (this.f6606a) {
            case 0:
                l lVar = this.f6607b;
                List<ImageHeaderParser> list = lVar.f6631d;
                return lVar.a(new r.a(lVar.f6630c, (ByteBuffer) obj, list), i7, i8, hVar, l.f6626j);
            default:
                l lVar2 = this.f6607b;
                return lVar2.a(new r.c((ParcelFileDescriptor) obj, lVar2.f6631d, lVar2.f6630c), i7, i8, hVar, l.f6626j);
        }
    }
}
