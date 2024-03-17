package com.hunantv.media.drm.wasabi;

import android.os.Handler;
import com.hunantv.media.drm.IDrmProxy;
import com.hunantv.media.drm.MgtvDrmErrorCodeException;
import com.intertrust.wasabi.ErrorCodeException;
import com.intertrust.wasabi.media.PlaylistProxy;
import com.intertrust.wasabi.media.PlaylistProxyListener;
import java.util.EnumSet;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class WasabiDrmProxy implements IDrmProxy {
    private boolean disableProxy;
    private PlaylistProxyListener mPlaylistProxyListener = new PlaylistProxyListener() { // from class: com.hunantv.media.drm.wasabi.WasabiDrmProxy.1
        public void onErrorNotification(int i, String str) {
            if (WasabiDrmProxy.this.proxyListener != null) {
                WasabiDrmProxy.this.proxyListener.onErrorNotification(WasabiDrmProxy.this, i, str);
            }
        }

        public void onExtLogNotification(String str) {
        }
    };
    private PlaylistProxy proxy;
    private IDrmProxy.DrmProxyNotifyListener proxyListener;

    @Override // com.hunantv.media.drm.IDrmProxy
    public void disableProxy(boolean z) {
        this.disableProxy = z;
    }

    @Override // com.hunantv.media.drm.IDrmProxy
    public synchronized void init() throws MgtvDrmErrorCodeException, NullPointerException {
        if (this.proxy == null) {
            try {
                this.proxy = new PlaylistProxy(EnumSet.noneOf(PlaylistProxy.Flags.class), this.mPlaylistProxyListener, new Handler());
            } catch (ErrorCodeException e) {
                throw new MgtvDrmErrorCodeException(e);
            }
        }
    }

    @Override // com.hunantv.media.drm.IDrmProxy
    public synchronized String makeUrl(String str) throws MgtvDrmErrorCodeException {
        if (this.proxy == null || this.disableProxy) {
            return str;
        }
        try {
            PlaylistProxy.MediaSourceParams mediaSourceParams = new PlaylistProxy.MediaSourceParams();
            mediaSourceParams.sourceContentType = "application/vnd.apple.mpegurl";
            return this.proxy.makeUrl(str, PlaylistProxy.MediaSourceType.HLS, mediaSourceParams);
        } catch (ErrorCodeException e) {
            throw new MgtvDrmErrorCodeException(e);
        }
    }

    @Override // com.hunantv.media.drm.IDrmProxy
    public void setDrmNotifyProxyListener(IDrmProxy.DrmProxyNotifyListener drmProxyNotifyListener) {
        this.proxyListener = drmProxyNotifyListener;
    }

    @Override // com.hunantv.media.drm.IDrmProxy
    public synchronized void start() throws MgtvDrmErrorCodeException {
        PlaylistProxy playlistProxy = this.proxy;
        if (playlistProxy != null) {
            try {
                playlistProxy.start();
            } catch (ErrorCodeException e) {
                throw new MgtvDrmErrorCodeException(e);
            }
        }
    }

    @Override // com.hunantv.media.drm.IDrmProxy
    public synchronized void stop() throws MgtvDrmErrorCodeException {
        PlaylistProxy playlistProxy = this.proxy;
        if (playlistProxy != null) {
            try {
                playlistProxy.stop();
            } catch (ErrorCodeException e) {
                throw new MgtvDrmErrorCodeException(e);
            }
        }
    }
}
