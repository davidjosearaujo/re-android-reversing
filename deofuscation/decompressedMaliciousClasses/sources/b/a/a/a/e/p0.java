package b.a.a.a.e;

import android.content.Context;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class p0 {

    /* renamed from: b  reason: collision with root package name */
    private static p0 f171b = new p0();

    /* renamed from: a  reason: collision with root package name */
    private o0 f172a = null;

    private final synchronized o0 a(Context context) {
        if (this.f172a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f172a = new o0(context);
        }
        return this.f172a;
    }

    public static o0 b(Context context) {
        return f171b.a(context);
    }
}
