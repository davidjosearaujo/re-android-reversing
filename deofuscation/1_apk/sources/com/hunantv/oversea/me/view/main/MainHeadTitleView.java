package com.hunantv.oversea.me.view.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hunantv.imgo.nightmode.view.SkinnableRelativeLayout;
import j.l.a.b0.j0;
import j.l.a.b0.v;
import j.l.a.t.e;
import j.l.c.k.c;
import j.l.c.k.m.j;
import j.l.c.k.n.d.b;

@SuppressLint({"ViewConstructor"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MainHeadTitleView extends SkinnableRelativeLayout {
    private a a;
    private View b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private TextView f;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void onMessageClick(View view);

        void onScanClick(View view);
    }

    public MainHeadTitleView(Context context) {
        super(context);
        o0(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o0(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundResource(c.h.me_bg_title_bar);
        LayoutInflater.from(context).inflate(c.m.me_layout_main_title, (ViewGroup) this);
        this.b = findViewById(c.j.me_view_status_bar_placeholder);
        this.c = (TextView) findViewById(c.j.me_tv_title_user);
        this.d = (ImageView) findViewById(c.j.me_iv_scan);
        ImageView imageView = (ImageView) findViewById(c.j.me_iv_message);
        this.e = imageView;
        imageView.setVisibility(8);
        this.f = (TextView) findViewById(c.j.ivMessageDot);
        this.b.getLayoutParams().height = j0.p(j.l.a.a.a());
        int i = Build.VERSION.SDK_INT;
        if (i < 23 && i >= 21) {
            this.b.setBackgroundColor(-16777216);
        }
        this.c.setText(j.l.a.a.a().getString(c.r.me_title));
        findViewById(c.j.me_rl_title).setOnTouchListener(b.a);
        this.d.setOnClickListener(new j.l.c.k.n.d.c(this));
        this.e.setOnClickListener(new j.l.c.k.n.d.a(this));
        setAlpha(0.0f);
    }

    public static /* synthetic */ boolean q0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void t0(View view) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onScanClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(View view) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onMessageClick(view);
        }
    }

    public void applyDayNight() {
        super.applyDayNight();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 || i < 21) {
            return;
        }
        if (e.m().s()) {
            this.b.setBackgroundColor(-16777216);
        } else {
            this.b.setBackgroundColor(0);
        }
    }

    public void n0() {
        j.g(this.f, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAlpha(float f) {
        v.g("MainHeadTitleView", "setAlpha alpha = " + f);
        Drawable background = getBackground();
        if (background != null) {
            background.mutate();
            background.setAlpha((int) (255.0f * f));
        }
        this.c.setAlpha(f);
    }

    public void setOnTitleClickListener(a aVar) {
        this.a = aVar;
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.setText(str);
    }

    public void w0() {
        j.g(this.f, 8);
    }
}
