package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.agconnect.core.ServiceDiscovery;
import j.k.a.k.c;
import j.k.a.k.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private final Context a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    public b(Context context) {
        this.a = context;
    }

    private <T extends d> T a(String str) {
        StringBuilder sb;
        String localizedMessage;
        String sb2;
        try {
            Class<?> cls = Class.forName(str);
            if (d.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            Log.e("ServiceRegistrarParser", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e) {
            sb2 = "Can not found service class, " + e.getMessage();
            Log.e("ServiceRegistrarParser", sb2);
            return null;
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            localizedMessage = e2.getLocalizedMessage();
            sb.append(localizedMessage);
            sb2 = sb.toString();
            Log.e("ServiceRegistrarParser", sb2);
            return null;
        } catch (InstantiationException e3) {
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            localizedMessage = e3.getLocalizedMessage();
            sb.append(localizedMessage);
            sb2 = sb.toString();
            Log.e("ServiceRegistrarParser", sb2);
            return null;
        }
    }

    private List<String> c() {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle d = d();
        if (d == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String str : d.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(d.getString(str))) {
                String[] split = str.split(CertificateUtil.DELIMITER);
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e) {
                        sb = new StringBuilder();
                        sb.append("registrar configuration format error:");
                        str = e.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb = new StringBuilder();
                    sb.append("registrar configuration error, ");
                    sb.append(str);
                    Log.e("ServiceRegistrarParser", sb.toString());
                }
            }
        }
        ArrayList<Map.Entry> arrayList2 = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList2, new a());
        for (Map.Entry entry : arrayList2) {
            arrayList.add(entry.getKey());
        }
        return arrayList;
    }

    private Bundle d() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.a, ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ServiceRegistrarParser", "get ServiceDiscovery exception." + e.getLocalizedMessage());
        }
        if (serviceInfo == null) {
            Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
            return null;
        }
        return serviceInfo.metaData;
    }

    public List<c> b() {
        Log.i("ServiceRegistrarParser", "getServices");
        List<String> c = c();
        ArrayList arrayList = new ArrayList();
        for (String str : c) {
            d a2 = a(str);
            if (a2 != null) {
                a2.b(this.a);
                List a3 = a2.a(this.a);
                if (a3 != null) {
                    arrayList.addAll(a3);
                }
            }
        }
        Log.i("ServiceRegistrarParser", "services:" + Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
