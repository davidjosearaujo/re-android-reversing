package d;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends a<Intent, a> {
    @Override // d.a
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        Intent intent = (Intent) obj;
        h.f(componentActivity, "context");
        return intent;
    }

    @Override // d.a
    public final Object c(Intent intent, int i7) {
        return new a(intent, i7);
    }
}
