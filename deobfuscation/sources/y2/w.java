package y2;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public final class w implements p2.j<Bitmap, Bitmap> {

    /* loaded from: classes.dex */
    public static final class a implements r2.v<Bitmap> {

        /* renamed from: f */
        public final Bitmap f6664f;

        public a(Bitmap bitmap) {
            this.f6664f = bitmap;
        }

        @Override // r2.v
        public final int b() {
            return k3.l.c(this.f6664f);
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
    public final /* bridge */ /* synthetic */ boolean a(Bitmap bitmap, p2.h hVar) {
        return true;
    }

    @Override // p2.j
    public final r2.v<Bitmap> b(Bitmap bitmap, int i7, int i8, p2.h hVar) {
        return new a(bitmap);
    }
}
