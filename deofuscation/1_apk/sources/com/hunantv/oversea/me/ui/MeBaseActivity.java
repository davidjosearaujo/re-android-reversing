package com.hunantv.oversea.me.ui;

import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.hunantv.imgo.base.RootActivity;
import j.l.a.t.e;
import j.l.c.k.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class MeBaseActivity extends RootActivity {
    @Override // com.hunantv.imgo.base.RootActivity, com.hunantv.imgo.nightmode.SkinnableActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.hunantv.imgo.nightmode.SkinnableActivity
    public void refreshNavigationBar() {
        if (e.m().t()) {
            setNavigationBarColor(u0(), true);
        } else {
            setNavigationBarColor(v0(), false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hunantv.imgo.nightmode.SkinnableActivity
    public void refreshStatusBar() {
        this.mStatusBarSupport.d(this, w0());
        if (e.m().t()) {
            this.mStatusBarSupport.b(this, true);
        } else {
            this.mStatusBarSupport.b(this, false);
        }
    }

    @ColorInt
    public int u0() {
        return getResources().getColor(c.f.me_skin_color_page_bg);
    }

    @ColorInt
    public int v0() {
        return getResources().getColor(c.f.me_skin_color_page_bg);
    }

    @ColorInt
    public int w0() {
        return ColorUtils.compositeColors(getResources().getColor(c.f.me_skin_color_status_bar_foreground), getResources().getColor(c.f.me_skin_color_page_bg));
    }

    @DrawableRes
    public int x0() {
        return c.h.me_bg_title_bar;
    }
}
