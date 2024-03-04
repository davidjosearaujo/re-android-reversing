package c0;

import com.google.android.material.textfield.TextInputLayout;
import linc.com.amplituda.callback.AmplitudaErrorListener;
import linc.com.amplituda.exceptions.AmplitudaException;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements i, TextInputLayout.e, AmplitudaErrorListener {

    /* renamed from: a */
    public final /* synthetic */ int f2469a;

    public /* synthetic */ e(int i7) {
        this.f2469a = i7;
    }

    @Override // c0.i
    public final double b(double d7) {
        switch (this.f2469a) {
            case 0:
                double d8 = d7 < 0.0d ? -d7 : d7;
                return Math.copySign(d8 >= 0.0031308049535603718d ? (Math.pow(d8, 0.4166666666666667d) - 0.05213270142180095d) / 0.9478672985781991d : d8 / 0.07739938080495357d, d7);
            default:
                return d7;
        }
    }

    @Override // linc.com.amplituda.callback.AmplitudaErrorListener
    public final void onError(AmplitudaException amplitudaException) {
        r5.h.f(amplitudaException, "exception");
        amplitudaException.printStackTrace();
    }
}
