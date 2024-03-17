package com.facebook.referrals;

import java.util.Collections;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ReferralResult {
    private final List<String> referralCodes;

    public ReferralResult(List<String> list) {
        this.referralCodes = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.referralCodes.equals(((ReferralResult) obj).referralCodes);
    }

    public List<String> getReferralCodes() {
        return Collections.unmodifiableList(this.referralCodes);
    }

    public int hashCode() {
        return this.referralCodes.hashCode();
    }
}
