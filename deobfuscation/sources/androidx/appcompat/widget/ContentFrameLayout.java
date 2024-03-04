package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: f */
    public TypedValue f722f;

    /* renamed from: g */
    public TypedValue f723g;

    /* renamed from: h */
    public TypedValue f724h;

    /* renamed from: i */
    public TypedValue f725i;

    /* renamed from: j */
    public TypedValue f726j;

    /* renamed from: k */
    public TypedValue f727k;

    /* renamed from: l */
    public final Rect f728l;
    public a m;

    /* loaded from: classes.dex */
    public interface a {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f728l = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f726j == null) {
            this.f726j = new TypedValue();
        }
        return this.f726j;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f727k == null) {
            this.f727k = new TypedValue();
        }
        return this.f727k;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f724h == null) {
            this.f724h = new TypedValue();
        }
        return this.f724h;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f725i == null) {
            this.f725i = new TypedValue();
        }
        return this.f725i;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f722f == null) {
            this.f722f = new TypedValue();
        }
        return this.f722f;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f723g == null) {
            this.f723g = new TypedValue();
        }
        return this.f723g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.m;
        if (aVar != null) {
            aVar.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.m;
        if (aVar != null) {
            f.h hVar = ((f.j) aVar).f3998a;
            f0 f0Var = hVar.f3961w;
            if (f0Var != null) {
                f0Var.l();
            }
            if (hVar.B != null) {
                hVar.f3956q.getDecorView().removeCallbacks(hVar.C);
                if (hVar.B.isShowing()) {
                    try {
                        hVar.B.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                hVar.B = null;
            }
            p1.k0 k0Var = hVar.D;
            if (k0Var != null) {
                k0Var.b();
            }
            androidx.appcompat.view.menu.f fVar = hVar.M(0).f3988h;
            if (fVar != null) {
                fVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:207:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.m = aVar;
    }
}
