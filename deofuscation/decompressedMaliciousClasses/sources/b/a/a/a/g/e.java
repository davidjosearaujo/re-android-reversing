package b.a.a.a.g;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f203a = new a();

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static final class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f204a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f204a.post(runnable);
        }
    }
}
