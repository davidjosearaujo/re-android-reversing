package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.facebook.internal.instrument.threadcheck.ThreadCheckHandler;
import n.b0;
import n.l2.k;
import r.e.a.d;

/* compiled from: InstrumentManager.kt */
@b0(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/internal/instrument/InstrumentManager;", "", "()V", "start", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class InstrumentManager {
    @d
    public static final InstrumentManager INSTANCE = new InstrumentManager();

    private InstrumentManager() {
    }

    @k
    public static final void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, new FeatureManager.Callback() { // from class: com.facebook.internal.instrument.InstrumentManager$start$1
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    if (z) {
                        CrashHandler.Companion.enable();
                        if (FeatureManager.isEnabled(FeatureManager.Feature.CrashShield)) {
                            ExceptionAnalyzer.enable();
                            CrashShieldHandler.enable();
                        }
                        if (FeatureManager.isEnabled(FeatureManager.Feature.ThreadCheck)) {
                            ThreadCheckHandler.enable();
                        }
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() { // from class: com.facebook.internal.instrument.InstrumentManager$start$2
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    if (z) {
                        ErrorReportHandler.enable();
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.AnrReport, new FeatureManager.Callback() { // from class: com.facebook.internal.instrument.InstrumentManager$start$3
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z) {
                    if (z) {
                        ANRHandler.enable();
                    }
                }
            });
        }
    }
}
