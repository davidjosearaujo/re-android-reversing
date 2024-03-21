package a.a.a.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class g extends h implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static short[] $ = {9098, 9127, 9135, 9122, 9121, 9129, 9096, 9148, 9135, 9129, 9123, 9131, 9120, 9146, 9198, 9133, 9135, 9120, 9198, 9120, 9121, 9146, 9198, 9132, 9131, 9198, 9135, 9146, 9146, 9135, 9133, 9126, 9131, 9130, 9198, 9146, 9121, 9198, 9135, 9198, 9133, 9121, 9120, 9146, 9135, 9127, 9120, 9131, 9148, 9198, 9144, 9127, 9131, 9145, 8384, 8399, 8389, 8403, 8398, 8392, 8389, 8347, 8402, 8384, 8407, 8388, 8389, 8421, 8392, 8384, 8397, 8398, 8390, 8434, 8405, 8384, 8405, 8388, 8688, 8703, 8693, 8675, 8702, 8696, 8693, 8619, 8674, 8677, 8680, 8701, 8692, 4424, 4423, 4429, 4443, 4422, 4416, 4429, 4371, 4445, 4417, 4428, 4420, 4428, 7482, 7477, 7487, 7465, 7476, 7474, 7487, 7521, 7480, 7482, 7477, 7480, 7486, 7479, 7482, 7481, 7479, 7486, 8782, 8769, 8779, 8797, 8768, 8774, 8779, 8725, 8796, 8775, 8768, 8792, 8796, 8811, 8774, 8782, 8771, 8768, 8776, 3920, 3935, 3925, 3907, 3934, 3928, 3925, 3851, 3923, 3920, 3922, 3930, 3938, 3909, 3920, 3922, 3930, 3960, 3925, 10908, 10899, 10905, 10895, 10898, 10900, 10905, 10951, 10894, 10908, 10891, 10904, 10905, 10937, 10900, 10908, 10897, 10898, 10906, 10926, 10889, 10908, 10889, 10904, 10436, 10443, 10433, 10455, 10442, 10444, 10433, 10399, 10454, 10449, 10460, 10441, 10432, 10349, 10338, 10344, 10366, 10339, 10341, 10344, 10294, 10360, 10340, 10345, 10337, 10345, 11715, 11724, 11718, 11728, 11725, 11723, 11718, 11672, 11713, 11715, 11724, 11713, 11719, 11726, 11715, 11712, 11726, 11719, 3990, 3993, 3987, 3973, 3992, 3998, 3987, 4045, 3972, 3999, 3992, 3968, 3972, 4019, 3998, 3990, 3995, 3992, 3984, 2516, 2523, 2513, 2503, 2522, 2524, 2513, 2447, 2519, 2516, 2518, 2526, 2534, 2497, 2516, 2518, 2526, 2556, 2513, 7875, 7886, 7894, 7872, 7898, 7899, 7920, 7878, 7873, 7881, 7875, 7886, 7899, 7882, 7901};
    int S = 0;
    int T = 0;
    boolean U = true;
    boolean V = true;
    int W = -1;
    Dialog X;
    boolean Y;
    boolean Z;
    boolean a0;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Override // a.a.a.a.h
    public void I(Bundle bundle) {
        Bundle bundle2;
        super.I(bundle);
        if (this.V) {
            View z = z();
            if (z != null) {
                if (z.getParent() == null) {
                    this.X.setContentView(z);
                } else {
                    throw new IllegalStateException($(0, 54, 9166));
                }
            }
            i f = f();
            if (f != null) {
                this.X.setOwnerActivity(f);
            }
            this.X.setCancelable(this.U);
            this.X.setOnCancelListener(this);
            this.X.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle($(54, 78, 8353))) != null) {
                this.X.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // a.a.a.a.h
    public void L(Context context) {
        super.L(context);
        if (!this.a0) {
            this.Z = false;
        }
    }

    @Override // a.a.a.a.h
    public void O(Bundle bundle) {
        super.O(bundle);
        this.V = this.v == 0;
        if (bundle != null) {
            this.S = bundle.getInt($(78, 91, 8593), 0);
            this.T = bundle.getInt($(91, 104, 4393), 0);
            this.U = bundle.getBoolean($(104, 122, 7515), true);
            this.V = bundle.getBoolean($(122, 141, 8751), this.V);
            this.W = bundle.getInt($(141, 160, 3889), -1);
        }
    }

    void R0(boolean z) {
        if (!this.Z) {
            this.Z = true;
            this.a0 = false;
            Dialog dialog = this.X;
            if (dialog != null) {
                dialog.dismiss();
                this.X = null;
            }
            this.Y = true;
            if (this.W >= 0) {
                o().c(this.W, 1);
                this.W = -1;
                return;
            }
            r a2 = o().a();
            a2.e(this);
            if (z) {
                a2.d();
            } else {
                a2.c();
            }
        }
    }

    public abstract Dialog S0(Bundle bundle);

    public void T0(boolean z) {
        this.V = z;
    }

    @Override // a.a.a.a.h
    public void U() {
        super.U();
        Dialog dialog = this.X;
        if (dialog != null) {
            this.Y = true;
            dialog.dismiss();
            this.X = null;
        }
    }

    public void U0(Dialog dialog, int i) {
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                dialog.getWindow().addFlags(24);
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    @Override // a.a.a.a.h
    public void V() {
        super.V();
        if (!this.a0 && !this.Z) {
            this.Z = true;
        }
    }

    public void V0(m mVar, String str) {
        this.Z = false;
        this.a0 = true;
        r a2 = mVar.a();
        a2.b(this, str);
        a2.c();
    }

    @Override // a.a.a.a.h
    public void h0(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.h0(bundle);
        Dialog dialog = this.X;
        if (!(dialog == null || (onSaveInstanceState = dialog.onSaveInstanceState()) == null)) {
            bundle.putBundle($(160, 184, 11005), onSaveInstanceState);
        }
        int i = this.S;
        if (i != 0) {
            bundle.putInt($(184, 197, 10405), i);
        }
        int i2 = this.T;
        if (i2 != 0) {
            bundle.putInt($(197, 210, 10252), i2);
        }
        boolean z = this.U;
        if (!z) {
            bundle.putBoolean($(210, 228, 11682), z);
        }
        boolean z2 = this.V;
        if (!z2) {
            bundle.putBoolean($(228, 247, 4087), z2);
        }
        int i3 = this.W;
        if (i3 != -1) {
            bundle.putInt($(247, 266, 2485), i3);
        }
    }

    @Override // a.a.a.a.h
    public void i0() {
        super.i0();
        Dialog dialog = this.X;
        if (dialog != null) {
            this.Y = false;
            dialog.show();
        }
    }

    @Override // a.a.a.a.h
    public void j0() {
        super.j0();
        Dialog dialog = this.X;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.Y) {
            R0(true);
        }
    }

    @Override // a.a.a.a.h
    public LayoutInflater p(Bundle bundle) {
        Context h;
        if (!this.V) {
            return super.p(bundle);
        }
        Dialog S0 = S0(bundle);
        this.X = S0;
        String $2 = $(266, 281, 7855);
        if (S0 != null) {
            U0(S0, this.S);
            h = this.X.getContext();
        } else {
            h = this.q.h();
        }
        return (LayoutInflater) h.getSystemService($2);
    }
}
