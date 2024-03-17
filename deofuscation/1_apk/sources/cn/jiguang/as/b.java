package cn.jiguang.as;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.f.i;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import cn.jiguang.net.SSLTrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    public static SSLTrustManager a;

    public static g a(Context context, String str, byte[] bArr, int i, int i2, int i3) {
        try {
            HttpRequest httpRequest = new HttpRequest(str);
            a(httpRequest, context, bArr, i, i3);
            while (i2 > 0) {
                i2--;
                HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                int responseCode = httpPost.getResponseCode();
                cn.jiguang.ar.c.d("HttpHelper", "status code:" + responseCode + " retry left:" + i2);
                if (responseCode == 200) {
                    return new g(0, httpPost.getResponseBody());
                }
                if (responseCode == 401) {
                    return new g(-3, httpPost.getResponseBody());
                }
                if (responseCode == 404 || responseCode == 410 || responseCode == 429) {
                    return new g(-1, httpPost.getResponseBody());
                }
                if (responseCode == 503) {
                    return new g(-2, httpPost.getResponseBody());
                }
                if (responseCode != 3005) {
                    return responseCode >= 500 ? new g(-1, httpPost.getResponseBody()) : new g(-2, httpPost.getResponseBody());
                }
            }
            return new g(-2, "Failed - retry enough");
        } catch (AssertionError e) {
            return new g(-2, "Catch AssertionError to avoid http close crash - " + e.getMessage());
        } catch (Exception e2) {
            return new g(-2, "Exception - " + e2.getMessage());
        } catch (Throwable th) {
            return new g(-2, "Exception - " + th.getMessage());
        }
    }

    public static g a(String str, String str2, Context context, boolean z, int i, int i2) {
        try {
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (z) {
                    try {
                        bytes = i.a(bytes);
                    } catch (IOException e) {
                        return new g(-2, "zip err:" + e.getMessage());
                    }
                }
                HttpRequest httpRequest = new HttpRequest(str);
                a(httpRequest, context, bytes, i2);
                while (i > 0) {
                    i--;
                    HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                    int responseCode = httpPost.getResponseCode();
                    cn.jiguang.ar.c.d("HttpHelper", "status code:" + responseCode + " retry left:" + i);
                    if (responseCode == 200) {
                        return new g(0, httpPost.getResponseBody());
                    }
                    if (responseCode == 401) {
                        return new g(-3, httpPost.getResponseBody());
                    }
                    if (responseCode == 404 || responseCode == 410 || responseCode == 429) {
                        return new g(-1, httpPost.getResponseBody());
                    }
                    if (responseCode == 503) {
                        return new g(-2, httpPost.getResponseBody());
                    }
                    if (responseCode != 3005) {
                        return responseCode >= 500 ? new g(-1, httpPost.getResponseBody()) : new g(-2, httpPost.getResponseBody());
                    }
                }
                return new g(-2, "Failed - retry enough");
            } catch (AssertionError e2) {
                return new g(-2, "Catch AssertionError to avoid http close crash - " + e2.getMessage());
            } catch (Exception e3) {
                return new g(-2, "Exception - " + e3.getMessage());
            } catch (Throwable th) {
                return new g(-2, "Exception - " + th.getMessage());
            }
        } catch (UnsupportedEncodingException e4) {
            return new g(-2, "Exception - " + e4.getMessage());
        }
    }

    private static void a(HttpRequest httpRequest, Context context, byte[] bArr, int i) {
        String a2;
        httpRequest.setConnectTimeout(30000);
        httpRequest.setReadTimeout(30000);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        String a3 = cn.jiguang.bf.d.a(cn.jiguang.bf.d.a());
        byte[] a4 = cn.jiguang.bf.d.a(bArr, a3, (i == 2 || i == 3) ? "0102030405060708" : "iop203040506aPk!", true);
        httpRequest.setBody(a4);
        httpRequest.setRequestProperty("Content-Length", String.valueOf(a4.length));
        httpRequest.setNeedRetryIfHttpsFailed(true);
        if (a == null) {
            try {
                if (!TextUtils.isEmpty("")) {
                    a = new SSLTrustManager("");
                }
            } catch (Throwable unused) {
            }
        }
        SSLTrustManager sSLTrustManager = a;
        if (sSLTrustManager != null) {
            httpRequest.setSslTrustManager(sSLTrustManager);
        }
        httpRequest.setRequestProperty("Accept", "application/jason");
        httpRequest.setRequestProperty("Accept-Encoding", "gzip");
        httpRequest.setRequestProperty("X-App-Key", cn.jiguang.d.a.e(context));
        if (i == 2 || i == 3) {
            httpRequest.setHaveRspData(true);
            httpRequest.setRspDatazip(true);
            httpRequest.setNeedErrorInput(true);
            httpRequest.setRequestProperty("FillType", "1");
            if (i == 3) {
                httpRequest.setRequestProperty("X-Real-IP", "jcore");
                a2 = f.b(a3);
            } else {
                a2 = f.a(a3);
            }
        } else {
            boolean z = i == 4;
            httpRequest.setHaveRspData(z);
            httpRequest.setRspDatazip(z);
            a2 = "Basic " + f.a(context, cn.jiguang.f.g.b(a4), a3, z);
        }
        httpRequest.setRequestProperty("Authorization", a2);
        httpRequest.setRequestProperty("Charset", "UTF-8");
    }

    private static void a(HttpRequest httpRequest, Context context, byte[] bArr, int i, int i2) {
        String str;
        httpRequest.setConnectTimeout(30000);
        httpRequest.setReadTimeout(30000);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        httpRequest.setBody(bArr);
        httpRequest.setRequestProperty("Content-Length", String.valueOf(bArr.length));
        httpRequest.setNeedRetryIfHttpsFailed(true);
        if (a == null) {
            try {
                if (!TextUtils.isEmpty("")) {
                    a = new SSLTrustManager("");
                }
            } catch (Throwable unused) {
            }
        }
        SSLTrustManager sSLTrustManager = a;
        if (sSLTrustManager != null) {
            httpRequest.setSslTrustManager(sSLTrustManager);
        }
        httpRequest.setRequestProperty("Accept", "application/jason");
        httpRequest.setRequestProperty("Accept-Encoding", "gzip");
        httpRequest.setRequestProperty("X-App-Key", cn.jiguang.d.a.e(context));
        httpRequest.setRequestProperty("Charset", "UTF-8");
        httpRequest.setRequestProperty("Host", "stats.jpush.cn");
        String a2 = cn.jiguang.bf.d.a(i);
        if (i2 == 2) {
            httpRequest.setHaveRspData(true);
            httpRequest.setRspDatazip(true);
            httpRequest.setNeedErrorInput(true);
            httpRequest.setRequestProperty("FillType", "1");
            str = f.a(a2);
        } else {
            httpRequest.setHaveRspData(false);
            httpRequest.setRspDatazip(false);
            str = "Basic " + f.a(context, cn.jiguang.f.g.b(bArr), a2);
        }
        httpRequest.setRequestProperty("Authorization", str);
    }
}
