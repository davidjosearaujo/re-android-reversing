package cn.jiguang.as;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.f.c;
import cn.jiguang.internal.ActionManager;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static String a;
    private static String b;
    private static ConcurrentHashMap<File, Boolean> c = new ConcurrentHashMap<>();
    private static final AtomicBoolean d = new AtomicBoolean(false);

    public static File a(Context context, String str) {
        return new File(e(context) + str + File.separator + UUID.randomUUID().toString());
    }

    public static File a(Context context, String str, JSONObject jSONObject, boolean z) {
        File a2 = a(context, str);
        if (z) {
            b(a2);
        }
        cn.jiguang.f.c.b(a2, jSONObject.toString());
        return a2;
    }

    public static FileFilter a() {
        return new FileFilter() { // from class: cn.jiguang.as.d.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return (file.getName().length() == 24 || file.getName().equals("0")) ? false : true;
            }
        };
    }

    public static void a(Context context) {
        c.a aVar = new c.a(false, true, "jpush_stat_history", 1);
        String e = cn.jiguang.d.a.e(context);
        File[] a2 = cn.jiguang.f.c.a(context.getFilesDir(), aVar, a());
        if (a2 != null) {
            for (File file : a2) {
                try {
                    cn.jiguang.f.c.e(new File(file, "nowrap"));
                    StringBuilder sb = new StringBuilder();
                    sb.append(file.getParent());
                    String str = File.separator;
                    sb.append(str);
                    sb.append(e);
                    sb.append(str);
                    sb.append(file.getName());
                    File file2 = new File(sb.toString());
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    file.renameTo(file2);
                } catch (Throwable th) {
                    cn.jiguang.ar.c.c("updateByAppKey", "e=" + th);
                }
            }
        }
    }

    private static void a(Context context, File file) {
        if (((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue() == 0) {
            cn.jiguang.ar.c.c("ReportHistory", "can't get uid, skip upload history");
            return;
        }
        File[] a2 = cn.jiguang.f.c.a(file, c.a.a);
        if (a2 == null || a2.length == 0) {
            return;
        }
        LinkedList<File> linkedList = new LinkedList();
        for (File file2 : a2) {
            if (!Boolean.TRUE.equals(c.get(file2))) {
                linkedList.add(file2);
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        cn.jiguang.ar.c.c("ReportHistory", "process space=" + e(file) + " history[" + linkedList.size() + "]");
        Collections.sort(linkedList, new Comparator<File>() { // from class: cn.jiguang.as.d.4
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file3, File file4) {
                long lastModified = file3.lastModified() - file4.lastModified();
                if (lastModified < 0) {
                    return 1;
                }
                return lastModified == 0 ? 0 : -1;
            }
        });
        for (File file3 : linkedList) {
            try {
                JSONObject a3 = c.a(file3);
                if (a3 == null) {
                    cn.jiguang.f.c.a(file3);
                } else {
                    b(file3);
                    Set<String> a4 = f.a(a3);
                    cn.jiguang.ar.c.c("ReportHistory", "report history types=" + a4);
                    if (f.a(context, a4, a3, file3, null) == -2) {
                        return;
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.ar.c.g("ReportHistory", "upload e:" + th);
            }
        }
    }

    public static void a(Context context, String... strArr) {
        FileFilter[] fileFilterArr;
        if (strArr == null || strArr.length == 0) {
            fileFilterArr = new FileFilter[1];
        } else {
            fileFilterArr = new FileFilter[strArr.length + 1];
            int i = 0;
            while (i < strArr.length) {
                int i2 = i + 1;
                fileFilterArr[i2] = c.a.a(strArr[i]);
                i = i2;
            }
        }
        fileFilterArr[0] = new c.a(false, true, "jpush_stat_history", 1);
        File[] a2 = cn.jiguang.f.c.a(context.getFilesDir(), fileFilterArr);
        if (a2 != null) {
            for (File file : a2) {
                cn.jiguang.f.c.e(file);
            }
        }
    }

    public static void a(File file) {
        if (file != null) {
            c.remove(file);
        }
    }

    private static Set<String> b() {
        HashSet hashSet = new HashSet();
        hashSet.add(CommonConstant.KEY_UID);
        hashSet.add(com.alipay.sdk.cons.b.h);
        hashSet.add(HiAnalyticsConstant.BI_KEY_SDK_VER);
        hashSet.add("channel");
        hashSet.add("app_version");
        JSONObject jSONObject = new JSONObject();
        ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    public static void b(final Context context) {
        cn.jiguang.be.b bVar;
        String str;
        if (d.get()) {
            cn.jiguang.ar.c.c("ReportHistory", "isRunning, no need report");
            return;
        }
        if (TextUtils.isEmpty(cn.jiguang.aq.d.b(context)) || !context.getPackageName().equals(cn.jiguang.f.a.a(context))) {
            bVar = new cn.jiguang.be.b("ReportHistory#submitReportAll") { // from class: cn.jiguang.as.d.3
                @Override // cn.jiguang.be.b
                public void a() {
                    d.f(context);
                }
            };
            str = "NORMAL_TASK";
        } else {
            bVar = new cn.jiguang.be.b("ReportHistory#submitReportAll") { // from class: cn.jiguang.as.d.2
                @Override // cn.jiguang.be.b
                public void a() {
                    d.f(context);
                }
            };
            str = "MAJOR_TASK";
        }
        cn.jiguang.be.d.a(str, bVar);
    }

    private static void b(Context context, File file) {
        try {
            JSONObject a2 = f.a(context);
            if (cn.jiguang.f.d.c(a2)) {
                return;
            }
            File[] a3 = cn.jiguang.f.c.a(new File(file, "nowrap"), c.a.a);
            if (a3 != null && a3.length != 0) {
                cn.jiguang.ar.c.c("ReportHistory", "process space=" + e(file) + " nowrap[" + a3.length + "]");
                File file2 = new File(file, "tmp");
                c a4 = c.a(a3[0], a2);
                for (int i = 1; i < a3.length; i++) {
                    c a5 = c.a(a3[i], a2);
                    if (a5 != null) {
                        if (a4 != null && a4.a(a5, file2)) {
                        }
                        a4 = a5;
                    }
                }
                if (a4 != null) {
                    a4.a((c) null, file2);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("ReportHistory", "processNowrap e:" + th);
        }
    }

    private static void b(File file) {
        if (file != null) {
            c.put(file, Boolean.TRUE);
        }
    }

    private static void c(Context context, File file) {
        cn.jiguang.ar.c.c("ReportHistory", "upload space=" + e(file));
        b(context, file);
        d(file);
        a(context, file);
        c(file);
    }

    private static void c(File file) {
        int i = 0;
        File[] a2 = cn.jiguang.f.c.a(file, c.a.a);
        if (a2 == null || a2.length <= 1) {
            return;
        }
        List<File> asList = Arrays.asList(a2);
        Collections.sort(asList, new Comparator<File>() { // from class: cn.jiguang.as.d.5
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file2, File file3) {
                long lastModified = file2.lastModified() - file3.lastModified();
                if (lastModified < 0) {
                    return 1;
                }
                return lastModified == 0 ? 0 : -1;
            }
        });
        for (File file2 : asList) {
            i = (int) (i + file2.length());
            if (i > 1048576) {
                cn.jiguang.f.c.a(file2);
            }
        }
        if (asList.size() < a2.length) {
            cn.jiguang.ar.c.c("ReportHistory", "trim space history=" + e(file) + "," + a2.length + " to " + asList.size());
        }
    }

    private static synchronized String d(Context context) {
        String str;
        String replaceFirst;
        synchronized (d.class) {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            if (a == null) {
                String a2 = cn.jiguang.f.a.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    if (a2.equals(context.getPackageName())) {
                        replaceFirst = "";
                    } else {
                        replaceFirst = a2.replaceFirst(context.getPackageName() + CertificateUtil.DELIMITER, "_");
                    }
                    a = replaceFirst;
                }
            }
            if (a != null) {
                str = "jpush_stat_history" + a;
            } else {
                str = "jpush_stat_history";
            }
            File a3 = cn.jiguang.f.c.a(context, str);
            if (a3 != null) {
                String absolutePath = a3.getAbsolutePath();
                b = absolutePath;
                return absolutePath;
            }
            return "jpush_stat_history" + a;
        }
    }

    private static void d(File file) {
        try {
            File[] a2 = cn.jiguang.f.c.a(new File(file, "tmp"), c.a.a);
            if (a2 != null && a2.length != 0) {
                LinkedList<File> linkedList = new LinkedList();
                for (File file2 : a2) {
                    if (!Boolean.TRUE.equals(c.get(file2))) {
                        linkedList.add(file2);
                    }
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                cn.jiguang.ar.c.c("ReportHistory", "process space=" + e(file) + " tmp[" + linkedList.size() + "]");
                Set<String> b2 = b();
                HashMap hashMap = new HashMap();
                c a3 = c.a(cn.jiguang.f.c.a(cn.jiguang.f.c.a(file, c.a.a)), b2);
                if (a3 != null) {
                    hashMap.put(String.valueOf(a3.b), a3);
                }
                for (File file3 : linkedList) {
                    c a4 = c.a(file3, b2);
                    if (a4 != null) {
                        String valueOf = String.valueOf(a4.b);
                        c cVar = (c) hashMap.get(valueOf);
                        if (cVar != null && cVar.a(a4, file)) {
                        }
                        hashMap.put(valueOf, a4);
                    }
                }
                for (c cVar2 : hashMap.values()) {
                    cVar2.a((c) null, file);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.g("ReportHistory", "processTmp e:" + th);
        }
    }

    private static String e(Context context) {
        String e = cn.jiguang.d.a.e(context);
        if (TextUtils.isEmpty(e)) {
            e = "0";
        }
        return d(context) + File.separator + e;
    }

    private static String e(File file) {
        try {
            File parentFile = file.getParentFile();
            StringBuilder sb = new StringBuilder();
            sb.append(parentFile.getParentFile().getName());
            String str = File.separator;
            sb.append(str);
            sb.append(parentFile.getName());
            sb.append(str);
            sb.append(file.getName());
            return sb.toString();
        } catch (Throwable unused) {
            return file.getAbsolutePath();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context) {
        try {
            d.set(true);
            File[] a2 = cn.jiguang.f.c.a(e(context), c.a.b);
            if (a2 != null) {
                for (File file : a2) {
                    c(context, file);
                }
            } else {
                cn.jiguang.ar.c.c("ReportHistory", "no history, no report");
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
