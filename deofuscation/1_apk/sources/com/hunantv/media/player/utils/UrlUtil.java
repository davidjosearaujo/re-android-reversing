package com.hunantv.media.player.utils;

import android.net.Uri;
import cn.jpush.android.local.JPushConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.huawei.hms.framework.common.ContainerUtils;
import com.hunantv.imgo.entity.JumpAction;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class UrlUtil {
    public static final String STR_FILE = "file";

    public static String addLocalPrefix(String str) {
        if (str == null || isFilePrefix(str)) {
            return str;
        }
        return "file://" + str;
    }

    public static String[] addLocalPrefix(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        int i = 0;
        for (String str : strArr) {
            strArr2[i] = addLocalPrefix(str);
            i++;
        }
        return strArr2;
    }

    public static boolean existParams(String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.indexOf(JumpAction.STR_ACTION_SPLIT) > 0;
    }

    public static String fromUtf8Bytes(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static String getFileName(String str) {
        Uri parse;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!StringUtil.isEmpty(str) && (parse = Uri.parse(str)) != null && parse.getPath() != null) {
            String[] split = parse.getPath().split("/");
            if (split.length >= 1) {
                return split[split.length - 1];
            }
            return null;
        }
        return null;
    }

    public static String getHostName(String str) {
        try {
            if (StringUtil.isEmpty(str)) {
                return null;
            }
            return Uri.parse(str).getHost();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getProtocol(String str) {
        try {
            if (!StringUtil.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                if (parse.getScheme() != null) {
                    return parse.getScheme();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "file";
    }

    public static String getSuffix(String str) {
        if (str == null) {
            return null;
        }
        try {
            Locale locale = Locale.US;
            String path = Uri.parse(str.toLowerCase(locale)).getPath();
            int lastIndexOf = path.lastIndexOf(Consts.DOT);
            if (lastIndexOf != -1) {
                return path.substring(lastIndexOf + 1).toLowerCase(locale);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUrlParamsValue(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            String str3 = "&" + str2 + ContainerUtils.KEY_VALUE_DELIMITER;
            try {
                int indexOf = str.indexOf(str3);
                if (indexOf >= 0) {
                    String substring = str.substring(indexOf + str3.length());
                    if (StringUtil.isEmpty(substring)) {
                        return null;
                    }
                    int indexOf2 = substring.indexOf("&");
                    return indexOf2 >= 0 ? substring.substring(0, indexOf2) : substring;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getValidHttpUrl(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(JPushConstants.HTTP_PRE);
        if (indexOf == -1 && (indexOf = str.indexOf(JPushConstants.HTTPS_PRE)) == -1) {
            return null;
        }
        return str.substring(indexOf);
    }

    public static String getValidUrl(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(JPushConstants.HTTP_PRE);
        return (indexOf == -1 && (indexOf = str.indexOf(JPushConstants.HTTPS_PRE)) == -1) ? str : str.substring(indexOf);
    }

    public static boolean isFilePrefix(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("file://");
    }

    public static boolean isLocal(String str) {
        return str != null && "file".equalsIgnoreCase(getProtocol(str));
    }

    public static boolean isM3u8(String str) {
        return isSuffixUrl(str, ".m3u8") || isSuffixUrl(str, ".m3u");
    }

    public static boolean isSegment(String str) {
        return isSuffixUrl(str, ".ts") || isSuffixUrl(str, ".m4s") || isSuffixUrl(str, ".mp4");
    }

    public static boolean isSuffixUrl(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                Locale locale = Locale.US;
                Uri parse = Uri.parse(str.toLowerCase(locale));
                if (StringUtil.isEmpty(parse.getPath())) {
                    return false;
                }
                return parse.getPath().endsWith(str2.toLowerCase(locale));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String urlEncode(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
