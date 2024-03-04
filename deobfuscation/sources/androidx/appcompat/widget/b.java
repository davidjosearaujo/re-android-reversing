package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class b extends Drawable {

    /* renamed from: a */
    public final ActionBarContainer f833a;

    public b(ActionBarContainer actionBarContainer) {
        this.f833a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f833a;
        if (actionBarContainer.m) {
            Drawable drawable = actionBarContainer.f666l;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f664j;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f833a;
        Drawable drawable3 = actionBarContainer2.f665k;
        if (drawable3 == null || !actionBarContainer2.f667n) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.f833a;
        if (!actionBarContainer.m) {
            drawable = actionBarContainer.f664j;
            if (drawable == null) {
                return;
            }
        } else if (actionBarContainer.f666l == null) {
            return;
        } else {
            drawable = actionBarContainer.f664j;
        }
        drawable.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i7) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
