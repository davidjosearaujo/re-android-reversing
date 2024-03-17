package com.hunantv.imgo.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.framework.common.ContainerUtils;
import j.l.a.b0.n0;
import java.util.HashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class JumpAction implements Parcelable {
    public static final Parcelable.Creator<JumpAction> CREATOR = new a();
    public static final String SCHEMA = "schema";
    public static final String STR_ACTION_SPLIT = "?";
    public static final String STR_PARAMS_SPLIT = "&";
    public static final String STR_SCHEM_SPLIT = "://";
    public String action;
    public HashMap<String, String> params;
    public String scheme;
    public String uri;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements Parcelable.Creator<JumpAction> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public JumpAction createFromParcel(Parcel parcel) {
            return new JumpAction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public JumpAction[] newArray(int i) {
            return null;
        }
    }

    public JumpAction() {
        this.params = new HashMap<>();
    }

    public static JumpAction urlToJumpAction(String str) {
        JumpAction jumpAction = null;
        if (!n0.y(str)) {
            int indexOf = str.indexOf(STR_SCHEM_SPLIT);
            if (indexOf == -1) {
                return null;
            }
            jumpAction = new JumpAction();
            int i = indexOf + 3;
            String[] strArr = {str.substring(0, i), str.substring(i, str.length())};
            jumpAction.scheme = SCHEMA;
            String str2 = strArr[1];
            jumpAction.uri = str2;
            if (!n0.y(str2)) {
                int indexOf2 = jumpAction.uri.indexOf(STR_ACTION_SPLIT);
                if (indexOf2 == -1) {
                    jumpAction.action = jumpAction.uri;
                    return jumpAction;
                }
                int i2 = indexOf2 + 1;
                String str3 = jumpAction.uri;
                String[] strArr2 = {jumpAction.uri.substring(0, indexOf2), str3.substring(i2, str3.length())};
                jumpAction.action = strArr2[0];
                if (!n0.y(strArr2[1])) {
                    String[] split = strArr2[1].split("&");
                    if (split.length > 0) {
                        for (String str4 : split) {
                            if (str4.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                                jumpAction.params.put(str4.substring(0, str4.indexOf(61)), str4.substring(str4.indexOf(61) + 1, str4.length()));
                            }
                        }
                    }
                }
            }
        }
        return jumpAction;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.scheme);
        parcel.writeString(this.action);
        parcel.writeString(this.uri);
        parcel.writeMap(this.params);
    }

    public JumpAction(Parcel parcel) {
        this.params = new HashMap<>();
        this.scheme = parcel.readString();
        this.action = parcel.readString();
        this.uri = parcel.readString();
        this.params = parcel.readHashMap(HashMap.class.getClassLoader());
    }
}
