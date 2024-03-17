package com.hunantv.oversea.channel.dynamic.listener.scroll;

import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.NativeProtocol;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.c.r1.e.b;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FastScrollHelper {
    private static final /* synthetic */ c.b a = null;

    static {
        a();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("FastScrollHelper.java", FastScrollHelper.class);
        a = eVar.H("method-execution", eVar.E("9", "startFastScroll", "com.hunantv.oversea.channel.dynamic.listener.scroll.FastScrollHelper", "androidx.recyclerview.widget.RecyclerView:int", "recyclerView:position", "", "void"), 21);
    }

    public static final /* synthetic */ void b(RecyclerView recyclerView, int i, c cVar) {
        if (recyclerView == null || recyclerView.getContext() == null || recyclerView.getLayoutManager() == null || recyclerView.getChildCount() == 0) {
            return;
        }
        b bVar = new b(recyclerView.getContext());
        bVar.setTargetPosition(i);
        recyclerView.getLayoutManager().startSmoothScroll(bVar);
    }

    @WithTryCatchRuntime
    public static void startFastScroll(RecyclerView recyclerView, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.r1.e.c(new Object[]{recyclerView, r.a.c.b.e.k(i), e.x(a, (Object) null, (Object) null, recyclerView, r.a.c.b.e.k(i))}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }
}
