package y2;

import android.graphics.Bitmap;
import k3.l;
import p2.h;
import p2.j;
import r2.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class w implements j<Bitmap, Bitmap> {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements v<Bitmap> {

        /* renamed from: f  reason: collision with root package name */
        public final Bitmap f6664f;

        public a(Bitmap bitmap) {
            this.f6664f = bitmap;
        }

        @Override // r2.v
        public final int b() {
            return l.c(this.f6664f);
        }

        @Override // r2.v
        public final Class<Bitmap> c() {
            return Bitmap.class;
        }

        @Override // r2.v
        public final Bitmap get() {
            return this.f6664f;
        }

        @Override // r2.v
        public final void recycle() {
        }
    }

    @Override // p2.j
    public final /* bridge */ /* synthetic */ boolean a(Bitmap bitmap, h hVar) {
        return true;
    }

    @Override // p2.j
    public final v<Bitmap> b(Bitmap bitmap, int i7, int i8, h hVar) {
        return new a(bitmap);
    }
}
