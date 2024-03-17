package cn.com.custommma.mobile.tracking.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.alipay.sdk.util.g;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ConnectUtil {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    private static final int CONNECT_TIMEOUT = 30000;
    private static final int READ_TIMEOUT = 30000;
    private static ConnectUtil instance;
    private static TrustManager[] trustAllManager = {new X509TrustManager() { // from class: cn.com.custommma.mobile.tracking.util.ConnectUtil.1
        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }};

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class NullHostNameVerifier implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        @SuppressLint({"BadHostnameVerifier"})
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface RequestSuccess {
        void completed(String str);
    }

    private ConnectUtil() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new NullHostNameVerifier());
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustAllManager, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }

    private static byte[] eGzip(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Exception unused) {
            gZIPOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception unused2) {
            if (gZIPOutputStream != null) {
                try {
                    gZIPOutputStream.close();
                } catch (IOException unused3) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public static ConnectUtil getInstance() {
        if (instance == null) {
            synchronized (ConnectUtil.class) {
                if (instance == null) {
                    instance = new ConnectUtil();
                }
            }
        }
        return instance;
    }

    public static String requestID(String str) {
        String str2 = "空值";
        try {
            CookieHandler.setDefault(new CookieManager());
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
            Log.d("lincoln", "请求code" + responseCode);
            List<String> list = httpURLConnection.getHeaderFields().get("Set-Cookie");
            for (int i = 0; i < list.size(); i++) {
                String str3 = list.get(i);
                if (str3 != null && str3.contains("a=")) {
                    str2 = str3.split(g.b)[0].split(ContainerUtils.KEY_VALUE_DELIMITER)[1];
                }
            }
            httpURLConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str2;
    }

    private static byte[] writeToArr(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0073, code lost:
        if (r6 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0075, code lost:
        r6.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x009e, code lost:
        if (r6 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00a1, code lost:
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0054 A[Catch: all -> 0x0042, Exception -> 0x0079, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:93:0x003d, B:100:0x0048, B:102:0x0054, B:99:0x0046), top: B:138:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v15, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] performGet(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "@#&=*+-_.,:!?()/~'%"
            java.lang.String r6 = android.net.Uri.encode(r6, r1)     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L95
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L95
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L95
            java.net.URLConnection r6 = r1.openConnection()     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L95
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L95
            r1 = 30000(0x7530, float:4.2039E-41)
            r6.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            r6.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            java.lang.String r1 = "GET"
            r6.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/x-www-form-urlencoded"
            r6.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            int r1 = r6.getResponseCode()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 == r2) goto L39
            r2 = 301(0x12d, float:4.22E-43)
            if (r1 == r2) goto L39
            r2 = 302(0x12e, float:4.23E-43)
            if (r1 != r2) goto L37
            goto L39
        L37:
            r1 = r0
            goto L6c
        L39:
            java.io.InputStream r1 = r6.getInputStream()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L7d
            byte[] r0 = writeToArr(r1)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            goto L48
        L42:
            r0 = move-exception
            goto L88
        L44:
            r1 = r0
        L45:
            r2 = 0
            byte[] r0 = new byte[r2]     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L79
        L48:
            java.lang.String r2 = "Location"
            java.lang.String r2 = r6.getHeaderField(r2)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L79
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L79
            if (r3 != 0) goto L69
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L79
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L79
            java.net.URLConnection r2 = r3.openConnection()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L79
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L79
            r2.getResponseCode()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L67
            r6 = r2
            goto L69
        L64:
            r0 = move-exception
            r6 = r2
            goto L88
        L67:
            r6 = r2
            goto L79
        L69:
            r4 = r1
            r1 = r0
            r0 = r4
        L6c:
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.io.IOException -> L72
            goto L73
        L72:
        L73:
            if (r6 == 0) goto La1
        L75:
            r6.disconnect()
            goto La1
        L79:
            r4 = r1
            r1 = r0
            r0 = r4
            goto L97
        L7d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L88
        L82:
            r1 = r0
            goto L97
        L84:
            r6 = move-exception
            r1 = r0
            r0 = r6
            r6 = r1
        L88:
            if (r1 == 0) goto L8f
            r1.close()     // Catch: java.io.IOException -> L8e
            goto L8f
        L8e:
        L8f:
            if (r6 == 0) goto L94
            r6.disconnect()
        L94:
            throw r0
        L95:
            r6 = r0
            r1 = r6
        L97:
            if (r0 == 0) goto L9e
            r0.close()     // Catch: java.io.IOException -> L9d
            goto L9e
        L9d:
        L9e:
            if (r6 == 0) goto La1
            goto L75
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.util.ConnectUtil.performGet(java.lang.String):byte[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] performPost(java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.util.ConnectUtil.performPost(java.lang.String, java.lang.String, boolean):byte[]");
    }

    public String requestID(Context context, String str, RequestSuccess requestSuccess) {
        String str2 = "unknow";
        try {
            CookieHandler.setDefault(new CookieManager());
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.getResponseCode();
            List<String> list = httpURLConnection.getHeaderFields().get("Set-Cookie");
            for (int i = 0; i < list.size(); i++) {
                String str3 = list.get(i);
                if (str3 != null && str3.contains("a=")) {
                    str2 = str3.split(g.b)[0].split(ContainerUtils.KEY_VALUE_DELIMITER)[1];
                    requestSuccess.completed(str2);
                }
            }
            httpURLConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str2;
    }
}
