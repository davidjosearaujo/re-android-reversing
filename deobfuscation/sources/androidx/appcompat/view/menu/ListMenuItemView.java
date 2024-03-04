package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.a1;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: f */
    public h f514f;

    /* renamed from: g */
    public ImageView f515g;

    /* renamed from: h */
    public RadioButton f516h;

    /* renamed from: i */
    public TextView f517i;

    /* renamed from: j */
    public CheckBox f518j;

    /* renamed from: k */
    public TextView f519k;

    /* renamed from: l */
    public ImageView f520l;
    public ImageView m;

    /* renamed from: n */
    public LinearLayout f521n;

    /* renamed from: o */
    public Drawable f522o;

    /* renamed from: p */
    public int f523p;

    /* renamed from: q */
    public Context f524q;

    /* renamed from: r */
    public boolean f525r;
    public Drawable s;

    /* renamed from: t */
    public boolean f526t;

    /* renamed from: u */
    public LayoutInflater f527u;

    /* renamed from: v */
    public boolean f528v;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a1 m = a1.m(getContext(), attributeSet, a0.e.N, 2130903767);
        this.f522o = m.e(5);
        this.f523p = m.i(1, -1);
        this.f525r = m.a(7, false);
        this.f524q = context;
        this.s = m.e(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, 2130903463, 0);
        this.f526t = obtainStyledAttributes.hasValue(0);
        m.n();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f527u == null) {
            this.f527u = LayoutInflater.from(getContext());
        }
        return this.f527u;
    }

    private void setSubMenuArrowVisible(boolean z6) {
        ImageView imageView = this.f520l;
        if (imageView != null) {
            imageView.setVisibility(z6 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.m;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        rect.top = this.m.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Code restructure failed: missing block: B:209:0x005b, code lost:
        if (r0 == false) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:200:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x011b  */
    @Override // androidx.appcompat.view.menu.k.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(androidx.appcompat.view.menu.h r11) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.c(androidx.appcompat.view.menu.h):void");
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.f514f;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Drawable drawable = this.f522o;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.q(this, drawable);
        TextView textView = (TextView) findViewById(2131296873);
        this.f517i = textView;
        int i7 = this.f523p;
        if (i7 != -1) {
            textView.setTextAppearance(this.f524q, i7);
        }
        this.f519k = (TextView) findViewById(2131296782);
        ImageView imageView = (ImageView) findViewById(2131296817);
        this.f520l = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.s);
        }
        this.m = (ImageView) findViewById(2131296500);
        this.f521n = (LinearLayout) findViewById(2131296404);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i7, int i8) {
        if (this.f515g != null && this.f525r) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f515g.getLayoutParams();
            int i9 = layoutParams.height;
            if (i9 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i9;
            }
        }
        super.onMeasure(i7, i8);
    }

    public void setCheckable(boolean z6) {
        CompoundButton compoundButton;
        View view;
        if (!z6 && this.f516h == null && this.f518j == null) {
            return;
        }
        if ((this.f514f.f623x & 4) != 0) {
            if (this.f516h == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(2131492881, (ViewGroup) this, false);
                this.f516h = radioButton;
                LinearLayout linearLayout = this.f521n;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f516h;
            view = this.f518j;
        } else {
            if (this.f518j == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(2131492878, (ViewGroup) this, false);
                this.f518j = checkBox;
                LinearLayout linearLayout2 = this.f521n;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f518j;
            view = this.f516h;
        }
        if (z6) {
            compoundButton.setChecked(this.f514f.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f518j;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f516h;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z6) {
        CompoundButton compoundButton;
        if ((this.f514f.f623x & 4) != 0) {
            if (this.f516h == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(2131492881, (ViewGroup) this, false);
                this.f516h = radioButton;
                LinearLayout linearLayout = this.f521n;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f516h;
        } else {
            if (this.f518j == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(2131492878, (ViewGroup) this, false);
                this.f518j = checkBox;
                LinearLayout linearLayout2 = this.f521n;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f518j;
        }
        compoundButton.setChecked(z6);
    }

    public void setForceShowIcon(boolean z6) {
        this.f528v = z6;
        this.f525r = z6;
    }

    public void setGroupDividerEnabled(boolean z6) {
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setVisibility((this.f526t || !z6) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f514f.f614n.getClass();
        boolean z6 = this.f528v;
        if (z6 || this.f525r) {
            ImageView imageView = this.f515g;
            if (imageView == null && drawable == null && !this.f525r) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(2131492879, (ViewGroup) this, false);
                this.f515g = imageView2;
                LinearLayout linearLayout = this.f521n;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f525r) {
                this.f515g.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f515g;
            if (!z6) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f515g.getVisibility() != 0) {
                this.f515g.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f517i.getVisibility() != 8) {
                this.f517i.setVisibility(8);
                return;
            }
            return;
        }
        this.f517i.setText(charSequence);
        if (this.f517i.getVisibility() != 0) {
            this.f517i.setVisibility(0);
        }
    }
}
