package a.a.a.a;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: /home/remnux/decompressedMalicious.dex */
abstract class e extends d {
    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View b2 = b(view, str, context, attributeSet);
        return (b2 != null || Build.VERSION.SDK_INT < 11) ? b2 : super.onCreateView(view, str, context, attributeSet);
    }
}
