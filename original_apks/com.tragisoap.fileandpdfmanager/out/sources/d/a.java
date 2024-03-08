package d;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import java.io.Serializable;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a<I, O> {

    /* renamed from: d.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0043a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f3548a;

        /* JADX WARN: Multi-variable type inference failed */
        public C0043a(Serializable serializable) {
            this.f3548a = serializable;
        }
    }

    public abstract Intent a(ComponentActivity componentActivity, Object obj);

    public C0043a b(ComponentActivity componentActivity, Object obj) {
        h.f(componentActivity, "context");
        return null;
    }

    public abstract Object c(Intent intent, int i7);
}
