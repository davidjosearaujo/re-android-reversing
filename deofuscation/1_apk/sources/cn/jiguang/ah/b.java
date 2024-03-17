package cn.jiguang.ah;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import j.l.c.e0.a.a.f;
import java.util.List;

@SuppressLint({"MissingPermission"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private Context a;
    private final TelephonyManager b;
    private cn.jiguang.ai.a c;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends PhoneStateListener {
        private a() {
            b.this = r1;
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            cn.jiguang.ai.a aVar;
            int networkId;
            try {
                super.onSignalStrengthsChanged(signalStrength);
                b.this.c.f = signalStrength.getGsmSignalStrength();
                TelephonyManager unused = b.this.b;
                CellLocation c = f.c();
                if (c == null) {
                    return;
                }
                if (!(c instanceof GsmCellLocation)) {
                    if (c instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) c;
                        b.this.c.e = cdmaCellLocation.getBaseStationId();
                        aVar = b.this.c;
                        networkId = cdmaCellLocation.getNetworkId();
                    }
                    b.this.b.listen(this, 0);
                }
                GsmCellLocation gsmCellLocation = (GsmCellLocation) c;
                b.this.c.e = gsmCellLocation.getCid();
                aVar = b.this.c;
                networkId = gsmCellLocation.getLac();
                aVar.d = networkId;
                b.this.b.listen(this, 0);
            } catch (Throwable unused2) {
            }
        }
    }

    public b(Context context) {
        this.a = context;
        this.b = (TelephonyManager) context.getSystemService("phone");
    }

    public cn.jiguang.ai.a a() {
        return this.c;
    }

    public void b() {
        if (this.b == null) {
            cn.jiguang.ak.a.d("JLocationCell", "get telephonyManager failed");
            return;
        }
        cn.jiguang.ai.a aVar = new cn.jiguang.ai.a();
        this.c = aVar;
        aVar.a = cn.jiguang.n.d.h(this.a);
        String networkOperator = this.b.getNetworkOperator();
        if (networkOperator.length() > 3) {
            this.c.b = Integer.parseInt(networkOperator.substring(0, 3));
            this.c.c = Integer.parseInt(networkOperator.substring(3));
        }
        this.c.i = this.b.getNetworkOperatorName();
        this.c.g = cn.jiguang.n.d.a(this.b.getNetworkType());
        this.c.h = cn.jiguang.n.d.a(this.a, this.b.getNetworkType());
        if (Build.VERSION.SDK_INT <= 17) {
            this.b.listen(new a(), 256);
            return;
        }
        List<CellInfo> a2 = f.a();
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        for (CellInfo cellInfo : a2) {
            if (cellInfo != null) {
                if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                    CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                    this.c.f = cellSignalStrength.getDbm();
                    this.c.e = cellIdentity.getCi();
                    this.c.d = cellIdentity.getTac();
                    if (this.c.e < 268435455) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellSignalStrengthGsm cellSignalStrength2 = cellInfoGsm.getCellSignalStrength();
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    this.c.f = cellSignalStrength2.getDbm();
                    this.c.e = cellIdentity2.getCid();
                    this.c.d = cellIdentity2.getLac();
                    if (this.c.e < 65535) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellSignalStrengthCdma cellSignalStrength3 = cellInfoCdma.getCellSignalStrength();
                    CellIdentityCdma cellIdentity3 = cellInfoCdma.getCellIdentity();
                    this.c.f = cellSignalStrength3.getDbm();
                    this.c.e = cellIdentity3.getBasestationId();
                    this.c.d = cellIdentity3.getNetworkId();
                    if (this.c.e < 65535) {
                        return;
                    }
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellSignalStrengthWcdma cellSignalStrength4 = cellInfoWcdma.getCellSignalStrength();
                    CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    this.c.f = cellSignalStrength4.getDbm();
                    this.c.e = cellIdentity4.getCid();
                    this.c.d = cellIdentity4.getLac();
                    if (this.c.e < 268435455) {
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
