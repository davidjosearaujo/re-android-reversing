package i6;

/* loaded from: classes.dex */
public abstract class i implements v {

    /* renamed from: f */
    public final v f4507f;

    public i(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4507f = vVar;
    }

    @Override // i6.v
    public long B(d dVar, long j5) {
        return this.f4507f.B(dVar, j5);
    }

    @Override // i6.v
    public final w c() {
        return this.f4507f.c();
    }

    @Override // i6.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4507f.close();
    }

    public final String toString() {
        return getClass().getSimpleName() + "(" + this.f4507f.toString() + ")";
    }
}
