package cn.jpush.android.f;

import android.annotation.TargetApi;
import java.util.Objects;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class b {
    public String a;
    public long b;

    public b(String str, long j) {
        this.a = str;
        this.b = j;
    }

    @TargetApi(19)
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.b == bVar.b && Objects.equals(this.a, bVar.a)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(19)
    public final int hashCode() {
        return Objects.hash(this.a, Long.valueOf(this.b));
    }
}
