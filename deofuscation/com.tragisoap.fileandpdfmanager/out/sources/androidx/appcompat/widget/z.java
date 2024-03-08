package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.b;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class z extends Spinner {
    @SuppressLint({"ResourceType"})

    /* renamed from: n */
    public static final int[] f1076n = {16843505};

    /* renamed from: g */
    public final Context f1078g;

    /* renamed from: h */
    public y f1079h;

    /* renamed from: i */
    public SpinnerAdapter f1080i;

    /* renamed from: j */
    public final boolean f1081j;

    /* renamed from: k */
    public i f1082k;

    /* renamed from: l */
    public int f1083l;
    public final Rect m = new Rect();

    /* renamed from: f */
    public final e f1077f = new e(this);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
            z.this = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (!z.this.getInternalPopup().b()) {
                z zVar = z.this;
                zVar.f1082k.m(c.b(zVar), c.a(zVar));
            }
            ViewTreeObserver viewTreeObserver = z.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                b.a(viewTreeObserver, this);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {
        public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c {
        public static int a(View view) {
            return view.getTextAlignment();
        }

        public static int b(View view) {
            return view.getTextDirection();
        }

        public static void c(View view, int i7) {
            view.setTextAlignment(i7);
        }

        public static void d(View view, int i7) {
            view.setTextDirection(i7);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class d {
        public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (!o1.b.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class e implements i, DialogInterface.OnClickListener {

        /* renamed from: f */
        public androidx.appcompat.app.b f1085f;

        /* renamed from: g */
        public ListAdapter f1086g;

        /* renamed from: h */
        public CharSequence f1087h;

        public e() {
            z.this = r1;
        }

        @Override // androidx.appcompat.widget.z.i
        public final boolean b() {
            androidx.appcompat.app.b bVar = this.f1085f;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.z.i
        public final int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.z.i
        public final void dismiss() {
            androidx.appcompat.app.b bVar = this.f1085f;
            if (bVar != null) {
                bVar.dismiss();
                this.f1085f = null;
            }
        }

        @Override // androidx.appcompat.widget.z.i
        public final Drawable f() {
            return null;
        }

        @Override // androidx.appcompat.widget.z.i
        public final void h(CharSequence charSequence) {
            this.f1087h = charSequence;
        }

        @Override // androidx.appcompat.widget.z.i
        public final void i(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.z.i
        public final void j(int i7) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.z.i
        public final void k(int i7) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.z.i
        public final void l(int i7) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.z.i
        public final void m(int i7, int i8) {
            if (this.f1086g != null) {
                b.a aVar = new b.a(z.this.getPopupContext());
                CharSequence charSequence = this.f1087h;
                if (charSequence != null) {
                    aVar.f500a.f490d = charSequence;
                }
                ListAdapter listAdapter = this.f1086g;
                int selectedItemPosition = z.this.getSelectedItemPosition();
                AlertController.b bVar = aVar.f500a;
                bVar.f492g = listAdapter;
                bVar.f493h = this;
                bVar.f495j = selectedItemPosition;
                bVar.f494i = true;
                androidx.appcompat.app.b a7 = aVar.a();
                this.f1085f = a7;
                AlertController.RecycleListView recycleListView = a7.f499k.e;
                c.d(recycleListView, i7);
                c.c(recycleListView, i8);
                this.f1085f.show();
            }
        }

        @Override // androidx.appcompat.widget.z.i
        public final int n() {
            return 0;
        }

        @Override // androidx.appcompat.widget.z.i
        public final CharSequence o() {
            return this.f1087h;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i7) {
            z.this.setSelection(i7);
            if (z.this.getOnItemClickListener() != null) {
                z.this.performItemClick(null, i7, this.f1086g.getItemId(i7));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.z.i
        public final void p(ListAdapter listAdapter) {
            this.f1086g = listAdapter;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class f implements ListAdapter, SpinnerAdapter {

        /* renamed from: f */
        public SpinnerAdapter f1089f;

        /* renamed from: g */
        public ListAdapter f1090g;

        public f(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1089f = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1090g = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                d.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            } else if (spinnerAdapter instanceof w0) {
                w0 w0Var = (w0) spinnerAdapter;
                if (w0Var.getDropDownViewTheme() == null) {
                    w0Var.a();
                }
            }
        }

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1090g;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1089f;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i7, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1089f;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i7, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i7) {
            SpinnerAdapter spinnerAdapter = this.f1089f;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i7);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i7) {
            SpinnerAdapter spinnerAdapter = this.f1089f;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i7);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int i7) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int i7, View view, ViewGroup viewGroup) {
            return getDropDownView(i7, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1089f;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i7) {
            ListAdapter listAdapter = this.f1090g;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i7);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1089f;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1089f;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class g extends n0 implements i {
        public CharSequence F;
        public ListAdapter G;
        public final Rect H = new Rect();
        public int I;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements AdapterView.OnItemClickListener {
            public a() {
                g.this = r1;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
                z.this.setSelection(i7);
                if (z.this.getOnItemClickListener() != null) {
                    g gVar = g.this;
                    z.this.performItemClick(view, i7, gVar.G.getItemId(i7));
                }
                g.this.dismiss();
            }
        }

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
                g.this = r1;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                g gVar = g.this;
                z zVar = z.this;
                gVar.getClass();
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (!(y.g.b(zVar) && zVar.getGlobalVisibleRect(gVar.H))) {
                    g.this.dismiss();
                    return;
                }
                g.this.s();
                g.this.d();
            }
        }

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: f */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1093f;

            public c(b bVar) {
                g.this = r1;
                this.f1093f = bVar;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ViewTreeObserver viewTreeObserver = z.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1093f);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context, AttributeSet attributeSet, int i7) {
            super(context, attributeSet, i7, 0);
            z.this = r2;
            this.f996t = r2;
            this.D = true;
            this.E.setFocusable(true);
            this.f997u = new a();
        }

        @Override // androidx.appcompat.widget.z.i
        public final void h(CharSequence charSequence) {
            this.F = charSequence;
        }

        @Override // androidx.appcompat.widget.z.i
        public final void k(int i7) {
            this.I = i7;
        }

        @Override // androidx.appcompat.widget.z.i
        public final void m(int i7, int i8) {
            ViewTreeObserver viewTreeObserver;
            boolean b2 = b();
            s();
            this.E.setInputMethodMode(2);
            d();
            i0 i0Var = this.f986h;
            i0Var.setChoiceMode(1);
            c.d(i0Var, i7);
            c.c(i0Var, i8);
            int selectedItemPosition = z.this.getSelectedItemPosition();
            i0 i0Var2 = this.f986h;
            if (b() && i0Var2 != null) {
                i0Var2.setListSelectionHidden(false);
                i0Var2.setSelection(selectedItemPosition);
                if (i0Var2.getChoiceMode() != 0) {
                    i0Var2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!b2 && (viewTreeObserver = z.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                this.E.setOnDismissListener(new c(bVar));
            }
        }

        @Override // androidx.appcompat.widget.z.i
        public final CharSequence o() {
            return this.F;
        }

        @Override // androidx.appcompat.widget.n0, androidx.appcompat.widget.z.i
        public final void p(ListAdapter listAdapter) {
            super.p(listAdapter);
            this.G = listAdapter;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void s() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.f()
                r1 = 0
                if (r0 == 0) goto L_0x0026
                androidx.appcompat.widget.z r1 = androidx.appcompat.widget.z.this
                android.graphics.Rect r1 = r1.m
                r0.getPadding(r1)
                androidx.appcompat.widget.z r0 = androidx.appcompat.widget.z.this
                boolean r0 = androidx.appcompat.widget.g1.a(r0)
                if (r0 == 0) goto L_0x001d
                androidx.appcompat.widget.z r0 = androidx.appcompat.widget.z.this
                android.graphics.Rect r0 = r0.m
                int r0 = r0.right
                goto L_0x0024
            L_0x001d:
                androidx.appcompat.widget.z r0 = androidx.appcompat.widget.z.this
                android.graphics.Rect r0 = r0.m
                int r0 = r0.left
                int r0 = -r0
            L_0x0024:
                r1 = r0
                goto L_0x002e
            L_0x0026:
                androidx.appcompat.widget.z r0 = androidx.appcompat.widget.z.this
                android.graphics.Rect r0 = r0.m
                r0.right = r1
                r0.left = r1
            L_0x002e:
                androidx.appcompat.widget.z r0 = androidx.appcompat.widget.z.this
                int r0 = r0.getPaddingLeft()
                androidx.appcompat.widget.z r2 = androidx.appcompat.widget.z.this
                int r2 = r2.getPaddingRight()
                androidx.appcompat.widget.z r3 = androidx.appcompat.widget.z.this
                int r3 = r3.getWidth()
                androidx.appcompat.widget.z r4 = androidx.appcompat.widget.z.this
                int r5 = r4.f1083l
                r6 = -2
                if (r5 != r6) goto L_0x0078
                android.widget.ListAdapter r5 = r8.G
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.f()
                int r4 = r4.a(r5, r6)
                androidx.appcompat.widget.z r5 = androidx.appcompat.widget.z.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                androidx.appcompat.widget.z r6 = androidx.appcompat.widget.z.this
                android.graphics.Rect r6 = r6.m
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L_0x0070
                r4 = r5
            L_0x0070:
                int r5 = r3 - r0
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
                goto L_0x007e
            L_0x0078:
                r4 = -1
                if (r5 != r4) goto L_0x0082
                int r4 = r3 - r0
                int r4 = r4 - r2
            L_0x007e:
                r8.r(r4)
                goto L_0x0085
            L_0x0082:
                r8.r(r5)
            L_0x0085:
                androidx.appcompat.widget.z r4 = androidx.appcompat.widget.z.this
                boolean r4 = androidx.appcompat.widget.g1.a(r4)
                if (r4 == 0) goto L_0x0096
                int r3 = r3 - r2
                int r0 = r8.f988j
                int r3 = r3 - r0
                int r0 = r8.I
                int r3 = r3 - r0
                int r3 = r3 + r1
                goto L_0x009b
            L_0x0096:
                int r2 = r8.I
                int r0 = r0 + r2
                int r3 = r0 + r1
            L_0x009b:
                r8.f989k = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.z.g.s():void");
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class h extends View.BaseSavedState {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: f */
        public boolean f1095f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Parcelable.Creator<h> {
            @Override // android.os.Parcelable.Creator
            public final h createFromParcel(Parcel parcel) {
                return new h(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final h[] newArray(int i7) {
                return new h[i7];
            }
        }

        public h(Parcel parcel) {
            super(parcel);
            this.f1095f = parcel.readByte() != 0;
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public final void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeByte(this.f1095f ? (byte) 1 : 0);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface i {
        boolean b();

        int c();

        void dismiss();

        Drawable f();

        void h(CharSequence charSequence);

        void i(Drawable drawable);

        void j(int i7);

        void k(int i7);

        void l(int i7);

        void m(int i7, int i8);

        int n();

        CharSequence o();

        void p(ListAdapter listAdapter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (r4 == null) goto L_0x005b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            r10.<init>(r11, r12, r13)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.m = r0
            android.content.Context r0 = r10.getContext()
            androidx.appcompat.widget.v0.a(r10, r0)
            int[] r0 = a0.e.R
            r1 = 0
            android.content.res.TypedArray r0 = r11.obtainStyledAttributes(r12, r0, r13, r1)
            androidx.appcompat.widget.e r2 = new androidx.appcompat.widget.e
            r2.<init>(r10)
            r10.f1077f = r2
            r2 = 4
            int r2 = r0.getResourceId(r2, r1)
            if (r2 == 0) goto L_0x002e
            i.c r3 = new i.c
            r3.<init>(r11, r2)
            r10.f1078g = r3
            goto L_0x0030
        L_0x002e:
            r10.f1078g = r11
        L_0x0030:
            r2 = 0
            r3 = -1
            int[] r4 = androidx.appcompat.widget.z.f1076n     // Catch: Exception -> 0x004c, all -> 0x0049
            android.content.res.TypedArray r4 = r11.obtainStyledAttributes(r12, r4, r13, r1)     // Catch: Exception -> 0x004c, all -> 0x0049
            boolean r5 = r4.hasValue(r1)     // Catch: Exception -> 0x0047, all -> 0x0043
            if (r5 == 0) goto L_0x0058
            int r3 = r4.getInt(r1, r1)     // Catch: Exception -> 0x0047, all -> 0x0043
            goto L_0x0058
        L_0x0043:
            r10 = move-exception
            r2 = r4
            goto L_0x00cd
        L_0x0047:
            r5 = move-exception
            goto L_0x004f
        L_0x0049:
            r10 = move-exception
            goto L_0x00cd
        L_0x004c:
            r4 = move-exception
            r5 = r4
            r4 = r2
        L_0x004f:
            java.lang.String r6 = "AppCompatSpinner"
            java.lang.String r7 = "Could not read android:spinnerMode"
            android.util.Log.i(r6, r7, r5)     // Catch: all -> 0x0043
            if (r4 == 0) goto L_0x005b
        L_0x0058:
            r4.recycle()
        L_0x005b:
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L_0x0095
            if (r3 == r5) goto L_0x0062
            goto L_0x00a2
        L_0x0062:
            androidx.appcompat.widget.z$g r3 = new androidx.appcompat.widget.z$g
            android.content.Context r6 = r10.f1078g
            r3.<init>(r6, r12, r13)
            android.content.Context r6 = r10.f1078g
            int[] r7 = a0.e.R
            androidx.appcompat.widget.a1 r6 = androidx.appcompat.widget.a1.m(r6, r12, r7, r13)
            r7 = 3
            r8 = -2
            android.content.res.TypedArray r9 = r6.f831b
            int r7 = r9.getLayoutDimension(r7, r8)
            r10.f1083l = r7
            android.graphics.drawable.Drawable r7 = r6.e(r5)
            r3.i(r7)
            java.lang.String r4 = r0.getString(r4)
            r3.F = r4
            r6.n()
            r10.f1082k = r3
            androidx.appcompat.widget.y r4 = new androidx.appcompat.widget.y
            r4.<init>(r10, r10, r3)
            r10.f1079h = r4
            goto L_0x00a2
        L_0x0095:
            androidx.appcompat.widget.z$e r3 = new androidx.appcompat.widget.z$e
            r3.<init>()
            r10.f1082k = r3
            java.lang.String r4 = r0.getString(r4)
            r3.f1087h = r4
        L_0x00a2:
            java.lang.CharSequence[] r1 = r0.getTextArray(r1)
            if (r1 == 0) goto L_0x00b9
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r11, r4, r1)
            r11 = 2131492990(0x7f0c007e, float:1.8609447E38)
            r3.setDropDownViewResource(r11)
            r10.setAdapter(r3)
        L_0x00b9:
            r0.recycle()
            r10.f1081j = r5
            android.widget.SpinnerAdapter r11 = r10.f1080i
            if (r11 == 0) goto L_0x00c7
            r10.setAdapter(r11)
            r10.f1080i = r2
        L_0x00c7:
            androidx.appcompat.widget.e r10 = r10.f1077f
            r10.d(r12, r13)
            return
        L_0x00cd:
            if (r2 == 0) goto L_0x00d2
            r2.recycle()
        L_0x00d2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.z.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i7 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i8 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i8 = Math.max(i8, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i8;
        }
        drawable.getPadding(this.m);
        Rect rect = this.m;
        return i8 + rect.left + rect.right;
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1077f;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        i iVar = this.f1082k;
        return iVar != null ? iVar.c() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        i iVar = this.f1082k;
        return iVar != null ? iVar.n() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f1082k != null ? this.f1083l : super.getDropDownWidth();
    }

    public final i getInternalPopup() {
        return this.f1082k;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        i iVar = this.f1082k;
        return iVar != null ? iVar.f() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1078g;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        i iVar = this.f1082k;
        return iVar != null ? iVar.o() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1077f;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1077f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.view.View, android.widget.AdapterView, android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.f1082k;
        if (iVar != null && iVar.b()) {
            this.f1082k.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (this.f1082k != null && View.MeasureSpec.getMode(i7) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i7)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        if (hVar.f1095f && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new a());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        i iVar = this.f1082k;
        hVar.f1095f = iVar != null && iVar.b();
        return hVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        y yVar = this.f1079h;
        if (yVar == null || !yVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        i iVar = this.f1082k;
        if (iVar == null) {
            return super.performClick();
        }
        if (iVar.b()) {
            return true;
        }
        this.f1082k.m(c.b(this), c.a(this));
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1081j) {
            this.f1080i = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1082k != null) {
            Context context = this.f1078g;
            if (context == null) {
                context = getContext();
            }
            this.f1082k.p(new f(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1077f;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        e eVar = this.f1077f;
        if (eVar != null) {
            eVar.f(i7);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i7) {
        i iVar = this.f1082k;
        if (iVar != null) {
            iVar.k(i7);
            this.f1082k.l(i7);
            return;
        }
        super.setDropDownHorizontalOffset(i7);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i7) {
        i iVar = this.f1082k;
        if (iVar != null) {
            iVar.j(i7);
        } else {
            super.setDropDownVerticalOffset(i7);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i7) {
        if (this.f1082k != null) {
            this.f1083l = i7;
        } else {
            super.setDropDownWidth(i7);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        i iVar = this.f1082k;
        if (iVar != null) {
            iVar.i(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i7) {
        setPopupBackgroundDrawable(g.a.a(getPopupContext(), i7));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        i iVar = this.f1082k;
        if (iVar != null) {
            iVar.h(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1077f;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1077f;
        if (eVar != null) {
            eVar.i(mode);
        }
    }
}
