package k;

import androidx.activity.h;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends androidx.activity.result.c {

    /* renamed from: f  reason: collision with root package name */
    public final Object f4609f = new Object();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f4610a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            StringBuilder d7 = h.d("arch_disk_io_");
            d7.append(this.f4610a.getAndIncrement());
            thread.setName(d7.toString());
            return thread;
        }
    }

    public c() {
        Executors.newFixedThreadPool(4, new a());
    }
}
