package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import o1.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class w extends BaseAdapter {

    /* renamed from: l  reason: collision with root package name */
    public static final int f3129l = e0.e(null).getMaximum(4);
    public static final int m = (e0.e(null).getMaximum(7) + e0.e(null).getMaximum(5)) - 1;

    /* renamed from: f  reason: collision with root package name */
    public final v f3130f;

    /* renamed from: g  reason: collision with root package name */
    public final d<?> f3131g;

    /* renamed from: h  reason: collision with root package name */
    public Collection<Long> f3132h;

    /* renamed from: i  reason: collision with root package name */
    public c f3133i;

    /* renamed from: j  reason: collision with root package name */
    public final a f3134j;

    /* renamed from: k  reason: collision with root package name */
    public final f f3135k;

    public w(v vVar, d<?> dVar, a aVar, f fVar) {
        this.f3130f = vVar;
        this.f3131g = dVar;
        this.f3134j = aVar;
        this.f3135k = fVar;
        this.f3132h = dVar.k();
    }

    public final int b() {
        v vVar = this.f3130f;
        int i7 = this.f3134j.f3040j;
        int i8 = vVar.f3122f.get(7);
        if (i7 <= 0) {
            i7 = vVar.f3122f.getFirstDayOfWeek();
        }
        int i9 = i8 - i7;
        return i9 < 0 ? i9 + vVar.f3125i : i9;
    }

    /* renamed from: c */
    public final Long getItem(int i7) {
        if (i7 < b()) {
            return null;
        }
        int b2 = b();
        v vVar = this.f3130f;
        if (i7 > (b2 + vVar.f3126j) - 1) {
            return null;
        }
        Calendar c7 = e0.c(vVar.f3122f);
        c7.set(5, (i7 - b()) + 1);
        return Long.valueOf(c7.getTimeInMillis());
    }

    public final void d(TextView textView, long j7, int i7) {
        b bVar;
        boolean z6;
        if (textView != null) {
            Context context = textView.getContext();
            boolean z7 = true;
            boolean z8 = e0.d().getTimeInMillis() == j7;
            for (c<Long, Long> cVar : this.f3131g.e()) {
                cVar.getClass();
            }
            for (c<Long, Long> cVar2 : this.f3131g.e()) {
                cVar2.getClass();
            }
            Calendar d7 = e0.d();
            Calendar e = e0.e(null);
            e.setTimeInMillis(j7);
            String format = d7.get(1) == e.get(1) ? e0.b("MMMMEEEEd", Locale.getDefault()).format(new Date(j7)) : e0.b("yMMMMEEEEd", Locale.getDefault()).format(new Date(j7));
            if (z8) {
                format = String.format(context.getString(2131820700), format);
            }
            textView.setContentDescription(format);
            if (this.f3134j.f3038h.g(j7)) {
                textView.setEnabled(true);
                Iterator<Long> it = this.f3131g.k().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (e0.a(j7) == e0.a(it.next().longValue())) {
                            z6 = true;
                            break;
                        }
                    } else {
                        z6 = false;
                        break;
                    }
                }
                textView.setSelected(z6);
                if (z6) {
                    bVar = this.f3133i.f3055b;
                } else {
                    if (e0.d().getTimeInMillis() != j7) {
                        z7 = false;
                    }
                    c cVar3 = this.f3133i;
                    bVar = z7 ? cVar3.f3056c : cVar3.f3054a;
                }
            } else {
                textView.setEnabled(false);
                bVar = this.f3133i.f3059g;
            }
            f fVar = this.f3135k;
            if (fVar == null || i7 == -1) {
                bVar.b(textView);
                return;
            }
            int i8 = this.f3130f.f3124h;
            fVar.getClass();
            bVar.b(textView);
            this.f3135k.getClass();
            this.f3135k.getClass();
            this.f3135k.getClass();
            this.f3135k.getClass();
            textView.setCompoundDrawables(null, null, null, null);
            this.f3135k.getClass();
            textView.setContentDescription(format);
        }
    }

    public final void e(MaterialCalendarGridView materialCalendarGridView, long j7) {
        if (v.f(j7).equals(this.f3130f)) {
            Calendar c7 = e0.c(this.f3130f.f3122f);
            c7.setTimeInMillis(j7);
            int i7 = c7.get(5);
            d((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.getAdapter().b() + (i7 - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j7, i7);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return m;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i7) {
        return (long) (i7 / this.f3130f.f3125i);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            com.google.android.material.datepicker.c r1 = r5.f3133i
            if (r1 != 0) goto L_0x000f
            com.google.android.material.datepicker.c r1 = new com.google.android.material.datepicker.c
            r1.<init>(r0)
            r5.f3133i = r1
        L_0x000f:
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L_0x0027
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131492949(0x7f0c0055, float:1.8609364E38)
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0027:
            int r7 = r5.b()
            int r7 = r6 - r7
            r8 = -1
            if (r7 < 0) goto L_0x005f
            com.google.android.material.datepicker.v r2 = r5.f3130f
            int r3 = r2.f3126j
            if (r7 < r3) goto L_0x0037
            goto L_0x005f
        L_0x0037:
            r8 = 1
            int r7 = r7 + r8
            r0.setTag(r2)
            android.content.res.Resources r2 = r0.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            java.util.Locale r2 = r2.locale
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r2 = java.lang.String.format(r2, r4, r3)
            r0.setText(r2)
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            r8 = r7
            goto L_0x0067
        L_0x005f:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L_0x0067:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            long r6 = r6.longValue()
            r5.d(r0, r6, r8)
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.w.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
