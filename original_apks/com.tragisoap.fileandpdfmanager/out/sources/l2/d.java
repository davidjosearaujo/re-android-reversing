package l2;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import h1.f;
import h1.i;
import j1.a;
import java.util.ArrayList;
import l2.g;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends f implements Animatable {

    /* renamed from: g */
    public b f4954g;

    /* renamed from: h */
    public Context f4955h;

    /* renamed from: i */
    public e f4956i;

    /* renamed from: j */
    public ArrayList<c> f4957j;

    /* renamed from: k */
    public final a f4958k;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Drawable.Callback {
        public a() {
            d.this = r1;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
            d.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j7) {
            d.this.scheduleSelf(runnable, j7);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            d.this.unscheduleSelf(runnable);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a */
        public g f4960a;

        /* renamed from: b */
        public AnimatorSet f4961b;

        /* renamed from: c */
        public ArrayList<Animator> f4962c;

        /* renamed from: d */
        public o.b<Animator, String> f4963d;

        public b(a aVar) {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a */
        public final Drawable.ConstantState f4964a;

        public c(Drawable.ConstantState constantState) {
            this.f4964a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f4964a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.f4964a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            d dVar = new d();
            Drawable newDrawable = this.f4964a.newDrawable();
            dVar.f4966f = newDrawable;
            newDrawable.setCallback(dVar.f4958k);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            d dVar = new d();
            Drawable newDrawable = this.f4964a.newDrawable(resources);
            dVar.f4966f = newDrawable;
            newDrawable.setCallback(dVar.f4958k);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            d dVar = new d();
            Drawable newDrawable = this.f4964a.newDrawable(resources, theme);
            dVar.f4966f = newDrawable;
            newDrawable.setCallback(dVar.f4958k);
            return dVar;
        }
    }

    public d() {
        this(null);
    }

    public d(Context context) {
        this.f4956i = null;
        this.f4957j = null;
        a aVar = new a();
        this.f4958k = aVar;
        this.f4955h = context;
        this.f4954g = new b(aVar);
    }

    @Override // l2.f, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.b.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            return a.b.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f4954g.f4960a.draw(canvas);
        if (this.f4954g.f4961b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f4966f;
        return drawable != null ? a.C0071a.a(drawable) : this.f4954g.f4960a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f4954g.getClass();
        return 0 | changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f4966f;
        return drawable != null ? a.b.c(drawable) : this.f4954g.f4960a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f4966f != null) {
            return new c(this.f4966f.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f4954g.f4960a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f4954g.f4960a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.getOpacity() : this.f4954g.f4960a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArray;
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.b.d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    typedArray = i.e(resources, theme, attributeSet, a.e);
                    int resourceId = typedArray.getResourceId(0, 0);
                    if (resourceId != 0) {
                        g gVar = new g();
                        ThreadLocal<TypedValue> threadLocal = f.f4353a;
                        gVar.f4966f = f.a.a(resources, resourceId, theme);
                        new g.h(gVar.f4966f.getConstantState());
                        gVar.f4972k = false;
                        gVar.setCallback(this.f4958k);
                        g gVar2 = this.f4954g.f4960a;
                        if (gVar2 != null) {
                            gVar2.setCallback(null);
                        }
                        this.f4954g.f4960a = gVar;
                    }
                } else if ("target".equals(name)) {
                    typedArray = resources.obtainAttributes(attributeSet, a.f4951f);
                    String string = typedArray.getString(0);
                    int resourceId2 = typedArray.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f4955h;
                        if (context != null) {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(context, resourceId2);
                            loadAnimator.setTarget(this.f4954g.f4960a.f4968g.f5014b.f5012o.getOrDefault(string, null));
                            b bVar = this.f4954g;
                            if (bVar.f4962c == null) {
                                bVar.f4962c = new ArrayList<>();
                                this.f4954g.f4963d = new o.b<>();
                            }
                            this.f4954g.f4962c.add(loadAnimator);
                            this.f4954g.f4963d.put(loadAnimator, string);
                        } else {
                            typedArray.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                typedArray.recycle();
            }
            eventType = xmlPullParser.next();
        }
        b bVar2 = this.f4954g;
        if (bVar2.f4961b == null) {
            bVar2.f4961b = new AnimatorSet();
        }
        bVar2.f4961b.playTogether(bVar2.f4962c);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f4966f;
        return drawable != null ? a.C0071a.d(drawable) : this.f4954g.f4960a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f4966f;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f4954g.f4961b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.isStateful() : this.f4954g.f4960a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f4954g.f4960a.setBounds(rect);
        }
    }

    @Override // l2.f, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i7) {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.setLevel(i7) : this.f4954g.f4960a.setLevel(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4966f;
        return drawable != null ? drawable.setState(iArr) : this.f4954g.f4960a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i7) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.setAlpha(i7);
        } else {
            this.f4954g.f4960a.setAlpha(i7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z6) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            a.C0071a.e(drawable, z6);
        } else {
            this.f4954g.f4960a.setAutoMirrored(z6);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4954g.f4960a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i7) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            j1.a.a(drawable, i7);
        } else {
            this.f4954g.f4960a.setTint(i7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            j1.a.b(drawable, colorStateList);
        } else {
            this.f4954g.f4960a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            j1.a.c(drawable, mode);
        } else {
            this.f4954g.f4960a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z6, boolean z7) {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            return drawable.setVisible(z6, z7);
        }
        this.f4954g.f4960a.setVisible(z6, z7);
        return super.setVisible(z6, z7);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f4954g.f4961b.isStarted()) {
            this.f4954g.f4961b.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f4966f;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f4954g.f4961b.end();
        }
    }
}
