package c4;

import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.d;

/* loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: f */
    public final /* synthetic */ d f2564f;

    public a(d dVar) {
        this.f2564f = dVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        d dVar = this.f2564f;
        float rotation = dVar.f3185q.getRotation();
        if (dVar.f3179j != rotation) {
            dVar.f3179j = rotation;
            dVar.m();
            return true;
        }
        return true;
    }
}
