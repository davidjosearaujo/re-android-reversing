package a1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.s0;
@SuppressLint({"LogConditional"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {
    public static String a(Context context, int i7) {
        if (i7 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i7);
        } catch (Exception unused) {
            return s0.g("?", i7);
        }
    }

    public static String b(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }
}
