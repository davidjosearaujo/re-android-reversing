package o3;

import android.view.View;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final View f5330a;

    /* renamed from: b  reason: collision with root package name */
    public int f5331b;

    /* renamed from: c  reason: collision with root package name */
    public int f5332c;

    /* renamed from: d  reason: collision with root package name */
    public int f5333d;

    public d(View view) {
        this.f5330a = view;
    }

    public final void a() {
        View view = this.f5330a;
        int top = this.f5333d - (view.getTop() - this.f5331b);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        view.offsetTopAndBottom(top);
        View view2 = this.f5330a;
        view2.offsetLeftAndRight(0 - (view2.getLeft() - this.f5332c));
    }
}
