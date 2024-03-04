package e4;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public abstract class a<V extends View> {

    /* renamed from: a */
    public final TimeInterpolator f3762a;

    /* renamed from: b */
    public final V f3763b;

    /* renamed from: c */
    public final int f3764c;

    /* renamed from: d */
    public final int f3765d;
    public final int e;

    /* renamed from: f */
    public androidx.activity.b f3766f;

    public a(V v6) {
        this.f3763b = v6;
        Context context = v6.getContext();
        this.f3762a = j.d(context, 2130903889, r1.a.b(0.0f, 0.0f, 0.0f, 1.0f));
        this.f3764c = j.c(context, 2130903872, 300);
        this.f3765d = j.c(context, 2130903877, 150);
        this.e = j.c(context, 2130903876, 100);
    }
}
