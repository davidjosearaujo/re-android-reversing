package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import b.a.a.a.d.a;
import b.a.a.a.d.c;
import b.a.a.a.e.r0;
import com.google.android.gms.common.util.DynamiteApi;
@DynamiteApi
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class FlagProviderImpl extends r0 {
    private static short[] $ = {25338, 25334, 25332, 25271, 25342, 25334, 25334, 25342, 25333, 25340, 25271, 25336, 25335, 25341, 25323, 25334, 25328, 25341, 25271, 25342, 25332, 25322, 28791, 28763, 28737, 28760, 28752, 28692, 28762, 28763, 28736, 28692, 28742, 28753, 28736, 28742, 28765, 28753, 28738, 28753, 28692, 28743, 28752, 28767, 28692, 28754, 28760, 28757, 28755, 28743, 28696, 28692, 28759, 28763, 28762, 28736, 28765, 28762, 28737, 28765, 28762, 28755, 28692, 28739, 28765, 28736, 28764, 28692, 28752, 28753, 28754, 28757, 28737, 28760, 28736, 28743, 28686, 28692, 28016, 27994, 27991, 27985, 28006, 27972, 27993, 27968, 27999, 27986, 27987, 27972, 28031, 27995, 27974, 27994};

    /* renamed from: a  reason: collision with root package name */
    private boolean f292a = false;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f293b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    @Override // b.a.a.a.e.q0
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f292a ? z : b.a(this.f293b, str, Boolean.valueOf(z)).booleanValue();
    }

    @Override // b.a.a.a.e.q0
    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f292a ? i : d.a(this.f293b, str, Integer.valueOf(i)).intValue();
    }

    @Override // b.a.a.a.e.q0
    public long getLongFlagValue(String str, long j, int i) {
        return !this.f292a ? j : f.a(this.f293b, str, Long.valueOf(j)).longValue();
    }

    @Override // b.a.a.a.e.q0
    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f292a ? str2 : h.a(this.f293b, str, str2);
    }

    @Override // b.a.a.a.e.q0
    public void init(a aVar) {
        Context context = (Context) c.y(aVar);
        if (!this.f292a) {
            try {
                this.f293b = j.a(context.createPackageContext($(0, 22, 25241), 0));
                this.f292a = true;
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e) {
                String $2 = $(22, 78, 28724);
                String valueOf = String.valueOf(e.getMessage());
                Log.w($(78, 94, 27958), valueOf.length() != 0 ? $2.concat(valueOf) : new String($2));
            }
        }
    }
}
