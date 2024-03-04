package q1;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: f */
    public final int f5620f;

    /* renamed from: g */
    public final f f5621g;

    /* renamed from: h */
    public final int f5622h;

    public a(int i7, f fVar, int i8) {
        this.f5620f = i7;
        this.f5621g = fVar;
        this.f5622h = i8;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f5620f);
        f fVar = this.f5621g;
        fVar.f5624a.performAction(this.f5622h, bundle);
    }
}
