package cn.jiguang.ap;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.service.DownloadProvider;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.hunantv.oversea.channel.dynamic.data.ParamParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public static Bundle a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putString(str, hashMap.get(str));
        }
        return bundle;
    }

    public static cn.jiguang.ao.c a(Context context, String str) {
        try {
            return new cn.jiguang.ao.c(str, "", context.getPackageManager().getApplicationInfo(str, 0).targetSdkVersion);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeHelper", "getWakeTarget throwable:" + th.getMessage());
            return null;
        }
    }

    public static String a(List<cn.jiguang.ao.c> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).a;
            String str2 = list.get(i).b;
            sb.append(str);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb.append(str2);
            sb.append(ParamParser.m);
        }
        return sb.toString();
    }

    public static HashMap<String, cn.jiguang.ao.c> a(Context context) {
        cn.jiguang.ao.c a;
        try {
            HashMap<String, cn.jiguang.ao.c> hashMap = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DaemonService");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                for (int i = 0; i < queryIntentServices.size(); i++) {
                    ServiceInfo serviceInfo = queryIntentServices.get(i).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && serviceInfo.exported && serviceInfo.enabled && !context.getPackageName().equals(str2) && (a = a.a(context, packageManager, str2, str)) != null) {
                        cn.jiguang.ak.a.a("JWakeHelper", "wakeTarget:" + a.toString());
                        hashMap.put(a.a, a);
                    }
                }
                return hashMap;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeHelper", "getWakeTargetMap throwable:" + th.getMessage());
            return null;
        }
    }

    public static HashMap<String, cn.jiguang.ao.c> a(Context context, HashMap<String, cn.jiguang.ao.c> hashMap) {
        try {
            HashMap<String, cn.jiguang.ao.c> hashMap2 = new HashMap<>();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.PushService");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() != 0) {
                for (int i = 0; i < queryIntentServices.size(); i++) {
                    ServiceInfo serviceInfo = queryIntentServices.get(i).serviceInfo;
                    String str = serviceInfo.name;
                    String str2 = serviceInfo.packageName;
                    if (str != null && str2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && ((hashMap == null || !hashMap.containsKey(str2)) && !context.getPackageName().equals(str2))) {
                        int checkPermission = packageManager.checkPermission(str2 + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, str2);
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, 128);
                        if (applicationInfo != null && applicationInfo.metaData != null) {
                            String b = cn.jiguang.n.d.b(context);
                            if (checkPermission == 0 && !TextUtils.isEmpty(b) && b.length() == 24 && !context.getPackageName().equals(applicationInfo.packageName)) {
                                cn.jiguang.ao.c cVar = new cn.jiguang.ao.c(str2, "", applicationInfo.targetSdkVersion);
                                ComponentInfo a = cn.jiguang.n.d.a(context, str2, (Class<?>) DownloadProvider.class);
                                if (a instanceof ProviderInfo) {
                                    ProviderInfo providerInfo = (ProviderInfo) a;
                                    if (providerInfo.exported && providerInfo.enabled && providerInfo.authority != null) {
                                        if (TextUtils.equals(str2 + ".DownloadProvider", providerInfo.authority)) {
                                            cVar.d = providerInfo.authority;
                                        }
                                    }
                                }
                                hashMap2.put(cVar.a, cVar);
                            }
                        }
                    }
                }
                cn.jiguang.ak.a.a("JWakeHelper", "getWakeAppListWithoutDService:" + hashMap2.toString());
                return hashMap2;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeHelper", "getWakeAppListWithoutDService throwable:" + th.getMessage());
            return null;
        }
    }

    public static List<cn.jiguang.ao.c> a(Context context, List<cn.jiguang.ao.c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                list.get(i).c = context.getPackageManager().getApplicationInfo(list.get(i).a, 128).targetSdkVersion;
            } catch (Throwable unused) {
            }
        }
        return list;
    }

    public static List<String> a(cn.jiguang.ao.a aVar, List<String> list) {
        return aVar == null ? list : c(aVar, b(aVar, list));
    }

    public static List<cn.jiguang.ao.c> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\$");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            String[] split2 = str2.split("\\|");
            String str3 = split2[0];
            String str4 = split2[1];
            cn.jiguang.ao.c cVar = new cn.jiguang.ao.c();
            cVar.a = str3;
            cVar.b = str4;
            cVar.i = 1;
            cVar.g = 4;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private static List<String> a(List<String> list, List<String> list2) {
        return a(list, list2, false);
    }

    private static List<String> a(List<String> list, List<String> list2, boolean z) {
        if (list == null || list.size() == 0) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list2) {
            if (list.contains(str)) {
                if (z) {
                    cn.jiguang.ak.a.a("JWakeHelper", str + " in the white list");
                    arrayList.add(str);
                } else {
                    cn.jiguang.ak.a.a("JWakeHelper", str + " in the black list");
                }
            }
            if (!z) {
                cn.jiguang.ak.a.a("JWakeHelper", str + " not in the global black list");
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private static JSONArray a(Context context, JSONArray jSONArray) {
        int i;
        Integer valueOf;
        int i2;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() <= 0) {
                    return jSONArray;
                }
                HashMap hashMap = new HashMap();
                int i3 = 0;
                while (true) {
                    i = 1;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    String optString = jSONObject.optString("type");
                    if ("aa3".equals(optString)) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("target");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            break;
                        }
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                            String optString2 = optJSONObject.optString("package");
                            JSONArray jSONArray2 = optJSONObject.getJSONArray("data");
                            if (jSONArray2 != null) {
                                for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i5);
                                    if (jSONObject2 != null) {
                                        int i6 = jSONObject2.getInt("wake_type");
                                        int i7 = jSONObject2.getInt("wake_status");
                                        if (hashMap.containsKey(optString2)) {
                                            Map map = (Map) hashMap.get(optString2);
                                            if (map.containsKey(Integer.valueOf(i6))) {
                                                Map map2 = (Map) map.get(Integer.valueOf(i6));
                                                if (map2.containsKey(Integer.valueOf(i7))) {
                                                    valueOf = Integer.valueOf(i7);
                                                    i2 = Integer.valueOf(((Integer) map2.get(Integer.valueOf(i7))).intValue() + 1);
                                                } else {
                                                    valueOf = Integer.valueOf(i7);
                                                    i2 = 1;
                                                }
                                                map2.put(valueOf, i2);
                                                map.put(Integer.valueOf(i6), map2);
                                            } else {
                                                HashMap hashMap2 = new HashMap();
                                                hashMap2.put(Integer.valueOf(i7), 1);
                                                map.put(Integer.valueOf(i6), hashMap2);
                                            }
                                            hashMap.put(optString2, map);
                                        } else {
                                            HashMap hashMap3 = new HashMap();
                                            hashMap3.put(Integer.valueOf(i7), 1);
                                            HashMap hashMap4 = new HashMap();
                                            hashMap4.put(Integer.valueOf(i6), hashMap3);
                                            hashMap.put(optString2, hashMap4);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        cn.jiguang.ak.a.d("JWakeHelper", "unkown type :" + optString);
                    }
                    i3++;
                }
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                Iterator it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("p", entry.getKey());
                    JSONArray jSONArray5 = new JSONArray();
                    Iterator it2 = ((Map) entry.getValue()).entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it2.next();
                        Integer num = (Integer) entry2.getKey();
                        Map map3 = (Map) entry2.getValue();
                        int intValue = map3.containsKey(Integer.valueOf(i)) ? ((Integer) map3.get(Integer.valueOf(i))).intValue() : 0;
                        int intValue2 = map3.containsKey(101) ? ((Integer) map3.get(101)).intValue() : 0;
                        Iterator it3 = it;
                        int intValue3 = map3.containsKey(102) ? ((Integer) map3.get(102)).intValue() : 0;
                        Iterator it4 = it2;
                        int intValue4 = map3.containsKey(103) ? ((Integer) map3.get(103)).intValue() : 0;
                        jSONArray5.put(num + "_" + (intValue + intValue2 + intValue3 + intValue4) + "_" + intValue + "_" + intValue2 + "_" + intValue3 + "_" + intValue4);
                        it = it3;
                        it2 = it4;
                        i = 1;
                    }
                    jSONObject3.put("d", jSONArray5);
                    jSONArray4.put(jSONObject3);
                    it = it;
                    i = 1;
                }
                if (jSONArray4.length() > 0) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("t", jSONArray4);
                    jSONObject4.put("itime", cn.jiguang.n.d.h(context));
                    jSONObject4.put("type", "aa3");
                    jSONArray3.put(jSONObject4);
                }
                return jSONArray3.length() > 0 ? jSONArray3 : jSONArray;
            } catch (Throwable th) {
                cn.jiguang.ak.a.e("JWakeHelper", "merge wake json failed:" + th.getMessage());
                return null;
            }
        }
        return jSONArray;
    }

    public static void a(Context context, cn.jiguang.ao.a aVar, List<cn.jiguang.ao.b> list) {
        if (!aVar.t) {
            cn.jiguang.ak.a.d("JWakeHelper", "server set do not report wake data,give up save");
            return;
        }
        JSONObject b = b(list);
        cn.jiguang.ak.a.a("JWakeHelper", "wake json:" + b);
        a(context, b);
    }

    private static void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            cn.jiguang.ak.a.a("JWakeHelper", "save wake data : " + jSONObject.toString());
            jSONObject.put("itime", cn.jiguang.n.d.h(context));
            jSONObject.put("type", "aa3");
            synchronized ("wake_cache_v2.json") {
                JSONObject a = cn.jiguang.r.c.a(context, "wake_cache_v2.json");
                if (a == null) {
                    a = new JSONObject();
                }
                JSONArray optJSONArray = a.optJSONArray("content");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject);
                a.put("content", optJSONArray);
                cn.jiguang.r.c.a(context, "wake_cache_v2.json", a);
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JWakeHelper", "saveWakeData failed:" + th.getMessage());
        }
    }

    public static String b(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        for (String str : hashMap.keySet()) {
            builder.appendQueryParameter(str, hashMap.get(str));
        }
        return builder.toString();
    }

    private static List<String> b(cn.jiguang.ao.a aVar, List<String> list) {
        if (TextUtils.isEmpty(aVar.n) || aVar.n.equals("disable")) {
            return list;
        }
        List<String> list2 = aVar.o;
        String str = aVar.n;
        str.hashCode();
        return !str.equals("exclude") ? !str.equals("include") ? list : b(list2, list) : a(list2, list);
    }

    private static List<String> b(List<String> list, List<String> list2) {
        return a(list, list2, true);
    }

    public static JSONArray b(Context context) {
        JSONObject a;
        synchronized ("wake_cache_v2.json") {
            a = cn.jiguang.r.c.a(context, "wake_cache_v2.json");
        }
        if (a == null) {
            a = new JSONObject();
        }
        JSONArray optJSONArray = a.optJSONArray("content");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            cn.jiguang.ak.a.a("JWakeHelper", "no save data");
            return null;
        }
        return a(context, optJSONArray);
    }

    private static JSONObject b(List<cn.jiguang.ao.b> list) {
        if (list == null || list.size() == 0) {
            cn.jiguang.ak.a.a("JWakeHelper", "wakeUpResult is empty, no need report");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.ao.b bVar : list) {
            try {
                HashMap<Integer, Integer> hashMap = bVar.b;
                if (hashMap != null && !hashMap.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("package", bVar.a);
                    JSONArray jSONArray2 = new JSONArray();
                    HashMap<Integer, Integer> hashMap2 = bVar.b;
                    for (Integer num : hashMap2.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("wake_type", num);
                        jSONObject2.put("wake_status", hashMap2.get(num));
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("package", bVar.a);
                    jSONObject.put("data", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            } catch (Throwable th) {
                cn.jiguang.ak.a.f("JWakeHelper", "formatReportData:" + th);
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("target", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject3;
    }

    private static List<String> c(cn.jiguang.ao.a aVar, List<String> list) {
        return a(aVar.p, list);
    }

    public static void c(Context context) {
        synchronized ("wake_cache_v2.json") {
            cn.jiguang.r.c.a(context, "wake_cache_v2.json", (String) null);
        }
    }
}
