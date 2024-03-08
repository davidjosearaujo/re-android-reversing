package androidx.activity;

import android.window.BackEvent;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b {

    /* renamed from: a */
    public final float f403a;

    /* renamed from: b */
    public final float f404b;

    /* renamed from: c */
    public final float f405c;

    /* renamed from: d */
    public final int f406d;

    public b(BackEvent backEvent) {
        h.f(backEvent, "backEvent");
        a aVar = a.f402a;
        float d7 = aVar.d(backEvent);
        float e = aVar.e(backEvent);
        float b2 = aVar.b(backEvent);
        int c7 = aVar.c(backEvent);
        this.f403a = d7;
        this.f404b = e;
        this.f405c = b2;
        this.f406d = c7;
    }

    public final String toString() {
        StringBuilder d7 = h.d("BackEventCompat{touchX=");
        d7.append(this.f403a);
        d7.append(", touchY=");
        d7.append(this.f404b);
        d7.append(", progress=");
        d7.append(this.f405c);
        d7.append(", swipeEdge=");
        d7.append(this.f406d);
        d7.append('}');
        return d7.toString();
    }
}
