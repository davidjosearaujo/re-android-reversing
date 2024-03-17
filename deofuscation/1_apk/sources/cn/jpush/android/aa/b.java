package cn.jpush.android.aa;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.TagAliasReceiver;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static volatile b a;
    private static final Object b = new Object();
    private ConcurrentHashMap<Long, a> c = new ConcurrentHashMap<>();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a {
        public int a;
        public int b;
        public long c;
        public ArrayList<String> d;
        public String e;
        public int f = -1;
        public int g = -1;
        public int h = 0;
        public int i;

        public a(int i, int i2, long j, ArrayList<String> arrayList, String str) {
            b.this = r1;
            this.i = 0;
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = arrayList;
            if (i == 1 && arrayList == null) {
                this.d = new ArrayList<>();
            }
            this.e = str;
            this.i = 1;
        }

        public String toString() {
            return "TagAliasCacheBean{protoType=" + this.a + ", actionType=" + this.b + ", seqID=" + this.c + ", tags=" + this.d + ", alias='" + this.e + "', totalPage=" + this.f + ", currPage=" + this.g + ", retryCount=" + this.h + '}';
        }
    }

    private a a(JSONObject jSONObject, a aVar) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onUpdateCacheNode,responseJson:" + jSONObject + ",tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return null;
        }
        if (TextUtils.equals(jSONObject.optString("op"), "get")) {
            if (aVar.a == 1) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("tags");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.getString(i));
                        }
                        if (arrayList.size() > 0) {
                            aVar.d.addAll(arrayList);
                        }
                    }
                } catch (Throwable th) {
                    Logger.e("TagAliasNewProtoRetryHelper", "parse tag list failed - error:" + th);
                }
            } else {
                String optString = jSONObject.optString("alias");
                if (optString != null) {
                    aVar.e = optString;
                }
            }
        }
        return aVar;
    }

    public static b a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private boolean a(Context context, int i, a aVar) {
        int i2;
        Logger.d("TagAliasNewProtoRetryHelper", "action - CheckAndSendAgain, errorCode:" + i + ",tagAliasCacheNode:" + aVar);
        if (i == 1 && (i2 = aVar.h) == 0) {
            aVar.h = i2 + 1;
            if (a(context, aVar.a, aVar.c)) {
                return true;
            }
            return b(context, aVar);
        }
        return false;
    }

    private boolean a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "tagAlias cache was null";
        } else {
            Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, tagAliasCacheNode:" + aVar);
            if (aVar.g < aVar.f) {
                return true;
            }
            str = "all tags info was loaded";
        }
        Logger.d("TagAliasNewProtoRetryHelper", str);
        return false;
    }

    private boolean b(Context context, a aVar) {
        String a2;
        String str;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onSendAgain, tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "onSendAgain - tagAliasCacheNode was null");
            return false;
        }
        int i = aVar.a;
        if (i == 1) {
            a2 = cn.jpush.android.aa.a.a(context, aVar.d, aVar.c, aVar.b, aVar.f, aVar.g);
        } else if (i != 2) {
            Logger.d("TagAliasNewProtoRetryHelper", "unsupport proto type");
            return false;
        } else {
            a2 = cn.jpush.android.aa.a.a(context, aVar.e, aVar.c, i);
        }
        if (a2 != null) {
            if (aVar.h > 200) {
                this.c.remove(Long.valueOf(aVar.c));
                cn.jpush.android.aa.a.a(context, aVar.a, JPushInterface.ErrorCode.ERROR_CODE_TOO_BUSY, aVar.c);
                str = "same tag/alias request times greate than 200";
            } else {
                cn.jpush.android.aa.a.a(context, aVar.a, aVar.c, a2);
                aVar.h++;
                this.c.put(Long.valueOf(aVar.c), aVar);
                str = "send request success";
            }
            Logger.d("TagAliasNewProtoRetryHelper", str);
            return true;
        }
        return false;
    }

    public int a(int i, int i2) {
        if (i == 0) {
            return i2;
        }
        if (i2 == 17) {
            try {
                return JPushInterface.ErrorCode.ERROR_CODE_ALIAS_LIMIT;
            } catch (Throwable unused) {
                return JPushInterface.ErrorCode.ERROR_CODE_INVALIDREQ;
            }
        } else if (i2 != 100) {
            switch (i2) {
                case 1:
                case 2:
                    return JPushInterface.ErrorCode.ERROR_CODE_TOO_BUSY;
                case 3:
                    return JPushInterface.ErrorCode.ERROR_CODE_BLACKLIST;
                case 4:
                    return JPushInterface.ErrorCode.ERROR_CODE_INVALIDUSER;
                case 5:
                    return JPushInterface.ErrorCode.ERROR_CODE_INVALIDREQ;
                case 6:
                    return JPushInterface.ErrorCode.ERROR_CODE_INTERNEL_SERVER_ERROR;
                case 7:
                case 8:
                    return JPushInterface.ErrorCode.ERROR_CODE_GET_FAILED;
                case 9:
                    return JPushInterface.ErrorCode.ERROR_CODE_TOO_MANY_TAGS;
                default:
                    return i2;
            }
        } else {
            return JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE;
        }
    }

    public int a(long j) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasTimeOut :" + j);
        a remove = this.c.remove(Long.valueOf(j));
        Logger.d("TagAliasNewProtoRetryHelper", "onTagAliasTimeOut,removed cachenode:" + remove);
        if (remove != null) {
            return remove.a;
        }
        return 0;
    }

    public Intent a(Context context, long j, int i, JSONObject jSONObject, Intent intent) {
        String str;
        String str2;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, seqID:" + j + ",errorCode:" + i + ",intent:" + intent);
        a aVar = this.c.get(Long.valueOf(j));
        StringBuilder sb = new StringBuilder();
        sb.append("tagAliasCacheNode:");
        sb.append(aVar);
        Logger.d("TagAliasNewProtoRetryHelper", sb.toString());
        this.c.remove(Long.valueOf(j));
        if (jSONObject == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "responseJson was null");
            return intent;
        } else if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return intent;
        } else {
            if (!a(context, i, aVar)) {
                if (i != 0) {
                    if (i == 100) {
                        long optLong = jSONObject.optLong("wait", -1L);
                        Logger.ww("TagAliasNewProtoRetryHelper", "set tag/alias action will freeze " + optLong + " seconds");
                        if (optLong > 0) {
                            cn.jpush.android.cache.a.a(context, optLong);
                        }
                    }
                    int a2 = a(aVar.a, i);
                    intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, a2);
                    Logger.d("TagAliasNewProtoRetryHelper", "mapped errorCode:" + a2);
                    return intent;
                }
                aVar.h = 0;
                if (aVar.b == 5) {
                    aVar.f = jSONObject.optInt("total", -1);
                    aVar.g = jSONObject.optInt("curr", -1);
                    a(jSONObject, aVar);
                }
                if (a(context, aVar)) {
                    aVar.g++;
                    Logger.d("TagAliasNewProtoRetryHelper", "load next page, currpage:" + aVar.g + ",totalPage:" + aVar.f);
                    if (a(context, aVar.a, aVar.c)) {
                        return null;
                    }
                    str2 = b(context, aVar) ? "get next page request was sended" : "get next page request was sended";
                }
                int i2 = aVar.b;
                if (i2 == 5) {
                    int i3 = aVar.a;
                    if (i3 == 1) {
                        if (aVar.d.size() > 0) {
                            intent.putStringArrayListExtra("tags", aVar.d);
                        }
                    } else if (i3 == 2 && (str = aVar.e) != null) {
                        intent.putExtra("alias", str);
                    }
                } else if (i2 == 6) {
                    if (aVar.a == 1) {
                        intent.putExtra("validated", jSONObject.optBoolean("validated", false));
                    } else {
                        Logger.w("TagAliasNewProtoRetryHelper", "unsupport  proto type");
                    }
                }
                return intent;
            }
            str2 = "retry action was sended";
            Logger.d("TagAliasNewProtoRetryHelper", str2);
            return null;
        }
    }

    public void a(int i, int i2, long j, ArrayList<String> arrayList, String str) {
        a aVar = new a(i, i2, j, arrayList, str);
        Logger.d("TagAliasNewProtoRetryHelper", "action - createNewCacheNode, tagAliasCacheNode:" + aVar);
        this.c.put(Long.valueOf(j), aVar);
    }

    public boolean a(int i) {
        ConcurrentHashMap<Long, a> concurrentHashMap = this.c;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return true;
        }
        for (Map.Entry<Long, a> entry : this.c.entrySet()) {
            a value = entry.getValue();
            if (value != null && value.a == i) {
                return false;
            }
        }
        return true;
    }

    public boolean a(Context context, int i, long j) {
        if ((i == 1 || i == 2) && cn.jpush.android.cache.a.j(context)) {
            Logger.w("TagAliasNewProtoRetryHelper", "tag/alias action was freezed");
            cn.jpush.android.aa.a.a(context, i, JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE, j);
            return true;
        }
        return false;
    }
}
