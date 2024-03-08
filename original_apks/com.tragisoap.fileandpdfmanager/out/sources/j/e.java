package j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import k1.a;
import k1.b;
import k1.c;
import o.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class e extends b implements Menu {

    /* renamed from: d  reason: collision with root package name */
    public final a f4569d;

    public e(Context context, a aVar) {
        super(context);
        if (aVar != null) {
            this.f4569d = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public final MenuItem add(int i7) {
        return c(this.f4569d.add(i7));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i7, int i8, int i9, int i10) {
        return c(this.f4569d.add(i7, i8, i9, i10));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i7, int i8, int i9, CharSequence charSequence) {
        return c(this.f4569d.add(i7, i8, i9, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return c(this.f4569d.add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i7, int i8, int i9, ComponentName componentName, Intent[] intentArr, Intent intent, int i10, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.f4569d.addIntentOptions(i7, i8, i9, componentName, intentArr, intent, i10, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i11 = 0; i11 < length; i11++) {
                menuItemArr[i11] = c(menuItemArr2[i11]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i7) {
        return d(this.f4569d.addSubMenu(i7));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i7, int i8, int i9, int i10) {
        return d(this.f4569d.addSubMenu(i7, i8, i9, i10));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i7, int i8, int i9, CharSequence charSequence) {
        return d(this.f4569d.addSubMenu(i7, i8, i9, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f4569d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public final void clear() {
        h<b, MenuItem> hVar = this.f4557b;
        if (hVar != null) {
            hVar.clear();
        }
        h<c, SubMenu> hVar2 = this.f4558c;
        if (hVar2 != null) {
            hVar2.clear();
        }
        this.f4569d.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f4569d.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i7) {
        return c(this.f4569d.findItem(i7));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i7) {
        return c(this.f4569d.getItem(i7));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f4569d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i7, KeyEvent keyEvent) {
        return this.f4569d.isShortcutKey(i7, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i7, int i8) {
        return this.f4569d.performIdentifierAction(i7, i8);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i7, KeyEvent keyEvent, int i8) {
        return this.f4569d.performShortcut(i7, keyEvent, i8);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i7) {
        if (this.f4557b != null) {
            int i8 = 0;
            while (true) {
                h<b, MenuItem> hVar = this.f4557b;
                if (i8 >= hVar.f5221h) {
                    break;
                }
                if (hVar.h(i8).getGroupId() == i7) {
                    this.f4557b.j(i8);
                    i8--;
                }
                i8++;
            }
        }
        this.f4569d.removeGroup(i7);
    }

    @Override // android.view.Menu
    public final void removeItem(int i7) {
        if (this.f4557b != null) {
            int i8 = 0;
            while (true) {
                h<b, MenuItem> hVar = this.f4557b;
                if (i8 >= hVar.f5221h) {
                    break;
                } else if (hVar.h(i8).getItemId() == i7) {
                    this.f4557b.j(i8);
                    break;
                } else {
                    i8++;
                }
            }
        }
        this.f4569d.removeItem(i7);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i7, boolean z6, boolean z7) {
        this.f4569d.setGroupCheckable(i7, z6, z7);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i7, boolean z6) {
        this.f4569d.setGroupEnabled(i7, z6);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i7, boolean z6) {
        this.f4569d.setGroupVisible(i7, z6);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z6) {
        this.f4569d.setQwertyMode(z6);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f4569d.size();
    }
}
