package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.r;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes.dex */
public final class i<S> extends a0<S> {

    /* renamed from: k0 */
    public static final /* synthetic */ int f3075k0 = 0;
    public int X;
    public com.google.android.material.datepicker.d<S> Y;
    public com.google.android.material.datepicker.a Z;

    /* renamed from: a0 */
    public f f3076a0;

    /* renamed from: b0 */
    public v f3077b0;

    /* renamed from: c0 */
    public int f3078c0;

    /* renamed from: d0 */
    public com.google.android.material.datepicker.c f3079d0;

    /* renamed from: e0 */
    public RecyclerView f3080e0;

    /* renamed from: f0 */
    public RecyclerView f3081f0;

    /* renamed from: g0 */
    public View f3082g0;

    /* renamed from: h0 */
    public View f3083h0;

    /* renamed from: i0 */
    public View f3084i0;

    /* renamed from: j0 */
    public View f3085j0;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ int f3086f;

        public a(int i7) {
            i.this = r1;
            this.f3086f = i7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = i.this.f3081f0;
            int i7 = this.f3086f;
            if (recyclerView.C) {
                return;
            }
            RecyclerView.l lVar = recyclerView.f1986r;
            if (lVar == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                lVar.y0(recyclerView, i7);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends p1.a {
        @Override // p1.a
        public final void d(View view, q1.f fVar) {
            this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
            fVar.i(null);
        }
    }

    /* loaded from: classes.dex */
    public class c extends c0 {
        public final /* synthetic */ int E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i7, int i8) {
            super(i7);
            i.this = r1;
            this.E = i8;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public final void B0(RecyclerView.w wVar, int[] iArr) {
            if (this.E == 0) {
                iArr[0] = i.this.f3081f0.getWidth();
                iArr[1] = i.this.f3081f0.getWidth();
                return;
            }
            iArr[0] = i.this.f3081f0.getHeight();
            iArr[1] = i.this.f3081f0.getHeight();
        }
    }

    /* loaded from: classes.dex */
    public class d implements e {
        public d() {
            i.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
    }

    @Override // androidx.fragment.app.n
    public final void A(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.X);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Y);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Z);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f3076a0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f3077b0);
    }

    @Override // com.google.android.material.datepicker.a0
    public final boolean P(r.c cVar) {
        return super.P(cVar);
    }

    public final LinearLayoutManager Q() {
        return (LinearLayoutManager) this.f3081f0.getLayoutManager();
    }

    public final void R(int i7) {
        this.f3081f0.post(new a(i7));
    }

    public final void S(v vVar) {
        RecyclerView recyclerView;
        int i7;
        v vVar2 = ((y) this.f3081f0.getAdapter()).f3138d.f3036f;
        Calendar calendar = vVar2.f3122f;
        if (!(calendar instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        int i8 = vVar.f3124h;
        int i9 = vVar2.f3124h;
        int i10 = vVar.f3123g;
        int i11 = vVar2.f3123g;
        int i12 = (i10 - i11) + ((i8 - i9) * 12);
        v vVar3 = this.f3077b0;
        if (!(calendar instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        int i13 = i12 - ((vVar3.f3123g - i11) + ((vVar3.f3124h - i9) * 12));
        boolean z6 = Math.abs(i13) > 3;
        boolean z7 = i13 > 0;
        this.f3077b0 = vVar;
        if (!z6 || !z7) {
            if (z6) {
                recyclerView = this.f3081f0;
                i7 = i12 + 3;
            }
            R(i12);
        }
        recyclerView = this.f3081f0;
        i7 = i12 - 3;
        recyclerView.g0(i7);
        R(i12);
    }

    public final void T(int i7) {
        this.f3078c0 = i7;
        if (i7 == 2) {
            this.f3080e0.getLayoutManager().o0(this.f3077b0.f3124h - ((g0) this.f3080e0.getAdapter()).f3071d.Z.f3036f.f3124h);
            this.f3084i0.setVisibility(0);
            this.f3085j0.setVisibility(8);
            this.f3082g0.setVisibility(8);
            this.f3083h0.setVisibility(8);
        } else if (i7 == 1) {
            this.f3084i0.setVisibility(8);
            this.f3085j0.setVisibility(0);
            this.f3082g0.setVisibility(0);
            this.f3083h0.setVisibility(0);
            S(this.f3077b0);
        }
    }

    @Override // androidx.fragment.app.n
    public final void t(Bundle bundle) {
        super.t(bundle);
        if (bundle == null) {
            bundle = this.f1705k;
        }
        this.X = bundle.getInt("THEME_RES_ID_KEY");
        this.Y = (com.google.android.material.datepicker.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.Z = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f3076a0 = (f) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f3077b0 = (v) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.n
    public final View u(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i7;
        int i8;
        androidx.recyclerview.widget.s sVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(j(), this.X);
        this.f3079d0 = new com.google.android.material.datepicker.c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        v vVar = this.Z.f3036f;
        if (r.W(contextThemeWrapper)) {
            i7 = 2131492957;
            i8 = 1;
        } else {
            i7 = 2131492952;
            i8 = 0;
        }
        View inflate = cloneInContext.inflate(i7, viewGroup, false);
        Resources resources = L().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(2131100295) + resources.getDimensionPixelOffset(2131100297) + resources.getDimensionPixelSize(2131100296);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131100280);
        int i9 = w.f3129l;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(2131100294) * (i9 - 1)) + (resources.getDimensionPixelSize(2131100275) * i9) + resources.getDimensionPixelOffset(2131100272));
        GridView gridView = (GridView) inflate.findViewById(2131296631);
        p1.y.i(gridView, new b());
        int i10 = this.Z.f3040j;
        gridView.setAdapter((ListAdapter) (i10 > 0 ? new g(i10) : new g()));
        gridView.setNumColumns(vVar.f3125i);
        gridView.setEnabled(false);
        this.f3081f0 = (RecyclerView) inflate.findViewById(2131296634);
        j();
        this.f3081f0.setLayoutManager(new c(i8, i8));
        this.f3081f0.setTag("MONTHS_VIEW_GROUP_TAG");
        y yVar = new y(contextThemeWrapper, this.Y, this.Z, this.f3076a0, new d());
        this.f3081f0.setAdapter(yVar);
        int integer = contextThemeWrapper.getResources().getInteger(2131361842);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(2131296637);
        this.f3080e0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.f3080e0.setLayoutManager(new GridLayoutManager(integer));
            this.f3080e0.setAdapter(new g0(this));
            this.f3080e0.i(new k(this));
        }
        if (inflate.findViewById(2131296624) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(2131296624);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            p1.y.i(materialButton, new l(this));
            View findViewById = inflate.findViewById(2131296626);
            this.f3082g0 = findViewById;
            findViewById.setTag("NAVIGATION_PREV_TAG");
            View findViewById2 = inflate.findViewById(2131296625);
            this.f3083h0 = findViewById2;
            findViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.f3084i0 = inflate.findViewById(2131296637);
            this.f3085j0 = inflate.findViewById(2131296630);
            T(1);
            materialButton.setText(this.f3077b0.j());
            this.f3081f0.j(new m(this, yVar, materialButton));
            materialButton.setOnClickListener(new n(this));
            this.f3083h0.setOnClickListener(new o(this, yVar));
            this.f3082g0.setOnClickListener(new h(this, yVar));
        }
        if (!r.W(contextThemeWrapper) && (recyclerView2 = (sVar = new androidx.recyclerview.widget.s()).f2280a) != (recyclerView = this.f3081f0)) {
            if (recyclerView2 != null) {
                y.a aVar = sVar.f2281b;
                ArrayList arrayList = recyclerView2.f1977m0;
                if (arrayList != null) {
                    arrayList.remove(aVar);
                }
                sVar.f2280a.setOnFlingListener(null);
            }
            sVar.f2280a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                sVar.f2280a.j(sVar.f2281b);
                sVar.f2280a.setOnFlingListener(sVar);
                new Scroller(sVar.f2280a.getContext(), new DecelerateInterpolator());
                sVar.b();
            }
        }
        RecyclerView recyclerView4 = this.f3081f0;
        v vVar2 = this.f3077b0;
        v vVar3 = yVar.f3138d.f3036f;
        if (vVar3.f3122f instanceof GregorianCalendar) {
            recyclerView4.g0((vVar2.f3123g - vVar3.f3123g) + ((vVar2.f3124h - vVar3.f3124h) * 12));
            p1.y.i(this.f3081f0, new j());
            return inflate;
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }
}
