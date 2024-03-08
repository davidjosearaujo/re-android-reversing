package k4;

import android.graphics.Canvas;
import android.graphics.Matrix;
import j4.a;
import java.util.ArrayList;
import java.util.List;
import k4.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k extends l.f {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f4794c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Matrix f4795d;

    public k(ArrayList arrayList, Matrix matrix) {
        this.f4794c = arrayList;
        this.f4795d = matrix;
    }

    @Override // k4.l.f
    public final void a(Matrix matrix, a aVar, int i7, Canvas canvas) {
        for (l.f fVar : this.f4794c) {
            fVar.a(this.f4795d, aVar, i7, canvas);
        }
    }
}
