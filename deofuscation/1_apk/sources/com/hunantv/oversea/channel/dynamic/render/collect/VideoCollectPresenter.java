package com.hunantv.oversea.channel.dynamic.render.collect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.hunantv.imgo.net.ImgoHttpCallBack;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.playlib.entity.kandan.CollectPreAddEntity;
import com.hunantv.oversea.playlib.entity.kandan.CollectSearchEntity;
import com.hunantv.oversea.playlib.kandan.UserVideoCollectUtil;
import com.hunantv.oversea.session.global.SessionManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.json.JsonVoid;
import j.l.a.b0.o0;
import j.l.a.i.e.o;
import j.l.c.c.b;
import j.l.c.c.c.u1.v.n;
import j.l.c.c.c.u1.v.p;
import j.l.c.c.c.u1.v.q;
import j.v.r.r;
import java.util.HashMap;
import java.util.Map;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VideoCollectPresenter {
    public static final int a = 1;
    public static final int b = 3;
    public static Map<String, Boolean> c;
    private static final /* synthetic */ c.b d = null;
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends ImgoHttpCallBack<CollectSearchEntity> {
        public final /* synthetic */ e d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public a(e eVar, int i, String str, String str2) {
            this.d = eVar;
            this.e = i;
            this.f = str;
            this.g = str2;
        }

        /* renamed from: w */
        public void failed(CollectSearchEntity collectSearchEntity, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            VideoCollectPresenter.this.queryLocalCollect(this.e, this.f, this.g, this.d);
        }

        @Override // com.hunantv.imgo.net.ImgoHttpCallBack
        /* renamed from: x */
        public void previewCache(@Nullable CollectSearchEntity collectSearchEntity) {
        }

        /* renamed from: y */
        public void success(@NonNull CollectSearchEntity collectSearchEntity) {
            CollectSearchEntity.Data data = collectSearchEntity.data;
            if (data == null) {
                VideoCollectPresenter.this.queryLocalCollect(this.e, this.f, this.g, this.d);
                return;
            }
            boolean z = data.isCollect == 1;
            e eVar = this.d;
            if (eVar != null) {
                eVar.a(z);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends j.l.a.r.d {
        public final /* synthetic */ f d;

        public b(f fVar) {
            this.d = fVar;
        }

        public void l(int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.l(i, i2, str, th);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o0.o(str);
        }

        public void success(JsonVoid jsonVoid) {
            super.success(jsonVoid);
            o0.n(b.r.channel_add_collect_success);
            f fVar = this.d;
            if (fVar != null) {
                fVar.b(true);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c extends ImgoHttpCallBack<CollectPreAddEntity> {
        public final /* synthetic */ f d;

        public c(f fVar) {
            this.d = fVar;
        }

        /* renamed from: w */
        public void failed(@Nullable CollectPreAddEntity collectPreAddEntity, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(collectPreAddEntity, i, i2, str, th);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o0.o(str);
        }

        /* renamed from: x */
        public void success(@NonNull CollectPreAddEntity collectPreAddEntity) {
            if (collectPreAddEntity.data != null) {
                o0.n(b.r.channel_add_collect_success);
                f fVar = this.d;
                if (fVar != null) {
                    fVar.b(true);
                }
                o oVar = new o();
                CollectPreAddEntity.Data data = collectPreAddEntity.data;
                oVar.b = data.pid;
                oVar.f = data.vid;
                oVar.c = Integer.valueOf(data.type);
                CollectPreAddEntity.Data data2 = collectPreAddEntity.data;
                oVar.e = data2.createTime;
                oVar.d = Integer.valueOf(data2.vType);
                j.l.c.u.z.a.l(j.l.a.a.a()).b(oVar);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class d extends j.l.a.r.d {
        public final /* synthetic */ f d;

        public d(f fVar) {
            this.d = fVar;
        }

        /* renamed from: x */
        public void failed(@Nullable JsonVoid jsonVoid, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o0.o(str);
        }

        public void success(JsonVoid jsonVoid) {
            o0.n(b.r.channel_remove_collect_success);
            f fVar = this.d;
            if (fVar != null) {
                fVar.a(true);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface e {
        void a(boolean z);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface f {
        void a(boolean z);

        void b(boolean z);
    }

    static {
        c();
        c = new HashMap();
    }

    public static final /* synthetic */ void b(VideoCollectPresenter videoCollectPresenter, r rVar, String str, String str2, f fVar, r.a.b.c cVar) {
        if (rVar == null) {
            if (fVar != null) {
                fVar.b(false);
            }
        } else if (SessionManager.m()) {
            UserVideoCollectUtil.a(rVar, new b(fVar), "", str2, str);
        } else {
            UserVideoCollectUtil.b(rVar, new c(fVar), "", str2, str);
        }
    }

    private static /* synthetic */ void c() {
        r.a.c.c.e eVar = new r.a.c.c.e("VideoCollectPresenter.java", VideoCollectPresenter.class);
        d = eVar.H("method-execution", eVar.E("9", "getCollectStatus", "com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter", "java.lang.String", SDKConstants.PARAM_KEY, "", "boolean"), 61);
        e = eVar.H("method-execution", eVar.E("1", "findCollect", "com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter", "com.mgtv.task.TaskStarter:int:java.lang.String:java.lang.String:com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter$FindCollectListener", "taskStarter:videoType:videoId:clipId:listener", "", "void"), 80);
        f = eVar.H("method-execution", eVar.E("2", "queryLocalCollect", "com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter", "int:java.lang.String:java.lang.String:com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter$FindCollectListener", "videoType:videoId:clipId:listener", "", "void"), 126);
        g = eVar.H("method-execution", eVar.E("1", "addToCollect", "com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter", "com.mgtv.task.TaskStarter:java.lang.String:java.lang.String:com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter$OnCollectListener", "taskStarter:videoId:clipId:listener", "", "void"), (int) EventClickData.u.P0);
        h = eVar.H("method-execution", eVar.E("1", "removeFromCollect", "com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter", "com.mgtv.task.TaskStarter:int:java.lang.String:java.lang.String:com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter$OnCollectListener", "taskStarter:videoType:videoId:clipId:listener", "", "void"), (int) IDrmSession.ERROR_SESSION_DRM_LICENSE_URL_EMPTY);
    }

    public static void d() {
        c.clear();
    }

    public static boolean e(String str) {
        return c.containsKey(str);
    }

    public static final /* synthetic */ void f(VideoCollectPresenter videoCollectPresenter, r rVar, int i, String str, String str2, e eVar, r.a.b.c cVar) {
        if (rVar == null) {
            if (eVar != null) {
                eVar.a(false);
            }
        } else if (SessionManager.m()) {
            UserVideoCollectUtil.q(rVar, new a(eVar, i, str, str2), "", str2, str);
        } else {
            videoCollectPresenter.queryLocalCollect(i, str, str2, eVar);
        }
    }

    public static final /* synthetic */ boolean g(String str, r.a.b.c cVar) {
        Boolean bool = c.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WithTryCatchRuntime
    public static boolean getCollectStatus(String str) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n(new Object[]{str, r.a.c.c.e.w(d, (Object) null, (Object) null, str)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)));
    }

    public static void h(String str, boolean z) {
        if (SessionManager.m()) {
            c.put(str, Boolean.valueOf(z));
        }
    }

    public static final /* synthetic */ void i(VideoCollectPresenter videoCollectPresenter, int i, String str, String str2, e eVar, r.a.b.c cVar) {
        o oVar = new o();
        oVar.d = Integer.valueOf(i);
        if (i == 1) {
            oVar.b = str2;
        } else {
            oVar.f = str;
        }
        boolean m = j.l.c.u.z.a.l(j.l.a.a.a()).m(oVar);
        if (eVar != null) {
            eVar.a(m);
        }
    }

    public static final /* synthetic */ void j(VideoCollectPresenter videoCollectPresenter, r rVar, int i, String str, String str2, f fVar, r.a.b.c cVar) {
        if (SessionManager.m()) {
            UserVideoCollectUtil.h(rVar, new d(fVar), "", str2, str);
            return;
        }
        o oVar = new o();
        oVar.d = Integer.valueOf(i);
        if (i == 1) {
            oVar.b = str2;
        } else {
            oVar.f = str;
        }
        j.l.c.u.z.a.l(j.l.a.a.a()).g(oVar);
        o0.n(b.r.channel_remove_collect_success);
        if (fVar != null) {
            fVar.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void queryLocalCollect(int i, String str, String str2, e eVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new p(new Object[]{this, r.a.c.b.e.k(i), str, str2, eVar, r.a.c.c.e.y(f, this, this, new Object[]{r.a.c.b.e.k(i), str, str2, eVar})}).e(69648));
    }

    @WithTryCatchRuntime
    public void addToCollect(r rVar, String str, String str2, f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new q(new Object[]{this, rVar, str, str2, fVar, r.a.c.c.e.y(g, this, this, new Object[]{rVar, str, str2, fVar})}).e(69648));
    }

    @WithTryCatchRuntime
    public void findCollect(r rVar, int i, String str, String str2, e eVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.v.o(new Object[]{this, rVar, r.a.c.b.e.k(i), str, str2, eVar, r.a.c.c.e.y(e, this, this, new Object[]{rVar, r.a.c.b.e.k(i), str, str2, eVar})}).e(69648));
    }

    @WithTryCatchRuntime
    public void removeFromCollect(r rVar, int i, String str, String str2, f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.v.r(new Object[]{this, rVar, r.a.c.b.e.k(i), str, str2, fVar, r.a.c.c.e.y(h, this, this, new Object[]{rVar, r.a.c.b.e.k(i), str, str2, fVar})}).e(69648));
    }
}
