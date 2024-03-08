package t2;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f6037a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final C0107b f6038b = new C0107b();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final ReentrantLock f6039a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        public int f6040b;
    }

    /* renamed from: t2.b$b  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0107b {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayDeque f6041a = new ArrayDeque();
    }

    public final void a(String str) {
        a aVar;
        synchronized (this) {
            Object obj = this.f6037a.get(str);
            q2.a.i(obj);
            aVar = (a) obj;
            int i7 = aVar.f6040b;
            if (i7 >= 1) {
                int i8 = i7 - 1;
                aVar.f6040b = i8;
                if (i8 == 0) {
                    a aVar2 = (a) this.f6037a.remove(str);
                    if (aVar2.equals(aVar)) {
                        C0107b bVar = this.f6038b;
                        synchronized (bVar.f6041a) {
                            if (bVar.f6041a.size() < 10) {
                                bVar.f6041a.offer(aVar2);
                            }
                        }
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVar2 + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f6040b);
            }
        }
        aVar.f6039a.unlock();
    }
}
