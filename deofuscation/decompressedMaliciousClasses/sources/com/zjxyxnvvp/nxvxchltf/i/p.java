package com.zjxyxnvvp.nxvxchltf.i;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, f> f329a = new ConcurrentHashMap();

    public void a(String str) {
        this.f329a.remove(str);
    }

    public f b(String str) {
        return this.f329a.get(str);
    }

    public List<f> c() {
        ArrayList arrayList = new ArrayList();
        for (f fVar : this.f329a.values()) {
            if (fVar.c()) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    public void d(String str, JSONObject jSONObject) {
        if (!this.f329a.containsKey(str)) {
            this.f329a.put(str, new f(str, false, jSONObject));
        }
    }

    public void e(String str, JSONObject jSONObject) {
        f b2 = b(str);
        if (b2 != null) {
            b2.d(true);
            b2.e(jSONObject);
        }
    }
}
