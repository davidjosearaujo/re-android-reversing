package com.google.android.material.datepicker;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.davemorrissey.labs.subscaleview.R;
import com.tragisoap.fileandpdfmanager.PartPreviewActivity;
import e5.k;
import e5.m;
import e5.p;
import e5.v;
import j6.a;
import java.lang.reflect.InvocationTargetException;
import o4.t;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: f */
    public final /* synthetic */ int f3099f;

    /* renamed from: g */
    public final /* synthetic */ Object f3100g;

    public /* synthetic */ q(int i7, Object obj) {
        this.f3099f = i7;
        this.f3100g = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        int i7 = 0;
        PasswordTransformationMethod passwordTransformationMethod = null;
        switch (this.f3099f) {
            case 0:
                r rVar = (r) this.f3100g;
                rVar.M0.setEnabled(rVar.U().h());
                rVar.K0.toggle();
                if (rVar.f3114z0 != 1) {
                    i7 = 1;
                }
                rVar.f3114z0 = i7;
                rVar.K0.setContentDescription(rVar.K0.getContext().getString(i7 == 1 ? 2131820701 : 2131820703));
                rVar.Y();
                return;
            case 1:
                t tVar = (t) this.f3100g;
                EditText editText2 = tVar.f5407f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = tVar.f5407f;
                    if (editText3 != null && (editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        i7 = 1;
                    }
                    if (i7 != 0) {
                        editText = tVar.f5407f;
                    } else {
                        editText = tVar.f5407f;
                        passwordTransformationMethod = PasswordTransformationMethod.getInstance();
                    }
                    editText.setTransformationMethod(passwordTransformationMethod);
                    if (selectionEnd >= 0) {
                        tVar.f5407f.setSelection(selectionEnd);
                    }
                    tVar.q();
                    return;
                }
                return;
            case 2:
                ((k.a) this.f3100g).D.performClick();
                return;
            case 3:
                ((p.a) this.f3100g).C.performClick();
                return;
            case 4:
                PartPreviewActivity partPreviewActivity = (PartPreviewActivity) this.f3100g;
                int i8 = PartPreviewActivity.D;
                partPreviewActivity.getClass();
                try {
                    m.f3832a.invoke(null, partPreviewActivity);
                    return;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    return;
                }
            case R.styleable.SubsamplingScaleImageView_zoomEnabled /* 5 */:
                ((v.a) this.f3100g).C.performClick();
                return;
            default:
                int i9 = a.f4599s0;
                ((a) this.f3100g).P(false, false);
                return;
        }
    }
}
