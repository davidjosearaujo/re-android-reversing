package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class p extends ImageView {

    /* renamed from: f */
    public final e f1011f;

    /* renamed from: g */
    public final o f1012g;

    /* renamed from: h */
    public boolean f1013h;

    public p() {
        throw null;
    }

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        x0.a(context);
        this.f1013h = false;
        v0.a(this, getContext());
        e eVar = new e(this);
        this.f1011f = eVar;
        eVar.d(attributeSet, i7);
        o oVar = new o(this);
        this.f1012g = oVar;
        oVar.b(attributeSet, i7);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1011f;
        if (eVar != null) {
            eVar.a();
        }
        o oVar = this.f1012g;
        if (oVar != null) {
            oVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1011f;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1011f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        y0 y0Var;
        o oVar = this.f1012g;
        if (oVar == null || (y0Var = oVar.f1009b) == null) {
            return null;
        }
        return y0Var.f1072a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        y0 y0Var;
        o oVar = this.f1012g;
        if (oVar == null || (y0Var = oVar.f1009b) == null) {
            return null;
        }
        return y0Var.f1073b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return ((this.f1012g.f1008a.getBackground() instanceof RippleDrawable) ^ true) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1011f;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        e eVar = this.f1011f;
        if (eVar != null) {
            eVar.f(i7);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        o oVar = this.f1012g;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        o oVar = this.f1012g;
        if (oVar != null && drawable != null && !this.f1013h) {
            oVar.f1010c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        o oVar2 = this.f1012g;
        if (oVar2 != null) {
            oVar2.a();
            if (this.f1013h) {
                return;
            }
            o oVar3 = this.f1012g;
            if (oVar3.f1008a.getDrawable() != null) {
                oVar3.f1008a.getDrawable().setLevel(oVar3.f1010c);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i7) {
        super.setImageLevel(i7);
        this.f1013h = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i7) {
        o oVar = this.f1012g;
        if (oVar != null) {
            oVar.c(i7);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        o oVar = this.f1012g;
        if (oVar != null) {
            oVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1011f;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1011f;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        o oVar = this.f1012g;
        if (oVar != null) {
            if (oVar.f1009b == null) {
                oVar.f1009b = new y0();
            }
            y0 y0Var = oVar.f1009b;
            y0Var.f1072a = colorStateList;
            y0Var.f1075d = true;
            oVar.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        o oVar = this.f1012g;
        if (oVar != null) {
            if (oVar.f1009b == null) {
                oVar.f1009b = new y0();
            }
            y0 y0Var = oVar.f1009b;
            y0Var.f1073b = mode;
            y0Var.f1074c = true;
            oVar.a();
        }
    }
}
