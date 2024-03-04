package x1;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
import q1.f;
import q1.g;
import q1.i;
import x1.b;

/* loaded from: classes.dex */
public abstract class a extends p1.a {

    /* renamed from: n */
    public static final Rect f6426n = new Rect(SubsamplingScaleImageView.TILE_SIZE_AUTO, SubsamplingScaleImageView.TILE_SIZE_AUTO, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o */
    public static final C0132a f6427o = new C0132a();

    /* renamed from: p */
    public static final b f6428p = new b();

    /* renamed from: h */
    public final AccessibilityManager f6432h;

    /* renamed from: i */
    public final View f6433i;

    /* renamed from: j */
    public c f6434j;

    /* renamed from: d */
    public final Rect f6429d = new Rect();
    public final Rect e = new Rect();

    /* renamed from: f */
    public final Rect f6430f = new Rect();

    /* renamed from: g */
    public final int[] f6431g = new int[2];

    /* renamed from: k */
    public int f6435k = Integer.MIN_VALUE;

    /* renamed from: l */
    public int f6436l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    /* renamed from: x1.a$a */
    /* loaded from: classes.dex */
    public class C0132a implements b.a<f> {
    }

    /* loaded from: classes.dex */
    public class b {
    }

    /* loaded from: classes.dex */
    public class c extends g {
        public c() {
            a.this = r1;
        }

        @Override // q1.g
        public final f a(int i7) {
            return new f(AccessibilityNodeInfo.obtain(a.this.n(i7).f5624a));
        }

        @Override // q1.g
        public final f b(int i7) {
            int i8 = i7 == 2 ? a.this.f6435k : a.this.f6436l;
            if (i8 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i8);
        }

        @Override // q1.g
        public final boolean c(int i7, int i8, Bundle bundle) {
            int i9;
            a aVar = a.this;
            if (i7 == -1) {
                View view = aVar.f6433i;
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                return y.d.j(view, i8, bundle);
            }
            boolean z6 = true;
            if (i8 != 1) {
                if (i8 != 2) {
                    boolean z7 = false;
                    if (i8 == 64) {
                        if (aVar.f6432h.isEnabled() && aVar.f6432h.isTouchExplorationEnabled() && (i9 = aVar.f6435k) != i7) {
                            if (i9 != Integer.MIN_VALUE) {
                                aVar.f6435k = Integer.MIN_VALUE;
                                aVar.f6433i.invalidate();
                                aVar.q(i9, 65536);
                            }
                            aVar.f6435k = i7;
                            aVar.f6433i.invalidate();
                            aVar.q(i7, 32768);
                        }
                        z6 = false;
                    } else if (i8 != 128) {
                        Chip.b bVar = (Chip.b) aVar;
                        bVar.getClass();
                        if (i8 == 16) {
                            if (i7 == 0) {
                                return Chip.this.performClick();
                            }
                            if (i7 == 1) {
                                Chip chip = Chip.this;
                                chip.playSoundEffect(0);
                                View.OnClickListener onClickListener = chip.m;
                                if (onClickListener != null) {
                                    onClickListener.onClick(chip);
                                    z7 = true;
                                }
                                if (chip.f3003x) {
                                    chip.f3002w.q(1, 1);
                                }
                            }
                        }
                        return z7;
                    } else {
                        if (aVar.f6435k == i7) {
                            aVar.f6435k = Integer.MIN_VALUE;
                            aVar.f6433i.invalidate();
                            aVar.q(i7, 65536);
                        }
                        z6 = false;
                    }
                    return z6;
                }
                return aVar.j(i7);
            }
            return aVar.p(i7);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f6433i = view;
        this.f6432h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (y.d.c(view) == 0) {
            y.d.s(view, 1);
        }
    }

    @Override // p1.a
    public final g b(View view) {
        if (this.f6434j == null) {
            this.f6434j = new c();
        }
        return this.f6434j;
    }

    @Override // p1.a
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
    }

    @Override // p1.a
    public final void d(View view, f fVar) {
        this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
        Chip.b bVar = (Chip.b) this;
        com.google.android.material.chip.a aVar = Chip.this.f2991j;
        fVar.f5624a.setCheckable(aVar != null && aVar.X);
        fVar.f5624a.setClickable(Chip.this.isClickable());
        fVar.h(Chip.this.getAccessibilityClassName());
        fVar.m(Chip.this.getText());
    }

    public final boolean j(int i7) {
        if (this.f6436l != i7) {
            return false;
        }
        this.f6436l = Integer.MIN_VALUE;
        Chip.b bVar = (Chip.b) this;
        if (i7 == 1) {
            Chip chip = Chip.this;
            chip.f2998r = false;
            chip.refreshDrawableState();
        }
        q(i7, 8);
        return true;
    }

    public final f k(int i7) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        f fVar = new f(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        fVar.h("android.view.View");
        Rect rect = f6426n;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        View view = this.f6433i;
        fVar.f5625b = -1;
        obtain.setParent(view);
        o(i7, fVar);
        if (fVar.g() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        fVar.f(this.e);
        if (this.e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) == 0) {
            if ((actions & 128) == 0) {
                obtain.setPackageName(this.f6433i.getContext().getPackageName());
                View view2 = this.f6433i;
                fVar.f5626c = i7;
                obtain.setSource(view2, i7);
                boolean z6 = false;
                if (this.f6435k == i7) {
                    obtain.setAccessibilityFocused(true);
                    fVar.a(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    fVar.a(64);
                }
                boolean z7 = this.f6436l == i7;
                if (z7) {
                    fVar.a(2);
                } else if (obtain.isFocusable()) {
                    fVar.a(1);
                }
                obtain.setFocused(z7);
                this.f6433i.getLocationOnScreen(this.f6431g);
                obtain.getBoundsInScreen(this.f6429d);
                if (this.f6429d.equals(rect)) {
                    fVar.f(this.f6429d);
                    if (fVar.f5625b != -1) {
                        f fVar2 = new f(AccessibilityNodeInfo.obtain());
                        for (int i8 = fVar.f5625b; i8 != -1; i8 = fVar2.f5625b) {
                            View view3 = this.f6433i;
                            fVar2.f5625b = -1;
                            fVar2.f5624a.setParent(view3, -1);
                            fVar2.f5624a.setBoundsInParent(f6426n);
                            o(i8, fVar2);
                            fVar2.f(this.e);
                            Rect rect2 = this.f6429d;
                            Rect rect3 = this.e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                    }
                    this.f6429d.offset(this.f6431g[0] - this.f6433i.getScrollX(), this.f6431g[1] - this.f6433i.getScrollY());
                }
                if (this.f6433i.getLocalVisibleRect(this.f6430f)) {
                    this.f6430f.offset(this.f6431g[0] - this.f6433i.getScrollX(), this.f6431g[1] - this.f6433i.getScrollY());
                    if (this.f6429d.intersect(this.f6430f)) {
                        fVar.f5624a.setBoundsInScreen(this.f6429d);
                        Rect rect4 = this.f6429d;
                        if (rect4 != null && !rect4.isEmpty() && this.f6433i.getWindowVisibility() == 0) {
                            View view4 = this.f6433i;
                            while (true) {
                                ViewParent parent = view4.getParent();
                                if (parent instanceof View) {
                                    view4 = (View) parent;
                                    if (view4.getAlpha() <= 0.0f) {
                                        break;
                                    } else if (view4.getVisibility() != 0) {
                                        break;
                                    }
                                } else if (parent != null) {
                                    z6 = true;
                                }
                            }
                        }
                        if (z6) {
                            fVar.f5624a.setVisibleToUser(true);
                        }
                    }
                }
                return fVar;
            }
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }

    public abstract void l(ArrayList arrayList);

    /* JADX WARN: Code restructure failed: missing block: B:312:0x0137, code lost:
        if (r13 < ((r17 * r17) + ((r12 * 13) * r12))) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:296:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0143 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m(int r20, android.graphics.Rect r21) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.a.m(int, android.graphics.Rect):boolean");
    }

    public final f n(int i7) {
        if (i7 == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.f6433i);
            f fVar = new f(obtain);
            View view = this.f6433i;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            view.onInitializeAccessibilityNodeInfo(obtain);
            ArrayList arrayList = new ArrayList();
            l(arrayList);
            if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
                int size = arrayList.size();
                for (int i8 = 0; i8 < size; i8++) {
                    fVar.f5624a.addChild(this.f6433i, ((Integer) arrayList.get(i8)).intValue());
                }
                return fVar;
            }
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        return k(i7);
    }

    public abstract void o(int i7, f fVar);

    public final boolean p(int i7) {
        int i8;
        if ((this.f6433i.isFocused() || this.f6433i.requestFocus()) && (i8 = this.f6436l) != i7) {
            if (i8 != Integer.MIN_VALUE) {
                j(i8);
            }
            if (i7 == Integer.MIN_VALUE) {
                return false;
            }
            this.f6436l = i7;
            Chip.b bVar = (Chip.b) this;
            if (i7 == 1) {
                Chip chip = Chip.this;
                chip.f2998r = true;
                chip.refreshDrawableState();
            }
            q(i7, 8);
            return true;
        }
        return false;
    }

    public final void q(int i7, int i8) {
        ViewParent parent;
        AccessibilityEvent obtain;
        if (i7 == Integer.MIN_VALUE || !this.f6432h.isEnabled() || (parent = this.f6433i.getParent()) == null) {
            return;
        }
        if (i7 != -1) {
            obtain = AccessibilityEvent.obtain(i8);
            f n6 = n(i7);
            obtain.getText().add(n6.g());
            obtain.setContentDescription(n6.f5624a.getContentDescription());
            obtain.setScrollable(n6.f5624a.isScrollable());
            obtain.setPassword(n6.f5624a.isPassword());
            obtain.setEnabled(n6.f5624a.isEnabled());
            obtain.setChecked(n6.f5624a.isChecked());
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(n6.f5624a.getClassName());
            i.a(obtain, this.f6433i, i7);
            obtain.setPackageName(this.f6433i.getContext().getPackageName());
        } else {
            obtain = AccessibilityEvent.obtain(i8);
            this.f6433i.onInitializeAccessibilityEvent(obtain);
        }
        parent.requestSendAccessibilityEvent(this.f6433i, obtain);
    }
}
