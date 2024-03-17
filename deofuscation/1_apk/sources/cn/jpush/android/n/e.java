package cn.jpush.android.n;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ac.i;
import cn.jpush.android.helper.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    public static int c = 200;
    private static e f;
    public Context a;
    public int b = 100;
    private volatile LinkedHashMap<String, cn.jpush.android.b.b> d;
    private volatile LinkedHashMap<String, cn.jpush.android.b.b> e;
    private a g;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void a(cn.jpush.android.b.b bVar);

        void a(cn.jpush.android.b.b bVar, cn.jpush.android.b.b bVar2);

        void a(boolean z);

        void b(cn.jpush.android.b.b bVar);
    }

    private e() {
    }

    private static cn.jpush.android.b.b a(cn.jpush.android.d.d dVar) {
        cn.jpush.android.b.b bVar = new cn.jpush.android.b.b();
        bVar.a = dVar.ag;
        bVar.b = dVar.ah;
        bVar.c = dVar.ai;
        bVar.d = dVar.aj;
        bVar.e = dVar.al;
        bVar.f = dVar.am;
        bVar.g = dVar.an;
        bVar.h = dVar.ao;
        return bVar;
    }

    public static e a() {
        if (f == null) {
            synchronized (e.class) {
                if (f == null) {
                    f = new e();
                }
            }
        }
        return f;
    }

    private LinkedHashMap<String, cn.jpush.android.b.b> a(Context context, int i) {
        FileInputStream fileInputStream = null;
        if (context == null) {
            Logger.w("GeofenceDataHelper", "unexcepted , context is null");
            return null;
        }
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        try {
            File a2 = cn.jpush.android.ac.c.a(context, i == 2 ? "jpush_geofence_v5_report" : "jpush_geofence_v5");
            if (a2.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(a2);
                try {
                    JSONObject jSONObject = new JSONObject(new String(i.a((InputStream) fileInputStream2)));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jpush.android.b.b a3 = cn.jpush.android.b.b.a(context, jSONObject.getJSONObject(keys.next()));
                        if (a3 != null) {
                            linkedHashMap.put(a3.a, a3);
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        Logger.w("GeofenceDataHelper", "load objects error:" + th.getMessage());
                        return linkedHashMap;
                    } finally {
                        i.a((Closeable) fileInputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return linkedHashMap;
    }

    private void a(String str, JSONObject jSONObject, int i, boolean z) {
        a aVar;
        LinkedHashMap<String, cn.jpush.android.b.b> d = d(i);
        Logger.dd("GeofenceDataHelper", "Before update.Current geofence size:" + d.size() + ",type:" + i);
        cn.jpush.android.b.b bVar = d.get(str);
        if (bVar == null) {
            Logger.ww("GeofenceDataHelper", "can not update geofence because origin one not found");
            return;
        }
        bVar.b(jSONObject);
        if (bVar.e * 1000 <= System.currentTimeMillis()) {
            d.remove(str);
            a(bVar);
        } else if (z && (aVar = this.g) != null) {
            aVar.a(bVar, bVar);
        }
        e(i);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:1|2|3|(1:7)|8|(13:50|(1:(2:69|(1:71)))(2:53|(5:57|(2:60|58)|61|62|(2:64|65)))|14|15|16|(1:18)|19|(1:21)(3:32|(4:35|(3:40|41|42)|43|33)|46)|22|(1:31)|(1:30)|27|28)(1:12)|13|14|15|16|(0)|19|(0)(0)|22|(0)|31|(0)|30|27|28|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00c0, code lost:
        if (r8.d.isEmpty() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00da, code lost:
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00de, code lost:
        cn.jpush.android.helper.Logger.dd("GeofenceDataHelper", "recover geofence failed:" + r9);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x015e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0165 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.n.e.b(android.content.Context):void");
    }

    private boolean b(int i) {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = i == 2 ? this.e : this.d;
        boolean z = false;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            Iterator<Map.Entry<String, cn.jpush.android.b.b>> it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                cn.jpush.android.b.b value = it.next().getValue();
                if (value != null && value.e * 1000 <= System.currentTimeMillis()) {
                    z = true;
                    Logger.dd("GeofenceDataHelper", "Geofence " + value.a + " is out of date!");
                    it.remove();
                }
            }
        }
        return z;
    }

    private void c(int i) {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap;
        String str;
        if (i == 0) {
            c(2);
            c(1);
            return;
        }
        if (i == 2) {
            linkedHashMap = this.e;
            Logger.dd("GeofenceDataHelper", "save report geofence to file");
            str = "jpush_geofence_v5_report";
        } else {
            linkedHashMap = this.d;
            Logger.dd("GeofenceDataHelper", "save show geofence to file");
            str = "jpush_geofence_v5";
        }
        if (linkedHashMap == null) {
            return;
        }
        try {
            File a2 = cn.jpush.android.ac.c.a(this.a, str);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, cn.jpush.android.b.b> entry : linkedHashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().a());
            }
            cn.jpush.android.ac.c.a(a2.getAbsolutePath(), jSONObject.toString());
        } catch (Throwable th) {
            Logger.ww("GeofenceDataHelper", "save geo to file error:" + th.getMessage());
        }
    }

    private boolean c(cn.jpush.android.b.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.a) && bVar.b != -1) {
            double d = bVar.g;
            if (d >= -90.0d && d <= 90.0d) {
                double d2 = bVar.f;
                if (d2 >= -180.0d && d2 <= 180.0d) {
                    return true;
                }
            }
        }
        Logger.ww("GeofenceDataHelper", "The geofence is invalid, won't operate!");
        return false;
    }

    private LinkedHashMap<String, cn.jpush.android.b.b> d(int i) {
        return i == 2 ? this.e : this.d;
    }

    private void e(int i) {
        c(i);
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(this.d.isEmpty() && this.e.isEmpty());
        }
    }

    private void f(int i) {
        int size = this.d.size();
        if (size > i) {
            Logger.dd("GeofenceDataHelper", "ShowGeofence count= " + size + ",limit=" + i + ",need remove earliest");
            Iterator<cn.jpush.android.b.b> it = this.d.values().iterator();
            while (it.hasNext() && size > i) {
                cn.jpush.android.b.b next = it.next();
                if (next != null) {
                    a(next);
                }
                it.remove();
                size--;
            }
        }
    }

    public void a(int i) {
        cn.jpush.android.cache.a.d(this.a, i);
        this.b = i;
        f(i);
    }

    public synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        this.a = context.getApplicationContext();
        this.b = cn.jpush.android.cache.a.e(context, 10);
        b(context);
        f(this.b);
    }

    public void a(cn.jpush.android.b.b bVar) {
        if (bVar == null || !TextUtils.isEmpty(bVar.a)) {
            int i = bVar.i;
            String str = bVar.a;
            LinkedHashMap<String, cn.jpush.android.b.b> d = d(i);
            Logger.dd("GeofenceDataHelper", "Before delete.Current geofence size:" + d.size() + ",type:" + i);
            if (d.remove(str) != null) {
                e(i);
                a aVar = this.g;
                if (aVar != null) {
                    aVar.b(bVar);
                    return;
                }
                return;
            }
            Logger.d("GeofenceDataHelper", "geofence=" + bVar.a + " already not exists");
        }
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public void a(String str) {
        Logger.d("GeofenceDataHelper", "will delete geofence=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cn.jpush.android.b.b bVar = this.d.get(str);
        cn.jpush.android.b.b bVar2 = this.e.get(str);
        if (bVar != null) {
            a(bVar);
        }
        if (bVar2 != null) {
            a(bVar2);
        }
        if (bVar == null && bVar2 == null) {
            Logger.d("GeofenceDataHelper", "geofence=" + str + " already not exists");
        }
    }

    public void a(String str, JSONObject jSONObject, boolean z) {
        int i;
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        if (jSONObject.has("type")) {
            i = jSONObject.optInt("type", 1);
        } else {
            a(str, jSONObject, 1, z);
            i = 2;
        }
        a(str, jSONObject, i, z);
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        int i = 0;
        while (true) {
            try {
                int length = jSONArray.length();
                int i2 = c;
                if (length <= i2) {
                    i2 = jSONArray.length();
                }
                if (i >= i2) {
                    break;
                }
                cn.jpush.android.b.b a2 = cn.jpush.android.b.b.a(jSONArray.getJSONObject(i));
                linkedHashMap.put(a2.a, a2);
                i++;
            } catch (Throwable th) {
                Logger.dd("GeofenceDataHelper", "Replace report geofences failed:" + th.getMessage());
                return;
            }
        }
        this.e = linkedHashMap;
        e(2);
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(null, null);
        }
    }

    public LinkedHashMap<String, cn.jpush.android.b.b> b() {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.putAll(this.e);
        linkedHashMap.putAll(this.d);
        return linkedHashMap;
    }

    public void b(cn.jpush.android.b.b bVar) {
        StringBuilder sb;
        String str;
        if (c(bVar)) {
            int i = bVar.i;
            LinkedHashMap<String, cn.jpush.android.b.b> d = d(i);
            Logger.dd("GeofenceDataHelper", "Before add.Current geofence size:" + d.size() + ",type:" + i);
            cn.jpush.android.b.b bVar2 = d.get(bVar.a);
            if (bVar2 == null) {
                if (i == 2 && d.size() >= c) {
                    sb = new StringBuilder();
                    sb.append("Report geofence size limit :");
                    sb.append(c);
                    sb.append(",won't add geofence");
                    str = bVar.a;
                } else if (bVar.e * 1000 <= System.currentTimeMillis()) {
                    sb = new StringBuilder();
                    sb.append("The geofence ");
                    sb.append(bVar.a);
                    str = " is out of date, will not create!";
                } else {
                    f(this.b - 1);
                    d.put(bVar.a, bVar);
                    a aVar = this.g;
                    if (aVar != null) {
                        aVar.a(bVar);
                    }
                }
                sb.append(str);
                Logger.dd("GeofenceDataHelper", sb.toString());
                return;
            } else if (bVar.e * 1000 <= System.currentTimeMillis()) {
                d.remove(bVar.a);
                a(bVar2);
            } else {
                bVar.a(bVar2);
                d.put(bVar.a, bVar);
                a aVar2 = this.g;
                if (aVar2 != null) {
                    aVar2.a(bVar2, bVar);
                }
            }
            e(i);
        }
    }

    public int c() {
        return this.d.size() + this.e.size();
    }
}
