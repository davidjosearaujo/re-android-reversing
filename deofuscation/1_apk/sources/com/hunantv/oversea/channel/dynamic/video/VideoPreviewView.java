package com.hunantv.oversea.channel.dynamic.video;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.app.OpenAuthTask;
import com.facebook.share.internal.ShareConstants;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.android.YogaLayout;
import com.huawei.agconnect.exception.AGCServerException;
import com.hunantv.imgo.net.ImgoHttpCallBack;
import com.hunantv.imgo.net.ImgoHttpParams;
import com.hunantv.imgo.nightmode.view.SkinnableFrameLayout;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.utils.ExTicker;
import com.hunantv.media.report.ReportParams;
import com.hunantv.media.widget.IVideoView;
import com.hunantv.media.widget.MgtvLoopVideoView;
import com.hunantv.mpdt.statistics.cdn.CdnQualityReport;
import com.hunantv.oversea.business.ad.huge.HugeMananger;
import com.hunantv.oversea.channel.dynamic.render.banner.BannerHelper;
import com.hunantv.oversea.channel.dynamic.video.VideoPreviewManager;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.hunantv.oversea.play.report.videoPreview.VideoPreviewReporter;
import com.hunantv.oversea.playlib.entity.PlayAuthEntity;
import com.hunantv.oversea.playlib.entity.PlayAuthRouterEntity;
import com.hunantv.oversea.playlib.entity.PlayStartInfo;
import com.hunantv.oversea.playlib.entity.PlayerUrlEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.b0;
import j.l.a.b0.f0;
import j.l.a.b0.j0;
import j.l.a.b0.p0;
import j.l.a.b0.v;
import j.l.a.j.a;
import j.l.c.c.b;
import j.l.c.c.c.x1.a0;
import j.l.c.c.c.x1.c0;
import j.l.c.c.c.x1.d0;
import j.l.c.c.c.x1.e0;
import j.l.c.c.c.x1.g0;
import j.l.c.c.c.x1.h0;
import j.l.c.c.c.x1.i0;
import j.l.c.c.c.x1.k0;
import j.l.c.c.c.x1.l0;
import j.l.c.c.c.x1.m0;
import j.l.c.c.c.x1.n0;
import j.l.c.c.c.x1.s;
import j.l.c.c.c.x1.t;
import j.l.c.c.c.x1.u;
import j.l.c.c.c.x1.w;
import j.l.c.c.c.x1.x;
import j.l.c.c.c.x1.y;
import j.l.c.c.c.x1.z;
import j.l.c.x.o0;
import j.s.j.y0;
import j.u.k.a;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VideoPreviewView extends SkinnableFrameLayout implements a.c {
    public static final String A2 = "sp_key_preview_mute";
    private static final String B2 = "android.media.VOLUME_CHANGED_ACTION";
    private static final String C2 = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static final int D2 = 3;
    private static final /* synthetic */ c.b E2 = null;
    private static final /* synthetic */ c.b F2 = null;
    private static final /* synthetic */ c.b G2 = null;
    private static final /* synthetic */ c.b H2 = null;
    private static final /* synthetic */ c.b I2 = null;
    private static final /* synthetic */ c.b J2 = null;
    private static final /* synthetic */ c.b K2 = null;
    private static final /* synthetic */ c.b L2 = null;
    private static final /* synthetic */ c.b M2 = null;
    private static final /* synthetic */ c.b N2 = null;
    private static final /* synthetic */ c.b O2 = null;
    private static final /* synthetic */ c.b P2 = null;
    private static final /* synthetic */ c.b Q2 = null;
    private static final /* synthetic */ c.b R2 = null;
    private static final /* synthetic */ c.b S2 = null;
    private static final /* synthetic */ c.b T2 = null;
    private static final /* synthetic */ c.b U2 = null;
    private static final /* synthetic */ c.b V2 = null;
    private static final /* synthetic */ c.b W2 = null;
    private static final /* synthetic */ c.b X2 = null;
    private static final /* synthetic */ c.b Y2 = null;
    private static final /* synthetic */ c.b Z2 = null;
    private static final /* synthetic */ c.b a3 = null;
    private static final /* synthetic */ c.b b3 = null;
    private static final /* synthetic */ c.b c3 = null;
    private static final /* synthetic */ c.b d3 = null;
    private static final /* synthetic */ c.b e3 = null;
    private static final /* synthetic */ c.b f3 = null;
    private static final /* synthetic */ c.b g3 = null;
    private static final /* synthetic */ c.b h3 = null;
    private static final /* synthetic */ c.b i3 = null;
    private static final /* synthetic */ c.b j3 = null;
    private static final /* synthetic */ c.b k3 = null;
    private static final /* synthetic */ c.b l3 = null;
    private static final /* synthetic */ c.b m3 = null;
    private static final /* synthetic */ c.b n3 = null;
    private static final /* synthetic */ c.b o3 = null;
    private static final String y2 = "VideoPreviewView";
    private static final int z2 = 1000;
    @Nullable
    private PlayAuthRouterEntity A;
    private String B;
    private String C;
    private boolean C1;
    private String D;
    private int E;
    private int F;
    private boolean K0;
    private r K1;
    private boolean a;
    private Context b;
    private TextView c;
    private TextView d;
    public MgtvLoopVideoView e;
    private boolean f;
    private j.v.r.r g;
    private j.v.r.m h;
    private VideoPreviewManager.c i;
    private VideoPreviewManager.d j;
    private int k;
    private String k0;
    private ExTicker k1;
    private int l;
    private HashMap<String, Integer> m;
    private View n;
    private int o;
    private View[] p;
    private AudioManager p2;
    private boolean q;
    @Nullable
    private String q2;
    @Nullable
    private j.l.c.c.c.x1.b r;
    private ReportParams r2;
    private PlayStartInfo s;
    private j.v.r.l s2;
    private j.u.k.a t;
    private long t2;
    private ImageView u;
    private long u2;
    private View v;
    private Handler v2;
    private View w;
    private q w2;
    private boolean x;
    @Nullable
    private CdnQualityReport x1;
    private IVideoView.OnInfoListener x2;
    private FrameLayout y;
    private boolean y1;
    @Nullable
    private PlayAuthEntity z;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends ImgoHttpCallBack<PlayerUrlEntity> {
        public final /* synthetic */ long d;

        public a(long j) {
            this.d = j;
        }

        @Override // com.hunantv.imgo.net.ImgoHttpCallBack
        /* renamed from: w */
        public void previewCache(PlayerUrlEntity playerUrlEntity) {
        }

        /* renamed from: x */
        public void success(PlayerUrlEntity playerUrlEntity) {
            if (playerUrlEntity == null || TextUtils.isEmpty(playerUrlEntity.info) || VideoPreviewView.this.A == null) {
                VideoPreviewView.this.handError();
                return;
            }
            VideoPreviewView videoPreviewView = VideoPreviewView.this;
            videoPreviewView.D = videoPreviewView.C;
            if (VideoPreviewView.this.s != null) {
                VideoPreviewView.this.s.mUrlEntity = playerUrlEntity;
            }
            j.l.c.c.c.x1.a.f(r().getFinalUrl(), VideoPreviewView.this.A.definition);
            VideoPreviewView.this.executeThirdStep(playerUrlEntity);
            long currentTimeMillis = System.currentTimeMillis() - this.d;
            if (currentTimeMillis > 0) {
                o0.n.a("ChannelAutoPlayer-2-Consume", (int) currentTimeMillis);
            }
        }

        public void failed(@Nullable PlayerUrlEntity playerUrlEntity, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(playerUrlEntity, i, i2, str, th);
            VideoPreviewView.B0(VideoPreviewView.this);
            boolean E1 = VideoPreviewView.this.E1();
            j.l.c.c.c.x1.a.d(r().getFinalUrl(), VideoPreviewView.this.A == null ? 0 : VideoPreviewView.this.A.definition, i, str, th, E1);
            if (E1) {
                VideoPreviewView.this.setVisibility(8);
                VideoPreviewView.this.handError();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements ExTicker.onTickListener {
        public b() {
        }

        @Override // com.hunantv.media.player.utils.ExTicker.onTickListener
        public void onTick(int i) {
            MgtvLoopVideoView mgtvLoopVideoView;
            if (VideoPreviewView.this.r != null) {
                VideoPreviewView videoPreviewView = VideoPreviewView.this;
                if (videoPreviewView.e != null) {
                    videoPreviewView.r.onTick(VideoPreviewView.this.e.getCurrentPosition(), i, VideoPreviewView.this.k1.getTickTime());
                }
            }
            if (VideoPreviewView.this.i == null || !VideoPreviewView.this.m1() || (mgtvLoopVideoView = VideoPreviewView.this.e) == null || mgtvLoopVideoView.getCurrentPosition() < VideoPreviewView.this.e.getDuration() * 0.5f) {
                return;
            }
            HugeMananger.h().onHugeSmallVideoMiddle();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c implements IVideoView.OnPreparedListener {
        public c() {
        }

        @Override // com.hunantv.media.widget.IVideoView.OnPreparedListener
        public void onPrepared() {
            if (VideoPreviewView.this.A != null) {
                j.l.c.c.c.x1.a.i(VideoPreviewView.this.A.definition, false, VideoPreviewView.this.B, VideoPreviewView.this.getCdnLastIp());
            }
            if (VideoPreviewView.this.q && ((VideoPreviewView.this.q2 != null && VideoPreviewView.this.q2.equals(VideoPreviewView.this.i.b)) || VideoPreviewView.this.m1())) {
                VideoPreviewView.this.e.start();
            }
            if (VideoPreviewView.this.u2 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - VideoPreviewView.this.u2;
                if (currentTimeMillis > 0) {
                    o0.n.a("ChannelAutoPlayer-3-Consume", (int) currentTimeMillis);
                }
                VideoPreviewView.this.u2 = 0L;
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class d implements IVideoView.OnPauseListener {
        public d() {
        }

        @Override // com.hunantv.media.widget.IVideoView.OnPauseListener
        public void onPause() {
            if (VideoPreviewView.this.x1 != null && VideoPreviewView.this.x1.p()) {
                VideoPreviewView.this.x1.G("", false);
            }
            if (VideoPreviewView.this.b instanceof Activity) {
                j0.z((Activity) VideoPreviewView.this.b);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class e implements IVideoView.OnStartListener {
        public e() {
        }

        @Override // com.hunantv.media.widget.IVideoView.OnStartListener
        public void onStart() {
            if (TextUtils.equals(VideoPreviewView.this.q2, VideoPreviewView.this.i.b)) {
                if (VideoPreviewView.this.x1 != null) {
                    VideoPreviewView.this.x1.t(false);
                }
                if (VideoPreviewView.this.b instanceof Activity) {
                    j0.w((Activity) VideoPreviewView.this.b);
                }
                if (VideoPreviewView.this.k1.getTickCount() == 0) {
                    VideoPreviewView.this.k1.start();
                } else {
                    VideoPreviewView.this.k1.resume();
                }
                if (VideoPreviewView.this.r != null) {
                    VideoPreviewView.this.r.onStart();
                    return;
                }
                return;
            }
            VideoPreviewView.this.e.pause();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class f implements IVideoView.OnCompletionListener {
        public f() {
        }

        @Override // com.hunantv.media.widget.IVideoView.OnCompletionListener
        public void onCompletion(int i, int i2) {
            if (VideoPreviewView.this.k1 != null) {
                VideoPreviewView.this.k1.stop();
            }
            if (VideoPreviewView.this.b instanceof Activity) {
                j0.z((Activity) VideoPreviewView.this.b);
            }
            if (i == 30011 || i == 30020 || i == 30030 || i == 30031 || i == 30032) {
                VideoPreviewView.this.q1("异常结束，重试二层");
                VideoPreviewView.this.D1(i, i2);
                return;
            }
            VideoPreviewView.this.m.remove(VideoPreviewView.this.i.b);
            VideoPreviewView.this.k = 0;
            if (!VideoPreviewView.this.a) {
                VideoPreviewView.this.onVideoEnd();
            } else {
                v.c(VideoPreviewView.y2, "onCompletion and autoreplay");
                VideoPreviewView.this.e.start();
            }
            VideoPreviewView.this.handError();
            if (VideoPreviewView.this.r != null) {
                VideoPreviewView.this.r.onPlayCompletion();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class g implements IVideoView.OnErrorListener {
        public g() {
        }

        @Override // com.hunantv.media.widget.IVideoView.OnErrorListener
        public boolean onError(int i, int i2) {
            VideoPreviewView.this.q1("播放出错，重试二层");
            VideoPreviewView.this.D1(i, i2);
            return true;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class h implements IVideoView.OnInfoListener {
        public long a;
        public boolean b;

        public h() {
        }

        @Override // com.hunantv.media.widget.IVideoView.OnInfoListener
        public boolean onInfo(int i, int i2) {
            if (i != 701) {
                if (i == 702) {
                    if (this.b) {
                        long currentTimeMillis = this.a > 0 ? System.currentTimeMillis() - this.a : 0L;
                        this.b = false;
                        VideoPreviewView.this.c1(i2, currentTimeMillis);
                    }
                    if (VideoPreviewView.this.k1 != null && VideoPreviewView.this.e.isPlaying()) {
                        VideoPreviewView.this.k1.resume();
                    }
                } else if (i == 900) {
                    VideoPreviewView videoPreviewView = VideoPreviewView.this;
                    videoPreviewView.q1("VideoPreviewView.onInfo: 二层重试次数：" + VideoPreviewView.this.F + ", svrip=" + VideoPreviewView.this.k0);
                    VideoPreviewView.this.hideBreathView();
                    if (VideoPreviewView.this.q) {
                        VideoPreviewView videoPreviewView2 = VideoPreviewView.this;
                        if (videoPreviewView2.e != null) {
                            if (videoPreviewView2.k1 != null) {
                                VideoPreviewView.this.k1.start();
                            }
                            VideoPreviewView.this.K0 = true;
                            VideoPreviewView.this.onVideoStart();
                            v.c(VideoPreviewView.y2, "MEDIA_INFO_RENDERING_START:" + VideoPreviewView.this.k);
                            if (VideoPreviewView.this.i != null && VideoPreviewView.this.m1() && VideoPreviewView.this.k == 0) {
                                HugeMananger.h().onHugeSmallVideoStart();
                            }
                            if (VideoPreviewView.this.t2 > 0) {
                                long currentTimeMillis2 = System.currentTimeMillis() - VideoPreviewView.this.t2;
                                if (currentTimeMillis2 > 0) {
                                    o0.n.a("ChannelAutoPlayer-Consume", (int) currentTimeMillis2);
                                }
                                VideoPreviewView.this.t2 = 0L;
                            }
                        }
                    }
                    return true;
                }
            } else {
                this.b = true;
                this.a = System.currentTimeMillis();
                if (VideoPreviewView.this.k1 != null) {
                    VideoPreviewView.this.k1.pause();
                }
                if (VideoPreviewView.this.x1 != null) {
                    VideoPreviewView.this.x1.l(false);
                }
            }
            return true;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPreviewView videoPreviewView = VideoPreviewView.this;
            videoPreviewView.f = !videoPreviewView.u.isSelected();
            f0.p(VideoPreviewView.A2, VideoPreviewView.this.f);
            VideoPreviewView.this.u.setSelected(VideoPreviewView.this.f);
            if (VideoPreviewView.this.f) {
                VideoPreviewView.this.e.setVolume(0.0f, 0.0f);
                return;
            }
            VideoPreviewView videoPreviewView2 = VideoPreviewView.this;
            videoPreviewView2.e.setVolume(videoPreviewView2.l, VideoPreviewView.this.l);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public j() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View[] viewArr;
            if (!VideoPreviewView.this.q || VideoPreviewView.this.p == null || VideoPreviewView.this.p.length == 0) {
                return;
            }
            for (View view : VideoPreviewView.this.p) {
                if (view != null) {
                    view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public k() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (VideoPreviewView.this.q) {
                VideoPreviewView.this.e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class l implements ValueAnimator.AnimatorUpdateListener {
        public l() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View[] viewArr;
            if (!VideoPreviewView.this.q || VideoPreviewView.this.p == null || VideoPreviewView.this.p.length == 0) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            VideoPreviewView.this.n.setAlpha(floatValue);
            for (View view : VideoPreviewView.this.p) {
                if (view != null) {
                    view.setAlpha(floatValue);
                }
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public m() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SkinnableFrameLayout skinnableFrameLayout;
            if (!VideoPreviewView.this.q || (skinnableFrameLayout = VideoPreviewView.this.e) == null) {
                return;
            }
            skinnableFrameLayout.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class n extends AnimatorListenerAdapter {
        public n() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            VideoPreviewView.this.setVisibility(8);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class o extends j.l.a.l.d.a {
        public o() {
        }

        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            if (VideoPreviewView.this.q) {
                VideoPreviewView.this.n.setVisibility(8);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class p extends ImgoHttpCallBack<PlayAuthEntity> {
        public final /* synthetic */ long d;

        public p(long j) {
            this.d = j;
        }

        @Override // com.hunantv.imgo.net.ImgoHttpCallBack
        /* renamed from: w */
        public void previewCache(PlayAuthEntity playAuthEntity) {
        }

        /* renamed from: x */
        public void success(PlayAuthEntity playAuthEntity) {
            List list;
            if (playAuthEntity == null || (list = playAuthEntity.videoSources) == null || list.size() == 0) {
                VideoPreviewView.this.handError();
                return;
            }
            if (VideoPreviewView.this.s != null) {
                VideoPreviewView.this.s.mAuthEntity = playAuthEntity;
            }
            VideoPreviewView.this.z = playAuthEntity;
            VideoPreviewView videoPreviewView = VideoPreviewView.this;
            videoPreviewView.A = videoPreviewView.getRouteInfo(playAuthEntity.videoSources);
            if (VideoPreviewView.this.A == null) {
                VideoPreviewView.this.handError();
                return;
            }
            j.l.c.c.c.x1.a.c(r().getFinalUrl(), VideoPreviewView.this.A.definition);
            VideoPreviewView.this.executeSecondStep();
            long currentTimeMillis = System.currentTimeMillis() - this.d;
            if (currentTimeMillis > 0) {
                o0.n.a("ChannelAutoPlayer-Source-Consume", (int) currentTimeMillis);
            }
        }

        public void failed(@Nullable PlayAuthEntity playAuthEntity, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            List list;
            if (playAuthEntity != null && (list = playAuthEntity.videoSources) != null && list.size() != 0) {
                if (VideoPreviewView.this.s != null) {
                    VideoPreviewView.this.s.mAuthEntity = playAuthEntity;
                }
                VideoPreviewView.this.z = playAuthEntity;
                VideoPreviewView videoPreviewView = VideoPreviewView.this;
                videoPreviewView.A = videoPreviewView.getRouteInfo(playAuthEntity.videoSources);
                if (VideoPreviewView.this.A == null) {
                    VideoPreviewView.this.handError();
                    return;
                }
                VideoPreviewView.this.executeSecondStep();
            } else {
                VideoPreviewView.this.setVisibility(8);
                VideoPreviewView.this.handError();
            }
            if (u() == ImgoHttpCallBack.ErrorType.BUSINESS_ERROR) {
                j.l.c.c.c.x1.a.a(r().getFinalUrl(), VideoPreviewView.this.A != null ? VideoPreviewView.this.A.definition : 0, i2);
            } else {
                j.l.c.c.c.x1.a.b(i, r().getFinalUrl(), true, th, 0);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface q {
        void e();
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class r extends BroadcastReceiver {
        private r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (VideoPreviewView.B2.equals(intent.getAction()) && intent.getIntExtra(VideoPreviewView.C2, -1) == 3) {
                    VideoPreviewView.this.onSystemVolumeChanged();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public /* synthetic */ r(VideoPreviewView videoPreviewView, h hVar) {
            this();
        }
    }

    static {
        Z0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoPreviewView(@NonNull Context context, boolean z) {
        super(context);
        this.l = 0;
        this.m = new HashMap<>();
        this.q = true;
        this.k0 = "";
        this.K0 = false;
        this.y1 = false;
        this.C1 = false;
        this.r2 = new ReportParams().setVideoType(ReportParams.VideoType.HOME_PREVIEW);
        this.v2 = new Handler();
        this.x2 = new h();
        this.b = context;
        this.a = z;
        LayoutInflater.from(context).inflate(b.m.layout_video_preview, (ViewGroup) this);
        initView();
    }

    public static final /* synthetic */ void A1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        videoPreviewView.y.setVisibility(8);
        if (videoPreviewView.p1()) {
            videoPreviewView.c.setTextSize(1, 22.0f);
            videoPreviewView.d.setTextSize(1, 13.0f);
            videoPreviewView.updateDescLayoutMargin(j0.b(j.l.a.a.a(), 4.0f));
        } else {
            videoPreviewView.c.setTextSize(1, 20.0f);
            videoPreviewView.d.setTextSize(1, 12.0f);
            videoPreviewView.updateDescLayoutMargin(j0.b(j.l.a.a.a(), 5.0f));
        }
        if (!videoPreviewView.p1() && !videoPreviewView.n1()) {
            videoPreviewView.c.setMaxLines(1);
        } else if (TextUtils.isEmpty(videoPreviewView.i.d)) {
            videoPreviewView.c.setMaxLines(2);
        } else {
            videoPreviewView.c.setMaxLines(1);
        }
        if (!TextUtils.isEmpty(videoPreviewView.i.c)) {
            videoPreviewView.c.setText(videoPreviewView.i.c);
        } else {
            videoPreviewView.c.setText("");
        }
        if (!TextUtils.isEmpty(videoPreviewView.i.d)) {
            videoPreviewView.d.setText(videoPreviewView.i.d);
            videoPreviewView.d.setVisibility(0);
            return;
        }
        videoPreviewView.d.setText("");
        videoPreviewView.d.setVisibility(8);
    }

    public static /* synthetic */ int B0(VideoPreviewView videoPreviewView) {
        int i2 = videoPreviewView.E;
        videoPreviewView.E = i2 + 1;
        return i2;
    }

    public static final /* synthetic */ void B1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        r rVar = videoPreviewView.K1;
        if (rVar != null) {
            try {
                try {
                    videoPreviewView.b.unregisterReceiver(rVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                videoPreviewView.K1 = null;
            }
        }
        videoPreviewView.p2 = null;
        MgtvLoopVideoView mgtvLoopVideoView = videoPreviewView.e;
        if (mgtvLoopVideoView != null) {
            mgtvLoopVideoView.release();
        }
    }

    public static final /* synthetic */ void C1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        MgtvLoopVideoView mgtvLoopVideoView = videoPreviewView.e;
        if (mgtvLoopVideoView != null) {
            mgtvLoopVideoView.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void D1(int i2, int i4) {
        int i5;
        int indexOf;
        this.F++;
        q1("VideoPreviewView.retrySecondStep: mRetryCount=" + this.F);
        if (this.A != null) {
            j.l.c.c.c.x1.a.h(this.A.definition, false, i2, i4, this.B, this.F >= 3, getCdnLastIp());
        }
        if (this.F >= 3) {
            setVisibility(8);
            CdnQualityReport cdnQualityReport = this.x1;
            if (cdnQualityReport != null) {
                cdnQualityReport.m("9." + i2 + Consts.DOT + i4, false);
            }
            j.l.c.c.c.x1.b bVar = this.r;
            if (bVar != null) {
                bVar.onError(i2, i4, true);
            }
            handError();
            return;
        }
        String str = this.B;
        if (str != null) {
            int indexOf2 = str.indexOf("//");
            if (indexOf2 >= 0 && (i5 = indexOf2 + 2) < str.length() && (indexOf = (str = str.substring(i5)).indexOf("/")) >= 0) {
                str = str.substring(0, indexOf);
            }
            if (TextUtils.isEmpty(this.k0)) {
                this.k0 = "&svrip=" + str;
            } else {
                this.k0 += "," + str;
            }
            q1("VideoPreviewView.retrySecondStep: svrip=" + this.k0);
        }
        executeSecondStep();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E1() {
        int i2 = this.F + 1;
        this.F = i2;
        boolean z = i2 >= 3;
        if (!z) {
            executeSecondStep();
        }
        return z;
    }

    public static final /* synthetic */ void F1(VideoPreviewView videoPreviewView, int i2, r.a.b.c cVar) {
    }

    public static final /* synthetic */ void H1(VideoPreviewView videoPreviewView, int i2, r.a.b.c cVar) {
        videoPreviewView.o = i2;
        videoPreviewView.setMuteType(i2);
        videoPreviewView.setInfoFrameType(i2);
        videoPreviewView.setBreathType(i2);
        View view = videoPreviewView.w;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public static final /* synthetic */ void J1(VideoPreviewView videoPreviewView, int i2, r.a.b.c cVar) {
        View view = videoPreviewView.n;
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (i2 == 0 || i2 == 2) {
            marginLayoutParams.rightMargin = j0.b(j.l.a.a.a(), 50.0f);
            marginLayoutParams.bottomMargin = j0.b(j.l.a.a.a(), 14.0f);
            marginLayoutParams.leftMargin = j0.b(j.l.a.a.a(), 10.0f);
        } else if (i2 != 3) {
        } else {
            marginLayoutParams.rightMargin = j0.b(j.l.a.a.a(), 30.0f);
            marginLayoutParams.bottomMargin = j0.b(j.l.a.a.a(), 52.0f);
            marginLayoutParams.leftMargin = j0.b(j.l.a.a.a(), 15.0f);
        }
    }

    public static final /* synthetic */ void K1(VideoPreviewView videoPreviewView, boolean z, r.a.b.c cVar) {
        if (videoPreviewView.y1 != z) {
            videoPreviewView.y1 = z;
            videoPreviewView.C1 = false;
            videoPreviewView.e.setTargetIsLoopMode(z);
        }
    }

    public static final /* synthetic */ void L1(VideoPreviewView videoPreviewView, int i2, r.a.b.c cVar) {
        RelativeLayout.LayoutParams layoutParams;
        View view = videoPreviewView.v;
        if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.removeRule(10);
        layoutParams.removeRule(12);
        layoutParams.removeRule(9);
        layoutParams.removeRule(11);
        if (i2 == 0) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.bottomMargin = j0.b(j.l.a.a.a(), 10.0f);
        } else if (i2 == 1) {
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = j0.b(j.l.a.a.a(), 15.0f);
            layoutParams.rightMargin = j0.b(j.l.a.a.a(), 15.0f);
        } else if (i2 == 2) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = j0.b(j.l.a.a.a(), 25.0f);
        } else if (i2 != 3) {
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = j0.b(j.l.a.a.a(), 20.0f);
        }
    }

    public static final /* synthetic */ void M1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        videoPreviewView.e.setOnPreparedListener(new c());
        videoPreviewView.e.setOnPauseListener(new d());
        videoPreviewView.e.setOnInfoListener(videoPreviewView.x2);
        videoPreviewView.e.setOnStartListener(new e());
        videoPreviewView.e.setOnCompletionListener(new f());
        videoPreviewView.e.setOnErrorListener(new g());
    }

    public static final /* synthetic */ void N1(VideoPreviewView videoPreviewView, ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean, r.a.b.c cVar) {
        if (videoPreviewView.w == null) {
            return;
        }
        int i2 = 8;
        if (!videoPreviewView.p1() && videoPreviewView.x) {
            View view = videoPreviewView.w;
            if (BannerHelper.isAdImageResExist(moduleDataBean) && moduleDataBean.adLogEnnable) {
                i2 = 0;
            }
            y0.q(view, i2);
            return;
        }
        y0.q(videoPreviewView.w, 8);
    }

    public static final /* synthetic */ void O1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        videoPreviewView.v.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setStartOffset(1000L);
        alphaAnimation.setDuration(1000L);
        videoPreviewView.v.startAnimation(alphaAnimation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean P1(VideoPreviewView videoPreviewView, ViewGroup viewGroup, r.a.b.c cVar) {
        videoPreviewView.t2 = System.currentTimeMillis();
        VideoPreviewManager.c cVar2 = (VideoPreviewManager.c) viewGroup.getTag(b.j.video_preview_data_id);
        viewGroup.addView((View) videoPreviewView, new ViewGroup.LayoutParams(-1, -1));
        if (viewGroup instanceof YogaLayout) {
            YogaNode yogaNodeForView = ((YogaLayout) viewGroup).getYogaNodeForView(videoPreviewView);
            yogaNodeForView.setPositionType(YogaPositionType.ABSOLUTE);
            yogaNodeForView.setWidthPercent(100.0f);
            yogaNodeForView.setHeightPercent(100.0f);
        }
        videoPreviewView.setVisibility(0);
        videoPreviewView.e.setAlpha(0.0f);
        View view = videoPreviewView.n;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = videoPreviewView.v;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        videoPreviewView.hideBreathView();
        videoPreviewView.i = cVar2;
        videoPreviewView.j = cVar2.r;
        if ((TextUtils.isEmpty(cVar2.b) || "0".equals(cVar2.b)) && !videoPreviewView.m1()) {
            videoPreviewView.q1("startViewPlay vid invalid !!!");
            return false;
        }
        videoPreviewView.K0 = false;
        j.u.k.a aVar = new j.u.k.a(j.l.a.a.a());
        videoPreviewView.t = aVar;
        aVar.m(videoPreviewView);
        videoPreviewView.t.k();
        if (videoPreviewView.m1()) {
            videoPreviewView.z = null;
            videoPreviewView.A = null;
            videoPreviewView.F = 0;
            videoPreviewView.refreshBreathView();
            videoPreviewView.r = videoPreviewView.b1();
            videoPreviewView.refreshControlInfo();
            Integer num = videoPreviewView.m.get(cVar2.b);
            videoPreviewView.k = num != null ? num.intValue() : 0;
            videoPreviewView.r2.setVid(cVar2.b);
            videoPreviewView.q2 = cVar2.b;
            videoPreviewView.B = cVar2.j;
            videoPreviewView.e.release();
            videoPreviewView.e.setStartPosMs(videoPreviewView.k);
            videoPreviewView.m.put(cVar2.b, Integer.valueOf(videoPreviewView.k));
            videoPreviewView.e.resetVideoPath(cVar2.j);
            videoPreviewView.q1("startViewPlay 巨幕广告");
            return true;
        } else if (!b0.g() && !cVar2.m) {
            videoPreviewView.q1("startViewPlay onPlayComplete");
            q qVar = videoPreviewView.w2;
            if (qVar != null) {
                qVar.e();
            }
            videoPreviewView.q2 = null;
            return false;
        } else {
            videoPreviewView.q1("startViewPlay");
            videoPreviewView.refreshBreathView();
            videoPreviewView.r = videoPreviewView.b1();
            videoPreviewView.refreshControlInfo();
            Integer num2 = videoPreviewView.m.get(cVar2.b);
            videoPreviewView.k = num2 != null ? num2.intValue() : 0;
            videoPreviewView.r2.setVid(cVar2.b);
            videoPreviewView.resetData();
            videoPreviewView.executeFirstStep(cVar2.b);
            return true;
        }
    }

    public static final /* synthetic */ void Q1(VideoPreviewView videoPreviewView, int i2, r.a.b.c cVar) {
        ViewGroup.LayoutParams layoutParams = videoPreviewView.d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
        }
    }

    public static final /* synthetic */ void R1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        if (videoPreviewView.y == null) {
            return;
        }
        if (videoPreviewView.p1()) {
            videoPreviewView.y.setVisibility(0);
        } else {
            videoPreviewView.y.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void X0(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        View inflate = LayoutInflater.from(videoPreviewView.b).inflate(b.m.layout_video_preview_controller, (ViewGroup) videoPreviewView, true);
        AudioManager audioManager = (AudioManager) videoPreviewView.b.getApplicationContext().getSystemService("audio");
        videoPreviewView.p2 = audioManager;
        if (audioManager != null) {
            videoPreviewView.l = audioManager.getStreamVolume(3);
        }
        videoPreviewView.u = (ImageView) inflate.findViewById(b.j.mute_button);
        videoPreviewView.v = inflate.findViewById(b.j.mute_button_ll);
        videoPreviewView.w = inflate.findViewById(b.j.adicon);
        videoPreviewView.y = (FrameLayout) inflate.findViewById(b.j.fl_square_ad_mask);
        if (videoPreviewView.f) {
            videoPreviewView.u.setSelected(true);
            videoPreviewView.e.setVolume(0.0f, 0.0f);
        }
        videoPreviewView.u.setOnClickListener(new i());
        videoPreviewView.c = (TextView) inflate.findViewById(b.j.title);
        videoPreviewView.d = (TextView) inflate.findViewById(b.j.desc);
        videoPreviewView.n = inflate.findViewById(b.j.info_frame);
    }

    private static /* synthetic */ void Z0() {
        r.a.c.c.e eVar = new r.a.c.c.e("VideoPreviewView.java", VideoPreviewView.class);
        E2 = eVar.H("method-execution", eVar.E("1", "setControlType", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "int", "controlType", "", "void"), 345);
        F2 = eVar.H("method-execution", eVar.E("2", "setMuteType", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "int", "controlType", "", "void"), 359);
        O2 = eVar.H("method-execution", eVar.E("2", "addPlayerLayer", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 565);
        P2 = eVar.H("method-execution", eVar.E("4", "addControlLayer", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 579);
        Q2 = eVar.H("method-execution", eVar.E("4", "refreshControlInfo", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 618);
        R2 = eVar.H("method-execution", eVar.E("4", "onVideoStart", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 663);
        S2 = eVar.H("method-execution", eVar.E("2", "showIcon", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "com.hunantv.oversea.channel.net.entity.ChannelIndexEntity$DataBean$ModuleDataBean", "bean", "", "void"), 714);
        T2 = eVar.H("method-execution", eVar.E("2", "updateVideoBgMask", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 730);
        U2 = eVar.H("method-execution", eVar.E("2", "updateDescLayoutMargin", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "int", "marginTop", "", "void"), 745);
        V2 = eVar.H("method-execution", eVar.E("2", "onVideoEnd", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 753);
        W2 = eVar.H("method-execution", eVar.E("2", "showMuteView", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), (int) MgtvMediaPlayer.MEDIA_INFO_EXTERNAL_METADATA_UPDATE);
        X2 = eVar.H("method-execution", eVar.E("2", "hideInfoView", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 815);
        G2 = eVar.H("method-execution", eVar.E("2", "setInfoFrameType", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "int", "controlType", "", "void"), (int) AGCServerException.AUTHENTICATION_FAILED);
        Y2 = eVar.H("method-execution", eVar.E("2", "executeFirstStep", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "java.lang.String", "vid", "", "void"), 847);
        Z2 = eVar.H("method-execution", eVar.E("2", "executeSecondStep", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 928);
        a3 = eVar.H("method-execution", eVar.E("2", "getRouteInfo", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "java.util.List", "videoSources", "", "com.hunantv.oversea.playlib.entity.PlayAuthRouterEntity"), 997);
        b3 = eVar.H("method-execution", eVar.E("2", "executeThirdStep", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "com.hunantv.oversea.playlib.entity.PlayerUrlEntity", "urlEntity", "", "void"), 1028);
        c3 = eVar.H("method-execution", eVar.E("2", "getRouterUrl", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "java.lang.String"), 1099);
        d3 = eVar.H("method-execution", eVar.E("2", "configVideoView", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 1184);
        e3 = eVar.H("method-execution", eVar.E("2", "onSystemVolumeChanged", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 1240);
        f3 = eVar.H("method-execution", eVar.E("2", "setPlayerListeners", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 1253);
        g3 = eVar.H("method-execution", eVar.E("2", "handError", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 1382);
        h3 = eVar.H("method-execution", eVar.E("4", "onDetachedFromWindow", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 1405);
        H2 = eVar.H("method-execution", eVar.E("2", "setBreathType", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "int", "controlType", "", "void"), 478);
        i3 = eVar.H("method-execution", eVar.E("4", "onRemoveFromList", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 1417);
        j3 = eVar.H("method-execution", eVar.E("1", "onChange", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "int", "networkType", "", "void"), 1467);
        k3 = eVar.H("method-execution", eVar.E("4", "onAttachedToWindow", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 1488);
        l3 = eVar.H("method-execution", eVar.E("2", "refreshBreathView", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 1508);
        m3 = eVar.H("method-execution", eVar.E("2", "hideBreathView", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 1523);
        n3 = eVar.H("method-execution", eVar.E("1", "startViewPlay", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "android.view.ViewGroup", "previewFrame", "", "boolean"), 1530);
        o3 = eVar.H("method-execution", eVar.E("1", "isPlaying", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "boolean"), 1645);
        I2 = eVar.H("method-execution", eVar.E("4", "initView", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 482);
        J2 = eVar.H("method-execution", eVar.E("1", "setHistoryMap", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "java.util.HashMap", "historyMap", "", "void"), 510);
        K2 = eVar.H("method-execution", eVar.E("1", "setLoopMode", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "boolean", "loopMode", "", "void"), 518);
        L2 = eVar.H("method-execution", eVar.E("1", "pause", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 528);
        M2 = eVar.H("method-execution", eVar.E("1", "resume", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 535);
        N2 = eVar.H("method-execution", eVar.E("1", "release", "com.hunantv.oversea.channel.dynamic.video.VideoPreviewView", "", "", "", "void"), 545);
    }

    public static final /* synthetic */ void a1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        if (j.v.o.a.d.d.c.b() == 0) {
            if (j.l.a.j.a.i == a.a.b) {
                videoPreviewView.e.setPlayerHardwareMode(false);
            } else {
                videoPreviewView.e.setPlayerHardwareMode(true);
            }
        } else {
            videoPreviewView.e.setPlayerHardwareMode(false);
        }
        videoPreviewView.e.setPlayerDebug(false);
        videoPreviewView.e.setTimeout(10000, 10000);
        videoPreviewView.e.setBufferTimeout(0);
        ExTicker exTicker = new ExTicker(1000);
        videoPreviewView.k1 = exTicker;
        exTicker.setCallback(new b());
    }

    @WithTryCatchRuntime
    private void addPlayerLayer() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.k(new Object[]{this, r.a.c.c.e.v(O2, this, this)}).e(69648));
    }

    private j.l.c.c.c.x1.b b1() {
        this.s = new PlayStartInfo();
        if (this.i == null || m1()) {
            return null;
        }
        VideoPreviewManager.d dVar = this.j;
        j.l.c.c.c.x1.b bVar = new j.l.c.c.c.x1.b(dVar == null ? "14" : ((VideoPreviewReporter.a) dVar).a, (VideoPreviewReporter.a) null);
        bVar.X(this.s);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(int i2, long j2) {
        j.l.c.c.c.x1.b bVar = this.r;
        if (bVar != null) {
            bVar.Z(j2);
            this.r.onEndBuffer(i2);
        }
    }

    @WithTryCatchRuntime
    private void configVideoView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a0(new Object[]{this, r.a.c.c.e.v(d3, this, this)}).e(69648));
    }

    public static final /* synthetic */ void d1(VideoPreviewView videoPreviewView, String str, r.a.b.c cVar) {
        videoPreviewView.q1("VideoPreviewView.executeFirstStep: IN");
        j.l.c.c.c.x1.b bVar = videoPreviewView.r;
        if (bVar != null) {
            bVar.f();
        }
        PlayStartInfo playStartInfo = videoPreviewView.s;
        if (playStartInfo != null) {
            playStartInfo.mVideoId = videoPreviewView.q2;
        }
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        imgoHttpParams.put("videoId", str);
        imgoHttpParams.put("playType", 10);
        imgoHttpParams.put(ShareConstants.FEED_SOURCE_PARAM, 1);
        j.v.r.l lVar = videoPreviewView.s2;
        if (lVar != null) {
            videoPreviewView.h.s(lVar);
        }
        j.l.c.c.c.x1.a.m(5);
        videoPreviewView.s2 = videoPreviewView.g.j((int) OpenAuthTask.Duplex).u("https://mobile.api.mgtv.com/v8/video/getSource", imgoHttpParams, new p(System.currentTimeMillis()));
    }

    public static final /* synthetic */ void e1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        videoPreviewView.q1("VideoPreviewView.executeSecondStep: IN");
        if (videoPreviewView.q) {
            PlayStartInfo playStartInfo = videoPreviewView.s;
            if (playStartInfo != null) {
                playStartInfo.mCurrentRouterInfo = videoPreviewView.A;
            }
            String routerUrl = videoPreviewView.A != null ? videoPreviewView.getRouterUrl() : "";
            videoPreviewView.q1("VideoPreviewView.executeSecondStep: url=" + routerUrl);
            if (TextUtils.isEmpty(routerUrl)) {
                videoPreviewView.handError();
                return;
            }
            ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
            imgoHttpParams.put("did", j.l.a.b0.e.x());
            imgoHttpParams.put("oaid", j.l.a.b0.e.U());
            imgoHttpParams.put("suuid", j.l.c.x.t0.a.a().f);
            videoPreviewView.r2.setVideoSession(j.l.c.x.t0.a.a().f);
            videoPreviewView.g.n(true).u(j.l.c.u.c0.a.f(routerUrl), imgoHttpParams, new a(System.currentTimeMillis()));
        }
    }

    @WithTryCatchRuntime
    private void executeFirstStep(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.v(new Object[]{this, str, r.a.c.c.e.w(Y2, this, this, str)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void executeSecondStep() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new w(new Object[]{this, r.a.c.c.e.v(Z2, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void executeThirdStep(PlayerUrlEntity playerUrlEntity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new y(new Object[]{this, playerUrlEntity, r.a.c.c.e.w(b3, this, this, playerUrlEntity)}).e(69648));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void f1(VideoPreviewView videoPreviewView, PlayerUrlEntity playerUrlEntity, r.a.b.c cVar) {
        videoPreviewView.q1("VideoPreviewView.executeThirdStep: IN");
        videoPreviewView.q2 = videoPreviewView.i.b;
        if (videoPreviewView.q) {
            videoPreviewView.setVisibility(0);
            if (videoPreviewView.A != null) {
                videoPreviewView.e.setDataSourceInfo(new MgtvMediaPlayer.DataSourceInfo().setVideoFormat(videoPreviewView.A.videoFormat).setFileFormat(videoPreviewView.A.fileFormat).setBitRate(videoPreviewView.A.filebitrate));
            } else {
                videoPreviewView.e.setDataSourceInfo(null);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("did", j.l.a.b0.e.x());
            hashMap.put("oaid", j.l.a.b0.e.U());
            hashMap.put("suuid", j.l.c.x.t0.a.a().f);
            try {
                videoPreviewView.r2.setCdnip(new URL(playerUrlEntity.info).getHost());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            videoPreviewView.u2 = System.currentTimeMillis();
            videoPreviewView.B = j.l.c.u.c0.a.g(p0.f(playerUrlEntity.info, hashMap));
            videoPreviewView.q1("VideoPreviewView.executeThirdStep: videoUrl=" + videoPreviewView.B);
            String str = videoPreviewView.B;
            PlayAuthRouterEntity playAuthRouterEntity = videoPreviewView.A;
            videoPreviewView.x1 = new CdnQualityReport(str, false, 0, playAuthRouterEntity == null ? 1 : playAuthRouterEntity.definition, "", "", "4");
            videoPreviewView.r2.setDef(String.valueOf(videoPreviewView.A.definition));
            videoPreviewView.e.setTsFlowTag(j.l.c.u.c0.a.c(videoPreviewView.B));
            videoPreviewView.e.setStartPosMs(videoPreviewView.k);
            videoPreviewView.m.put(videoPreviewView.i.b, Integer.valueOf(videoPreviewView.k));
            if (videoPreviewView.y1 && videoPreviewView.C1) {
                videoPreviewView.e.resetVideoPath(videoPreviewView.B);
            } else {
                videoPreviewView.e.setVideoPath(videoPreviewView.B);
                videoPreviewView.C1 = true;
            }
            j.l.c.c.c.x1.b bVar = videoPreviewView.r;
            if (bVar != null) {
                bVar.H(videoPreviewView.i.l);
                videoPreviewView.r.R(j.l.c.x.t0.a.a().B);
                videoPreviewView.r.Q(j.l.c.x.t0.a.a().A);
                videoPreviewView.r.a0(videoPreviewView.e);
                videoPreviewView.r.P(videoPreviewView.i.b);
                videoPreviewView.r.N(videoPreviewView.i.a);
                PlayStartInfo playStartInfo = videoPreviewView.s;
                if (playStartInfo != null) {
                    String str2 = videoPreviewView.B;
                    playStartInfo.mVideoUrl = str2;
                    playStartInfo.mVideoProxyUrl = str2;
                }
            }
        }
    }

    public static final /* synthetic */ PlayAuthRouterEntity g1(VideoPreviewView videoPreviewView, List list, r.a.b.c cVar) {
        int i2;
        PlayAuthRouterEntity playAuthRouterEntity = null;
        if (list != null && list.size() != 0) {
            int n2 = j0.n(j.l.a.a.a());
            int i4 = 0;
            int i5 = n2 >= 1080 ? 2 : n2 >= 720 ? 1 : 0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PlayAuthRouterEntity playAuthRouterEntity2 = (PlayAuthRouterEntity) it.next();
                if (!TextUtils.isEmpty(playAuthRouterEntity2.url) && (i2 = playAuthRouterEntity2.definition) <= i5 && i2 >= i4) {
                    playAuthRouterEntity = playAuthRouterEntity2;
                    i4 = i2;
                }
            }
        }
        return playAuthRouterEntity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCdnLastIp() {
        MgtvLoopVideoView mgtvLoopVideoView = this.e;
        return mgtvLoopVideoView != null ? mgtvLoopVideoView.getLastIP() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public PlayAuthRouterEntity getRouteInfo(List<PlayAuthRouterEntity> list) {
        return (PlayAuthRouterEntity) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new x(new Object[]{this, list, r.a.c.c.e.w(a3, this, this, list)}).e(69648));
    }

    @Nullable
    @WithTryCatchRuntime
    private String getRouterUrl() {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new z(new Object[]{this, r.a.c.c.e.v(c3, this, this)}).e(69648));
    }

    public static final /* synthetic */ String h1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        PlayAuthEntity playAuthEntity = videoPreviewView.z;
        if (playAuthEntity == null || videoPreviewView.A == null) {
            return null;
        }
        List list = playAuthEntity.videoDomains;
        if (videoPreviewView.E < list.size() && videoPreviewView.F < 3) {
            videoPreviewView.C = (String) list.get(videoPreviewView.E);
        } else if (!TextUtils.isEmpty(videoPreviewView.D)) {
            videoPreviewView.C = videoPreviewView.D;
        }
        return videoPreviewView.C + videoPreviewView.A.url + videoPreviewView.k0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void handError() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d0(new Object[]{this, r.a.c.c.e.v(g3, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void hideBreathView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k0(new Object[]{this, r.a.c.c.e.v(m3, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    private void hideInfoView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new t(new Object[]{this, r.a.c.c.e.v(X2, this, this)}).e(69648));
    }

    public static final /* synthetic */ void i1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        videoPreviewView.hideBreathView();
        View view = videoPreviewView.n;
        if (view != null) {
            view.setVisibility(8);
        }
        FrameLayout frameLayout = videoPreviewView.y;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        q qVar = videoPreviewView.w2;
        if (qVar != null) {
            qVar.e();
        }
    }

    public static final /* synthetic */ void j1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
    }

    public static final /* synthetic */ void k1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        if (videoPreviewView.m1()) {
            return;
        }
        if (TextUtils.isEmpty(videoPreviewView.i.c) && TextUtils.isEmpty(videoPreviewView.i.d) && !videoPreviewView.m1()) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setAnimationListener(new o());
        videoPreviewView.n.startAnimation(alphaAnimation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void l1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        IVideoView.Configuration configuration = new IVideoView.Configuration();
        configuration.isLoopMode = videoPreviewView.y1;
        configuration.renderViewType = 1;
        MgtvLoopVideoView mgtvLoopVideoView = new MgtvLoopVideoView(videoPreviewView.b, configuration);
        videoPreviewView.e = mgtvLoopVideoView;
        mgtvLoopVideoView.setScreenOnWhilePlaying(false);
        videoPreviewView.e.setReportParams(videoPreviewView.r2);
        videoPreviewView.e.setAlpha(0.0f);
        videoPreviewView.e.setBackgroundColor(0);
        videoPreviewView.e.setAspectRatio(1);
        videoPreviewView.addView(videoPreviewView.e);
        videoPreviewView.f = f0.d(A2, true);
        videoPreviewView.configVideoView();
        videoPreviewView.setPlayerListeners();
        videoPreviewView.addPlayerLayer();
        videoPreviewView.addControlLayer();
        videoPreviewView.h = new j.v.r.m(ThreadManager.getSystemExecutorServiceForVod(), false);
        videoPreviewView.g = new j.v.r.r(j.l.a.a.a(), videoPreviewView.h, (j.v.r.p) null);
        videoPreviewView.K1 = new r(videoPreviewView, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(B2);
        videoPreviewView.b.registerReceiver(videoPreviewView.K1, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m1() {
        ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean;
        return this.i != null && HugeMananger.h().l(this.i.j) && (moduleDataBean = this.i.s) != null && moduleDataBean.adJump == 3;
    }

    private boolean n1() {
        return this.o == 2;
    }

    public static final /* synthetic */ boolean o1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        MgtvLoopVideoView mgtvLoopVideoView = videoPreviewView.e;
        return (mgtvLoopVideoView == null || !mgtvLoopVideoView.isPlaying() || videoPreviewView.e.isCompletion()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onSystemVolumeChanged() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.b0(new Object[]{this, r.a.c.c.e.v(e3, this, this)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void onVideoEnd() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.r(new Object[]{this, r.a.c.c.e.v(V2, this, this)}).e(69648));
    }

    private boolean p1() {
        return this.o == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(String str) {
        j.l.a.n.m.a.d("30", y2, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void r1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        videoPreviewView.q = true;
    }

    @WithTryCatchRuntime
    private void refreshBreathView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.j0(new Object[]{this, r.a.c.c.e.v(l3, this, this)}).e(69648));
    }

    private void resetData() {
        q1("VideoPreviewView.resetData: =========================");
        this.k0 = "";
        this.F = 0;
        this.E = 0;
        this.D = null;
        this.B = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void s1(VideoPreviewView videoPreviewView, int i2, r.a.b.c cVar) {
        if (videoPreviewView.q) {
            if (i2 != 2 && i2 != 0) {
                videoPreviewView.setVisibility(0);
                String str = videoPreviewView.q2;
                if (str == null || !str.equals(videoPreviewView.i.b)) {
                    return;
                }
                videoPreviewView.e.start();
                videoPreviewView.onVideoStart();
                return;
            }
            videoPreviewView.setVisibility(8);
            videoPreviewView.e.pause();
            videoPreviewView.handError();
        }
    }

    @WithTryCatchRuntime
    private void setBreathType(int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n0(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(H2, this, this, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    private void setInfoFrameType(int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.f0(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(G2, this, this, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    private void setMuteType(int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new u(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(F2, this, this, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    private void setPlayerListeners() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new c0(new Object[]{this, r.a.c.c.e.v(f3, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    private void showIcon(@Nullable ChannelIndexEntity.DataBean.ModuleDataBean moduleDataBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.o(new Object[]{this, moduleDataBean, r.a.c.c.e.w(S2, this, this, moduleDataBean)}).e(69648));
    }

    @WithTryCatchRuntime
    private void showMuteView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new s(new Object[]{this, r.a.c.c.e.v(W2, this, this)}).e(69648));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void t1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        videoPreviewView.onRemoveFromList();
        j.u.k.a aVar = videoPreviewView.t;
        if (aVar != null) {
            aVar.n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void u1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        MgtvLoopVideoView mgtvLoopVideoView;
        if (videoPreviewView.q) {
            videoPreviewView.q = false;
            j.v.r.l lVar = videoPreviewView.s2;
            if (lVar != null) {
                videoPreviewView.h.s(lVar);
            }
            MgtvLoopVideoView mgtvLoopVideoView2 = videoPreviewView.e;
            if (mgtvLoopVideoView2 != null) {
                mgtvLoopVideoView2.pause();
            }
            if (videoPreviewView.K0 && (mgtvLoopVideoView = videoPreviewView.e) != null) {
                int duration = mgtvLoopVideoView.getDuration();
                if (videoPreviewView.e.isCompletion()) {
                    videoPreviewView.m.put(videoPreviewView.i.b, 0);
                } else if (videoPreviewView.m.containsKey(videoPreviewView.i.b) && ((duration > 0 && duration - videoPreviewView.e.getCurrentPosition() > 5000) || videoPreviewView.m1())) {
                    videoPreviewView.m.put(videoPreviewView.i.b, Integer.valueOf(videoPreviewView.e.getCurrentPosition()));
                }
                ExTicker exTicker = videoPreviewView.k1;
                if (exTicker != null) {
                    exTicker.stop();
                }
                j.l.c.c.c.x1.b bVar = videoPreviewView.r;
                if (bVar != null) {
                    bVar.onPlayCompletion();
                }
                View[] viewArr = videoPreviewView.p;
                if (viewArr != null && viewArr.length != 0) {
                    for (View view : viewArr) {
                        if (view != null) {
                            view.setAlpha(1.0f);
                        }
                    }
                }
                CdnQualityReport cdnQualityReport = videoPreviewView.x1;
                if (cdnQualityReport != null && cdnQualityReport.p()) {
                    videoPreviewView.x1.G("", false);
                }
                videoPreviewView.n.clearAnimation();
                Context context = videoPreviewView.b;
                if (context instanceof Activity) {
                    j0.z((Activity) context);
                }
                videoPreviewView.setVisibility(8);
            } else {
                videoPreviewView.v2.removeCallbacksAndMessages(null);
            }
            videoPreviewView.p = null;
            VideoPreviewManager.k().l(videoPreviewView);
            videoPreviewView.hideBreathView();
        }
    }

    @WithTryCatchRuntime
    private void updateDescLayoutMargin(int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.q(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(U2, this, this, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    private void updateVideoBgMask() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.p(new Object[]{this, r.a.c.c.e.v(T2, this, this)}).e(69648));
    }

    public static final /* synthetic */ void v1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        AudioManager audioManager = videoPreviewView.p2;
        if (audioManager != null) {
            videoPreviewView.l = audioManager.getStreamVolume(3);
        }
        if (videoPreviewView.f) {
            return;
        }
        MgtvLoopVideoView mgtvLoopVideoView = videoPreviewView.e;
        int i2 = videoPreviewView.l;
        mgtvLoopVideoView.setVolume(i2, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void w1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        View[] viewArr = videoPreviewView.p;
        if (viewArr != null && viewArr.length != 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(400L);
            videoPreviewView.n.setVisibility(0);
            ofFloat.addUpdateListener(new l());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat2.setStartDelay(100L);
            ofFloat2.setDuration(300L);
            ofFloat2.addUpdateListener(new m());
            ofFloat.addListener(new n());
            ofFloat2.start();
            ofFloat.start();
            return;
        }
        videoPreviewView.setVisibility(8);
    }

    public static final /* synthetic */ void x1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        if (!TextUtils.equals(videoPreviewView.q2, videoPreviewView.i.b)) {
            videoPreviewView.e.pause();
            return;
        }
        if (!TextUtils.isEmpty(videoPreviewView.i.c) || !TextUtils.isEmpty(videoPreviewView.i.d)) {
            videoPreviewView.n.setVisibility(0);
        }
        View[] viewArr = videoPreviewView.p;
        if (viewArr != null && viewArr.length != 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(400L);
            ofFloat.addUpdateListener(new j());
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setStartDelay(100L);
            ofFloat2.setDuration(300L);
            ofFloat2.addUpdateListener(new k());
            ofFloat.start();
            ofFloat2.start();
            videoPreviewView.hideInfoView();
        } else {
            videoPreviewView.e.setAlpha(1.0f);
            videoPreviewView.hideInfoView();
        }
        videoPreviewView.showMuteView();
        videoPreviewView.showIcon(videoPreviewView.i.s);
        videoPreviewView.updateVideoBgMask();
    }

    public static final /* synthetic */ void y1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
        MgtvLoopVideoView mgtvLoopVideoView = videoPreviewView.e;
        if (mgtvLoopVideoView != null) {
            mgtvLoopVideoView.pause();
        }
    }

    public static final /* synthetic */ void z1(VideoPreviewView videoPreviewView, r.a.b.c cVar) {
    }

    public void G1(VideoPreviewManager.c cVar, View view, int i2) {
    }

    @WithTryCatchRuntime
    public void addControlLayer() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.l(new Object[]{this, r.a.c.c.e.v(P2, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void initView() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.o0(new Object[]{this, r.a.c.c.e.v(I2, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public boolean isPlaying() {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new m0(new Object[]{this, r.a.c.c.e.v(o3, this, this)}).e(69648)));
    }

    @WithTryCatchRuntime
    public void onAttachedToWindow() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i0(new Object[]{this, r.a.c.c.e.v(k3, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void onChange(int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h0(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(j3, this, this, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    public void onDetachedFromWindow() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new e0(new Object[]{this, r.a.c.c.e.v(h3, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void onRemoveFromList() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g0(new Object[]{this, r.a.c.c.e.v(i3, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void onVideoStart() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.n(new Object[]{this, r.a.c.c.e.v(R2, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void pause() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.g(new Object[]{this, r.a.c.c.e.v(L2, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void refreshControlInfo() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.m(new Object[]{this, r.a.c.c.e.v(Q2, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void release() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.i(new Object[]{this, r.a.c.c.e.v(N2, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void resume() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.h(new Object[]{this, r.a.c.c.e.v(M2, this, this)}).e(69648));
    }

    public void setBackground(boolean z) {
        MgtvLoopVideoView mgtvLoopVideoView = this.e;
        if (mgtvLoopVideoView != null) {
            mgtvLoopVideoView.setBackground(z);
        }
    }

    @WithTryCatchRuntime
    public void setControlType(int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.j(new Object[]{this, r.a.c.b.e.k(i2), r.a.c.c.e.w(E2, this, this, r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    public void setHistoryMap(HashMap<String, Integer> hashMap) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.e(new Object[]{this, hashMap, r.a.c.c.e.w(J2, this, this, hashMap)}).e(69648));
    }

    @WithTryCatchRuntime
    public void setLoopMode(boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.x1.f(new Object[]{this, r.a.c.b.e.a(z), r.a.c.c.e.w(K2, this, this, r.a.c.b.e.a(z))}).e(69648));
    }

    public void setPreviewPlayListener(q qVar) {
        this.w2 = qVar;
    }

    public void setRelativeView(View... viewArr) {
        if (viewArr == null) {
            this.p = null;
            return;
        }
        int length = viewArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (viewArr[i2] != null) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            viewArr = null;
        }
        this.p = viewArr;
    }

    public void setShowAdView(boolean z) {
        this.x = z;
    }

    @WithTryCatchRuntime
    public boolean startViewPlay(ViewGroup viewGroup) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l0(new Object[]{this, viewGroup, r.a.c.c.e.w(n3, this, this, viewGroup)}).e(69648)));
    }
}
