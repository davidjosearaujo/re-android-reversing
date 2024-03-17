package com.hunantv.mpdt.statistics.playerconfig;

import android.os.Parcel;
import android.os.Parcelable;
import com.mgtv.json.JsonInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VideoPlayerConfigNew implements JsonInterface, Parcelable {
    public static final Parcelable.Creator<VideoPlayerConfigNew> CREATOR = new a();
    public static final int SURFACEVIEW = 0;
    public static final int TEXTUREVIEW = 1;
    private static final long serialVersionUID = 2361014833265743937L;
    private String accurate_seek;
    private String addrinfo_timeout;
    private String addrinfo_type;
    private String buffer_timeout;
    private String datasource_async;
    private String decodetype;
    private String dns_family_type;
    private String http_multiple;
    private String http_persistent;
    private String is_soft;
    private String load_retry_time;
    private String m3u8_gzip;
    private String mp_type;
    private String open_timeout;
    private String player_support;
    private String render_type;
    private String rw_timeout;
    private String ts_not_skip;
    private String weak_net_speed;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements Parcelable.Creator<VideoPlayerConfigNew> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VideoPlayerConfigNew createFromParcel(Parcel parcel) {
            return new VideoPlayerConfigNew(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VideoPlayerConfigNew[] newArray(int i) {
            return new VideoPlayerConfigNew[i];
        }
    }

    public VideoPlayerConfigNew() {
    }

    private int convertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAccurate_seek() {
        return convertToInt(this.accurate_seek);
    }

    public int getAddrinfo_timeout() {
        return convertToInt(this.addrinfo_timeout);
    }

    public String getAddrinfo_type() {
        return this.addrinfo_type;
    }

    public int getBuffer_timeout() {
        return convertToInt(this.buffer_timeout);
    }

    public int getDatasource_async() {
        return convertToInt(this.datasource_async);
    }

    public int getDecodetype() {
        return convertToInt(this.decodetype);
    }

    public int getDns_family_type() {
        return convertToInt(this.dns_family_type);
    }

    public int getHttp_multiple() {
        return convertToInt(this.http_multiple);
    }

    public int getHttp_persistent() {
        return convertToInt(this.http_persistent);
    }

    public int getIs_soft() {
        return convertToInt(this.is_soft);
    }

    public int getLoad_retry_time() {
        return convertToInt(this.load_retry_time);
    }

    public int getM3u8_gzip() {
        return convertToInt(this.m3u8_gzip);
    }

    public int getMp_type() {
        return convertToInt(this.mp_type);
    }

    public int getOpen_timeout() {
        return convertToInt(this.open_timeout);
    }

    public String getPlayer_support() {
        return this.player_support;
    }

    public int getRender_type() {
        return convertToInt(this.render_type);
    }

    public int getRw_timeout() {
        return convertToInt(this.rw_timeout);
    }

    public int getTs_not_skip() {
        return convertToInt(this.ts_not_skip);
    }

    public int getWeak_net_speed() {
        return convertToInt(this.weak_net_speed);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mp_type);
        parcel.writeString(this.is_soft);
        parcel.writeString(this.render_type);
        parcel.writeString(this.accurate_seek);
        parcel.writeString(this.open_timeout);
        parcel.writeString(this.rw_timeout);
        parcel.writeString(this.addrinfo_type);
        parcel.writeString(this.addrinfo_timeout);
        parcel.writeString(this.buffer_timeout);
        parcel.writeString(this.ts_not_skip);
        parcel.writeString(this.load_retry_time);
        parcel.writeString(this.datasource_async);
        parcel.writeString(this.weak_net_speed);
        parcel.writeString(this.decodetype);
        parcel.writeString(this.dns_family_type);
        parcel.writeString(this.http_persistent);
        parcel.writeString(this.http_multiple);
        parcel.writeString(this.m3u8_gzip);
        parcel.writeString(this.player_support);
    }

    public VideoPlayerConfigNew(Parcel parcel) {
        this.mp_type = parcel.readString();
        this.is_soft = parcel.readString();
        this.render_type = parcel.readString();
        this.accurate_seek = parcel.readString();
        this.open_timeout = parcel.readString();
        this.rw_timeout = parcel.readString();
        this.addrinfo_type = parcel.readString();
        this.addrinfo_timeout = parcel.readString();
        this.buffer_timeout = parcel.readString();
        this.ts_not_skip = parcel.readString();
        this.load_retry_time = parcel.readString();
        this.datasource_async = parcel.readString();
        this.weak_net_speed = parcel.readString();
        this.decodetype = parcel.readString();
        this.dns_family_type = parcel.readString();
        this.http_persistent = parcel.readString();
        this.http_multiple = parcel.readString();
        this.m3u8_gzip = parcel.readString();
        this.player_support = parcel.readString();
    }
}
