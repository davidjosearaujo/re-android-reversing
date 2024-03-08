package l2;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import j1.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class f extends Drawable {

    /* renamed from: f  reason: collision with root package name */
    public Drawable f4966f;

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.b.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void clearColorFilter() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getCurrent() : super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getMinimumHeight() : super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getMinimumWidth() : super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getState() : super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getTransparentRegion() : super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i7) {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.setLevel(i7) : super.onLevelChange(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i7) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.setChangingConfigurations(i7);
        } else {
            super.setChangingConfigurations(i7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(int i7, PorterDuff.Mode mode) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.setColorFilter(i7, mode);
        } else {
            super.setColorFilter(i7, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z6) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.setFilterBitmap(z6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f7, float f8) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.b.e(drawable, f7, f8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i7, int i8, int i9, int i10) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.b.f(drawable, i7, i8, i9, i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.setState(iArr) : super.setState(iArr);
    }
}
