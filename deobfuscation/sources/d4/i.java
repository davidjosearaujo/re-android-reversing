package d4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a */
    public final ArrayList<b> f3609a = new ArrayList<>();

    /* renamed from: b */
    public ValueAnimator f3610b = null;

    /* renamed from: c */
    public final a f3611c = new a();

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
            i.this = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            i iVar = i.this;
            if (iVar.f3610b == animator) {
                iVar.f3610b = null;
            }
        }
    }

    /* loaded from: classes.dex */
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
