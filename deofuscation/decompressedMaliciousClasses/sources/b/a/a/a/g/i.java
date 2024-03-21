package b.a.a.a.g;

import java.util.ArrayDeque;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class i<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f209a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private Queue<h<TResult>> f210b;
    private boolean c;

    public final void a(c<TResult> cVar) {
        h<TResult> poll;
        synchronized (this.f209a) {
            if (this.f210b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.f209a) {
                        poll = this.f210b.poll();
                        if (poll == null) {
                            this.c = false;
                            return;
                        }
                    }
                    poll.a(cVar);
                }
            }
        }
    }

    public final void b(h<TResult> hVar) {
        synchronized (this.f209a) {
            if (this.f210b == null) {
                this.f210b = new ArrayDeque();
            }
            this.f210b.add(hVar);
        }
    }
}
