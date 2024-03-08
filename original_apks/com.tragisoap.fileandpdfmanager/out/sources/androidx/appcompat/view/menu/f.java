package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import g1.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p1.d0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class f implements k1.a {

    /* renamed from: y */
    public static final int[] f578y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a */
    public final Context f579a;

    /* renamed from: b */
    public final Resources f580b;

    /* renamed from: c */
    public boolean f581c;

    /* renamed from: d */
    public boolean f582d;
    public a e;
    public CharSequence m;

    /* renamed from: n */
    public Drawable f590n;

    /* renamed from: o */
    public View f591o;

    /* renamed from: v */
    public h f597v;

    /* renamed from: x */
    public boolean f599x;

    /* renamed from: l */
    public int f589l = 0;

    /* renamed from: p */
    public boolean f592p = false;

    /* renamed from: q */
    public boolean f593q = false;

    /* renamed from: r */
    public boolean f594r = false;
    public boolean s = false;

    /* renamed from: t */
    public ArrayList<h> f595t = new ArrayList<>();

    /* renamed from: u */
    public CopyOnWriteArrayList<WeakReference<j>> f596u = new CopyOnWriteArrayList<>();

    /* renamed from: w */
    public boolean f598w = false;

    /* renamed from: f */
    public ArrayList<h> f583f = new ArrayList<>();

    /* renamed from: g */
    public ArrayList<h> f584g = new ArrayList<>();

    /* renamed from: h */
    public boolean f585h = true;

    /* renamed from: i */
    public ArrayList<h> f586i = new ArrayList<>();

    /* renamed from: j */
    public ArrayList<h> f587j = new ArrayList<>();

    /* renamed from: k */
    public boolean f588k = true;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        boolean a(f fVar, MenuItem menuItem);

        void b(f fVar);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        boolean a(h hVar);
    }

    public f(Context context) {
        boolean z6 = false;
        this.f579a = context;
        Resources resources = context.getResources();
        this.f580b = resources;
        if (resources.getConfiguration().keyboard != 1 && d0.b(ViewConfiguration.get(context))) {
            z6 = true;
        }
        this.f582d = z6;
    }

    public final h a(int i7, int i8, int i9, CharSequence charSequence) {
        int i10;
        int i11 = (-65536 & i9) >> 16;
        if (i11 >= 0) {
            int[] iArr = f578y;
            if (i11 < 6) {
                int i12 = (iArr[i11] << 16) | (65535 & i9);
                h hVar = new h(this, i7, i8, i9, i12, charSequence, this.f589l);
                ArrayList<h> arrayList = this.f583f;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        if (arrayList.get(size).f606d <= i12) {
                            i10 = size + 1;
                            break;
                        }
                    } else {
                        i10 = 0;
                        break;
                    }
                }
                arrayList.add(i10, hVar);
                p(true);
                return hVar;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public final MenuItem add(int i7) {
        return a(0, 0, 0, this.f580b.getString(i7));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i7, int i8, int i9, int i10) {
        return a(i7, i8, i9, this.f580b.getString(i10));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i7, int i8, int i9, CharSequence charSequence) {
        return a(i7, i8, i9, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i7, int i8, int i9, ComponentName componentName, Intent[] intentArr, Intent intent, int i10, MenuItem[] menuItemArr) {
        int i11;
        PackageManager packageManager = this.f579a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i10 & 1) == 0) {
            removeGroup(i7);
        }
        for (int i12 = 0; i12 < size; i12++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i12);
            int i13 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i13 < 0 ? intent : intentArr[i13]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            h a7 = a(i7, i8, i9, resolveInfo.loadLabel(packageManager));
            a7.setIcon(resolveInfo.loadIcon(packageManager));
            a7.f608g = intent2;
            if (menuItemArr != null && (i11 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i11] = a7;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i7) {
        return addSubMenu(0, 0, 0, this.f580b.getString(i7));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i7, int i8, int i9, int i10) {
        return addSubMenu(i7, i8, i9, this.f580b.getString(i10));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i7, int i8, int i9, CharSequence charSequence) {
        h a7 = a(i7, i8, i9, charSequence);
        m mVar = new m(this.f579a, this, a7);
        a7.f615o = mVar;
        mVar.setHeaderTitle(a7.e);
        return mVar;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(j jVar, Context context) {
        this.f596u.add(new WeakReference<>(jVar));
        jVar.e(context, this);
        this.f588k = true;
    }

    public final void c(boolean z6) {
        if (!this.s) {
            this.s = true;
            Iterator<WeakReference<j>> it = this.f596u.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f596u.remove(next);
                } else {
                    jVar.a(this, z6);
                }
            }
            this.s = false;
        }
    }

    @Override // android.view.Menu
    public final void clear() {
        h hVar = this.f597v;
        if (hVar != null) {
            d(hVar);
        }
        this.f583f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f590n = null;
        this.m = null;
        this.f591o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(h hVar) {
        boolean z6 = false;
        if (!this.f596u.isEmpty() && this.f597v == hVar) {
            w();
            Iterator<WeakReference<j>> it = this.f596u.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f596u.remove(next);
                } else {
                    z6 = jVar.c(hVar);
                    if (z6) {
                        break;
                    }
                }
            }
            v();
            if (z6) {
                this.f597v = null;
            }
        }
        return z6;
    }

    public boolean e(f fVar, MenuItem menuItem) {
        a aVar = this.e;
        return aVar != null && aVar.a(fVar, menuItem);
    }

    public boolean f(h hVar) {
        boolean z6 = false;
        if (this.f596u.isEmpty()) {
            return false;
        }
        w();
        Iterator<WeakReference<j>> it = this.f596u.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                this.f596u.remove(next);
            } else {
                z6 = jVar.k(hVar);
                if (z6) {
                    break;
                }
            }
        }
        v();
        if (z6) {
            this.f597v = hVar;
        }
        return z6;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i7) {
        MenuItem findItem;
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            h hVar = this.f583f.get(i8);
            if (hVar.f603a == i7) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (findItem = hVar.f615o.findItem(i7)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final h g(int i7, KeyEvent keyEvent) {
        ArrayList<h> arrayList = this.f595t;
        arrayList.clear();
        h(arrayList, i7, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean n6 = n();
        for (int i8 = 0; i8 < size; i8++) {
            h hVar = arrayList.get(i8);
            char c7 = n6 ? hVar.f611j : hVar.f609h;
            char[] cArr = keyData.meta;
            if ((c7 == cArr[0] && (metaState & 2) == 0) || ((c7 == cArr[2] && (metaState & 2) != 0) || (n6 && c7 == '\b' && i7 == 67))) {
                return hVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i7) {
        return this.f583f.get(i7);
    }

    public final void h(ArrayList arrayList, int i7, KeyEvent keyEvent) {
        boolean n6 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i7 == 67) {
            int size = this.f583f.size();
            for (int i8 = 0; i8 < size; i8++) {
                h hVar = this.f583f.get(i8);
                if (hVar.hasSubMenu()) {
                    hVar.f615o.h(arrayList, i7, keyEvent);
                }
                char c7 = n6 ? hVar.f611j : hVar.f609h;
                if (((modifiers & 69647) == ((n6 ? hVar.f612k : hVar.f610i) & 69647)) && c7 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c7 == cArr[0] || c7 == cArr[2] || (n6 && c7 == '\b' && i7 == 67)) && hVar.isEnabled()) {
                        arrayList.add(hVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f599x) {
            return true;
        }
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            if (this.f583f.get(i7).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList<h> l6 = l();
        if (this.f588k) {
            Iterator<WeakReference<j>> it = this.f596u.iterator();
            boolean z6 = false;
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f596u.remove(next);
                } else {
                    z6 |= jVar.i();
                }
            }
            if (z6) {
                this.f586i.clear();
                this.f587j.clear();
                int size = l6.size();
                for (int i7 = 0; i7 < size; i7++) {
                    h hVar = l6.get(i7);
                    ((hVar.f623x & 32) == 32 ? this.f586i : this.f587j).add(hVar);
                }
            } else {
                this.f586i.clear();
                this.f587j.clear();
                this.f587j.addAll(l());
            }
            this.f588k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i7, KeyEvent keyEvent) {
        return g(i7, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public f k() {
        return this;
    }

    public final ArrayList<h> l() {
        if (!this.f585h) {
            return this.f584g;
        }
        this.f584g.clear();
        int size = this.f583f.size();
        for (int i7 = 0; i7 < size; i7++) {
            h hVar = this.f583f.get(i7);
            if (hVar.isVisible()) {
                this.f584g.add(hVar);
            }
        }
        this.f585h = false;
        this.f588k = true;
        return this.f584g;
    }

    public boolean m() {
        return this.f598w;
    }

    public boolean n() {
        return this.f581c;
    }

    public boolean o() {
        return this.f582d;
    }

    public final void p(boolean z6) {
        if (!this.f592p) {
            if (z6) {
                this.f585h = true;
                this.f588k = true;
            }
            if (!this.f596u.isEmpty()) {
                w();
                Iterator<WeakReference<j>> it = this.f596u.iterator();
                while (it.hasNext()) {
                    WeakReference<j> next = it.next();
                    j jVar = next.get();
                    if (jVar == null) {
                        this.f596u.remove(next);
                    } else {
                        jVar.f();
                    }
                }
                v();
                return;
            }
            return;
        }
        this.f593q = true;
        if (z6) {
            this.f594r = true;
        }
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i7, int i8) {
        return q(findItem(i7), null, i8);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i7, KeyEvent keyEvent, int i8) {
        h g2 = g(i7, keyEvent);
        boolean q6 = g2 != null ? q(g2, null, i8) : false;
        if ((i8 & 2) != 0) {
            c(true);
        }
        return q6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r1 != false) goto L_0x00c8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006a, code lost:
        if ((r9 & 1) == 0) goto L_0x00c8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c6, code lost:
        if (r1 == false) goto L_0x00c8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c8, code lost:
        c(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cb, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, androidx.appcompat.view.menu.j r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.h r7 = (androidx.appcompat.view.menu.h) r7
            r0 = 0
            if (r7 == 0) goto L_0x00cc
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x000d
            goto L_0x00cc
        L_0x000d:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.f616p
            r2 = 1
            if (r1 == 0) goto L_0x0019
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L_0x0019
            goto L_0x0040
        L_0x0019:
            androidx.appcompat.view.menu.f r1 = r7.f614n
            boolean r1 = r1.e(r1, r7)
            if (r1 == 0) goto L_0x0022
            goto L_0x0040
        L_0x0022:
            android.content.Intent r1 = r7.f608g
            if (r1 == 0) goto L_0x0036
            androidx.appcompat.view.menu.f r3 = r7.f614n     // Catch: ActivityNotFoundException -> 0x002e
            android.content.Context r3 = r3.f579a     // Catch: ActivityNotFoundException -> 0x002e
            r3.startActivity(r1)     // Catch: ActivityNotFoundException -> 0x002e
            goto L_0x0040
        L_0x002e:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L_0x0036:
            p1.b r1 = r7.A
            if (r1 == 0) goto L_0x0042
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0042
        L_0x0040:
            r1 = r2
            goto L_0x0043
        L_0x0042:
            r1 = r0
        L_0x0043:
            p1.b r3 = r7.A
            if (r3 == 0) goto L_0x004f
            boolean r4 = r3.a()
            if (r4 == 0) goto L_0x004f
            r4 = r2
            goto L_0x0050
        L_0x004f:
            r4 = r0
        L_0x0050:
            boolean r5 = r7.e()
            if (r5 == 0) goto L_0x005f
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L_0x00cb
            goto L_0x00c8
        L_0x005f:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L_0x006d
            if (r4 == 0) goto L_0x0068
            goto L_0x006d
        L_0x0068:
            r7 = r9 & 1
            if (r7 != 0) goto L_0x00cb
            goto L_0x00c8
        L_0x006d:
            r9 = r9 & 4
            if (r9 != 0) goto L_0x0074
            r6.c(r0)
        L_0x0074:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L_0x0088
            androidx.appcompat.view.menu.m r9 = new androidx.appcompat.view.menu.m
            android.content.Context r5 = r6.f579a
            r9.<init>(r5, r6, r7)
            r7.f615o = r9
            java.lang.CharSequence r5 = r7.e
            r9.setHeaderTitle(r5)
        L_0x0088:
            androidx.appcompat.view.menu.m r7 = r7.f615o
            if (r4 == 0) goto L_0x008f
            r3.f(r7)
        L_0x008f:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.appcompat.view.menu.j>> r9 = r6.f596u
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0098
            goto L_0x00c5
        L_0x0098:
            if (r8 == 0) goto L_0x009e
            boolean r0 = r8.h(r7)
        L_0x009e:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.appcompat.view.menu.j>> r8 = r6.f596u
            java.util.Iterator r8 = r8.iterator()
        L_0x00a4:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00c5
            java.lang.Object r9 = r8.next()
            java.lang.ref.WeakReference r9 = (java.lang.ref.WeakReference) r9
            java.lang.Object r3 = r9.get()
            androidx.appcompat.view.menu.j r3 = (androidx.appcompat.view.menu.j) r3
            if (r3 != 0) goto L_0x00be
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.appcompat.view.menu.j>> r3 = r6.f596u
            r3.remove(r9)
            goto L_0x00a4
        L_0x00be:
            if (r0 != 0) goto L_0x00a4
            boolean r0 = r3.h(r7)
            goto L_0x00a4
        L_0x00c5:
            r1 = r1 | r0
            if (r1 != 0) goto L_0x00cb
        L_0x00c8:
            r6.c(r2)
        L_0x00cb:
            return r1
        L_0x00cc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.f.q(android.view.MenuItem, androidx.appcompat.view.menu.j, int):boolean");
    }

    public final void r(j jVar) {
        Iterator<WeakReference<j>> it = this.f596u.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar2 = next.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f596u.remove(next);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i7) {
        int size = size();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                i9 = -1;
                break;
            } else if (this.f583f.get(i9).f604b == i7) {
                break;
            } else {
                i9++;
            }
        }
        if (i9 >= 0) {
            int size2 = this.f583f.size() - i9;
            while (true) {
                i8++;
                if (i8 >= size2 || this.f583f.get(i9).f604b != i7) {
                    break;
                } else if (i9 >= 0 && i9 < this.f583f.size()) {
                    this.f583f.remove(i9);
                }
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i7) {
        int size = size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                i8 = -1;
                break;
            } else if (this.f583f.get(i8).f603a == i7) {
                break;
            } else {
                i8++;
            }
        }
        if (i8 >= 0 && i8 < this.f583f.size()) {
            this.f583f.remove(i8);
            p(true);
        }
    }

    public final void s(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
            int size = size();
            for (int i7 = 0; i7 < size; i7++) {
                MenuItem item = getItem(i7);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((m) item.getSubMenu()).s(bundle);
                }
            }
            int i8 = bundle.getInt("android:menu:expandedactionview");
            if (i8 > 0 && (findItem = findItem(i8)) != null) {
                findItem.expandActionView();
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i7, boolean z6, boolean z7) {
        int size = this.f583f.size();
        for (int i8 = 0; i8 < size; i8++) {
            h hVar = this.f583f.get(i8);
            if (hVar.f604b == i7) {
                hVar.f623x = (hVar.f623x & -5) | (z7 ? 4 : 0);
                hVar.setCheckable(z6);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z6) {
        this.f598w = z6;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i7, boolean z6) {
        int size = this.f583f.size();
        for (int i8 = 0; i8 < size; i8++) {
            h hVar = this.f583f.get(i8);
            if (hVar.f604b == i7) {
                hVar.setEnabled(z6);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i7, boolean z6) {
        int size = this.f583f.size();
        boolean z7 = false;
        for (int i8 = 0; i8 < size; i8++) {
            h hVar = this.f583f.get(i8);
            if (hVar.f604b == i7) {
                int i9 = hVar.f623x;
                int i10 = (i9 & -9) | (z6 ? 0 : 8);
                hVar.f623x = i10;
                if (i9 != i10) {
                    z7 = true;
                }
            }
        }
        if (z7) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z6) {
        this.f581c = z6;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f583f.size();
    }

    public final void t(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i7 = 0; i7 < size; i7++) {
            MenuItem item = getItem(i7);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i7, CharSequence charSequence, int i8, Drawable drawable, View view) {
        Resources resources = this.f580b;
        if (view != null) {
            this.f591o = view;
            this.m = null;
            this.f590n = null;
        } else {
            if (i7 > 0) {
                this.m = resources.getText(i7);
            } else if (charSequence != null) {
                this.m = charSequence;
            }
            if (i8 > 0) {
                Context context = this.f579a;
                Object obj = g1.a.f4192a;
                this.f590n = a.c.b(context, i8);
            } else if (drawable != null) {
                this.f590n = drawable;
            }
            this.f591o = null;
        }
        p(false);
    }

    public final void v() {
        this.f592p = false;
        if (this.f593q) {
            this.f593q = false;
            p(this.f594r);
        }
    }

    public final void w() {
        if (!this.f592p) {
            this.f592p = true;
            this.f593q = false;
            this.f594r = false;
        }
    }
}
