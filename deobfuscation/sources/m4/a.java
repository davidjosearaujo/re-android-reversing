package m4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b */
    public static a f5090b;

    /* renamed from: a */
    public final Object f5091a = new Object();

    /* renamed from: m4.a$a */
    /* loaded from: classes.dex */
    public class C0079a implements Handler.Callback {
        public C0079a() {
            a.this = r1;
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

    /* loaded from: classes.dex */
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
