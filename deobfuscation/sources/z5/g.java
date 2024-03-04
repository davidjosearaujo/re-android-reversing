package z5;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import q5.p;

/* loaded from: classes.dex */
public final class g extends r5.i implements p<CharSequence, Integer, f5.c<? extends Integer, ? extends Integer>> {

    /* renamed from: g */
    public final /* synthetic */ List<String> f6968g;

    /* renamed from: h */
    public final /* synthetic */ boolean f6969h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(List<String> list, boolean z6) {
        super(2);
        this.f6968g = list;
        this.f6969h = z6;
    }

    @Override // q5.p
    public final f5.c<? extends Integer, ? extends Integer> i(CharSequence charSequence, Integer num) {
        Object obj;
        f5.c cVar;
        Object obj2;
        CharSequence charSequence2 = charSequence;
        int intValue = num.intValue();
        r5.h.f(charSequence2, "$this$$receiver");
        List<String> list = this.f6968g;
        boolean z6 = this.f6969h;
        if (z6 || list.size() != 1) {
            if (intValue < 0) {
                intValue = 0;
            }
            w5.c cVar2 = new w5.c(intValue, charSequence2.length());
            if (charSequence2 instanceof String) {
                int i7 = cVar2.f6412g;
                int i8 = cVar2.f6413h;
                if ((i8 > 0 && intValue <= i7) || (i8 < 0 && i7 <= intValue)) {
                    while (true) {
                        Iterator<T> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (f.W(0, intValue, str.length(), str, (String) charSequence2, z6)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (intValue == i7) {
                                break;
                            }
                            intValue += i8;
                        } else {
                            cVar = new f5.c(Integer.valueOf(intValue), str2);
                            break;
                        }
                    }
                }
                cVar = null;
            } else {
                int i9 = cVar2.f6412g;
                int i10 = cVar2.f6413h;
                if ((i10 > 0 && intValue <= i9) || (i10 < 0 && i9 <= intValue)) {
                    while (true) {
                        Iterator<T> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (i.c0(str3, charSequence2, intValue, str3.length(), z6)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (intValue == i9) {
                                break;
                            }
                            intValue += i10;
                        } else {
                            cVar = new f5.c(Integer.valueOf(intValue), str4);
                            break;
                        }
                    }
                }
                cVar = null;
            }
        } else {
            int size = list.size();
            if (size == 0) {
                throw new NoSuchElementException("List is empty.");
            }
            if (size != 1) {
                throw new IllegalArgumentException("List has more than one element.");
            }
            String str5 = list.get(0);
            int a02 = i.a0(charSequence2, str5, intValue, false, 4);
            if (a02 >= 0) {
                cVar = new f5.c(Integer.valueOf(a02), str5);
            }
            cVar = null;
        }
        if (cVar != null) {
            return new f5.c<>(cVar.f4135f, Integer.valueOf(((String) cVar.f4136g).length()));
        }
        return null;
    }
}
