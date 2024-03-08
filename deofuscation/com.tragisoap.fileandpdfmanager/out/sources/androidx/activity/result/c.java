package androidx.activity.result;

import android.graphics.Path;
import android.graphics.Typeface;
import android.view.View;
import com.google.android.material.carousel.b;
import java.util.HashMap;
import l0.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class c {
    public /* synthetic */ c() {
    }

    public static float e(float f7, float f8, float f9) {
        return 1.0f - ((f7 - f9) / (f8 - f9));
    }

    public abstract Path f(float f7, float f8, float f9, float f10);

    public abstract View g(int i7);

    public abstract b j(u3.b bVar, View view);

    public abstract void l(int i7);

    public abstract void m(Typeface typeface, boolean z6);

    public abstract boolean n();

    public abstract boolean o(u3.b bVar, int i7);

    public /* synthetic */ c(a aVar) {
        new HashMap();
    }
}
