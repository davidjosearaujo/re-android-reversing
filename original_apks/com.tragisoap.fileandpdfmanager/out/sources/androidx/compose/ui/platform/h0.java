package androidx.compose.ui.platform;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import c6.b;
import c6.e;
import f5.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h0 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e<g> f1179a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(b bVar, Handler handler) {
        super(handler);
        this.f1179a = bVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z6, Uri uri) {
        this.f1179a.t(g.f4141a);
    }
}
