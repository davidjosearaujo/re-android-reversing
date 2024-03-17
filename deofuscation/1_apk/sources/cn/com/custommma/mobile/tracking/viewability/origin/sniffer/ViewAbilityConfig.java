package cn.com.custommma.mobile.tracking.viewability.origin.sniffer;

import com.hunantv.media.player.MgtvMediaPlayer;
import java.io.Serializable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewAbilityConfig implements Serializable {
    private static final long serialVersionUID = 1;
    private int maxDuration = 120000;
    private int exposeValidDuration = 1000;
    private int videoExposeValidDuration = MgtvMediaPlayer.MainNotifyHandler.MSG_HTTPDNS_REPORT_PV;
    private int inspectInterval = 100;
    private int maxUploadAmount = 20;
    private float coverRateScale = 0.5f;

    public float getCoverRateScale() {
        return this.coverRateScale;
    }

    public int getExposeValidDuration() {
        return this.exposeValidDuration;
    }

    public int getInspectInterval() {
        return this.inspectInterval;
    }

    public int getMaxDuration() {
        return this.maxDuration;
    }

    public int getMaxUploadAmount() {
        return this.maxUploadAmount;
    }

    public int getVideoExposeValidDuration() {
        return this.videoExposeValidDuration;
    }

    public void setCoverRateScale(float f) {
        this.coverRateScale = f;
    }

    public void setExposeValidDuration(int i) {
        this.exposeValidDuration = i * 1000;
    }

    public void setInspectInterval(int i) {
        this.inspectInterval = i;
    }

    public void setMaxDuration(int i) {
        this.maxDuration = i * 1000;
    }

    public void setMaxUploadAmount(int i) {
        this.maxUploadAmount = i;
    }

    public void setVideoExposeValidDuration(int i) {
        this.videoExposeValidDuration = i * 1000;
    }
}
