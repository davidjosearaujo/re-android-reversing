package com.hunantv.oversea.me.view.main;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.fastjson.asm.Opcodes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hunantv.imgo.nightmode.view.SkinnableConstraintLayout;
import com.hunantv.oversea.login_api.entity.UserInfo;
import com.hunantv.oversea.me.data.CardData;
import com.hunantv.oversea.session.global.SessionManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.task.http.HttpParams;
import j.l.a.a;
import j.l.a.b0.j;
import j.l.a.b0.j0;
import j.l.a.b0.p0;
import j.l.a.b0.z;
import j.l.b.e.s.b;
import j.l.c.k.c;
import j.l.c.k.n.d.k;
import j.l.c.k.n.d.l;
import j.v.r.r;
import j.v.r.v.h;
import java.text.SimpleDateFormat;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class UserCardInnerView extends SkinnableConstraintLayout implements View.OnClickListener {
    private static final /* synthetic */ c.b q = null;
    private static final /* synthetic */ c.b r = null;
    private ImageView j;
    private ConstraintLayout k;
    private TextView l;
    private TextView m;
    private TextView n;
    private CardData.CardModuleData.ChildData o;
    private r p;

    static {
        e();
    }

    public UserCardInnerView(Context context) {
        super(context);
        g(context);
    }

    private static /* synthetic */ void e() {
        e eVar = new e("UserCardInnerView.java", UserCardInnerView.class);
        q = eVar.H("method-execution", eVar.E("1", "refreshUserCard", "com.hunantv.oversea.me.view.main.UserCardInnerView", "com.hunantv.oversea.me.data.CardData$CardDataBean", "dataBean", "", "void"), 103);
        r = eVar.H("method-execution", eVar.E("2", "getVipExpireDate", "com.hunantv.oversea.me.view.main.UserCardInnerView", "", "", "", "java.lang.String"), (int) Opcodes.IF_ACMPEQ);
    }

    public static final /* synthetic */ String f(UserCardInnerView userCardInnerView, c cVar) {
        Context a;
        UserInfo.VipInfoBean vipInfoBean;
        String str;
        if (!SessionManager.o() || (a = a.a()) == null || (vipInfoBean = SessionManager.g().h().vipinfo) == null) {
            return "";
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            str = simpleDateFormat.format(simpleDateFormat.parse(vipInfoBean.vip_end_time));
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        return TextUtils.isEmpty(str) ? "" : a.getString(c.r.me_vip_expire_date, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(context).inflate(c.m.me_layout_user_card, (ViewGroup) this);
        this.j = (ImageView) findViewById(c.j.ivBgVipModule);
        ConstraintLayout findViewById = findViewById(c.j.me_cl_vip_module);
        this.k = findViewById;
        findViewById.setOnClickListener(this);
        this.l = (TextView) findViewById(c.j.me_tv_vip_title);
        this.m = (TextView) findViewById(c.j.me_tv_vip_subtitle);
        this.n = (TextView) findViewById(c.j.me_tv_vip_pop);
    }

    @NonNull
    @WithTryCatchRuntime
    private String getVipExpireDate() {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{this, e.v(r, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setVip(CardData.CardDataBean cardDataBean) {
        int i;
        String str;
        if (cardDataBean == null || j.a(cardDataBean.moduleData)) {
            return;
        }
        if (cardDataBean.moduleData.get(0) == null) {
            return;
        }
        CardData.CardModuleData cardModuleData = cardDataBean.moduleData.get(0);
        boolean o = SessionManager.o();
        if (!j.a(cardModuleData.child) && cardModuleData.child.get(0) != null) {
            this.o = cardModuleData.child.get(0);
        }
        CardData.CardModuleData.ChildData childData = this.o;
        String str2 = childData != null ? childData.title : "";
        if (TextUtils.isEmpty(str2)) {
            str2 = cardModuleData.name;
        }
        j.l.c.k.m.j.g(this.l, TextUtils.isEmpty(str2) ? 8 : 0);
        this.l.setText(str2);
        Resources resources = getContext().getResources();
        int i2 = c.f.me_color_804919_60;
        int color = resources.getColor(i2);
        CardData.CardModuleData.ChildData childData2 = this.o;
        if (childData2 != null) {
            str = childData2.sub_title;
            i = z.e(childData2.sub_style, getContext().getResources().getColor(i2));
        } else {
            i = color;
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = cardModuleData.subName;
        }
        if (TextUtils.isEmpty(str)) {
            str = o ? getVipExpireDate() : "";
        }
        j.l.c.k.m.j.g(this.m, TextUtils.isEmpty(str) ? 8 : 0);
        this.m.setTextColor(i);
        this.m.setText(str);
        CardData.CardModuleData.ChildData childData3 = this.o;
        String str3 = childData3 != null ? childData3.pop_title : "";
        j.l.c.k.m.j.g(this.n, TextUtils.isEmpty(str3) ? 8 : 0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.rightMargin = ((Math.min(j0.n(getContext()), j0.k(getContext())) - j0.b(getContext(), 30.0f)) * 11) / 50;
        this.n.setLayoutParams(layoutParams);
        this.n.setText(str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == c.j.me_cl_vip_module) {
            b.n("80103");
            b c = b.c(getContext().getApplicationContext());
            String g = j.v.o.a.d.e.a.g();
            CardData.CardModuleData.ChildData childData = this.o;
            if (childData != null && !TextUtils.isEmpty(childData.jump_url)) {
                g = this.o.jump_url;
            }
            String e = p0.e(c.e(g, j.l.a.k.e.H, j.l.a.b0.e.v0(), j.l.a.b0.e.n(), "U", "", "", "", "", "", "", "", "vip", "0", "", ""), "ftype", "1");
            CardData.CardModuleData.ChildData childData2 = this.o;
            if (childData2 != null && !j.a(childData2.click_report_urls) && !TextUtils.isEmpty(this.o.click_report_urls.get(0))) {
                if (this.p == null) {
                    this.p = new r(getContext());
                }
                this.p.u(this.o.click_report_urls.get(0), (HttpParams) null, new h());
            } else {
                j.l.c.k.f.a.n();
            }
            j.l.c.k.h.c.b(getContext(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super/*android.view.ViewGroup*/.onSizeChanged(i, i2, i3, i4);
        Glide.with(getContext()).load(Integer.valueOf(c.h.me_bg_main_vip_module)).diskCacheStrategy(DiskCacheStrategy.NONE).override(this.k.getMeasuredWidth(), this.k.getMeasuredHeight()).into(this.j);
    }

    @WithTryCatchRuntime
    public void refreshUserCard(CardData.CardDataBean cardDataBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{this, cardDataBean, e.w(q, this, this, cardDataBean)}).e(69648));
    }

    public UserCardInnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context);
    }

    public UserCardInnerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g(context);
    }
}
