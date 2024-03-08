package z5;

import q5.l;
import r5.i;
import w5.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h extends i implements l<c, String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CharSequence f6970g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(String str) {
        super(1);
        this.f6970g = str;
    }

    @Override // q5.l
    public final String k(c cVar) {
        c cVar2 = cVar;
        r5.h.f(cVar2, "it");
        CharSequence charSequence = this.f6970g;
        r5.h.f(charSequence, "<this>");
        return charSequence.subSequence(Integer.valueOf(cVar2.f6411f).intValue(), Integer.valueOf(cVar2.f6412g).intValue() + 1).toString();
    }
}
