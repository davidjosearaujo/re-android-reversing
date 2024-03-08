package androidx.emoji2.text;

import androidx.emoji2.text.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends f.h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f.a f1507a;

    public e(f.a aVar) {
        this.f1507a = aVar;
    }

    @Override // androidx.emoji2.text.f.h
    public final void a(Throwable th) {
        this.f1507a.f1519a.d(th);
    }

    @Override // androidx.emoji2.text.f.h
    public final void b(n nVar) {
        f.a aVar = this.f1507a;
        aVar.f1518c = nVar;
        aVar.f1517b = new j(aVar.f1518c, new f.i(), aVar.f1519a.f1516h);
        aVar.f1519a.e();
    }
}
