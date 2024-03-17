package com.facebook.internal.logging.dumpsys;

import android.content.res.Resources;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.security.CertificateUtil;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import r.e.a.d;
import r.e.a.e;

/* compiled from: ResourcesUtil.kt */
@b0(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/ResourcesUtil;", "", "()V", "getFallbackIdString", "", "resourceId", "", "getIdString", "r", "Landroid/content/res/Resources;", "getIdStringQuietly", "getResourcePackageId", "id", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ResourcesUtil {
    @d
    public static final ResourcesUtil INSTANCE = new ResourcesUtil();

    private ResourcesUtil() {
    }

    private final String getFallbackIdString(int i) {
        return "#" + Integer.toHexString(i);
    }

    @d
    @k
    public static final String getIdString(@e Resources resources, int i) throws Resources.NotFoundException {
        String str;
        if (resources == null) {
            return INSTANCE.getFallbackIdString(i);
        }
        String str2 = "";
        if (INSTANCE.getResourcePackageId(i) != 127) {
            str2 = resources.getResourcePackageName(i);
            f0.o(str2, "r.getResourcePackageName(resourceId)");
            str = CertificateUtil.DELIMITER;
        } else {
            str = "";
        }
        String resourceTypeName = resources.getResourceTypeName(i);
        String resourceEntryName = resources.getResourceEntryName(i);
        StringBuilder sb = new StringBuilder(str2.length() + 1 + str.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb.append("@");
        sb.append(str2);
        sb.append(str);
        sb.append(resourceTypeName);
        sb.append("/");
        sb.append(resourceEntryName);
        String sb2 = sb.toString();
        f0.o(sb2, "sb.toString()");
        return sb2;
    }

    @d
    @k
    public static final String getIdStringQuietly(@e Resources resources, int i) {
        try {
            return getIdString(resources, i);
        } catch (Resources.NotFoundException unused) {
            return INSTANCE.getFallbackIdString(i);
        }
    }

    private final int getResourcePackageId(int i) {
        return (i >>> 24) & JfifUtil.MARKER_FIRST_BYTE;
    }
}
