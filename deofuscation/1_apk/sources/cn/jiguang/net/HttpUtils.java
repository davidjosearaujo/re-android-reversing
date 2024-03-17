package cn.jiguang.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import cn.jiguang.f.i;
import com.huawei.hms.framework.common.ContainerUtils;
import com.hunantv.imgo.entity.JumpAction;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class HttpUtils {
    public static final String a = cn.jiguang.r.a.b(new byte[]{32, 0, 14, 41, 38, 38, 63, 1, 23, 43});

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static abstract class HttpListener {
        public void a() {
        }

        public void a(HttpResponse httpResponse) {
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends AsyncTask<HttpRequest, Void, HttpResponse> {
        private HttpListener a;
        private Context b;

        public a(Context context, HttpListener httpListener) {
            this.a = httpListener;
            this.b = context;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public HttpResponse doInBackground(HttpRequest... httpRequestArr) {
            if (httpRequestArr == null || httpRequestArr.length == 0) {
                return null;
            }
            return HttpUtils.httpGet(this.b, httpRequestArr[0]);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(HttpResponse httpResponse) {
            HttpListener httpListener = this.a;
            if (httpListener != null) {
                httpListener.a(httpResponse);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            HttpListener httpListener = this.a;
            if (httpListener != null) {
                httpListener.a();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b extends AsyncTask<String, Void, HttpResponse> {
        private HttpListener a;
        private Context b;

        public b(HttpListener httpListener, Context context) {
            this.a = httpListener;
            this.b = context;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public HttpResponse doInBackground(String... strArr) {
            if (strArr == null || strArr.length == 0) {
                return null;
            }
            return HttpUtils.httpGet(this.b, strArr[0]);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(HttpResponse httpResponse) {
            HttpListener httpListener = this.a;
            if (httpListener != null) {
                httpListener.a(httpResponse);
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            HttpListener httpListener = this.a;
            if (httpListener != null) {
                httpListener.a();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:(6:6|7|9|10|11|(6:104|105|(2:107|(1:109))|110|(1:112)(1:115)|113))|(2:14|(16:16|17|18|19|20|21|23|24|(9:27|28|(3:44|45|(1:47))|(1:35)|(1:37)|38|39|(1:41)|42)|52|(3:31|33|35)|(0)|38|39|(0)|42))|103|19|20|21|23|24|(9:27|28|(0)|(0)|(0)|38|39|(0)|42)|52|(0)|(0)|38|39|(0)|42) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:6|7|9|10|11|(6:104|105|(2:107|(1:109))|110|(1:112)(1:115)|113)|(2:14|(16:16|17|18|19|20|21|23|24|(9:27|28|(3:44|45|(1:47))|(1:35)|(1:37)|38|39|(1:41)|42)|52|(3:31|33|35)|(0)|38|39|(0)|42))|103|19|20|21|23|24|(9:27|28|(0)|(0)|(0)|38|39|(0)|42)|52|(0)|(0)|38|39|(0)|42) */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00d4, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x00d5, code lost:
        cn.jiguang.ar.c.c("HttpUtils", "get input stream error:" + r4.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x00ed, code lost:
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x013d, code lost:
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x013e, code lost:
        r11 = r9;
        r9 = r1;
        r1 = r4;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0142, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0143, code lost:
        r8 = r1;
        r1 = r9;
        r9 = r8;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0148, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0149, code lost:
        r11 = r9;
        r9 = r1;
        r1 = r4;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x01a9, code lost:
        if (r11 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x023f, code lost:
        if (r11 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0241, code lost:
        r11.disconnect();
        r3 = r3;
        r9 = r9;
        r11 = r11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:184:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0120 A[Catch: all -> 0x013d, IOException -> 0x0142, MalformedURLException -> 0x0148, TryCatch #11 {MalformedURLException -> 0x0148, IOException -> 0x0142, all -> 0x013d, blocks: (B:172:0x00ee, B:186:0x0110, B:188:0x0116, B:190:0x0120, B:191:0x012a), top: B:272:0x00ee }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01c0 A[Catch: all -> 0x020c, TryCatch #7 {all -> 0x020c, blocks: (B:223:0x01b3, B:225:0x01c0, B:226:0x01c8, B:233:0x01e5, B:227:0x01cc, B:229:0x01d0, B:230:0x01d9, B:232:0x01dd), top: B:261:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x01cc A[Catch: all -> 0x020c, TryCatch #7 {all -> 0x020c, blocks: (B:223:0x01b3, B:225:0x01c0, B:226:0x01c8, B:233:0x01e5, B:227:0x01cc, B:229:0x01d0, B:230:0x01d9, B:232:0x01dd), top: B:261:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static cn.jiguang.net.HttpResponse a(android.content.Context r9, cn.jiguang.net.HttpRequest r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.net.HttpUtils.a(android.content.Context, cn.jiguang.net.HttpRequest, boolean):cn.jiguang.net.HttpResponse");
    }

    private static void a(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        if (httpRequest == null || httpURLConnection == null) {
            return;
        }
        setURLConnection(httpRequest.getRequestProperties(), httpURLConnection);
        if (httpRequest.getConnectTimeout() >= 0) {
            httpURLConnection.setConnectTimeout(httpRequest.getConnectTimeout());
        }
        if (httpRequest.getReadTimeout() >= 0) {
            httpURLConnection.setReadTimeout(httpRequest.getReadTimeout());
        }
    }

    private static void a(HttpURLConnection httpURLConnection, HttpResponse httpResponse) {
        if (httpResponse == null || httpURLConnection == null) {
            return;
        }
        httpResponse.setResponseCode(httpURLConnection.getResponseCode());
        httpResponse.setResponseHeader("expires", httpURLConnection.getHeaderField("Expires"));
        httpResponse.setResponseHeader("cache-control", httpURLConnection.getHeaderField("Cache-Control"));
    }

    public static String appendParaToUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains(JumpAction.STR_ACTION_SPLIT)) {
            sb.append("&");
        } else {
            sb.append(JumpAction.STR_ACTION_SPLIT);
        }
        sb.append(str2);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(str3);
        return sb.toString();
    }

    public static HttpURLConnection getHttpURLConnectionWithProxy(Context context, String str) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        URL url = new URL(str);
        if (context != null) {
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                    return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(a, 80)));
                }
            } catch (Throwable unused) {
            }
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static String getUrlWithParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParas = joinParas(map);
        if (!TextUtils.isEmpty(joinParas)) {
            sb.append(JumpAction.STR_ACTION_SPLIT);
            sb.append(joinParas);
        }
        return sb.toString();
    }

    public static String getUrlWithValueEncodeParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParasWithEncodedValue = joinParasWithEncodedValue(map);
        if (!TextUtils.isEmpty(joinParasWithEncodedValue)) {
            sb.append(JumpAction.STR_ACTION_SPLIT);
            sb.append(joinParasWithEncodedValue);
        }
        return sb.toString();
    }

    public static HttpResponse httpGet(Context context, HttpRequest httpRequest) {
        return a(context, httpRequest, false);
    }

    public static HttpResponse httpGet(Context context, String str) {
        return httpGet(context, new HttpRequest(str));
    }

    public static void httpGet(Context context, HttpRequest httpRequest, HttpListener httpListener) {
        new a(context, httpListener).execute(httpRequest);
    }

    public static void httpGet(Context context, String str, HttpListener httpListener) {
        new b(httpListener, context).execute(str);
    }

    public static String httpGetString(Context context, HttpRequest httpRequest) {
        HttpResponse httpGet = httpGet(context, httpRequest);
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static String httpGetString(Context context, String str) {
        HttpResponse httpGet = httpGet(context, new HttpRequest(str));
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static HttpResponse httpPost(Context context, HttpRequest httpRequest) {
        return a(context, httpRequest, true);
    }

    public static HttpResponse httpPost(Context context, String str) {
        return httpPost(context, new HttpRequest(str));
    }

    public static String httpPostString(Context context, String str) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static String httpPostString(Context context, String str, Map<String, String> map) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str, map));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static String joinParas(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(next.getValue());
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public static String joinParasWithEncodedValue(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<String, String> next = it.next();
                    sb.append(next.getKey());
                    sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append("&");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static long parseGmtTime(String str) {
        try {
            return cn.jiguang.f.b.a("EEE, d MMM yyyy HH:mm:ss z").parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static byte[] readInputStream(InputStream inputStream) {
        return i.b(inputStream);
    }

    public static void setURLConnection(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
