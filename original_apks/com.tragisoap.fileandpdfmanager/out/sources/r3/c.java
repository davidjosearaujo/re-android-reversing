package r3;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import q1.j;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5900a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f5901b;

    public c(BottomSheetBehavior bottomSheetBehavior, int i7) {
        this.f5901b = bottomSheetBehavior;
        this.f5900a = i7;
    }

    @Override // q1.j
    public final boolean a(View view) {
        this.f5901b.K(this.f5900a);
        return true;
    }
}
