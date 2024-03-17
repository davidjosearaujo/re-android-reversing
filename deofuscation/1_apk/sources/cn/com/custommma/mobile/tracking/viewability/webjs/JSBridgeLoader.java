package cn.com.custommma.mobile.tracking.viewability.webjs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.com.custommma.mobile.tracking.bean.Company;
import cn.com.custommma.mobile.tracking.util.DeviceInfoUtil;
import cn.com.custommma.mobile.tracking.util.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JSBridgeLoader {
    private static final String SHAREDPREFERENCES_BRIDGEJS = "bridgejs";
    private static final String SHAREDPREFERENCES_NAME = "mma.viewabilityjs.bridgejs";
    private String bridgeJs;
    private Context context;
    private boolean isUpdating = false;
    private String jsKey;
    private String jsName;
    private String jsURL;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class HttpURLRequest {
        private static TrustManager[] X509TrustAllManager = {new X509TrustManager() { // from class: cn.com.custommma.mobile.tracking.viewability.webjs.JSBridgeLoader.HttpURLRequest.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};
        private static boolean isUsedHttps;
        private static final boolean usedGzip = false;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class NullHostNameVerifier implements HostnameVerifier {
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        }

        private HttpURLRequest() {
        }

        private static SSLSocketFactory getSSLSocketFactory() {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, X509TrustAllManager, new SecureRandom());
                return sSLContext.getSocketFactory();
            } catch (GeneralSecurityException unused) {
                return null;
            }
        }

        public static byte[] performGet(String str) throws IOException {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            byte[] bArr;
            InputStream inputStream2;
            Logger.d("Attempting Get to " + str + "\n");
            InputStream inputStream3 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    if (isUsedHttps) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(getSSLSocketFactory());
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new NullHostNameVerifier());
                    }
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setReadTimeout(3000);
                    httpURLConnection.setRequestMethod("GET");
                    if (httpURLConnection.getResponseCode() == 200) {
                        String contentEncoding = httpURLConnection.getContentEncoding();
                        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
                            inputStream2 = new GZIPInputStream(httpURLConnection.getInputStream());
                        } else {
                            inputStream2 = httpURLConnection.getInputStream();
                        }
                        try {
                            InputStream inputStream4 = inputStream2;
                            bArr = JSBridgeLoader.writeToArr(inputStream2);
                            inputStream3 = inputStream4;
                        } catch (Throwable th) {
                            inputStream = inputStream2;
                            th = th;
                            try {
                                th.printStackTrace();
                            } finally {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            }
                        }
                    } else {
                        bArr = null;
                    }
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                inputStream = null;
            }
        }
    }

    public JSBridgeLoader(Context context, Company company) {
        this.context = context;
        this.jsURL = company.jsurl;
        this.jsName = company.jsname;
        this.jsKey = "bridgejs_" + company.name;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getJsFromAssets() {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = r5.context     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2e
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2e
            java.lang.String r2 = r5.jsName     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2e
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2e
            if (r1 == 0) goto L1e
            byte[] r2 = writeToArr(r1)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L39
            if (r2 == 0) goto L1e
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L39
            r3.<init>(r2)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L39
            r0 = r3
            goto L1e
        L1c:
            r2 = move-exception
            goto L30
        L1e:
            if (r1 == 0) goto L38
            r1.close()     // Catch: java.io.IOException -> L24
            goto L38
        L24:
            r1 = move-exception
            r1.printStackTrace()
            goto L38
        L29:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L3a
        L2e:
            r2 = move-exception
            r1 = r0
        L30:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L38
            r1.close()     // Catch: java.io.IOException -> L24
        L38:
            return r0
        L39:
            r0 = move-exception
        L3a:
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.io.IOException -> L40
            goto L44
        L40:
            r1 = move-exception
            r1.printStackTrace()
        L44:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.viewability.webjs.JSBridgeLoader.getJsFromAssets():java.lang.String");
    }

    public static byte[] writeToArr(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
                byteArrayOutputStream.close();
            }
            return bArr;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th;
        }
    }

    public void doUpdate() {
        if (this.isUpdating) {
            return;
        }
        if (TextUtils.isEmpty(this.jsURL)) {
            Logger.w("<jsurl> is empty,online updates are unavailable.");
        } else if (DeviceInfoUtil.isNetworkAvailable(this.context)) {
            new Thread(new Runnable() { // from class: cn.com.custommma.mobile.tracking.viewability.webjs.JSBridgeLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    JSBridgeLoader.this.isUpdating = true;
                    try {
                        byte[] performGet = HttpURLRequest.performGet(JSBridgeLoader.this.jsURL);
                        String str = performGet != null ? new String(performGet, "UTF-8") : null;
                        if (!TextUtils.isEmpty(str) && !str.equals(JSBridgeLoader.this.bridgeJs)) {
                            SharedPreferences.Editor edit = JSBridgeLoader.this.context.getSharedPreferences(JSBridgeLoader.SHAREDPREFERENCES_NAME, 0).edit();
                            edit.putString(JSBridgeLoader.this.jsKey, str);
                            edit.apply();
                            if (TextUtils.isEmpty(JSBridgeLoader.this.bridgeJs)) {
                                JSBridgeLoader.this.bridgeJs = str;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    JSBridgeLoader.this.isUpdating = false;
                }
            }).start();
        }
    }

    public String getBridgeJs() {
        if (TextUtils.isEmpty(this.bridgeJs)) {
            try {
                String string = this.context.getSharedPreferences(SHAREDPREFERENCES_NAME, 0).getString(this.jsKey, "");
                this.bridgeJs = string;
                if (TextUtils.isEmpty(string) && !TextUtils.isEmpty(this.jsName)) {
                    this.bridgeJs = getJsFromAssets();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.bridgeJs;
    }
}
