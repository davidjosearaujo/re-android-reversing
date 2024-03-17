package com.hunantv.oversea.channel.dynamic.video;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import com.hunantv.oversea.business.ad.huge.HugeMananger;
import com.hunantv.oversea.channel.dynamic.data.ModuleData;
import com.hunantv.oversea.channel.dynamic.render.banner.DynamicBanner;
import com.hunantv.oversea.channel.dynamic.video.VideoPreviewView;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.hunantv.oversea.play.report.videoPreview.VideoPreviewReporter;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.widget.AutoScrollViewPager;
import com.mgtv.widget.banner.CustomViewPager;
import com.mgtv.widget.banner.MZBannerView;
import j.l.c.c.b;
import java.util.HashMap;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VideoPreviewManager {
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    private static VideoPreviewManager m;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private ViewPager d;
    private VideoPreviewView e;
    private View f;
    private int g;
    private int a = 0;
    private boolean b = false;
    private SparseArray<HashMap<String, Integer>> c = new SparseArray<>();
    private b h = new b(this, null);

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements VideoPreviewView.q {
        public a() {
        }

        @Override // com.hunantv.oversea.channel.dynamic.video.VideoPreviewView.q
        public void e() {
            VideoPreviewManager videoPreviewManager = VideoPreviewManager.this;
            videoPreviewManager.v(videoPreviewManager.d, 3000);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private int a;

        private b() {
        }

        public void a(int i) {
            this.a = i;
        }

        public void onPageScrollStateChanged(int i) {
            if (i != 0 || VideoPreviewManager.this.d == null) {
                return;
            }
            int currentItem = VideoPreviewManager.this.d.getCurrentItem();
            if (currentItem != this.a) {
                VideoPreviewManager.this.videoPreviewInViewPage((HashMap) VideoPreviewManager.this.c.get(VideoPreviewManager.this.g));
            }
            this.a = currentItem;
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (VideoPreviewManager.this.d != null && DynamicBanner.r2.equals(VideoPreviewManager.this.d.getTag())) {
                if (i != this.a) {
                    VideoPreviewManager.this.videoPreviewInViewPage((HashMap) VideoPreviewManager.this.c.get(VideoPreviewManager.this.g));
                }
                this.a = i;
            }
        }

        public /* synthetic */ b(VideoPreviewManager videoPreviewManager, a aVar) {
            this();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class c {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public int k;
        public boolean l = true;
        public boolean m = false;
        public String n;
        public String o;
        public int p;
        public int q;
        public d r;
        public ChannelIndexEntity.DataBean.ModuleDataBean s;
        public ModuleData.DataBean.DSLBean t;

        public c(String str, String str2, String str3) {
            this.b = str;
            this.c = str2;
            this.d = str3;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class d extends VideoPreviewReporter.a {
        public d(boolean z, boolean z2, boolean z3) {
            super(z, z2, z3);
        }
    }

    static {
        f();
        m = new VideoPreviewManager();
    }

    private VideoPreviewManager() {
    }

    private static /* synthetic */ void f() {
        e eVar = new e("VideoPreviewManager.java", VideoPreviewManager.class);
        n = eVar.H("method-execution", eVar.E("2", "videoPreviewInViewPage", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewManager", "java.util.HashMap", "map", "", "void"), 234);
        o = eVar.H("method-execution", eVar.E("0", "findViewPage", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewManager", "android.view.ViewGroup", ViewHierarchyConstants.VIEW_KEY, "", "androidx.viewpager.widget.ViewPager"), 424);
    }

    public static final /* synthetic */ ViewPager j(VideoPreviewManager videoPreviewManager, ViewGroup viewGroup, r.a.b.c cVar) {
        ViewPager findViewPage;
        if (viewGroup instanceof ViewPager) {
            return (ViewPager) viewGroup;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewPager childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewPager) {
                return childAt;
            }
            if ((childAt instanceof ViewGroup) && (findViewPage = videoPreviewManager.findViewPage((ViewGroup) childAt)) != null) {
                return findViewPage;
            }
        }
        return null;
    }

    public static VideoPreviewManager k() {
        return m;
    }

    private void o(ViewPager viewPager, HashMap<String, Integer> hashMap) {
        this.d = viewPager;
        this.h.a(viewPager.getCurrentItem());
        this.d.addOnPageChangeListener(this.h);
        videoPreviewInViewPage(hashMap);
    }

    private void r() {
    }

    private void s() {
        ViewGroup viewGroup;
        SkinnableFrameLayout skinnableFrameLayout = this.e;
        if (skinnableFrameLayout == null || (viewGroup = (ViewGroup) skinnableFrameLayout.getParent()) == null || viewGroup.indexOfChild(this.e) == -1) {
            return;
        }
        viewGroup.removeView(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(ViewPager viewPager, int i2) {
        if (viewPager instanceof AutoScrollViewPager) {
            if (i2 != -1) {
                ((AutoScrollViewPager) viewPager).startAutoScroll(i2);
            } else {
                ((AutoScrollViewPager) viewPager).startAutoScroll();
            }
        } else if (viewPager instanceof CustomViewPager) {
            MZBannerView mZBannerView = (ViewGroup) viewPager.getParent().getParent();
            if (mZBannerView instanceof MZBannerView) {
                if (i2 != -1) {
                    mZBannerView.R0(i2);
                } else {
                    mZBannerView.Q0();
                }
            }
        } else if (viewPager instanceof DynamicBanner) {
            if (i2 != -1) {
                ((DynamicBanner) viewPager).startAutoScroll();
            } else {
                ((DynamicBanner) viewPager).startAutoScroll(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void videoPreviewInViewPage(HashMap<String, Integer> hashMap) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.c(new Object[]{this, hashMap, e.w(n, this, this, hashMap)}).e(69648));
    }

    private void y(ViewPager viewPager) {
        if (viewPager instanceof AutoScrollViewPager) {
            ((AutoScrollViewPager) viewPager).h();
        } else if (viewPager instanceof CustomViewPager) {
            MZBannerView mZBannerView = (ViewGroup) viewPager.getParent().getParent();
            if (mZBannerView instanceof MZBannerView) {
                mZBannerView.pause();
            }
        } else if (viewPager instanceof DynamicBanner) {
            ((DynamicBanner) viewPager).I();
        }
    }

    public static final /* synthetic */ void z(VideoPreviewManager videoPreviewManager, HashMap hashMap, r.a.b.c cVar) {
        View childAt;
        c cVar2;
        if (videoPreviewManager.d.getAdapter() instanceof j.v.s.a.a.b.a) {
            ViewPager viewPager = videoPreviewManager.d;
            childAt = viewPager.findViewWithTag(Integer.valueOf(viewPager.getCurrentItem()));
        } else {
            ViewPager viewPager2 = videoPreviewManager.d;
            childAt = viewPager2.getChildAt(viewPager2.getCurrentItem());
        }
        if (childAt == null) {
            return;
        }
        videoPreviewManager.s();
        ViewGroup viewGroup = (ViewGroup) childAt.findViewById(b.j.video_preview_frame);
        if (viewGroup == null) {
            viewGroup = (ViewGroup) childAt.findViewById(b.j.dsl_tag_playerview);
        }
        videoPreviewManager.y(videoPreviewManager.d);
        boolean z = true;
        if (viewGroup != null && (cVar2 = (c) viewGroup.getTag(b.j.video_preview_data_id)) != null) {
            videoPreviewManager.n();
            if (videoPreviewManager.e == null) {
                VideoPreviewView videoPreviewView = new VideoPreviewView(childAt.getContext(), false);
                videoPreviewManager.e = videoPreviewView;
                videoPreviewView.setLoopMode(videoPreviewManager.b);
            }
            int i2 = videoPreviewManager.a;
            if (i2 == 3 && HugeMananger.h().hasHugeData() && HugeMananger.h().l(cVar2.j)) {
                videoPreviewManager.e.setShowAdView(false);
                i2 = 2;
            } else {
                videoPreviewManager.e.setShowAdView(true);
            }
            videoPreviewManager.e.G1(cVar2, viewGroup, i2);
            videoPreviewManager.e.setControlType(i2);
            videoPreviewManager.e.setRelativeView(childAt.findViewById(b.j.ivImage), childAt.findViewById(b.j.shadow_mask));
            videoPreviewManager.e.setHistoryMap(hashMap);
            videoPreviewManager.e.setPreviewPlayListener(new a());
            z = true ^ videoPreviewManager.e.startViewPlay(viewGroup);
        }
        if (z) {
            videoPreviewManager.v(videoPreviewManager.d, 3000);
        } else {
            videoPreviewManager.y(videoPreviewManager.d);
        }
        if (videoPreviewManager.f == null) {
            videoPreviewManager.f = videoPreviewManager.i(videoPreviewManager.d);
        }
    }

    @Nullable
    @WithTryCatchRuntime
    public ViewPager findViewPage(ViewGroup viewGroup) {
        return (ViewPager) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.d(new Object[]{this, viewGroup, e.w(o, this, this, viewGroup)}).e(69648));
    }

    public void g(int i2, boolean z) {
        if (this.g != i2) {
            return;
        }
        s();
        ViewPager viewPager = this.d;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this.h);
            if (z) {
                v(this.d, -1);
            }
            this.d = null;
        }
        this.f = null;
        this.g = -1;
    }

    public void h(boolean z) {
        VideoPreviewView videoPreviewView = this.e;
        if (videoPreviewView != null) {
            videoPreviewView.setBackground(!z);
        }
    }

    public View i(ViewGroup viewGroup) {
        if (viewGroup != null) {
            Object tag = viewGroup.getTag(b.j.tag_video_preview_item_view);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                return viewGroup;
            }
            if (viewGroup.getParent() instanceof ViewGroup) {
                return i((ViewGroup) viewGroup.getParent());
            }
            return null;
        }
        return null;
    }

    public void l(VideoPreviewView videoPreviewView) {
        if (videoPreviewView == this.e) {
            this.f = null;
        }
    }

    public void m(int i2) {
        VideoPreviewView videoPreviewView;
        if (this.g != i2 || (videoPreviewView = this.e) == null) {
            return;
        }
        videoPreviewView.pause();
    }

    public void n() {
    }

    public void p() {
        s();
        VideoPreviewView videoPreviewView = this.e;
        if (videoPreviewView != null) {
            videoPreviewView.release();
            this.e = null;
        }
    }

    public void q() {
        r();
    }

    public void t(int i2) {
        VideoPreviewView videoPreviewView;
        if (this.g != i2 || (videoPreviewView = this.e) == null) {
            return;
        }
        videoPreviewView.resume();
    }

    public void u(boolean z) {
        if (this.b != z) {
            this.b = z;
            VideoPreviewView videoPreviewView = this.e;
            if (videoPreviewView != null) {
                videoPreviewView.setLoopMode(z);
            }
        }
    }

    public void w(View view, int i2, int i3) {
        c cVar;
        this.a = i3;
        if (this.f == view) {
            return;
        }
        s();
        r();
        this.g = i2;
        ViewPager viewPager = this.d;
        ViewGroup viewGroup = null;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this.h);
            v(this.d, -1);
            this.d = null;
        }
        HashMap<String, Integer> hashMap = this.c.get(i2);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.c.put(i2, hashMap);
        }
        if (view instanceof ViewGroup) {
            this.f = view;
            view.setTag(b.j.tag_video_preview_item_view, Boolean.TRUE);
            ViewPager findViewPage = findViewPage((ViewGroup) view);
            if (findViewPage != null) {
                o(findViewPage, hashMap);
                return;
            }
            int i4 = b.j.video_preview_frame;
            if (view.findViewById(i4) != null) {
                viewGroup = (ViewGroup) view.findViewById(i4);
            } else {
                int i5 = b.j.dsl_tag_playerview;
                if (view.findViewById(i5) != null) {
                    viewGroup = (ViewGroup) view.findViewById(i5);
                }
            }
            if (viewGroup == null || (cVar = (c) viewGroup.getTag(b.j.video_preview_data_id)) == null) {
                return;
            }
            n();
            if (this.e == null) {
                VideoPreviewView videoPreviewView = new VideoPreviewView(view.getContext(), false);
                this.e = videoPreviewView;
                videoPreviewView.setLoopMode(this.b);
            }
            this.e.G1(cVar, viewGroup, i3);
            this.e.setControlType(this.a);
            this.e.setRelativeView(new View[0]);
            this.e.setHistoryMap(hashMap);
            this.e.setShowAdView(true);
            this.e.startViewPlay(viewGroup);
        }
    }

    public void x(View view, int i2) {
        s();
        r();
        ViewPager viewPager = this.d;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this.h);
            v(this.d, -1);
            this.d = null;
        }
        if (this.c.get(i2) == null) {
            this.c.put(i2, new HashMap<>());
        }
        if (view instanceof ViewGroup) {
            this.f = view;
            ViewGroup viewGroup = (ViewGroup) view;
            c cVar = (c) view.getTag(b.j.video_preview_data_id);
        }
    }
}
