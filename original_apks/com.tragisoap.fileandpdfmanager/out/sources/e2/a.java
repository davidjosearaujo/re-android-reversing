package e2;

import androidx.activity.result.c;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.e0;
import androidx.lifecycle.n;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.io.PrintWriter;
import l0.z;
import o.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends c {

    /* renamed from: f  reason: collision with root package name */
    public final n f3758f;

    /* renamed from: g  reason: collision with root package name */
    public final b f3759g;

    /* renamed from: e2.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0049a<D> extends r<D> {
        @Override // androidx.lifecycle.LiveData
        public final void e() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public final void f() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public final void g(s<? super D> sVar) {
            super.g(sVar);
        }

        @Override // androidx.lifecycle.r
        public final void h(D d7) {
            super.h(d7);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            z.l(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends c0 {

        /* renamed from: d  reason: collision with root package name */
        public static final C0050a f3760d = new C0050a();

        /* renamed from: c  reason: collision with root package name */
        public i<C0049a> f3761c = new i<>();

        /* renamed from: e2.a$b$a  reason: collision with other inner class name */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static class C0050a implements d0.a {
            @Override // androidx.lifecycle.d0.a
            public final <T extends c0> T b(Class<T> cls) {
                return new b();
            }
        }

        @Override // androidx.lifecycle.c0
        public final void b() {
            i<C0049a> iVar = this.f3761c;
            int i7 = iVar.f5225h;
            if (i7 <= 0) {
                Object[] objArr = iVar.f5224g;
                for (int i8 = 0; i8 < i7; i8++) {
                    objArr[i8] = null;
                }
                iVar.f5225h = 0;
                return;
            }
            ((C0049a) iVar.f5224g[0]).getClass();
            throw null;
        }
    }

    public a(n nVar, e0 e0Var) {
        this.f3758f = nVar;
        this.f3759g = (b) new d0(e0Var, b.f3760d).a(b.class);
    }

    @Deprecated
    public final void p(String str, PrintWriter printWriter) {
        b bVar = this.f3759g;
        if (bVar.f3761c.f5225h > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            i<C0049a> iVar = bVar.f3761c;
            if (iVar.f5225h > 0) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(bVar.f3761c.f5223f[0]);
                printWriter.print(": ");
                printWriter.println(((C0049a) iVar.f5224g[0]).toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(0);
                printWriter.print(" mArgs=");
                printWriter.println((Object) null);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println((Object) null);
                throw null;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        z.l(this.f3758f, sb);
        sb.append("}}");
        return sb.toString();
    }
}
