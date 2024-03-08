package m1;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f5072a = "fonts-androidx";

    /* renamed from: b  reason: collision with root package name */
    public int f5073b = 10;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends Thread {

        /* renamed from: f  reason: collision with root package name */
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
