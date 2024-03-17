package com.hunantv.oversea.channel.dynamic.business.preview;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.hunantv.oversea.channel.dynamic.ChannelDynamicAdapter;
import com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment;
import com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.v.g.k.d;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicPreviewFragment extends ChannelDynamicFragment {
    public static final String Q2 = "pre_params";
    private static final /* synthetic */ c.b R2 = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements d {
        public a() {
        }

        public void a(View view, j.v.g.d.a aVar) {
            DynamicPreviewFragment.this.handleAction(view, aVar);
        }
    }

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("DynamicPreviewFragment.java", DynamicPreviewFragment.class);
        R2 = eVar.H("method-execution", eVar.E("4", "updateChannelTitle", "com.hunantv.oversea.channel.dynamic.business.preview.DynamicPreviewFragment", "", "", "", "void"), 68);
    }

    public static final /* synthetic */ void u1(DynamicPreviewFragment dynamicPreviewFragment, c cVar) {
        ChannelDynamicPresenter channelDynamicPresenter = dynamicPreviewFragment.k;
        if (channelDynamicPresenter != null) {
            String s = channelDynamicPresenter.s();
            if (dynamicPreviewFragment.getActivity() instanceof ChannelPreviewActivity) {
                dynamicPreviewFragment.getActivity().setChannelTitle(s);
            }
        }
    }

    @Override // com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment
    public void j(int i, boolean z) {
        super.j(i, z);
        updateChannelTitle();
    }

    @Override // com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment, com.hunantv.imgo.base.RootFragment
    public void onInitializeData(@Nullable Bundle bundle) {
        if (getActivity() == null) {
            return;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            l(1);
            return;
        }
        ChannelPreviewEntity channelPreviewEntity = (ChannelPreviewEntity) arguments.getSerializable(Q2);
        if (channelPreviewEntity == null) {
            l(1);
            return;
        }
        j.l.c.c.c.l1.c.d dVar = new j.l.c.c.c.l1.c.d(this, this.l, channelPreviewEntity.channelId);
        dVar.a0(channelPreviewEntity.pre);
        dVar.b0(channelPreviewEntity.moduleId);
        dVar.d0(channelPreviewEntity.previewPage);
        dVar.c0(channelPreviewEntity.previewFilter);
        dVar.e0(channelPreviewEntity.previewPageSize);
        this.k = dVar;
        ChannelDynamicAdapter channelDynamicAdapter = new ChannelDynamicAdapter(this.l, this.i, this.k.t());
        this.f = channelDynamicAdapter;
        channelDynamicAdapter.p(new a());
        this.e.setAdapter(this.f);
    }

    @WithTryCatchRuntime
    public void updateChannelTitle() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.l1.c.c(new Object[]{this, e.v(R2, this, this)}).e(69648));
    }
}
