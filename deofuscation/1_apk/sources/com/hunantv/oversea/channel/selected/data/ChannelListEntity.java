package com.hunantv.oversea.channel.selected.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.json.JsonInterface;
import java.io.Serializable;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelListEntity extends JsonEntity implements Serializable, JsonInterface {
    private static final String CHANNEL_ID_SELECT = "619";
    private static final String CHANNEL_ID_SELECT_TEST = "122";
    private static final String SPLIT_CHA = "&";
    private static final /* synthetic */ c.b ajc$tjp_0 = null;
    private static final long serialVersionUID = 6832951997000859338L;
    public ChannelBean channel;
    public List<DataBean> data;
    public String seqid;
    public long timestamp;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ChannelBean implements Serializable, JsonInterface {
        private static final long serialVersionUID = -3583679582893528007L;
        public String title;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DataBean implements Serializable, JsonInterface {
        private static final long serialVersionUID = -3497413721287858064L;
        public String bgImg;
        public String bgImgUrl;
        public boolean cache;
        public String channelHImg;
        public String channelIcon;
        public String channelIcon2;
        public String channelIcon3;
        public String channelMapping;
        public String channelSource;
        public String cid;
        public String description;
        public String fontColor;
        public String fstlvlId;
        public String h5Url;
        public String isCustomShow;
        public String isDefault;
        public String isIndividual;
        public String isTop;
        public int isTopRed;
        public String keywords;
        public String layer;
        public String library;
        public String navbarBgColor;
        public String navbarHlColor;
        public String pageType;
        public String parentId;
        public String status;
        public String superscript;
        public String superscriptIcon;
        public String supportH5;
        public String title;
        public String url;
        public String vclassId;
        public String vclassName;
        public String vclassType;
        public String buttonSupport = "000";
        public String customPosition = "0";

        private boolean checkLibData(DataBean dataBean) {
            return false;
        }

        public boolean checkEquals(DataBean dataBean) {
            int i;
            if (dataBean != null && TextUtils.equals(this.vclassId, dataBean.vclassId) && TextUtils.equals(this.title, dataBean.title) && TextUtils.equals(this.buttonSupport, dataBean.buttonSupport) && TextUtils.equals(this.customPosition, dataBean.customPosition) && TextUtils.equals(dataBean.channelSource, this.channelSource) && TextUtils.equals(this.h5Url, dataBean.h5Url) && !checkLibData(dataBean) && (i = this.isTopRed) == dataBean.isTopRed) {
                if (i == 1) {
                    return TextUtils.equals(this.bgImgUrl, dataBean.bgImgUrl) && TextUtils.equals(this.navbarBgColor, dataBean.navbarBgColor);
                }
                return true;
            }
            return false;
        }

        public void copyData(DataBean dataBean) {
            if (dataBean == null) {
                return;
            }
            this.channelHImg = dataBean.channelHImg;
            this.channelIcon = dataBean.channelIcon;
            this.description = dataBean.description;
            this.fstlvlId = dataBean.fstlvlId;
            this.isTop = dataBean.isTop;
            this.keywords = dataBean.keywords;
            this.layer = dataBean.layer;
            this.library = dataBean.library;
            this.pageType = dataBean.pageType;
            this.parentId = dataBean.parentId;
            this.status = dataBean.status;
            this.superscript = dataBean.superscript;
            this.superscriptIcon = dataBean.superscriptIcon;
            this.title = dataBean.title;
            this.url = dataBean.url;
            this.vclassId = dataBean.vclassId;
            this.vclassName = dataBean.vclassName;
            this.vclassType = dataBean.vclassType;
            this.channelIcon2 = dataBean.channelIcon2;
            this.channelIcon3 = dataBean.channelIcon3;
            this.buttonSupport = dataBean.buttonSupport;
            this.supportH5 = dataBean.supportH5;
            this.h5Url = dataBean.h5Url;
            this.customPosition = dataBean.customPosition;
            this.navbarBgColor = dataBean.navbarBgColor;
            this.navbarHlColor = dataBean.navbarHlColor;
            this.isTopRed = dataBean.isTopRed;
            this.bgImgUrl = dataBean.bgImgUrl;
            this.fontColor = dataBean.fontColor;
            this.bgImg = dataBean.bgImg;
        }

        public boolean isIndividual() {
            return TextUtils.equals(this.isIndividual, "1");
        }

        public boolean isTopRedMode() {
            return this.isTopRed == 1;
        }
    }

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("ChannelListEntity.java", ChannelListEntity.class);
        ajc$tjp_0 = eVar.H("method-execution", eVar.E("1", "reportString", "com.hunantv.oversea.channel.selected.data.ChannelListEntity", "", "", "", "java.lang.String"), 46);
    }

    public static boolean isSelectedChannel(String str) {
        return TextUtils.equals(str, CHANNEL_ID_SELECT) || TextUtils.equals(str, "122");
    }

    public static final /* synthetic */ String reportString_aroundBody0(ChannelListEntity channelListEntity, c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("ChannelListEntity==seqid:");
        sb.append(channelListEntity.seqid);
        sb.append("&");
        sb.append("timestamp:");
        sb.append(channelListEntity.timestamp);
        sb.append("&");
        sb.append("code:");
        sb.append(channelListEntity.code);
        sb.append("&");
        sb.append("msg:");
        sb.append(channelListEntity.msg);
        sb.append("&");
        sb.append("data size:");
        List<DataBean> list = channelListEntity.data;
        sb.append(list == null ? -1 : list.size());
        return sb.toString();
    }

    public boolean moreThanOne() {
        List<DataBean> list = this.data;
        return (list == null || list.isEmpty()) ? false : true;
    }

    @NonNull
    @WithTryCatchRuntime
    public String reportString() {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.f.v0.c(new Object[]{this, e.v(ajc$tjp_0, this, this)}).e(69648));
    }
}
