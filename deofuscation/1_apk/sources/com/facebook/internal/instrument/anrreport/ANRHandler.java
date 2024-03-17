package com.facebook.internal.instrument.anrreport;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest$Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt___CollectionsKt;
import n.b0;
import n.b2.l0;
import n.l2.k;
import n.l2.v.f0;
import n.p2.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.e.a.d;

/* compiled from: ANRHandler.kt */
@b0(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRHandler;", "", "()V", "MAX_ANR_REPORT_NUM", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enable", "", "sendANRReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ANRHandler {
    private static final int MAX_ANR_REPORT_NUM = 5;
    @d
    public static final ANRHandler INSTANCE = new ANRHandler();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    private ANRHandler() {
    }

    @k
    public static final synchronized void enable() {
        synchronized (ANRHandler.class) {
            if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
                return;
            }
            if (enabled.getAndSet(true)) {
                return;
            }
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                sendANRReports();
            }
            ANRDetector.start();
        }
    }

    @VisibleForTesting
    @k
    public static final void sendANRReports() {
        if (CrashShieldHandler.isObjectCrashing(ANRHandler.class)) {
            return;
        }
        try {
            if (Utility.isDataProcessingRestricted()) {
                return;
            }
            File[] listAnrReportFiles = InstrumentUtility.listAnrReportFiles();
            ArrayList arrayList = new ArrayList(listAnrReportFiles.length);
            for (File file : listAnrReportFiles) {
                arrayList.add(InstrumentData.Builder.load(file));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((InstrumentData) obj).isValid()) {
                    arrayList2.add(obj);
                }
            }
            final List h5 = CollectionsKt___CollectionsKt.h5(arrayList2, new Comparator() { // from class: com.facebook.internal.instrument.anrreport.ANRHandler$sendANRReports$validReports$3
                @Override // java.util.Comparator
                public final int compare(InstrumentData instrumentData, InstrumentData instrumentData2) {
                    f0.o(instrumentData2, "o2");
                    return instrumentData.compareTo(instrumentData2);
                }
            });
            JSONArray jSONArray = new JSONArray();
            l0 it = q.n1(0, Math.min(h5.size(), 5)).iterator();
            while (it.hasNext()) {
                jSONArray.put(h5.get(it.nextInt()));
            }
            InstrumentUtility.sendReports("anr_reports", jSONArray, new GraphRequest$Callback() { // from class: com.facebook.internal.instrument.anrreport.ANRHandler$sendANRReports$2
                @Override // com.facebook.GraphRequest$Callback
                public final void onCompleted(@d GraphResponse graphResponse) {
                    JSONObject jsonObject;
                    f0.p(graphResponse, "response");
                    try {
                        if (graphResponse.getError() == null && (jsonObject = graphResponse.getJsonObject()) != null && jsonObject.getBoolean(GraphResponse.SUCCESS_KEY)) {
                            for (InstrumentData instrumentData : h5) {
                                instrumentData.clear();
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRHandler.class);
        }
    }
}
