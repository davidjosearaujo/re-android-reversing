package a.a.a.e;

import android.annotation.TargetApi;
import android.graphics.Paint;
import android.view.View;
@TargetApi(11)
/* loaded from: /home/remnux/decompressedMalicious.dex */
class h {
    public static int a(View view) {
        return view.getLayerType();
    }

    public static void b(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void c(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }
}
