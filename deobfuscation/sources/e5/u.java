package e5;

import android.view.View;

/* loaded from: classes.dex */
public final class u implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ View f3859f;

    public u(View view) {
        this.f3859f = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3859f.setVisibility(0);
    }
}
