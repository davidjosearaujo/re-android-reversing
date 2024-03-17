package cn.jiguang.common.app.helper;

import java.io.File;
import java.util.regex.Pattern;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AndroidAppProcess extends AndroidProcess {
    private static final boolean c = new File("/dev/cpuctl/tasks").exists();
    private static final Pattern d = Pattern.compile("^([A-Za-z]{1}[A-Za-z0-9_]*[\\.|:])*[A-Za-z][A-Za-z0-9_]*$");
}
