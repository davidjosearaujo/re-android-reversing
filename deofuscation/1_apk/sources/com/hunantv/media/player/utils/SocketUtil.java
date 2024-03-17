package com.hunantv.media.player.utils;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SocketUtil {
    public static String getAddress(String str) {
        try {
            return getAddressThrowable(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAddress(URL url) {
        if (url == null) {
            return null;
        }
        try {
            return getAddress(url.getHost());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getAddressThrowable(String str) throws UnknownHostException, SecurityException, InvalidParameterException {
        if (str == null || str.trim().equals("")) {
            throw new InvalidParameterException("getAddressThrowable domainName invalid");
        }
        InetAddress byName = InetAddress.getByName(str);
        if (byName != null) {
            return byName.getHostAddress();
        }
        return null;
    }

    public static String[] getAllAddressThrowable(String str) throws UnknownHostException, SecurityException, InvalidParameterException {
        if (str == null || str.trim().equals("")) {
            throw new InvalidParameterException("getAddressThrowable domainName invalid");
        }
        InetAddress[] allByName = InetAddress.getAllByName(str);
        int length = allByName.length;
        if (length > 0) {
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = allByName[i].getHostAddress();
            }
            return strArr;
        }
        return null;
    }
}
