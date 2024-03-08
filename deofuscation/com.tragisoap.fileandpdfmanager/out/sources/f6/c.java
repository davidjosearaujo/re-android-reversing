package f6;

import a6.x;
import androidx.activity.h;
import i5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c implements x {

    /* renamed from: f  reason: collision with root package name */
    public final f f4145f;

    public c(f fVar) {
        this.f4145f = fVar;
    }

    @Override // a6.x
    public final f l() {
        return this.f4145f;
    }

    public final String toString() {
        StringBuilder d7 = h.d("CoroutineScope(coroutineContext=");
        d7.append(this.f4145f);
        d7.append(')');
        return d7.toString();
    }
}
