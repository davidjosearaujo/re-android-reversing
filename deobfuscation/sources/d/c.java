package d;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import d.a;
import r5.h;

/* loaded from: classes.dex */
public final class c extends a<String, Boolean> {
    @Override // d.a
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        h.f(componentActivity, "context");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{(String) obj});
        h.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return putExtra;
    }

    @Override // d.a
    public final a.C0043a b(ComponentActivity componentActivity, Object obj) {
        h.f(componentActivity, "context");
        if (g1.a.a(componentActivity, (String) obj) == 0) {
            return new a.C0043a(Boolean.TRUE);
        }
        return null;
    }

    @Override // d.a
    public final Object c(Intent intent, int i7) {
        boolean z6;
        if (intent == null || i7 != -1) {
            return Boolean.FALSE;
        }
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        boolean z7 = false;
        if (intArrayExtra != null) {
            int length = intArrayExtra.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    z6 = false;
                    break;
                }
                if (intArrayExtra[i8] == 0) {
                    z6 = true;
                    break;
                }
                i8++;
            }
            if (z6) {
                z7 = true;
            }
        }
        return Boolean.valueOf(z7);
    }
}
