package androidx.activity.result;

import androidx.activity.h;
import d.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends c {

    /* renamed from: f */
    public final /* synthetic */ String f441f;

    /* renamed from: g */
    public final /* synthetic */ a f442g;

    /* renamed from: h */
    public final /* synthetic */ f f443h;

    public d(f fVar, String str, a aVar) {
        this.f443h = fVar;
        this.f441f = str;
        this.f442g = aVar;
    }

    public final void p(Object obj) {
        Integer num = (Integer) this.f443h.f447b.get(this.f441f);
        if (num != null) {
            this.f443h.f449d.add(this.f441f);
            try {
                this.f443h.b(num.intValue(), this.f442g, obj);
            } catch (Exception e) {
                this.f443h.f449d.remove(this.f441f);
                throw e;
            }
        } else {
            StringBuilder d7 = h.d("Attempting to launch an unregistered ActivityResultLauncher with contract ");
            d7.append(this.f442g);
            d7.append(" and input ");
            d7.append(obj);
            d7.append(". You must ensure the ActivityResultLauncher is registered before calling launch().");
            throw new IllegalStateException(d7.toString());
        }
    }
}
