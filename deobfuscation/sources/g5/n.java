package g5;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class n extends m {
    public static final <T> T W(List<? extends T> list) {
        r5.h.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T> T X(List<? extends T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final void Y(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, q5.l lVar) {
        CharSequence charSequence5;
        r5.h.f(iterable, "<this>");
        r5.h.f(charSequence, "separator");
        r5.h.f(charSequence2, "prefix");
        r5.h.f(charSequence3, "postfix");
        r5.h.f(charSequence4, "truncated");
        sb.append(charSequence2);
        Iterator it = iterable.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i8++;
            if (i8 > 1) {
                sb.append(charSequence);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                next = lVar.k(next);
            } else {
                if (!(next != null ? next instanceof CharSequence : true)) {
                    if (next instanceof Character) {
                        sb.append(((Character) next).charValue());
                    } else {
                        charSequence5 = String.valueOf(next);
                        sb.append(charSequence5);
                    }
                }
            }
            charSequence5 = (CharSequence) next;
            sb.append(charSequence5);
        }
        if (i7 >= 0 && i8 > i7) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static String Z(Iterable iterable, String str, String str2, String str3, q5.l lVar, int i7) {
        if ((i7 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i7 & 2) != 0 ? "" : str2;
        String str6 = (i7 & 4) != 0 ? "" : str3;
        int i8 = (i7 & 8) != 0 ? -1 : 0;
        String str7 = (i7 & 16) != 0 ? "..." : null;
        q5.l lVar2 = (i7 & 32) != 0 ? null : lVar;
        r5.h.f(iterable, "<this>");
        r5.h.f(str4, "separator");
        r5.h.f(str5, "prefix");
        r5.h.f(str6, "postfix");
        r5.h.f(str7, "truncated");
        StringBuilder sb = new StringBuilder();
        Y(iterable, sb, str4, str5, str6, i8, str7, lVar2);
        String sb2 = sb.toString();
        r5.h.e(sb2, "toString(...)");
        return sb2;
    }

    public static final void a0(Iterable iterable, AbstractCollection abstractCollection) {
        r5.h.f(iterable, "<this>");
        for (Object obj : iterable) {
            abstractCollection.add(obj);
        }
    }

    public static final <T> List<T> b0(Iterable<? extends T> iterable) {
        ArrayList arrayList;
        r5.h.f(iterable, "<this>");
        boolean z6 = iterable instanceof Collection;
        if (z6) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return c0(collection);
                }
                return q2.a.G(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            }
            return p.f4284f;
        }
        if (z6) {
            arrayList = c0((Collection) iterable);
        } else {
            ArrayList arrayList2 = new ArrayList();
            a0(iterable, arrayList2);
            arrayList = arrayList2;
        }
        int size2 = arrayList.size();
        return size2 != 0 ? size2 != 1 ? arrayList : q2.a.G(arrayList.get(0)) : p.f4284f;
    }

    public static final ArrayList c0(Collection collection) {
        r5.h.f(collection, "<this>");
        return new ArrayList(collection);
    }
}
