package com.hunantv.oversea.channel.net.entity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hunantv.imgo.entity.JsonEntity;
import com.hunantv.oversea.main.common.utils.ImageCropParam;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.json.JsonInterface;
import j.l.c.c.e.b.a;
import java.io.Serializable;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelIndexEntity extends JsonEntity implements Serializable, JsonInterface {
    public static final int AD_CLICK_HUGE = 3;
    public static final int AD_CLICK_IN = 2;
    public static final int AD_CLICK_OUT = 1;
    public static final int AD_CLICK_UNKNOW = 0;
    private static final String SPLIT_CHA = "&";
    private static final /* synthetic */ c.b ajc$tjp_0 = null;
    private static final long serialVersionUID = -1130704452419899285L;
    public ChannelBean channel;
    public List<DataBean> data;
    public int flag;
    public List<NaviBean> navi;
    public int pageNo;
    public int pageSize;
    public String seqid;
    public long timestamp;
    public int totalPage;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class BtnStyle implements Serializable, JsonInterface {
        public String btnStatus;
        public String btnText;
        public String btnType;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ChannelBean implements Serializable, JsonInterface {
        private static final long serialVersionUID = -4373581635335250854L;
        public String channelIcon;
        public String isCustomShow;
        public String isIndividual;
        public String navbarBgColor;
        public String navbarHlColor;
        public String title;
        public String vclassId;
        public String wechatDesc;
        public String wechatTitle;

        public boolean isIndividualChannel() {
            return !TextUtils.isEmpty(this.isCustomShow) && this.isCustomShow.equals("1");
        }

        @NonNull
        public String reportString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ChannelBean==");
            stringBuffer.append("channelIcon:" + this.channelIcon);
            stringBuffer.append("&");
            stringBuffer.append("title:" + this.title);
            stringBuffer.append("&");
            stringBuffer.append("vclassId:" + this.vclassId);
            stringBuffer.append("&");
            stringBuffer.append("wechatDesc:" + this.wechatDesc);
            stringBuffer.append("&");
            stringBuffer.append("wechatTitle:" + this.wechatTitle);
            stringBuffer.append("&");
            stringBuffer.append("isCustomShow:" + this.isCustomShow);
            stringBuffer.append("&");
            stringBuffer.append("navbarHlColor:" + this.navbarHlColor);
            stringBuffer.append("&");
            stringBuffer.append("navbarBgColor:" + this.navbarBgColor);
            return stringBuffer.toString();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DataBean implements Serializable, JsonInterface {
        private static final long serialVersionUID = -3917143712407328595L;
        public int adId;
        public String aidInfo;
        public String backgroundImgPos;
        public String bannerFlag;
        public String cardId;
        public String combineId;
        public List<FdModuleDataBean> fdModuleData;
        public String fontColor;
        public String icon;
        public String indexKey;
        public String insertStyle;
        public String interfaceUrl;
        public String isCardModule;
        public boolean isCombinationCard;
        public int isExchange;
        public String isFrame;
        public int mobileNumber;
        public List<ModuleDataBean> moduleData;
        public String moduleHeight;
        public String moduleName;
        public String moduleStyle;
        public String moduleTitle;
        public String moduleType;
        public String navbarBgColor;
        public String navbarHlColor;
        public String negativeFeedbackUrl;
        public List<PbModuleDataBean> pbModuleData;
        public String pic;
        public String reporter;
        public String schemaUrl;
        public String tagSubmitUrl;
        public List<ModuleDataBean> zlData;
        public List<DataBean> zlModuleData;
        public String zlparam;
        public String dataModuleId = "";
        public String exchangeNumber = "";
        public String moduleId = "";

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class ModuleDataBean implements Serializable, JsonInterface {
            private static final long serialVersionUID = -9020677403073044161L;
            public String activityId;
            public int adAwayAppType;
            public int adJump;
            public String adJumpUrl;
            public boolean adLogEnnable;
            public String adOrigin;
            public int adResType;
            public String adUUID;
            public long aid;
            public String articleUrl;
            public String autoPlayActivityId;
            public String autoPlayTVChannelId;
            public String autoPlayVideoId;
            public String bgColor;
            public BtnStyle btnStyle;
            public String childId;
            public String childid;
            public String cid;
            public String clipDesc;
            public String clipTitle;
            public String commentCount;
            public String commentNum;
            public String conner;
            public String cornerType;
            public String coverImg;
            public String dataStyle;
            public long duration;
            public String fdParams;
            public String filter;
            public String fontColor;
            public Icon icon;
            public List<Image> images;
            public String imgHUrl;
            public String imgHUrlToMobile;
            public String imgHVUrl;
            public int imgType;
            public boolean inModuleCJ;
            public boolean isBannerAdVideo;
            public boolean isBannerExpose;
            public int isFollow;
            public int isFollowed;
            public boolean isSelected;
            public String isShare;
            public boolean isShownOfficialVideo;
            public String jumpId;
            public String jumpKind;
            public String jumpUrl;
            public String jumpid;
            public String jumpkind;
            public String likeCount;
            public String likeStatus;
            public String liveEndTime;
            public String liveStartTime;
            public String mainName;
            public String mobileImgUrl;
            public String mobileTitle;
            public String mobileVImgUrl;
            public String name;
            public String nickName;
            public int order;
            public String pageUrl;
            public String phoneImgUrl;
            public String photo;
            public List<PkItem> pkItem;
            public String playerType;
            public int positon;
            public String praiseNum;
            public long previewDuration;
            public String previewVid;
            public List<RecReasons> recReasons;
            public String releaseTime;
            public ReserveContent reserveContent;
            public String rightCorner;
            public int screenMode;
            public ShareInfo shareInfo;
            public String sortNo;
            public String subName;
            public String subtitle;
            public String summary;
            public String timeLineDateTime;
            public String title;
            public String topicDesc;
            public String topicId;
            public String topicImage;
            public String topicScore;
            public String topicTitle;
            public String tvChannelId;
            public int type;
            public String uid;
            public String updateInfo;
            public int upgcFlag;
            public User user;
            public String videoGroup;
            public String videoId;
            public String videoUrl;
            public String viewNum;
            public long watchTime;
            public String columType = "";
            public String columDMId = "";
            public String columMId = "";
            public String columMName = "";
            public String mobileJumpUrl = "";

            /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
            public static class Icon implements Serializable, JsonInterface {
                private static final long serialVersionUID = 7342919351695676301L;
                public String color;
                public String name;
            }

            /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
            public static class Image implements Serializable, JsonInterface {
                private static final long serialVersionUID = 8454645458855679179L;
                public String url;
            }

            @Nullable
            public String getImgUrl(boolean z) {
                String str;
                if (!TextUtils.isEmpty(this.phoneImgUrl)) {
                    str = this.phoneImgUrl;
                } else {
                    str = z ? this.imgHUrl : this.imgHVUrl;
                }
                return str == null ? "" : str;
            }

            @Nullable
            public String getImgUrlWithCropParam(String str, boolean z) {
                return ImageCropParam.getImgUrlWithCropParam(getImgUrl(z), new ImageCropParam.b().d(str).c());
            }

            @Nullable
            public String getTitle() {
                String str = this.mobileTitle;
                String str2 = (str == null || str.isEmpty()) ? this.name : this.mobileTitle;
                return str2 == null ? "" : str2;
            }
        }

        public String getDataModuleId() {
            if (TextUtils.isEmpty(this.dataModuleId) || TextUtils.equals(this.dataModuleId, "0")) {
                this.dataModuleId = "";
            }
            return String.valueOf(this.dataModuleId);
        }

        public boolean isCardStyle() {
            return TextUtils.equals(this.moduleStyle, "1");
        }

        public boolean isFrame() {
            return TextUtils.equals(this.isFrame, "1");
        }

        public boolean isInsertStyle() {
            return TextUtils.equals(this.insertStyle, "1");
        }

        public boolean isNewCardModule() {
            return TextUtils.equals(this.isCardModule, "1");
        }

        public boolean isReportRecommendation() {
            return TextUtils.equals(this.reporter, "recommendation");
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class FdModuleDataBean implements Serializable, JsonInterface {
        private static final int SHOW_STATE_DEFAULT = 0;
        private static final int SHOW_STATE_EXPOSURE = 1;
        private static final int SHOW_STATE_REPORTED = 2;
        private static final long serialVersionUID = -4640889108420565221L;
        public String childid;
        public String fdConner;
        public String fdConnerBgColor;
        public String fdConnerTxtColor;
        public String fdCorner;
        public String fdDescription;
        public String fdDuration;
        public String fdInfo;
        public String fdLeftTopConner;
        public String fdMobileImgUrl;
        public String fdMobileVImgUrl;
        public FdNegativeFeedbackData fdNegativeFeedbackData;
        public String fdPlayInfo;
        public String fdPreviewDuration;
        public String fdPreviewTitle;
        public String fdPreviewVid;
        public List<FdTags> fdRuleTags;
        public String fdStars;
        public String fdSubtitle;
        public List<FdTags> fdTags;
        public String fdTitle;
        public int fdTop;
        public String fdUpdateInfo;
        public String fdWatchInfo;
        public String fdWatchTime;
        private String haveIntact;
        public boolean isMask;
        public String jumpid;
        public String jumpkind;
        public String likeCount;
        public String nickName;
        public String photo;
        public String playCount;
        public String fdParams = "";
        private int showState = 0;

        public void doExpsure() {
            if (this.showState < 1) {
                this.showState = 1;
            }
        }

        public void doReport() {
            this.showState = 2;
        }

        @Nullable
        public String getImgUrl(boolean z) {
            String str = z ? this.fdMobileImgUrl : this.fdMobileVImgUrl;
            return TextUtils.isEmpty(str) ? "" : str;
        }

        @Nullable
        public String getImgUrlWithCropParam(String str, String str2) {
            return ImageCropParam.getImgUrlWithCropParam(str, new ImageCropParam.b().d(str2).c());
        }

        public boolean hasIntact() {
            return TextUtils.equals(this.haveIntact, "1");
        }

        public boolean shouldReport() {
            return this.showState == 1;
        }

        @Nullable
        public String getImgUrlWithCropParam(String str, boolean z) {
            return ImageCropParam.getImgUrlWithCropParam(getImgUrl(z), new ImageCropParam.b().d(str).c());
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class FdNegativeFeedbackData implements Serializable, JsonInterface {
        private static final long serialVersionUID = 3757709030120257363L;
        public List<FdNegativeFeedbackOptionsData> fdNegativeOptions;
        public String fdNegativeType;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class FdNegativeFeedbackOptionsData implements Serializable, JsonInterface {
        private static final long serialVersionUID = -5696250248157662127L;
        public String content;
        public String id;
        public String name;
        public String url;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class FdTags implements Serializable, JsonInterface {
        private static final long serialVersionUID = -3353696254417436880L;
        public String id;
        public String name;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class NaviBean implements Serializable, JsonInterface {
        private static final long serialVersionUID = 950712146063558734L;
        public String childId;
        public String filter;
        public String jumpId;
        public String jumpKind;
        public String name;
        public String pageUrl;
        public int sortNo;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class PbModuleDataBean implements Serializable, JsonInterface {
        private static final long serialVersionUID = -530917950270927620L;
        public List<PdDataBean> data;
        public String moduleTitle;
        public String moduleType;
        public MoreBean more;
        public List<PdDataBean> pdData;
        public String queryUrl;
        public String subCancelToast;
        public String subNoPushToast;
        public String subToast;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class MoreBean implements Serializable, JsonInterface {
            private static final long serialVersionUID = -5084397034885941864L;
            public int isMore;
            public String moreName;
            public int pbId;
        }

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class PdDataBean implements Serializable, JsonInterface {
            private static final long serialVersionUID = -4284029062699456062L;
            public String aid;
            public String beginTime;
            public String buttonStatus;
            public int buttonType;
            public String childId;
            public int dataType;
            public String desc;
            public int dsId;
            public String img;
            public String imgHor;
            public String imgVer;
            public String jumpId;
            public String jumpKind;
            public String jumpUrl;
            public boolean mIsSubscribe;
            public String rightBottom;
            public RightTopBean rightTop;
            public int selected;
            public String streamId;
            public String title;
            public String tvChannelId;
            public String videoId;

            /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
            public static class RightTopBean implements Serializable, JsonInterface {
                private static final long serialVersionUID = -1508158388424514335L;
                public String color;
                public String text;
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class PkItem implements Serializable, JsonInterface {
        public String item;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class RecReasons implements Serializable, JsonInterface {
        private static final long serialVersionUID = -3950095805508977476L;
        public String backgroundColor;
        public String borderColor;
        public String recReason;
        public String textColor;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ReserveContent implements Serializable, JsonInterface {
        public String aid;
        public String h5Url;
        public String roomId;
        public String type;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ShareInfo implements Serializable, JsonInterface {
        private static final long serialVersionUID = 948084414880669258L;
        public String desc;
        public String img;
        public String title;
        public String url;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class User implements Serializable, JsonInterface {
        private static final long serialVersionUID = 1110361341556324346L;
        public int accountType;
        public int level;
        public String nickName;
        public String photo;
        public String uuid;
    }

    static {
        ajc$preClinit();
    }

    @Nullable
    public static ChannelIndexEntity addUniqueKey(@NonNull ChannelIndexEntity channelIndexEntity) {
        List<DataBean> list = channelIndexEntity.data;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                DataBean dataBean = list.get(i);
                if (dataBean != null) {
                    list.get(i).indexKey = dataBean.moduleType + "+" + i;
                }
            }
        }
        return channelIndexEntity;
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("ChannelIndexEntity.java", ChannelIndexEntity.class);
        ajc$tjp_0 = eVar.H("method-execution", eVar.E("1", "reportString", "com.hunantv.oversea.channel.net.entity.ChannelIndexEntity", "", "", "", "java.lang.String"), 46);
    }

    public static final /* synthetic */ String reportString_aroundBody0(ChannelIndexEntity channelIndexEntity, c cVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChannelIndexEntity==");
        stringBuffer.append("seqid:" + channelIndexEntity.seqid);
        stringBuffer.append("&");
        stringBuffer.append("timestamp:" + channelIndexEntity.timestamp);
        stringBuffer.append("&");
        stringBuffer.append("flag:" + channelIndexEntity.flag);
        stringBuffer.append("&");
        stringBuffer.append("pageNo:" + channelIndexEntity.pageNo);
        stringBuffer.append("&");
        stringBuffer.append("pageSize:" + channelIndexEntity.pageSize);
        stringBuffer.append("&");
        stringBuffer.append("totalPage:" + channelIndexEntity.totalPage);
        stringBuffer.append("&");
        StringBuilder sb = new StringBuilder();
        sb.append("ChannelBean:");
        ChannelBean channelBean = channelIndexEntity.channel;
        sb.append(channelBean == null ? "" : channelBean.reportString());
        stringBuffer.append(sb.toString());
        stringBuffer.append("&");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("dataListSize:");
        List<DataBean> list = channelIndexEntity.data;
        sb2.append(list == null ? "-1" : Integer.valueOf(list.size()));
        stringBuffer.append(sb2.toString());
        return stringBuffer.toString();
    }

    @NonNull
    @WithTryCatchRuntime
    public String reportString() {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a(new Object[]{this, e.v(ajc$tjp_0, this, this)}).e(69648));
    }
}
