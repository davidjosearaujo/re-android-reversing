package u1;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.fragment.app.s0;
import u1.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: l */
    public b f6086l;

    /* renamed from: g */
    public boolean f6081g = true;

    /* renamed from: h */
    public Cursor f6082h = null;

    /* renamed from: f */
    public boolean f6080f = false;

    /* renamed from: i */
    public int f6083i = -1;

    /* renamed from: j */
    public C0109a f6084j = new C0109a();

    /* renamed from: k */
    public b f6085k = new b();

    /* renamed from: u1.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class C0109a extends ContentObserver {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0109a() {
            super(new Handler());
            a.this = r1;
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z6) {
            Cursor cursor;
            a aVar = a.this;
            if (aVar.f6081g && (cursor = aVar.f6082h) != null && !cursor.isClosed()) {
                aVar.f6080f = aVar.f6082h.requery();
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends DataSetObserver {
        public b() {
            a.this = r1;
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            a aVar = a.this;
            aVar.f6080f = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            a aVar = a.this;
            aVar.f6080f = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context) {
    }

    public abstract void b(View view, Cursor cursor);

    public void c(Cursor cursor) {
        Cursor cursor2 = this.f6082h;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0109a aVar = this.f6084j;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                b bVar = this.f6085k;
                if (bVar != null) {
                    cursor2.unregisterDataSetObserver(bVar);
                }
            }
            this.f6082h = cursor;
            if (cursor != null) {
                C0109a aVar2 = this.f6084j;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                b bVar2 = this.f6085k;
                if (bVar2 != null) {
                    cursor.registerDataSetObserver(bVar2);
                }
                this.f6083i = cursor.getColumnIndexOrThrow("_id");
                this.f6080f = true;
                notifyDataSetChanged();
            } else {
                this.f6083i = -1;
                this.f6080f = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String d(Cursor cursor);

    public abstract View e(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f6080f || (cursor = this.f6082h) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i7, View view, ViewGroup viewGroup) {
        if (!this.f6080f) {
            return null;
        }
        this.f6082h.moveToPosition(i7);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.f6091o.inflate(cVar.f6090n, viewGroup, false);
        }
        b(view, this.f6082h);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f6086l == null) {
            this.f6086l = new b(this);
        }
        return this.f6086l;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i7) {
        Cursor cursor;
        if (!this.f6080f || (cursor = this.f6082h) == null) {
            return null;
        }
        cursor.moveToPosition(i7);
        return this.f6082h;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i7) {
        Cursor cursor;
        if (!this.f6080f || (cursor = this.f6082h) == null || !cursor.moveToPosition(i7)) {
            return 0;
        }
        return this.f6082h.getLong(this.f6083i);
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        if (!this.f6080f) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f6082h.moveToPosition(i7)) {
            if (view == null) {
                view = e(viewGroup);
            }
            b(view, this.f6082h);
            return view;
        } else {
            throw new IllegalStateException(s0.g("couldn't move cursor to position ", i7));
        }
    }
}
