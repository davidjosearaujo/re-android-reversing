package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
public class l extends Dialog implements androidx.lifecycle.n, w, h2.c {

    /* renamed from: f */
    public androidx.lifecycle.o f421f;

    /* renamed from: g */
    public final h2.b f422g;

    /* renamed from: h */
    public final OnBackPressedDispatcher f423h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, int i7) {
        super(context, i7);
        r5.h.f(context, "context");
        this.f422g = new h2.b(this);
        this.f423h = new OnBackPressedDispatcher(new k(0, this));
    }

    public static void e(l lVar) {
        r5.h.f(lVar, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.activity.w
    public final OnBackPressedDispatcher a() {
        return this.f423h;
    }

    @Override // h2.c
    public final androidx.savedstate.a b() {
        return this.f422g.f4376b;
    }

    @Override // androidx.lifecycle.n
    public final androidx.lifecycle.o k() {
        androidx.lifecycle.o oVar = this.f421f;
        if (oVar == null) {
            androidx.lifecycle.o oVar2 = new androidx.lifecycle.o(this);
            this.f421f = oVar2;
            return oVar2;
        }
        return oVar;
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
            r5.h.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.getClass();
            onBackPressedDispatcher.f387f = onBackInvokedDispatcher;
            onBackPressedDispatcher.c(onBackPressedDispatcher.f389h);
        }
        this.f422g.b(bundle);
        androidx.lifecycle.o oVar = this.f421f;
        if (oVar == null) {
            oVar = new androidx.lifecycle.o(this);
            this.f421f = oVar;
        }
        oVar.f(g.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        r5.h.e(onSaveInstanceState, "super.onSaveInstanceState()");
        this.f422g.c(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        androidx.lifecycle.o oVar = this.f421f;
        if (oVar == null) {
            oVar = new androidx.lifecycle.o(this);
            this.f421f = oVar;
        }
        oVar.f(g.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        androidx.lifecycle.o oVar = this.f421f;
        if (oVar == null) {
            oVar = new androidx.lifecycle.o(this);
            this.f421f = oVar;
        }
        oVar.f(g.a.ON_DESTROY);
        this.f421f = null;
        super.onStop();
    }
}
