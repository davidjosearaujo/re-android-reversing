package q1;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import c0.m;
import com.google.android.material.internal.CheckableImageButton;
import java.util.WeakHashMap;
import o4.l;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class e implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a */
    public final d f5623a;

    public e(d dVar) {
        this.f5623a = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f5623a.equals(((e) obj).f5623a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5623a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z6) {
        l lVar = (l) ((m) this.f5623a).f2487a;
        AutoCompleteTextView autoCompleteTextView = lVar.f5354h;
        if (autoCompleteTextView != null) {
            if (autoCompleteTextView.getInputType() != 0) {
                return;
            }
            CheckableImageButton checkableImageButton = lVar.f5367d;
            int i7 = z6 ? 2 : 1;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.s(checkableImageButton, i7);
        }
    }
}
