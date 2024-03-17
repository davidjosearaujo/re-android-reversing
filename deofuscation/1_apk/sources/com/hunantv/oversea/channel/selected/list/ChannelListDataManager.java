package com.hunantv.oversea.channel.selected.list;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.imageutils.JfifUtil;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.channel.selected.data.ChannelListEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.c0;
import j.l.a.b0.f0;
import j.l.c.c.f.x0.a;
import j.l.c.c.f.x0.b;
import j.l.c.c.f.x0.d;
import j.l.c.c.f.x0.f;
import j.l.c.c.f.x0.g;
import j.l.c.c.f.x0.h;
import j.l.c.c.f.x0.i;
import j.l.c.c.f.x0.j;
import j.l.c.c.f.x0.k;
import j.l.c.c.f.x0.l;
import j.l.c.c.f.x0.m;
import j.l.c.c.f.x0.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelListDataManager {
    public static boolean d = false;
    private static final String e = "pref_key_custom_show_channel_count";
    private static final String f = "pref_key_custom_is_show_reddot";
    private static final String g = "https://mob.bz.mgtv.com/odin/c1/channel/list";
    private static final String h = "key_operation";
    private static final ChannelListDataManager i;
    private static final /* synthetic */ c.b j = null;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private static final /* synthetic */ c.b p = null;
    private static final /* synthetic */ c.b q = null;
    private static final /* synthetic */ c.b r = null;
    private static final /* synthetic */ c.b s = null;
    private static final /* synthetic */ c.b t = null;
    private static final /* synthetic */ c.b u = null;
    @Nullable
    private ChannelListEntity a;
    private List<ChannelListEntity.DataBean> b = new ArrayList();
    private Comparator<ChannelListEntity.DataBean> c = new Comparator<ChannelListEntity.DataBean>() { // from class: com.hunantv.oversea.channel.selected.list.ChannelListDataManager.1
        private static final /* synthetic */ c.b b = null;
        private static final /* synthetic */ c.b c = null;

        static {
            a();
        }

        private static /* synthetic */ void a() {
            e eVar = new e("ChannelListDataManager.java", AnonymousClass1.class);
            b = eVar.H("method-execution", eVar.E("1", "compare", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager$1", "com.hunantv.oversea.channel.selected.data.ChannelListEntity$DataBean:com.hunantv.oversea.channel.selected.data.ChannelListEntity$DataBean", "o1:o2", "", "int"), (int) IDrmSession.ERROR_SESSION_PROVISION_NO_SELECT_DRM);
            c = eVar.H("method-execution", eVar.E("2", "switchCustompostion", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager$1", "com.hunantv.oversea.channel.selected.data.ChannelListEntity$DataBean", "dataBean", "", "int"), 218);
        }

        public static final /* synthetic */ int b(AnonymousClass1 anonymousClass1, ChannelListEntity.DataBean dataBean, ChannelListEntity.DataBean dataBean2, c cVar) {
            if (dataBean == null || dataBean2 == null) {
                return 0;
            }
            return anonymousClass1.switchCustompostion(dataBean) - anonymousClass1.switchCustompostion(dataBean2);
        }

        public static final /* synthetic */ int c(AnonymousClass1 anonymousClass1, ChannelListEntity.DataBean dataBean, c cVar) {
            if (dataBean == null) {
                return 2;
            }
            int g2 = c0.g(dataBean.customPosition, 2);
            if (dataBean.cache && g2 == 2) {
                g2 = 1;
            }
            if (g2 == 2) {
                return 1;
            }
            if (g2 == 1) {
                return 2;
            }
            return g2;
        }

        @WithTryCatchRuntime
        private int switchCustompostion(ChannelListEntity.DataBean dataBean) {
            return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b(new Object[]{this, dataBean, e.w(c, this, this, dataBean)}).e(69648)));
        }

        @Override // java.util.Comparator
        @WithTryCatchRuntime
        public int compare(ChannelListEntity.DataBean dataBean, ChannelListEntity.DataBean dataBean2) {
            return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a(new Object[]{this, dataBean, dataBean2, e.x(b, this, this, dataBean, dataBean2)}).e(69648)));
        }
    };

    static {
        a();
        d = false;
        i = new ChannelListDataManager();
    }

    private ChannelListDataManager() {
        List<ChannelListEntity.DataBean> list;
        ChannelListEntity channelListEntity = (ChannelListEntity) j.l.a.r.a.d().b(g);
        if (channelListEntity != null && (list = channelListEntity.data) != null) {
            this.b.addAll(list);
        }
        this.a = channelListEntity;
    }

    private static /* synthetic */ void a() {
        e eVar = new e("ChannelListDataManager.java", ChannelListDataManager.class);
        j = eVar.H("method-execution", eVar.E("1", "getChannelData", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "", "", "", "java.util.List"), 79);
        k = eVar.H("method-execution", eVar.E("22", "saveChannelListEntity", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "com.hunantv.oversea.channel.selected.data.ChannelListEntity", "entity", "", "void"), 89);
        t = eVar.H("method-execution", eVar.E("1", "incReddotCount", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "", "", "", "void"), 327);
        u = eVar.H("method-execution", eVar.E("1", "notifyRequest", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "", "", "", "void"), 339);
        l = eVar.H("method-execution", eVar.E("1", "saveAndGetChannelListEntity", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "com.hunantv.oversea.channel.selected.data.ChannelListEntity", "entity", "", "void"), 113);
        m = eVar.H("method-execution", eVar.E("2", "checkDataBean", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "com.hunantv.oversea.channel.selected.data.ChannelListEntity$DataBean:com.hunantv.oversea.channel.selected.data.ChannelListEntity$DataBean", "oldBean:newBean", "", "boolean"), 125);
        n = eVar.H("method-execution", eVar.E("22", "sortDataBean", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "java.util.List", "newDataBeans", "", "void"), (int) EventClickData.u.J0);
        o = eVar.H("method-execution", eVar.E("22", "forbidSort", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "java.util.List", "newDataBeans", "", "void"), 176);
        p = eVar.H("method-execution", eVar.E("21", "updateLinkDataBean", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "java.util.List", "dataBeans", "", "void"), 239);
        q = eVar.H("method-execution", eVar.E("1", "isEmpty", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "", "", "", "boolean"), (int) JfifUtil.MARKER_FIRST_BYTE);
        r = eVar.H("method-execution", eVar.E("1", "setOperation", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "boolean", "operation", "", "void"), 265);
        s = eVar.H("method-execution", eVar.E("1", "isShowReddot", "com.hunantv.oversea.channel.selected.list.ChannelListDataManager", "", "", "", "boolean"), 311);
    }

    public static final /* synthetic */ boolean b(ChannelListDataManager channelListDataManager, ChannelListEntity.DataBean dataBean, ChannelListEntity.DataBean dataBean2, c cVar) {
        if (dataBean == null || dataBean2 == null) {
            return false;
        }
        return dataBean.checkEquals(dataBean2);
    }

    @WithTryCatchRuntime
    private boolean checkDataBean(@Nullable ChannelListEntity.DataBean dataBean, @Nullable ChannelListEntity.DataBean dataBean2) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new m(new Object[]{this, dataBean, dataBean2, e.x(m, this, this, dataBean, dataBean2)}).e(69648)));
    }

    public static final /* synthetic */ void d(ChannelListDataManager channelListDataManager, List list, c cVar) {
        if (list == null) {
            return;
        }
        for (int i2 = 0; i2 < channelListDataManager.b.size(); i2++) {
            ChannelListEntity.DataBean dataBean = channelListDataManager.b.get(i2);
            if (dataBean != null && c0.g(dataBean.customPosition, 1) == 0) {
                channelListDataManager.b.remove(i2);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ChannelListEntity.DataBean dataBean2 = (ChannelListEntity.DataBean) it.next();
            if (dataBean2 != null && c0.g(dataBean2.customPosition, 1) == 0) {
                arrayList.add(dataBean2);
            }
        }
        channelListDataManager.b.addAll(0, arrayList);
    }

    public static final /* synthetic */ List f(ChannelListDataManager channelListDataManager, c cVar) {
        return new ArrayList(channelListDataManager.b);
    }

    @WithTryCatchRuntime
    private synchronized void forbidSort(@Nullable List<ChannelListEntity.DataBean> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.x0.c(new Object[]{this, list, e.w(o, this, this, list)}).e(69648));
    }

    public static ChannelListDataManager h() {
        return i;
    }

    public static final /* synthetic */ boolean l(ChannelListDataManager channelListDataManager, c cVar) {
        if (f0.d(f, true)) {
            boolean z = f0.h(e, 0) < 4 && !channelListDataManager.i();
            f0.p(f, z);
            return z && !d;
        }
        return false;
    }

    public static final /* synthetic */ void m(ChannelListDataManager channelListDataManager, c cVar) {
    }

    public static final /* synthetic */ void o(ChannelListDataManager channelListDataManager, ChannelListEntity channelListEntity, c cVar) {
        if (channelListEntity != null && channelListEntity.data != null) {
            if (!channelListDataManager.b.isEmpty() && f0.d(h, false)) {
                channelListDataManager.sortDataBean(channelListEntity.data);
            } else {
                channelListDataManager.b.clear();
                channelListDataManager.b.addAll(channelListEntity.data);
            }
            Collections.sort(channelListDataManager.b, channelListDataManager.c);
            channelListEntity.data = new ArrayList(channelListDataManager.b);
            j.l.a.r.a.d().f(g, channelListEntity);
            channelListDataManager.a = channelListEntity;
            return;
        }
        channelListDataManager.b.clear();
        channelListDataManager.a = null;
    }

    public static final /* synthetic */ void q(ChannelListDataManager channelListDataManager, List list, c cVar) {
        boolean z;
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        channelListDataManager.forbidSort(arrayList);
        int i2 = 0;
        while (i2 < channelListDataManager.b.size()) {
            ChannelListEntity.DataBean dataBean = channelListDataManager.b.get(i2);
            int i3 = 0;
            while (true) {
                z = true;
                if (i3 >= arrayList.size()) {
                    z = false;
                    break;
                }
                ChannelListEntity.DataBean dataBean2 = arrayList.get(i3);
                if (channelListDataManager.checkDataBean(dataBean, dataBean2)) {
                    dataBean.copyData(dataBean2);
                    dataBean.cache = true;
                    arrayList.remove(i3);
                    break;
                }
                i3++;
            }
            if (z) {
                i2++;
            } else {
                channelListDataManager.b.remove(i2);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        channelListDataManager.b.addAll(arrayList);
    }

    public static final /* synthetic */ void r(ChannelListDataManager channelListDataManager, List list, c cVar) {
        if (list == null) {
            return;
        }
        channelListDataManager.b.clear();
        channelListDataManager.b.addAll(list);
        ChannelListEntity channelListEntity = new ChannelListEntity();
        channelListEntity.data = new ArrayList(channelListDataManager.b);
        j.l.a.r.a.d().f(g, channelListEntity);
        channelListDataManager.a = channelListEntity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public synchronized void saveChannelListEntity(@Nullable ChannelListEntity channelListEntity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{this, channelListEntity, e.w(k, this, this, channelListEntity)}).e(69648));
    }

    @WithTryCatchRuntime
    private synchronized void sortDataBean(@Nullable List<ChannelListEntity.DataBean> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n(new Object[]{this, list, e.w(n, this, this, list)}).e(69648));
    }

    public void c() {
        if (this.a != null) {
            this.a = null;
        }
        List<ChannelListEntity.DataBean> list = this.b;
        if (list != null) {
            list.clear();
        }
        j.l.a.r.a.d().h(g);
        setOperation(false);
    }

    @Nullable
    public ChannelListEntity e() {
        return this.a;
    }

    public String g() {
        List<ChannelListEntity.DataBean> list = this.b;
        if (list == null) {
            return "";
        }
        for (ChannelListEntity.DataBean dataBean : list) {
            if (TextUtils.equals(dataBean.channelSource, "1")) {
                return dataBean.vclassId;
            }
        }
        return "";
    }

    @WithTryCatchRuntime
    public List<ChannelListEntity.DataBean> getChannelData() {
        return (List) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h(new Object[]{this, e.v(j, this, this)}).e(69648));
    }

    public boolean i() {
        List<ChannelListEntity.DataBean> list = this.b;
        if (list == null) {
            return false;
        }
        for (ChannelListEntity.DataBean dataBean : list) {
            if (TextUtils.equals(dataBean.channelSource, "1")) {
                return true;
            }
        }
        return false;
    }

    @WithTryCatchRuntime
    public void incReddotCount() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, e.v(t, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public boolean isEmpty() {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.x0.e(new Object[]{this, e.v(q, this, this)}).e(69648)));
    }

    @WithTryCatchRuntime
    public boolean isShowReddot() {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g(new Object[]{this, e.v(s, this, this)}).e(69648)));
    }

    @WithTryCatchRuntime
    public void notifyRequest() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j(new Object[]{this, e.v(u, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void saveAndGetChannelListEntity(@Nullable ChannelListEntity channelListEntity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{this, channelListEntity, e.w(l, this, this, channelListEntity)}).e(69648));
    }

    @WithTryCatchRuntime
    public void setOperation(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, r.a.c.b.e.a(z), e.w(r, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    @WithTryCatchRuntime
    @Deprecated
    public synchronized void updateLinkDataBean(List<ChannelListEntity.DataBean> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{this, list, e.w(p, this, this, list)}).e(69648));
    }
}
