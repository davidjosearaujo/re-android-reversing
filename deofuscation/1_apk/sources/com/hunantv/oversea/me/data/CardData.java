package com.hunantv.oversea.me.data;

import android.text.TextUtils;
import com.mgtv.json.JsonInterface;
import java.io.Serializable;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CardData implements Serializable, JsonInterface {
    private static final long serialVersionUID = 2042862781382067501L;
    public CardListDataBean data;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class CardDataBean implements Serializable, JsonInterface {
        private static final long serialVersionUID = -2052823556013973335L;
        public boolean isCheckSync = false;
        public List<CardModuleData> moduleData;
        public String moduleId;
        public String moduleName;
        public String moduleTitle;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class CardListDataBean implements Serializable, JsonInterface {
        private static final long serialVersionUID = 5957632393019733029L;
        public List<CardDataBean> list;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class CardModuleData implements Serializable, JsonInterface {
        private static final long serialVersionUID = -471897078512988669L;
        public String canDel;
        public List<ChildData> child;
        public String childId;
        public String image;
        public String isMore;
        public String isPoint;
        public String itemId;
        public String jumpId;
        public String jumpKind;
        public String name;
        public String pageUrl;
        public String subName;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class ChildData implements Serializable, JsonInterface {
            private static final long serialVersionUID = 1435574469886893628L;
            public List<String> click_report_urls;
            public String img;
            public String jump_url;
            public String pop_title;
            public List<String> show_report_urls;
            public String sub_style;
            public String sub_title;
            public String title;
            public String title_img;
        }

        public boolean canDel() {
            return TextUtils.equals(this.canDel, "1");
        }

        public void copyData(CardModuleData cardModuleData) {
            if (cardModuleData == null) {
                return;
            }
            this.itemId = cardModuleData.itemId;
            this.jumpKind = cardModuleData.jumpKind;
            this.image = cardModuleData.image;
            this.jumpId = cardModuleData.jumpId;
            this.childId = cardModuleData.childId;
            this.name = cardModuleData.name;
            this.subName = cardModuleData.subName;
            this.pageUrl = cardModuleData.pageUrl;
            this.isPoint = cardModuleData.isPoint;
            this.isMore = cardModuleData.isMore;
            this.canDel = cardModuleData.canDel;
            this.child = cardModuleData.child;
        }

        public boolean isMore() {
            return TextUtils.equals(this.isMore, "1");
        }

        public boolean isShowPoint() {
            return TextUtils.equals(this.isPoint, "1");
        }

        public void setIsMore(String str) {
            this.isMore = str;
        }
    }
}
