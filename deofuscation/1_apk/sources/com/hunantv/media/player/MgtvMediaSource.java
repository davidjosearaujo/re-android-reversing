package com.hunantv.media.player;

import com.hunantv.media.global.GlobalKeyGenerator;
import com.hunantv.media.p2p.IP2pTask;
import com.hunantv.media.player.MgtvMediaPlayer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvMediaSource {
    public static final String FLV = "FLV";
    public static final String HLS_FMP4 = "HLS-FMP4";
    public static final String HLS_TS = "HLS-TS";
    public static final String MPEG_4 = "MPEG-4";
    public static final String MPEG_TS = "MPEG-TS";
    public String audioFormat;
    public String def;
    public String fileFormat;
    public boolean isReleased;
    private int key;
    public IP2pTask p2pTask;
    public String playingUrl;
    public String proxyUrl;
    public int readType;
    public String url;
    public String vid;
    public String videoFormat;
    private int videoHeight;
    private int videoWidth;
    public String vsri;

    public MgtvMediaSource(int i, String str) {
        this.readType = 0;
        this.vsri = "0|0_0|0_0";
        this.isReleased = false;
        this.readType = i;
        this.url = str;
        init();
    }

    public MgtvMediaSource(int i, String str, String str2) {
        this.readType = 0;
        this.vsri = "0|0_0|0_0";
        this.isReleased = false;
        this.readType = i;
        this.url = str;
        this.proxyUrl = str2;
        init();
    }

    public MgtvMediaSource(String str) {
        this.readType = 0;
        this.vsri = "0|0_0|0_0";
        this.isReleased = false;
        this.url = str;
        init();
    }

    private void init() {
        this.key = GlobalKeyGenerator.genKey();
        this.playingUrl = this.readType == 0 ? this.url : this.proxyUrl;
    }

    public String getAudioFormat() {
        return this.audioFormat;
    }

    public String getDef() {
        return this.def;
    }

    public String getFileFormat() {
        return this.fileFormat;
    }

    public int getKey() {
        return this.key;
    }

    public IP2pTask getP2pTask() {
        return this.p2pTask;
    }

    public String getPlayingUrl() {
        return this.playingUrl;
    }

    public String getProxyUrl() {
        return this.proxyUrl;
    }

    public int getReadType() {
        return this.readType;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVid() {
        return this.vid;
    }

    public String getVideoFormat() {
        return this.videoFormat;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public String getVsri() {
        return this.vsri;
    }

    public synchronized boolean isReleased() {
        return this.isReleased;
    }

    public synchronized void release() {
        this.isReleased = true;
    }

    public MgtvMediaSource setAudioFormat(String str) {
        this.audioFormat = str;
        return this;
    }

    public MgtvMediaSource setDef(String str) {
        this.def = str;
        return this;
    }

    public MgtvMediaSource setFileFormat(String str) {
        this.fileFormat = str;
        return this;
    }

    public MgtvMediaSource setP2pTask(IP2pTask iP2pTask) {
        this.p2pTask = iP2pTask;
        return this;
    }

    public MgtvMediaSource setPlayingUrl(String str) {
        this.playingUrl = str;
        return this;
    }

    public MgtvMediaSource setReadType(int i) {
        this.readType = i;
        return this;
    }

    public MgtvMediaSource setVid(String str) {
        this.vid = str;
        return this;
    }

    public MgtvMediaSource setVideoFormat(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            lowerCase.hashCode();
            lowerCase.hashCode();
            char c = 65535;
            switch (lowerCase.hashCode()) {
                case 96974:
                    if (lowerCase.equals("avc")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3148040:
                    if (lowerCase.equals(MgtvMediaPlayer.DataSourceInfo.H264)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3148041:
                    if (lowerCase.equals(MgtvMediaPlayer.DataSourceInfo.H265)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3199082:
                    if (lowerCase.equals("hevc")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    str = MgtvMediaPlayer.DataSourceInfo.H264;
                    break;
                case 2:
                case 3:
                    str = MgtvMediaPlayer.DataSourceInfo.H265;
                    break;
            }
        }
        this.videoFormat = str;
        return this;
    }

    public MgtvMediaSource setVideoHeight(int i) {
        this.videoHeight = i;
        return this;
    }

    public MgtvMediaSource setVideoWidth(int i) {
        this.videoWidth = i;
        return this;
    }

    public MgtvMediaSource setVsri(String str) {
        this.vsri = str;
        return this;
    }

    public String toString() {
        return "MgtvMediaSource{readType=" + this.readType + ", url='" + this.url + "', proxyUrl='" + this.proxyUrl + "', playingUrl='" + this.playingUrl + "', videoFormat='" + this.videoFormat + "', fileFormat='" + this.fileFormat + "', vid='" + this.vid + "', def='" + this.def + "', videoWidth='" + this.videoWidth + "', videoHeight='" + this.videoHeight + "', key=" + this.key + '}';
    }

    public void updateProxyUrl(String str) {
        this.url = this.proxyUrl;
    }
}
