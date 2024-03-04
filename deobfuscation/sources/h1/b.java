package h1;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public static final ThreadLocal<TypedValue> f4338a = new ThreadLocal<>();

    public static ColorStateList a(Resources resources, XmlResourceParser xmlResourceParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlResourceParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:634:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:647:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:673:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:751:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:756:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:763:0x0355  */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r2v37, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.res.ColorStateList b(android.content.res.Resources r38, android.content.res.XmlResourceParser r39, android.util.AttributeSet r40, android.content.res.Resources.Theme r41) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.b.b(android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }
}