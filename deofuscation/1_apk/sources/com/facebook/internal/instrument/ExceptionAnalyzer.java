package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Callback;
import com.facebook.GraphRequest$Companion;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.huawei.hms.push.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.s0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.e.a.d;

/* compiled from: ExceptionAnalyzer.kt */
@b0(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/internal/instrument/ExceptionAnalyzer;", "", "()V", "enabled", "", "enable", "", "execute", e.a, "", "isDebug", "sendExceptionAnalysisReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ExceptionAnalyzer {
    @d
    public static final ExceptionAnalyzer INSTANCE = new ExceptionAnalyzer();
    private static boolean enabled;

    private ExceptionAnalyzer() {
    }

    @k
    public static final void enable() {
        enabled = true;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            INSTANCE.sendExceptionAnalysisReports();
        }
    }

    @k
    public static final void execute(@r.e.a.e Throwable th) {
        if (!enabled || isDebug() || th == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        StackTraceElement[] stackTrace = th.getStackTrace();
        f0.o(stackTrace, "e.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            f0.o(stackTraceElement, "it");
            String className = stackTraceElement.getClassName();
            f0.o(className, "it.className");
            FeatureManager.Feature feature = FeatureManager.getFeature(className);
            if (feature != FeatureManager.Feature.Unknown) {
                FeatureManager.disableFeature(feature);
                hashSet.add(feature.toString());
            }
        }
        if (FacebookSdk.getAutoLogAppEventsEnabled() && (!hashSet.isEmpty())) {
            InstrumentData.Builder.build(new JSONArray((Collection) hashSet)).save();
        }
    }

    @VisibleForTesting
    @k
    public static final boolean isDebug() {
        return false;
    }

    @VisibleForTesting
    public final void sendExceptionAnalysisReports() {
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
        ArrayList arrayList = new ArrayList();
        for (File file : listExceptionAnalysisReportFiles) {
            final InstrumentData load = InstrumentData.Builder.load(file);
            if (load.isValid()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crash_shield", load.toString());
                    GraphRequest$Companion graphRequest$Companion = GraphRequest.Companion;
                    s0 s0Var = s0.a;
                    String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                    f0.o(format, "java.lang.String.format(format, *args)");
                    arrayList.add(graphRequest$Companion.newPostRequest(null, format, jSONObject, new GraphRequest$Callback() { // from class: com.facebook.internal.instrument.ExceptionAnalyzer$sendExceptionAnalysisReports$request$1
                        @Override // com.facebook.GraphRequest$Callback
                        public final void onCompleted(@d GraphResponse graphResponse) {
                            JSONObject jsonObject;
                            f0.p(graphResponse, "response");
                            try {
                                if (graphResponse.getError() == null && (jsonObject = graphResponse.getJsonObject()) != null && jsonObject.getBoolean(GraphResponse.SUCCESS_KEY)) {
                                    InstrumentData.this.clear();
                                }
                            } catch (JSONException unused) {
                            }
                        }
                    }));
                } catch (JSONException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        new GraphRequestBatch(arrayList).executeAsync();
    }
}
