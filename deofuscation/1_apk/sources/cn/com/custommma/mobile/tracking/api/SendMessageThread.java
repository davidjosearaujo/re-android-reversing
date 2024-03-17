package cn.com.custommma.mobile.tracking.api;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.com.custommma.mobile.tracking.util.CommonUtil;
import cn.com.custommma.mobile.tracking.util.ConnectUtil;
import cn.com.custommma.mobile.tracking.util.DeviceInfoUtil;
import cn.com.custommma.mobile.tracking.util.Logger;
import cn.com.custommma.mobile.tracking.util.SharedPreferencedUtil;
import java.util.HashSet;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SendMessageThread extends Thread {
    private ConnectUtil connectUtil;
    private Context context;
    private boolean isInterruptThread = false;
    private boolean isNormalList;
    private Object object;
    private HashSet<String> requestList;
    private String spName;

    public SendMessageThread(String str, Context context, boolean z) {
        this.connectUtil = null;
        this.object = null;
        this.requestList = null;
        this.spName = str;
        this.context = context;
        this.isNormalList = z;
        this.requestList = new HashSet<>();
        this.connectUtil = ConnectUtil.getInstance();
        this.object = new Object();
    }

    private void handleFailedResult(String str, long j) {
        if (this.isNormalList) {
            SharedPreferencedUtil.removeFromSharedPreferences(this.context, SharedPreferencedUtil.SP_NAME_NORMAL, str);
            SharedPreferencedUtil.putLong(this.context, SharedPreferencedUtil.SP_NAME_FAILED, str, j);
            SharedPreferencedUtil.putLong(this.context, SharedPreferencedUtil.SP_NAME_OTHER, str, 1L);
        } else {
            long j2 = SharedPreferencedUtil.getLong(this.context, SharedPreferencedUtil.SP_NAME_OTHER, str) + 1;
            if (j2 > 3) {
                SharedPreferencedUtil.removeFromSharedPreferences(this.context, SharedPreferencedUtil.SP_NAME_FAILED, str);
                SharedPreferencedUtil.removeFromSharedPreferences(this.context, SharedPreferencedUtil.SP_NAME_OTHER, str);
            } else {
                SharedPreferencedUtil.putLong(this.context, SharedPreferencedUtil.SP_NAME_OTHER, str, j2);
            }
        }
        this.requestList.remove(str);
    }

    private void handleSuccessResult(String str, String str2) {
        SharedPreferencedUtil.removeFromSharedPreferences(this.context, str, str2);
        if (!this.isNormalList) {
            SharedPreferencedUtil.removeFromSharedPreferences(this.context, SharedPreferencedUtil.SP_NAME_OTHER, str2);
        }
        this.requestList.remove(str2);
    }

    private synchronized void sendData() {
        synchronized (this.object) {
            for (String str : SharedPreferencedUtil.getSharedPreferences(this.context, this.spName).getAll().keySet()) {
                if (this.isInterruptThread || !DeviceInfoUtil.isNetworkAvailable(this.context)) {
                    return;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        continue;
                    } else {
                        long j = SharedPreferencedUtil.getLong(this.context, this.spName, str);
                        if (j > System.currentTimeMillis()) {
                            if (this.requestList.contains(str)) {
                                return;
                            }
                            this.requestList.add(str);
                            if (this.connectUtil.performGet(str) == null) {
                                handleFailedResult(str, j);
                                return;
                            }
                            Logger.i("record [" + CommonUtil.md5(str) + "] upload succeed.");
                            handleSuccessResult(this.spName, str);
                            if (Countly.LOCAL_TEST) {
                                this.context.sendBroadcast(new Intent(Countly.ACTION_STATS_SUCCESSED));
                            }
                        } else {
                            SharedPreferencedUtil.removeFromSharedPreferences(this.context, this.spName, str);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // java.lang.Thread
    public void interrupt() {
        this.isInterruptThread = true;
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        sendData();
    }
}
