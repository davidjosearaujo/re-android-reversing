package r3;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import q1.j;

/* loaded from: classes.dex */
public final class c implements j {

    /* renamed from: a */
    public final /* synthetic */ int f5900a;

    /* renamed from: b */
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
