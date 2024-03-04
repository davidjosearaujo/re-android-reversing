package p1;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import p1.y;
import q1.f;
import q1.j;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c */
    public static final View.AccessibilityDelegate f5465c = new View.AccessibilityDelegate();

    /* renamed from: a */
    public final View.AccessibilityDelegate f5466a;

    /* renamed from: b */
    public final C0092a f5467b;

    /* renamed from: p1.a$a */
    /* loaded from: classes.dex */
    public static final class C0092a extends View.AccessibilityDelegate {

        /* renamed from: a */
        public final a f5468a;

        public C0092a(a aVar) {
            this.f5468a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f5468a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            q1.g b2 = this.f5468a.b(view);
            if (b2 != null) {
                return (AccessibilityNodeProvider) b2.f5639a;
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f5468a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            q1.f fVar = new q1.f(accessibilityNodeInfo);
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            Boolean valueOf = Boolean.valueOf(y.l.d(view));
            boolean z6 = true;
            accessibilityNodeInfo.setScreenReaderFocusable(valueOf != null && valueOf.booleanValue());
            Boolean valueOf2 = Boolean.valueOf(y.l.c(view));
            accessibilityNodeInfo.setHeading((valueOf2 == null || !valueOf2.booleanValue()) ? false : false);
            accessibilityNodeInfo.setPaneTitle(y.b(view));
            f.c.c(accessibilityNodeInfo, y.n.b(view));
            this.f5468a.d(view, fVar);
            accessibilityNodeInfo.getText();
            List list = (List) view.getTag(2131296821);
            if (list == null) {
                list = Collections.emptyList();
            }
            for (int i7 = 0; i7 < list.size(); i7++) {
                fVar.b((f.a) list.get(i7));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f5468a.e(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f5468a.f(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean performAccessibilityAction(View view, int i7, Bundle bundle) {
            return this.f5468a.g(view, i7, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEvent(View view, int i7) {
            this.f5468a.h(view, i7);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f5468a.i(view, accessibilityEvent);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i7, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i7, bundle);
        }
    }

    public a() {
        this(f5465c);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f5466a = accessibilityDelegate;
        this.f5467b = new C0092a(this);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f5466a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public q1.g b(View view) {
        AccessibilityNodeProvider a7 = b.a(this.f5466a, view);
        if (a7 != null) {
            return new q1.g(a7);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f5466a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, q1.f fVar) {
        this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f5466a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f5466a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i7, Bundle bundle) {
        boolean z6;
        WeakReference weakReference;
        boolean z7;
        List list = (List) view.getTag(2131296821);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z8 = false;
        int i8 = 0;
        while (true) {
            if (i8 >= list.size()) {
                break;
            }
            f.a aVar = (f.a) list.get(i8);
            if (aVar.a() != i7) {
                i8++;
            } else if (aVar.f5637d != null) {
                Class<? extends j.a> cls = aVar.f5636c;
                if (cls != null) {
                    try {
                        cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).getClass();
                    } catch (Exception e) {
                        Class<? extends j.a> cls2 = aVar.f5636c;
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                    }
                }
                z6 = aVar.f5637d.a(view);
            }
        }
        z6 = false;
        if (!z6) {
            z6 = b.b(this.f5466a, view, i7, bundle);
        }
        if (z6 || i7 != 2131296273 || bundle == null) {
            return z6;
        }
        int i9 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(2131296822);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i9)) != null) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (clickableSpan != null) {
                CharSequence text = view.createAccessibilityNodeInfo().getText();
                ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
                for (int i10 = 0; clickableSpanArr != null && i10 < clickableSpanArr.length; i10++) {
                    if (clickableSpan.equals(clickableSpanArr[i10])) {
                        z7 = true;
                        break;
                    }
                }
            }
            z7 = false;
            if (z7) {
                clickableSpan.onClick(view);
                z8 = true;
            }
        }
        return z8;
    }

    public void h(View view, int i7) {
        this.f5466a.sendAccessibilityEvent(view, i7);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f5466a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
