package cn.jpush.android.u;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.huawei.agconnect.exception.AGCServerException;
import com.hunantv.mpdt.data.ExposureData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public static final String a = cn.jpush.android.ac.d.b(new byte[]{106, 58, 41, 59, 97, 120, 78, 81, 80, 105, 87, 116, 112, 94, 78, 124, 122, 52, 43, 16, 91, 19, 1, 31, 51, 67, 72, 120, 99, 115, 51, 10, 123, 42, 56, 38, 61, 1, 16, 41, 85, 58, 27, 57, 41, 59, 105, 120, 120, 93, 65, 109, 103, 100, 51, 10, 0, 98, 2, 31, 24, 57, 2, 117, 105, 120, 117, 67, 67, 120, 120, 115, 51, 10, 0, 98, 2, 31, 24, 57, 41, 59, 123, 126, 126, 71, 2, 35, 40, 77, 27, 57, 41, 16, 1, 31, 74, 75, 42, 16, 1, 31, 24, 57, 41, 59, 124, 111, 97, 85, 2, 35, 40, 52, 101, 66, 65, 119, 123, 122, 112, 68, 73, 118, 102, 78, 51, 28, 42, 16, 1, 31, 24, 57, 41, 59, 126, 119, 125, 69, 69, 59, 50, 54, 74, 1, 22, 53, 40, 39, 39, 109, 12, 19, 1, 31, 24, 57, 41, 16, 42, 114, 100, 66, 65, 109, 97, 121, Byte.MAX_VALUE, 18, 26, 57, 61, 38, 33, 58, 41, 16, 1, 31, 24, 77, 12, 57, 115, 28, 24, 57, 41, 16, 1, 31, 51, 68, 89, 105, 109, 52, 43, 16, 2, 109, 122, 119, Byte.MAX_VALUE, 67, 76, 120, 124, Byte.MAX_VALUE, 126, 94, 121, 59, 36, 28, 24, 57, 41, 16, 1, 31, 51, 70, 65, 117, 125, 115, 51, 10, 0, 66, 37, 39, 34, 30, 18, 53, 40, 35, 61, 16, 16, 68, 36, 28, 24, 57, 41, 16, 1, 31, 51, 84, 85, 107, 105, 98, 120, 95, 78, 59, 50, 54, 34, 0, 16, 19, 1, 31, 24, 57, 41, 100, 2, 31, 24, 57, 41, 16, 85, 28, 24, 57, 41, 16, 85, 58, 27, 57, 41, 16, 1, 52, 121, 89, 68, 124, 42, 44, 49, 107, 42, 16, 1, 31, 24, 57, 123, 98, 2, 31, 24, 57, 41, 16, 1, 52, 101, 73, 80, 124, 42, 44, 49, 18, 84, 107, 105, 120, 98, 92, 65, 109, 97, 121, Byte.MAX_VALUE, 104, 2, 53, 2, 31, 24, 57, 41, 16, 1, 52, 103, 81, 76, 108, 109, 52, 43, 16, 123, 40, 62, 58, 49, 1, 22, 68, 36, 28, 24, 57, 41, 16, 1, 31, 51, 84, 85, 107, 105, 98, 120, 95, 78, 59, 50, 54, 36, 0, 16, 19, 1, 31, 24, 57, 41, 100, 36, 54, 106, 58, 41, 16, 1, 31, 24, 57, 2, 109, 113, 102, 116, 18, 26, 57, 42, 98, 99, 81, 78, 106, 100, 119, 101, 89, 79, 119, 81, 52, 61, 58, 41, 16, 1, 31, 24, 57, 2, 111, 105, 122, 100, 85, 2, 35, 40, 77, 33, 28, 0, 52, 57, 35, 76, 28, 42, 16, 1, 31, 24, 57, 41, 59, 108, 99, 99, 81, 84, 112, 103, 120, 51, 10, 0, 44, 56, 38, 27, 57, 41, 16, 1, 31, 108, 109, 42, 16, 1, 31, 24, 109, 42, 16, 1, 31, 108, 28, 42, 16, 1, 31, 51, 64, 79, 107, 124, 100, 112, 89, 84, 59, 50, 54, 106, 58, 41, 16, 1, 31, 51, 67, 72, 118, Byte.MAX_VALUE, 52, 43, 16, 123, 19, 1, 31, 24, 57, 41, 66, 115, 28, 24, 57, 41, 16, 1, 31, 51, 68, 89, 105, 109, 52, 43, 16, 2, 109, 122, 119, Byte.MAX_VALUE, 67, 76, 120, 124, Byte.MAX_VALUE, 126, 94, 120, 59, 36, 28, 24, 57, 41, 16, 1, 31, 51, 70, 65, 117, 125, 115, 51, 10, 0, 66, 58, 58, 49, 2, 125, 53, 2, 31, 24, 57, 41, 16, 1, 52, 117, 69, 82, 120, 124, Byte.MAX_VALUE, 126, 94, 2, 35, 40, 35, 33, 0, 42, 16, 1, 31, 24, 57, 93, 53, 40, 109, 27, 57, 41, 16, 1, 31, 24, 18, 84, 96, 120, 115, 51, 10, 0, 59, 124, 100, 112, 94, 83, 117, 105, 98, 120, 95, 78, 64, 42, 58, 27, 57, 41, 16, 1, 31, 24, 18, 86, 120, 100, 99, 116, 18, 26, 57, 83, 59, 35, 7, 14, 47, 36, 54, 32, 0, 12, 57, 56, 75, 61, 58, 41, 16, 1, 31, 24, 57, 2, 125, 125, 100, 112, 68, 73, 118, 102, 52, 43, 16, 19, 41, 56, 28, 24, 57, 41, 16, 1, 107, 76, 58, 41, 16, 1, 31, 76, 28, 42, 16, 1, 31, 24, 18, 72, 112, 108, 115, 51, 10, 0, 66, 2, 31, 24, 57, 41, 16, 83, 109, 27, 57, 41, 16, 1, 31, 24, 18, 84, 96, 120, 115, 51, 10, 0, 59, 124, 100, 112, 94, 83, 117, 105, 98, 120, 95, 78, 65, 42, 58, 27, 57, 41, 16, 1, 31, 24, 18, 86, 120, 100, 99, 116, 18, 26, 57, 83, 36, 61, 16, 18, 68, 36, 28, 24, 57, 41, 16, 1, 31, 51, 84, 85, 107, 105, 98, 120, 95, 78, 59, 50, 54, 36, 0, 16, 19, 1, 31, 24, 57, 41, 100, 36, 54, 106, 58, 41, 16, 1, 31, 24, 57, 2, 109, 113, 102, 116, 18, 26, 57, 42, 98, 99, 81, 78, 106, 100, 119, 101, 89, 79, 119, 81, 52, 61, 58, 41, 16, 1, 31, 24, 57, 2, 111, 105, 122, 100, 85, 2, 35, 40, 77, 33, 28, 0, 52, 59, 38, 76, 28, 42, 16, 1, 31, 24, 57, 41, 59, 108, 99, 99, 81, 84, 112, 103, 120, 51, 10, 0, 42, 56, 38, 27, 57, 41, 16, 1, 31, 108, 109, 42, 16, 1, 31, 24, 109, 42, 16, 1, 31, 108, 58, 41, 16, 117, 58, 27, 57, 41, 59, 107, 121, Byte.MAX_VALUE, 68, 65, 112, 102, 115, 99, 18, 26, 57, 115, 28, 24, 57, 41, 59, 100, 119, Byte.MAX_VALUE, 84, 83, 122, 105, 102, 116, 18, 26, 57, 115, 28, 24, 57, 41, 16, 42, 97, 51, 10, 0, 47, 48, 58, 27, 57, 41, 16, 1, 52, 121, 18, 26, 57, 57, 37, 63, 2, 42, 16, 1, 31, 108, 28, 42, 16, 1, 31, 51, 64, 79, 107, 
    124, 100, 112, 89, 84, 59, 50, 54, 106, 58, 41, 16, 1, 31, 51, 71, 2, 35, 40, 47, 39, 28, 42, 16, 1, 31, 24, 18, 72, 59, 50, 54, 35, 7, 14, 47, 2, 31, 24, 57, 93, 19, 1, 31, 108, 28, 42, 16, 1, 52, 121, 5, Byte.MAX_VALUE, 124, 112, 98, 99, 81, 83, 59, 50, 54, 51, 75, 124, 59, 101, 121, 117, 85, 76, 69, 42, 44, 77, 18, 80, 108, 106, 122, 120, 83, 124, 59, 36, 74, 51, 64, 79, 107, 124, 100, 112, 89, 84, 69, 42, 44, 106, 108, 2, 125, 105, 100, 122, 92, 89, 69, 42, 44, 106, 77, 12, 69, 42, 101, 101, 73, 76, 124, 84, 52, 43, 75, 124, 59, 101, 121, 117, 85, 76, 52, 107, 121, Byte.MAX_VALUE, 68, 65, 112, 102, 115, 99, 108, 2, 35, 115, 74, 51, 71, 73, 125, 124, 126, 77, 18, 26, 69, 42, 37, 63, 4, 20, 107, 109, 123, 77, 18, 12, 69, 42, 126, 116, 89, 71, 113, 124, 74, 51, 10, 124, 59, 56, 56, 40, 8, 82, 124, 101, 74, 51, 28, 124, 59, 101, 119, 99, 87, 73, 119, 84, 52, 43, 108, 2, 41, 40, 119, 100, 68, 79, 69, 42, 58, 77, 18, 66, 120, 107, 125, 118, 66, 79, 108, 102, 114, 77, 18, 26, 69, 42, 53, 119, 86, 70, Byte.MAX_VALUE, 110, 112, 77, 18, 12, 69, 42, 116, 126, 72, 115, 113, 105, 114, 126, 71, 124, 59, 50, 74, 51, 0, 0, 41, 38, 38, 37, 66, 69, 116, 40, 38, 63, 0, 22, 107, 109, 123, 49, 0, 0, 107, 111, 116, 112, 24, 16, 53, 40, 38, 61, 16, 16, 53, 40, 38, 63, 1, 21, 48, 84, 52, 61, 108, 2, 123, 103, 100, 117, 85, 82, 75, 105, 114, 120, 69, 83, 69, 42, 44, 77, 18, 16, 55, 57, 36, 99, 85, 77, 69, 42, 58, 77, 18, 79, 105, 105, 117, 120, 68, 89, 69, 42, 44, 77, 18, 17, 69, 42, 107, 61, 108, 2, 112, 107, 121, Byte.MAX_VALUE, 29, 73, 116, 111, 74, 51, 10, 91, 69, 42, 98, 126, 64, 124, 59, 50, 74, 51, 0, 14, 40, 58, 100, 116, 93, 124, 59, 36, 74, 51, 92, 69, Byte.MAX_VALUE, 124, 74, 51, 10, 124, 59, 56, 56, 32, 6, 82, 124, 101, 74, 51, 28, 124, 59, Byte.MAX_VALUE, Byte.MAX_VALUE, 117, 68, 72, 69, 42, 44, 77, 18, 16, 55, 57, 32, 99, 85, 77, 69, 42, 58, 77, 18, 72, 124, 97, 113, 121, 68, 124, 59, 50, 74, 51, 0, 14, 40, 62, 100, 116, 93, 124, 59, 117, 58, 77, 18, 73, 119, 110, 121, 60, 89, 77, 126, 84, 52, 43, 75, 124, 59, 124, 121, 97, 108, 2, 35, 84, 52, 33, 30, 20, 107, 109, 123, 77, 18, 12, 69, 42, 122, 116, 86, 84, 69, 42, 44, 77, 18, 18, 55, 48, 46, 99, 85, 77, 69, 42, 58, 77, 18, 87, 112, 108, 98, 121, 108, 2, 35, 84, 52, 33, 30, 20, 43, 122, 115, 124, 108, 2, 53, 84, 52, 121, 85, 73, 126, 96, 98, 77, 18, 26, 69, 42, 38, 63, 4, 18, 107, 109, 123, 77, 18, 93, 53, 84, 52, 112, 64, 80, 52, 102, 119, 124, 85, 124, 59, 50, 109, 77, 18, 84, 118, 120, 74, 51, 10, 124, 59, 56, 56, 32, 2, 82, 124, 101, 74, 51, 28, 124, 59, 100, 115, 119, 68, 124, 59, 50, 74, 51, 0, 14, 45, 58, 100, 116, 93, 124, 59, 36, 74, 51, 71, 73, 125, 124, 126, 77, 18, 26, 69, 42, 36, 99, 85, 77, 69, 42, 58, 77, 18, 70, 118, 102, 98, 66, 89, 90, 124, 84, 52, 43, 108, 2, 41, 38, 39, 35, 66, 69, 116, 84, 52, 61, 108, 2, 122, 103, 122, 126, 66, 124, 59, 50, 74, 51, 19, 17, 41, 57, 39, 32, 7, 124, 59, 117, 58, 77, 18, 73, 119, 110, 121, 60, 68, 73, 109, 100, 115, 77, 18, 26, 98, 84, 52, 101, 95, 80, 69, 42, 44, 77, 18, 16, 55, 59, 46, 99, 85, 77, 69, 42, 58, 77, 18, 76, 124, 110, 98, 77, 18, 26, 69, 42, 38, 63, 1, 22, 107, 109, 123, 77, 18, 12, 69, 42, 97, 120, 84, 84, 113, 84, 52, 43, 108, 2, 43, 38, 33, 99, 85, 77, 69, 42, 58, 77, 18, 70, 118, 102, 98, 66, 89, 90, 124, 84, 52, 43, 108, 2, 41, 38, 39, 37, 66, 69, 116, 84, 52, 61, 108, 2, 122, 103, 122, 126, 66, 124, 59, 50, 74, 51, 19, 16, 93, 57, 39, 32, 5, 124, 59, 117, 58, 77, 18, 73, 119, 110, 121, 60, 83, 79, 119, 124, 115, Byte.MAX_VALUE, 68, 124, 59, 50, 109, 77, 18, 84, 118, 120, 74, 51, 10, 124, 59, 56, 56, 39, 66, 69, 116, 84, 52, 61, 108, 2, 117, 109, 112, 101, 108, 2, 35, 84, 52, 33, 30, 17, 47, 122, 115, 124, 108, 2, 53, 84, 52, 102, 89, 68, 109, 96, 74, 51, 10, 124, 59, 58, 56, 38, 66, 69, 116, 84, 52, 61, 108, 2, Byte.MAX_VALUE, 103, 120, 101, 99, 73, 99, 109, 74, 51, 10, 124, 59, 56, 56, 32, 4, 82, 124, 101, 74, 51, 28, 124, 59, 107, 121, 125, 95, 82, 69, 42, 44, 77, 18, 3, 44, 59, 35, 38, 6, 101, 69, 42, 107, 108, 77, 12, 69, 42, 122, 112, 94, 68, 106, 107, 119, 97, 85, 124, 59, 50, 109, 77, 18, 68, 120, 122, 125, 125, 73, 124, 59, 50, 109, 108, 28, 124, 59, 123, 98, 104, 92, 69, 69, 42, 44, 106, 77, 93, 53, 84, 52, 125, 81, 78, 126, 125, 119, 118, 85, 124, 59, 50, 109, 77, 18, 90, 113, 84, 52, 43, 75, 124, 59, 98, 99, 98, 68, 124, 59, 50, 74, 51, -43, 
    -88, -125, -19, -98, -117, 108, 2, 53, 84, 52, Byte.MAX_VALUE, 95, 87, 69, 42, 44, 77, 18, -57, -105, -72, -13, -115, -104, 124, 59, 36, 74, 51, 81, 77, 69, 42, 44, 77, 18, -60, -95, -126, -13, -100, -72, 124, 59, 36, 74, 51, 64, 77, 69, 42, 44, 77, 18, -60, -95, -125, -13, -100, -72, 124, 59, 117, 58, 77, 18, 69, 119, 84, 52, 43, 75, 124, 59, 98, 99, 98, 68, 124, 59, 50, 74, 51, 90, 85, 106, 124, 74, 51, 28, 124, 59, 102, 121, 102, 108, 2, 35, 84, 52, Byte.MAX_VALUE, 95, 87, 69, 42, 58, 77, 18, 65, 116, 84, 52, 43, 108, 2, 120, 101, 74, 51, 28, 124, 59, 120, 123, 77, 18, 26, 69, 42, 102, 124, 108, 2, 100, 117, 58, 77, 18, 70, 112, 112, 66, 116, 72, 84, 69, 42, 44, 74, 108, 2, 112, 102, 112, 126, 29, 84, 112, 124, 122, 116, 108, 2, 53, 84, 52, 120, 94, 70, 118, 37, 117, 126, 94, 84, 124, 102, 98, 77, 18, 125, 100, 42, 28, 24, 77, 42, 100});
    public List<Long> b;
    public b c;
    public c d;
    public String e;

    /* renamed from: cn.jpush.android.u.a$a */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class C0018a {
        private a a = new a();

        private void a(b bVar, String str, String str2, String str3) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(str2);
                if (optJSONObject == null) {
                    Logger.d("InAppAnimatorConfig", "[parseAnimatorData] orientType array is null, orient: " + str2);
                    return;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray(str3);
                if (optJSONArray == null) {
                    Logger.d("InAppAnimatorConfig", "[parseAnimatorData] showHide array is null, showHide: " + str3);
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                    if (optJSONArray2 != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                b.C0019a c0019a = new b.C0019a();
                                c0019a.c = optJSONObject2.optInt("duration", AGCServerException.UNKNOW_EXCEPTION);
                                c0019a.a = optJSONObject2.optString("type", "");
                                JSONArray optJSONArray3 = optJSONObject2.optJSONArray(SDKConstants.PARAM_VALUE);
                                if (optJSONArray3 != null) {
                                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                        c0019a.b.add(Float.valueOf((float) optJSONArray3.getDouble(i3)));
                                    }
                                }
                                arrayList.add(c0019a);
                            }
                        }
                        ("landscape".equals(str2) ? ExposureData.ACT_EXPOSURE.equals(str3) ? bVar.a.a : bVar.a.b : ExposureData.ACT_EXPOSURE.equals(str3) ? bVar.b.a : bVar.b.b).add(arrayList);
                    }
                }
            } catch (Throwable th) {
                Logger.w("InAppAnimatorConfig", "parse animator , err: " + th.getMessage());
            }
        }

        public C0018a a(String str) {
            try {
                this.a.b = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.a.b.add(Long.valueOf(jSONArray.getInt(i)));
                    }
                    Logger.d("InAppAnimatorConfig", "shakes: \n " + this.a.b.toString());
                }
            } catch (Throwable th) {
                Logger.w("InAppAnimatorConfig", "parse animator shake, err: " + th.getMessage());
            }
            return this;
        }

        public a a() {
            return this.a;
        }

        public C0018a b(String str) {
            this.a.c = new b();
            if (!TextUtils.isEmpty(str)) {
                a(this.a.c, str, "landscape", ExposureData.ACT_EXPOSURE);
                a(this.a.c, str, "landscape", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
                a(this.a.c, str, "portrait", ExposureData.ACT_EXPOSURE);
                a(this.a.c, str, "portrait", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
                Logger.d("InAppAnimatorConfig", "animator: \n landscape: " + this.a.c.a.toString() + "\n portrait:  " + this.a.c.b.toString());
            }
            return this;
        }

        public C0018a c(String str) {
            try {
                this.a.d = new c();
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("landscape");
                    if (optJSONObject != null) {
                        this.a.d.a.b = (float) optJSONObject.optDouble("h");
                        this.a.d.a.a = (float) optJSONObject.optDouble("w");
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("portrait");
                    if (optJSONObject2 != null) {
                        this.a.d.b.b = (float) optJSONObject2.optDouble("h");
                        this.a.d.b.a = (float) optJSONObject2.optDouble("w");
                    }
                }
                Logger.d("InAppAnimatorConfig", "container: \n landscape: " + this.a.d.a.toString() + "\n portrait:  " + this.a.d.b.toString());
            } catch (Throwable th) {
                Logger.w("InAppAnimatorConfig", "parse container , err: " + th.getMessage());
            }
            return this;
        }

        public C0018a d(String str) {
            this.a.e = str;
            Logger.d("InAppAnimatorConfig", "h5Extras: \n " + str);
            return this;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b {
        public C0020b a = new C0020b();
        public C0020b b = new C0020b();

        /* renamed from: cn.jpush.android.u.a$b$a */
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class C0019a {
            public String a;
            public List<Float> b = new ArrayList();
            public long c;

            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < this.b.size(); i++) {
                    sb.append(this.b.get(i));
                    if (i < this.b.size() - 1) {
                        sb.append(", ");
                    }
                }
                return "type: " + this.a + ", duration: " + this.c + ", values: " + sb.toString() + "\t";
            }
        }

        /* renamed from: cn.jpush.android.u.a$b$b */
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class C0020b {
            public List<List<C0019a>> a = new ArrayList();
            public List<List<C0019a>> b = new ArrayList();

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("showList-> ");
                for (int i = 0; i < this.a.size(); i++) {
                    sb.append(this.a.get(i).toString());
                }
                sb.append("\n\t\t\t hideList-> ");
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    sb.append(this.b.get(i2).toString());
                }
                return sb.toString();
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class c {
        public C0021a a = new C0021a();
        public C0021a b = new C0021a();

        /* renamed from: cn.jpush.android.u.a$c$a */
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class C0021a {
            public float a;
            public float b;

            public String toString() {
                return "width: " + this.a + ", height: " + this.b;
            }
        }
    }

    public static C0018a a() {
        return new C0018a();
    }
}
