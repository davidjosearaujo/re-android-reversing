package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.h;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class s {
    public static b a(Status status) {
        return status.e() ? new h(status) : new b(status);
    }
}
