package b.a.a.a.e;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class q implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ l f173a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ p f174b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, l lVar) {
        this.f174b = pVar;
        this.f173a = lVar;
    }

    @Override // com.google.android.gms.common.api.f.a
    public final void a(Status status) {
        this.f174b.f169a.remove(this.f173a);
    }
}
