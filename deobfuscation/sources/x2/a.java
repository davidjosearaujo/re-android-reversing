package x2;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Log;
import android.util.Size;
import p2.g;
import p2.h;
import p2.i;
import y2.k;
import y2.l;
import y2.q;

/* loaded from: classes.dex */
public final class a implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a */
    public final q f6462a;

    /* renamed from: b */
    public final int f6463b;

    /* renamed from: c */
    public final int f6464c;

    /* renamed from: d */
    public final p2.b f6465d;
    public final k e;

    /* renamed from: f */
    public final boolean f6466f;

    /* renamed from: g */
    public final i f6467g;

    /* renamed from: x2.a$a */
    /* loaded from: classes.dex */
    public class C0135a implements ImageDecoder.OnPartialImageListener {
        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public final boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public a(int i7, int i8, h hVar) {
        if (q.f6636f == null) {
            synchronized (q.class) {
                if (q.f6636f == null) {
                    q.f6636f = new q();
                }
            }
        }
        this.f6462a = q.f6636f;
        this.f6463b = i7;
        this.f6464c = i8;
        this.f6465d = (p2.b) hVar.c(l.f6622f);
        this.e = (k) hVar.c(k.f6620f);
        g<Boolean> gVar = l.f6625i;
        this.f6466f = hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue();
        this.f6467g = (i) hVar.c(l.f6623g);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        boolean z6 = false;
        if (this.f6462a.a(this.f6463b, this.f6464c, this.f6466f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f6465d == p2.b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new C0135a());
        Size size = imageInfo.getSize();
        int i7 = this.f6463b;
        if (i7 == Integer.MIN_VALUE) {
            i7 = size.getWidth();
        }
        int i8 = this.f6464c;
        if (i8 == Integer.MIN_VALUE) {
            i8 = size.getHeight();
        }
        float b2 = this.e.b(size.getWidth(), size.getHeight(), i7, i8);
        int round = Math.round(size.getWidth() * b2);
        int round2 = Math.round(size.getHeight() * b2);
        if (Log.isLoggable("ImageDecoder", 2)) {
            StringBuilder d7 = androidx.activity.h.d("Resizing from [");
            d7.append(size.getWidth());
            d7.append("x");
            d7.append(size.getHeight());
            d7.append("] to [");
            d7.append(round);
            d7.append("x");
            d7.append(round2);
            d7.append("] scaleFactor: ");
            d7.append(b2);
            Log.v("ImageDecoder", d7.toString());
        }
        imageDecoder.setTargetSize(round, round2);
        i iVar = this.f6467g;
        if (iVar != null) {
            if (iVar == i.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                z6 = true;
            }
            imageDecoder.setTargetColorSpace(ColorSpace.get(z6 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
        }
    }
}
