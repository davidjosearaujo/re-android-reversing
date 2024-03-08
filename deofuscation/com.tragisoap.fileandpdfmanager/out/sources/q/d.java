package q;

import java.util.HashMap;
import java.util.LinkedHashSet;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5601a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5602b;

    public d(int i7, int i8) {
        this.f5601a = i7;
        if (i7 != 3) {
            this.f5602b = new HashMap();
        } else {
            this.f5602b = new LinkedHashSet();
        }
    }

    public final String toString() {
        switch (this.f5601a) {
            case 4:
                return '<' + ((String) this.f5602b) + '>';
            default:
                return super.toString();
        }
    }

    public /* synthetic */ d(int i7, Object obj) {
        this.f5601a = i7;
        this.f5602b = obj;
    }
}
