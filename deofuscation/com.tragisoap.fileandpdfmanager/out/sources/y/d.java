package y;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f6473a = new d();

    public final AutofillId a(ViewStructure viewStructure) {
        h.f(viewStructure, "structure");
        return viewStructure.getAutofillId();
    }

    public final boolean b(AutofillValue autofillValue) {
        h.f(autofillValue, "value");
        return autofillValue.isDate();
    }

    public final boolean c(AutofillValue autofillValue) {
        h.f(autofillValue, "value");
        return autofillValue.isList();
    }

    public final boolean d(AutofillValue autofillValue) {
        h.f(autofillValue, "value");
        return autofillValue.isText();
    }

    public final boolean e(AutofillValue autofillValue) {
        h.f(autofillValue, "value");
        return autofillValue.isToggle();
    }

    public final void f(ViewStructure viewStructure, String[] strArr) {
        h.f(viewStructure, "structure");
        h.f(strArr, "hints");
        viewStructure.setAutofillHints(strArr);
    }

    public final void g(ViewStructure viewStructure, AutofillId autofillId, int i7) {
        h.f(viewStructure, "structure");
        h.f(autofillId, "parent");
        viewStructure.setAutofillId(autofillId, i7);
    }

    public final void h(ViewStructure viewStructure, int i7) {
        h.f(viewStructure, "structure");
        viewStructure.setAutofillType(i7);
    }

    public final CharSequence i(AutofillValue autofillValue) {
        h.f(autofillValue, "value");
        CharSequence textValue = autofillValue.getTextValue();
        h.e(textValue, "value.textValue");
        return textValue;
    }
}
