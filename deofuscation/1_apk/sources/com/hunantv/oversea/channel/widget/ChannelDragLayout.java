package com.hunantv.oversea.channel.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.hunantv.imgo.nightmode.view.SkinnableRelativeLayout;
import com.hunantv.imgo.widget.DragContainerLayout;
import com.hunantv.media.drm.IDrmSession;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.imagelib.DiskPolicy;
import com.mgtv.imagelib.LoadPriority;
import j.l.a.b0.v;
import j.l.c.i.k0.b;
import j.v.h.d;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelDragLayout extends SkinnableRelativeLayout {
    private static final String i = "ChannelDragLayout";
    private static final int j = 600;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private final DragContainerLayout a;
    private final ImageView b;
    private final ViewGroup c;
    private e d;
    private CountDownTimer e;
    private int f;
    private boolean g;
    private boolean h;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ChannelDragLayout.this.g = false;
            ChannelDragLayout.this.u0();
            v.l(ChannelDragLayout.i, "mTimer.onFinish:");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            v.l(ChannelDragLayout.i, "mTimer.onTick:" + j);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends d {
        public b() {
            super(null);
        }

        @Override // com.hunantv.oversea.channel.widget.ChannelDragLayout.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            if (ChannelDragLayout.this.e == null || ChannelDragLayout.this.f <= 0 || ChannelDragLayout.this.g) {
                return;
            }
            ChannelDragLayout.this.g = true;
            ChannelDragLayout.this.e.start();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c extends d {
        public c() {
            super(null);
        }

        @Override // com.hunantv.oversea.channel.widget.ChannelDragLayout.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            ChannelDragLayout.this.hide();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class d implements Animation.AnimationListener {
        private d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface e {
        void a();

        void onClose();
    }

    static {
        t0();
    }

    public ChannelDragLayout(Context context) {
        this(context, null);
    }

    public static final /* synthetic */ void B0(ChannelDragLayout channelDragLayout, int i2, r.a.b.c cVar) {
        channelDragLayout.f = i2;
        CountDownTimer countDownTimer = channelDragLayout.e;
        if (countDownTimer != null) {
            channelDragLayout.g = false;
            countDownTimer.cancel();
            channelDragLayout.e = null;
        }
        if (i2 <= 0) {
            return;
        }
        channelDragLayout.e = new a(1000 * i2, 1000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void C0(ChannelDragLayout channelDragLayout, boolean z, r.a.b.c cVar) {
        CountDownTimer countDownTimer = channelDragLayout.e;
        if (countDownTimer == null) {
            return;
        }
        if (z) {
            if (!channelDragLayout.h || channelDragLayout.g) {
                return;
            }
            channelDragLayout.g = true;
            countDownTimer.start();
            return;
        }
        channelDragLayout.g = false;
        countDownTimer.cancel();
        channelDragLayout.h = true;
        channelDragLayout.setAlpha(1.0f);
    }

    public static final /* synthetic */ void D0(ChannelDragLayout channelDragLayout, int i2, r.a.b.c cVar) {
        ViewGroup viewGroup = channelDragLayout.c;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i2;
            }
        }
    }

    private static /* synthetic */ void t0() {
        r.a.c.c.e eVar = new r.a.c.c.e("ChannelDragLayout.java", ChannelDragLayout.class);
        k = eVar.H("method-execution", eVar.E("1", "setDuration", "com.hunantv.oversea.channel.widget.ChannelDragLayout", "int", "duration", "", "void"), 86);
        l = eVar.H("method-execution", eVar.E("1", "updateDragMargin", "com.hunantv.oversea.channel.widget.ChannelDragLayout", "int", "marginBottom", "", "void"), 116);
        m = eVar.H("method-execution", eVar.E("1", "toggleTimer", "com.hunantv.oversea.channel.widget.ChannelDragLayout", "boolean", "open", "", "void"), (int) IDrmSession.ERROR_SESSION_DRM_PSSHS_NOT_SUPPORT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0(View view) {
        setDuration(0);
        e eVar = this.d;
        if (eVar != null) {
            eVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void A0(View view) {
        e eVar = this.d;
        if (eVar != null) {
            eVar.onClose();
        }
    }

    public void destroy() {
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            this.g = false;
            countDownTimer.cancel();
            this.e = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hide() {
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            this.g = false;
            countDownTimer.cancel();
        }
        setVisibility(8);
        SkinnableRelativeLayout skinnableRelativeLayout = this.a;
        if (skinnableRelativeLayout != null) {
            skinnableRelativeLayout.setVisibility(8);
        }
    }

    @WithTryCatchRuntime
    public void setDuration(int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.g.c(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(k, this, this, r.a.c.b.e.k(i2))}).e(69648));
    }

    public void setImageUrl(String str) {
        if (this.b != null) {
            j.v.h.e.A(this.b, str, new d.b().y0(0).C0(true).N0(DiskPolicy.SOURCE).X0(LoadPriority.HIGH).w0(), (j.v.h.j.d) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInvisible(boolean z) {
        if (getVisibility() != 8) {
            toggleTimer(!z);
            setVisibility(z ? 4 : 0);
        }
        SkinnableRelativeLayout skinnableRelativeLayout = this.a;
        if (skinnableRelativeLayout == null || skinnableRelativeLayout.getVisibility() == 8) {
            return;
        }
        this.a.setVisibility(z ? 4 : 0);
    }

    public void setOnInnerClickListener(e eVar) {
        this.d = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        setVisibility(0);
        SkinnableRelativeLayout skinnableRelativeLayout = this.a;
        if (skinnableRelativeLayout != null) {
            skinnableRelativeLayout.setVisibility(0);
        }
    }

    @WithTryCatchRuntime
    public void toggleTimer(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.g.e(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(m, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setAnimationListener(new c());
        startAnimation(alphaAnimation);
    }

    @WithTryCatchRuntime
    public void updateDragMargin(int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.g.d(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(l, this, this, r.a.c.b.e.k(i2))}).e(69648));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v0() {
        show();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setAnimationListener(new b());
        startAnimation(alphaAnimation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean w0() {
        SkinnableRelativeLayout skinnableRelativeLayout = this.a;
        return skinnableRelativeLayout != null && skinnableRelativeLayout.getVisibility() == 0 && getVisibility() == 0;
    }

    public ChannelDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelDragLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g = false;
        this.h = false;
        LayoutInflater.from(context).inflate(b.l.layout_drag_enter, (ViewGroup) this);
        this.a = (DragContainerLayout) findViewById(b.i.rl_apperience_enter);
        ImageView imageView = (ImageView) findViewById(b.i.apperience_enter);
        this.b = imageView;
        this.c = (ViewGroup) findViewById(b.i.rl_drag_enter);
        imageView.setOnClickListener(new j.l.c.c.g.b(this));
        ((ImageView) findViewById(b.i.apperience_close)).setOnClickListener(new j.l.c.c.g.a(this));
    }
}
