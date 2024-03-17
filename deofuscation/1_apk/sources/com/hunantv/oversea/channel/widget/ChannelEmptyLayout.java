package com.hunantv.oversea.channel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import j.l.c.c.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ChannelEmptyLayout extends SkinnableFrameLayout {
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

    public ChannelEmptyLayout(Context context) {
        this(context, null);
    }

    public void b0(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View view = this.a;
        if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.rightMargin = i3;
        marginLayoutParams.bottomMargin = i4;
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

    public void setContentGravity(int i) {
        FrameLayout.LayoutParams layoutParams;
        View view = this.a;
        if (view == null || (layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.gravity = i;
    }

    public void setContentOnClickListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.a;
        if (view == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public void setIcon(@DrawableRes int i) {
        ImageView imageView = this.b;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(i);
    }

    public void setMiddleMargin(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        TextView textView = this.c;
        if (textView == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams()) == null) {
            return;
        }
        marginLayoutParams.topMargin = i;
    }

    @Deprecated
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
    }

    public void setText(@StringRes int i) {
        TextView textView = this.c;
        if (textView == null) {
            return;
        }
        textView.setText(i);
    }

    public ChannelEmptyLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelEmptyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(b.m.layout_channel_empty, (ViewGroup) this);
        View findViewById = findViewById(b.j.contentLayout);
        this.a = findViewById;
        this.b = (ImageView) findViewById.findViewById(b.j.ivIcon);
        this.c = (TextView) this.a.findViewById(b.j.tvDesc);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.t.ChannelEmptyLayout);
        Drawable drawable = obtainStyledAttributes.getDrawable(b.t.ChannelEmptyLayout_emptyIcon);
        if (drawable != null) {
            this.b.setImageDrawable(drawable);
        }
        String string = obtainStyledAttributes.getString(b.t.ChannelEmptyLayout_emptyText);
        if (!TextUtils.isEmpty(string)) {
            this.c.setText(string);
        }
        setMiddleMargin((int) obtainStyledAttributes.getDimension(b.t.ChannelEmptyLayout_middleMargin, 0.0f));
        obtainStyledAttributes.recycle();
        super.setOnClickListener(new a());
    }
}
