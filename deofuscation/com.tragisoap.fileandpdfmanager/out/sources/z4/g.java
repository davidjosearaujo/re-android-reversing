package z4;

import java.util.concurrent.ThreadFactory;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6953a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f6954b = true;

    public g(String str) {
        this.f6953a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f6953a);
        thread.setDaemon(this.f6954b);
        return thread;
    }
}
