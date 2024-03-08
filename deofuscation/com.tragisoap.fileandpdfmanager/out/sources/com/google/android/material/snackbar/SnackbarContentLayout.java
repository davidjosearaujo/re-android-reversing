package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import e4.j;
import java.util.WeakHashMap;
import n3.a;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    public TextView f3264f;

    /* renamed from: g  reason: collision with root package name */
    public Button f3265g;

    /* renamed from: h  reason: collision with root package name */
    public int f3266h;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.d(context, 2130903884, a.f5162b);
    }

    public final boolean a(int i7, int i8, int i9) {
        boolean z6;
        if (i7 != getOrientation()) {
            setOrientation(i7);
            z6 = true;
        } else {
            z6 = false;
        }
        if (this.f3264f.getPaddingTop() == i8 && this.f3264f.getPaddingBottom() == i9) {
            return z6;
        }
        TextView textView = this.f3264f;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.e.g(textView)) {
            y.e.k(textView, y.e.f(textView), i8, y.e.e(textView), i9);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i8, textView.getPaddingRight(), i9);
        return true;
    }

    public Button getActionView() {
        return this.f3265g;
    }

    public TextView getMessageView() {
        return this.f3264f;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f3264f = (TextView) findViewById(2131296793);
        this.f3265g = (Button) findViewById(2131296792);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (a(1, r0, r0 - r2) != false) goto L_0x0058;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (a(0, r0, r0) != false) goto L_0x0058;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
        super.onMeasure(r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.getOrientation()
            r1 = 1
            if (r0 != r1) goto L_0x000b
            return
        L_0x000b:
            android.content.res.Resources r0 = r7.getResources()
            r2 = 2131099785(0x7f060089, float:1.7811933E38)
            int r0 = r0.getDimensionPixelSize(r2)
            android.content.res.Resources r2 = r7.getResources()
            r3 = 2131099784(0x7f060088, float:1.781193E38)
            int r2 = r2.getDimensionPixelSize(r3)
            android.widget.TextView r3 = r7.f3264f
            android.text.Layout r3 = r3.getLayout()
            r4 = 0
            if (r3 == 0) goto L_0x0032
            int r3 = r3.getLineCount()
            if (r3 <= r1) goto L_0x0032
            r3 = r1
            goto L_0x0033
        L_0x0032:
            r3 = r4
        L_0x0033:
            if (r3 == 0) goto L_0x004c
            int r5 = r7.f3266h
            if (r5 <= 0) goto L_0x004c
            android.widget.Button r5 = r7.f3265g
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f3266h
            if (r5 <= r6) goto L_0x004c
            int r2 = r0 - r2
            boolean r0 = r7.a(r1, r0, r2)
            if (r0 == 0) goto L_0x0057
            goto L_0x0058
        L_0x004c:
            if (r3 == 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r0 = r2
        L_0x0050:
            boolean r0 = r7.a(r4, r0, r0)
            if (r0 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r1 = r4
        L_0x0058:
            if (r1 == 0) goto L_0x005d
            super.onMeasure(r8, r9)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i7) {
        this.f3266h = i7;
    }
}
