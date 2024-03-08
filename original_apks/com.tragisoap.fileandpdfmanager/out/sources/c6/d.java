package c6;

import a6.g;
import q2.a;
import q5.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a */
    public static final j<Object> f2595a = new j<>(-1, null, null, 0);

    /* renamed from: b */
    public static final int f2596b = a.R("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);

    /* renamed from: c */
    public static final int f2597c = a.R("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12);

    /* renamed from: d */
    public static final q.d f2598d = new q.d(4, "BUFFERED");
    public static final q.d e = new q.d(4, "SHOULD_BUFFER");

    /* renamed from: f */
    public static final q.d f2599f = new q.d(4, "S_RESUMING_BY_RCV");

    /* renamed from: g */
    public static final q.d f2600g = new q.d(4, "RESUMING_BY_EB");

    /* renamed from: h */
    public static final q.d f2601h = new q.d(4, "POISONED");

    /* renamed from: i */
    public static final q.d f2602i = new q.d(4, "DONE_RCV");

    /* renamed from: j */
    public static final q.d f2603j = new q.d(4, "INTERRUPTED_SEND");

    /* renamed from: k */
    public static final q.d f2604k = new q.d(4, "INTERRUPTED_RCV");

    /* renamed from: l */
    public static final q.d f2605l = new q.d(4, "CHANNEL_CLOSED");
    public static final q.d m = new q.d(4, "SUSPEND");

    /* renamed from: n */
    public static final q.d f2606n = new q.d(4, "SUSPEND_NO_WAITER");

    /* renamed from: o */
    public static final q.d f2607o = new q.d(4, "FAILED");

    /* renamed from: p */
    public static final q.d f2608p = new q.d(4, "NO_RECEIVE_RESULT");

    /* renamed from: q */
    public static final q.d f2609q = new q.d(4, "CLOSE_HANDLER_CLOSED");

    /* renamed from: r */
    public static final q.d f2610r = new q.d(4, "CLOSE_HANDLER_INVOKED");
    public static final q.d s = new q.d(4, "NO_CLOSE_CAUSE");

    public static final <T> boolean a(g<? super T> gVar, T t5, l<? super Throwable, f5.g> lVar) {
        if (gVar.c(t5, lVar) == null) {
            return false;
        }
        gVar.h();
        return true;
    }
}
