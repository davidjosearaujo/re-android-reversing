package k2;

import android.view.View;
import androidx.fragment.app.s0;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b */
    public View f4667b;

    /* renamed from: a */
    public final HashMap f4666a = new HashMap();

    /* renamed from: c */
    public final ArrayList<h> f4668c = new ArrayList<>();

    @Deprecated
    public n() {
    }

    public n(View view) {
        this.f4667b = view;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            return this.f4667b == nVar.f4667b && this.f4666a.equals(nVar.f4666a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4666a.hashCode() + (this.f4667b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("TransitionValues@");
        d7.append(Integer.toHexString(hashCode()));
        d7.append(":\n");
        String h7 = s0.h(d7.toString() + "    view = " + this.f4667b + "\n", "    values:");
        for (String str : this.f4666a.keySet()) {
            h7 = h7 + "    " + str + ": " + this.f4666a.get(str) + "\n";
        }
        return h7;
    }
}
