package h3;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes.dex */
public abstract class e<Z> extends h<ImageView, Z> {

    /* renamed from: h */
    public Animatable f4383h;

    public e(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.manager.g
    public final void a() {
        Animatable animatable = this.f4383h;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // h3.g
    public final void c(Drawable drawable) {
        l(null);
        this.f4383h = null;
        ((ImageView) this.f4384f).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.manager.g
    public final void d() {
        Animatable animatable = this.f4383h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // h3.g
    public final void g(Drawable drawable) {
        l(null);
        this.f4383h = null;
        ((ImageView) this.f4384f).setImageDrawable(drawable);
    }

    @Override // h3.h, h3.g
    public final void i(Drawable drawable) {
        super.i(drawable);
        Animatable animatable = this.f4383h;
        if (animatable != null) {
            animatable.stop();
        }
        l(null);
        this.f4383h = null;
        ((ImageView) this.f4384f).setImageDrawable(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h3.g
    public final void j(Object obj) {
        l(obj);
        if (!(obj instanceof Animatable)) {
            this.f4383h = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.f4383h = animatable;
        animatable.start();
    }

    public abstract void l(Z z6);
}
