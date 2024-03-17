package com.hunantv.media.utils;

import com.hunantv.media.player.pragma.DebugLog;
import java.io.File;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LocalHelper {
    private static final String TAG = "LocalHelper";

    /* renamed from: com.hunantv.media.utils.LocalHelper$1  reason: invalid class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$hunantv$media$utils$LocalHelper$MediaType;

        static {
            int[] iArr = new int[MediaType.values().length];
            $SwitchMap$com$hunantv$media$utils$LocalHelper$MediaType = iArr;
            try {
                iArr[MediaType.MP4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hunantv$media$utils$LocalHelper$MediaType[MediaType.HLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum MediaType {
        MP4,
        HLS
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
        if (r6 != false) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean checkHLS(java.io.File r6) {
        /*
            long r0 = r6.length()
            r2 = 0
            r3 = 25
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
            return r2
        Lc:
            r0 = 200(0xc8, float:2.8E-43)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6b
            r3.<init>(r6)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L6b
            r6 = 0
        L17:
            int r1 = 200 - r6
            if (r1 <= 0) goto L28
            int r1 = r3.read(r0, r6, r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            if (r1 < 0) goto L28
            int r6 = r6 + r1
            goto L17
        L23:
            r6 = move-exception
            r1 = r3
            goto L6c
        L26:
            r6 = move-exception
            goto L60
        L28:
            r1 = 25
            if (r6 >= r1) goto L30
            c.a.a.b.d.e.a(r3)
            return r2
        L30:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            r1.<init>(r0, r2, r6)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            boolean r6 = com.hunantv.media.player.utils.StringUtil.isEmpty(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            if (r6 != 0) goto L67
            java.lang.String r6 = "#EXTM3U"
            boolean r6 = r1.contains(r6)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            if (r6 == 0) goto L67
            java.lang.String r6 = "#EXT-X-STREAM-INF:"
            boolean r6 = r1.contains(r6)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            if (r6 != 0) goto L5b
            java.lang.String r6 = "#EXT-X-TARGETDURATION:"
            boolean r6 = r1.contains(r6)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            if (r6 != 0) goto L5b
            java.lang.String r6 = "#EXT-X-MEDIA-SEQUENCE:"
            boolean r6 = r1.contains(r6)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L26
            if (r6 == 0) goto L67
        L5b:
            c.a.a.b.d.e.a(r3)
            r6 = 1
            return r6
        L60:
            r1 = r3
            goto L63
        L62:
            r6 = move-exception
        L63:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L6b
            r3 = r1
        L67:
            c.a.a.b.d.e.a(r3)
            return r2
        L6b:
            r6 = move-exception
        L6c:
            c.a.a.b.d.e.a(r1)
            goto L71
        L70:
            throw r6
        L71:
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.utils.LocalHelper.checkHLS(java.io.File):boolean");
    }

    private static boolean checkMP4(File file) {
        return file.length() > 8;
    }

    private static String filterLocalProtocol(String str) {
        try {
            if (str.startsWith("file:")) {
                int i = 5;
                while (i < str.length() && str.charAt(i) == '/') {
                    i++;
                }
                return str.substring(i - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static boolean validLocalPath(String str, MediaType mediaType) {
        boolean validLocalPathImpl = validLocalPathImpl(str, mediaType);
        String str2 = TAG;
        DebugLog.i(str2, "validLocalPath: " + validLocalPathImpl);
        return validLocalPathImpl;
    }

    private static boolean validLocalPathImpl(String str, MediaType mediaType) {
        if (com.hunantv.media.player.utils.StringUtil.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(filterLocalProtocol(str));
            if (file.exists() && !file.isDirectory()) {
                int i = AnonymousClass1.$SwitchMap$com$hunantv$media$utils$LocalHelper$MediaType[mediaType.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    return checkHLS(file);
                }
                return checkMP4(file);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
