package com.hunantv.oversea.channel.selected.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.alibaba.fastjson.asm.Opcodes;
import com.hunantv.imgo.nightmode.view.SkinnableTextView;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.channel.selected.data.ChannelListEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.widget.smarttablayout.MGSmartTabLayout;
import j.l.a.b0.j0;
import j.l.c.c.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelTabProvider implements MGSmartTabLayout.h {
    private static final /* synthetic */ c.b d = null;
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private final LayoutInflater b;
    private List<ChannelListEntity.DataBean> a = new ArrayList();
    @SuppressLint({"UseSparseArrays"})
    private final HashMap<Integer, a> c = new HashMap<>();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        private View a;
        private TextView b;
        private View c;

        public a(View view) {
            this.a = view;
            this.b = (TextView) view.findViewById(b.j.tv_channel_tab);
            this.c = view.findViewById(b.j.view_channel_tab_indicator);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.TextView, com.hunantv.imgo.nightmode.view.SkinnableTextView] */
        public void d(List<ChannelListEntity.DataBean> list, int i) {
            TextView textView = this.b;
            if (textView instanceof SkinnableTextView) {
                ?? r0 = (SkinnableTextView) textView;
                r0.setSkinWidgetId(2002);
                r0.setText(list.get(i).title);
            }
        }
    }

    static {
        a();
    }

    public ChannelTabProvider(@NonNull Context context) {
        this.b = LayoutInflater.from(context);
    }

    private static /* synthetic */ void a() {
        e eVar = new e("ChannelTabProvider.java", ChannelTabProvider.class);
        d = eVar.H("method-execution", eVar.E("1", "refreshView", "com.hunantv.oversea.channel.selected.view.ChannelTabProvider", "int", "position", "", "void"), 117);
        e = eVar.H("method-execution", eVar.E("1", "refreshViewColor", "com.hunantv.oversea.channel.selected.view.ChannelTabProvider", "boolean:android.content.res.ColorStateList:boolean", "needResetColor:textColor:isDynamicSpecialStyle", "", "void"), (int) EventClickData.u.O0);
        f = eVar.H("method-execution", eVar.E("1", "refreshIndicatorColor", "com.hunantv.oversea.channel.selected.view.ChannelTabProvider", "boolean:android.content.res.ColorStateList", "needResetColor:indicatorColor", "", "void"), (int) Opcodes.IF_ACMPNE);
    }

    public static final /* synthetic */ void c(ChannelTabProvider channelTabProvider, boolean z, ColorStateList colorStateList, c cVar) {
        for (Map.Entry<Integer, a> entry : channelTabProvider.c.entrySet()) {
            a value = entry.getValue();
            if (value != null && value.c != null) {
                if (z) {
                    value.c.setBackgroundResource(b.h.bg_channel_tab_indicator);
                } else if (colorStateList != null) {
                    int colorForState = colorStateList.getColorForState(new int[]{16842913}, ContextCompat.getColor(value.c.getContext(), b.f.mgtv_theme_color_FF4500));
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setCornerRadius(j0.b(value.c.getContext(), 2.5f));
                    gradientDrawable.setColor(colorForState);
                    value.c.setBackground(gradientDrawable);
                }
            }
        }
    }

    public static final /* synthetic */ void d(ChannelTabProvider channelTabProvider, boolean z, ColorStateList colorStateList, boolean z2, c cVar) {
        for (Map.Entry<Integer, a> entry : channelTabProvider.c.entrySet()) {
            a value = entry.getValue();
            if (value != null && (value.b instanceof SkinnableTextView)) {
                SkinnableTextView skinnableTextView = (SkinnableTextView) value.b;
                if (z) {
                    skinnableTextView.clearDynamicColor();
                } else if (colorStateList != null) {
                    skinnableTextView.setTextColor(colorStateList);
                }
            }
        }
    }

    public static final /* synthetic */ void e(ChannelTabProvider channelTabProvider, int i, c cVar) {
        for (Map.Entry<Integer, a> entry : channelTabProvider.c.entrySet()) {
            a value = entry.getValue();
            if (value != null) {
                TextView textView = value.b;
                View view = value.c;
                if (entry.getKey().intValue() == i) {
                    textView.setTextSize(1, 22.0f);
                    view.setVisibility(0);
                } else {
                    textView.setTextSize(1, 18.0f);
                    view.setVisibility(4);
                }
            }
        }
    }

    public void b() {
        this.c.clear();
    }

    public View createTabView(ViewGroup viewGroup, int i, PagerAdapter pagerAdapter) {
        a aVar;
        if (this.c.containsKey(Integer.valueOf(i))) {
            aVar = this.c.get(Integer.valueOf(i));
        } else {
            a aVar2 = new a(this.b.inflate(b.m.layout_select_channel_tab, viewGroup, false));
            this.c.put(Integer.valueOf(i), aVar2);
            aVar = aVar2;
        }
        if (aVar != null) {
            aVar.d(this.a, i);
            return aVar.a;
        }
        return new View(viewGroup.getContext());
    }

    public void f(@Nullable ChannelListEntity channelListEntity) {
        if (channelListEntity == null || channelListEntity.data == null) {
            return;
        }
        this.a.clear();
        for (ChannelListEntity.DataBean dataBean : channelListEntity.data) {
            if (!TextUtils.isEmpty(dataBean.vclassId) && !TextUtils.isEmpty(dataBean.title)) {
                this.a.add(dataBean);
            }
        }
    }

    @WithTryCatchRuntime
    public void refreshIndicatorColor(boolean z, @Nullable ColorStateList colorStateList) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.y0.c(new Object[]{this, r.a.c.b.e.a(z), colorStateList, e.x(f, this, this, r.a.c.b.e.a(z), colorStateList)}).e(69648));
    }

    @WithTryCatchRuntime
    public void refreshView(int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.y0.a(new Object[]{this, r.a.c.b.e.k(i), e.w(d, this, this, r.a.c.b.e.k(i))}).e(69648));
    }

    @WithTryCatchRuntime
    public void refreshViewColor(boolean z, @Nullable ColorStateList colorStateList, boolean z2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.y0.b(new Object[]{this, r.a.c.b.e.a(z), colorStateList, r.a.c.b.e.a(z2), e.y(e, this, this, new Object[]{r.a.c.b.e.a(z), colorStateList, r.a.c.b.e.a(z2)})}).e(69648));
    }
}
