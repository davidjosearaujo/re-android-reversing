package com.hunantv.oversea.me.view.main;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.asm.Opcodes;
import com.hunantv.imgo.recyclerview.LinearLayoutManagerWrapper;
import com.hunantv.oversea.me.adapter.PlayHistoryAdapter;
import com.hunantv.oversea.me.data.CardData;
import com.hunantv.oversea.me.data.CollectUpdateInfoEntity;
import com.hunantv.oversea.me.model.MainPlayHistoryRepository;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.j;
import j.l.a.b0.j0;
import j.l.a.w.a;
import j.l.b.e.e.o;
import j.l.c.k.c;
import j.l.c.k.e.k;
import j.l.c.k.f.h;
import j.l.c.k.g.h;
import java.util.ArrayList;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;
import r.e.a.d;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PlayHistoryCardView extends CommonCardView implements a.b, MainPlayHistoryRepository.f, h.d {
    private static final int r = 10;
    private static final /* synthetic */ c.b s = null;
    private RecyclerView j;
    private PlayHistoryAdapter k;
    private CardData.CardDataBean l;
    private MainPlayHistoryRepository m;
    private h n;
    private boolean o;
    private boolean p;
    private String q;

    static {
        o();
    }

    public PlayHistoryCardView(Context context) {
        super(context, null);
        this.q = "";
    }

    private static /* synthetic */ void o() {
        e eVar = new e("PlayHistoryCardView.java", PlayHistoryCardView.class);
        s = eVar.H("method-execution", eVar.E("1", "onHistoryDataReady", "com.hunantv.oversea.me.view.main.PlayHistoryCardView", "java.util.List:java.lang.String", "historyList:seqId", "", "void"), (int) Opcodes.IFNULL);
    }

    private List<k> p(List<k> list) {
        return (list == null || list.size() <= 10) ? list : new ArrayList(list.subList(0, 10));
    }

    private boolean q(CardData.CardDataBean cardDataBean) {
        CardData.CardDataBean cardDataBean2 = this.l;
        if (cardDataBean2 == null || cardDataBean == null || j.a(cardDataBean2.moduleData) || j.l.c.k.m.h.d(this.l.moduleData) != j.l.c.k.m.h.d(cardDataBean.moduleData)) {
            return true;
        }
        for (int i = 0; i < this.l.moduleData.size(); i++) {
            CardData.CardModuleData cardModuleData = this.l.moduleData.get(i);
            CardData.CardModuleData cardModuleData2 = cardDataBean.moduleData.get(i);
            if (!TextUtils.equals(cardModuleData.itemId, cardModuleData2.itemId) || !TextUtils.equals(cardModuleData.name, cardModuleData2.name)) {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ void r(PlayHistoryCardView playHistoryCardView, List list, String str, c cVar) {
        List<k> p = playHistoryCardView.p(list);
        playHistoryCardView.q = str;
        if (!j.a(p) && playHistoryCardView.j != null) {
            if (playHistoryCardView.k == null) {
                PlayHistoryAdapter playHistoryAdapter = new PlayHistoryAdapter(((j.l.c.k.n.d.e) playHistoryCardView).a);
                playHistoryCardView.k = playHistoryAdapter;
                playHistoryAdapter.x(playHistoryCardView);
            }
            playHistoryCardView.j.setAdapter(playHistoryCardView.k);
            playHistoryCardView.k.updateData(p);
            playHistoryCardView.j.setVisibility(0);
            o.a(((j.l.c.k.n.d.e) playHistoryCardView).a).g("5", "111", "user_ihome", playHistoryCardView.q);
            return;
        }
        PlayHistoryAdapter playHistoryAdapter2 = playHistoryCardView.k;
        if (playHistoryAdapter2 != null) {
            playHistoryAdapter2.updateData(p);
        }
        j.l.c.k.m.j.g(playHistoryCardView.j, 8);
    }

    public void a(CollectUpdateInfoEntity collectUpdateInfoEntity) {
        CollectUpdateInfoEntity.Data data;
        LinearLayout linearLayout = this.f;
        if (linearLayout == null || linearLayout.getChildCount() == 0) {
            return;
        }
        for (int i = 0; i < this.f.getChildCount(); i++) {
            View childAt = this.f.getChildAt(i);
            if ((childAt.getTag() instanceof CardData.CardModuleData) && "892".equals(((CardData.CardModuleData) childAt.getTag()).itemId)) {
                View findViewById = childAt.findViewById(c.j.me_item_message);
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText((collectUpdateInfoEntity == null || (data = collectUpdateInfoEntity.data) == null || TextUtils.isEmpty(data.info)) ? "" : collectUpdateInfoEntity.data.info);
                    j.l.c.k.m.j.g(findViewById, 0);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.hunantv.oversea.me.view.main.CommonCardView
    public void e(CardData.CardDataBean cardDataBean) {
        if (q(cardDataBean)) {
            this.l = cardDataBean;
            this.o = false;
            this.p = false;
            super.e(cardDataBean);
        }
        if (this.p) {
            if (this.m == null) {
                this.m = new MainPlayHistoryRepository(this);
            }
            this.m.requestPlayHistory();
            if (cardDataBean.isCheckSync) {
                this.m.i();
            }
        } else {
            MainPlayHistoryRepository mainPlayHistoryRepository = this.m;
            if (mainPlayHistoryRepository != null) {
                mainPlayHistoryRepository.onCleared();
                this.m = null;
            }
        }
        if (this.o) {
            if (this.n == null) {
                this.n = new h(this);
            }
            this.n.i();
            if (cardDataBean.isCheckSync) {
                this.n.e();
                return;
            }
            return;
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.onCleared();
            this.n = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.oversea.me.view.main.CommonCardView
    public View l(List<CardData.CardModuleData> list, int i) {
        if ("5".equals(list.get(i).itemId)) {
            int size = list.size();
            CardData.CardModuleData cardModuleData = list.get(i);
            View inflate = LayoutInflater.from(((j.l.c.k.n.d.e) this).a).inflate(c.m.me_item_main_play_card, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = j0.b(((j.l.c.k.n.d.e) this).a, i == 0 ? 8.0f : 6.0f);
            layoutParams.bottomMargin = j0.b(((j.l.c.k.n.d.e) this).a, i != size + (-1) ? 6.0f : 8.0f);
            inflate.setLayoutParams(layoutParams);
            inflate.setTag(cardModuleData);
            inflate.setOnClickListener(this);
            ((TextView) inflate.findViewById(c.j.me_item_new_title)).setText(cardModuleData.name);
            j.l.c.k.m.j.g((TextView) inflate.findViewById(c.j.me_item_message), 8);
            RecyclerView findViewById = inflate.findViewById(c.j.recyclerView);
            this.j = findViewById;
            findViewById.setLayoutManager(new LinearLayoutManagerWrapper(((j.l.c.k.n.d.e) this).a, 0, false));
            return inflate;
        }
        return super.l(list, i);
    }

    @Override // com.hunantv.oversea.me.view.main.CommonCardView
    public void m(View view, CardData.CardModuleData cardModuleData, int i) {
        super.m(view, cardModuleData, i);
        if ("892".equals(cardModuleData.itemId)) {
            this.o = true;
        }
        if ("5".equals(cardModuleData.itemId)) {
            this.p = true;
        }
    }

    @Override // com.hunantv.oversea.me.view.main.CommonCardView
    public void onClick(View view) {
        if ((view.getTag() instanceof CardData.CardModuleData) && TextUtils.equals("6", ((CardData.CardModuleData) view.getTag()).jumpId)) {
            j.l.c.k.f.a.i("seqid=" + this.q + "&p=0");
        }
        super.onClick(view);
    }

    @Override // com.hunantv.oversea.me.model.MainPlayHistoryRepository.f
    public /* synthetic */ void onError() {
        j.l.c.k.g.k.a(this);
    }

    @Override // com.hunantv.oversea.me.model.MainPlayHistoryRepository.f
    @WithTryCatchRuntime
    public void onHistoryDataReady(@d List<k> list, String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.k.n.d.j(new Object[]{this, list, str, e.x(s, this, this, list, str)}).e(69648));
    }

    public void onItemClick(View view, int i) {
        k kVar = (k) this.k.getItem(i);
        if (kVar == null) {
            return;
        }
        int i2 = i + 1;
        j.l.b.e.o.a.c(j.l.a.a.a()).f(i2, kVar.g, 0, kVar.a, 0);
        j.l.c.k.f.a.i("seqid=" + this.q + "&vid=" + kVar.a + "&pid=" + kVar.b + "&p=" + i2);
        Context context = ((j.l.c.k.n.d.e) this).a;
        h.a c = new h.a().i(String.valueOf(kVar.a)).b(String.valueOf(kVar.c)).f(String.valueOf(kVar.b)).c("-1");
        String str = this.q;
        if (str == null) {
            str = "";
        }
        j.l.c.z.c.d.i(context, j.l.c.k.f.h.d(c.g(str).d("user_play").e("user_ihome").h(String.valueOf(kVar.e * 1000))));
    }
}
