package b5;

/* loaded from: classes.dex */
public final class l {
    public static String a(y4.m mVar) {
        int indexOf = mVar.f6753h.indexOf(47, mVar.f6747a.length() + 3);
        String str = mVar.f6753h;
        String substring = mVar.f6753h.substring(indexOf, y4.m.e(str, indexOf, str.length(), "?#"));
        String h7 = mVar.h();
        if (h7 != null) {
            return substring + '?' + h7;
        }
        return substring;
    }
}
