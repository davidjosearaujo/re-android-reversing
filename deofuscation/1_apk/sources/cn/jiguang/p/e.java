package cn.jiguang.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e extends cn.jiguang.n.a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e b;
    private Context a;
    private JSONObject c;

    private e() {
    }

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    public static void a(Context context, ArrayList<String> arrayList) {
        if (context == null || arrayList == null) {
            cn.jiguang.ak.a.a("JDeviceIdsMap", "save DeviceIds fail, context or deviceIds is null");
            return;
        }
        try {
            String j = cn.jiguang.n.b.j(context);
            ArrayList arrayList2 = new ArrayList();
            if (!TextUtils.isEmpty(j)) {
                cn.jiguang.ak.a.a("JDeviceIdsMap", "old share process deviceIds is " + j);
                for (String str : j.split(",")) {
                    arrayList2.add(str);
                }
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(arrayList2);
            linkedHashSet.addAll(arrayList);
            StringBuilder sb = new StringBuilder();
            Iterator it = linkedHashSet.iterator();
            while (true) {
                sb.append((String) it.next());
                if (!it.hasNext()) {
                    cn.jiguang.ak.a.a("JDeviceIdsMap", "new share process deviceIds is " + sb.toString());
                    cn.jiguang.n.b.y(context, sb.toString());
                    return;
                }
                sb.append(',');
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(String str) {
        String i = cn.jiguang.n.b.i(this.a);
        if (TextUtils.isEmpty(i)) {
            cn.jiguang.ak.a.a("JDeviceIdsMap", "dIds cache is empty");
            return true;
        }
        return !i.equals(str);
    }

    private void e() {
        try {
            Object opt = this.c.opt("deviceids");
            if (opt != null) {
                cn.jiguang.n.b.x(this.a, opt.toString());
                cn.jiguang.ak.a.a("JDeviceIdsMap", "dids refresh cache success, dIds: " + opt);
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JDeviceIdsMap", "ids encrypted failed, err: " + th.getMessage());
        }
    }

    public static void e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            cn.jiguang.ak.a.a("JDeviceIdsMap", "save DeviceId fail, context or deviceId is null");
        } else if (!cn.jiguang.q.c.a(context) || cn.jiguang.q.c.b(context)) {
        } else {
            cn.jiguang.ak.a.a("JDeviceIdsMap", "start save deviceId into sd by mediaStore");
            boolean z = false;
            try {
                String a = cn.jiguang.f.e.a(context, "jdevice_id_map");
                JSONArray jSONArray = null;
                boolean z2 = true;
                if (TextUtils.isEmpty(a)) {
                    jSONArray = new JSONArray();
                    jSONArray.put(str);
                } else {
                    String g = cn.jiguang.n.d.g(a);
                    cn.jiguang.ak.a.a("JDeviceIdsMap", "old deviceIds is " + g + " from sd");
                    if (!g.contains(str)) {
                        jSONArray = new JSONArray(g);
                        jSONArray.put(str);
                        z = true;
                    }
                    z2 = z;
                }
                if (!z2 || jSONArray == null) {
                    return;
                }
                cn.jiguang.ak.a.a("JDeviceIdsMap", "save deviceId " + str + " into sd, new deviceIds is " + jSONArray.toString());
                cn.jiguang.f.e.a(context, "jdevice_id_map", cn.jiguang.n.d.f(jSONArray.toString()));
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JDeviceIdsMap", "save deviceId info sd error :" + th);
            }
        }
    }

    @Override // cn.jiguang.n.a
    public String a(Context context) {
        this.a = context;
        return "JDeviceIdsMap";
    }

    @Override // cn.jiguang.n.a
    public void b(Context context, String str) {
        String[] split;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String g = cn.jiguang.n.d.g(context);
        String j = cn.jiguang.n.b.j(context);
        if (!TextUtils.isEmpty(j)) {
            try {
                cn.jiguang.ak.a.d("JDeviceIdsMap", "collect share process dIds " + j);
                ArrayList arrayList = new ArrayList();
                for (String str2 : j.split(",")) {
                    if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, g)) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.size() > 0) {
                    linkedHashSet.addAll(arrayList);
                }
            } catch (Throwable unused) {
            }
        }
        if (cn.jiguang.q.c.a(context) && !cn.jiguang.q.c.b(context)) {
            String a = cn.jiguang.f.e.a(context, "jdevice_id_map");
            if (!TextUtils.isEmpty(a)) {
                String g2 = cn.jiguang.n.d.g(a);
                cn.jiguang.ak.a.d("JDeviceIdsMap", "collect sd dIds " + g2);
                try {
                    JSONArray jSONArray = new JSONArray(g2);
                    int length = jSONArray.length();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        String optString = jSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString) && !TextUtils.equals(optString, g)) {
                            arrayList2.add(optString);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        linkedHashSet.addAll(arrayList2);
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        if (cn.jiguang.ap.b.b(context).u) {
            cn.jiguang.ak.a.d("JDeviceIdsMap", "collect waked dIds");
            try {
                JSONArray b2 = cn.jiguang.ap.e.b(context);
                if (b2 != null && b2.length() > 0) {
                    cn.jiguang.ak.a.a("JDeviceIdsMap", "waked dIds is " + b2.toString());
                    int length2 = b2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject = b2.optJSONObject(i2);
                        if (optJSONObject != null) {
                            String optString2 = optJSONObject.optString("di");
                            if (!TextUtils.isEmpty(optString2) && !TextUtils.equals(optString2, g)) {
                                linkedHashSet.add(optString2);
                            }
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
            cn.jiguang.ap.e.c(context);
        }
        try {
            if (linkedHashSet.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator it = linkedHashSet.iterator();
                do {
                    jSONArray2.put((String) it.next());
                } while (it.hasNext());
                jSONArray2.put(g);
                if (!a(jSONArray2.toString())) {
                    cn.jiguang.ak.a.a("JDeviceIdsMap", "dids not changed, need not report");
                    return;
                }
                if (this.c == null) {
                    this.c = new JSONObject();
                }
                this.c.put("deviceids", jSONArray2);
                cn.jiguang.ak.a.a("JDeviceIdsMap", "collect success:" + this.c + ", origin dIds : " + jSONArray2.toString());
                super.b(context, str);
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JDeviceIdsMap", "collect dIds fail, error is " + th);
        }
    }

    @Override // cn.jiguang.n.a
    public void d(Context context, String str) {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            cn.jiguang.ak.a.d("JDeviceIdsMap", "there are no data to report");
            return;
        }
        cn.jiguang.n.d.a(context, jSONObject, "device_id_map");
        cn.jiguang.n.d.a(context, (Object) this.c);
        super.d(context, str);
        e();
        cn.jiguang.ak.a.a("JDeviceIdsMap", str + "report success, reportData: " + this.c);
        this.c = null;
    }
}
