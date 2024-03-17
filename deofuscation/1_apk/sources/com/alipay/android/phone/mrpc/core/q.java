package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.facebook.internal.ServerProtocol;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class q implements Callable<u> {
    public static final HttpRequestRetryHandler e = new ad();
    public l a;
    public Context b;
    public o c;
    public String d;
    public HttpUriRequest f;
    public CookieManager i;
    public AbstractHttpEntity j;
    public HttpHost k;
    public URL l;
    public String q;
    public HttpContext g = new BasicHttpContext();
    public CookieStore h = new BasicCookieStore();
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public String p = null;

    public q(l lVar, o oVar) {
        this.a = lVar;
        this.b = lVar.a;
        this.c = oVar;
    }

    public static long a(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if ("max-age".equalsIgnoreCase(strArr[i])) {
                int i2 = i + 1;
                if (strArr[i2] != null) {
                    try {
                        return Long.parseLong(strArr[i2]);
                    } catch (Exception unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return 0L;
    }

    public static HttpUrlHeader a(HttpResponse httpResponse) {
        Header[] allHeaders;
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    private u a(HttpResponse httpResponse, int i, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        new StringBuilder("开始handle，handleResponse-1,").append(Thread.currentThread().getId());
        HttpEntity entity = httpResponse.getEntity();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        String str3 = null;
        if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
            if (entity == null) {
                httpResponse.getStatusLine().getStatusCode();
                return null;
            }
            return null;
        }
        new StringBuilder("200，开始处理，handleResponse-2,threadid = ").append(Thread.currentThread().getId());
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(entity, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.o = false;
            this.a.c(System.currentTimeMillis() - currentTimeMillis);
            this.a.a(byteArray.length);
            new StringBuilder("res:").append(byteArray.length);
            p pVar = new p(a(httpResponse), i, str, byteArray);
            long b = b(httpResponse);
            Header contentType = httpResponse.getEntity().getContentType();
            if (contentType != null) {
                HashMap<String, String> a = a(contentType.getValue());
                str3 = a.get("charset");
                str2 = a.get("Content-Type");
            } else {
                str2 = null;
            }
            pVar.b(str2);
            pVar.a(str3);
            pVar.a(System.currentTimeMillis());
            pVar.b(b);
            try {
                byteArrayOutputStream.close();
                return pVar;
            } catch (IOException e2) {
                throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e3) {
                    throw new RuntimeException("ArrayOutputStream close error!", e3.getCause());
                }
            }
            throw th;
        }
    }

    public static HashMap<String, String> a(String str) {
        String[] split;
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(com.alipay.sdk.util.g.b)) {
            String[] split2 = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            hashMap.put(split2[0], split2[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a = b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = a.read(bArr);
                    if (read == -1 || this.c.h()) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    this.c.f();
                }
                outputStream.flush();
            } catch (Exception e2) {
                e2.getCause();
                throw new IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
            }
        } finally {
            r.a(a);
        }
    }

    public static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0L;
    }

    private URI b() {
        String a = this.c.a();
        String str = this.d;
        if (str != null) {
            a = str;
        }
        if (a != null) {
            return new URI(a);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.j == null) {
            byte[] b = this.c.b();
            String b2 = this.c.b("gzip");
            if (b != null) {
                if (TextUtils.equals(b2, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                    this.j = b.a(b);
                } else {
                    this.j = new ByteArrayEntity(b);
                }
                this.j.setContentType(this.c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f = httpPost;
        } else {
            this.f = new HttpGet(b());
        }
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:246:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0107 A[Catch: Exception -> 0x0260, NullPointerException -> 0x0282, IOException -> 0x02a6, UnknownHostException -> 0x02d0, HttpHostConnectException -> 0x02fc, NoHttpResponseException -> 0x0320, SocketTimeoutException -> 0x034b, ConnectTimeoutException -> 0x0376, ConnectionPoolTimeoutException -> 0x03a0, SSLException -> 0x03ca, SSLPeerUnverifiedException -> 0x03f4, SSLHandshakeException -> 0x041e, URISyntaxException -> 0x0448, HttpException -> 0x0455, TryCatch #3 {HttpException -> 0x0455, SocketTimeoutException -> 0x034b, IOException -> 0x02a6, NoHttpResponseException -> 0x0320, NullPointerException -> 0x0282, URISyntaxException -> 0x0448, UnknownHostException -> 0x02d0, SSLException -> 0x03ca, HttpHostConnectException -> 0x02fc, SSLHandshakeException -> 0x041e, Exception -> 0x0260, ConnectionPoolTimeoutException -> 0x03a0, SSLPeerUnverifiedException -> 0x03f4, ConnectTimeoutException -> 0x0376, blocks: (B:201:0x0006, B:215:0x0032, B:217:0x003a, B:219:0x0040, B:220:0x0044, B:222:0x004a, B:223:0x0058, B:225:0x006c, B:227:0x0081, B:229:0x00c1, B:231:0x00d0, B:233:0x00d6, B:235:0x00e0, B:238:0x00e9, B:240:0x00f5, B:244:0x00ff, B:248:0x011f, B:250:0x0127, B:251:0x0134, B:253:0x015a, B:254:0x0161, B:256:0x0167, B:257:0x016b, B:259:0x0171, B:261:0x017d, B:265:0x01ac, B:266:0x01c8, B:274:0x01e5, B:275:0x01fe, B:276:0x01ff, B:278:0x0207, B:280:0x020d, B:284:0x0219, B:286:0x021d, B:288:0x022d, B:290:0x0235, B:292:0x023f, B:247:0x0107, B:294:0x0254, B:295:0x025f, B:204:0x0017, B:206:0x001b, B:208:0x001f, B:210:0x0025, B:213:0x002d), top: B:381:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0127 A[Catch: Exception -> 0x0260, NullPointerException -> 0x0282, IOException -> 0x02a6, UnknownHostException -> 0x02d0, HttpHostConnectException -> 0x02fc, NoHttpResponseException -> 0x0320, SocketTimeoutException -> 0x034b, ConnectTimeoutException -> 0x0376, ConnectionPoolTimeoutException -> 0x03a0, SSLException -> 0x03ca, SSLPeerUnverifiedException -> 0x03f4, SSLHandshakeException -> 0x041e, URISyntaxException -> 0x0448, HttpException -> 0x0455, TryCatch #3 {HttpException -> 0x0455, SocketTimeoutException -> 0x034b, IOException -> 0x02a6, NoHttpResponseException -> 0x0320, NullPointerException -> 0x0282, URISyntaxException -> 0x0448, UnknownHostException -> 0x02d0, SSLException -> 0x03ca, HttpHostConnectException -> 0x02fc, SSLHandshakeException -> 0x041e, Exception -> 0x0260, ConnectionPoolTimeoutException -> 0x03a0, SSLPeerUnverifiedException -> 0x03f4, ConnectTimeoutException -> 0x0376, blocks: (B:201:0x0006, B:215:0x0032, B:217:0x003a, B:219:0x0040, B:220:0x0044, B:222:0x004a, B:223:0x0058, B:225:0x006c, B:227:0x0081, B:229:0x00c1, B:231:0x00d0, B:233:0x00d6, B:235:0x00e0, B:238:0x00e9, B:240:0x00f5, B:244:0x00ff, B:248:0x011f, B:250:0x0127, B:251:0x0134, B:253:0x015a, B:254:0x0161, B:256:0x0167, B:257:0x016b, B:259:0x0171, B:261:0x017d, B:265:0x01ac, B:266:0x01c8, B:274:0x01e5, B:275:0x01fe, B:276:0x01ff, B:278:0x0207, B:280:0x020d, B:284:0x0219, B:286:0x021d, B:288:0x022d, B:290:0x0235, B:292:0x023f, B:247:0x0107, B:294:0x0254, B:295:0x025f, B:204:0x0017, B:206:0x001b, B:208:0x001f, B:210:0x0025, B:213:0x002d), top: B:381:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x015a A[Catch: Exception -> 0x0260, NullPointerException -> 0x0282, IOException -> 0x02a6, UnknownHostException -> 0x02d0, HttpHostConnectException -> 0x02fc, NoHttpResponseException -> 0x0320, SocketTimeoutException -> 0x034b, ConnectTimeoutException -> 0x0376, ConnectionPoolTimeoutException -> 0x03a0, SSLException -> 0x03ca, SSLPeerUnverifiedException -> 0x03f4, SSLHandshakeException -> 0x041e, URISyntaxException -> 0x0448, HttpException -> 0x0455, TryCatch #3 {HttpException -> 0x0455, SocketTimeoutException -> 0x034b, IOException -> 0x02a6, NoHttpResponseException -> 0x0320, NullPointerException -> 0x0282, URISyntaxException -> 0x0448, UnknownHostException -> 0x02d0, SSLException -> 0x03ca, HttpHostConnectException -> 0x02fc, SSLHandshakeException -> 0x041e, Exception -> 0x0260, ConnectionPoolTimeoutException -> 0x03a0, SSLPeerUnverifiedException -> 0x03f4, ConnectTimeoutException -> 0x0376, blocks: (B:201:0x0006, B:215:0x0032, B:217:0x003a, B:219:0x0040, B:220:0x0044, B:222:0x004a, B:223:0x0058, B:225:0x006c, B:227:0x0081, B:229:0x00c1, B:231:0x00d0, B:233:0x00d6, B:235:0x00e0, B:238:0x00e9, B:240:0x00f5, B:244:0x00ff, B:248:0x011f, B:250:0x0127, B:251:0x0134, B:253:0x015a, B:254:0x0161, B:256:0x0167, B:257:0x016b, B:259:0x0171, B:261:0x017d, B:265:0x01ac, B:266:0x01c8, B:274:0x01e5, B:275:0x01fe, B:276:0x01ff, B:278:0x0207, B:280:0x020d, B:284:0x0219, B:286:0x021d, B:288:0x022d, B:290:0x0235, B:292:0x023f, B:247:0x0107, B:294:0x0254, B:295:0x025f, B:204:0x0017, B:206:0x001b, B:208:0x001f, B:210:0x0025, B:213:0x002d), top: B:381:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0167 A[Catch: Exception -> 0x0260, NullPointerException -> 0x0282, IOException -> 0x02a6, UnknownHostException -> 0x02d0, HttpHostConnectException -> 0x02fc, NoHttpResponseException -> 0x0320, SocketTimeoutException -> 0x034b, ConnectTimeoutException -> 0x0376, ConnectionPoolTimeoutException -> 0x03a0, SSLException -> 0x03ca, SSLPeerUnverifiedException -> 0x03f4, SSLHandshakeException -> 0x041e, URISyntaxException -> 0x0448, HttpException -> 0x0455, TryCatch #3 {HttpException -> 0x0455, SocketTimeoutException -> 0x034b, IOException -> 0x02a6, NoHttpResponseException -> 0x0320, NullPointerException -> 0x0282, URISyntaxException -> 0x0448, UnknownHostException -> 0x02d0, SSLException -> 0x03ca, HttpHostConnectException -> 0x02fc, SSLHandshakeException -> 0x041e, Exception -> 0x0260, ConnectionPoolTimeoutException -> 0x03a0, SSLPeerUnverifiedException -> 0x03f4, ConnectTimeoutException -> 0x0376, blocks: (B:201:0x0006, B:215:0x0032, B:217:0x003a, B:219:0x0040, B:220:0x0044, B:222:0x004a, B:223:0x0058, B:225:0x006c, B:227:0x0081, B:229:0x00c1, B:231:0x00d0, B:233:0x00d6, B:235:0x00e0, B:238:0x00e9, B:240:0x00f5, B:244:0x00ff, B:248:0x011f, B:250:0x0127, B:251:0x0134, B:253:0x015a, B:254:0x0161, B:256:0x0167, B:257:0x016b, B:259:0x0171, B:261:0x017d, B:265:0x01ac, B:266:0x01c8, B:274:0x01e5, B:275:0x01fe, B:276:0x01ff, B:278:0x0207, B:280:0x020d, B:284:0x0219, B:286:0x021d, B:288:0x022d, B:290:0x0235, B:292:0x023f, B:247:0x0107, B:294:0x0254, B:295:0x025f, B:204:0x0017, B:206:0x001b, B:208:0x001f, B:210:0x0025, B:213:0x002d), top: B:381:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x01dc  */
    @Override // java.util.concurrent.Callable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.android.phone.mrpc.core.u call() {
        /*
            Method dump skipped, instructions count: 1138
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.q.call():com.alipay.android.phone.mrpc.core.u");
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (TextUtils.isEmpty(this.q)) {
            String b = this.c.b("operationType");
            this.q = b;
            return b;
        }
        return this.q;
    }

    private int g() {
        URL h = h();
        return h.getPort() == -1 ? h.getDefaultPort() : h.getPort();
    }

    private URL h() {
        URL url = this.l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.c.a());
        this.l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager cookieManager2 = CookieManager.getInstance();
        this.i = cookieManager2;
        return cookieManager2;
    }

    public final o a() {
        return this.c;
    }
}
