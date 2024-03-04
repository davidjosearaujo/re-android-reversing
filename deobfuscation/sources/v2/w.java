package v2;

import android.net.Uri;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import v2.n;

/* loaded from: classes.dex */
public final class w<Data> implements n<Uri, Data> {

    /* renamed from: b */
    public static final Set<String> f6262b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a */
    public final n<f, Data> f6263a;

    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        @Override // v2.o
        public final n<Uri, InputStream> b(r rVar) {
            return new w(rVar.b(f.class, InputStream.class));
        }
    }

    public w(n<f, Data> nVar) {
        this.f6263a = nVar;
    }

    @Override // v2.n
    public final n.a a(Uri uri, int i7, int i8, p2.h hVar) {
        return this.f6263a.a(new f(uri.toString()), i7, i8, hVar);
    }

    @Override // v2.n
    public final boolean b(Uri uri) {
        return f6262b.contains(uri.getScheme());
    }
}
