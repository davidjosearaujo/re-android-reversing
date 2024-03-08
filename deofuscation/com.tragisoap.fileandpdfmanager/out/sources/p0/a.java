package p0;

import g5.n;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements CharSequence {

    /* renamed from: f */
    public final String f5456f;

    /* renamed from: g */
    public final List<C0091a<Object>> f5457g;

    /* renamed from: h */
    public final List<C0091a<Object>> f5458h;

    /* renamed from: i */
    public final List<C0091a<? extends Object>> f5459i;

    /* renamed from: p0.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0091a<T> {

        /* renamed from: a */
        public final T f5460a;

        /* renamed from: b */
        public final int f5461b;

        /* renamed from: c */
        public final int f5462c;

        /* renamed from: d */
        public final String f5463d;

        public C0091a(T t5, int i7, int i8, String str) {
            h.f(str, "tag");
            this.f5460a = t5;
            this.f5461b = i7;
            this.f5462c = i8;
            this.f5463d = str;
            if (!(i7 <= i8)) {
                throw new IllegalArgumentException("Reversed range is not supported".toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0091a)) {
                return false;
            }
            C0091a aVar = (C0091a) obj;
            return h.a(this.f5460a, aVar.f5460a) && this.f5461b == aVar.f5461b && this.f5462c == aVar.f5462c && h.a(this.f5463d, aVar.f5463d);
        }

        public final int hashCode() {
            T t5 = this.f5460a;
            int hashCode = t5 == null ? 0 : t5.hashCode();
            int hashCode2 = Integer.hashCode(this.f5461b);
            return this.f5463d.hashCode() + ((Integer.hashCode(this.f5462c) + ((hashCode2 + (hashCode * 31)) * 31)) * 31);
        }

        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("Range(item=");
            d7.append(this.f5460a);
            d7.append(", start=");
            d7.append(this.f5461b);
            d7.append(", end=");
            d7.append(this.f5462c);
            d7.append(", tag=");
            d7.append(this.f5463d);
            d7.append(')');
            return d7.toString();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            return q2.a.m(Integer.valueOf(((C0091a) t5).f5461b), Integer.valueOf(((C0091a) t6).f5461b));
        }
    }

    public a() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String str, List<C0091a<Object>> list, List<C0091a<Object>> list2, List<? extends C0091a<? extends Object>> list3) {
        List list4;
        this.f5456f = str;
        this.f5457g = list;
        this.f5458h = list2;
        this.f5459i = list3;
        if (list2 != null) {
            b bVar = new b();
            if (list2.size() <= 1) {
                list4 = n.b0(list2);
            } else {
                Object[] array = list2.toArray(new Object[0]);
                h.f(array, "<this>");
                if (array.length > 1) {
                    Arrays.sort(array, bVar);
                }
                list4 = Arrays.asList(array);
                h.e(list4, "asList(...)");
            }
            int size = list4.size();
            int i7 = -1;
            for (int i8 = 0; i8 < size; i8++) {
                C0091a aVar = (C0091a) list4.get(i8);
                if (!(aVar.f5461b >= i7)) {
                    throw new IllegalArgumentException("ParagraphStyle should not overlap".toString());
                } else if (aVar.f5462c <= this.f5456f.length()) {
                    i7 = aVar.f5462c;
                } else {
                    StringBuilder d7 = androidx.activity.h.d("ParagraphStyle range [");
                    d7.append(aVar.f5461b);
                    d7.append(", ");
                    d7.append(aVar.f5462c);
                    d7.append(") is out of boundary");
                    throw new IllegalArgumentException(d7.toString().toString());
                }
            }
        }
    }

    /* renamed from: a */
    public final a subSequence(int i7, int i8) {
        if (!(i7 <= i8)) {
            throw new IllegalArgumentException(("start (" + i7 + ") should be less or equal to end (" + i8 + ')').toString());
        } else if (i7 == 0 && i8 == this.f5456f.length()) {
            return this;
        } else {
            String substring = this.f5456f.substring(i7, i8);
            h.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return new a(substring, b.a(i7, i8, this.f5457g), b.a(i7, i8, this.f5458h), b.a(i7, i8, this.f5459i));
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i7) {
        return this.f5456f.charAt(i7);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return h.a(this.f5456f, aVar.f5456f) && h.a(this.f5457g, aVar.f5457g) && h.a(this.f5458h, aVar.f5458h) && h.a(this.f5459i, aVar.f5459i);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int hashCode = this.f5456f.hashCode() * 31;
        List<C0091a<Object>> list = this.f5457g;
        int i7 = 0;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<C0091a<Object>> list2 = this.f5458h;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<C0091a<? extends Object>> list3 = this.f5459i;
        if (list3 != null) {
            i7 = list3.hashCode();
        }
        return hashCode3 + i7;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f5456f.length();
    }

    @Override // java.lang.CharSequence, java.lang.Object
    public final String toString() {
        return this.f5456f;
    }
}
