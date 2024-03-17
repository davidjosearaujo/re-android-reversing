package com.hunantv.oversea.channel.dynamic.data;

import android.text.TextUtils;
import com.alibaba.fastjson.asm.Opcodes;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.json.JsonInterface;
import com.mgtv.task.http.HttpTraceObject;
import j.l.a.b0.c0;
import j.l.a.b0.j;
import j.l.c.c.c.o1.u;
import j.l.c.c.c.o1.v;
import j.l.c.c.c.o1.w;
import j.l.c.c.c.o1.x;
import j.l.c.c.c.o1.y;
import java.util.List;
import q.b0;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ModuleData extends JsonEntity implements JsonInterface {
    public static final String DSL_ID_INSERT_AD = "-100001";
    private static final /* synthetic */ c.b ajc$tjp_0 = null;
    private static final long serialVersionUID = -9166272693978331361L;
    public AdInfoBean adInfo;
    public ChannelBean channel;
    public String channelId;
    public List<DataBean> data;
    public List<ModuleIDSBean> moduleIDS;
    public ShareInfoBean shareInfo;
    public String title;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class AdInfoBean implements JsonInterface {
        private static final long serialVersionUID = -7302160118872390583L;
        public List<String> ids;
        private String interval;

        public int getInterval() {
            int f = c0.f(this.interval);
            if (f < 5) {
                return 5;
            }
            return f;
        }

        public boolean isEmpty() {
            return j.a(this.ids);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ChannelBean implements JsonInterface {
        private static final long serialVersionUID = -4373581635335250854L;
        public String bgImg;
        public String isCustomShow;
        public String navbarBgColor;
        public String navbarHlColor;

        public boolean isIndividualChannel() {
            return !TextUtils.isEmpty(this.isCustomShow) && this.isCustomShow.equals("1");
        }

        public boolean isIndividualColor() {
            return (TextUtils.isEmpty(this.navbarHlColor) || TextUtils.isEmpty(this.navbarBgColor)) ? false : true;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DSLEntityBean extends JsonEntity implements JsonInterface {
        private static final long serialVersionUID = -5843295124087920918L;
        public DataBean.DSLBean data;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ModuleIDSBean implements JsonInterface {
        private static final long serialVersionUID = -4334661023334690638L;
        public String adID;
        public String infinite;
        public String moduleEntityId;
        private transient int pageNum = 1;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static final class a {
            public static final String a = "column";
            public static final String b = "row";
        }

        public int getPageNum() {
            return this.pageNum;
        }

        public boolean hasMore() {
            return isColumnInfinite() && this.pageNum >= 1;
        }

        public void inCrease() {
            this.pageNum++;
        }

        public boolean isAd() {
            return !TextUtils.isEmpty(this.adID);
        }

        public boolean isColumnInfinite() {
            return TextUtils.equals(a.a, this.infinite);
        }

        public void setNoMore() {
            this.pageNum = -1;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class ShareInfoBean implements JsonInterface {
        private static final long serialVersionUID = 3703670686459662743L;
        public String channelTitle;
        public String desc;
        public String image;
        public String qrcode;
        public String title;
        public String url;
    }

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        e eVar = new e("ModuleData.java", ModuleData.class);
        ajc$tjp_0 = eVar.H("method-execution", eVar.E("1", "parseTraceId", "com.hunantv.oversea.channel.dynamic.data.ModuleData", "com.mgtv.task.http.HttpTraceObject", "traceObject", "", "void"), 44);
    }

    public static final /* synthetic */ void parseTraceId_aroundBody0(ModuleData moduleData, HttpTraceObject httpTraceObject, c cVar) {
        List<DataBean> list;
        if (httpTraceObject == null || httpTraceObject.finalRequest == null || (list = moduleData.data) == null || list.size() <= 0) {
            return;
        }
        String c = httpTraceObject.finalRequest.c("x-r-i");
        for (DataBean dataBean : moduleData.data) {
            dataBean.traceId = c;
            List<DataBean.DSLBean> list2 = dataBean.DSLList;
            if (list2 != null && list2.size() > 0) {
                for (DataBean.DSLBean dSLBean : dataBean.DSLList) {
                    dSLBean.traceId = c;
                }
            }
        }
    }

    @WithTryCatchRuntime
    public void parseTraceId(HttpTraceObject httpTraceObject) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new u(new Object[]{this, httpTraceObject, e.w(ajc$tjp_0, this, this, httpTraceObject)}).e(69648));
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DataBean implements JsonInterface {
        private static final /* synthetic */ c.b ajc$tjp_0 = null;
        private static final long serialVersionUID = 486193657293398620L;
        public List<DSLBean> DSLList;
        public int card;
        public JsonElement feedbackData;
        public boolean hasMore;
        public transient boolean isCache;
        public String moduleEntityId;
        public String report;
        public int retryItem;
        public transient String traceId;

        static {
            ajc$preClinit();
        }

        private static /* synthetic */ void ajc$preClinit() {
            e eVar = new e("ModuleData.java", DataBean.class);
            ajc$tjp_0 = eVar.H("method-execution", eVar.E("1", "parseTraceId", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean", "com.mgtv.task.http.HttpTraceObject", "traceObject", "", "void"), 77);
        }

        public static final /* synthetic */ void parseTraceId_aroundBody0(DataBean dataBean, HttpTraceObject httpTraceObject, c cVar) {
            b0 b0Var;
            if (httpTraceObject == null || (b0Var = httpTraceObject.finalRequest) == null) {
                return;
            }
            String c = b0Var.c("x-r-i");
            dataBean.traceId = c;
            List<DSLBean> list = dataBean.DSLList;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (DSLBean dSLBean : dataBean.DSLList) {
                dSLBean.traceId = c;
            }
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.moduleEntityId) || j.a(this.DSLList)) ? false : true;
        }

        @WithTryCatchRuntime
        public void parseTraceId(HttpTraceObject httpTraceObject) {
            LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new v(new Object[]{this, httpTraceObject, e.w(ajc$tjp_0, this, this, httpTraceObject)}).e(69648));
        }

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class DSLBean implements JsonInterface {
            private static final /* synthetic */ c.b ajc$tjp_0 = null;
            private static final /* synthetic */ c.b ajc$tjp_1 = null;
            private static final /* synthetic */ c.b ajc$tjp_2 = null;
            private static final long serialVersionUID = 6956543503191078800L;
            public String DSLID;
            public transient int adState;
            public int card;
            public transient int cardFlag;
            public JsonObject data;
            public JsonElement feedbackData;
            public transient Object mTag;
            public transient String moduleEntityId;
            public transient String report;
            public transient String traceId;

            static {
                ajc$preClinit();
            }

            private static /* synthetic */ void ajc$preClinit() {
                e eVar = new e("ModuleData.java", DSLBean.class);
                ajc$tjp_0 = eVar.H("method-execution", eVar.E("1", "parseTraceId", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "com.mgtv.task.http.HttpTraceObject", "traceObject", "", "void"), 179);
                ajc$tjp_1 = eVar.H("method-execution", eVar.E("1", "getItems", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "", "", "", "com.google.gson.JsonArray"), (int) Opcodes.NEW);
                ajc$tjp_2 = eVar.H("method-execution", eVar.E("1", "getItem", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "int", "childIndex", "", "com.google.gson.JsonObject"), (int) Opcodes.IFNULL);
            }

            public static final /* synthetic */ JsonObject getItem_aroundBody4(DSLBean dSLBean, int i, c cVar) {
                JsonObject jsonObject;
                JsonArray asJsonArray;
                if (i >= 0 && (jsonObject = dSLBean.data) != null) {
                    try {
                        JsonElement jsonElement = jsonObject.get("items");
                        if (jsonElement != null && jsonElement.isJsonArray() && (asJsonArray = jsonElement.getAsJsonArray()) != null && asJsonArray.size() > 0 && i < asJsonArray.size()) {
                            JsonElement jsonElement2 = asJsonArray.get(i);
                            if (jsonElement2.isJsonObject()) {
                                return jsonElement2.getAsJsonObject();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            public static final /* synthetic */ JsonArray getItems_aroundBody2(DSLBean dSLBean, c cVar) {
                JsonObject jsonObject = dSLBean.data;
                if (jsonObject != null) {
                    JsonElement jsonElement = jsonObject.get("items");
                    if (jsonElement instanceof JsonArray) {
                        return jsonElement.getAsJsonArray();
                    }
                    return null;
                }
                return null;
            }

            public static final /* synthetic */ void parseTraceId_aroundBody0(DSLBean dSLBean, HttpTraceObject httpTraceObject, c cVar) {
                b0 b0Var;
                if (httpTraceObject == null || (b0Var = httpTraceObject.finalRequest) == null) {
                    return;
                }
                dSLBean.traceId = b0Var.c("x-r-i");
            }

            public void copyTransient(DataBean dataBean) {
                if (dataBean != null) {
                    this.moduleEntityId = dataBean.moduleEntityId;
                    this.traceId = dataBean.traceId;
                    this.report = dataBean.report;
                }
            }

            public long getAid() {
                JsonObject jsonObject = this.data;
                if (jsonObject != null) {
                    JsonElement jsonElement = jsonObject.get("aid");
                    if (jsonElement instanceof JsonPrimitive) {
                        return jsonElement.getAsLong();
                    }
                    return 0L;
                }
                return 0L;
            }

            public String getAidInfo() {
                JsonObject jsonObject = this.data;
                if (jsonObject != null) {
                    JsonElement jsonElement = jsonObject.get("aidInfo");
                    if (jsonElement instanceof JsonPrimitive) {
                        return jsonElement.getAsString();
                    }
                    return null;
                }
                return null;
            }

            @WithTryCatchRuntime
            public JsonObject getItem(int i) {
                return (JsonObject) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new y(new Object[]{this, r.a.c.b.e.k(i), e.w(ajc$tjp_2, this, this, r.a.c.b.e.k(i))}).e(69648));
            }

            @WithTryCatchRuntime
            public JsonArray getItems() {
                return (JsonArray) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new x(new Object[]{this, e.v(ajc$tjp_1, this, this)}).e(69648));
            }

            public boolean isValid() {
                JsonObject jsonObject;
                return (TextUtils.isEmpty(this.DSLID) || (jsonObject = this.data) == null || jsonObject.entrySet().isEmpty()) ? false : true;
            }

            @WithTryCatchRuntime
            public void parseTraceId(HttpTraceObject httpTraceObject) {
                LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new w(new Object[]{this, httpTraceObject, e.w(ajc$tjp_0, this, this, httpTraceObject)}).e(69648));
            }

            public String toString() {
                return "DSLBean{DSLID='" + this.DSLID + "', data=" + this.data + ", card=" + this.card + ", feedbackData=" + this.feedbackData + ", cardFlag=" + this.cardFlag + ", adState=" + this.adState + ", mTag=" + this.mTag + ", traceId='" + this.traceId + "', moduleEntityId='" + this.moduleEntityId + "', report='" + this.report + "'}";
            }

            public void copyTransient(DSLBean dSLBean) {
                if (dSLBean != null) {
                    this.moduleEntityId = dSLBean.moduleEntityId;
                    this.traceId = dSLBean.traceId;
                    this.report = dSLBean.report;
                }
            }
        }
    }
}
