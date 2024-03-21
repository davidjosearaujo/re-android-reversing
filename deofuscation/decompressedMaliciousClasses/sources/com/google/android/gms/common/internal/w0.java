package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import b.a.a.a.e.j1;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class w0 {
    private static short[] $ = {7278, 7278, 7222, 7223, 7220, 7219, 7207, 7230, 7206, 7282, 7219, 7217, 7217, 7229, 7207, 7228, 7206, 7276, 7276, 3222, 3226, 3224, 3291, 3218, 3226, 3226, 3218, 3225, 3216};

    /* renamed from: a */
    private final Account f281a;

    /* renamed from: b */
    private final Set<Scope> f282b;
    private final Set<Scope> c;
    private final Map<a<?>, x0> d;
    private final String e;
    private final String f;
    private final j1 g;
    private Integer h;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public w0(Account account, Set<Scope> set, Map<a<?>, x0> map, int i, View view, String str, String str2, j1 j1Var) {
        Map<a<?>, x0> map2 = map;
        this.f281a = account;
        this.f282b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.d = map2 == null ? Collections.EMPTY_MAP : map2;
        this.e = str;
        this.f = str2;
        this.g = j1Var;
        HashSet hashSet = new HashSet(this.f282b);
        for (x0 x0Var : this.d.values()) {
            hashSet.addAll(x0Var.f285a);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    public final Account a() {
        return this.f281a;
    }

    public final void b(Integer num) {
        this.h = num;
    }

    public final Account c() {
        Account account = this.f281a;
        return account != null ? account : new Account($(0, 19, 7250), $(19, 29, 3317));
    }

    public final Set<Scope> d() {
        return this.c;
    }

    public final String e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final j1 g() {
        return this.g;
    }

    public final Integer h() {
        return this.h;
    }
}
