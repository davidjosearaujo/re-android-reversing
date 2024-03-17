package com.huawei.hms.common.internal;

import com.huawei.hms.utils.StringUtil;
import com.hunantv.media.player.datasource.p2p.MGTVP2pDirectMediaDataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class TransactionIdCreater {
    private static final int API_SIZE = 6;
    private static final int APPID_SIZE = 9;
    private static final char FILL_BYTE = '0';

    public static String getId(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.addByteForNum(str, 9, FILL_BYTE));
        sb.append(StringUtil.addByteForNum(str2, 6, FILL_BYTE));
        Locale locale = Locale.ENGLISH;
        sb.append(new SimpleDateFormat("yyyyMMddHHmmssSSS", locale).format(new Date()));
        sb.append(String.format(locale, "%06d", Integer.valueOf(new Random().nextInt(MGTVP2pDirectMediaDataSource.ERR_P2P_TYPE_BASE_CODE))));
        return sb.toString();
    }
}
