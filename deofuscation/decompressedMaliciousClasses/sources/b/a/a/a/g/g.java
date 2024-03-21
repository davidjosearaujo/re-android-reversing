package b.a.a.a.g;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ c f207a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ f f208b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, c cVar) {
        this.f208b = fVar;
        this.f207a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f208b.f206b) {
            if (this.f208b.c != null) {
                this.f208b.c.a(this.f207a);
            }
        }
    }
}
