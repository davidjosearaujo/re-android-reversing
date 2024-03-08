package r2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5893a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f5894b = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((v) message.obj).recycle();
            return true;
        }
    }

    public final synchronized void a(v<?> vVar, boolean z6) {
        if (!this.f5893a && !z6) {
            this.f5893a = true;
            vVar.recycle();
            this.f5893a = false;
        }
        this.f5894b.obtainMessage(1, vVar).sendToTarget();
    }
}
