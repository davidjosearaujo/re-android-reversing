package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d implements j, AdapterView.OnItemClickListener {

    /* renamed from: f */
    public Context f564f;

    /* renamed from: g */
    public LayoutInflater f565g;

    /* renamed from: h */
    public f f566h;

    /* renamed from: i */
    public ExpandedMenuView f567i;

    /* renamed from: j */
    public j.a f568j;

    /* renamed from: k */
    public a f569k;

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: f */
        public int f570f = -1;

        public a() {
            d.this = r1;
            b();
        }

        public final void b() {
            f fVar = d.this.f566h;
            h hVar = fVar.f597v;
            if (hVar != null) {
                fVar.i();
                ArrayList<h> arrayList = fVar.f587j;
                int size = arrayList.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (arrayList.get(i7) == hVar) {
                        this.f570f = i7;
                        return;
                    }
                }
            }
            this.f570f = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: c */
        public final h getItem(int i7) {
            f fVar = d.this.f566h;
            fVar.i();
            ArrayList<h> arrayList = fVar.f587j;
            d.this.getClass();
            int i8 = i7 + 0;
            int i9 = this.f570f;
            if (i9 >= 0 && i8 >= i9) {
                i8++;
            }
            return arrayList.get(i8);
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            f fVar = d.this.f566h;
            fVar.i();
            int size = fVar.f587j.size();
            d.this.getClass();
            int i7 = size + 0;
            return this.f570f < 0 ? i7 : i7 - 1;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i7) {
            return i7;
        }

        @Override // android.widget.Adapter
        public final View getView(int i7, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = d.this.f565g.inflate(2131492880, viewGroup, false);
            }
            ((k.a) view).c(getItem(i7));
            return view;
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public d(Context context) {
        this.f564f = context;
        this.f565g = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f fVar, boolean z6) {
        j.a aVar = this.f568j;
        if (aVar != null) {
            aVar.a(fVar, z6);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c(h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void e(Context context, f fVar) {
        if (this.f564f != null) {
            this.f564f = context;
            if (this.f565g == null) {
                this.f565g = LayoutInflater.from(context);
            }
        }
        this.f566h = fVar;
        a aVar = this.f569k;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final void f() {
        a aVar = this.f569k;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean h(m mVar) {
        if (mVar.hasVisibleItems()) {
            g gVar = new g(mVar);
            b.a aVar = new b.a(mVar.f579a);
            d dVar = new d(aVar.f500a.f487a);
            gVar.f602h = dVar;
            dVar.f568j = gVar;
            f fVar = gVar.f600f;
            fVar.b(dVar, fVar.f579a);
            d dVar2 = gVar.f602h;
            if (dVar2.f569k == null) {
                dVar2.f569k = new a();
            }
            a aVar2 = dVar2.f569k;
            AlertController.b bVar = aVar.f500a;
            bVar.f492g = aVar2;
            bVar.f493h = gVar;
            View view = mVar.f591o;
            if (view != null) {
                bVar.e = view;
            } else {
                bVar.f489c = mVar.f590n;
                bVar.f490d = mVar.m;
            }
            bVar.f491f = gVar;
            androidx.appcompat.app.b a7 = aVar.a();
            gVar.f601g = a7;
            a7.setOnDismissListener(gVar);
            WindowManager.LayoutParams attributes = gVar.f601g.getWindow().getAttributes();
            attributes.type = 1003;
            attributes.flags |= 131072;
            gVar.f601g.show();
            j.a aVar3 = this.f568j;
            if (aVar3 != null) {
                aVar3.b(mVar);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void j(j.a aVar) {
        this.f568j = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean k(h hVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i7, long j5) {
        this.f566h.q(this.f569k.getItem(i7), this, 0);
    }
}
