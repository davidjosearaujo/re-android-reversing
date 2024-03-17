package cn.jiguang.av;

import android.content.Context;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class e {
    private static final Comparator<d> a = new Comparator<d>() { // from class: cn.jiguang.av.e.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            if (dVar.equals(dVar2)) {
                return 0;
            }
            int i = dVar.b;
            int i2 = dVar2.b;
            if (i > i2) {
                return -1;
            }
            if (i < i2) {
                return 1;
            }
            int i3 = dVar.e;
            int i4 = dVar2.e;
            if (i3 > i4) {
                return -1;
            }
            if (i3 < i4) {
                return 1;
            }
            long j = dVar.d;
            if (j != 0) {
                long j2 = dVar2.d;
                if (j2 != 0) {
                    if (j < j2) {
                        return -1;
                    }
                    if (j > j2) {
                        return 1;
                    }
                }
            }
            long j3 = dVar.c;
            if (j3 != 0) {
                long j4 = dVar2.c;
                if (j4 != 0) {
                    if (j3 > j4 + 180000) {
                        return -1;
                    }
                    if (j3 < j4 - 180000) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    };

    public static LinkedHashSet<g> a(Context context, LinkedHashSet<g> linkedHashSet, long j) {
        if ((linkedHashSet != null ? linkedHashSet.size() : 0) == 0) {
            return new LinkedHashSet<>();
        }
        LinkedList linkedList = new LinkedList();
        Iterator<g> it = linkedHashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            g next = it.next();
            if (next.a()) {
                cn.jiguang.g.a<String> f = cn.jiguang.g.a.f(next.toString());
                d a2 = d.a((String) cn.jiguang.g.b.a(context, f));
                if (a2 == null) {
                    a2 = new d(next);
                }
                if (z) {
                    a2.e = 1;
                    z = false;
                }
                if (j > 0) {
                    a2.c = j;
                    cn.jiguang.g.b.a(context, f.a((cn.jiguang.g.a<String>) a2.a()));
                }
                linkedList.add(a2);
            }
        }
        LinkedList a3 = a(linkedList, a);
        LinkedHashSet<g> linkedHashSet2 = new LinkedHashSet<>();
        Iterator it2 = a3.iterator();
        while (it2.hasNext()) {
            Iterator it3 = ((LinkedList) it2.next()).iterator();
            while (it3.hasNext()) {
                linkedHashSet2.add(((d) it3.next()).a);
            }
        }
        return linkedHashSet2;
    }

    private static <T> LinkedList<LinkedList<T>> a(Collection<T> collection, Comparator<T> comparator) {
        boolean z;
        int size = collection != null ? collection.size() : 0;
        if (size == 0) {
            return new LinkedList<>();
        }
        LinkedList<LinkedList<T>> linkedList = new LinkedList<>();
        if (size == 1) {
            linkedList.add(new LinkedList<>(collection));
            return linkedList;
        }
        SecureRandom secureRandom = new SecureRandom();
        for (T t : collection) {
            for (int i = 0; i < linkedList.size(); i++) {
                LinkedList<T> linkedList2 = linkedList.get(i);
                int compare = comparator.compare(t, linkedList2.getFirst());
                if (compare == 0) {
                    linkedList2.add(secureRandom.nextInt(linkedList2.size() + 1), t);
                } else if (compare < 0) {
                    LinkedList<T> linkedList3 = new LinkedList<>();
                    linkedList3.add(t);
                    linkedList.add(i, linkedList3);
                }
                z = true;
            }
            z = false;
            if (!z) {
                LinkedList<T> linkedList4 = new LinkedList<>();
                linkedList4.add(t);
                linkedList.add(linkedList4);
            }
        }
        return linkedList;
    }

    public static void a(Context context, g gVar, int i, long j) {
        if (gVar != null) {
            cn.jiguang.g.a<String> f = cn.jiguang.g.a.f(gVar.toString());
            d a2 = d.a((String) cn.jiguang.g.b.a(context, f));
            if (a2 == null) {
                a2 = new d(gVar);
            }
            a2.d = j;
            a2.b = i;
            cn.jiguang.g.b.a(context, f.a((cn.jiguang.g.a<String>) a2.a()));
        }
    }
}
