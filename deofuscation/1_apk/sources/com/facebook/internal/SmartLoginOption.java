package com.facebook.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.EnumSet;
import java.util.Iterator;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.u;
import r.e.a.d;

/* compiled from: SmartLoginOption.kt */
@b0(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/SmartLoginOption;", "", SDKConstants.PARAM_VALUE, "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "None", "Enabled", "RequireConfirm", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum SmartLoginOption {
    None(0),
    Enabled(1),
    RequireConfirm(2);
    
    private static final EnumSet<SmartLoginOption> ALL;
    @d
    public static final Companion Companion = new Companion(null);
    private final long value;

    /* compiled from: SmartLoginOption.kt */
    @b0(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/internal/SmartLoginOption$Companion;", "", "()V", "ALL", "Ljava/util/EnumSet;", "Lcom/facebook/internal/SmartLoginOption;", "parseOptions", "bitmask", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Companion {
        private Companion() {
        }

        @d
        @k
        public final EnumSet<SmartLoginOption> parseOptions(long j) {
            EnumSet<SmartLoginOption> noneOf = EnumSet.noneOf(SmartLoginOption.class);
            Iterator it = SmartLoginOption.ALL.iterator();
            while (it.hasNext()) {
                SmartLoginOption smartLoginOption = (SmartLoginOption) it.next();
                if ((smartLoginOption.getValue() & j) != 0) {
                    noneOf.add(smartLoginOption);
                }
            }
            f0.o(noneOf, "result");
            return noneOf;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    static {
        EnumSet<SmartLoginOption> allOf = EnumSet.allOf(SmartLoginOption.class);
        f0.o(allOf, "EnumSet.allOf(SmartLoginOption::class.java)");
        ALL = allOf;
    }

    SmartLoginOption(long j) {
        this.value = j;
    }

    @d
    @k
    public static final EnumSet<SmartLoginOption> parseOptions(long j) {
        return Companion.parseOptions(j);
    }

    public final long getValue() {
        return this.value;
    }
}
