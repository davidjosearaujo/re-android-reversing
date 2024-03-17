package cn.jiguang.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.bf.d;
import cn.jiguang.n.c;
import cn.jiguang.n.e;
import cn.jiguang.net.HttpUtils;
import cn.jiguang.r.c;
import cn.jiguang.r.f;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.hunantv.imgo.net.RequestParams;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static String g;
    private static final String b = cn.jiguang.r.a.b(new byte[]{85, 118, 97, 33, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, 44});
    private static final String c = cn.jiguang.r.a.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 96, 90, 17, 33, 103, 102});
    public static String a = "";
    private static long d = 0;
    private static long e = 43200;
    private static String f = "";
    private static boolean h = false;

    /* renamed from: cn.jiguang.j.a$a  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class C0009a extends e {
        private Context a;

        public C0009a(Context context) {
            this.a = context;
            this.b = "FolderMapConfAction";
        }

        @Override // cn.jiguang.n.e
        public void a() {
            JSONObject c;
            Context context = this.a;
            if (context == null) {
                cn.jiguang.ak.a.d("JActFolderConfManager", "request folder map config, context is null");
            } else if (!a.e(context)) {
                cn.jiguang.ak.a.a("JActFolderConfManager", "not config request business time.");
            } else {
                String f = a.f(this.a);
                if (TextUtils.isEmpty(f) || (c = a.c(this.a, f)) == null) {
                    return;
                }
                long optLong = c.optLong("req_gap");
                String optString = c.optString("af");
                String optString2 = c.optString("sign", "");
                a.b(this.a, optLong);
                if (TextUtils.isEmpty(optString) || "null".equals(optString)) {
                    cn.jiguang.ak.a.a("JActFolderConfManager", "recv config data is null");
                } else if ("-1".equals(optString)) {
                    c.d(this.a, "afm.cache");
                    String unused = a.f = "";
                } else {
                    if (TextUtils.isEmpty(a.g)) {
                        String unused2 = a.f = optString;
                    } else {
                        HashMap<String, List<String>> hashMap = new HashMap<>();
                        if (!a.h) {
                            hashMap = a.a(a.b(this.a));
                        }
                        hashMap.putAll(a.a(optString));
                        String unused3 = a.f = a.b(hashMap);
                    }
                    c.a(this.a, "afm.cache", d.a(a.f));
                    a.d(this.a, optString2);
                }
            }
        }
    }

    private static String a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] decode = Base64.decode(str, 2);
            if (z) {
                decode = f.b(decode);
            }
            String str2 = b;
            return new String(d.a(decode, str2, str2, false));
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public static HashMap<String, List<String>> a(String str) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        try {
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JActFolderConfManager", "parse package folder map data config failed, " + th.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (String str2 : str.split("&&")) {
            String[] split = str2.split("&");
            String str3 = split[0];
            String str4 = split[1];
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put(str4, Arrays.asList(str3.split("@")));
            }
        }
        cn.jiguang.ak.a.a("JActFolderConfManager", "parse package folder config, data: " + str + ", folder size: " + hashMap.size());
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018 A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:2:0x0000, B:4:0x000a, B:10:0x0018, B:12:0x0027, B:15:0x002e), top: B:20:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    @android.annotation.TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject a(android.content.Context r5, java.lang.String r6, long r7) {
        /*
            java.lang.String r0 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r0 = cn.jiguang.n.d.a(r5, r0)     // Catch: java.lang.Throwable -> L5d
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L15
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r0 = cn.jiguang.n.d.a(r5, r0)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L13
            goto L15
        L13:
            r0 = 0
            goto L16
        L15:
            r0 = 1
        L16:
            if (r2 != r0) goto L25
            cn.jiguang.common.app.helper.a r3 = cn.jiguang.common.app.helper.a.a()     // Catch: java.lang.Throwable -> L5d
            java.util.List r3 = r3.a(r5)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = a(r3)     // Catch: java.lang.Throwable -> L5d
            goto L27
        L25:
            java.lang.String r3 = ""
        L27:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L5d
            if (r4 != 0) goto L2e
            r1 = 1
        L2e:
            cn.jiguang.j.a.h = r1     // Catch: java.lang.Throwable -> L5d
            g(r5)     // Catch: java.lang.Throwable -> L5d
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5d
            r5.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = "appkey"
            r5.put(r1, r6)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r6 = "uid"
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r6 = "can_read"
            r5.put(r6, r0)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r6 = "sign"
            java.lang.String r7 = cn.jiguang.j.a.g     // Catch: java.lang.Throwable -> L5d
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r6 = "al"
            r5.put(r6, r3)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r6 = "ver"
            r7 = 2
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> L5d
            return r5
        L5d:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "package app list probe req data failed, "
            r6.append(r7)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "JActFolderConfManager"
            cn.jiguang.ak.a.d(r6, r5)
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.j.a.a(android.content.Context, java.lang.String, long):org.json.JSONObject");
    }

    public static void a(Context context) {
        cn.jiguang.n.d.b(new C0009a(context));
    }

    public static synchronized String b(Context context) {
        synchronized (a.class) {
            if (!TextUtils.isEmpty(f)) {
                return f;
            }
            String c2 = c.c(context, "afm.cache");
            if (!TextUtils.isEmpty(c2)) {
                f = d.b(c2);
            }
            return f;
        }
    }

    private static String b(String str, boolean z) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (z) {
                bytes = f.a(bytes);
            }
            String str2 = b;
            return Base64.encodeToString(d.a(bytes, str2, str2, true), 2);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(HashMap<String, List<String>> hashMap) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            List<String> list = hashMap.get(str);
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    sb.append(list.get(i2));
                    if (i2 != list.size() - 1) {
                        sb.append("@");
                    }
                }
                sb.append("&");
                sb.append(str);
                if (i != arrayList.size() - 1) {
                    sb.append("&&");
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, long j) {
        d = System.currentTimeMillis();
        long max = Math.max(600L, j);
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jiguang.common", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("fd_last_time", d).putLong("fd_internal_time", max).apply();
        }
        e = max;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String a2 = a(str, true);
            JSONObject jSONObject = new JSONObject(a2);
            cn.jiguang.ak.a.a("JActFolderConfManager", "decode success, server active Config:" + a2);
            int optInt = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE);
            String optString = jSONObject.optString("message");
            if (optInt != 2000) {
                cn.jiguang.ak.a.a("JActFolderConfManager", "[refreshConfigData] data config code:" + optInt + " msg:" + optString);
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                long optLong = optJSONObject.optLong("req_gap");
                String optString2 = optJSONObject.optString("af");
                String optString3 = optJSONObject.optString("sign", "");
                cn.jiguang.ak.a.a("JActFolderConfManager", "server folder config, internal: " + optLong + ", content: " + optString2 + ", sign: " + optString3);
                return optJSONObject;
            }
            return null;
        } catch (Throwable unused) {
            cn.jiguang.ak.a.d("JActFolderConfManager", "[refreshConfigData] refreshConfigData failed, errMsg: " + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jiguang.common", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("req_sign", str).apply();
        }
        g = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(Context context) {
        SharedPreferences sharedPreferences;
        if (d == 0 && (sharedPreferences = context.getSharedPreferences("cn.jiguang.common", 0)) != null) {
            d = sharedPreferences.getLong("fd_last_time", 0L);
            e = sharedPreferences.getLong("fd_internal_time", 43200L);
        }
        return System.currentTimeMillis() - d >= e * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(Context context) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        String b2;
        String str;
        try {
            b2 = cn.jiguang.n.d.b(context);
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
            inputStream = null;
        }
        if (TextUtils.isEmpty(b2)) {
            cn.jiguang.ak.a.d("JActFolderConfManager", "request folder data config failed because can't get appKey");
            f.a((Closeable) null);
            return null;
        }
        long c2 = cn.jiguang.n.d.c(context);
        if (c2 == 0) {
            cn.jiguang.ak.a.d("JActFolderConfManager", "request folder data config failed because can't get uid");
            f.a((Closeable) null);
            return null;
        } else if (cn.jiguang.n.d.q(context)) {
            cn.jiguang.ak.a.a("JActFolderConfManager", "sdk is banned, not request data config");
            f.a((Closeable) null);
            return null;
        } else {
            JSONObject a2 = a(context, b2, c2);
            if (a2 == null) {
                cn.jiguang.ak.a.d("JActFolderConfManager", "package request data failed.");
                f.a((Closeable) null);
                return null;
            }
            String str2 = c;
            if (c.a.a && !TextUtils.isEmpty(a)) {
                cn.jiguang.ak.a.a("JActFolderConfManager", "use folder data config url :" + a);
                str2 = a;
            }
            HashMap hashMap = new HashMap();
            cn.jiguang.ak.a.a("JActFolderConfManager", "url:" + str2 + ", param json:" + a2.toString());
            hashMap.put("Content-Type", "text/plain");
            hashMap.put("Accept", RequestParams.APPLICATION_JSON);
            hashMap.put("Charset", "UTF-8");
            HttpURLConnection httpURLConnectionWithProxy = HttpUtils.getHttpURLConnectionWithProxy(context, str2);
            try {
                httpURLConnectionWithProxy.setConnectTimeout(30000);
                httpURLConnectionWithProxy.setReadTimeout(30000);
                httpURLConnectionWithProxy.setRequestMethod("POST");
                for (Map.Entry entry : hashMap.entrySet()) {
                    httpURLConnectionWithProxy.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                OutputStream outputStream = httpURLConnectionWithProxy.getOutputStream();
                String b3 = b(a2.toString(), true);
                cn.jiguang.ak.a.a("JActFolderConfManager", "encryptStr:" + b3 + ", zip length: " + b3.length() + ", length: " + a2.toString().length());
                outputStream.write(b3.getBytes("UTF-8"));
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
                        str = new String(byteArrayOutputStream.toByteArray());
                    } catch (Throwable th2) {
                        th = th2;
                        Throwable th3 = th;
                        httpURLConnection = httpURLConnectionWithProxy;
                        th = th3;
                        try {
                            cn.jiguang.ak.a.d("JActFolderConfManager", "request folder data config exception:" + th.getMessage());
                            return null;
                        } finally {
                            f.a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                } else {
                    inputStream = null;
                    str = null;
                }
                cn.jiguang.ak.a.a("JActFolderConfManager", "request folder data config code:" + responseCode + ", body:" + str);
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
            if (TextUtils.isEmpty(str)) {
                f.a(inputStream);
                if (httpURLConnectionWithProxy != null) {
                    httpURLConnectionWithProxy.disconnect();
                }
                return null;
            }
            cn.jiguang.ak.a.a("JActFolderConfManager", "request folder data config success");
            f.a(inputStream);
            if (httpURLConnectionWithProxy != null) {
                httpURLConnectionWithProxy.disconnect();
            }
            return str;
        }
    }

    private static void g(Context context) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(g) && (sharedPreferences = context.getSharedPreferences("cn.jiguang.common", 0)) != null) {
            g = sharedPreferences.getString("req_sign", "");
        }
    }
}
