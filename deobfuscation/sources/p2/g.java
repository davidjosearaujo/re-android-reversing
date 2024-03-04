package p2;

import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class g<T> {
    public static final a e = new a();

    /* renamed from: a */
    public final T f5565a;

    /* renamed from: b */
    public final b<T> f5566b;

    /* renamed from: c */
    public final String f5567c;

    /* renamed from: d */
    public volatile byte[] f5568d;

    /* loaded from: classes.dex */
    public class a implements b<Object> {
        @Override // p2.g.b
        public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        void a(byte[] bArr, T t5, MessageDigest messageDigest);
    }

    public g(String str, T t5, b<T> bVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.f5567c = str;
        this.f5565a = t5;
        this.f5566b = bVar;
    }

    public static g a(Object obj, String str) {
        return new g(str, obj, e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f5567c.equals(((g) obj).f5567c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5567c.hashCode();
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("Option{key='");
        d7.append(this.f5567c);
        d7.append('\'');
        d7.append('}');
        return d7.toString();
    }
}
