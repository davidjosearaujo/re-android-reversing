package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import p.p0;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a */
    public static final Class<? extends Object>[] f1238a = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final boolean a(Object obj) {
        if (!(obj instanceof v.g)) {
            if ((obj instanceof f5.a) && (obj instanceof Serializable)) {
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
        v.g gVar = (v.g) obj;
        if (gVar.q() == p.w.f5454a || gVar.q() == p0.f5447a || gVar.q() == p.h0.f5433a) {
            T value = gVar.getValue();
            if (value == 0) {
                return true;
            }
            return a(value);
        }
        return false;
    }
}
