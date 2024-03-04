package b3;

import java.io.File;
import r2.v;

/* loaded from: classes.dex */
public final class b implements v<File> {

    /* renamed from: f */
    public final File f2373f;

    public b(File file) {
        q2.a.i(file);
        this.f2373f = file;
    }

    @Override // r2.v
    public final /* bridge */ /* synthetic */ int b() {
        return 1;
    }

    @Override // r2.v
    public final Class<File> c() {
        return this.f2373f.getClass();
    }

    @Override // r2.v
    public final File get() {
        return this.f2373f;
    }

    @Override // r2.v
    public final /* bridge */ /* synthetic */ void recycle() {
    }
}
