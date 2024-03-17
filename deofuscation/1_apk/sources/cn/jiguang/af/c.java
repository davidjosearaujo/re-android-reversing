package cn.jiguang.af;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import cn.jiguang.n.d;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface c extends IInterface {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: cn.jiguang.af.c$a$a */
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class C0002a implements c {
            private IBinder a;

            public C0002a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // cn.jiguang.af.c
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(d.g("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0="));
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Throwable th) {
                    try {
                        cn.jiguang.ak.a.d("ZTEOAID", "getOAID obtain exception:" + th.getMessage());
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // cn.jiguang.af.c
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z = false;
                try {
                    obtain.writeInterfaceToken(d.g("Halo+/ex0XYuOCl75w4mzBmlg/ol+vqLiEURlblgA+0="));
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                } finally {
                    try {
                        return z;
                    } finally {
                    }
                }
                return z;
            }
        }
    }

    String a();

    boolean b();
}
