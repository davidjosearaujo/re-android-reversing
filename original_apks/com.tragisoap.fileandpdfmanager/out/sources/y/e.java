package y;

import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends AutofillManager.AutofillCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final e f6474a = new e();

    public final void a(a aVar) {
        h.f(aVar, "autofill");
        aVar.getClass();
        throw null;
    }

    public final void b(a aVar) {
        h.f(aVar, "autofill");
        aVar.getClass();
        throw null;
    }

    @Override // android.view.autofill.AutofillManager.AutofillCallback
    public final void onAutofillEvent(View view, int i7, int i8) {
        h.f(view, "view");
        super.onAutofillEvent(view, i7, i8);
        Log.d("Autofill Status", i8 != 1 ? i8 != 2 ? i8 != 3 ? "Unknown status event." : "Autofill popup isn't shown because autofill is not available.\n\nDid you set up autofill?\n1. Go to Settings > System > Languages&input > Advanced > Autofill Service\n2. Pick a service\n\nDid you add an account?\n1. Go to Settings > System > Languages&input > Advanced\n2. Click on the settings icon next to the Autofill Service\n3. Add your account" : "Autofill popup was hidden." : "Autofill popup was shown.");
    }
}
