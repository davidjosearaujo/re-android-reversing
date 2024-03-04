package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: n */
    public int f1311n;

    /* renamed from: o */
    public int f1312o;

    /* renamed from: p */
    public y0.a f1313p;

    public a(Context context) {
        super(context);
        setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f1313p.f6476v0;
    }

    public int getMargin() {
        return this.f1313p.f6477w0;
    }

    public int getType() {
        return this.f1311n;
    }

    @Override // androidx.constraintlayout.widget.b
    public final void i(AttributeSet attributeSet) {
        super.i(attributeSet);
        this.f1313p = new y0.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a0.b.e);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == 26) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 25) {
                    this.f1313p.f6476v0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 27) {
                    this.f1313p.f6477w0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1317i = this.f1313p;
        k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x000b, code lost:
        if (r0 == 6) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0014, code lost:
        if (r0 == 6) goto L13;
     */
    @Override // androidx.constraintlayout.widget.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(y0.d r4, boolean r5) {
        /*
            r3 = this;
            int r0 = r3.f1311n
            r3.f1312o = r0
            r1 = 6
            r2 = 5
            if (r5 == 0) goto Le
            if (r0 != r2) goto Lb
            goto L16
        Lb:
            if (r0 != r1) goto L18
            goto L10
        Le:
            if (r0 != r2) goto L14
        L10:
            r5 = 0
        L11:
            r3.f1312o = r5
            goto L18
        L14:
            if (r0 != r1) goto L18
        L16:
            r5 = 1
            goto L11
        L18:
            boolean r5 = r4 instanceof y0.a
            if (r5 == 0) goto L22
            y0.a r4 = (y0.a) r4
            int r3 = r3.f1312o
            r4.f6475u0 = r3
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.a.j(y0.d, boolean):void");
    }

    public void setAllowsGoneWidget(boolean z6) {
        this.f1313p.f6476v0 = z6;
    }

    public void setDpMargin(int i7) {
        this.f1313p.f6477w0 = (int) ((i7 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i7) {
        this.f1313p.f6477w0 = i7;
    }

    public void setType(int i7) {
        this.f1311n = i7;
    }
}
