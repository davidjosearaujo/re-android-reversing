package f2;

import android.view.Choreographer;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class d implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f4106a;

    public /* synthetic */ d(Runnable runnable) {
        this.f4106a = runnable;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j7) {
        this.f4106a.run();
    }
}
