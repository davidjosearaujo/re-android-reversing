package b5;

import androidx.fragment.app.s0;
import i6.f;
import i6.r;
import java.util.Locale;
import java.util.regex.Matcher;
import y4.l;
import y4.o;
import y4.t;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k extends t {

    /* renamed from: f */
    public final l f2431f;

    /* renamed from: g */
    public final f f2432g;

    public k(l lVar, r rVar) {
        this.f2431f = lVar;
        this.f2432g = rVar;
    }

    @Override // y4.t
    public final long d() {
        return j.a(this.f2431f);
    }

    @Override // y4.t
    public final o e() {
        String a7 = this.f2431f.a("Content-Type");
        if (a7 == null) {
            return null;
        }
        Matcher matcher = o.f6761c.matcher(a7);
        if (!matcher.lookingAt()) {
            return null;
        }
        String group = matcher.group(1);
        Locale locale = Locale.US;
        group.toLowerCase(locale);
        matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = o.f6762d.matcher(a7);
        String str = null;
        for (int end = matcher.end(); end < a7.length(); end = matcher2.end()) {
            matcher2.region(end, a7.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group2 = matcher2.group(1);
            if (group2 != null && group2.equalsIgnoreCase("charset")) {
                String group3 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (str == null || group3.equalsIgnoreCase(str)) {
                    str = group3;
                } else {
                    throw new IllegalArgumentException(s0.h("Multiple different charsets: ", a7));
                }
            }
        }
        return new o(a7, str);
    }

    @Override // y4.t
    public final f f() {
        return this.f2432g;
    }
}
