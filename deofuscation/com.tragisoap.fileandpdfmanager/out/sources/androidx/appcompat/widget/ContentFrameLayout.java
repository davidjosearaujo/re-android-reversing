package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.f;
import f.h;
import f.j;
import p1.k0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
    public final Rect f728l = new Rect();
    public a m;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
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

    @Override // android.view.View, android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.m;
        if (aVar != null) {
            aVar.getClass();
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.m;
        if (aVar != null) {
            h hVar = ((j) aVar).f3998a;
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
            k0 k0Var = hVar.D;
            if (k0Var != null) {
                k0Var.b();
            }
            f fVar = hVar.M(0).f3988h;
            if (fVar != null) {
                fVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.m = aVar;
    }
}
