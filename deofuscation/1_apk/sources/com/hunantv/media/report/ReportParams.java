package com.hunantv.media.report;

import a.a.a.b.a;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ReportParams {
    public static final int MAX_LEAVE_VALID_TIME = 540;
    public static final int SPTP_M3U8_DATA = 1;
    public static final int SPTP_NORMAL = 0;
    private String abt;
    private String acp;
    private String datano;
    private DRM drm;
    private String encinfo;
    private Map<String, String> exCommonFields;
    private Map<String, String> exServiceFields;
    private String fileHash;
    private String flowt;
    private int lastErrorCodeExtra;
    private String local_md5;
    private int mAddrInfoInt;
    private int mCaseType;
    private String mDownloadSDKVersion;
    private int mEnhanceQualityType;
    private long mLeaveTimeS;
    private String mPlaySessionId;
    private int mRenderType;
    private int mRetryIndex;
    private long mRouterTimeStamp;
    private String mVideoSession;
    private int p2ps;
    private String refmdid;
    private String remote_md5;
    private int renvtp;
    private int sptp;
    private String svds;
    private String videoFileHash;
    private KeyInfo keyInfo = new KeyInfo();
    private VideoType mVideoType = VideoType.NONE;
    private ProxyType mProxyType = ProxyType.NO_PROXY;
    private String vid = "";
    private String cdnip = "n";
    private End end = new End();
    private int mHasAd = -1;
    private int svtp = 0;
    private int isndn = 0;
    private String def = "";
    private String bsid = "";
    private String pay = "";
    private String fpid = "";
    private String ap = "";
    private String fpn = "";
    private String url = "";
    private String plid = "";
    private String fpa = "";
    private String cid = "";
    private String istry = "";
    private String isad = "";
    private String cf = "";
    private String switcher = "";
    private String submit = "";
    private String bdid = "";
    private String cpn = "";
    private String vfps = "0";
    private String playPreviewType = "";

    /* renamed from: com.hunantv.media.report.ReportParams$1  reason: invalid class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$report$ReportParams$VideoType;

        static {
            int[] iArr = new int[VideoType.values().length];
            $SwitchMap$com$hunantv$media$report$ReportParams$VideoType = iArr;
            try {
                iArr[VideoType.VOD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.LIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.AD_PRE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.AD_MID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.HOME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.FILM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.AD_BOOT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.GAME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.HOME_PREVIEW.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.IMMERSIVE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.VOD_FEED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.FANTUAN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.VIP_RECOMMEND.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.INTERACTIVE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.HOME_PREVIEW_FEED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.HOME_PREVIEW_DY_FEED.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.SOCIAL_PLAY.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.STAR_ROOM_LIVE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.GIF_PREVIEW_VIDEO.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.GIF_PREVIEW_IMAGE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.GIF_CREATOR.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.AUDIO.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.VOD_AUDIO.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.SOCIAL_AUDIO_CHAT.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.TRY_WATCHING.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.AUDIO_FM.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.ALPHA_PLAY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.MINI_FILM.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.SECRET_SPACE.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$hunantv$media$report$ReportParams$VideoType[VideoType.SMALL_ROUTINE.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DRM {
        public String ec;
        public String firm;
        public String lic;

        public DRM() {
        }

        public DRM(DRM drm) {
            this.lic = drm.lic;
            this.firm = drm.firm;
            this.ec = drm.ec;
        }

        public DRM setEc(String str) {
            this.ec = str;
            return this;
        }

        public DRM setFirm(String str) {
            this.firm = str;
            return this;
        }

        public DRM setLic(String str) {
            this.lic = str;
            return this;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class End {
        private boolean innerRetry;
        private Target target;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public enum Target {
            CHANGE_DEFINITION,
            CHANGE_SOURCE
        }

        public End() {
            this.target = Target.CHANGE_SOURCE;
            this.innerRetry = false;
        }

        public End(End end) {
            this.target = Target.CHANGE_SOURCE;
            this.innerRetry = false;
            this.target = end.target;
            this.innerRetry = end.innerRetry;
        }

        public Target getTarget() {
            return this.target;
        }

        public boolean isInnerRetry() {
            return this.innerRetry;
        }

        public End setInnerRetry(boolean z) {
            this.innerRetry = z;
            return this;
        }

        public End setTarget(Target target) {
            this.target = target;
            return this;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class KeyInfo {
        public boolean keyInfoExist;
        public int keyInfoRet;
        public boolean keyInfoSet;
        public int keyInfoSetLayer;
        public String keyinfoDef;
        public String keyinfoFileName;
        public String keyinfoUrl;
        public String keyinfoVid;
        public String reqErrMsg;
        public String reqHttpCode;

        public KeyInfo() {
            this.reqHttpCode = "n";
            this.reqErrMsg = "n";
            this.keyinfoVid = "n";
            this.keyinfoUrl = "n";
            this.keyinfoDef = "n";
            this.keyinfoFileName = "n";
        }

        public KeyInfo(KeyInfo keyInfo) {
            this.reqHttpCode = "n";
            this.reqErrMsg = "n";
            this.keyinfoVid = "n";
            this.keyinfoUrl = "n";
            this.keyinfoDef = "n";
            this.keyinfoFileName = "n";
            this.keyInfoExist = keyInfo.keyInfoExist;
            this.keyInfoSet = keyInfo.keyInfoSet;
            this.keyInfoSetLayer = keyInfo.keyInfoSetLayer;
            this.keyInfoRet = keyInfo.keyInfoRet;
            this.reqHttpCode = keyInfo.reqHttpCode;
            this.reqErrMsg = keyInfo.reqErrMsg;
            this.keyinfoVid = keyInfo.keyinfoVid;
            this.keyinfoUrl = keyInfo.keyinfoUrl;
            this.keyinfoDef = keyInfo.keyinfoDef;
            this.keyinfoFileName = keyInfo.keyinfoFileName;
        }

        public void reset() {
            this.keyInfoExist = false;
            this.keyInfoSet = false;
            this.keyInfoSetLayer = 0;
            this.keyInfoRet = 0;
            this.reqHttpCode = "n";
            this.reqErrMsg = "n";
            this.keyinfoVid = "n";
            this.keyinfoUrl = "n";
            this.keyinfoDef = "n";
            this.keyinfoFileName = "n";
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ProxyType {
        NO_PROXY,
        ONLY_P2P,
        ONLY_UNICOM,
        NOPROXY_DRM,
        P2P_DRM,
        UNICOM_DRM,
        LOCAL_PROXY
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum SubVideoType {
        NONE(0),
        VOD_NONE(10),
        VOD_VIP_PROTECT(11);
        
        private int mValue;

        SubVideoType(int i) {
            this.mValue = 0;
            this.mValue = i;
        }

        public int value() {
            return this.mValue;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum VideoType {
        NONE,
        VOD,
        LIVE,
        LOCAL,
        AD_PRE,
        AD_MID,
        SHORT,
        HOME,
        FILM,
        AD_BOOT,
        GAME,
        HOME_PREVIEW,
        IMMERSIVE,
        VOD_FEED,
        FANTUAN,
        VIP_RECOMMEND,
        INTERACTIVE,
        HOME_PREVIEW_FEED,
        HOME_PREVIEW_DY_FEED,
        SOCIAL_PLAY,
        STAR_ROOM_LIVE,
        GIF_PREVIEW_VIDEO,
        GIF_PREVIEW_IMAGE,
        GIF_CREATOR,
        AUDIO,
        VOD_AUDIO,
        SOCIAL_AUDIO_CHAT,
        TRY_WATCHING,
        AUDIO_FM,
        ALPHA_PLAY,
        MINI_FILM,
        SECRET_SPACE,
        SMALL_ROUTINE
    }

    public ReportParams() {
    }

    public ReportParams(ReportParams reportParams) {
        deepCopy(reportParams);
    }

    public static String createSessionID(Context context) {
        return a.e(context);
    }

    public static String getVideoTypeName(VideoType videoType) {
        switch (AnonymousClass1.$SwitchMap$com$hunantv$media$report$ReportParams$VideoType[videoType.ordinal()]) {
            case 1:
                return "VOD";
            case 2:
                return "LIVE";
            case 3:
                return "LOCAL";
            case 4:
                return "AD_PRE";
            case 5:
                return "AD_MID";
            case 6:
                return "SHORT";
            case 7:
                return "HOME";
            case 8:
                return "FILM";
            case 9:
                return "AD_BOOT";
            case 10:
                return "GAME";
            case 11:
                return "HOME_PREVIEW";
            case 12:
                return "IMMERSIVE";
            case 13:
                return "VOD_FEED";
            case 14:
                return "FANTUAN";
            case 15:
                return "VIP_RECOMMEND";
            case 16:
                return "INTERACTIVE";
            case 17:
                return "HOME_PREVIEW_FEED";
            case 18:
                return "HOME_PREVIEW_DY_FEED";
            case 19:
                return "SOCIAL_PLAY";
            case 20:
                return "STAR_ROOM_LIVE";
            case 21:
                return "GIF_PREVIEW_VIDEO";
            case 22:
                return "GIF_PREVIEW_IMAGE";
            case 23:
                return "GIF_CREATOR";
            case 24:
                return "AUDIO";
            case 25:
                return "VOD_AUDIO";
            case 26:
                return "SOCIAL_AUDIO_CHAT";
            case 27:
                return "TRY_WATCHING";
            case 28:
                return "AUDIO_FM";
            case 29:
                return "ALPHA_PLAY";
            case 30:
                return "MINI_FILM";
            case 31:
                return "SECRET_SPACE";
            case 32:
                return "SMALL_ROUTINE";
            default:
                return "NONE";
        }
    }

    public static String getVideoTypeStr(VideoType videoType) {
        switch (AnonymousClass1.$SwitchMap$com$hunantv$media$report$ReportParams$VideoType[videoType.ordinal()]) {
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "7";
            case 7:
                return "8";
            case 8:
                return "9";
            case 9:
                return "10";
            case 10:
                return "11";
            case 11:
                return "12";
            case 12:
                return "13";
            case 13:
                return "14";
            case 14:
                return "15";
            case 15:
                return "16";
            case 16:
                return "17";
            case 17:
                return "18";
            case 18:
                return "19";
            case 19:
                return "20";
            case 20:
                return "21";
            case 21:
                return "30";
            case 22:
                return "31";
            case 23:
                return "32";
            case 24:
                return "50";
            case 25:
                return "51";
            case 26:
                return "52";
            case 27:
                return "60";
            case 28:
                return "200";
            case 29:
                return "33";
            case 30:
                return "22";
            case 31:
                return "23";
            case 32:
                return "61";
            default:
                return "0";
        }
    }

    public ReportParams deepCopy(ReportParams reportParams) {
        if (reportParams != null) {
            DRM drm = reportParams.drm;
            if (drm != null) {
                this.drm = new DRM(drm);
            }
            this.keyInfo = new KeyInfo(reportParams.keyInfo);
            this.mVideoSession = reportParams.mVideoSession;
            this.mVideoType = reportParams.mVideoType;
            this.mCaseType = reportParams.mCaseType;
            this.mProxyType = reportParams.mProxyType;
            this.mRetryIndex = reportParams.mRetryIndex;
            this.vid = reportParams.vid;
            this.cdnip = reportParams.cdnip;
            this.local_md5 = reportParams.local_md5;
            this.lastErrorCodeExtra = reportParams.lastErrorCodeExtra;
            this.mRouterTimeStamp = reportParams.mRouterTimeStamp;
            this.end = new End(reportParams.end);
            this.mDownloadSDKVersion = reportParams.mDownloadSDKVersion;
            this.mHasAd = reportParams.mHasAd;
            this.mLeaveTimeS = reportParams.mLeaveTimeS;
            this.mRenderType = reportParams.mRenderType;
            this.mEnhanceQualityType = reportParams.mEnhanceQualityType;
            this.mAddrInfoInt = reportParams.mAddrInfoInt;
            this.p2ps = reportParams.p2ps;
            this.def = reportParams.def;
            if (reportParams.exCommonFields != null) {
                this.exCommonFields = new HashMap(reportParams.exCommonFields);
            }
            if (reportParams.exServiceFields != null) {
                this.exServiceFields = new HashMap(reportParams.exServiceFields);
            }
            this.bsid = reportParams.bsid;
            this.pay = reportParams.pay;
            this.fpid = reportParams.fpid;
            this.ap = reportParams.ap;
            this.fpn = reportParams.fpn;
            this.url = reportParams.url;
            this.plid = reportParams.plid;
            this.fpa = reportParams.fpa;
            this.cid = reportParams.cid;
            this.istry = reportParams.istry;
            this.isad = reportParams.isad;
            this.cf = reportParams.cf;
            this.switcher = reportParams.switcher;
            this.submit = reportParams.submit;
            this.bdid = reportParams.bdid;
            this.cpn = reportParams.cpn;
            this.datano = reportParams.datano;
            this.refmdid = reportParams.refmdid;
            this.acp = reportParams.acp;
            this.abt = reportParams.abt;
            this.fileHash = reportParams.fileHash;
            this.remote_md5 = reportParams.remote_md5;
            this.videoFileHash = reportParams.videoFileHash;
        }
        return this;
    }

    public String getAbt() {
        return this.abt;
    }

    public String getAcp() {
        return this.acp;
    }

    public int getAddrInfoInt() {
        return this.mAddrInfoInt;
    }

    public String getAp() {
        return this.ap;
    }

    public String getBdid() {
        return this.bdid;
    }

    public String getBsid() {
        return this.bsid;
    }

    public int getCaseType() {
        return this.mCaseType;
    }

    public String getCdnip() {
        return this.cdnip;
    }

    public String getCf() {
        return this.cf;
    }

    public String getCid() {
        return this.cid;
    }

    public String getCpn() {
        return this.cpn;
    }

    public String getDatano() {
        return this.datano;
    }

    public String getDef() {
        return this.def;
    }

    public String getDownloadSDKVersion() {
        return this.mDownloadSDKVersion;
    }

    public DRM getDrm() {
        return this.drm;
    }

    public String getEncinfo() {
        return this.encinfo;
    }

    public End getEnd() {
        return this.end;
    }

    public int getEnhanceQualityType() {
        return this.mEnhanceQualityType;
    }

    public Map<String, String> getExCommonFields() {
        return this.exCommonFields;
    }

    public Map<String, String> getExServiceFields() {
        return this.exServiceFields;
    }

    public String getFlowt() {
        return this.flowt;
    }

    public String getFpa() {
        return this.fpa;
    }

    public String getFpid() {
        return this.fpid;
    }

    public String getFpn() {
        return this.fpn;
    }

    public int getHasAd() {
        return this.mHasAd;
    }

    public String getIsad() {
        return this.isad;
    }

    public int getIsndn() {
        return this.isndn;
    }

    public String getIstry() {
        return this.istry;
    }

    public KeyInfo getKeyInfo() {
        return this.keyInfo;
    }

    public int getLastErrorCodeExtra() {
        return this.lastErrorCodeExtra;
    }

    public long getLeaveTimeS() {
        return this.mLeaveTimeS;
    }

    public String getLocalMd5() {
        return this.local_md5;
    }

    public int getP2ps() {
        return this.p2ps;
    }

    public String getPay() {
        return this.pay;
    }

    public String getPlayPreviewType() {
        return this.playPreviewType;
    }

    public String getPlaySessionId() {
        return this.mPlaySessionId;
    }

    public String getPlid() {
        return this.plid;
    }

    public ProxyType getProxyType() {
        return this.mProxyType;
    }

    public String getRefmdid() {
        return this.refmdid;
    }

    public String getRemoteMd5() {
        return this.remote_md5;
    }

    public int getRenderType() {
        return this.mRenderType;
    }

    public int getRenvtp() {
        return this.renvtp;
    }

    public int getRetryIndex() {
        return this.mRetryIndex;
    }

    public long getRouterTimeStamp() {
        return this.mRouterTimeStamp;
    }

    public int getSptp() {
        return this.sptp;
    }

    public String getSubmit() {
        return this.submit;
    }

    public String getSvds() {
        return this.svds;
    }

    public int getSvtp() {
        return this.svtp;
    }

    public String getSwitcher() {
        return this.switcher;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVfps() {
        return this.vfps;
    }

    public String getVid() {
        return this.vid;
    }

    public String getVideoFileHash() {
        return this.videoFileHash;
    }

    public String getVideoSession() {
        return this.mVideoSession;
    }

    public VideoType getVideoType() {
        return this.mVideoType;
    }

    public boolean isP2p() {
        ProxyType proxyType;
        int i = this.p2ps;
        return i == 2 || i == 1 || (proxyType = this.mProxyType) == ProxyType.ONLY_P2P || proxyType == ProxyType.P2P_DRM;
    }

    public ReportParams setAbt(String str) {
        this.abt = str;
        return this;
    }

    public ReportParams setAcp(String str) {
        this.acp = str;
        return this;
    }

    public ReportParams setAddrInfoInt(int i) {
        this.mAddrInfoInt = i;
        return this;
    }

    public ReportParams setAp(String str) {
        this.ap = str;
        return this;
    }

    public ReportParams setBdid(String str) {
        this.bdid = str;
        return this;
    }

    public ReportParams setBsid(String str) {
        this.bsid = str;
        return this;
    }

    public ReportParams setCaseType(int i) {
        this.mCaseType = i;
        return this;
    }

    public ReportParams setCdnip(String str) {
        this.cdnip = str;
        return this;
    }

    public ReportParams setCf(String str) {
        this.cf = str;
        return this;
    }

    public ReportParams setCid(String str) {
        this.cid = str;
        return this;
    }

    public ReportParams setCpn(String str) {
        this.cpn = str;
        return this;
    }

    public ReportParams setDatano(String str) {
        this.datano = str;
        return this;
    }

    public ReportParams setDef(String str) {
        this.def = str;
        return this;
    }

    public ReportParams setDownloadSDKVersion(String str) {
        this.mDownloadSDKVersion = str;
        return this;
    }

    public ReportParams setDrm(DRM drm) {
        this.drm = drm;
        return this;
    }

    public ReportParams setEncinfo(String str) {
        this.encinfo = str;
        return this;
    }

    public ReportParams setEnhanceQualityType(int i) {
        this.mEnhanceQualityType = i;
        return this;
    }

    public ReportParams setExCommonFields(Map<String, String> map) {
        this.exCommonFields = map;
        return this;
    }

    public ReportParams setExServiceFields(Map<String, String> map) {
        this.exServiceFields = map;
        return this;
    }

    public ReportParams setFileHash(String str) {
        this.fileHash = str;
        return this;
    }

    public ReportParams setFlowt(String str) {
        this.flowt = str;
        return this;
    }

    public ReportParams setFpa(String str) {
        this.fpa = str;
        return this;
    }

    public ReportParams setFpid(String str) {
        this.fpid = str;
        return this;
    }

    public ReportParams setFpn(String str) {
        this.fpn = str;
        return this;
    }

    public ReportParams setHasAd(int i) {
        this.mHasAd = i;
        return this;
    }

    public ReportParams setIsNewDefName(boolean z) {
        this.isndn = z ? 1 : 0;
        return this;
    }

    public ReportParams setIsad(String str) {
        this.isad = str;
        return this;
    }

    public ReportParams setIstry(String str) {
        this.istry = str;
        return this;
    }

    public ReportParams setLastErrorCodeExtra(int i) {
        this.lastErrorCodeExtra = i;
        return this;
    }

    public ReportParams setLeaveTimeS(long j) {
        this.mLeaveTimeS = j;
        return this;
    }

    public ReportParams setLocalMd5(String str) {
        this.local_md5 = str;
        return this;
    }

    public ReportParams setP2ps(int i) {
        this.p2ps = i;
        return this;
    }

    public ReportParams setPay(String str) {
        this.pay = str;
        return this;
    }

    public void setPlayPreviewType(String str) {
        this.playPreviewType = str;
    }

    public void setPlaySessionId(String str) {
        this.mPlaySessionId = str;
    }

    public ReportParams setPlid(String str) {
        this.plid = str;
        return this;
    }

    public ReportParams setProxyType(ProxyType proxyType) {
        this.mProxyType = proxyType;
        return this;
    }

    public ReportParams setRefmdid(String str) {
        this.refmdid = str;
        return this;
    }

    public ReportParams setRemoteMd5(String str) {
        this.remote_md5 = str;
        return this;
    }

    public ReportParams setRenderType(int i) {
        this.mRenderType = i;
        return this;
    }

    public ReportParams setRenvtp(int i) {
        this.renvtp = i;
        return this;
    }

    public ReportParams setRetryIndex(int i) {
        this.mRetryIndex = i;
        return this;
    }

    public ReportParams setRouterTimeStamp(long j) {
        this.mRouterTimeStamp = j;
        return this;
    }

    public ReportParams setSptp(int i) {
        this.sptp = i;
        return this;
    }

    public ReportParams setSubmit(String str) {
        this.submit = str;
        return this;
    }

    public ReportParams setSvds(String str) {
        this.svds = str;
        return this;
    }

    public ReportParams setSvtp(SubVideoType subVideoType) {
        this.svtp = subVideoType.value();
        return this;
    }

    public ReportParams setSwitcher(String str) {
        this.switcher = str;
        return this;
    }

    public ReportParams setUrl(String str) {
        this.url = str;
        return this;
    }

    public void setVfps(String str) {
        this.vfps = str;
    }

    public ReportParams setVid(String str) {
        this.vid = str;
        return this;
    }

    public ReportParams setVideoFileHash(String str) {
        this.videoFileHash = str;
        return this;
    }

    public ReportParams setVideoSession(String str) {
        this.mVideoSession = str;
        return this;
    }

    public ReportParams setVideoType(VideoType videoType) {
        this.mVideoType = videoType;
        return this;
    }

    public String toString() {
        return "ReportParams{mVideoSession='" + this.mVideoSession + "', mVideoType=" + this.mVideoType + ", vid='" + this.vid + "', cdnip='" + this.cdnip + "', p2ps=" + this.p2ps + ", def='" + this.def + "', flowt='" + this.flowt + "', videoFileHash='" + this.videoFileHash + "', framerate(vfps)='" + this.vfps + "', videoIntroduction='" + this.svds + "', playPreviewType='" + this.playPreviewType + "'}";
    }
}
