package o4;

import android.view.View;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5337a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f5338b;

    public /* synthetic */ c(m mVar, int i7) {
        this.f5337a = i7;
        this.f5338b = mVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z6) {
        switch (this.f5337a) {
            case 0:
                f fVar = (f) this.f5338b;
                fVar.t(fVar.u());
                return;
            default:
                l lVar = (l) this.f5338b;
                lVar.f5358l = z6;
                lVar.q();
                if (!z6) {
                    lVar.t(false);
                    lVar.m = false;
                    return;
                }
                return;
        }
    }
}
