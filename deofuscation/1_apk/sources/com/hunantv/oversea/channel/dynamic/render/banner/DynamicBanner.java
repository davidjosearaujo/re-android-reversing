package com.hunantv.oversea.channel.dynamic.render.banner;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.yoga.android.YogaLayout;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.business.ad.huge.HugeMananger;
import com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment;
import com.hunantv.oversea.channel.dynamic.config.ChannelDynamicConfigMananger;
import com.hunantv.oversea.channel.dynamic.video.VideoPreviewManager;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.dynamicview.model.ChannelStyle;
import com.mgtv.dynamicview.model.StyleLayout;
import com.mgtv.dynamicview.widget.CustomBannerIndicator;
import com.mgtv.dynamicview.widget.CustomProgress;
import com.mgtv.widget.banner.SmartTouchViewPager;
import j.l.a.b0.j0;
import j.l.a.b0.n0;
import j.l.a.b0.q;
import j.l.a.b0.v;
import j.l.a.b0.z;
import j.l.c.c.b;
import j.l.c.c.c.u1.l;
import j.l.c.c.c.u1.u.a0;
import j.l.c.c.c.u1.u.b0;
import j.l.c.c.c.u1.u.c0;
import j.l.c.c.c.u1.u.d0;
import j.l.c.c.c.u1.u.e0;
import j.l.c.c.c.u1.u.f0;
import j.l.c.c.c.u1.u.p;
import j.l.c.c.c.u1.u.r;
import j.l.c.c.c.u1.u.s;
import j.l.c.c.c.u1.u.t;
import j.l.c.c.c.u1.u.u;
import j.l.c.c.c.u1.u.w;
import j.l.c.c.c.u1.u.x;
import j.l.c.c.c.u1.u.y;
import j.l.c.c.d.e;
import j.v.g.i.g;
import j.v.g.k.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicBanner extends SmartTouchViewPager implements j.v.g.l.a, j.v.g.l.c, l {
    private static final /* synthetic */ c.b A2 = null;
    private static final /* synthetic */ c.b B2 = null;
    private static final /* synthetic */ c.b C2 = null;
    private static final /* synthetic */ c.b D2 = null;
    private static final /* synthetic */ c.b E2 = null;
    private static final /* synthetic */ c.b F2 = null;
    private static final /* synthetic */ c.b G2 = null;
    private static final /* synthetic */ c.b H2 = null;
    private static final /* synthetic */ c.b I2 = null;
    public static final String r2 = "DynamicBanner";
    public static final int s2 = 3250;
    private static final int t2 = 500;
    private static final String u2 = "ShowReport";
    private static final /* synthetic */ c.b v2 = null;
    private static final /* synthetic */ c.b w2 = null;
    private static final /* synthetic */ c.b x2 = null;
    private static final /* synthetic */ c.b y2 = null;
    private static final /* synthetic */ c.b z2 = null;
    private String A;
    public int B;
    private CustomBannerIndicator C;
    public long C1;
    private CustomProgress D;
    private int E;
    private InnerHandler F;
    private boolean K0;
    private ViewPager.OnPageChangeListener K1;
    private Activity g;
    private ListAdapter h;
    private List<Object> i;
    public JsonElement j;
    private String k;
    private int k0;
    @Nullable
    private e k1;
    private int l;
    public int m;
    private boolean n;
    private j.v.g.i.d o;
    private ChannelStyle p;
    private final Runnable p2;
    public float q;
    private j.l.c.c.c.u1.u.a q2;
    private int r;
    private String s;
    private View.OnClickListener t;
    private boolean u;
    private d v;
    private ViewPager.OnPageChangeListener w;
    private BannerAdVideoHelper x;
    private j.l.c.c.c.s1.e x1;
    private boolean y;
    private float y1;
    private String z;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class InnerHandler extends Handler {
        public static final int b = 1;
        private static final /* synthetic */ c.b c = null;
        private final WeakReference<DynamicBanner> a;

        static {
            a();
        }

        public /* synthetic */ InnerHandler(DynamicBanner dynamicBanner, a aVar) {
            this(dynamicBanner);
        }

        private static /* synthetic */ void a() {
            r.a.c.c.e eVar = new r.a.c.c.e("DynamicBanner.java", InnerHandler.class);
            c = eVar.H("method-execution", eVar.E("1", "handleMessage", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner$InnerHandler", "android.os.Message", "msg", "", "void"), 660);
        }

        public static final /* synthetic */ void c(InnerHandler innerHandler, Message message, r.a.b.c cVar) {
            super.handleMessage(message);
            DynamicBanner dynamicBanner = innerHandler.a.get();
            if (dynamicBanner != null && 1 == message.what) {
                dynamicBanner.p2.run();
            }
        }

        public void b() {
            removeMessages(1);
        }

        public void d(int i) {
            removeMessages(1);
            sendEmptyMessageDelayed(1, i);
        }

        @Override // android.os.Handler
        @WithTryCatchRuntime
        public void handleMessage(@NonNull Message message) {
            LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new e0(new Object[]{this, message, r.a.c.c.e.w(c, this, this, message)}).e(69648));
        }

        private InnerHandler(DynamicBanner dynamicBanner) {
            this.a = new WeakReference<>(dynamicBanner);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class ListAdapter extends PagerAdapter implements j.v.s.a.a.b.a {
        private static final /* synthetic */ c.b b = null;

        static {
            b();
        }

        private ListAdapter() {
        }

        private static /* synthetic */ void b() {
            r.a.c.c.e eVar = new r.a.c.c.e("DynamicBanner.java", ListAdapter.class);
            b = eVar.H("method-execution", eVar.E("1", "instantiateItem", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner$ListAdapter", "android.view.ViewGroup:int", "container:position", "", "java.lang.Object"), 707);
        }

        private String c(ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean) {
            if (moduleDataBean == null) {
                return "";
            }
            String str = moduleDataBean.subName;
            if (moduleDataBean.adLogEnnable) {
                String string = j.l.a.a.a().getResources().getString(b.r.mgmi_template_ad);
                if (TextUtils.isEmpty(str)) {
                    return string;
                }
                return str + " · " + string;
            }
            return str;
        }

        private int d() {
            if (DynamicBanner.this.i == null) {
                return 0;
            }
            return DynamicBanner.this.i.size();
        }

        private String e(Object obj, String str) {
            JsonObject asJsonObject;
            JsonElement jsonElement;
            if (!(obj instanceof JsonElement) || (asJsonObject = ((JsonElement) obj).getAsJsonObject()) == null || (jsonElement = asJsonObject.get(str)) == null) {
                return null;
            }
            return jsonElement.getAsString();
        }

        public static final /* synthetic */ Object f(ListAdapter listAdapter, ViewGroup viewGroup, int i, r.a.b.c cVar) {
            g e;
            g e2;
            f fVar;
            String str;
            int d = DynamicBanner.this.K0 ? i % listAdapter.d() : i;
            Object obj = DynamicBanner.this.i.get(d);
            boolean z = (obj instanceof ChannelIndexEntity.DataBean.ModuleDataBean) || DynamicBanner.this.x1 == null;
            VideoPreviewManager.c cVar2 = null;
            View inflate = z ? LayoutInflater.from(DynamicBanner.this.g).inflate(DynamicBanner.this.getBannerAdLayoutId(), (ViewGroup) null) : DynamicBanner.this.x1.d(DynamicBanner.this.g, DynamicBanner.this.o, DynamicBanner.this.p);
            inflate.setTag(b.j.home_jx_style, Boolean.valueOf(q.a(viewGroup)));
            if (!z) {
                if (DynamicBanner.this.i != null && (DynamicBanner.this.K0 || d < DynamicBanner.this.i.size())) {
                    JsonObject jsonObject = (JsonObject) DynamicBanner.this.i.get(d);
                    ArrayList arrayList = DynamicBanner.this.o.n;
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            View findViewById = inflate.findViewById(((Integer) it.next()).intValue());
                            if (findViewById != null && (fVar = (f) findViewById.getTag(b.j.dsl_tag_data_binder)) != null) {
                                findViewById.setTag(b.j.dsl_tag_banner_show_flag, Boolean.TRUE);
                                fVar.rendWithData(findViewById, jsonObject, DynamicBanner.this.v, d);
                                Object tag = findViewById.getTag(b.j.dsl_tag_banner_show_data);
                                if (tag instanceof String) {
                                    jsonObject.addProperty(DynamicBanner.u2, (String) tag);
                                }
                            }
                        }
                    }
                    if (DynamicBanner.this.K0 || d != DynamicBanner.this.i.size() - 1) {
                        int itemWidth = DynamicBanner.this.getItemWidth();
                        if (itemWidth != 0) {
                            inflate.getLayoutParams().width = itemWidth;
                        }
                    } else {
                        inflate.getLayoutParams().width = DynamicBanner.this.m;
                    }
                    if (inflate instanceof YogaLayout) {
                        YogaLayout yogaLayout = (YogaLayout) inflate;
                        yogaLayout.getYogaNode().setHeight(Float.NaN);
                        yogaLayout.getYogaNode().setWidth(Float.NaN);
                    }
                    View findViewById2 = inflate.findViewById(b.j.dsl_tag_playerview);
                    if (findViewById2 != null) {
                        f fVar2 = (f) findViewById2.getTag(b.j.dsl_tag_data_binder);
                        if (fVar2 != null && (e = fVar2.e("type")) != null && !EventClickData.a.o.equals(e.a()) && (e2 = fVar2.e("videoId")) != null) {
                            String c = f.c(e2.c(), jsonObject);
                            if (!TextUtils.isEmpty(c) && !"0".equals(c)) {
                                VideoPreviewManager.c cVar3 = new VideoPreviewManager.c(c, null, null);
                                cVar3.a = DynamicBanner.this.s;
                                cVar3.c = listAdapter.e(obj, "videoName");
                                cVar3.d = listAdapter.e(obj, "desc");
                                cVar2 = cVar3;
                            }
                        }
                        findViewById2.setTag(b.j.video_preview_data_id, cVar2);
                    }
                }
                return inflate;
            }
            ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean = (ChannelIndexEntity.DataBean.ModuleDataBean) obj;
            j.l.c.c.c.u1.u.b K = DynamicBanner.this.K(inflate);
            View a = K.a(inflate);
            K.render(moduleDataBean, DynamicBanner.this.y1);
            inflate.setOnClickListener(DynamicBanner.this.t);
            if (BannerHelper.isAdImageResExist(moduleDataBean) && !TextUtils.isEmpty(moduleDataBean.videoUrl) && moduleDataBean.adJump == 3) {
                if (DynamicBanner.this instanceof DynamicSquareBanner) {
                    str = listAdapter.c(moduleDataBean);
                } else {
                    str = moduleDataBean.subName;
                }
                VideoPreviewManager.c cVar4 = new VideoPreviewManager.c(moduleDataBean.autoPlayVideoId, moduleDataBean.name, str);
                cVar4.j = moduleDataBean.videoUrl;
                cVar4.b = "0";
                cVar4.s = moduleDataBean;
                cVar4.a = DynamicBanner.this.s;
                inflate.findViewById(b.j.video_preview_frame).setTag(b.j.video_preview_data_id, cVar4);
            } else if (moduleDataBean.isBannerAdVideo) {
                if (DynamicBanner.this.x != null) {
                    DynamicBanner.this.x.renderAdView(DynamicBanner.this.k1, a, moduleDataBean, false);
                }
                inflate.findViewById(b.j.video_preview_frame).setTag(b.j.video_preview_data_id, null);
            }
            viewGroup.addView(inflate);
            inflate.setTag(Integer.valueOf(i));
            return inflate;
        }

        public int a() {
            if (DynamicBanner.this.i == null) {
                return 0;
            }
            return DynamicBanner.this.i.size();
        }

        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return DynamicBanner.this.getCount();
        }

        @NonNull
        @WithTryCatchRuntime
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            return LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f0(new Object[]{this, viewGroup, r.a.c.b.e.k(i), r.a.c.c.e.x(b, this, this, viewGroup, r.a.c.b.e.k(i))}).e(69648));
        }

        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        public /* synthetic */ ListAdapter(DynamicBanner dynamicBanner, a aVar) {
            this();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        public void onPageScrollStateChanged(int i) {
            if (DynamicBanner.this.w != null) {
                DynamicBanner.this.w.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                DynamicBanner.this.F.b();
            } else if (i != 2) {
            } else {
                DynamicBanner.this.F.d(3000);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (DynamicBanner.this.w != null) {
                DynamicBanner.this.w.onPageScrolled(i, f, i2);
            }
        }

        public void onPageSelected(int i) {
            int i2;
            boolean z = !DynamicBanner.this.K0 && i == DynamicBanner.this.getRealCount() - 1;
            DynamicBanner dynamicBanner = DynamicBanner.this;
            dynamicBanner.B = z ? 0 : i;
            if (dynamicBanner.K0) {
                DynamicBanner dynamicBanner2 = DynamicBanner.this;
                i2 = dynamicBanner2.B % dynamicBanner2.getRealCount();
            } else {
                i2 = DynamicBanner.this.B;
            }
            if (DynamicBanner.this.k0 != i2) {
                DynamicBanner.this.k0 = i2;
                DynamicBanner dynamicBanner3 = DynamicBanner.this;
                dynamicBanner3.updateIndicator(dynamicBanner3.k0);
            }
            if (DynamicBanner.this.w != null) {
                DynamicBanner.this.w.onPageSelected(i);
            }
            DynamicBanner.this.T();
            DynamicBanner.this.updateMainUI(i, true);
            DynamicBanner.this.exposuredBanner(i);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends TypeToken<JsonObject> {
        public b() {
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c implements j.l.c.c.c.u1.u.a {
        public c() {
        }

        public void a(boolean z) {
            v.c(DynamicBanner.r2, "notifyAdVisible onPageVisibleChanged: " + z);
            if (z && DynamicBanner.this.isAttachedToWindow()) {
                if (HugeMananger.h().m()) {
                    DynamicBanner.this.I();
                } else {
                    DynamicBanner.this.startAutoScroll();
                }
                DynamicBanner dynamicBanner = DynamicBanner.this;
                dynamicBanner.notifyAdVisible(dynamicBanner.B, true);
                return;
            }
            DynamicBanner.this.I();
            DynamicBanner dynamicBanner2 = DynamicBanner.this;
            dynamicBanner2.notifyAdVisible(dynamicBanner2.B, false);
        }

        public void b(@NonNull RecyclerView recyclerView, int i) {
            if (i == 0) {
                v.c(DynamicBanner.r2, "notifyAdVisible onScrollStateChanged idle");
                if (DynamicBanner.this.y || !DynamicBanner.this.isAttachedToWindow()) {
                    return;
                }
                DynamicBanner.this.y = true;
                DynamicBanner dynamicBanner = DynamicBanner.this;
                dynamicBanner.notifyAdVisible(dynamicBanner.B, true);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class d implements j.v.g.k.d {
        private WeakReference<j.v.g.k.d> a;
        private int b;

        private d() {
        }

        public void a(View view, j.v.g.d.a aVar) {
            b(view, aVar, false);
        }

        public void b(View view, j.v.g.d.a aVar, boolean z) {
            j.v.g.k.d dVar;
            WeakReference<j.v.g.k.d> weakReference = this.a;
            if (weakReference == null || (dVar = weakReference.get()) == null) {
                return;
            }
            if (z) {
                dVar.a(view, aVar);
                return;
            }
            if (aVar instanceof j.v.g.d.b) {
                j.v.g.d.b bVar = (j.v.g.d.b) aVar;
                bVar.b = bVar.a;
                bVar.a = this.b;
            }
            dVar.a(view, aVar);
        }

        public void c(int i, j.v.g.k.d dVar) {
            this.b = i;
            this.a = new WeakReference<>(dVar);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        G();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DynamicBanner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new ArrayList();
        this.l = 0;
        this.n = false;
        this.s = "";
        this.u = false;
        this.v = new d(null);
        this.y = true;
        this.B = -1;
        this.E = s2;
        this.F = new InnerHandler(this, null);
        this.K0 = true;
        this.y1 = 0.0f;
        this.K1 = new a();
        this.p2 = new Runnable() { // from class: com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner.3
            private static final /* synthetic */ c.b b = null;

            static {
                a();
            }

            private static /* synthetic */ void a() {
                r.a.c.c.e eVar = new r.a.c.c.e("DynamicBanner.java", AnonymousClass3.class);
                b = eVar.H("method-execution", eVar.E("1", "run", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner$3", "", "", "", "void"), 676);
            }

            public static final /* synthetic */ void b(AnonymousClass3 anonymousClass3, r.a.b.c cVar) {
                if (DynamicBanner.this.h == null || !DynamicBanner.this.isAttachedToWindow()) {
                    return;
                }
                if (DynamicBanner.this.u) {
                    DynamicBanner.this.a0();
                }
                DynamicBanner.this.F.d(DynamicBanner.this.E);
            }

            @Override // java.lang.Runnable
            @WithTryCatchRuntime
            public void run() {
                LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new p(new Object[]{this, r.a.c.c.e.v(b, this, this)}).e(69648));
            }
        };
        this.q2 = new c();
        b0();
        this.g = (Activity) context;
        setOnPageChangeListener(this.K1);
        setClipToPadding(false);
        setTag(r2);
        this.x = new BannerAdVideoHelper();
    }

    private static /* synthetic */ void G() {
        r.a.c.c.e eVar = new r.a.c.c.e("DynamicBanner.java", DynamicBanner.class);
        v2 = eVar.H("method-execution", eVar.E("1", "applyDayNight", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "", "", "", "void"), (int) Opcodes.INVOKEINTERFACE);
        w2 = eVar.H("method-execution", eVar.E("2", "updateIndicator", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "int", "position", "", "void"), 327);
        F2 = eVar.H("method-execution", eVar.E("1", "startLastItem", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "", "", "", "void"), 966);
        G2 = eVar.H("method-execution", eVar.E("2", "exposuredBanner", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "int", "index", "", "void"), 986);
        H2 = eVar.H("method-execution", eVar.E("2", "reportDslShow", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "java.lang.Object:int", "object:realPosition", "", "void"), 1030);
        I2 = eVar.H("method-execution", eVar.E("2", "notifyAdVisible", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "int:boolean", "position:isAttachedToWindow", "", "void"), 1110);
        x2 = eVar.H("method-execution", eVar.E("2", "resetIndicator", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "int", "count", "", "void"), 342);
        y2 = eVar.H("method-execution", eVar.E("2", "updateMainUI", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "int:boolean", "index:updateMain", "", "void"), 371);
        z2 = eVar.H("method-execution", eVar.E("2", "needUpdateChannelTopBg", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "", "", "", "boolean"), 420);
        A2 = eVar.H("method-execution", eVar.E("2", "resetViewPageAdapter", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "", "", "", "void"), 483);
        B2 = eVar.H("method-execution", eVar.E("1", "startAutoScroll", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "", "", "", "void"), 607);
        C2 = eVar.H("method-execution", eVar.E("1", "startAutoScroll", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "int", "scrollInterval", "", "void"), 615);
        D2 = eVar.H("method-execution", eVar.E("2", "getStartSelectItem", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "", "", "", "int"), 926);
        E2 = eVar.H("method-execution", eVar.E("2", "getCount", "com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner", "", "", "", "int"), 950);
    }

    public static final /* synthetic */ void H(DynamicBanner dynamicBanner, r.a.b.c cVar) {
        int i = dynamicBanner.B;
        if (i != -1) {
            dynamicBanner.updateMainUI(i, false);
        }
    }

    private void J(Object obj) {
        setShowInteractAd((obj instanceof ChannelIndexEntity.DataBean.ModuleDataBean) && ((ChannelIndexEntity.DataBean.ModuleDataBean) obj).adResType == 2);
    }

    public static final /* synthetic */ void M(DynamicBanner dynamicBanner, int i, r.a.b.c cVar) {
        int realCount = i % dynamicBanner.getRealCount();
        Object obj = dynamicBanner.i.get(realCount);
        BannerAdVideoHelper bannerAdVideoHelper = dynamicBanner.x;
        if (bannerAdVideoHelper != null) {
            bannerAdVideoHelper.notifyAdChanged(dynamicBanner.k1, obj, false);
        }
        boolean z = obj instanceof ChannelIndexEntity.DataBean.ModuleDataBean;
        dynamicBanner.S(z);
        if (!z) {
            dynamicBanner.reportDslShow(obj, realCount);
            dynamicBanner.reportCollectShow(obj);
            dynamicBanner.startAutoScroll();
            dynamicBanner.setShowInteractAd(false);
            return;
        }
        dynamicBanner.J(obj);
        j.l.c.c.d.a aVar = new j.l.c.c.d.a("MSG_BANNER_EXPOSURED");
        aVar.i = obj;
        aVar.c = new int[]{realCount, dynamicBanner.r};
        e eVar = dynamicBanner.k1;
        if (eVar != null) {
            eVar.V(aVar);
        }
    }

    public static final /* synthetic */ int N(DynamicBanner dynamicBanner, r.a.b.c cVar) {
        List<Object> list = dynamicBanner.i;
        if (list == null) {
            return 0;
        }
        return dynamicBanner.K0 ? list.size() * 500 : list.size();
    }

    private float O(int i) {
        int realCount = getRealCount();
        if (realCount > 0) {
            return ((i + 1) * 1.0f) / realCount;
        }
        return 0.0f;
    }

    public static final /* synthetic */ int P(DynamicBanner dynamicBanner, r.a.b.c cVar) {
        List<Object> list = dynamicBanner.i;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int realCount = dynamicBanner.getRealCount();
        int i = (realCount * 500) / 2;
        if (realCount == 0 || i % realCount == 0) {
            return i;
        }
        while (i % realCount != 0) {
            i++;
        }
        return i;
    }

    public static final /* synthetic */ boolean Q(DynamicBanner dynamicBanner, r.a.b.c cVar) {
        if (j.l.a.t.e.m().r()) {
            return TextUtils.equals(dynamicBanner.A, "1");
        }
        return TextUtils.equals(dynamicBanner.z, "1");
    }

    public static final /* synthetic */ void R(DynamicBanner dynamicBanner, int i, boolean z, r.a.b.c cVar) {
        BannerAdVideoHelper bannerAdVideoHelper;
        List<Object> list = dynamicBanner.i;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (dynamicBanner.K0) {
            i %= dynamicBanner.getRealCount();
        }
        v.c(r2, "notifyAdVisible realPosition: " + i);
        if (i >= 0) {
            Object obj = dynamicBanner.i.get(i);
            if (!(obj instanceof ChannelIndexEntity.DataBean.ModuleDataBean) || (bannerAdVideoHelper = dynamicBanner.x) == null) {
                return;
            }
            bannerAdVideoHelper.notifyAdVisible(dynamicBanner.k1, obj, false, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void V(DynamicBanner dynamicBanner, Object obj, int i, r.a.b.c cVar) {
        JsonObject jsonObject;
        JsonElement jsonElement;
        if ((obj instanceof JsonObject) && (jsonElement = (jsonObject = (JsonObject) obj).get(u2)) != null && jsonElement.isJsonPrimitive()) {
            String asString = jsonElement.getAsString();
            if (TextUtils.isEmpty(asString)) {
                return;
            }
            j.v.g.d.a eVar = new j.v.g.d.e(i, asString);
            ((j.v.g.d.b) eVar).c = jsonObject;
            dynamicBanner.v.a(dynamicBanner, eVar);
            v.c(r2, "reportDslShow pos: " + i + ", showReport: " + asString);
        }
    }

    public static final /* synthetic */ void W(DynamicBanner dynamicBanner, int i, r.a.b.c cVar) {
        CustomBannerIndicator customBannerIndicator = dynamicBanner.C;
        if (customBannerIndicator != null) {
            customBannerIndicator.setItemSize(i);
            dynamicBanner.C.requestLayout();
        }
        if (dynamicBanner.D != null) {
            dynamicBanner.D.setProgress(dynamicBanner.O(0));
        }
    }

    public static final /* synthetic */ void Y(DynamicBanner dynamicBanner, r.a.b.c cVar) {
        ListAdapter listAdapter = new ListAdapter(dynamicBanner, null);
        dynamicBanner.h = listAdapter;
        dynamicBanner.setAdapter(listAdapter);
        if (dynamicBanner.K0) {
            int startSelectItem = dynamicBanner.getStartSelectItem();
            dynamicBanner.B = startSelectItem;
            dynamicBanner.setCurrentItem(startSelectItem);
        }
        dynamicBanner.exposuredBanner(dynamicBanner.B);
    }

    private void Z() {
        e eVar = this.k1;
        if (eVar != null) {
            Fragment b2 = eVar.b();
            if (b2 instanceof ChannelDynamicFragment) {
                ((ChannelDynamicFragment) b2).f1(this.q2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        try {
            int currentItem = getCurrentItem() + 1;
            if (currentItem == getCount() - 1) {
                currentItem = 0;
            }
            setCurrentItem(currentItem, true);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static final /* synthetic */ void d0(DynamicBanner dynamicBanner, int i, r.a.b.c cVar) {
        dynamicBanner.F.b();
        dynamicBanner.u = true;
        dynamicBanner.F.d(i);
    }

    public static final /* synthetic */ void e0(DynamicBanner dynamicBanner, r.a.b.c cVar) {
        int realCount = dynamicBanner.getRealCount();
        if (realCount == 0) {
            return;
        }
        dynamicBanner.F.b();
        int currentItem = dynamicBanner.getCurrentItem();
        int i = ((currentItem - realCount) + (realCount - (currentItem % realCount))) - 1;
        dynamicBanner.B = i;
        dynamicBanner.setCurrentItem(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void exposuredBanner(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new x(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(G2, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    public static final /* synthetic */ void f0(DynamicBanner dynamicBanner, int i, r.a.b.c cVar) {
        CustomBannerIndicator customBannerIndicator = dynamicBanner.C;
        if (customBannerIndicator != null) {
            customBannerIndicator.setSelectIndex(i);
        }
        if (dynamicBanner.D != null) {
            dynamicBanner.D.setProgress(dynamicBanner.O(i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void g0(DynamicBanner dynamicBanner, int i, boolean z, r.a.b.c cVar) {
        String str;
        JsonObject asJsonObject;
        Object obj = dynamicBanner.i.get(i % dynamicBanner.getRealCount());
        str = "";
        if (obj instanceof ChannelIndexEntity.DataBean.ModuleDataBean) {
            ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean = (ChannelIndexEntity.DataBean.ModuleDataBean) obj;
            String str2 = moduleDataBean.fontColor;
            str = moduleDataBean.bgColor;
        } else if ((obj instanceof JsonElement) && (asJsonObject = ((JsonElement) obj).getAsJsonObject()) != null) {
            JsonElement jsonElement = asJsonObject.get("bgColor");
            str = jsonElement != null ? jsonElement.getAsString() : "";
            JsonElement jsonElement2 = asJsonObject.get("fontColor");
            if (jsonElement2 != null) {
                jsonElement2.getAsString();
            }
        }
        if (dynamicBanner.k1 == null || dynamicBanner.r != 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            dynamicBanner.setBackgroundResource(b.f.transparent);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        Resources resources = dynamicBanner.getResources();
        int i2 = b.f.channel_background;
        gradientDrawable.setColors(new int[]{z.e(str, resources.getColor(i2)), z.e(str, dynamicBanner.getResources().getColor(i2)), dynamicBanner.getResources().getColor(i2)});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setGradientCenter(0.5f, 0.8f);
        dynamicBanner.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public int getCount() {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new u(new Object[]{this, r.a.c.c.e.v(E2, this, this)}).e(69648)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemWidth() {
        if (TextUtils.isEmpty(this.k)) {
            return 0;
        }
        if (this.l == 0) {
            if (this.n) {
                String str = this.k;
                this.l = (n0.a(str.substring(0, str.length() - 1)) * this.m) / 100;
            } else {
                this.l = j0.b(this.g, n0.a(this.k));
            }
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealCount() {
        List<Object> list = this.i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @WithTryCatchRuntime
    private int getStartSelectItem() {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new t(new Object[]{this, r.a.c.c.e.v(D2, this, this)}).e(69648)));
    }

    @WithTryCatchRuntime
    private boolean needUpdateChannelTopBg() {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d0(new Object[]{this, r.a.c.c.e.v(z2, this, this)}).e(69648)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void notifyAdVisible(int i, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.u.z(new Object[]{this, r.a.c.b.e.k(i), r.a.c.b.e.a(z), r.a.c.c.e.x(I2, this, this, r.a.c.b.e.k(i), r.a.c.b.e.a(z))}).e(69648));
    }

    @WithTryCatchRuntime
    private void reportDslShow(Object obj, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new y(new Object[]{this, obj, r.a.c.b.e.k(i), r.a.c.c.e.x(H2, this, this, obj, r.a.c.b.e.k(i))}).e(69648));
    }

    @WithTryCatchRuntime
    private void resetIndicator(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b0(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(x2, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    @WithTryCatchRuntime
    private void resetViewPageAdapter() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.u.q(new Object[]{this, r.a.c.c.e.v(A2, this, this)}).e(69648));
    }

    private void setShowInteractAd(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void updateIndicator(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a0(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(w2, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void updateMainUI(int i, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new c0(new Object[]{this, r.a.c.b.e.k(i), r.a.c.b.e.a(z), r.a.c.c.e.x(y2, this, this, r.a.c.b.e.k(i), r.a.c.b.e.a(z))}).e(69648));
    }

    public void I() {
        InnerHandler innerHandler = this.F;
        if (innerHandler != null) {
            this.u = false;
            innerHandler.b();
        }
    }

    public j.l.c.c.c.u1.u.b K(View view) {
        return new BannerAdRectHolder(view);
    }

    public void L(j.v.g.l.a aVar) {
        if (aVar instanceof CustomBannerIndicator) {
            this.C = (CustomBannerIndicator) aVar;
        } else if (aVar instanceof CustomProgress) {
            this.D = (CustomProgress) aVar;
        }
    }

    public void S(boolean z) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void T() {
        if (this.v != null) {
            j.v.g.d.a cVar = new j.v.g.d.c();
            ((j.v.g.d.b) cVar).a = this.r;
            ((j.v.g.d.b) cVar).b = this.k0;
            this.v.b(this, cVar, true);
        }
    }

    public void U(Object obj, Object obj2) {
        if (obj2 != null) {
            this.i.remove(obj2);
        }
        if (obj != null) {
            this.i.add(obj);
        }
        resetIndicator(this.i.size());
        resetViewPageAdapter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void X(j.v.g.i.d dVar, ChannelStyle channelStyle, j.v.g.f.t tVar) {
        Map map;
        this.o = dVar;
        this.p = channelStyle;
        StyleLayout styleLayout = dVar.e;
        String str = styleLayout.width;
        this.k = str;
        this.q = styleLayout.aspectRatio;
        if (!TextUtils.isEmpty(str) && this.k.contains("%")) {
            this.n = true;
        }
        j.v.g.i.d dVar2 = (j.v.g.i.d) getTag(b.j.dsl_tag_style);
        this.C1 = j.l.a.b0.c0.i(ChannelDynamicConfigMananger.c(dVar2.l), 9000189L);
        if (dVar2 != null && (map = dVar2.f) != null) {
            String str2 = (String) map.get("itemSpacing");
            if (!TextUtils.isEmpty(str2)) {
                setPageMargin(j0.b(this.g, n0.F(str2)));
            }
            String str3 = (String) dVar2.f.get("itemEdge");
            if (!TextUtils.isEmpty(str3)) {
                int b2 = j0.b(this.g, n0.F(str3));
                setPadding(b2, 0, b2, 0);
            }
            this.z = (String) dVar2.f.get("topBgSwitch");
            this.A = (String) dVar2.f.get("topBgSeasonSwitch");
        }
        Map map2 = dVar.f;
        if (map2 != null) {
            String str4 = (String) map2.get("borderRadius");
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            float e = j.l.a.b0.c0.e(str4, -1.0f);
            this.y1 = e != -1.0f ? j0.b(j.l.a.a.a(), e) : this.y1;
        }
    }

    public void addAttributeResource(int i, int i2) {
    }

    @WithTryCatchRuntime
    public void applyDayNight() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.u.v(new Object[]{this, r.a.c.c.e.v(v2, this, this)}).e(69648));
    }

    public void b0() {
        new j.v.g.l.b().b(true);
    }

    public int getBannerAdLayoutId() {
        return b.m.item_template_dynamic_ad_banner_image;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void h0(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        if (size != 0 && size != this.m) {
            this.m = size;
        }
        int n = j0.n(this.g);
        setMeasuredDimension(n, (int) (((((n - getPaddingLeft()) - getPaddingRight()) * 9) * 1.0f) / 16.0f));
    }

    public void j0(int i) {
    }

    public void onAttachedToWindow() {
        super/*androidx.viewpager.widget.ViewPager*/.onAttachedToWindow();
        if (HugeMananger.h().m()) {
            I();
            return;
        }
        startAutoScroll();
        Z();
    }

    public void onDetachedFromWindow() {
        super/*androidx.viewpager.widget.ViewPager*/.onDetachedFromWindow();
        this.y = false;
        notifyAdVisible(this.B, false);
        I();
    }

    public void onMeasure(int i, int i2) {
        super/*androidx.viewpager.widget.ViewPager*/.onMeasure(i, i2);
        h0(i, i2);
    }

    public void removeItem(int i) {
    }

    public void reportCollectShow(Object obj) {
    }

    public void setChannelCenter(e eVar) {
        this.k1 = eVar;
    }

    public void setExtendOnclick(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void setInfiniteLoop(boolean z) {
        this.K0 = z;
    }

    public void setPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.w = onPageChangeListener;
    }

    public void setScrollInterval(int i) {
        if (i >= 1000) {
            this.E = i;
        }
    }

    public void setStyleManager(j.l.c.c.c.s1.e eVar) {
        this.x1 = eVar;
    }

    @WithTryCatchRuntime
    public void startAutoScroll() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new r(new Object[]{this, r.a.c.c.e.v(B2, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void startLastItem() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new w(new Object[]{this, r.a.c.c.e.v(F2, this, this)}).e(69648));
    }

    public void t(JsonElement jsonElement, j.v.g.k.d dVar, int i) {
        this.r = i;
        this.v.c(i, dVar);
        resetIndicator(this.i.size());
        if (jsonElement instanceof JsonArray) {
            this.j = jsonElement;
            List j = j.v.j.b.j((JsonArray) jsonElement, new b().getType());
            this.i.clear();
            this.i.addAll(j);
            resetViewPageAdapter();
            if (getRealCount() > 1) {
                setOffscreenPageLimit(getRealCount() / 2);
            }
            startAutoScroll();
        }
        e eVar = this.k1;
        if (eVar != null) {
            this.s = eVar.b0(i);
        }
    }

    @WithTryCatchRuntime
    public void startAutoScroll(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new s(new Object[]{this, r.a.c.b.e.k(i), r.a.c.c.e.w(C2, this, this, r.a.c.b.e.k(i))}).e(69648));
    }
}
