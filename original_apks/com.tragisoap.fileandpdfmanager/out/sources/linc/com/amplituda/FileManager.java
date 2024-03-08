package linc.com.amplituda;

import android.content.Context;
import android.content.res.Resources;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import linc.com.amplituda.exceptions.io.AmplitudaIOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class FileManager {
    public static final String AMPLITUDA_INTERNAL_CACHE = "internal-ampl-cache";
    private final String cache;
    private final Resources resources;

    public FileManager(Context context) {
        this.resources = context.getResources();
        this.cache = context.getExternalCacheDir().getPath() + File.separator;
    }

    private synchronized byte[] getByteArrayFromInputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[65535];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private synchronized long getUrlContentLength(URLConnection uRLConnection) {
        long j7;
        j7 = -1;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setRequestMethod("HEAD");
            String headerField = httpURLConnection.getHeaderField("content-length");
            Long valueOf = headerField == null ? null : Long.valueOf(Long.parseLong(headerField));
            if (valueOf != null && valueOf.longValue() >= 0) {
                j7 = valueOf.longValue();
            }
        } catch (Exception unused) {
            return -1;
        }
        return j7;
    }

    private synchronized void streamToFile(InputStream inputStream, File file, int i7, long j7, AmplitudaProgressListener amplitudaProgressListener) {
        int i8;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[i7];
            int i9 = 0;
            int i10 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                i9 += read;
                if (!(amplitudaProgressListener == null || j7 <= 0 || (i8 = (int) (((double) (((float) i9) / ((float) j7))) * 100.0d)) == i10)) {
                    amplitudaProgressListener.onProgressInternal(i8);
                    i10 = i8;
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException | NullPointerException unused2) {
            }
            throw th;
        }
        try {
            inputStream.close();
        } catch (IOException | NullPointerException unused3) {
        }
    }

    public synchronized void clearAllCacheFiles() {
        clearCache(AMPLITUDA_INTERNAL_CACHE);
    }

    public synchronized void clearCache(final String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                File[] listFiles = new File(this.cache).listFiles(new FileFilter() { // from class: linc.com.amplituda.FileManager.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        return file.isFile() && file.getName().contains(str);
                    }
                });
                if (!(listFiles == null || listFiles.length == 0)) {
                    for (File file : listFiles) {
                        file.delete();
                    }
                }
            }
        }
    }

    public synchronized void deleteFile(File file) {
        if (file != null) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public synchronized File getByteArrayFile(byte[] bArr, AmplitudaProgressListener amplitudaProgressListener) {
        File file;
        file = new File(this.cache, String.valueOf(Arrays.hashCode(bArr)));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (amplitudaProgressListener != null) {
                try {
                    amplitudaProgressListener.onProgressInternal(0);
                } finally {
                    try {
                        throw th;
                    } catch (Throwable th) {
                    }
                }
            }
            fileOutputStream.write(bArr);
            if (amplitudaProgressListener != null) {
                amplitudaProgressListener.onProgressInternal(100);
            }
            fileOutputStream.close();
        } catch (IOException unused) {
            return null;
        }
        return file;
    }

    public synchronized File getCacheFile(String str, String str2) {
        File file;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("internal-ampl-cache_");
            if (!str2.isEmpty()) {
                str = str2;
            }
            sb.append(str);
            sb.append(".txt");
            file = new File(this.cache, sb.toString());
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new AmplitudaIOException(e.getMessage(), 1);
        }
        return file;
    }

    public synchronized File getInputStreamFile(InputStream inputStream, AmplitudaProgressListener amplitudaProgressListener) {
        try {
        } catch (IOException unused) {
            return null;
        }
        return getByteArrayFile(getByteArrayFromInputStream(inputStream), amplitudaProgressListener);
    }

    public synchronized String getInputStreamHashString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[65535];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
        } catch (IOException unused) {
            return null;
        }
        return String.valueOf(Arrays.hashCode(byteArrayOutputStream.toByteArray()));
    }

    public synchronized File getRawFile(int i7, AmplitudaProgressListener amplitudaProgressListener) {
        File file;
        file = new File(this.cache, String.valueOf(i7));
        try {
            InputStream openRawResource = this.resources.openRawResource(i7);
            streamToFile(openRawResource, file, 4096, (long) openRawResource.available(), amplitudaProgressListener);
        } catch (Resources.NotFoundException | IOException unused) {
            return null;
        }
        return file;
    }

    public synchronized File getUrlFile(String str, AmplitudaProgressListener amplitudaProgressListener) {
        File file;
        file = new File(this.cache, String.valueOf(str.hashCode()));
        try {
            URL url = new URL(str);
            URLConnection openConnection = url.openConnection();
            openConnection.connect();
            streamToFile(new BufferedInputStream(url.openStream()), file, 1024, getUrlContentLength(openConnection), amplitudaProgressListener);
        } catch (IOException unused) {
            return null;
        }
        return file;
    }

    public synchronized String readFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(System.lineSeparator());
                } else {
                    String trim = sb.toString().trim();
                    bufferedReader.close();
                    return trim;
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
