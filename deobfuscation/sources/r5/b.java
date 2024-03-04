package r5;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class b implements x5.a, Serializable {

    /* renamed from: f */
    public transient x5.a f5910f;

    /* renamed from: g */
    public final Object f5911g;

    /* renamed from: h */
    public final Class f5912h;

    /* renamed from: i */
    public final String f5913i;

    /* renamed from: j */
    public final String f5914j;

    /* renamed from: k */
    public final boolean f5915k;

    /* loaded from: classes.dex */
    public static class a implements Serializable {

        /* renamed from: f */
        public static final a f5916f = new a();
    }

    public b(Object obj, Class cls, String str, String str2, boolean z6) {
        this.f5911g = obj;
        this.f5912h = cls;
        this.f5913i = str;
        this.f5914j = str2;
        this.f5915k = z6;
    }

    public abstract x5.a a();

    public final c b() {
        Class cls = this.f5912h;
        if (cls == null) {
            return null;
        }
        if (this.f5915k) {
            t.f5928a.getClass();
            return new m(cls);
        }
        return t.a(cls);
    }
}
