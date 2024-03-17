package com.hunantv.media.widget;

import androidx.annotation.Nullable;
import com.hunantv.media.player.subtitle.SubtitleSource;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface ISubtitle {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface SubtitleCallback {
        void onError(SubtitleSource subtitleSource);

        void onSuccess(SubtitleSource subtitleSource);
    }

    void enableSubtitle(boolean z);

    @Nullable
    SubtitleSource getSubtitleSource();

    void removeSubtitleSource();

    void setSubtitleCallback(SubtitleCallback subtitleCallback);

    void setSubtitleSource(SubtitleSource subtitleSource);
}
