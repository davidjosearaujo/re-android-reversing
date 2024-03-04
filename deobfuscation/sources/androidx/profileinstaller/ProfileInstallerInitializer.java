package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements i2.b<c> {

    /* loaded from: classes.dex */
    public static class a {
        public static void a(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: f2.d
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j7) {
                    runnable.run();
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    @Override // i2.b
    public final List<Class<? extends i2.b<?>>> a() {
        return Collections.emptyList();
    }

    @Override // i2.b
    public final c b(Context context) {
        a.a(new f2.c(this, 0, context.getApplicationContext()));
        return new c();
    }
}
