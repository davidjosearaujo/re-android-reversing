package o4;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.a1;
import androidx.appcompat.widget.c0;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class u extends LinearLayout {

    /* renamed from: f */
    public final TextInputLayout f5409f;

    /* renamed from: g */
    public final c0 f5410g;

    /* renamed from: h */
    public CharSequence f5411h;

    /* renamed from: i */
    public final CheckableImageButton f5412i;

    /* renamed from: j */
    public ColorStateList f5413j;

    /* renamed from: k */
    public PorterDuff.Mode f5414k;

    /* renamed from: l */
    public int f5415l;
    public ImageView.ScaleType m;

    /* renamed from: n */
    public View.OnLongClickListener f5416n;

    /* renamed from: o */
    public boolean f5417o;

    public u(TextInputLayout textInputLayout, a1 a1Var) {
        super(textInputLayout.getContext());
        CharSequence k6;
        this.f5409f = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(2131492914, (ViewGroup) this, false);
        this.f5412i = checkableImageButton;
        c0 c0Var = new c0(getContext(), null);
        this.f5410g = c0Var;
        if (g4.c.d(getContext())) {
            p1.g.g((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        View.OnLongClickListener onLongClickListener = this.f5416n;
        checkableImageButton.setOnClickListener(null);
        n.d(checkableImageButton, onLongClickListener);
        this.f5416n = null;
        checkableImageButton.setOnLongClickListener(null);
        n.d(checkableImageButton, null);
        if (a1Var.l(69)) {
            this.f5413j = g4.c.b(getContext(), a1Var, 69);
        }
        if (a1Var.l(70)) {
            this.f5414k = d4.s.b(a1Var.h(70, -1), null);
        }
        if (a1Var.l(66)) {
            b(a1Var.e(66));
            if (a1Var.l(65) && checkableImageButton.getContentDescription() != (k6 = a1Var.k(65))) {
                checkableImageButton.setContentDescription(k6);
            }
            checkableImageButton.setCheckable(a1Var.a(64, true));
        }
        int d7 = a1Var.d(67, getResources().getDimensionPixelSize(2131100350));
        if (d7 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (d7 != this.f5415l) {
            this.f5415l = d7;
            checkableImageButton.setMinimumWidth(d7);
            checkableImageButton.setMinimumHeight(d7);
        }
        if (a1Var.l(68)) {
            ImageView.ScaleType b2 = n.b(a1Var.h(68, -1));
            this.m = b2;
            checkableImageButton.setScaleType(b2);
        }
        c0Var.setVisibility(8);
        c0Var.setId(2131296870);
        c0Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.g.f(c0Var, 1);
        c0Var.setTextAppearance(a1Var.i(60, 0));
        if (a1Var.l(61)) {
            c0Var.setTextColor(a1Var.b(61));
        }
        CharSequence k7 = a1Var.k(59);
        this.f5411h = TextUtils.isEmpty(k7) ? null : k7;
        c0Var.setText(k7);
        e();
        addView(checkableImageButton);
        addView(c0Var);
    }

    public final int a() {
        int b2 = this.f5412i.getVisibility() == 0 ? p1.g.b((ViewGroup.MarginLayoutParams) this.f5412i.getLayoutParams()) + this.f5412i.getMeasuredWidth() : 0;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        return y.e.f(this.f5410g) + y.e.f(this) + b2;
    }

    public final void b(Drawable drawable) {
        this.f5412i.setImageDrawable(drawable);
        if (drawable != null) {
            n.a(this.f5409f, this.f5412i, this.f5413j, this.f5414k);
            c(true);
            n.c(this.f5409f, this.f5412i, this.f5413j);
            return;
        }
        c(false);
        CheckableImageButton checkableImageButton = this.f5412i;
        View.OnLongClickListener onLongClickListener = this.f5416n;
        checkableImageButton.setOnClickListener(null);
        n.d(checkableImageButton, onLongClickListener);
        this.f5416n = null;
        CheckableImageButton checkableImageButton2 = this.f5412i;
        checkableImageButton2.setOnLongClickListener(null);
        n.d(checkableImageButton2, null);
        if (this.f5412i.getContentDescription() != null) {
            this.f5412i.setContentDescription(null);
        }
    }

    public final void c(boolean z6) {
        if ((this.f5412i.getVisibility() == 0) != z6) {
            this.f5412i.setVisibility(z6 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        EditText editText = this.f5409f.f3280i;
        if (editText == null) {
            return;
        }
        int i7 = 0;
        if (!(this.f5412i.getVisibility() == 0)) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            i7 = y.e.f(editText);
        }
        c0 c0Var = this.f5410g;
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131100220);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
        y.e.k(c0Var, i7, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void e() {
        int i7 = (this.f5411h == null || this.f5417o) ? 8 : 0;
        setVisibility(this.f5412i.getVisibility() == 0 || i7 == 0 ? 0 : 8);
        this.f5410g.setVisibility(i7);
        this.f5409f.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        d();
    }
}
