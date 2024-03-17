package com.hunantv.oversea.me.viewmodels;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.hunantv.imgo.net.ImgoHttpCallBack;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.me.data.CardData;
import com.hunantv.oversea.me.ui.main.MainMePage;
import com.hunantv.oversea.me.util.message.MeMessageNotifier;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.j;
import j.l.a.b0.v;
import j.l.b.d.o;
import j.l.b.g.d;
import j.l.c.h.e;
import j.l.c.k.g.g;
import j.l.c.k.o.l;
import j.l.c.k.o.n;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MainMeViewModel extends n implements e, j.l.c.l.f.b {
    private static final /* synthetic */ c.b n = null;
    private MutableLiveData<c> j = new MutableLiveData<>();
    private MutableLiveData<UserInfo> k = new MutableLiveData<>();
    private MutableLiveData<Integer> l = new MutableLiveData<>(0);
    private final Object m = new Object();
    private final g i = b(new g());

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends ImgoHttpCallBack<CardData> {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: w */
        public /* synthetic */ void x(CardData cardData) {
            MainMeViewModel.this.filterData(cardData, true);
        }

        /* renamed from: y */
        public void success(CardData cardData) {
            ThreadManager.execute(new j.l.c.k.o.b(this, cardData));
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends ImgoHttpCallBack<CardData> {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: x */
        public /* synthetic */ void y(CardData cardData) {
            MainMeViewModel.this.filterData(cardData, false);
        }

        /* renamed from: w */
        public void failed(@Nullable CardData cardData, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(cardData, i, i2, str, th);
            v.g(MainMePage.g, "MainMeViewModel -> requestNetwork failed, \nhttpStatus = " + i + ", \ncode = " + i2 + ", \ninfo = " + str + ", \ne = " + th);
            d.n(i, "个人中心首页加载失败", new o(i, i2, str, r().getFinalUrl()).d());
        }

        /* renamed from: z */
        public void success(CardData cardData) {
            ThreadManager.execute(new j.l.c.k.o.c(this, cardData));
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class c {
        public List<CardData.CardDataBean> a;
        public boolean b;
    }

    static {
        ajc$preClinit();
    }

    public MainMeViewModel() {
        p();
        j.l.c.k.h.a.a(this);
        MeMessageNotifier.e().c(this);
    }

    private static /* synthetic */ void ajc$preClinit() {
        r.a.c.c.e eVar = new r.a.c.c.e("MainMeViewModel.java", MainMeViewModel.class);
        n = eVar.H("method-execution", eVar.E("2", "filterData", "com.hunantv.oversea.me.viewmodels.MainMeViewModel", "com.hunantv.oversea.me.data.CardData:boolean", "resultData:fromCache", "", "void"), (int) EventClickData.u.m1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void filterData(CardData cardData, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{this, cardData, r.a.c.b.e.a(z), r.a.c.c.e.x(n, this, this, cardData, r.a.c.b.e.a(z))}).e(69648));
    }

    public static final /* synthetic */ void k(MainMeViewModel mainMeViewModel, CardData cardData, boolean z, r.a.b.c cVar) {
        CardData.CardListDataBean cardListDataBean;
        synchronized (mainMeViewModel.m) {
            if (mainMeViewModel.j.getValue() == null || !z) {
                if (cardData != null && (cardListDataBean = cardData.data) != null && !j.a(cardListDataBean.list)) {
                    mainMeViewModel.i.e(cardData);
                    ArrayList arrayList = new ArrayList();
                    for (CardData.CardDataBean cardDataBean : cardData.data.list) {
                        if (cardDataBean != null && !"userIcon".equals(cardDataBean.moduleName)) {
                            cardDataBean.isCheckSync = !z;
                            arrayList.add(cardDataBean);
                            if ("userCard".equals(cardDataBean.moduleName) && !j.a(cardDataBean.moduleData) && cardDataBean.moduleData.get(0) != null && !j.a(cardDataBean.moduleData.get(0).child) && cardDataBean.moduleData.get(0).child.get(0) != null) {
                                CardData.CardModuleData.ChildData childData = cardDataBean.moduleData.get(0).child.get(0);
                                if (!j.a(childData.show_report_urls)) {
                                    mainMeViewModel.i.b(childData.show_report_urls.get(0));
                                }
                            }
                        }
                    }
                    CardData.CardDataBean cardDataBean2 = new CardData.CardDataBean();
                    cardDataBean2.moduleName = "bottom_padding";
                    arrayList.add(cardDataBean2);
                    c cVar2 = new c();
                    cVar2.a = arrayList;
                    cVar2.b = z;
                    mainMeViewModel.j.postValue(cVar2);
                }
            }
        }
    }

    private void p() {
        this.i.d(new a());
    }

    public void a(j.l.c.l.f.a aVar) {
        if (aVar != null) {
            v.g("MeMessageRedDot", "count = " + aVar.a);
            this.l.postValue(Integer.valueOf(aVar.a));
        }
    }

    public void j() {
        this.l.postValue(0);
    }

    public MutableLiveData<c> l() {
        return this.j;
    }

    public int m() {
        if (this.l.getValue() == null) {
            return 0;
        }
        return ((Integer) this.l.getValue()).intValue();
    }

    public MutableLiveData<Integer> n() {
        return this.l;
    }

    public MutableLiveData<UserInfo> o() {
        return this.k;
    }

    public void onCleared() {
        super.onCleared();
        MeMessageNotifier.e().h(this);
        j.l.c.k.h.a.j(this);
    }

    public void onUserInfoChanged(@Nullable UserInfo userInfo) {
        this.k.postValue(userInfo);
    }

    public void q() {
        this.i.c(new b());
    }
}
