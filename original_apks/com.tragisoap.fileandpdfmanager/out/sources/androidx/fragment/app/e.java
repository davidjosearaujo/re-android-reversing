package androidx.fragment.app;

import android.animation.Animator;
import l1.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e implements d.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Animator f1616a;

    public e(Animator animator) {
        this.f1616a = animator;
    }

    @Override // l1.d.a
    public final void onCancel() {
        this.f1616a.end();
    }
}
