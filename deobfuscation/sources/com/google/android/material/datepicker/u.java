package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class u<S> extends a0<S> {
    public int X;
    public d<S> Y;
    public com.google.android.material.datepicker.a Z;

    /* loaded from: classes.dex */
    public class a extends z<S> {
        public a() {
            u.this = r1;
        }

        @Override // com.google.android.material.datepicker.z
        public final void a(S s) {
            Iterator<z<S>> it = u.this.W.iterator();
            while (it.hasNext()) {
                it.next().a(s);
            }
        }
    }

    @Override // androidx.fragment.app.n
    public final void A(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.X);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.Y);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Z);
    }

    @Override // androidx.fragment.app.n
    public final void t(Bundle bundle) {
        super.t(bundle);
        if (bundle == null) {
            bundle = this.f1705k;
        }
        this.X = bundle.getInt("THEME_RES_ID_KEY");
        this.Y = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.Z = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.n
    public final View u(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(j(), this.X));
        d<S> dVar = this.Y;
        new a();
        return dVar.p();
    }
}
