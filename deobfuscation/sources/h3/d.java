package h3;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class d extends e<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    @Override // h3.e
    public final void l(Drawable drawable) {
        ((ImageView) this.f4384f).setImageDrawable(drawable);
    }
}
