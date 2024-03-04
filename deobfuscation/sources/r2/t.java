package r2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l3.a;
import r2.j;

/* loaded from: classes.dex */
public final class t<Data, ResourceType, Transcode> {

    /* renamed from: a */
    public final o1.d<List<Throwable>> f5868a;

    /* renamed from: b */
    public final List<? extends k<Data, ResourceType, Transcode>> f5869b;

    /* renamed from: c */
    public final String f5870c;

    public t(Class cls, Class cls2, Class cls3, List list, a.c cVar) {
        this.f5868a = cVar;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f5869b = list;
        StringBuilder d7 = androidx.activity.h.d("Failed LoadPath{");
        d7.append(cls.getSimpleName());
        d7.append("->");
        d7.append(cls2.getSimpleName());
        d7.append("->");
        d7.append(cls3.getSimpleName());
        d7.append("}");
        this.f5870c = d7.toString();
    }

    public final v a(int i7, int i8, p2.h hVar, com.bumptech.glide.load.data.e eVar, j.b bVar) {
        List<Throwable> b2 = this.f5868a.b();
        q2.a.i(b2);
        List<Throwable> list = b2;
        try {
            int size = this.f5869b.size();
            v vVar = null;
            for (int i9 = 0; i9 < size; i9++) {
                try {
                    vVar = this.f5869b.get(i9).a(i7, i8, hVar, eVar, bVar);
                } catch (r e) {
                    list.add(e);
                }
                if (vVar != null) {
                    break;
                }
            }
            if (vVar != null) {
                return vVar;
            }
            throw new r(this.f5870c, new ArrayList(list));
        } finally {
            this.f5868a.a(list);
        }
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("LoadPath{decodePaths=");
        d7.append(Arrays.toString(this.f5869b.toArray()));
        d7.append('}');
        return d7.toString();
    }
}
