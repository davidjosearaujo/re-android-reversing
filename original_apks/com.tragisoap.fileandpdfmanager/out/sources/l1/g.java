package l1;

import android.os.LocaleList;
import java.util.Locale;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final LocaleList f4946a;

    public g(Object obj) {
        this.f4946a = (LocaleList) obj;
    }

    @Override // l1.f
    public final String a() {
        return this.f4946a.toLanguageTags();
    }

    @Override // l1.f
    public final Object b() {
        return this.f4946a;
    }

    public final boolean equals(Object obj) {
        return this.f4946a.equals(((f) obj).b());
    }

    @Override // l1.f
    public final Locale get(int i7) {
        return this.f4946a.get(i7);
    }

    public final int hashCode() {
        return this.f4946a.hashCode();
    }

    @Override // l1.f
    public final boolean isEmpty() {
        return this.f4946a.isEmpty();
    }

    @Override // l1.f
    public final int size() {
        return this.f4946a.size();
    }

    public final String toString() {
        return this.f4946a.toString();
    }
}
