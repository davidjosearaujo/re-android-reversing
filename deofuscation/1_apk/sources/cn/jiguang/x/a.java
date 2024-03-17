package cn.jiguang.x;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.n.d;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private Context a;
    private String b;

    public a(Context context) {
        this.b = "";
        this.a = context;
        this.b = d.g("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO");
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Cursor query = this.a.getContentResolver().query(Uri.parse(this.b), null, null, new String[]{str}, null);
            if (query != null) {
                r1 = query.moveToNext() ? query.getString(query.getColumnIndex(SDKConstants.PARAM_VALUE)) : null;
                query.close();
            } else {
                cn.jiguang.ak.a.a("MeizuDB", "return cursor is null,return");
            }
        } catch (Exception e) {
            cn.jiguang.ak.a.d("MeizuDB", "getId error: " + e.getMessage());
        }
        return r1;
    }
}
