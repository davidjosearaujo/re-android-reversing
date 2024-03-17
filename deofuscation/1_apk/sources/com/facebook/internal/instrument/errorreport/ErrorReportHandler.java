package com.facebook.internal.instrument.errorreport;

import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest$Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.text.Regex;
import n.b0;
import n.b2.x;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.s0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.e.a.d;
import r.e.a.e;

/* compiled from: ErrorReportHandler.kt */
@b0(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportHandler;", "", "()V", "MAX_ERROR_REPORT_NUM", "", "enable", "", "listErrorReportFiles", "", "Ljava/io/File;", "()[Ljava/io/File;", "save", "msg", "", "sendErrorReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ErrorReportHandler {
    @d
    public static final ErrorReportHandler INSTANCE = new ErrorReportHandler();
    private static final int MAX_ERROR_REPORT_NUM = 1000;

    private ErrorReportHandler() {
    }

    @k
    public static final void enable() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    @d
    @k
    public static final File[] listErrorReportFiles() {
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir != null) {
            File[] listFiles = instrumentReportDir.listFiles(new FilenameFilter() { // from class: com.facebook.internal.instrument.errorreport.ErrorReportHandler$listErrorReportFiles$1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    f0.o(str, "name");
                    s0 s0Var = s0.a;
                    String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{InstrumentUtility.ERROR_REPORT_PREFIX}, 1));
                    f0.o(format, "java.lang.String.format(format, *args)");
                    return new Regex(format).matches(str);
                }
            });
            f0.o(listFiles, "reportDir.listFiles { di…OR_REPORT_PREFIX)))\n    }");
            return listFiles;
        }
        return new File[0];
    }

    @k
    public static final void save(@e String str) {
        try {
            new ErrorReportData(str).save();
        } catch (Exception unused) {
        }
    }

    @k
    public static final void sendErrorReports() {
        if (Utility.isDataProcessingRestricted()) {
            return;
        }
        File[] listErrorReportFiles = listErrorReportFiles();
        final ArrayList arrayList = new ArrayList();
        for (File file : listErrorReportFiles) {
            ErrorReportData errorReportData = new ErrorReportData(file);
            if (errorReportData.isValid()) {
                arrayList.add(errorReportData);
            }
        }
        x.p0(arrayList, new Comparator() { // from class: com.facebook.internal.instrument.errorreport.ErrorReportHandler$sendErrorReports$1
            @Override // java.util.Comparator
            public final int compare(ErrorReportData errorReportData2, ErrorReportData errorReportData3) {
                f0.o(errorReportData3, "o2");
                return errorReportData2.compareTo(errorReportData3);
            }
        });
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size() && i < 1000; i++) {
            jSONArray.put(arrayList.get(i));
        }
        InstrumentUtility.sendReports("error_reports", jSONArray, new GraphRequest$Callback() { // from class: com.facebook.internal.instrument.errorreport.ErrorReportHandler$sendErrorReports$2
            @Override // com.facebook.GraphRequest$Callback
            public final void onCompleted(@d GraphResponse graphResponse) {
                JSONObject jsonObject;
                f0.p(graphResponse, "response");
                try {
                    if (graphResponse.getError() == null && (jsonObject = graphResponse.getJsonObject()) != null && jsonObject.getBoolean(GraphResponse.SUCCESS_KEY)) {
                        for (ErrorReportData errorReportData2 : arrayList) {
                            errorReportData2.clear();
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }
}
