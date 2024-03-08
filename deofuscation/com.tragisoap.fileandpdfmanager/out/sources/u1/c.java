package u1;

import android.content.Context;
import android.view.LayoutInflater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class c extends a {
    public int m;

    /* renamed from: n  reason: collision with root package name */
    public int f6090n;

    /* renamed from: o  reason: collision with root package name */
    public LayoutInflater f6091o;

    @Deprecated
    public c(Context context, int i7) {
        super(context);
        this.f6090n = i7;
        this.m = i7;
        this.f6091o = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
