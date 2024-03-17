package cn.jiguang.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bf.d;
import cn.jiguang.n.c;
import cn.jiguang.n.e;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.hunantv.imgo.net.RequestParams;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public static String a = "";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile c c;
    private Context b;
    private int d = 0;
    private String e = "";
    private String f = "I8iQemLpVcDAL0AS";
    private String g = "RTDdJXgDDVXH8Tbv";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements Callable<Integer> {
        private Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Integer call() {
            c.this.a(this.b);
            return 0;
        }
    }

    private int a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.ak.a.a("JDataConfigManager", "[refreshConfig] data config is null");
        } else {
            try {
                String str3 = new String(d.a(str, this.f, this.g), "UTF-8");
                a("JDataConfigManager", "serverConfig:" + str3);
                JSONObject jSONObject = new JSONObject(str3);
                int optInt = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE);
                String optString = jSONObject.optString("message");
                if (optInt == 2000) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        cn.jiguang.i.a.a().b();
                        int optInt2 = optJSONObject.optInt("status");
                        this.e = optJSONObject.optString("sign");
                        if (optInt2 == 0) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("rt");
                            if (optJSONArray != null) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    String optString2 = optJSONArray.optString(i);
                                    if (!TextUtils.isEmpty(optString2)) {
                                        String[] split = optString2.split("-");
                                        cn.jiguang.i.a.a().b.add(new String[]{split[0], split[1]});
                                    }
                                }
                            }
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray("pl");
                            if (optJSONArray2 != null) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                    if (optJSONObject2 != null) {
                                        cn.jiguang.o.a aVar = new cn.jiguang.o.a();
                                        aVar.a(true);
                                        aVar.a(optJSONObject2.optInt("ci"));
                                        aVar.b(optJSONObject2.optInt("sc"));
                                        aVar.d(optJSONObject2.optInt("bc"));
                                        aVar.c(optJSONObject2.optInt("sr"));
                                        aVar.e(optJSONObject2.optInt("br"));
                                        aVar.f(optJSONObject2.optInt("bg"));
                                        aVar.g(optJSONObject2.optInt("md"));
                                        cn.jiguang.i.a.a().a(aVar);
                                    }
                                }
                            }
                        } else {
                            str2 = "parse data config , config status is no";
                        }
                    }
                    return optInt;
                }
                str2 = "[refreshConfig] data config code:" + optInt + " msg:" + optString;
                cn.jiguang.ak.a.a("JDataConfigManager", str2);
                return optInt;
            } catch (Throwable unused) {
                cn.jiguang.ak.a.d("JDataConfigManager", "[refreshConfig] refreshConfig failed");
            }
        }
        return 0;
    }

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public static void a(String str, String str2) {
        int length = 4000 - str.length();
        while (str2.length() > length) {
            cn.jiguang.ak.a.a(str, str2.substring(0, length));
            str2 = str2.substring(length);
        }
        cn.jiguang.ak.a.a(str, str2);
    }

    private String b(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        String b;
        String str2;
        try {
            b = cn.jiguang.n.d.b(this.b);
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
            inputStream = null;
        }
        if (TextUtils.isEmpty(b)) {
            cn.jiguang.ak.a.d("JDataConfigManager", "request data config failed because can't get appKey");
            return null;
        }
        String str3 = "https://ce3e75d5.jpush.cn/wi/op8jdu";
        if (c.a.a && !TextUtils.isEmpty(a)) {
            str3 = a;
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ak", b);
        jSONObject.put("p", "a");
        jSONObject.put(com.alipay.sdk.sys.a.t, "1");
        jSONObject.put("sign", str);
        cn.jiguang.ak.a.a("JDataConfigManager", "url:" + str3 + ", param json:" + jSONObject.toString());
        hashMap.put("Content-Type", "text/plain");
        hashMap.put("Accept", RequestParams.APPLICATION_JSON);
        hashMap.put("Charset", "UTF-8");
        HttpURLConnection httpURLConnectionWithProxy = HttpUtils.getHttpURLConnectionWithProxy(this.b, str3);
        try {
            httpURLConnectionWithProxy.setConnectTimeout(30000);
            httpURLConnectionWithProxy.setReadTimeout(30000);
            httpURLConnectionWithProxy.setRequestMethod("POST");
            for (Map.Entry entry : hashMap.entrySet()) {
                httpURLConnectionWithProxy.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            OutputStream outputStream = httpURLConnectionWithProxy.getOutputStream();
            String a2 = d.a(jSONObject.toString().getBytes(), this.f, this.g);
            cn.jiguang.ak.a.a("JDataConfigManager", "encryptStr:" + a2);
            outputStream.write(a2.getBytes("UTF-8"));
            outputStream.flush();
            int responseCode = httpURLConnectionWithProxy.getResponseCode();
            if (responseCode == 200) {
                inputStream = httpURLConnectionWithProxy.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str2 = new String(byteArrayOutputStream.toByteArray());
                } catch (Throwable th2) {
                    th = th2;
                    Throwable th3 = th;
                    httpURLConnection = httpURLConnectionWithProxy;
                    th = th3;
                    try {
                        cn.jiguang.ak.a.d("JDataConfigManager", "request data config exception:" + th.getMessage());
                        return null;
                    } finally {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e) {
                                cn.jiguang.ak.a.d("JDataConfigManager", "request data config exception:" + e.getMessage());
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            } else {
                inputStream = null;
                str2 = null;
            }
            cn.jiguang.ak.a.a("JDataConfigManager", "request data config code:" + responseCode + ", body:" + str2);
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    cn.jiguang.ak.a.d("JDataConfigManager", "request data config exception:" + e2.getMessage());
                }
            }
            if (httpURLConnectionWithProxy != null) {
                httpURLConnectionWithProxy.disconnect();
            }
            return null;
        }
        cn.jiguang.ak.a.a("JDataConfigManager", "request data config success");
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e3) {
                cn.jiguang.ak.a.d("JDataConfigManager", "request data config exception:" + e3.getMessage());
            }
        }
        if (httpURLConnectionWithProxy != null) {
            httpURLConnectionWithProxy.disconnect();
        }
        return str2;
    }

    private void b(Context context) {
        if (TextUtils.isEmpty(this.e)) {
            String c2 = cn.jiguang.r.c.c(context, "bac.catch");
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            a(c2);
        }
    }

    public synchronized void a(Context context) {
        if (this.d >= 3) {
            cn.jiguang.ak.a.a("JDataConfigManager", "try more than 3 times,won't try again");
            cn.jiguang.n.b.e(context, "JDataConfigManager");
            this.d = 0;
            return;
        }
        if (cn.jiguang.n.b.a(context, "JDataConfigManager")) {
            b(context);
            String b = b(this.e);
            if (TextUtils.isEmpty(b)) {
                this.d++;
            } else {
                if (a(b) == 2000) {
                    cn.jiguang.r.c.a(context, "bac.catch", b);
                }
                cn.jiguang.n.b.e(context, "JDataConfigManager");
                this.d = 0;
            }
        } else {
            b(context);
        }
    }

    public void a(Context context, int i) {
        try {
            FutureTask futureTask = new FutureTask(new a(context));
            cn.jiguang.n.d.a(futureTask);
            futureTask.get(i, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            cn.jiguang.ak.a.a("JDataConfigManager", "requestConfigSync timeout");
        }
    }

    public void a(final Context context, final b bVar) {
        cn.jiguang.n.d.a(new e() { // from class: cn.jiguang.o.c.1
            @Override // cn.jiguang.n.e
            public void a() {
                try {
                    c.this.a(context);
                } catch (Throwable th) {
                    cn.jiguang.ak.a.a("JDataConfigManager", "request config error:" + th);
                }
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        });
    }
}
