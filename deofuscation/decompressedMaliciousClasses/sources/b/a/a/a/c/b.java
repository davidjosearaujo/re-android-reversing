package b.a.a.a.c;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.e0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class b extends DialogFragment {
    private static short[] $ = {9889, 9859, 9868, 9868, 9869, 9878, 9922, 9862, 9867, 9873, 9874, 9870, 9859, 9883, 9922, 9868, 9879, 9870, 9870, 9922, 9862, 9867, 9859, 9870, 9869, 9861};

    /* renamed from: a  reason: collision with root package name */
    private Dialog f115a = null;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f116b = null;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static b a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        b bVar = new b();
        e0.e(dialog, $(0, 26, 9954));
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        bVar.f115a = dialog2;
        if (onCancelListener != null) {
            bVar.f116b = onCancelListener;
        }
        return bVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f116b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f115a == null) {
            setShowsDialog(false);
        }
        return this.f115a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
