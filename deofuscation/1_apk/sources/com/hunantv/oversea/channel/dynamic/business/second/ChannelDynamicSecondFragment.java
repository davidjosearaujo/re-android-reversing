package com.hunantv.oversea.channel.dynamic.business.second;

import com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment;
import com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelDynamicSecondFragment extends ChannelDynamicFragment {
    private static final /* synthetic */ c.b Q2 = null;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("ChannelDynamicSecondFragment.java", ChannelDynamicSecondFragment.class);
        Q2 = eVar.H("method-execution", eVar.E("4", "updateChannelTitle", "com.hunantv.oversea.channel.dynamic.business.second.ChannelDynamicSecondFragment", "", "", "", "void"), 25);
    }

    public static final /* synthetic */ void u1(ChannelDynamicSecondFragment channelDynamicSecondFragment, c cVar) {
        ChannelDynamicPresenter channelDynamicPresenter = channelDynamicSecondFragment.k;
        if (channelDynamicPresenter != null) {
            String s = channelDynamicPresenter.s();
            if (channelDynamicSecondFragment.getActivity() instanceof ChannelDynamicSecondActivity) {
                channelDynamicSecondFragment.getActivity().setChannelTitle(s);
            }
        }
    }

    @Override // com.hunantv.oversea.channel.dynamic.ChannelDynamicFragment
    public void j(int i, boolean z) {
        super.j(i, z);
        updateChannelTitle();
    }

    @WithTryCatchRuntime
    public void updateChannelTitle() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.l1.d.c(new Object[]{this, e.v(Q2, this, this)}).e(69648));
    }
}
