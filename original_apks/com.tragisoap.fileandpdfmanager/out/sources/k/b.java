package k;

import androidx.activity.result.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends c {

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f4607g;

    /* renamed from: f  reason: collision with root package name */
    public c f4608f = new c();

    public static b p() {
        if (f4607g != null) {
            return f4607g;
        }
        synchronized (b.class) {
            if (f4607g == null) {
                f4607g = new b();
            }
        }
        return f4607g;
    }
}
