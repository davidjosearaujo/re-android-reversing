package b5;

import y4.m;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l {
    public static String a(m mVar) {
        int indexOf = mVar.f6753h.indexOf(47, mVar.f6747a.length() + 3);
        String str = mVar.f6753h;
        String substring = mVar.f6753h.substring(indexOf, m.e(str, indexOf, str.length(), "?#"));
        String h7 = mVar.h();
        if (h7 == null) {
            return substring;
        }
        return substring + '?' + h7;
    }
}
