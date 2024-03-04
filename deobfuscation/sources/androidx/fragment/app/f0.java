package androidx.fragment.app;

import androidx.lifecycle.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: b */
    public int f1625b;

    /* renamed from: c */
    public int f1626c;

    /* renamed from: d */
    public int f1627d;
    public int e;

    /* renamed from: f */
    public int f1628f;

    /* renamed from: g */
    public boolean f1629g;

    /* renamed from: h */
    public String f1630h;

    /* renamed from: i */
    public int f1631i;

    /* renamed from: j */
    public CharSequence f1632j;

    /* renamed from: k */
    public int f1633k;

    /* renamed from: l */
    public CharSequence f1634l;
    public ArrayList<String> m;

    /* renamed from: n */
    public ArrayList<String> f1635n;

    /* renamed from: a */
    public ArrayList<a> f1624a = new ArrayList<>();

    /* renamed from: o */
    public boolean f1636o = false;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public int f1637a;

        /* renamed from: b */
        public n f1638b;

        /* renamed from: c */
        public int f1639c;

        /* renamed from: d */
        public int f1640d;
        public int e;

        /* renamed from: f */
        public int f1641f;

        /* renamed from: g */
        public g.b f1642g;

        /* renamed from: h */
        public g.b f1643h;

        public a() {
        }

        public a(int i7, n nVar) {
            this.f1637a = i7;
            this.f1638b = nVar;
            g.b bVar = g.b.RESUMED;
            this.f1642g = bVar;
            this.f1643h = bVar;
        }
    }

    public final void b(a aVar) {
        this.f1624a.add(aVar);
        aVar.f1639c = this.f1625b;
        aVar.f1640d = this.f1626c;
        aVar.e = this.f1627d;
        aVar.f1641f = this.e;
    }
}
