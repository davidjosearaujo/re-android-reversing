package com.hunantv.oversea.me.view.main;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleObserver;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.me.data.CardData;
import j.l.a.b0.j;
import j.l.c.k.n.d.e;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class UserHeadCardView extends e implements LifecycleObserver {
    private UserHeadInnerView e;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public boolean a;
        public UserInfo b;

        public a(boolean z, UserInfo userInfo) {
            this.a = z;
            this.b = userInfo;
        }
    }

    public UserHeadCardView(Context context) {
        super(context);
    }

    public void b(View view) {
    }

    public void e(CardData.CardDataBean cardDataBean) {
        this.e.refreshUserInfo(j.l.c.k.h.a.g() ? j.l.c.k.h.a.f() : null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.hunantv.oversea.me.view.main.UserHeadInnerView, android.view.View] */
    public View f(Context context) {
        ?? userHeadInnerView = new UserHeadInnerView(context);
        this.e = userHeadInnerView;
        return userHeadInnerView;
    }

    public void j(List<Object> list) {
        if (j.a(list) || !(list.get(0) instanceof a)) {
            return;
        }
        a aVar = (a) list.get(0);
        this.e.refreshUserInfo(aVar.a ? aVar.b : null);
    }
}
