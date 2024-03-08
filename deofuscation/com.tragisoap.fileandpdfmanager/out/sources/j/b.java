package j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import k1.c;
import o.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class b {

    /* renamed from: a */
    public final Context f4556a;

    /* renamed from: b */
    public h<k1.b, MenuItem> f4557b;

    /* renamed from: c */
    public h<c, SubMenu> f4558c;

    public b(Context context) {
        this.f4556a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof k1.b)) {
            return menuItem;
        }
        k1.b bVar = (k1.b) menuItem;
        if (this.f4557b == null) {
            this.f4557b = new h<>();
        }
        MenuItem orDefault = this.f4557b.getOrDefault(bVar, null);
        if (orDefault != null) {
            return orDefault;
        }
        c cVar = new c(this.f4556a, bVar);
        this.f4557b.put(bVar, cVar);
        return cVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof c)) {
            return subMenu;
        }
        c cVar = (c) subMenu;
        if (this.f4558c == null) {
            this.f4558c = new h<>();
        }
        SubMenu orDefault = this.f4558c.getOrDefault(cVar, null);
        if (orDefault != null) {
            return orDefault;
        }
        g gVar = new g(this.f4556a, cVar);
        this.f4558c.put(cVar, gVar);
        return gVar;
    }
}
