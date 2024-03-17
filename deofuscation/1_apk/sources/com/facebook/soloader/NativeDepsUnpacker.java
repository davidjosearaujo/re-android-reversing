package com.facebook.soloader;

import android.content.Context;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class NativeDepsUnpacker {
    private static final String APK_IDENTIFIER_FILE_NAME = "apk_id";
    private static final String LOCK_FILE_NAME = "lock";
    private static final String NATIVE_DEPS_DIR_NAME = "native_deps";
    private static final String NATIVE_DEPS_FILE_APK_PATH = "assets/native_deps.txt";
    private static final String NATIVE_DEPS_FILE_NAME = "deps";
    private static final byte STATE_CLEAN = 1;
    private static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "state";

    private NativeDepsUnpacker() {
    }

    private static boolean apkChanged(Context context, File file) throws IOException {
        byte[] existingApkIdentifier = getExistingApkIdentifier(context, file);
        byte[] apkIdentifier = getApkIdentifier(context);
        if (existingApkIdentifier == null || apkIdentifier == null || existingApkIdentifier.length != apkIdentifier.length) {
            return true;
        }
        return !Arrays.equals(existingApkIdentifier, apkIdentifier);
    }

    private static boolean ensureDirExists(File file) {
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return file.isDirectory();
    }

    public static void ensureNativeDepsAvailable(Context context) throws IOException {
        File nativeDepsDir = getNativeDepsDir(context);
        if (ensureDirExists(nativeDepsDir)) {
            FileLocker orCreateLockOnDir = SysUtil.getOrCreateLockOnDir(nativeDepsDir, new File(nativeDepsDir, LOCK_FILE_NAME), true);
            try {
                byte readState = readState(nativeDepsDir);
                if (readState == 1 && apkChanged(context, nativeDepsDir)) {
                    readState = 0;
                }
                if (readState == 1) {
                    if (orCreateLockOnDir != null) {
                        orCreateLockOnDir.close();
                        return;
                    }
                    return;
                }
                writeState(nativeDepsDir, (byte) 0);
                extractNativeDeps(context);
                writeApkIdentifier(context, nativeDepsDir);
                SysUtil.fsyncRecursive(nativeDepsDir);
                writeState(nativeDepsDir, (byte) 1);
                if (orCreateLockOnDir != null) {
                    orCreateLockOnDir.close();
                }
            } catch (Throwable th) {
                if (orCreateLockOnDir != null) {
                    try {
                        orCreateLockOnDir.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private static void extractNativeDeps(Context context) throws IOException {
        byte[] readNativeDepsFromApk = readNativeDepsFromApk(context);
        byte[] apkIdentifier = getApkIdentifier(context);
        int length = readNativeDepsFromApk.length;
        RandomAccessFile randomAccessFile = new RandomAccessFile(getNativeDepsFilePath(context), "rw");
        try {
            randomAccessFile.write(apkIdentifier);
            randomAccessFile.writeInt(length);
            randomAccessFile.write(readNativeDepsFromApk);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] getApkIdentifier(Context context) throws IOException {
        return SysUtil.makeApkDepBlock(new File(context.getApplicationInfo().sourceDir), context);
    }

    @Nullable
    private static byte[] getExistingApkIdentifier(Context context, File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, APK_IDENTIFIER_FILE_NAME), "rw");
        try {
            int length = (int) randomAccessFile.length();
            byte[] bArr = new byte[length];
            if (randomAccessFile.read(bArr) != length) {
                randomAccessFile.close();
                return null;
            }
            randomAccessFile.close();
            return bArr;
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static File getNativeDepsDir(Context context) {
        return new File(context.getApplicationInfo().dataDir, NATIVE_DEPS_DIR_NAME);
    }

    public static File getNativeDepsFilePath(Context context) {
        return new File(getNativeDepsDir(context), NATIVE_DEPS_FILE_NAME);
    }

    public static byte[] readAllBytes(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new EOFException("EOF found unexpectedly");
            }
            i2 += read;
            if (i2 > i) {
                throw new IllegalStateException("Read more bytes than expected");
            }
        }
        return bArr;
    }

    public static byte[] readNativeDepsFromApk(Context context) throws IOException {
        ZipFile zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir));
        try {
            ZipEntry entry = zipFile.getEntry(NATIVE_DEPS_FILE_APK_PATH);
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                if (inputStream != null) {
                    byte[] readAllBytes = readAllBytes(inputStream, (int) entry.getSize());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    zipFile.close();
                    return readAllBytes;
                }
                throw new FileNotFoundException("Failed to read native_deps file from APK");
            }
            throw new FileNotFoundException("Could not find native_deps file in APK");
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] readNativeDepsFromDisk(Context context) throws IOException {
        File nativeDepsFilePath = getNativeDepsFilePath(context);
        FileInputStream fileInputStream = new FileInputStream(nativeDepsFilePath);
        try {
            byte[] readAllBytes = readAllBytes(fileInputStream, (int) nativeDepsFilePath.length());
            fileInputStream.close();
            return readAllBytes;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte readState(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, "state"), "rw");
        byte b = 0;
        try {
            byte readByte = randomAccessFile.readByte();
            if (readByte == 1) {
                b = readByte;
            }
        } catch (EOFException unused) {
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        randomAccessFile.close();
        return b;
    }

    private static void writeApkIdentifier(Context context, File file) throws IOException {
        File file2 = new File(file, APK_IDENTIFIER_FILE_NAME);
        byte[] apkIdentifier = getApkIdentifier(context);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            randomAccessFile.write(apkIdentifier);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void writeState(File file, byte b) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(file, "state"), "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
