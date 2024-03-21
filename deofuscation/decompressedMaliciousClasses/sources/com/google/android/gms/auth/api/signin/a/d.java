package com.google.android.gms.auth.api.signin.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.e0;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class d {
    private static short[] $ = {6294, 6298, 6296, 6363, 6290, 6298, 6298, 6290, 6297, 6288, 6363, 6292, 6299, 6289, 6279, 6298, 6300, 6289, 6363, 6290, 6296, 6278, 6363, 6278, 6300, 6290, 6299, 6300, 6299, 9427, 9435, 9435, 9427, 9432, 9425, 9447, 9437, 9427, 9434, 9469, 9434, 9461, 9431, 9431, 9435, 9409, 9434, 9408, 1933, 1925, 1925, 1933, 1926, 1935, 1977, 1923, 1933, 1924, 1955, 1924, 1957, 1946, 1950, 1923, 1925, 1924, 1945, 7966, 6893, 6892, 6895, 6888, 6908, 6885, 6909, 6862, 6886, 6886, 6894, 6885, 6892, 6874, 6880, 6894, 6887, 6848, 6887, 6856, 6890, 6890, 6886, 6908, 6887, 6909, 7003, 7002, 7001, 7006, 6986, 6995, 6987, 7032, 6992, 6992, 7000, 6995, 7002, 7020, 6998, 7000, 6993, 7030, 6993, 7038, 7004, 7004, 6992, 6986, 6993, 6987};
    private static final Lock c = new ReentrantLock();
    private static d d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f223a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f224b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    private d(Context context) {
        this.f224b = context.getSharedPreferences($(0, 29, 6389), 0);
    }

    public static d a(Context context) {
        e0.i(context);
        c.lock();
        try {
            if (d == null) {
                d = new d(context.getApplicationContext());
            }
            return d;
        } finally {
            c.unlock();
        }
    }

    private final GoogleSignInAccount b(String str) {
        String d2;
        if (!TextUtils.isEmpty(str) && (d2 = d(g($(29, 48, 9396), str))) != null) {
            try {
                return GoogleSignInAccount.k(d2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final GoogleSignInOptions c(String str) {
        String d2;
        if (!TextUtils.isEmpty(str) && (d2 = d(g($(48, 67, 2026), str))) != null) {
            try {
                return GoogleSignInOptions.c(d2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final String d(String str) {
        this.f223a.lock();
        try {
            return this.f224b.getString(str, null);
        } finally {
            this.f223a.unlock();
        }
    }

    private static String g(String str, String str2) {
        int length = String.valueOf(str).length();
        String $2 = $(67, 68, 7972);
        StringBuilder sb = new StringBuilder(length + $2.length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append($2);
        sb.append(str2);
        return sb.toString();
    }

    public final GoogleSignInAccount e() {
        return b(d($(68, 94, 6793)));
    }

    public final GoogleSignInOptions f() {
        return c(d($(94, 120, 6975)));
    }
}
