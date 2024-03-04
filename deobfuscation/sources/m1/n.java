package m1;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class n implements ThreadFactory {

    /* renamed from: a */
    public String f5072a = "fonts-androidx";

    /* renamed from: b */
    public int f5073b = 10;

    /* loaded from: classes.dex */
    public static class a extends Thread {

        /* renamed from: f */
        public final int f5074f;

        public a(Runnable runnable, String str, int i7) {
            super(runnable, str);
            this.f5074f = i7;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.f5074f);
            super.run();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new a(runnable, this.f5072a, this.f5073b);
    }
}
