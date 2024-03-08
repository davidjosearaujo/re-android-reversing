package o3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: f  reason: collision with root package name */
    public d f5328f;

    /* renamed from: g  reason: collision with root package name */
    public int f5329g = 0;

    public c() {
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v6, int i7) {
        x(coordinatorLayout, v6, i7);
        if (this.f5328f == null) {
            this.f5328f = new d(v6);
        }
        d dVar = this.f5328f;
        dVar.f5331b = dVar.f5330a.getTop();
        dVar.f5332c = dVar.f5330a.getLeft();
        this.f5328f.a();
        int i8 = this.f5329g;
        if (i8 == 0) {
            return true;
        }
        d dVar2 = this.f5328f;
        if (dVar2.f5333d != i8) {
            dVar2.f5333d = i8;
            dVar2.a();
        }
        this.f5329g = 0;
        return true;
    }

    public final int w() {
        d dVar = this.f5328f;
        if (dVar != null) {
            return dVar.f5333d;
        }
        return 0;
    }

    public void x(CoordinatorLayout coordinatorLayout, V v6, int i7) {
        coordinatorLayout.q(v6, i7);
    }
}
