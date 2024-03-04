package h3;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class b extends e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    @Override // h3.e
    public final void l(Bitmap bitmap) {
        ((ImageView) this.f4384f).setImageBitmap(bitmap);
    }
}
