package cn.jpush.android.helper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import com.hunantv.mpdt.data.EventClickData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class i {
    private static List<String> a;
    private static List<String> b;
    private static Map<String, Integer> c;
    private static Map<String, Map<String, Integer[]>> d;
    private static Map<String, Integer> e;
    private static List<String> f;
    private static long g;
    private static int h;
    private static String i;
    private static String j;
    private static String k;

    static {
        HashMap hashMap = new HashMap();
        c = hashMap;
        hashMap.put("xiaomi", 1);
        c.put("lge", 1);
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("Smartisan");
        a.add("Lenovo");
        ArrayList arrayList2 = new ArrayList();
        b = arrayList2;
        arrayList2.add("MI 5C");
        ArrayList arrayList3 = new ArrayList();
        f = arrayList3;
        arrayList3.add("nubia");
        HashMap hashMap2 = new HashMap();
        e = hashMap2;
        hashMap2.put("galaxy nexus", 1);
        a();
        i = "";
        j = "";
        k = "";
    }

    public static int a(Context context) {
        if (context != null && context.getResources().getIdentifier("push_notification_banner_layout", "id", context.getPackageName()) > 0) {
            for (int i2 = 1; i2 < 100; i2++) {
                Resources resources = context.getResources();
                if (resources.getIdentifier("layout_version_" + i2, "id", context.getPackageName()) > 0) {
                    return i2;
                }
            }
            return 0;
        }
        return 0;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[Catch: all -> 0x0109, TRY_ENTER, TryCatch #2 {all -> 0x0109, blocks: (B:7:0x0011, B:16:0x003b, B:18:0x003f, B:19:0x0041, B:23:0x0061, B:25:0x0071, B:26:0x0077, B:28:0x007d, B:30:0x0083, B:39:0x00c6, B:40:0x00cd, B:42:0x00d3, B:32:0x008c, B:34:0x00ab, B:44:0x00fa), top: B:54:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[Catch: all -> 0x0109, TryCatch #2 {all -> 0x0109, blocks: (B:7:0x0011, B:16:0x003b, B:18:0x003f, B:19:0x0041, B:23:0x0061, B:25:0x0071, B:26:0x0077, B:28:0x007d, B:30:0x0083, B:39:0x00c6, B:40:0x00cd, B:42:0x00d3, B:32:0x008c, B:34:0x00ab, B:44:0x00fa), top: B:54:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[Catch: all -> 0x0109, TryCatch #2 {all -> 0x0109, blocks: (B:7:0x0011, B:16:0x003b, B:18:0x003f, B:19:0x0041, B:23:0x0061, B:25:0x0071, B:26:0x0077, B:28:0x007d, B:30:0x0083, B:39:0x00c6, B:40:0x00cd, B:42:0x00d3, B:32:0x008c, B:34:0x00ab, B:44:0x00fa), top: B:54:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[Catch: all -> 0x0109, TryCatch #2 {all -> 0x0109, blocks: (B:7:0x0011, B:16:0x003b, B:18:0x003f, B:19:0x0041, B:23:0x0061, B:25:0x0071, B:26:0x0077, B:28:0x007d, B:30:0x0083, B:39:0x00c6, B:40:0x00cd, B:42:0x00d3, B:32:0x008c, B:34:0x00ab, B:44:0x00fa), top: B:54:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa A[Catch: all -> 0x0109, TRY_LEAVE, TryCatch #2 {all -> 0x0109, blocks: (B:7:0x0011, B:16:0x003b, B:18:0x003f, B:19:0x0041, B:23:0x0061, B:25:0x0071, B:26:0x0077, B:28:0x007d, B:30:0x0083, B:39:0x00c6, B:40:0x00cd, B:42:0x00d3, B:32:0x008c, B:34:0x00ab, B:44:0x00fa), top: B:54:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r16, int r17, long r18) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.helper.i.a(android.content.Context, int, long):int");
    }

    public static int a(Context context, String str, int i2) {
        String b2;
        if (context == null) {
            return 0;
        }
        try {
            b2 = cn.jpush.android.r.h.b(context);
        } catch (Throwable th) {
            Logger.w("SSPHelper", "[checkInAppAndSSPContent] error: " + th.getMessage());
        }
        if (TextUtils.isEmpty(b2)) {
            Logger.d("SSPHelper", "[checkInAppAndSSPContent] getLatestInAppInfo, info: " + b2);
            return 0;
        }
        String[] split = b2.split(",");
        String valueOf = String.valueOf(split[0]);
        long parseLong = Long.parseLong(split[1]);
        long currentTimeMillis = System.currentTimeMillis();
        Logger.d("SSPHelper", "in-app md5-content: " + valueOf + "; md5-sspContent: " + str + ", currentTime: " + currentTimeMillis + ", inAppTime: " + parseLong);
        if (!TextUtils.isEmpty(valueOf) && cn.jpush.android.ac.b.a(currentTimeMillis, parseLong)) {
            Logger.d("SSPHelper", "latest ssp and in-app show in same day");
            if (currentTimeMillis - parseLong <= i2) {
                if (valueOf.equals(str)) {
                    Logger.w("SSPHelper", "same content in-app display now by interval time, drop this ssp message");
                    return 2;
                }
                Logger.w("SSPHelper", "not same content in-app message show recently(3min),ssp delay 3min to notify");
                return 1;
            }
        }
        return 0;
    }

    private static int a(String str) {
        if (Build.MANUFACTURER.toLowerCase().contains("meizu")) {
            return (str.startsWith("Flyme 8") || str.startsWith("Flyme 7.1")) ? 0 : 1;
        }
        return -2;
    }

    public static Map<String, Integer[]> a(int i2) {
        try {
            String a2 = h.a();
            Logger.d("SSPHelper", "get os version = " + a2);
            if (!TextUtils.isEmpty(a2)) {
                for (Map.Entry<String, Map<String, Integer[]>> entry : d.entrySet()) {
                    String[] split = entry.getKey().split("@lv");
                    if (split.length == 2) {
                        String str = split[0];
                        if (a2.startsWith(str)) {
                            Map<String, Map<String, Integer[]>> map = d;
                            Map<String, Integer[]> map2 = map.get(str + "@lv" + i2);
                            if (map2 != null) {
                                return map2;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Logger.w("SSPHelper", "getLocationMap failed:" + th);
        }
        Map<String, Map<String, Integer[]>> map3 = d;
        return map3.get("default@lv" + i2);
    }

    public static void a() {
        d = new LinkedHashMap();
        HashMap hashMap = new HashMap();
        hashMap.put("100", new Integer[]{10, 12, 0, 0});
        hashMap.put(EventClickData.i.w0, new Integer[]{0, 1, 0, 1});
        hashMap.put("102", new Integer[]{4, 0, 0, 0});
        hashMap.put(EventClickData.i.z0, new Integer[]{0, 10, 0, 0});
        hashMap.put("105", new Integer[]{0, 2, 0, 0});
        hashMap.put(EventClickData.i.C0, new Integer[]{1});
        hashMap.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap.put(EventClickData.i.B0, new Integer[]{0, 8, 8, 0});
        hashMap.put(EventClickData.i.L0, new Integer[]{0, 0, 12, 0});
        hashMap.put("108", new Integer[]{8});
        d.put("EmotionUI_10.0@lv1", hashMap);
        hashMap.put(EventClickData.i.z0, new Integer[]{0, 5, 0, 0});
        d.put("EmotionUI_10.0@lv0", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(EventClickData.i.w0, new Integer[]{0, 1, 0, 1});
        hashMap2.put("100", new Integer[]{15, 2, 15, 4});
        hashMap2.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap2.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap2.put(EventClickData.i.B0, new Integer[]{6, 0, 0, 6});
        hashMap2.put("102", new Integer[]{5, 0, 0, 0});
        hashMap2.put(EventClickData.i.C0, new Integer[]{1});
        hashMap2.put(EventClickData.i.y0, new Integer[]{6, 0, 0, 0});
        hashMap2.put("108", new Integer[]{8});
        d.put("EmotionUI_10.0@lv2", hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("100", new Integer[]{10, 12, 7, 0});
        hashMap3.put(EventClickData.i.w0, new Integer[]{0, 1, 0, 1});
        hashMap3.put("102", new Integer[]{4, 0, 0, 0});
        hashMap3.put(EventClickData.i.z0, new Integer[]{0, 10, 0, 0});
        hashMap3.put("105", new Integer[]{0, 2, 0, 0});
        hashMap3.put(EventClickData.i.C0, new Integer[]{1});
        hashMap3.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap3.put(EventClickData.i.B0, new Integer[]{7, 7, 0, 0});
        hashMap3.put(EventClickData.i.L0, new Integer[]{0, 0, 6, 0});
        hashMap3.put("108", new Integer[]{8});
        d.put("EmotionUI_10.1@lv1", hashMap3);
        hashMap3.put(EventClickData.i.z0, new Integer[]{0, 5, 0, 0});
        d.put("EmotionUI_10.1@lv0", hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(EventClickData.i.w0, new Integer[]{0, 2, 2, 0});
        hashMap4.put("100", new Integer[]{16, 2, 16, 2});
        hashMap4.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap4.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap4.put(EventClickData.i.B0, new Integer[]{8, 0, 0, 8});
        hashMap4.put("102", new Integer[]{3, 0, 0, 0});
        hashMap4.put(EventClickData.i.C0, new Integer[]{1});
        hashMap4.put("108", new Integer[]{8});
        hashMap4.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        d.put("EmotionUI_10.1@lv2", hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put("100", new Integer[]{7, 2, 4, 6});
        hashMap5.put(EventClickData.i.w0, new Integer[]{0, 1, 0, 1});
        hashMap5.put("102", new Integer[]{4, 0, 0, 0});
        hashMap5.put(EventClickData.i.z0, new Integer[]{0, 0, 0, 0});
        hashMap5.put("105", new Integer[]{0, 2, 0, 0});
        hashMap5.put(EventClickData.i.C0, new Integer[]{1});
        hashMap5.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap5.put(EventClickData.i.B0, new Integer[]{8, 0, 0, 8});
        hashMap5.put(EventClickData.i.L0, new Integer[]{0, 6, 6, 0});
        hashMap5.put(EventClickData.i.M0, new Integer[]{0});
        d.put("EmotionUI_9.1.1@lv1", hashMap5);
        d.put("EmotionUI_9.1.1@lv0", hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put(EventClickData.i.w0, new Integer[]{0, 2, 2, 0});
        hashMap6.put("100", new Integer[]{12, 0, 12, 2});
        hashMap6.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap6.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap6.put(EventClickData.i.B0, new Integer[]{8, 0, 0, 8});
        hashMap6.put("102", new Integer[]{3, 0, 0, 0});
        hashMap6.put(EventClickData.i.C0, new Integer[]{1});
        hashMap6.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        hashMap6.put(EventClickData.i.M0, new Integer[]{0});
        d.put("EmotionUI_9.1.1@lv2", hashMap6);
        HashMap hashMap7 = new HashMap();
        hashMap7.put("100", new Integer[]{7, 2, 1, 6});
        hashMap7.put(EventClickData.i.w0, new Integer[]{0, 1, 0, 1});
        hashMap7.put("102", new Integer[]{4, 0, 0, 0});
        hashMap7.put(EventClickData.i.z0, new Integer[]{0, 0, 0, 0});
        hashMap7.put("105", new Integer[]{0, 0, 0, 0});
        hashMap7.put(EventClickData.i.C0, new Integer[]{1});
        hashMap7.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap7.put(EventClickData.i.B0, new Integer[]{4, 0, 4, 0});
        hashMap7.put(EventClickData.i.L0, new Integer[]{0, 6, 8, 0});
        hashMap7.put(EventClickData.i.M0, new Integer[]{0});
        d.put("EmotionUI_9.0.0@lv1", hashMap7);
        d.put("EmotionUI_9.0.0@lv0", hashMap7);
        HashMap hashMap8 = new HashMap();
        hashMap8.put(EventClickData.i.w0, new Integer[]{0, 2, 2, 0});
        hashMap8.put("100", new Integer[]{12, 0, 12, 2});
        hashMap8.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap8.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap8.put(EventClickData.i.B0, new Integer[]{8, 8, 0, 0});
        hashMap8.put("102", new Integer[]{3, 0, 0, 0});
        hashMap8.put(EventClickData.i.C0, new Integer[]{1});
        hashMap8.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        hashMap8.put(EventClickData.i.M0, new Integer[]{0});
        d.put("EmotionUI_9.0.0@lv2", hashMap8);
        HashMap hashMap9 = new HashMap();
        hashMap9.put("100", new Integer[]{7, 7, 4, 0});
        hashMap9.put(EventClickData.i.w0, new Integer[]{0, 1, 0, 1});
        hashMap9.put("102", new Integer[]{4, 0, 0, 0});
        hashMap9.put(EventClickData.i.z0, new Integer[]{0, 10, 0, 0});
        hashMap9.put("105", new Integer[]{0, 2, 0, 0});
        hashMap9.put(EventClickData.i.C0, new Integer[]{1});
        hashMap9.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap9.put(EventClickData.i.B0, new Integer[]{8, 8, 0, 0});
        hashMap9.put(EventClickData.i.L0, new Integer[]{0, 0, 6, 0});
        d.put("EmotionUI_9@lv1", hashMap9);
        hashMap9.put(EventClickData.i.z0, new Integer[]{0, 5, 0, 0});
        d.put("EmotionUI_9@lv0", hashMap9);
        HashMap hashMap10 = new HashMap();
        hashMap10.put(EventClickData.i.w0, new Integer[]{0, 2, 2, 0});
        hashMap10.put("100", new Integer[]{12, 0, 12, 2});
        hashMap10.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap10.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap10.put(EventClickData.i.B0, new Integer[]{8, 0, 0, 8});
        hashMap10.put("102", new Integer[]{3, 0, 0, 0});
        hashMap10.put(EventClickData.i.C0, new Integer[]{1});
        hashMap10.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        hashMap10.put(EventClickData.i.M0, new Integer[]{0});
        d.put("EmotionUI_9@lv2", hashMap10);
        HashMap hashMap11 = new HashMap();
        hashMap11.put("100", new Integer[]{12, 9, 0, 0});
        hashMap11.put(EventClickData.i.w0, new Integer[]{0, 1, 0, 1});
        hashMap11.put("102", new Integer[]{0, 0, 0, 0});
        hashMap11.put(EventClickData.i.z0, new Integer[]{0, 3, 0, 0});
        hashMap11.put("105", new Integer[]{0, 2, 0, 0});
        hashMap11.put(EventClickData.i.C0, new Integer[]{1});
        hashMap11.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap11.put(EventClickData.i.B0, new Integer[]{0, 4, 4, 0});
        hashMap11.put(EventClickData.i.L0, new Integer[]{0, 0, 12, 0});
        hashMap11.put("108", new Integer[]{8});
        d.put("EmotionUI_8@lv1", hashMap11);
        d.put("EmotionUI_8@lv0", hashMap11);
        HashMap hashMap12 = new HashMap();
        hashMap12.put(EventClickData.i.w0, new Integer[]{0, 2, 2, 0});
        hashMap12.put("100", new Integer[]{16, 0, 16, 2});
        hashMap12.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap12.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap12.put(EventClickData.i.B0, new Integer[]{8, 8, 0, 8});
        hashMap12.put("102", new Integer[]{0, 0, 0, 0});
        hashMap12.put(EventClickData.i.C0, new Integer[]{1});
        hashMap12.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        hashMap12.put(EventClickData.i.M0, new Integer[]{0});
        d.put("EmotionUI_8@lv2", hashMap12);
        HashMap hashMap13 = new HashMap();
        hashMap13.put("100", new Integer[]{12, 11, 2, 0});
        hashMap13.put(EventClickData.i.w0, new Integer[]{0, 1, 0, 1});
        hashMap13.put("102", new Integer[]{0, 0, 0, 0});
        hashMap13.put(EventClickData.i.z0, new Integer[]{0, 4, 0, 0});
        hashMap13.put("105", new Integer[]{0, 1, 0, 0});
        hashMap13.put(EventClickData.i.C0, new Integer[]{1});
        hashMap13.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap13.put(EventClickData.i.B0, new Integer[]{0, 4, 4, 0});
        hashMap13.put(EventClickData.i.L0, new Integer[]{0, 0, 12, 0});
        hashMap13.put("108", new Integer[]{8});
        hashMap13.put("111", new Integer[]{8});
        d.put("EmotionUI_5@lv1", hashMap13);
        d.put("EmotionUI_6@lv1", hashMap13);
        d.put("EmotionUI_7@lv1", hashMap13);
        d.put("EmotionUI_5@lv0", hashMap13);
        d.put("EmotionUI_6@lv0", hashMap13);
        d.put("EmotionUI_7@lv0", hashMap13);
        HashMap hashMap14 = new HashMap();
        hashMap14.put(EventClickData.i.w0, new Integer[]{0, 2, 2, 0});
        hashMap14.put("100", new Integer[]{16, 0, 16, 2});
        hashMap14.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap14.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap14.put(EventClickData.i.B0, new Integer[]{8, 8, 0, 8});
        hashMap14.put("102", new Integer[]{0, 0, 0, 0});
        hashMap14.put(EventClickData.i.C0, new Integer[]{1});
        hashMap14.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        hashMap14.put(EventClickData.i.M0, new Integer[]{0});
        d.put("EmotionUI_5@lv2", hashMap14);
        d.put("EmotionUI_6@lv2", hashMap14);
        d.put("EmotionUI_7@lv2", hashMap14);
        HashMap hashMap15 = new HashMap();
        hashMap15.put("100", new Integer[]{1, 0, 0, 0});
        hashMap15.put("102", new Integer[]{7, 11, 0, -1});
        hashMap15.put(EventClickData.i.y0, new Integer[]{0, 11, 0, 0});
        hashMap15.put("105", new Integer[]{7, -1, 0, 0});
        hashMap15.put(EventClickData.i.C0, new Integer[]{1});
        hashMap15.put(EventClickData.i.B0, new Integer[]{3, 11, 9, 1});
        hashMap15.put(EventClickData.i.K0, new Integer[]{10});
        hashMap15.put(EventClickData.i.L0, new Integer[]{0, 12, 0, 0});
        d.put("MIUI_V9@lv1", hashMap15);
        d.put("MIUI_V9@lv0", hashMap15);
        HashMap hashMap16 = new HashMap();
        hashMap16.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap16.put("102", new Integer[]{14, 8, 0, 0});
        hashMap16.put("100", new Integer[]{14, 5, 0, 4});
        hashMap16.put("105", new Integer[]{14, 0, 0, 0});
        hashMap16.put(EventClickData.i.C0, new Integer[]{1});
        hashMap16.put(EventClickData.i.B0, new Integer[]{2, 4, 2, 0});
        d.put("MIUI_V9@lv2", hashMap16);
        HashMap hashMap17 = new HashMap();
        hashMap17.put("100", new Integer[]{-1, 0, 0, 0});
        hashMap17.put("102", new Integer[]{-1, 3, 0, 0});
        hashMap17.put(EventClickData.i.y0, new Integer[]{0, 5, 0, 0});
        hashMap17.put("105", new Integer[]{-1, 2, 0, 0});
        hashMap17.put(EventClickData.i.C0, new Integer[]{1});
        hashMap17.put(EventClickData.i.B0, new Integer[]{5, 10, 14, 9});
        hashMap17.put(EventClickData.i.L0, new Integer[]{0, 9, 0, 0});
        d.put("MIUI_V10@lv1", hashMap17);
        d.put("MIUI_V10@lv0", hashMap17);
        HashMap hashMap18 = new HashMap();
        hashMap18.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap18.put("102", new Integer[]{0, 8, 0, 0});
        hashMap18.put("100", new Integer[]{0, 5, 0, 0});
        hashMap18.put("105", new Integer[]{0, 0, 0, 0});
        hashMap18.put(EventClickData.i.C0, new Integer[]{1});
        hashMap18.put(EventClickData.i.B0, new Integer[]{4, 14, 14, 4});
        hashMap18.put(EventClickData.i.M0, new Integer[]{0});
        d.put("MIUI_V10@lv2", hashMap18);
        HashMap hashMap19 = new HashMap();
        hashMap19.put("100", new Integer[]{0, 0, 0, 0});
        hashMap19.put("102", new Integer[]{0, 3, 0, 0});
        hashMap19.put(EventClickData.i.y0, new Integer[]{0, 5, 0, 0});
        hashMap19.put("105", new Integer[]{0, 2, 0, 0});
        hashMap19.put(EventClickData.i.C0, new Integer[]{1});
        hashMap19.put(EventClickData.i.B0, new Integer[]{2, 6, 10, 6});
        hashMap19.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        d.put("MIUI_V11@lv1", hashMap19);
        d.put("MIUI_V11@lv0", hashMap19);
        HashMap hashMap20 = new HashMap();
        hashMap20.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap20.put("102", new Integer[]{0, 8, 0, 0});
        hashMap20.put("100", new Integer[]{0, 5, 0, 4});
        hashMap20.put("105", new Integer[]{0, 0, 0, 0});
        hashMap20.put(EventClickData.i.C0, new Integer[]{1});
        hashMap20.put(EventClickData.i.B0, new Integer[]{0, 10, 12, 2});
        d.put("MIUI_V11@lv2", hashMap20);
        HashMap hashMap21 = new HashMap();
        hashMap21.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap21.put("102", new Integer[]{0, 3, 0, 0});
        hashMap21.put("100", new Integer[]{0, 0, 14, 0});
        hashMap21.put("105", new Integer[]{2, 0, 0, 0});
        hashMap21.put(EventClickData.i.C0, new Integer[]{2});
        hashMap21.put(EventClickData.i.B0, new Integer[]{12, 0, 12, 24});
        hashMap21.put("111", new Integer[]{8});
        d.put("MIUI_V12@lv2", hashMap21);
        HashMap hashMap22 = new HashMap();
        hashMap22.put("100", new Integer[]{10, 12, 0, 0});
        hashMap22.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap22.put("102", new Integer[]{0, 0, 0, 0});
        hashMap22.put(EventClickData.i.z0, new Integer[]{0, 7, 0, 0});
        hashMap22.put("105", new Integer[]{0, 0, 0, 0});
        hashMap22.put(EventClickData.i.C0, new Integer[]{1});
        hashMap22.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap22.put(EventClickData.i.B0, new Integer[]{4, 8, 4, 0});
        hashMap22.put(EventClickData.i.L0, new Integer[]{0, 0, 10, 0});
        hashMap22.put("108", new Integer[]{8});
        hashMap22.put("111", new Integer[]{8});
        d.put("OPPO_V6@lv1", hashMap22);
        d.put("OPPO_V6@lv0", hashMap22);
        HashMap hashMap23 = new HashMap();
        hashMap23.put(EventClickData.i.w0, new Integer[]{0, 2, 0, 0});
        hashMap23.put("100", new Integer[]{14, 2, 14, 4});
        hashMap23.put(EventClickData.i.H0, new Integer[]{0, 10, 0, 0});
        hashMap23.put(EventClickData.i.L0, new Integer[]{0, 10, 0, 0});
        hashMap23.put(EventClickData.i.B0, new Integer[]{10, 10, 2, 2});
        hashMap23.put("102", new Integer[]{2, 0, 0, 0});
        hashMap23.put("105", new Integer[]{0, 0, 0, 5});
        hashMap23.put(EventClickData.i.C0, new Integer[]{1});
        hashMap23.put("108", new Integer[]{8});
        hashMap23.put("111", new Integer[]{8});
        d.put("OPPO_V6@lv2", hashMap23);
        HashMap hashMap24 = new HashMap();
        hashMap24.put("100", new Integer[]{10, 12, 0, 0});
        hashMap24.put(EventClickData.i.w0, new Integer[]{0, 2, 0, 2});
        hashMap24.put("102", new Integer[]{0, 0, 0, 0});
        hashMap24.put(EventClickData.i.z0, new Integer[]{0, 7, 0, 0});
        hashMap24.put("105", new Integer[]{0, 0, 0, 0});
        hashMap24.put(EventClickData.i.C0, new Integer[]{1});
        hashMap24.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap24.put(EventClickData.i.B0, new Integer[]{5, 10, 5, 0});
        hashMap24.put(EventClickData.i.L0, new Integer[]{0, 0, 10, 0});
        d.put("OPPO_V7@lv1", hashMap24);
        d.put("OPPO_V7@lv0", hashMap24);
        HashMap hashMap25 = new HashMap();
        hashMap25.put(EventClickData.i.w0, new Integer[]{4, 4, 0, 0});
        hashMap25.put("100", new Integer[]{15, 2, 15, 4});
        hashMap25.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap25.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap25.put(EventClickData.i.B0, new Integer[]{12, 6, 2, 8});
        hashMap25.put("102", new Integer[]{4, 0, 0, 0});
        hashMap25.put(EventClickData.i.C0, new Integer[]{1});
        hashMap25.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        d.put("OPPO_V7@lv2", hashMap25);
        HashMap hashMap26 = new HashMap();
        hashMap26.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap26.put("100", new Integer[]{14, 2, 14, 4});
        hashMap26.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap26.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap26.put(EventClickData.i.B0, new Integer[]{10, 10, 2, 2});
        hashMap26.put("102", new Integer[]{4, 0, 0, 0});
        hashMap26.put(EventClickData.i.C0, new Integer[]{1});
        hashMap26.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        d.put("OPPO_V5.1@lv2", hashMap26);
        HashMap hashMap27 = new HashMap();
        hashMap27.put("100", new Integer[]{5, 4, 0, 0});
        hashMap27.put(EventClickData.i.w0, new Integer[]{0, 1, 0, 1});
        hashMap27.put("102", new Integer[]{0, 0, 0, 0});
        hashMap27.put(EventClickData.i.z0, new Integer[]{0, 7, 0, 0});
        hashMap27.put("105", new Integer[]{0, 0, 0, 0});
        hashMap27.put(EventClickData.i.C0, new Integer[]{1});
        hashMap27.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap27.put(EventClickData.i.B0, new Integer[]{10, 12, 2, 0});
        hashMap27.put(EventClickData.i.L0, new Integer[]{0, 6, 10, 0});
        d.put("OPPO_V5@lv1", hashMap27);
        d.put("OPPO_V5@lv0", hashMap27);
        HashMap hashMap28 = new HashMap();
        hashMap28.put(EventClickData.i.w0, new Integer[]{0, 2, 0, 0});
        hashMap28.put("100", new Integer[]{10, 0, 10, 4});
        hashMap28.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap28.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap28.put(EventClickData.i.B0, new Integer[]{12, 10, 2, 4});
        hashMap28.put("102", new Integer[]{4, 0, 0, 0});
        hashMap28.put(EventClickData.i.C0, new Integer[]{1});
        hashMap28.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        d.put("OPPO_V5@lv2", hashMap28);
        HashMap hashMap29 = new HashMap();
        hashMap29.put("100", new Integer[]{8, 3, 0, 0});
        hashMap29.put(EventClickData.i.H0, new Integer[]{2, 0, 0, 0});
        hashMap29.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap29.put("102", new Integer[]{5, 0, 0, 0});
        hashMap29.put(EventClickData.i.z0, new Integer[]{0, 0, 0, 0});
        hashMap29.put("105", new Integer[]{0, 0, 6, 0});
        hashMap29.put(EventClickData.i.C0, new Integer[]{2});
        hashMap29.put(EventClickData.i.y0, new Integer[]{0, 0, 0, 0});
        hashMap29.put(EventClickData.i.B0, new Integer[]{6, 12, 6, 0});
        hashMap29.put(EventClickData.i.L0, new Integer[]{0, 6, 12, 0});
        hashMap29.put(EventClickData.i.N0, new Integer[]{8});
        d.put("Funtouch OS_4.5@lv1", hashMap29);
        d.put("Funtouch OS_4.5@lv0", hashMap29);
        HashMap hashMap30 = new HashMap();
        hashMap30.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap30.put("100", new Integer[]{13, 5, 13, 4});
        hashMap30.put(EventClickData.i.B0, new Integer[]{12, 7, 2, 7});
        hashMap30.put("102", new Integer[]{5, 0, 0, 0});
        hashMap30.put(EventClickData.i.C0, new Integer[]{2});
        d.put("Funtouch OS_4.5@lv2", hashMap30);
        HashMap hashMap31 = new HashMap();
        hashMap31.put("100", new Integer[]{9, 3, 0, 0});
        hashMap31.put(EventClickData.i.H0, new Integer[]{2, 0, 0, 0});
        hashMap31.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap31.put("102", new Integer[]{3, 0, 0, 0});
        hashMap31.put(EventClickData.i.z0, new Integer[]{0, 0, 0, 0});
        hashMap31.put("105", new Integer[]{0, 0, 6, 0});
        hashMap31.put(EventClickData.i.C0, new Integer[]{2});
        hashMap31.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap31.put(EventClickData.i.B0, new Integer[]{6, 12, 6, 0});
        hashMap31.put(EventClickData.i.L0, new Integer[]{0, 6, 12, 0});
        hashMap31.put(EventClickData.i.N0, new Integer[]{8});
        d.put("Funtouch OS_4@lv1", hashMap31);
        d.put("Funtouch OS_4@lv0", hashMap31);
        HashMap hashMap32 = new HashMap();
        hashMap32.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap32.put("100", new Integer[]{13, 5, 13, 4});
        hashMap32.put(EventClickData.i.B0, new Integer[]{12, 0, 2, 14});
        hashMap32.put("102", new Integer[]{5, 0, 0, 0});
        hashMap32.put(EventClickData.i.C0, new Integer[]{2});
        d.put("Funtouch OS_4@lv2", hashMap32);
        HashMap hashMap33 = new HashMap();
        hashMap33.put("100", new Integer[]{8, 5, 0, 0});
        hashMap33.put(EventClickData.i.H0, new Integer[]{3, 0, 0, 0});
        hashMap33.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap33.put("102", new Integer[]{5, 0, 0, 0});
        hashMap33.put(EventClickData.i.z0, new Integer[]{0, 5, 0, 0});
        hashMap33.put("105", new Integer[]{0, 0, 6, 4});
        hashMap33.put(EventClickData.i.C0, new Integer[]{2});
        hashMap33.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap33.put(EventClickData.i.B0, new Integer[]{5, 0, 7, 0});
        hashMap33.put(EventClickData.i.L0, new Integer[]{0, 6, 12, 0});
        hashMap33.put(EventClickData.i.N0, new Integer[]{8});
        d.put("Funtouch OS_9@lv1", hashMap33);
        d.put("Funtouch OS_9@lv0", hashMap33);
        HashMap hashMap34 = new HashMap();
        hashMap34.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap34.put("100", new Integer[]{13, 2, 13, 4});
        hashMap34.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap34.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap34.put(EventClickData.i.B0, new Integer[]{12, 0, 2, 14});
        hashMap34.put("102", new Integer[]{5, 0, 0, 0});
        hashMap34.put(EventClickData.i.C0, new Integer[]{2});
        d.put("Funtouch OS_9@lv2", hashMap34);
        HashMap hashMap35 = new HashMap();
        hashMap35.put("100", new Integer[]{8, 5, 0, 0});
        hashMap35.put(EventClickData.i.H0, new Integer[]{3, 0, 0, 0});
        hashMap35.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap35.put("102", new Integer[]{5, 0, 0, 0});
        hashMap35.put(EventClickData.i.z0, new Integer[]{0, 5, 0, 0});
        hashMap35.put("105", new Integer[]{0, 0, 6, 4});
        hashMap35.put(EventClickData.i.C0, new Integer[]{2});
        hashMap35.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap35.put(EventClickData.i.B0, new Integer[]{10, 0, 8, 18});
        hashMap35.put(EventClickData.i.L0, new Integer[]{0, 6, 12, 0});
        d.put("Funtouch OS_10@lv1", hashMap35);
        d.put("Funtouch OS_10@lv0", hashMap35);
        HashMap hashMap36 = new HashMap();
        hashMap36.put(EventClickData.i.w0, new Integer[]{0, 0, 1, 0});
        hashMap36.put("100", new Integer[]{14, 2, 14, 4});
        hashMap36.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap36.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap36.put(EventClickData.i.B0, new Integer[]{16, 4, 2, 14});
        hashMap36.put("102", new Integer[]{5, 0, 0, 0});
        hashMap36.put(EventClickData.i.C0, new Integer[]{1});
        d.put("Funtouch OS_10@lv2", hashMap36);
        HashMap hashMap37 = new HashMap();
        hashMap37.put("100", new Integer[]{22, 4, 18, 0});
        hashMap37.put(EventClickData.i.H0, new Integer[]{0, 10, 0, 0});
        hashMap37.put(EventClickData.i.L0, new Integer[]{0, 10, 0, 0});
        hashMap37.put(EventClickData.i.w0, new Integer[]{2, 2, 2, 2});
        hashMap37.put("102", new Integer[]{0, 0, 0, 0});
        hashMap37.put(EventClickData.i.z0, new Integer[]{0, 0, 0, 2});
        hashMap37.put("108", new Integer[]{8});
        hashMap37.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap37.put(EventClickData.i.C0, new Integer[]{1});
        hashMap37.put(EventClickData.i.B0, new Integer[]{6, 6, 6, 6});
        d.put("SAMSUNG_ONEUI_1.5@lv2", hashMap37);
        HashMap hashMap38 = new HashMap();
        hashMap38.put("100", new Integer[]{18, 11, 9, 0});
        hashMap38.put(EventClickData.i.w0, new Integer[]{2, 2, 2, 2});
        hashMap38.put("102", new Integer[]{0, 0, 0, 0});
        hashMap38.put(EventClickData.i.z0, new Integer[]{0, 8, 0, 0});
        hashMap38.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap38.put("105", new Integer[]{0, 2, 6, 10});
        hashMap38.put(EventClickData.i.C0, new Integer[]{1});
        hashMap38.put(EventClickData.i.B0, new Integer[]{0, 0, 0, 0});
        hashMap38.put("108", new Integer[]{8});
        hashMap38.put(EventClickData.i.L0, new Integer[]{0, 0, 13, 0});
        d.put("SAMSUNG_ONEUI_1@lv1", hashMap38);
        d.put("SAMSUNG_ONEUI_1@lv0", hashMap38);
        HashMap hashMap39 = new HashMap();
        hashMap39.put("100", new Integer[]{24, 4, 18, 0});
        hashMap39.put(EventClickData.i.H0, new Integer[]{0, 10, 0, 0});
        hashMap39.put(EventClickData.i.L0, new Integer[]{0, 10, 0, 0});
        hashMap39.put(EventClickData.i.w0, new Integer[]{2, 2, 2, 2});
        hashMap39.put("102", new Integer[]{0, 0, 0, 0});
        hashMap39.put(EventClickData.i.z0, new Integer[]{0, 0, 0, 2});
        hashMap39.put("108", new Integer[]{8});
        hashMap39.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap39.put(EventClickData.i.C0, new Integer[]{1});
        hashMap39.put(EventClickData.i.B0, new Integer[]{0, 0, 0, 0});
        d.put("SAMSUNG_ONEUI_1@lv2", hashMap39);
        HashMap hashMap40 = new HashMap();
        hashMap40.put("100", new Integer[]{18, 11, 9, 0});
        hashMap40.put(EventClickData.i.w0, new Integer[]{2, 2, 2, 2});
        hashMap40.put("102", new Integer[]{0, 0, 0, 0});
        hashMap40.put(EventClickData.i.z0, new Integer[]{0, 8, 12, 0});
        hashMap40.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap40.put("105", new Integer[]{0, 2, 12, 10});
        hashMap40.put(EventClickData.i.C0, new Integer[]{1});
        hashMap40.put(EventClickData.i.B0, new Integer[]{5, 0, 6, 11});
        hashMap40.put("108", new Integer[]{8});
        hashMap40.put(EventClickData.i.L0, new Integer[]{0, 0, 13, 0});
        d.put("SAMSUNG_ONEUI_2@lv1", hashMap40);
        d.put("SAMSUNG_ONEUI_2@lv0", hashMap40);
        HashMap hashMap41 = new HashMap();
        hashMap41.put("100", new Integer[]{22, 4, 18, 4});
        hashMap41.put(EventClickData.i.H0, new Integer[]{0, 10, 0, 0});
        hashMap41.put(EventClickData.i.L0, new Integer[]{0, 10, 0, 0});
        hashMap41.put(EventClickData.i.w0, new Integer[]{2, 2, 2, 2});
        hashMap41.put("102", new Integer[]{0, 0, 0, 0});
        hashMap41.put(EventClickData.i.z0, new Integer[]{0, 0, 12, 2});
        hashMap41.put("105", new Integer[]{0, 1, 12, 0});
        hashMap41.put("108", new Integer[]{8});
        hashMap41.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap41.put(EventClickData.i.C0, new Integer[]{1});
        hashMap41.put(EventClickData.i.B0, new Integer[]{6, 6, 6, 6});
        d.put("SAMSUNG_ONEUI_2@lv2", hashMap41);
        HashMap hashMap42 = new HashMap();
        hashMap42.put("100", new Integer[]{18, 8, 9, 0});
        hashMap42.put(EventClickData.i.w0, new Integer[]{2, 2, 2, 2});
        hashMap42.put("102", new Integer[]{0, 0, 0, 0});
        hashMap42.put(EventClickData.i.z0, new Integer[]{0, 6, 12, 0});
        hashMap42.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap42.put("105", new Integer[]{0, 2, 12, 10});
        hashMap42.put(EventClickData.i.C0, new Integer[]{1});
        hashMap42.put(EventClickData.i.B0, new Integer[]{5, 0, 6, 11});
        hashMap42.put("108", new Integer[]{8});
        hashMap42.put(EventClickData.i.L0, new Integer[]{0, 0, 13, 0});
        d.put("SAMSUNG_EXUI_9@lv1", hashMap42);
        d.put("SAMSUNG_EXUI_9@lv0", hashMap42);
        HashMap hashMap43 = new HashMap();
        hashMap43.put("100", new Integer[]{22, 4, 16, 4});
        hashMap43.put(EventClickData.i.H0, new Integer[]{0, 10, 0, 0});
        hashMap43.put(EventClickData.i.L0, new Integer[]{0, 10, 0, 0});
        hashMap43.put(EventClickData.i.w0, new Integer[]{2, 2, 2, 2});
        hashMap43.put("102", new Integer[]{0, 0, 0, 0});
        hashMap43.put(EventClickData.i.z0, new Integer[]{0, 0, 12, 2});
        hashMap43.put("105", new Integer[]{0, 1, 12, 0});
        hashMap43.put("108", new Integer[]{8});
        hashMap43.put(EventClickData.i.y0, new Integer[]{8, 0, 0, 0});
        hashMap43.put(EventClickData.i.C0, new Integer[]{1});
        hashMap43.put(EventClickData.i.B0, new Integer[]{5, 5, 5, 5});
        d.put("SAMSUNG_EXUI_9@lv2", hashMap43);
        HashMap hashMap44 = new HashMap();
        hashMap44.put("100", new Integer[]{-5, -2, -5, -10});
        hashMap44.put(EventClickData.i.w0, new Integer[]{2, 2, 2, 2});
        hashMap44.put("102", new Integer[]{3, 0, 0, 0});
        hashMap44.put(EventClickData.i.z0, new Integer[]{0, 9, 12, 0});
        hashMap44.put("105", new Integer[]{0, 2, 12, 10});
        hashMap44.put(EventClickData.i.C0, new Integer[]{1});
        hashMap44.put(EventClickData.i.I0, new Integer[]{8});
        hashMap44.put("108", new Integer[]{8});
        hashMap44.put("111", new Integer[]{8});
        hashMap44.put(EventClickData.i.L0, new Integer[]{0, 0, 8, 0});
        hashMap44.put(EventClickData.i.M0, new Integer[]{0});
        d.put("Flyme 8@lv1", hashMap44);
        d.put("Flyme 8@lv0", hashMap44);
        HashMap hashMap45 = new HashMap();
        hashMap45.put("100", new Integer[]{1, 0, 0, -10});
        hashMap45.put(EventClickData.i.I0, new Integer[]{8});
        hashMap45.put("108", new Integer[]{8});
        hashMap45.put("111", new Integer[]{8});
        hashMap45.put(EventClickData.i.C0, new Integer[]{1});
        hashMap45.put(EventClickData.i.M0, new Integer[]{0});
        hashMap45.put("105", new Integer[]{0, 2, 0, 0});
        d.put("Flyme 8@lv2", hashMap45);
        d.put("Flyme 7@lv2", hashMap45);
        HashMap hashMap46 = new HashMap();
        hashMap46.put("100", new Integer[]{12, 10, 0, 0});
        hashMap46.put(EventClickData.i.w0, new Integer[]{0, 0, 0, 0});
        hashMap46.put("102", new Integer[]{0, 0, 0, 0});
        hashMap46.put(EventClickData.i.z0, new Integer[]{0, 9, 3, 0});
        hashMap46.put("105", new Integer[]{0, 0, 3, 10});
        hashMap46.put(EventClickData.i.C0, new Integer[]{1});
        hashMap46.put(EventClickData.i.B0, new Integer[]{2, 4, 9, 7});
        hashMap46.put(EventClickData.i.L0, new Integer[]{0, 4, 15, 0});
        d.put("Hydrogen OS 9@lv1", hashMap46);
        d.put("OXYGEN_9@lv1", hashMap46);
        d.put("ONEPLUS_9@lv1", hashMap46);
        d.put("ONEPLUS_10@lv1", hashMap46);
        d.put("Hydrogen OS 9@lv0", hashMap46);
        d.put("OXYGEN_9@lv0", hashMap46);
        d.put("ONEPLUS_9@lv0", hashMap46);
        d.put("ONEPLUS_10@lv0", hashMap46);
        HashMap hashMap47 = new HashMap();
        hashMap47.put("100", new Integer[]{14, 2, 14, 0});
        hashMap47.put(EventClickData.i.H0, new Integer[]{0, 8, 0, 0});
        hashMap47.put(EventClickData.i.L0, new Integer[]{0, 8, 0, 0});
        hashMap47.put(EventClickData.i.C0, new Integer[]{1});
        hashMap47.put(EventClickData.i.B0, new Integer[]{8, 5, 2, 5});
        hashMap47.put(EventClickData.i.y0, new Integer[]{2, 0, 0, 0});
        d.put("Hydrogen OS 9@lv2", hashMap47);
        d.put("OXYGEN_9@lv2", hashMap47);
        d.put("ONEPLUS_9@lv2", hashMap47);
        d.put("ONEPLUS_10@lv2", hashMap47);
        HashMap hashMap48 = new HashMap();
        hashMap48.put("100", new Integer[]{6, 14, 0, 0});
        hashMap48.put(EventClickData.i.w0, new Integer[]{1, 1, 1, 1});
        hashMap48.put("102", new Integer[]{0, 0, 0, 0});
        hashMap48.put(EventClickData.i.z0, new Integer[]{0, 4, 12, 0});
        hashMap48.put("105", new Integer[]{0, 2, 12, 10});
        hashMap48.put(EventClickData.i.C0, new Integer[]{1});
        hashMap48.put(EventClickData.i.B0, new Integer[]{16, 9, 3, 10});
        hashMap48.put("108", new Integer[]{8});
        hashMap48.put("111", new Integer[]{8});
        hashMap48.put(EventClickData.i.J0, new Integer[]{5});
        hashMap48.put(EventClickData.i.L0, new Integer[]{0, 0, 10, 0});
        d.put("MEIOS_3@lv1", hashMap48);
        d.put("MEIOS_4@lv1", hashMap48);
        d.put("MEIOS_3@lv0", hashMap48);
        d.put("MEIOS_4@lv0", hashMap48);
        HashMap hashMap49 = new HashMap();
        hashMap49.put("100", new Integer[]{10, 4, 10, 10});
        hashMap49.put(EventClickData.i.H0, new Integer[]{0, 12, 0, 0});
        hashMap49.put(EventClickData.i.B0, new Integer[]{20, 10, 0, 10});
        hashMap49.put(EventClickData.i.z0, new Integer[]{0, 0, 0, 0});
        hashMap49.put(EventClickData.i.y0, new Integer[]{2, 0, 0, 0});
        hashMap49.put(EventClickData.i.C0, new Integer[]{1});
        hashMap49.put("108", new Integer[]{8});
        hashMap49.put("111", new Integer[]{8});
        hashMap49.put(EventClickData.i.M0, new Integer[]{0});
        d.put("MEIOS_3@lv2", hashMap49);
        d.put("MEIOS_4@lv2", hashMap49);
        d.put("default@lv0", new HashMap());
        HashMap hashMap50 = new HashMap();
        hashMap50.put(EventClickData.i.w0, new Integer[]{2, 0, 0, 0});
        hashMap50.put("100", new Integer[]{8, 4, 0, 4});
        hashMap50.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        d.put("default@lv1", hashMap50);
        HashMap hashMap51 = new HashMap();
        hashMap51.put(EventClickData.i.w0, new Integer[]{2, 0, 0, 0});
        hashMap51.put("100", new Integer[]{8, 6, 8, 4});
        hashMap51.put(EventClickData.i.y0, new Integer[]{4, 0, 0, 0});
        d.put("default@lv2", hashMap51);
    }

    public static boolean a(Context context, cn.jpush.android.d.d dVar) {
        if (context != null && dVar != null) {
            try {
                if (dVar.C != null && new JSONObject(dVar.C).optInt("in_allow_intercept", 0) == 1) {
                    String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
                    if (Class.forName(messageReceiverClass).getMethod("onSspNotificationWillShow", Context.class, NotificationMessage.class, String.class) == null) {
                        Logger.d("SSPHelper", "not found onSspNotificationShow method");
                        return false;
                    } else if (!TextUtils.isEmpty(messageReceiverClass) && !((JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance()).onSspNotificationWillShow(context, dVar.b(), cn.jpush.android.ac.a.d(context))) {
                        Logger.d("SSPHelper", "user do not show ssp notification");
                        c.a(dVar.c, 1105, context);
                        return false;
                    }
                }
            } catch (Throwable th) {
                Logger.w("SSPHelper", "[isUserSspNotifShow]  error. " + th.getMessage());
            }
        }
        return true;
    }

    public static byte b(Context context) {
        String messageReceiverClass;
        if (context == null) {
            return (byte) 0;
        }
        try {
            messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
        } catch (Throwable th) {
            Logger.w("SSPHelper", "[onCheckSspNotificationState]  error. " + th.getMessage());
        }
        if (Class.forName(messageReceiverClass).getMethod("onCheckSspNotificationState", Context.class, String.class) == null) {
            Logger.d("SSPHelper", "not found onCheckSspNotificationState method");
            return (byte) 0;
        }
        if (!TextUtils.isEmpty(messageReceiverClass)) {
            byte onCheckSspNotificationState = ((JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance()).onCheckSspNotificationState(context, cn.jpush.android.ac.a.d(context));
            Logger.dd("SSPHelper", "check SspNotificationState:" + ((int) onCheckSspNotificationState));
            return onCheckSspNotificationState;
        }
        return (byte) 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0080 A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #0 {all -> 0x0099, blocks: (B:12:0x005f, B:13:0x0063, B:21:0x0080, B:14:0x0068, B:16:0x006e, B:18:0x0078), top: B:31:0x005d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(java.lang.String r6) {
        /*
            r0 = -2
            java.lang.String r1 = "SSPHelper"
            if (r6 == 0) goto Laf
            java.lang.String r2 = r6.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L11
            goto Laf
        L11:
            java.lang.String r2 = "Funtouch"
            java.lang.String r3 = ""
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r2 = "OS_"
            java.lang.String r6 = r6.replace(r2, r3)
            java.lang.String r6 = r6.trim()
            java.lang.String r2 = "3.1"
            boolean r2 = r6.startsWith(r2)
            r3 = -1
            if (r2 == 0) goto L2d
            return r3
        L2d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "replaceVivoVersion:"
            r2.append(r4)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            cn.jpush.android.helper.Logger.d(r1, r2)
            java.lang.String r2 = "."
            int r2 = r6.indexOf(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "strStartIndex:"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            cn.jpush.android.helper.Logger.d(r1, r4)
            r4 = 0
            if (r2 >= 0) goto L68
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L99
        L63:
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> L99
            goto L7e
        L68:
            java.lang.String r6 = r6.substring(r4, r2)     // Catch: java.lang.Throwable -> L99
            if (r6 == 0) goto L7d
            java.lang.String r2 = r6.trim()     // Catch: java.lang.Throwable -> L99
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L99
            if (r2 != 0) goto L7d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L99
            goto L63
        L7d:
            r6 = -1
        L7e:
            if (r6 == r3) goto Lae
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r2.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r5 = "firstVersion:"
            r2.append(r5)     // Catch: java.lang.Throwable -> L99
            r2.append(r6)     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L99
            cn.jpush.android.helper.Logger.e(r1, r2)     // Catch: java.lang.Throwable -> L99
            r0 = 3
            if (r6 > r0) goto L98
            return r3
        L98:
            return r4
        L99:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[getVivoNotificationStyle] parse vivo version failed:"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            cn.jpush.android.helper.Logger.e(r1, r6)
        Lae:
            return r0
        Laf:
            java.lang.String r6 = "vivo rom version was empty"
            cn.jpush.android.helper.Logger.d(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.helper.i.b(java.lang.String):int");
    }

    public static void b(Context context, cn.jpush.android.d.d dVar) {
        try {
            String str = dVar.t;
            String str2 = dVar.v;
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = dVar.d;
            String d2 = cn.jpush.android.ac.a.d(str + str2);
            Logger.d("SSPHelper", "ssp contentMd5: " + d2 + "; notificationId: " + i2 + ", currentTime: " + currentTimeMillis);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            cn.jpush.android.cache.a.i(context, i2 + "," + d2 + "," + currentTimeMillis);
        } catch (Throwable th) {
            Logger.w("SSPHelper", "setLatestSSPInfo failed, " + th.getMessage());
        }
    }

    public static boolean b() {
        String a2 = h.a();
        return (a2 == null || !(a2.startsWith("MIUI") || a2.startsWith("Flyme") || a2.startsWith("MEIOS"))) && Build.VERSION.SDK_INT >= 28;
    }

    private static String c(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            Logger.i("SSPHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            Logger.e("SSPHelper", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f A[Catch: all -> 0x007b, TRY_ENTER, TryCatch #2 {all -> 0x007b, blocks: (B:3:0x0004, B:12:0x002f, B:14:0x0033, B:15:0x0035, B:19:0x003d, B:21:0x0043, B:22:0x0044), top: B:32:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:3:0x0004, B:12:0x002f, B:14:0x0033, B:15:0x0035, B:19:0x003d, B:21:0x0043, B:22:0x0044), top: B:32:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:3:0x0004, B:12:0x002f, B:14:0x0033, B:15:0x0035, B:19:0x003d, B:21:0x0043, B:22:0x0044), top: B:32:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r12) {
        /*
            java.lang.String r0 = ","
            java.lang.String r1 = "SSPHelper"
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r4 = cn.jpush.android.cache.a.o(r12)     // Catch: java.lang.Throwable -> L7b
            r5 = 0
            r7 = 1
            r8 = 0
            java.lang.String[] r4 = r4.split(r0)     // Catch: java.lang.Throwable -> L29
            r9 = r4[r8]     // Catch: java.lang.Throwable -> L29
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L29
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L29
            r4 = r4[r7]     // Catch: java.lang.Throwable -> L2a
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L2a
            long r10 = r4.longValue()     // Catch: java.lang.Throwable -> L2a
            goto L2b
        L29:
            r9 = 0
        L2a:
            r10 = r5
        L2b:
            int r4 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r4 != 0) goto L31
            long r10 = cn.jpush.android.helper.i.g     // Catch: java.lang.Throwable -> L7b
        L31:
            if (r9 != 0) goto L35
            int r9 = cn.jpush.android.helper.i.h     // Catch: java.lang.Throwable -> L7b
        L35:
            boolean r4 = cn.jpush.android.ac.b.a(r2, r10)     // Catch: java.lang.Throwable -> L7b
            if (r4 != 0) goto L3c
            goto L3d
        L3c:
            r8 = r9
        L3d:
            boolean r4 = cn.jpush.android.ac.b.a(r2, r10)     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L44
            int r7 = r7 + r8
        L44:
            cn.jpush.android.helper.i.g = r2     // Catch: java.lang.Throwable -> L7b
            cn.jpush.android.helper.i.h = r7     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b
            r4.<init>()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = "setSSPState sspCount:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L7b
            r4.append(r7)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r5 = ",sspTime:"
            r4.append(r5)     // Catch: java.lang.Throwable -> L7b
            r4.append(r2)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L7b
            cn.jpush.android.helper.Logger.d(r1, r4)     // Catch: java.lang.Throwable -> L7b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7b
            r4.<init>()     // Catch: java.lang.Throwable -> L7b
            r4.append(r7)     // Catch: java.lang.Throwable -> L7b
            r4.append(r0)     // Catch: java.lang.Throwable -> L7b
            r4.append(r2)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L7b
            cn.jpush.android.cache.a.g(r12, r0)     // Catch: java.lang.Throwable -> L7b
            goto L95
        L7b:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "setSSPState error:"
            r0.append(r2)
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            cn.jpush.android.helper.Logger.w(r1, r12)
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.helper.i.c(android.content.Context):void");
    }

    public static boolean c() {
        String a2 = h.a();
        if (a2 != null) {
            return (a2.startsWith("MIUI") || a2.startsWith("Flyme") || a2.startsWith("MEIOS")) ? false : true;
        }
        return true;
    }

    public static boolean d() {
        String a2 = h.a();
        if (a2 != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 == 26 || i2 == 27) {
                return (a2.startsWith("OPPO_V5") || a2.startsWith("Funtouch OS_4")) ? false : true;
            }
            return true;
        }
        return true;
    }

    public static boolean e() {
        List<String> list;
        int i2;
        List<String> list2;
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str) && (list2 = a) != null && !list2.isEmpty()) {
                for (String str2 : a) {
                    if (str2.toLowerCase().equals(str.toLowerCase())) {
                        Logger.d("SSPHelper", "black manufacturer:" + str);
                        return true;
                    }
                }
            }
            if (str.toLowerCase().equals("nubia") && (i2 = Build.VERSION.SDK_INT) < 23) {
                Logger.d("SSPHelper", "black manufacturer:" + str + ",black android version:" + i2);
                return true;
            }
        } catch (Throwable th) {
            Logger.d("SSPHelper", "manufacturer fiflter failed:" + th.getMessage());
        }
        try {
            String str3 = Build.MODEL;
            if (!TextUtils.isEmpty(str3) && (list = b) != null && !list.isEmpty()) {
                for (String str4 : b) {
                    if (str4.toLowerCase().equals(str3.toLowerCase())) {
                        Logger.d("SSPHelper", "black model:" + str3);
                        return true;
                    }
                }
            }
        } catch (Throwable th2) {
            Logger.d("SSPHelper", "model fiflter failed:" + th2.getMessage());
        }
        String i3 = i();
        if (TextUtils.isEmpty(i3) || !i3.startsWith("EmotionUI_4.0")) {
            return false;
        }
        Logger.d("SSPHelper", "emuiVersion is in black:" + i3);
        return true;
    }

    public static boolean f() {
        try {
            String j2 = j();
            Logger.d("SSPHelper", "vivoVersion:" + j2);
            if (!Build.MANUFACTURER.equalsIgnoreCase("vivo") && !j2.startsWith("Funtouch")) {
                String c2 = c("ro.iqoo.os.build.display.id");
                Logger.d("SSPHelper", "iqooMonsterUI:" + c2);
                if (c2 == null) {
                    return false;
                }
                if (TextUtils.isEmpty(c2.trim())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int g() {
        int a2;
        StringBuilder sb;
        String str;
        Map<String, Integer> map;
        Map<String, Integer> map2;
        try {
            String str2 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str2) && (map2 = c) != null && !map2.isEmpty() && c.containsKey(str2.toLowerCase())) {
                Logger.d("SSPHelper", "found notify style by manufacturer:" + str2);
                return c.get(str2.toLowerCase()).intValue();
            }
        } catch (Throwable th) {
            Logger.d("SSPHelper", "manufacturer fiflter failed:" + th.getMessage());
        }
        try {
            String str3 = Build.MODEL;
            if (!TextUtils.isEmpty(str3) && (map = e) != null && !map.isEmpty() && e.containsKey(str3.toLowerCase())) {
                Logger.d("SSPHelper", "found notify style by model:" + str3);
                return e.get(str3.toLowerCase()).intValue();
            }
        } catch (Throwable th2) {
            Logger.d("SSPHelper", "model fiflter failed:" + th2.getMessage());
        }
        String k2 = k();
        if (!TextUtils.isEmpty(k2) && (k2.startsWith("V3.0") || k2.startsWith("V2."))) {
            Logger.d("SSPHelper", "oppo V2.X/V3.0 version use left-right notify style :" + k2);
            return -1;
        }
        String j2 = j();
        if (TextUtils.isEmpty(j2) || (a2 = b(j2)) == -2) {
            String b2 = h.b();
            if (TextUtils.isEmpty(b2)) {
                return 0;
            }
            Logger.d("SSPHelper", "flymeVersion notify style :" + b2);
            a2 = a(b2);
            if (a2 == -2) {
                return 0;
            }
            sb = new StringBuilder();
            str = "meizuNotificationStyle notify style :";
        } else {
            sb = new StringBuilder();
            str = "vivoNotificationStyle notify style :";
        }
        sb.append(str);
        sb.append(a2);
        Logger.d("SSPHelper", sb.toString());
        return a2;
    }

    public static boolean h() {
        List<String> list;
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str) && (list = f) != null && !list.isEmpty()) {
                for (String str2 : f) {
                    if (str2.toLowerCase().equals(str.toLowerCase())) {
                        Logger.d("SSPHelper", "one line manufacturer:" + str);
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            Logger.d("SSPHelper", "manufacturer fiflter failed:" + th.getMessage());
        }
        String k2 = k();
        if (TextUtils.isEmpty(k2)) {
            return false;
        }
        if (k2.startsWith("V3.2") || k2.startsWith("V3.1")) {
            Logger.d("SSPHelper", "oppo V3.1/V3.2 version use one line  qnotify style :" + k2);
            return true;
        }
        return false;
    }

    private static String i() {
        if (TextUtils.isEmpty(i)) {
            String c2 = c("ro.build.version.emui");
            i = c2;
            return c2;
        }
        return i;
    }

    private static String j() {
        if (TextUtils.isEmpty(k)) {
            String c2 = c("ro.vivo.os.build.display.id");
            k = c2;
            return c2;
        }
        return k;
    }

    private static String k() {
        if (TextUtils.isEmpty(j)) {
            String c2 = c("ro.build.version.opporom");
            j = c2;
            return c2;
        }
        return j;
    }
}
