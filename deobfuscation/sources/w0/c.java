package w0;

import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.l;
import java.util.ArrayList;
import java.util.HashSet;
import o.h;
import p.o;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public Object f6337a;

    /* renamed from: b */
    public Object f6338b;

    /* renamed from: c */
    public Object f6339c;

    /* renamed from: d */
    public Object f6340d;

    public c(int i7) {
        if (i7 == 1) {
            this.f6337a = new o1.e(10);
            this.f6338b = new h();
            this.f6339c = new ArrayList();
            this.f6340d = new HashSet();
        } else if (i7 != 2) {
            this.f6337a = new o(256, 2);
            this.f6338b = new o(256, 2);
            this.f6339c = new o(256, 2);
            this.f6340d = new f[32];
        } else {
            this.f6337a = new o.b();
            this.f6338b = new SparseArray();
            this.f6339c = new o.e();
            this.f6340d = new o.b();
        }
    }

    public /* synthetic */ c(FrameLayout frameLayout, FrameLayout frameLayout2, l lVar, ImageView imageView) {
        this.f6337a = frameLayout;
        this.f6338b = frameLayout2;
        this.f6339c = lVar;
        this.f6340d = imageView;
    }

    public final void a(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((h) this.f6338b).getOrDefault(obj, null);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i7 = 0; i7 < size; i7++) {
                a(arrayList2.get(i7), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }
}
