package cn.jpush.android.helper;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JDispatchAction;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.local.JPushResponse;
import cn.jpush.android.t.a;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.nio.ByteBuffer;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends JDispatchAction {
    @Override // cn.jiguang.api.JDispatchAction
    public Object beforLogin(Context context, String str, int i, String str2) {
        return ActionHelper.getInstance().beforLogin(context, str, i, str2);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i, int i2, long j, long j2, ByteBuffer byteBuffer) {
        Logger.d("JPushDispacthAction", "dispatchMessage command:" + i + ",ver:" + i2 + ",rid:" + j + ",requestid:" + j2);
        ActionHelper.getInstance().doAction(context, "msg", new JPushResponse(i, j, j2, byteBuffer));
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchTimeOutMessage(Context context, String str, long j, int i) {
        Bundle bundle = new Bundle();
        bundle.putLong("rid", j);
        bundle.putInt("cmd", i);
        ActionHelper.getInstance().doAction(context, "msg_time_out", bundle);
    }

    public Object getDataByCmd(Context context, int i) {
        if (i != 30000) {
            if (30001 == i) {
                return "sdk_ver_local";
            }
            if (30002 == i) {
                return JPushConstants.SDK_VERSION_NAME;
            }
            return null;
        }
        String b = a.C0017a.b();
        Logger.d("JPushDispacthAction", "core get push animator config file version: " + b);
        return b;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Bundle getPInfo(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("pid", 2);
        bundle.putString(JThirdPlatFormInterface.KEY_CODE, JPushConstants.SDK_VERSION_CODE + "");
        return bundle;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return HiAnalyticsConstant.BI_KEY_SDK_VER;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return ActionHelper.getInstance().getSdkVersion(str);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
        ActionHelper.getInstance().doAction(context, "handle_msg", obj);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i) {
        return ActionHelper.getInstance().isSupportedCMD(str, i);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        ActionHelper.getInstance().doAction(context, str2, bundle);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onEvent(Context context, String str, int i, int i2, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putInt(JThirdPlatFormInterface.KEY_CODE, i2);
        bundle.putString("msg", str2);
        ActionHelper.getInstance().doAction(context, "jcore_on_event", bundle);
    }
}
