package d;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import r5.h;

/* loaded from: classes.dex */
public final class d extends a<Intent, androidx.activity.result.a> {
    @Override // d.a
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        Intent intent = (Intent) obj;
        h.f(componentActivity, "context");
        return intent;
    }

    @Override // d.a
    public final Object c(Intent intent, int i7) {
        return new androidx.activity.result.a(intent, i7);
    }
}
