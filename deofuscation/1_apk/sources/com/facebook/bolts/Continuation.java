package com.facebook.bolts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface Continuation<TTaskResult, TContinuationResult> {
    @Nullable
    TContinuationResult then(@NonNull Task<TTaskResult> task) throws Exception;
}
