package o4;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import k4.f;
import k4.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class h extends f {
    public static final /* synthetic */ int F = 0;
    public a E;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends f.b {

        /* renamed from: v  reason: collision with root package name */
        public final RectF f5348v;

        public a(i iVar, RectF rectF) {
            super(iVar);
            this.f5348v = rectF;
        }

        @Override // k4.f.b, android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            b bVar = new b(this);
            bVar.invalidateSelf();
            return bVar;
        }

        public a(a aVar) {
            super(aVar);
            this.f5348v = aVar.f5348v;
        }
    }

    @TargetApi(18)
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends h {
        public b(a aVar) {
            super(aVar);
        }

        @Override // k4.f
        public final void g(Canvas canvas) {
            if (this.E.f5348v.isEmpty()) {
                super.g(canvas);
                return;
            }
            canvas.save();
            canvas.clipOutRect(this.E.f5348v);
            super.g(canvas);
            canvas.restore();
        }
    }

    public h(a aVar) {
        super(aVar);
        this.E = aVar;
    }

    @Override // k4.f, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.E = new a(this.E);
        return this;
    }

    public final void o(float f7, float f8, float f9, float f10) {
        RectF rectF = this.E.f5348v;
        if (f7 != rectF.left || f8 != rectF.top || f9 != rectF.right || f10 != rectF.bottom) {
            rectF.set(f7, f8, f9, f10);
            invalidateSelf();
        }
    }
}
