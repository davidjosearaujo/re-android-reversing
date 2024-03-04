package i;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.a1;
import androidx.appcompat.widget.h0;
import androidx.fragment.app.s0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
import p1.i;

/* loaded from: classes.dex */
public final class f extends MenuInflater {
    public static final Class<?>[] e;

    /* renamed from: f */
    public static final Class<?>[] f4421f;

    /* renamed from: a */
    public final Object[] f4422a;

    /* renamed from: b */
    public final Object[] f4423b;

    /* renamed from: c */
    public Context f4424c;

    /* renamed from: d */
    public Object f4425d;

    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c */
        public static final Class<?>[] f4426c = {MenuItem.class};

        /* renamed from: a */
        public Object f4427a;

        /* renamed from: b */
        public Method f4428b;

        public a(Object obj, String str) {
            this.f4427a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f4428b = cls.getMethod(str, f4426c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f4428b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f4428b.invoke(this.f4427a, menuItem)).booleanValue();
                }
                this.f4428b.invoke(this.f4427a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public CharSequence A;
        public CharSequence B;

        /* renamed from: a */
        public Menu f4429a;

        /* renamed from: h */
        public boolean f4435h;

        /* renamed from: i */
        public int f4436i;

        /* renamed from: j */
        public int f4437j;

        /* renamed from: k */
        public CharSequence f4438k;

        /* renamed from: l */
        public CharSequence f4439l;
        public int m;

        /* renamed from: n */
        public char f4440n;

        /* renamed from: o */
        public int f4441o;

        /* renamed from: p */
        public char f4442p;

        /* renamed from: q */
        public int f4443q;

        /* renamed from: r */
        public int f4444r;
        public boolean s;

        /* renamed from: t */
        public boolean f4445t;

        /* renamed from: u */
        public boolean f4446u;

        /* renamed from: v */
        public int f4447v;

        /* renamed from: w */
        public int f4448w;

        /* renamed from: x */
        public String f4449x;

        /* renamed from: y */
        public String f4450y;

        /* renamed from: z */
        public p1.b f4451z;
        public ColorStateList C = null;
        public PorterDuff.Mode D = null;

        /* renamed from: b */
        public int f4430b = 0;

        /* renamed from: c */
        public int f4431c = 0;

        /* renamed from: d */
        public int f4432d = 0;
        public int e = 0;

        /* renamed from: f */
        public boolean f4433f = true;

        /* renamed from: g */
        public boolean f4434g = true;

        public b(Menu menu) {
            f.this = r1;
            this.f4429a = menu;
        }

        public final <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, f.this.f4424c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        public final void b(MenuItem menuItem) {
            boolean z6 = false;
            menuItem.setChecked(this.s).setVisible(this.f4445t).setEnabled(this.f4446u).setCheckable(this.f4444r >= 1).setTitleCondensed(this.f4439l).setIcon(this.m);
            int i7 = this.f4447v;
            if (i7 >= 0) {
                menuItem.setShowAsAction(i7);
            }
            if (this.f4450y != null) {
                if (f.this.f4424c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                f fVar = f.this;
                if (fVar.f4425d == null) {
                    fVar.f4425d = f.a(fVar.f4424c);
                }
                menuItem.setOnMenuItemClickListener(new a(fVar.f4425d, this.f4450y));
            }
            if (this.f4444r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.h) {
                    androidx.appcompat.view.menu.h hVar = (androidx.appcompat.view.menu.h) menuItem;
                    hVar.f623x = (hVar.f623x & (-5)) | 4;
                } else if (menuItem instanceof j.c) {
                    j.c cVar = (j.c) menuItem;
                    try {
                        if (cVar.e == null) {
                            cVar.e = cVar.f4559d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        cVar.e.invoke(cVar.f4559d, Boolean.TRUE);
                    } catch (Exception e) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                    }
                }
            }
            String str = this.f4449x;
            if (str != null) {
                menuItem.setActionView((View) a(str, f.e, f.this.f4422a));
                z6 = true;
            }
            int i8 = this.f4448w;
            if (i8 > 0) {
                if (z6) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i8);
                }
            }
            p1.b bVar = this.f4451z;
            if (bVar != null) {
                if (menuItem instanceof k1.b) {
                    ((k1.b) menuItem).a(bVar);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.A;
            boolean z7 = menuItem instanceof k1.b;
            if (z7) {
                ((k1.b) menuItem).setContentDescription(charSequence);
            } else {
                i.h(menuItem, charSequence);
            }
            CharSequence charSequence2 = this.B;
            if (z7) {
                ((k1.b) menuItem).setTooltipText(charSequence2);
            } else {
                i.m(menuItem, charSequence2);
            }
            char c7 = this.f4440n;
            int i9 = this.f4441o;
            if (z7) {
                ((k1.b) menuItem).setAlphabeticShortcut(c7, i9);
            } else {
                i.g(menuItem, c7, i9);
            }
            char c8 = this.f4442p;
            int i10 = this.f4443q;
            if (z7) {
                ((k1.b) menuItem).setNumericShortcut(c8, i10);
            } else {
                i.k(menuItem, c8, i10);
            }
            PorterDuff.Mode mode = this.D;
            if (mode != null) {
                if (z7) {
                    ((k1.b) menuItem).setIconTintMode(mode);
                } else {
                    i.j(menuItem, mode);
                }
            }
            ColorStateList colorStateList = this.C;
            if (colorStateList != null) {
                if (z7) {
                    ((k1.b) menuItem).setIconTintList(colorStateList);
                } else {
                    i.i(menuItem, colorStateList);
                }
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        e = clsArr;
        f4421f = clsArr;
    }

    public f(Context context) {
        super(context);
        this.f4424c = context;
        Object[] objArr = {context};
        this.f4422a = objArr;
        this.f4423b = objArr;
    }

    public static Object a(Context context) {
        return (!(context instanceof Activity) && (context instanceof ContextWrapper)) ? a(((ContextWrapper) context).getBaseContext()) : context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) {
        p1.b bVar;
        ColorStateList colorStateList;
        b bVar2 = new b(menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException(s0.h("Expecting menu, got ", name));
                }
                eventType = xmlResourceParser.next();
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        String str = null;
        boolean z6 = false;
        boolean z7 = false;
        while (!z6) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlResourceParser.getName();
                    if (z7 && name2.equals(str)) {
                        str = null;
                        z7 = false;
                    } else if (name2.equals("group")) {
                        bVar2.f4430b = 0;
                        bVar2.f4431c = 0;
                        bVar2.f4432d = 0;
                        bVar2.e = 0;
                        bVar2.f4433f = true;
                        bVar2.f4434g = true;
                    } else if (name2.equals("item")) {
                        if (!bVar2.f4435h) {
                            p1.b bVar3 = bVar2.f4451z;
                            if (bVar3 == null || !bVar3.a()) {
                                bVar2.f4435h = true;
                                bVar2.b(bVar2.f4429a.add(bVar2.f4430b, bVar2.f4436i, bVar2.f4437j, bVar2.f4438k));
                            } else {
                                bVar2.f4435h = true;
                                bVar2.b(bVar2.f4429a.addSubMenu(bVar2.f4430b, bVar2.f4436i, bVar2.f4437j, bVar2.f4438k).getItem());
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z6 = true;
                    }
                }
            } else if (!z7) {
                String name3 = xmlResourceParser.getName();
                if (name3.equals("group")) {
                    TypedArray obtainStyledAttributes = f.this.f4424c.obtainStyledAttributes(attributeSet, a0.e.L);
                    bVar2.f4430b = obtainStyledAttributes.getResourceId(1, 0);
                    bVar2.f4431c = obtainStyledAttributes.getInt(3, 0);
                    bVar2.f4432d = obtainStyledAttributes.getInt(4, 0);
                    bVar2.e = obtainStyledAttributes.getInt(5, 0);
                    bVar2.f4433f = obtainStyledAttributes.getBoolean(2, true);
                    bVar2.f4434g = obtainStyledAttributes.getBoolean(0, true);
                    obtainStyledAttributes.recycle();
                } else if (name3.equals("item")) {
                    Context context = f.this.f4424c;
                    a1 a1Var = new a1(context, context.obtainStyledAttributes(attributeSet, a0.e.M));
                    bVar2.f4436i = a1Var.i(2, 0);
                    bVar2.f4437j = (a1Var.h(5, bVar2.f4431c) & (-65536)) | (a1Var.h(6, bVar2.f4432d) & 65535);
                    bVar2.f4438k = a1Var.k(7);
                    bVar2.f4439l = a1Var.k(8);
                    bVar2.m = a1Var.i(0, 0);
                    String j5 = a1Var.j(9);
                    bVar2.f4440n = j5 == null ? (char) 0 : j5.charAt(0);
                    bVar2.f4441o = a1Var.h(16, 4096);
                    String j7 = a1Var.j(10);
                    bVar2.f4442p = j7 == null ? (char) 0 : j7.charAt(0);
                    bVar2.f4443q = a1Var.h(20, 4096);
                    bVar2.f4444r = a1Var.l(11) ? a1Var.a(11, false) : bVar2.e;
                    bVar2.s = a1Var.a(3, false);
                    bVar2.f4445t = a1Var.a(4, bVar2.f4433f);
                    bVar2.f4446u = a1Var.a(1, bVar2.f4434g);
                    bVar2.f4447v = a1Var.h(21, -1);
                    bVar2.f4450y = a1Var.j(12);
                    bVar2.f4448w = a1Var.i(13, 0);
                    bVar2.f4449x = a1Var.j(15);
                    String j8 = a1Var.j(14);
                    boolean z8 = j8 != null;
                    if (z8 && bVar2.f4448w == 0 && bVar2.f4449x == null) {
                        bVar = (p1.b) bVar2.a(j8, f4421f, f.this.f4423b);
                    } else {
                        if (z8) {
                            Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                        }
                        bVar = null;
                    }
                    bVar2.f4451z = bVar;
                    bVar2.A = a1Var.k(17);
                    bVar2.B = a1Var.k(22);
                    if (a1Var.l(19)) {
                        bVar2.D = h0.b(a1Var.h(19, -1), bVar2.D);
                        colorStateList = null;
                    } else {
                        colorStateList = null;
                        bVar2.D = null;
                    }
                    if (a1Var.l(18)) {
                        colorStateList = a1Var.b(18);
                    }
                    bVar2.C = colorStateList;
                    a1Var.n();
                    bVar2.f4435h = false;
                } else if (name3.equals("menu")) {
                    bVar2.f4435h = true;
                    SubMenu addSubMenu = bVar2.f4429a.addSubMenu(bVar2.f4430b, bVar2.f4436i, bVar2.f4437j, bVar2.f4438k);
                    bVar2.b(addSubMenu.getItem());
                    b(xmlResourceParser, attributeSet, addSubMenu);
                } else {
                    str = name3;
                    z7 = true;
                }
            }
            eventType = xmlResourceParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i7, Menu menu) {
        if (!(menu instanceof k1.a)) {
            super.inflate(i7, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f4424c.getResources().getLayout(i7);
                    b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (IOException e7) {
                    throw new InflateException("Error inflating menu XML", e7);
                }
            } catch (XmlPullParserException e8) {
                throw new InflateException("Error inflating menu XML", e8);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
