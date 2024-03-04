package z4;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class g implements ThreadFactory {

    /* renamed from: a */
    public final /* synthetic */ String f6953a;

    /* renamed from: b */
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
