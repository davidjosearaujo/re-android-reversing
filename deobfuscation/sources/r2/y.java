package r2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a */
    public boolean f5893a;

    /* renamed from: b */
    public final Handler f5894b = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: classes.dex */
    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((v) message.obj).recycle();
                return true;
            }
            return false;
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
