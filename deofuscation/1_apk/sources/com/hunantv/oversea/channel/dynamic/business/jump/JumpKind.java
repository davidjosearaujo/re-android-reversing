package com.hunantv.oversea.channel.dynamic.business.jump;

import com.huawei.hms.api.ConnectionResult;
import com.hunantv.media.player.libnative.ImgoMediaPlayerLib;
import j.l.a.b0.c0;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum JumpKind {
    KIND_ERROR(-1),
    KIND_NONE(0),
    KIND_COLLECT(1),
    KIND_PL(2),
    KIND_ACTIVITY(3),
    KIND_ST(4),
    KIND_FL(5),
    KIND_OTHER(6),
    KIND_CHANNEL(7),
    KIND_ARTIST(8),
    KIND_H5(9),
    KIND_BROWSER(10),
    KIND_SVIDEO(11),
    KIND_COLLECT_VIDEO(12),
    KIND_PL_VIDEO(13),
    KIND_LIVE_MULT(14),
    KIND_LIVE_H5(15),
    KIND_CHANNEL_LIST(16),
    KIND_CHANNEL_RANK(17),
    KIND_LIVE_ACTOR_ROOM(18),
    KIND_PAY(19),
    KIND_GAME_DETAIL(20),
    KIND_SINGLE_FL(21),
    KIND_IMMERSIVE(23),
    KIND_LOCATION(24),
    KIND_NEWS_FEED(25),
    KIND_SCHEMA_OR_URL(27),
    KIND_INTERACTVOD(28),
    KIND_INTERACTVOD_VID(29),
    KIND_AUDIO_LIVE(30),
    KIND_CHAT_ROOM(33),
    KIND_MINI_PLAY(35),
    KIND_MINI_PLAY_SINGLE(36),
    KIND_TOPIC_DETAIL(ConnectionResult.RESOLUTION_REQUIRED),
    KIND_COLUM_PLAYLIST(ImgoMediaPlayerLib.FFP_PROP_INT64_SELECTED_VIDEO_STREAM),
    KIND_COLUM_LIST(ImgoMediaPlayerLib.FFP_PROP_INT64_SELECTED_AUDIO_STREAM),
    KIND_COLUM_HOT(ImgoMediaPlayerLib.FFP_PROP_INT64_VIDEO_DECODER),
    KIND_HOT_UP(ImgoMediaPlayerLib.FFP_PROP_INT64_AUDIO_DECODER),
    KIND_FANTUAN_MAIN(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED),
    KIND_DYNAMIC_DETAIL(ConnectionResult.RESTRICTED_PROFILE),
    KIND_CREATE_VOTE(ConnectionResult.SERVICE_UPDATING),
    KIND_FANTUAN_STAR(ConnectionResult.SIGN_IN_FAILED);
    
    private int value;

    JumpKind(int i) {
        this.value = i;
    }

    public static JumpKind from(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                int g = c0.g(str.trim().toLowerCase(Locale.getDefault()), 0);
                if (g != 33) {
                    if (g != 35) {
                        if (g != 36) {
                            switch (g) {
                                case 0:
                                    return KIND_NONE;
                                case 1:
                                    return KIND_COLLECT;
                                case 2:
                                    return KIND_PL;
                                case 3:
                                    return KIND_ACTIVITY;
                                case 4:
                                    return KIND_ST;
                                case 5:
                                    return KIND_FL;
                                case 6:
                                    return KIND_OTHER;
                                case 7:
                                    return KIND_CHANNEL;
                                case 8:
                                    return KIND_ARTIST;
                                case 9:
                                    return KIND_H5;
                                case 10:
                                    return KIND_BROWSER;
                                case 11:
                                    return KIND_SVIDEO;
                                case 12:
                                    return KIND_COLLECT_VIDEO;
                                case 13:
                                    return KIND_PL_VIDEO;
                                case 14:
                                    return KIND_LIVE_MULT;
                                case 15:
                                    return KIND_LIVE_H5;
                                case 16:
                                    return KIND_CHANNEL_LIST;
                                case 17:
                                    return KIND_CHANNEL_RANK;
                                case 18:
                                    return KIND_LIVE_ACTOR_ROOM;
                                case 19:
                                    return KIND_PAY;
                                case 20:
                                    return KIND_GAME_DETAIL;
                                case 21:
                                    return KIND_SINGLE_FL;
                                default:
                                    switch (g) {
                                        case 23:
                                            return KIND_IMMERSIVE;
                                        case 24:
                                            return KIND_LOCATION;
                                        case 25:
                                            return KIND_NEWS_FEED;
                                        default:
                                            switch (g) {
                                                case 27:
                                                    return KIND_SCHEMA_OR_URL;
                                                case 28:
                                                    return KIND_INTERACTVOD;
                                                case 29:
                                                    return KIND_INTERACTVOD_VID;
                                                case 30:
                                                    return KIND_AUDIO_LIVE;
                                                default:
                                                    switch (g) {
                                                        case ConnectionResult.RESOLUTION_REQUIRED /* 9001 */:
                                                            return KIND_TOPIC_DETAIL;
                                                        case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                                                            return KIND_FANTUAN_MAIN;
                                                        case ConnectionResult.RESTRICTED_PROFILE /* 9003 */:
                                                            return KIND_DYNAMIC_DETAIL;
                                                        case ConnectionResult.SERVICE_UPDATING /* 9004 */:
                                                            return KIND_CREATE_VOTE;
                                                        case ConnectionResult.SIGN_IN_FAILED /* 9005 */:
                                                            return KIND_FANTUAN_STAR;
                                                        default:
                                                            switch (g) {
                                                                case ImgoMediaPlayerLib.FFP_PROP_INT64_SELECTED_VIDEO_STREAM /* 20001 */:
                                                                    return KIND_COLUM_PLAYLIST;
                                                                case ImgoMediaPlayerLib.FFP_PROP_INT64_SELECTED_AUDIO_STREAM /* 20002 */:
                                                                    return KIND_COLUM_LIST;
                                                                case ImgoMediaPlayerLib.FFP_PROP_INT64_VIDEO_DECODER /* 20003 */:
                                                                    return KIND_COLUM_HOT;
                                                                case ImgoMediaPlayerLib.FFP_PROP_INT64_AUDIO_DECODER /* 20004 */:
                                                                    return KIND_HOT_UP;
                                                                default:
                                                                    return KIND_ERROR;
                                                            }
                                                    }
                                            }
                                    }
                            }
                        }
                        return KIND_MINI_PLAY_SINGLE;
                    }
                    return KIND_MINI_PLAY;
                }
                return KIND_CHAT_ROOM;
            } catch (Exception unused) {
                return KIND_ERROR;
            }
        }
        return KIND_NONE;
    }

    public int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.valueOf(this.value);
    }
}
