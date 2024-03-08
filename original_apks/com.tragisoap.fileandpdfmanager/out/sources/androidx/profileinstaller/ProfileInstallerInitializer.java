package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import f2.d;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ProfileInstallerInitializer implements i2.b<c> {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        public static void a(Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new d(runnable));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
