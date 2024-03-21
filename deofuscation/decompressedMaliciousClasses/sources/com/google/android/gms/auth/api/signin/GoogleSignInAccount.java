package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    private static short[] $ = {7871, 7847, 7840, 7867, 7840, 7834, 7869, 7843, 7261, 7232, 7240, 7249, 7242, 7257, 7244, 7249, 7255, 7254, 7276, 7249, 7253, 7261, 8985, 8972, 8991, 8976, 8970, 8987, 8986, 9005, 8989, 8977, 8974, 8987, 8973, 2820, 2825, 9334, 9325, 9321, 9319, 9324, 9291, 9318, 7491, 7499, 7495, 7503, 7498, 5205, 5208, 5186, 5185, 5213, 5200, 5192, 5247, 5200, 5212, 5204, 5366, 5368, 5351, 5364, 5375, 5343, 5360, 5372, 5364, 787, 788, 792, 796, 793, 780, 827, 788, 792, 784, 1888, 1901, 1897, 1914, 1916, 1900, 1902, 1915, 1898, 1899, 1862, 1899, 1898, 1889, 1915, 1894, 1897, 1894, 1898, 1917, 649, 671, 648, 652, 671, 648, 699, 655, 654, 658, 697, 661, 670, 671, 6647, 6650, 2729, 2738, 2742, 2744, 2739, 2708, 2745, 4495, 4487, 4491, 4483, 4486, 8937, 8932, 8958, 8957, 8929, 8940, 8948, 8899, 8940, 8928, 8936, 2162, 2172, 2147, 2160, 2171, 2139, 2164, 2168, 2160, 5522, 5525, 5529, 5533, 5528, 5517, 5562, 5525, 5529, 5521, 5423, 5431, 5424, 5419, 5424, 5386, 5421, 5427, 476, 458, 477, 473, 458, 477, 494, 474, 475, 455, 492, 448, 459, 458, 22, 11, 3, 26, 1, 18, 7, 26, 28, 29, 39, 26, 30, 22, 7299, 7310, 7306, 7321, 7327, 7311, 7309, 7320, 7305, 7304, 7333, 7304, 7305, 7298, 7320, 7301, 7306, 7301, 7305, 7326, 2247, 2258, 2241, 2254, 2260, 2245, 2244, 2291, 2243, 2255, 2256, 2245, 2259};
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new c();
    private static c m = d.b();
    private static Comparator<Scope> n = new b();

    /* renamed from: a */
    private int f213a;

    /* renamed from: b */
    private String f214b;
    private String c;
    private String d;
    private String e;
    private Uri f;
    private String g;
    private long h;
    private String i;
    private List<Scope> j;
    private String k;
    private String l;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f213a = i;
        this.f214b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = uri;
        this.g = str5;
        this.h = j;
        this.i = str6;
        this.j = list;
        this.k = str7;
        this.l = str8;
    }

    public static GoogleSignInAccount k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString($(0, 8, 7887), null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString($(8, 22, 7224)));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray($(22, 35, 9086));
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString2 = jSONObject.optString($(35, 37, 2925));
        String optString3 = jSONObject.optString($(37, 44, 9218), null);
        String optString4 = jSONObject.optString($(44, 49, 7462), null);
        String optString5 = jSONObject.optString($(49, 60, 5169), null);
        String optString6 = jSONObject.optString($(60, 69, 5265), null);
        String optString7 = jSONObject.optString($(69, 79, 885), null);
        Long valueOf = Long.valueOf(parseLong);
        String string = jSONObject.getString($(79, 99, 1807));
        if (valueOf == null) {
            valueOf = Long.valueOf(m.a() / 1000);
        }
        long longValue = valueOf.longValue();
        e0.g(string);
        e0.i(hashSet);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, longValue, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.g = jSONObject.optString($(99, 113, 762), null);
        return googleSignInAccount;
    }

    private final JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (g() != null) {
                jSONObject.put($(113, 115, 6558), g());
            }
            if (h() != null) {
                jSONObject.put($(115, 122, 2781), h());
            }
            if (d() != null) {
                jSONObject.put($(122, 127, 4586), d());
            }
            if (c() != null) {
                jSONObject.put($(127, 138, 8845), c());
            }
            if (f() != null) {
                jSONObject.put($(138, 147, 2069), f());
            }
            if (e() != null) {
                jSONObject.put($(147, 157, 5620), e());
            }
            if (i() != null) {
                jSONObject.put($(157, 165, 5471), i().toString());
            }
            if (j() != null) {
                jSONObject.put($(165, 179, 431), j());
            }
            jSONObject.put($(179, 193, 115), this.h);
            jSONObject.put($(193, 213, 7404), this.i);
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.j, n);
            for (Scope scope : this.j) {
                jSONArray.put(scope.c());
            }
            jSONObject.put($(213, 226, 2208), jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.l;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        return ((GoogleSignInAccount) obj).l().toString().equals(l().toString());
    }

    public String f() {
        return this.k;
    }

    public String g() {
        return this.f214b;
    }

    public String h() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return l().toString().hashCode();
    }

    public Uri i() {
        return this.f;
    }

    public String j() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int q = com.google.android.gms.common.internal.safeparcel.d.q(parcel);
        com.google.android.gms.common.internal.safeparcel.d.o(parcel, 1, this.f213a);
        com.google.android.gms.common.internal.safeparcel.d.h(parcel, 2, g(), false);
        com.google.android.gms.common.internal.safeparcel.d.h(parcel, 3, h(), false);
        com.google.android.gms.common.internal.safeparcel.d.h(parcel, 4, d(), false);
        com.google.android.gms.common.internal.safeparcel.d.h(parcel, 5, c(), false);
        com.google.android.gms.common.internal.safeparcel.d.g(parcel, 6, i(), i, false);
        com.google.android.gms.common.internal.safeparcel.d.h(parcel, 7, j(), false);
        com.google.android.gms.common.internal.safeparcel.d.d(parcel, 8, this.h);
        com.google.android.gms.common.internal.safeparcel.d.h(parcel, 9, this.i, false);
        com.google.android.gms.common.internal.safeparcel.d.p(parcel, 10, this.j, false);
        com.google.android.gms.common.internal.safeparcel.d.h(parcel, 11, f(), false);
        com.google.android.gms.common.internal.safeparcel.d.h(parcel, 12, e(), false);
        com.google.android.gms.common.internal.safeparcel.d.c(parcel, q);
    }
}
