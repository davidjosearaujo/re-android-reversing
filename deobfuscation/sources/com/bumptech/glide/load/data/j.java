package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.s0;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public final class j implements d<InputStream> {

    /* renamed from: f */
    public final v2.f f2678f;

    /* renamed from: g */
    public final int f2679g;

    /* renamed from: h */
    public HttpURLConnection f2680h;

    /* renamed from: i */
    public InputStream f2681i;

    /* renamed from: j */
    public volatile boolean f2682j;

    /* loaded from: classes.dex */
    public static class a {
    }

    static {
        new a();
    }

    public j(v2.f fVar, int i7) {
        this.f2678f = fVar;
        this.f2679g = i7;
    }

    public static int c(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", e);
                return -1;
            }
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        InputStream inputStream = this.f2681i;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f2680h;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f2680h = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        this.f2682j = true;
    }

    public final InputStream d(URL url, int i7, URL url2, Map<String, String> map) {
        InputStream inputStream;
        if (i7 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new p2.e("In re-direct loop", -1, null);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                httpURLConnection.setConnectTimeout(this.f2679g);
                httpURLConnection.setReadTimeout(this.f2679g);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                this.f2680h = httpURLConnection;
                try {
                    httpURLConnection.connect();
                    this.f2681i = this.f2680h.getInputStream();
                    if (this.f2682j) {
                        return null;
                    }
                    int c7 = c(this.f2680h);
                    int i8 = c7 / 100;
                    if (i8 == 2) {
                        HttpURLConnection httpURLConnection2 = this.f2680h;
                        try {
                            if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                                inputStream = new k3.c(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                            } else {
                                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                                }
                                inputStream = httpURLConnection2.getInputStream();
                            }
                            this.f2681i = inputStream;
                            return inputStream;
                        } catch (IOException e) {
                            throw new p2.e("Failed to obtain InputStream", c(httpURLConnection2), e);
                        }
                    }
                    if (!(i8 == 3)) {
                        if (c7 == -1) {
                            throw new p2.e("Http request failed", c7, null);
                        }
                        try {
                            throw new p2.e(this.f2680h.getResponseMessage(), c7, null);
                        } catch (IOException e7) {
                            throw new p2.e("Failed to get a response message", c7, e7);
                        }
                    }
                    String headerField = this.f2680h.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        throw new p2.e("Received empty or null redirect url", c7, null);
                    }
                    try {
                        URL url3 = new URL(url, headerField);
                        b();
                        return d(url3, i7 + 1, url, map);
                    } catch (MalformedURLException e8) {
                        throw new p2.e(s0.h("Bad redirect url: ", headerField), c7, e8);
                    }
                } catch (IOException e9) {
                    throw new p2.e("Failed to connect or obtain data", c(this.f2680h), e9);
                }
            } catch (IOException e10) {
                throw new p2.e("URL.openConnection threw", 0, e10);
            }
        }
        throw new p2.e("Too many (> 5) redirects!", -1, null);
    }

    @Override // com.bumptech.glide.load.data.d
    public final p2.a e() {
        return p2.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.i iVar, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        int i7 = k3.h.f4702b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                aVar.d(d(this.f2678f.d(), 0, null, this.f2678f.f6201b.a()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                aVar.c(e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(k3.h.a(elapsedRealtimeNanos));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                StringBuilder d7 = androidx.activity.h.d("Finished http url fetcher fetch in ");
                d7.append(k3.h.a(elapsedRealtimeNanos));
                Log.v("HttpUrlFetcher", d7.toString());
            }
            throw th;
        }
    }
}
