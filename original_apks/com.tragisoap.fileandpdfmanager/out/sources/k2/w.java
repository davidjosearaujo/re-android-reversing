package k2;

import android.view.View;
import android.view.WindowId;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class w implements x {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f4684a;

    public w(View view) {
        this.f4684a = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof w) && ((w) obj).f4684a.equals(this.f4684a);
    }

    public final int hashCode() {
        return this.f4684a.hashCode();
    }
}
