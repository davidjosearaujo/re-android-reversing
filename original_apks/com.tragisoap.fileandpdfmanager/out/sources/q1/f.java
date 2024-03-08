package q1;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.activity.h;
import java.time.Duration;
import java.util.ArrayList;
import linc.com.amplituda.ErrorCode;
import q1.j;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f {

    /* renamed from: a */
    public final AccessibilityNodeInfo f5624a;

    /* renamed from: b */
    public int f5625b = -1;

    /* renamed from: c */
    public int f5626c = -1;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a {
        public static final a e = new a(16, (String) null);

        /* renamed from: f */
        public static final a f5627f = new a(4096, (String) null);

        /* renamed from: g */
        public static final a f5628g = new a(8192, (String) null);

        /* renamed from: h */
        public static final a f5629h = new a(262144, (String) null);

        /* renamed from: i */
        public static final a f5630i = new a(524288, (String) null);

        /* renamed from: j */
        public static final a f5631j = new a(1048576, (String) null);

        /* renamed from: k */
        public static final a f5632k = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, null, null, null);

        /* renamed from: l */
        public static final a f5633l = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, null, null, null);

        /* renamed from: a */
        public final Object f5634a;

        /* renamed from: b */
        public final int f5635b;

        /* renamed from: c */
        public final Class<? extends j.a> f5636c;

        /* renamed from: d */
        public final j f5637d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            new a(1, (String) null);
            new a(2, (String) null);
            new a(4, (String) null);
            new a(8, (String) null);
            new a(32, (String) null);
            new a(64, (String) null);
            new a(128, (String) null);
            new a(256, j.b.class);
            new a(512, j.b.class);
            new a(1024, j.c.class);
            new a(2048, j.c.class);
            new a(16384, (String) null);
            new a(32768, (String) null);
            new a(65536, (String) null);
            new a(131072, j.g.class);
            new a(2097152, j.h.class);
            int i7 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, null, null, j.e.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, 16908358, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, 16908359, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, 16908360, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, 16908361, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, 16908349, null, null, j.f.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, 16908354, null, null, j.d.class);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, 16908356, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, 16908357, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, 16908362, null, null, null);
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, 16908372, null, null, null);
            new a(i7 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, 16908373, null, null, null);
            new a(i7 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, 16908374, null, null, null);
            new a(i7 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, 16908375, null, null, null);
            new a(i7 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, 16908376, null, null, null);
            if (i7 >= 34) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
            }
            new a(accessibilityAction, 16908382, null, null, null);
        }

        public a(int i7, Class cls) {
            this(null, i7, null, null, cls);
        }

        public a(int i7, String str) {
            this(null, i7, str, null, null);
        }

        public a(Object obj, int i7, String str, j jVar, Class cls) {
            this.f5635b = i7;
            this.f5637d = jVar;
            this.f5634a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i7, str) : obj;
            this.f5636c = cls;
        }

        public final int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f5634a).getId();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f5634a;
            return obj2 == null ? aVar.f5634a == null : obj2.equals(aVar.f5634a);
        }

        public final int hashCode() {
            Object obj = this.f5634a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public final String toString() {
            StringBuilder d7 = h.d("AccessibilityActionCompat: ");
            String d8 = f.d(this.f5635b);
            if (d8.equals("ACTION_UNKNOWN") && ((AccessibilityNodeInfo.AccessibilityAction) this.f5634a).getLabel() != null) {
                d8 = ((AccessibilityNodeInfo.AccessibilityAction) this.f5634a).getLabel().toString();
            }
            d7.append(d8);
            return d7.toString();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public static g a(int i7, int i8, int i9, int i10, boolean z6) {
            return new g(AccessibilityNodeInfo.CollectionItemInfo.obtain(i7, i8, i9, i10, z6));
        }

        public static Object b(int i7, float f7, float f8, float f9) {
            return AccessibilityNodeInfo.RangeInfo.obtain(i7, f7, f8, f9);
        }

        public static Bundle c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {
        public static Object a(int i7, float f7, float f8, float f9) {
            return new AccessibilityNodeInfo.RangeInfo(i7, f7, f8, f9);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d {
        public static g a(boolean z6, int i7, int i8, int i9, int i10, boolean z7, String str, String str2) {
            return new g(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z6).setColumnIndex(i7).setRowIndex(i8).setColumnSpan(i9).setRowSpan(i10).setSelected(z7).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static f b(AccessibilityNodeInfo accessibilityNodeInfo, int i7, int i8) {
            return f.n(accessibilityNodeInfo.getChild(i7, i8));
        }

        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static f f(AccessibilityNodeInfo accessibilityNodeInfo, int i7) {
            return f.n(accessibilityNodeInfo.getParent(i7));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z6) {
            accessibilityNodeInfo.setTextSelectable(z6);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e {
        public static void a(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void f(AccessibilityNodeInfo accessibilityNodeInfo, boolean z6) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z6);
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, long j7) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j7));
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z6) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z6);
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, boolean z6) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z6);
        }
    }

    /* renamed from: q1.f$f */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class C0098f {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class g {

        /* renamed from: a */
        public final Object f5638a;

        public g(AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) {
            this.f5638a = collectionItemInfo;
        }

        public static g a(int i7, int i8, int i9, int i10, boolean z6) {
            return new g(AccessibilityNodeInfo.CollectionItemInfo.obtain(i7, i8, i9, i10, false, z6));
        }
    }

    public f(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f5624a = accessibilityNodeInfo;
    }

    @Deprecated
    public f(AccessibilityNodeInfo accessibilityNodeInfo, int i7) {
        this.f5624a = accessibilityNodeInfo;
    }

    public static String d(int i7) {
        if (i7 == 1) {
            return "ACTION_FOCUS";
        }
        if (i7 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i7) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case ErrorCode.STREAM_INFO_NOT_FOUND_PROC_CODE /* 32 */:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908382:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i7) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i7) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i7) {
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    case 16908373:
                                        return "ACTION_DRAG_START";
                                    case 16908374:
                                        return "ACTION_DRAG_DROP";
                                    case 16908375:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static f n(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            return new f(accessibilityNodeInfo, 0);
        }
        return null;
    }

    public final void a(int i7) {
        this.f5624a.addAction(i7);
    }

    public final void b(a aVar) {
        this.f5624a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f5634a);
    }

    public final ArrayList c(String str) {
        ArrayList<Integer> integerArrayList = b.c(this.f5624a).getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        b.c(this.f5624a).putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final boolean e(int i7) {
        Bundle c7 = b.c(this.f5624a);
        return c7 != null && (c7.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i7) == i7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5624a;
        if (accessibilityNodeInfo == null) {
            if (fVar.f5624a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(fVar.f5624a)) {
            return false;
        }
        return this.f5626c == fVar.f5626c && this.f5625b == fVar.f5625b;
    }

    @Deprecated
    public final void f(Rect rect) {
        this.f5624a.getBoundsInParent(rect);
    }

    public final CharSequence g() {
        if (!(!c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty())) {
            return this.f5624a.getText();
        }
        ArrayList c7 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        ArrayList c8 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        ArrayList c9 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        ArrayList c10 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f5624a.getText(), 0, this.f5624a.getText().length()));
        for (int i7 = 0; i7 < c7.size(); i7++) {
            spannableString.setSpan(new a(((Integer) c10.get(i7)).intValue(), this, b.c(this.f5624a).getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) c7.get(i7)).intValue(), ((Integer) c8.get(i7)).intValue(), ((Integer) c9.get(i7)).intValue());
        }
        return spannableString;
    }

    public final void h(CharSequence charSequence) {
        this.f5624a.setClassName(charSequence);
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5624a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final void i(C0098f fVar) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f5624a;
        if (fVar == null) {
            collectionInfo = null;
        } else {
            fVar.getClass();
            collectionInfo = null;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public final void j(g gVar) {
        this.f5624a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) gVar.f5638a);
    }

    public final void k(CharSequence charSequence) {
        this.f5624a.setContentDescription(charSequence);
    }

    public final void l(boolean z6) {
        this.f5624a.setDismissable(z6);
    }

    public final void m(CharSequence charSequence) {
        this.f5624a.setText(charSequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.ArrayList] */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 685
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.f.toString():java.lang.String");
    }
}
