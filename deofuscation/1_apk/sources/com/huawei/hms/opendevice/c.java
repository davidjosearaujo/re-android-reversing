package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SecretUtil.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class c {
    public static final String a = "c";
    public static Map<String, String> b = new HashMap();
    public static final Object c = new Object();

    public static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    public static byte[] a(String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT >= 26) {
            return j.k.c.a.a.h.g.a.f(str, str2, str3, str4, 32, true);
        }
        return j.k.c.a.a.h.g.a.f(str, str2, str3, str4, 32, false);
    }

    public static byte[] b() {
        return a(d(), e(), c(), g());
    }

    public static void c(Context context) {
        synchronized (c) {
            d(context.getApplicationContext());
            if (i()) {
                HMSLog.i(a, "The local secret is already in separate file mode.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(p.c(context.getApplicationContext()));
            sb.append("/shared_prefs/LocalAvengers.xml");
            File file = new File(sb.toString());
            if (file.exists()) {
                j.k.c.a.a.k.d.i(file);
                HMSLog.i(a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] d = j.k.c.a.a.h.g.b.d(32);
            byte[] d2 = j.k.c.a.a.h.g.b.d(32);
            byte[] d3 = j.k.c.a.a.h.g.b.d(32);
            byte[] d4 = j.k.c.a.a.h.g.b.d(32);
            String a2 = a.a(d);
            String a3 = a.a(d2);
            String a4 = a.a(d3);
            String a5 = a.a(d4);
            a(a2, a3, a4, a5, j.k.c.a.a.h.g.e.j(a.a(j.k.c.a.a.h.g.b.d(32)), a(a2, a3, a4, a5)), context);
            HMSLog.i(a, "generate D.");
        }
    }

    public static void d(Context context) {
        if (i()) {
            HMSLog.i(a, "secretKeyCache not empty.");
            return;
        }
        b.clear();
        String c2 = p.c(context);
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        String a2 = s.a(c2 + "/files/math/m");
        String a3 = s.a(c2 + "/files/panda/p");
        String a4 = s.a(c2 + "/files/panda/d");
        String a5 = s.a(c2 + "/files/math/t");
        String a6 = s.a(c2 + "/files/s");
        if (t.a(a2, a3, a4, a5, a6)) {
            b.put("m", a2);
            b.put("p", a3);
            b.put("d", a4);
            b.put("t", a5);
            b.put("s", a6);
        }
    }

    public static synchronized String e(Context context) {
        synchronized (c.class) {
            String b2 = j.k.c.a.a.h.g.e.b(f(), b());
            if (t.a(b2)) {
                HMSLog.i(a, "keyS has been upgraded, no require operate again.");
                return b2;
            }
            String a2 = j.k.c.a.a.h.g.e.a(f(), h());
            if (t.a(a2)) {
                HMSLog.i(a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                a(j.k.c.a.a.h.g.e.j(a2, b()), context);
                return a2;
            }
            String b3 = j.k.c.a.a.h.g.e.b(f(), j.k.c.a.a.h.g.a.f(d(), e(), c(), g(), 32, false));
            if (t.a(b3)) {
                HMSLog.i(a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
                a(j.k.c.a.a.h.g.e.j(b3, b()), context);
                return b3;
            }
            HMSLog.e(a, "all mode unable to decrypt root key.");
            return "";
        }
    }

    public static String f() {
        return a("s");
    }

    public static String g() {
        return a("t");
    }

    public static j.k.c.a.a.h.g.d h() {
        return j.k.c.a.a.h.g.d.e(d(), e(), c(), g());
    }

    public static boolean i() {
        return !TextUtils.isEmpty(f());
    }

    public static String b(Context context) {
        if (!i()) {
            HMSLog.i(a, "work key is empty, execute init.");
            c(context);
        }
        String b2 = j.k.c.a.a.h.g.e.b(f(), b());
        return t.a(b2) ? b2 : e(context);
    }

    public static byte[] a(Context context) {
        byte[] a2 = a.a(context.getString(R.string.push_cat_head));
        byte[] a3 = a.a(context.getString(R.string.push_cat_body));
        return a(a(a(a2, a3), a.a(a())));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] >> 2);
        }
        return bArr;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, Context context) {
        String c2 = p.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(c2);
            sb.append("/files/math/m");
            a("m", str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c2);
            sb2.append("/files/panda/p");
            a("p", str2, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(c2);
            sb3.append("/files/panda/d");
            a("d", str3, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(c2);
            sb4.append("/files/math/t");
            a("t", str4, sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(c2);
            sb5.append("/files/s");
            a("s", str5, sb5.toString());
        } catch (IOException unused) {
            HMSLog.e(a, "save key IOException.");
        }
    }

    public static String e() {
        return a("p");
    }

    public static String d() {
        return a("m");
    }

    public static String c() {
        return a("d");
    }

    public static void a(String str, Context context) {
        String c2 = p.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(c2);
            sb.append("/files/s");
            a("s", str, sb.toString());
        } catch (IOException unused) {
            HMSLog.e(a, "save keyS IOException.");
        }
    }

    public static void a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        HMSLog.i(a, "save local secret key.");
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str3);
            s.a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter = null;
        }
        try {
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            b.put(str, str2);
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter);
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter2);
            throw th;
        }
    }

    public static String a(String str) {
        String str2 = b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
