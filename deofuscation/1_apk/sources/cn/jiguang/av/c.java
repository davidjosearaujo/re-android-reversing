package cn.jiguang.av;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.internal.JConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.fastjson.JSONStreamContext;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r27, cn.jiguang.ba.a r28) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.av.c.a(android.content.Context, cn.jiguang.ba.a):int");
    }

    public static void a(Context context) {
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.J().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.K().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.d(false).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.d(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.O().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.L().a((cn.jiguang.g.a<Boolean>) null), cn.jiguang.g.a.M().a((cn.jiguang.g.a<Long>) null), cn.jiguang.g.a.b(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.b(false).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.c(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.c(false).a((cn.jiguang.g.a<String>) null));
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.c().a((cn.jiguang.g.a<Long>) null), cn.jiguang.g.a.d().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.e().a((cn.jiguang.g.a<String>) null));
    }

    public static void a(Context context, int i) {
        a(context, i, true);
    }

    public static void a(Context context, int i, boolean z) {
        String str;
        StringBuilder sb;
        String str2;
        String str3;
        if (z) {
            String a = cn.jiguang.bc.c.a(i);
            cn.jiguang.ar.c.j("ConnectingHelper", "Register Failed with server error - code:" + i);
            if (!TextUtils.isEmpty(a)) {
                cn.jiguang.ar.c.h("ConnectingHelper", "Local error description: " + a);
            }
            cn.jiguang.ax.b.a().a(context, 0, i, a);
        }
        String e = cn.jiguang.d.a.e(context);
        if (i != 11) {
            if (i == 1012) {
                a(context);
                return;
            }
            if (i != 10001) {
                switch (i) {
                    case JSONStreamContext.ArrayValue /* 1005 */:
                        sb = new StringBuilder();
                        sb.append("包名: ");
                        sb.append(context.getPackageName());
                        sb.append(" 与 AppKey:");
                        sb.append(e);
                        str2 = "不匹配";
                        sb.append(str2);
                        str = sb.toString();
                        break;
                    case 1006:
                        sb = new StringBuilder();
                        sb.append("包名: ");
                        sb.append(context.getPackageName());
                        str2 = " 不存在";
                        sb.append(str2);
                        str = sb.toString();
                        break;
                    case 1007:
                        str3 = "IMEI is duplicated reported by server. Give up now. ";
                        cn.jiguang.ar.c.e("ConnectingHelper", str3);
                        return;
                    case 1008:
                        sb = new StringBuilder();
                        sb.append(" AppKey:");
                        sb.append(e);
                        str2 = " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致";
                        sb.append(str2);
                        str = sb.toString();
                        break;
                    case 1009:
                        sb = new StringBuilder();
                        sb.append(" AppKey:");
                        sb.append(e);
                        str2 = " 非android AppKey";
                        sb.append(str2);
                        str = sb.toString();
                        break;
                    default:
                        str3 = "Unhandled server response error code - " + i;
                        cn.jiguang.ar.c.e("ConnectingHelper", str3);
                        return;
                }
            } else {
                str = " 未在manifest中配置AppKey";
            }
            cn.jiguang.f.a.a(context, str, -1);
        }
    }

    private static void a(final Context context, final long j) {
        if (j > 0) {
            cn.jiguang.at.b.d(new cn.jiguang.be.b() { // from class: cn.jiguang.av.c.1
                /* JADX WARN: Removed duplicated region for block: B:25:0x011c A[Catch: all -> 0x0147, TRY_LEAVE, TryCatch #0 {all -> 0x0147, blocks: (B:12:0x0070, B:15:0x008a, B:16:0x0096, B:25:0x011c, B:17:0x009d, B:19:0x00d9, B:21:0x00e5, B:22:0x00f7), top: B:28:0x0070 }] */
                /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
                @Override // cn.jiguang.be.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a() {
                    /*
                        Method dump skipped, instructions count: 328
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.av.c.AnonymousClass1.a():void");
                }
            }, new int[0]);
        }
    }

    private static synchronized byte[] a(String str, int i, byte[] bArr, boolean z, int i2) {
        byte[] b;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str) || str.length() != 2 || bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("flag or body length error");
            }
            cn.jiguang.bc.b bVar = new cn.jiguang.bc.b(300);
            bVar.b(0);
            bVar.a(str.getBytes());
            bVar.a(i);
            bVar.b(i2);
            bVar.a(bArr);
            bVar.b(bVar.a(), 0);
            bVar.a((int) ((byte) ((z ? (byte) 1 : (byte) 0) | 16)), 4);
            b = bVar.b();
        }
        return b;
    }

    public static byte[] a(String str, String str2) {
        boolean z;
        byte[] a;
        byte[] i = cn.jiguang.f.g.i(str2);
        try {
            a = cn.jiguang.f.i.a(i);
        } catch (IOException unused) {
        }
        if (a.length < i.length) {
            i = a;
            z = true;
            int length = i.length;
            int a2 = cn.jiguang.bf.d.a();
            String a3 = cn.jiguang.bf.d.a(a2);
            return a(str, a2, cn.jiguang.bf.d.a(i, a3, a3.substring(0, 16), true), z, length);
        }
        z = false;
        int length2 = i.length;
        int a22 = cn.jiguang.bf.d.a();
        String a32 = cn.jiguang.bf.d.a(a22);
        return a(str, a22, cn.jiguang.bf.d.a(i, a32, a32.substring(0, 16), true), z, length2);
    }

    public static byte[] a(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        datagramSocket.setSoTimeout(6000);
        datagramSocket.send(datagramPacket);
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024);
        cn.jiguang.ar.c.d("ConnectingHelper", "udp Receiving...");
        datagramSocket.receive(datagramPacket2);
        int length = datagramPacket2.getLength();
        byte[] bArr = new byte[length];
        System.arraycopy(datagramPacket2.getData(), 0, bArr, 0, length);
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new cn.jiguang.ax.f(4, "response is empty!");
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.getShort();
            wrap.getShort();
            int i = wrap.getInt();
            int i2 = i >>> 24;
            long j = i & 16777215;
            wrap.getShort();
            int remaining = wrap.remaining();
            byte[] bArr2 = new byte[remaining];
            wrap.get(bArr2, 0, remaining);
            if (j != 0) {
                String a = cn.jiguang.bf.d.a(j);
                try {
                    bArr2 = cn.jiguang.bf.d.a(bArr2, a, a.substring(0, 16), false);
                    if (bArr2 == null) {
                        throw new cn.jiguang.ax.f(5, "decrypt response error");
                    }
                } catch (Exception unused) {
                    throw new cn.jiguang.ax.f(5, "decrypt response error");
                }
            }
            if ((i2 & 1) == 1) {
                try {
                    return cn.jiguang.f.i.b(bArr2);
                } catch (IOException unused2) {
                    return bArr2;
                }
            }
            return bArr2;
        } catch (Throwable th) {
            throw new cn.jiguang.ax.f(4, "parse head error:" + th.getMessage());
        }
    }

    public static int b(Context context, cn.jiguang.ba.a aVar) {
        Object obj;
        Object obj2;
        String d = d(context);
        String str = cn.jiguang.bc.a.a(context).a;
        String e = e(context);
        String f = f(context);
        long b = cn.jiguang.ax.b.a().b();
        String d2 = cn.jiguang.d.a.d(context);
        cn.jiguang.ar.c.c("ConnectingHelper", "Register with: key:" + d + ", apkVersion:" + str + ", clientInfo:" + e + ", extKey:" + f + ",reg business:" + b + " accountId:" + d2);
        byte[] a = cn.jiguang.az.b.a(context, cn.jiguang.az.b.a(c(context), d, str, e, f, b, d2));
        if (a == null) {
            cn.jiguang.ar.c.h("ConnectingHelper", "Register failed - encrytor reg info failed");
            return -1;
        } else if (aVar.a(a) != 0) {
            cn.jiguang.ar.c.h("ConnectingHelper", "Register failed - send reg info failed");
            return -1;
        } else {
            try {
                Pair<cn.jiguang.az.c, ByteBuffer> a2 = cn.jiguang.az.a.a(context, aVar.a(com.alipay.sdk.data.a.O).array(), "");
                if (a2 == null || (obj = a2.first) == null || (obj2 = a2.second) == null || ((cn.jiguang.az.c) obj).c != 0) {
                    cn.jiguang.ar.c.h("ConnectingHelper", "Register failed - can't parse a Register Response");
                    return -1;
                }
                cn.jiguang.az.e eVar = new cn.jiguang.az.e((cn.jiguang.az.c) obj, (ByteBuffer) obj2);
                cn.jiguang.ar.c.c("ConnectingHelper", "register response:" + eVar);
                int i = eVar.a;
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.B().a((cn.jiguang.g.a<Integer>) Integer.valueOf(i)));
                if (i == 0) {
                    long j = eVar.b;
                    String str2 = eVar.c;
                    String str3 = eVar.d;
                    String str4 = eVar.e;
                    cn.jiguang.ar.c.f("ConnectingHelper", "Register succeed - juid:" + j + ", registrationId:" + str3 + ", deviceId:" + str4);
                    if (cn.jiguang.f.g.a(str3) || 0 == j) {
                        cn.jiguang.ar.c.j("ConnectingHelper", "Unexpected: registrationId/juid should not be empty. ");
                        return -1;
                    }
                    cn.jiguang.b.a.d(context);
                    cn.jiguang.at.b.a(context, str4);
                    cn.jiguang.at.b.a(context, j, str2, str3);
                }
                return i;
            } catch (cn.jiguang.ax.f e2) {
                cn.jiguang.ar.c.h("ConnectingHelper", "Register failed - recv msg failed with error:" + e2);
                return -1;
            }
        }
    }

    private static String b(String str, String str2) {
        return !cn.jiguang.f.g.a(str) ? str : str2;
    }

    public static void b(Context context) {
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.c(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.c(false).a((cn.jiguang.g.a<String>) null));
    }

    public static synchronized long c(Context context) {
        long j;
        synchronized (c.class) {
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.H())).longValue();
            if (longValue == -1) {
                longValue = Math.abs(new Random().nextInt(10000));
            }
            j = (longValue + (longValue % 2 == 0 ? 1L : 2L)) % 10000;
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.H().a((cn.jiguang.g.a<Long>) Long.valueOf(j)));
        }
        return j;
    }

    private static String d(Context context) {
        String a = cn.jiguang.bc.d.a(context);
        String str = cn.jiguang.bc.a.a(context).o;
        return b(a, " ") + Consts.SEPARATOR + b(str, " ") + Consts.SEPARATOR + context.getPackageName() + Consts.SEPARATOR + cn.jiguang.d.a.e(context);
    }

    private static String e(Context context) {
        String e = cn.jiguang.ax.b.a().e();
        cn.jiguang.ar.c.c("ConnectingHelper", "regVersion:" + e);
        cn.jiguang.bc.a a = cn.jiguang.bc.a.a(context);
        return b(a.b, " ") + Consts.SEPARATOR + b(a.c, " ") + Consts.SEPARATOR + b(a.d, " ") + Consts.SEPARATOR + b(a.e, " ") + Consts.SEPARATOR + b(cn.jiguang.d.a.g(context), " ") + Consts.SEPARATOR + e + Consts.SEPARATOR + a.g + Consts.SEPARATOR + a.h + Consts.SEPARATOR + a.l + Consts.SEPARATOR + a.q + "&" + a.r;
    }

    private static String f(final Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            String str6 = cn.jiguang.bc.a.a(context).j;
            if ("unknown".equalsIgnoreCase(str6)) {
                str6 = " ";
            }
            final String a = cn.jiguang.bf.b.a(context);
            cn.jiguang.be.d.a("FUTURE_TASK", new cn.jiguang.be.b() { // from class: cn.jiguang.av.c.2
                @Override // cn.jiguang.be.b
                public void a() {
                    Bundle bundle = new Bundle();
                    bundle.putString("jg_device_id", a);
                    cn.jiguang.ax.e.a(context, "device_id_map", bundle);
                }
            });
            int i = cn.jiguang.bf.b.a;
            String str7 = cn.jiguang.bc.a.a(context).p;
            String str8 = cn.jiguang.bc.a.a(context).i;
            String g = cn.jiguang.d.a.l(context) ? cn.jiguang.f.a.g(context, "") : "";
            Object a2 = cn.jiguang.ax.e.a(context, "get_all_ids", null);
            if (a2 == null || !(a2 instanceof JSONObject)) {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            } else {
                cn.jiguang.ar.c.c("ConnectingHelper", "parse ids:" + a2.toString());
                str2 = ((JSONObject) a2).optString("udid", "");
                str3 = ((JSONObject) a2).optString("joad", "");
                str4 = ((JSONObject) a2).optString("jvad", "");
                str5 = ((JSONObject) a2).optString("jaad", "");
                str = ((JSONObject) a2).optString("jgad", "");
            }
            return i + Consts.SEPARATOR + b(a, " ") + Consts.SEPARATOR + b(str7, " ") + Consts.SEPARATOR + b(str8, " ") + Consts.SEPARATOR + b(g, " ") + Consts.SEPARATOR + b(str6, " ") + Consts.SEPARATOR + b(str2, " ") + Consts.SEPARATOR + b(str3, " ") + Consts.SEPARATOR + b(str4, " ") + Consts.SEPARATOR + b(str5, " ") + Consts.SEPARATOR + b(str, " ");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String g(Context context) {
        String str = JConstants.testCountry;
        return !TextUtils.isEmpty(str) ? str : cn.jiguang.f.a.n(context);
    }
}
