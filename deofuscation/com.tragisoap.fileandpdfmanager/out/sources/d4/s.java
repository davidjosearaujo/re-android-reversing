package d4;

import android.graphics.PorterDuff;
import android.view.View;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {

        /* renamed from: a */
        public int f3637a;

        /* renamed from: b */
        public int f3638b;

        /* renamed from: c */
        public int f3639c;

        public b(int i7, int i8, int i9, int i10) {
            this.f3637a = i7;
            this.f3638b = i9;
            this.f3639c = i10;
        }
    }

    public static boolean a(View view) {
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        return y.e.d(view) == 1;
    }

    public static PorterDuff.Mode b(int i7, PorterDuff.Mode mode) {
        if (i7 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i7 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i7 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i7) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
