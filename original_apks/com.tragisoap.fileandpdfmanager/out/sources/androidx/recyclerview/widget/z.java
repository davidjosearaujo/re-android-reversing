package androidx.recyclerview.widget;

import android.view.View;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final b f2284a;

    /* renamed from: b  reason: collision with root package name */
    public a f2285b = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2286a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f2287b;

        /* renamed from: c  reason: collision with root package name */
        public int f2288c;

        /* renamed from: d  reason: collision with root package name */
        public int f2289d;
        public int e;

        public final boolean a() {
            int i7 = this.f2286a;
            int i8 = 2;
            if ((i7 & 7) != 0) {
                int i9 = this.f2289d;
                int i10 = this.f2287b;
                if ((((i9 > i10 ? 1 : i9 == i10 ? 2 : 4) << 0) & i7) == 0) {
                    return false;
                }
            }
            if ((i7 & 112) != 0) {
                int i11 = this.f2289d;
                int i12 = this.f2288c;
                if ((((i11 > i12 ? 1 : i11 == i12 ? 2 : 4) << 4) & i7) == 0) {
                    return false;
                }
            }
            if ((i7 & 1792) != 0) {
                int i13 = this.e;
                int i14 = this.f2287b;
                if ((((i13 > i14 ? 1 : i13 == i14 ? 2 : 4) << 8) & i7) == 0) {
                    return false;
                }
            }
            if ((i7 & 28672) != 0) {
                int i15 = this.e;
                int i16 = this.f2288c;
                if (i15 > i16) {
                    i8 = 1;
                } else if (i15 != i16) {
                    i8 = 4;
                }
                if (((i8 << 12) & i7) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        int a();

        int b(View view);

        View c(int i7);

        int d();

        int e(View view);
    }

    public z(b bVar) {
        this.f2284a = bVar;
    }

    public final View a(int i7, int i8, int i9, int i10) {
        int d7 = this.f2284a.d();
        int a7 = this.f2284a.a();
        int i11 = i8 > i7 ? 1 : -1;
        View view = null;
        while (i7 != i8) {
            View c7 = this.f2284a.c(i7);
            int b2 = this.f2284a.b(c7);
            int e = this.f2284a.e(c7);
            a aVar = this.f2285b;
            aVar.f2287b = d7;
            aVar.f2288c = a7;
            aVar.f2289d = b2;
            aVar.e = e;
            if (i9 != 0) {
                aVar.f2286a = i9 | 0;
                if (aVar.a()) {
                    return c7;
                }
            }
            if (i10 != 0) {
                a aVar2 = this.f2285b;
                aVar2.f2286a = i10 | 0;
                if (aVar2.a()) {
                    view = c7;
                }
            }
            i7 += i11;
        }
        return view;
    }

    public final boolean b(View view) {
        a aVar = this.f2285b;
        int d7 = this.f2284a.d();
        int a7 = this.f2284a.a();
        int b2 = this.f2284a.b(view);
        int e = this.f2284a.e(view);
        aVar.f2287b = d7;
        aVar.f2288c = a7;
        aVar.f2289d = b2;
        aVar.e = e;
        a aVar2 = this.f2285b;
        aVar2.f2286a = 24579 | 0;
        return aVar2.a();
    }
}
