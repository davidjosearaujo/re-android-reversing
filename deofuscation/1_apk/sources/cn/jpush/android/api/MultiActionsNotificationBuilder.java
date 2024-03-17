package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JNotifyActivity;
import j.l.c.e0.a.a.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MultiActionsNotificationBuilder extends DefaultPushNotificationBuilder {
    private static final String INTENT_NOTIFICATION_CLICK_ACTION_PROXY = "cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY";
    private static final String NOTI_ACT_EXTRA_STR = "notification_action_extra_string";
    private static final String NOTI_ACT_RES_ID = "notification_action_res_id";
    private static final String NOTI_ACT_TEXT = "notification_action_text";
    private static final String TAG = "MultiActionsNotificationBuilder";
    private JSONArray actionJSONArray = new JSONArray();
    public Context mContext;

    public MultiActionsNotificationBuilder(Context context) {
        this.mContext = context;
    }

    public static PushNotificationBuilder parseFromPreference(Context context, String str) {
        MultiActionsNotificationBuilder multiActionsNotificationBuilder = new MultiActionsNotificationBuilder(context);
        try {
            multiActionsNotificationBuilder.actionJSONArray = new JSONArray(str);
        } catch (JSONException e) {
            Logger.ww(TAG, "Parse builder from preference failed!");
            e.printStackTrace();
        }
        return multiActionsNotificationBuilder;
    }

    public void addJPushAction(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NOTI_ACT_RES_ID, i);
            jSONObject.put(NOTI_ACT_TEXT, str);
            jSONObject.put(NOTI_ACT_EXTRA_STR, str2);
            this.actionJSONArray.put(jSONObject);
            Logger.i(TAG, this.actionJSONArray.toString());
        } catch (JSONException e) {
            Logger.ww(TAG, "Construct action failed!");
            e.printStackTrace();
        }
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    @TargetApi(11)
    public Notification getNotification(Notification.Builder builder) {
        if (Build.VERSION.SDK_INT < 16) {
            Logger.i(TAG, "Device with SDK_VERSION < 16, show original notification style.");
            return builder.getNotification();
        }
        for (int i = 0; i < this.actionJSONArray.length(); i++) {
            try {
                JSONObject jSONObject = this.actionJSONArray.getJSONObject(i);
                Intent intent = new Intent("cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY");
                intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA, jSONObject.getString(NOTI_ACT_EXTRA_STR));
                intent.setClass(this.mContext, JNotifyActivity.class);
                intent.setFlags(8388608);
                intent.putExtra("isNotification", true);
                PendingIntent a = d.a(this.mContext, i, intent, 201326592);
                Logger.i(TAG, "Add notification action: res - " + jSONObject.getInt(NOTI_ACT_RES_ID) + ", string - " + jSONObject.getString(NOTI_ACT_TEXT) + ", extra - " + jSONObject.getString(NOTI_ACT_EXTRA_STR));
                builder.addAction(jSONObject.getInt(NOTI_ACT_RES_ID), jSONObject.getString(NOTI_ACT_TEXT), a).setAutoCancel(true);
            } catch (JSONException e) {
                Logger.ww(TAG, "Parse Action from preference preference failed!");
                e.printStackTrace();
            }
        }
        return builder.build();
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return this.actionJSONArray.toString();
    }
}
