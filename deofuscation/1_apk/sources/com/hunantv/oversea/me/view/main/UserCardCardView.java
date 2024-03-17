package com.hunantv.oversea.me.view.main;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleObserver;
import com.hunantv.oversea.me.data.CardData;
import j.l.c.k.n.d.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class UserCardCardView extends e implements LifecycleObserver {
    private UserCardInnerView e;

    public UserCardCardView(Context context) {
        super(context);
    }

    public void b(View view) {
    }

    public void e(CardData.CardDataBean cardDataBean) {
        this.e.refreshUserCard(cardDataBean);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.hunantv.oversea.me.view.main.UserCardInnerView] */
    public View f(Context context) {
        ?? userCardInnerView = new UserCardInnerView(context);
        this.e = userCardInnerView;
        return userCardInnerView;
    }
}
