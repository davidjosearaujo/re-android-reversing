package com.google.android.gms.common.api;

import a.a.a.d.a;
import android.text.TextUtils;
import b.a.a.a.e.f;
import java.util.ArrayList;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class m extends Exception {
    private static short[] $ = {12129, 12155, 15009, 14976, 14977, 14986, 15055, 14976, 14985, 15055, 15003, 14983, 14986, 15055, 15006, 15002, 14986, 15005, 14982, 14986, 14987, 15055, 15022, 15039, 15014, 15004, 15055, 14990, 15005, 14986, 15055, 14990, 15001, 14990, 14982, 14979, 14990, 14989, 14979, 14986, 15041, 15055, 9074, 9038, 9036, 9028, 8961, 9038, 9031, 8961, 9045, 9033, 9028, 8961, 9040, 9044, 9028, 9043, 9032, 9028, 9029, 8961, 9056, 9073, 9064, 9042, 8961, 9024, 9043, 9028, 8961, 9044, 9039, 9024, 9047, 9024, 9032, 9037, 9024, 9027, 9037, 9028, 8975, 8961, 10704, 10699};

    /* renamed from: a  reason: collision with root package name */
    private final a<f<?>, b.a.a.a.c.a> f240a;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public m(a<f<?>, b.a.a.a.c.a> aVar) {
        this.f240a = aVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (f<?> fVar : this.f240a.keySet()) {
            b.a.a.a.c.a aVar = this.f240a.get(fVar);
            if (aVar.h()) {
                z = false;
            }
            String valueOf = String.valueOf(fVar.b());
            String valueOf2 = String.valueOf(aVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length());
            sb.append(valueOf);
            sb.append($(0, 2, 12123));
            sb.append(valueOf2);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? $(2, 42, 15087) : $(42, 84, 8993));
        sb2.append(TextUtils.join($(84, 86, 10731), arrayList));
        return sb2.toString();
    }
}
