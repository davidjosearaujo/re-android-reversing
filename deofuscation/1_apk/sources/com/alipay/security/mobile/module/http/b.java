package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b implements Runnable {
    public final /* synthetic */ DataReportRequest a;
    public final /* synthetic */ c b;

    public b(c cVar, DataReportRequest dataReportRequest) {
        this.b = cVar;
        this.a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        try {
            dataReportService = this.b.c;
            DataReportResult unused = c.e = dataReportService.reportData(this.a);
        } catch (Throwable th) {
            DataReportResult unused2 = c.e = new DataReportResult();
            dataReportResult = c.e;
            dataReportResult.success = false;
            dataReportResult2 = c.e;
            dataReportResult2.resultCode = "static data rpc upload error, " + com.alipay.security.mobile.module.a.a.a(th);
            new StringBuilder("rpc failed:").append(com.alipay.security.mobile.module.a.a.a(th));
        }
    }
}