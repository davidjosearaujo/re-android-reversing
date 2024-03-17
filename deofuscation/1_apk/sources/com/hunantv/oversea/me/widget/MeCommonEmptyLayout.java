package com.hunantv.oversea.me.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import j.l.c.k.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class MeCommonEmptyLayout extends SkinnableFrameLayout {
    @Nullable
    private View a;
    @Nullable
    private ImageView b;
    @Nullable
    private TextView c;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public MeCommonEmptyLayout(Context context) {
        this(context, null);
    }

    public void destroy() {
        super.setOnClickListener((View.OnClickListener) null);
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(null);
        }
        this.b = null;
        this.c = null;
    }

    public void setContentOnClickListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.a;
        if (view == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public void setIcon(int i) {
        ImageView imageView = this.b;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(i);
    }

    @Deprecated
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
    }

    public void setText(int i) {
        TextView textView = this.c;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public MeCommonEmptyLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MeCommonEmptyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(c.m.me_layout_common_empty, (ViewGroup) this);
        View findViewById = findViewById(c.j.contentLayout);
        this.a = findViewById;
        this.b = (ImageView) findViewById.findViewById(c.j.ivIcon);
        this.c = (TextView) this.a.findViewById(c.j.tvDesc);
        super.setOnClickListener(new a());
    }
}
