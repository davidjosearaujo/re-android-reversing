package v2;

import android.text.TextUtils;
import androidx.activity.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i implements g {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, List<h>> f6208b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Map<String, String> f6209c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        public static final Map<String, List<h>> f6210b;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, List<h>> f6211a = f6210b;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i7 = 0; i7 < length; i7++) {
                    char charAt = property.charAt(i7);
                    if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                        charAt = '?';
                    }
                    sb.append(charAt);
                }
                property = sb.toString();
            }
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(property)));
            }
            f6210b = Collections.unmodifiableMap(hashMap);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b implements h {

        /* renamed from: a  reason: collision with root package name */
        public final String f6212a;

        public b(String str) {
            this.f6212a = str;
        }

        @Override // v2.h
        public final String a() {
            return this.f6212a;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f6212a.equals(((b) obj).f6212a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f6212a.hashCode();
        }

        public final String toString() {
            StringBuilder d7 = h.d("StringHeaderFactory{value='");
            d7.append(this.f6212a);
            d7.append('\'');
            d7.append('}');
            return d7.toString();
        }
    }

    public i(Map<String, List<h>> map) {
        this.f6208b = Collections.unmodifiableMap(map);
    }

    @Override // v2.g
    public final Map<String, String> a() {
        if (this.f6209c == null) {
            synchronized (this) {
                if (this.f6209c == null) {
                    this.f6209c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f6209c;
    }

    public final HashMap b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<h>> entry : this.f6208b.entrySet()) {
            List<h> value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = value.size();
            for (int i7 = 0; i7 < size; i7++) {
                String a7 = value.get(i7).a();
                if (!TextUtils.isEmpty(a7)) {
                    sb.append(a7);
                    if (i7 != value.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                hashMap.put(entry.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f6208b.equals(((i) obj).f6208b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6208b.hashCode();
    }

    public final String toString() {
        StringBuilder d7 = h.d("LazyHeaders{headers=");
        d7.append(this.f6208b);
        d7.append('}');
        return d7.toString();
    }
}
