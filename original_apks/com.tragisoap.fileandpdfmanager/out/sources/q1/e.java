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
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final d f5623a;

    public e(d dVar) {
        this.f5623a = dVar;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return this.f5623a.equals(((e) obj).f5623a);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.f5623a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z6) {
        l lVar = (l) ((m) this.f5623a).f2487a;
        AutoCompleteTextView autoCompleteTextView = lVar.f5354h;
        if (autoCompleteTextView != null) {
            int i7 = 1;
            if (!(autoCompleteTextView.getInputType() != 0)) {
                CheckableImageButton checkableImageButton = lVar.f5367d;
                if (z6) {
                    i7 = 2;
                }
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.d.s(checkableImageButton, i7);
            }
        }
    }
}
