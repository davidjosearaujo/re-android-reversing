package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.f;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a */
    public final HashMap f446a = new HashMap();

    /* renamed from: b */
    public final HashMap f447b = new HashMap();

    /* renamed from: c */
    public final HashMap f448c = new HashMap();

    /* renamed from: d */
    public ArrayList<String> f449d = new ArrayList<>();
    public final transient HashMap e = new HashMap();

    /* renamed from: f */
    public final HashMap f450f = new HashMap();

    /* renamed from: g */
    public final Bundle f451g = new Bundle();

    /* loaded from: classes.dex */
    public static class a<O> {

        /* renamed from: a */
        public final androidx.activity.result.b<O> f452a;

        /* renamed from: b */
        public final d.a<?, O> f453b;

        public a(androidx.activity.result.b<O> bVar, d.a<?, O> aVar) {
            this.f452a = bVar;
            this.f453b = aVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final androidx.lifecycle.g f454a;

        /* renamed from: b */
        public final ArrayList<l> f455b = new ArrayList<>();

        public b(androidx.lifecycle.g gVar) {
            this.f454a = gVar;
        }
    }

    public final boolean a(int i7, int i8, Intent intent) {
        String str = (String) this.f446a.get(Integer.valueOf(i7));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.e.get(str);
        if (aVar == null || aVar.f452a == null || !this.f449d.contains(str)) {
            this.f450f.remove(str);
            this.f451g.putParcelable(str, new androidx.activity.result.a(intent, i8));
            return true;
        }
        aVar.f452a.a(aVar.f453b.c(intent, i8));
        this.f449d.remove(str);
        return true;
    }

    public abstract void b(int i7, d.a aVar, @SuppressLint({"UnknownNullness"}) Object obj);

    public final d c(final String str, n nVar, final d.a aVar, final androidx.activity.result.b bVar) {
        o k6 = nVar.k();
        if (k6.f1876d.compareTo(g.b.STARTED) >= 0) {
            throw new IllegalStateException("LifecycleOwner " + nVar + " is attempting to register while current state is " + k6.f1876d + ". LifecycleOwners must call register before they are STARTED.");
        }
        e(str);
        b bVar2 = (b) this.f448c.get(str);
        if (bVar2 == null) {
            bVar2 = new b(k6);
        }
        l lVar = new l() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.l
            public final void c(n nVar2, g.a aVar2) {
                if (!g.a.ON_START.equals(aVar2)) {
                    if (g.a.ON_STOP.equals(aVar2)) {
                        f.this.e.remove(str);
                        return;
                    } else if (g.a.ON_DESTROY.equals(aVar2)) {
                        f.this.f(str);
                        return;
                    } else {
                        return;
                    }
                }
                f.this.e.put(str, new f.a(bVar, aVar));
                if (f.this.f450f.containsKey(str)) {
                    Object obj = f.this.f450f.get(str);
                    f.this.f450f.remove(str);
                    bVar.a(obj);
                }
                a aVar3 = (a) f.this.f451g.getParcelable(str);
                if (aVar3 != null) {
                    f.this.f451g.remove(str);
                    bVar.a(aVar.c(aVar3.f440g, aVar3.f439f));
                }
            }
        };
        bVar2.f454a.a(lVar);
        bVar2.f455b.add(lVar);
        this.f448c.put(str, bVar2);
        return new d(this, str, aVar);
    }

    public final e d(String str, d.a aVar, androidx.activity.result.b bVar) {
        e(str);
        this.e.put(str, new a(bVar, aVar));
        if (this.f450f.containsKey(str)) {
            Object obj = this.f450f.get(str);
            this.f450f.remove(str);
            bVar.a(obj);
        }
        androidx.activity.result.a aVar2 = (androidx.activity.result.a) this.f451g.getParcelable(str);
        if (aVar2 != null) {
            this.f451g.remove(str);
            bVar.a(aVar.c(aVar2.f440g, aVar2.f439f));
        }
        return new e(this, str, aVar);
    }

    public final void e(String str) {
        if (((Integer) this.f447b.get(str)) != null) {
            return;
        }
        u5.c.f6119f.getClass();
        int nextInt = u5.c.f6120g.a().nextInt(2147418112);
        while (true) {
            int i7 = nextInt + 65536;
            if (!this.f446a.containsKey(Integer.valueOf(i7))) {
                this.f446a.put(Integer.valueOf(i7), str);
                this.f447b.put(str, Integer.valueOf(i7));
                return;
            }
            u5.c.f6119f.getClass();
            nextInt = u5.c.f6120g.a().nextInt(2147418112);
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.f449d.contains(str) && (num = (Integer) this.f447b.remove(str)) != null) {
            this.f446a.remove(num);
        }
        this.e.remove(str);
        if (this.f450f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f450f.get(str));
            this.f450f.remove(str);
        }
        if (this.f451g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f451g.getParcelable(str));
            this.f451g.remove(str);
        }
        b bVar = (b) this.f448c.get(str);
        if (bVar != null) {
            Iterator<l> it = bVar.f455b.iterator();
            while (it.hasNext()) {
                bVar.f454a.c(it.next());
            }
            bVar.f455b.clear();
            this.f448c.remove(str);
        }
    }
}
