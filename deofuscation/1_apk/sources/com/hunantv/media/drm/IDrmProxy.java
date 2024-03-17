package com.hunantv.media.drm;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IDrmProxy {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface DrmProxyNotifyListener {
        void onErrorNotification(IDrmProxy iDrmProxy, int i, String str);
    }

    void disableProxy(boolean z);

    void init() throws MgtvDrmErrorCodeException, NullPointerException;

    String makeUrl(String str) throws MgtvDrmErrorCodeException;

    void setDrmNotifyProxyListener(DrmProxyNotifyListener drmProxyNotifyListener);

    void start() throws MgtvDrmErrorCodeException;

    void stop() throws MgtvDrmErrorCodeException;
}
