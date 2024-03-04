package z5;

import q5.l;

/* loaded from: classes.dex */
public final class h extends r5.i implements l<w5.c, String> {

    /* renamed from: g */
    public final /* synthetic */ CharSequence f6970g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(String str) {
        super(1);
        this.f6970g = str;
    }

    @Override // q5.l
    public final String k(w5.c cVar) {
        w5.c cVar2 = cVar;
        r5.h.f(cVar2, "it");
        CharSequence charSequence = this.f6970g;
        r5.h.f(charSequence, "<this>");
        return charSequence.subSequence(Integer.valueOf(cVar2.f6411f).intValue(), Integer.valueOf(cVar2.f6412g).intValue() + 1).toString();
    }
}
