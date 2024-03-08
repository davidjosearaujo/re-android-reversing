package b3;

import java.io.File;
import q2.a;
import r2.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements v<File> {

    /* renamed from: f  reason: collision with root package name */
    public final File f2373f;

    public b(File file) {
        a.i(file);
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
