package p3;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
import q1.j;

/* loaded from: classes.dex */
public final class a implements j {

    /* renamed from: a */
    public final /* synthetic */ SwipeDismissBehavior f5572a;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f5572a = swipeDismissBehavior;
    }

    @Override // q1.j
    public final boolean a(View view) {
        boolean z6 = false;
        if (this.f5572a.w(view)) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            boolean z7 = y.e.d(view) == 1;
            int i7 = this.f5572a.f2808i;
            if ((i7 == 0 && z7) || (i7 == 1 && !z7)) {
                z6 = true;
            }
            int width = view.getWidth();
            if (z6) {
                width = -width;
            }
            view.offsetLeftAndRight(width);
            view.setAlpha(0.0f);
            this.f5572a.getClass();
            return true;
        }
        return false;
    }
}
