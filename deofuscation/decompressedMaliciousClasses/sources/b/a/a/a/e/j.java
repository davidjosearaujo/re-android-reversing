package b.a.a.a.e;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.e0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class j<R extends com.google.android.gms.common.api.j, A extends a.c> extends l<R> {
    private static short[] $ = {7120, 7160, 7160, 7152, 7163, 7154, 7126, 7143, 7166, 7124, 7163, 7166, 7154, 7161, 7139, 7095, 7162, 7138, 7140, 7139, 7095, 7161, 7160, 7139, 7095, 7157, 7154, 7095, 7161, 7138, 7163, 7163, 4848, 4823, 4831, 4826, 4819, 4818, 4758, 4804, 4819, 4805, 4803, 4826, 4802, 4758, 4827, 4803, 4805, 4802, 4758, 4824, 4825, 4802, 4758, 4820, 4819, 4758, 4805, 4803, 4821, 4821, 4819, 4805, 4805};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(a<?> aVar, e eVar) {
        super(eVar);
        e0.e(eVar, $(0, 32, 7063));
        aVar.c();
    }

    private final void n(RemoteException remoteException) {
        o(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    protected abstract void l(A a2);

    public final void m(A a2) {
        try {
            l(a2);
        } catch (DeadObjectException e) {
            n(e);
            throw e;
        } catch (RemoteException e2) {
            n(e2);
        }
    }

    public final void o(Status status) {
        e0.f(!status.f(), $(32, 65, 4790));
        e(g(status));
    }
}
