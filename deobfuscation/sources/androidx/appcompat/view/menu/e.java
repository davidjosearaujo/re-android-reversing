package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends BaseAdapter {

    /* renamed from: f */
    public f f572f;

    /* renamed from: g */
    public int f573g = -1;

    /* renamed from: h */
    public boolean f574h;

    /* renamed from: i */
    public final boolean f575i;

    /* renamed from: j */
    public final LayoutInflater f576j;

    /* renamed from: k */
    public final int f577k;

    public e(f fVar, LayoutInflater layoutInflater, boolean z6, int i7) {
        this.f575i = z6;
        this.f576j = layoutInflater;
        this.f572f = fVar;
        this.f577k = i7;
        b();
    }

    public final void b() {
        f fVar = this.f572f;
        h hVar = fVar.f597v;
        if (hVar != null) {
            fVar.i();
            ArrayList<h> arrayList = fVar.f587j;
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (arrayList.get(i7) == hVar) {
                    this.f573g = i7;
                    return;
                }
            }
        }
        this.f573g = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public final h getItem(int i7) {
        ArrayList<h> l6;
        if (this.f575i) {
            f fVar = this.f572f;
            fVar.i();
            l6 = fVar.f587j;
        } else {
            l6 = this.f572f.l();
        }
        int i8 = this.f573g;
        if (i8 >= 0 && i7 >= i8) {
            i7++;
        }
        return l6.get(i7);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<h> l6;
        if (this.f575i) {
            f fVar = this.f572f;
            fVar.i();
            l6 = fVar.f587j;
        } else {
            l6 = this.f572f.l();
        }
        return this.f573g < 0 ? l6.size() : l6.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public final View getView(int i7, View view, ViewGroup viewGroup) {
        boolean z6 = false;
        if (view == null) {
            view = this.f576j.inflate(this.f577k, viewGroup, false);
        }
        int i8 = getItem(i7).f604b;
        int i9 = i7 - 1;
        int i10 = i9 >= 0 ? getItem(i9).f604b : i8;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f572f.m() && i8 != i10) {
            z6 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z6);
        k.a aVar = (k.a) view;
        if (this.f574h) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.c(getItem(i7));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
