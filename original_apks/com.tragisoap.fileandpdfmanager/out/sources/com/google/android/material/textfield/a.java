package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.h;
import androidx.appcompat.widget.a1;
import androidx.appcompat.widget.c0;
import androidx.fragment.app.s0;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import d4.m;
import d4.s;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import o4.f;
import o4.l;
import o4.n;
import o4.t;
import p1.g;
import p1.k0;
import p1.y;
@SuppressLint({"ViewConstructor"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends LinearLayout {

    /* renamed from: f */
    public final TextInputLayout f3320f;

    /* renamed from: g */
    public final FrameLayout f3321g;

    /* renamed from: h */
    public final CheckableImageButton f3322h;

    /* renamed from: i */
    public ColorStateList f3323i;

    /* renamed from: j */
    public PorterDuff.Mode f3324j;

    /* renamed from: k */
    public View.OnLongClickListener f3325k;

    /* renamed from: l */
    public final CheckableImageButton f3326l;
    public final d m;

    /* renamed from: p */
    public ColorStateList f3329p;

    /* renamed from: q */
    public PorterDuff.Mode f3330q;

    /* renamed from: r */
    public int f3331r;
    public ImageView.ScaleType s;

    /* renamed from: t */
    public View.OnLongClickListener f3332t;

    /* renamed from: u */
    public CharSequence f3333u;

    /* renamed from: v */
    public final c0 f3334v;

    /* renamed from: w */
    public boolean f3335w;

    /* renamed from: x */
    public EditText f3336x;

    /* renamed from: z */
    public q1.d f3338z;

    /* renamed from: n */
    public int f3327n = 0;

    /* renamed from: o */
    public final LinkedHashSet<TextInputLayout.g> f3328o = new LinkedHashSet<>();
    public final C0039a A = new C0039a();

    /* renamed from: y */
    public final AccessibilityManager f3337y = (AccessibilityManager) getContext().getSystemService("accessibility");

    /* renamed from: com.google.android.material.textfield.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class C0039a extends m {
        public C0039a() {
            a.this = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            a.this.b().a();
        }

        @Override // d4.m, android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            a.this.b().b();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements TextInputLayout.f {
        public b() {
            a.this = r1;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public final void a(TextInputLayout textInputLayout) {
            if (a.this.f3336x != textInputLayout.getEditText()) {
                a aVar = a.this;
                EditText editText = aVar.f3336x;
                if (editText != null) {
                    editText.removeTextChangedListener(aVar.A);
                    if (a.this.f3336x.getOnFocusChangeListener() == a.this.b().e()) {
                        a.this.f3336x.setOnFocusChangeListener(null);
                    }
                }
                a.this.f3336x = textInputLayout.getEditText();
                a aVar2 = a.this;
                EditText editText2 = aVar2.f3336x;
                if (editText2 != null) {
                    editText2.addTextChangedListener(aVar2.A);
                }
                a.this.b().m(a.this.f3336x);
                a aVar3 = a.this;
                aVar3.j(aVar3.b());
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c implements View.OnAttachStateChangeListener {
        public c() {
            a.this = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            a aVar = a.this;
            if (aVar.f3338z != null && aVar.f3337y != null) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (y.g.b(aVar)) {
                    q1.c.a(aVar.f3337y, aVar.f3338z);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            AccessibilityManager accessibilityManager;
            a aVar = a.this;
            q1.d dVar = aVar.f3338z;
            if (dVar != null && (accessibilityManager = aVar.f3337y) != null) {
                q1.c.b(accessibilityManager, dVar);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d {

        /* renamed from: a */
        public final SparseArray<o4.m> f3342a = new SparseArray<>();

        /* renamed from: b */
        public final a f3343b;

        /* renamed from: c */
        public final int f3344c;

        /* renamed from: d */
        public final int f3345d;

        public d(a aVar, a1 a1Var) {
            this.f3343b = aVar;
            this.f3344c = a1Var.i(28, 0);
            this.f3345d = a1Var.i(52, 0);
        }
    }

    public a(TextInputLayout textInputLayout, a1 a1Var) {
        super(textInputLayout.getContext());
        CharSequence k6;
        b bVar = new b();
        this.f3320f = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f3321g = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton a7 = a(this, from, 2131296864);
        this.f3322h = a7;
        CheckableImageButton a8 = a(frameLayout, from, 2131296863);
        this.f3326l = a8;
        this.m = new d(this, a1Var);
        CharSequence charSequence = null;
        c0 c0Var = new c0(getContext(), null);
        this.f3334v = c0Var;
        if (a1Var.l(38)) {
            this.f3323i = g4.c.b(getContext(), a1Var, 38);
        }
        if (a1Var.l(39)) {
            this.f3324j = s.b(a1Var.h(39, -1), null);
        }
        if (a1Var.l(37)) {
            i(a1Var.e(37));
        }
        a7.setContentDescription(getResources().getText(2131820601));
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.s(a7, 2);
        a7.setClickable(false);
        a7.setPressable(false);
        a7.setFocusable(false);
        if (!a1Var.l(53)) {
            if (a1Var.l(32)) {
                this.f3329p = g4.c.b(getContext(), a1Var, 32);
            }
            if (a1Var.l(33)) {
                this.f3330q = s.b(a1Var.h(33, -1), null);
            }
        }
        if (a1Var.l(30)) {
            g(a1Var.h(30, 0));
            if (a1Var.l(27) && a8.getContentDescription() != (k6 = a1Var.k(27))) {
                a8.setContentDescription(k6);
            }
            a8.setCheckable(a1Var.a(26, true));
        } else if (a1Var.l(53)) {
            if (a1Var.l(54)) {
                this.f3329p = g4.c.b(getContext(), a1Var, 54);
            }
            if (a1Var.l(55)) {
                this.f3330q = s.b(a1Var.h(55, -1), null);
            }
            g(a1Var.a(53, false) ? 1 : 0);
            CharSequence k7 = a1Var.k(51);
            if (a8.getContentDescription() != k7) {
                a8.setContentDescription(k7);
            }
        }
        int d7 = a1Var.d(29, getResources().getDimensionPixelSize(2131100350));
        if (d7 >= 0) {
            if (d7 != this.f3331r) {
                this.f3331r = d7;
                a8.setMinimumWidth(d7);
                a8.setMinimumHeight(d7);
                a7.setMinimumWidth(d7);
                a7.setMinimumHeight(d7);
            }
            if (a1Var.l(31)) {
                ImageView.ScaleType b2 = n.b(a1Var.h(31, -1));
                this.s = b2;
                a8.setScaleType(b2);
                a7.setScaleType(b2);
            }
            c0Var.setVisibility(8);
            c0Var.setId(2131296871);
            c0Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
            y.g.f(c0Var, 1);
            c0Var.setTextAppearance(a1Var.i(72, 0));
            if (a1Var.l(73)) {
                c0Var.setTextColor(a1Var.b(73));
            }
            CharSequence k8 = a1Var.k(71);
            this.f3333u = !TextUtils.isEmpty(k8) ? k8 : charSequence;
            c0Var.setText(k8);
            n();
            frameLayout.addView(a8);
            addView(c0Var);
            addView(frameLayout);
            addView(a7);
            textInputLayout.f3283j0.add(bVar);
            if (textInputLayout.f3280i != null) {
                bVar.a(textInputLayout);
            }
            addOnAttachStateChangeListener(new c());
            return;
        }
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i7) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(2131492913, viewGroup, false);
        checkableImageButton.setId(i7);
        if (g4.c.d(getContext())) {
            g.h((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public final o4.m b() {
        d dVar = this.m;
        int i7 = this.f3327n;
        o4.m mVar = dVar.f3342a.get(i7);
        if (mVar == null) {
            if (i7 == -1) {
                mVar = new o4.g(dVar.f3343b);
            } else if (i7 == 0) {
                mVar = new o4.s(dVar.f3343b);
            } else if (i7 == 1) {
                mVar = new t(dVar.f3343b, dVar.f3345d);
            } else if (i7 == 2) {
                mVar = new f(dVar.f3343b);
            } else if (i7 == 3) {
                mVar = new l(dVar.f3343b);
            } else {
                throw new IllegalArgumentException(s0.g("Invalid end icon mode: ", i7));
            }
            dVar.f3342a.append(i7, mVar);
        }
        return mVar;
    }

    public final int c() {
        int measuredWidth = (d() || e()) ? this.f3326l.getMeasuredWidth() + g.c((ViewGroup.MarginLayoutParams) this.f3326l.getLayoutParams()) : 0;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        return y.e.e(this.f3334v) + y.e.e(this) + measuredWidth;
    }

    public final boolean d() {
        return this.f3321g.getVisibility() == 0 && this.f3326l.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f3322h.getVisibility() == 0;
    }

    public final void f(boolean z6) {
        boolean isActivated;
        boolean isChecked;
        o4.m b2 = b();
        boolean z7 = true;
        if (!b2.k() || (isChecked = this.f3326l.isChecked()) == b2.l()) {
            z7 = false;
        } else {
            this.f3326l.setChecked(!isChecked);
            z7 = true;
        }
        if ((b2 instanceof l) && (isActivated = this.f3326l.isActivated()) != b2.j()) {
            this.f3326l.setActivated(!isActivated);
        }
        if (z6 || z7) {
            n.c(this.f3320f, this.f3326l, this.f3329p);
        }
    }

    public final void g(int i7) {
        AccessibilityManager accessibilityManager;
        if (this.f3327n != i7) {
            o4.m b2 = b();
            q1.d dVar = this.f3338z;
            if (!(dVar == null || (accessibilityManager = this.f3337y) == null)) {
                q1.c.b(accessibilityManager, dVar);
            }
            CharSequence charSequence = null;
            this.f3338z = null;
            b2.s();
            this.f3327n = i7;
            Iterator<TextInputLayout.g> it = this.f3328o.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            h(i7 != 0);
            o4.m b7 = b();
            int i8 = this.m.f3344c;
            if (i8 == 0) {
                i8 = b7.d();
            }
            Drawable a7 = i8 != 0 ? g.a.a(getContext(), i8) : null;
            this.f3326l.setImageDrawable(a7);
            if (a7 != null) {
                n.a(this.f3320f, this.f3326l, this.f3329p, this.f3330q);
                n.c(this.f3320f, this.f3326l, this.f3329p);
            }
            int c7 = b7.c();
            if (c7 != 0) {
                charSequence = getResources().getText(c7);
            }
            if (this.f3326l.getContentDescription() != charSequence) {
                this.f3326l.setContentDescription(charSequence);
            }
            this.f3326l.setCheckable(b7.k());
            if (b7.i(this.f3320f.getBoxBackgroundMode())) {
                b7.r();
                q1.d h7 = b7.h();
                this.f3338z = h7;
                if (!(h7 == null || this.f3337y == null)) {
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    if (y.g.b(this)) {
                        q1.c.a(this.f3337y, this.f3338z);
                    }
                }
                View.OnClickListener f7 = b7.f();
                CheckableImageButton checkableImageButton = this.f3326l;
                View.OnLongClickListener onLongClickListener = this.f3332t;
                checkableImageButton.setOnClickListener(f7);
                n.d(checkableImageButton, onLongClickListener);
                EditText editText = this.f3336x;
                if (editText != null) {
                    b7.m(editText);
                    j(b7);
                }
                n.a(this.f3320f, this.f3326l, this.f3329p, this.f3330q);
                f(true);
                return;
            }
            StringBuilder d7 = h.d("The current box background mode ");
            d7.append(this.f3320f.getBoxBackgroundMode());
            d7.append(" is not supported by the end icon mode ");
            d7.append(i7);
            throw new IllegalStateException(d7.toString());
        }
    }

    public final void h(boolean z6) {
        if (d() != z6) {
            this.f3326l.setVisibility(z6 ? 0 : 8);
            k();
            m();
            this.f3320f.q();
        }
    }

    public final void i(Drawable drawable) {
        this.f3322h.setImageDrawable(drawable);
        l();
        n.a(this.f3320f, this.f3322h, this.f3323i, this.f3324j);
    }

    public final void j(o4.m mVar) {
        if (this.f3336x != null) {
            if (mVar.e() != null) {
                this.f3336x.setOnFocusChangeListener(mVar.e());
            }
            if (mVar.g() != null) {
                this.f3326l.setOnFocusChangeListener(mVar.g());
            }
        }
    }

    public final void k() {
        int i7 = 8;
        this.f3321g.setVisibility((this.f3326l.getVisibility() != 0 || e()) ? 8 : 0);
        if (d() || e() || !((this.f3333u == null || this.f3335w) ? true : false)) {
            i7 = 0;
        }
        setVisibility(i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            r4 = this;
            com.google.android.material.internal.CheckableImageButton r0 = r4.f3322h
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001a
            com.google.android.material.textfield.TextInputLayout r0 = r4.f3320f
            o4.o r3 = r0.f3291o
            boolean r3 = r3.f5382q
            if (r3 == 0) goto L_0x001a
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x001a
            r0 = r1
            goto L_0x001b
        L_0x001a:
            r0 = r2
        L_0x001b:
            com.google.android.material.internal.CheckableImageButton r3 = r4.f3322h
            if (r0 == 0) goto L_0x0021
            r0 = r2
            goto L_0x0023
        L_0x0021:
            r0 = 8
        L_0x0023:
            r3.setVisibility(r0)
            r4.k()
            r4.m()
            int r0 = r4.f3327n
            if (r0 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r1 = r2
        L_0x0032:
            if (r1 != 0) goto L_0x0039
            com.google.android.material.textfield.TextInputLayout r4 = r4.f3320f
            r4.q()
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.a.l():void");
    }

    public final void m() {
        int i7;
        if (this.f3320f.f3280i != null) {
            if (d() || e()) {
                i7 = 0;
            } else {
                EditText editText = this.f3320f.f3280i;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                i7 = y.e.e(editText);
            }
            c0 c0Var = this.f3334v;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131100220);
            int paddingTop = this.f3320f.f3280i.getPaddingTop();
            int paddingBottom = this.f3320f.f3280i.getPaddingBottom();
            WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
            y.e.k(c0Var, dimensionPixelSize, paddingTop, i7, paddingBottom);
        }
    }

    public final void n() {
        int visibility = this.f3334v.getVisibility();
        boolean z6 = false;
        int i7 = (this.f3333u == null || this.f3335w) ? 8 : 0;
        if (visibility != i7) {
            o4.m b2 = b();
            if (i7 == 0) {
                z6 = true;
            }
            b2.p(z6);
        }
        k();
        this.f3334v.setVisibility(i7);
        this.f3320f.q();
    }
}
