package com.hunantv.imgo.net;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mgtv.task.http.HttpCallBack;
import com.mgtv.task.http.HttpFormatException;
import com.mgtv.task.http.HttpResponseObject;
import com.mgtv.task.http.HttpTraceObject;
import j.l.a.b0.e;
import j.l.c.y.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class ImgoHttpCallBack<T> extends HttpCallBack<T> {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum ErrorType {
        HTTP_ERROR,
        PARSE_ERROR,
        BUSINESS_ERROR
    }

    private void v(HttpTraceObject httpTraceObject) {
        if (httpTraceObject != null) {
            try {
                b bVar = (b) ARouter.getInstance().build("/report/provider").navigation();
                if (bVar != null) {
                    bVar.R(httpTraceObject.getException(), httpTraceObject.getHttpStatus(), httpTraceObject.getResponse(), httpTraceObject.getFinalUrl());
                    bVar.U(httpTraceObject.getException() != null ? httpTraceObject.getException().getMessage() : "http request failed!!!", new String[]{httpTraceObject.getFinalUrl(), String.valueOf(httpTraceObject.getHttpStatus())});
                }
            } catch (Exception unused) {
            }
        }
    }

    public void previewCache(T t) {
    }

    public ErrorType u() {
        HttpTraceObject r = r();
        if (r.getHttpStatus() != 200) {
            return ErrorType.HTTP_ERROR;
        }
        if (r.getException() instanceof HttpFormatException) {
            return ErrorType.PARSE_ERROR;
        }
        return ErrorType.BUSINESS_ERROR;
    }

    @Override // 
    public void onPostExecute(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
        if ("debug".equals(e.n())) {
            super.onPostExecute(httpResponseObject, obj, th);
        } else {
            try {
                super.onPostExecute(httpResponseObject, obj, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        HttpTraceObject httpTraceObject = (HttpTraceObject) obj;
        if (httpTraceObject == null) {
            return;
        }
        if (th instanceof Exception) {
            httpTraceObject.setException((Exception) th);
        }
        if (httpTraceObject.getException() == null && httpTraceObject.getHttpStatus() == 200) {
            return;
        }
        v(httpTraceObject);
    }
}
