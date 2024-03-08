package androidx.activity;

import android.view.MotionEvent;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.e1;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.e;
import androidx.emoji2.text.l;
import androidx.lifecycle.g;
import androidx.lifecycle.u;
import com.davemorrissey.labs.subscaleview.R;
import o4.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ int f419f;

    /* renamed from: g */
    public final /* synthetic */ Object f420g;

    public /* synthetic */ k(int i7, Object obj) {
        this.f419f = i7;
        this.f420g = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f419f) {
            case 0:
                l.e((l) this.f420g);
                return;
            case 1:
                h hVar = null;
                Toolbar.f fVar = ((Toolbar) this.f420g).R;
                if (fVar != null) {
                    hVar = fVar.f796g;
                }
                if (hVar != null) {
                    hVar.collapseActionView();
                    return;
                }
                return;
            case 2:
                ((e1) this.f420g).b(false);
                return;
            case 3:
                AndroidComposeView androidComposeView = (AndroidComposeView) this.f420g;
                Class<?> cls = AndroidComposeView.f1105x;
                r5.h.f(androidComposeView, "this$0");
                androidComposeView.f1121v = false;
                MotionEvent motionEvent = androidComposeView.f1120u;
                r5.h.c(motionEvent);
                if (motionEvent.getActionMasked() == 10) {
                    androidComposeView.r(motionEvent);
                    return;
                }
                throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
            case 4:
                e eVar = (e) this.f420g;
                int i7 = e.e;
                r5.h.f(eVar, "this$0");
                eVar.getClass();
                throw null;
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                ((l.b) this.f420g).c();
                return;
            case 6:
                u uVar = (u) this.f420g;
                u uVar2 = u.m;
                r5.h.f(uVar, "this$0");
                if (uVar.f1886g == 0) {
                    uVar.f1887h = true;
                    uVar.f1890k.f(g.a.ON_PAUSE);
                }
                if (uVar.f1885f == 0 && uVar.f1887h) {
                    uVar.f1890k.f(g.a.ON_STOP);
                    uVar.f1888i = true;
                    return;
                }
                return;
            default:
                ((f) this.f420g).t(true);
                return;
        }
    }
}
