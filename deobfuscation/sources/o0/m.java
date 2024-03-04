package o0;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a */
    public static final q<List<String>> f5246a = new q<>("ContentDescription", a.f5259g);

    /* renamed from: b */
    public static final q<String> f5247b;

    /* renamed from: c */
    public static final q<Object> f5248c;

    /* renamed from: d */
    public static final q<String> f5249d;
    public static final q<Boolean> e;

    /* renamed from: f */
    public static final q<f5.g> f5250f;

    /* renamed from: g */
    public static final q<o0.d> f5251g;

    /* renamed from: h */
    public static final q<o0.d> f5252h;

    /* renamed from: i */
    public static final q<o0.c> f5253i;

    /* renamed from: j */
    public static final q<List<p0.a>> f5254j;

    /* renamed from: k */
    public static final q<p0.a> f5255k;

    /* renamed from: l */
    public static final q<p0.c> f5256l;
    public static final q<Boolean> m;

    /* renamed from: n */
    public static final q<Object> f5257n;

    /* renamed from: o */
    public static final q<f5.g> f5258o;

    /* loaded from: classes.dex */
    public static final class a extends r5.i implements q5.p<List<? extends String>, List<? extends String>, List<? extends String>> {

        /* renamed from: g */
        public static final a f5259g = new a();

        public a() {
            super(2);
        }

        @Override // q5.p
        public final List<? extends String> i(List<? extends String> list, List<? extends String> list2) {
            List<? extends String> list3 = list;
            List<? extends String> list4 = list2;
            r5.h.f(list4, "childValue");
            if (list3 != null) {
                ArrayList c02 = g5.n.c0(list3);
                c02.addAll(list4);
                return c02;
            }
            return list4;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends r5.i implements q5.p<f5.g, f5.g, f5.g> {

        /* renamed from: g */
        public static final b f5260g = new b();

        public b() {
            super(2);
        }

        @Override // q5.p
        public final f5.g i(f5.g gVar, f5.g gVar2) {
            f5.g gVar3 = gVar;
            r5.h.f(gVar2, "<anonymous parameter 1>");
            return gVar3;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends r5.i implements q5.p<String, String, String> {

        /* renamed from: g */
        public static final c f5261g = new c();

        public c() {
            super(2);
        }

        @Override // q5.p
        public final String i(String str, String str2) {
            r5.h.f(str2, "<anonymous parameter 1>");
            throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends r5.i implements q5.p<o0.c, o0.c, o0.c> {

        /* renamed from: g */
        public static final d f5262g = new d();

        public d() {
            super(2);
        }

        @Override // q5.p
        public final o0.c i(o0.c cVar, o0.c cVar2) {
            o0.c cVar3 = cVar;
            int i7 = cVar2.f5228a;
            return cVar3;
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends r5.i implements q5.p<String, String, String> {

        /* renamed from: g */
        public static final e f5263g = new e();

        public e() {
            super(2);
        }

        @Override // q5.p
        public final String i(String str, String str2) {
            String str3 = str;
            r5.h.f(str2, "<anonymous parameter 1>");
            return str3;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends r5.i implements q5.p<List<? extends p0.a>, List<? extends p0.a>, List<? extends p0.a>> {

        /* renamed from: g */
        public static final f f5264g = new f();

        public f() {
            super(2);
        }

        @Override // q5.p
        public final List<? extends p0.a> i(List<? extends p0.a> list, List<? extends p0.a> list2) {
            List<? extends p0.a> list3 = list;
            List<? extends p0.a> list4 = list2;
            r5.h.f(list4, "childValue");
            if (list3 != null) {
                ArrayList c02 = g5.n.c0(list3);
                c02.addAll(list4);
                return c02;
            }
            return list4;
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends r5.i implements q5.p<Float, Float, Float> {

        /* renamed from: g */
        public static final g f5265g = new g();

        public g() {
            super(2);
        }

        @Override // q5.p
        public final Float i(Float f7, Float f8) {
            Float f9 = f7;
            f8.floatValue();
            return f9;
        }
    }

    static {
        p pVar = p.f5268g;
        f5247b = new q<>("StateDescription", pVar);
        f5248c = new q<>("ProgressBarRangeInfo", pVar);
        f5249d = new q<>("PaneTitle", c.f5261g);
        new q("SelectableGroup", pVar);
        new q("CollectionInfo", pVar);
        new q("CollectionItemInfo", pVar);
        new q("Heading", pVar);
        new q("Disabled", pVar);
        new q("LiveRegion", pVar);
        e = new q<>("Focused", pVar);
        new q("IsTraversalGroup", pVar);
        f5250f = new q<>("InvisibleToUser", b.f5260g);
        new q("TraversalIndex", g.f5265g);
        f5251g = new q<>("HorizontalScrollAxisRange", pVar);
        f5252h = new q<>("VerticalScrollAxisRange", pVar);
        f5253i = new q<>("Role", d.f5262g);
        new q("TestTag", e.f5263g);
        f5254j = new q<>("Text", f.f5264g);
        f5255k = new q<>("EditableText", pVar);
        f5256l = new q<>("TextSelectionRange", pVar);
        m = new q<>("Selected", pVar);
        f5257n = new q<>("ToggleableState", pVar);
        f5258o = new q<>("Password", pVar);
        new q("Error", pVar);
    }
}
