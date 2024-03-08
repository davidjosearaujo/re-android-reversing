package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import f5.f;
import java.util.Map;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a0 implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.savedstate.a f1848a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1849b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f1850c;

    /* renamed from: d  reason: collision with root package name */
    public final f f1851d;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements q5.a<b0> {

        /* renamed from: g  reason: collision with root package name */
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
        h.f(aVar, "savedStateRegistry");
        h.f(f0Var, "viewModelStoreOwner");
        this.f1848a = aVar;
        this.f1851d = new f(new a(f0Var));
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
            if (!h.a(a7, Bundle.EMPTY)) {
                bundle.putBundle(str, a7);
            }
        }
        this.f1849b = false;
        return bundle;
    }

    public final void b() {
        if (!this.f1849b) {
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
}
