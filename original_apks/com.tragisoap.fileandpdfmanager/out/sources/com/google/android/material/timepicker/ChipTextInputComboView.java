package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import d4.m;
import g1.a;
import java.util.WeakHashMap;
import p1.k0;
import p1.q0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: f  reason: collision with root package name */
    public final Chip f3346f;

    /* renamed from: g  reason: collision with root package name */
    public final EditText f3347g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f3348h = (TextView) findViewById(2131296608);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends m {
        public a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.f3346f.setText(ChipTextInputComboView.a(chipTextInputComboView, "00"));
                return;
            }
            String a7 = ChipTextInputComboView.a(ChipTextInputComboView.this, editable);
            Chip chip = ChipTextInputComboView.this.f3346f;
            if (TextUtils.isEmpty(a7)) {
                a7 = ChipTextInputComboView.a(ChipTextInputComboView.this, "00");
            }
            chip.setText(a7);
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(2131492937, (ViewGroup) this, false);
        this.f3346f = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(2131492938, (ViewGroup) this, false);
        EditText editText = textInputLayout.getEditText();
        this.f3347g = editText;
        editText.setVisibility(4);
        editText.addTextChangedListener(new a());
        editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        addView(chip);
        addView(textInputLayout);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        editText.setId(y.e.a());
        y.e.h(this.f3348h, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    public static String a(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        try {
            return String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f3346f.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3347g.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z6) {
        this.f3346f.setChecked(z6);
        int i7 = 0;
        this.f3347g.setVisibility(z6 ? 0 : 4);
        Chip chip = this.f3346f;
        if (z6) {
            i7 = 8;
        }
        chip.setVisibility(i7);
        if (isChecked()) {
            EditText editText = this.f3347g;
            editText.requestFocus();
            editText.post(new Runnable(editText) { // from class: d4.p

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ View f3633f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ boolean f3634g = false;

                {
                    this.f3633f = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    View view = this.f3633f;
                    if (this.f3634g) {
                        WeakHashMap<View, k0> weakHashMap = y.f5540a;
                        q0 c7 = y.n.c(view);
                        if (c7 != null) {
                            q0.a aVar = c7.f5528a;
                            aVar.f5530b.f5536a.a();
                            aVar.f5529a.show(0);
                            return;
                        }
                    }
                    Context context = view.getContext();
                    Object obj = a.f4192a;
                    ((InputMethodManager) a.d.b(context, InputMethodManager.class)).showSoftInput(view, 1);
                }
            });
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3346f.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int i7, Object obj) {
        this.f3346f.setTag(i7, obj);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f3346f.toggle();
    }
}
