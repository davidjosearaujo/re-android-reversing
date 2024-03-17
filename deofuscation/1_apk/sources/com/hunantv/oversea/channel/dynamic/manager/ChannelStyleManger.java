package com.hunantv.oversea.channel.dynamic.manager;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.hunantv.imgo.net.ImgoHttpParams;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.oversea.channel.dynamic.style.StyleMap;
import com.hunantv.oversea.channel.dynamic.style.xml.MixedDynamicStyleResponse;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.task.http.HttpResponseObject;
import j.l.a.m.b.g;
import j.l.c.c.c.t1.f;
import j.l.c.c.c.v1.h;
import j.l.c.c.d.d;
import j.v.r.m;
import j.v.r.p;
import j.v.r.r;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelStyleManger extends j.l.c.c.c.s1.a {
    private static final String d = "ChannelDynamicStyleManger";
    private static final String e = "https://dc.bz.mgtv.com/dynamic/v1/dsl/list";
    private static final /* synthetic */ c.b f = null;
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private boolean c;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MixedDynamicStyleResponse diskCache = StyleMap.getDiskCache(ChannelStyleManger.e);
            if (diskCache != null) {
                ChannelStyleManger.this.e(diskCache.data, (j.l.c.c.c.w1.a) null);
                StringBuilder sb = new StringBuilder();
                sb.append("load dsl style success[Disk],size:");
                List<MixedDynamicStyleResponse.DSLEntity> list = diskCache.data;
                sb.append(list == null ? 0 : list.size());
                j.l.a.n.m.a.d("30", "DynamicData", sb.toString());
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends j.l.c.c.c.q1.a<MixedDynamicStyleResponse> {

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public class a implements j.l.c.c.c.w1.a {
            public boolean a = false;
            public final /* synthetic */ boolean b;

            public a(boolean z) {
                this.b = z;
            }

            public void a(ArrayList<String> arrayList) {
                this.a = true;
                StringBuilder sb = new StringBuilder();
                sb.append("load dsl style,onDslUpdate: size=");
                sb.append(arrayList == null ? 0 : arrayList.size());
                j.l.a.n.m.a.d("30", ChannelStyleManger.d, sb.toString());
            }

            public void onComplete() {
                d dVar = new d();
                ((j.l.a.m.b.b) dVar).b = "load_dsl_style_success";
                ((j.l.a.m.b.b) dVar).f = this.b || this.a;
                g.b(d.class).a(dVar);
                j.l.a.n.m.a.d("30", ChannelStyleManger.d, "load dsl style,onComplete: isFirstEmpty=" + this.b + " ,needUpdate=" + this.a);
            }
        }

        public b() {
        }

        /* renamed from: x */
        public void failed(@Nullable MixedDynamicStyleResponse mixedDynamicStyleResponse, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super/*com.mgtv.task.http.HttpCallBack*/.failed(mixedDynamicStyleResponse, i, i2, str, th);
            ChannelStyleManger.this.c = false;
            StringBuilder sb = new StringBuilder();
            sb.append("load dsl style failed,httpStatus:");
            sb.append(i);
            sb.append(", info:");
            sb.append(str);
            sb.append(",error:");
            sb.append(th == null ? "" : th.getMessage());
            j.l.a.n.m.a.d("30", ChannelStyleManger.d, sb.toString());
        }

        /* renamed from: y */
        public void previewCache(MixedDynamicStyleResponse mixedDynamicStyleResponse) {
        }

        /* renamed from: z */
        public void success(MixedDynamicStyleResponse mixedDynamicStyleResponse) {
            ChannelStyleManger.this.c = false;
            if (r() != null && !TextUtils.isEmpty(r().getFinalUrl())) {
                StringBuilder sb = new StringBuilder();
                sb.append("load dsl style success[Http],size:");
                List<MixedDynamicStyleResponse.DSLEntity> list = mixedDynamicStyleResponse.data;
                sb.append(list != null ? list.size() : 0);
                j.l.a.n.m.a.d("30", ChannelStyleManger.d, sb.toString());
                List<MixedDynamicStyleResponse.DSLEntity> list2 = mixedDynamicStyleResponse.data;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                ChannelStyleManger.this.e(mixedDynamicStyleResponse.data, new a(ChannelStyleManger.this.isEmpty()));
                StyleMap.putDiskCache(ChannelStyleManger.e, mixedDynamicStyleResponse);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load dsl style success[Memory],size:");
            List<MixedDynamicStyleResponse.DSLEntity> list3 = mixedDynamicStyleResponse.data;
            sb2.append(list3 != null ? list3.size() : 0);
            j.l.a.n.m.a.d("30", ChannelStyleManger.d, sb2.toString());
        }

        public void onCancelled(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
            super/*com.mgtv.task.http.HttpCallBack*/.onCancelled(httpResponseObject, obj, th);
            j.l.a.n.m.a.d("30", ChannelStyleManger.d, "load dsl style canceled");
        }

        public void onPostExecute(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
            super.onPostExecute(httpResponseObject, obj, th);
            new h().e(r(), "", w());
            j.l.a.n.m.a.d("30", ChannelStyleManger.d, "load dsl style cost=" + w());
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class c {
        private static final ChannelStyleManger a = new ChannelStyleManger(null);

        private c() {
        }
    }

    static {
        l();
    }

    public /* synthetic */ ChannelStyleManger(a aVar) {
        this();
    }

    private static /* synthetic */ void l() {
        e eVar = new e("ChannelStyleManger.java", ChannelStyleManger.class);
        f = eVar.H("method-execution", eVar.E("1", MgtvMediaPlayer.DataSourceInfo.INIT_VALUE, "com.hunantv.oversea.channel.dynamic.manager.ChannelStyleManger", "", "", "", "void"), 65);
        g = eVar.H("method-execution", eVar.E("2", "preload", "com.hunantv.oversea.channel.dynamic.manager.ChannelStyleManger", "", "", "", "void"), 73);
        h = eVar.H("method-execution", eVar.E("1", "requestStyle", "com.hunantv.oversea.channel.dynamic.manager.ChannelStyleManger", "", "", "", "void"), 93);
    }

    public static ChannelStyleManger m() {
        return c.a;
    }

    public static final /* synthetic */ void n(ChannelStyleManger channelStyleManger, r.a.b.c cVar) {
        channelStyleManger.preload();
        channelStyleManger.requestStyle();
    }

    public static final /* synthetic */ void p(ChannelStyleManger channelStyleManger, r.a.b.c cVar) {
        if (channelStyleManger.c) {
            return;
        }
        channelStyleManger.c = true;
        j.l.c.c.c.q1.b bVar = new j.l.c.c.c.q1.b(e);
        bVar.b("10100001");
        bVar.b(j.l.a.k.b.b());
        bVar.b("12");
        bVar.b("0");
        new r(j.l.a.a.a(), new m(ThreadManager.getNetWorkExecutorService(), false), (p) null).n(true).o().u(bVar.toString(), new ImgoHttpParams(), new b());
    }

    @WithTryCatchRuntime
    private void preload() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.s1.c(new Object[]{this, e.v(g, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void init() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.s1.b(new Object[]{this, e.v(f, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void requestStyle() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.s1.d(new Object[]{this, e.v(h, this, this)}).e(69648));
    }

    private ChannelStyleManger() {
        this.c = false;
        ((j.l.c.c.c.s1.a) this).b.j(new j.l.c.c.c.t1.e(this));
        ((j.l.c.c.c.s1.a) this).b.k(new f());
        ((j.l.c.c.c.s1.a) this).b.e(this);
    }
}
