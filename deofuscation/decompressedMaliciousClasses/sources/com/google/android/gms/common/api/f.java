package com.google.android.gms.common.api;

import com.google.android.gms.common.api.j;
import java.util.concurrent.TimeUnit;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public abstract class f<R extends j> {

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface a {
        void a(Status status);
    }

    public abstract R a(long j, TimeUnit timeUnit);

    public abstract void b(a aVar);
}
