package com.hunantv.oversea.channel.selected.delegate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.hunantv.imgo.global.AgeDataModel;
import com.hunantv.oversea.channel.widget.ChannelDragLayout;
import com.hunantv.oversea.main.common.layerconf.LayerConfig;
import com.hunantv.oversea.main.common.layerconf.LayerConfigEntity;
import com.hunantv.oversea.report.ReportManager;
import com.hunantv.oversea.report.data.cv.lob.CornerMarkCvLob;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.f.w0.b;
import j.l.c.z.c.d;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DragLayoutDelegate {
    private static final String e = "DragLayoutDelegate";
    private static final /* synthetic */ c.b f = null;
    public Context a;
    public ChannelDragLayout b;
    public b c;
    private boolean d = true;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements ChannelDragLayout.e {
        public final /* synthetic */ LayerConfigEntity.DataBean.LayerBean a;
        public final /* synthetic */ String b;

        public a(LayerConfigEntity.DataBean.LayerBean layerBean, String str) {
            this.a = layerBean;
            this.b = str;
        }

        @Override // com.hunantv.oversea.channel.widget.ChannelDragLayout.e
        @SuppressLint({"DefaultLocale"})
        public void a() {
            LayerConfig.e().reportClick(this.a);
            LayerConfig.e().reportClick("1", String.format("aid=%1$d&lt=%2$d&p=%3$d&bz=%4$s", Integer.valueOf(this.a.aid), Integer.valueOf(this.a.layer_type), Integer.valueOf(this.a.position), this.a.bz), "619");
            DragLayoutDelegate.this.g(this.b);
        }

        @Override // com.hunantv.oversea.channel.widget.ChannelDragLayout.e
        @SuppressLint({"DefaultLocale"})
        public void onClose() {
            LayerConfig.e().reportClose(this.a);
            LayerConfig.e().reportClick("2", String.format("aid=%1$d&lt=%2$d&p=%3$d&bz=%4$s", Integer.valueOf(this.a.aid), Integer.valueOf(this.a.layer_type), Integer.valueOf(this.a.position), this.a.bz), "619");
            DragLayoutDelegate.this.d = false;
            ChannelDragLayout channelDragLayout = DragLayoutDelegate.this.b;
            if (channelDragLayout != null) {
                channelDragLayout.u0();
            }
        }
    }

    static {
        c();
    }

    public DragLayoutDelegate(Context context, ChannelDragLayout channelDragLayout, b bVar) {
        this.a = context;
        this.b = channelDragLayout;
        this.c = bVar;
    }

    private static /* synthetic */ void c() {
        e eVar = new e("DragLayoutDelegate.java", DragLayoutDelegate.class);
        f = eVar.H("method-execution", eVar.E("1", "showDragEnter", "com.hunantv.oversea.channel.selected.delegate.DragLayoutDelegate", "", "", "", "void"), 55);
    }

    private boolean e() {
        this.c.isAtHome();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        Log.w(e, "openWeb: TODO: 打开网页 url=" + str);
        d.i(this.a, str);
    }

    public static final /* synthetic */ void h(DragLayoutDelegate dragLayoutDelegate, c cVar) {
        if (AgeDataModel.b().d() || dragLayoutDelegate.b == null) {
            return;
        }
        LayerConfigEntity.DataBean.LayerBean channelIcon = LayerConfig.e().getChannelIcon("ch_channel");
        if (channelIcon != null && dragLayoutDelegate.d) {
            try {
                if (TextUtils.isEmpty(channelIcon.img)) {
                    dragLayoutDelegate.d = false;
                    dragLayoutDelegate.d();
                    return;
                }
                String str = channelIcon.landing;
                dragLayoutDelegate.b.setDuration(channelIcon.duration);
                dragLayoutDelegate.b.setImageUrl(channelIcon.img);
                dragLayoutDelegate.b.setOnInnerClickListener(new a(channelIcon, str));
                if (!dragLayoutDelegate.e()) {
                    dragLayoutDelegate.d();
                    return;
                } else if (dragLayoutDelegate.b.w0()) {
                    return;
                } else {
                    j.l.a.n.m.a.d("30", e, "show dialog: drag enter");
                    LayerConfig.e().reportPv(channelIcon);
                    dragLayoutDelegate.b.v0();
                    CornerMarkCvLob cornerMarkCvLob = new CornerMarkCvLob();
                    cornerMarkCvLob.aid = channelIcon.aid;
                    cornerMarkCvLob.lt = channelIcon.layer_type;
                    cornerMarkCvLob.p = channelIcon.position;
                    cornerMarkCvLob.bz = channelIcon.bz;
                    ReportManager.b().g("c_cornermarker", "ch_channel", cornerMarkCvLob);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                dragLayoutDelegate.d = false;
                dragLayoutDelegate.d();
                return;
            }
        }
        dragLayoutDelegate.d();
    }

    public void d() {
        ChannelDragLayout channelDragLayout = this.b;
        if (channelDragLayout != null) {
            channelDragLayout.hide();
        }
    }

    public void f(int i) {
        if (e()) {
            showDragEnter();
        } else {
            d();
        }
    }

    @WithTryCatchRuntime
    public void showDragEnter() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.w0.a(new Object[]{this, e.v(f, this, this)}).e(69648));
    }
}
