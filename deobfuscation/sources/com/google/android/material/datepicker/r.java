package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p1.k0;
import p1.n0;
import p1.q0;
import p1.y;

/* loaded from: classes.dex */
public final class r<S> extends androidx.fragment.app.m {
    public int A0;
    public CharSequence B0;
    public int C0;
    public CharSequence D0;
    public int E0;
    public CharSequence F0;
    public int G0;
    public CharSequence H0;
    public TextView I0;
    public TextView J0;
    public CheckableImageButton K0;
    public k4.f L0;
    public Button M0;
    public boolean N0;
    public CharSequence O0;
    public CharSequence P0;

    /* renamed from: m0 */
    public final LinkedHashSet<t<? super S>> f3101m0 = new LinkedHashSet<>();

    /* renamed from: n0 */
    public final LinkedHashSet<View.OnClickListener> f3102n0 = new LinkedHashSet<>();

    /* renamed from: o0 */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f3103o0 = new LinkedHashSet<>();

    /* renamed from: p0 */
    public final LinkedHashSet<DialogInterface.OnDismissListener> f3104p0 = new LinkedHashSet<>();

    /* renamed from: q0 */
    public int f3105q0;

    /* renamed from: r0 */
    public d<S> f3106r0;

    /* renamed from: s0 */
    public a0<S> f3107s0;

    /* renamed from: t0 */
    public com.google.android.material.datepicker.a f3108t0;

    /* renamed from: u0 */
    public f f3109u0;

    /* renamed from: v0 */
    public i<S> f3110v0;

    /* renamed from: w0 */
    public int f3111w0;

    /* renamed from: x0 */
    public CharSequence f3112x0;

    /* renamed from: y0 */
    public boolean f3113y0;

    /* renamed from: z0 */
    public int f3114z0;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
            r.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Iterator<t<? super S>> it = r.this.f3101m0.iterator();
            while (it.hasNext()) {
                r.this.U().l();
                it.next().a();
            }
            r.this.P(false, false);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
            r.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Iterator<View.OnClickListener> it = r.this.f3102n0.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            r.this.P(false, false);
        }
    }

    /* loaded from: classes.dex */
    public class c extends z<S> {
        public c() {
            r.this = r1;
        }

        @Override // com.google.android.material.datepicker.z
        public final void a(S s) {
            r rVar = r.this;
            d<S> U = rVar.U();
            rVar.j();
            String c7 = U.c();
            TextView textView = rVar.J0;
            d<S> U2 = rVar.U();
            rVar.L();
            textView.setContentDescription(U2.i());
            rVar.J0.setText(c7);
            r rVar2 = r.this;
            rVar2.M0.setEnabled(rVar2.U().h());
        }
    }

    public static int V(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(2131100273);
        Calendar d7 = e0.d();
        d7.set(5, 1);
        Calendar c7 = e0.c(d7);
        c7.get(2);
        c7.get(1);
        int maximum = c7.getMaximum(7);
        c7.getActualMaximum(5);
        c7.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131100279) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(2131100293)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean W(Context context) {
        return X(context, 16843277);
    }

    public static boolean X(Context context, int i7) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(g4.b.c(2130903810, context, i.class.getCanonicalName()).data, new int[]{i7});
        boolean z6 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z6;
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.n
    public final void A(Bundle bundle) {
        super.A(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f3105q0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f3106r0);
        a.b bVar = new a.b(this.f3108t0);
        i<S> iVar = this.f3110v0;
        v vVar = iVar == null ? null : iVar.f3077b0;
        if (vVar != null) {
            bVar.f3047c = Long.valueOf(vVar.f3127k);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", bVar.e);
        v f7 = v.f(bVar.f3045a);
        v f8 = v.f(bVar.f3046b);
        a.c cVar = (a.c) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l6 = bVar.f3047c;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new com.google.android.material.datepicker.a(f7, f8, cVar, l6 != null ? v.f(l6.longValue()) : null, bVar.f3048d));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f3109u0);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f3111w0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f3112x0);
        bundle.putInt("INPUT_MODE_KEY", this.f3114z0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.A0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.B0);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.C0);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.D0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.E0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.F0);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.G0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.H0);
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.n
    public final void B() {
        super.B();
        Window window = R().getWindow();
        if (this.f3113y0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.L0);
            if (!this.N0) {
                View findViewById = M().findViewById(2131296491);
                ColorStateList a7 = z3.a.a(findViewById.getBackground());
                Integer valueOf = a7 != null ? Integer.valueOf(a7.getDefaultColor()) : null;
                boolean z6 = valueOf == null || valueOf.intValue() == 0;
                int u6 = q2.a.u(window.getContext(), 16842801, -16777216);
                if (z6) {
                    valueOf = Integer.valueOf(u6);
                }
                Integer valueOf2 = Integer.valueOf(u6);
                n0.a(window, false);
                window.getContext();
                window.getContext();
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                d4.e.a(window, q2.a.C(0) || q2.a.C(valueOf.intValue()));
                boolean z7 = q2.a.C(0) || q2.a.C(valueOf2.intValue());
                q0.a aVar = new q0.a(window.getInsetsController(), new p1.u(window.getDecorView()));
                aVar.f5531c = window;
                if (z7) {
                    Window window2 = aVar.f5531c;
                    if (window2 != null) {
                        View decorView = window2.getDecorView();
                        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
                    }
                    aVar.f5529a.setSystemBarsAppearance(16, 16);
                } else {
                    Window window3 = aVar.f5531c;
                    if (window3 != null) {
                        View decorView2 = window3.getDecorView();
                        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
                    }
                    aVar.f5529a.setSystemBarsAppearance(0, 16);
                }
                s sVar = new s(findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingTop());
                WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
                y.i.u(findViewById, sVar);
                this.N0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = L().getResources().getDimensionPixelOffset(2131100281);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.L0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new y3.a(R(), rect));
        }
        Y();
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.n
    public final void C() {
        this.f3107s0.W.clear();
        super.C();
    }

    @Override // androidx.fragment.app.m
    public final Dialog Q() {
        Context L = L();
        L();
        int i7 = this.f3105q0;
        if (i7 == 0) {
            i7 = U().d();
        }
        Dialog dialog = new Dialog(L, i7);
        Context context = dialog.getContext();
        this.f3113y0 = W(context);
        this.L0 = new k4.f(context, null, 2130903810, 2131887133);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, l0.z.m, 2130903810, 2131887133);
        int color = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        this.L0.i(context);
        this.L0.k(ColorStateList.valueOf(color));
        k4.f fVar = this.L0;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
        fVar.j(y.i.i(decorView));
        return dialog;
    }

    public final d<S> U() {
        if (this.f3106r0 == null) {
            this.f3106r0 = (d) this.f1705k.getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f3106r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00d5  */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.android.material.datepicker.u, androidx.fragment.app.n] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Y() {
        /*
            r8 = this;
            r8.L()
            int r0 = r8.f3105q0
            if (r0 == 0) goto L8
            goto L10
        L8:
            com.google.android.material.datepicker.d r0 = r8.U()
            int r0 = r0.d()
        L10:
            com.google.android.material.datepicker.d r1 = r8.U()
            com.google.android.material.datepicker.a r2 = r8.f3108t0
            com.google.android.material.datepicker.f r3 = r8.f3109u0
            com.google.android.material.datepicker.i r4 = new com.google.android.material.datepicker.i
            r4.<init>()
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r6 = "THEME_RES_ID_KEY"
            r5.putInt(r6, r0)
            java.lang.String r7 = "GRID_SELECTOR_KEY"
            r5.putParcelable(r7, r1)
            java.lang.String r1 = "CALENDAR_CONSTRAINTS_KEY"
            r5.putParcelable(r1, r2)
            java.lang.String r7 = "DAY_VIEW_DECORATOR_KEY"
            r5.putParcelable(r7, r3)
            com.google.android.material.datepicker.v r2 = r2.f3039i
            java.lang.String r3 = "CURRENT_MONTH_KEY"
            r5.putParcelable(r3, r2)
            r4.O(r5)
            r8.f3110v0 = r4
            int r2 = r8.f3114z0
            r3 = 1
            if (r2 != r3) goto L66
            com.google.android.material.datepicker.d r2 = r8.U()
            com.google.android.material.datepicker.a r4 = r8.f3108t0
            com.google.android.material.datepicker.u r5 = new com.google.android.material.datepicker.u
            r5.<init>()
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            r7.putInt(r6, r0)
            java.lang.String r0 = "DATE_SELECTOR_KEY"
            r7.putParcelable(r0, r2)
            r7.putParcelable(r1, r4)
            r5.O(r7)
            r4 = r5
        L66:
            r8.f3107s0 = r4
            android.widget.TextView r0 = r8.I0
            int r1 = r8.f3114z0
            r2 = 0
            r4 = 2
            if (r1 != r3) goto L87
            android.content.Context r1 = r8.L()
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            if (r1 != r4) goto L81
            goto L82
        L81:
            r3 = r2
        L82:
            if (r3 == 0) goto L87
            java.lang.CharSequence r1 = r8.P0
            goto L89
        L87:
            java.lang.CharSequence r1 = r8.O0
        L89:
            r0.setText(r1)
            com.google.android.material.datepicker.d r0 = r8.U()
            r8.j()
            java.lang.String r0 = r0.c()
            android.widget.TextView r1 = r8.J0
            com.google.android.material.datepicker.d r3 = r8.U()
            r8.L()
            java.lang.String r3 = r3.i()
            r1.setContentDescription(r3)
            android.widget.TextView r1 = r8.J0
            r1.setText(r0)
            androidx.fragment.app.x r0 = r8.h()
            r0.getClass()
            androidx.fragment.app.a r1 = new androidx.fragment.app.a
            r1.<init>(r0)
            r0 = 2131296632(0x7f090178, float:1.8211186E38)
            com.google.android.material.datepicker.a0<S> r3 = r8.f3107s0
            r5 = 0
            r1.e(r0, r3, r5, r4)
            boolean r0 = r1.f1629g
            if (r0 != 0) goto Ld5
            androidx.fragment.app.x r0 = r1.f1571p
            r0.A(r1, r2)
            com.google.android.material.datepicker.a0<S> r0 = r8.f3107s0
            com.google.android.material.datepicker.r$c r1 = new com.google.android.material.datepicker.r$c
            r1.<init>()
            r0.P(r1)
            return
        Ld5:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "This transaction is already being added to the back stack"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.r.Y():void");
    }

    @Override // androidx.fragment.app.m, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f3103o0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.m, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f3104p0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.J;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.m, androidx.fragment.app.n
    public final void t(Bundle bundle) {
        super.t(bundle);
        if (bundle == null) {
            bundle = this.f1705k;
        }
        this.f3105q0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f3106r0 = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f3108t0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f3109u0 = (f) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f3111w0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f3112x0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f3114z0 = bundle.getInt("INPUT_MODE_KEY");
        this.A0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.B0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.C0 = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.D0 = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.E0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.F0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.G0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.H0 = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence = this.f3112x0;
        if (charSequence == null) {
            charSequence = L().getResources().getText(this.f3111w0);
        }
        this.O0 = charSequence;
        if (charSequence != null) {
            CharSequence[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                charSequence = split[0];
            }
        } else {
            charSequence = null;
        }
        this.P0 = charSequence;
    }

    @Override // androidx.fragment.app.n
    public final View u(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View findViewById;
        LinearLayout.LayoutParams layoutParams;
        View inflate = layoutInflater.inflate(this.f3113y0 ? 2131492964 : 2131492963, viewGroup);
        Context context = inflate.getContext();
        if (this.f3113y0) {
            findViewById = inflate.findViewById(2131296632);
            layoutParams = new LinearLayout.LayoutParams(V(context), -2);
        } else {
            findViewById = inflate.findViewById(2131296633);
            layoutParams = new LinearLayout.LayoutParams(V(context), -1);
        }
        findViewById.setLayoutParams(layoutParams);
        TextView textView = (TextView) inflate.findViewById(2131296644);
        this.J0 = textView;
        WeakHashMap<View, k0> weakHashMap = p1.y.f5540a;
        y.g.f(textView, 1);
        this.K0 = (CheckableImageButton) inflate.findViewById(2131296646);
        this.I0 = (TextView) inflate.findViewById(2131296650);
        this.K0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.K0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, g.a.a(context, 2131165382));
        stateListDrawable.addState(new int[0], g.a.a(context, 2131165384));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.K0.setChecked(this.f3114z0 != 0);
        p1.y.i(this.K0, null);
        this.K0.setContentDescription(this.K0.getContext().getString(this.f3114z0 == 1 ? 2131820701 : 2131820703));
        this.K0.setOnClickListener(new q(0, this));
        this.M0 = (Button) inflate.findViewById(2131296398);
        if (U().h()) {
            this.M0.setEnabled(true);
        } else {
            this.M0.setEnabled(false);
        }
        this.M0.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence = this.B0;
        if (charSequence != null) {
            this.M0.setText(charSequence);
        } else {
            int i7 = this.A0;
            if (i7 != 0) {
                this.M0.setText(i7);
            }
        }
        CharSequence charSequence2 = this.D0;
        if (charSequence2 != null) {
            this.M0.setContentDescription(charSequence2);
        } else if (this.C0 != 0) {
            this.M0.setContentDescription(j().getResources().getText(this.C0));
        }
        this.M0.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(2131296369);
        button.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence3 = this.F0;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i8 = this.E0;
            if (i8 != 0) {
                button.setText(i8);
            }
        }
        CharSequence charSequence4 = this.H0;
        if (charSequence4 == null) {
            if (this.G0 != 0) {
                charSequence4 = j().getResources().getText(this.G0);
            }
            button.setOnClickListener(new b());
            return inflate;
        }
        button.setContentDescription(charSequence4);
        button.setOnClickListener(new b());
        return inflate;
    }
}
