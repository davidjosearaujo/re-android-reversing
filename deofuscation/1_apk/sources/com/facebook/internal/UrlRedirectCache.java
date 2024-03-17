package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.n0;
import r.e.a.d;
import r.e.a.e;

/* compiled from: UrlRedirectCache.kt */
@b0(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/UrlRedirectCache;", "", "()V", "redirectContentTag", "", "tag", "urlRedirectFileLruCache", "Lcom/facebook/internal/FileLruCache;", "cacheUriRedirect", "", "fromUri", "Landroid/net/Uri;", "toUri", "clearCache", "getCache", "getRedirectedUri", ShareConstants.MEDIA_URI, "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class UrlRedirectCache {
    @d
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();
    private static final String redirectContentTag;
    private static final String tag;
    private static FileLruCache urlRedirectFileLruCache;

    static {
        String s = n0.d(UrlRedirectCache.class).s();
        if (s == null) {
            s = "UrlRedirectCache";
        }
        tag = s;
        redirectContentTag = s + "_Redirect";
    }

    private UrlRedirectCache() {
    }

    @k
    public static final void cacheUriRedirect(@e Uri uri, @e Uri uri2) {
        String uri3;
        Charset charset;
        if (uri == null || uri2 == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            try {
                FileLruCache cache = getCache();
                String uri4 = uri.toString();
                f0.o(uri4, "fromUri.toString()");
                outputStream = cache.openPutStream(uri4, redirectContentTag);
                uri3 = uri2.toString();
                f0.o(uri3, "toUri.toString()");
                charset = n.u2.d.a;
            } catch (IOException e) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str = tag;
                companion.log(loggingBehavior, 4, str, "IOException when accessing cache: " + e.getMessage());
            }
            if (uri3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = uri3.getBytes(charset);
            f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        } finally {
            Utility.closeQuietly(null);
        }
    }

    @k
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String str = tag;
            companion.log(loggingBehavior, 5, str, "clearCache failed " + e.getMessage());
        }
    }

    @d
    @k
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            fileLruCache = urlRedirectFileLruCache;
            if (fileLruCache == null) {
                fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
            }
            urlRedirectFileLruCache = fileLruCache;
        }
        return fileLruCache;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0057, code lost:
        if (n.l2.v.f0.g(r3, r11) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0059, code lost:
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x005b, code lost:
        com.facebook.internal.Logger.Companion.log(com.facebook.LoggingBehavior.CACHE, 6, com.facebook.internal.UrlRedirectCache.tag, "A loop detected in UrlRedirectCache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0067, code lost:
        com.facebook.internal.Utility.closeQuietly(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x006a, code lost:
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00b5: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:101:0x00b5 */
    @n.l2.k
    @r.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.net.Uri getRedirectedUri(@r.e.a.e android.net.Uri r11) {
        /*
            r0 = 0
            if (r11 != 0) goto L4
            return r0
        L4:
            java.lang.String r11 = r11.toString()
            java.lang.String r1 = "uri.toString()"
            n.l2.v.f0.o(r11, r1)
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r1.add(r11)
            com.facebook.internal.FileLruCache r2 = getCache()     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L91
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L91
            java.io.InputStream r3 = r2.get(r11, r3)     // Catch: java.lang.Throwable -> L8f java.io.IOException -> L91
            r4 = 0
            r5 = r0
            r6 = 0
        L22:
            if (r3 == 0) goto L81
            r6 = 1
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb4
            r7.<init>(r3)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb4
            r3 = 128(0x80, float:1.794E-43)
            char[] r5 = new char[r3]     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            r8.<init>()     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            int r9 = r7.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
        L37:
            if (r9 <= 0) goto L41
            r8.append(r5, r4, r9)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            int r9 = r7.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            goto L37
        L41:
            com.facebook.internal.Utility.closeQuietly(r7)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.String r3 = r8.toString()     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.String r5 = "urlBuilder.toString()"
            n.l2.v.f0.o(r3, r5)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            boolean r5 = r1.contains(r3)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            if (r5 == 0) goto L6b
            boolean r1 = n.l2.v.f0.g(r3, r11)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            if (r1 == 0) goto L5b
            r5 = r7
            goto L81
        L5b:
            com.facebook.internal.Logger$Companion r11 = com.facebook.internal.Logger.Companion     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            r2 = 6
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.String r4 = "A loop detected in UrlRedirectCache"
            r11.log(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            com.facebook.internal.Utility.closeQuietly(r7)
            return r0
        L6b:
            r1.add(r3)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.lang.String r11 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            java.io.InputStream r11 = r2.get(r3, r11)     // Catch: java.lang.Throwable -> L79 java.io.IOException -> L7c
            r5 = r7
            r10 = r3
            r3 = r11
            r11 = r10
            goto L22
        L79:
            r11 = move-exception
            r0 = r7
            goto Lb6
        L7c:
            r11 = move-exception
            r5 = r7
            goto L93
        L7f:
            r11 = move-exception
            goto L93
        L81:
            if (r6 == 0) goto L8b
            android.net.Uri r11 = android.net.Uri.parse(r11)     // Catch: java.io.IOException -> L7f java.lang.Throwable -> Lb4
            com.facebook.internal.Utility.closeQuietly(r5)
            return r11
        L8b:
            com.facebook.internal.Utility.closeQuietly(r5)
            goto Lb3
        L8f:
            r11 = move-exception
            goto Lb6
        L91:
            r11 = move-exception
            r5 = r0
        L93:
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion     // Catch: java.lang.Throwable -> Lb4
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> Lb4
            r3 = 4
            java.lang.String r4 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> Lb4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb4
            r6.<init>()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r7 = "IOException when accessing cache: "
            r6.append(r7)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r11 = r11.getMessage()     // Catch: java.lang.Throwable -> Lb4
            r6.append(r11)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r11 = r6.toString()     // Catch: java.lang.Throwable -> Lb4
            r1.log(r2, r3, r4, r11)     // Catch: java.lang.Throwable -> Lb4
            goto L8b
        Lb3:
            return r0
        Lb4:
            r11 = move-exception
            r0 = r5
        Lb6:
            com.facebook.internal.Utility.closeQuietly(r0)
            goto Lbb
        Lba:
            throw r11
        Lbb:
            goto Lba
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.getRedirectedUri(android.net.Uri):android.net.Uri");
    }
}
