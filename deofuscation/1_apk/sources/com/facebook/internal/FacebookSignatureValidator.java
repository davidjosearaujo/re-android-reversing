package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.HashSet;
import kotlin.collections.CollectionsKt___CollectionsKt;
import n.b0;
import n.b2.d1;
import n.l2.k;
import n.l2.v.f0;
import n.u2.u;
import r.e.a.d;

/* compiled from: FacebookSignatureValidator.kt */
@b0(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/FacebookSignatureValidator;", "", "()V", "FBF_HASH", "", "FBI_HASH", "FBL_HASH", "FBR2_HASH", "FBR_HASH", "IGR_HASH", "MSR_HASH", "validAppSignatureHashes", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "validateSignature", "", "context", "Landroid/content/Context;", CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class FacebookSignatureValidator {
    @d
    public static final FacebookSignatureValidator INSTANCE = new FacebookSignatureValidator();
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    private static final String FBR2_HASH = "cc2751449a350f668590264ed76692694a80308a";
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    private static final String FBL_HASH = "df6b721c8b4d3b6eb44c861d4415007e5a35fc95";
    private static final String MSR_HASH = "9b8f518b086098de3d77736f9458a3d2f6f95a37";
    private static final String FBF_HASH = "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3";
    private static final String IGR_HASH = "c56fb7d591ba6704df047fd98f535372fea00211";
    private static final HashSet<String> validAppSignatureHashes = d1.m(new String[]{FBR_HASH, FBR2_HASH, FBI_HASH, FBL_HASH, MSR_HASH, FBF_HASH, IGR_HASH});

    private FacebookSignatureValidator() {
    }

    @k
    public static final boolean validateSignature(@d Context context, @d String str) {
        f0.p(context, "context");
        f0.p(str, CommonConstant.ReqAccessTokenParam.PACKAGE_NAME);
        String str2 = Build.BRAND;
        int i = context.getApplicationInfo().flags;
        f0.o(str2, "brand");
        if (!u.u2(str2, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE, false, 2, (Object) null) || (i & 2) == 0) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null) {
                    f0.o(signatureArr, "packageInfo.signatures");
                    if (signatureArr.length == 0) {
                        return false;
                    }
                    Signature[] signatureArr2 = packageInfo.signatures;
                    f0.o(signatureArr2, "packageInfo.signatures");
                    for (Signature signature : signatureArr2) {
                        HashSet<String> hashSet = validAppSignatureHashes;
                        byte[] byteArray = signature.toByteArray();
                        f0.o(byteArray, "it.toByteArray()");
                        if (!CollectionsKt___CollectionsKt.J1(hashSet, Utility.sha1hash(byteArray))) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return true;
    }
}
