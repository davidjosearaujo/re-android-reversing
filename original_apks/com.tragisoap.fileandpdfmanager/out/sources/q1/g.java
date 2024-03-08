package q1;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f5639a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        public final g f5640a;

        public a(g gVar) {
            this.f5640a = gVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i7) {
            f a7 = this.f5640a.a(i7);
            if (a7 == null) {
                return null;
            }
            return a7.f5624a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i7) {
            this.f5640a.getClass();
            return null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final boolean performAction(int i7, int i8, Bundle bundle) {
            return this.f5640a.c(i7, i8, bundle);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends a {
        public b(g gVar) {
            super(gVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo findFocus(int i7) {
            f b2 = this.f5640a.b(i7);
            if (b2 == null) {
                return null;
            }
            return b2.f5624a;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends b {
        public c(g gVar) {
            super(gVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final void addExtraDataToAccessibilityNodeInfo(int i7, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f5640a.getClass();
        }
    }

    public g() {
        this.f5639a = new c(this);
    }

    public g(AccessibilityNodeProvider accessibilityNodeProvider) {
        this.f5639a = accessibilityNodeProvider;
    }

    public f a(int i7) {
        return null;
    }

    public f b(int i7) {
        return null;
    }

    public boolean c(int i7, int i8, Bundle bundle) {
        return false;
    }
}
