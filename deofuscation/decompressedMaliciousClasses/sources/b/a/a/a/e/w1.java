package b.a.a.a.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class w1 implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f185a;

    /* renamed from: b  reason: collision with root package name */
    private final String f186b;

    /* JADX INFO: Access modifiers changed from: protected */
    public w1(IBinder iBinder, String str) {
        this.f185a = iBinder;
        this.f186b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f186b);
        return obtain;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f185a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel b(int i, Parcel parcel) {
        try {
            parcel = Parcel.obtain();
            this.f185a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f185a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
