package u1;

import android.database.Cursor;
import android.widget.Filter;
import androidx.appcompat.widget.u0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public a f6089a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
    }

    public b(a aVar) {
        this.f6089a = aVar;
    }

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return ((u0) this.f6089a).d((Cursor) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r3) {
        /*
            r2 = this;
            u1.b$a r2 = r2.f6089a
            androidx.appcompat.widget.u0 r2 = (androidx.appcompat.widget.u0) r2
            if (r3 != 0) goto L_0x0009
            java.lang.String r3 = ""
            goto L_0x0010
        L_0x0009:
            r2.getClass()
            java.lang.String r3 = r3.toString()
        L_0x0010:
            androidx.appcompat.widget.SearchView r0 = r2.f1043p
            int r0 = r0.getVisibility()
            r1 = 0
            if (r0 != 0) goto L_0x0036
            androidx.appcompat.widget.SearchView r0 = r2.f1043p
            int r0 = r0.getWindowVisibility()
            if (r0 == 0) goto L_0x0022
            goto L_0x0036
        L_0x0022:
            android.app.SearchableInfo r0 = r2.f1044q     // Catch: RuntimeException -> 0x002e
            android.database.Cursor r2 = r2.h(r0, r3)     // Catch: RuntimeException -> 0x002e
            if (r2 == 0) goto L_0x0036
            r2.getCount()     // Catch: RuntimeException -> 0x002e
            goto L_0x0037
        L_0x002e:
            r2 = move-exception
            java.lang.String r3 = "SuggestionsAdapter"
            java.lang.String r0 = "Search suggestions query threw an exception."
            android.util.Log.w(r3, r0, r2)
        L_0x0036:
            r2 = r1
        L_0x0037:
            android.widget.Filter$FilterResults r3 = new android.widget.Filter$FilterResults
            r3.<init>()
            if (r2 == 0) goto L_0x0047
            int r0 = r2.getCount()
            r3.count = r0
            r3.values = r2
            goto L_0x004c
        L_0x0047:
            r2 = 0
            r3.count = r2
            r3.values = r1
        L_0x004c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.b.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.f6089a;
        Cursor cursor = ((a) aVar).f6082h;
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            ((u0) aVar).c((Cursor) obj);
        }
    }
}
