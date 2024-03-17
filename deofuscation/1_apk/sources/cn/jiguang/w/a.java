package cn.jiguang.w;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.n.d;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a implements IInterface {
    private IBinder a;
    private String b = d.g("axDZqud6H+CDQBXA/yBXOryhAsxzPh1PgN4N991nACfTSsXdCfZsE70k+cjPDPVB6dhHsO0zfFF8mVkwxeVKdQ==");

    public a(IBinder iBinder) {
        this.a = iBinder;
    }

    public String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken(this.b);
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } catch (Exception e) {
                cn.jiguang.ak.a.d("HuaweiAdvertisingInterface", "getIds error: " + e.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
