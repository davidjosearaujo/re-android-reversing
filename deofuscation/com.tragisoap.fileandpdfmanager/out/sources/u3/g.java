package u3;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f6113a;

    public g(int i7) {
        this.f6113a = i7;
    }

    public abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract float b(RecyclerView.m mVar);

    public abstract RectF c(float f7, float f8, float f9, float f10);

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract void j(View view, int i7, int i8);

    public abstract void k(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract void l(float f7, float f8, Rect rect, View view);
}
