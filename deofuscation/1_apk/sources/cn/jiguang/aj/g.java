package cn.jiguang.aj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class g<E> {
    private Comparator<E> a;
    private int b;

    public g(Comparator<E> comparator) {
        a(comparator);
    }

    private boolean a(List<E> list, int i, int i2, E e) {
        while (i <= i2) {
            int i3 = (i + i2) >> 1;
            int compare = this.a.compare(list.get(i3), e);
            if (compare == 0) {
                this.b = i3;
                return true;
            } else if (compare < 0) {
                i = i3 + 1;
            } else {
                i2 = i3 - 1;
            }
        }
        this.b = i;
        return false;
    }

    public List<E> a(List<E> list, List<E> list2) {
        if (this.a == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int size = list.size();
        int size2 = list2.size();
        int i = size - 1;
        int i2 = size2 - 1;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size && i4 < size2) {
            E e = list.get(i3);
            E e2 = list2.get(i4);
            int compare = this.a.compare(e, e2);
            if (compare == 0) {
                arrayList.add(e);
            } else if (compare >= 0) {
                if (a(list2, i4 + 1, i2, e)) {
                    arrayList.add(e);
                    i4 = this.b + 1;
                } else {
                    i4 = this.b;
                }
                i3++;
            } else if (a(list, i3 + 1, i, e2)) {
                arrayList.add(e2);
                i3 = this.b;
            } else {
                i3 = this.b;
                i4++;
            }
            i3++;
            i4++;
        }
        return arrayList;
    }

    public void a(Comparator<E> comparator) {
        this.a = comparator;
    }
}
