package androidx.constraintlayout.widget;

import a0.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    public c f1407f;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends ConstraintLayout.a {
        public float A0;
        public float B0;
        public float C0;
        public float D0;

        /* renamed from: r0  reason: collision with root package name */
        public float f1408r0;

        /* renamed from: s0  reason: collision with root package name */
        public boolean f1409s0;

        /* renamed from: t0  reason: collision with root package name */
        public float f1410t0;

        /* renamed from: u0  reason: collision with root package name */
        public float f1411u0;

        /* renamed from: v0  reason: collision with root package name */
        public float f1412v0;

        /* renamed from: w0  reason: collision with root package name */
        public float f1413w0;

        /* renamed from: x0  reason: collision with root package name */
        public float f1414x0;

        /* renamed from: y0  reason: collision with root package name */
        public float f1415y0;

        /* renamed from: z0  reason: collision with root package name */
        public float f1416z0;

        public a() {
            this.f1408r0 = 1.0f;
            this.f1409s0 = false;
            this.f1410t0 = 0.0f;
            this.f1411u0 = 0.0f;
            this.f1412v0 = 0.0f;
            this.f1413w0 = 0.0f;
            this.f1414x0 = 1.0f;
            this.f1415y0 = 1.0f;
            this.f1416z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1408r0 = 1.0f;
            this.f1409s0 = false;
            this.f1410t0 = 0.0f;
            this.f1411u0 = 0.0f;
            this.f1412v0 = 0.0f;
            this.f1413w0 = 0.0f;
            this.f1414x0 = 1.0f;
            this.f1415y0 = 1.0f;
            this.f1416z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f8g);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == 15) {
                    this.f1408r0 = obtainStyledAttributes.getFloat(index, this.f1408r0);
                } else if (index == 28) {
                    this.f1410t0 = obtainStyledAttributes.getFloat(index, this.f1410t0);
                    this.f1409s0 = true;
                } else if (index == 23) {
                    this.f1412v0 = obtainStyledAttributes.getFloat(index, this.f1412v0);
                } else if (index == 24) {
                    this.f1413w0 = obtainStyledAttributes.getFloat(index, this.f1413w0);
                } else if (index == 22) {
                    this.f1411u0 = obtainStyledAttributes.getFloat(index, this.f1411u0);
                } else if (index == 20) {
                    this.f1414x0 = obtainStyledAttributes.getFloat(index, this.f1414x0);
                } else if (index == 21) {
                    this.f1415y0 = obtainStyledAttributes.getFloat(index, this.f1415y0);
                } else if (index == 16) {
                    this.f1416z0 = obtainStyledAttributes.getFloat(index, this.f1416z0);
                } else if (index == 17) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == 18) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == 19) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == 27) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    public c getConstraintSet() {
        if (this.f1407f == null) {
            this.f1407f = new c();
        }
        c cVar = this.f1407f;
        cVar.getClass();
        int childCount = getChildCount();
        cVar.f1325c.clear();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            a aVar = (a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!cVar.f1324b || id != -1) {
                if (!cVar.f1325c.containsKey(Integer.valueOf(id))) {
                    cVar.f1325c.put(Integer.valueOf(id), new c.a());
                }
                c.a aVar2 = cVar.f1325c.get(Integer.valueOf(id));
                if (aVar2 != null) {
                    if (childAt instanceof b) {
                        b bVar = (b) childAt;
                        aVar2.c(id, aVar);
                        if (bVar instanceof a) {
                            c.b bVar2 = aVar2.f1329d;
                            bVar2.f1357h0 = 1;
                            a aVar3 = (a) bVar;
                            bVar2.f1353f0 = aVar3.getType();
                            aVar2.f1329d.f1359i0 = aVar3.getReferencedIds();
                            aVar2.f1329d.f1355g0 = aVar3.getMargin();
                        }
                    }
                    aVar2.c(id, aVar);
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        return this.f1407f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
    }
}
