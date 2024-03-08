package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.f;
import androidx.emoji2.text.l;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer.b f1525f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f.h f1526g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f1527h;

    public /* synthetic */ g(EmojiCompatInitializer.b bVar, f.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f1525f = bVar;
        this.f1526g = hVar;
        this.f1527h = threadPoolExecutor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EmojiCompatInitializer.b bVar = this.f1525f;
        f.h hVar = this.f1526g;
        ThreadPoolExecutor threadPoolExecutor = this.f1527h;
        bVar.getClass();
        try {
            l a7 = c.a(bVar.f1503a);
            if (a7 != null) {
                l.b bVar2 = (l.b) a7.f1520a;
                synchronized (bVar2.f1549d) {
                    bVar2.f1550f = threadPoolExecutor;
                }
                a7.f1520a.a(new h(hVar, threadPoolExecutor));
                return;
            }
            throw new RuntimeException("EmojiCompat font provider not available on this device.");
        } catch (Throwable th) {
            hVar.a(th);
            threadPoolExecutor.shutdown();
        }
    }
}
