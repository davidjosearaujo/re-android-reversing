package f4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.t;
import d4.n;
import g4.c;
import l0.z;
import t1.b;

/* loaded from: classes.dex */
public final class a extends t {

    /* renamed from: l */
    public static final int[][] f4132l = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: j */
    public ColorStateList f4133j;

    /* renamed from: k */
    public boolean f4134k;

    public a(Context context, AttributeSet attributeSet) {
        super(q4.a.a(context, attributeSet, 2130904004, 2131887125), attributeSet);
        Context context2 = getContext();
        TypedArray d7 = n.d(context2, attributeSet, z.f4929p, 2130904004, 2131887125, new int[0]);
        if (d7.hasValue(0)) {
            b.c(this, c.a(context2, d7, 0));
        }
        this.f4134k = d7.getBoolean(1, false);
        d7.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f4133j == null) {
            int v6 = q2.a.v(this, 2130903289);
            int v7 = q2.a.v(this, 2130903308);
            int v8 = q2.a.v(this, 2130903330);
            this.f4133j = new ColorStateList(f4132l, new int[]{q2.a.F(v8, v6, 1.0f), q2.a.F(v8, v7, 0.54f), q2.a.F(v8, v7, 0.38f), q2.a.F(v8, v7, 0.38f)});
        }
        return this.f4133j;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4134k && b.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z6) {
        this.f4134k = z6;
        b.c(this, z6 ? getMaterialThemeColorsTintList() : null);
    }
}
