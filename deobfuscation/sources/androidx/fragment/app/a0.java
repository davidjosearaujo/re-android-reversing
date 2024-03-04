package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.d0;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a0 extends androidx.lifecycle.c0 {

    /* renamed from: i */
    public static final a f1574i = new a();

    /* renamed from: f */
    public final boolean f1577f;

    /* renamed from: c */
    public final HashMap<String, n> f1575c = new HashMap<>();

    /* renamed from: d */
    public final HashMap<String, a0> f1576d = new HashMap<>();
    public final HashMap<String, androidx.lifecycle.e0> e = new HashMap<>();

    /* renamed from: g */
    public boolean f1578g = false;

    /* renamed from: h */
    public boolean f1579h = false;

    /* loaded from: classes.dex */
    public class a implements d0.a {
        @Override // androidx.lifecycle.d0.a
        public final <T extends androidx.lifecycle.c0> T b(Class<T> cls) {
            return new a0(true);
        }
    }

    public a0(boolean z6) {
        this.f1577f = z6;
    }

    @Override // androidx.lifecycle.c0
    public final void b() {
        if (x.K(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1578g = true;
    }

    public final void c(n nVar) {
        if (this.f1579h) {
            if (x.K(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f1575c.remove(nVar.f1704j) != null) && x.K(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + nVar);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a0.class != obj.getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f1575c.equals(a0Var.f1575c) && this.f1576d.equals(a0Var.f1576d) && this.e.equals(a0Var.e);
    }

    public final int hashCode() {
        int hashCode = this.f1576d.hashCode();
        return this.e.hashCode() + ((hashCode + (this.f1575c.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<n> it = this.f1575c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1576d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
