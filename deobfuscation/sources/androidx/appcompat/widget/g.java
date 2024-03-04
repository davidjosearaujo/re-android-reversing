package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
public final class g extends CheckedTextView {

    /* renamed from: f */
    public final h f904f;

    /* renamed from: g */
    public final e f905g;

    /* renamed from: h */
    public final a0 f906h;

    /* renamed from: i */
    public m f907i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0086 A[Catch: all -> 0x00b0, TryCatch #0 {all -> 0x00b0, blocks: (B:99:0x004a, B:101:0x0051, B:103:0x0057, B:107:0x0066, B:109:0x006c, B:111:0x0072, B:112:0x007f, B:114:0x0086, B:115:0x008f, B:117:0x0096), top: B:124:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0096 A[Catch: all -> 0x00b0, TRY_LEAVE, TryCatch #0 {all -> 0x00b0, blocks: (B:99:0x004a, B:101:0x0051, B:103:0x0057, B:107:0x0066, B:109:0x006c, B:111:0x0072, B:112:0x007f, B:114:0x0086, B:115:0x008f, B:117:0x0096), top: B:124:0x004a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public g(android.content.Context r10, android.util.AttributeSet r11) {
        /*
            r9 = this;
            androidx.appcompat.widget.x0.a(r10)
            r0 = 2130903230(0x7f0300be, float:1.7413272E38)
            r9.<init>(r10, r11, r0)
            android.content.Context r10 = r9.getContext()
            androidx.appcompat.widget.v0.a(r9, r10)
            androidx.appcompat.widget.a0 r10 = new androidx.appcompat.widget.a0
            r10.<init>(r9)
            r9.f906h = r10
            r10.f(r11, r0)
            r10.b()
            androidx.appcompat.widget.e r10 = new androidx.appcompat.widget.e
            r10.<init>(r9)
            r9.f905g = r10
            r10.d(r11, r0)
            androidx.appcompat.widget.h r10 = new androidx.appcompat.widget.h
            r10.<init>(r9)
            r9.f904f = r10
            android.content.Context r1 = r9.getContext()
            int[] r4 = a0.e.H
            androidx.appcompat.widget.a1 r1 = androidx.appcompat.widget.a1.m(r1, r11, r4, r0)
            android.content.Context r3 = r9.getContext()
            android.content.res.TypedArray r6 = r1.f831b
            java.util.WeakHashMap<android.view.View, p1.k0> r2 = p1.y.f5540a
            r7 = 2130903230(0x7f0300be, float:1.7413272E38)
            r8 = 0
            r2 = r9
            r5 = r11
            p1.y.m.d(r2, r3, r4, r5, r6, r7, r8)
            r2 = 1
            boolean r3 = r1.l(r2)     // Catch: java.lang.Throwable -> Lb0
            r4 = 0
            if (r3 == 0) goto L63
            int r3 = r1.i(r2, r4)     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto L63
            android.content.Context r5 = r9.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L63 java.lang.Throwable -> Lb0
            android.graphics.drawable.Drawable r3 = g.a.a(r5, r3)     // Catch: android.content.res.Resources.NotFoundException -> L63 java.lang.Throwable -> Lb0
            r9.setCheckMarkDrawable(r3)     // Catch: android.content.res.Resources.NotFoundException -> L63 java.lang.Throwable -> Lb0
            goto L64
        L63:
            r2 = r4
        L64:
            if (r2 != 0) goto L7f
            boolean r2 = r1.l(r4)     // Catch: java.lang.Throwable -> Lb0
            if (r2 == 0) goto L7f
            int r2 = r1.i(r4, r4)     // Catch: java.lang.Throwable -> Lb0
            if (r2 == 0) goto L7f
            android.widget.CheckedTextView r3 = r10.f909a     // Catch: java.lang.Throwable -> Lb0
            android.content.Context r4 = r3.getContext()     // Catch: java.lang.Throwable -> Lb0
            android.graphics.drawable.Drawable r2 = g.a.a(r4, r2)     // Catch: java.lang.Throwable -> Lb0
            r3.setCheckMarkDrawable(r2)     // Catch: java.lang.Throwable -> Lb0
        L7f:
            r2 = 2
            boolean r3 = r1.l(r2)     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto L8f
            android.widget.CheckedTextView r3 = r10.f909a     // Catch: java.lang.Throwable -> Lb0
            android.content.res.ColorStateList r2 = r1.b(r2)     // Catch: java.lang.Throwable -> Lb0
            r3.setCheckMarkTintList(r2)     // Catch: java.lang.Throwable -> Lb0
        L8f:
            r2 = 3
            boolean r3 = r1.l(r2)     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto La5
            android.widget.CheckedTextView r10 = r10.f909a     // Catch: java.lang.Throwable -> Lb0
            r3 = -1
            int r2 = r1.h(r2, r3)     // Catch: java.lang.Throwable -> Lb0
            r3 = 0
            android.graphics.PorterDuff$Mode r2 = androidx.appcompat.widget.h0.b(r2, r3)     // Catch: java.lang.Throwable -> Lb0
            r10.setCheckMarkTintMode(r2)     // Catch: java.lang.Throwable -> Lb0
        La5:
            r1.n()
            androidx.appcompat.widget.m r9 = r9.getEmojiTextViewHelper()
            r9.a(r11, r0)
            return
        Lb0:
            r9 = move-exception
            r1.n()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private m getEmojiTextViewHelper() {
        if (this.f907i == null) {
            this.f907i = new m(this);
        }
        return this.f907i;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        a0 a0Var = this.f906h;
        if (a0Var != null) {
            a0Var.b();
        }
        e eVar = this.f905g;
        if (eVar != null) {
            eVar.a();
        }
        h hVar = this.f904f;
        if (hVar != null) {
            hVar.a();
        }
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

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f905g;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f905g;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        h hVar = this.f904f;
        if (hVar != null) {
            return hVar.f910b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        h hVar = this.f904f;
        if (hVar != null) {
            return hVar.f911c;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f906h.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f906h.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a0.e.v(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z6) {
        super.setAllCaps(z6);
        getEmojiTextViewHelper().b(z6);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f905g;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        e eVar = this.f905g;
        if (eVar != null) {
            eVar.f(i7);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i7) {
        setCheckMarkDrawable(g.a.a(getContext(), i7));
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        h hVar = this.f904f;
        if (hVar != null) {
            if (hVar.f913f) {
                hVar.f913f = false;
                return;
            }
            hVar.f913f = true;
            hVar.a();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f906h;
        if (a0Var != null) {
            a0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        a0 a0Var = this.f906h;
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

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f905g;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f905g;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        h hVar = this.f904f;
        if (hVar != null) {
            hVar.f910b = colorStateList;
            hVar.f912d = true;
            hVar.a();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        h hVar = this.f904f;
        if (hVar != null) {
            hVar.f911c = mode;
            hVar.e = true;
            hVar.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f906h.h(colorStateList);
        this.f906h.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f906h.i(mode);
        this.f906h.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        a0 a0Var = this.f906h;
        if (a0Var != null) {
            a0Var.g(context, i7);
        }
    }
}
