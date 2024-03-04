package androidx.compose.ui.platform;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* loaded from: classes.dex */
public final class h0 extends ContentObserver {

    /* renamed from: a */
    public final /* synthetic */ c6.e<f5.g> f1179a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(c6.b bVar, Handler handler) {
        super(handler);
        this.f1179a = bVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z6, Uri uri) {
        this.f1179a.t(f5.g.f4141a);
    }
}
