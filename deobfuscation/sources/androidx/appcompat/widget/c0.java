package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import n1.c;

/* loaded from: classes.dex */
public class c0 extends TextView {

    /* renamed from: f */
    public final e f857f;

    /* renamed from: g */
    public final a0 f858g;

    /* renamed from: h */
    public m f859h;

    /* renamed from: i */
    public boolean f860i;

    /* renamed from: j */
    public c f861j;

    /* renamed from: k */
    public Future<n1.c> f862k;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i7);

        void b(int i7);
    }

    /* loaded from: classes.dex */
    public class b implements a {
        public b() {
            c0.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public class c extends b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super();
            c0.this = r1;
        }

        @Override // androidx.appcompat.widget.c0.a
        public final void a(int i7) {
            c0.super.setLastBaselineToBottomHeight(i7);
        }

        @Override // androidx.appcompat.widget.c0.a
        public final void b(int i7) {
            c0.super.setFirstBaselineToTopHeight(i7);
        }
    }

    public c0() {
        throw null;
    }

    public c0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        x0.a(context);
        this.f860i = false;
        this.f861j = null;
        v0.a(this, getContext());
        e eVar = new e(this);
        this.f857f = eVar;
        eVar.d(attributeSet, i7);
        a0 a0Var = new a0(this);
        this.f858g = a0Var;
        a0Var.f(attributeSet, i7);
        a0Var.b();
        getEmojiTextViewHelper().a(attributeSet, i7);
    }

    private m getEmojiTextViewHelper() {
        if (this.f859h == null) {
            this.f859h = new m(this);
        }
        return this.f859h;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f857f;
        if (eVar != null) {
            eVar.a();
        }
        a0 a0Var = this.f858g;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        Method method = g1.f908a;
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        Method method = g1.f908a;
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        Method method = g1.f908a;
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        Method method = g1.f908a;
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        Method method = g1.f908a;
        return super.getAutoSizeTextType() == 1 ? 1 : 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        ActionMode.Callback customSelectionActionModeCallback = super.getCustomSelectionActionModeCallback();
        if (customSelectionActionModeCallback instanceof t1.n) {
            ((t1.n) customSelectionActionModeCallback).getClass();
            return null;
        }
        return customSelectionActionModeCallback;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public a getSuperCaller() {
        if (this.f861j == null) {
            this.f861j = new c();
        }
        return this.f861j;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f857f;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f857f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f858g.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f858g.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future<n1.c> future = this.f862k;
        if (future != null) {
            try {
                this.f862k = null;
                future.get().getClass();
                setText(t1.m.a(null));
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    public c.a getTextMetricsParamsCompat() {
        return new c.a(t1.m.c(this));
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f858g.getClass();
        a0.e.v(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        super.onLayout(z6, i7, i8, i9, i10);
        a0 a0Var = this.f858g;
        if (a0Var != null) {
            a0Var.getClass();
            Method method = g1.f908a;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i7, int i8) {
        Future<n1.c> future = this.f862k;
        if (future != null) {
            try {
                this.f862k = null;
                future.get().getClass();
                setText(t1.m.a(null));
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i7, i8);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        if (this.f858g != null) {
            Method method = g1.f908a;
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z6) {
        super.setAllCaps(z6);
        getEmojiTextViewHelper().b(z6);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i7, int i8, int i9, int i10) {
        Method method = g1.f908a;
        super.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i7) {
        Method method = g1.f908a;
        super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i7) {
        Method method = g1.f908a;
        super.setAutoSizeTextTypeWithDefaults(i7);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f857f;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        e eVar = this.f857f;
        if (eVar != null) {
            eVar.f(i7);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f858g;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f858g;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i7 != 0 ? g.a.a(context, i7) : null, i8 != 0 ? g.a.a(context, i8) : null, i9 != 0 ? g.a.a(context, i9) : null, i10 != 0 ? g.a.a(context, i10) : null);
        a0 a0Var = this.f858g;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i7 != 0 ? g.a.a(context, i7) : null, i8 != 0 ? g.a.a(context, i8) : null, i9 != 0 ? g.a.a(context, i9) : null, i10 != 0 ? g.a.a(context, i10) : null);
        a0 a0Var = this.f858g;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z6) {
        getEmojiTextViewHelper().c(z6);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().f979b.f6917a.a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i7) {
        getSuperCaller().b(i7);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i7) {
        getSuperCaller().a(i7);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i7) {
        a0.e.h(i7);
        int fontMetricsInt = getPaint().getFontMetricsInt(null);
        if (i7 != fontMetricsInt) {
            setLineSpacing(i7 - fontMetricsInt, 1.0f);
        }
    }

    public void setPrecomputedText(n1.c cVar) {
        cVar.getClass();
        setText(t1.m.a(null));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f857f;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f857f;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f858g.h(colorStateList);
        this.f858g.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f858g.i(mode);
        this.f858g.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        a0 a0Var = this.f858g;
        if (a0Var != null) {
            a0Var.g(context, i7);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<n1.c> future) {
        this.f862k = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        TextDirectionHeuristic textDirectionHeuristic = aVar.f5119b;
        int i7 = 1;
        if (textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL && textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                i7 = 2;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                i7 = 3;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                i7 = 4;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                i7 = 5;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                i7 = 6;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                i7 = 7;
            }
        }
        t1.k.h(this, i7);
        getPaint().set(aVar.f5118a);
        t1.l.e(this, aVar.f5120c);
        t1.l.h(this, aVar.f5121d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i7, float f7) {
        Method method = g1.f908a;
        super.setTextSize(i7, f7);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i7) {
        if (this.f860i) {
            return;
        }
        Typeface typeface2 = null;
        if (typeface != null && i7 > 0) {
            Context context = getContext();
            i1.f fVar = i1.e.f4469a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typeface2 = Typeface.create(typeface, i7);
        }
        this.f860i = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i7);
        } finally {
            this.f860i = false;
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f858g;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f858g;
        if (a0Var != null) {
            a0Var.b();
        }
    }
}
