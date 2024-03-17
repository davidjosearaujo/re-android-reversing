package com.hunantv.imgo.yaml.representer;

import com.hunantv.imgo.yaml.DumperOptions;
import j.l.a.d0.l.e;
import j.l.a.d0.m.c;
import j.l.a.d0.m.d;
import j.l.a.d0.m.f;
import j.l.a.d0.m.g;
import j.l.a.d0.m.h;
import j.l.a.d0.p.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class BaseRepresenter {
    public a b;
    public Character d;
    public Object g;
    private e h;
    public final Map<Class<?>, a> a = new HashMap();
    public final Map<Class<?>, a> c = new LinkedHashMap();
    public DumperOptions.FlowStyle e = DumperOptions.FlowStyle.AUTO;
    public final Map<Object, d> f = new IdentityHashMap<Object, d>() { // from class: com.hunantv.imgo.yaml.representer.BaseRepresenter.1
        private static final long serialVersionUID = -5576159264232131854L;

        @Override // java.util.IdentityHashMap, java.util.AbstractMap, java.util.Map
        public d put(Object obj, d dVar) {
            return (d) super.put((AnonymousClass1) obj, (Object) new j.l.a.d0.m.a(dVar));
        }
    };
    private boolean i = false;

    public DumperOptions.FlowStyle a() {
        return this.e;
    }

    public final e b() {
        if (this.h == null) {
            this.h = new e();
        }
        return this.h;
    }

    public final boolean c() {
        return this.i;
    }

    public d d(Object obj) {
        d e = e(obj);
        this.f.clear();
        this.g = null;
        return e;
    }

    public final d e(Object obj) {
        this.g = obj;
        if (this.f.containsKey(obj)) {
            return this.f.get(this.g);
        }
        if (obj == null) {
            return this.b.a((Object) null);
        }
        Class<?> cls = obj.getClass();
        if (this.a.containsKey(cls)) {
            return this.a.get(cls).a(obj);
        }
        for (Class<?> cls2 : this.c.keySet()) {
            if (cls2.isInstance(obj)) {
                return this.c.get(cls2).a(obj);
            }
        }
        if (this.c.containsKey(null)) {
            return this.c.get(null).a(obj);
        }
        return this.a.get(null).a(obj);
    }

    public d f(h hVar, Map<?, ?> map, Boolean bool) {
        ArrayList arrayList = new ArrayList(map.size());
        d cVar = new c(hVar, arrayList, bool);
        this.f.put(this.g, cVar);
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            f e = e(entry.getKey());
            f e2 = e(entry.getValue());
            z = ((e instanceof f) && e.m() == null) ? false : false;
            if (!(e2 instanceof f) || e2.m() != null) {
                z = false;
            }
            arrayList.add(new j.l.a.d0.m.e(e, e2));
        }
        if (bool == null) {
            DumperOptions.FlowStyle flowStyle = this.e;
            if (flowStyle != DumperOptions.FlowStyle.AUTO) {
                cVar.o(flowStyle.getStyleBoolean());
            } else {
                cVar.o(Boolean.valueOf(z));
            }
        }
        return cVar;
    }

    public d g(h hVar, String str) {
        return h(hVar, str, null);
    }

    public d h(h hVar, String str, Character ch) {
        if (ch == null) {
            ch = this.d;
        }
        return new f(hVar, str, (j.l.a.d0.i.a) null, (j.l.a.d0.i.a) null, ch);
    }

    public d i(h hVar, Iterable<?> iterable, Boolean bool) {
        ArrayList arrayList = new ArrayList(iterable instanceof List ? ((List) iterable).size() : 10);
        d gVar = new g(hVar, arrayList, bool);
        this.f.put(this.g, gVar);
        boolean z = true;
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            f e = e(it.next());
            if (!(e instanceof f) || e.m() != null) {
                z = false;
            }
            arrayList.add(e);
        }
        if (bool == null) {
            DumperOptions.FlowStyle flowStyle = this.e;
            if (flowStyle != DumperOptions.FlowStyle.AUTO) {
                gVar.o(flowStyle.getStyleBoolean());
            } else {
                gVar.o(Boolean.valueOf(z));
            }
        }
        return gVar;
    }

    public void j(DumperOptions.FlowStyle flowStyle) {
        this.e = flowStyle;
    }

    public void k(DumperOptions.ScalarStyle scalarStyle) {
        this.d = scalarStyle.getChar();
    }

    public void l(e eVar) {
        this.h = eVar;
        this.i = true;
    }
}
