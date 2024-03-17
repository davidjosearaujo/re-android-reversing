package com.hunantv.oversea.me.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.hunantv.oversea.business.update.notice.UpdateNoticeObserver;
import com.hunantv.oversea.me.data.CardData;
import com.hunantv.oversea.me.jumper.MeCenterJumper;
import j.l.a.b0.j0;
import j.l.c.a.h.a.d;
import j.l.c.k.c;
import j.l.c.k.m.j;
import j.l.c.k.n.d.e;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CommonCardView extends e {
    public static final String i = "MainMeItemSetting";
    private FrameLayout e;
    public LinearLayout f;
    public LifecycleOwner g;
    private boolean h;

    public CommonCardView(Context context, LifecycleOwner lifecycleOwner) {
        super(context);
        this.g = lifecycleOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        LinearLayout linearLayout = this.f;
        if (linearLayout == null || linearLayout.getChildCount() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f.getChildCount(); i2++) {
            View childAt = this.f.getChildAt(i2);
            if ((childAt.getTag() instanceof CardData.CardModuleData) && "2".equals(((CardData.CardModuleData) childAt.getTag()).itemId)) {
                j.g(childAt.findViewById(c.j.tvUpdateNotice), z ? 0 : 8);
                return;
            }
        }
    }

    public void b(View view) {
        this.e = (FrameLayout) view.findViewById(c.j.flCardParent);
        this.f = (LinearLayout) view.findViewById(c.j.me_ll_container);
    }

    public void e(CardData.CardDataBean cardDataBean) {
        if (this.f.getChildCount() > 0) {
            this.f.removeAllViews();
        }
        if (cardDataBean != null && !j.l.a.b0.j.a(cardDataBean.moduleData)) {
            this.e.setPadding(j.a(15.0f), j.a(10.0f), j.a(15.0f), 0);
            int size = cardDataBean.moduleData.size();
            for (int i2 = 0; i2 < size; i2++) {
                View l = l(cardDataBean.moduleData, i2);
                this.f.addView(l);
                m(l, cardDataBean.moduleData.get(i2), i2);
            }
            return;
        }
        this.e.setPadding(0, 0, 0, 0);
    }

    public View f(Context context) {
        return LayoutInflater.from(context).inflate(c.m.me_item_main_common_card, (ViewGroup) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View l(List<CardData.CardModuleData> list, int i2) {
        int size = list.size();
        CardData.CardModuleData cardModuleData = list.get(i2);
        View inflate = LayoutInflater.from(((e) this).a).inflate(c.m.me_item_main_new_list, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = j0.b(((e) this).a, i2 == 0 ? 8.0f : 6.0f);
        layoutParams.bottomMargin = j0.b(((e) this).a, i2 != size + (-1) ? 6.0f : 8.0f);
        inflate.setLayoutParams(layoutParams);
        inflate.setTag(cardModuleData);
        inflate.setOnClickListener(this);
        ((TextView) inflate.findViewById(c.j.me_item_new_title)).setText(cardModuleData.name);
        if ("2".equals(cardModuleData.itemId)) {
            j.g(inflate.findViewById(c.j.tvUpdateNotice), this.h ? 0 : 8);
        }
        return inflate;
    }

    public void m(View view, CardData.CardModuleData cardModuleData, int i2) {
        if ("2".equals(cardModuleData.itemId)) {
            d.c().h(i, new UpdateNoticeObserver(this.g) { // from class: com.hunantv.oversea.me.view.main.CommonCardView.1
                public void d(j.l.c.a.h.a.c cVar, boolean z) {
                    CommonCardView.this.h = z;
                    CommonCardView.this.n(z);
                }
            });
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof CardData.CardModuleData) {
            CardData.CardModuleData cardModuleData = (CardData.CardModuleData) view.getTag();
            MeCenterJumper.jump(((e) this).a, cardModuleData);
            if ("2".equals(cardModuleData.itemId)) {
                d.c().g(i);
            }
        }
    }
}
