package com.hunantv.mpdt.chesslogin;

import android.util.Base64;
import com.alipay.sdk.app.statistic.b;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.json.JsonInterface;
import j.l.b.c.a;
import j.l.b.c.d;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChessLoginManager {
    private static final int a = 16;
    private static final String b = "16-Bytes--String";
    public static String c;
    public static String d;
    public static boolean e;
    public static int f;
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private static final /* synthetic */ c.b j = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ChessUserInfo implements JsonInterface {
        public String icon;
        public String name;
        public String ticket;
        public String uuid;
    }

    static {
        a();
        f = -1;
    }

    private static /* synthetic */ void a() {
        e eVar = new e("ChessLoginManager.java", ChessLoginManager.class);
        g = eVar.H("method-execution", eVar.E("9", "encrypt", "com.hunantv.mpdt.chesslogin.ChessLoginManager", "java.lang.String:java.lang.String", "content:secureKey", "", "java.lang.String"), 42);
        h = eVar.H("method-execution", eVar.E("a", "getAESKey", "com.hunantv.mpdt.chesslogin.ChessLoginManager", "java.lang.String", SDKConstants.PARAM_KEY, "java.io.UnsupportedEncodingException", "[B"), 70);
        i = eVar.H("method-execution", eVar.E("9", "decrypt", "com.hunantv.mpdt.chesslogin.ChessLoginManager", "java.lang.String:java.lang.String", "content:secureKey", "", "java.lang.String"), 82);
        j = eVar.H("method-execution", eVar.E("9", b.n, "com.hunantv.mpdt.chesslogin.ChessLoginManager", "java.lang.String:java.lang.String", "timestamp:sign", "", "boolean"), 117);
    }

    @WithTryCatchRuntime
    public static boolean auth(String str, String str2) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{str, str2, e.x(j, (Object) null, (Object) null, str, str2)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)));
    }

    public static final /* synthetic */ boolean b(String str, String str2, c cVar) {
        String encrypt = encrypt("appKey=" + c + "&package=" + d + "&timestamp=" + str, d);
        return encrypt != null && encrypt.equals(str2);
    }

    public static final /* synthetic */ String c(String str, String str2, c cVar) {
        if (str == null) {
            return null;
        }
        byte[] decode = Base64.decode(str, 2);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(getAESKey(str2), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(b.getBytes()));
            return new String(cipher.doFinal(decode), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static final /* synthetic */ String d(String str, String str2, c cVar) {
        if (str == null) {
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(getAESKey(str2), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(b.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @WithTryCatchRuntime
    public static String decrypt(String str, String str2) {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.c.c(new Object[]{str, str2, e.x(i, (Object) null, (Object) null, str, str2)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public static final /* synthetic */ byte[] e(String str, c cVar) {
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        return bArr;
    }

    @WithTryCatchRuntime
    public static String encrypt(String str, String str2) {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a(new Object[]{str, str2, e.x(g, (Object) null, (Object) null, str, str2)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    @WithTryCatchRuntime
    private static byte[] getAESKey(String str) throws UnsupportedEncodingException {
        return (byte[]) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.c.b(new Object[]{str, e.w(h, (Object) null, (Object) null, str)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }
}
