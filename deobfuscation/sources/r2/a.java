package r2;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* renamed from: r2.a$a */
    /* loaded from: classes.dex */
    public class RunnableC0101a implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ Runnable f5717f;

        public RunnableC0101a(Runnable runnable) {
            this.f5717f = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            this.f5717f.run();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(new RunnableC0101a(runnable), "glide-active-resources");
    }
}
