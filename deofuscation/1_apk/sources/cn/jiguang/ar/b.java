package cn.jiguang.ar;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import cn.jiguang.be.d;
import cn.jiguang.f.g;
import cn.jiguang.internal.JConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class b {
    private static String a = ".jpush";
    private static String b;
    private static String c;
    private static final SimpleDateFormat d;
    private static ArrayList<String> e;
    private static boolean f;
    private static boolean g;

    static {
        StringBuilder sb = new StringBuilder();
        j.l.c.e0.a.a.b.a();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(a);
        sb.append(str);
        b = sb.toString();
        c = b + a;
        d = new SimpleDateFormat("MM.dd_HH:mm:ss_SSS", Locale.ENGLISH);
        e = new ArrayList<>();
        f = false;
        g = false;
    }

    private static void a(String str) {
        if (g) {
            return;
        }
        try {
            e.add(str);
            if (e.size() == 500) {
                ArrayList<String> arrayList = e;
                e = new ArrayList<>();
                boolean c2 = cn.jiguang.f.a.c(JConstants.mApplicationContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                f = c2;
                if (c2) {
                    c.a("Logger", "have writable external storage, write log file");
                    a(arrayList);
                } else {
                    c.a("Logger", "no writable external storage");
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            e = new ArrayList<>();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, Throwable th) {
        str2 = (str2 == null || str2.trim().equals("")) ? "Logger" : "Logger";
        if (str3 == null) {
            return;
        }
        try {
            String format = d.format(new Date());
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str3), 256);
            String a2 = g.a("[" + str2 + "]", 24);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    a(((Object) format) + " " + g.a(str, 5) + " " + a2 + " " + readLine);
                } catch (IOException e2) {
                    c.i("Logger", e2.getMessage());
                }
            }
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                a(((Object) format) + " " + str + stringWriter2);
            }
        } catch (Throwable th2) {
            Log.w("Logger", "logtofile call failed:" + th2.getMessage());
        }
    }

    private static void a(final ArrayList<String> arrayList) {
        try {
            Context context = JConstants.mApplicationContext;
            if (context == null || cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                d.a("NORMAL_TASK", new cn.jiguang.be.b("LogToFile#saveLogs") { // from class: cn.jiguang.ar.b.1
                    @Override // cn.jiguang.be.b
                    public void a() {
                        BufferedWriter bufferedWriter = null;
                        try {
                            try {
                                String str = b.c + "-" + cn.jiguang.f.b.b() + "_1.txt";
                                File file = new File(str);
                                file.getParentFile().mkdirs();
                                int i = 2;
                                while (true) {
                                    if (!file.exists()) {
                                        break;
                                    }
                                    str = b.c + "-" + cn.jiguang.f.b.b() + "_" + i + ".txt";
                                    file = new File(str);
                                    if (i > 10) {
                                        c.g("Logger", "Unexpected error here, so many existed error file.");
                                        break;
                                    }
                                    i++;
                                }
                                c.a("Logger", "Write log file: " + file.getName());
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str));
                                try {
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        bufferedWriter2.write(((String) it.next()) + "\n");
                                    }
                                    b.e.clear();
                                    bufferedWriter2.close();
                                } catch (Throwable th) {
                                    bufferedWriter = bufferedWriter2;
                                    th = th;
                                    try {
                                        c.a("Logger", "write logs to file error", th);
                                        b.e.clear();
                                        if (bufferedWriter != null) {
                                            bufferedWriter.close();
                                        }
                                        b.d();
                                    } catch (Throwable th2) {
                                        try {
                                            b.e.clear();
                                            if (bufferedWriter != null) {
                                                bufferedWriter.close();
                                            }
                                        } catch (Throwable th3) {
                                            c.c("Logger", "close file stream error", th3);
                                        }
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            c.c("Logger", "close file stream error", th5);
                        }
                        b.d();
                    }
                });
            } else {
                c.g("Logger", "WRITE_EXTERNAL_STORAGE not get");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void d() {
        File[] listFiles;
        try {
            File file = new File(b);
            if (file.exists()) {
                int length = a.length() + 1;
                int length2 = cn.jiguang.f.b.a.length() + length;
                if (file.listFiles() != null) {
                    for (File file2 : file.listFiles()) {
                        if (cn.jiguang.f.b.a(cn.jiguang.f.b.b(file2.getName().substring(length, length2)), 2)) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            c.i("Logger", th.getMessage());
        }
    }
}
