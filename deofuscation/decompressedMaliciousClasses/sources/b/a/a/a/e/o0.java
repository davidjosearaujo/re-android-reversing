package b.a.a.a.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    private Context f168a;

    public o0(Context context) {
        this.f168a = context;
    }

    public final ApplicationInfo a(String str, int i) {
        return this.f168a.getPackageManager().getApplicationInfo(str, i);
    }

    public final PackageInfo b(String str, int i) {
        return this.f168a.getPackageManager().getPackageInfo(str, i);
    }

    public final CharSequence c(String str) {
        return this.f168a.getPackageManager().getApplicationLabel(this.f168a.getPackageManager().getApplicationInfo(str, 0));
    }
}
