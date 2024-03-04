package q;

import i5.f;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public Object f5598a;

    /* renamed from: b */
    public Serializable f5599b;

    /* renamed from: c */
    public Object f5600c;

    public /* synthetic */ c(int i7, f fVar, c6.a aVar, d6.c cVar) {
        this.f5598a = cVar;
        this.f5599b = aVar;
        this.f5600c = fVar;
    }

    public final void a() {
        b[] bVarArr = (b[]) this.f5600c;
        int[] iArr = (int[]) this.f5598a;
        Object[] objArr = (Object[]) this.f5599b;
        int length = bVarArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            b bVar = bVarArr[i7];
            if (bVar != null) {
                bVar.clear();
            }
            iArr[i7] = i7;
            objArr[i7] = null;
        }
    }
}
