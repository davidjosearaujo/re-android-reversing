package cn.com.custommma.mobile.tracking.viewability.webjs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DataCacheManager {
    private static final String JSON_CACHEDATA = "cache_data";
    private static final String JSON_EXPIRED_TIME = "expired_time";
    private static final String SHAREDPREFERENCES_NAME = "mma.viewabilityjs.data";
    private static final long THREE_DAY_INTERVIAL = 259200000;
    private static volatile DataCacheManager mInstance;
    private Context mContext;

    private DataCacheManager(Context context) {
        Objects.requireNonNull(context, "DataCacheManager context can`t be null!");
        this.mContext = context;
    }

    public static DataCacheManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DataCacheManager.class) {
                if (mInstance == null) {
                    mInstance = new DataCacheManager(context);
                }
            }
        }
        return mInstance;
    }

    private SharedPreferences getSharedPreferences() {
        return this.mContext.getSharedPreferences(SHAREDPREFERENCES_NAME, 0);
    }

    public synchronized void clearData(String str) {
        try {
            SharedPreferences.Editor edit = getSharedPreferences().edit();
            edit.remove(str);
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void clearnExpiredData() {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences();
            for (String str : sharedPreferences.getAll().keySet()) {
                String string = sharedPreferences.getString(str, "");
                if (!TextUtils.isEmpty(string) && new JSONObject(string).getLong(JSON_EXPIRED_TIME) > System.currentTimeMillis()) {
                    clearData(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized String getData(String str) {
        String str2;
        str2 = "";
        try {
            String string = getSharedPreferences().getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                str2 = new JSONObject(string).getString(JSON_CACHEDATA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public synchronized void setData(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JSON_EXPIRED_TIME, System.currentTimeMillis() + 259200000);
            jSONObject.put(JSON_CACHEDATA, str2);
            SharedPreferences.Editor edit = getSharedPreferences().edit();
            edit.putString(str, jSONObject.toString());
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
