package s3;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import j1.a;
import java.util.WeakHashMap;
import k4.f;
import k4.i;
import k4.m;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialButton f5968a;

    /* renamed from: b  reason: collision with root package name */
    public i f5969b;

    /* renamed from: c  reason: collision with root package name */
    public int f5970c;

    /* renamed from: d  reason: collision with root package name */
    public int f5971d;
    public int e;

    /* renamed from: f  reason: collision with root package name */
    public int f5972f;

    /* renamed from: g  reason: collision with root package name */
    public int f5973g;

    /* renamed from: h  reason: collision with root package name */
    public int f5974h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f5975i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f5976j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f5977k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f5978l;
    public f m;

    /* renamed from: q  reason: collision with root package name */
    public boolean f5982q;
    public RippleDrawable s;

    /* renamed from: t  reason: collision with root package name */
    public int f5984t;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5979n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f5980o = false;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5981p = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5983r = true;

    public a(MaterialButton materialButton, i iVar) {
        this.f5968a = materialButton;
        this.f5969b = iVar;
    }

    public final m a() {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        int numberOfLayers = this.s.getNumberOfLayers();
        RippleDrawable rippleDrawable2 = this.s;
        return (m) (numberOfLayers > 2 ? rippleDrawable2.getDrawable(2) : rippleDrawable2.getDrawable(1));
    }

    public final f b(boolean z6) {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (f) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z6 ? 1 : 0);
    }

    public final void c(i iVar) {
        this.f5969b = iVar;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(iVar);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(iVar);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(iVar);
        }
    }

    public final void d(int i7, int i8) {
        MaterialButton materialButton = this.f5968a;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        int f7 = y.e.f(materialButton);
        int paddingTop = this.f5968a.getPaddingTop();
        int e = y.e.e(this.f5968a);
        int paddingBottom = this.f5968a.getPaddingBottom();
        int i9 = this.e;
        int i10 = this.f5972f;
        this.f5972f = i8;
        this.e = i7;
        if (!this.f5980o) {
            e();
        }
        y.e.k(this.f5968a, f7, (paddingTop + i7) - i9, e, (paddingBottom + i8) - i10);
    }

    public final void e() {
        MaterialButton materialButton = this.f5968a;
        f fVar = new f(this.f5969b);
        fVar.i(this.f5968a.getContext());
        a.b.h(fVar, this.f5976j);
        PorterDuff.Mode mode = this.f5975i;
        if (mode != null) {
            a.b.i(fVar, mode);
        }
        ColorStateList colorStateList = this.f5977k;
        fVar.f4720f.f4749k = (float) this.f5974h;
        fVar.invalidateSelf();
        f.b bVar = fVar.f4720f;
        if (bVar.f4743d != colorStateList) {
            bVar.f4743d = colorStateList;
            fVar.onStateChange(fVar.getState());
        }
        f fVar2 = new f(this.f5969b);
        fVar2.setTint(0);
        float f7 = (float) this.f5974h;
        int v6 = this.f5979n ? q2.a.v(this.f5968a, 2130903330) : 0;
        fVar2.f4720f.f4749k = f7;
        fVar2.invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(v6);
        f.b bVar2 = fVar2.f4720f;
        if (bVar2.f4743d != valueOf) {
            bVar2.f4743d = valueOf;
            fVar2.onStateChange(fVar2.getState());
        }
        f fVar3 = new f(this.f5969b);
        this.m = fVar3;
        a.b.g(fVar3, -1);
        ColorStateList colorStateList2 = this.f5978l;
        if (colorStateList2 == null) {
            colorStateList2 = ColorStateList.valueOf(0);
        }
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList2, new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{fVar2, fVar}), this.f5970c, this.e, this.f5971d, this.f5972f), this.m);
        this.s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        f b2 = b(false);
        if (b2 != null) {
            b2.j((float) this.f5984t);
            b2.setState(this.f5968a.getDrawableState());
        }
    }

    public final void f() {
        int i7 = 0;
        f b2 = b(false);
        f b7 = b(true);
        if (b2 != null) {
            ColorStateList colorStateList = this.f5977k;
            b2.f4720f.f4749k = (float) this.f5974h;
            b2.invalidateSelf();
            f.b bVar = b2.f4720f;
            if (bVar.f4743d != colorStateList) {
                bVar.f4743d = colorStateList;
                b2.onStateChange(b2.getState());
            }
            if (b7 != null) {
                float f7 = (float) this.f5974h;
                if (this.f5979n) {
                    i7 = q2.a.v(this.f5968a, 2130903330);
                }
                b7.f4720f.f4749k = f7;
                b7.invalidateSelf();
                ColorStateList valueOf = ColorStateList.valueOf(i7);
                f.b bVar2 = b7.f4720f;
                if (bVar2.f4743d != valueOf) {
                    bVar2.f4743d = valueOf;
                    b7.onStateChange(b7.getState());
                }
            }
        }
    }
}
