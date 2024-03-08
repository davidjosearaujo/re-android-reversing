package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.lifecycle.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import p.b;
import p.c0;
import p.e0;
import p.m;
import p.p0;
import p.v;
import q5.l;
import q5.p;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final m f1159a = new m(p0.f5447a, a.f1164g);

    /* renamed from: b  reason: collision with root package name */
    public static final m f1160b = new m(b.f1165g);

    /* renamed from: c  reason: collision with root package name */
    public static final m f1161c = new m(c.f1166g);

    /* renamed from: d  reason: collision with root package name */
    public static final m f1162d = new m(d.f1167g);
    public static final m e = new m(e.f1168g);

    /* renamed from: f  reason: collision with root package name */
    public static final m f1163f = new m(f.f1169g);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends r5.i implements q5.a<Configuration> {

        /* renamed from: g  reason: collision with root package name */
        public static final a f1164g = new a();

        public a() {
            super(0);
        }

        @Override // q5.a
        public final Configuration d() {
            h.b("LocalConfiguration");
            throw null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b extends r5.i implements q5.a<Context> {

        /* renamed from: g  reason: collision with root package name */
        public static final b f1165g = new b();

        public b() {
            super(0);
        }

        @Override // q5.a
        public final Context d() {
            h.b("LocalContext");
            throw null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c extends r5.i implements q5.a<n0.a> {

        /* renamed from: g  reason: collision with root package name */
        public static final c f1166g = new c();

        public c() {
            super(0);
        }

        @Override // q5.a
        public final n0.a d() {
            h.b("LocalImageVectorCache");
            throw null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class d extends r5.i implements q5.a<n> {

        /* renamed from: g  reason: collision with root package name */
        public static final d f1167g = new d();

        public d() {
            super(0);
        }

        @Override // q5.a
        public final n d() {
            h.b("LocalLifecycleOwner");
            throw null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class e extends r5.i implements q5.a<h2.c> {

        /* renamed from: g  reason: collision with root package name */
        public static final e f1168g = new e();

        public e() {
            super(0);
        }

        @Override // q5.a
        public final h2.c d() {
            h.b("LocalSavedStateRegistryOwner");
            throw null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class f extends r5.i implements q5.a<View> {

        /* renamed from: g  reason: collision with root package name */
        public static final f f1169g = new f();

        public f() {
            super(0);
        }

        @Override // q5.a
        public final View d() {
            h.b("LocalView");
            throw null;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class g extends r5.i implements l<Configuration, f5.g> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ v<Configuration> f1170g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(v<Configuration> vVar) {
            super(1);
            this.f1170g = vVar;
        }

        @Override // q5.l
        public final f5.g k(Configuration configuration) {
            Configuration configuration2 = configuration;
            r5.h.f(configuration2, "it");
            this.f1170g.setValue(new Configuration(configuration2));
            return f5.g.f4141a;
        }
    }

    /* renamed from: androidx.compose.ui.platform.h$h  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0011h extends r5.i implements l<p.l, Object> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ p f1171g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0011h(p pVar) {
            super(1);
            this.f1171g = pVar;
        }

        @Override // q5.l
        public final Object k(p.l lVar) {
            r5.h.f(lVar, "$this$DisposableEffect");
            return new a0.e(this.f1171g);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class i extends r5.i implements p<p.b, Integer, f5.g> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AndroidComposeView f1172g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ k f1173h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ p<p.b, Integer, f5.g> f1174i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f1175j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public i(AndroidComposeView androidComposeView, k kVar, p<? super p.b, ? super Integer, f5.g> pVar, int i7) {
            super(2);
            this.f1172g = androidComposeView;
            this.f1173h = kVar;
            this.f1174i = pVar;
            this.f1175j = i7;
        }

        @Override // q5.p
        public final f5.g i(p.b bVar, Integer num) {
            p.b bVar2 = bVar;
            if ((num.intValue() & 11) != 2 || !bVar2.k()) {
                int i7 = p.d.f5425a;
                o.a(this.f1172g, this.f1173h, this.f1174i, bVar2, ((this.f1175j << 3) & 896) | 72);
            } else {
                bVar2.c();
            }
            return f5.g.f4141a;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class j extends r5.i implements p<p.b, Integer, f5.g> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AndroidComposeView f1176g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ p<p.b, Integer, f5.g> f1177h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f1178i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public j(AndroidComposeView androidComposeView, p<? super p.b, ? super Integer, f5.g> pVar, int i7) {
            super(2);
            this.f1176g = androidComposeView;
            this.f1177h = pVar;
            this.f1178i = i7;
        }

        @Override // q5.p
        public final f5.g i(p.b bVar, Integer num) {
            num.intValue();
            h.a(this.f1176g, this.f1177h, bVar, a0.e.K(this.f1178i | 1));
            return f5.g.f4141a;
        }
    }

    public static final void a(AndroidComposeView androidComposeView, p<? super p.b, ? super Integer, f5.g> pVar, p.b bVar, int i7) {
        LinkedHashMap linkedHashMap;
        boolean z6;
        r5.h.f(androidComposeView, "owner");
        r5.h.f(pVar, "content");
        p.c i8 = bVar.i(1396852028);
        Context context = androidComposeView.getContext();
        i8.s(-492369756, null, null);
        Object r6 = i8.r();
        b.a.C0090a aVar = b.a.f5423a;
        if (r6 == aVar) {
            r6 = a0.b.s(new Configuration(context.getResources().getConfiguration()));
            i8.u(r6);
        }
        i8.o();
        v vVar = (v) r6;
        i8.s(1157296644, null, null);
        boolean m = i8.m(vVar);
        Object r7 = i8.r();
        if (m || r7 == aVar) {
            r7 = new g(vVar);
            i8.u(r7);
        }
        i8.o();
        androidComposeView.setConfigurationChangeObserver((l) r7);
        i8.s(-492369756, null, null);
        Object r8 = i8.r();
        if (r8 == aVar) {
            r5.h.e(context, "context");
            r8 = new k(context);
            i8.u(r8);
        }
        i8.o();
        k kVar = (k) r8;
        AndroidComposeView.b viewTreeOwners = androidComposeView.getViewTreeOwners();
        if (viewTreeOwners != null) {
            i8.s(-492369756, null, null);
            Object r9 = i8.r();
            if (r9 == aVar) {
                h2.c cVar = viewTreeOwners.f1124b;
                Class<? extends Object>[] clsArr = t.f1238a;
                r5.h.f(cVar, "owner");
                ViewParent parent = androidComposeView.getParent();
                r5.h.d(parent, "null cannot be cast to non-null type android.view.View");
                View view = (View) parent;
                Object tag = view.getTag(2131296394);
                String str = tag instanceof String ? (String) tag : null;
                if (str == null) {
                    str = String.valueOf(view.getId());
                }
                r5.h.f(str, "id");
                String str2 = u.a.class.getSimpleName() + ':' + str;
                androidx.savedstate.a b2 = cVar.b();
                Bundle a7 = b2.a(str2);
                if (a7 != null) {
                    linkedHashMap = new LinkedHashMap();
                    Set<String> keySet = a7.keySet();
                    r5.h.e(keySet, "this.keySet()");
                    for (Iterator it = keySet.iterator(); it.hasNext(); it = it) {
                        String str3 = (String) it.next();
                        ArrayList parcelableArrayList = a7.getParcelableArrayList(str3);
                        r5.h.d(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
                        r5.h.e(str3, "key");
                        linkedHashMap.put(str3, parcelableArrayList);
                    }
                } else {
                    linkedHashMap = null;
                }
                m mVar = u.c.f6069a;
                u.b bVar2 = new u.b(linkedHashMap);
                try {
                    b2.c(str2, new r(bVar2));
                    z6 = true;
                } catch (IllegalArgumentException unused) {
                    z6 = false;
                }
                r9 = new p(bVar2, new q(z6, b2, str2));
                i8.u(r9);
            }
            i8.o();
            p pVar2 = (p) r9;
            p.n.a(f5.g.f4141a, new C0011h(pVar2), i8);
            r5.h.e(context, "context");
            Configuration configuration = (Configuration) vVar.getValue();
            i8.s(-485908294, null, null);
            i8.s(-492369756, null, null);
            Object r10 = i8.r();
            Object obj = b.a.f5423a;
            if (r10 == obj) {
                r10 = new n0.a();
                i8.u(r10);
            }
            i8.o();
            n0.a aVar2 = (n0.a) r10;
            i8.s(-492369756, null, null);
            Object r11 = i8.r();
            Configuration configuration2 = r11;
            if (r11 == obj) {
                Configuration configuration3 = new Configuration();
                if (configuration != null) {
                    configuration3.setTo(configuration);
                }
                i8.u(configuration3);
                configuration2 = configuration3;
            }
            i8.o();
            Configuration configuration4 = (Configuration) configuration2;
            i8.s(-492369756, null, null);
            Object r12 = i8.r();
            if (r12 == obj) {
                r12 = new j(configuration4, aVar2);
                i8.u(r12);
            }
            i8.o();
            p.n.a(aVar2, new i(context, (j) r12), i8);
            i8.o();
            p.g.a(new c0[]{f1159a.a((Configuration) vVar.getValue()), f1160b.a(context), f1162d.a(viewTreeOwners.f1123a), e.a(viewTreeOwners.f1124b), u.c.f6069a.a(pVar2), f1163f.a(androidComposeView.getView()), f1161c.a(aVar2)}, t.b.b(i8, 1471621628, new i(androidComposeView, kVar, pVar, i7)), i8, 56);
            e0 q6 = i8.q();
            if (q6 != null) {
                q6.f5426a = new j(androidComposeView, pVar, i7);
                return;
            }
            return;
        }
        throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
    }

    public static final void b(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
