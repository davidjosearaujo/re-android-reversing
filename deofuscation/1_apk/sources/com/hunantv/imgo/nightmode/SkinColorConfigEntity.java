package com.hunantv.imgo.nightmode;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SkinColorConfigEntity implements Serializable {
    private static final int COLOR_LENGTH_ALPHA = 9;
    private static final int COLOR_LENGTH_ORIGIN = 7;
    private static final long serialVersionUID = 9087510808971257374L;
    public String ChannelNameNormal;
    public String ChannelNameSeleted;
    public String MyIntegralColor;
    public String MyIntegralbackground;
    public String MyNameColor;
    public String MySignInButtonBg;
    public String MySignInButtonFonts;
    public String MySweepiCON;
    public String NavigationBarFantuanLiveiCON;
    public String NavigationBarFantuanSearchBg;
    public String NavigationBarFantuanSearchFonts;
    public String NavigationBarLibrariesMask;
    public String NavigationBarToolsiCON;
    public String NavigationBarVipButtonBG;
    public String NavigationBarVipButtonFonts;
    public String SearchButtonBackGround;
    public String SearchButtoniCON;
    public String SearchInputBackGround;
    public String SearchInputFonts;
    public int SysteamStatusBarFonts;

    public static String getAlphaColor(String str) {
        return TextUtils.isEmpty(str) ? "" : str.length() == 7 ? str.replace("#", "#B3") : str;
    }
}
