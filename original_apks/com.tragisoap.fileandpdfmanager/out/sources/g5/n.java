package g5;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import q2.a;
import q5.l;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class n extends m {
    public static final <T> T W(List<? extends T> list) {
        h.f(list, "<this>");
        if (!list.isEmpty()) {
            return (T) list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T X(List<? extends T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

    public static final void Y(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, l lVar) {
        CharSequence charSequence5;
        h.f(iterable, "<this>");
        h.f(charSequence, "separator");
        h.f(charSequence2, "prefix");
        h.f(charSequence3, "postfix");
        h.f(charSequence4, "truncated");
        sb.append(charSequence2);
        int i8 = 0;
        for (Object obj : iterable) {
            i8++;
            boolean z6 = true;
            if (i8 > 1) {
                sb.append(charSequence);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                obj = lVar.k(obj);
            } else {
                if (obj != null) {
                    z6 = obj instanceof CharSequence;
                }
                if (!z6) {
                    if (obj instanceof Character) {
                        sb.append(((Character) obj).charValue());
                    } else {
                        charSequence5 = String.valueOf(obj);
                        sb.append(charSequence5);
                    }
                }
            }
            charSequence5 = (CharSequence) obj;
            sb.append(charSequence5);
        }
        if (i7 >= 0 && i8 > i7) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static String Z(Iterable iterable, String str, String str2, String str3, l lVar, int i7) {
        if ((i7 & 1) != 0) {
            str = ", ";
        }
        String str4 = (i7 & 2) != 0 ? "" : str2;
        String str5 = (i7 & 4) != 0 ? "" : str3;
        int i8 = (i7 & 8) != 0 ? -1 : 0;
        String str6 = (i7 & 16) != 0 ? "..." : null;
        l lVar2 = (i7 & 32) != 0 ? null : lVar;
        h.f(iterable, "<this>");
        h.f(str, "separator");
        h.f(str4, "prefix");
        h.f(str5, "postfix");
        h.f(str6, "truncated");
        StringBuilder sb = new StringBuilder();
        Y(iterable, sb, str, str4, str5, i8, str6, lVar2);
        String sb2 = sb.toString();
        h.e(sb2, "toString(...)");
        return sb2;
    }

    public static final void a0(Iterable iterable, AbstractCollection abstractCollection) {
        h.f(iterable, "<this>");
        for (Object obj : iterable) {
            abstractCollection.add(obj);
        }
    }

    public static final <T> List<T> b0(Iterable<? extends T> iterable) {
        ArrayList arrayList;
        h.f(iterable, "<this>");
        boolean z6 = iterable instanceof Collection;
        if (z6) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return p.f4284f;
            }
            if (size != 1) {
                return c0(collection);
            }
            return a.G(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        if (z6) {
            arrayList = c0((Collection) iterable);
        } else {
            ArrayList arrayList2 = new ArrayList();
            a0(iterable, arrayList2);
            arrayList = arrayList2;
        }
        int size2 = arrayList.size();
        return size2 != 0 ? size2 != 1 ? arrayList : a.G(arrayList.get(0)) : p.f4284f;
    }

    public static final ArrayList c0(Collection collection) {
        h.f(collection, "<this>");
        return new ArrayList(collection);
    }
}
