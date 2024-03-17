package cn.jiguang.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.ar.c;
import cn.jiguang.ax.e;
import cn.jiguang.ax.h;
import cn.jiguang.ax.k;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends JDispatchAction {
    private static JSONObject a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(byteBuffer.array());
            wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            c.c("JCoreDispatchAction", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e) {
            c.g("JCoreDispatchAction", "parseBundle2Json exception:" + e.getMessage());
            return null;
        }
    }

    private void a(Context context, long j, int i, ByteBuffer byteBuffer) {
        if (i == 19) {
            h.a().a(context, "tcp_a18", null);
        } else if (i == 30 || i == 32) {
            cn.jiguang.e.a.b().a(context, 0, i);
        } else if (i == 25) {
            a(context, byteBuffer);
        } else if (i == 26 && byteBuffer != null) {
            short s = byteBuffer.getShort();
            if (s == 0) {
                k.a().a(context, j);
            } else {
                k.a().a(context, j, s);
            }
        }
    }

    private void a(Context context, ByteBuffer byteBuffer) {
        JSONObject a = a(byteBuffer);
        if (a == null) {
            return;
        }
        try {
            int optInt = a.optInt("cmd");
            JSONObject optJSONObject = a.optJSONObject("content");
            String jSONObject = optJSONObject != null ? optJSONObject.toString() : "";
            c.c("JCoreDispatchAction", "deal command, cmd: " + optInt + ", content: " + jSONObject);
            if (optInt == 75) {
                h.a().a(optJSONObject);
            } else if (optInt == 80) {
                cn.jiguang.aq.b.a(context, optJSONObject);
            }
            Bundle bundle = new Bundle();
            bundle.putByteArray("RESPONSE_BODY", byteBuffer.array());
            e.a(context, "cmd", bundle);
        } catch (Throwable th) {
            c.g("JCoreDispatchAction", "deal command failed, " + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i, int i2, long j, long j2, ByteBuffer byteBuffer) {
        try {
            a(context, j2, i, byteBuffer);
        } catch (Throwable th) {
            c.g("JCoreDispatchAction", "dispatchMessage failed:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return "core_sdk_ver";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return cn.jiguang.a.a.b;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i) {
        return i == 0 || i == 1 || i == 19 || i == 25 || i == 26 || i == 30 || i == 32;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        if (bundle != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (str2.equals("asm")) {
                    cn.jiguang.e.a.b().a(context, bundle);
                } else if (str2.equals("asmr")) {
                    cn.jiguang.e.a.b().b(context, bundle);
                } else if (str2.equals("lbsenable")) {
                    e.a(context, str2, bundle);
                    if (bundle != null) {
                        cn.jiguang.g.b.a(context, cn.jiguang.g.a.z().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(bundle.getBoolean("enable"))));
                    }
                } else if (!str2.equals("lbsforenry")) {
                    if (!str2.equals("notification_state") && !str2.equals("old_cmd") && !str2.equals("user_present") && !str2.equals("set_wake_enable")) {
                        return;
                    }
                    e.a(context, str2, bundle);
                } else {
                    long j = bundle.getLong("forenry");
                    c.c("JCoreDispatchAction", "setLbsPermissionDialogShieldDelay=" + j);
                    if (((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue() <= 0) {
                        cn.jiguang.g.b.a(context, cn.jiguang.g.a.x().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
                    }
                    cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[1];
                    aVarArr[0] = cn.jiguang.g.a.y().a((cn.jiguang.g.a<Long>) (j > 0 ? Long.valueOf(j) : null));
                    cn.jiguang.g.b.a(context, aVarArr);
                }
            } catch (Throwable th) {
                c.g("JCoreDispatchAction", "onActionRun failed:" + th.getMessage());
            }
        }
    }
}
