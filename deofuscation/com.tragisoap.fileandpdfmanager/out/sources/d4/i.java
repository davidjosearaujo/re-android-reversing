package d4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f3609a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f3610b = null;

    /* renamed from: c  reason: collision with root package name */
    public final a f3611c = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            i iVar = i.this;
            if (iVar.f3610b == animator) {
                iVar.f3610b = null;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public b(int[] iArr, ValueAnimator valueAnimator) {
        }
    }

    public final void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f3611c);
        this.f3609a.add(bVar);
    }
}
