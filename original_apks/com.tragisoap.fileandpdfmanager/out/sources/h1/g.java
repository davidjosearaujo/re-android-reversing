package h1;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import h1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f4361f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f4362g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f4363h;

    public /* synthetic */ g(int i7, int i8, Object obj) {
        this.f4361f = i8;
        this.f4363h = obj;
        this.f4362g = i7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4361f) {
            case 0:
                ((f.e) this.f4363h).c(this.f4362g);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4363h;
                int i7 = this.f4362g;
                View view = (View) sideSheetBehavior.f3240u.get();
                if (view != null) {
                    sideSheetBehavior.z(view, i7, false);
                    return;
                }
                return;
        }
    }
}
