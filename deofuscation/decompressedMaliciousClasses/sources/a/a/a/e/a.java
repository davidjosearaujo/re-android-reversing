package a.a.a.e;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final AbstractC0002a f108a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.a.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public interface AbstractC0002a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class b implements AbstractC0002a {
        b() {
        }

        @Override // a.a.a.e.a.AbstractC0002a
        public void a(LayoutInflater layoutInflater, e eVar) {
            b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class c extends b {
        c() {
        }

        @Override // a.a.a.e.a.b, a.a.a.e.a.AbstractC0002a
        public void a(LayoutInflater layoutInflater, e eVar) {
            c.b(layoutInflater, eVar);
        }
    }

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class d extends c {
        d() {
        }

        @Override // a.a.a.e.a.c, a.a.a.e.a.b, a.a.a.e.a.AbstractC0002a
        public void a(LayoutInflater layoutInflater, e eVar) {
            d.a(layoutInflater, eVar);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f108a = i >= 21 ? new d() : i >= 11 ? new c() : new b();
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        f108a.a(layoutInflater, eVar);
    }
}
