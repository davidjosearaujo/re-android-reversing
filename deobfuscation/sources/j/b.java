package j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import o.h;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a */
    public final Context f4556a;

    /* renamed from: b */
    public h<k1.b, MenuItem> f4557b;

    /* renamed from: c */
    public h<k1.c, SubMenu> f4558c;

    public b(Context context) {
        this.f4556a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof k1.b) {
            k1.b bVar = (k1.b) menuItem;
            if (this.f4557b == null) {
                this.f4557b = new h<>();
            }
            MenuItem orDefault = this.f4557b.getOrDefault(bVar, null);
            if (orDefault == null) {
                c cVar = new c(this.f4556a, bVar);
                this.f4557b.put(bVar, cVar);
                return cVar;
            }
            return orDefault;
        }
        return menuItem;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (subMenu instanceof k1.c) {
            k1.c cVar = (k1.c) subMenu;
            if (this.f4558c == null) {
                this.f4558c = new h<>();
            }
            SubMenu orDefault = this.f4558c.getOrDefault(cVar, null);
            if (orDefault == null) {
                g gVar = new g(this.f4556a, cVar);
                this.f4558c.put(cVar, gVar);
                return gVar;
            }
            return orDefault;
        }
        return subMenu;
    }
}
