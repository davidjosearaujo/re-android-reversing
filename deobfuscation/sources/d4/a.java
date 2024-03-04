package d4;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public final class a extends p1.a {

    /* renamed from: d */
    public final /* synthetic */ CheckableImageButton f3566d;

    public a(CheckableImageButton checkableImageButton) {
        this.f3566d = checkableImageButton;
    }

    @Override // p1.a
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f3566d.isChecked());
    }

    @Override // p1.a
    public final void d(View view, q1.f fVar) {
        this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
        fVar.f5624a.setCheckable(this.f3566d.f3208j);
        fVar.f5624a.setChecked(this.f3566d.isChecked());
    }
}
