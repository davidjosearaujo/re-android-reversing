package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.t;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import f.p;
import f4.a;
import o4.r;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends p {
    @Override // f.p
    public final d a(Context context, AttributeSet attributeSet) {
        return new r(context, attributeSet);
    }

    @Override // f.p
    public final AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // f.p
    public final f c(Context context, AttributeSet attributeSet) {
        return new MaterialCheckBox(context, attributeSet);
    }

    @Override // f.p
    public final t d(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // f.p
    public final c0 e(Context context, AttributeSet attributeSet) {
        return new p4.a(context, attributeSet);
    }
}
