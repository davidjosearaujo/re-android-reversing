package o4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.n0;
import com.google.android.material.textfield.TextInputLayout;
import j1.a;
import java.util.Locale;
import java.util.WeakHashMap;
import l0.z;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class r extends androidx.appcompat.widget.d {

    /* renamed from: j */
    public final n0 f5397j;

    /* renamed from: k */
    public final AccessibilityManager f5398k;

    /* renamed from: l */
    public final Rect f5399l;
    public final int m;

    /* renamed from: n */
    public final float f5400n;

    /* renamed from: o */
    public ColorStateList f5401o;

    /* renamed from: p */
    public int f5402p;

    /* renamed from: q */
    public ColorStateList f5403q;

    /* loaded from: classes.dex */
    public class a<T> extends ArrayAdapter<String> {

        /* renamed from: f */
        public ColorStateList f5404f;

        /* renamed from: g */
        public ColorStateList f5405g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, int i7, String[] strArr) {
            super(context, i7, strArr);
            r.this = r1;
            b();
        }

        public final void b() {
            ColorStateList colorStateList;
            ColorStateList colorStateList2 = r.this.f5403q;
            ColorStateList colorStateList3 = null;
            if (colorStateList2 != null) {
                int[] iArr = {16842919};
                colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
            } else {
                colorStateList = null;
            }
            this.f5405g = colorStateList;
            r rVar = r.this;
            if (rVar.f5402p != 0) {
                ColorStateList colorStateList4 = rVar.f5403q;
                if (colorStateList4 != null) {
                    int[] iArr2 = {16843623, -16842919};
                    int[] iArr3 = {16842913, -16842919};
                    colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{i1.a.b(colorStateList4.getColorForState(iArr3, 0), r.this.f5402p), i1.a.b(r.this.f5403q.getColorForState(iArr2, 0), r.this.f5402p), r.this.f5402p});
                }
            }
            this.f5404f = colorStateList3;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final View getView(int i7, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i7, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                RippleDrawable rippleDrawable = null;
                if (r.this.getText().toString().contentEquals(textView.getText())) {
                    if (r.this.f5402p != 0) {
                        ColorDrawable colorDrawable = new ColorDrawable(r.this.f5402p);
                        if (this.f5405g != null) {
                            a.b.h(colorDrawable, this.f5404f);
                            rippleDrawable = new RippleDrawable(this.f5405g, colorDrawable, null);
                        } else {
                            rippleDrawable = colorDrawable;
                        }
                    }
                }
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.d.q(textView, rippleDrawable);
            }
            return view2;
        }
    }

    public r(Context context, AttributeSet attributeSet) {
        super(q4.a.a(context, attributeSet, 2130903103, 0), attributeSet, 0);
        this.f5399l = new Rect();
        Context context2 = getContext();
        TypedArray d7 = d4.n.d(context2, attributeSet, z.f4924j, 2130903103, 2131886839, new int[0]);
        if (d7.hasValue(0) && d7.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.m = d7.getResourceId(3, 2131492948);
        this.f5400n = d7.getDimensionPixelOffset(1, 2131100319);
        if (d7.hasValue(2)) {
            this.f5401o = ColorStateList.valueOf(d7.getColor(2, 0));
        }
        this.f5402p = d7.getColor(4, 0);
        this.f5403q = g4.c.a(context2, d7, 5);
        this.f5398k = (AccessibilityManager) context2.getSystemService("accessibility");
        n0 n0Var = new n0(context2, null, 2130903768, 0);
        this.f5397j = n0Var;
        n0Var.D = true;
        n0Var.E.setFocusable(true);
        n0Var.f996t = this;
        n0Var.E.setInputMethodMode(2);
        n0Var.p(getAdapter());
        n0Var.f997u = new q(this);
        if (d7.hasValue(6)) {
            setSimpleItems(d7.getResourceId(6, 0));
        }
        d7.recycle();
    }

    public static void a(r rVar, Object obj) {
        rVar.setText(rVar.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        AccessibilityManager accessibilityManager = this.f5398k;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f5397j.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f5401o;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout b2 = b();
        return (b2 == null || !b2.J) ? super.getHint() : b2.getHint();
    }

    public float getPopupElevation() {
        return this.f5400n;
    }

    public int getSimpleItemSelectedColor() {
        return this.f5402p;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f5403q;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b2 = b();
        if (b2 != null && b2.J && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5397j.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (View.MeasureSpec.getMode(i7) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b2 = b();
            int i9 = 0;
            if (adapter != null && b2 != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                n0 n0Var = this.f5397j;
                int min = Math.min(adapter.getCount(), Math.max(0, !n0Var.b() ? -1 : n0Var.f986h.getSelectedItemPosition()) + 15);
                View view = null;
                int i10 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i9) {
                        view = null;
                        i9 = itemViewType;
                    }
                    view = adapter.getView(max, view, b2);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i10 = Math.max(i10, view.getMeasuredWidth());
                }
                Drawable f7 = this.f5397j.f();
                if (f7 != null) {
                    f7.getPadding(this.f5399l);
                    Rect rect = this.f5399l;
                    i10 += rect.left + rect.right;
                }
                i9 = b2.getEndIconView().getMeasuredWidth() + i10;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i9), View.MeasureSpec.getSize(i7)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z6) {
        AccessibilityManager accessibilityManager = this.f5398k;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        super.onWindowFocusChanged(z6);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t5) {
        super.setAdapter(t5);
        this.f5397j.p(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        n0 n0Var = this.f5397j;
        if (n0Var != null) {
            n0Var.i(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i7) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i7));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f5401o = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof k4.f) {
            ((k4.f) dropDownBackground).k(this.f5401o);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f5397j.f998v = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i7) {
        super.setRawInputType(i7);
        TextInputLayout b2 = b();
        if (b2 != null) {
            b2.s();
        }
    }

    public void setSimpleItemSelectedColor(int i7) {
        this.f5402p = i7;
        if (getAdapter() instanceof a) {
            ((a) getAdapter()).b();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f5403q = colorStateList;
        if (getAdapter() instanceof a) {
            ((a) getAdapter()).b();
        }
    }

    public void setSimpleItems(int i7) {
        setSimpleItems(getResources().getStringArray(i7));
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new a(getContext(), this.m, strArr));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        AccessibilityManager accessibilityManager = this.f5398k;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f5397j.d();
        } else {
            super.showDropDown();
        }
    }
}
