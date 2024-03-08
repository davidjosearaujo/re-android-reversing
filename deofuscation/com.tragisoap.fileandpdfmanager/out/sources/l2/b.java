package l2;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends Animatable2.AnimationCallback {

    /* renamed from: a */
    public final /* synthetic */ c f4952a;

    public b(c cVar) {
        this.f4952a = cVar;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        this.f4952a.a(drawable);
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        this.f4952a.b(drawable);
    }
}
