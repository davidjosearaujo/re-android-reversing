package i6;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class i implements v {

    /* renamed from: f  reason: collision with root package name */
    public final v f4507f;

    public i(v vVar) {
        if (vVar != null) {
            this.f4507f = vVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // i6.v
    public long B(d dVar, long j7) {
        return this.f4507f.B(dVar, j7);
    }

    @Override // i6.v
    public final w c() {
        return this.f4507f.c();
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4507f.close();
    }

    @Override // java.lang.Object
    public final String toString() {
        return getClass().getSimpleName() + "(" + this.f4507f.toString() + ")";
    }
}
