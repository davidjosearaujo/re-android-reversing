package com.hunantv.mpdt.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.hunantv.imgo.net.RequestParams;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.n0;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class EventClickData extends CommonData {
    public static final String CL_FACEBOOK_CH = "d1001";
    public static final String CL_WEIXIN_CH = "d1002";
    public static final String POS_CHANNEL_MODULE = "2";
    public static final String POS_CHANNEL_WIDGET = "1";
    public static final String REPORT_SHARE_VALUE_SKIN = "7";
    public static final String SHOW_VALUE_COLUMN = "8";
    public static final String SHOW_VALUE_COLUMN_VIDEO = "9";
    public static final String SHOW_VALUE_GIF = "3";
    public static final String SHOW_VALUE_IMMERSIVE = "10";
    public static final String SHOW_VALUE_LIVE = "4";
    public static final String SHOW_VALUE_PLAYER_COMMEND = "2";
    public static final String SHOW_VALUE_RESULT_CANCELED = "2";
    public static final String SHOW_VALUE_RESULT_FAIL = "1";
    public static final String SHOW_VALUE_RESULT_SUCCESS = "0";
    public static final String SHOW_VALUE_SCREENSHOT = "1";
    public static final String VAL_DLNA_CHANGE_DEVICE = "13";
    public static final String VAL_DLNA_DEVICE = "11";
    public static final String VAL_DLNA_ENTER = "10";
    public static final String VAL_DLNA_LOAD_DEVICE_SUCCESS = "14";
    public static final String VAL_DLNA_RESULT = "12";
    public static final String VAL_EVOCATIVE_PARTNER = "2";
    public static final String VAL_JUMP_TO_DOWNLOAD_PARTNER = "1";
    public static final String VAL_TEST_SHOW = "0";
    public static final String VAL_TEST_SURE = "1";
    private static final long serialVersionUID = -8412022015473054179L;
    private String act;
    private String cpid;
    private String pos;
    private int rtime;
    private String suuid;
    private String value;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public static final String A = "pd";
        public static final String B = "pjr";
        public static final String C = "st";
        public static final String D = "tpo";
        public static final String E = "navsort";
        public static final String F = "my";
        public static final String G = "fantuan";
        public static final String H = "msgc";
        public static final String I = "chicon";
        public static final String J = "appup";
        public static final String K = "skin";
        public static final String L = "liver";
        public static final String M = "columnist";
        public static final String N = "imm";
        public static final String O = "newpush";
        public static final String P = "btclick";
        public static final String Q = "oc";
        public static final String R = "ol";
        public static final String S = "cm";
        public static final String T = "rd";
        public static final String U = "score";
        public static final String V = "mqttpush";
        public static final String W = "upver";
        public static final String X = "vimp";
        public static final String Y = "crech";
        public static final String Z = "opendtpop";
        public static final String a = "test";
        public static final String a0 = "noah";
        public static final String b = "cl";
        public static final String b0 = "so";
        public static final String c = "ms";
        public static final String c0 = "mynew";
        public static final String d = "mc";
        public static final String d0 = "im";
        public static final String e = "ma";
        public static final String e0 = "pfc";
        public static final String f = "air";
        public static final String f0 = "aitab";
        public static final String g = "vl";
        public static final String g0 = "hot";
        public static final String h = "fol";
        public static final String h0 = "pfc";
        public static final String i = "addl";
        public static final String j = "share";
        public static final String k = "shareresult";
        public static final String l = "apppush";
        public static final String m = "appsetpush";
        public static final String n = "wdl";
        public static final String o = "feed";
        public static final String p = "dli";
        public static final String q = "dlc";
        public static final String r = "ins";
        public static final String s = "click";
        public static final String t = "pushalert";
        public static final String u = "huajiao";
        public static final String v = "layer";
        public static final String w = "pfc";
        public static final String x = "playHistory";
        public static final String y = "comment";
        public static final String z = "appdownload";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class a0 {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
        public static final String e = "5";
        public static final String f = "6";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class b {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class b0 {
        public static final String a = "1";
        public static final String b = "2";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class c {
        public static final String a = "1";
        public static final String b = "2";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class c0 {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
        public static final String e = "5";
        public static final String f = "6";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class d {
        public static final String a = "1";
        public static final String b = "7";
        public static final String c = "8";
        public static final String d = "9";
        public static final String e = "16";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class d0 {
        public static final String a = "0";
        public static final String b = "1";
        public static final String c = "2";
        public static final String d = "3";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class e {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
        public static final String e = "5";
        public static final String f = "6";
        public static final String g = "7";
        public static final String h = "10";
        public static final String i = "11";
        public static final String j = "15";
        public static final String k = "9";
        public static final String l = "13";
        public static final String m = "1";
        public static final String n = "2";
        public static final String o = "0";
        public static final String p = "1";
        public static final String q = "2";
        public static final String r = "20";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class e0 {
        public static final String a = "1";
        public static final String b = "2";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class f {
        public static final String a = "1";
        public static final String b = "3";
        public static final String c = "4";
        public static final String d = "5";
        public static final String e = "6";
        public static final String f = "7";
        public static final String g = "8";
        public static final String h = "9";
        public static final String i = "10";
        public static final String j = "11";
        public static final String k = "12";
        public static final String l = "13";
        public static final String m = "14";
        public static final String n = "15";
        public static final String o = "17";
        public static final String p = "18";
        public static final String q = "19";
        public static final String r = "20";
        public static final String s = "21";
        public static final String t = "22";
        public static final String u = "23";
        public static final String v = "24";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class g {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class h {
        public static final String A = "27";
        public static final String B = "28";
        public static final String C = "29";
        public static final String D = "30";
        public static final String E = "31";
        public static final String F = "32";
        public static final String G = "33";
        public static final String H = "34";
        public static final String I = "35";
        public static final String J = "36";
        public static final String K = "37";
        public static final String L = "38";
        public static final String M = "39";
        public static final String N = "40";
        public static final String O = "41";
        public static final String P = "42";
        public static final String Q = "43";
        public static final String R = "44";
        public static final String a = "1";
        public static final String b = "14";
        public static final String c = "2";
        public static final String d = "3";
        public static final String e = "4";
        public static final String f = "22";
        public static final String g = "5";
        public static final String h = "6";
        public static final String i = "7";
        public static final String j = "8";
        public static final String k = "9";
        public static final String l = "10";
        public static final String m = "11";
        public static final String n = "12";
        public static final String o = "13";
        public static final String p = "14";
        public static final String q = "15";
        public static final String r = "16";
        public static final String s = "17";
        public static final String t = "18";
        public static final String u = "19";
        public static final String v = "20";
        public static final String w = "21";
        public static final String x = "23";
        public static final String y = "25";
        public static final String z = "26";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class i {
        public static final String A = "27";
        public static final String A0 = "105";
        public static final String B = "28";
        public static final String B0 = "106";
        public static final String C = "29";
        public static final String C0 = "107";
        public static final String D = "30";
        public static final String D0 = "108";
        public static final String E = "31";
        public static final String E0 = "109";
        public static final String F = "32";
        public static final String F0 = "110";
        public static final String G = "33";
        public static final String G0 = "111";
        public static final String H = "34";
        public static final String H0 = "112";
        public static final String I = "35";
        public static final String I0 = "113";
        public static final String J = "36";
        public static final String J0 = "114";
        public static final String K = "37";
        public static final String K0 = "115";
        public static final String L = "38";
        public static final String L0 = "116";
        public static final String M = "39";
        public static final String M0 = "117";
        public static final String N = "40";
        public static final String N0 = "118";
        public static final String O = "41";
        public static final String O0 = "119";
        public static final String P = "42";
        public static final String P0 = "120";
        public static final String Q = "43";
        public static final String Q0 = "121";
        public static final String R = "44";
        public static final String R0 = "124";
        public static final String S = "45";
        public static final String S0 = "122";
        public static final String T = "46";
        public static final String T0 = "123";
        public static final String U = "47";
        public static final String U0 = "125";
        public static final String V = "48";
        public static final String V0 = "126";
        public static final String W = "62";
        public static final String W0 = "127";
        public static final String X = "63";
        public static final String X0 = "128";
        public static final String Y = "64";
        public static final String Y0 = "129";
        public static final String Z = "65";
        public static final String Z0 = "130";
        public static final String a = "1";
        public static final String a0 = "66";
        public static final String a1 = "131";
        public static final String b = "2";
        public static final String b0 = "67";
        public static final String b1 = "133";
        public static final String c = "3";
        public static final String c0 = "68";
        public static final String c1 = "135";
        public static final String d = "4";
        public static final String d0 = "80";
        public static final String d1 = "137";
        public static final String e = "5";
        public static final String e0 = "81";
        public static final String e1 = "138";
        public static final String f = "6";
        public static final String f0 = "82";
        public static final String f1 = "147";
        public static final String g = "7";
        public static final String g0 = "83";
        public static final String h = "8";
        public static final String h0 = "84";
        public static final String i = "9";
        public static final String i0 = "85";
        public static final String j = "10";
        public static final String j0 = "86";
        public static final String k = "11";
        public static final String k0 = "88";
        public static final String l = "12";
        public static final String l0 = "89";
        public static final String m = "13";
        public static final String m0 = "90";
        public static final String n = "14";
        public static final String n0 = "91";
        public static final String o = "15";
        public static final String o0 = "93";
        public static final String p = "16";
        public static final String p0 = "94";
        public static final String q = "17";
        public static final String q0 = "95";
        public static final String r = "18";
        public static final String r0 = "96";
        public static final String s = "19";
        public static final String s0 = "97";
        public static final String t = "20";
        public static final String t0 = "98";
        public static final String u = "21";
        public static final String u0 = "99";
        public static final String v = "22";
        public static final String v0 = "100";
        public static final String w = "23";
        public static final String w0 = "101";
        public static final String x = "24";
        public static final String x0 = "102";
        public static final String y = "25";
        public static final String y0 = "103";
        public static final String z = "26";
        public static final String z0 = "104";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class j {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
        public static final String e = "5";
        public static final String f = "6";
        public static final String g = "7";
        public static final String h = "8";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class k {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class l {
        public static final String A = "169";
        public static final String B = "170";
        public static final String C = "177";
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
        public static final String e = "5";
        public static final String f = "6";
        public static final String g = "7";
        public static final String h = "8";
        public static final String i = "10";
        public static final String j = "12";
        public static final String k = "13";
        public static final String l = "14";
        public static final String m = "17";
        public static final String n = "18";
        public static final String o = "19";
        public static final String p = "20";
        public static final String q = "121";
        public static final String r = "10";
        public static final String s = "21";
        public static final String t = "16";
        public static final String u = "22";
        public static final String v = "37";
        public static final String w = "38";
        public static final String x = "44";
        public static final String y = "159";
        public static final String z = "160";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class m {
        public static final String a = "2";
        public static final String b = "3";
        public static final String c = "4";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class n {
        public static final String A = "27";
        public static final String B = "28";
        public static final String C = "29";
        public static final String D = "30";
        public static final String E = "31";
        public static final String F = "32";
        public static final String G = "33";
        public static final String H = "34";
        public static final String I = "35";
        public static final String J = "36";
        public static final String K = "37";
        public static final String L = "38";
        public static final String M = "39";
        public static final String N = "40";
        public static final String O = "41";
        public static final String P = "42";
        public static final String Q = "43";
        public static final String R = "44";
        public static final String S = "45";
        public static final String T = "46";
        public static final String U = "47";
        public static final String V = "48";
        public static final String W = "49";
        public static final String X = "50";
        public static final String Y = "51";
        public static final String Z = "52";
        public static final String a = "1";
        public static final String a0 = "53";
        public static final String b = "2";
        public static final String b0 = "54";
        public static final String c = "3";
        public static final String c0 = "55";
        public static final String d = "4";
        public static final String d0 = "56";
        public static final String e = "5";
        public static final String e0 = "57";
        public static final String f = "6";
        public static final String f0 = "58";
        public static final String g = "7";
        public static final String g0 = "59";
        public static final String h = "8";
        public static final String h0 = "60";
        public static final String i = "9";
        public static final String i0 = "61";
        public static final String j = "10";
        public static final String j0 = "63";
        public static final String k = "11";
        public static final String l = "12";
        public static final String m = "13";
        public static final String n = "14";
        public static final String o = "15";
        public static final String p = "16";
        public static final String q = "17";
        public static final String r = "18";
        public static final String s = "19";
        public static final String t = "20";
        public static final String u = "21";
        public static final String v = "22";
        public static final String w = "23";
        public static final String x = "24";
        public static final String y = "25";
        public static final String z = "26";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class o {
        public static final String A = "48";
        public static final String B = "58";
        public static final String C = "59";
        public static final String D = "148";
        public static final String E = "149";
        public static final String F = "150";
        public static final String a = "47";
        public static final String b = "50";
        public static final String c = "49";
        public static final String d = "51";
        public static final String e = "36";
        public static final String f = "35";
        public static final String g = "52";
        public static final String h = "53";
        public static final String i = "54";
        public static final String j = "55";
        public static final String k = "56";
        public static final String l = "132";
        public static final String m = "5";
        public static final String n = "9";
        public static final String o = "61";
        public static final String p = "13";
        public static final String q = "12";
        public static final String r = "11";
        public static final String s = "10";
        public static final String t = "6";
        public static final String u = "7";
        public static final String v = "60";
        public static final String w = "8";
        public static final String x = "25";
        public static final String y = "57";
        public static final String z = "47";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class p {
        public static final String a = "2";
        public static final String b = "3";
        public static final String c = "4";
        public static final String d = "8";
        public static final String e = "9";
        public static final String f = "7";
        public static final String g = "5";
        public static final String h = "6";
        public static final String i = "10";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class q {
        public static final String a = "147";
        public static final String b = "148";
        public static final String c = "149";
        public static final String d = "150";
        public static final String e = "151";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class r {
        public static final String a = "10";
        public static final String b = "11";
        public static final String c = "12";
        public static final String d = "13";
        public static final String e = "14";
        public static final String f = "15";
        public static final String g = "16";
        public static final String h = "17";
        public static final String i = "18";
        public static final String j = "19";
        public static final String k = "20";
        public static final String l = "21";
        public static final String m = "22";
        public static final String n = "23";
        public static final String o = "32";
        public static final String p = "33";
        public static final String q = "34";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class s {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class t {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
        public static final String e = "5";
        public static final String f = "6";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class u {
        public static final int A = 27;
        public static final int A0 = 90;
        public static final int A1 = 154;
        public static final int B = 28;
        public static final int B0 = 91;
        public static final int B1 = 155;
        public static final int C = 29;
        public static final int C0 = 99;
        public static final int C1 = 156;
        public static final int D = 30;
        public static final int D0 = 100;
        public static final int D1 = 168;
        public static final int E = 31;
        public static final int E0 = 101;
        public static final int E1 = 171;
        public static final int F = 32;
        public static final int F0 = 102;
        public static final int F1 = 172;
        public static final int G = 33;
        public static final int G0 = 103;
        public static final int G1 = 173;
        public static final int H = 40;
        public static final int H0 = 104;
        public static final int H1 = 174;
        public static final int I = 41;
        public static final int I0 = 137;
        public static final int I1 = 175;
        public static final int J = 42;
        public static final int J0 = 138;
        public static final int J1 = 176;
        public static final int K = 43;
        public static final int K0 = 139;
        public static final int L = 44;
        public static final int L0 = 140;
        public static final int M = 45;
        public static final int M0 = 141;
        public static final int N = 46;
        public static final int N0 = 142;
        public static final int O = 47;
        public static final int O0 = 143;
        public static final int P = 48;
        public static final int P0 = 144;
        public static final int Q = 49;
        public static final int Q0 = 145;
        public static final int R = 51;
        public static final int R0 = 123;
        public static final int S = 52;
        public static final int S0 = 124;
        public static final int T = 53;
        public static final int T0 = 125;
        public static final int U = 54;
        public static final int U0 = 126;
        public static final int V = 55;
        public static final int V0 = 105;
        public static final int W = 56;
        public static final int W0 = 106;
        public static final int X = 57;
        public static final int X0 = 107;
        public static final int Y = 58;
        public static final int Y0 = 108;
        public static final int Z = 59;
        public static final int Z0 = 109;
        public static final int a = 1;
        public static final int a0 = 60;
        public static final int a1 = 110;
        public static final int b = 2;
        public static final int b0 = 61;
        public static final int b1 = 111;
        public static final int c = 3;
        public static final int c0 = 62;
        public static final int c1 = 113;
        public static final int d = 4;
        public static final int d0 = 63;
        public static final int d1 = 114;
        public static final int e = 5;
        public static final int e0 = 64;
        public static final int e1 = 119;
        public static final int f = 6;
        public static final int f0 = 65;
        public static final int f1 = 120;
        public static final int g = 7;
        public static final int g0 = 66;
        public static final String g1 = "121";
        public static final int h = 8;
        public static final int h0 = 67;
        public static final int h1 = 115;
        public static final int i = 9;
        public static final int i0 = 68;
        public static final int i1 = 116;
        public static final int j = 10;
        public static final int j0 = 69;
        public static final int j1 = 117;
        public static final int k = 11;
        public static final int k0 = 73;
        public static final int k1 = 127;
        public static final int l = 12;
        public static final int l0 = 74;
        public static final int l1 = 128;
        public static final int m = 13;
        public static final int m0 = 75;
        public static final int m1 = 129;
        public static final int n = 14;
        public static final int n0 = 76;
        public static final int n1 = 130;
        public static final int o = 15;
        public static final int o0 = 77;
        public static final int o1 = 153;
        public static final int p = 16;
        public static final int p0 = 79;
        public static final int p1 = 157;
        public static final int q = 17;
        public static final int q0 = 80;
        public static final int q1 = 133;
        public static final int r = 18;
        public static final int r0 = 81;
        public static final int r1 = 134;
        public static final int s = 19;
        public static final int s0 = 82;
        public static final int s1 = 135;
        public static final int t = 20;
        public static final int t0 = 83;
        public static final int t1 = 136;
        public static final int u = 21;
        public static final int u0 = 84;
        public static final int u1 = 146;
        public static final int v = 22;
        public static final int v0 = 85;
        public static final int v1 = 122;
        public static final int w = 23;
        public static final int w0 = 86;
        public static final int w1 = 123;
        public static final int x = 24;
        public static final int x0 = 87;
        public static final int x1 = 124;
        public static final int y = 25;
        public static final int y0 = 88;
        public static final int y1 = 125;
        public static final int z = 26;
        public static final int z0 = 89;
        public static final int z1 = 152;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class v {
        public static final String a = "5";
        public static final String b = "6";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class w {
        public static final String a = "widgetsearch";
        public static final String b = "widgetdl";
        public static final String c = "widgetdlc";
        public static final String d = "msgpush";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class x {
        public static final String a = "0";
        public static final String b = "1";
        public static final String c = "2";
        public static final String d = "3";
        public static final String e = "4";
        public static final String f = "5";
        public static final String g = "6";
        public static final String h = "7";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class y {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
        public static final String e = "5";
        public static final String f = "6";
        public static final String g = "9";
        public static final String h = "11";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class z {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
        public static final String e = "5";
        public static final String f = "6";
        public static final String g = "7";
        public static final String h = "8";
        public static final String i = "9";
        public static final String j = "10";
        public static final String k = "11";
        public static final String l = "12";
        public static final String m = "13";
        public static final String n = "16";
        public static final String o = "17";
        public static final String p = "18";
        public static final String q = "20";
        public static final String r = "21";
        public static final String s = "22";
    }

    public EventClickData() {
    }

    @NonNull
    public static String convertMapToEncodeString(HashMap<String, String> hashMap) {
        try {
            return URLEncoder.encode(convertMapToString(hashMap), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @NonNull
    public static String convertMapToString(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
            sb.append("&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, StandardCharsets.UTF_8.name());
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    @NonNull
    public static String toJsonString(@Nullable JsonInterface jsonInterface, @Nullable Type type) {
        if (jsonInterface == null || type == null) {
            return "";
        }
        String str = null;
        try {
            str = URLEncoder.encode(j.v.j.b.e(jsonInterface, type), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str == null ? "" : str;
    }

    @NonNull
    public RequestParams createRequestParams() {
        RequestParams createBaseRequestParams = createBaseRequestParams();
        createBaseRequestParams.put("act", this.act);
        createBaseRequestParams.put("pos", this.pos);
        createBaseRequestParams.put(SDKConstants.PARAM_VALUE, n0.D(this.value));
        return createBaseRequestParams;
    }

    public String getAct() {
        return this.act;
    }

    public String getCpid() {
        return this.cpid;
    }

    public String getPos() {
        return this.pos;
    }

    public int getRtime() {
        return this.rtime;
    }

    public String getSuuid() {
        return this.suuid;
    }

    public String getValue() {
        return this.value;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setCpid(String str) {
        this.cpid = str;
    }

    public void setPos(String str) {
        this.pos = str;
    }

    public void setRtime(int i2) {
        this.rtime = i2;
    }

    public void setSuuid(String str) {
        this.suuid = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public EventClickData(String str, String str2) {
        this("", str, "0", str2);
    }

    public EventClickData(String str, String str2, String str3) {
        this();
        this.act = str;
        this.pos = str2;
        this.value = str3;
    }

    public EventClickData(String str, String str2, String str3, String str4) {
        this();
        this.suuid = str;
        this.act = str2;
        this.pos = str3;
        this.value = str4;
    }
}
