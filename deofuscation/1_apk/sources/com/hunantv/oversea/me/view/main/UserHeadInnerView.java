package com.hunantv.oversea.me.view.main;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hunantv.imgo.nightmode.view.SkinnableConstraintLayout;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.me.ui.profile.MeProfileActivity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.k.c;
import j.l.c.k.h.a;
import j.l.c.k.m.j;
import j.l.c.k.n.d.m;
import j.v.h.d;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class UserHeadInnerView extends SkinnableConstraintLayout {
    private static final /* synthetic */ c.b o = null;
    private ImageView j;
    private TextView k;
    private ConstraintLayout l;
    private ImageView m;
    private TextView n;

    static {
        e();
    }

    public UserHeadInnerView(Context context) {
        super(context);
        f(context);
    }

    private static /* synthetic */ void e() {
        e eVar = new e("UserHeadInnerView.java", UserHeadInnerView.class);
        o = eVar.H("method-execution", eVar.E("1", "refreshUserInfo", "com.hunantv.oversea.me.view.main.UserHeadInnerView", "com.hunantv.oversea.login_api.entity.UserInfo", "userInfo", "", "void"), 74);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(context).inflate(c.m.me_layout_user_info, (ViewGroup) this);
        this.j = (ImageView) findViewById(c.j.me_iv_user_avatar);
        this.k = (TextView) findViewById(c.j.me_tv_user_name);
        this.l = findViewById(c.j.me_cl_vip_level);
        this.m = (ImageView) findViewById(c.j.me_iv_vip_level);
        this.n = (TextView) findViewById(c.j.me_tv_vip_level);
        j.v.h.e.z(this.j, Integer.valueOf(c.h.me_icon_default_user_avatar_tiny), (d) null, (j.v.h.j.d) null);
        this.j.setOnClickListener(new j.l.c.k.n.d.d(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public /* synthetic */ void h(Context context, View view) {
        if (a.g()) {
            Intent intent = new Intent(context, MeProfileActivity.class);
            j.l.c.e0.a.a.a.h(intent);
            context.startActivity(intent);
        } else {
            a.h(getContext(), 0);
        }
        j.l.c.k.f.a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUser(UserInfo userInfo) {
        if (userInfo == null) {
            this.k.setText(c.r.me_immediately_login);
            j.v.h.e.z(this.j, Integer.valueOf(c.h.me_icon_default_user_avatar_tiny), (d) null, (j.v.h.j.d) null);
        } else {
            this.k.setText(userInfo.nickname);
            j.v.h.e.x(this.j, userInfo.getAvatar(), c.h.me_icon_default_user_avatar_tiny);
        }
        int i = 0;
        boolean z = a.g() && userInfo != null && userInfo.isVIP();
        j.g(this.l, (userInfo == null || !a.g()) ? 8 : 8);
        this.l.setBackgroundResource(z ? c.h.me_bg_main_vip : c.h.me_bg_main_not_vip);
        this.m.setImageResource(z ? c.h.me_icon_main_vip : c.h.me_icon_main_not_vip);
        this.n.setText(z ? String.valueOf(userInfo.getGrowth().level) : "0");
    }

    @WithTryCatchRuntime
    public void refreshUserInfo(UserInfo userInfo) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new m(new Object[]{this, userInfo, e.w(o, this, this, userInfo)}).e(69648));
    }

    public UserHeadInnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context);
    }

    public UserHeadInnerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f(context);
    }
}
