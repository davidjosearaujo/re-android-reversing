package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import f5.a;
import java.io.Serializable;
import p.h0;
import p.p0;
import p.w;
import v.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<? extends Object>[] f1238a = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final boolean a(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (!(gVar.q() == w.f5454a || gVar.q() == p0.f5447a || gVar.q() == h0.f5433a)) {
                return false;
            }
            T value = gVar.getValue();
            if (value == 0) {
                return true;
            }
            return a(value);
        } else if ((obj instanceof a) && (obj instanceof Serializable)) {
            return false;
        } else {
            Class<? extends Object>[] clsArr = f1238a;
            for (int i7 = 0; i7 < 7; i7++) {
                if (clsArr[i7].isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }
}
