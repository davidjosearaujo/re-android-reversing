package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.a.b;
import com.google.android.gms.auth.api.signin.a.c;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class GoogleSignInOptions extends com.google.android.gms.common.internal.safeparcel.a implements a.AbstractC0005a, ReflectedParcelable {
    public static final GoogleSignInOptions m;
    public static final GoogleSignInOptions n;

    /* renamed from: a */
    private int f215a;

    /* renamed from: b */
    private final ArrayList<Scope> f216b;
    private Account c;
    private boolean d;
    private final boolean e;
    private final boolean f;
    private String g;
    private String h;
    private ArrayList<b> i;
    private static short[] $ = {3659, 3657, 3668, 3677, 3666, 3671, 3678, 4598, 4606, 4594, 4602, 4607, 527, 528, 517, 526, 521, 516, 11257, 11237, 11237, 11233, 11234, 11179, 11198, 11198, 11238, 11238, 11238, 11199, 11254, 11262, 11262, 11254, 11261, 11252, 11248, 11233, 11256, 11234, 11199, 11250, 11262, 11260, 11198, 11248, 11236, 11237, 11257, 11198, 11254, 11248, 11260, 11252, 11234, 9498, 9482, 9478, 9497, 9484, 9498, 1319, 1317, 1317, 1321, 1331, 1320, 1330, 1288, 1319, 1323, 1315, 4151, 4155, 4153, 4218, 4147, 4155, 4155, 4147, 4152, 4145, 8661, 8664, 8680, 8659, 8663, 8665, 8658, 8686, 8665, 8653, 8649, 8665, 8655, 8648, 8665, 8664, 1806, 1816, 1807, 1803, 1816, 1807, 1852, 1800, 1801, 1813, 1839, 1816, 1804, 1800, 1816, 1806, 1801, 1816, 1817, 8429, 8420, 8441, 8424, 8430, 8392, 8420, 8431, 8430, 8397, 8420, 8441, 8409, 8430, 8429, 8441, 8430, 8440, 8419, 8415, 8420, 8416, 8430, 8421, 5388, 5402, 5389, 5385, 5402, 5389, 5436, 5395, 5398, 5402, 5393, 5387, 5430, 5403, 4469, 4466, 4462, 4457, 4472, 4473, 4441, 4466, 4464, 4476, 4468, 4467};
    public static final Scope j = new Scope($(0, 7, 3643));
    public static final Scope k = new Scope($(12, 18, 608));
    private static Scope l = new Scope($(18, 55, 11153));
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new e();

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static final class a {

        /* renamed from: b */
        private boolean f218b;
        private boolean c;
        private boolean d;
        private String e;
        private Account f;
        private String g;

        /* renamed from: a */
        private Set<Scope> f217a = new HashSet();
        private Map<Integer, b> h = new HashMap();

        public final GoogleSignInOptions a() {
            if (this.d && (this.f == null || !this.f217a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f217a), this.f, this.d, this.f218b, this.c, this.e, this.g, this.h, null);
        }

        public final a b() {
            this.f217a.add(GoogleSignInOptions.k);
            return this;
        }

        public final a c() {
            this.f217a.add(GoogleSignInOptions.j);
            return this;
        }

        public final a d(Scope scope, Scope... scopeArr) {
            this.f217a.add(scope);
            this.f217a.addAll(Arrays.asList(scopeArr));
            return this;
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    static {
        new Scope($(7, 12, 4499));
        a b2 = new a().b();
        b2.c();
        m = b2.a();
        a aVar = new a();
        aVar.d(l, new Scope[0]);
        n = aVar.a();
    }

    public GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<b> arrayList2) {
        this(i, arrayList, account, z, z2, z3, str, str2, e(arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, b> map) {
        this.f215a = i;
        this.f216b = arrayList;
        this.c = account;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = str;
        this.h = str2;
        this.i = new ArrayList<>(map.values());
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, d dVar) {
        this(3, arrayList, account, z, z2, z3, str, str2, map);
    }

    public static GoogleSignInOptions c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray($(55, 61, 9577));
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString($(61, 72, 1350), null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, $(72, 82, 4180)) : null, jSONObject.getBoolean($(82, 98, 8636)), jSONObject.getBoolean($(98, 117, 1917)), jSONObject.getBoolean($(117, 141, 8331)), jSONObject.optString($(141, 155, 5503), null), jSONObject.optString($(155, 167, 4381), null), new HashMap());
    }

    private static Map<Integer, b> e(List<b> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (b bVar : list) {
            hashMap.put(Integer.valueOf(bVar.c()), bVar);
        }
        return hashMap;
    }

    public final ArrayList<Scope> d() {
        return new ArrayList<>(this.f216b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r7.c.equals(r4.c) != false) goto L_0x004b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        if (r7.g.equals(r4.g) != false) goto L_0x0066;
     */
    @Override // java.lang.Object
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r3 = r7
            r4 = r8
            r0 = 0
            if (r4 != 0) goto L_0x0008
            return r0
        L_0x0008:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: ClassCastException -> 0x007a
            java.util.ArrayList<com.google.android.gms.auth.api.signin.a.b> r1 = r3.i     // Catch: ClassCastException -> 0x007a
            int r1 = r1.size()     // Catch: ClassCastException -> 0x007a
            if (r1 > 0) goto L_0x007a
            java.util.ArrayList<com.google.android.gms.auth.api.signin.a.b> r1 = r4.i     // Catch: ClassCastException -> 0x007a
            int r1 = r1.size()     // Catch: ClassCastException -> 0x007a
            if (r1 <= 0) goto L_0x001b
            goto L_0x007a
        L_0x001b:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f216b     // Catch: ClassCastException -> 0x007a
            int r1 = r1.size()     // Catch: ClassCastException -> 0x007a
            java.util.ArrayList r2 = r4.d()     // Catch: ClassCastException -> 0x007a
            int r2 = r2.size()     // Catch: ClassCastException -> 0x007a
            if (r1 != r2) goto L_0x007a
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f216b     // Catch: ClassCastException -> 0x007a
            java.util.ArrayList r2 = r4.d()     // Catch: ClassCastException -> 0x007a
            boolean r1 = r1.containsAll(r2)     // Catch: ClassCastException -> 0x007a
            if (r1 != 0) goto L_0x0038
            goto L_0x007a
        L_0x0038:
            android.accounts.Account r1 = r3.c     // Catch: ClassCastException -> 0x007a
            if (r1 != 0) goto L_0x0041
            android.accounts.Account r1 = r4.c     // Catch: ClassCastException -> 0x007a
            if (r1 != 0) goto L_0x007a
            goto L_0x004b
        L_0x0041:
            android.accounts.Account r1 = r3.c     // Catch: ClassCastException -> 0x007a
            android.accounts.Account r2 = r4.c     // Catch: ClassCastException -> 0x007a
            boolean r1 = r1.equals(r2)     // Catch: ClassCastException -> 0x007a
            if (r1 == 0) goto L_0x007a
        L_0x004b:
            java.lang.String r1 = r3.g     // Catch: ClassCastException -> 0x007a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: ClassCastException -> 0x007a
            if (r1 == 0) goto L_0x005c
            java.lang.String r1 = r4.g     // Catch: ClassCastException -> 0x007a
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: ClassCastException -> 0x007a
            if (r1 == 0) goto L_0x007a
            goto L_0x0066
        L_0x005c:
            java.lang.String r1 = r3.g     // Catch: ClassCastException -> 0x007a
            java.lang.String r2 = r4.g     // Catch: ClassCastException -> 0x007a
            boolean r1 = r1.equals(r2)     // Catch: ClassCastException -> 0x007a
            if (r1 == 0) goto L_0x007a
        L_0x0066:
            boolean r1 = r3.f     // Catch: ClassCastException -> 0x007a
            boolean r2 = r4.f     // Catch: ClassCastException -> 0x007a
            if (r1 != r2) goto L_0x007a
            boolean r1 = r3.d     // Catch: ClassCastException -> 0x007a
            boolean r2 = r4.d     // Catch: ClassCastException -> 0x007a
            if (r1 != r2) goto L_0x007a
            boolean r1 = r3.e     // Catch: ClassCastException -> 0x007a
            boolean r4 = r4.e     // Catch: ClassCastException -> 0x007a
            if (r1 != r4) goto L_0x007a
            r4 = 1
            return r4
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @Override // java.lang.Object
    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f216b;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.c());
        }
        Collections.sort(arrayList);
        c cVar = new c();
        cVar.c(arrayList);
        cVar.c(this.c);
        cVar.c(this.g);
        cVar.a(this.f);
        cVar.a(this.d);
        cVar.a(this.e);
        return cVar.b();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.o(parcel, 1, this.f215a);
        d.p(parcel, 2, d(), false);
        d.g(parcel, 3, this.c, i, false);
        d.i(parcel, 4, this.d);
        d.i(parcel, 5, this.e);
        d.i(parcel, 6, this.f);
        d.h(parcel, 7, this.g, false);
        d.h(parcel, 8, this.h, false);
        d.p(parcel, 9, this.i, false);
        d.c(parcel, q);
    }
}
