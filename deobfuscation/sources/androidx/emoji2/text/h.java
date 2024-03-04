package androidx.emoji2.text;

import androidx.emoji2.text.f;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class h extends f.h {

    /* renamed from: a */
    public final /* synthetic */ f.h f1528a;

    /* renamed from: b */
    public final /* synthetic */ ThreadPoolExecutor f1529b;

    public h(f.h hVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f1528a = hVar;
        this.f1529b = threadPoolExecutor;
    }

    @Override // androidx.emoji2.text.f.h
    public final void a(Throwable th) {
        try {
            this.f1528a.a(th);
        } finally {
            this.f1529b.shutdown();
        }
    }

    @Override // androidx.emoji2.text.f.h
    public final void b(n nVar) {
        try {
            this.f1528a.b(nVar);
        } finally {
            this.f1529b.shutdown();
        }
    }
}
