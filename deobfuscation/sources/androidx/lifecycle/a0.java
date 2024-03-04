package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import java.util.Map;

/* loaded from: classes.dex */
public final class a0 implements a.b {

    /* renamed from: a */
    public final androidx.savedstate.a f1848a;

    /* renamed from: b */
    public boolean f1849b;

    /* renamed from: c */
    public Bundle f1850c;

    /* renamed from: d */
    public final f5.f f1851d;

    /* loaded from: classes.dex */
    public static final class a extends r5.i implements q5.a<b0> {

        /* renamed from: g */
        public final /* synthetic */ f0 f1852g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f0 f0Var) {
            super(0);
            this.f1852g = f0Var;
        }

        @Override // q5.a
        public final b0 d() {
            return z.a(this.f1852g);
        }
    }

    public a0(androidx.savedstate.a aVar, f0 f0Var) {
        r5.h.f(aVar, "savedStateRegistry");
        r5.h.f(f0Var, "viewModelStoreOwner");
        this.f1848a = aVar;
        this.f1851d = new f5.f(new a(f0Var));
    }

    @Override // androidx.savedstate.a.b
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1850c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((b0) this.f1851d.a()).f1853c.entrySet()) {
            String str = (String) entry.getKey();
            Bundle a7 = ((y) entry.getValue()).e.a();
            if (!r5.h.a(a7, Bundle.EMPTY)) {
                bundle.putBundle(str, a7);
            }
        }
        this.f1849b = false;
        return bundle;
    }

    public final void b() {
        if (this.f1849b) {
            return;
        }
        Bundle a7 = this.f1848a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1850c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (a7 != null) {
            bundle.putAll(a7);
        }
        this.f1850c = bundle;
        this.f1849b = true;
        b0 b0Var = (b0) this.f1851d.a();
    }
}
