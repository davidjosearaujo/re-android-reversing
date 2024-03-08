package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1620a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f1621b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l.a f1622c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f fVar = f.this;
            fVar.f1620a.endViewTransition(fVar.f1621b);
            f.this.f1622c.a();
        }
    }

    public f(View view, ViewGroup viewGroup, l.a aVar) {
        this.f1620a = viewGroup;
        this.f1621b = view;
        this.f1622c = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f1620a.post(new a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
