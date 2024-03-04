package androidx.cardview.widget;

import a0.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import n.b;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: k */
    public static final int[] f1096k = {16842801};

    /* renamed from: l */
    public static final e f1097l = new e();

    /* renamed from: f */
    public boolean f1098f;

    /* renamed from: g */
    public boolean f1099g;

    /* renamed from: h */
    public final Rect f1100h;

    /* renamed from: i */
    public final Rect f1101i;

    /* renamed from: j */
    public final a f1102j;

    /* loaded from: classes.dex */
    public class a implements n.a {

        /* renamed from: a */
        public Drawable f1103a;

        public a() {
            CardView.this = r1;
        }

        public final void a(int i7, int i8, int i9, int i10) {
            CardView.this.f1101i.set(i7, i8, i9, i10);
            CardView cardView = CardView.this;
            Rect rect = cardView.f1100h;
            CardView.super.setPadding(i7 + rect.left, i8 + rect.top, i9 + rect.right, i10 + rect.bottom);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130903202);
        Resources resources;
        int i7;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1100h = rect;
        this.f1101i = new Rect();
        a aVar = new a();
        this.f1102j = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f44i0, 2130903202, 2131886368);
        if (obtainStyledAttributes.hasValue(2)) {
            valueOf = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1096k);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i7 = 2131034159;
            } else {
                resources = getResources();
                i7 = 2131034158;
            }
            valueOf = ColorStateList.valueOf(resources.getColor(i7));
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f1098f = obtainStyledAttributes.getBoolean(7, false);
        this.f1099g = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        e eVar = f1097l;
        b bVar = new b(dimension, valueOf);
        aVar.f1103a = bVar;
        setBackgroundDrawable(bVar);
        setClipToOutline(true);
        setElevation(dimension2);
        eVar.E(aVar, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((b) this.f1102j.f1103a).f5101h;
    }

    public float getCardElevation() {
        return CardView.this.getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f1100h.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1100h.left;
    }

    public int getContentPaddingRight() {
        return this.f1100h.right;
    }

    public int getContentPaddingTop() {
        return this.f1100h.top;
    }

    public float getMaxCardElevation() {
        return ((b) this.f1102j.f1103a).e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f1099g;
    }

    public float getRadius() {
        return ((b) this.f1102j.f1103a).f5095a;
    }

    public boolean getUseCompatPadding() {
        return this.f1098f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
    }

    public void setCardBackgroundColor(int i7) {
        a aVar = this.f1102j;
        ColorStateList valueOf = ColorStateList.valueOf(i7);
        b bVar = (b) aVar.f1103a;
        bVar.b(valueOf);
        bVar.invalidateSelf();
    }

    public void setCardElevation(float f7) {
        CardView.this.setElevation(f7);
    }

    public void setMaxCardElevation(float f7) {
        f1097l.E(this.f1102j, f7);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i7) {
        super.setMinimumHeight(i7);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i7) {
        super.setMinimumWidth(i7);
    }

    @Override // android.view.View
    public final void setPadding(int i7, int i8, int i9, int i10) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i7, int i8, int i9, int i10) {
    }

    public void setPreventCornerOverlap(boolean z6) {
        if (z6 != this.f1099g) {
            this.f1099g = z6;
            e eVar = f1097l;
            a aVar = this.f1102j;
            eVar.E(aVar, ((b) aVar.f1103a).e);
        }
    }

    public void setRadius(float f7) {
        b bVar = (b) this.f1102j.f1103a;
        if (f7 == bVar.f5095a) {
            return;
        }
        bVar.f5095a = f7;
        bVar.c(null);
        bVar.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z6) {
        if (this.f1098f != z6) {
            this.f1098f = z6;
            e eVar = f1097l;
            a aVar = this.f1102j;
            eVar.E(aVar, ((b) aVar.f1103a).e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        b bVar = (b) this.f1102j.f1103a;
        bVar.b(colorStateList);
        bVar.invalidateSelf();
    }
}
