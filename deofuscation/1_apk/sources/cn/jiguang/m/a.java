package cn.jiguang.m;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.r.e;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {

    /* renamed from: cn.jiguang.m.a$a */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class C0010a {
        public HandlerThread a;
        public Handler b;
        private int c;
        private String d;

        public C0010a(String str, int i) {
            this.c = i;
            this.d = str;
            HandlerThread handlerThread = new HandlerThread("jg_ptm_thread");
            this.a = handlerThread;
            handlerThread.start();
            this.b = new Handler(this.a.getLooper(), new Handler.Callback() { // from class: cn.jiguang.m.a.a.1
                {
                    C0010a.this = this;
                }

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    Thread thread;
                    if (message == null || message.what != 1 || (thread = (Thread) message.obj) == null) {
                        return false;
                    }
                    thread.interrupt();
                    return false;
                }
            });
        }

        private void b(byte[] bArr, int i, int i2) {
            byte[] bArr2 = {bArr[0], bArr[1], bArr[2], 0};
            Thread currentThread = Thread.currentThread();
            while (i < i2) {
                bArr2[3] = (byte) i;
                if (bArr2[3] != bArr[3]) {
                    String b = a.b(bArr2);
                    if (!b.equalsIgnoreCase(this.d)) {
                        this.b.removeCallbacksAndMessages(null);
                        Message obtainMessage = this.b.obtainMessage(1);
                        obtainMessage.obj = currentThread;
                        Bundle bundle = new Bundle();
                        bundle.putString("ip", b);
                        obtainMessage.setData(bundle);
                        this.b.sendMessageDelayed(obtainMessage, this.c);
                        e.a(new String[]{"ping -c 1 -w 1 " + b}, 0);
                    }
                }
                i++;
            }
        }

        public void a(byte[] bArr, int i, int i2) {
            b(bArr, i, i2);
            this.a.quit();
        }
    }

    public static String a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i & JfifUtil.MARKER_FIRST_BYTE);
        stringBuffer.append('.');
        stringBuffer.append((i >> 8) & JfifUtil.MARKER_FIRST_BYTE);
        stringBuffer.append('.');
        stringBuffer.append((i >> 16) & JfifUtil.MARKER_FIRST_BYTE);
        stringBuffer.append('.');
        stringBuffer.append((i >> 24) & JfifUtil.MARKER_FIRST_BYTE);
        return stringBuffer.toString();
    }

    public static List<cn.jiguang.l.a> a(String str) {
        cn.jiguang.l.a b;
        List<String> a = e.a(new String[]{"cat /proc/net/arp"}, 1);
        if (a == null || a.isEmpty()) {
            cn.jiguang.ak.a.d("JArpHelper", "execute command failed");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : a) {
            if (!TextUtils.isEmpty(str2) && (b = b(str2)) != null && b.c.equals("0x2") && !str.equals(b.a) && !b.d.equals(com.alipay.sdk.util.a.b)) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    public static void a(String str, byte[] bArr) {
        new C0010a(str, 300).a(bArr, 0, JfifUtil.MARKER_FIRST_BYTE);
    }

    public static byte[] a(long j) {
        return new byte[]{(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)};
    }

    private static cn.jiguang.l.a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        cn.jiguang.l.a aVar = new cn.jiguang.l.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i >= bytes.length - 1) {
                break;
            }
            i++;
            if (bytes[i] == 32) {
                int i4 = i - i2;
                if (i4 > 1) {
                    String str2 = new String(bytes, i2, i4);
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    aVar.d = str2;
                                    break;
                                }
                            } else {
                                aVar.c = str2;
                            }
                        } else {
                            aVar.b = str2;
                        }
                    } else {
                        aVar.a = str2;
                    }
                    i3++;
                }
                i2 = i + 1;
            }
        }
        return aVar;
    }

    public static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bArr[0] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[1] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[2] & 255);
        stringBuffer.append('.');
        stringBuffer.append(bArr[3] & 255);
        return stringBuffer.toString();
    }
}
