package com.hunantv.media.widget.debug;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c.a.a.a.o.d;
import c.a.a.b.c.a;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hunantv.imgo.nightmode.view.SkinnableRelativeLayout;
import com.hunantv.media.config.NetPlayConfig;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.media.drm.utils.MgtvDrmUtils;
import com.hunantv.media.player.IMgtvRenderView;
import com.hunantv.media.player.MgtvMediaPlayer;
import com.hunantv.media.player.MgtvPlayerListener;
import com.hunantv.media.player.helper.MediaCodecHelp;
import com.hunantv.media.player.libnative.ImgoMediaPlayerLib;
import com.hunantv.media.player.utils.ThreadUtil;
import com.hunantv.media.utils.NumericUtil;
import com.hunantv.media.widget.IVideoView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DebugPanel extends SkinnableRelativeLayout {
    public static boolean sReportLogOpen;
    private static Setting sSetting = new Setting();
    public ScrollView baseInfoScrollLayout;
    public String baseInfoText;
    public TextView baseInfoTextView;
    public byte[] keyInfoData;
    private TestBroadCastReceiver mBroadCastReceiver;
    private Context mContext;
    private IVideoView mMgtvVideoView;
    private MgtvPlayerListener.OnVideoPTSListener mPtsListener;
    private TextView mPtsTextView;
    private LinearLayout mRootLayout;
    private ScrollView mScrollLayout;
    private String mUrl;

    /* renamed from: com.hunantv.media.widget.debug.DebugPanel$33  reason: invalid class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class AnonymousClass33 {
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode;
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter;

        static {
            int[] iArr = new int[MgtvMediaPlayer.Prepared4StartMode.values().length];
            $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode = iArr;
            try {
                iArr[MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_AUTOPLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode[MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_LOADDATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode[MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[IVideoView.RenderFilter.values().length];
            $SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter = iArr2;
            try {
                iArr2[IVideoView.RenderFilter.UNSHARP_EDGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter[IVideoView.RenderFilter.UNSHARP_EDGE_COMPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter[IVideoView.RenderFilter.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnEnableListener {
        void onEnableChanged(boolean z);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface OnRadioCheckListener {
        void onRadioCheckChanged(int i);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Setting {
        public int aspectRatios;
        public boolean isAntiViewShake;
        public boolean isForceHttpDns;
        public boolean openImgods;
        public int renderType;
        public IVideoView.RenderFilter renderFilter = IVideoView.RenderFilter.NORMAL;
        public int addrInfoTypeInt = 0;
        public float fileStartTimeFloatS = -1.0f;
        public float playSpeed = 1.0f;
        public boolean enableAccSeek = false;
        public boolean enableTsSkipError = false;
        public MgtvMediaPlayer.Prepared4StartMode prepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
    }

    public DebugPanel(Context context, IVideoView iVideoView) {
        super(context);
        this.mUrl = null;
        this.mBroadCastReceiver = new TestBroadCastReceiver();
        this.mPtsListener = new MgtvPlayerListener.OnVideoPTSListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.1
            @Override // com.hunantv.media.player.MgtvPlayerListener.OnVideoPTSListener
            public void onVideoPTS(final MgtvPlayerListener.FrameClock frameClock) {
                ThreadUtil.postOnUiThread(new Runnable() { // from class: com.hunantv.media.widget.debug.DebugPanel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DebugPanel debugPanel = DebugPanel.this;
                        debugPanel.updatePts(frameClock.clock_type + "-" + frameClock.vframe_time);
                    }
                });
            }
        };
        this.baseInfoText = "";
        this.mContext = context;
        this.mMgtvVideoView = iVideoView;
        init();
    }

    private Button createBtn(Context context, String str) {
        Button button = new Button(context);
        button.setText(str);
        return button;
    }

    private void createEnableLayout(String str, boolean z, final OnEnableListener onEnableListener) {
        createRadioLayout(str, z ? 1 : 0, Arrays.asList("关闭", "打开"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.31
            @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
            public void onRadioCheckChanged(int i) {
                OnEnableListener onEnableListener2 = onEnableListener;
                if (onEnableListener2 != null) {
                    onEnableListener2.onEnableChanged(i == 1);
                }
            }
        });
    }

    private LinearLayout createNewLinear(String str, List<View> list) {
        if (list == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.mContext);
        textView.setText(str);
        linearLayout.addView(textView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        for (View view : list) {
            linearLayout.addView(view, layoutParams);
        }
        this.mRootLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    private void createRadioLayout(String str, int i, List<String> list, final OnRadioCheckListener onRadioCheckListener) {
        if (list == null || list.size() <= 0) {
            return;
        }
        RadioGroup radioGroup = new RadioGroup(this.mContext);
        radioGroup.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        final ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            RadioButton radioButton = new RadioButton(this.mContext);
            radioButton.setText(list.get(i2));
            radioGroup.addView(radioButton, i2, layoutParams);
            arrayList.add(radioButton);
        }
        if (this.mMgtvVideoView != null && i < arrayList.size()) {
            radioGroup.check(((RadioButton) arrayList.get(i)).getId());
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.32
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                if (onRadioCheckListener != null) {
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        if (i3 == ((RadioButton) arrayList.get(i4)).getId()) {
                            onRadioCheckListener.onRadioCheckChanged(i4);
                            return;
                        }
                    }
                }
            }
        });
        createNewLinear(str, Arrays.asList(radioGroup));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        Button button = new Button(this.mContext);
        button.setText("设置");
        if (Build.VERSION.SDK_INT >= 17) {
            button.setId(View.generateViewId());
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScrollView scrollView;
                int i = 8;
                if (DebugPanel.this.mScrollLayout.getVisibility() == 8 || DebugPanel.this.mScrollLayout.getVisibility() == 4) {
                    scrollView = DebugPanel.this.mScrollLayout;
                    i = 0;
                } else {
                    scrollView = DebugPanel.this.mScrollLayout;
                }
                scrollView.setVisibility(i);
            }
        });
        addView(button, new RelativeLayout.LayoutParams(-2, -2));
        Button button2 = new Button(this.mContext);
        button2.setText("刷帧");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugPanel.this.mPtsTextView.setVisibility(0);
                DebugPanel.this.mMgtvVideoView.enableFramePTSNotify(true);
                DebugPanel.this.mMgtvVideoView.stepPlaybackNextFrame();
                DebugPanel.this.mMgtvVideoView.addVideoPTSListener(DebugPanel.this.mPtsListener);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, button.getId());
        addView(button2, layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(0);
        initBaseInfoLayout(linearLayout);
        addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(this.mContext);
        this.mPtsTextView = textView;
        textView.setBackgroundColor(-16777216);
        this.mPtsTextView.setTextColor(-65536);
        this.mPtsTextView.setVisibility(8);
        this.mPtsTextView.setTextSize(1, 25.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(this.mPtsTextView, layoutParams2);
        ScrollView scrollView = new ScrollView(this.mContext);
        this.mScrollLayout = scrollView;
        scrollView.setVisibility(8);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this.mContext);
        LinearLayout linearLayout2 = new LinearLayout(this.mContext);
        this.mRootLayout = linearLayout2;
        initContent(linearLayout2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        horizontalScrollView.addView(this.mRootLayout, layoutParams3);
        this.mScrollLayout.addView(horizontalScrollView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(1, button.getId());
        addView(this.mScrollLayout, layoutParams4);
    }

    private void initABTestView() {
        final EditText editText = new EditText(this.mContext);
        NetPlayConfig netPlayConfig = NetPlayConfig.getsGlobalNetPlayConfig();
        if (netPlayConfig != null) {
            editText.setText(netPlayConfig.player_support);
        }
        Button createBtn = createBtn(this.mContext, "设置");
        createBtn.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetPlayConfig netPlayConfig2;
                if (DebugPanel.this.mMgtvVideoView == null || (netPlayConfig2 = NetPlayConfig.getsGlobalNetPlayConfig()) == null) {
                    return;
                }
                netPlayConfig2.player_support = editText.getText().toString();
                NetPlayConfig.setGlobalNetPlayConfig(netPlayConfig2);
            }
        });
        createNewLinear("AB测值(play_support):", Arrays.asList(editText, createBtn));
    }

    private void initAccSeekView() {
        createEnableLayout("精准seek:", sSetting.enableAccSeek, new OnEnableListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.28
            @Override // com.hunantv.media.widget.debug.DebugPanel.OnEnableListener
            public void onEnableChanged(boolean z) {
                DebugPanel.sSetting.enableAccSeek = z;
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.this.mMgtvVideoView.setAccurateSeekEnable(DebugPanel.sSetting.enableAccSeek);
                }
            }
        });
    }

    private void initAddrInfoView() {
        final EditText editText = new EditText(this.mContext);
        NetPlayConfig netPlayConfig = NetPlayConfig.getsGlobalNetPlayConfig();
        if (netPlayConfig != null) {
            editText.setText(netPlayConfig.addrinfo_type);
        }
        Button createBtn = createBtn(this.mContext, "设置");
        createBtn.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetPlayConfig netPlayConfig2;
                if (DebugPanel.this.mMgtvVideoView == null || (netPlayConfig2 = NetPlayConfig.getsGlobalNetPlayConfig()) == null) {
                    return;
                }
                netPlayConfig2.addrinfo_type = editText.getText().toString();
                NetPlayConfig.setGlobalNetPlayConfig(netPlayConfig2);
            }
        });
        createNewLinear("addrinfo_type:", Arrays.asList(editText, createBtn));
    }

    private void initAntiShakeView() {
        if (this.mMgtvVideoView != null) {
            boolean z = sSetting.isAntiViewShake;
            createRadioLayout("抗抖:", z ? 1 : 0, Arrays.asList("close", "open"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.24
                @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
                public void onRadioCheckChanged(int i) {
                    DebugPanel.sSetting.isAntiViewShake = i != 0;
                    if (DebugPanel.this.mMgtvVideoView != null) {
                        DebugPanel.this.mMgtvVideoView.setAntiViewShake(DebugPanel.sSetting.isAntiViewShake);
                    }
                }
            });
        }
    }

    private void initAspectRatioView() {
        createRadioLayout("播放比例:", sSetting.aspectRatios, Arrays.asList("FIT_PARENT", "FILL_PARENT"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.25
            @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
            public void onRadioCheckChanged(int i) {
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.sSetting.aspectRatios = i;
                    DebugPanel.this.mMgtvVideoView.setAspectRatio(DebugPanel.sSetting.aspectRatios);
                }
            }
        });
    }

    private void initBackPlayView() {
        IVideoView iVideoView = this.mMgtvVideoView;
        if (iVideoView != null) {
            createRadioLayout("背景播放:", !iVideoView.isBackPlayEnable(), Arrays.asList("打开", "关闭"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.9
                @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
                public void onRadioCheckChanged(int i) {
                    if (DebugPanel.this.mMgtvVideoView != null) {
                        DebugPanel.this.mMgtvVideoView.setBackPlayEnable(i == 0);
                    }
                }
            });
        }
    }

    private void initBaseInfoLayout(LinearLayout linearLayout) {
        Button button = new Button(this.mContext);
        button.setText("基本信息");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScrollView scrollView;
                int i = 8;
                if (DebugPanel.this.baseInfoScrollLayout.getVisibility() == 8 || DebugPanel.this.baseInfoScrollLayout.getVisibility() == 4) {
                    DebugPanel.this.updateBaseInfoText();
                    scrollView = DebugPanel.this.baseInfoScrollLayout;
                    i = 0;
                } else {
                    scrollView = DebugPanel.this.baseInfoScrollLayout;
                }
                scrollView.setVisibility(i);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        linearLayout.addView(button, layoutParams);
        ScrollView scrollView = new ScrollView(this.mContext);
        this.baseInfoScrollLayout = scrollView;
        scrollView.setVisibility(8);
        this.baseInfoScrollLayout.setBackgroundColor(-1);
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this.mContext);
        TextView textView = new TextView(this.mContext);
        this.baseInfoTextView = textView;
        textView.setTextColor(-16777216);
        horizontalScrollView.addView(this.baseInfoTextView, new FrameLayout.LayoutParams(-1, -1));
        this.baseInfoScrollLayout.addView(horizontalScrollView, new FrameLayout.LayoutParams(-1, -1));
        linearLayout.addView(this.baseInfoScrollLayout, new LinearLayout.LayoutParams(-1, -1));
    }

    private void initContent(LinearLayout linearLayout) {
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        initKeyInfoView();
        initAddrInfoView();
        initABTestView();
        if (sReportLogOpen) {
            registerLocalBroadCast();
        }
        Button createBtn = createBtn(this.mContext, "重置");
        createBtn.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugPanel.this.reset();
            }
        });
        createNewLinear("恢复默认:", Arrays.asList(createBtn));
        Button createBtn2 = createBtn(this.mContext, "打开");
        createBtn2.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z;
                if (DebugPanel.sReportLogOpen) {
                    DebugPanel.this.unregisterLocalBroadCast();
                    z = false;
                } else {
                    DebugPanel.this.registerLocalBroadCast();
                    z = true;
                }
                DebugPanel.sReportLogOpen = z;
            }
        });
        createNewLinear("上报日志:", Arrays.asList(createBtn2));
        initDRMHTTPSView();
        initBackPlayView();
        initMediaCodecSwView();
        initOppoSRView();
        initOppoOSIEView();
        initEnhanceView();
        initEnhanceFilterView();
        initDisplayFloatRect();
        initDnsView();
        initFileStartTimeView();
        initSourceSelectView();
        initAspectRatioView();
        initPlaySpeedView();
        initAccSeekView();
        initTsSkipErrView();
        initPreparedStartModeView();
        initForceHttpDnsView();
        initAntiShakeView();
        initDnsFamilyTypeView();
        setSetting();
    }

    private void initDRMHTTPSView() {
        createRadioLayout("DRM HTTPS抓包:", !a.o() ? 1 : 0, Arrays.asList("允许", "关闭"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.8
            @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
            public void onRadioCheckChanged(int i) {
                a.k(i == 0);
            }
        });
    }

    private void initDisplayFloatRect() {
        final EditText editText = new EditText(this.mContext);
        editText.setText("0.0f");
        final EditText editText2 = new EditText(this.mContext);
        editText2.setText("0.0f");
        final EditText editText3 = new EditText(this.mContext);
        editText3.setText("0.5f");
        final EditText editText4 = new EditText(this.mContext);
        editText4.setText("1.0f");
        final Button createBtn = createBtn(this.mContext, "设置");
        createBtn.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DebugPanel.this.mMgtvVideoView != null) {
                    try {
                        IMgtvRenderView.FloatRect floatRect = new IMgtvRenderView.FloatRect();
                        floatRect.lt = new IMgtvRenderView.Coordinate(Float.parseFloat(editText.getText().toString()), Float.parseFloat(editText2.getText().toString()));
                        floatRect.rb = new IMgtvRenderView.Coordinate(Float.parseFloat(editText3.getText().toString()), Float.parseFloat(editText4.getText().toString()));
                        DebugPanel.this.mMgtvVideoView.setDisplayFloatRect(floatRect);
                        ((Button) createBtn).setText("设置成功");
                    } catch (Exception e) {
                        e.printStackTrace();
                        ((Button) createBtn).setText("设置异常");
                    }
                }
            }
        });
        createNewLinear("DNS值(ltx-lty-rbx-rby):", Arrays.asList(editText, editText2, editText3, editText4, createBtn));
    }

    private void initDnsFamilyTypeView() {
        createRadioLayout("DnsFamily:", this.mMgtvVideoView.getDnsFamilyType(), Arrays.asList(MessengerShareContentUtility.PREVIEW_DEFAULT, "ONLY_IPV4", "ONLY_IPV6"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.30
            @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
            public void onRadioCheckChanged(int i) {
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.this.mMgtvVideoView.setDnsFamilyType(i);
                }
            }
        });
    }

    private void initDnsView() {
        final EditText editText = new EditText(this.mContext);
        editText.setText(sSetting.addrInfoTypeInt + "");
        Button createBtn = createBtn(this.mContext, "设置");
        createBtn.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.sSetting.addrInfoTypeInt = NumericUtil.parseInt(editText.getText().toString());
                    DebugPanel.this.mMgtvVideoView.setNetAddrinfo(DebugPanel.sSetting.addrInfoTypeInt, -1);
                }
            }
        });
        createNewLinear("DNS值:", Arrays.asList(editText, createBtn));
    }

    private void initEnhanceFilterView() {
        int i = AnonymousClass33.$SwitchMap$com$hunantv$media$widget$IVideoView$RenderFilter[sSetting.renderFilter.ordinal()];
        int i2 = 2;
        if (i == 1) {
            i2 = 1;
        } else if (i != 2) {
            i2 = 0;
        }
        createRadioLayout("图像增强:", i2, Arrays.asList("正常", "全屏", "半屏"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.21
            @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
            public void onRadioCheckChanged(int i3) {
                Setting setting;
                IVideoView.RenderFilter renderFilter;
                if (i3 == 1) {
                    d.a = true;
                    setting = DebugPanel.sSetting;
                    renderFilter = IVideoView.RenderFilter.UNSHARP_EDGE;
                } else if (i3 != 2) {
                    setting = DebugPanel.sSetting;
                    renderFilter = IVideoView.RenderFilter.NORMAL;
                } else {
                    d.a = true;
                    setting = DebugPanel.sSetting;
                    renderFilter = IVideoView.RenderFilter.UNSHARP_EDGE_COMPARE;
                }
                setting.renderFilter = renderFilter;
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.this.mMgtvVideoView.setRenderFilter(DebugPanel.sSetting.renderFilter);
                }
            }
        });
    }

    private void initEnhanceView() {
        final Button createBtn = createBtn(this.mContext, "Debug");
        setButtonSelect(createBtn, c.a.a.a.o.g.e.a.r);
        createBtn.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z = !createBtn.isSelected();
                c.a.a.a.o.g.e.a.r = z;
                DebugPanel.this.setButtonSelect((Button) createBtn, z);
            }
        });
        createNewLinear("图像增强Shader替换:", Arrays.asList(createBtn));
    }

    private void initFileStartTimeView() {
        final EditText editText = new EditText(this.mContext);
        editText.setText(sSetting.fileStartTimeFloatS + "");
        Button createBtn = createBtn(this.mContext, "设置");
        createBtn.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.sSetting.fileStartTimeFloatS = NumericUtil.parseFloat(editText.getText().toString(), -1.0f);
                }
            }
        });
        createNewLinear("FileStartTime:", Arrays.asList(editText, createBtn));
    }

    private void initForceHttpDnsView() {
        if (this.mMgtvVideoView != null) {
            boolean z = sSetting.isForceHttpDns;
            createRadioLayout("httpdns:", z ? 1 : 0, Arrays.asList("close", "open"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.23
                @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
                public void onRadioCheckChanged(int i) {
                    DebugPanel.sSetting.isForceHttpDns = i != 0;
                    if (DebugPanel.this.mMgtvVideoView != null) {
                        DebugPanel.this.mMgtvVideoView.setForceHttpDns(DebugPanel.sSetting.isForceHttpDns);
                        DebugPanel.this.mMgtvVideoView.resume();
                    }
                }
            });
        }
    }

    private void initKeyInfoView() {
        IVideoView iVideoView = this.mMgtvVideoView;
        if (iVideoView != null) {
            boolean isKeyInfoDataSet = iVideoView.isKeyInfoDataSet();
            createRadioLayout("KeyInfo:", isKeyInfoDataSet ? 1 : 0, Arrays.asList("enable", "disable"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.18
                @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
                public void onRadioCheckChanged(int i) {
                    if (DebugPanel.this.mMgtvVideoView != null) {
                        if (i == 0) {
                            DebugPanel debugPanel = DebugPanel.this;
                            if (debugPanel.keyInfoData == null) {
                                return;
                            }
                            debugPanel.mMgtvVideoView.reset();
                            DebugPanel.this.mMgtvVideoView.setKeyInfoData(DebugPanel.this.keyInfoData, 0, 0);
                        } else if (i != 1) {
                            return;
                        } else {
                            DebugPanel debugPanel2 = DebugPanel.this;
                            debugPanel2.keyInfoData = debugPanel2.mMgtvVideoView.getKeyInfoData();
                            DebugPanel.this.mMgtvVideoView.reset();
                        }
                        DebugPanel.this.mMgtvVideoView.resume();
                    }
                }
            });
        }
    }

    private void initMediaCodecSwView() {
        IVideoView iVideoView = this.mMgtvVideoView;
        if (iVideoView != null) {
            createRadioLayout("软渲染:", !iVideoView.isMediaCodecSWEnable(), Arrays.asList("打开", "关闭"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.10
                @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
                public void onRadioCheckChanged(int i) {
                    if (DebugPanel.this.mMgtvVideoView != null) {
                        DebugPanel.this.mMgtvVideoView.enableMediaCodecSW(i == 0);
                        DebugPanel.this.mMgtvVideoView.resume();
                    }
                }
            });
        }
    }

    private void initOppoOSIEView() {
        if (this.mMgtvVideoView != null) {
            createRadioLayout("oppo_osie:", 1, Arrays.asList("打开", "关闭"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.12
                @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
                public void onRadioCheckChanged(int i) {
                    if (DebugPanel.this.mMgtvVideoView != null) {
                        DebugPanel.this.mMgtvVideoView.enableOppoFunc(2, i == 0);
                    }
                }
            });
        }
    }

    private void initOppoSRView() {
        if (this.mMgtvVideoView != null) {
            createRadioLayout("oppo_sr:", 1, Arrays.asList("打开", "关闭"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.11
                @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
                public void onRadioCheckChanged(int i) {
                    if (DebugPanel.this.mMgtvVideoView != null) {
                        DebugPanel.this.mMgtvVideoView.enableOppoFunc(1, i == 0);
                    }
                }
            });
        }
    }

    private void initPlaySpeedView() {
        final EditText editText = new EditText(this.mContext);
        editText.setText(sSetting.playSpeed + "");
        Button createBtn = createBtn(this.mContext, "设置");
        createBtn.setOnClickListener(new View.OnClickListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DebugPanel.sSetting.playSpeed = NumericUtil.parseFloat(editText.getText().toString());
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.this.mMgtvVideoView.setPlaybackSpeed(DebugPanel.sSetting.playSpeed);
                }
            }
        });
        createNewLinear("倍速播放:", Arrays.asList(editText, createBtn));
    }

    private void initPreparedStartModeView() {
        int i = AnonymousClass33.$SwitchMap$com$hunantv$media$player$MgtvMediaPlayer$Prepared4StartMode[sSetting.prepared4StartMode.ordinal()];
        int i2 = 2;
        if (i == 1) {
            i2 = 1;
        } else if (i != 2) {
            i2 = 0;
        }
        createRadioLayout("Prepared模式:", i2, Arrays.asList(MessengerShareContentUtility.PREVIEW_DEFAULT, "AUTOPLAY", "LOADDATA", "LOAD_DISAV"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.22
            @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
            public void onRadioCheckChanged(int i3) {
                Setting setting;
                MgtvMediaPlayer.Prepared4StartMode prepared4StartMode;
                if (i3 == 1) {
                    setting = DebugPanel.sSetting;
                    prepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_AUTOPLAY;
                } else if (i3 == 2) {
                    setting = DebugPanel.sSetting;
                    prepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_LOADDATA;
                } else if (i3 != 3) {
                    setting = DebugPanel.sSetting;
                    prepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_DEFAULT;
                } else {
                    setting = DebugPanel.sSetting;
                    prepared4StartMode = MgtvMediaPlayer.Prepared4StartMode.MODE_PREPARED4START_LOADDATA_DISAV;
                }
                setting.prepared4StartMode = prepared4StartMode;
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.this.mMgtvVideoView.setPrepared4StartMode(DebugPanel.sSetting.prepared4StartMode);
                }
            }
        });
    }

    private void initRenderTypeView() {
        createRadioLayout("渲染类型:", sSetting.renderType == 0 ? 0 : 1, Arrays.asList("SurfaceView", "TextureView"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.26
            @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
            public void onRadioCheckChanged(int i) {
                Setting setting;
                int i2;
                if (i == 0) {
                    setting = DebugPanel.sSetting;
                    i2 = 0;
                } else {
                    setting = DebugPanel.sSetting;
                    i2 = 1;
                }
                setting.renderType = i2;
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.this.mMgtvVideoView.convertRender(DebugPanel.sSetting.renderType);
                }
            }
        });
    }

    private void initSourceSelectView() {
        if (this.mMgtvVideoView != null) {
            boolean z = sSetting.openImgods;
            createRadioLayout("数据模块:", z ? 1 : 0, Arrays.asList("ffmpegDS", "curlDS"), new OnRadioCheckListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.19
                @Override // com.hunantv.media.widget.debug.DebugPanel.OnRadioCheckListener
                public void onRadioCheckChanged(int i) {
                    if (DebugPanel.this.mMgtvVideoView != null) {
                        DebugPanel.sSetting.openImgods = i != 0;
                        DebugPanel.this.mMgtvVideoView.openImgoDSModule(DebugPanel.sSetting.openImgods);
                        DebugPanel.this.mMgtvVideoView.resume();
                    }
                }
            });
        }
    }

    private void initTsSkipErrView() {
        createEnableLayout("ts跳过异常:", sSetting.enableTsSkipError, new OnEnableListener() { // from class: com.hunantv.media.widget.debug.DebugPanel.29
            @Override // com.hunantv.media.widget.debug.DebugPanel.OnEnableListener
            public void onEnableChanged(boolean z) {
                DebugPanel.sSetting.enableTsSkipError = z;
                if (DebugPanel.this.mMgtvVideoView != null) {
                    DebugPanel.this.mMgtvVideoView.enableTsSkipError(DebugPanel.sSetting.enableTsSkipError);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLocalBroadCast() {
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.mBroadCastReceiver, new IntentFilter("mgtv.player.action.PLAYER_REPORT_EVENT"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        sSetting = new Setting();
        setSetting();
        LinearLayout linearLayout = this.mRootLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            initContent(this.mRootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonSelect(Button button, boolean z) {
        button.setSelected(z);
        button.setTextColor(Color.parseColor(button.isSelected() ? "#FF8B18" : "#000000"));
    }

    private void setSetting() {
        IVideoView iVideoView = this.mMgtvVideoView;
        if (iVideoView != null) {
            sSetting.addrInfoTypeInt = iVideoView.getAddrInfoTypeInt();
            this.mMgtvVideoView.setRenderFilter(sSetting.renderFilter);
            this.mMgtvVideoView.setNetAddrinfo(sSetting.addrInfoTypeInt, -1);
            this.mMgtvVideoView.openImgoDSModule(sSetting.openImgods);
            this.mMgtvVideoView.setAspectRatio(sSetting.aspectRatios);
            this.mMgtvVideoView.setPlaybackSpeed(sSetting.playSpeed);
            this.mMgtvVideoView.setAccurateSeekEnable(sSetting.enableAccSeek);
            this.mMgtvVideoView.enableTsSkipError(sSetting.enableTsSkipError);
            this.mMgtvVideoView.setPrepared4StartMode(sSetting.prepared4StartMode);
            this.mMgtvVideoView.setForceHttpDns(sSetting.isForceHttpDns);
            this.mMgtvVideoView.setAntiViewShake(sSetting.isAntiViewShake);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterLocalBroadCast() {
        LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.mBroadCastReceiver);
    }

    public void release() {
        unregisterLocalBroadCast();
    }

    public void updateBaseInfoText() {
        ThreadUtil.runOnUiThread(new Runnable() { // from class: com.hunantv.media.widget.debug.DebugPanel.7
            @Override // java.lang.Runnable
            public void run() {
                IDrmSession drmSession = (DebugPanel.this.mMgtvVideoView == null || DebugPanel.this.mMgtvVideoView.getMediaPlayer() == null) ? null : DebugPanel.this.mMgtvVideoView.getMediaPlayer().getDrmSession();
                StringBuilder sb = new StringBuilder();
                sb.append("***********************DRM信息******************\n");
                sb.append("当前片源选择DRM类型：");
                sb.append(drmSession != null ? MgtvDrmUtils.drmt2DrmTypeStr(drmSession.getDrmt()) : "n");
                sb.append("\n");
                String str = (((sb.toString() + "\n") + "设备是否支持：widevine：" + MgtvDrmUtils.isWidevineSupport() + "\n") + "\n") + "***********************解码器性能列表******************\n";
                MediaCodecHelp.getHardWareperformance(true);
                ArrayList<MediaCodecHelp.CodecPerformance> decoderPerformanceList = MediaCodecHelp.getDecoderPerformanceList();
                for (int i = 0; i < decoderPerformanceList.size(); i++) {
                    str = str + "MimeType:" + decoderPerformanceList.get(i).mimeType + " CodecName:" + decoderPerformanceList.get(i).codecName + " Performance:" + decoderPerformanceList.get(i).performance + " hdr:" + decoderPerformanceList.get(i).hdr + "\n";
                }
                DebugPanel debugPanel = DebugPanel.this;
                debugPanel.baseInfoText = (str + "屏幕性能:" + MediaCodecHelp.getScreenPerformance(DebugPanel.this.getContext()).toString() + "\n") + "*******************************************************\n";
                if (debugPanel.mMgtvVideoView == null || DebugPanel.this.mMgtvVideoView.getMediaPlayer() == null) {
                    DebugPanel.this.baseInfoText = "播放器尚未准备好";
                } else {
                    MgtvMediaPlayer mediaPlayer = DebugPanel.this.mMgtvVideoView.getMediaPlayer();
                    StringBuilder sb2 = new StringBuilder();
                    DebugPanel debugPanel2 = DebugPanel.this;
                    sb2.append(debugPanel2.baseInfoText);
                    sb2.append("TAG:");
                    sb2.append(DebugPanel.this.mMgtvVideoView.getLogTag());
                    sb2.append("\nURL:");
                    sb2.append(DebugPanel.this.mMgtvVideoView.getCurrentUri() != null ? DebugPanel.this.mMgtvVideoView.getCurrentUri().toString() : "");
                    sb2.append("\n\n解码器(OMX开头为硬解):");
                    sb2.append(mediaPlayer.getCurrentVideoDecoderName());
                    sb2.append("\n分辨率:");
                    sb2.append(mediaPlayer.getVideoWidth());
                    sb2.append("x");
                    sb2.append(mediaPlayer.getVideoHeight());
                    sb2.append("\nFPS:");
                    sb2.append(mediaPlayer.getVideoFPS());
                    sb2.append("\n\n起播总耗时:");
                    sb2.append(mediaPlayer.getPropertyLong(ImgoMediaPlayerLib.FFP_PROP_INT64_VVTTIME_VVT, 0L));
                    sb2.append(" ms\n起播t1:");
                    sb2.append(mediaPlayer.getPropertyLong(ImgoMediaPlayerLib.FFP_PROP_INT64_VVTTIME_T1, 0L));
                    sb2.append(" ms\n起播t2:");
                    sb2.append(mediaPlayer.getPropertyLong(ImgoMediaPlayerLib.FFP_PROP_INT64_VVTTIME_T2, 0L));
                    sb2.append(" ms\n起播t3:");
                    sb2.append(mediaPlayer.getPropertyLong(ImgoMediaPlayerLib.FFP_PROP_INT64_VVTTIME_T3, 0L));
                    sb2.append(" ms\n起播t4:");
                    sb2.append(mediaPlayer.getPropertyLong(ImgoMediaPlayerLib.FFP_PROP_INT64_VVTTIME_T4, 0L));
                    sb2.append(" ms\n起播t5:");
                    sb2.append(mediaPlayer.getPropertyLong(ImgoMediaPlayerLib.FFP_PROP_INT64_VVTTIME_T5, 0L));
                    sb2.append(" ms\n起播t6:");
                    sb2.append(mediaPlayer.getPropertyLong(ImgoMediaPlayerLib.FFP_PROP_INT64_VVTTIME_T6, 0L));
                    sb2.append(" ms\n\n");
                    debugPanel2.baseInfoText = sb2.toString();
                    c.a.a.a.d mediaInfo = mediaPlayer.getMediaInfo();
                    if (mediaInfo != null) {
                        StringBuilder sb3 = new StringBuilder();
                        DebugPanel debugPanel3 = DebugPanel.this;
                        sb3.append(debugPanel3.baseInfoText);
                        sb3.append("mediaInfo: ");
                        sb3.append(mediaInfo);
                        sb3.append("\n");
                        debugPanel3.baseInfoText = sb3.toString();
                    }
                }
                DebugPanel debugPanel4 = DebugPanel.this;
                debugPanel4.baseInfoTextView.setText(debugPanel4.baseInfoText);
            }
        });
    }

    public void updatePts(String str) {
        TextView textView = this.mPtsTextView;
        if (textView != null) {
            textView.setText(str);
        }
        this.mPtsTextView.invalidate();
    }
}
