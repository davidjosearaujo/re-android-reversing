package u1;

import android.content.Context;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public abstract class c extends a {
    public int m;

    /* renamed from: n */
    public int f6090n;

    /* renamed from: o */
    public LayoutInflater f6091o;

    @Deprecated
    public c(Context context, int i7) {
        super(context);
        this.f6090n = i7;
        this.m = i7;
        this.f6091o = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
