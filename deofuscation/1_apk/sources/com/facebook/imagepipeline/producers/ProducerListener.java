package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface ProducerListener {
    void onProducerEvent(String str, String str2, String str3);

    void onProducerFinishWithCancellation(String str, String str2, @Nullable Map<String, String> map);

    void onProducerFinishWithFailure(String str, String str2, Throwable th, @Nullable Map<String, String> map);

    void onProducerFinishWithSuccess(String str, String str2, @Nullable Map<String, String> map);

    void onProducerStart(String str, String str2);

    void onUltimateProducerReached(String str, String str2, boolean z);

    boolean requiresExtraMap(String str);
}
