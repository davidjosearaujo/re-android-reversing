package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.g;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.savedstate.a;
import h2.b;
import h2.c;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class l extends Dialog implements n, w, c {

    /* renamed from: f */
    public o f421f;

    /* renamed from: g */
    public final b f422g = new b(this);

    /* renamed from: h */
    public final OnBackPressedDispatcher f423h = new OnBackPressedDispatcher(new k(0, this));

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, int i7) {
        super(context, i7);
        h.f(context, "context");
    }

    public static void e(l lVar) {
        h.f(lVar, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.activity.w
    public final OnBackPressedDispatcher a() {
        return this.f423h;
    }

    @Override // h2.c
    public final a b() {
        return this.f422g.f4376b;
    }

    @Override // androidx.lifecycle.n
    public final o k() {
        o oVar = this.f421f;
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(this);
        this.f421f = oVar2;
        return oVar2;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f423h.b();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f423h;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            h.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.getClass();
            onBackPressedDispatcher.f387f = onBackInvokedDispatcher;
            onBackPressedDispatcher.c(onBackPressedDispatcher.f389h);
        }
        this.f422g.b(bundle);
        o oVar = this.f421f;
        if (oVar == null) {
            oVar = new o(this);
            this.f421f = oVar;
        }
        oVar.f(g.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        h.e(onSaveInstanceState, "super.onSaveInstanceState()");
        this.f422g.c(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        o oVar = this.f421f;
        if (oVar == null) {
            oVar = new o(this);
            this.f421f = oVar;
        }
        oVar.f(g.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        o oVar = this.f421f;
        if (oVar == null) {
            oVar = new o(this);
            this.f421f = oVar;
        }
        oVar.f(g.a.ON_DESTROY);
        this.f421f = null;
        super.onStop();
    }
}
