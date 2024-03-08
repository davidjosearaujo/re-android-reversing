package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import g.a;
import t1.p;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class f extends CheckBox implements p {

    /* renamed from: f */
    public final i f899f;

    /* renamed from: g */
    public final e f900g;

    /* renamed from: h */
    public final a0 f901h;

    /* renamed from: i */
    public m f902i;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130903219);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        x0.a(context);
        v0.a(this, getContext());
        i iVar = new i(this);
        this.f899f = iVar;
        iVar.b(attributeSet, i7);
        e eVar = new e(this);
        this.f900g = eVar;
        eVar.d(attributeSet, i7);
        a0 a0Var = new a0(this);
        this.f901h = a0Var;
        a0Var.f(attributeSet, i7);
        getEmojiTextViewHelper().a(attributeSet, i7);
    }

    private m getEmojiTextViewHelper() {
        if (this.f902i == null) {
            this.f902i = new m(this);
        }
        return this.f902i;
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f900g;
        if (eVar != null) {
            eVar.a();
        }
        a0 a0Var = this.f901h;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView, android.widget.CompoundButton
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.f899f;
        if (iVar != null) {
            iVar.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f900g;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f900g;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // t1.p
    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f899f;
        if (iVar != null) {
            return iVar.f917b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f899f;
        if (iVar != null) {
            return iVar.f918c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f901h.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f901h.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z6) {
        super.setAllCaps(z6);
        getEmojiTextViewHelper().b(z6);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f900g;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        e eVar = this.f900g;
        if (eVar != null) {
            eVar.f(i7);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i7) {
        setButtonDrawable(a.a(getContext(), i7));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f899f;
        if (iVar == null) {
            return;
        }
        if (iVar.f920f) {
            iVar.f920f = false;
            return;
        }
        iVar.f920f = true;
        iVar.a();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f901h;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f901h;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z6) {
        getEmojiTextViewHelper().c(z6);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().f979b.f6917a.a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f900g;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f900g;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // t1.p
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f899f;
        if (iVar != null) {
            iVar.f917b = colorStateList;
            iVar.f919d = true;
            iVar.a();
        }
    }

    @Override // t1.p
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.f899f;
        if (iVar != null) {
            iVar.f918c = mode;
            iVar.e = true;
            iVar.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f901h.h(colorStateList);
        this.f901h.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f901h.i(mode);
        this.f901h.b();
    }
}
