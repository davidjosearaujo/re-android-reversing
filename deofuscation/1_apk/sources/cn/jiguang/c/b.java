package cn.jiguang.c;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.aq.d;
import cn.jiguang.ar.c;
import cn.jiguang.as.f;
import cn.jiguang.ax.e;
import cn.jiguang.ax.h;
import cn.jiguang.dy.JDynamicLoadBase;
import cn.jiguang.f.g;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreHelperAction;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b extends JCoreHelperAction {
    private static final String[] b = {"JDevice", "JWakeCmd", "JWake", "JCommon", "JArp", "JLocation"};
    private boolean c = false;
    public boolean a = false;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements Callable<Map<String, String>> {
        private Context b;
        private Integer c;

        public a(Context context, Integer num) {
            b.this = r1;
            this.b = context;
            this.c = num;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Map<String, String> call() {
            return JDynamicLoadBase.getPathMap(this.b, this.c.intValue());
        }
    }

    /* renamed from: cn.jiguang.c.b$b */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class C0006b extends cn.jiguang.be.b {
        private Context b;
        private Intent c;
        private String d;

        public C0006b(Context context, Intent intent, String str) {
            b.this = r1;
            this.b = context;
            this.d = str;
            this.c = intent;
            this.h = "JCoreHelper#PushReceiverAction";
        }

        @Override // cn.jiguang.be.b
        public void a() {
            try {
                ActionManager.getInstance().handleMessage(this.b, this.d, this.c);
                b.this.a(this.b, this.c);
            } catch (Throwable th) {
                c.i("JCoreHelper", "[PushReceiverAction failed:]" + th.getMessage());
            }
        }
    }

    private static Bundle a(Context context, int i, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            if (i == 4096) {
                if (bundle != null) {
                    a(context, cn.jiguang.aq.a.a(bundle, "arg1"));
                }
                return bundle2;
            } else if (i == 4098) {
                JCoreManager.init(context);
                return bundle2;
            } else {
                switch (i) {
                    case 36864:
                        a(bundle);
                        return null;
                    case 36865:
                        if (JCoreManager.isInternal()) {
                            JConstants.testAndroidQ();
                        }
                        return null;
                    default:
                        return null;
                }
            }
        } catch (Throwable th) {
            c.i("JCoreHelper", "si e:" + th);
            return null;
        }
    }

    public static Object a(Context context) {
        return e.a(context, "deviceinfo", null);
    }

    public void a(Context context, Intent intent) {
        Method declaredMethod;
        Boolean bool;
        boolean z;
        c.c("JCoreHelper", "[handleReceiverIntent]:" + intent.getAction());
        e.a(context, "get_receiver", intent);
        String action = intent.getAction();
        if (action == null) {
            c.g("JCoreHelper", "onReceive empty action");
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            c.e("JCoreHelper", "onReceiveandroid.intent.action.USER_PRESENT");
            cn.jiguang.a.a.a(context, true, 0L);
            a(context, JConstants.SDK_TYPE, "user_present", (Bundle) null);
        } else if (action.equals("android.intent.action.SCREEN_ON")) {
            cn.jiguang.a.a.a(context, false, 0L);
        } else if (action.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo == null) {
                c.g("JCoreHelper", "Not found networkInfo");
                return;
            }
            c.c("JCoreHelper", "Connection state changed to - " + networkInfo.toString());
            if (2 == networkInfo.getType() || 3 == networkInfo.getType()) {
                c.c("JCoreHelper", "MMS or SUPL network state change, to do nothing!");
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            if (booleanExtra) {
                c.c("JCoreHelper", "No any network is connected");
                extras.putBoolean("connected", false);
            } else {
                try {
                    if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                        c.c("JCoreHelper", "Network is connected.");
                        extras.putBoolean("connected", true);
                    } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                        c.c("JCoreHelper", "Network is disconnected.");
                        extras.putBoolean("connected", false);
                    } else {
                        c.c("JCoreHelper", "other network state - " + networkInfo.getState() + ". Do nothing.");
                    }
                } catch (Throwable unused) {
                    extras.putBoolean("connected", cn.jiguang.f.a.d(context));
                }
            }
            cn.jiguang.a.a.a(context, "tcp_a15", extras);
        } else if (!action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") && !action.equals("android.os.action.POWER_SAVE_MODE_CHANGED")) {
            if (action.equals("noti_open_proxy") && intent.getBooleanExtra("debug_notification", false)) {
                String stringExtra = intent.getStringExtra("toastText");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                Toast makeText = Toast.makeText(context, stringExtra, 0);
                try {
                    View view = makeText.getView();
                    if (view instanceof LinearLayout) {
                        View childAt = ((LinearLayout) view).getChildAt(0);
                        if (childAt instanceof TextView) {
                            TextView textView = (TextView) childAt;
                            if (!g.a(stringExtra)) {
                                textView.setText(stringExtra);
                            }
                            textView.setTextSize(13.0f);
                        }
                    }
                } catch (Exception unused2) {
                }
                makeText.show();
            }
        } else {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                try {
                    Class<?> cls = Class.forName("android.os.PowerManager");
                    if (cls != null) {
                        if (action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) {
                            Method declaredMethod2 = cls.getDeclaredMethod("isDeviceIdleMode", new Class[0]);
                            if (declaredMethod2 != null) {
                                bool = (Boolean) declaredMethod2.invoke(powerManager, new Object[0]);
                                z = bool.booleanValue();
                            }
                            z = true;
                        } else {
                            if (action.equals("android.os.action.POWER_SAVE_MODE_CHANGED") && (declaredMethod = cls.getDeclaredMethod("isPowerSaveMode", new Class[0])) != null) {
                                bool = (Boolean) declaredMethod.invoke(powerManager, new Object[0]);
                                z = bool.booleanValue();
                            }
                            z = true;
                        }
                        if (z) {
                            return;
                        }
                        c.c("JCoreHelper", "doze or powersave mode exit.");
                        cn.jiguang.a.a.a(context, true, 0L);
                    }
                } catch (Throwable th) {
                    c.i("JCoreHelper", "handle DEVICE_IDLE_MODE_CHANGED or POWER_SAVE_MODE_CHANGED fail:" + th);
                }
            }
        }
    }

    private static void a(Context context, Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            try {
                c.c("JCoreHelper", "setSDKConfigs");
                int i = RemoteMessageConst.DEFAULT_TTL;
                try {
                    int i2 = bundle.getInt("heartbeat_interval", JConstants.DEFAULT_HEARTBEAT_INTERVAL);
                    if (i2 < 30) {
                        i2 = 30;
                    } else if (i2 > 86400) {
                        i2 = RemoteMessageConst.DEFAULT_TTL;
                    }
                    JConstants.DEFAULT_HEARTBEAT_INTERVAL = i2;
                    c.c("JCoreHelper", "set heartbeat interval=" + i2);
                } catch (Throwable unused) {
                }
                try {
                    int i3 = bundle.getInt("alarm_delay", JConstants.DEFAULT_ALARM_DELAY);
                    if (i3 <= 86400) {
                        i = i3;
                    }
                    int i4 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
                    if (i < i4 + 5) {
                        i = i4 + 5;
                    }
                    JConstants.DEFAULT_ALARM_DELAY = i;
                    c.c("JCoreHelper", "set alarm delay=" + i);
                } catch (Throwable unused2) {
                }
                byte b2 = (byte) bundle.getInt("tcp_algorithm", -1);
                if (b2 >= 0) {
                    JConstants.tcpAlgorithm = b2;
                    c.c("JCoreHelper", "set tcp algorithm=" + ((int) b2));
                }
                if (bundle.containsKey("tcp_report")) {
                    f.b = bundle.getBoolean("tcp_report");
                }
                if (bundle.containsKey("plugin_report_switch")) {
                    context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("plugin_report_switch", bundle.getBoolean("plugin_report_switch")).apply();
                }
                if (bundle.containsKey("plugin_multi_switch")) {
                    context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putBoolean("plugin_multi_switch", bundle.getBoolean("plugin_multi_switch")).apply();
                }
                int i5 = bundle.getInt("ipv_config", -1);
                cn.jiguang.ay.c.a(i5);
                if (i5 != 2 && i5 != 3) {
                    if (i5 == 0 || i5 == 1) {
                        f.c = true;
                        return;
                    }
                    return;
                }
                f.c = false;
            } catch (Throwable unused3) {
            }
        }
    }

    public static void a(Context context, String str) {
        cn.jiguang.aq.a.a(context, str);
    }

    public static void a(Context context, String str, int i, int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putInt("custom", i);
        bundle.putInt("dynamic", i2);
        bundle.putInt("sdk_v", i3);
        e.a(context, "set_sdktype_info", bundle);
    }

    public static void a(Context context, String str, Bundle bundle) {
        cn.jiguang.a.a.a(context, str, bundle);
    }

    private static void a(Context context, String str, Bundle bundle, String str2) {
        if (bundle != null) {
            bundle.putString(HianalyticsBaseData.SDK_TYPE, str);
            cn.jiguang.a.a.a(context, str2, bundle);
        }
    }

    public static void a(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        c.d("JCoreHelper", "runActionWithService action:" + str2);
        bundle.putString(HianalyticsBaseData.SDK_TYPE, str);
        bundle.putString("internal_action", str2);
        cn.jiguang.a.a.a(context, "a3", bundle);
    }

    public static void a(Bundle bundle) {
    }

    private static void a(String str, String str2, boolean z, int i, String str3, Throwable th) {
        cn.jiguang.ar.a.a(str, str2, z, i, str3, th);
    }

    private static void b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(HianalyticsBaseData.SDK_TYPE, str);
        cn.jiguang.a.a.a(context, "tcp_a8", bundle);
    }

    public static Pair<String, Integer> c(Context context) {
        return cn.jiguang.aq.a.d(context);
    }

    private static void c(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(HianalyticsBaseData.SDK_TYPE, str);
        cn.jiguang.a.a.a(context, "tcp_a9", bundle);
    }

    private static void c(Context context, String str, Bundle bundle) {
        if (bundle != null) {
            try {
                boolean z = bundle.getBoolean("sdk_banned");
                c.c("JCoreHelper", "[handleSdkBannedStatusChanged] sdk banned: " + z);
                if (z) {
                    b(context, str);
                    cn.jiguang.bb.b.a().b(JosStatusCodes.RTN_CODE_COMMON_ERROR);
                } else {
                    c(context, str);
                }
            } catch (Throwable th) {
                c.g("JCoreHelper", "network change handler error, " + th.getMessage());
            }
        }
    }

    private static void d(Context context, String str, Bundle bundle) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (bundle != null) {
            try {
                c.c("JCoreHelper", "[handleConnectionChanged] connected: " + bundle.getBoolean("connected"));
            } catch (Throwable th) {
                c.g("JCoreHelper", "network change handler error, " + th.getMessage());
                return;
            }
        }
        Intent intent = new Intent();
        intent.setAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            intent.putExtra("networkInfo", activeNetworkInfo);
            c.c("JCoreHelper", "networkInfo, available: " + activeNetworkInfo.isAvailable() + ", type: " + activeNetworkInfo.getType());
        }
        ActionManager.getInstance().handleMessage(context, str, intent);
        cn.jiguang.a.a.a(context, "tcp_a15", bundle);
    }

    public void a(Context context, boolean z, int i) {
        c.c("JCoreHelper", "changeForegroudStat:" + z + ", userActiveType:" + i);
        this.a = z;
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", this.a);
        bundle.putInt("user_type", i);
        cn.jiguang.a.a.a(context, "a4", bundle);
        if (!this.a) {
            this.c = true;
            cn.jiguang.b.a.e(context);
        } else if (this.c) {
            cn.jiguang.b.a.a(context, 3);
        }
    }

    public void b(Context context, String str, Bundle bundle) {
        cn.jiguang.a.a.b(context, str, bundle);
    }

    public boolean b(Context context) {
        try {
            Bundle a2 = cn.jiguang.aq.e.a().a(context, "INTERNAL_API", "isTcpLoggedIn", null, d.a(context));
            return (a2 == null || !a2.containsKey("state")) ? h.a().d() : a2.getBoolean("state");
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public Bundle directHandle(Context context, String str, String str2, Bundle bundle) {
        return cn.jiguang.aq.e.a().b(context, str, str2, bundle);
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public Object onCommonMethod(Context context, String str, Object obj) {
        return e.a(context, str, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:1135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:722:0x0123 A[Catch: all -> 0x085c, TryCatch #1 {all -> 0x085c, blocks: (B:645:0x000f, B:649:0x0019, B:652:0x001d, B:657:0x0040, B:659:0x0043, B:660:0x0045, B:662:0x004c, B:664:0x0051, B:666:0x0056, B:669:0x005d, B:671:0x0061, B:673:0x0067, B:675:0x006d, B:676:0x0080, B:678:0x0083, B:679:0x0088, B:681:0x008f, B:683:0x0093, B:685:0x0099, B:687:0x009f, B:690:0x00b2, B:692:0x00b5, B:694:0x00bb, B:696:0x00c6, B:698:0x00c9, B:700:0x00cf, B:701:0x00d3, B:703:0x00da, B:705:0x00dd, B:707:0x00e3, B:709:0x00ee, B:711:0x00f1, B:713:0x00f7, B:714:0x00fb, B:716:0x0102, B:718:0x0105, B:720:0x010b, B:722:0x0123, B:724:0x012d, B:726:0x0131, B:728:0x0137, B:730:0x013e, B:732:0x0145, B:733:0x0169, B:734:0x0172, B:735:0x017b, B:738:0x0183, B:740:0x0187, B:742:0x018d, B:743:0x019e, B:745:0x01a6, B:748:0x01b1, B:750:0x01b4, B:752:0x01ba, B:754:0x01c0, B:764:0x0210, B:765:0x0225, B:766:0x0229, B:756:0x01e3, B:758:0x01e9, B:762:0x020a, B:767:0x022e, B:769:0x0236, B:772:0x023e, B:774:0x0242, B:776:0x0248, B:777:0x025b, B:780:0x0263, B:782:0x0267, B:784:0x026d, B:786:0x0287, B:789:0x0290, B:791:0x0294, B:794:0x02af, B:796:0x02b2, B:798:0x02c3, B:800:0x02c7, B:803:0x0301, B:805:0x0304, B:807:0x030a, B:809:0x0314, B:811:0x0318, B:813:0x031e, B:814:0x0322, B:817:0x032e, B:818:0x0333, B:821:0x033e, B:823:0x0341, B:825:0x0347, B:826:0x037b, B:828:0x0385, B:830:0x0389, B:831:0x0392, B:833:0x039a, B:835:0x039e, B:836:0x03a7, B:838:0x03af, B:839:0x03b8, B:842:0x03c0, B:844:0x03c3, B:846:0x03c9, B:847:0x03da, B:850:0x03e5, B:852:0x03e8, B:854:0x03ee, B:855:0x03ff, B:858:0x0409, B:860:0x040c, B:862:0x0412, B:863:0x041f, B:866:0x0429, B:868:0x042c, B:870:0x0432, B:871:0x043f, B:873:0x0446, B:875:0x044a, B:876:0x047b, B:878:0x0488, B:880:0x048f, B:882:0x0493, B:884:0x0499, B:886:0x04bb, B:888:0x04be, B:889:0x04c3, B:891:0x04cc, B:893:0x04d5, B:896:0x04dc, B:898:0x04e0, B:900:0x04e6, B:902:0x04ec, B:903:0x0519, B:906:0x0520, B:908:0x0523, B:910:0x0529, B:913:0x0534, B:915:0x0538, B:917:0x053e, B:919:0x0544, B:922:0x0557, B:924:0x055b, B:926:0x0561, B:928:0x0567, B:930:0x057e, B:932:0x0582, B:933:0x0587, B:935:0x0590, B:937:0x0593, B:939:0x0599, B:941:0x05a8, B:943:0x05ab, B:945:0x05b1, B:947:0x05bc, B:949:0x05c0, B:951:0x05c6, B:953:0x05cd, B:955:0x05d3, B:956:0x060f, B:959:0x0616, B:961:0x0619, B:963:0x061f, B:965:0x062f, B:967:0x0632, B:969:0x0638, B:973:0x064a, B:977:0x0652, B:979:0x065a, B:982:0x0672, B:984:0x0675, B:986:0x067b, B:987:0x068f, B:1002:0x06bd, B:1004:0x06c0, B:1006:0x06c6, B:991:0x0699, B:993:0x069d, B:995:0x06a3, B:997:0x06a7, B:999:0x06ad, B:1007:0x06d9, B:1011:0x06e3, B:1013:0x06e6, B:1015:0x06ec, B:1016:0x0706, B:1017:0x070c, B:1018:0x0720, B:1020:0x0729, B:1023:0x0734, B:1025:0x0737, B:1027:0x073d, B:1029:0x074e, B:1033:0x075b, B:1035:0x075f, B:1037:0x0763, B:1039:0x0769, B:1041:0x0772, B:1045:0x07a1, B:1047:0x07a5, B:1049:0x07ab, B:1051:0x07ba, B:1053:0x07bd, B:1056:0x07c6, B:1058:0x07c9, B:1060:0x07cf, B:1062:0x07d5, B:1065:0x07e2, B:1068:0x07ee, B:1070:0x07f1, B:1072:0x07f7, B:1074:0x07fd, B:1082:0x0817, B:1077:0x0808, B:1083:0x081d, B:1084:0x0829, B:1085:0x082f, B:1087:0x0834, B:1089:0x0839, B:1091:0x083e, B:1093:0x0843, B:1095:0x0848, B:1096:0x084e, B:1097:0x0854, B:1098:0x0858), top: B:1106:0x000f, inners: #0 }] */
    @Override // cn.jiguang.internal.JCoreHelperAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object onEvent(android.content.Context r20, java.lang.String r21, int r22, java.lang.String r23, android.os.Bundle r24, java.lang.Object... r25) {
        /*
            Method dump skipped, instructions count: 2344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.c.b.onEvent(android.content.Context, java.lang.String, int, java.lang.String, android.os.Bundle, java.lang.Object[]):java.lang.Object");
    }
}
