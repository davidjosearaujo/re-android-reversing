package cn.jpush.android.aa;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.ac.f;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.g;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.TagAliasReceiver;
import com.alipay.sdk.app.OpenAuthTask;
import com.facebook.share.internal.ShareConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static ConcurrentLinkedQueue<Long> a = new ConcurrentLinkedQueue<>();

    private static int a(long j) {
        if (a.size() >= 10) {
            long longValue = j - a.element().longValue();
            if (longValue < 0) {
                a.clear();
                return 2;
            } else if (longValue <= 10000) {
                return 1;
            } else {
                while (a.size() >= 10) {
                    a.poll();
                }
            }
        }
        a.offer(Long.valueOf(j));
        return 0;
    }

    public static long a(Context context, String str, int i, long j) {
        Logger.d("TagAliasHelper", "action - onRecvTagAliasCallBack");
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE, JPushInterface.ErrorCode.UNKNOWN_ERROR);
            if (i == 0) {
                j = jSONObject.optLong("sequence");
            }
            Intent intent = new Intent();
            if (i == 0) {
                intent.setAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
            } else {
                String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
                if (!TextUtils.isEmpty(messageReceiverClass)) {
                    intent = new Intent(context, Class.forName(messageReceiverClass));
                }
                intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                if (i == 1) {
                    intent.putExtra(RemoteMessageConst.MSGTYPE, 1);
                } else {
                    intent.putExtra(RemoteMessageConst.MSGTYPE, 2);
                }
            }
            Intent intent2 = intent;
            intent2.addCategory(context.getPackageName());
            intent2.putExtra("proto_type", i);
            intent2.setPackage(context.getPackageName());
            intent2.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, optInt);
            intent2.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, j);
            Intent a2 = b.a().a(context, j, optInt, jSONObject, intent2);
            if (a2 != null) {
                context.sendBroadcast(a2, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
            }
            return j;
        } catch (Throwable unused) {
            Logger.w("TagAliasHelper", "tagalias msgContent:" + str);
            return -1L;
        }
    }

    public static String a(Context context, String str, long j, int i) {
        String jSONObject;
        if (c(i)) {
            try {
                JSONObject a2 = a(i);
                if (b(2, i)) {
                    if (TextUtils.isEmpty(str)) {
                        Logger.ee("TagAliasHelper", "alias was empty. Give up action.");
                        a(context, 2, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j);
                        return null;
                    } else if (!a(context, 2, str, j)) {
                        return null;
                    } else {
                        a2.put("alias", str);
                    }
                }
                jSONObject = a2.toString();
                Logger.d("TagAliasHelper", "alias str:" + jSONObject);
            } catch (Throwable th) {
                Logger.w("TagAliasHelper", "alias exception:" + th);
            }
            if (TextUtils.isEmpty(jSONObject)) {
                Logger.d("TagAliasHelper", "alias request action was empty");
                return null;
            }
            return jSONObject;
        }
        Logger.e("TagAliasHelper", "unsupport alias action type");
        a(context, 2, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [org.json.JSONArray] */
    public static String a(Context context, List<String> list, long j, int i, int i2, int i3) {
        String jSONObject;
        if (i != 0) {
            try {
                JSONObject a2 = a(i);
                if (a(1, i)) {
                    if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet(list);
                        if (!a(context, 1, hashSet, j)) {
                            return null;
                        }
                        Object b = b(hashSet);
                        if (!b(context, b, j, 1)) {
                            return null;
                        }
                        if (i != 6) {
                            b = new JSONArray();
                            for (String str : list) {
                                b.put(str);
                            }
                        } else if (TextUtils.isEmpty(b)) {
                            Logger.ee("TagAliasHelper", "stags was empty. Give up action.");
                            a(context, 1, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j);
                            return null;
                        }
                        a2.put("tags", b);
                    }
                    Logger.ee("TagAliasHelper", "tags was empty. Give up action.");
                    a(context, 1, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j);
                    return null;
                }
                if (i == 5) {
                    if (i3 == -1) {
                        i3 = 1;
                    }
                    a2.put("curr", i3);
                }
                jSONObject = a2.toString();
                Logger.d("TagAliasHelper", "tag str:" + jSONObject);
            } catch (Throwable th) {
                Logger.w("TagAliasHelper", "tag exception:" + th);
            }
            if (TextUtils.isEmpty(jSONObject)) {
                Logger.d("TagAliasHelper", "tag request action was empty");
                return null;
            }
            return jSONObject;
        }
        Logger.e("TagAliasHelper", "unsupport tag action type");
        a(context, 1, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
        return null;
    }

    private static String a(Context context, List<String> list, String str, long j) {
        String jSONObject;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        if (str == null || a(context, 0, str, j)) {
            if (hashSet == null || a(context, 0, hashSet, j)) {
                String b = b(hashSet);
                if (b(context, b, j, 0)) {
                    if (b == null && str == null) {
                        Logger.ee("TagAliasHelper", "NULL alias and tags. Give up action.");
                        a(context, 0, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j);
                        return null;
                    }
                    Logger.dd("TagAliasHelper", "action:setAliasAndTags - alias:" + str + ", tags:" + b);
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(JThirdPlatFormInterface.KEY_PLATFORM, "a");
                        if (str != null) {
                            jSONObject2.put("alias", str);
                        }
                        if (hashSet != null) {
                            jSONObject2.put("tags", b);
                        }
                        jSONObject = jSONObject2.toString();
                        Logger.d("TagAliasHelper", "tagalias str:" + jSONObject);
                    } catch (Throwable th) {
                        Logger.w("TagAliasHelper", "tagalias exception:" + th);
                        a(context, 0, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
                    }
                    if (TextUtils.isEmpty(jSONObject)) {
                        Logger.d("TagAliasHelper", "tagalias request action was empty");
                        return null;
                    }
                    return jSONObject;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static Set<String> a(Set<String> set) {
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        for (String str : set) {
            if (TextUtils.isEmpty(str) || !f.a(str)) {
                Logger.ee("TagAliasHelper", "Invalid tag : " + str);
            } else {
                linkedHashSet.add(str);
                i++;
                if (i >= 1000) {
                    Logger.ww("TagAliasHelper", "The lenght of tags maybe more than 1000.");
                    return linkedHashSet;
                }
            }
        }
        return linkedHashSet;
    }

    private static JSONObject a(int i) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, "a");
        jSONObject.put("op", b(i));
        return jSONObject;
    }

    public static void a(Context context, int i, int i2, long j) {
        try {
            Intent intent = new Intent();
            intent.addCategory(context.getPackageName());
            intent.setPackage(context.getPackageName());
            if (i == 0) {
                intent.setAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
            } else {
                intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                intent.setClass(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
                if (i == 1) {
                    intent.putExtra(RemoteMessageConst.MSGTYPE, 1);
                } else {
                    intent.putExtra(RemoteMessageConst.MSGTYPE, 2);
                }
            }
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, i2);
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, j);
            context.sendBroadcast(intent, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        } catch (Throwable th) {
            Logger.ww("TagAliasHelper", "NotifyTagAliasError:" + th.getMessage());
        }
    }

    public static void a(Context context, int i, long j, String str) {
        Logger.dd("TagAliasHelper", "tagalias:" + str);
        if (str == null) {
            Logger.w("TagAliasHelper", "tagaliasRequest was null");
            return;
        }
        int i2 = i == 0 ? 10 : i == 1 ? 28 : 29;
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, i2, i == 0 ? 4 : i == 1 ? 1 : 2, j, 20000L, cn.jpush.android.z.c.a(JCoreHelper.getAppKey(context), i2, str));
    }

    public static void a(Context context, Bundle bundle) {
        int i;
        int i2;
        String str;
        int i3;
        String str2;
        String str3;
        int i4;
        String string = bundle.getString("alias");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("tags");
        long j = bundle.getLong("seq", 0L);
        try {
            i = Integer.parseInt(bundle.getString("proto_type"));
        } catch (Throwable th) {
            Logger.w("TagAliasHelper", "load tag/alias proto type failed - error:" + th);
            a(context, 0, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
            i = 0;
        }
        try {
            i2 = Integer.parseInt(bundle.getString(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE));
        } catch (Throwable th2) {
            Logger.w("TagAliasHelper", "load tag/alias action type failed - error:" + th2);
            a(context, i, JPushInterface.ErrorCode.UNKNOWN_ERROR, j);
            i2 = 0;
        }
        if (cn.jpush.android.cache.a.d(context)) {
            i4 = JPushInterface.ErrorCode.PUSH_STOPED;
        } else {
            int a2 = a(System.currentTimeMillis());
            if (a2 != 0) {
                Logger.w("TagAliasHelper", a2 == 1 ? "set tags/alias too soon,over 10 times in 10s" : "set tags/alias failed,time shaft error，please try again");
                a(context, i, a2 == 1 ? JPushInterface.ErrorCode.INVOKE_TOO_SOON : JPushInterface.ErrorCode.INCORRECT_TIME, j);
                return;
            } else if (!b.a().a(context, i, j)) {
                String str4 = null;
                if (i == 0) {
                    Logger.d("TagAliasHelper", "old tag/alias proto");
                    str2 = a(context, stringArrayList, string, j);
                    str = "alias";
                    i3 = 2;
                } else {
                    if (i == 1) {
                        str = "alias";
                        i3 = 2;
                        str4 = a(context, stringArrayList, j, i2, -1, -1);
                    } else {
                        str = "alias";
                        i3 = 2;
                        if (i == 2) {
                            str4 = a(context, string, j, i2);
                        }
                    }
                    str2 = str4;
                }
                if (str2 == null || !(i == 1 || i == i3)) {
                    str3 = str2;
                } else if (!b.a().a(i)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i == 1 ? "tag" : str);
                    sb.append(" is operatoring, please wait last operator complete");
                    Logger.w("TagAliasHelper", sb.toString());
                    a(context, i, i == 1 ? JPushInterface.ErrorCode.ERROR_CODE_TAG_OPERATORING : JPushInterface.ErrorCode.ERROR_CODE_ALIAS_OPERATORING, j);
                    return;
                } else {
                    int i5 = i2;
                    str3 = str2;
                    b.a().a(i, i5, j, stringArrayList, string);
                }
                a(context, i, j, str3);
                return;
            } else {
                i4 = JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE;
            }
        }
        a(context, i, i4, j);
    }

    public static void a(Context context, String str, Set<String> set, CallBackParams callBackParams) {
        long a2 = g.a();
        if (callBackParams != null) {
            c.a().a(context, Long.valueOf(a2), callBackParams);
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (callBackParams != null && callBackParams.protoType == 0) {
            c.a().a(context);
        }
        Bundle bundle = new Bundle();
        bundle.putString("alias", str);
        bundle.putStringArrayList("tags", set != null ? new ArrayList<>(set) : null);
        bundle.putLong("seq", a2);
        StringBuilder sb = new StringBuilder();
        sb.append(callBackParams != null ? callBackParams.protoType : 0);
        sb.append("");
        bundle.putString("proto_type", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(callBackParams != null ? callBackParams.action : 0);
        sb2.append("");
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, sb2.toString());
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "tagalis", bundle);
    }

    private static boolean a(int i, int i2) {
        return i == 1 && (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 6);
    }

    private static boolean a(Context context, int i, String str, long j) {
        int b = f.b(str);
        if (b != 0) {
            Logger.dd("TagAliasHelper", "Invalid alias: " + str + ", will not set alias this time.");
            a(context, i, b, j);
            return false;
        }
        return true;
    }

    private static boolean a(Context context, int i, Set<String> set, long j) {
        int a2 = f.a(set);
        if (a2 != 0) {
            Logger.dd("TagAliasHelper", "Invalid tags, will not set tags this time.");
            a(context, i, a2, j);
            return false;
        }
        return true;
    }

    private static boolean a(String str, boolean z) {
        int length = !TextUtils.isEmpty(str) ? str.getBytes().length + 0 : 0;
        Logger.v("TagAliasHelper", "tags length:" + length);
        if (z) {
            if (length > 5000) {
                return false;
            }
        } else if (length > 7000) {
            return false;
        }
        return true;
    }

    private static String b(int i) {
        switch (i) {
            case 1:
                return "add";
            case 2:
                return "set";
            case 3:
                return "del";
            case 4:
                return "clean";
            case 5:
                return "get";
            case 6:
                return "valid";
            default:
                return null;
        }
    }

    public static String b(Set<String> set) {
        String str = null;
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return "";
        }
        int i = 0;
        for (String str2 : set) {
            if (TextUtils.isEmpty(str2) || !f.a(str2)) {
                Logger.ee("TagAliasHelper", "Invalid tag: " + str2);
            } else {
                if (str != null) {
                    str2 = str + "," + str2;
                }
                i++;
                if (i >= 1000) {
                    return str2;
                }
                str = str2;
            }
        }
        return str;
    }

    private static boolean b(int i, int i2) {
        return i == 2 && i2 == 2;
    }

    private static boolean b(Context context, String str, long j, int i) {
        if (str != null) {
            if (!a(str.replaceAll(",", ""), i != 0)) {
                a(context, i, JPushInterface.ErrorCode.TOO_LONG_TAGALIAS, j);
                StringBuilder sb = new StringBuilder();
                sb.append("The length of tags should be less than ");
                sb.append(i != 0 ? OpenAuthTask.Duplex : 7000);
                sb.append(" bytes.");
                Logger.ww("TagAliasHelper", sb.toString());
                return false;
            }
        }
        return true;
    }

    private static boolean c(int i) {
        return i == 2 || i == 3 || i == 5;
    }
}
