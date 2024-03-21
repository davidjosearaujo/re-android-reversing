package b.a.a.a.e;

import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.AbstractC0005a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.j;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class a0<O extends a.AbstractC0005a> extends s {
    private static short[] $ = {7196, 7220, 7205, 7225, 7230, 7221, 7281, 7224, 7202, 7281, 7231, 7230, 7205, 7281, 7202, 7204, 7201, 7201, 7230, 7203, 7205, 7220, 7221, 7281, 7219, 7208, 7281, 7218, 7230, 7231, 7231, 7220, 7218, 7205, 7224, 7230, 7231, 7229, 7220, 7202, 7202, 7281, 7218, 7229, 7224, 7220, 7231, 7205, 7295, 7281, 7184, 7169, 7192, 7202, 7281, 7202, 7204, 7201, 7201, 7230, 7203, 7205, 7224, 7231, 7222, 7281, 7218, 7230, 7231, 7231, 7220, 7218, 7205, 7224, 7230, 7231, 7229, 7220, 7202, 7202, 7281, 7218, 7229, 7224, 7220, 7231, 7205, 7281, 7228, 7204, 7202, 7205, 7281, 7231, 7230, 7205, 7281, 7218, 7216, 7229, 7229, 7281, 7205, 7225, 7224, 7202, 7281, 7228, 7220, 7205, 7225, 7230, 7221, 7295};

    /* renamed from: a  reason: collision with root package name */
    private final d<O> f134a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public a0(d<O> dVar) {
        super($(0, 114, 7249));
        this.f134a = dVar;
    }

    @Override // com.google.android.gms.common.api.e
    public final Looper a() {
        return this.f134a.b();
    }

    @Override // com.google.android.gms.common.api.e
    public final <A extends a.c, R extends j, T extends j<R, A>> T b(T t) {
        this.f134a.e(t);
        return t;
    }
}
