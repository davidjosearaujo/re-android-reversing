package b.a.a.a.e;

import b.a.a.a.c.a;
import java.util.Collections;
/* loaded from: /home/remnux/decompressedMalicious.dex */
final class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a f190a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ y f191b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, a aVar) {
        this.f191b = yVar;
        this.f190a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f190a.h()) {
            this.f191b.e = true;
            if (this.f191b.f188a.a()) {
                this.f191b.h();
            } else {
                this.f191b.f188a.b(null, Collections.emptySet());
            }
        } else {
            ((v) this.f191b.f.i.get(this.f191b.f189b)).b(this.f190a);
        }
    }
}
