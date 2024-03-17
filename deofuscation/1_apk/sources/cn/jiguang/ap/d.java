package cn.jiguang.ap;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    public static List<cn.jiguang.ao.c> a(String str, String str2, String str3, int i) {
        List<cn.jiguang.ao.c> list;
        cn.jiguang.ao.c cVar = new cn.jiguang.ao.c();
        cVar.a = str2;
        cVar.b = str3;
        if (str == null || TextUtils.isEmpty(str)) {
            list = null;
        } else {
            list = c.a(str);
            cn.jiguang.ak.a.a("JWakePackageHelper", "cache cmd wakeTargets:" + list);
        }
        if (list != null && !list.isEmpty()) {
            int size = list.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (list.get(size).a.equals(str2) && list.get(size).b.equals(str3)) {
                        list.remove(size);
                        break;
                    }
                    size--;
                } else {
                    break;
                }
            }
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (i == 1) {
            list.add(cVar);
        }
        return list;
    }
}
