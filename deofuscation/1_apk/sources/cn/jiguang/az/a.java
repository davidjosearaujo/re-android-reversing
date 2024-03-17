package cn.jiguang.az;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static Pair<c, ByteBuffer> a(Context context, byte[] bArr, String str) {
        ByteBuffer wrap;
        if (bArr.length < 20) {
            cn.jiguang.ar.c.h("JCommands", "Error: received body-length short than common head-length, return null");
            return null;
        }
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        c cVar = new c(false, bArr2);
        cn.jiguang.ar.c.c("JCommands", "parsed head - " + cVar.toString());
        int i = cVar.a - 20;
        if (i < 0) {
            cn.jiguang.ar.c.h("JCommands", "Error: totalBytes length error with no encrypted, return null");
            return null;
        }
        cn.jiguang.ar.c.a("JCommands", "body size:" + i);
        if (TextUtils.isEmpty(str)) {
            str = b.a(context);
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr, 20, bArr3, 0, i);
        cn.jiguang.ar.c.c("JCommands", "decode algorithm:" + ((int) cVar.d) + ", pwd:" + str);
        if (TextUtils.isEmpty(str)) {
            System.arraycopy(bArr, 20, bArr3, 0, i);
            wrap = ByteBuffer.wrap(bArr3);
        } else {
            try {
                wrap = ByteBuffer.wrap(cVar.d == 2 ? new cn.jiguang.bf.c().b(bArr3, str) : cn.jiguang.bf.d.a(bArr3, str, str.substring(0, 16), false));
            } catch (Exception e) {
                cn.jiguang.ar.c.c("JCommands", "decryptBytes error:" + e.getMessage());
                return null;
            }
        }
        return new Pair<>(cVar, wrap);
    }

    public static boolean a(Context context, byte[] bArr) {
        try {
            Pair<c, ByteBuffer> a = a(context, bArr, "");
            if (a != null) {
                long f = cn.jiguang.d.a.f(context);
                long j = ((c) a.first).g;
                cn.jiguang.ar.c.c("JCommands", "uid:" + f + ",msgUid:" + j + ",cmd:" + ((c) a.first).c);
                if (f == 0 || j == 0 || f == j) {
                    cn.jiguang.ax.b.a().a(context, (c) a.first, (ByteBuffer) a.second);
                    return true;
                }
                cn.jiguang.ar.c.c("JCommands", "recv other app msg");
                cn.jiguang.e.a.b().a(context, j, bArr);
                return true;
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.ar.c.h("JCommands", "dispatchMessage error:" + th.getMessage());
            return false;
        }
    }
}
