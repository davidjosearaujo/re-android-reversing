package f1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.w;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public class e extends Activity implements n, p1.f {

    /* renamed from: f */
    public o f4075f;

    public e() {
        new o.h();
        this.f4075f = new o(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (getWindow().getDecorView() != null) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
        }
        return l(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (getWindow().getDecorView() != null) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public o k() {
        return this.f4075f;
    }

    public final boolean l(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i7 = w.f1893g;
        w.b.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        o oVar = this.f4075f;
        oVar.getClass();
        oVar.e("markState");
        oVar.h();
        super.onSaveInstanceState(bundle);
    }
}
