package b.a.a.a.e;

import b.a.a.a.f.d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.j;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class a1 implements d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static abstract class a extends v0<d.b> {
        protected w0 p = new c1(this);

        public a(e eVar) {
            super(eVar);
        }

        @Override // b.a.a.a.e.l
        public final /* synthetic */ j g(Status status) {
            return new b(status, false);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class b implements d.b {

        /* renamed from: a */
        private Status f135a;

        /* renamed from: b */
        private boolean f136b;

        public b(Status status, boolean z) {
            this.f135a = status;
            this.f136b = z;
        }

        @Override // b.a.a.a.f.d.b
        public final boolean a() {
            Status status = this.f135a;
            if (status == null || !status.f()) {
                return false;
            }
            return this.f136b;
        }

        @Override // com.google.android.gms.common.api.j
        public final Status b() {
            return this.f135a;
        }
    }

    @Override // b.a.a.a.f.d
    public f<d.b> a(e eVar) {
        return eVar.b(new b1(this, eVar));
    }
}
