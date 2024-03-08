package l2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f4965a;

    public e(d dVar) {
        this.f4965a = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ArrayList arrayList = new ArrayList(this.f4965a.f4957j);
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((c) arrayList.get(i7)).a(this.f4965a);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        ArrayList arrayList = new ArrayList(this.f4965a.f4957j);
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((c) arrayList.get(i7)).b(this.f4965a);
        }
    }
}
