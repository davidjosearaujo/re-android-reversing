package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class TimePickerView extends ConstraintLayout {

    /* renamed from: w */
    public static final /* synthetic */ int f3364w = 0;

    /* renamed from: v */
    public final Chip f3365v;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements View.OnClickListener {
        public a() {
            TimePickerView.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TimePickerView timePickerView = TimePickerView.this;
            int i7 = TimePickerView.f3364w;
            timePickerView.getClass();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        LayoutInflater.from(context).inflate(2131492939, this);
        ClockFaceView clockFaceView = (ClockFaceView) findViewById(2131296600);
        ((MaterialButtonToggleGroup) findViewById(2131296605)).f2919h.add(new MaterialButtonToggleGroup.d() { // from class: com.google.android.material.timepicker.e
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
            public final void a() {
                TimePickerView timePickerView = TimePickerView.this;
                int i7 = TimePickerView.f3364w;
                timePickerView.getClass();
            }
        });
        Chip chip = (Chip) findViewById(2131296610);
        Chip chip2 = (Chip) findViewById(2131296607);
        this.f3365v = chip2;
        ClockHandView clockHandView = (ClockHandView) findViewById(2131296601);
        g gVar = new g(new GestureDetector(getContext(), new f(this)));
        chip.setOnTouchListener(gVar);
        chip2.setOnTouchListener(gVar);
        chip.setTag(2131296779, 12);
        chip2.setTag(2131296779, 10);
        chip.setOnClickListener(aVar);
        chip2.setOnClickListener(aVar);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i7) {
        super.onVisibilityChanged(view, i7);
        if (view == this && i7 == 0) {
            this.f3365v.sendAccessibilityEvent(8);
        }
    }
}
