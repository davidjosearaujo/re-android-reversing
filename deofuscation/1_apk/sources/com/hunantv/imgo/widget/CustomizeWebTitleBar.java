package com.hunantv.imgo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.hunantv.imgo.nightmode.view.SkinnableRelativeLayout;
import j.l.a.a0.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CustomizeWebTitleBar extends SkinnableRelativeLayout implements j.l.a.h.a, View.OnClickListener, View.OnLongClickListener {
    private View a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private LinearLayout h;
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
        public static final byte f = 6;
        public static final byte g = 5;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface b {
        void a(View view, byte b);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface c {
        boolean a(View view, byte b);
    }

    public CustomizeWebTitleBar(Context context) {
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
        ImageView imageView3 = this.d;
        if (imageView3 != null) {
            imageView3.setOnClickListener(null);
            this.d.setOnLongClickListener(null);
        }
        ImageView imageView4 = this.e;
        if (imageView4 != null) {
            imageView4.setOnClickListener(null);
            this.e.setOnLongClickListener(null);
        }
        ImageView imageView5 = this.f;
        if (imageView5 != null) {
            imageView5.setOnClickListener(null);
            this.f.setOnLongClickListener(null);
        }
        TextView textView = this.g;
        if (textView != null) {
            textView.setOnClickListener(null);
            this.g.setOnLongClickListener(null);
        }
    }

    @Nullable
    public View n0(byte b2) {
        switch (b2) {
            case 0:
                return this.a;
            case 1:
                return this.b;
            case 2:
                return this.c;
            case 3:
                return this.d;
            case 4:
                return this.e;
            case 5:
                return this.g;
            case 6:
                return this.f;
            default:
                return null;
        }
    }

    public void o0() {
        this.h.setVisibility(8);
        this.b.setVisibility(0);
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
            this.i.a(view, (byte) 3);
        } else if (id == b.i.tvBack) {
            this.i.a(view, (byte) 2);
        } else if (id == b.i.tvClose) {
            this.i.a(view, (byte) 3);
        } else if (id == b.i.ivRight) {
            this.i.a(view, (byte) 4);
        } else if (id == b.i.ivRightSub) {
            this.i.a(view, (byte) 6);
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
            return this.j.a(view, (byte) 3);
        }
        if (id == b.i.ivRight) {
            return this.j.a(view, (byte) 4);
        }
        if (id == b.i.ivRightSub) {
            return this.j.a(view, (byte) 6);
        }
        if (id == b.i.tvBack) {
            return this.j.a(view, (byte) 2);
        }
        if (id == b.i.tvClose) {
            return this.j.a(view, (byte) 3);
        }
        if (id == b.i.tvCenter) {
            return this.j.a(view, (byte) 5);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q0(Context context, AttributeSet attributeSet) {
        this.a = findViewById(b.i.rootLayout);
        this.b = (ImageView) findViewById(b.i.ivLeft);
        this.h = (LinearLayout) findViewById(b.i.leftTextFrame);
        this.c = (ImageView) findViewById(b.i.tvBack);
        this.d = (ImageView) findViewById(b.i.tvClose);
        this.e = (ImageView) findViewById(b.i.ivRight);
        this.f = (ImageView) findViewById(b.i.ivRightSub);
        this.g = (TextView) findViewById(b.i.tvCenter);
        this.h.setVisibility(8);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.a.setOnLongClickListener(this);
        this.b.setOnLongClickListener(this);
        this.c.setOnLongClickListener(this);
        this.d.setOnLongClickListener(this);
        this.e.setOnLongClickListener(this);
        this.f.setOnLongClickListener(this);
        this.g.setOnLongClickListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.r.CustomizeTitleBar);
        Drawable drawable = obtainStyledAttributes.getDrawable(b.r.CustomizeTitleBar_rightIcon);
        if (drawable != null) {
            this.e.setImageDrawable(drawable);
        } else {
            this.e.setVisibility(8);
        }
        obtainStyledAttributes.recycle();
    }

    public int r0() {
        return b.l.layout_web_customize_titlebar;
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

    public void setOnComponentClickListener(b bVar) {
        this.i = bVar;
    }

    public void setOnComponentLongClickListener(c cVar) {
        this.j = cVar;
    }

    public void setRightIcon(int i) {
        this.e.setImageResource(i);
    }

    public void setRightIconSub(int i) {
        if (i != 0) {
            this.f.setVisibility(0);
            this.f.setImageResource(i);
        }
    }

    public void setTitleText(int i) {
        if (i != 0) {
            this.g.setVisibility(0);
            this.g.setText(i);
        }
    }

    public void t0(byte b2, @ColorInt int i) {
        View n0 = n0(b2);
        if (n0 == null || !(n0 instanceof TextView)) {
            return;
        }
        ((TextView) n0).setTextColor(i);
    }

    public void u0(byte b2, int i) {
        View n0 = n0(b2);
        if (n0 == null) {
            return;
        }
        n0.setVisibility(i);
    }

    public void v0() {
        this.h.setVisibility(0);
        this.b.setVisibility(8);
    }

    public CustomizeWebTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setLeftIcon(Drawable drawable) {
        this.b.setImageDrawable(drawable);
    }

    public void setRightIcon(Drawable drawable) {
        this.e.setImageDrawable(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomizeWebTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(r0(), (ViewGroup) this);
        q0(context, attributeSet);
    }

    public void setRightIconSub(Drawable drawable) {
        if (drawable != null) {
            this.f.setVisibility(0);
            this.f.setImageDrawable(drawable);
        }
    }

    public void setTitleText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.g.setVisibility(0);
        this.g.setText(charSequence);
    }
}
