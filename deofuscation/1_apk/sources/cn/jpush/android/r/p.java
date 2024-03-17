package cn.jpush.android.r;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.facebook.common.util.ByteConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class p {
    public static ArrayList<String> a(ArrayList<String> arrayList, Context context, String str, String str2) {
        return a(arrayList, context, str, str2, true);
    }

    public static ArrayList<String> a(ArrayList<String> arrayList, Context context, String str, String str2, boolean z) {
        String str3;
        ArrayList<String> arrayList2 = new ArrayList<>();
        Logger.v("InAppTemplateHelper", "action:loadH5TemplateImageResources - urlPrefix:" + str);
        boolean z2 = false;
        try {
            boolean z3 = true;
            if (!cn.jpush.android.ac.a.c(str) || context == null || arrayList.size() <= 0 || TextUtils.isEmpty(str2)) {
                z2 = true;
            } else {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (TextUtils.isEmpty(next) || next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                        str3 = next;
                    } else {
                        str3 = str + next;
                    }
                    byte[] a = cn.jpush.android.w.a.a(str3, 3, (int) ByteConstants.MB);
                    if (a != null) {
                        Logger.d("InAppTemplateHelper", "download image resource success, path: " + next);
                        if (next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                            next = cn.jpush.android.ac.c.b(next);
                        }
                        String str4 = cn.jpush.android.ac.c.a(context, "h5_tpl_imgs", 0, z) + next;
                        boolean a2 = cn.jpush.android.ac.c.a(str4, a);
                        if (a2) {
                            arrayList2.add(str4);
                            Logger.d("InAppTemplateHelper", "download image resource cache to local success, path: " + str4);
                        }
                        Logger.v("InAppTemplateHelper", "Succeed to load image - " + str4 + ", cache local status: " + a2);
                    } else {
                        Logger.w("InAppTemplateHelper", "download image resource failed, path: " + str3);
                        z3 = false;
                    }
                }
                Logger.i("InAppTemplateHelper", "template image resource download completed. local image list: " + arrayList2.toString());
                z2 = z3;
            }
        } catch (Throwable th) {
            Logger.w("InAppTemplateHelper", "load h5 template image resource failed, " + th.getMessage());
        }
        if (z2) {
            return arrayList2;
        }
        return null;
    }

    public static LinkedHashMap<String, cn.jpush.android.u.f> a(Context context) {
        LinkedHashMap<String, cn.jpush.android.u.f> linkedHashMap = new LinkedHashMap<>();
        if (context == null) {
            Logger.w("InAppTemplateHelper", "unexcepted , context is null");
            return linkedHashMap;
        }
        FileInputStream fileInputStream = null;
        try {
            File a = cn.jpush.android.ac.c.a(context, "tpl.cfg.cache");
            if (a != null && a.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(a);
                try {
                    JSONObject jSONObject = new JSONObject(new String(cn.jpush.android.ac.i.a((InputStream) fileInputStream2)));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jpush.android.u.f a2 = cn.jpush.android.u.f.a(jSONObject.getJSONObject(keys.next()));
                        if (a2 != null) {
                            linkedHashMap.put(a2.a, a2);
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        Logger.w("InAppTemplateHelper", "load objects error:" + th.getMessage());
                        return linkedHashMap;
                    } finally {
                        cn.jpush.android.ac.i.a((Closeable) fileInputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static LinkedHashMap<String, cn.jpush.android.u.f> a(LinkedHashMap<String, cn.jpush.android.u.f> linkedHashMap) {
        LinkedHashMap<String, cn.jpush.android.u.f> linkedHashMap2 = new LinkedHashMap<>();
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(linkedHashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, cn.jpush.android.u.f>>() { // from class: cn.jpush.android.r.p.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(Map.Entry<String, cn.jpush.android.u.f> entry, Map.Entry<String, cn.jpush.android.u.f> entry2) {
                    if (entry2.getValue().c > entry.getValue().c) {
                        return 1;
                    }
                    return entry2.getValue().c < entry.getValue().c ? -1 : 0;
                }
            });
            for (Map.Entry entry : arrayList) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            Logger.w("InAppTemplateHelper", "sort template file map filed. error: " + th.getMessage());
        }
        return linkedHashMap2;
    }

    public static void a(Context context, LinkedHashMap<String, cn.jpush.android.u.f> linkedHashMap) {
        try {
            File a = cn.jpush.android.ac.c.a(context, "tpl.cfg.cache");
            if (a != null) {
                JSONObject jSONObject = new JSONObject();
                if (linkedHashMap.size() > 20) {
                    linkedHashMap = a(linkedHashMap);
                }
                int i = 0;
                for (Map.Entry<String, cn.jpush.android.u.f> entry : linkedHashMap.entrySet()) {
                    cn.jpush.android.u.f value = entry.getValue();
                    if (i < 20) {
                        jSONObject.put(entry.getKey(), value.a());
                    } else {
                        String str = value.b;
                        File file = new File(str);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                            Logger.d("InAppTemplateHelper", "exceed max template cache count, delete old template file: " + str + ", maxCacheCount: 20");
                        }
                    }
                    i++;
                }
                Logger.d("InAppTemplateHelper", "[saveTemplateConfig] template config info: " + jSONObject.toString() + ", templateSize: " + linkedHashMap.values().size());
                cn.jpush.android.ac.c.a(a.getAbsolutePath(), jSONObject.toString());
            }
        } catch (Throwable th) {
            Logger.w("InAppTemplateHelper", "save template config to file failed. error: " + th.getMessage());
        }
    }
}
