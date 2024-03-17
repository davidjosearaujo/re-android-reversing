package com.hunantv.imgo.widget;

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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.hunantv.imgo.nightmode.view.SkinnableRelativeLayout;
import com.hunantv.imgo.nightmode.view.SkinnableView;
import j.l.a.a0.b;
import j.l.a.b0.j0;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CustomizeTitleBar extends SkinnableRelativeLayout implements j.l.a.h.a, View.OnClickListener, View.OnLongClickListener {
    private View a;
    private ImageView b;
    private ImageView c;
    private TextView d;
    private FrameLayout e;
    public TextView f;
    private View g;
    private boolean h;
    @Nullable
    public b i;
    @Nullable
    public c j;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class a {
        public static final byte a = 0;
        public static final byte b = 1;
        public static final byte c = 2;
        public static final byte d = 3;
        public static final byte e = 4;
        public static final byte f = 5;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface b {
        void a(View view, byte b);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface c {
        boolean a(View view, byte b);
    }

    public CustomizeTitleBar(Context context) {
        this(context, null);
    }

    public void destroy() {
        this.i = null;
        this.j = null;
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(null);
            this.a.setOnLongClickListener(null);
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.b.setOnLongClickListener(null);
        }
        ImageView imageView2 = this.c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
            this.c.setOnLongClickListener(null);
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(null);
            this.d.setOnLongClickListener(null);
        }
        FrameLayout frameLayout = this.e;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(null);
            this.e.setOnLongClickListener(null);
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setOnClickListener(null);
            this.f.setOnLongClickListener(null);
        }
    }

    @Nullable
    public View n0(byte b2) {
        if (b2 != 0) {
            if (b2 != 1) {
                if (b2 != 2) {
                    if (b2 != 3) {
                        if (b2 != 4) {
                            if (b2 != 5) {
                                return null;
                            }
                            return this.f;
                        }
                        return this.e;
                    }
                    return this.d;
                }
                return this.c;
            }
            return this.b;
        }
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o0(Context context, AttributeSet attributeSet) {
        this.a = findViewById(b.i.rootLayout);
        this.b = (ImageView) findViewById(b.i.ivLeft);
        this.c = (ImageView) findViewById(b.i.ivRight);
        this.d = (TextView) findViewById(b.i.tvRight);
        this.e = (FrameLayout) findViewById(b.i.rightFrame);
        this.f = (TextView) findViewById(b.i.tvCenter);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.a.setOnLongClickListener(this);
        this.b.setOnLongClickListener(this);
        this.c.setOnLongClickListener(this);
        this.d.setOnLongClickListener(this);
        this.e.setOnLongClickListener(this);
        this.f.setOnLongClickListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.CustomizeTitleBar);
        Drawable drawable = obtainStyledAttributes.getDrawable(b.r.CustomizeTitleBar_leftIcon);
        if (drawable != null) {
            this.b.setImageDrawable(drawable);
        } else {
            this.b.setImageResource(b.g.icon_back_selector);
        }
        this.b.setVisibility(obtainStyledAttributes.getBoolean(b.r.CustomizeTitleBar_leftIconVisible, true) ? 0 : 8);
        int resourceId = obtainStyledAttributes.getResourceId(b.r.CustomizeTitleBar_rightIcon, -1);
        if (resourceId != -1) {
            this.c.setImageResource(resourceId);
        } else {
            this.c.setVisibility(8);
        }
        String string = obtainStyledAttributes.getString(b.r.CustomizeTitleBar_rightText);
        if (TextUtils.isEmpty(string)) {
            this.d.setVisibility(8);
        } else {
            this.d.setText(string);
        }
        this.d.setTextColor(obtainStyledAttributes.getColor(b.r.CustomizeTitleBar_rightTextColor, ContextCompat.getColor(context, b.e.color_v60_mgtv)));
        String string2 = obtainStyledAttributes.getString(b.r.CustomizeTitleBar_titleText);
        if (!TextUtils.isEmpty(string2)) {
            this.f.setText(string2);
        }
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(b.r.CustomizeTitleBar_titleTextSize, 0);
        if (dimensionPixelSize > 0.0f) {
            this.f.setTextSize(0, dimensionPixelSize);
        }
        this.h = obtainStyledAttributes.getBoolean(b.r.CustomizeTitleBar_shadow, true);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.widget.RelativeLayout*/.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (this.h && (viewGroup instanceof RelativeLayout)) {
            SkinnableView skinnableView = new SkinnableView(getContext());
            this.g = skinnableView;
            skinnableView.setBackgroundResource(b.e.mgtv_theme_color_EAEAEA);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, j0.b(getContext(), 0.5f));
            layoutParams.addRule(3, getId());
            viewGroup.addView(this.g, layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.i == null) {
            return;
        }
        int id = view.getId();
        if (id == b.i.rootLayout) {
            this.i.a(view, (byte) 0);
        } else if (id == b.i.ivLeft) {
            this.i.a(view, (byte) 1);
        } else if (id == b.i.ivRight) {
            this.i.a(view, (byte) 2);
        } else if (id == b.i.tvRight) {
            this.i.a(view, (byte) 3);
        } else if (id == b.i.rightFrame) {
            this.i.a(view, (byte) 4);
        } else if (id == b.i.tvCenter) {
            this.i.a(view, (byte) 5);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.j == null) {
            return false;
        }
        int id = view.getId();
        if (id == b.i.rootLayout) {
            return this.j.a(view, (byte) 0);
        }
        if (id == b.i.ivLeft) {
            return this.j.a(view, (byte) 1);
        }
        if (id == b.i.ivRight) {
            return this.j.a(view, (byte) 2);
        }
        if (id == b.i.tvRight) {
            return this.j.a(view, (byte) 3);
        }
        if (id == b.i.rightFrame) {
            return this.j.a(view, (byte) 4);
        }
        if (id == b.i.tvCenter) {
            return this.j.a(view, (byte) 5);
        }
        return false;
    }

    public int q0() {
        return b.l.layout_me_customize_titlebar;
    }

    public void r0(byte b2, @ColorInt int i) {
        View n0 = n0(b2);
        if (n0 == null || !(n0 instanceof TextView)) {
            return;
        }
        ((TextView) n0).setTextColor(i);
    }

    public void setBackgroundResource(@DrawableRes int i) {
        View view = this.a;
        if (view == null) {
            return;
        }
        view.setBackgroundResource(i);
    }

    public void setLeftIcon(int i) {
        this.b.setImageResource(i);
    }

    public void setLeftIconVisible(int i) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setOnComponentClickListener(b bVar) {
        this.i = bVar;
    }

    public void setOnComponentLongClickListener(c cVar) {
        this.j = cVar;
    }

    public void setRightIcon(int i) {
        this.c.setImageResource(i);
    }

    public void setRightText(int i) {
        this.d.setText(i);
    }

    public void setRightView(View view) {
        if (view == null) {
            return;
        }
        this.e.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.e.addView(view, layoutParams);
    }

    public void setTitleText(int i) {
        if (i != 0) {
            this.f.setVisibility(0);
            this.f.setText(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int i) {
        super/*android.widget.RelativeLayout*/.setVisibility(i);
        if (i == 0) {
            View view = this.g;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.g;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void t0(byte b2, int i) {
        View n0 = n0(b2);
        if (n0 == null) {
            return;
        }
        n0.setVisibility(i);
    }

    public CustomizeTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setLeftIcon(Drawable drawable) {
        this.b.setImageDrawable(drawable);
    }

    public void setRightIcon(Drawable drawable) {
        this.c.setImageDrawable(drawable);
    }

    public void setRightText(CharSequence charSequence) {
        this.d.setText(charSequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomizeTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(q0(), (ViewGroup) this);
        o0(context, attributeSet);
    }

    public void setTitleText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f.setVisibility(0);
        this.f.setText(charSequence);
    }
}
