package b.a.a.a.e;

import android.os.DeadObjectException;
import android.os.RemoteException;
import b.a.a.a.g.d;
import com.google.android.gms.common.api.Status;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class b extends a {

    /* renamed from: a  reason: collision with root package name */
    protected final d<Void> f137a;

    public b(int i, d<Void> dVar) {
        super(i);
        this.f137a = dVar;
    }

    @Override // b.a.a.a.e.a
    public final void c(v<?> vVar) {
        try {
            f(vVar);
        } catch (DeadObjectException e) {
            e(a.a(e));
            throw e;
        } catch (RemoteException e2) {
            e(a.a(e2));
        }
    }

    @Override // b.a.a.a.e.a
    public void e(Status status) {
        this.f137a.d(new com.google.android.gms.common.api.b(status));
    }

    protected abstract void f(v<?> vVar);
}
