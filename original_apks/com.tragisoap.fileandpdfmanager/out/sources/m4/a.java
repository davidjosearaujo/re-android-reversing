package m4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f5090b;

    /* renamed from: a  reason: collision with root package name */
    public final Object f5091a = new Object();

    /* renamed from: m4.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class C0079a implements Handler.Callback {
        public C0079a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a aVar = a.this;
            b bVar = (b) message.obj;
            synchronized (aVar.f5091a) {
                if (bVar == null || bVar == null) {
                    bVar.getClass();
                    throw null;
                }
            }
            return true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
    }

    public a() {
        new Handler(Looper.getMainLooper(), new C0079a());
    }

    public static a a() {
        if (f5090b == null) {
            f5090b = new a();
        }
        return f5090b;
    }
}
