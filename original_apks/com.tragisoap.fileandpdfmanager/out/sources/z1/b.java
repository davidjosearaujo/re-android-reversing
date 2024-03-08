package z1;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.o;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f6906a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f6907b;

    /* renamed from: c  reason: collision with root package name */
    public static Class<?> f6908c;

    @SuppressLint({"PrivateApi"})
    public b() {
        try {
            f6908c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f6908c;
        return cls != null ? new o(cls, charSequence) : super.newEditable(charSequence);
    }
}
