package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import java.lang.reflect.Method;
import t1.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class AppCompatButton extends Button {

    /* renamed from: f */
    public final e f716f;

    /* renamed from: g */
    public final a0 f717g;

    /* renamed from: h */
    public m f718h;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130903191);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        x0.a(context);
        v0.a(this, getContext());
        e eVar = new e(this);
        this.f716f = eVar;
        eVar.d(attributeSet, i7);
        a0 a0Var = new a0(this);
        this.f717g = a0Var;
        a0Var.f(attributeSet, i7);
        a0Var.b();
        getEmojiTextViewHelper().a(attributeSet, i7);
    }

    private m getEmojiTextViewHelper() {
        if (this.f718h == null) {
            this.f718h = new m(this);
        }
        return this.f718h;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f716f;
        if (eVar != null) {
            eVar.a();
        }
        a0 a0Var = this.f717g;
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
        if (!(customSelectionActionModeCallback instanceof n)) {
            return customSelectionActionModeCallback;
        }
        ((n) customSelectionActionModeCallback).getClass();
        return null;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f716f;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f716f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f717g.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f717g.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        super.onLayout(z6, i7, i8, i9, i10);
        a0 a0Var = this.f717g;
        if (a0Var != null) {
            a0Var.getClass();
            Method method = g1.f908a;
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        if (this.f717g != null) {
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
        e eVar = this.f716f;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        e eVar = this.f716f;
        if (eVar != null) {
            eVar.f(i7);
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

    public void setSupportAllCaps(boolean z6) {
        a0 a0Var = this.f717g;
        if (a0Var != null) {
            a0Var.f815a.setAllCaps(z6);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f716f;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f716f;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f717g.h(colorStateList);
        this.f717g.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f717g.i(mode);
        this.f717g.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        a0 a0Var = this.f717g;
        if (a0Var != null) {
            a0Var.g(context, i7);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i7, float f7) {
        Method method = g1.f908a;
        super.setTextSize(i7, f7);
    }
}
