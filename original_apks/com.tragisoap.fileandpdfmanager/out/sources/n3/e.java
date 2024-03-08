package n3;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f5168a = new Matrix();

    public e() {
        super(Matrix.class, "imageMatrixProperty");
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
