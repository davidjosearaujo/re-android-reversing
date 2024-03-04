package n3;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class e extends Property<ImageView, Matrix> {

    /* renamed from: a */
    public final Matrix f5168a;

    public e() {
        super(Matrix.class, "imageMatrixProperty");
        this.f5168a = new Matrix();
    }

    @Override // android.util.Property
    public final Matrix get(ImageView imageView) {
        this.f5168a.set(imageView.getImageMatrix());
        return this.f5168a;
    }

    @Override // android.util.Property
    public final void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
