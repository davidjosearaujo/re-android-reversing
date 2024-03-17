package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAIDLInvoke.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface d extends IInterface {
    void a(b bVar, c cVar) throws RemoteException;

    /* compiled from: IAIDLInvoke.java */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static abstract class a extends Binder implements d {

        /* compiled from: IAIDLInvoke.java */
        /* renamed from: com.huawei.hms.core.aidl.d$a$a */
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class C0042a implements d {
            public static d b;
            private IBinder a;

            public C0042a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.huawei.hms.core.aidl.d
            public void a(b bVar, c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (this.a.transact(2, obtain, null, 1) || a.a() == null) {
                        return;
                    }
                    a.a().a(bVar, cVar);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0042a(iBinder);
        }

        public static d a() {
            return C0042a.b;
        }
    }
}
