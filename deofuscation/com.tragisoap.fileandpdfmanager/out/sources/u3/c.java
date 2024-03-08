package u3;

import android.view.View;
import androidx.activity.d;
import com.google.android.material.carousel.CarouselLayoutManager;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class c implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f6109a;

    public /* synthetic */ c(CarouselLayoutManager carouselLayoutManager) {
        this.f6109a = carouselLayoutManager;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        CarouselLayoutManager carouselLayoutManager = this.f6109a;
        carouselLayoutManager.getClass();
        if (i7 != i11 || i8 != i12 || i9 != i13 || i10 != i14) {
            view.post(new d(9, carouselLayoutManager));
        }
    }
}
