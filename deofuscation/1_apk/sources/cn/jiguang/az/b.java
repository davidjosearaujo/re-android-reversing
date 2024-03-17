package cn.jiguang.az;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import com.facebook.imageutils.JfifUtil;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static Integer a;

    public static int a() {
        Integer num = a;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(Math.abs(new SecureRandom().nextInt()));
        a = valueOf;
        return valueOf.intValue();
    }

    public static String a(Context context) {
        long f = cn.jiguang.d.a.f(context);
        return f > 0 ? cn.jiguang.bf.d.a(f) : cn.jiguang.bf.d.a(a());
    }

    public static String a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.getShort()];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(int i, byte b, long j, String str) {
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(20480);
        bVar.b(i);
        bVar.a((int) b);
        bVar.b(j);
        bVar.a(str);
        return bVar.b();
    }

    public static byte[] a(long j, int i, long j2, short s, int i2) {
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(20480);
        bVar.b(0);
        bVar.a(6);
        bVar.a(2);
        bVar.b(j);
        bVar.a(i);
        bVar.b(j2);
        bVar.a(s);
        bVar.a(i2);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, long j2, String str, String str2, String str3, long j3, byte b, int i, String str4, String str5, String str6, String str7, int i2) {
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(20480);
        bVar.b(0);
        bVar.a(24);
        bVar.a(1);
        bVar.b(j);
        bVar.a(0L);
        bVar.b(j2);
        bVar.a(97);
        bVar.a(0);
        bVar.b(0);
        bVar.a(str);
        bVar.a(str3);
        bVar.a(str2);
        bVar.a(0);
        bVar.a(j3);
        bVar.a((int) b);
        bVar.a(i);
        bVar.a(str4);
        bVar.a(str5);
        bVar.a(str6);
        bVar.a(str7);
        bVar.a(i2);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, String str, String str2, String str3, String str4, long j2, String str5) {
        int a2 = a();
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(20480);
        bVar.b(0);
        bVar.a(24);
        bVar.a(0);
        bVar.b(j);
        bVar.a(a2);
        bVar.b(0L);
        bVar.a(str);
        bVar.a(str2);
        bVar.a(str3);
        bVar.a(0);
        bVar.a(str4);
        bVar.a(j2);
        bVar.a(str5);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j, String str, long[] jArr) {
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(20480);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            if (jArr != null) {
                jSONArray.put(j);
                for (long j2 : jArr) {
                    jSONArray.put(j2);
                }
            }
            jSONObject.put("uids", jSONArray);
            cn.jiguang.ar.c.c("CorePackage", "attach uids:" + jSONArray.toString());
            bVar.a(jSONObject.toString());
            return bVar.b();
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("CorePackage", "packageAttachInfo:" + th);
            return null;
        }
    }

    public static byte[] a(Context context, int i, int i2, long j, byte[] bArr, long j2) {
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(20480);
        bVar.b(0);
        bVar.a(i2);
        bVar.a(i);
        bVar.b(j);
        bVar.a(JConstants.tcpSessionId);
        cn.jiguang.ar.c.c("CorePackage", "packageSendData uid:" + j2);
        if (j2 == 0) {
            j2 = cn.jiguang.d.a.f(context);
            cn.jiguang.ar.c.c("CorePackage", "use mine uid:" + j2);
        }
        bVar.b(j2);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return a(context, bVar.b());
    }

    public static byte[] a(Context context, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length - 24;
        byte[] bArr2 = new byte[24];
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, 24);
        System.arraycopy(bArr, 24, bArr3, 0, length);
        String a2 = a(context);
        try {
            byte b = JConstants.tcpAlgorithm;
            cn.jiguang.ar.c.c("CorePackage", "encryptBuf algorithm=" + ((int) b) + ", key=" + a2);
            byte[] a3 = b == 2 ? new cn.jiguang.bf.c().a(bArr3, a2) : cn.jiguang.bf.d.a(bArr3, a2, a2.substring(0, 16), true);
            int length2 = a3.length + 24;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr4, 0, 24);
            System.arraycopy(a3, 0, bArr4, 24, a3.length);
            bArr4[0] = (byte) ((length2 >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
            bArr4[1] = (byte) (length2 & JfifUtil.MARKER_FIRST_BYTE);
            bArr4[0] = (byte) (bArr4[0] | 128);
            bArr4[4] = b;
            return bArr4;
        } catch (Exception e) {
            cn.jiguang.ar.c.g("CorePackage", "e:" + e);
            cn.jiguang.ar.c.h("CorePackage", "encrpt data failed");
            return null;
        }
    }

    public static byte[] a(String str, long[] jArr) {
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(20480);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            if (jArr != null) {
                for (long j : jArr) {
                    jSONArray.put(j);
                }
            }
            jSONObject.put("uids", jSONArray);
            bVar.a(jSONObject.toString());
            return bVar.b();
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("CorePackage", "packageDetachInfo:" + th);
            return null;
        }
    }

    public static byte[] a(short s, short s2, String str) {
        cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(20480);
        bVar.a((int) s);
        bVar.a((int) s2);
        bVar.a(str);
        return bVar.b();
    }
}
