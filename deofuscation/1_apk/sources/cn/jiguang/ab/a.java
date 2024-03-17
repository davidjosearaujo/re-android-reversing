package cn.jiguang.ab;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import cn.jiguang.n.d;
import java.security.MessageDigest;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a implements IInterface {
    private IBinder a;
    private String b;
    private String c = d.g("bFWKQsRzI9d+ktdqxw44MA==");
    private String d = d.g("vWw3rdN6/HN94yy83HO8Lw==");
    private String e = d.g("Ha7IUc4OlbRIQFpw3FJeZw==");
    private String f = d.g("qFFOesfckPwVmbfqzGl5oBCLe9WD17E04n+Ic7C9fCw=");

    public a(IBinder iBinder) {
        this.a = iBinder;
    }

    private String a(String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.f);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } catch (Throwable th) {
            try {
                cn.jiguang.ak.a.d("OppoAdvertisingInterface", "getIdByType error: " + th.getMessage());
                obtain2.recycle();
                obtain.recycle();
                return "";
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private String b(Context context) {
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(this.b)) {
            Signature[] signatureArr = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (PackageManager.NameNotFoundException e) {
                cn.jiguang.ak.a.d("OppoAdvertisingInterface", "packageName: " + packageName + " getPackageInfo error: " + e.getMessage());
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        this.b = sb.toString();
                    }
                } catch (Throwable th) {
                    cn.jiguang.ak.a.d("OppoAdvertisingInterface", "package sign error: " + th.getMessage());
                }
            }
        }
        return this.b;
    }

    public String a(Context context) {
        return context == null ? "" : a(context.getPackageName(), b(context), this.c);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }
}
