package androidx.fragment.app;

import android.animation.Animator;
import l1.d;

/* loaded from: classes.dex */
public final class e implements d.a {

    /* renamed from: a */
    public final /* synthetic */ Animator f1616a;

    public e(Animator animator) {
        this.f1616a = animator;
    }

    @Override // l1.d.a
    public final void onCancel() {
        this.f1616a.end();
    }
}
