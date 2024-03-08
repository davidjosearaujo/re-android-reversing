package k;

import java.util.concurrent.Executor;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class a implements Executor {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f4606f;

    public /* synthetic */ a(int i7) {
        this.f4606f = i7;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f4606f) {
            case 1:
                runnable.run();
                return;
            case 2:
                runnable.run();
                return;
            default:
                runnable.run();
                return;
        }
    }
}
