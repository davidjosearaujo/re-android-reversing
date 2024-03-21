package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.safeparcel.d;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
@KeepName
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class DataHolder extends com.google.android.gms.common.internal.safeparcel.a implements Closeable {
    private static short[] $ = {-9505, -9478, -9489, -9478, -9511, -9490, -9475, -9475, -9474, -9495, -15052, -15085, -15095, -15080, -15089, -15085, -15076, -15087, -15011, -15079, -15076, -15095, -15076, -15011, -15087, -15080, -15076, -15082, -15011, -15094, -15084, -15095, -15083, -15084, -15085, -15011, -15076, -15011, -15047, -15076, -15095, -15076, -15041, -15096, -15077, -15077, -15080, -15089, -15011, -15086, -15073, -15081, -15080, -15074, -15095, -15011, -15079, -15080, -15095, -15080, -15074, -15095, -15080, -15079, -15012, -15011, -15011, -15041, -15080, -15011, -15090, -15096, -15089, -15080, -15011, -15095, -15086, -15011, -15080, -15099, -15091, -15087, -15084, -15074, -15084, -15095, -15087, -15100, -15011, -15074, -15076, -15087, -15087, -15011, -15089, -15080, -15087, -15080, -15076, -15090, -15080, -15019, -15020, -15011, -15086, -15085, -15011, -15076, -15087, -15087, -15011, -15047, -15076, -15095, -15076, -15041, -15096, -15077, -15077, -15080, -15089, -15011, -15080, -15099, -15095, -15080, -15085, -15079, -15084, -15085, -15078, -15011, -15086, -15073, -15081, -15080, -15074, -15095, -15090, -15011, -15094, -15083, -15080, -15085, -15011, -15100, -15086, -15096, -15011, -15076, -15089, -15080, -15011, -15079, -15086, -15085, -15080, -15011, -15094, -15084, -15095, -15083, -15011, -15095, -15083, -15080, -15088, -15021, -15011, -15019, -15084, -15085, -15095, -15080, -15089, -15085, -15076, -15087, -15011, -15086, -15073, -15081, -15080, -15074, -15095, -15033, -15011, -1931};
    public static final Parcelable.Creator<DataHolder> CREATOR = new b();

    /* renamed from: a */
    private int f243a;

    /* renamed from: b */
    private final String[] f244b;
    private Bundle c;
    private final CursorWindow[] d;
    private final int e;
    private final Bundle f;
    private int[] g;
    private boolean h = false;
    private boolean i = true;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class a {
        private a(String[] strArr, String str) {
            e0.i(strArr);
            new ArrayList();
            new HashMap();
        }

        public /* synthetic */ a(String[] strArr, String str, a aVar) {
            this(strArr, null);
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
        new a(new String[0], null);
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f243a = i;
        this.f244b = strArr;
        this.d = cursorWindowArr;
        this.e = i2;
        this.f = bundle;
    }

    public final boolean c() {
        boolean z;
        synchronized (this) {
            z = this.h;
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.h) {
                this.h = true;
                for (int i = 0; i < this.d.length; i++) {
                    this.d[i].close();
                }
            }
        }
    }

    public final void d() {
        this.c = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.f244b;
            if (i2 >= strArr.length) {
                break;
            }
            this.c.putInt(strArr[i2], i2);
            i2++;
        }
        this.g = new int[this.d.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.d;
            if (i < cursorWindowArr.length) {
                this.g[i] = i3;
                i3 += this.d[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
                i++;
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object
    protected final void finalize() {
        try {
            if (this.i && this.d.length > 0 && !c()) {
                close();
                String $2 = $(0, 10, -9573);
                String valueOf = String.valueOf(toString());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 178);
                sb.append($(10, 187, -14979));
                sb.append(valueOf);
                sb.append($(187, 188, -1956));
                Log.e($2, sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.l(parcel, 1, this.f244b, false);
        d.k(parcel, 2, this.d, i, false);
        d.o(parcel, 3, this.e);
        d.e(parcel, 4, this.f, false);
        d.o(parcel, 1000, this.f243a);
        d.c(parcel, q);
    }
}
