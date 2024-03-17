package com.hunantv.oversea.channel.dynamic.render.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.gson.JsonElement;
import com.hunantv.imgo.nightmode.view.SkinnableRelativeLayout;
import com.mgtv.dynamicview.model.ChannelStyle;
import j.l.c.c.b;
import j.l.c.c.c.u1.l;
import j.l.c.c.d.e;
import j.v.g.f.t;
import j.v.g.i.d;
import j.v.g.l.a;
import j.v.g.l.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelAdBannerLayout extends SkinnableRelativeLayout implements a, c, l {
    @Nullable
    public DynamicBanner a;

    public ChannelAdBannerLayout(Context context) {
        super(context);
    }

    public void L(a aVar) {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner != null) {
            dynamicBanner.L(aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void X(d dVar, ChannelStyle channelStyle, t tVar) {
        if (this.a != null) {
            setPadding(0, 0, 0, 0);
            int i = b.j.dsl_tag_style;
            this.a.setTag(i, (d) getTag(i));
            this.a.X(dVar, channelStyle, tVar);
        }
    }

    public long getFocusAid() {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner == null) {
            return 9000189L;
        }
        return dynamicBanner.C1;
    }

    public void j0(int i) {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner != null) {
            dynamicBanner.j0(i);
        }
    }

    public void n0(Object obj, Object obj2) {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner != null) {
            dynamicBanner.U(obj, obj2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onFinishInflate() {
        super/*android.widget.RelativeLayout*/.onFinishInflate();
        this.a = (DynamicBanner) findViewById(b.j.viewPager);
    }

    public void removeItem(int i) {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner != null) {
            dynamicBanner.removeItem(i);
        }
    }

    public void setChannelCenter(e eVar) {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner != null) {
            dynamicBanner.setChannelCenter(eVar);
        }
    }

    public void setExtendOnclick(View.OnClickListener onClickListener) {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner != null) {
            dynamicBanner.setExtendOnclick(onClickListener);
        }
    }

    public void setScrollInterval(int i) {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner != null) {
            dynamicBanner.setScrollInterval(i);
        }
    }

    public void setStyleManager(j.l.c.c.c.s1.e eVar) {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner != null) {
            dynamicBanner.setStyleManager(eVar);
        }
    }

    public void t(JsonElement jsonElement, j.v.g.k.d dVar, int i) {
        DynamicBanner dynamicBanner = this.a;
        if (dynamicBanner != null) {
            dynamicBanner.t(jsonElement, dVar, i);
        }
    }

    public ChannelAdBannerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChannelAdBannerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
