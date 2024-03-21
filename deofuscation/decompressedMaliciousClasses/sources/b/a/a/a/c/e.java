package b.a.a.a.c;

import a.a.a.a.g;
import a.a.a.a.m;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.e0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class e extends g {
    private static short[] $ = {3390, 3356, 3347, 3347, 3346, 3337, 3421, 3353, 3348, 3342, 3341, 3345, 3356, 3332, 3421, 3347, 3336, 3345, 3345, 3421, 3353, 3348, 3356, 3345, 3346, 3354};
    private Dialog b0 = null;
    private DialogInterface.OnCancelListener c0 = null;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static e W0(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        e eVar = new e();
        e0.e(dialog, $(0, 26, 3453));
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        eVar.b0 = dialog2;
        if (onCancelListener != null) {
            eVar.c0 = onCancelListener;
        }
        return eVar;
    }

    @Override // a.a.a.a.g
    public Dialog S0(Bundle bundle) {
        if (this.b0 == null) {
            T0(false);
        }
        return this.b0;
    }

    @Override // a.a.a.a.g
    public void V0(m mVar, String str) {
        super.V0(mVar, str);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.c0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
