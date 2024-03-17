package cn.com.custommma.mobile.tracking.util.klog;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FileLog {
    private static final String FILE_FORMAT = ".log";
    private static final String FILE_PREFIX = "KLog_";

    private static String getFileName() {
        Random random = new Random();
        return FILE_PREFIX + Long.toString(System.currentTimeMillis() + random.nextInt(10000)).substring(4) + FILE_FORMAT;
    }

    public static void printFile(String str, File file, String str2, String str3, String str4) {
        if (str2 == null) {
            str2 = getFileName();
        }
        if (save(file, str2, str4)) {
            Log.d(str, str3 + " save log success ! location is >>>" + file.getAbsolutePath() + "/" + str2);
            return;
        }
        Log.e(str, str3 + "save log fails !");
    }

    private static boolean save(File file, String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return false;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
