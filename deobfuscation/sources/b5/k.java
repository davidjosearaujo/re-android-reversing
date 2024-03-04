package b5;

import androidx.fragment.app.s0;
import i6.r;
import java.util.Locale;
import java.util.regex.Matcher;
import y4.t;

/* loaded from: classes.dex */
public final class k extends t {

    /* renamed from: f */
    public final y4.l f2431f;

    /* renamed from: g */
    public final i6.f f2432g;

    public k(y4.l lVar, r rVar) {
        this.f2431f = lVar;
        this.f2432g = rVar;
    }

    @Override // y4.t
    public final long d() {
        return j.a(this.f2431f);
    }

    @Override // y4.t
    public final y4.o e() {
        String a7 = this.f2431f.a("Content-Type");
        if (a7 != null) {
            Matcher matcher = y4.o.f6761c.matcher(a7);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                Locale locale = Locale.US;
                group.toLowerCase(locale);
                matcher.group(2).toLowerCase(locale);
                Matcher matcher2 = y4.o.f6762d.matcher(a7);
                String str = null;
                for (int end = matcher.end(); end < a7.length(); end = matcher2.end()) {
                    matcher2.region(end, a7.length());
                    if (!matcher2.lookingAt()) {
                        return null;
                    }
                    String group2 = matcher2.group(1);
                    if (group2 != null && group2.equalsIgnoreCase("charset")) {
                        String group3 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                        if (str != null && !group3.equalsIgnoreCase(str)) {
                            throw new IllegalArgumentException(s0.h("Multiple different charsets: ", a7));
                        }
                        str = group3;
                    }
                }
                return new y4.o(a7, str);
            }
            return null;
        }
        return null;
    }

    @Override // y4.t
    public final i6.f f() {
        return this.f2432g;
    }
}
