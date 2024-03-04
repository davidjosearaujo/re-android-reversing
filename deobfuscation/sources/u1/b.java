package u1;

import android.database.Cursor;
import android.widget.Filter;
import androidx.appcompat.widget.u0;

/* loaded from: classes.dex */
public final class b extends Filter {

    /* renamed from: a */
    public a f6089a;

    /* loaded from: classes.dex */
    public interface a {
    }

    public b(a aVar) {
        this.f6089a = aVar;
    }

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return ((u0) this.f6089a).d((Cursor) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0047  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r3) {
        /*
            r2 = this;
            u1.b$a r2 = r2.f6089a
            androidx.appcompat.widget.u0 r2 = (androidx.appcompat.widget.u0) r2
            if (r3 != 0) goto L9
            java.lang.String r3 = ""
            goto L10
        L9:
            r2.getClass()
            java.lang.String r3 = r3.toString()
        L10:
            androidx.appcompat.widget.SearchView r0 = r2.f1043p
            int r0 = r0.getVisibility()
            r1 = 0
            if (r0 != 0) goto L36
            androidx.appcompat.widget.SearchView r0 = r2.f1043p
            int r0 = r0.getWindowVisibility()
            if (r0 == 0) goto L22
            goto L36
        L22:
            android.app.SearchableInfo r0 = r2.f1044q     // Catch: java.lang.RuntimeException -> L2e
            android.database.Cursor r2 = r2.h(r0, r3)     // Catch: java.lang.RuntimeException -> L2e
            if (r2 == 0) goto L36
            r2.getCount()     // Catch: java.lang.RuntimeException -> L2e
            goto L37
        L2e:
            r2 = move-exception
            java.lang.String r3 = "SuggestionsAdapter"
            java.lang.String r0 = "Search suggestions query threw an exception."
            android.util.Log.w(r3, r0, r2)
        L36:
            r2 = r1
        L37:
            android.widget.Filter$FilterResults r3 = new android.widget.Filter$FilterResults
            r3.<init>()
            if (r2 == 0) goto L47
            int r0 = r2.getCount()
            r3.count = r0
            r3.values = r2
            goto L4c
        L47:
            r2 = 0
            r3.count = r2
            r3.values = r1
        L4c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.b.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.f6089a;
        Cursor cursor = ((u1.a) aVar).f6082h;
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        ((u0) aVar).c((Cursor) obj);
    }
}
