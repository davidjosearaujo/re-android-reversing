package com.facebook.internal;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.e.a.d;

/* compiled from: BundleJSONConverter.kt */
@b0(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter;", "", "()V", "SETTERS", "", "Ljava/lang/Class;", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "convertToBundle", "Landroid/os/Bundle;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "bundle", "Setter", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class BundleJSONConverter {
    @d
    public static final BundleJSONConverter INSTANCE = new BundleJSONConverter();
    private static final Map<Class<?>, Setter> SETTERS;

    /* compiled from: BundleJSONConverter.kt */
    @b0(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&¨\u0006\f"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter$Setter;", "", "setOnBundle", "", "bundle", "Landroid/os/Bundle;", SDKConstants.PARAM_KEY, "", SDKConstants.PARAM_VALUE, "setOnJSON", "json", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Setter {
        void setOnBundle(@d Bundle bundle, @d String str, @d Object obj) throws JSONException;

        void setOnJSON(@d JSONObject jSONObject, @d String str, @d Object obj) throws JSONException;
    }

    static {
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(Boolean.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.1
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@d Bundle bundle, @d String str, @d Object obj) throws JSONException {
                f0.p(bundle, "bundle");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@d JSONObject jSONObject, @d String str, @d Object obj) throws JSONException {
                f0.p(jSONObject, "json");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(Integer.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.2
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@d Bundle bundle, @d String str, @d Object obj) throws JSONException {
                f0.p(bundle, "bundle");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@d JSONObject jSONObject, @d String str, @d Object obj) throws JSONException {
                f0.p(jSONObject, "json");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(Long.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.3
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@d Bundle bundle, @d String str, @d Object obj) throws JSONException {
                f0.p(bundle, "bundle");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                bundle.putLong(str, ((Long) obj).longValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@d JSONObject jSONObject, @d String str, @d Object obj) throws JSONException {
                f0.p(jSONObject, "json");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(Double.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.4
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@d Bundle bundle, @d String str, @d Object obj) throws JSONException {
                f0.p(bundle, "bundle");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@d JSONObject jSONObject, @d String str, @d Object obj) throws JSONException {
                f0.p(jSONObject, "json");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(String.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.5
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@d Bundle bundle, @d String str, @d Object obj) throws JSONException {
                f0.p(bundle, "bundle");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                bundle.putString(str, (String) obj);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@d JSONObject jSONObject, @d String str, @d Object obj) throws JSONException {
                f0.p(jSONObject, "json");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(String[].class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.6
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@d Bundle bundle, @d String str, @d Object obj) throws JSONException {
                f0.p(bundle, "bundle");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@d JSONObject jSONObject, @d String str, @d Object obj) throws JSONException {
                f0.p(jSONObject, "json");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                JSONArray jSONArray = new JSONArray();
                for (String str2 : (String[]) obj) {
                    jSONArray.put(str2);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        hashMap.put(JSONArray.class, new Setter() { // from class: com.facebook.internal.BundleJSONConverter.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnBundle(@d Bundle bundle, @d String str, @d Object obj) throws JSONException {
                f0.p(bundle, "bundle");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    Object obj2 = jSONArray.get(i);
                    if (obj2 instanceof String) {
                        arrayList.add(obj2);
                    } else {
                        throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                    }
                }
                bundle.putStringArrayList(str, arrayList);
            }

            @Override // com.facebook.internal.BundleJSONConverter.Setter
            public void setOnJSON(@d JSONObject jSONObject, @d String str, @d Object obj) throws JSONException {
                f0.p(jSONObject, "json");
                f0.p(str, SDKConstants.PARAM_KEY);
                f0.p(obj, SDKConstants.PARAM_VALUE);
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    private BundleJSONConverter() {
    }

    @d
    @k
    public static final Bundle convertToBundle(@d JSONObject jSONObject) throws JSONException {
        f0.p(jSONObject, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj != JSONObject.NULL) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        f0.o(next, SDKConstants.PARAM_KEY);
                        f0.o(obj, SDKConstants.PARAM_VALUE);
                        setter.setOnBundle(bundle, next, obj);
                    } else {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                }
            }
        }
        return bundle;
    }

    @d
    @k
    public static final JSONObject convertToJSON(@d Bundle bundle) throws JSONException {
        f0.p(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                f0.o(obj, "bundle[key] ?: // Null i…orted.\n          continue");
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : (List) obj) {
                        jSONArray.put(str2);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        f0.o(str, SDKConstants.PARAM_KEY);
                        setter.setOnJSON(jSONObject, str, obj);
                    } else {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                }
            }
        }
        return jSONObject;
    }
}
